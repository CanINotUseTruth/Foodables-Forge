package net.truth.foodables.block.custom.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.truth.foodables.block.custom.DryingRackBlock;
import net.truth.foodables.block.custom.entity.DryingRackEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DryingRackEntityRenderer implements BlockEntityRenderer<DryingRackEntity> {

    public DryingRackEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(DryingRackEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.getRenderStack();

        Direction dir = pBlockEntity.getBlockState().getValue(DryingRackBlock.FACING);

        pPoseStack.pushPose();
        switch (dir) {
            case NORTH -> pPoseStack.translate(0.5F, 0.4375F, 0.90625F);
            case SOUTH -> {
                pPoseStack.translate(0.5F, 0.4375F, 0.09500F);
                pPoseStack.mulPose(Axis.YN.rotationDegrees(180F));
            }
            case EAST -> {
                pPoseStack.translate(0.09500F, 0.4375F, 0.5F);
                pPoseStack.mulPose(Axis.YN.rotationDegrees(-270F));
            }
            case WEST -> {
                pPoseStack.translate(0.90625F, 0.4375F, 0.5F);
                pPoseStack.mulPose(Axis.YN.rotationDegrees(-90F));
            }
        }

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(Objects.requireNonNull(pBlockEntity.getLevel()),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
