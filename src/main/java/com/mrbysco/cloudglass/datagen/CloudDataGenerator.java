package com.mrbysco.cloudglass.datagen;

import com.mrbysco.cloudglass.datagen.client.CloudBlockstateProvider;
import com.mrbysco.cloudglass.datagen.client.CloudItemModelProvider;
import com.mrbysco.cloudglass.datagen.client.CloudLanguageProvider;
import com.mrbysco.cloudglass.datagen.server.CloudLootProvider;
import com.mrbysco.cloudglass.datagen.server.CloudRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CloudDataGenerator {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeClient()) {
			generator.addProvider(true, new CloudLanguageProvider(packOutput));
			generator.addProvider(true, new CloudBlockstateProvider(packOutput, helper));
			generator.addProvider(true, new CloudItemModelProvider(packOutput, helper));
		}
		if (event.includeServer()) {
			generator.addProvider(true, new CloudLootProvider(packOutput, lookupProvider));
			generator.addProvider(true, new CloudRecipeProvider(packOutput, lookupProvider));
		}
	}
}
