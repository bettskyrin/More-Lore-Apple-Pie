package com.betts.moloap.mixin;

import com.betts.moloap.world.item.MoLoAPItems;
import net.minecraft.data.advancements.packs.VanillaHusbandryAdvancements;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;

@Mixin(VanillaHusbandryAdvancements.class)
public class MoLoAPAdvancementMixin {

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void modifyItems(CallbackInfo ci) {
        try {
            Field foods = VanillaHusbandryAdvancements.class.getDeclaredField("EDIBLE_ITEMS");
            foods.setAccessible(true);

            Item[] vanillaItems = (Item[]) foods.get(null); // Get EDIBLE_ITEMS
            Item[] modItems = new Item[vanillaItems.length + 1];

            System.arraycopy(vanillaItems, 0, modItems, 0, vanillaItems.length);

            modItems[vanillaItems.length] = MoLoAPItems.APPLE_PIE;
            foods.set(null, modItems);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
