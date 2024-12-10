package com.mrbysco.cloudglass.datagen.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CloudBlockstateProvider extends BlockStateProvider {
	public CloudBlockstateProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, CloudGlassMod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		for (DeferredHolder<Block, ? extends Block> registryObject : CloudRegistry.BLOCKS.getEntries()) {
			ModelFile blockModel = models().cubeAll(registryObject.getId().getPath(), blockTexture(registryObject.get())).renderType("translucent");
			getVariantBuilder(registryObject.get())
					.partialState().modelForState().modelFile(blockModel).addModel();
		}
	}
}
