package net.truth.foodables.block.custom.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.PitcherCropBlock;
import net.minecraft.world.level.block.TorchflowerCropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FarmBlockEntity extends BlockEntity {

    private int progress = 0;
    private int maxProgress = 1280; // TODO test amount to stack time of different crops

    public FarmBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FARM_BLOCK_BE.get(), pPos, pBlockState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putInt("farm_block.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        progress = pTag.getInt("farm_block.progress");
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        BlockState aboveBlockState = level.getBlockState(pPos.above());

        if(checkBlockAbove(aboveBlockState)) {
            increaseProgress();
        }

        if(hasProgressFinished() && !level.isClientSide()) {
            if(Math.random() * 100 >= 50) {
                applyBonemealEffect(level, pPos, aboveBlockState);

            }
            resetProgress();
        }
    }

    private void applyBonemealEffect(Level level, BlockPos pPos, BlockState aboveBlockState) {
        if(aboveBlockState.getBlock() instanceof CropBlock) {
            ((CropBlock) aboveBlockState.getBlock()).performBonemeal((ServerLevel) level, RandomSource.create(), pPos.above(), aboveBlockState);
        }

        if(aboveBlockState.getBlock() instanceof PitcherCropBlock) {
            ((PitcherCropBlock) aboveBlockState.getBlock()).performBonemeal((ServerLevel) level, RandomSource.create(), pPos.above(), aboveBlockState);
        }
    }

    private boolean checkBlockAbove(BlockState aboveBlockState) {

        if(aboveBlockState.getBlock() instanceof CropBlock) {
            int maxAge = ((CropBlock) aboveBlockState.getBlock()).getMaxAge();
            switch (maxAge) {
                case 2 -> {
                    return aboveBlockState.getValue(TorchflowerCropBlock.AGE) < ((CropBlock) aboveBlockState.getBlock()).getMaxAge();
                }
                case 3, 7 -> {
                    return aboveBlockState.getValue(CropBlock.AGE) < ((CropBlock) aboveBlockState.getBlock()).getMaxAge();
                }
            }

        }

        if(aboveBlockState.getBlock() instanceof PitcherCropBlock) {
            return aboveBlockState.getValue(PitcherCropBlock.AGE) < 4;
        }

        return false;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseProgress() {
        this.progress++;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
    }
}
