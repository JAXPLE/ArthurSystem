package teamzesa.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager extends JavaPlugin implements Listener {
    private static UserManager instance = new UserManager();
    private static Map<UUID, Double> userInfo;
    private FileConfiguration fileConfiguration;
    private File file;


    private UserManager() {
        userInfo = new HashMap<>();
    }

    @EventHandler(priority = EventPriority.HIGH)
    private void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        Double healthScale = e.getPlayer().getHealthScale();

        if (userInfo.containsKey(uuid))
            return;

        userInfo.put(uuid,healthScale);
    }

    private void loadPlayerInfo(JavaPlugin javaPlugin) {

    }

    public static UserManager getInstance() {
        if (instance == null)
            return new UserManager();
        return instance;
    }

    public void updatePlayerHealth(UUID playerUUID, double health) {
        if (userInfo.containsKey(playerUUID)) {
            userInfo.put(playerUUID, health);
        }
    }
}
