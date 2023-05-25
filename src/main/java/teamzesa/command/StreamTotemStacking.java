package teamzesa.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTotemStacking implements CommandExecutor {
    private static final int MINIMUM = 2;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "플레이 상태에만 작성 가능합니다.");
            return false;
        }

        Player p = (Player) sender;
        ItemStack offHandStuff = p.getInventory().getItemInOffHand();

        List<ItemStack> playerItemStack = Arrays.asList(p.getInventory().getContents());

        // Checking total Totem amount
        List<Integer> itemList = playerItemStack.stream()
                .filter(item -> item != null && item.getType() == Material.TOTEM_OF_UNDYING)
                .map(ItemStack::getAmount)
                .collect(Collectors.toList());

        // Exception Check
        if (itemList.stream().mapToInt(Integer::intValue).sum() < MINIMUM) {
            p.sendMessage(ChatColor.RED + "2개 이상의 토템을 가지고 있으셔야 합니다.");
            return false;
        }

        if (itemList.stream().allMatch(amount -> amount == 1)) {
            p.sendMessage(ChatColor.RED + "합칠 토템이 없습니다.");
            return false;
        }

        // Remove Inventory
        playerItemStack.stream()
                .filter(item -> item != null && item.getType() == Material.TOTEM_OF_UNDYING)
                .forEach(p.getInventory()::remove);

        // offHandCheck
        if (offHandStuff.getType() == Material.TOTEM_OF_UNDYING)
            p.getInventory().setItemInOffHand(null);

        // setTotem
        ItemStack stackOfTotem = new ItemStack(Material.TOTEM_OF_UNDYING, itemList.stream().mapToInt(Integer::intValue).sum());
        p.getInventory().addItem(stackOfTotem);
        p.sendMessage(ChatColor.YELLOW + "토템을 합쳤습니다.");

        return true;
    }
}
