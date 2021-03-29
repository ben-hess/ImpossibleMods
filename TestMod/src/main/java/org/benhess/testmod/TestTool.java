package org.benhess.testmod;

import org.benhess.impossiblemods.items.IMCustomToolItem;

public class TestTool extends IMCustomToolItem {

    public TestTool() {
        super("Super Hoe");
        setDescription("This was a bad idea.");
        setKnockBack(50);
        setAttackDamage(500);
    }
}