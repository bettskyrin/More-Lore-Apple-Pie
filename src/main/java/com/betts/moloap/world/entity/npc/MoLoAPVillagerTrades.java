package com.betts.moloap.world.entity.npc;

import com.betts.moloap.world.item.MoLoAPItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

public class MoLoAPVillagerTrades {
    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD), new ItemStack(MoLoAPItems.APPLE_PIE).copyWithCount(4), 4, 12, 0.05F)
            );
        });
    }
}
