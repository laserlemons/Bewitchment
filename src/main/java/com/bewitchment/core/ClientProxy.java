package com.bewitchment.core;

import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		ModelLoader.setCustomStateMapper(ModBlocks.crop_kelp, new StateMap.Builder().ignore(BlockLiquid.LEVEL).build());
	}
	
	@Override
	public void registerTexture(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public boolean isFancyGraphicsEnabled()
	{
		return Minecraft.getMinecraft().gameSettings.fancyGraphics;
	}
}