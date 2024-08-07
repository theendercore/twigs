package com.ninni.twigs.data;

import com.ninni.twigs.data.tags.TwigsBiomeTagProvider;
import com.ninni.twigs.data.tags.TwigsBlockTagProvider;
import com.ninni.twigs.data.tags.TwigsEntityTypeTagProvider;
import com.ninni.twigs.data.tags.TwigsItemTagProvider;
import com.ninni.twigs.data.worldgen.TwigsConfiguredFeatureProvider;
import com.ninni.twigs.data.worldgen.TwigsPlacedFeatureProvider;
import com.ninni.twigs.data.worldgen.TwigsStructureProvider;
import com.ninni.twigs.registry.TwigsBlocks;
import com.ninni.twigs.registry.TwigsConfiguredFeatures;
import com.ninni.twigs.registry.TwigsPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import static com.ninni.twigs.Twigs.MOD_ID;

public class TwigsDataGeneratorFabric implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TwigsConfiguredFeatureProvider::new);
        pack.addProvider(TwigsPlacedFeatureProvider::new);
        pack.addProvider(TwigsStructureProvider::new);

        pack.addProvider(TwigsChestLootTableProvider::new);
        pack.addProvider(TwigsBlockLootTableProvider::new);

        TwigsBlockTagProvider blockTags = pack.addProvider(TwigsBlockTagProvider::new);
        pack.addProvider((o, r) -> new TwigsItemTagProvider(o, r, blockTags));
        pack.addProvider(TwigsEntityTypeTagProvider::new);
        pack.addProvider(TwigsBiomeTagProvider::new);

        pack.addProvider(TwigsRecipeProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TwigsConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, TwigsPlacedFeatures::bootstrap);

        registryBuilder.add(Registries.STRUCTURE, TwigsStructureProvider::bootstrapStructures);
        registryBuilder.add(Registries.TEMPLATE_POOL, TwigsStructureProvider::bootstrapTemplatePools);
        registryBuilder.add(Registries.STRUCTURE_SET, TwigsStructureProvider::bootstrapStructureSets);
    }

    public static List<Block> getModBlocks() {
        return TwigsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }

    public static ResourceLocation getId(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    public static ResourceLocation getId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}