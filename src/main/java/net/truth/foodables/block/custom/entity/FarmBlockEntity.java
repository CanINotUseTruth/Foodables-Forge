package net.truth.foodables.block.custom.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.truth.foodables.Foodables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FarmBlockEntity extends BlockEntity {

    private int progress = 0;
    private int maxProgress = 600;

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
        progress = pTag.getInt("drying_rack.progress");
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        BlockState aboveBlockState = level.getBlockState(pPos.above());

        if(checkBlockAbove(aboveBlockState)) {
            increaseProgress();
        }

        if(hasProgressFinished() && !level.isClientSide()) {
            if(Math.random() * 100 >= 50 && aboveBlockState.getBlock() instanceof CropBlock) {
                Foodables.LOGGER.info("Growth applied");
                ((CropBlock) aboveBlockState.getBlock()).performBonemeal((ServerLevel) level, RandomSource.create(), pPos.above(), aboveBlockState);
            }
            resetProgress();
        }
    }

    private boolean checkBlockAbove(BlockState aboveBlockState) {
        if(aboveBlockState.getBlock() instanceof CropBlock) {
            return aboveBlockState.getValue(CropBlock.AGE) < 7;
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
