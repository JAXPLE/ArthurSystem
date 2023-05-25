package teamzesa.manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println("sender"+sender);
        System.out.println("command"+command);
        System.out.println("label"+label);
        System.out.println("args"+Arrays.toString(args));
        return false;
    }
}
