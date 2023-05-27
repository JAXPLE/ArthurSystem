package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.command.TotemStacking;
import teamzesa.manager.NetherManager;
import teamzesa.manager.PvpManager;
import teamzesa.manager.RaidManager;


public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PvpManager(),this);
        this.getServer().getPluginManager().registerEvents(new RaidManager(),this);
        this.getServer().getPluginManager().registerEvents(new NetherManager(),this);

        Bukkit.getPluginCommand("totem").setExecutor(new TotemStacking());

//        ItemManager.customItem(this);
    }

}
