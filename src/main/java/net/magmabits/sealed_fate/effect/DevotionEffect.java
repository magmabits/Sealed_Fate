package net.magmabits.sealed_fate.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DevotionEffect extends StatusEffect {
    public DevotionEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity livingEntity, int pAmplifier) {
        if (livingEntity.world.isClient()) {
            double x = livingEntity.getX();
            double y = livingEntity.getY();
            double z = livingEntity.getZ();

            livingEntity.teleport(x,y,z);
            livingEntity.setVelocity(0,0,0);
        }
        super.applyUpdateEffect(livingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
