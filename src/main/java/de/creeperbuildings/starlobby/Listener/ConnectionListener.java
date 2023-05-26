package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import de.creeperbuildings.starlobby.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(Main.plugin().getConfig().getString("join-message"));

        if (Main.plugin().getConfig().getBoolean("scoreboard.enabled")) {
            Main.getScoreboardManager().createScoreboard(e.getPlayer());
        }

        int x = Main.plugin().getConfig().getInt("join-position.x");
        int y = Main.plugin().getConfig().getInt("join-position.y");
        int z = Main.plugin().getConfig().getInt("join-position.z");
        int yaw = Main.plugin().getConfig().getInt("join-position.yaw");
        int pitch = Main.plugin().getConfig().getInt("join-position.pitch");
        World w = Bukkit.getWorld(Main.plugin().getConfig().getString("join-position.world"));

        p.teleport(new Location(w, x, y, z, yaw, pitch));

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(Main.plugin().getConfig().getString("leave-message"));
    }
}