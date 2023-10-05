package net.redinsi.redinsimod.data.recipes;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.redinsi.redinsimod.RedinsiMod;
import net.minecraft.util.registry.Registry;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RedinsiMod.MOD_ID);

    public static final RegistryObject<MethCookRecipe.Serializer> METH_COOKING_SERIALIZER =
            RECIPE_SERIALIZER.register("meth_cooking", MethCookRecipe.Serializer::new);

    public static final IRecipeType<MethCookRecipe> METH_COOK_RECIPE =
            new MethCookRecipe.MethCookRecipeType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
        Registry.register(Registry.RECIPE_TYPE, MethCookRecipe.TYPE_ID, METH_COOK_RECIPE);
    }
}
