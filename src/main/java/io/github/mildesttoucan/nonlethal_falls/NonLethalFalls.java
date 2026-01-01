package io.github.mildesttoucan.nonlethal_falls;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.TamableAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class NonLethalFalls implements ModInitializer {
	public static final String MOD_ID = "nonlethal-falls";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final NLFConfig CONFIG = NLFConfig.createToml(
            Paths.get("config"),
            "",
            MOD_ID,
            NLFConfig.class
    );


	@Override
    public void onInitialize() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (!damageSource.is(DamageTypes.FALL) || !CONFIG.enabled) {
                return true;
            }

            if (CONFIG.allEntitiesImmunity) {
                entity.setHealth(CONFIG.healthLeft);
                return false;
            }
            if ((CONFIG.playerImmunity && entity instanceof ServerPlayer) || (CONFIG.tameableImmunity && entity instanceof TamableAnimal)) {
                entity.setHealth(CONFIG.healthLeft);
                return false;
            }
            return true;
        });
    }
}