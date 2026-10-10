package com.mrbysco.cloudglass.datagen;

import com.mrbysco.cloudglass.datagen.client.CloudLanguageProvider;
import com.mrbysco.cloudglass.datagen.client.CloudModelprovider;
import com.mrbysco.cloudglass.datagen.server.CloudLootProvider;
import com.mrbysco.cloudglass.datagen.server.CloudRecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber
public class CloudDataGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		event.createProvider(CloudLanguageProvider::new);
		event.createProvider(CloudModelprovider::new);
		event.createProvider(CloudLootProvider::new);
		event.createProvider(CloudRecipeProvider.Runner::new);
	}
}
