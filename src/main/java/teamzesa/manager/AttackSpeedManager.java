package teamzesa.manager;

import com.sun.tools.javac.Main;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class AttackSpeedManager implements Listener {
    private static AttackSpeedManager attackSpeedManager = new AttackSpeedManager();
    private Main plugin;

    private AttackSpeedManager() {}

    public static AttackSpeedManager getInstance() {
        if (attackSpeedManager == null) {
            attackSpeedManager = new AttackSpeedManager();
            return attackSpeedManager;
        }
        return attackSpeedManager;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
//        What to set the attack speed to. Default for 1.9 is 4, at least 40 is needed for no cooldown.
        Objects.requireNonNull(e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(40);
    }
}
