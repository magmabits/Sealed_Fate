package net.magmabits.sealed_fate.world.feature;

import net.magmabits.sealed_fate.SealedFate;
import net.magmabits.sealed_fate.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> END_LUMINA_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.LUMINA_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_LUMINA_ORE =
            ConfiguredFeatures.register("end_lumina_ore", Feature.ORE, new OreFeatureConfig(END_LUMINA_ORES, 6));

    public static void registerConfiguredFeatures() {
        SealedFate.LOGGER.debug("Registering the mod configured features for " + SealedFate.MOD_ID);
    }
}
