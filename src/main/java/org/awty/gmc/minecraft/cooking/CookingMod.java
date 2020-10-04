package org.awty.gmc.minecraft.cooking;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.awty.gmc.minecraft.cooking.blocks.craftingstations.*;
import org.awty.gmc.minecraft.cooking.blocks.crops.*;
import org.awty.gmc.minecraft.cooking.recipes.*;

public class CookingMod implements ModInitializer {
	
	public final static String NAMESPACE = "cooking";

	public static class Blocks {
		public static Block STOVE;
		public static Block MILK_BARREL;
		public static Block GRILL;
		public static Block OVEN;
		public static Block TOASTER;
		public static Block MILL;
		public static Block FRYER;

		public static Block TOMATOES;
		public static Block RICE;
		public static Block ONIONS;
		public static Block BEANS;

		private static void registerAll() {
			STOVE = registerBlock("stove",
					new StoveBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)
							.sounds(BlockSoundGroup.METAL)));
			MILK_BARREL = registerBlock("milk_barrel",
					new MilkBarrelBlock(Settings.of(Material.WOOD)
							.strength(2.5F)
							.sounds(BlockSoundGroup.WOOD)));
			GRILL = registerBlock("grill",
					new GrillBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)
							.sounds(BlockSoundGroup.METAL)));
			OVEN = registerBlock("oven",
					new OvenBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)
							.sounds(BlockSoundGroup.METAL)));
			TOASTER = registerBlock("toaster",
					new ToasterBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)
							.sounds(BlockSoundGroup.METAL)));
			MILL = registerBlock("mill",
					new MillBlock(Settings.of(Material.WOOD)
							.strength(2.5F)
							.sounds(BlockSoundGroup.WOOD)));
			FRYER = registerBlock("fryer",
					new FryerBlock(Settings.of(Material.METAL)
							.requiresTool()
							.strength(3.5F)
							.sounds(BlockSoundGroup.METAL)));

			TOMATOES = registerBlock("tomatoes",
					new TomatoesBlock(Settings.of(Material.PLANT)
							.noCollision()
							.ticksRandomly()
							.breakInstantly()
							.sounds(BlockSoundGroup.CROP)));
			RICE = registerBlock("rice",
					new RiceBlock(Settings.of(Material.PLANT)
							.noCollision()
							.ticksRandomly()
							.breakInstantly()
							.sounds(BlockSoundGroup.CROP)));
			ONIONS = registerBlock("onions",
					new OnionsBlock(Settings.of(Material.PLANT)
							.noCollision()
							.ticksRandomly()
							.breakInstantly()
							.sounds(BlockSoundGroup.CROP)));
			BEANS = registerBlock("beans",
					new BeansBlock(Settings.of(Material.PLANT)
							.noCollision()
							.ticksRandomly()
							.breakInstantly()
							.sounds(BlockSoundGroup.CROP)));
		}

		private static Block registerBlock(String fileName, Block block) {
			return Registry.register(Registry.BLOCK, new Identifier(NAMESPACE, fileName), block);
		}
	}

	public static class Items {
		public static Item STOVE;
		public static Item MILK_BARREL;
		public static Item GRILL;
		public static Item OVEN;
		public static Item TOASTER;
		public static Item MILL;
		public static Item FRYER;

		public static Item TOMATO;
		public static Item RICE;
		public static Item ONION;
		public static Item BEAN;

		private static void registerAll() {
			STOVE = registerItemFromBlock("stove", Blocks.STOVE);
			MILK_BARREL = registerItemFromBlock("milk_barrel", Blocks.MILK_BARREL);
			GRILL = registerItemFromBlock("grill", Blocks.GRILL);
			OVEN = registerItemFromBlock("oven", Blocks.OVEN);
			TOASTER = registerItemFromBlock("toaster", Blocks.TOASTER);
			MILL = registerItemFromBlock("mill", Blocks.MILL);
			FRYER = registerItemFromBlock("fryer", Blocks.FRYER);

			TOMATO = registerCropItem("tomato", Blocks.TOMATOES, new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build());
			RICE = registerCropItem("rice", Blocks.RICE, new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build());
			ONION = registerCropItem("onion", Blocks.ONIONS,  new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build());
			BEAN = registerCropItem("bean", Blocks.BEANS, new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build());
		}

		private static Item registerFoodItem(String fileName, FoodComponent foodComponent) {
			return Registry.register(Registry.ITEM, new Identifier(NAMESPACE, fileName), new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(foodComponent)));
		}

		private static Item registerCropItem(String fileName, Block cropBlock, FoodComponent foodComponent) {
			return Registry.register(Registry.ITEM, new Identifier(NAMESPACE, fileName), new AliasedBlockItem(cropBlock, new FabricItemSettings().group(ItemGroup.FOOD).food(foodComponent)));
		}

		private static Item registerCookingItem(String fileName) {
			return Registry.register(Registry.ITEM, new Identifier(NAMESPACE, fileName), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
		}

		private static Item registerItemFromBlock(String fileName, Block block) {
			return Registry.register(Registry.ITEM, new Identifier(NAMESPACE, fileName), new BlockItem(block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		}
	}

	public static class RecipeTypes {
		public static RecipeType<StoveCookingRecipe> STOVE_COOKING;
		public static RecipeType<MilkBarrelCookingRecipe> MILK_BARREL_COOKING;
		public static RecipeType<GrillingRecipe> GRILLING;
		public static RecipeType<BakingRecipe> BAKING;
		public static RecipeType<ToastingRecipe> TOASTING;
		public static RecipeType<MillingRecipe> MILLING;
		public static RecipeType<FryingRecipe> FRYING;

		private static void registerAll() {
			STOVE_COOKING = registerRecipeType("stove_cooking");
			MILK_BARREL_COOKING = registerRecipeType("milk_barrel_cooking");
			GRILLING = registerRecipeType("grilling");
			BAKING = registerRecipeType("baking");
			TOASTING = registerRecipeType("toasting");
			MILLING = registerRecipeType("milling");
			FRYING = registerRecipeType("frying");
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
		public static AbstractShapedCookingRecipe.Serializer MILK_BARREL_COOKING;
		public static AbstractShapedCookingRecipe.Serializer GRILLING;
		public static AbstractShapedCookingRecipe.Serializer BAKING;
		public static AbstractShapedCookingRecipe.Serializer TOASTING;
		public static AbstractShapedCookingRecipe.Serializer MILLING;
		public static AbstractShapedCookingRecipe.Serializer FRYING;

		private static void registerAll() {
			STOVE_COOKING = register("stove_cooking", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			MILK_BARREL_COOKING = register("milk_barrel_cooking", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			GRILLING = register("grilling", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			BAKING = register("baking", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			TOASTING = register("toasting", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			MILLING = register("milling", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
			FRYING = register("frying", new AbstractShapedCookingRecipe.Serializer(StoveCookingRecipe::new));
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
