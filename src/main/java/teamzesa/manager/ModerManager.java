package teamzesa.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModerManager {
    private static ModerManager instance;
    private Map<UUID, UUID> moderatorList = new HashMap<>();

    private ModerManager() {
        UUID JAXPLE = UUID.fromString("27d84b4f-5991-4001-89d5-0fdfd3374a3d");
        UUID GUNBUNJUL = UUID.fromString("7e57dd28-bdba-4312-84ea-2da58cd6e598");

        this.moderatorList.put(JAXPLE, JAXPLE);
        this.moderatorList.put(GUNBUNJUL, GUNBUNJUL);
    }

    public static synchronized ModerManager getInstance() {
        if (instance == null) {
            instance = new ModerManager();
        }
        return instance;
    }

    public Boolean CheckingUUID(UUID uuid) {
        if (moderatorList.get(uuid) == null)
            return false;
        return true;
    }
}
