package org.benhess.impossiblemods.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IMRegisteredCustomItem implements IMRegisteredItem {

    private final IMCustomItem item;
    private final int customItemId;

    public IMRegisteredCustomItem(IMCustomItem item, int customItemId){
        this.item = item;
        this.customItemId = customItemId;
    }

    @Override
    public ItemStack createItemStack(int amount) {
        ItemStack stack = new ItemStack(item.getBukkitMaterial(), amount);
        ItemMeta meta = stack.getItemMeta();
        if(meta != null){
            item.updateMeta(meta);
            meta.setCustomModelData(customItemId);
        }
        stack.setItemMeta(meta);
        return stack;
    }

    @Override
    public boolean matchesItemStack(ItemStack stack) {
        ItemMeta meta = stack.getItemMeta();
        if(meta != null && meta.hasCustomModelData()){
            return meta.getCustomModelData() == customItemId;
        }
        return false;
    }

    public IMCustomItem getItem(){
        return item;
    }

    public int getCustomItemId(){
        return customItemId;
    }
}