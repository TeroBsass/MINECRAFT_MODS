package net.redinsi.redinsimod.tailentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redinsi.redinsimod.RedinsiMod;
import net.redinsi.redinsimod.block.ModBlocks;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES
            = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RedinsiMod.MOD_ID);

    public static RegistryObject<TileEntityType<MethCookTile>> METH_COOK_TILE
            = TILE_ENTITIES.register("meth_cook_tile",
                () -> TileEntityType.Builder.create(
                        MethCookTile::new, ModBlocks.METH_COOK.get())
                        .build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
