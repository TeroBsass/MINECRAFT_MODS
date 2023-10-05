package net.redinsi.redinsimod.summery_chat_activity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import static net.minecraft.util.text.TextFormatting.*;

public class ActiveSummeryKill {
    @SubscribeEvent
    public static void chatting(PlayerInteractEvent.RightClickItem event){
        World world = event.getWorld();
        PlayerEntity player = event.getPlayer();
        if(!world.isRemote()) {
            ITextComponent message1 = new StringTextComponent(GOLD + "[" + YELLOW + "Walter White" + GOLD + "]:" + WHITE + "  Kill");
            player.sendMessage(message1, player.getUniqueID());
        }
    }
}
