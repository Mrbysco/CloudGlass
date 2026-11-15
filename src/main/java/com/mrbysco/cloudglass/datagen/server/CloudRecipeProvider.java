package com.mrbysco.cloudglass.datagen.server;

import com.mrbysco.cloudglass.block.CloudGlassBlock;
import com.mrbysco.cloudglass.registry.CloudRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.concurrent.CompletableFuture;

public class CloudRecipeProvider extends RecipeProvider {
	public CloudRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
		super(recipeOutput, advancementOutput);
	}

	@Override
	protected void buildRecipes() {
		cloudRecipe(CloudRegistry.WHITE_CLOUD_GLASS, Blocks.WOOL.white(), output);
		cloudRecipe(CloudRegistry.ORANGE_CLOUD_GLASS, Blocks.WOOL.orange(), output);
		cloudRecipe(CloudRegistry.MAGENTA_CLOUD_GLASS, Blocks.WOOL.magenta(), output);
		cloudRecipe(CloudRegistry.LIGHT_BLUE_CLOUD_GLASS, Blocks.WOOL.lightBlue(), output);
		cloudRecipe(CloudRegistry.YELLOW_CLOUD_GLASS, Blocks.WOOL.yellow(), output);
		cloudRecipe(CloudRegistry.LIME_CLOUD_GLASS, Blocks.WOOL.lime(), output);
		cloudRecipe(CloudRegistry.PINK_CLOUD_GLASS, Blocks.WOOL.pink(), output);
		cloudRecipe(CloudRegistry.GRAY_CLOUD_GLASS, Blocks.WOOL.gray(), output);
		cloudRecipe(CloudRegistry.LIGHT_GRAY_CLOUD_GLASS, Blocks.WOOL.lightGray(), output);
		cloudRecipe(CloudRegistry.CYAN_CLOUD_GLASS, Blocks.WOOL.cyan(), output);
		cloudRecipe(CloudRegistry.PURPLE_CLOUD_GLASS, Blocks.WOOL.purple(), output);
		cloudRecipe(CloudRegistry.BLUE_CLOUD_GLASS, Blocks.WOOL.blue(), output);
		cloudRecipe(CloudRegistry.BROWN_CLOUD_GLASS, Blocks.WOOL.brown(), output);
		cloudRecipe(CloudRegistry.GREEN_CLOUD_GLASS, Blocks.WOOL.green(), output);
		cloudRecipe(CloudRegistry.RED_CLOUD_GLASS, Blocks.WOOL.red(), output);
		cloudRecipe(CloudRegistry.BLACK_CLOUD_GLASS, Blocks.WOOL.black(), output);

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
		shaped(RecipeCategory.BUILDING_BLOCKS, block.asItem(), 4)
				.pattern(" W ")
				.pattern("WGW")
				.pattern(" W ")
				.define('W', wool)
				.define('G', Tags.BlockItems.GLASS_BLOCKS_COLORLESS.item())
				.unlockedBy("has_wool", has(wool))
				.unlockedBy("has_glass", has(Tags.BlockItems.GLASS_BLOCKS_COLORLESS.item()))
				.save(output);
	}

	private void dyeRecipe(DeferredBlock<CloudGlassBlock> block, TagKey<Item> dye, RecipeOutput output) {
		shaped(RecipeCategory.BUILDING_BLOCKS, block.asItem(), 8)
				.pattern("CCC")
				.pattern("CDC")
				.pattern("CCC")
				.define('C', CloudRegistry.WHITE_CLOUD_GLASS)
				.define('D', dye)
				.unlockedBy("has_cloud", has(CloudRegistry.WHITE_CLOUD_GLASS))
				.unlockedBy("has_dye", has(dye))
				.save(output, block.getId().withSuffix("_from_dye").toString());
	}
}
