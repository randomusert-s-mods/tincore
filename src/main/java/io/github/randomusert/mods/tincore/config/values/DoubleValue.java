package io.github.randomusert.mods.tincore.config.values;

import io.github.randomusert.mods.tincore.config.ConfigValue;

public class DoubleValue extends ConfigValue<Double> {
    private final double min;
    private final double max;

    public DoubleValue(String key, double defaultValue, double min, double max, String comment) {
        super(key, defaultValue, comment);
        this.min = min;
        this.max = max;
        validate(defaultValue);
    }

    private void validate(double v) {
        if (v < min || v > max)
            throw new IllegalArgumentException(key + " value out of range");
    }

    @Override
    public void setFromObject(Object o) {
        if (o instanceof Number) {
            double v = ((Number) o).doubleValue();
            validate(v);
            this.value = v;
        }
    }

    @Override
    public Object toObject() {
        return value;
    }
}