package com.mrbysco.cloudglass.registry;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.block.CloudGlassBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class CloudRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CloudGlassMod.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CloudGlassMod.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CloudGlassMod.MOD_ID);

	public static final DeferredBlock<CloudGlassBlock> WHITE_CLOUD_GLASS = registerCloud("white_cloud_glass", DyeColor.WHITE);
	public static final DeferredBlock<CloudGlassBlock> ORANGE_CLOUD_GLASS = registerCloud("orange_cloud_glass", DyeColor.ORANGE);
	public static final DeferredBlock<CloudGlassBlock> MAGENTA_CLOUD_GLASS = registerCloud("magenta_cloud_glass", DyeColor.MAGENTA);
	public static final DeferredBlock<CloudGlassBlock> LIGHT_BLUE_CLOUD_GLASS = registerCloud("light_blue_cloud_glass", DyeColor.LIGHT_BLUE);
	public static final DeferredBlock<CloudGlassBlock> YELLOW_CLOUD_GLASS = registerCloud("yellow_cloud_glass", DyeColor.YELLOW);
	public static final DeferredBlock<CloudGlassBlock> LIME_CLOUD_GLASS = registerCloud("lime_cloud_glass", DyeColor.LIME);
	public static final DeferredBlock<CloudGlassBlock> PINK_CLOUD_GLASS = registerCloud("pink_cloud_glass", DyeColor.PINK);
	public static final DeferredBlock<CloudGlassBlock> GRAY_CLOUD_GLASS = registerCloud("gray_cloud_glass", DyeColor.GRAY);
	public static final DeferredBlock<CloudGlassBlock> LIGHT_GRAY_CLOUD_GLASS = registerCloud("light_gray_cloud_glass", DyeColor.LIGHT_GRAY);
	public static final DeferredBlock<CloudGlassBlock> CYAN_CLOUD_GLASS = registerCloud("cyan_cloud_glass", DyeColor.CYAN);
	public static final DeferredBlock<CloudGlassBlock> PURPLE_CLOUD_GLASS = registerCloud("purple_cloud_glass", DyeColor.PURPLE);
	public static final DeferredBlock<CloudGlassBlock> BLUE_CLOUD_GLASS = registerCloud("blue_cloud_glass", DyeColor.BLUE);
	public static final DeferredBlock<CloudGlassBlock> BROWN_CLOUD_GLASS = registerCloud("brown_cloud_glass", DyeColor.BROWN);
	public static final DeferredBlock<CloudGlassBlock> GREEN_CLOUD_GLASS = registerCloud("green_cloud_glass", DyeColor.GREEN);
	public static final DeferredBlock<CloudGlassBlock> RED_CLOUD_GLASS = registerCloud("red_cloud_glass", DyeColor.RED);
	public static final DeferredBlock<CloudGlassBlock> BLACK_CLOUD_GLASS = registerCloud("black_cloud_glass", DyeColor.BLACK);

	public static DeferredBlock<CloudGlassBlock> registerCloud(String name, DyeColor color) {
		DeferredBlock<CloudGlassBlock> block = BLOCKS.registerBlock(name, (properties) -> new CloudGlassBlock(
				color,
				properties
						.mapColor(color)
						.instrument(NoteBlockInstrument.HAT)
						.strength(0.3F)
						.sound(SoundType.GLASS)
						.noOcclusion()
						.noCollission()
						.isValidSpawn((state, getter, pos, type) -> false)
						.isRedstoneConductor((state, getter, pos) -> false)
						.isSuffocating((state, getter, pos) -> false)
						.isViewBlocking((state, getter, pos) -> false)
		));
		ITEMS.registerSimpleBlockItem(block);
		return block;
	}

	public static final Supplier<CreativeModeTab> CLOUD_TAB = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(CloudRegistry.LIGHT_BLUE_CLOUD_GLASS.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.cloudglass.tab"))
			.displayItems((displayParameters, output) -> {
				List<ItemStack> stacks = CloudRegistry.BLOCKS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());
}
