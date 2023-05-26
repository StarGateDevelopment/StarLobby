package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinMessage implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(Main.prefix + p.getName() + "§a has landed on Chicken' Sky");
        p.setGameMode(GameMode.ADVENTURE);
        p.sendMessage("§7-----------------------");
        p.sendMessage("§7-------§6ChickenSKY§7--------");;
        p.sendMessage("§cYou§7Tube §7> https://www.youtube.com/@Mr.ChickenFLY");
        p.sendMessage( "§5Twitch §7> https://www.twitch.tv/mrchickenfly_hahnflieger ");
        p.sendMessage( "§bIP §7> play.chickensky.cloud ");
        p.sendMessage("§7-----------------------");
        p.sendMessage("§7---Thanks for Playing----");
        p.sendMessage("§7-----------------------");
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(Main.prefix + p.getName() + "§c go to the Nether");
    }
}
