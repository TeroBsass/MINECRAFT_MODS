package net.redinsi.redinsimod.tailentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.redinsi.redinsimod.block.ModBlocks;
import net.redinsi.redinsimod.container.MethCookContainer;
import net.redinsi.redinsimod.data.recipes.MethCookRecipe;
import net.redinsi.redinsimod.data.recipes.ModRecipeTypes;
import net.redinsi.redinsimod.item.ModItems;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.Optional;

public class MethCookTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    public MethCookTile(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public MethCookTile() {
        this(ModTileEntities.METH_COOK_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(2) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }


            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap,
                                             @Nullable Direction side) {

        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    private void strikeMethCooking() {
        if(!this.world.isRemote()) {
            EntityType.LIGHTNING_BOLT.spawn((ServerWorld)world, null, null,
                    pos, SpawnReason.TRIGGERED, true, true);
        }
    }

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setInventorySlotContents(i, itemHandler.getStackInSlot(i));
        }

        Optional<MethCookRecipe> recipe = world.getRecipeManager()
                .getRecipe(ModRecipeTypes.METH_COOK_RECIPE, inv, world);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getRecipeOutput();

            if(iRecipe.getWeather().equals(MethCookRecipe.Weather.CLEAR) &&
                    !world.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(MethCookRecipe.Weather.RAIN) &&
                    world.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(MethCookRecipe.Weather.THUNDERING) &&
                    world.isThundering()) {
                strikeMethCooking();
                craftTheItem(output);
            }

            markDirty();
        });
    }

    private void craftTheItem(ItemStack output) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.insertItem(1, output, false);
    }

    @Override
    public void tick() {
        if(world.isRemote)
            return;
        craft();
    }
}
