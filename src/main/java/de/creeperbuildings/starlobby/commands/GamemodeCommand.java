package de.creeperbuildings.starlobby.commands;

import de.creeperbuildings.starlobby.Main;
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
            p.sendMessage(Main.prefix + " > You have changed your gamemode to §lCreative");
            p.setGameMode(GameMode.CREATIVE);
        } else if (label.equalsIgnoreCase("gma")) {
            p.sendMessage(Main.prefix + " > You have changed your gamemode to §lAdventure");
            p.setGameMode(GameMode.ADVENTURE);
        } else if (label.equalsIgnoreCase("gmsp")) {
            p.sendMessage( Main.prefix + Main.prefix + " > You have changed your gamemode to §lSpectator");
            p.setGameMode(GameMode.SPECTATOR);
        } else if (label.equalsIgnoreCase("gms")) {
            p.sendMessage(Main.prefix + " > You have changed your gamemode to §lSurvival");
            p.setGameMode(GameMode.SURVIVAL);
        }
        return false;
    }
}