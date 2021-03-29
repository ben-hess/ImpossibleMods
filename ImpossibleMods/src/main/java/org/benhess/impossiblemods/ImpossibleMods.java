package org.benhess.impossiblemods;

import org.benhess.impossiblemods.events.IMEventHandler;
import org.benhess.impossiblemods.items.IMItemManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ImpossibleMods extends JavaPlugin {

    private IMItemManager itemManager;
    private IMEventHandler eventHandler;

    @Override
    public void onEnable(){
        itemManager = new IMItemManager();
        eventHandler = new IMEventHandler(itemManager);
        getServer().getPluginManager().registerEvents(eventHandler, this);
        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> loadMods());
    }

    public void loadMods(){
        ArrayList<ImpossibleMod> mods = new ArrayList<>();

        // Load mod plugins
        Plugin[] plugins = getServer().getPluginManager().getPlugins();
        for(int i = 0; i < plugins.length; i++){
            if(plugins[i] instanceof ImpossibleMod){
                mods.add((ImpossibleMod)plugins[i]);
            }
        }

        for(int i = 0; i < mods.size(); i++){
            mods.get(i).onModLoad(this);
            getLogger().info("Loaded mod '" + plugins[i].getName() + "'.");
        }
    }

    public IMItemManager getItemManager(){
        return itemManager;
    }
}