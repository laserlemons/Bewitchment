package com.bewitchment.registry.gen;

import java.util.Random;

import com.bewitchment.core.Main;
import com.bewitchment.registry.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator
{
	private final WorldGenerator silver, salt, alexandrite, amethyst, bloodstone, garnet, jasper, malachite, nuummite, tigers_eye, tourmaline;
	
	public WorldGenOres()
	{
		this.silver = new WorldGenMinable(ModBlocks.ore_silver.getDefaultState(), Main.proxy.config.silver_size);
		this.salt = new WorldGenMinable(ModBlocks.ore_salt.getDefaultState(), Main.proxy.config.salt_size);
		this.alexandrite = new WorldGenMinable(ModBlocks.ore_alexandrite.getDefaultState(), Main.proxy.config.alexandrite_size);
		this.amethyst = new WorldGenMinable(ModBlocks.ore_amethyst.getDefaultState(), Main.proxy.config.amethyst_size);
		this.bloodstone = new WorldGenMinable(ModBlocks.ore_bloodstone.getDefaultState(), Main.proxy.config.bloodstone_size);
		this.garnet = new WorldGenMinable(ModBlocks.ore_garnet.getDefaultState(), Main.proxy.config.garnet_size);
		this.jasper = new WorldGenMinable(ModBlocks.ore_jasper.getDefaultState(), Main.proxy.config.jasper_size);
		this.malachite = new WorldGenMinable(ModBlocks.ore_malachite.getDefaultState(), Main.proxy.config.malachite_size);
		this.nuummite = new WorldGenMinable(ModBlocks.ore_nuummite.getDefaultState(), Main.proxy.config.nuummite_size);
		this.tigers_eye = new WorldGenMinable(ModBlocks.ore_tigers_eye.getDefaultState(), Main.proxy.config.tigers_eye_size);
		this.tourmaline = new WorldGenMinable(ModBlocks.ore_tourmaline.getDefaultState(), Main.proxy.config.tourmaline_size);
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator generator, IChunkProvider provider)
	{
		if (world.provider.getDimension() == 0)
		{
//			for (int j = 0; j < 32; j++) // uncomment this for mega ores
			{
				for (int i = 0; i < Main.proxy.config.silver_chance; i++) silver.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.silver_max - Main.proxy.config.silver_min) + Main.proxy.config.silver_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.salt_chance; i++) salt.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.salt_max - Main.proxy.config.salt_min) + Main.proxy.config.salt_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.alexandrite_chance; i++) alexandrite.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.alexandrite_max - Main.proxy.config.alexandrite_min) + Main.proxy.config.alexandrite_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.amethyst_chance; i++) amethyst.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.amethyst_max - Main.proxy.config.amethyst_min) + Main.proxy.config.amethyst_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.bloodstone_chance; i++) bloodstone.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.bloodstone_max - Main.proxy.config.bloodstone_min) + Main.proxy.config.bloodstone_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.garnet_chance; i++) garnet.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.garnet_max - Main.proxy.config.garnet_min) + Main.proxy.config.garnet_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.jasper_chance; i++) jasper.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.jasper_max - Main.proxy.config.jasper_min) + Main.proxy.config.jasper_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.malachite_chance; i++) malachite.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.malachite_max - Main.proxy.config.malachite_min) + Main.proxy.config.malachite_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.nuummite_chance; i++) nuummite.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.nuummite_max - Main.proxy.config.nuummite_min) + Main.proxy.config.nuummite_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.tigers_eye_chance; i++) tigers_eye.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.tigers_eye_max - Main.proxy.config.tigers_eye_min) + Main.proxy.config.tigers_eye_min, chunkZ * 16 + rand.nextInt(16)));
				for (int i = 0; i < Main.proxy.config.tourmaline_chance; i++) tourmaline.generate(world, rand, new BlockPos(chunkX * 16 + rand.nextInt(16), rand.nextInt(Main.proxy.config.tourmaline_max - Main.proxy.config.tourmaline_min) + Main.proxy.config.tourmaline_min, chunkZ * 16 + rand.nextInt(16)));
			}
		}
	}
}