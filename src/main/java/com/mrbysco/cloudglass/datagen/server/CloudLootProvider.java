package com.mrbysco.cloudglass.datagen.server;

import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;

public class CloudLootProvider {
	public static class CloudBlockLoot extends BlockLootSubProvider {
		public CloudBlockLoot(Context registries) {
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
