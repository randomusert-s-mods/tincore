package io.github.randomusert.mods.tincore.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class ItemStringToItemLike {

    /**
     * A Utility function to convert Item String to a ItemLike
     *
     * @since 0.2
     * @return Item item
     * */
    public static ItemLike ItemStringToItemLike(String namespace, String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace, path);

        Item item = BuiltInRegistries.ITEM.get(id);

        if (item == Items.AIR) {
            throw new IllegalStateException("item with id " + id + " cannot be found! make sure you have the mod installed as a dependency that adds this item!");

        }

        return item;
    }
}
