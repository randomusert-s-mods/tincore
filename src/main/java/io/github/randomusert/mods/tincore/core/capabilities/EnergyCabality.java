package io.github.randomusert.mods.tincore.core.capabilities;


import io.github.randomusert.mods.tincore.energy.ITinEnergy;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.ItemCapability;


/**
 * Capability class for energy storage.
 * {@Link ITinEnergy} stores the interface providing energy storage functionality.
 */
public class EnergyCabality {
    public static final class EnergyStorage {
    
        public static final BlockCapability<ITinEnergy, Direction> BLOCK = BlockCapability.createSided(create("energy"), ITinEnergy.class);
        public static final EntityCapability<ITinEnergy, Direction> ENTITY = EntityCapability.createSided(create("energy"), ITinEnergy.class);
        public static final ItemCapability<ITinEnergy, Void> ITEM = ItemCapability.createVoid(create("energy"), ITinEnergy.class);

        private EnergyStorage() {}

    private static ResourceLocation create(String name) {

        if (name != null) {
            return  ResourceLocation.fromNamespaceAndPath("tincore", name);
        }
        throw new IllegalArgumentException("Name cannot be null");
    }
}
}
