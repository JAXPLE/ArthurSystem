package teamzesa.moder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModerChecker {
    private static ModerChecker instance;
    private Map<UUID, UUID> moderatorList = new HashMap<>();

    private ModerChecker() {
        UUID Jaxple = UUID.fromString("27d84b4f-5991-4001-89d5-0fdfd3374a3d");
        UUID gunBunJun = UUID.fromString("7e57dd28-bdba-4312-84ea-2da58cd6e598");

        this.moderatorList.put(Jaxple, Jaxple);
        this.moderatorList.put(gunBunJun, gunBunJun);
    }

    public static synchronized ModerChecker getInstance() {
        if (instance == null) {
            instance = new ModerChecker();
        }
        return instance;
    }

    public Boolean CheckingUUID(UUID uuid) {
        if (moderatorList.get(uuid) == null)
            return false;
        return true;
    }
}
