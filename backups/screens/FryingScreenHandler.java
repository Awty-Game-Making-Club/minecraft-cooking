package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerContext;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.recipes.AbstractCookingRecipe;

public class FryingScreenHandler extends AbstractCookingScreenHandler {

    public FryingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public FryingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(CookingMod.Blocks.FRYER, syncId, playerInventory, context);
    }


}
