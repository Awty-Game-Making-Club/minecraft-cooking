package org.awty.gmc.minecraft.cooking.recipes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.awty.gmc.minecraft.cooking.CookingMod;

public class ToastingRecipe extends AbstractCookingRecipe {
    public ToastingRecipe(Identifier id, String group, int width, int height, DefaultedList<Ingredient> ingredients, ItemStack output) {
        super(id, group, width, height, ingredients, output);
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(CookingMod.Items.TOASTER);
    }

    public RecipeType<?> getType() {
        return CookingMod.RecipeTypes.TOASTING;
    }

    public RecipeSerializer<?> getSerializer() {
        return CookingMod.RecipeSerializers.TOASTING;
    }
}
