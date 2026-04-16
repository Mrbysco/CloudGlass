package com.mrbysco.cloudglass.datagen.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CloudModelprovider extends ModelProvider {

	public CloudModelprovider(PackOutput packOutput) {
		super(packOutput, CloudGlassMod.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		for (DeferredHolder<Block, ? extends Block> registryObject : CloudRegistry.BLOCKS.getEntries()) {
			Identifier model = ModelTemplates.CUBE_ALL.create(registryObject.get(), TextureMapping.cube(new Material(registryObject.getId().withPrefix("block/"))), blockModels.modelOutput);
			blockModels.blockStateOutput
					.accept(
							MultiVariantGenerator.dispatch(registryObject.get(),
									BlockModelGenerators.plainVariant(model)
							)
					);
			blockModels.registerSimpleItemModel(registryObject.get(), model);
		}
	}
}
