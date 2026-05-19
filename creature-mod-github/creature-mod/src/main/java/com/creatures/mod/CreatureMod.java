package com.creatures.mod;

import com.creatures.mod.init.ModEntities;
import com.creatures.mod.init.ModAttributes;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatureMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("creature_mod");

    @Override
    public void onInitialize() {
        ModEntities.init();
        ModAttributes.init();
        LOGGER.info("Creature Mod lastet! 15 nye skapninger klar.");
    }
}
