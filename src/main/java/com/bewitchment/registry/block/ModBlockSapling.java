package com.bewitchment.registry.block;

import java.util.ArrayList;
import java.util.Random;

import com.bewitchment.registry.ModBlocks;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockSapling extends ModBlockBush implements IGrowable
{
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.1, 0, 0.1, 0.9, 0.8, 0.9);
	
	public ModBlockSapling(String name, String... oreNames)
	{
		super(name, oreNames);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, pos, state, rand);
            if (world.isAreaLoaded(pos, 1) && world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) this.grow(world, rand, pos, state);
        }
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return SAPLING_AABB;
	}
    
	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
	{
		return rand.nextFloat() < 0.45f;
	}
	
	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if (canSaplingGrow(world, pos) && rand.nextBoolean())
		{
			if (this == ModBlocks.sapling_cypress)
			{
				int h = generateTrunk(world, ModBlocks.log_cypress.getDefaultState(), pos, rand, 5, 13);
				for (int y = -h + 2; y < 2; y++)
				{
					boolean cross = y <= -1;
					boolean core = y > -1;
					boolean full = y >= -h + 3 && y <= -h / 2;
					for (int x = -1; x <= 1; x++)
					{
						for (int z = -1; z <= 1; z++)
						{
							BlockPos current = pos.up(h).add(x, y, z);
							if (world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current) && ((core && z == 0 && x == 0) || full || (cross && (z == 0 || x == 0)))) world.setBlockState(current, ModBlocks.leaves_cypress.getDefaultState());
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_elder)
			{
				int h = generateTrunk(world, ModBlocks.log_elder.getDefaultState(), pos, rand, 3, 5);
				for (int x = -2; x < 3; x++)
				{
					for (int z = -2; z < 3; z++)
					{
						for (int y = -2; y < 1; y++)
						{
							BlockPos current = pos.up(h).add(x, y, z);
							if (world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current) && ((Math.abs(z) != 2 || Math.abs(x) != 2) || rand.nextDouble() < 0.2) && ((y < 0 || (x < 2 && z < 2 && x > -2 && z > -2)))) world.setBlockState(current, ModBlocks.leaves_elder.getDefaultState());
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_juniper)
			{
				int h = generateTrunk(world, ModBlocks.log_juniper.getDefaultState(), pos, rand, 2, 4);
				EnumFacing branchOffset = EnumFacing.HORIZONTALS[rand.nextInt(4)];
				BlockPos branching = pos.up(h).offset(branchOffset);
				ArrayList<BlockPos> logs = new ArrayList<BlockPos>();
				if (world.getBlockState(branching).getBlock().canBeReplacedByLeaves(world.getBlockState(branching), world, branching))
				{
					world.setBlockState(branching, ModBlocks.log_juniper.getDefaultState());
					logs.add(branching);
				}
				BlockPos other = branching.offset(branchOffset.getOpposite(), 2);
				if (world.getBlockState(other).getBlock().canBeReplacedByLeaves(world.getBlockState(other), world, other))
				{
					world.setBlockState(other, ModBlocks.log_juniper.getDefaultState());
					logs.add(other);
				}
				for (int i = 0; i < h / 2; i++)
				{
					BlockPos current = branching.up().offset(branchOffset, i + 1);
					if (world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current))
					{
						logs.add(current);
						world.setBlockState(current, ModBlocks.log_juniper.getDefaultState());
					}
				}
				for (BlockPos pos0 : logs)
				{
					for (EnumFacing face : EnumFacing.VALUES)
					{
						BlockPos pos1 = pos0.offset(face);
						if (world.getBlockState(pos1).getBlock().canBeReplacedByLeaves(world.getBlockState(pos1), world, pos1)) world.setBlockState(pos1, ModBlocks.leaves_juniper.getDefaultState());
						for (EnumFacing face0 : EnumFacing.VALUES)
						{
							if (face0 != EnumFacing.DOWN)
							{
								BlockPos pos2 = pos0.offset(face).offset(face0);
								if (world.getBlockState(pos2).getBlock().canBeReplacedByLeaves(world.getBlockState(pos2), world, pos2) && rand.nextDouble() < 0.8) world.setBlockState(pos2, ModBlocks.leaves_juniper.getDefaultState());
							}
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_yew)
			{
				int h1 = generateTrunk(world, ModBlocks.log_yew.getDefaultState(), pos, rand, 4, 6);
				int h2 = generateTrunk(world, ModBlocks.log_yew.getDefaultState(), world.getBlockState(pos.east()).getBlock() == ModBlocks.sapling_yew ? pos.east() : pos.west(), rand, 4, 6);
				int h3 = generateTrunk(world, ModBlocks.log_yew.getDefaultState(), world.getBlockState(pos.east().north()).getBlock() == ModBlocks.sapling_yew ? pos.east().north() : world.getBlockState(pos.east().south()).getBlock() == ModBlocks.sapling_yew ? pos.east().south() : world.getBlockState(pos.west().north()).getBlock() == ModBlocks.sapling_yew ? pos.west().north() : pos.west().south(), rand, 4, 6);
				int h4 = generateTrunk(world, ModBlocks.log_yew.getDefaultState(), world.getBlockState(pos.north()).getBlock() == ModBlocks.sapling_yew ? pos.north() : pos.south(), rand, 4, 6);
				int hMin = Math.min(Math.min(h1, h2), Math.min(h3, h4));
				int hMax = Math.max(Math.max(h1, h2), Math.max(h3, h4));
				for (int x = -2; x < 4; x++)
				{
					for (int z = -3; z < 3; z++)
					{
						for (int y = -2; y < hMax - hMin + 2; y++)
						{
							BlockPos current = pos.up(hMin).add(x, y, z);
							if (world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current) && !(((x == -2 || x == 3 || z == -3 || z == 2) && (rand.nextDouble() < 0.1 || y >= hMax - hMin)) && ((x == -1 || x == 2 || z == -2 || z == 1) && y == hMax - hMin + 1) || (x == -2 && z == -3) || (x == -2 && z == 2) || (x == 3 && z == -3) || (x == 3 && z == 2))) world.setBlockState(current, ModBlocks.leaves_yew.getDefaultState());
						}
					}
				}
			}
		}
	}
	
	private boolean canSaplingGrow(World world, BlockPos pos)
	{
		if (!world.isRemote)
		{
			if (!world.getBlockState(pos.up()).getBlock().canBeReplacedByLeaves(world.getBlockState(pos.up()), world, pos.up())) return false;
			else if (this == ModBlocks.sapling_cypress)
			{
				for (int x = -1; x < 2; x++)
				{
					for (int z = -1; z < 2; z++)
					{
						for (int y = 0; y < 8; y++)
						{
							BlockPos current = pos.up(2).add(x, y, z);
							if (!world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current)) return false;
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_elder)
			{
				for (int x = -1; x < 2; x++)
				{
					for (int z = -1; z < 2; z++)
					{
						for (int y = 0; y < 1; y++)
						{
							BlockPos current = pos.up(2).add(x, y, z);
							if (!world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current)) return false;
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_juniper)
			{
				for (int x = -2; x < 3; x++)
				{
					for (int z = -2; z < 3; z++)
					{
						for (int y = 0; y < 2; y++)
						{
							BlockPos current = pos.up(2).add(x, y, z);
							if (!world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current)) return false;
						}
					}
				}
			}
			else if (this == ModBlocks.sapling_yew)
			{
				boolean flag = false;
				for (int x = 0; x >= -1; x--)
				{
					for (int z = 0; z >= -1; z--)
					{
						if (isYewValid(world, pos, x, z)) flag = true;
					}
				}
				if (!flag) return false;
				for (int x = -2; x < 3; x++)
				{
					for (int z = -2; z < 3; z++)
					{
						for (int y = 0; y < 3; y++)
						{
							BlockPos current = pos.up(2).add(x, y, z);
							if (!world.getBlockState(current).getBlock().canBeReplacedByLeaves(world.getBlockState(current), world, current)) return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private boolean isYewValid(World world, BlockPos pos, int x, int z)
    {
        return world.getBlockState(pos.add(x, 0, z)).getBlock() == ModBlocks.sapling_yew && world.getBlockState(pos.add(x + 1, 0, z)).getBlock() == ModBlocks.sapling_yew && world.getBlockState(pos.add(x, 0, z + 1)).getBlock() == ModBlocks.sapling_yew && world.getBlockState(pos.add(x + 1, 0, z + 1)).getBlock() == ModBlocks.sapling_yew;
    }
	
	private int generateTrunk(World world, IBlockState state, BlockPos pos, Random rand, int minHeight, int maxHeight)
	{
		int height = minHeight + rand.nextInt(maxHeight - minHeight + 1);
		for (int i = 0; i < height; i++) if (world.getBlockState(pos.up(i)).getBlock().canBeReplacedByLeaves(world.getBlockState(pos.up(i)), world, pos.up(i)) || i == 0) world.setBlockState(pos.up(i), state);
		return height;
	}
}