package net.magmabits.hydrosteel;

import net.fabricmc.api.ModInitializer;
import net.magmabits.hydrosteel.block.ModBlocks;
import net.magmabits.hydrosteel.effect.ModEffects;
import net.magmabits.hydrosteel.item.ModItems;
import net.magmabits.hydrosteel.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hydrosteel implements ModInitializer {
	public static final String MOD_ID = "hydrosteel";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();
	}
}
