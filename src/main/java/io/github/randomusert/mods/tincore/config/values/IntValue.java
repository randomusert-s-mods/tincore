package io.github.randomusert.mods.tincore.config.values;

import io.github.randomusert.mods.tincore.config.ConfigValue;
public class IntValue extends ConfigValue<Integer> {
    private final int min;
    private final int max;

    public IntValue(String key, int defaultValue, int min, int max, String comment) {
        super(key, defaultValue, comment);
        this.min = min;
        this.max = max;
        validate(defaultValue);
    }

    private void validate(int v) {
        if (v < min || v > max)
            throw new IllegalArgumentException(key + " value out of range");
    }

    @Override
    public void setFromObject(Object o) {
        if (o instanceof Number) {
            int v = ((Number) o).intValue();
            validate(v);
            this.value = v;
        }
    }

    @Override
    public Object toObject() {
        return value;
    }
}
