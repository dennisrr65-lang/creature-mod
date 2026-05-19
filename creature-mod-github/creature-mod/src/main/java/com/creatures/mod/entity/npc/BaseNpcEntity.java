package com.creatures.mod.entity.npc;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.village.TradeOfferList;
import net.minecraft.world.World;

public abstract class BaseNpcEntity extends MerchantEntity {
    public BaseNpcEntity(EntityType<? extends MerchantEntity> type, World world) {
        super(type, world);
        this.setInvulnerable(true);
    }

    @Override protected void initGoals() {
        goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        goalSelector.add(2, new LookAroundGoal(this));
        goalSelector.add(3, new WanderAroundGoal(this, 0.5));
    }

    public static DefaultAttributeContainer.Builder createBaseAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override public boolean isLeveledMerchant() { return false; }
    @Override public void afterUsing(TradeOfferList offers) {}
    @Override protected SoundEvent getYesSound() { return null; }
    @Override protected SoundEvent getTradingSound(boolean sold) { return null; }
    @Override public SoundEvent getAmbientSound() { return null; }
}
