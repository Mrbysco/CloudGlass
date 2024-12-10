package com.mrbysco.cloudglass;

import com.mojang.logging.LogUtils;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CloudGlassMod.MOD_ID)
public class CloudGlassMod {
	public static final String MOD_ID = "cloudglass";
	public static final Logger LOGGER = LogUtils.getLogger();

	public CloudGlassMod(IEventBus eventBus, Dist dist, ModContainer container) {
		CloudRegistry.BLOCKS.register(eventBus);
		CloudRegistry.ITEMS.register(eventBus);
		CloudRegistry.CREATIVE_MODE_TABS.register(eventBus);
	}
}
