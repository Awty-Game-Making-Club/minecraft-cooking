package org.awty.gmc.minecraft.cooking.blocks.craftingstations;

import net.minecraft.recipe.RecipeType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.recipes.AbstractCookingRecipe;

public class MilkBarrelBlock extends AbstractCookingBlock {
    public MilkBarrelBlock(Settings settings) {
        super(settings);
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getRecipeType() {
        return CookingMod.RecipeTypes.MILK_BARREL_COOKING;
    }

    @Override
    Text getTitle() {
        return new TranslatableText("container.cooking.milk_barrel");
    }
}
