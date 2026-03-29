package io.github.randomusert.mods.tincore.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BaseBlock extends Block {
    public BaseBlock(Properties properties) {
        super(properties);
    }

    public BaseBlock(SoundType sound, float hardness, float resistance) {
        super(Properties.of()
                .sound(sound)
                .strength(hardness, resistance)
        );
    }

    public BaseBlock(SoundType sound, float hardness, float resistance, boolean tool) {
        super(Properties.of()
                .sound(sound)
                .strength(hardness, resistance)
                .requiresCorrectToolForDrops()
        );
    }
}
