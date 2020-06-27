package me.dylan.hasteyboys.commands;

import me.dylan.hasteyboys.HasteyBoys;
import me.dylan.hasteyboys.locale.Locale;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HasteyBoysCommand implements CommandExecutor {

    private final HasteyBoys hb;

    public HasteyBoysCommand(HasteyBoys hb) {
        this.hb = hb;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(Locale.PREFIX + Locale.WRONG_ARGS);
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "enable":
                hb.setEnabled(true);
                sender.sendMessage(Locale.PREFIX + Locale.HASTEYBOYS_ENABLE);
                break;
            case "disable":
                hb.setEnabled(false);
                sender.sendMessage(Locale.PREFIX + Locale.HASTEYBOYS_DISABLE);
                break;
            case "toggle":
                hb.setEnabled(!hb.isEnabled());
                sender.sendMessage(Locale.PREFIX + (hb.isEnabled() ? Locale.HASTEYBOYS_ENABLE : Locale.HASTEYBOYS_DISABLE));
                break;
            case "info":
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8»&m-------------------------------------------------&r&8«"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7This plugin was made by &6Interuptings/Dylan&7."));
                sender.sendMessage("");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &b&l@Interuptings"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  &7&lDylan#6678"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8»&m-------------------------------------------------&r&8«"));
                break;
            default:
                sender.sendMessage(Locale.PREFIX + Locale.WRONG_ARGS);
                break;
        }
        return false;
    }
}
