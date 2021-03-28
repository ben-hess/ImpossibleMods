package org.benhess.impossiblemods.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class IMCustomToolItem extends IMCustomItem {

    public IMCustomToolItem(String name) {
        super(name);
    }

    @Override
    public void updateMeta(ItemMeta meta){
        super.updateMeta(meta);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("damage", 5000, AttributeModifier.Operation.ADD_NUMBER));
    }

    @Override
    public Material getBukkitMaterial(){
        return Material.GOLDEN_HOE;
    }
}
