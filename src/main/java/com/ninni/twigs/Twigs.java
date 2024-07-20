package com.ninni.twigs;

import com.google.common.reflect.Reflection;
import com.ninni.twigs.registry.*;
import com.ninni.twigs.stat.TwigsStats;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.LinkedHashMap;
import java.util.List;

public class Twigs implements ModInitializer {
	public static final String MOD_ID = "twigs";

	@Override
	public void onInitialize() {
		TwigsBiomeModifier.init();
		Reflection.initialize(
				TwigsEntityTypes.class,
				TwigsParticleTypes.class,
				TwigsItems.class,
				TwigsFeatures.class,
				TwigsCreativeModeTab.class,
				TwigsLootTableAdditions.class,
				TwigsBlocks.class,
				TwigsStats.class,
				TwigsBlockEntityType.class,
				TwigsSoundEvents.class,
				TwigsStructureTypes.class,
				TwigsStructurePieceTypes.class
		);
		DispenserBlock.registerProjectileBehavior(TwigsItems.PEBBLE);

		Util.make(new LinkedHashMap<Block, Block>(), pairs -> {
			pairs.put(TwigsBlocks.COPPER_PILLAR, TwigsBlocks.WAXED_COPPER_PILLAR);
			pairs.put(TwigsBlocks.EXPOSED_COPPER_PILLAR, TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR);
			pairs.put(TwigsBlocks.WEATHERED_COPPER_PILLAR, TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR);
			pairs.put(TwigsBlocks.OXIDIZED_COPPER_PILLAR, TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR);

			pairs.forEach(OxidizableBlocksRegistry::registerWaxableBlockPair);

			List<Block> unwaxed = List.copyOf(pairs.keySet());
			for (int i = 0, l = unwaxed.size(); i < l - 1; i++) {
				OxidizableBlocksRegistry.registerOxidizableBlockPair(unwaxed.get(i), unwaxed.get(i + 1));
			}
		});
	}
}
