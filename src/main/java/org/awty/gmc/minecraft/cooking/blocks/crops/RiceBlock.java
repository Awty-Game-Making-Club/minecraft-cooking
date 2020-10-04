package org.awty.gmc.minecraft.cooking.blocks.crops;

import net.minecraft.item.ItemConvertible;
import org.awty.gmc.minecraft.cooking.CookingMod;

public class RiceBlock extends SimpleCropBlock {
    public RiceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return CookingMod.Items.RICE;
    }
}
