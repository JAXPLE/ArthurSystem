package teamzesa.manager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidTriggerEvent;

public class RaidManager implements Listener {
    private Location loc;
    private double x;
    private double z;

    @EventHandler
    public void raidAnnouncer(RaidTriggerEvent e) {
        this.loc = e.getRaid().getLocation();
        String activeWorld = worldName(e.getWorld().getName());

        this.x = loc.getX();
        this.z = loc.getZ();

        System.out.println(e.getRaid().getBadOmenLevel());

        Bukkit.broadcastMessage(
                String.format(
                        ChatColor.RED + "%s 월드의 X : %1.0f Y : %1.0f 에서 레이드를 시작합니다.",
                        activeWorld, x, z
                )
        );
    }

    public String worldName(String worldName) {
        switch (worldName) {
            case "world" :
                return "야생";
            case "world_nether" :
                return "지옥";
            case "world_the_end" :
                return "엔더";
        }
        return null;
    }
}
