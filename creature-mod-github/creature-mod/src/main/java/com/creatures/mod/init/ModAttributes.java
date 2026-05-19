package com.creatures.mod.init;

import com.creatures.mod.entity.animal.*;
import com.creatures.mod.entity.monster.*;
import com.creatures.mod.entity.npc.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModAttributes {
    public static void init() {
        FabricDefaultAttributeRegistry.register(ModEntities.ELK, ElkEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GRIZZLY_BEAR, GrizzlyBearEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.EAGLE, EagleEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TORTOISE, TortoiseEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FIREFLY, FireflyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MANTA_RAY, MantaRayEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.STONE_TROLL, StoneTrollEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SHADOW_WISP, ShadowWispEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DEEP_CRAWLER, DeepCrawlerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FROST_WALKER, FrostWalkerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MIRE_GHOUL, MireGhoulEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BLACKSMITH, BlacksmithEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.WITCH_DOCTOR, WitchDoctorEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.EXPLORER, ExplorerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FARMER_NPC, FarmerNpcEntity.createAttributes());
    }
}
