package teamzesa.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager implements Listener {
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

    public void updatePlayerHealth(UUID playerUUID, double healthScale) {
        userInfo.put(playerUUID, healthScale);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setHealthScale(userInfo.get(p.getUniqueId()));
    }
}
