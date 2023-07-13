package net.truth.foodables.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.truth.foodables.Foodables;
import net.truth.foodables.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = Foodables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FISHERMAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.SQUID.get(), 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1), stack, 16, 2, 0.1f
            ));

        }

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.COMPOST.get(), 4);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 8, 12, 0.1f
            ));

        }
    }

    @SubscribeEvent
    public static void addComposterDrop(PlayerInteractEvent event) {
        BlockState blockState = event.getLevel().getBlockState(event.getPos());
        if(blockState.getBlock() instanceof ComposterBlock && !event.getLevel().isClientSide()) {
            if (isRightClick(event) && blockState.getValue(ComposterBlock.LEVEL) == 8 && Math.random() * 100 >= 50) {
                Vec3 vec3 = Vec3.atLowerCornerWithOffset(event.getPos(), 0.5D, 1.01D, 0.5D).offsetRandom(event.getLevel().random, 0.7F);
                ItemEntity itementity = new ItemEntity(event.getLevel(), vec3.x(), vec3.y(), vec3.z(), new ItemStack(ModItems.COMPOST.get()));
                itementity.setDefaultPickUpDelay();
                event.getLevel().addFreshEntity(itementity);
            }
        }
    }

    private static boolean isRightClick(PlayerInteractEvent event) {
        return event instanceof PlayerInteractEvent.RightClickBlock || event instanceof PlayerInteractEvent.RightClickEmpty ||
                event instanceof PlayerInteractEvent.RightClickItem;
    }
}
