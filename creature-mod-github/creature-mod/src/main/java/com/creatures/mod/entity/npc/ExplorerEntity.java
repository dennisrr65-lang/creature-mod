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

public class ExplorerEntity extends BaseNpcEntity {
    public ExplorerEntity(EntityType<? extends MerchantEntity> type, World world) {
        super(type, world);
        this.setCustomName(Text.literal("§b§lOppdageren Lars"));
        this.setCustomNameVisible(true);
    }

    @Override public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient()) {
            this.setCurrentCustomer(player);
            this.sendOffers(player, Text.literal("Oppdageren Lars"), 1);
        }
        return ActionResult.SUCCESS;
    }

    @Override protected void fillRecipes() {
        TradeOfferList offers = this.getOffers();
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 3),
            new ItemStack(Items.COMPASS),
            10, 1, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 5),
            new ItemStack(Items.SPYGLASS),
            6, 2, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.EMERALD, 8),
            new ItemStack(Items.ENDER_PEARL, 4),
            5, 3, 0.05f));
        offers.add(new TradeOffer(
            new TradedItem(Items.DIAMOND, 2),
            new ItemStack(Items.ELYTRA),
            1, 10, 0.05f));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createBaseAttributes();
    }
}
