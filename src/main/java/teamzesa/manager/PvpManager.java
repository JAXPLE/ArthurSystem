package teamzesa.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PvpManager implements Listener {
    private ModerManager moderManager;

    public PvpManager() {
        moderManager = ModerManager.getInstance();
    }

    /*@EventHandler
    public void reset(BlockBreakEvent e) { //정상체력 초기화
        if (moderManager.CheckingUUID(e.getPlayer().getUniqueId()))
            e.getPlayer().setHealthScale(20.0);
    }

    @EventHandler
    public void setFull(BlockPlaceEvent e) { //최대체력 초기화
        if (moderManager.CheckingUUID(e.getPlayer().getUniqueId()))
            e.getPlayer().setHealthScale(60.0);
    }*/

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player killed = e.getEntity();
        Player killer = killed.getKiller();

        if (killer == null)
            return;

        if (killed.getHealthScale() <= 2.0)
            return;

        if (killer.getHealthScale() >= 60.0)
            return;

        if (killed != killer) {
            talking(killed,killer);
            killed.setHealthScale(killed.getHealthScale() - 2.0);
            killer.setHealthScale(killer.getHealthScale() + 2.0);
        }
    }

    public void talking(Player killed, Player killer) {
        killed.sendRawMessage(killer.getName() + "님이 체력을 약탈했습니다.");
        killer.sendRawMessage(killed.getName() + "님의 체력을 약탈했습니다.");
    }
}
