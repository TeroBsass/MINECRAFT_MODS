package net.redinsi.redinsimod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCommands {
    @SubscribeEvent
    public static void onRegisterCommandEvent(RegisterCommandsEvent event){
        CommandDispatcher<CommandSource> commandDispatcher = event.getDispatcher();
        GS_command.register(commandDispatcher);
        GC_command.register(commandDispatcher);
        GA_command.register(commandDispatcher);
        GSPEC_command.register(commandDispatcher);
        StartSummery.register(commandDispatcher);
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(ModCommands.class);
    }
}
