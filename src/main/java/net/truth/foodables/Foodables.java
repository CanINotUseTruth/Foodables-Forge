package net.truth.foodables;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.truth.foodables.block.ModBlocks;
import net.truth.foodables.block.custom.entity.ModBlockEntities;
import net.truth.foodables.item.ModCreativeModeTabs;
import net.truth.foodables.item.ModItems;
import net.truth.foodables.loot.ModLootModifiers;
import net.truth.foodables.recipe.ModRecipes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Foodables.MOD_ID)
public class Foodables
{
    public static final String MOD_ID = "foodables";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Foodables() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Minecraft Items
            ComposterBlock.COMPOSTABLES.put(Items.ROTTEN_FLESH, 0.3F);

            // Seeds
            ComposterBlock.COMPOSTABLES.put(ModItems.LETTUCE_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BROWN_ONION_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.RED_ONION_SEEDS.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.GARLIC_SEEDS.get(), 0.3F);

            // Saplings
            ComposterBlock.COMPOSTABLES.put(ModBlocks.APPLE_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.LEMON_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.LIME_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.ORANGE_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MANGO_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BANANA_SAPLING.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.PEPPERCORN_SAPLING.get().asItem(), 0.3F);

            // Leaves
            ComposterBlock.COMPOSTABLES.put(ModBlocks.APPLE_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.LEMON_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.LIME_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.ORANGE_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MANGO_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BANANA_LEAVES.get().asItem(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.PEPPERCORN_LEAVES.get().asItem(), 0.3F);

            // Fruit and Veggies
            ComposterBlock.COMPOSTABLES.put(ModItems.DRIED_PEPPERCORN.get(), 0.15F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PEPPERCORN.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BLACKBERRIES.get(), 0.3F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BAKED_APPLE.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BAKED_BEETROOT.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BAKED_PUMPKIN.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BAKED_CARROT.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.SLICED_RED_ONION.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.SLICED_BROWN_ONION.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_ONION.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.CARAMELIZED_ONION.get(), 0.5F);
            ComposterBlock.COMPOSTABLES.put(ModItems.PUMPKIN_SLICES.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.LETTUCE.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.GARLIC.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BROWN_ONION.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.RED_ONION.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.LEMON.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.LIME.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.ORANGE.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.MANGO.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.BANANA.get(), 0.65F);

            // Cakes
            ComposterBlock.COMPOSTABLES.put(ModBlocks.HONEY_CAKE.get().asItem(), 1.0F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.APPLE_CAKE.get().asItem(), 1.0F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BERRY_CAKE.get().asItem(), 1.0F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.ORANGE_CAKE.get().asItem(), 1.0F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.BANANA_CAKE.get().asItem(), 1.0F);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.CHOCOLATE_CAKE.get().asItem(), 1.0F);

            // Other
            ComposterBlock.COMPOSTABLES.put(ModItems.DOUGH.get(), 0.35F);
            ComposterBlock.COMPOSTABLES.put(ModItems.SLICED_BREAD.get(), 0.65F);
            ComposterBlock.COMPOSTABLES.put(ModItems.TOAST.get(), 0.65F);
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
