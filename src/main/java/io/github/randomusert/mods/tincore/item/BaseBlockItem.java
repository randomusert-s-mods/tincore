package io.github.randomusert.mods.tincore.item;

import java.util.function.Function;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;

public class BaseBlockItem extends BlockItem {
     public BaseBlockItem(Block block) {
        super(block, new Properties());
    }

    public BaseBlockItem(Block block, Function<Properties,Properties> properties) {
        super(block, properties.apply(new Properties()));
    }    
}
