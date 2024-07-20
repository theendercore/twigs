package com.ninni.twigs.data.tags;

import com.ninni.twigs.TwigsTags;
import com.ninni.twigs.registry.TwigsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.ninni.twigs.Twigs.MOD_ID;

public class TwigsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public TwigsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        flowerTags();
        microBlockTags();
        mineableTags();


        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
                .add(TwigsBlocks.POLISHED_AMETHYST)
                .add(TwigsBlocks.CUT_AMETHYST);
        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .add(TwigsBlocks.PETRIFIED_LICHEN)
                .add(TwigsBlocks.BRICK_TRAIL)
                .add(TwigsBlocks.SILT_BRICK_TRAIL)
                .add(TwigsBlocks.AZALEA_FLOWERS);
        getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
                .add(TwigsBlocks.SOUL_LAMP);
    }

    private void flowerTags() {
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(TwigsBlocks.AZALEA_FLOWERS);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(TwigsBlocks.POTTED_AZALEA_FLOWERS);

        // (ender) replaceable_plants got replaced by replaceable_by_trees in 1.20,
        // but I feel like these 2 items should also be in replaceable
        // also replaceable is referenced in enchantment_power_transmitter

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(TwigsBlocks.AZALEA_FLOWERS)
                .add(TwigsBlocks.PETRIFIED_LICHEN);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .add(TwigsBlocks.AZALEA_FLOWERS)
                .add(TwigsBlocks.PETRIFIED_LICHEN);
    }

    private void microBlockTags() {
        var stairsTag = getOrCreateTagBuilder(BlockTags.STAIRS);
        var slabTag = getOrCreateTagBuilder(BlockTags.SLABS);
        var wallTag = getOrCreateTagBuilder(BlockTags.WALLS);
        for (Block block : getModBlocks()) {
            if (block instanceof StairBlock) stairsTag.add(block);
            else if (block instanceof SlabBlock) slabTag.add(block);
            else if (block instanceof WallBlock) wallTag.add(block);
        }
    }

    private void mineableTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .forceAddTag(TwigsTags.TABLES_BLOCK)
                .add(TwigsBlocks.CRIMSON_SHROOMLAMP)
                .add(TwigsBlocks.WARPED_SHROOMLAMP);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(TwigsBlocks.ROCKY_DIRT)
                .add(TwigsBlocks.SILT);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TwigsBlocks.LAMP)
                .add(TwigsBlocks.SOUL_LAMP)
                .add(TwigsBlocks.POLISHED_BASALT_BRICKS)
                .add(TwigsBlocks.CHISELED_SMOOTH_BASALT_BRICKS)
                .add(TwigsBlocks.SMOOTH_BASALT_BRICKS)
                .add(TwigsBlocks.SMOOTH_BASALT_BRICK_STAIRS)
                .add(TwigsBlocks.SMOOTH_BASALT_BRICK_SLAB)
                .add(TwigsBlocks.SMOOTH_BASALT_BRICK_WALL)
                .add(TwigsBlocks.MIXED_BRICKS)
                .add(TwigsBlocks.CHISELED_BRICKS)
                .add(TwigsBlocks.CRACKED_BRICKS)
                .add(TwigsBlocks.MOSSY_BRICKS)
                .add(TwigsBlocks.MOSSY_BRICK_STAIRS)
                .add(TwigsBlocks.MOSSY_BRICK_SLAB)
                .add(TwigsBlocks.MOSSY_BRICK_WALL)
                .add(TwigsBlocks.POLISHED_AMETHYST)
                .add(TwigsBlocks.CUT_AMETHYST)
                .add(TwigsBlocks.COBBLESTONE_BRICKS)
                .add(TwigsBlocks.COBBLESTONE_BRICK_SLAB)
                .add(TwigsBlocks.COBBLESTONE_BRICK_STAIRS)
                .add(TwigsBlocks.COBBLESTONE_BRICK_WALL)
                .add(TwigsBlocks.CRACKED_COBBLESTONE_BRICKS)
                .add(TwigsBlocks.MOSSY_COBBLESTONE_BRICKS)
                .add(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB)
                .add(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS)
                .add(TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL)
                .add(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS)
                .add(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB)
                .add(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS)
                .add(TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL)
                .add(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS)
                .add(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS)
                .add(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB)
                .add(TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL)
                .add(TwigsBlocks.POLISHED_TUFF)
                .add(TwigsBlocks.POLISHED_TUFF_STAIRS)
                .add(TwigsBlocks.POLISHED_TUFF_SLAB)
                .add(TwigsBlocks.POLISHED_TUFF_BRICKS)
                .add(TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS)
                .add(TwigsBlocks.POLISHED_TUFF_BRICK_SLAB)
                .add(TwigsBlocks.POLISHED_TUFF_BRICK_WALL)
                .add(TwigsBlocks.CRACKED_POLISHED_TUFF_BRICKS)
                .add(TwigsBlocks.CALCITE_STAIRS)
                .add(TwigsBlocks.CALCITE_SLAB)
                .add(TwigsBlocks.CALCITE_WALL)
                .add(TwigsBlocks.POLISHED_CALCITE)
                .add(TwigsBlocks.POLISHED_CALCITE_STAIRS)
                .add(TwigsBlocks.POLISHED_CALCITE_SLAB)
                .add(TwigsBlocks.POLISHED_CALCITE_BRICKS)
                .add(TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS)
                .add(TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB)
                .add(TwigsBlocks.POLISHED_CALCITE_BRICK_WALL)
                .add(TwigsBlocks.CRACKED_POLISHED_CALCITE_BRICKS)
                .forceAddTag(TwigsTags.SCHIST_BLOCK)
                .forceAddTag(TwigsTags.RHYOLITE_BLOCK)
                .forceAddTag(TwigsTags.BLOODSTONE_BLOCK)
                .add(TwigsBlocks.ROCKY_DIRT)
                .forceAddTag(TwigsTags.PACKED_SILT_BLOCK)
                .forceAddTag(TwigsTags.SILT_POTS_BLOCK)
                .add(TwigsBlocks.GRAVEL_BRICKS)
                .add(TwigsBlocks.GRAVEL_BRICK_STAIRS)
                .add(TwigsBlocks.GRAVEL_BRICK_SLAB)
                .add(TwigsBlocks.GRAVEL_BRICK_WALL)
                .add(TwigsBlocks.SILT_BRICKS)
                .add(TwigsBlocks.SILT_BRICK_STAIRS)
                .add(TwigsBlocks.SILT_BRICK_SLAB)
                .add(TwigsBlocks.SILT_BRICK_WALL)
                .add(TwigsBlocks.MIXED_SILT_BRICKS)
                .add(TwigsBlocks.CHISELED_SILT_BRICKS)
                .add(TwigsBlocks.CRACKED_SILT_BRICKS)
                .add(TwigsBlocks.COMPACTED_DRIPSTONE)
                .add(TwigsBlocks.SMOOTH_STONE_BRICKS)
                .add(TwigsBlocks.SMOOTH_STONE_BRICK_STAIRS)
                .add(TwigsBlocks.SMOOTH_STONE_BRICK_SLAB)
                .add(TwigsBlocks.SMOOTH_STONE_BRICK_WALL)
                .add(TwigsBlocks.QUARTZ_COLUMN)
                .add(TwigsBlocks.STONE_COLUMN)
                .add(TwigsBlocks.DEEPSLATE_COLUMN)
                .add(TwigsBlocks.BLACKSTONE_COLUMN)
                .add(TwigsBlocks.PETRIFIED_LICHEN)
                .add(TwigsBlocks.COPPER_PILLAR)
                .add(TwigsBlocks.EXPOSED_COPPER_PILLAR)
                .add(TwigsBlocks.WEATHERED_COPPER_PILLAR)
                .add(TwigsBlocks.OXIDIZED_COPPER_PILLAR)
                .add(TwigsBlocks.WAXED_COPPER_PILLAR)
                .add(TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR)
                .add(TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR)
                .add(TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR);
    }


    private List<Block> getModBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> getId(block).getNamespace().equals(MOD_ID)).toList();
    }

    private ResourceLocation getId(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
