package net.truth.foodables.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ModDrink extends Item {
    public ModDrink(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;

        if (player instanceof ServerPlayer) CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);

        if (player != null) player.awardStat(Stats.ITEM_USED.get(this));

        if (this.isEdible()) {
            Objects.requireNonNull(player).eat(pLevel, pStack);
            if (pStack.isEmpty()) return new ItemStack(Items.GLASS_BOTTLE);
            player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }

        pEntityLiving.gameEvent(GameEvent.DRINK);
        return pStack;
    }
    @Override
    public @NotNull SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}
