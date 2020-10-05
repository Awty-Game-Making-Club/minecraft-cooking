package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import org.awty.gmc.minecraft.cooking.CookingMod;

public class BakingScreenHandler extends AbstractCookingScreenHandler {

    public BakingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public BakingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(CookingMod.Blocks.OVEN, syncId, playerInventory, context);
    }

}
