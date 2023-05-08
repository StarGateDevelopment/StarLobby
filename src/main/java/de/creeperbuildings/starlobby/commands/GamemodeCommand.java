package de.creeperbuildings.starlobby.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player p = (Player) commandSender;
        if (label.equalsIgnoreCase("gmc")) {
            p.setGameMode(GameMode.CREATIVE);
        } else if (label.equalsIgnoreCase("gma")) {
            p.setGameMode(GameMode.ADVENTURE);
        } else if (label.equalsIgnoreCase("gmsp")) {
            p.setGameMode(GameMode.SPECTATOR);
        } else if (label.equalsIgnoreCase("gms")) {
            p.setGameMode(GameMode.SURVIVAL);
        }
        return false;
    }
}