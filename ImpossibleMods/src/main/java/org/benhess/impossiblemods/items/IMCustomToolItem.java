package org.benhess.impossiblemods.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class IMCustomToolItem extends IMCustomItem {

    private double attackDamage = 0;
    private double knockBack = 0;

    public IMCustomToolItem(String name) {
        super(name);
    }

    @Override
    public void updateMeta(ItemMeta meta){
        super.updateMeta(meta);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),
                "generic.attack_damage", attackDamage - 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, new AttributeModifier(UUID.randomUUID(),
                "generic.attack_knockback", knockBack, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
    }

    @Override
    public Material getBukkitMaterial(){
        return Material.WOODEN_HOE;
    }

    @Override
    public boolean usesVanillaBehavior(){
        return true;
    }

    protected void setAttackDamage(double attackDamage){
        this.attackDamage = attackDamage;
    }

    protected void setKnockBack(double knockBack){
        this.knockBack = knockBack;
    }

    public double getAttackDamage(){
        return attackDamage;
    }

    public double getKnockBack(){
        return knockBack;
    }
}
