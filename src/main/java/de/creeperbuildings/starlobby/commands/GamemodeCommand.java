package de.creeperbuildings.starlobby.commands;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.creeperbuildings.starlobby.Main.prefix;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player p = (Player) commandSender;
        if (label.equalsIgnoreCase("gmc")) {
            String msg = Main.plugin().getMessages().getString("change-game-mode").replace("%prefix%", prefix)
                            .replace("%gamemode%", "CREATIVE");
            p.sendMessage(msg);
            p.setGameMode(GameMode.CREATIVE);
        } else if (label.equalsIgnoreCase("gma")) {
            String msg = Main.plugin().getMessages().getString("change-game-mode").replace("%prefix%", prefix)
                    .replace("%gamemode%", "ADVENTURE");
            p.sendMessage(msg);
            p.setGameMode(GameMode.ADVENTURE);
        } else if (label.equalsIgnoreCase("gmsp")) {
            String msg = Main.plugin().getMessages().getString("change-game-mode").replace("%prefix%", prefix)
                    .replace("%gamemode%", "SPECTATOR");
            p.sendMessage(msg);
            p.setGameMode(GameMode.SPECTATOR);
        } else if (label.equalsIgnoreCase("gms")) {
            String msg = Main.plugin().getMessages().getString("change-game-mode").replace("%prefix%", prefix)
                    .replace("%gamemode%", "SURVIVAL");
            p.sendMessage(msg);
            p.setGameMode(GameMode.SURVIVAL);
        }
        return false;
    }
}