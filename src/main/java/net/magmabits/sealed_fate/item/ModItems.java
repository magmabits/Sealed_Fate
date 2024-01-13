package net.magmabits.sealed_fate.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.magmabits.sealed_fate.SealedFate;
import net.magmabits.sealed_fate.custom.DestinedFateItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item DESTINED_FATE = registerItem("destined_fate",
            new DestinedFateItem(ToolMaterials.DIAMOND, 2, -2.4f, new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));

    public static final Item FATEFORGED_HELMET = registerItem("fateforged_helmet",
            new ArmorItem(ModArmorMaterial.FATEFORGED, EquipmentSlot.HEAD, new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));
    public static final Item FATEFORGED_CHESTPLATE = registerItem("fateforged_chestplate",
            new ModArmorItem(ModArmorMaterial.FATEFORGED, EquipmentSlot.CHEST, new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));
    public static final Item FATEFORGED_LEGGINGS = registerItem("fateforged_leggings",
            new ArmorItem(ModArmorMaterial.FATEFORGED, EquipmentSlot.LEGS, new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));
    public static final Item FATEFORGED_BOOTS = registerItem("fateforged_boots",
            new ArmorItem(ModArmorMaterial.FATEFORGED, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));

    public static final Item LUMINA_ESSENCE = registerItem("lumina_essence",
            new Item(new FabricItemSettings().fireproof().group(ModItemGroup.SEALED_FATE)));


    public static void registerModItems() {
        SealedFate.LOGGER.debug("Registering items for " + SealedFate.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SealedFate.MOD_ID, name), item);
    }
}
