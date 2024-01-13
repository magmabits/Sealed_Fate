package net.magmabits.sealed_fate.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class DestinedFateItem extends SwordItem {
    private static final HashMap<PlayerEntity, Long> cooldownMap = new HashMap<>();
    private static final long COOLDOWN_DURATION = 15 * 1000; // 30 seconds in milliseconds

    public DestinedFateItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) attacker;

        if (!cooldownMap.containsKey(player) || System.currentTimeMillis() - cooldownMap.get(player) >= COOLDOWN_DURATION) {
            // The ability is not on cooldown or has passed the cooldown duration
            cooldownMap.put(player, System.currentTimeMillis());
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0), attacker);

            // Schedule a task to notify the player after the cooldown duration
            scheduleRechargeNotification(player);

            return true; // Triggered successfully
        }

        return super.postHit(stack, target, attacker); // Continue with normal behavior when on cooldown
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Fate's Blessing").formatted(Formatting.LIGHT_PURPLE).append("\nIlluminates the opponent.").formatted(Formatting.DARK_GRAY));
    }

    private void scheduleRechargeNotification(PlayerEntity player) {
        new Thread(() -> {
            try {
                Thread.sleep(COOLDOWN_DURATION);
                player.sendMessage(Text.literal("[⚖]").formatted(Formatting.LIGHT_PURPLE).append("Ability recharged!").formatted(Formatting.WHITE));
            } catch (InterruptedException e) {
                System.out.println();
            }
        }).start();
    }
}