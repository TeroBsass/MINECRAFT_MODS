package net.redinsi.redinsimod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redinsi.redinsimod.RedinsiMod;
import net.redinsi.redinsimod.item.custom.Pseudostone;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.lwjgl.system.CallbackI;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RedinsiMod.MOD_ID);

    public static final RegistryObject<Item> METH = ITEMS.register("meth",
            () -> new Item(new Item.Properties()
                    .maxStackSize(16)
                    .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> METH_M = ITEMS.register("meth_m",
            () -> new Item(new Item.Properties()
                    .maxStackSize(16)
                    .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> PSEUDO = ITEMS.register("pseudo",
            () -> new Pseudostone(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)
            .maxDamage(8)));
    public static final RegistryObject<Item> FLASK = ITEMS.register("flask",
            () -> new Item(new Item.Properties()
                .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> METH_BAG = ITEMS.register("meth_bag", () -> new Item(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> METH_M_BAG =ITEMS.register("meth_m_bag", () -> new Item(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> METH_PACK = ITEMS.register("meth_pack", () -> new Item(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> METH_M_PACK = ITEMS.register("meth_m_pack",() -> new Item(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)));
    public static final RegistryObject<Item> PSEUDO_PACK = ITEMS.register("pseudo_pack", () -> new Item(new Item.Properties()
            .group(ModItemGroup.BAD_GROUP)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
