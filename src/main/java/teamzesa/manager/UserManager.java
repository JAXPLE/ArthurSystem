package teamzesa.manager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager extends JavaPlugin implements Listener {
    private static UserManager instance = new UserManager();
    private static Map<UUID, Double> userInfo;
    private File file;
    private Yaml yaml;


    private UserManager() {
        userInfo = new HashMap<>();
        loadPlayerInfo(this);
    }

    @EventHandler(priority = EventPriority.HIGH)
    private void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        Double healthScale = e.getPlayer().getHealthScale();

        if (userInfo.containsKey(uuid))
            return;

        userInfo.put(uuid,healthScale);
    }

    public void loadPlayerInfo(JavaPlugin javaPlugin) {
        File file = new File(javaPlugin.getDataFolder(), "playerHealthData.yaml");

        if (!file.exists())
            return;

        yaml = new Yaml();

        try (FileReader reader = new FileReader(file)) {
            Map<String, Double> dataMap = yaml.load(reader);

            // Convert the keys from Strings to UUIDs
            userInfo = new HashMap<>();
            for (Map.Entry<String, Double> entry : dataMap.entrySet()) {
                UUID uuid = UUID.fromString(entry.getKey());
                double health = entry.getValue();
                userInfo.put(uuid, health);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerInfo(JavaPlugin javaPlugin) {
        /*for (UUID playerUUID : userInfo.keySet()) {
            String uuid = playerUUID.toString();
            String heart = userInfo.get(playerUUID).toString();

            data += "{\n" + "UUID:" + uuid + "heart:" + heart + "\n}" + "\n";
        }*/

        yaml = new Yaml();
        String data = yaml.dump(userInfo);

        file = javaPlugin.getDataFolder();
        if (!file.exists())
            return;

        file = new File(javaPlugin.getDataFolder(),"playerHealthData.yaml");

        try (FileWriter writer = new FileWriter(file)){
            writer.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserManager getInstance() {
        if (instance == null)
            return new UserManager();
        return instance;
    }

    public void updatePlayerHealth(UUID playerUUID, double health) {
        if (userInfo.containsKey(playerUUID)) {
            userInfo.put(playerUUID, health);
        }
    }
}
