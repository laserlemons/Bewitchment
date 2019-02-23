package com.bewitchment.registry.item;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.registry.ModItems;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ModItemSeed extends ModItem implements IPlantable
{
	public final Block crop;
	public final List<Block> soil = new ArrayList<Block>();
	
	public ModItemSeed(String name, CreativeTabs tab, Block crop, Block... soil)
	{
		super(name, tab);
		this.crop = crop;
		for (Block block : soil) this.soil.add(block);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = world.getBlockState(pos);
        if (player.canPlayerEdit(pos.offset(face), face, stack) && soil.contains(state.getBlock()) && face == EnumFacing.UP && (this == ModItems.seed_kelp ? world.getBlockState(pos.up(2)).getBlock() == Blocks.WATER : true))
        {
            world.setBlockState(pos.up(), this.crop.getDefaultState());
            if (player instanceof EntityPlayerMP) CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), stack);
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else return EnumActionResult.FAIL;
    }
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}
	
	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return crop.getDefaultState();
	}
}