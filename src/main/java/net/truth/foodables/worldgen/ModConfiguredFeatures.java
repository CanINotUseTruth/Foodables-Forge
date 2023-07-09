package net.truth.foodables.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_KEY = registerKey("lime");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_KEY = registerKey("mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_KEY = registerKey("banana");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEPPERCORN_KEY = registerKey("peppercorn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SALT_ORE_KEY = registerKey("salt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKBERRY_KEY = registerKey("blackberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_KEY = registerKey("blueberry");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldSaltOre = List.of(OreConfiguration.target(stoneReplaceables, 
                ModBlocks.SALT_ORE.get().defaultBlockState()));

        register(context, SALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSaltOre, 9));

        register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, LEMON_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.LEMON_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, LIME_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.LIME_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, ORANGE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, MANGO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.MANGO_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, BANANA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.BANANA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, PEPPERCORN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4,3,0),
                BlockStateProvider.simple(ModBlocks.PEPPERCORN_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, BLACKBERRY_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(24, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLACKBERRY_BUSH.get().defaultBlockState()
                                .setValue(SweetBerryBushBlock.AGE, 3))))));

        register(context, BLUEBERRY_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(24, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get().defaultBlockState()
                                .setValue(SweetBerryBushBlock.AGE, 3))))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Foodables.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
