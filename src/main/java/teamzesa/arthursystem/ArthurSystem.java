package teamzesa.arthursystem;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.pvp.PvpSystem;

public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PvpSystem(),this);
    }

}
