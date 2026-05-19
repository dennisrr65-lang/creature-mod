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

public class BlacksmithEntity extends BaseNpcEntity {
    public BlacksmithEntity(EntityType<? extends MerchantEntity> type, World world) {
        super(type, world);
        this.setCustomName(Text.literal("§6§lSmed Erik"));
        this.setCustomNameVisible(true);
    }

    @Override public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient()) {
            this.setCurrentCustomer(player);
            this.sendOffers(player, Text.literal("Smed Erik"), 1);
        }
        return ActionResult.SUCCESS;
    }

    @Override protected void fillRecipes() {
        TradeOfferList offers = this.getOffers();
        offers.add(new TradeOffer(
            new TradedItem(Items.IRON_INGOT, 8),
            new ItemStack(Items.IRON_SWORD),
            12, 2, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.IRON_INGOT, 5),
            new ItemStack(Items.IRON_PICKAXE),
            12, 2, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.GOLD_INGOT, 6),
            new ItemStack(Items.GOLDEN_SWORD),
            8, 3, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.DIAMOND, 3),
            new ItemStack(Items.DIAMOND_SWORD),
            4, 5, 0.05f));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createBaseAttributes();
    }
}
