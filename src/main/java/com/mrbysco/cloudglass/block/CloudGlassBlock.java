package com.mrbysco.cloudglass.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CloudGlassBlock extends TransparentBlock implements BeaconBeamBlock {
	public static final MapCodec<CloudGlassBlock> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(CloudGlassBlock::getColor), propertiesCodec())
					.apply(instance, CloudGlassBlock::new)
	);
	private final DyeColor color;

	@Override
	public MapCodec<CloudGlassBlock> codec() {
		return CODEC;
	}

	public CloudGlassBlock(DyeColor dyeColor, BlockBehaviour.Properties properties) {
		super(properties);
		this.color = dyeColor;
	}

	@Override
	public DyeColor getColor() {
		return this.color;
	}
}
