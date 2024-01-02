package net.magmabits.hydrosteel;

import com.oroarmor.multiitemlib.api.UniqueItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.magmabits.hydrosteel.block.ModBlocks;
import net.magmabits.hydrosteel.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.magmabits.hydrosteel.item.ModItems.MOSSFORGED_TRIDENT;


// Very important comment
public class Hydrosteel implements ModInitializer {
	public static final String MOD_ID = "hydrosteel";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		registerItemsWithMultiItemLib();
	}

	public static void registerItemsWithMultiItemLib() {
		UniqueItemRegistry.TRIDENT.addItemToRegistry(MOSSFORGED_TRIDENT);
	}
}
