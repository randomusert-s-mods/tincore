package io.github.randomusert.mods.tincore.utils;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.Optional;

public class ItemStringToItemLike {

    /**
     * A Utility function to convert Item String to a ItemLike
     *
     * @since 0.2
     * @return Item item
     * */
    public static ItemLike ItemStringToItemLike(String namespace, String path) {
        Identifier id = Identifier.fromNamespaceAndPath(namespace, path);

        Optional<Holder.Reference<Item>> holder = BuiltInRegistries.ITEM.get(id);

        Item item = holder.map(Holder::value)
                .orElse(Items.AIR);
        if (item == Items.AIR) {
            throw new IllegalStateException("item with id " + id + " cannot be found! make sure you have the mod installed as a dependency that adds this item!");

        }

        return item;
    }
}
