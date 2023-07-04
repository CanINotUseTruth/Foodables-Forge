package net.truth.foodables.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Foodables.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FOODABLES_TAB = CREATIVE_MODE_TABS.register("foodables_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MORTAR_AND_PESTLE.get()))
                    .title(Component.translatable("creativetab.foodables.foodables_tab"))
                    .displayItems((displayParameters, output) -> {
                        // - Items -
                        // Tools
                        output.accept(ModItems.MORTAR_AND_PESTLE.get());
                        output.accept(ModItems.KNIFE.get());
                        output.accept(ModItems.CRUSHER.get());
                        output.accept(ModItems.WHISK.get());
                        output.accept(ModItems.JUICER.get());
                        output.accept(ModItems.WET_CARTON.get());
                        output.accept(ModItems.CARTON.get());
                        output.accept(ModItems.CAKE_TIN.get());

                        // Veggies
                        output.accept(ModItems.LETTUCE.get());
                        output.accept(ModItems.TOMATO.get());
                        output.accept(ModItems.GARLIC.get());
                        output.accept(ModItems.BROWN_ONION.get());
                        output.accept(ModItems.RED_ONION.get());
                        output.accept(ModItems.SLICED_BROWN_ONION.get());
                        output.accept(ModItems.SLICED_RED_ONION.get());
                        output.accept(ModItems.PUMPKIN_SLICES.get());

                        // Cooked Veggies
                        output.accept(ModItems.COOKED_ONION.get());
                        output.accept(ModItems.CARAMELIZED_ONION.get());
                        output.accept(ModItems.BATTERED_ONIONS.get());
                        output.accept(ModItems.ONION_RINGS.get());
                        output.accept(ModItems.UNCOOKED_FRIES.get());
                        output.accept(ModItems.FRIES.get());

                        // Fruit
                        output.accept(ModItems.LEMON.get());
                        output.accept(ModItems.LIME.get());
                        output.accept(ModItems.ORANGE.get());
                        output.accept(ModItems.MANGO.get());
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.FRUIT_SALAD.get());

                        // Berries
                        output.accept(ModItems.BLUEBERRIES.get());
                        output.accept(ModItems.BLACKBERRIES.get());

                        // Baked Fruit & Veggies
                        output.accept(ModItems.BAKED_APPLE.get());
                        output.accept(ModItems.BAKED_PUMPKIN.get());
                        output.accept(ModItems.BAKED_CARROT.get());
                        output.accept(ModItems.BAKED_BEETROOT.get());

                        // Meat
                        output.accept(ModItems.SQUID.get());
                        output.accept(ModItems.BATTERED_SQUID.get());
                        output.accept(ModItems.SALT_AND_PEPPER_SQUID.get());
                        output.accept(ModItems.RAW_NUGGETS.get());
                        output.accept(ModItems.BATTERED_NUGGETS.get());
                        output.accept(ModItems.COOKED_NUGGETS.get());
                        output.accept(ModItems.RAW_BACON.get());
                        output.accept(ModItems.COOKED_BACON.get());
                        output.accept(ModItems.SALTED_BACON_STRIPS.get());
                        output.accept(ModItems.BACON_JERKY.get());
                        output.accept(ModItems.CHICKEN_STRIPS.get());
                        output.accept(ModItems.SALTED_CHICKEN_STRIPS.get());
                        output.accept(ModItems.CHICKEN_JERKY.get());
                        output.accept(ModItems.BEEF_STRIPS.get());
                        output.accept(ModItems.COOKED_BEEF_STRIPS.get());
                        output.accept(ModItems.SALTED_BEEF_STRIPS.get());
                        output.accept(ModItems.BEEF_JERKY.get());
                        output.accept(ModItems.LAMB_STRIPS.get());
                        output.accept(ModItems.SALTED_LAMB_STRIPS.get());
                        output.accept(ModItems.LAMB_JERKY.get());
                        output.accept(ModItems.RABBIT_STRIPS.get());
                        output.accept(ModItems.SALTED_RABBIT_STRIPS.get());
                        output.accept(ModItems.RABBIT_JERKY.get());
                        output.accept(ModItems.SALTED_ZOMBIE_FLESH.get());
                        output.accept(ModItems.ZOMBIE_JERKY.get());

                        // Meat Adjacent
                        output.accept(ModItems.FRIED_EGG.get());
                        output.accept(ModItems.BACON_AND_EGG.get());

                        // Juices
                        output.accept(ModItems.LEMON_JUICE.get());
                        output.accept(ModItems.LIME_JUICE.get());
                        output.accept(ModItems.ORANGE_JUICE.get());
                        output.accept(ModItems.APPLE_JUICE.get());
                        output.accept(ModItems.CARROT_JUICE.get());
                        output.accept(ModItems.PUMPKIN_JUICE.get());
                        output.accept(ModItems.TOMATO_JUICE.get());
                        output.accept(ModItems.MELON_JUICE.get());
                        output.accept(ModItems.SWEET_BERRY_JUICE.get());
                        output.accept(ModItems.BLUEBERRY_JUICE.get());
                        output.accept(ModItems.BLACKBERRY_JUICE.get());
                        output.accept(ModItems.MANGO_JUICE.get());

                        // Drinks
                        output.accept(ModItems.LEMONADE.get());

                        // Oils
                        output.accept(ModItems.SUNFLOWER_OIL.get());

                        // Sauces
                        output.accept(ModItems.MAYONNAISE.get());
                        output.accept(ModItems.AIOLI.get());

                        // Cake Related Items
                        output.accept(ModItems.PLAIN_CAKE_MIX.get());
                        output.accept(ModItems.HONEY_CAKE_MIX.get());
                        output.accept(ModItems.APPLE_CAKE_MIX.get());
                        output.accept(ModItems.BERRY_CAKE_MIX.get());
                        output.accept(ModItems.ORANGE_CAKE_MIX.get());
                        output.accept(ModItems.BANANA_CAKE_MIX.get());
                        output.accept(ModItems.CHOCOLATE_CAKE_MIX.get());
                        output.accept(ModItems.BAKED_PLAIN_CAKE.get());
                        output.accept(ModItems.BAKED_HONEY_CAKE.get());
                        output.accept(ModItems.BAKED_APPLE_CAKE.get());
                        output.accept(ModItems.BAKED_BERRY_CAKE.get());
                        output.accept(ModItems.BAKED_ORANGE_CAKE.get());
                        output.accept(ModItems.BAKED_BANANA_CAKE.get());
                        output.accept(ModItems.BAKED_CHOCOLATE_CAKE.get());

                        // Sandwich Related Items
                        output.accept(ModItems.DOUGH.get());
                        output.accept(ModItems.SLICED_BREAD.get());
                        output.accept(ModItems.TOAST.get());
                        output.accept(ModItems.BLT_SANDWICH.get());
                        output.accept(ModItems.STEAK_SANDWICH.get());

                        // Miscellaneous
                        output.accept(ModItems.PEPPERCORN.get());
                        output.accept(ModItems.DRIED_PEPPERCORN.get());
                        output.accept(ModItems.SALT.get());
                        output.accept(ModItems.GROUND_SALT.get());
                        output.accept(ModItems.GROUND_PEPPER.get());
                        output.accept(ModItems.WHEAT_FLOUR.get());
                        output.accept(ModItems.GROUND_COCOA.get());

                        // Seed Items
                        output.accept(ModItems.LETTUCE_SEEDS.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModItems.BROWN_ONION_SEEDS.get());
                        output.accept(ModItems.RED_ONION_SEEDS.get());
                        output.accept(ModItems.GARLIC_SEEDS.get());

                        // - Blocks -
                        // Drying Racks
                        output.accept(ModBlocks.OAK_DRYING_RACK.get());
                        output.accept(ModBlocks.SPRUCE_DRYING_RACK.get());
                        output.accept(ModBlocks.BIRCH_DRYING_RACK.get());
                        output.accept(ModBlocks.JUNGLE_DRYING_RACK.get());
                        output.accept(ModBlocks.DARK_OAK_DRYING_RACK.get());
                        output.accept(ModBlocks.ACACIA_DRYING_RACK.get());
                        output.accept(ModBlocks.MANGROVE_DRYING_RACK.get());
                        output.accept(ModBlocks.CHERRY_DRYING_RACK.get());
                        output.accept(ModBlocks.CRIMSON_DRYING_RACK.get());
                        output.accept(ModBlocks.WARPED_DRYING_RACK.get());

                        // Ores
                        output.accept(ModBlocks.SALT_ORE.get());

                        // Tree Related Blocks
                        output.accept(ModBlocks.APPLE_LEAVES.get());
                        output.accept(ModBlocks.LEMON_LEAVES.get());
                        output.accept(ModBlocks.LIME_LEAVES.get());
                        output.accept(ModBlocks.ORANGE_LEAVES.get());
                        output.accept(ModBlocks.MANGO_LEAVES.get());
                        output.accept(ModBlocks.BANANA_LEAVES.get());
                        output.accept(ModBlocks.PEPPERCORN_LEAVES.get());
                        output.accept(ModBlocks.APPLE_SAPLING.get());
                        output.accept(ModBlocks.LEMON_SAPLING.get());
                        output.accept(ModBlocks.LIME_SAPLING.get());
                        output.accept(ModBlocks.ORANGE_SAPLING.get());
                        output.accept(ModBlocks.MANGO_SAPLING.get());
                        output.accept(ModBlocks.BANANA_SAPLING.get());
                        output.accept(ModBlocks.PEPPERCORN_SAPLING.get());


                        // Cake Blocks
                        output.accept(ModBlocks.HONEY_CAKE.get());
                        output.accept(ModBlocks.APPLE_CAKE.get());
                        output.accept(ModBlocks.BERRY_CAKE.get());
                        output.accept(ModBlocks.ORANGE_CAKE.get());
                        output.accept(ModBlocks.BANANA_CAKE.get());
                        output.accept(ModBlocks.CHOCOLATE_CAKE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
