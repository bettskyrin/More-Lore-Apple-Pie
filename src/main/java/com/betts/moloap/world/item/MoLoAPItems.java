package com.betts.moloap.world.item;

import com.betts.moloap.world.food.MoLoAPFoods;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static com.betts.moloap.MoreLoreApplePie.MOD_ID;
import static net.minecraft.world.item.Items.COMPOSTER;
import static net.minecraft.world.item.Items.registerItem;

public class MoLoAPItems {
    public static final Item APPLE_PIE = registerItem(itemId("apple_pie"), Item::new, new Item.Properties().food(MoLoAPFoods.APPLE_PIE));

    private static ResourceKey<Item> itemId(String itemName) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, itemName));
    }

    public static void initialize() {
        // Seamless Creative Mode tab item
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            entries.addAfter(Items.PUMPKIN_PIE, MoLoAPItems.APPLE_PIE);
        });
        // Make Compostable
        CompostingChanceRegistry.INSTANCE.add(MoLoAPItems.APPLE_PIE, 1.0F);

         // LOGGER.info("Registering items..."); // For Developer Use

    }
}
