package teamzesa.manager;

import com.sun.tools.javac.Main;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class AttackSpeedManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
//        What to set the attack speed to. Default for 1.9 is 4, at least 40 is needed for no cooldown.
        Objects.requireNonNull(e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(40);
    }

    @EventHandler
    public void testSpeed(EntityDamageByEntityEvent e) {
//        Boolean[] hitCheck = new Boolean[3];
//        hitCheck[0] = e.getEntity() instanceof LivingEntity; //damaging Player
//        hitCheck[1] = e.getDamager() instanceof Player; //hitPlayer
//        hitCheck[2] = e.getDamager() instanceof LivingEntity; //liveCheck
//
//        for (Boolean check : hitCheck)
//            if (!check)
//                return;

        LivingEntity target = (LivingEntity) e.getEntity();
        e.getDamager().sendMessage("test");
        target.setMaximumNoDamageTicks(0);
    }
}
