package com.creatures.mod.entity.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.*;
import net.minecraft.world.World;

public class WitchDoctorEntity extends BaseNpcEntity {
    public WitchDoctorEntity(EntityType<? extends MerchantEntity> type, World world) {
        super(type, world);
        this.setCustomName(Text.literal("§5§lHekselegen Mara"));
        this.setCustomNameVisible(true);
    }

    @Override public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient()) {
            this.setCurrentCustomer(player);
            this.sendOffers(player, Text.literal("Hekselegen Mara"), 1);
        }
        return ActionResult.SUCCESS;
    }

    @Override protected void fillRecipes() {
        TradeOfferList offers = this.getOffers();
        offers.add(new TradeOffer(
            new TradedItem(Items.GOLD_INGOT, 4),
            PotionContentsComponent.createStack(Items.POTION, Potions.HEALING),
            10, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.GOLD_INGOT, 5),
            PotionContentsComponent.createStack(Items.POTION, Potions.SWIFTNESS),
            10, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.GOLD_INGOT, 6),
            PotionContentsComponent.createStack(Items.POTION, Potions.STRENGTH),
            8, 2, 0.05f));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createBaseAttributes();
    }
}
