package com.bewitchment.registry.block.tile;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModSlot extends SlotItemHandler
{
	private final List<Item> acceptable = new ArrayList<Item>();
	
	public ModSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Item... acceptable)
	{
		super(itemHandler, index, xPosition, yPosition);
		for (Item item : acceptable) this.acceptable.add(item);
	}
	
	@Override
    public boolean isItemValid(ItemStack stack)
    {
		return acceptable.contains(Items.AIR) ? false : acceptable.isEmpty() ? super.isItemValid(stack) : acceptable.contains(stack.getItem());
    }
}