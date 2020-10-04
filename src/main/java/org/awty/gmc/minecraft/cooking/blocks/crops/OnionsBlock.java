package org.awty.gmc.minecraft.cooking.blocks.crops;

import net.minecraft.item.ItemConvertible;
import org.awty.gmc.minecraft.cooking.CookingMod;

public class OnionsBlock extends SimpleCropBlock {
    public OnionsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return CookingMod.Items.ONION;
    }
}
