package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    private Main main;

    public ConnectionListener(Main main) {
        this.main = main;

    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.ADVENTURE);
        e.setJoinMessage("§7[§a+§7]" + p.getName());
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§7[§c-§7]" + p.getName());
    }
}
