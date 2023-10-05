package net.redinsi.redinsimod.summery_chat_activity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.minecraft.util.text.TextFormatting.*;

public class AfterPseudoChattingActivity {
    @SubscribeEvent
    public static void chatting(PlayerInteractEvent.RightClickItem event){
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        if(!world.isRemote()) {
            ITextComponent message1 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  Ok, you ready for main part.");
            ITextComponent message2 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  Our town in drug revolution.I was in this too, but not now.You must start deal drugs and come very big person.");
            ITextComponent message3 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  You must do it - for one day kill all drug dealers in the america, so you must give me one stack of meth or methylamine meth quickly.");
            ITextComponent message4 = new StringTextComponent(GOLD + "[" + YELLOW + "Волтер Вайт" + GOLD + "]" + WHITE + "  And i give you something cool!");
            player.sendMessage(message1, player.getUniqueID());
            player.sendMessage(message2, player.getUniqueID());
            player.sendMessage(message3, player.getUniqueID());
            player.sendMessage(message4, player.getUniqueID());
        }
    }
}
