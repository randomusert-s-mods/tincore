package io.github.randomusert.mods.tincore.block;

import java.util.function.Function;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BaseBlock extends Block {
    public BaseBlock(Function<Properties, Properties> propertiesModifier) {
        super(propertiesModifier.apply(Properties.of()));
    }
    public BaseBlock(SoundType soundType, float hardness, float resistance) {
        super(Properties.of()
                .sound(soundType)
                .strength(hardness, resistance)
        );
    }
    public BaseBlock(SoundType soundType, float hardness, float resistance, boolean tool) {
        super(Properties.of()
                .sound(soundType)
                .strength(hardness, resistance)
                .requiresCorrectToolForDrops()
        );
    }
}
