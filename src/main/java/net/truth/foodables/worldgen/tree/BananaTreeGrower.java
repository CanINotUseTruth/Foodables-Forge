package net.truth.foodables.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.truth.foodables.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BananaTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.BANANA_KEY;
    }
}
