package com.ninni.twigs.data;

import com.ninni.twigs.registry.TwigsBlocks;
import com.ninni.twigs.registry.TwigsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static com.ninni.twigs.Twigs.MOD_ID;
import static com.ninni.twigs.util.RecipeHelper.*;

public class TwigsRecipeProvider extends FabricRecipeProvider {
    public TwigsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, TwigsBlocks.AZALEA_FLOWERS, 6)
                .requires(Blocks.FLOWERING_AZALEA_LEAVES)
                .unlockedBy("has_azalea_leaves", has(Blocks.FLOWERING_AZALEA_LEAVES))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(MOD_ID, "azalea_flowers_from_flowering_azalea_leaves"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, TwigsBlocks.AZALEA_FLOWERS, 6)
                .requires(Blocks.FLOWERING_AZALEA)
                .unlockedBy("has_azalea", has(Blocks.FLOWERING_AZALEA))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(MOD_ID, "azalea_flowers_from_flowering_azalea"));


        bambooRecipes(exporter);
        paperLanternRecipes(exporter);
        lampRecipes(exporter);
        tableRecipes(exporter);

        cobblestoneBricksRecipes(exporter);
        twistingAndWeepingRecipes(exporter);
        polishedTuffRecipes(exporter);
        calciteRecipes(exporter);
        schistRecipes(exporter);
        rhyoliteRecipes(exporter);
        bloodstoneRecipes(exporter);
        coloredSiltRecipes(exporter);
    }

    private void bambooRecipes(RecipeOutput exporter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.BAMBOO_MAT, 2)
                .pattern("###")
                .define('#', Items.BAMBOO)
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .save(exporter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.BAMBOO_THATCH_SLAB, 6)
                .pattern("###")
                .define('#', TwigsBlocks.BAMBOO_THATCH)
                .unlockedBy("has_bamboo_thatch", has(TwigsBlocks.BAMBOO_THATCH))
                .save(exporter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.BAMBOO_THATCH, 2)
                .pattern("##")
                .pattern("##")
                .define('#', TwigsBlocks.BAMBOO_LEAVES)
                .unlockedBy("has_bamboo_leaves", has(TwigsBlocks.BAMBOO_LEAVES))
                .save(exporter);
    }

    private void paperLanternRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.PAPER_LANTERN, 1)
                .pattern("###")
                .pattern("#T#")
                .pattern("###")
                .define('#', Items.PAPER)
                .define('T', Items.TORCH)
                .unlockedBy("has_paper", has(Items.PAPER))
                .unlockedBy("has_torch", has(Items.TORCH))
                .save(exporter);
        quickPaperLanternRecipe(exporter, TwigsBlocks.ALLIUM_PAPER_LANTERN, Items.ALLIUM);
        quickPaperLanternRecipe(exporter, TwigsBlocks.BLUE_ORCHID_PAPER_LANTERN, Items.BLUE_ORCHID);
        quickPaperLanternRecipe(exporter, TwigsBlocks.CRIMSON_ROOTS_PAPER_LANTERN, Items.CRIMSON_ROOTS);
        quickPaperLanternRecipe(exporter, TwigsBlocks.DANDELION_PAPER_LANTERN, Items.DANDELION);
        quickPaperLanternRecipe(exporter, TwigsBlocks.TORCHFLOWER_PAPER_LANTERN, Items.TORCHFLOWER);
    }

    private void lampRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TwigsBlocks.LAMP, 1)
                .pattern("iii")
                .pattern("iTi")
                .pattern("iCi")
                .define('i', Items.IRON_INGOT)
                .define('T', Items.TORCH)
                .define('C', Items.COAL)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_torch", has(Items.TORCH))
                .unlockedBy("has_coal", has(Items.COAL))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TwigsBlocks.SOUL_LAMP, 1)
                .pattern("iii")
                .pattern("iSi")
                .pattern("iFi")
                .define('i', Items.IRON_INGOT)
                .define('S', Items.SOUL_TORCH)
                .define('F', Items.SOUL_SAND)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_soul_torch", has(Items.SOUL_TORCH))
                .unlockedBy("has_soul_sand", has(Items.SOUL_SAND))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TwigsBlocks.WARPED_SHROOMLAMP, 1)
                .pattern("###")
                .pattern("SSS")
                .pattern("###")
                .define('#', Items.WARPED_PLANKS)
                .define('S', Items.SHROOMLIGHT)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_shroomlight", has(Items.SHROOMLIGHT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TwigsBlocks.CRIMSON_SHROOMLAMP, 1)
                .pattern("###")
                .pattern("SSS")
                .pattern("###")
                .define('#', Items.CRIMSON_PLANKS)
                .define('S', Items.SHROOMLIGHT)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_shroomlight", has(Items.SHROOMLIGHT))
                .save(exporter);
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

    private void cobblestoneBricksRecipes(RecipeOutput exporter) {

        quick2x2Recipe(exporter, TwigsBlocks.COBBLESTONE_BRICKS, Blocks.COBBLESTONE);
        quickStonecuttingRecipe(exporter, TwigsBlocks.COBBLESTONE_BRICKS, Blocks.COBBLESTONE, 1);

        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.COBBLESTONE_BRICK_SLAB, TwigsBlocks.COBBLESTONE_BRICK_STAIRS, TwigsBlocks.COBBLESTONE_BRICK_WALL,
                TwigsBlocks.COBBLESTONE_BRICKS);
        quickSlabStairsWallStonecuttingRecipe(exporter,
                TwigsBlocks.COBBLESTONE_BRICK_SLAB, TwigsBlocks.COBBLESTONE_BRICK_STAIRS, TwigsBlocks.COBBLESTONE_BRICK_WALL,
                Blocks.COBBLESTONE);
        quickSmeltingRecipe(exporter, TwigsBlocks.CRACKED_COBBLESTONE_BRICKS, TwigsBlocks.COBBLESTONE_BRICKS);

        // this is a new recipe yes but it makes sense
        quick2x2Recipe(exporter, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS, Blocks.MOSSY_COBBLESTONE);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS)
                .requires(TwigsBlocks.COBBLESTONE_BRICKS)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_cobblestone_bricks", has(TwigsBlocks.COBBLESTONE_BRICKS))
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(exporter, ResourceLocation.fromNamespaceAndPath(MOD_ID, "mossy_cobblestone_bricks_from_moss"));
        quickStonecuttingRecipe(exporter, TwigsBlocks.MOSSY_COBBLESTONE_BRICKS, Blocks.MOSSY_COBBLESTONE, 1);
        quickSlabStairsWallRecipe(exporter,
                TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL,
                TwigsBlocks.MOSSY_COBBLESTONE_BRICKS);
        quickSlabStairsWallStonecuttingRecipe(exporter,
                TwigsBlocks.MOSSY_COBBLESTONE_BRICK_SLAB, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_STAIRS, TwigsBlocks.MOSSY_COBBLESTONE_BRICK_WALL,
                Blocks.MOSSY_COBBLESTONE);
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

    private void siltRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.SILT, 4)
                .pattern("DG")
                .pattern("GD")
                .define('D', Items.SAND)
                .define('G', Items.CLAY)
                .unlockedBy("has_sand", has(Items.SAND))
                .unlockedBy("has_clay", has(Items.CLAY))
                .unlockedBy("has_silt", has(TwigsBlocks.SILT))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.PACKED_SILT, 4)
                .requires(TwigsBlocks.SILT)
                .requires(Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .unlockedBy("has_silt", has(TwigsBlocks.SILT))
                .unlockedBy("has_packed_silt", has(TwigsBlocks.PACKED_SILT))
                .save(exporter);

        quickPolishedRecipes(
                exporter,
                TwigsBlocks.SILT_SHINGLES,
                TwigsBlocks.SILT_SHINGLE_SLAB, TwigsBlocks.SILT_SHINGLE_STAIRS, TwigsBlocks.SILT_SHINGLE_WALL,
                TwigsBlocks.PACKED_SILT
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.SILT_POT, 0)
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .define('#', TwigsBlocks.SILT_BRICKS)
                .unlockedBy("has_packed_silt", has(TwigsBlocks.PACKED_SILT))
                .unlockedBy("has_silt", has(TwigsBlocks.SILT))
                .save(exporter);

    }

    private void coloredSiltRecipes(RecipeOutput exporter) {
        quickColoredSiltRecipes(exporter,
                Items.WHITE_DYE, TwigsBlocks.WHITE_PACKED_SILT,
                TwigsBlocks.WHITE_SILT_SHINGLES, TwigsBlocks.WHITE_SILT_SHINGLE_STAIRS, TwigsBlocks.WHITE_SILT_SHINGLE_SLAB, TwigsBlocks.WHITE_SILT_SHINGLE_WALL,
                TwigsBlocks.WHITE_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.ORANGE_DYE, TwigsBlocks.ORANGE_PACKED_SILT,
                TwigsBlocks.ORANGE_SILT_SHINGLES, TwigsBlocks.ORANGE_SILT_SHINGLE_STAIRS, TwigsBlocks.ORANGE_SILT_SHINGLE_SLAB, TwigsBlocks.ORANGE_SILT_SHINGLE_WALL,
                TwigsBlocks.ORANGE_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.MAGENTA_DYE, TwigsBlocks.MAGENTA_PACKED_SILT,
                TwigsBlocks.MAGENTA_SILT_SHINGLES, TwigsBlocks.MAGENTA_SILT_SHINGLE_STAIRS, TwigsBlocks.MAGENTA_SILT_SHINGLE_SLAB, TwigsBlocks.MAGENTA_SILT_SHINGLE_WALL,
                TwigsBlocks.MAGENTA_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.LIGHT_BLUE_DYE, TwigsBlocks.LIGHT_BLUE_PACKED_SILT,
                TwigsBlocks.LIGHT_BLUE_SILT_SHINGLES, TwigsBlocks.LIGHT_BLUE_SILT_SHINGLE_STAIRS, TwigsBlocks.LIGHT_BLUE_SILT_SHINGLE_SLAB, TwigsBlocks.LIGHT_BLUE_SILT_SHINGLE_WALL,
                TwigsBlocks.LIGHT_BLUE_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.YELLOW_DYE, TwigsBlocks.YELLOW_PACKED_SILT,
                TwigsBlocks.YELLOW_SILT_SHINGLES, TwigsBlocks.YELLOW_SILT_SHINGLE_STAIRS, TwigsBlocks.YELLOW_SILT_SHINGLE_SLAB, TwigsBlocks.YELLOW_SILT_SHINGLE_WALL,
                TwigsBlocks.YELLOW_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.LIME_DYE, TwigsBlocks.LIME_PACKED_SILT,
                TwigsBlocks.LIME_SILT_SHINGLES, TwigsBlocks.LIME_SILT_SHINGLE_STAIRS, TwigsBlocks.LIME_SILT_SHINGLE_SLAB, TwigsBlocks.LIME_SILT_SHINGLE_WALL,
                TwigsBlocks.LIME_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.PINK_DYE, TwigsBlocks.PINK_PACKED_SILT,
                TwigsBlocks.PINK_SILT_SHINGLES, TwigsBlocks.PINK_SILT_SHINGLE_STAIRS, TwigsBlocks.PINK_SILT_SHINGLE_SLAB, TwigsBlocks.PINK_SILT_SHINGLE_WALL,
                TwigsBlocks.PINK_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.GRAY_DYE, TwigsBlocks.GRAY_PACKED_SILT,
                TwigsBlocks.GRAY_SILT_SHINGLES, TwigsBlocks.GRAY_SILT_SHINGLE_STAIRS, TwigsBlocks.GRAY_SILT_SHINGLE_SLAB, TwigsBlocks.GRAY_SILT_SHINGLE_WALL,
                TwigsBlocks.GRAY_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.LIGHT_GRAY_DYE, TwigsBlocks.LIGHT_GRAY_PACKED_SILT,
                TwigsBlocks.LIGHT_GRAY_SILT_SHINGLES, TwigsBlocks.LIGHT_GRAY_SILT_SHINGLE_STAIRS, TwigsBlocks.LIGHT_GRAY_SILT_SHINGLE_SLAB, TwigsBlocks.LIGHT_GRAY_SILT_SHINGLE_WALL,
                TwigsBlocks.LIGHT_GRAY_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.CYAN_DYE, TwigsBlocks.CYAN_PACKED_SILT,
                TwigsBlocks.CYAN_SILT_SHINGLES, TwigsBlocks.CYAN_SILT_SHINGLE_STAIRS, TwigsBlocks.CYAN_SILT_SHINGLE_SLAB, TwigsBlocks.CYAN_SILT_SHINGLE_WALL,
                TwigsBlocks.CYAN_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.PURPLE_DYE, TwigsBlocks.PURPLE_PACKED_SILT,
                TwigsBlocks.PURPLE_SILT_SHINGLES, TwigsBlocks.PURPLE_SILT_SHINGLE_STAIRS, TwigsBlocks.PURPLE_SILT_SHINGLE_SLAB, TwigsBlocks.PURPLE_SILT_SHINGLE_WALL,
                TwigsBlocks.PURPLE_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.BLUE_DYE, TwigsBlocks.BLUE_PACKED_SILT,
                TwigsBlocks.BLUE_SILT_SHINGLES, TwigsBlocks.BLUE_SILT_SHINGLE_STAIRS, TwigsBlocks.BLUE_SILT_SHINGLE_SLAB, TwigsBlocks.BLUE_SILT_SHINGLE_WALL,
                TwigsBlocks.BLUE_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.BROWN_DYE, TwigsBlocks.BROWN_PACKED_SILT,
                TwigsBlocks.BROWN_SILT_SHINGLES, TwigsBlocks.BROWN_SILT_SHINGLE_STAIRS, TwigsBlocks.BROWN_SILT_SHINGLE_SLAB, TwigsBlocks.BROWN_SILT_SHINGLE_WALL,
                TwigsBlocks.BROWN_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.GREEN_DYE, TwigsBlocks.GREEN_PACKED_SILT,
                TwigsBlocks.GREEN_SILT_SHINGLES, TwigsBlocks.GREEN_SILT_SHINGLE_STAIRS, TwigsBlocks.GREEN_SILT_SHINGLE_SLAB, TwigsBlocks.GREEN_SILT_SHINGLE_WALL,
                TwigsBlocks.GREEN_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.RED_DYE, TwigsBlocks.RED_PACKED_SILT,
                TwigsBlocks.RED_SILT_SHINGLES, TwigsBlocks.RED_SILT_SHINGLE_STAIRS, TwigsBlocks.RED_SILT_SHINGLE_SLAB, TwigsBlocks.RED_SILT_SHINGLE_WALL,
                TwigsBlocks.RED_SILT_POT
        );
        quickColoredSiltRecipes(exporter,
                Items.BLACK_DYE, TwigsBlocks.BLACK_PACKED_SILT,
                TwigsBlocks.BLACK_SILT_SHINGLES, TwigsBlocks.BLACK_SILT_SHINGLE_STAIRS, TwigsBlocks.BLACK_SILT_SHINGLE_SLAB, TwigsBlocks.BLACK_SILT_SHINGLE_WALL,
                TwigsBlocks.BLACK_SILT_POT
        );
    }

}
