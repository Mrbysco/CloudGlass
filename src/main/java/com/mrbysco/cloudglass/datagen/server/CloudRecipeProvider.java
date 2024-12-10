package com.mrbysco.cloudglass.datagen.server;

import com.mrbysco.cloudglass.block.CloudGlassBlock;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.concurrent.CompletableFuture;

public class CloudRecipeProvider extends RecipeProvider {
	public CloudRecipeProvider(PackOutput output, CompletableFuture<Provider> lookupProvider) {
		super(output, lookupProvider);
	}

	@Override
	protected void buildRecipes(RecipeOutput output) {
		cloudRecipe(CloudRegistry.WHITE_CLOUD_GLASS, Blocks.WHITE_WOOL, output);
		cloudRecipe(CloudRegistry.ORANGE_CLOUD_GLASS, Blocks.ORANGE_WOOL, output);
		cloudRecipe(CloudRegistry.MAGENTA_CLOUD_GLASS, Blocks.MAGENTA_WOOL, output);
		cloudRecipe(CloudRegistry.LIGHT_BLUE_CLOUD_GLASS, Blocks.LIGHT_BLUE_WOOL, output);
		cloudRecipe(CloudRegistry.YELLOW_CLOUD_GLASS, Blocks.YELLOW_WOOL, output);
		cloudRecipe(CloudRegistry.LIME_CLOUD_GLASS, Blocks.LIME_WOOL, output);
		cloudRecipe(CloudRegistry.PINK_CLOUD_GLASS, Blocks.PINK_WOOL, output);
		cloudRecipe(CloudRegistry.GRAY_CLOUD_GLASS, Blocks.GRAY_WOOL, output);
		cloudRecipe(CloudRegistry.LIGHT_GRAY_CLOUD_GLASS, Blocks.LIGHT_GRAY_WOOL, output);
		cloudRecipe(CloudRegistry.CYAN_CLOUD_GLASS, Blocks.CYAN_WOOL, output);
		cloudRecipe(CloudRegistry.PURPLE_CLOUD_GLASS, Blocks.PURPLE_WOOL, output);
		cloudRecipe(CloudRegistry.BLUE_CLOUD_GLASS, Blocks.BLUE_WOOL, output);
		cloudRecipe(CloudRegistry.BROWN_CLOUD_GLASS, Blocks.BROWN_WOOL, output);
		cloudRecipe(CloudRegistry.GREEN_CLOUD_GLASS, Blocks.GREEN_WOOL, output);
		cloudRecipe(CloudRegistry.RED_CLOUD_GLASS, Blocks.RED_WOOL, output);
		cloudRecipe(CloudRegistry.BLACK_CLOUD_GLASS, Blocks.BLACK_WOOL, output);

		dyeRecipe(CloudRegistry.ORANGE_CLOUD_GLASS, Tags.Items.DYES_ORANGE, output);
		dyeRecipe(CloudRegistry.MAGENTA_CLOUD_GLASS, Tags.Items.DYES_MAGENTA, output);
		dyeRecipe(CloudRegistry.LIGHT_BLUE_CLOUD_GLASS, Tags.Items.DYES_LIGHT_BLUE, output);
		dyeRecipe(CloudRegistry.YELLOW_CLOUD_GLASS, Tags.Items.DYES_YELLOW, output);
		dyeRecipe(CloudRegistry.LIME_CLOUD_GLASS, Tags.Items.DYES_LIME, output);
		dyeRecipe(CloudRegistry.PINK_CLOUD_GLASS, Tags.Items.DYES_PINK, output);
		dyeRecipe(CloudRegistry.GRAY_CLOUD_GLASS, Tags.Items.DYES_GRAY, output);
		dyeRecipe(CloudRegistry.LIGHT_GRAY_CLOUD_GLASS, Tags.Items.DYES_LIGHT_GRAY, output);
		dyeRecipe(CloudRegistry.CYAN_CLOUD_GLASS, Tags.Items.DYES_CYAN, output);
		dyeRecipe(CloudRegistry.PURPLE_CLOUD_GLASS, Tags.Items.DYES_PURPLE, output);
		dyeRecipe(CloudRegistry.BLUE_CLOUD_GLASS, Tags.Items.DYES_BLUE, output);
		dyeRecipe(CloudRegistry.BROWN_CLOUD_GLASS, Tags.Items.DYES_BROWN, output);
		dyeRecipe(CloudRegistry.GREEN_CLOUD_GLASS, Tags.Items.DYES_GREEN, output);
		dyeRecipe(CloudRegistry.RED_CLOUD_GLASS, Tags.Items.DYES_RED, output);
		dyeRecipe(CloudRegistry.BLACK_CLOUD_GLASS, Tags.Items.DYES_BLACK, output);
	}

	private void cloudRecipe(DeferredBlock<CloudGlassBlock> block, ItemLike wool, RecipeOutput output) {
		new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, block.asItem(), 4)
				.pattern(" W ")
				.pattern("WGW")
				.pattern(" W ")
				.define('W', wool)
				.define('G', Tags.Items.GLASS_BLOCKS_COLORLESS)
				.unlockedBy("has_wool", has(wool))
				.unlockedBy("has_glass", has(Tags.Items.GLASS_BLOCKS_COLORLESS))
				.save(output);
	}

	private void dyeRecipe(DeferredBlock<CloudGlassBlock> block, TagKey<Item> dye, RecipeOutput output) {
		new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, block.asItem(), 8)
				.pattern("CCC")
				.pattern("CDC")
				.pattern("CCC")
				.define('C', CloudRegistry.WHITE_CLOUD_GLASS)
				.define('D', dye)
				.unlockedBy("has_cloud", has(CloudRegistry.WHITE_CLOUD_GLASS))
				.unlockedBy("has_dye", has(dye))
				.save(output, block.getId().withSuffix("_from_dye"));
	}
}
