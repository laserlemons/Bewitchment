package com.bewitchment.registry.block;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.IOreName;
import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class ModBlockStairs extends BlockStairs implements IOreName
{
	private final List<String> oreNames = new ArrayList<String>();
	
	public ModBlockStairs(String name, CreativeTabs tab, Block original, String tool, int level, String... oreNames)
	{
		super(original.getDefaultState());
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(tab);
		this.setHarvestLevel(tool, level);
		if (original.getDefaultState().getMaterial() == Material.CARPET) Blocks.FIRE.setFireInfo(this, 60, 20);
		if (original.getDefaultState().getMaterial() == Material.CLOTH || original.getDefaultState().getMaterial() == Material.LEAVES) Blocks.FIRE.setFireInfo(this, 30, 60);
		if (original.getDefaultState().getMaterial() == Material.PLANTS) Blocks.FIRE.setFireInfo(this, 60, 100);
		if (original.getDefaultState().getMaterial() == Material.TNT || original.getDefaultState().getMaterial() == Material.VINE) Blocks.FIRE.setFireInfo(this, 15, 100);
		if (original.getDefaultState().getMaterial() == Material.WOOD) Blocks.FIRE.setFireInfo(this, 5, 20);
		for (String ore : oreNames) this.oreNames.add(ore);
		ModBlocks.REGISTRY.add(this);
	}
	
	@Override
	public List<String> getOreNames()
	{
		return oreNames;
	}
}