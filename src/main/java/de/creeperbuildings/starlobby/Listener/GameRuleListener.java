package de.creeperbuildings.starlobby.Listener;

import de.creeperbuildings.starlobby.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GameRuleListener implements Listener {
    FileConfiguration c = Main.plugin().getConfig();

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(c.getBoolean("disable-weather"));
    }

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        e.setCancelled(!c.getBoolean("spawn-mobs") || e.getEntityType().equals(EntityType.WARDEN) && !c.getBoolean("spawn-warden"));
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent e) {
        e.setCancelled(!c.getBoolean("mob-griefing"));
    }

    @EventHandler
    public void onEndermanTakeBlock(EntityChangeBlockEvent e) {
        e.setCancelled(!c.getBoolean("mob-griefing"));
    }
}
