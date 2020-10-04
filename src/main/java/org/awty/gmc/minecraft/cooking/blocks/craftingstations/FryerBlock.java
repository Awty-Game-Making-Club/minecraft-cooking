package org.awty.gmc.minecraft.cooking.blocks.craftingstations;

import net.minecraft.recipe.RecipeType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.recipes.AbstractShapedCookingRecipe;

public class FryerBlock extends CookingBlock {
    public FryerBlock(Settings settings) {
        super(settings);
    }

    @Override
    RecipeType<? extends AbstractShapedCookingRecipe> getRecipeType() {
        return CookingMod.RecipeTypes.FRYING;
    }

    @Override
    Text getTitle() {
        return new TranslatableText("container.cooking.fryer");
    }
}
