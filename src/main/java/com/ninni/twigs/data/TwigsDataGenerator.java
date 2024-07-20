package com.ninni.twigs.data;

import com.ninni.twigs.data.tags.TwigsBiomeTagProvider;
import com.ninni.twigs.data.tags.TwigsBlockTagProvider;
import com.ninni.twigs.data.tags.TwigsEntityTypeTagProvider;
import com.ninni.twigs.data.tags.TwigsItemTagProvider;
import com.ninni.twigs.data.worldgen.TwigsConfiguredFeatureProvider;
import com.ninni.twigs.data.worldgen.TwigsPlacedFeatureProvider;
import com.ninni.twigs.data.worldgen.TwigsStructureProvider;
import com.ninni.twigs.registry.TwigsConfiguredFeatures;
import com.ninni.twigs.registry.TwigsPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.atomic.AtomicReference;

public class TwigsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TwigsConfiguredFeatureProvider::new);
        pack.addProvider(TwigsPlacedFeatureProvider::new);
        pack.addProvider(TwigsStructureProvider::new);

        pack.addProvider(TwigsChestLootTableProvider::new);

        // (ender) I don't know if there is a nicer way of doing this
        AtomicReference<TwigsBlockTagProvider> blockTags = new AtomicReference<>();
        pack.addProvider((o, r) -> {
            blockTags.set(new TwigsBlockTagProvider(o, r));
            return blockTags.get();
        });
        pack.addProvider((o, r) -> new TwigsItemTagProvider(o, r, blockTags.get()));
        pack.addProvider(TwigsEntityTypeTagProvider::new);
        pack.addProvider(TwigsBiomeTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TwigsConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, TwigsPlacedFeatures::bootstrap);

        registryBuilder.add(Registries.STRUCTURE, TwigsStructureProvider::bootstrapStructures);
        registryBuilder.add(Registries.TEMPLATE_POOL, TwigsStructureProvider::bootstrapTemplatePools);
        registryBuilder.add(Registries.STRUCTURE_SET, TwigsStructureProvider::bootstrapStructureSets);
    }
}
