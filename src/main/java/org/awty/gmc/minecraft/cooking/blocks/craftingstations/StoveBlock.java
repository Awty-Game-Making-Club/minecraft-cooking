package org.awty.gmc.minecraft.cooking.blocks.craftingstations;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.awty.gmc.minecraft.cooking.CookingMod;
import org.awty.gmc.minecraft.cooking.screens.StoveScreenHandler;

public class StoveBlock extends CraftingTableBlock {
    private static final Text TITLE = new TranslatableText("container.cooking.stove");

    public final static DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public final static BooleanProperty LIT = Properties.LIT;

    public StoveBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) ->
                new StoveScreenHandler(this, CookingMod.RecipeTypes.STOVE_COOKING, i, playerInventory, ScreenHandlerContext.create(world, pos)), TITLE);
    }
}
