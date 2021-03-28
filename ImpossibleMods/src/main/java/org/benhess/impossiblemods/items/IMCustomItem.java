package org.benhess.impossiblemods.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class IMCustomItem {
    private String name;
    private String[] description;

    public IMCustomItem(String name){
        this.name = name;
    }

    public void updateMeta(ItemMeta meta){
        meta.setDisplayName(ChatColor.WHITE + name);
        meta.setLocalizedName(name);
        if(description != null){
            ArrayList<String> lore = new ArrayList<>();
            for(int i = 0; i < description.length; i++){
                lore.add(ChatColor.GRAY + description[i]);
            }
            meta.setLore(lore);
        }
    }

    public Material getBukkitMaterial(){
        return Material.STONE;
    }

    protected void setDescription(String... lines){
        this.description = lines;
    }

    protected void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String[] getDescription(){
        return description;
    }
}