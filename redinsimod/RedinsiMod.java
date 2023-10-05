package net.redinsi.redinsimod;

import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.redinsi.redinsimod.block.ModBlocks;
import net.redinsi.redinsimod.commands.ModCommands;
import net.redinsi.redinsimod.container.ModContainers;
import net.redinsi.redinsimod.data.recipes.ModRecipeTypes;
import net.redinsi.redinsimod.events.ModEvents;
import net.redinsi.redinsimod.item.ModItems;
import net.redinsi.redinsimod.painting.ModPaintings;
import net.redinsi.redinsimod.tailentity.ModTileEntities;
import net.redinsi.redinsimod.world.biome.ModBiomes;
import net.redinsi.redinsimod.world.biome.ModBiomesDatapack;
import net.redinsi.redinsimod.world.structure.ModStructures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.redinsi.redinsimod.screen.MethCookScreen;


@Mod(RedinsiMod.MOD_ID)
public class RedinsiMod
{
    public static final String MOD_ID = "redinsimod";
    private static final Logger LOGGER = LogManager.getLogger();

    public RedinsiMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModCommands.register();
        ModEvents.register();
        ModContainers.register(eventBus);
        ModRecipeTypes.register(eventBus);
        ModPaintings.register(eventBus);
        ModStructures.register(eventBus);
        ModBiomes.register(eventBus);
        ModBiomesDatapack.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModStructures.setupStructures();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ScreenManager.registerFactory(ModContainers.METH_COOK_CONTAINER.get(), MethCookScreen::new);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("redinsimod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("HELLO from Register Block");
        }
    }
}
