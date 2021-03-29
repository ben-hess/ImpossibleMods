package org.benhess.impossiblemods.items;

import org.bukkit.inventory.ItemStack;

public interface IMRegisteredItem {
    ItemStack createItemStack(int amount);
}