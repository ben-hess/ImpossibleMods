package org.benhess.impossiblemods.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IMRegisteredVanillaItem implements IMRegisteredItem {

    private Material material;

    public IMRegisteredVanillaItem(Material material){
        this.material = material;
    }

    @Override
    public ItemStack createItemStack(int amount) {
        return new ItemStack(material, amount);
    }

    @Override
    public boolean matchesItemStack(ItemStack stack) {
        if(stack.getType() != material){
            return false;
        }
        ItemMeta meta = stack.getItemMeta();
        if(meta != null && meta.hasCustomModelData()){
            return false;
        }
        return true;
    }
}
