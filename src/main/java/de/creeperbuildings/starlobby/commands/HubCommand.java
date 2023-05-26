package de.creeperbuildings.starlobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.teleport(new Location(Bukkit.getWorld("world"), 0, 100, 0));
            p.playSound(p.getLocation(),Sound.ENTITY_ENDERMEN_TELEPORT, 1,1 );
        }
        return false;
    }
}
