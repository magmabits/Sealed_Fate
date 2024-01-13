package net.magmabits.sealed_fate;

import net.fabricmc.api.ModInitializer;
import net.magmabits.sealed_fate.block.ModBlocks;
import net.magmabits.sealed_fate.effect.ModEffects;
import net.magmabits.sealed_fate.item.ModItems;
import net.magmabits.sealed_fate.world.feature.ModConfiguredFeatures;
import net.magmabits.sealed_fate.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SealedFate implements ModInitializer {
	public static final String MOD_ID = "sealed_fate";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();
		ModOreGeneration.generateOres();
	}
}
