package com.mrbysco.cloudglass.datagen.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CloudItemModelProvider extends ItemModelProvider {
	public CloudItemModelProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, CloudGlassMod.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		for (DeferredHolder<Item, ? extends Item> registryObject : CloudRegistry.ITEMS.getEntries()) {
			if (registryObject.get() instanceof BlockItem) {
				withBlockParent(registryObject.getId());
			}
		}
	}

	private void withBlockParent(ResourceLocation location) {
		withExistingParent(location.getPath(), modLoc("block/" + location.getPath()));
	}
}
