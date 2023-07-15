package net.truth.foodables.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.PitcherCropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.truth.foodables.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PitcherCropBlock.class)
public class MixinPitcherCropBlock {

    @Inject(at = @At("HEAD"), method = "mayPlaceOn", cancellable = true)
    private void onMayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos, CallbackInfoReturnable<Boolean> callback) {
        if(pState.is(ModBlocks.FERTILE_FARMLAND.get())) callback.setReturnValue(true);
    }
}
