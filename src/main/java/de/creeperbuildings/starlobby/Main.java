package de.creeperbuildings.starlobby;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private final String prefix = "[§aLOBBY]";
    private final String noPerms = prefix + "§c§lYou don't have the Permissions to do this.";


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aThe Lobby Plugin was successfully started.");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(prefix + "§cThe Plugin was shutdowned :(");
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerms() {
        return noPerms;
    }
}
