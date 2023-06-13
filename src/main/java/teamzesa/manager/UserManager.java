package teamzesa.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.arthursystem.ArthurSystem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager implements Listener {
    private static UserManager instance;
    private Map<UUID, Double> userInfo;
    private FileConfiguration config;
    private File configFile;

//    private UserManager() {
////        userInfo = new HashMap<>();
//    }

    private UserManager() {
        userInfo = new HashMap<>();
        config = new YamlConfiguration();
    }

    public static UserManager getInstance() {
        if (instance == null)
            return new UserManager();
        return instance;
    }

    public void updatePlayerHealth(UUID playerUUID, double healthScale) {
        userInfo.replace(playerUUID, healthScale);
    }

    public void saveUserHealthInfo() {
        for (UUID playerUUID : userInfo.keySet()) {
            config.set("UUID:" + playerUUID.toString(), 0);
            config.set("HealthScale:" + String.valueOf(userInfo.get(playerUUID)), 0);
        }
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setConfig(FileConfiguration config) {
        this.config = config;
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = e.getPlayer().getUniqueId();

        if (userInfo.get(uuid.toString()) == null)
            userInfo.put(uuid,20.0);

        p.setHealthScale(userInfo.get(p.getUniqueId()));
    }

    public Map<UUID,Double> getUserInfo() {
        return userInfo;
    }
}
