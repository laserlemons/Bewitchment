package com.bewitchment.registry;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.block.ModBlockSlab;
import com.bewitchment.registry.item.ModItem;
import com.bewitchment.registry.item.ModItemSeed;
import com.bewitchment.registry.item.tool.ModItemArmor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockSlab;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Main.MOD_ID)
public class ModItems
{
	public static final List<Item> REGISTRY = new ArrayList<Item>();
	
	public static final ToolMaterial TOOL_SILVER = EnumHelper.addToolMaterial("silver", 1, 215, 10.0F, 2.5F, 24);

	public static final ArmorMaterial ARMOR_BEWITCHED_LEATHER = EnumHelper.addArmorMaterial("bewitched_leather", Main.MOD_ID + ":" + "bewitched_leather", 24, new int[]{1, 4, 5, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.5F);
	public static final ArmorMaterial ARMOR_VAMPIRE = EnumHelper.addArmorMaterial("vampire", Main.MOD_ID + ":" + "vampire", 9, new int[]{2, 6, 7, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.25F);

	public static final ToolMaterial TOOL_COLD_IRON = EnumHelper.addToolMaterial("cold_iron", 2, 850, 7.0F, 3.0F, 8);

	public static final ToolMaterial TOOL_CHALK = EnumHelper.addToolMaterial("chalk", 2, 300, 2F, 1.5F, 30);
	
	//Armor
	public static final Item helmet_cold_iron = new ModItemArmor.ColdIron("helmet_cold_iron", Main.proxy.tab_items, EntityEquipmentSlot.HEAD);
	public static final Item chestplate_cold_iron = new ModItemArmor.ColdIron("chestplate_cold_iron", Main.proxy.tab_items, EntityEquipmentSlot.CHEST);
	public static final Item leggings_cold_iron = new ModItemArmor.ColdIron("leggings_cold_iron", Main.proxy.tab_items, EntityEquipmentSlot.LEGS);
	public static final Item boots_cold_iron = new ModItemArmor.ColdIron("boots_cold_iron", Main.proxy.tab_items, EntityEquipmentSlot.FEET);
	
	public static final Item helmet_silver = new ModItemArmor.Silver("helmet_silver", Main.proxy.tab_items, EntityEquipmentSlot.HEAD);
	public static final Item chestplate_silver = new ModItemArmor.Silver("chestplate_silver", Main.proxy.tab_items, EntityEquipmentSlot.CHEST);
	public static final Item leggings_silver = new ModItemArmor.Silver("leggings_silver", Main.proxy.tab_items, EntityEquipmentSlot.LEGS);
	public static final Item boots_silver = new ModItemArmor.Silver("boots_silver", Main.proxy.tab_items, EntityEquipmentSlot.FEET);
	
	//Material Items
	public static final Item ingot_cold_iron = new ModItem("ingot_cold_iron", Main.proxy.tab_items, "ingotColdIron");
	public static final Item ingot_silver = new ModItem("ingot_silver", Main.proxy.tab_items, "ingotSilver");
	public static final Item nugget_cold_iron = new ModItem("nugget_cold_iron", Main.proxy.tab_items, "nuggetColdIron");
	public static final Item nugget_silver = new ModItem("nugget_silver", Main.proxy.tab_items, "nuggetSilver");
	public static final Item gem_alexandrite = new ModItem("gem_alexandrite", Main.proxy.tab_items, "gemAlexandrite");
	public static final Item gem_amethyst = new ModItem("gem_amethyst", Main.proxy.tab_items, "gemAmethyst");
	public static final Item gem_bloodstone = new ModItem("gem_bloodstone", Main.proxy.tab_items, "gemBloodstone");
	public static final Item gem_garnet = new ModItem("gem_garnet", Main.proxy.tab_items, "gemGarnet");
	public static final Item gem_jasper = new ModItem("gem_jasper", Main.proxy.tab_items, "gemJasper");
	public static final Item gem_malachite = new ModItem("gem_malachite", Main.proxy.tab_items, "gemMalachite");
	public static final Item gem_nuummite = new ModItem("gem_nuummite", Main.proxy.tab_items, "gemNuummite");
	public static final Item gem_tigers_eye = new ModItem("gem_tigers_eye", Main.proxy.tab_items, "gemTigersEye");
	public static final Item gem_tourmaline = new ModItem("gem_tourmaline", Main.proxy.tab_items, "gemTourmaline");
	
	//Ingredients
	public static final Item aconitum = new ModItem("aconitum", Main.proxy.tab_items, "cropAconitum");
	public static final Item asphodel = new ModItem("asphodel", Main.proxy.tab_items, "cropAsphodel");
	public static final Item belladonna = new ModItem("belladonna", Main.proxy.tab_items, "cropBelladonna");
	public static final Item chrysanthemum = new ModItem("chrysanthemum", Main.proxy.tab_items);
	public static final Item garlic = new ModItem("garlic", Main.proxy.tab_items, "cropGarlic", "listAllherb");
	public static final Item ginger = new ModItem("ginger", Main.proxy.tab_items, "cropGinger", "listAllspice");
	public static final Item hellebore = new ModItem("hellebore", Main.proxy.tab_items);
	public static final Item infested_wheat = new ModItem("infested_wheat", Main.proxy.tab_items);
	public static final Item kelp = new ModItem("kelp", Main.proxy.tab_items, "cropKelp", "cropSeaweed", "listAllveggie", "listAllgreenveggie");
	public static final Item kenaf = new ModItem("kenaf", Main.proxy.tab_items, "cropKenaf");
	public static final Item lavender = new ModItem("lavender", Main.proxy.tab_items, "cropLavender", "listAllherb");
	public static final Item mandrake_root = new ModItem("mandrake_root", Main.proxy.tab_items, "cropMandrake");
	public static final Item mint = new ModItem("mint", Main.proxy.tab_items, "cropMint", "cropSpiceleaf", "listAllspice", "listAllgreenveggie");
	public static final Item sagebrush = new ModItem("sagebrush", Main.proxy.tab_items);
	public static final Item silphium = new ModItem("silphium", Main.proxy.tab_items, "cropSilphium", "listAllherb", "listAllspice", "listAllgreenveggie");
	public static final Item thistle = new ModItem("thistle", Main.proxy.tab_items, "cropThistle");
	public static final Item tulsi = new ModItem("tulsi", Main.proxy.tab_items, "cropTulsi", "listAllherb");
	public static final Item white_sage = new ModItem("white_sage", Main.proxy.tab_items, "cropWhiteSage");
	public static final Item witchweed = new ModItem("witchweed", Main.proxy.tab_items);
	public static final Item wormwood = new ModItem("wormwood", Main.proxy.tab_items, "cropWormwood", "listAllspice");
	
	//Seeds
	public static final ModItemSeed seed_aconitum = new ModItemSeed("seed_aconitum", Main.proxy.tab_items, ModBlocks.crop_aconitum, Blocks.FARMLAND);
	public static final ModItemSeed seed_asphodel = new ModItemSeed("seed_asphodel", Main.proxy.tab_items, ModBlocks.crop_asphodel, Blocks.FARMLAND);
	public static final ModItemSeed seed_belladonna = new ModItemSeed("seed_belladonna", Main.proxy.tab_items, ModBlocks.crop_belladonna, Blocks.FARMLAND);
	public static final ModItemSeed seed_chrysanthemum = new ModItemSeed("seed_chrysanthemum", Main.proxy.tab_items, ModBlocks.crop_chrysanthemum, Blocks.FARMLAND);
	public static final ModItemSeed seed_garlic = new ModItemSeed("seed_garlic", Main.proxy.tab_items, ModBlocks.crop_garlic, Blocks.FARMLAND);
	public static final ModItemSeed seed_ginger = new ModItemSeed("seed_ginger", Main.proxy.tab_items, ModBlocks.crop_ginger, Blocks.FARMLAND);
	public static final ModItemSeed seed_hellebore = new ModItemSeed("seed_hellebore", Main.proxy.tab_items, ModBlocks.crop_hellebore, Blocks.FARMLAND);
	public static final ModItemSeed seed_kelp = new ModItemSeed("seed_kelp", Main.proxy.tab_items, ModBlocks.crop_kelp, Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL);
	public static final ModItemSeed seed_kenaf = new ModItemSeed("seed_kenaf", Main.proxy.tab_items, ModBlocks.crop_kenaf, Blocks.FARMLAND);
	public static final ModItemSeed seed_lavender = new ModItemSeed("seed_lavender", Main.proxy.tab_items, ModBlocks.crop_lavender, Blocks.FARMLAND);
	public static final ModItemSeed seed_mandrake = new ModItemSeed("seed_mandrake", Main.proxy.tab_items, ModBlocks.crop_mandrake, Blocks.FARMLAND);
	public static final ModItemSeed seed_mint = new ModItemSeed("seed_mint", Main.proxy.tab_items, ModBlocks.crop_mint, Blocks.FARMLAND);
	public static final ModItemSeed seed_sagebrush = new ModItemSeed("seed_sagebrush", Main.proxy.tab_items, ModBlocks.crop_sagebrush, Blocks.FARMLAND);
	public static final ModItemSeed seed_silphium = new ModItemSeed("seed_silphium", Main.proxy.tab_items, ModBlocks.crop_silphium, Blocks.FARMLAND);
	public static final ModItemSeed seed_thistle = new ModItemSeed("seed_thistle", Main.proxy.tab_items, ModBlocks.crop_thistle, Blocks.FARMLAND);
	public static final ModItemSeed seed_tulsi = new ModItemSeed("seed_tulsi", Main.proxy.tab_items, ModBlocks.crop_tulsi, Blocks.FARMLAND);
	public static final ModItemSeed seed_white_sage = new ModItemSeed("seed_white_sage", Main.proxy.tab_items, ModBlocks.crop_white_sage, Blocks.FARMLAND);
	public static final ModItemSeed seed_wormwood = new ModItemSeed("seed_wormwood", Main.proxy.tab_items, ModBlocks.crop_wormwood, Blocks.FARMLAND);

	@SubscribeEvent
	public static void register(Register<Item> event)
	{
		for (Block block : ModBlocks.REGISTRY)
		{
			if (!(block instanceof BlockCrops) && !(block instanceof BlockSlab))
			{
				Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey());
				event.getRegistry().register(itemBlock);
				Main.proxy.registerTexture(itemBlock);
			}
		}
		registerSlab(event, ModBlocks.slab_cypress, ModBlocks.slab_cypress_double);
		registerSlab(event, ModBlocks.slab_elder, ModBlocks.slab_elder_double);
		registerSlab(event, ModBlocks.slab_juniper, ModBlocks.slab_juniper_double);
		registerSlab(event, ModBlocks.slab_yew, ModBlocks.slab_yew_double);
		for (Item item : REGISTRY)
		{
			event.getRegistry().register(item);
			Main.proxy.registerTexture(item);
		}
	}
	
	private static void registerSlab(Register<Item> event, ModBlockSlab half, ModBlockSlab full)
	{
		Item itemSlab = new ItemSlab(half, half, full).setRegistryName(half.getRegistryName()).setTranslationKey(half.getTranslationKey());
		Item itemSlabFull = new ItemSlab(full, half, full).setRegistryName(half.getRegistryName().toString() + "_double").setTranslationKey(half.getTranslationKey());
		half.half = half;
		full.half = half;
		event.getRegistry().register(itemSlab);
		Main.proxy.registerTexture(itemSlab);
		event.getRegistry().register(itemSlabFull);
		Main.proxy.registerTexture(itemSlabFull);
	}
}