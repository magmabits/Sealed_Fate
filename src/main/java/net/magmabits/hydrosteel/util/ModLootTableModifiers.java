package net.magmabits.hydrosteel.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.magmabits.hydrosteel.Hydrosteel;
import net.magmabits.hydrosteel.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier BURIED_TREASURE_CHEST_ID = new Identifier("minecraft", "chests/buried_treasure");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BURIED_TREASURE_CHEST_ID.equals(id)) {
                LootPool.Builder ancientCoralBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.ANCIENT_CORAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                LootPool.Builder hydrosteelScrapBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.HYDROSTEEL_SCRAP))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());

                tableBuilder.pool(ancientCoralBuilder.build());
                tableBuilder.pool(hydrosteelScrapBuilder.build());
            }
        }));
    }
}
