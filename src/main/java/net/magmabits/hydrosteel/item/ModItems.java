package net.magmabits.hydrosteel.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.magmabits.hydrosteel.Hydrosteel;
import net.magmabits.hydrosteel.custom.CoralbladeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item HYDROSTEEL_SCRAP = registerItem("hydrosteel_scrap",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL)));
    public static final Item HYDROSTEEL_INGOT = registerItem("hydrosteel_ingot",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL)));
    public static final Item ANCIENT_CORAL = registerItem("ancient_coral",
            new Item(new FabricItemSettings().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.RARE)));

    public static final Item HYDROSTEEL_HELMET = registerItem("hydrosteel_helmet",
            new ArmorItem(ModArmorMaterial.HYDROSTEEL, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.UNCOMMON)));
    public static final Item HYDROSTEEL_CHESTPLATE = registerItem("hydrosteel_chestplate",
            new ModArmorItem(ModArmorMaterial.HYDROSTEEL, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.UNCOMMON)));
    public static final Item HYDROSTEEL_LEGGINGS = registerItem("hydrosteel_leggings",
            new ArmorItem(ModArmorMaterial.HYDROSTEEL, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.UNCOMMON)));
    public static final Item HYDROSTEEL_BOOTS = registerItem("hydrosteel_boots",
            new ArmorItem(ModArmorMaterial.HYDROSTEEL, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.UNCOMMON)));

    public static final Item CORALBLADE = registerItem("coralblade",
            new CoralbladeItem(ToolMaterials.DIAMOND, 4, -2.4f, new FabricItemSettings().fireproof().group(ModItemGroup.HYDROSTEEL).rarity(Rarity.RARE)));

    public static void registerModItems() {
        Hydrosteel.LOGGER.debug("Registering items for " + Hydrosteel.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Hydrosteel.MOD_ID, name), item);
    }
}
