package de.creeperbuildings.starlobby.navigator;

import de.creeperbuildings.starlobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import javax.swing.*;

public class Navigator implements Listener {

    private final String GUI_NAME = "Navigator";

    public void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*5, GUI_NAME);

        inventory.setItem(22, new ItemBuilder(Material.EYE_OF_ENDER).displayname("§aSpawn").build());
        inventory.setItem(24, new ItemBuilder(Material.BARRIER).displayname("§aEditable in Config.yml").build());
        inventory.setItem(20, new ItemBuilder(Material.BARRIER).displayname("§aEditable in Config.yml").build());
        inventory.setItem(11, new ItemBuilder(Material.BARRIER).displayname("§aEditable in Config.yml").build());
        inventory.setItem(31, new ItemBuilder(Material.BARRIER).displayname("§aEditable in Config.yml").build());
        player.openInventory(inventory);
    }

    @EventHandler
    public void onNavigator(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() != null && event.getItem().getType() == Material.NETHER_STAR) {
            if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))
                return;
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                openGUI(player);
        }
      }

    @EventHandler
    public void onGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getCurrentItem() == null) return;
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case EYE_OF_ENDER ->
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1L, 1L);


            }
        }
    }

    }

