package com.betts.moloap.world.entity.npc;

import com.betts.moloap.world.item.MoLoAPItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class MoLoAPVillagerTrades {
    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add((entity, randomSource) -> new TradeOffer(
                    new TradedItem(Items.EMERALD), new ItemStack(MoLoAPItems.APPLE_PIE).copyWithCount(4), 4, 5, 0.05F)
            );
        });
    }
}
