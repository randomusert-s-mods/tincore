package io.github.randomusert.mods.tincore.utils;


public class LogUtils {

    /**
     * Logs an error to the console.
     *
     * @since 0.2
     * */
    public static void LogError(String msg) {
        System.out.println("[Error]: " + msg);
    }

    /**
     * Logs a warning to the console.
     *
     * @since 0.2
     * */
    public static void LogWarn(String msg) {
        System.out.println("[Warn]: " + msg);
    }

    /**
     * Logs an info message to the console.
     *
     * @since 0.2
     * */
    public static void LogInfo(String msg) {
        System.out.println("[Info]: " + msg);
    }
}
