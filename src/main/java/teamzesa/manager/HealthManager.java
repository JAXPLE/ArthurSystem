package teamzesa.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class HealthManager implements Listener {

    private final int MIN_HEALTH_RANGE = 10;
    private static HealthManager instance;
    private HealthManager() {}

    public static HealthManager getInstance() {
        if (instance == null)
            instance = new HealthManager();
        return instance;
    }

    @EventHandler
    public void healthSet(PlayerLevelChangeEvent e) {
        Player player = e.getPlayer();
        int exp = player.getLevel();

        player.sendMessage(String.valueOf(e.getNewLevel()));
        player.sendMessage(String.valueOf(e.getOldLevel()));

        if (exp >= MIN_HEALTH_RANGE)
            player.setHealthScale(
                    player.getHealthScale() + exp/MIN_HEALTH_RANGE
            );
    }
}
