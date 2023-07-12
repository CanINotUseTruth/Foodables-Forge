package net.truth.foodables.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import net.truth.foodables.block.custom.entity.DryingRackEntity;
import net.truth.foodables.block.custom.entity.ModBlockEntities;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class DryingRackBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public static final VoxelShape NORTH_SHAPE, SOUTH_SHAPE, EAST_SHAPE, WEST_SHAPE;
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;

    public DryingRackBlock(Properties pProperties) {
        super(pProperties);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }


    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        Direction dir = pState.getValue(FACING);
        return switch (dir) {
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidState = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @SuppressWarnings("deprecation")
    public @NotNull FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }
    @SuppressWarnings("deprecation")
    public @NotNull BlockState updateShape(BlockState pState, @NotNull Direction pFacing, @NotNull BlockState pFacingState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, BlockState pState, @NotNull FluidState pFluidState) {
        if (!pState.getValue(BlockStateProperties.WATERLOGGED) && pFluidState.getType() == Fluids.WATER) {
            if (!pLevel.isClientSide()) {
                BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
                if (blockEntity instanceof DryingRackEntity) {
                    ((DryingRackEntity) blockEntity).drops();
                }
                pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.WATERLOGGED, Boolean.TRUE), 3);
                pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            }
            return true;
        } else {
            return false;
        }
    }

    /* BLOCK ENTITY */

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof DryingRackEntity) {
                ((DryingRackEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer,
                                          @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        DryingRackEntity dryingRackEntity = (DryingRackEntity) pLevel.getBlockEntity(pPos);
        ItemStackHandler itemStackHandler = Objects.requireNonNull(dryingRackEntity).itemStackHandler;
        ItemStack itemStack = itemStackHandler.getStackInSlot(0);
        ItemStack heldItem = pPlayer.getMainHandItem();

        if(heldItem.getItem() == Items.WATER_BUCKET) {
            return InteractionResult.PASS;
        }

        if (itemStack.isEmpty()) {
            // Hang item on rack
            if (!heldItem.isEmpty() && !pState.getValue(WATERLOGGED) && itemStackHandler.isItemValid(0, heldItem)) {
                if (!pLevel.isClientSide()) {
                    dryingRackEntity.itemStackHandler.setStackInSlot(0,
                            pPlayer.getAbilities().instabuild ? heldItem.copyWithCount(1) : heldItem.split(1));
                }
                return InteractionResult.sidedSuccess(true);
            }
            return InteractionResult.CONSUME;
        } else {
            // Remove hanging item
            if (!pLevel.isClientSide && !pPlayer.addItem(itemStack.split(1))) {
                pPlayer.drop(itemStack.split(1), false);
            }
            dryingRackEntity.clear();
            return InteractionResult.sidedSuccess(true);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new DryingRackEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.DRYING_RACK_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    // TODO Look in to horizontal facing block to change this implementation
    static {
        FACING = HorizontalDirectionalBlock.FACING;
        NORTH_SHAPE = Block.box(0.0D, 12.0D, 12.0D, 16.0D, 16.0D, 16.0D);
        SOUTH_SHAPE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 4.0D);
        EAST_SHAPE = Block.box(0.0D, 12.0D, 0.0D, 4.0D, 16.0D, 16.0D);
        WEST_SHAPE = Block.box(12.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }

}
