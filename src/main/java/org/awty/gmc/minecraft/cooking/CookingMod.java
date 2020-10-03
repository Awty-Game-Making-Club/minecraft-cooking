package org.awty.gmc.minecraft.cooking;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.awty.gmc.minecraft.cooking.blocks.craftingstations.StoveBlock;
import org.awty.gmc.minecraft.cooking.recipes.AbstractShapedCookingRecipe;
import org.awty.gmc.minecraft.cooking.recipes.StoveCookingRecipe;

public class CookingMod implements ModInitializer {
	
	public final static String NAMESPACE = "cooking";

	public static class Blocks {
		public static Block STOVE;

		private static void registerAll() {
			STOVE = registerBlock("stove",
					new StoveBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)));
		}

		private static Block registerBlock(String fileName, Block block) {
			return Registry.register(Registry.BLOCK, new Identifier(NAMESPACE, fileName), block);
		}
	}

	public static class Items {
		public static Item STOVE;

		private static void registerAll() {
			STOVE = registerItemFromBlock("stove", Blocks.STOVE);
		}

		private static Item registerItemFromBlock(String fileName, Block block) {
			return Registry.register(Registry.ITEM, new Identifier(NAMESPACE, fileName), new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		}
	}

	public static class RecipeTypes {
		public static RecipeType<StoveCookingRecipe> STOVE_COOKING;

		private static void registerAll() {
			STOVE_COOKING = registerRecipeType("stove_cooking");
		}

		private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String fileName) {
			return Registry.register(Registry.RECIPE_TYPE, new Identifier(NAMESPACE, fileName), new RecipeType<T>() {
				public String toString() {
					return fileName;
				}
			});
		}
	}

	public static class RecipeSerializers {
		public static AbstractShapedCookingRecipe.Serializer STOVE_COOKING;

		private static void registerAll() {
			STOVE_COOKING = register("stove_cooking", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
		}

		private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String fileName, S serializer) {
			return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(NAMESPACE, fileName), serializer);
		}
	}

	@Override
	public void onInitialize() {
		Blocks.registerAll();
		Items.registerAll();
		RecipeTypes.registerAll();
		RecipeSerializers.registerAll();
	}

}
