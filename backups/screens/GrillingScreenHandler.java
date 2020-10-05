package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerContext;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.recipes.AbstractCookingRecipe;

public class GrillingScreenHandler extends AbstractCookingScreenHandler {

    public GrillingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public GrillingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(CookingMod.Blocks.GRILL, syncId, playerInventory, context);
    }

}
