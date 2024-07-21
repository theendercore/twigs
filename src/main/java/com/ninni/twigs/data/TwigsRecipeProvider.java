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

        twistingAndWeepingRecipes(exporter);
        polishedTuffRecipes(exporter);
        calciteRecipes(exporter);
        schistRecipes(exporter);
        rhyoliteRecipes(exporter);
        bloodstoneRecipes(exporter);
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

    private void twistingAndWeepingRecipes(RecipeOutput exporter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS, 8)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', Blocks.POLISHED_BLACKSTONE_BRICKS)
                .define('T', Items.TWISTING_VINES)
                .unlockedBy("has_polished_blackstone_bricks", has(Blocks.POLISHED_BLACKSTONE_BRICKS))
                .unlockedBy("has_twisting_vines", has(Items.TWISTING_VINES))
                .save(exporter);
        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_SLAB,
                TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_STAIRS,
                TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICK_WALL,
                TwigsBlocks.TWISTING_POLISHED_BLACKSTONE_BRICKS
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS, 8)
                .pattern("###")
                .pattern("#W#")
                .pattern("###")
                .define('#', Blocks.POLISHED_BLACKSTONE_BRICKS)
                .define('W', Items.WEEPING_VINES)
                .unlockedBy("has_polished_blackstone_bricks", has(Blocks.POLISHED_BLACKSTONE_BRICKS))
                .unlockedBy("has_weeping_vines", has(Items.WEEPING_VINES))
                .save(exporter);
        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB,
                TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS,
                TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL,
                TwigsBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS
        );
    }

    private void polishedTuffRecipes(RecipeOutput exporter) {
        quickPolishedRecipes(exporter, TwigsBlocks.POLISHED_TUFF,
                TwigsBlocks.POLISHED_TUFF_SLAB, TwigsBlocks.POLISHED_TUFF_STAIRS, Blocks.TUFF);

        quickPolishedBrickRecipes(exporter, TwigsBlocks.POLISHED_TUFF_BRICKS,
                TwigsBlocks.POLISHED_TUFF_BRICK_SLAB, TwigsBlocks.POLISHED_TUFF_BRICK_STAIRS, TwigsBlocks.POLISHED_TUFF_BRICK_WALL,
                TwigsBlocks.POLISHED_TUFF, Blocks.TUFF);

        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_POLISHED_TUFF_BRICKS, TwigsBlocks.POLISHED_TUFF_BRICKS);
    }


    private void calciteRecipes(RecipeOutput exporter) {
        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.CALCITE_SLAB, TwigsBlocks.CALCITE_STAIRS, TwigsBlocks.CALCITE_WALL, Blocks.CALCITE);

        quickPolishedRecipes(exporter, TwigsBlocks.POLISHED_CALCITE,
                TwigsBlocks.POLISHED_CALCITE_SLAB, TwigsBlocks.POLISHED_CALCITE_STAIRS, Blocks.CALCITE);

        quickPolishedBrickRecipes(exporter, TwigsBlocks.POLISHED_CALCITE_BRICKS,
                TwigsBlocks.POLISHED_CALCITE_BRICK_SLAB, TwigsBlocks.POLISHED_CALCITE_BRICK_STAIRS, TwigsBlocks.POLISHED_CALCITE_BRICK_WALL,
                TwigsBlocks.POLISHED_CALCITE, Blocks.CALCITE);

        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_POLISHED_CALCITE_BRICKS, TwigsBlocks.POLISHED_CALCITE_BRICKS);
    }

    private void schistRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.SCHIST, 2)
                .pattern("#C")
                .pattern("C#")
                .define('#', Items.QUARTZ)
                .define('C', Items.CLAY_BALL)
                .unlockedBy("has_red_sand", has(Blocks.RED_SAND))
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .save(exporter);

        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.SCHIST_SLAB, TwigsBlocks.SCHIST_STAIRS, TwigsBlocks.SCHIST_WALL, TwigsBlocks.SCHIST);

        quickPolishedRecipes(exporter, TwigsBlocks.POLISHED_SCHIST,
                TwigsBlocks.POLISHED_SCHIST_SLAB, TwigsBlocks.POLISHED_SCHIST_STAIRS, TwigsBlocks.SCHIST);

        quickPolishedBrickRecipes(exporter, TwigsBlocks.POLISHED_SCHIST_BRICKS,
                TwigsBlocks.POLISHED_SCHIST_BRICK_SLAB, TwigsBlocks.POLISHED_SCHIST_BRICK_STAIRS, TwigsBlocks.POLISHED_SCHIST_BRICK_WALL,
                TwigsBlocks.POLISHED_SCHIST, TwigsBlocks.SCHIST);

        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_POLISHED_SCHIST_BRICKS, TwigsBlocks.POLISHED_SCHIST_BRICKS);
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

        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_POLISHED_RHYOLITE_BRICKS, TwigsBlocks.POLISHED_RHYOLITE_BRICKS);
    }


    private void bloodstoneRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.BLOODSTONE, 2)
                .pattern("#I")
                .pattern("I#")
                .define('#', Items.QUARTZ)
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("has_red_sand", has(Blocks.RED_SAND))
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(exporter);

        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.BLOODSTONE_SLAB, TwigsBlocks.BLOODSTONE_STAIRS, TwigsBlocks.BLOODSTONE_WALL, TwigsBlocks.BLOODSTONE);

        quickPolishedRecipes(exporter, TwigsBlocks.POLISHED_BLOODSTONE,
                TwigsBlocks.POLISHED_BLOODSTONE_SLAB, TwigsBlocks.POLISHED_BLOODSTONE_STAIRS, TwigsBlocks.BLOODSTONE);

        quickPolishedBrickRecipes(exporter, TwigsBlocks.POLISHED_BLOODSTONE_BRICKS,
                TwigsBlocks.POLISHED_BLOODSTONE_BRICK_SLAB, TwigsBlocks.POLISHED_BLOODSTONE_BRICK_STAIRS, TwigsBlocks.POLISHED_BLOODSTONE_BRICK_WALL,
                TwigsBlocks.POLISHED_BLOODSTONE, TwigsBlocks.BLOODSTONE);

        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_POLISHED_BLOODSTONE_BRICKS, TwigsBlocks.POLISHED_BLOODSTONE_BRICKS);
    }

}
