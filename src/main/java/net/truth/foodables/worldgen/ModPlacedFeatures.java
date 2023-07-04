package net.truth.foodables.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final ResourceKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final ResourceKey<PlacedFeature> LIME_PLACED_KEY = registerKey("lime_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final ResourceKey<PlacedFeature> MANGO_PLACED_KEY = registerKey("mango_placed");
    public static final ResourceKey<PlacedFeature> BANANA_PLACED_KEY = registerKey("banana_placed");
    public static final ResourceKey<PlacedFeature> PEPPERCORN_PLACED_KEY = registerKey("peppercorn_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, APPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.APPLE_SAPLING.get()));
        register(context, LEMON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LEMON_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.LEMON_SAPLING.get()));
        register(context, LIME_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIME_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.LIME_SAPLING.get()));
        register(context, ORANGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.ORANGE_SAPLING.get()));
        register(context, MANGO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MANGO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.MANGO_SAPLING.get()));
        register(context, BANANA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BANANA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.BANANA_SAPLING.get()));
        register(context, PEPPERCORN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PEPPERCORN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.PEPPERCORN_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Foodables.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
