package gliath.mmtest;

import gliath.mmtest.initializer.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case -1:
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
            case 1:
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {
        generateOre(ModBlocks.mod_block, (byte) 0, Blocks.netherrack, random, world, chunkX, chunkZ, 2, 10, 6, 5, 128);
    }

    public void generateOverworld(World world, Random random, int chunkX, int chunkZ) {
        generateOre(ModBlocks.mod_block, (byte) 0, Blocks.stone, random, world, chunkX, chunkZ, 2, 10, 6, 15, 100);
    }

    public void generateEnd(World world, Random random, int chunkX, int chunkZ) {
        generateOre(ModBlocks.mod_block, (byte) 0, Blocks.end_stone, random, world, chunkX, chunkZ, 2, 10, 3, 2, 100);
    }

    public void generateOre(Block block, byte blockMeta, Block generateIn, Random random, World world, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY) {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;

        WorldGenMinable gen = new WorldGenMinable(block.getStateFromMeta(blockMeta), veinSize, BlockHelper.forBlock(generateIn));
        for (int i = 0 ; i < chance ; i++) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);

            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
        }
    }
}