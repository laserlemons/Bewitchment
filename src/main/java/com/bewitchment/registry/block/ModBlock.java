package com.bewitchment.registry.block;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.IOreName;
import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlock extends Block implements IOreName
{
	private final List<String> oreNames = new ArrayList<String>();
	
	public ModBlock(String name, CreativeTabs tab, Material mat, SoundType sound, float hardness, float resistance, String tool, int level, String... oreNames)
	{
		super(mat);
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(tab);
		this.setSoundType(sound);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, level);
		for (String ore : oreNames) this.oreNames.add(ore);
		ModBlocks.REGISTRY.add(this);
	}
	
	@Override
	public List<String> getOreNames()
	{
		return oreNames;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}