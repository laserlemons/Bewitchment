package com.bewitchment.core;

import com.bewitchment.registry.IOreName;
import com.bewitchment.registry.ModBlocks;
import com.bewitchment.registry.ModItems;
import com.bewitchment.registry.event.BlockDropHandler;
import com.bewitchment.registry.gen.WorldGenCoquina;
import com.bewitchment.registry.gen.WorldGenOres;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy
{
	public ModConfig config;
	
	public final CreativeTabs tab_blocks = new CreativeTabs(Main.MOD_ID + "_blocks")
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ModBlocks.block_alexandrite);
		}
	};
	
	public final CreativeTabs tab_items = new CreativeTabs(Main.MOD_ID + "_items")
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(ModItems.aconitum);
		}
	};
	
	public void preInit(FMLPreInitializationEvent event)
	{
		this.config = new ModConfig(event.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent event)
	{
		for (Block block : ModBlocks.REGISTRY) if (block instanceof IOreName) for (String ore : ((IOreName) block).getOreNames()) OreDictionary.registerOre(ore, block);
		for (Item item : ModItems.REGISTRY) if (item instanceof IOreName) for (String ore : ((IOreName) item).getOreNames()) OreDictionary.registerOre(ore, item);
		ModBlocks.crop_aconitum.setSeed(ModItems.seed_aconitum).setCrop(ModItems.aconitum);
		ModBlocks.crop_asphodel.setSeed(ModItems.seed_asphodel).setCrop(ModItems.asphodel);
		ModBlocks.crop_belladonna.setSeed(ModItems.seed_belladonna).setCrop(ModItems.belladonna);
		ModBlocks.crop_chrysanthemum.setSeed(ModItems.seed_chrysanthemum).setCrop(ModItems.chrysanthemum);
		ModBlocks.crop_garlic.setSeed(ModItems.seed_garlic).setCrop(ModItems.garlic);
		ModBlocks.crop_ginger.setSeed(ModItems.seed_ginger).setCrop(ModItems.ginger);
		ModBlocks.crop_hellebore.setSeed(ModItems.seed_hellebore).setCrop(ModItems.hellebore);
		ModBlocks.crop_kelp.setSeed(ModItems.seed_kelp).setCrop(ModItems.kelp);
		ModBlocks.crop_kenaf.setSeed(ModItems.seed_kenaf).setCrop(ModItems.kenaf);
		ModBlocks.crop_lavender.setSeed(ModItems.seed_lavender).setCrop(ModItems.lavender);
		ModBlocks.crop_mandrake.setSeed(ModItems.seed_mandrake).setCrop(ModItems.mandrake_root);
		ModBlocks.crop_mint.setSeed(ModItems.seed_mint).setCrop(ModItems.mint);
		ModBlocks.crop_sagebrush.setSeed(ModItems.seed_sagebrush).setCrop(ModItems.sagebrush);
		ModBlocks.crop_silphium.setSeed(ModItems.seed_silphium).setCrop(ModItems.silphium);
		ModBlocks.crop_thistle.setSeed(ModItems.seed_thistle).setCrop(ModItems.thistle);
		ModBlocks.crop_tulsi.setSeed(ModItems.seed_tulsi).setCrop(ModItems.tulsi);
		ModBlocks.crop_white_sage.setSeed(ModItems.seed_white_sage).setCrop(ModItems.white_sage);
		ModBlocks.crop_wormwood.setSeed(ModItems.seed_wormwood).setCrop(ModItems.wormwood);
		ModBlocks.leaves_cypress.drop = Item.getItemFromBlock(ModBlocks.sapling_cypress);
		ModBlocks.leaves_elder.drop = Item.getItemFromBlock(ModBlocks.sapling_elder);
		ModBlocks.leaves_juniper.drop = Item.getItemFromBlock(ModBlocks.sapling_juniper);
		ModBlocks.leaves_yew.drop = Item.getItemFromBlock(ModBlocks.sapling_yew);
		this.registerEventHandlers();
		this.registerWorldGenerators();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	private void registerEventHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new BlockDropHandler());
	}
	
	private void registerWorldGenerators()
	{
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCoquina(), 0);
	}
	
	public void registerTexture(Item item)
	{
	}
	
	public boolean isFancyGraphicsEnabled()
	{
		return false;
	}
}