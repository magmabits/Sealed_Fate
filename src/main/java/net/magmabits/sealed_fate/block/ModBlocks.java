package net.magmabits.sealed_fate.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.magmabits.sealed_fate.SealedFate;
import net.magmabits.sealed_fate.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block LUMINA_BLOCK = registerModBlock("lumina_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool())
    );
    public static final Block LUMINA_ORE = registerModBlock("lumina_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), UniformIntProvider.create(1,2))
    );

    public static void registerModBlocks() {
        SealedFate.LOGGER.debug("Registering blocks for " + SealedFate.MOD_ID);
    }

    private static Block registerModBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(SealedFate.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(SealedFate.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(ModItemGroup.SEALED_FATE)));
    }
}
