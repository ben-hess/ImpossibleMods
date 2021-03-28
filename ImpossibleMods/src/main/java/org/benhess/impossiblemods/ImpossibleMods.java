package org.benhess.impossiblemods;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class ImpossibleMods extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getScheduler().scheduleSyncDelayedTask(this, () -> loadMods());
    }

    public void loadMods(){
        Plugin[] plugins = getServer().getPluginManager().getPlugins();
        ArrayList<ImpossibleMod> mods = new ArrayList<>();

        for(int i = 0; i < plugins.length; i++){
            if(plugins[i] instanceof ImpossibleMod){
                mods.add((ImpossibleMod)plugins[i]);
                getLogger().info("Loaded mod '" + plugins[i].getName() + "'.");
            }
        }
    }
}