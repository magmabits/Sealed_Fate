package net.magmabits.sealed_fate.effect;

import net.magmabits.sealed_fate.SealedFate;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect DEVOTION;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(SealedFate.MOD_ID, name),
                new DevotionEffect(StatusEffectCategory.BENEFICIAL, 0x7069d1));
    }

    public static void registerEffects() {
        DEVOTION = registerStatusEffect("devotion");
    }
}
