package com.bewitchment.registry.block;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.IOreName;
import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockFence extends BlockFence implements IOreName
{
	private final List<String> oreNames = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public ModBlockFence(String name, Block base, String... oreNames)
	{
		super(base.getDefaultState().getMaterial(), base.getDefaultState().getMaterial().getMaterialMapColor());
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(Main.proxy.tab);
		this.setHardness(base.getBlockHardness(null, null, null));
		this.setResistance(base.getExplosionResistance(null)*5);
		this.setHarvestLevel(base.getHarvestTool(base.getDefaultState()), base.getHarvestLevel(base.getDefaultState()));
		this.setSoundType(base.getSoundType());
		if (base.getDefaultState().getMaterial() == Material.CARPET) Blocks.FIRE.setFireInfo(this, 60, 20);
		if (base.getDefaultState().getMaterial() == Material.CLOTH || base.getDefaultState().getMaterial() == Material.LEAVES) Blocks.FIRE.setFireInfo(this, 30, 60);
		if (base.getDefaultState().getMaterial() == Material.PLANTS) Blocks.FIRE.setFireInfo(this, 60, 100);
		if (base.getDefaultState().getMaterial() == Material.TNT || base.getDefaultState().getMaterial() == Material.VINE) Blocks.FIRE.setFireInfo(this, 15, 100);
		if (base.getDefaultState().getMaterial() == Material.WOOD) Blocks.FIRE.setFireInfo(this, 5, 20);
		if (base.getDefaultState().getMaterial() == Material.ICE) this.setDefaultSlipperiness(0.98f);
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
		return getDefaultState().getMaterial() == Material.ICE || getDefaultState().getMaterial() == Material.GLASS ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.CUTOUT;
	}
}