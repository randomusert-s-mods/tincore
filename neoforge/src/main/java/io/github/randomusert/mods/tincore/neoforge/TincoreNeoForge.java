package io.github.randomusert.mods.tincore.neoforge;

import io.github.randomusert.mods.tincore.Tincore;
import net.neoforged.fml.common.Mod;

@Mod(Tincore.MOD_ID)
public final class TincoreNeoForge {
    public TincoreNeoForge() {
        // Run our common setup.
        Tincore.init();
    }
}
