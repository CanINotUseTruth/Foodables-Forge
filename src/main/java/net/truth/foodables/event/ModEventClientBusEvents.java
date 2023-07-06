package net.truth.foodables.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.truth.foodables.Foodables;
import net.truth.foodables.block.custom.entity.ModBlockEntities;
import net.truth.foodables.block.custom.entity.renderer.DryingRackEntityRenderer;

@Mod.EventBusSubscriber(modid = Foodables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.DRYING_RACK_BE.get(),
                DryingRackEntityRenderer::new);
    }
}
