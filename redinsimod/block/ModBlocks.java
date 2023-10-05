package net.redinsi.redinsimod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redinsi.redinsimod.RedinsiMod;
import net.redinsi.redinsimod.block.custom.MethCookBlock;
import net.redinsi.redinsimod.block.custom.Pseudo_stoneBlock;
import net.redinsi.redinsimod.item.ModItemGroup;
import net.redinsi.redinsimod.item.ModItems;

import java.util.Properties;
import java.util.function.Supplier;

import static net.minecraft.block.Blocks.IRON_BLOCK;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, RedinsiMod.MOD_ID);

    public static final RegistryObject<Block> METHYLAMINE = registryBlock("methylamine",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(5f)
                    ));
    public static final RegistryObject<Block> PSEUDO_BAG = registryBlock("pseudo_bag",
            () -> new Pseudo_stoneBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestTool(ToolType.AXE)
                    .setRequiresTool()
                    .hardnessAndResistance(2f)));

    public static final RegistryObject<Block> METH_COOK = registryBlock("meth_cook_table",
            () -> new MethCookBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(1f)));

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.BAD_GROUP)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
