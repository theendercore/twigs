package com.ninni.twigs;

import com.google.common.reflect.Reflection;
import com.ninni.twigs.registry.*;
import com.ninni.twigs.stat.TwigsStats;
import net.fabricmc.api.ModInitializer;

public class Twigs implements ModInitializer {
	public static final String MOD_ID = "twigs";

	@Override
	public void onInitialize() {
		TwigsBiomeModifier.init();
		Reflection.initialize(
				TwigsItems.class,
				TwigsCreativeModeTab.class,
				TwigsBlocks.class,
				TwigsStats.class,
				TwigsBlockEntityType.class,
				TwigsSoundEvents.class
		);
	}
}
