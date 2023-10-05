package net.redinsi.redinsimod.world.biome;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.redinsi.redinsimod.RedinsiMod;
import net.redinsi.redinsimod.block.ModBlocks;

public class ModConfiguredSurfaceBuilders {
    public static ConfiguredSurfaceBuilder<?> RIFT_SURFACE = register("rift_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    ModBlocks.METH_COOK.get().getDefaultState(),
                    ModBlocks.PSEUDO_BAG.get().getDefaultState(),
                    ModBlocks.METHYLAMINE.get().getDefaultState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(RedinsiMod.MOD_ID, name), csb);
    }
}
