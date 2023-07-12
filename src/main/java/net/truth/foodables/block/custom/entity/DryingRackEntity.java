package net.truth.foodables.block.custom.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.truth.foodables.recipe.DryingRackRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class DryingRackEntity extends BlockEntity {
    public final ItemStackHandler itemStackHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!Objects.requireNonNull(level).isClientSide()) {
                level.sendBlockUpdated(getBlockPos(),getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return hasRecipe(stack);
        }
    };

    private static final int INPUT_SLOT = 0;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 0;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public ItemStack getRenderStack() {
        return itemStackHandler.getStackInSlot(INPUT_SLOT);
    }

    public DryingRackEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DRYING_RACK_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> DryingRackEntity.this.progress;
                    case 1 -> DryingRackEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> DryingRackEntity.this.progress = pValue;
                    case 1 -> DryingRackEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        inventory.setItem(0, itemStackHandler.getStackInSlot(INPUT_SLOT));
        Containers.dropContents(Objects.requireNonNull(this.level), this.worldPosition, inventory);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("rack_inventory", itemStackHandler.serializeNBT());
        pTag.putInt("drying_rack.progress", progress);
        pTag.putInt("drying_rack.max_progress", maxProgress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("rack_inventory"));
        progress = pTag.getInt("drying_rack.progress");
        maxProgress = pTag.getInt("drying_rack.max_progress");
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (hasRecipe()) {
            if(this.progress == 0) setMaxProgress();
            increaseCraftingProgress();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void setMaxProgress() {
        Optional<DryingRackRecipe> recipe = getCurrentRecipe();
        this.maxProgress = recipe.get().getDryingTime();
    }

    private void craftItem() {
        Optional<DryingRackRecipe> recipe = getCurrentRecipe();
        ItemStack resultItem = recipe.get().getResultItem(Objects.requireNonNull(getLevel()).registryAccess());

        this.itemStackHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemStackHandler.setStackInSlot(INPUT_SLOT, new ItemStack(resultItem.getItem(), 1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<DryingRackRecipe> recipe = getCurrentRecipe();
        return recipe.isPresent();
    }

    public boolean hasRecipe(ItemStack stack) {
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, stack);
        Optional<DryingRackRecipe> recipe = Objects.requireNonNull(this.level).getRecipeManager().getRecipeFor(DryingRackRecipe.Type.INSTANCE, inventory, level);
        return recipe.isPresent();
    }

    private Optional<DryingRackRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemStackHandler.getSlots());
        inventory.setItem(0, this.itemStackHandler.getStackInSlot(INPUT_SLOT));
        return Objects.requireNonNull(this.level).getRecipeManager().getRecipeFor(DryingRackRecipe.Type.INSTANCE, inventory, level);
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

    public void clear() {
        itemStackHandler.setStackInSlot(0, new ItemStack(Items.AIR, 0));
    }
}
