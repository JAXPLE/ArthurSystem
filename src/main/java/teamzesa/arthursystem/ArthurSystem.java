package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.command.TotemStacking;
import teamzesa.manager.*;


public final class ArthurSystem extends JavaPlugin implements Listener {

    private PluginManager pm;
    private AttackSpeedManager attackSpeedManager;
    private HealthManager healthManager;

    public ArthurSystem() {
        this.pm = getServer().getPluginManager();
        this.attackSpeedManager = AttackSpeedManager.getInstance();
        this.healthManager = HealthManager.getInstance();
    }

    @Override
    public void onEnable() {
        this.pm.registerEvents(attackSpeedManager, this);
        this.pm.registerEvents(healthManager, this);
        this.pm.registerEvents(new RaidManager(), this);
        this.pm.registerEvents(new NetherManager(), this);
//        this.pm.registerEvents(UserManager.getInstance(), this);
//        this.pm.registerEvents(new PvpManager(), this);

        Bukkit.getPluginCommand("totem").setExecutor(new TotemStacking());
    }
}
