package net.magmabits.hydrosteel.effect;

import net.magmabits.hydrosteel.Hydrosteel;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect DROWNING;
    public static StatusEffects effects;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Hydrosteel.MOD_ID, name),
                new DrowningEffect(StatusEffectCategory.HARMFUL, 0x78d8fb)).addAttributeModifier(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "7107DE5E-7CE8-4030-940E-514C1F160890",
                -0.50000000596046448,
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
        );
    }

    public static void registerEffects() {
        DROWNING = registerStatusEffect("drowning");
    }
}
