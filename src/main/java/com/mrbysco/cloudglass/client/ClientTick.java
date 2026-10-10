package com.mrbysco.cloudglass.client;

import com.mrbysco.cloudglass.CloudGlassMod;
import com.mrbysco.cloudglass.block.CloudGlassBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;


@EventBusSubscriber(modid = CloudGlassMod.MOD_ID, value = Dist.CLIENT)
public class ClientTick {

	private static final int ALPHA = 0x80;

	@SubscribeEvent
	public static void onRegisterLayers(RegisterGuiLayersEvent event) {
		event.registerAbove(
				VanillaGuiLayers.CAMERA_OVERLAYS,
				Identifier.fromNamespaceAndPath(CloudGlassMod.MOD_ID, "screen_tint"),
				(graphics, deltaTracker) -> {
					Minecraft mc = Minecraft.getInstance();
					if (mc.player == null || mc.level == null) return;

					BlockPos pos = BlockPos.containing(mc.player.getEyePosition());
					if (mc.level.getBlockState(pos).getBlock() instanceof CloudGlassBlock tint) {
						int argb = (ALPHA << 24) | tint.getTintRgb();
						graphics.fill(0, 0, graphics.guiWidth(), graphics.guiHeight(), argb);
					}
				});
	}
}
