package de.creeperbuildings.starlobby.playerhider;


import de.creeperbuildings.starlobby.Main;
import de.creeperbuildings.starlobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PlayerHider implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory phider = Bukkit.createInventory(null, 27, "§7Player Hider");
        //Design Creation
        phider.setItem(0, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(1, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(2, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(3, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(4, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(5, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(6, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(7, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(8, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(9, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(18, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(17, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(26, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(19, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(20, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(21, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(22, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(23, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(24, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(25, new ItemBuilder(Material.GOLD_BLOCK).build());
        //Hider
        phider.setItem(12, new ItemBuilder(Material.REDSTONE).displayname("§cHide Players").build());
        phider.setItem(14, new ItemBuilder(Material.EMERALD).displayname("§aShow Players").build());
        //Technical Design
        phider.setItem(10, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(11, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(13, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(15, new ItemBuilder(Material.GOLD_BLOCK).build());
        phider.setItem(16, new ItemBuilder(Material.GOLD_BLOCK).build());

        e.setCancelled(true);
        Player t = (Player) e.getWhoClicked();
        switch (e.getSlot()) {
            case 12 -> {
                ((Player) e.getWhoClicked()).hidePlayer(t);
                p.sendMessage("[StarLobby] > §cYou dont see any Players right now");

                switch (e.getSlot()) {
                    case 14 -> {
                        ((Player) e.getWhoClicked()).showPlayer(t);
                        p.sendMessage("[StarLobby] > §aYou see every Players right now");
                        e.setCancelled(true);
                    }
                }


            }

        }
    }
}


