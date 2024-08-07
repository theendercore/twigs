package com.ninni.twigs.data;

import com.ninni.twigs.Twigs;
import com.ninni.twigs.data.tags.TwigsBiomeTagProvider;
import com.ninni.twigs.data.tags.TwigsBlockTagProvider;
import com.ninni.twigs.data.tags.TwigsItemTagProvider;
import com.ninni.twigs.registry.TwigsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Twigs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TwigsDataGenerator {

    private TwigsDataGenerator() {
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        boolean server = event.includeServer();

        generator.addProvider(server, new TwigsDatapackBuiltinEntriesProviderOld(output, lookupProvider));


        // Tags
        TwigsBlockTagProvider blockTags = generator.addProvider(server, new TwigsBlockTagProvider(output, lookupProvider, fileHelper));
        generator.addProvider(server, new TwigsItemTagProvider(output, lookupProvider, blockTags.contentsGetter(), fileHelper));

        generator.addProvider(server, new TwigsBiomeTagProvider(output, lookupProvider, fileHelper));

    }

    public static List<Block> getModBlocks() {
        return TwigsBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }

}
