package net.magmabits.hydrosteel.item;

import com.oroarmor.multiitemlib.api.UniqueItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.magmabits.hydrosteel.Hydrosteel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item HYDROSTEEL_SCRAP = registerItem("hydrosteel_scrap",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL)));
    public static final Item HYDROSTEEL_INGOT = registerItem("hydrosteel_ingot",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL)));
    public static final Item MOSSFORGED_TRIDENT = registerItem("mossforged_trident",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL)));

    public static void registerModItems() {
        Hydrosteel.LOGGER.debug("Registering items for " + Hydrosteel.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Hydrosteel.MOD_ID, name), item);
    }
}
