package io.github.randomusert.mods.tincore.helper;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loghelper {
    //create a logger instance
    private static final String NAME = "tincore";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    // helper for info messages
    public static void LogInfo(String message, String modid) {
        LOGGER.info("[" + modid + "] " + message);
    }

    // helper for error messages
    public static void LogError(String message, String modid) {
        LOGGER.error("[" + modid + "] " + message);
    }

    // helper for warning messages
    public static void LogWarn(String message, String modid) {
        LOGGER.warn("[" + modid + "] " + message);
    }
    
    // helper for debug messages
    public static void LogDebug(String message, String modid) {
        LOGGER.debug("[" + modid + "] " + message);
    }
}
