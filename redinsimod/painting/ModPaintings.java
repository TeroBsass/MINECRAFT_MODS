package net.redinsi.redinsimod.painting;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redinsi.redinsimod.RedinsiMod;

public class ModPaintings {
    public static final DeferredRegister<PaintingType> PAINTING_TYPES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, RedinsiMod.MOD_ID);

    public static final RegistryObject<PaintingType> BREAKING_BAD =
            PAINTING_TYPES.register("breaking_bad_painting",
                    () -> new PaintingType(16 * 8, 16 * 3));

    public static final RegistryObject<PaintingType> BREAKING_BAD_2 =
            PAINTING_TYPES.register("breaking_bad_painting_2",
                    () -> new PaintingType(16 * 5, 16 * 4));


    public static void register(IEventBus eventBus) {
        PAINTING_TYPES.register(eventBus);
    }
}
