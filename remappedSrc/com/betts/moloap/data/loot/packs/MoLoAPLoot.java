package com.betts.moloap.data.loot.packs;

import com.betts.moloap.world.item.MoLoAPItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;


public class MoLoAPLoot {
    public static void modify() {
        LootTableEvents.MODIFY.register((resourceKey, tableBuilder, lootTableSource, provider) -> {
            if (LootTables.VILLAGE_PLAINS_CHEST.equals(resourceKey)) {
                LootPool.Builder chestPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(MoLoAPItems.APPLE_PIE).weight(97))
                        .with(ItemEntry.builder(Items.AIR).weight(903)); // Simulate Pumpkin Pie's 9.7% chest loot weight
                tableBuilder.pool(chestPool.build());
            } else if (LootTables.HERO_OF_THE_VILLAGE_FARMER_GIFT_GAMEPLAY.equals(resourceKey)) {
                tableBuilder.modifyPools(poolBuilder -> {
                    poolBuilder.rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(ItemEntry.builder(MoLoAPItems.APPLE_PIE));
                    poolBuilder.build();
                });
            }
        });
    }

}

