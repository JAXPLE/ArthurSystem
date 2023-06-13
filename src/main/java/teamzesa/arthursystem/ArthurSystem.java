package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.command.TotemStacking;
import teamzesa.manager.*;

import java.io.File;

public final class ArthurSystem extends JavaPlugin implements Listener {

    private PluginManager pm;
    private AttackSpeedManager attackSpeedManager;
    private HealthManager healthManager;

    public ArthurSystem() {
        this.pm = getServer().getPluginManager();
        this.attackSpeedManager = new AttackSpeedManager();
        this.healthManager = HealthManager.getInstance();
//        this.healthManager = new HealthManager();
//        this.userManager = UserManager.getInstance();
    }

    @Override
    public void onEnable() {
        this.pm.registerEvents(this, this);
//        this.pm.registerEvents(healthManager, this);
//        this.pm.registerEvents(userManager, this);
        this.pm.registerEvents(new AttackSpeedManager(), this);
        this.pm.registerEvents(new RaidManager(), this);
        this.pm.registerEvents(new NetherManager(), this);
//        this.pm.registerEvents(new PvpManager(), this);

        Bukkit.getPluginCommand("totem").setExecutor(new TotemStacking());
    }

    @EventHandler
    public void test1(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();
        p.sendRawMessage(e.getEventName());
    }

    @EventHandler
    public void test2(PlayerExpChangeEvent e) {
        Player p = e.getPlayer();
        p.sendRawMessage(e.getEventName());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        System.out.println(p.getName());
    }
}
