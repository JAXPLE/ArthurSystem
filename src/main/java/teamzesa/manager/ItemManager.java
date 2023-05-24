package teamzesa.manager;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class ItemManager {
    public static ItemStack customItem(Plugin System) {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        NamespacedKey resourceKey = new NamespacedKey(System,"custom_resource");
        itemMeta.getPersistentDataContainer().set(resourceKey, PersistentDataType.STRING, "neth_sword/1");

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
