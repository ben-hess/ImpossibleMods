package org.benhess.impossiblemods.items;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IMItemManager {

    ArrayList<IMRegisteredCustomItem> customItems;
    HashMap<Material, IMRegisteredVanillaItem> vanillaItemCache;

    public IMItemManager(){
        customItems = new ArrayList<>();
        vanillaItemCache = new HashMap<>();
    }

    public IMRegisteredCustomItem registerCustomItem(IMCustomItem item){
        int id = 0;
        for(int i = 0; i < customItems.size(); i++){
            if(customItems.get(i).getItem() == item){
                return customItems.get(i);
            }

            int nextId = customItems.get(i).getCustomItemId();
            if(id < nextId){
                id = nextId + 1;
            }
        }
        IMRegisteredCustomItem registeredItem = new IMRegisteredCustomItem(item, id);
        customItems.add(registeredItem);
        return registeredItem;
    }

    public IMRegisteredVanillaItem getVanillaItem(Material material){
        if(vanillaItemCache.containsKey(material)){
            return vanillaItemCache.get(material);
        }
        IMRegisteredVanillaItem registeredItem = new IMRegisteredVanillaItem(material);
        vanillaItemCache.put(material, registeredItem);
        return registeredItem;
    }
}
