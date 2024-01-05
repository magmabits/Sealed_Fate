package net.magmabits.hydrosteel.custom;

import net.magmabits.hydrosteel.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class CoralbladeItem extends SwordItem {
    private static final HashMap<PlayerEntity, Long> cooldownMap = new HashMap<>();
    private static final long COOLDOWN_DURATION = 30 * 1000; // 30 seconds in milliseconds

    public CoralbladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) attacker;

        if (!cooldownMap.containsKey(player) || System.currentTimeMillis() - cooldownMap.get(player) >= COOLDOWN_DURATION) {
            // The ability is not on cooldown or has passed the cooldown duration
            cooldownMap.put(player, System.currentTimeMillis());
            target.addStatusEffect(new StatusEffectInstance(ModEffects.DROWNING, 200, 0), attacker);

            // Play sound here
            playTriggerSound((ServerWorld) attacker.world, player, SoundEvents.BLOCK_NOTE_BLOCK_BELL);

            // Schedule a task to notify the player after the cooldown duration
            scheduleRechargeNotification(player);

            return true; // Triggered successfully
        }

        return super.postHit(stack, target, attacker); // Continue with normal behavior when on cooldown
    }

    private void playTriggerSound(ServerWorld world, PlayerEntity player, SoundEvent event) {
        // Replace "minecraft:entity.player.levelup" with the desired sound event
        SoundEvent soundEvent = new SoundEvent(event.getId());
        world.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, player.getSoundCategory(), 1.0F, 3.0F);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Inflicts the \"Drowning\" effect.").formatted(Formatting.GRAY));
    }

    private void scheduleRechargeNotification(PlayerEntity player) {
        new Thread(() -> {
            try {
                Thread.sleep(COOLDOWN_DURATION);
                playTriggerSound((ServerWorld) player.getWorld(), player, SoundEvents.BLOCK_NOTE_BLOCK_CHIME);
                player.sendMessage(Text.of("§b[♦]§f Ability recharged!"));
            } catch (InterruptedException e) {
                System.out.println();
            }
        }).start();
    }
}