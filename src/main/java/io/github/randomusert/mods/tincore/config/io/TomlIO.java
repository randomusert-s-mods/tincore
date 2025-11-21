package io.github.randomusert.mods.tincore.config.io;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import com.electronwill.nightconfig.toml.TomlFormat;

import io.github.randomusert.mods.tincore.config.ConfigValue;
import io.github.randomusert.mods.tincore.config.TinConfigSpec;

import com.electronwill.nightconfig.core.io.WritingMode;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class TomlIO {
    public static CommentedFileConfig loadOrCreate(File file) {
        file.getParentFile().mkdirs();
        CommentedFileConfig cfg = CommentedFileConfig.builder(file)
                .sync() // optional
                .preserveInsertionOrder()
                .writingMode(WritingMode.REPLACE_ATOMIC)
                .build();
        if (!file.exists())
            cfg.save();
        cfg.load();
        return cfg;
    }

    public static void save(TinConfigSpec spec, File file) {
        CommentedFileConfig cfg = loadOrCreate(file);
        // write all values into hierarchical tables
        for (ConfigValue<?> v : spec.getAll()) {
            String[] parts = v.getKey().split("\\.");
            // place value under nested tables using NightConfig helpers
            String tomlKey = String.join(".", parts);
            cfg.set(tomlKey, v.toObject());
            if (v.getComment() != null && !v.getComment().isEmpty())
                cfg.setComment(tomlKey, v.getComment());
        }
        cfg.save();
    }

    public static void loadToSpec(TinConfigSpec spec, File file) {
        CommentedFileConfig cfg = loadOrCreate(file);
        for (ConfigValue<?> v : spec.getAll()) {
            Object o = cfg.get(v.getKey());
            if (o != null)
                v.setFromObject(o);
        }
    }
}
