package com.bewitchment.registry.item.tool;

import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.ModItems;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItemArmor extends ItemArmor
{
	public ModItemArmor(String name, CreativeTabs tab, ArmorMaterial mat, EntityEquipmentSlot slot)
	{
		super(mat, 0, slot);
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(tab);
		ModItems.REGISTRY.add(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
	{
		tooltip.add(TextFormatting.GRAY + I18n.format("tooltip." + "armor_description_" + getArmorMaterial().name()));
	}
	
	public static class Silver extends ModItemArmor
	{
		private static final ArmorMaterial MAT = EnumHelper.addArmorMaterial("silver", Main.MOD_ID + ":" + "silver", 12, new int[]{1, 4, 5, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
		
		public Silver(String name, CreativeTabs tab, EntityEquipmentSlot slot)
		{
			super(name, tab, MAT, slot);
		}
		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
		{
			//werewolf
		}
	}
	
	public static class ColdIron extends ModItemArmor
	{
		public static final ArmorMaterial MAT = EnumHelper.addArmorMaterial("cold_iron", Main.MOD_ID + ":" + "cold_iron", 18, new int[]{2, 6, 7, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.45F);
		
		public ColdIron(String name, CreativeTabs tab, EntityEquipmentSlot slot)
		{
			super(name, tab, MAT, slot);
		}
		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
		{
			//spirit
		}
	}
}