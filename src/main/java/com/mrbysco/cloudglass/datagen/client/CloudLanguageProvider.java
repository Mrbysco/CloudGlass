package com.mrbysco.cloudglass.datagen.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class CloudLanguageProvider extends LanguageProvider {

	public CloudLanguageProvider(PackOutput packOutput) {
		super(packOutput, CloudGlassMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.cloudglass.tab", "Cloud Glass");


		addBlock(CloudRegistry.WHITE_CLOUD_GLASS, "White Cloud Glass");
		addBlock(CloudRegistry.ORANGE_CLOUD_GLASS, "Orange Cloud Glass");
		addBlock(CloudRegistry.MAGENTA_CLOUD_GLASS, "Magenta Cloud Glass");
		addBlock(CloudRegistry.LIGHT_BLUE_CLOUD_GLASS, "Light Blue Cloud Glass");
		addBlock(CloudRegistry.YELLOW_CLOUD_GLASS, "Yellow Cloud Glass");
		addBlock(CloudRegistry.LIME_CLOUD_GLASS, "Lime Cloud Glass");
		addBlock(CloudRegistry.PINK_CLOUD_GLASS, "Pink Cloud Glass");
		addBlock(CloudRegistry.GRAY_CLOUD_GLASS, "Gray Cloud Glass");
		addBlock(CloudRegistry.LIGHT_GRAY_CLOUD_GLASS, "Light Gray Cloud Glass");
		addBlock(CloudRegistry.CYAN_CLOUD_GLASS, "Cyan Cloud Glass");
		addBlock(CloudRegistry.PURPLE_CLOUD_GLASS, "Purple Cloud Glass");
		addBlock(CloudRegistry.BLUE_CLOUD_GLASS, "Blue Cloud Glass");
		addBlock(CloudRegistry.BROWN_CLOUD_GLASS, "Brown Cloud Glass");
		addBlock(CloudRegistry.GREEN_CLOUD_GLASS, "Green Cloud Glass");
		addBlock(CloudRegistry.RED_CLOUD_GLASS, "Red Cloud Glass");
		addBlock(CloudRegistry.BLACK_CLOUD_GLASS, "Black Cloud Glass");
	}
}
