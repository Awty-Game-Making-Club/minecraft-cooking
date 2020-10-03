package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerContext;
import org.awty.gmc.minecraft.cooking.recipes.AbstractShapedCookingRecipe;

public class StoveScreenHandler extends CookingScreenHandler {

    public StoveScreenHandler(Block block, RecipeType<? extends AbstractShapedCookingRecipe> recipeType, int syncId, PlayerInventory playerInventory) {
        super(block, recipeType, syncId, playerInventory);
    }

    public StoveScreenHandler(Block block, RecipeType<? extends AbstractShapedCookingRecipe> recipeType, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(block, recipeType, syncId, playerInventory, context);
    }
}
