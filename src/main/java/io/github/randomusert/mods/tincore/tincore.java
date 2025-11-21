package io.github.randomusert.mods.tincore;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.randomusert.mods.tincore.helper.Loghelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

//main class for the mod
@Mod(tincore.MODID)
public class tincore {
    public static final String MODID = "tincore";
    public static final Logger LOGGER = LogUtils.getLogger();
    public tincore(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
;
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        Loghelper.LogInfo("HELLO FROM COMMON SETUP", tincore.MODID);

    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
