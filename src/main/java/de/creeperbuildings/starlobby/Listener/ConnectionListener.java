package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import de.creeperbuildings.starlobby.scoreboard.ScoreboardManager;
import de.creeperbuildings.starlobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;
import java.util.Objects;

import static de.creeperbuildings.starlobby.Main.prefix;

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

        if (!Main.plugin().getConfig().getString("config-version").equals(Main.latestVersion)
            && p.hasPermission("starlobby.admin.notify-update")) {
            p.sendMessage(prefix + "§cA new update for §eStarLobby §cis available: §a" + Main.latestVersion);
        }

        // Tab list Configuration
        if (Main.plugin().getConfig().getBoolean("tablist.enable")) {
            p.setPlayerListHeader(createOneLineTextFromList(Main.plugin().getConfig().getStringList("tablist.header")));
            p.setPlayerListFooter(createOneLineTextFromList(Main.plugin().getConfig().getStringList("tablist.footer")));
        }


        for (String s : Main.plugin().getConfig().getConfigurationSection("hotbar").getKeys(true)) {
            ConfigurationSection c = Main.plugin().getConfig().getConfigurationSection("hotbar").getConfigurationSection(s);
            try {
                int slot = Integer.parseInt(s);
                p.getInventory().setItem(slot, new ItemBuilder(c.getItemStack("material")).amount(c.getInt("amount"))
                        .displayname(c.getString("displayname")).lore(c.getStringList("lore")).build());
            } catch (NumberFormatException ex) {
                Main.plugin().getLogger().severe("Problem with config file. Invalid slot name in 'hotbar'.");
            }
        }


    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(Main.plugin().getConfig().getString("leave-message"));
    }

    private String createOneLineTextFromList(List<String> strings) {
        StringBuilder result = new StringBuilder();
        for (String s : strings) result.append(s).append("\n");
        return result.toString();
    }
}