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

public class FireflyEntity extends AnimalEntity {
    public FireflyEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
        this.setNoGravity(true);
    }

    @Override protected void initGoals() {
        goalSelector.add(0, new WanderAroundGoal(this, 0.8));
        goalSelector.add(1, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6);
    }

    @Override public void tick() {
        super.tick();
        if (!this.getWorld().isClient()) {
            this.setVelocity(
                this.getVelocity().x + (this.getRandom().nextDouble() - 0.5) * 0.02,
                Math.sin(this.age * 0.1) * 0.05,
                this.getVelocity().z + (this.getRandom().nextDouble() - 0.5) * 0.02
            );
        }
    }

    @Nullable @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) { return null; }
}
