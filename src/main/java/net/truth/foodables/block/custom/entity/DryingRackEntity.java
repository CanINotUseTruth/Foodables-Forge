package net.truth.foodables.block.custom.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.truth.foodables.recipe.DryingRackRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public class DryingRackEntity extends BlockEntity {
    public final ItemStackHandler itemStackHandler = new ItemStackHandler(1) {
        @Override
        protected  void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return hasRecipe(stack);
        }
    };

    private static final int INPUT_SLOT = 0;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 10;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

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
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

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
        super.saveAdditional(pTag);
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("rack_inventory"));
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
        if (recipe.isEmpty()) return false;
        return true;
    }

    private boolean hasRecipe(ItemStack stack) {
        SimpleContainer inventory = new SimpleContainer(1);
        inventory.setItem(0, stack);
        Optional<DryingRackRecipe> recipe = Objects.requireNonNull(this.level).getRecipeManager().getRecipeFor(DryingRackRecipe.Type.INSTANCE, inventory, level);
        if (recipe.isEmpty()) return false;
        return true;
    }

    private Optional<DryingRackRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemStackHandler.getSlots());
        inventory.setItem(0, this.itemStackHandler.getStackInSlot(0));
        return Objects.requireNonNull(this.level).getRecipeManager().getRecipeFor(DryingRackRecipe.Type.INSTANCE, inventory, level);
    }


}
