package com.bewitchment.registry.item.tool;

import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.core.api.transformation.ITransformation.Transformation.TransformationProvider;
import com.bewitchment.core.api.transformation.ITransformation.Transformations;
import com.bewitchment.registry.ModItems;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
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
		public Silver(String name, CreativeTabs tab, ArmorMaterial mat, EntityEquipmentSlot slot)
		{
			super(name, tab, mat, slot);
		}
		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
		{
			if (player.getCapability(TransformationProvider.TRANSFORMATION, null).getTransformation() == Transformations.WEREWOLF) player.attackEntityFrom(DamageSource.MAGIC, 1);
		}
	}
	
	public static class ColdIron extends ModItemArmor
	{
		public ColdIron(String name, CreativeTabs tab, ArmorMaterial mat, EntityEquipmentSlot slot)
		{
			super(name, tab, mat, slot);
		}
	}
}