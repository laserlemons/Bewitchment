package com.bewitchment.registry;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.block.ModBlock;
import com.bewitchment.registry.block.ModBlockCrop;
import com.bewitchment.registry.block.ModBlockExp;
import com.bewitchment.registry.block.ModBlockLeaves;
import com.bewitchment.registry.block.ModBlockPillar;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Main.MOD_ID)
public class ModBlocks
{
	public static final List<Block> REGISTRY = new ArrayList<Block>();
	
	//Crop
	public static final ModBlockCrop crop_aconitum = new ModBlockCrop("crop_aconitum", 3);
	public static final ModBlockCrop crop_asphodel = new ModBlockCrop("crop_asphodel", 4);
	public static final ModBlockCrop crop_belladonna = new ModBlockCrop.Belladonna("crop_belladonna", 4);
	public static final ModBlockCrop crop_chrysanthemum = new ModBlockCrop("crop_chrysanthemum", 3);
	public static final ModBlockCrop crop_garlic = new ModBlockCrop("crop_garlic", 3);
	public static final ModBlockCrop crop_ginger = new ModBlockCrop("crop_ginger", 3);
	public static final ModBlockCrop crop_hellebore = new ModBlockCrop("crop_hellebore", 3);
	public static final ModBlockCrop crop_infested_wheat = new ModBlockCrop("crop_infested_wheat", 6);
	public static final ModBlockCrop crop_kelp = new ModBlockCrop.Kelp("crop_kelp", 7);
	public static final ModBlockCrop crop_kenaf = new ModBlockCrop.Kenaf("crop_kenaf", 4);
	public static final ModBlockCrop crop_lavender = new ModBlockCrop("crop_lavender", 3);
	public static final ModBlockCrop crop_mandrake = new ModBlockCrop("crop_mandrake", 3);
	public static final ModBlockCrop crop_mint = new ModBlockCrop.Mint("crop_mint", 3);
	public static final ModBlockCrop crop_sagebrush = new ModBlockCrop("crop_sagebrush", 3);
	public static final ModBlockCrop crop_silphium = new ModBlockCrop.Silphium("crop_silphium", 6);
	public static final ModBlockCrop crop_thistle = new ModBlockCrop.Thistle("crop_thistle", 3);
	public static final ModBlockCrop crop_tulsi = new ModBlockCrop("crop_tulsi", 3);
	public static final ModBlockCrop crop_white_sage = new ModBlockCrop("crop_white_sage", 3);
	public static final ModBlockCrop crop_wormwood = new ModBlockCrop("crop_wormwood", 6);
	
	//Material Blocks
	public static final Block block_silver = new ModBlock("block_silver", Main.proxy.tab_blocks, Material.IRON, SoundType.METAL, 5, 30, "pickaxe", 1, "blockSilver");
	public static final Block block_alexandrite = new ModBlock("block_alexandrite", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockAlexandrite");
	public static final Block block_amethyst = new ModBlock("block_amethyst", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockAmethyst");
	public static final Block block_bloodstone = new ModBlock("block_bloodstone", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockBloodstone");
	public static final Block block_garnet = new ModBlock("block_garnet", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockGarnet");
	public static final Block block_jasper = new ModBlock("block_jasper", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockJasper");
	public static final Block block_malachite = new ModBlock("block_malachite", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockMalachite");
	public static final Block block_nuummite = new ModBlock("block_nuummite", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockNuummite");
	public static final Block block_tigers_eye = new ModBlock("block_tigers_eye", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockTigersEye");
	public static final Block block_tourmaline = new ModBlock("block_tourmaline", Main.proxy.tab_blocks, Material.GLASS, SoundType.GLASS, 5, 30, "pickaxe", 1, "blockTourmaline");
	
	//Ores
	public static final Block ore_silver = new ModBlock("ore_silver", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreSilver");
	public static final Block ore_salt = new ModBlockExp("ore_salt", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreSalt");
	public static final Block ore_alexandrite = new ModBlockExp("ore_alexandrite", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreAlexandrite");
	public static final Block ore_amethyst = new ModBlockExp("ore_amethyst", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreAmethyst");
	public static final Block ore_bloodstone = new ModBlockExp("ore_bloodstone", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreBloodstone");
	public static final Block ore_garnet = new ModBlockExp("ore_garnet", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreGarnet");
	public static final Block ore_jasper = new ModBlockExp("ore_jasper", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreJasper");
	public static final Block ore_malachite = new ModBlockExp("ore_malachite", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreMalachite");
	public static final Block ore_nuummite = new ModBlockExp("ore_nuummite", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreNuummite");
	public static final Block ore_tigers_eye = new ModBlockExp("ore_tigers_eye", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreTigersEye");
	public static final Block ore_tourmaline = new ModBlockExp("ore_tourmaline", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 3, 15, "pickaxe", 1, "oreTourmaline");
	
	//Trees
	public static final Block log_cypress = new ModBlockPillar("log_cypress", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_elder = new ModBlockPillar("log_elder", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_juniper = new ModBlockPillar("log_juniper", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_yew = new ModBlockPillar("log_yew", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block leaves_cypress = new ModBlockLeaves("leaves_cypress", Main.proxy.tab_blocks, "treeLeaves");
	public static final Block leaves_elder = new ModBlockLeaves("leaves_elder", Main.proxy.tab_blocks, "treeLeaves");
	public static final Block leaves_juniper = new ModBlockLeaves("leaves_juniper", Main.proxy.tab_blocks, "treeLeaves");
	public static final Block leaves_yew = new ModBlockLeaves("leaves_yew", Main.proxy.tab_blocks, "treeLeaves");
	public static final Block planks_cypress = new ModBlock("planks_cypress", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_elder = new ModBlock("planks_elder", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_juniper = new ModBlock("planks_juniper", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_yew = new ModBlock("planks_yew", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	
	@SubscribeEvent
	public static void register(Register<Block> event)
	{
		for (Block block : REGISTRY) event.getRegistry().register(block);
	}
}