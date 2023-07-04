package net.truth.foodables.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.custom.FoodablesCropBlock;
import net.truth.foodables.block.custom.crops.*;
import net.truth.foodables.item.ModItems;
import net.truth.foodables.worldgen.tree.*;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Foodables.MOD_ID);

    // Functional Blocks
    public static final RegistryObject<Block> OAK_DRYING_RACK = registerBlock("oak_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_DRYING_RACK = registerBlock("spruce_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> BIRCH_DRYING_RACK = registerBlock("birch_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_DRYING_RACK = registerBlock("jungle_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_DRYING_RACK = registerBlock("dark_oak_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ACACIA_DRYING_RACK = registerBlock("acacia_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_DRYING_RACK = registerBlock("mangrove_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CHERRY_DRYING_RACK = registerBlock("cherry_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_DRYING_RACK = registerBlock("crimson_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> WARPED_DRYING_RACK = registerBlock("warped_drying_rack",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    // Food Blocks
    public static final RegistryObject<Block> HONEY_CAKE = registerBlock("honey_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));
    public static final RegistryObject<Block> APPLE_CAKE = registerBlock("apple_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));
    public static final RegistryObject<Block> BERRY_CAKE = registerBlock("berry_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));
    public static final RegistryObject<Block> ORANGE_CAKE = registerBlock("orange_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));
    public static final RegistryObject<Block> BANANA_CAKE = registerBlock("banana_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));
    public static final RegistryObject<Block> CHOCOLATE_CAKE = registerBlock("chocolate_cake",
            () -> new CakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).noLootTable()));

    // Ore Blocks
    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));

    // Tree Blocks
    public static final RegistryObject<Block> PEPPERCORN_LEAVES = registerBlock("peppercorn_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LIME_LEAVES = registerBlock("lime_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PEPPERCORN_SAPLING = registerBlock("peppercorn_sapling",
            () -> new SaplingBlock(new PeppercornTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LEMON_SAPLING = registerBlock("lemon_sapling",
            () -> new SaplingBlock(new LemonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LIME_SAPLING = registerBlock("lime_sapling",
            () -> new SaplingBlock(new LimeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ORANGE_SAPLING = registerBlock("orange_sapling",
            () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            () -> new SaplingBlock(new MangoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_sapling",
            () -> new SaplingBlock(new BananaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    // Potted Saplings
    public static final RegistryObject<Block> POTTED_PEPPERCORN_SAPLING = BLOCKS.register("potted_peppercorn_sapling",
            () -> new FlowerPotBlock(PEPPERCORN_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_LEMON_SAPLING = BLOCKS.register("potted_lemon_sapling",
            () -> new FlowerPotBlock(LEMON_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_LIME_SAPLING = BLOCKS.register("potted_lime_sapling",
            () -> new FlowerPotBlock(LIME_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_ORANGE_SAPLING = BLOCKS.register("potted_orange_sapling",
            () -> new FlowerPotBlock(ORANGE_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_APPLE_SAPLING = BLOCKS.register("potted_apple_sapling",
            () -> new FlowerPotBlock(APPLE_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_MANGO_SAPLING = BLOCKS.register("potted_mango_sapling",
            () -> new FlowerPotBlock(MANGO_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final RegistryObject<Block> POTTED_BANANA_SAPLING = BLOCKS.register("potted_banana_sapling",
            () -> new FlowerPotBlock(BANANA_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    // TODO Berry Blocks

    // Crop Blocks
    public static final RegistryObject<Block> LETTUCE_CROP = BLOCKS.register("lettuce_crop",
            () -> new LettuceCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> BROWN_ONION_CROP = BLOCKS.register("brown_onion_crop",
            () -> new BrownOnionCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> RED_ONION_CROP = BLOCKS.register("red_onion_crop",
            () -> new RedOnionCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
