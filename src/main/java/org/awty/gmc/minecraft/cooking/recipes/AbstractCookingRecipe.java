package org.awty.gmc.minecraft.cooking.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public abstract class AbstractCookingRecipe extends ShapedRecipe {
    public AbstractCookingRecipe(Identifier id, String group, int width, int height, DefaultedList<Ingredient> ingredients, ItemStack output) {
        super(id, group, width, height, ingredients, output);
    }

    public static class Serializer extends ShapedRecipe.Serializer {
        @FunctionalInterface
        public interface RecipeConstructor {
            AbstractCookingRecipe apply(Identifier id, String group, int width, int height, DefaultedList<Ingredient> ingredients, ItemStack output);
        }

        private final RecipeConstructor recipeConstructor;

        public Serializer(RecipeConstructor recipeConstructor) {
            this.recipeConstructor = recipeConstructor;
        }

        @Override
        public AbstractCookingRecipe read(Identifier identifier, JsonObject jsonObject) {
            ShapedRecipe shapedRecipe = super.read(identifier, jsonObject);
            return recipeConstructor.apply(shapedRecipe.getId(),
                    shapedRecipe.getGroup(),
                    shapedRecipe.getWidth(),
                    shapedRecipe.getHeight(),
                    shapedRecipe.getPreviewInputs(),
                    shapedRecipe.getOutput());
        }

        @Override
        public AbstractCookingRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            ShapedRecipe shapedRecipe = super.read(identifier, packetByteBuf);
            return recipeConstructor.apply(shapedRecipe.getId(),
                    shapedRecipe.getGroup(),
                    shapedRecipe.getWidth(),
                    shapedRecipe.getHeight(),
                    shapedRecipe.getPreviewInputs(),
                    shapedRecipe.getOutput());
        }

        @Override
        public void write(PacketByteBuf packetByteBuf, ShapedRecipe shapedRecipe) {
            super.write(packetByteBuf, shapedRecipe);
        }
    }
}
