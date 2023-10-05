package net.redinsi.redinsimod.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.redinsi.redinsimod.block.ModBlocks;
import net.redinsi.redinsimod.item.ModItems;
import net.redinsi.redinsimod.summery_chat_activity.ActiveSummeryKill;
import net.redinsi.redinsimod.summery_chat_activity.AfterMethCookChattingActivity;
import net.redinsi.redinsimod.summery_chat_activity.AfterPseudoChattingActivity;

import static net.minecraft.util.text.TextFormatting.*;
import static net.redinsi.redinsimod.commands.StartSummery.onEvent;

public class StartSummeryEvent {
    public static boolean commandNext = false;
    public static int numOfCommand = 1;

    public static int count = 0;
    public static int count2 = 0;

    @Mod.EventBusSubscriber(modid = "redinsimod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class RightClickEvent {
        @SubscribeEvent
        public static void onCommandStartSummery(PlayerInteractEvent.RightClickItem event) {
            if(onEvent) {
                ItemStack itemStack = event.getItemStack();
                PlayerEntity player = event.getPlayer();
                if(itemStack.getItem() == ModBlocks.METH_COOK.get().asItem()) {
                    ItemStack heldItem = player.getHeldItemMainhand();
                    heldItem.shrink(1);
                    commandNext = true;
                    onEvent = false;
                    count = 0;
                    count2 = 0;
                }
            }
            if(commandNext && numOfCommand == 1) {
                if(count == 0) {
                    AfterMethCookChattingActivity.chatting(event);
                }
                count = 1;
                PlayerEntity player = event.getPlayer();
                ItemStack itemStack = event.getItemStack();
                if(itemStack.getItem() == ModItems.PSEUDO.get()) {
                    ItemStack heldItem = player.getHeldItemMainhand();
                    heldItem.shrink(1);
                    numOfCommand = 2;
                    count = 0;
                    count2 = 0;
                }
            }
            if(commandNext && numOfCommand == 2) {
                if(count == 0) {
                    AfterPseudoChattingActivity.chatting(event);
                }
                count = 1;
                count2 = 0;
                PlayerEntity player = event.getPlayer();
                ItemStack itemStack = event.getItemStack();
                if(itemStack.getItem() == ModItems.METH.get() || itemStack.getItem() == ModItems.METH_M.get()) {
                    ItemStack heldItem = player.getHeldItemMainhand();
                    int itemStackCount = itemStack.getCount();
                    if(itemStackCount == 16) {
                        heldItem.shrink(16);
                        player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.PSEUDO_BAG.get().asItem()));
                        numOfCommand = 3;
                        count = 0;
                        count2 = 0;
                    }else {
                        if(count2 == 0) {
                            ITextComponent message1 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "No get more meth or methylamine meth!!!");
                            player.sendMessage(message1, player.getUniqueID());
                        }
                        count2 = 1;
                    }
                }
            }
            if(commandNext && numOfCommand == 3) {
                if(count == 0) {
                    ActiveSummeryKill.chatting(event);
                }
                count = 1;
                PlayerEntity player = event.getPlayer();
                ItemStack itemStack = event.getItemStack();
            }
        }
    }
}
