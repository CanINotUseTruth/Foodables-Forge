package net.truth.foodables.block.custom.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Foodables.MOD_ID);

    public static final RegistryObject<BlockEntityType<DryingRackEntity>> DRYING_RACK_BE =
            BLOCK_ENTITIES.register("drying_rack", () ->
                    BlockEntityType.Builder.of(DryingRackEntity::new,
                            ModBlocks.OAK_DRYING_RACK.get(),
                            ModBlocks.BIRCH_DRYING_RACK.get(),
                            ModBlocks.SPRUCE_DRYING_RACK.get(),
                            ModBlocks.JUNGLE_DRYING_RACK.get(),
                            ModBlocks.ACACIA_DRYING_RACK.get(),
                            ModBlocks.DARK_OAK_DRYING_RACK.get(),
                            ModBlocks.MANGROVE_DRYING_RACK.get(),
                            ModBlocks.CHERRY_DRYING_RACK.get(),
                            ModBlocks.CRIMSON_DRYING_RACK.get(),
                            ModBlocks.WARPED_DRYING_RACK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
