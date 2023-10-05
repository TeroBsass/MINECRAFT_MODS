package net.redinsi.redinsimod.data.recipes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.redinsi.redinsimod.RedinsiMod;

public interface iMethCookRecipe extends IRecipe<IInventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(RedinsiMod.MOD_ID, "meth_cooking");

    @Override
    default IRecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return true;
    }

    @Override
    default boolean isDynamic(){
        return true;
    }
}
