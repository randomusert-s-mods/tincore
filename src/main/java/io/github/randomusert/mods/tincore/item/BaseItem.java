package io.github.randomusert.mods.tincore.item;

import net.minecraft.world.item.Item;
import java.util.function.Function;

public class BaseItem extends Item {
    public BaseItem() {
        super(new Properties());
    }
    public BaseItem(Function<Properties, Properties> propertiesModifier) {
        super(propertiesModifier.apply(new Properties()));
    }
}