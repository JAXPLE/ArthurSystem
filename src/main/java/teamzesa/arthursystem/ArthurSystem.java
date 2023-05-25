package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.command.StreamTotemStacking;
import teamzesa.command.TotemStacking;
import teamzesa.manager.PvpManager;


public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PvpManager(),this);

        Bukkit.getPluginCommand("totem").setExecutor(new TotemStacking());

//        ItemManager.customItem(this);
    }

}
