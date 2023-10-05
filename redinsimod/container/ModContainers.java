package net.redinsi.redinsimod.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redinsi.redinsimod.RedinsiMod;

public class ModContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, RedinsiMod.MOD_ID);
    public static final RegistryObject<ContainerType<MethCookContainer>> METH_COOK_CONTAINER
            = CONTAINERS.register("meth_cook_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    World world = inv.player.getEntityWorld();
                    
                    return new MethCookContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}