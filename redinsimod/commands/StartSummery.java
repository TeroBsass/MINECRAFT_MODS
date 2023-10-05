package net.redinsi.redinsimod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
public class StartSummery implements Command<CommandSource> {
    public static final StartSummery CMD = new StartSummery();
    public static boolean onEvent = false;
    public static boolean isSaying = false;
    public static boolean startingOn = false;

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralArgumentBuilder<CommandSource> start_summery_russ = Commands.literal("start_summery")
                .requires(commandSource -> commandSource.hasPermissionLevel(0))
                .executes(CMD);
        dispatcher.register(start_summery_russ);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if(!isSaying) {
            context.getSource().sendFeedback(ITextComponent.getTextComponentOrEmpty(TextFormatting.GOLD + "[" + TextFormatting.YELLOW + "Walter White" + TextFormatting.GOLD + "]" + TextFormatting.WHITE + "  Hello, I need meth cook table."), true);
            context.getSource().sendFeedback(ITextComponent.getTextComponentOrEmpty(TextFormatting.GOLD + "[" + TextFormatting.YELLOW + "Walter White" + TextFormatting.GOLD + "]" + TextFormatting.WHITE + "  For give me something, you need get it in right hand and click right mouse button!!"), true);
            onEvent = true;
            isSaying = true;
            startingOn = true;
        }
        return 0;
    }
}
