package com.bewitchment.registry.event;

import java.util.Random;

import com.bewitchment.registry.ModBlocks;
import com.bewitchment.registry.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockDropHandler
{
	@SubscribeEvent
	public void harvestDrops(HarvestDropsEvent event)
	{
		replaceDrop(event, ModBlocks.ore_alexandrite, new ItemStack(ModItems.gem_alexandrite, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_amethyst, new ItemStack(ModItems.gem_amethyst, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_bloodstone, new ItemStack(ModItems.gem_bloodstone, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_garnet, new ItemStack(ModItems.gem_garnet, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_jasper, new ItemStack(ModItems.gem_jasper, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_malachite, new ItemStack(ModItems.gem_malachite, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_nuummite, new ItemStack(ModItems.gem_nuummite, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_tigers_eye, new ItemStack(ModItems.gem_tigers_eye, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
		replaceDrop(event, ModBlocks.ore_tourmaline, new ItemStack(ModItems.gem_tourmaline, fortuneDrop(event.getFortuneLevel(), event.getWorld().rand)));
	}
	
	private void replaceDrop(HarvestDropsEvent event, Block block, ItemStack out)
	{
		if (event.getState().getBlock() == block && !event.isSilkTouching())
		{
			event.getDrops().clear();
			event.getDrops().add(out);
		}
	}
	
	private int fortuneDrop(int fortune, Random rand)
	{
		return fortune > 0 ? Math.max(0, rand.nextInt(fortune + 2) - 1) + 1 : 1;
	}
}