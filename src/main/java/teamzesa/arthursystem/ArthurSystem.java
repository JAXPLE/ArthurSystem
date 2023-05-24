package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.manager.ItemManager;
import teamzesa.manager.PvpManager;


public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PvpManager(),this);
        ItemManager.customItem(this);
    }

}
