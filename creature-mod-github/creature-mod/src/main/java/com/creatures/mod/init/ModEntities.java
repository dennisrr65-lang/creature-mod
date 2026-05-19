package com.creatures.mod.init;

import com.creatures.mod.entity.animal.*;
import com.creatures.mod.entity.monster.*;
import com.creatures.mod.entity.npc.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static EntityType<ElkEntity> ELK;
    public static EntityType<GrizzlyBearEntity> GRIZZLY_BEAR;
    public static EntityType<EagleEntity> EAGLE;
    public static EntityType<TortoiseEntity> TORTOISE;
    public static EntityType<FireflyEntity> FIREFLY;
    public static EntityType<MantaRayEntity> MANTA_RAY;
    public static EntityType<StoneTrollEntity> STONE_TROLL;
    public static EntityType<ShadowWispEntity> SHADOW_WISP;
    public static EntityType<DeepCrawlerEntity> DEEP_CRAWLER;
    public static EntityType<FrostWalkerEntity> FROST_WALKER;
    public static EntityType<MireGhoulEntity> MIRE_GHOUL;
    public static EntityType<CrystalGolemEntity> CRYSTAL_GOLEM;
    public static EntityType<BlacksmithEntity> BLACKSMITH;
    public static EntityType<WitchDoctorEntity> WITCH_DOCTOR;
    public static EntityType<ExplorerEntity> EXPLORER;
    public static EntityType<FarmerNpcEntity> FARMER_NPC;

    public static void init() {
        ELK = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","elk"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ElkEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.2f)).build());
        GRIZZLY_BEAR = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","grizzly_bear"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GrizzlyBearEntity::new).dimensions(EntityDimensions.fixed(1.4f,1.8f)).build());
        EAGLE = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","eagle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EagleEntity::new).dimensions(EntityDimensions.fixed(0.9f,0.8f)).build());
        TORTOISE = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","tortoise"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TortoiseEntity::new).dimensions(EntityDimensions.fixed(1.2f,0.5f)).build());
        FIREFLY = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","firefly"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, FireflyEntity::new).dimensions(EntityDimensions.fixed(0.2f,0.2f)).build());
        MANTA_RAY = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","manta_ray"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, MantaRayEntity::new).dimensions(EntityDimensions.fixed(2.4f,0.6f)).build());
        STONE_TROLL = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","stone_troll"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StoneTrollEntity::new).dimensions(EntityDimensions.fixed(1.6f,3.0f)).build());
        SHADOW_WISP = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","shadow_wisp"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShadowWispEntity::new).dimensions(EntityDimensions.fixed(0.8f,0.8f)).build());
        DEEP_CRAWLER = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","deep_crawler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DeepCrawlerEntity::new).dimensions(EntityDimensions.fixed(1.8f,0.6f)).build());
        FROST_WALKER = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","frost_walker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrostWalkerEntity::new).dimensions(EntityDimensions.fixed(0.8f,2.4f)).build());
        MIRE_GHOUL = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","mire_ghoul"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MireGhoulEntity::new).dimensions(EntityDimensions.fixed(0.9f,1.9f)).build());
        CRYSTAL_GOLEM = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","crystal_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrystalGolemEntity::new).dimensions(EntityDimensions.fixed(1.4f,2.9f)).build());
        BLACKSMITH = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","blacksmith"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, BlacksmithEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());
        WITCH_DOCTOR = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","witch_doctor"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, WitchDoctorEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());
        EXPLORER = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","explorer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ExplorerEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());
        FARMER_NPC = Registry.register(Registries.ENTITY_TYPE, Identifier.of("creature_mod","farmer_npc"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FarmerNpcEntity::new).dimensions(EntityDimensions.fixed(0.6f,1.95f)).build());
    }
}
