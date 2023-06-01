package teamzesa.manager;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager extends JavaPlugin implements Listener {
    private static UserManager instance = new UserManager();
    private Map<UUID, Double> userInfo;

    private UserManager() {
        userInfo = new HashMap<>();
    }

    public static UserManager getInstance() {
        if (instance == null)
            return new UserManager();
        return instance;
    }

    public void updatePlayerHealth(UUID playerUUID, double health) {
        userInfo.put(playerUUID, health);
    }

    @EventHandler(priority = EventPriority.HIGH)
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();

        if (dataContainer.has(makeKey("lastHealth"), PersistentDataType.DOUBLE)) {
            double lastHealth = dataContainer.get(makeKey("lastHealth"), PersistentDataType.DOUBLE);
            player.setHealthScale(lastHealth);
            userInfo.put(uuid, lastHealth);
        } else {
            double healthScale = player.getHealthScale();
            userInfo.put(uuid, healthScale);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    private void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        double healthScale = player.getHealthScale();
        userInfo.put(uuid, healthScale);

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        dataContainer.set(makeKey("lastHealth"), PersistentDataType.DOUBLE, healthScale);
    }

    private NamespacedKey makeKey(String key) {
        return new NamespacedKey(this, key);
    }
}
