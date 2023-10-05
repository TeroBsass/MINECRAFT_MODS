package net.redinsi.redinsimod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameType;

public class GC_command implements Command<CommandSource> {

    private static final GC_command CMD = new GC_command();

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> hiCommand = Commands.literal("gc")
                .requires(commandSource -> commandSource.hasPermissionLevel(0))
                .executes(CMD);
        dispatcher.register(hiCommand);
    }
    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        context.getSource().sendFeedback(ITextComponent.getTextComponentOrEmpty("gamemode creative"), true);
        context.getSource().asPlayer().setGameType(GameType.CREATIVE);
        return 0;
    }
}
