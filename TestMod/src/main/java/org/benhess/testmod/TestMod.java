package org.benhess.testmod;

import org.benhess.impossiblemods.ImpossibleMod;
import org.benhess.impossiblemods.ImpossibleMods;
import org.benhess.impossiblemods.items.IMRegisteredItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class TestMod extends ImpossibleMod {

    IMRegisteredItem registeredTestItem;
    IMRegisteredItem registeredTestTool;

    @Override
    public void onModLoad(ImpossibleMods loader){
        registeredTestItem = loader.getItemManager().registerCustomItem(new TestItem());
        registeredTestTool = loader.getItemManager().registerCustomItem(new TestTool());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev){
        ev.getPlayer().getInventory().addItem(registeredTestTool.createItemStack(1), registeredTestItem.createItemStack(1));
    }
}