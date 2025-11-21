package io.github.randomusert.mods.tincore.config.values;

import io.github.randomusert.mods.tincore.config.ConfigValue;

public class BooleanValue extends ConfigValue<Boolean> {
    public BooleanValue(String key, boolean defaultValue, String comment) {
        super(key, defaultValue, comment);
    }

    @Override
    public void setFromObject(Object o) {
        if (o instanceof Boolean)
            this.value = (Boolean) o;
    }

    @Override
    public Object toObject() {
        return value;
    }
}
