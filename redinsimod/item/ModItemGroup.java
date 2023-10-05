package net.redinsi.redinsimod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup BAD_GROUP = new ItemGroup("redinsiModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.METH.get());
        }
    };
}
