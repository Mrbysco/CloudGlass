package com.mrbysco.cloudglass.datagen.server;

import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CloudLootProvider extends LootTableProvider {
	public CloudLootProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(CloudBlockLoot::new, LootContextParamSets.BLOCK)
		), lookupProvider);
	}

	private static class CloudBlockLoot extends BlockLootSubProvider {
		protected CloudBlockLoot(HolderLookup.Provider registries) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
		}

		@Override
		protected void generate() {
			for (DeferredHolder<Block, ? extends Block> registryObject : CloudRegistry.BLOCKS.getEntries()) {
				this.dropSelf(registryObject.get());
			}
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) CloudRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}
}
