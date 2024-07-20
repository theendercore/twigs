package com.ninni.twigs.util;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import static com.ninni.twigs.Twigs.MOD_ID;
import static net.minecraft.data.recipes.RecipeCategory.BUILDING_BLOCKS;
import static net.minecraft.data.recipes.RecipeProvider.*;

public interface RecipeHelper {
    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private static ResourceLocation smeltingName(ItemLike item, ItemLike from) {
        return id("smelting/" + getItemName(item) + "_from_" + getItemName(from) + "_smelting");
    }

    private static ResourceLocation smokingName(ItemLike item, ItemLike from) {
        return id("smoking/" + getItemName(item) + "_from_" + getItemName(from) + "_smoking");
    }

    private static ResourceLocation smokingName(ItemLike item, String from) {
        return id("smoking/" + getItemName(item) + "_from_" + from + "_smoking");
    }

    private static ResourceLocation blastingName(ItemLike item, ItemLike from) {
        return id("blasting/" + getItemName(item) + "_from_" + getItemName(from) + "_blasting");
    }

    private static ResourceLocation cuttingName(ItemLike item, ItemLike from) {
        var string = getItemName(item) + "_from_" + getItemName(from);
        return id("stonecutting/" + string);
    }

    static void quickStonecuttingRecipe(RecipeOutput output, ItemLike from, ItemLike result, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(from), BUILDING_BLOCKS, result, amount)
                .unlockedBy(getHasName(from), has(from))
                .save(output, cuttingName(result, from));
    }

    static void quickSmeltingRecipe(RecipeOutput output, ItemLike result, ItemLike from) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(from), BUILDING_BLOCKS, result, .1f, 200)
                .unlockedBy(getHasName(from), has(from))
                .save(output, smeltingName(result, from));
    }

    static void quickSmokingRecipe(RecipeOutput output, ItemLike result, ItemLike from) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(from), BUILDING_BLOCKS, result, .1f, 100)
                .unlockedBy(getHasName(from), has(from))
                .save(output, smokingName(result, from));
    }

    static void quickSmokingRecipe(RecipeOutput output, ItemLike result, TagKey<Item> from) {
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(from), BUILDING_BLOCKS, result, .1f, 100)
                .unlockedBy("has_" + from.location().getPath(), has(from))
                .save(output, smokingName(result, from.location().getPath()));
    }

    static void quickBlastingRecipe(RecipeOutput output, ItemLike result, ItemLike from) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(from), BUILDING_BLOCKS, result, .1f, 100)
                .unlockedBy(getHasName(from), has(from))
                .save(output, blastingName(result, from));
    }

    // Semi-generic recipes

    static void quickSlabStairsRecipe(RecipeOutput output, ItemLike slab, ItemLike stair, ItemLike input) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, slab, 6)
                .pattern("---")
                .define('-', input)
                .unlockedBy(getHasName(input), has(input))
                .save(output);
        quickStonecuttingRecipe(output, slab, input, 2);

        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, stair, 4)
                .pattern("o  ")
                .pattern("oo ")
                .pattern("ooo")
                .define('o', input)
                .unlockedBy(getHasName(input), has(input))
                .save(output);
        quickStonecuttingRecipe(output, stair, input, 1);

    }

    static void quickSlabStairsWallRecipe(RecipeOutput output, ItemLike slab, ItemLike stair, ItemLike wall, ItemLike input) {
        quickSlabStairsRecipe(output, slab, stair, input);

        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, wall, 6)
                .pattern("---")
                .pattern("---")
                .define('-', input)
                .unlockedBy(getHasName(input), has(input))
                .save(output);
       quickStonecuttingRecipe(output, wall, input, 1);
    }


    // Specific recipes
    static void quickTableRecipe(RecipeOutput output, ItemLike result, ItemLike slab, ItemLike fence, ItemLike plank) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, result, 1)
                .pattern("___")
                .pattern("O O")
                .pattern("O O")
                .define('_', slab)
                .define('O', fence)
                .unlockedBy(getHasName(slab), has(slab))
                .unlockedBy(getHasName(fence), has(fence))
                .unlockedBy(getHasName(plank), has(plank))
                .save(output);
    }
}
