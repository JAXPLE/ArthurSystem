package teamzesa.manager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NetherManager implements Listener {

    @EventHandler
    public void onPlayerCode(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        World world = p.getWorld();

        if (world.getEnvironment() == World.Environment.NETHER &&
            loc.getBlockY() > 125) {
            p.setHealth(0);
            p.sendMessage("허용되지 않는 좌표 입니다.");
        }
    }
}
