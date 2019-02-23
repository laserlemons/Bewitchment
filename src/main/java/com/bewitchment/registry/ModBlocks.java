package com.bewitchment.registry;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.block.ModBlock;
import com.bewitchment.registry.block.ModBlockCrop;
import com.bewitchment.registry.block.ModBlockExp;
import com.bewitchment.registry.block.ModBlockFence;
import com.bewitchment.registry.block.ModBlockLeaves;
import com.bewitchment.registry.block.ModBlockPillar;
import com.bewitchment.registry.block.ModBlockSapling;
import com.bewitchment.registry.block.ModBlockSlab;
import com.bewitchment.registry.block.ModBlockStairs;
import com.bewitchment.registry.block.util.BlockSaltBarrier;

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
	
	//No Item
	public static final Block salt_barrier = new BlockSaltBarrier("salt_barrier");
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
	public static final ModBlockCrop crop_silphium = new ModBlockCrop.Silphium("crop_silphium", 5);
	public static final ModBlockCrop crop_thistle = new ModBlockCrop.Thistle("crop_thistle", 3);
	public static final ModBlockCrop crop_tulsi = new ModBlockCrop("crop_tulsi", 3);
	public static final ModBlockCrop crop_white_sage = new ModBlockCrop("crop_white_sage", 3);
	public static final ModBlockCrop crop_wormwood = new ModBlockCrop("crop_wormwood", 6);
	
	//Material Blocks
	public static final Block block_cold_iron = new ModBlock("block_cold_iron", Main.proxy.tab_blocks, Material.IRON, SoundType.METAL, 5, 30, "pickaxe", 1, "blockColdIron");
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
	
	public static final Block fake_ice = new ModBlock("fake_ice", Main.proxy.tab_blocks, Material.ICE, SoundType.GLASS, 0.5f, 2.5f, "", 0);
	public static final Block nethersteel = new ModBlock("nethersteel", Main.proxy.tab_blocks, Material.IRON, SoundType.METAL, 5, 30, "pickaxe", 1, "blockNethersteel");
	
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
	
	public static final Block coquina = new ModBlock("coquina", Main.proxy.tab_blocks, Material.ROCK, SoundType.STONE, 5, 30, "pickaxe", 0, "coquina");
	
	//Trees
	public static final Block log_cypress = new ModBlockPillar("log_cypress", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_elder = new ModBlockPillar("log_elder", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_juniper = new ModBlockPillar("log_juniper", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final Block log_yew = new ModBlockPillar("log_yew", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 10, "axe", 0, "logWood");
	public static final ModBlockLeaves leaves_cypress = new ModBlockLeaves("leaves_cypress", Main.proxy.tab_blocks, "treeLeaves");
	public static final ModBlockLeaves leaves_elder = new ModBlockLeaves("leaves_elder", Main.proxy.tab_blocks, "treeLeaves");
	public static final ModBlockLeaves leaves_juniper = new ModBlockLeaves("leaves_juniper", Main.proxy.tab_blocks, "treeLeaves");
	public static final ModBlockLeaves leaves_yew = new ModBlockLeaves("leaves_yew", Main.proxy.tab_blocks, "treeLeaves");
	public static final Block planks_cypress = new ModBlock("planks_cypress", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_elder = new ModBlock("planks_elder", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_juniper = new ModBlock("planks_juniper", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block planks_yew = new ModBlock("planks_yew", Main.proxy.tab_blocks, Material.WOOD, SoundType.WOOD, 2, 15, "axe", 0, "plankWood");
	public static final Block sapling_cypress = new ModBlockSapling("sapling_cypress", Main.proxy.tab_blocks, "treeSapling");
	public static final Block sapling_elder = new ModBlockSapling("sapling_elder", Main.proxy.tab_blocks, "treeSapling");
	public static final Block sapling_juniper = new ModBlockSapling("sapling_juniper", Main.proxy.tab_blocks, "treeSapling");
	public static final Block sapling_yew = new ModBlockSapling("sapling_yew", Main.proxy.tab_blocks, "treeSapling");
	
	//Decoration
	public static final Block stairs_cypress = new ModBlockStairs("stairs_cypress", Main.proxy.tab_blocks, planks_cypress, "axe", 0, "stairWood");
	public static final Block stairs_elder = new ModBlockStairs("stairs_elder", Main.proxy.tab_blocks, planks_elder, "axe", 0, "stairWood");
	public static final Block stairs_juniper = new ModBlockStairs("stairs_juniper", Main.proxy.tab_blocks, planks_juniper, "axe", 0, "stairWood");
	public static final Block stairs_yew = new ModBlockStairs("stairs_yew", Main.proxy.tab_blocks, planks_yew, "axe", 0, "stairWood");
	public static final Block stairs_fake_ice = new ModBlockStairs("stairs_fake_ice", Main.proxy.tab_blocks, fake_ice, "", 0);
	
	public static final ModBlockSlab slab_cypress = new ModBlockSlab("slab_cypress", Main.proxy.tab_blocks, planks_cypress, false, "slabWood");
	public static final ModBlockSlab slab_cypress_double = new ModBlockSlab("slab_cypress_double", Main.proxy.tab_blocks, planks_cypress, true);
	public static final ModBlockSlab slab_elder = new ModBlockSlab("slab_elder", Main.proxy.tab_blocks, planks_elder, false, "slabWood");
	public static final ModBlockSlab slab_elder_double = new ModBlockSlab("slab_elder_double", Main.proxy.tab_blocks, planks_elder, true);
	public static final ModBlockSlab slab_juniper = new ModBlockSlab("slab_juniper", Main.proxy.tab_blocks, planks_juniper, false, "slabWood");
	public static final ModBlockSlab slab_juniper_double = new ModBlockSlab("slab_juniper_double", Main.proxy.tab_blocks, planks_juniper, true);
	public static final ModBlockSlab slab_yew = new ModBlockSlab("slab_yew", Main.proxy.tab_blocks, planks_yew, false, "slabWood");
	public static final ModBlockSlab slab_yew_double = new ModBlockSlab("slab_yew_double", Main.proxy.tab_blocks, planks_yew, true);
	public static final ModBlockSlab slab_fake_ice = new ModBlockSlab("slab_fake_ice", Main.proxy.tab_blocks, fake_ice, false);
	public static final ModBlockSlab slab_fake_ice_double = new ModBlockSlab("slab_fake_ice_double", Main.proxy.tab_blocks, fake_ice, true);
	
	public static final Block fence_fake_ice = new ModBlockFence("fence_fake_ice", Main.proxy.tab_blocks, fake_ice);
	
	@SubscribeEvent
	public static void register(Register<Block> event)
	{
		for (Block block : REGISTRY) event.getRegistry().register(block);
	}
}