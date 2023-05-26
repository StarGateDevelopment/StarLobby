package de.creeperbuildings.starlobby.commands;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("lobby.cmd.gm")) {
            if (args.length==1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(Main.prefix + "§7You have changed your GameMode to §aSurvial§7.");
                } else if (args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(Main.prefix + "§7You have changed your GameMode to §aCreative§7.");
                } else if (args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(Main.prefix + "§7You have changed your GameMode to §aAdventure§7.");
                } else if (args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(Main.prefix + "§7You have changed your GameMode to §aSpectator§7.");

                }
            }
        }
        return false;
    }
}
