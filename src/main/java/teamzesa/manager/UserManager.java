package teamzesa.manager;

import org.bukkit.event.Listener;
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

    public void updatePlayerHealth(UUID playerUUID, double health) {
        userInfo.put(playerUUID, health);
    }

}
