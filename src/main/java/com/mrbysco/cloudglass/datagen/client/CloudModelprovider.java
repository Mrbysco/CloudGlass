package com.mrbysco.cloudglass.datagen.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CloudModelprovider extends ModelProvider {
	private static final ModelTemplate TRANSLUCENT_CUBE = ModelTemplates.CUBE_ALL.extend().renderType("translucent").build();

	public CloudModelprovider(PackOutput packOutput) {
		super(packOutput, CloudGlassMod.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		for (DeferredHolder<Block, ? extends Block> registryObject : CloudRegistry.BLOCKS.getEntries()) {
			ResourceLocation model = TRANSLUCENT_CUBE.create(registryObject.get(), TextureMapping.cube(registryObject.getId().withPrefix("block/")), blockModels.modelOutput);
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
