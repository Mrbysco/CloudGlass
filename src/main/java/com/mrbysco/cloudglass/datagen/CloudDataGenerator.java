package com.mrbysco.cloudglass.datagen;

import com.mrbysco.cloudglass.datagen.client.CloudBlockstateProvider;
import com.mrbysco.cloudglass.datagen.client.CloudItemModelProvider;
import com.mrbysco.cloudglass.datagen.client.CloudLanguageProvider;
import com.mrbysco.cloudglass.datagen.server.CloudLootProvider;
import com.mrbysco.cloudglass.datagen.server.CloudRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CloudDataGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeClient()) {
			event.createProvider(CloudLanguageProvider::new);
			generator.addProvider(true, new CloudBlockstateProvider(packOutput, helper));
			generator.addProvider(true, new CloudItemModelProvider(packOutput, helper));
		}
		if (event.includeServer()) {
			event.createProvider(CloudLootProvider::new);
			event.createProvider(CloudRecipeProvider::new);
		}
	}
}
