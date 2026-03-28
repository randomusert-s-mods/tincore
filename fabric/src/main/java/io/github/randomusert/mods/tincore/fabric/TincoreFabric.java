package io.github.randomusert.mods.tincore.fabric;

import io.github.randomusert.mods.tincore.Tincore;
import net.fabricmc.api.ModInitializer;

public final class TincoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Tincore.init();
    }
}
