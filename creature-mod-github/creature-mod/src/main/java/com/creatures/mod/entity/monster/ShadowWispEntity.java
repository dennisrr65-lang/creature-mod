package com.creatures.mod.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ShadowWispEntity extends HostileEntity {
    private int teleportCooldown = 0;

    public ShadowWispEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    @Override protected void initGoals() {
        goalSelector.add(0, new MeleeAttackGoal(this, 1.5, false));
        goalSelector.add(1, new WanderAroundGoal(this, 1.2));
        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new RevengeGoal(this));
    }

    @Override public void tick() {
        super.tick();
        if (!this.getWorld().isClient()) {
            if (teleportCooldown > 0) teleportCooldown--;
            // Teleport near target when hurt
            if (this.getHealth() < this.getMaxHealth() * 0.5 && teleportCooldown == 0 && this.getTarget() != null) {
                var target = this.getTarget();
                this.teleport(target.getX() + (random.nextDouble() - 0.5) * 4,
                    target.getY(), target.getZ() + (random.nextDouble() - 0.5) * 4);
                teleportCooldown = 60;
            }
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }
}
