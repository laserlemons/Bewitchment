package com.bewitchment.core.api.transformation;

import com.bewitchment.core.Main;
import com.bewitchment.registry.ModBlocks;

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
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
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
			return transformation == null ? Transformations.NONE : transformation;
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
			public void livingTick(LivingEvent.LivingUpdateEvent event)
			{
				if (event.getEntityLiving() instanceof EntityPlayer && ((EntityPlayer)event.getEntityLiving()).getCapability(TransformationProvider.TRANSFORMATION, null).getTransformation() == null) event.getEntityLiving().getCapability(TransformationProvider.TRANSFORMATION, null).setTransformation(Transformations.NONE);
			}
			
			@SubscribeEvent
			public void clonePlayer(PlayerEvent.Clone event)
			{
				event.getEntityPlayer().getCapability(TransformationProvider.TRANSFORMATION, null).setTransformation(event.getOriginal().getCapability(TransformationProvider.TRANSFORMATION, null).getTransformation());
			}
			
			@SubscribeEvent(priority = EventPriority.LOWEST)
			public void breakBlock(BlockEvent.BreakEvent event)
			{
				if (!event.getPlayer().getCapability(TransformationProvider.TRANSFORMATION, null).getTransformation().canCrossSalt && event.getState().getBlock() == ModBlocks.salt_barrier || event.getPlayer().world.getBlockState(event.getPos().up()).getBlock() == ModBlocks.salt_barrier) event.setCanceled(true);
			}
		}
	}
}