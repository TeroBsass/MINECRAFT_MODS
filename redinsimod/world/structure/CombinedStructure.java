package net.redinsi.redinsimod.world.structure;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.redinsi.redinsimod.world.structure.structures.HouseStructure;
import net.redinsi.redinsimod.world.structure.structures.HouseStructureTwo;

public class CombinedStructure extends Structure<NoFeatureConfig> {
    // Initialize this structure with a dedicated processor
    public CombinedStructure() {
        super();
        // More code here
    }

    @Override
    public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
        return CombinedStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seed) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seed);
        }

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistries,
                                   ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_,
                                   int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
            init(dynamicRegistries, );
        }

        public void init(DynamicRegistries dynamicRegistries, long seed, ChunkGenerator chunkGenerator,
                         TemplateManager templateManager,
                         int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
            // Call the init method on HouseStructure and HouseStructureTwo
            new HouseStructure.Sinit(dynamicRegistries, seed, chunkGenerator, templateManager, chunkX, chunkZ, biome, config);
            new HouseStructureTwo.Start().init(dynamicRegistries, seed, chunkGenerator, templateManager, chunkX+1, chunkZ, biome, config);
        }
    }

}
