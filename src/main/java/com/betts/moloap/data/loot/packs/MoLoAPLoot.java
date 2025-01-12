package com.betts.moloap.data.loot.packs;

import com.betts.moloap.world.item.MoLoAPItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;


public class MoLoAPLoot {
    public static void modify() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (BuiltInLootTables.VILLAGE_PLAINS_HOUSE.equals(key) && source.isBuiltin()) {
                LootPool.Builder chestPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(MoLoAPItems.APPLE_PIE).setWeight(97))
                        .add(LootItem.lootTableItem(Items.AIR).setWeight(903)); // Simulate Pumpkin Pie's 9.7% chest loot weight
                tableBuilder.pool(chestPool.build());
            } else if (BuiltInLootTables.FARMER_GIFT.equals(key) && source.isBuiltin()) {
                LootPool.Builder giftPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(MoLoAPItems.APPLE_PIE));
                tableBuilder.pool(giftPool.build());
            }
        });
    }

}

