package net.redinsi.redinsimod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static net.redinsi.redinsimod.item.custom.Pseudostone.lightEntityOnFire;

public class Pseudo_stoneBlock extends Block {
    public Pseudo_stoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack p_190948_1_, @Nullable IBlockReader p_190948_2_, List<ITextComponent> tooltip, ITooltipFlag p_190948_4_) {

        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.redinsimod.pseudo_bag_shift"));
        }else {
            tooltip.add(new TranslationTextComponent("tooltip.redinsimod.pseudo_bag"));
        }

        super.addInformation(p_190948_1_, p_190948_2_, tooltip, p_190948_4_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_,
                                             PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if(!p_225533_2_.isRemote()) {
            if(p_225533_5_ == Hand.MAIN_HAND) {
                System.out.println("main");
            }
            if(p_225533_5_ == Hand.OFF_HAND) {
                System.out.println("off");
            }
        }


        return super.onBlockActivated(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState p_196270_1_, World p_196270_2_, BlockPos p_196270_3_, PlayerEntity p_196270_4_) {

        if(!p_196270_2_.isRemote()) {
            System.out.println("left-clicked");
        }
    }


    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        lightEntityOnFire(entityIn, 5);
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
