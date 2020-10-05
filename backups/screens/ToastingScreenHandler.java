package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import org.awty.gmc.minecraft.cooking.CookingMod;

public class ToastingScreenHandler extends AbstractCookingScreenHandler {

    public ToastingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public ToastingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(CookingMod.Blocks.TOASTER, syncId, playerInventory, context);
    }

}
