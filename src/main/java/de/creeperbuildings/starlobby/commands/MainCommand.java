package de.creeperbuildings.starlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p;
        if (sender instanceof Player) {
            p = (Player) sender;
        } else {
            sender.sendMessage("§cThis command is not available in console!");
            return false;
        }
        if (args.length == 0) {
            if (p.hasPermission("starlobby.admin.main-command")) { // Show a list of available Commands
                p.sendMessage("§aStarLobby");
                p.sendMessage("§6This plugin is by EinfachCody and CreeperBuildings.");
                p.sendMessage("§aUsage of this command:");
                p.sendMessage("§6Aliases: §a/starlobby /slobby /starl");
                p.sendMessage("§6Sub commands:");
                p.sendMessage("§a/starlobby ");
            }
            return false;
        }
        return false;
    }
}
