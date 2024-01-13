package net.magmabits.sealed_fate.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.magmabits.sealed_fate.SealedFate;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SEALED_FATE = FabricItemGroupBuilder.build(
            new Identifier(SealedFate.MOD_ID, "sealed_fate"), () -> new ItemStack(ModItems.LUMINA_ESSENCE));
}
