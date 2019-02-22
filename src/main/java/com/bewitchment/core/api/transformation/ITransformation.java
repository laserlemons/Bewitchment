package com.bewitchment.core.api.transformation;

import com.bewitchment.core.Main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public interface ITransformation
{
	public Transformations getTransformation();
	
	public void setTransformation(Transformations val);
	
	public static enum Transformations
	{
		NONE(true), WEREWOLF(false), VAMPIRE(false), SPECTRE(false), HUNTER(false);
		
		public final boolean canCrossSalt;
		
		private Transformations(boolean canCrossSalt)
		{
			this.canCrossSalt = canCrossSalt;
		}
	}
	
	public static class Transformation implements ITransformation
	{
		private Transformations transformation;
		
		@Override
		public Transformations getTransformation()
		{
			return transformation;
		}
		
		@Override
		public void setTransformation(Transformations val)
		{
			transformation = val;
		}
		
		public static class TransformationStorage implements IStorage<ITransformation>
		{
			@Override
			public NBTBase writeNBT(Capability<ITransformation> capability, ITransformation instance, EnumFacing side)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("transformation", instance.getTransformation().ordinal());
				return tag;
			}
			
			@Override
			public void readNBT(Capability<ITransformation> capability, ITransformation instance, EnumFacing side, NBTBase nbt)
			{
				instance.setTransformation(Transformations.values()[((NBTTagCompound)nbt).getInteger("transformation")]);
			}
		}
		
		public static class TransformationProvider implements ICapabilitySerializable<NBTTagCompound>
		{
			@CapabilityInject(ITransformation.class)
			public static final Capability<ITransformation> TRANSFORMATION = null;
			
			private ITransformation instance = TRANSFORMATION.getDefaultInstance();
			
			@Override
			public boolean hasCapability(Capability<?> capability, EnumFacing facing)
			{
				return capability == TRANSFORMATION;
			}
			
			@Override
			public <T> T getCapability(Capability<T> capability, EnumFacing facing)
			{
				return capability == TRANSFORMATION ? TRANSFORMATION.<T>cast(instance) : null;
			}
			
			@Override
			public NBTTagCompound serializeNBT()
			{
				return (NBTTagCompound) TRANSFORMATION.getStorage().writeNBT(TRANSFORMATION, instance, null);
			}
			
			@Override
			public void deserializeNBT(NBTTagCompound nbt)
			{
				TRANSFORMATION.getStorage().readNBT(TRANSFORMATION, instance, null, nbt);
			}
		}
		
		public static class TransformationHandler
		{
			public static final ResourceLocation CAP_TRANSFORMATION = new ResourceLocation(Main.MOD_ID, "transformation");
			
			@SubscribeEvent
			public void attachCapability(AttachCapabilitiesEvent<Entity> event)
			{
				if (event.getObject() instanceof EntityPlayer) event.addCapability(CAP_TRANSFORMATION, new TransformationProvider());
			}
			
			@SubscribeEvent
			public void clonePlayer(PlayerEvent.Clone event)
			{
				EntityPlayer player = event.getEntityPlayer();
				ITransformation newT = player.getCapability(TransformationProvider.TRANSFORMATION, null), oldT = event.getOriginal().getCapability(TransformationProvider.TRANSFORMATION, null);
				newT.setTransformation(oldT.getTransformation());
			}
		}
	}
}