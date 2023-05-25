package teamzesa.arthursystem;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.manager.CommandManager;
import teamzesa.manager.ItemManager;
import teamzesa.manager.PvpManager;


public final class ArthurSystem extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PvpManager(),this);

        ItemManager.customItem(this);

        this.getCommand("test").setExecutor(new CommandManager());
    }

}
