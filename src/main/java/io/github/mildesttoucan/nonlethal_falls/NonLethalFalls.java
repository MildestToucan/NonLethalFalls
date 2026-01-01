package io.github.mildesttoucan.nonlethal_falls;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonLethalFalls implements ModInitializer {
	public static final String MOD_ID = "nonlethal-falls";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
    public void onInitialize() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (!damageSource.is(DamageTypes.FALL) || !(entity instanceof ServerPlayer player)) {
                return true;
            }
            player.setHealth(1.0F);
            return false;
        });
    }
}