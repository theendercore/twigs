package com.ninni.twigs.data;

import com.ninni.twigs.registry.TwigsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static com.ninni.twigs.util.RecipeHelper.*;

public class TwigsRecipeProvider extends FabricRecipeProvider {
    public TwigsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        tableRecipes(exporter);

        rhyoliteRecipes(exporter);
    }

    private void tableRecipes(RecipeOutput exporter) {
        quickTableRecipe(exporter, TwigsBlocks.ACACIA_TABLE, Blocks.ACACIA_SLAB, Blocks.ACACIA_FENCE, Blocks.ACACIA_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.BAMBOO_TABLE, Blocks.BAMBOO_SLAB, Blocks.BAMBOO_FENCE, Blocks.BAMBOO_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.BIRCH_TABLE, Blocks.BIRCH_SLAB, Blocks.BIRCH_FENCE, Blocks.BIRCH_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.CHERRY_TABLE, Blocks.CHERRY_SLAB, Blocks.CHERRY_FENCE, Blocks.CHERRY_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.CRIMSON_TABLE, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_FENCE, Blocks.CRIMSON_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.DARK_OAK_TABLE, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_FENCE, Blocks.DARK_OAK_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.JUNGLE_TABLE, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_FENCE, Blocks.JUNGLE_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.MANGROVE_TABLE, Blocks.MANGROVE_SLAB, Blocks.MANGROVE_FENCE, Blocks.MANGROVE_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.OAK_TABLE, Blocks.OAK_SLAB, Blocks.OAK_FENCE, Blocks.OAK_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.SPRUCE_TABLE, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_FENCE, Blocks.SPRUCE_PLANKS);
        quickTableRecipe(exporter, TwigsBlocks.WARPED_TABLE, Blocks.WARPED_SLAB, Blocks.WARPED_FENCE, Blocks.WARPED_PLANKS);
    }

    private void rhyoliteRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.RHYOLITE, 2)
                .pattern("#R")
                .pattern("R#")
                .define('#', Items.QUARTZ)
                .define('R', Blocks.RED_SAND)
                .unlockedBy("has_quartz", has(Items.QUARTZ))
                .unlockedBy("has_red_sand", has(Blocks.RED_SAND))
                .save(exporter);

        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.RHYOLITE_SLAB, TwigsBlocks.RHYOLITE_STAIRS, TwigsBlocks.RHYOLITE_WALL, TwigsBlocks.RHYOLITE);

        quickPolishedRecipes(exporter, TwigsBlocks.POLISHED_RHYOLITE,
                TwigsBlocks.POLISHED_RHYOLITE_SLAB, TwigsBlocks.POLISHED_RHYOLITE_STAIRS, TwigsBlocks.RHYOLITE);

        quickPolishedBrickRecipes(exporter, TwigsBlocks.POLISHED_RHYOLITE_BRICKS,
                TwigsBlocks.POLISHED_RHYOLITE_BRICK_SLAB, TwigsBlocks.POLISHED_RHYOLITE_BRICK_STAIRS, TwigsBlocks.POLISHED_RHYOLITE_BRICK_WALL,
                TwigsBlocks.POLISHED_RHYOLITE, TwigsBlocks.RHYOLITE);

    }

}
