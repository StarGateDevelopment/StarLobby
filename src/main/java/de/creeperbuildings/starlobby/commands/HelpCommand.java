package de.creeperbuildings.starlobby.commands;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (!p.hasPermission("starlobby.command.help")) {
            p.sendMessage(Main.plugin().getMessages().getString("no-permission"));
        }

        return false;
    }
}