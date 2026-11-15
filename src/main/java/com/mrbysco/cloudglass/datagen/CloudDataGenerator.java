package com.mrbysco.cloudglass.datagen;

import com.mrbysco.cloudglass.datagen.client.CloudLanguageProvider;
import com.mrbysco.cloudglass.datagen.client.CloudModelprovider;
import com.mrbysco.cloudglass.datagen.server.CloudLootProvider;
import com.mrbysco.cloudglass.datagen.server.CloudRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class CloudDataGenerator {
	@SubscribeEvent
	static void onGatherRegistries(GatherDataRegistryEntriesEvent event) {
		event.lootTable(new LootTableProvider.SubProviderEntry(CloudLootProvider.CloudBlockLoot::new, LootContextParamSets.BLOCK));
		event.recipe(CloudRecipeProvider::new);
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		event.createProvider(CloudLanguageProvider::new);
		event.createProvider(CloudModelprovider::new);
	}
}
