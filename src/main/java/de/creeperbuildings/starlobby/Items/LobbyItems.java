package de.creeperbuildings.starlobby.Items;

import de.creeperbuildings.starlobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LobbyItems implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        p.getInventory().setItem(0, new ItemBuilder(Material.BOOK).displayname("§7Server Information").build());
        p.getInventory().setItem(1, new ItemBuilder(Material.STICK).displayname("§7Player").build());
        p.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).displayname("§7Navigator").build());

    }


}
