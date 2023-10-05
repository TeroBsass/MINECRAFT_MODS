package net.redinsi.redinsimod.summery_chat_activity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import static net.minecraft.util.text.TextFormatting.*;

public class AfterMethCookChattingActivity {
    @SubscribeEvent
    public static void chatting(PlayerInteractEvent.RightClickItem event){
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        if(!world.isRemote()) {
            ITextComponent message1 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  Oh, you really do it, but now I need " + GOLD + "pseudo " + WHITE + ".");
            ITextComponent message2 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  After this we already can speak");
            player.sendMessage(message1, player.getUniqueID());
            player.sendMessage(message2, player.getUniqueID());
        }
    }
}
