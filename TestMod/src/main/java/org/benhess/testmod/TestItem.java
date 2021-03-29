package org.benhess.testmod;

import org.benhess.impossiblemods.items.IMCustomItem;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestItem extends IMCustomItem {

    public TestItem() {
        super("Useless Gift");
        setDescription("The gift that keeps on giving.");
    }

    @Override
    public void onBlockInteract(Player player, ItemStack item, Block block, BlockFace blockFace){
        player.getInventory().addItem(item);
    }
}
