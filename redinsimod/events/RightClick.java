package net.redinsi.redinsimod.events;

import net.redinsi.redinsimod.commands.StartSummery;
import net.redinsi.redinsimod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import java.util.Objects;

public class RightClick {
    @Mod.EventBusSubscriber(modid = "redinsimod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class RightClickEvent {

        @SubscribeEvent
        public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
            if(!StartSummery.startingOn) {
                ItemStack itemStack = event.getItemStack();
                if (itemStack.getItem() == ModItems.METH.get()) {
                    dealDamageToPlayer(event.getPlayer(), 3);
                    ItemStack heldItem = event.getPlayer().getHeldItemMainhand();
                    heldItem.shrink(1);
                    getEffects(event);
                }
                if (itemStack.getItem() == ModItems.METH_M.get()) {
                    dealDamageToPlayer(event.getPlayer(), 3);
                    ItemStack heldItem = event.getPlayer().getHeldItemMainhand();
                    heldItem.shrink(1);
                    getEffects(event);
                }
            }
        }
    }
    private static void dealDamageToPlayer(PlayerEntity player, float amount) {
        player.attackEntityFrom(DamageSource.GENERIC, amount);
    }

    private static void getEffects(PlayerInteractEvent.RightClickItem event) {
        event.getPlayer().addPotionEffect(new EffectInstance(Objects.requireNonNull(Effect.get(9)), 600, 6));
        event.getPlayer().addPotionEffect(new EffectInstance(Objects.requireNonNull(Effect.get(15)), 400, 4));
        event.getPlayer().addPotionEffect(new EffectInstance(Objects.requireNonNull(Effect.get(2)), 400, 4));
    }


}
