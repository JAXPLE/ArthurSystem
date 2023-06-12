package teamzesa.manager;

import com.google.gson.Gson;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import teamzesa.arthursystem.ArthurSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.UTFDataFormatException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class UserManager implements Listener {
    private static UserManager instance = new UserManager();
    private static final String FILE = "playerHealthData.yml";
    private Map<UUID, Double> userInfo;
    private File file;

    private UserManager() {
        userInfo = new HashMap<>();
    }

    public static UserManager getInstance() {
        if (instance == null)
            return new UserManager();
        return instance;
    }

    public void updatePlayerHealth(UUID playerUUID, double healthScale) {
        userInfo.replace(playerUUID, healthScale);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = e.getPlayer().getUniqueId();

        if (userInfo.get(uuid.toString()) == null)
            userInfo.put(uuid,20.0);

        p.setHealthScale(userInfo.get(p.getUniqueId()));
    }

    public void savePlayerData() throws Exception{
        Gson gson = new Gson();
        String data = gson.toJson(userInfo);
        file = new File(data);
        FileWriter fileWriter = new FileWriter(file,);
    }
}
