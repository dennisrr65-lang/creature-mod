package com.creatures.mod.entity.animal;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MantaRayEntity extends AnimalEntity {
    public MantaRayEntity(EntityType<? extends AnimalEntity> type, World world) { super(type, world); }

    @Override protected void initGoals() {
        goalSelector.add(0, new WanderAroundGoal(this, 1.0));
        goalSelector.add(1, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 25.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7);
    }

    @Override public boolean canBreatheInWater() { return true; }

    @Nullable @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) { return null; }
}
