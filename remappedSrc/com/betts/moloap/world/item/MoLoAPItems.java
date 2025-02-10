package com.betts.moloap.world.item;

import com.betts.moloap.world.food.MoLoAPFoods;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.betts.moloap.MoreLoreApplePie.MOD_ID;
import static net.minecraft.item.Items.register;

public class MoLoAPItems {
    public static final Item APPLE_PIE = register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "apple_pie")), Item::new, new Item.Settings().food(MoLoAPFoods.APPLE_PIE));

    public static void register() {
        // Seamless Creative Mode tab item
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.PUMPKIN_PIE, MoLoAPItems.APPLE_PIE);
        });
        // Make Compostable
        CompostingChanceRegistry.INSTANCE.add(MoLoAPItems.APPLE_PIE, 1.0F);

    }
}
