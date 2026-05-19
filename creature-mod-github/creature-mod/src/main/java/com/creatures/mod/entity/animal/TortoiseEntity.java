package com.creatures.mod.entity.animal;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TortoiseEntity extends AnimalEntity {
    public TortoiseEntity(EntityType<? extends AnimalEntity> type, World world) { super(type, world); }

    @Override protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new WanderAroundGoal(this, 0.5));
        goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        goalSelector.add(3, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
            .add(EntityAttributes.GENERIC_ARMOR, 10.0);
    }

    @Nullable @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) { return null; }
}
