package com.creatures.mod.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CrystalGolemEntity extends HostileEntity {
    public CrystalGolemEntity(EntityType<? extends HostileEntity> type, World world) { super(type, world); }

    @Override protected void initGoals() {
        goalSelector.add(0, new MeleeAttackGoal(this, 0.7, true));
        goalSelector.add(1, new WanderAroundFarGoal(this, 0.6));
        goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 12.0f));
        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new RevengeGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 120.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 18.0)
            .add(EntityAttributes.GENERIC_ARMOR, 12.0)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0);
    }
}
