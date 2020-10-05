package org.awty.gmc.minecraft.cooking.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.recipes.AbstractCookingRecipe;

import java.util.Objects;
import java.util.Optional;

public class MillingScreenHandler extends AbstractCookingScreenHandler {

    public MillingScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public MillingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(CookingMod.Blocks.MILL, syncId, playerInventory, context);
    }

}
