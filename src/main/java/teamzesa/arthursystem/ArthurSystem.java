package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.manager.CommandManager;
import teamzesa.manager.ItemManager;
import teamzesa.manager.PvpManager;


public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PvpManager(),this);

        Bukkit.getPluginCommand("test").setExecutor(new CommandManager());
//        ItemManager.customItem(this);
    }

}
