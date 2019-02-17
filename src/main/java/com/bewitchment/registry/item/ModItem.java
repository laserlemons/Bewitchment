package com.bewitchment.registry.item;

import java.util.ArrayList;
import java.util.List;

import com.bewitchment.core.Main;
import com.bewitchment.registry.IOreName;
import com.bewitchment.registry.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ModItem extends Item implements IOreName
{
	private final List<String> oreNames = new ArrayList<String>();
	
	public ModItem(String name, CreativeTabs tab, String... oreNames)
	{
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(tab);
		for (String ore : oreNames) this.oreNames.add(ore);
		ModItems.REGISTRY.add(this);
	}
	
	@Override
	public List<String> getOreNames()
	{
		return oreNames;
	}
}