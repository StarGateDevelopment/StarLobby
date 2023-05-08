package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import de.creeperbuildings.starlobby.scoreboard.ScoreboardManager;
import org.bukkit.GameMode;
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

    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(Main.plugin().getConfig().getString("leave-message"));
    }
}