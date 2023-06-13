package teamzesa.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class HealthManager implements Listener {
    private final int MIN_HEALTH_RANGE = 10;
    private static HealthManager instance;
    private HealthManager() {
    }

    public static HealthManager getInstance() {
        return instance;
    }

    @EventHandler
    public void healthSet(PlayerExpChangeEvent e) {
        Player player = e.getPlayer();
        int exp = player.getLevel();

        System.out.println(player.getName());


        if (exp >= MIN_HEALTH_RANGE)
            player.setHealthScale(
                    player.getHealthScale() + exp/MIN_HEALTH_RANGE
            );
    }
}
