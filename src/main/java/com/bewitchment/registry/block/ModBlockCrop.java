package com.bewitchment.registry.block;

import java.util.Random;

import com.bewitchment.core.Main;
import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ModBlockCrop extends BlockCrops
{
	private int maxAge;
	private Item seed, crop;
	
	public ModBlockCrop(String name, int maxAge)
	{
		super();
		this.setRegistryName(new ResourceLocation(Main.MOD_ID, name));
		this.setTranslationKey(this.getRegistryName().toString());
		this.setCreativeTab(null);
		this.maxAge = maxAge;
		ModBlocks.REGISTRY.add(this);
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public int getMaxAge()
	{
		return maxAge;
	}
	
	@Override
	public Item getSeed()
	{
		return seed;
	}
	
	public ModBlockCrop setSeed(Item seed)
	{
		this.seed = seed;
		return this;
	}
	
	@Override
	public Item getCrop()
	{
		return crop;
	}
	
	public ModBlockCrop setCrop(Item crop)
	{
		this.crop = crop;
		return this;
	}
	
	public static class Belladonna extends ModBlockCrop
	{
		private final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[]{new AxisAlignedBB(0, 0, 0, 1, 0.125D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.375D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.5D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.625D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.75D, 1), new AxisAlignedBB(0, 0, 0, 1, 1, 1)};
		
		public Belladonna(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			this.checkAndDropBlock(world, pos, state);
			if (world.getLightFromNeighbors(pos.up()) >= 9)
			{
				int i = this.getAge(state);
				if (i < this.getMaxAge())
				{
					if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int)((25f / (world.getBiome(pos).isHighHumidity() ? 25 : getGrowthChance(this, world, pos))) + 1)) == 0))
					{
						world.setBlockState(pos, withAge(i + 1));
						ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
					}
				}
			}
		}
		
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			return CROPS_AABB[getAge(state)];
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
	}
	
	public static class Kelp extends ModBlockCrop
	{
		public Kelp(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			super.updateTick(world, pos, state, rand);
			if (rand.nextInt(2) == 0 && isMaxAge(state) && canBlockStay(world, pos, state) && canPlaceBlockAt(world, pos) && canPlaceBlockAt(world, pos.up()))
			{
				if (ForgeHooks.onCropsGrowPre(world, pos, state, true))
				{
					world.setBlockState(pos.up(), getDefaultState());
					ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
				}
			}
		}
		
		@Override
		protected BlockStateContainer createBlockState()
		{
			return new BlockStateContainer(this, BlockLiquid.LEVEL, AGE);
		}
		
		@Override
		public Material getMaterial(IBlockState state)
		{
			return Material.WATER;
		}
		
		@Override
		public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
		{
			return world.getBlockState(pos.down()).getMaterial().isSolid() || world.getBlockState(pos.down()).getBlock() == this;
		}
		
		@Override
		public boolean canPlaceBlockAt(World world, BlockPos pos)
		{
			return world.getBlockState(pos.up()).getMaterial() == Material.WATER;
		}
		
		@Override
		public boolean isReplaceable(IBlockAccess world, BlockPos pos)
		{
			return false;
		}
		
		@Override
		protected boolean canSustainBush(IBlockState state)
		{
			return false;
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos from)
		{
			if (!canBlockStay(world, pos, state)) checkAndDropBlock(world, pos, state);
		}
		
		@Override
		public void onPlayerDestroy(World world, BlockPos pos, IBlockState state)
		{
			world.setBlockState(pos, Blocks.WATER.getDefaultState());
		}
		
		@Override
		protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
		{
			if (!canBlockStay(world, pos, state))
			{
				this.dropBlockAsItem(world, pos, state, 0);
				world.setBlockState(pos, Blocks.WATER.getDefaultState());
			}
		}
	}
	
	public static class Kenaf extends ModBlockCrop
	{
		private static final AxisAlignedBB[] KENAF_AABB = new AxisAlignedBB[]{new AxisAlignedBB(0, 0, 0, 1, 0.125D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.375D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.625D, 1), new AxisAlignedBB(0, 0, 0, 1, 0.75D, 1), new AxisAlignedBB(0, 0, 0, 1, 1, 1), null, null, new AxisAlignedBB(0, 0, 0, 1, 1, 1)};
		
		public Kenaf(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			super.updateTick(world, pos, state, rand);
			if (isMaxAge(state) && getAge(state) != getMaxAge() && canSustainBush(world.getBlockState(pos.down())) && world.isAirBlock(pos.up()))
			{
				int i = 1;
				while (world.getBlockState(pos.down(i)).getBlock() == this) i++;
				if (i >= 5 || (i >= 3 && rand.nextInt(5) == 0)) world.setBlockState(pos, withAge(getMaxAge()));
				else if (rand.nextInt(5) == 0)
				{
					if (ForgeHooks.onCropsGrowPre(world, pos, state, true))
					{
						world.setBlockState(pos.up(), getDefaultState());
						ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
					}
				}
			}
		}
		
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			return KENAF_AABB[getAge(state)];
		}
		
		@Override
		public boolean canPlaceBlockAt(World world, BlockPos pos)
		{
			return canSustainBush(world.getBlockState(pos.down()));
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
		
		@Override
		protected boolean canSustainBush(IBlockState state)
		{
			return state.getBlock() == Blocks.FARMLAND || (state.getBlock() == this && isMaxAge(state));
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos from)
		{
			if (!canSustainBush(world.getBlockState(pos.down())))
			{
				dropBlockAsItem(world, pos, state, 0);
				world.setBlockToAir(pos);
			}
		}
	}
	
	public static class Mint extends ModBlockCrop
	{
		public Mint(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			super.updateTick(world, pos, state, rand);
			if (isMaxAge(state) && getAge(state) != getMaxAge())
			{
				if (rand.nextBoolean()) world.setBlockState(pos, withAge(getMaxAge()));
				else
				{
					BlockPos i = pos.add(-1, -1, -1), f = pos.add(1, 1, 1);
					BlockPos.getAllInBox(i, f).forEach(pos0 -> {
						if (rand.nextBoolean() && canSustainBush(world.getBlockState(pos0.down())) && world.isAirBlock(pos0) || world.getBlockState(pos0).getBlock().isReplaceable(world, pos0)) world.setBlockState(pos0, getDefaultState());
					});
				}
			}
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
		
		@Override
		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
		{
			world.spawnParticle(EnumParticleTypes.END_ROD, rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0, 0.05, 0);
		}
	}
	
	public static class Silphium extends ModBlockCrop
	{
		public Silphium(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			checkAndDropBlock(world, pos, state);
			if (world.getLightFromNeighbors(pos.up()) >= 9)
			{
				int age = getAge(state);
				if (age < getMaxAge())
				{
					if (ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((int)(25f / getGrowthChance(this, world, pos)) + 1) == 0))
					{
						world.setBlockState(pos, withAge(age + 1));
						ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
					}
				}
			}
			if (getAge(state) == getMaxAge() || rand.nextBoolean() || !world.getBiome(pos).canRain()) return;
			if (ForgeHooks.onCropsGrowPre(world, pos, state, true) && canSustainBush(world.getBlockState(pos.down())) && world.isAirBlock(pos.up()))
			{
				IBlockState down = world.getBlockState(pos.down());
				if (down.getBlock() == this && getAge(down) >= 3)
				{
					world.setBlockState(pos, withAge(getMaxAge()));
					ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
				}
				else if (getAge(state) == getMaxAge()-1)
				{
					world.setBlockState(pos, getDefaultState());
					ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
				}
			}
		}
		
		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune)
		{
			return getAge(state) == getMaxAge() ? getCrop() : getSeed();
		}
		
		@Override
		public boolean canPlaceBlockAt(World world, BlockPos pos)
		{
			return canSustainBush(world.getBlockState(pos.down()));
		}
		
		@Override
		protected boolean canSustainBush(IBlockState state)
		{
			return state.getBlock() == Blocks.FARMLAND || (state.getBlock() == this && isMaxAge(state));
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
		
		@Override
		public void grow(World world, BlockPos pos, IBlockState state)
		{
			if (getAge(state) == 6) return;
			world.setBlockState(pos, withAge(Math.min(getAge(state) + getBonemealAgeIncrease(world), getMaxAge())));
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos from)
		{
			if (!canSustainBush(world.getBlockState(pos.down())))
			{
				dropBlockAsItem(world, pos, state, 0);
				world.setBlockToAir(pos);
			}
		}
	}
	
	public static class Thistle extends ModBlockCrop
	{
		public Thistle(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			super.updateTick(world, pos, state, rand);
			if (isMaxAge(state) && getAge(state) != getMaxAge())
			{
				if (rand.nextBoolean()) world.setBlockState(pos, withAge(getMaxAge()));
				else
				{
					BlockPos i = pos.add(-1, -1, -1), f = pos.add(1, 1, 1);
					BlockPos.getAllInBox(i, f).forEach(pos0 -> {
						if (rand.nextBoolean() && canSustainBush(world.getBlockState(pos0.down())) && world.isAirBlock(pos0) || world.getBlockState(pos0).getBlock().isReplaceable(world, pos0)) world.setBlockState(pos0, getDefaultState());
					});
				}
			}
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
		
		@Override
		public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity)
		{
			entity.attackEntityFrom(DamageSource.CACTUS, 0.5f);
		}
	}
	
	public static class Wormwood extends ModBlockCrop
	{
		public Wormwood(String name, int maxAge)
		{
			super(name, maxAge);
		}
		
		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
		{
			if (rand.nextBoolean() || !world.getBiome(pos).canRain()) return;
			if (isMaxAge(state) && getAge(state) != getMaxAge() && canSustainBush(world.getBlockState(pos.down())) && world.isAirBlock(pos.up()))
			{
				if (world.getBlockState(pos.down()).getBlock() == this) world.setBlockState(pos, withAge(getMaxAge()));
				else if (rand.nextInt(20) == 0)
				{
					if (ForgeHooks.onCropsGrowPre(world, pos, state, true))
					{
						world.setBlockState(pos.up(), getDefaultState());
						ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
					}
				}
			}
		}
		
		@Override
		public boolean canPlaceBlockAt(World world, BlockPos pos)
		{
			return canSustainBush(world.getBlockState(pos.down()));
		}
		
		@Override
		public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
		{
			return true;
		}
		
		@Override
		protected boolean canSustainBush(IBlockState state)
		{
			return state.getBlock() == Blocks.FARMLAND || state.getBlock() == this;
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos from)
		{
			if (!canSustainBush(world.getBlockState(pos.down())))
			{
				this.dropBlockAsItem(world, pos, state, 0);
				world.setBlockToAir(pos);
			}
		}
	}
}