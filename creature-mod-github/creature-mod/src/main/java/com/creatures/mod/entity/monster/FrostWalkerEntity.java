package com.creatures.mod.entity.monster;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrostWalkerEntity extends HostileEntity {
    public FrostWalkerEntity(EntityType<? extends HostileEntity> type, World world) { super(type, world); }

    @Override protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true));
        goalSelector.add(2, new WanderAroundFarGoal(this, 0.9));
        targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        targetSelector.add(2, new RevengeGoal(this));
    }

    @Override public void tick() {
        super.tick();
        if (!this.getWorld().isClient() && this.age % 10 == 0) {
            BlockPos pos = this.getBlockPos();
            for (int x = -2; x <= 2; x++) {
                for (int z = -2; z <= 2; z++) {
                    BlockPos check = pos.add(x, -1, z);
                    if (this.getWorld().getBlockState(check).isOf(Blocks.WATER)) {
                        this.getWorld().setBlockState(check, Blocks.ICE.getDefaultState());
                    }
                }
            }
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 45.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9.0)
            .add(EntityAttributes.GENERIC_ARMOR, 5.0);
    }
}
