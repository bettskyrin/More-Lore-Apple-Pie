package com.betts.moloap;

import com.betts.moloap.world.item.MoLoAPItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreLoreApplePie implements ModInitializer {
	public static final String MOD_ID = "moloap";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("More Lore: Apple Pie initializing!");
		MoLoAPItems.initialize();
	}
}