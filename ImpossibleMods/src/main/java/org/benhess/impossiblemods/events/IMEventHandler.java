package org.benhess.impossiblemods.events;

import org.benhess.impossiblemods.items.IMCustomItem;
import org.benhess.impossiblemods.items.IMItemManager;
import org.benhess.impossiblemods.items.IMRegisteredCustomItem;
import org.benhess.impossiblemods.items.IMRegisteredItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class IMEventHandler implements Listener {

    private IMItemManager itemManager;

    public IMEventHandler(IMItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public IMItemManager getItemManager() {
        return itemManager;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            ItemStack item = event.getItem();
            if(item != null){
                IMRegisteredItem registeredItem = itemManager.findItem(item);
                if(registeredItem instanceof IMRegisteredCustomItem){
                    IMCustomItem customItem = ((IMRegisteredCustomItem)registeredItem).getItem();
                    customItem.onBlockInteract(event.getPlayer(), item, event.getClickedBlock(), event.getBlockFace());
                    event.setCancelled(!customItem.usesVanillaBehavior());
                }
            }
        }
    }
}