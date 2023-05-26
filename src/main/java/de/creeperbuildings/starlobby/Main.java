package de.creeperbuildings.starlobby;

import de.creeperbuildings.starlobby.scoreboard.ScoreboardManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.error.YAMLException;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    private static Main plugin;
    private static ScoreboardManager scoreboardManager;

    private YamlConfiguration messages;



    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        getLogger().info("Starting StarLobby...");
        getLogger().info("   _____ _             _           _     _           ");
        getLogger().info("  / ____| |           | |         | |   | |          ");
        getLogger().info(" | (___ | |_ __ _ _ __| |     ___ | |__ | |__  _   _ ");
        getLogger().info("  \\___ \\| __/ _` | '__| |    / _ \\| '_ \\| '_ \\| | | |");
        getLogger().info("  ____) | || (_| | |  | |___| (_) | |_) | |_) | |_| |");
        getLogger().info(" |_____/ \\__\\__,_|_|  |______\\___/|_.__/|_.__/ \\__, |");
        getLogger().info("                                                __/ |");
        getLogger().info("                                               |___/ ");

        saveResource("messages.yml", false);
        try {
            messages.load(new File(plugin().getDataFolder().getAbsolutePath() + "/messages.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            getLogger().severe("An error occurred while loading messages.yml!" + e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }



    public YamlConfiguration getMessages() {
        return messages;
    }

    public static Main plugin() {
        return plugin;
    }

    public static ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}