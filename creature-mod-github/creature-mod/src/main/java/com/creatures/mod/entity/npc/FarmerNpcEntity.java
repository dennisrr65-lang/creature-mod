package com.creatures.mod.entity.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.*;
import net.minecraft.world.World;

public class FarmerNpcEntity extends BaseNpcEntity {
    public FarmerNpcEntity(EntityType<? extends MerchantEntity> type, World world) {
        super(type, world);
        this.setCustomName(Text.literal("§a§lBonde Sigrid"));
        this.setCustomNameVisible(true);
    }

    @Override public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient()) {
            this.setCurrentCustomer(player);
            this.sendOffers(player, Text.literal("Bonde Sigrid"), 1);
        }
        return ActionResult.SUCCESS;
    }

    @Override protected void fillRecipes() {
        TradeOfferList offers = this.getOffers();
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 1),
            new ItemStack(Items.BREAD, 6),
            16, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 2),
            new ItemStack(Items.COOKED_BEEF, 4),
            12, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 1),
            new ItemStack(Items.WHEAT_SEEDS, 16),
            20, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 3),
            new ItemStack(Items.GOLDEN_APPLE),
            5, 3, 0.05f));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createBaseAttributes();
    }
}
