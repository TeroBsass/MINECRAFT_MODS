package net.redinsi.redinsimod.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {
    @SubscribeEvent
    public static void onRegisterEvents(PlayerInteractEvent.RightClickItem event) {
        RightClick.RightClickEvent.onRightClickItem(event);
        StartSummeryEvent.RightClickEvent.onCommandStartSummery(event);
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
    }
}
