package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.command.TotemStacking;
import teamzesa.manager.*;


public final class ArthurSystem extends JavaPlugin implements Listener {

    private PluginManager pm;

    public ArthurSystem() {
        this.pm = getServer().getPluginManager();
    }

    @Override
    public void onEnable() {
        this.pm.registerEvents(AttackSpeedManager.getInstance(), this);
        this.pm.registerEvents(UserManager.getInstance(), this);
        this.pm.registerEvents(new PvpManager(), this);
        this.pm.registerEvents(new RaidManager(), this);
        this.pm.registerEvents(new NetherManager(), this);

        Bukkit.getPluginCommand("totem").setExecutor(new TotemStacking());
    }

}
