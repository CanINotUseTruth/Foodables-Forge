package net.truth.foodables.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.truth.foodables.Foodables;
import net.truth.foodables.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FoodablesCropBlock extends CropBlock {

    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    public FoodablesCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.LETTUCE_SEEDS.get();
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer,
                                          @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {

        if(!pLevel.isClientSide && isMaxAge(pState)){
            List<ItemStack> dropList = getDrops(pState, (ServerLevel)pLevel, pPos, null);
            List<ItemStack> drops = new ArrayList<>(List.of());
            drops.addAll(dropList);

            for(ItemStack stack : drops){
                if(stack.getItem() == ((FoodablesCropBlock)pState.getBlock()).getBaseSeedId()){
                    ItemStack seedStack = stack.copy();
                    drops.remove(stack);
                    seedStack.shrink(1);
                    drops.add(seedStack);
                    break;
                }
            }

            pLevel.setBlock(pPos, this.getStateForAge(0), 2);

            for(ItemStack stack : drops) {
                popResource(pLevel, pPos, stack);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
