package io.github.randomusert.mods.tincore;

import io.github.randomusert.mods.tincore.utils.LogUtils;

public final class Tincore {
    public static final String MOD_ID = "tincore";

    public static String ver = "1.21.1-0.3-DEV";

    public static void init() {
        LogUtils.LogInfo("Welcome to Tincore " + ver + " !");
    }
}
