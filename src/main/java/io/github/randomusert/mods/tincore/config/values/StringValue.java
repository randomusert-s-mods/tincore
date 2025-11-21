package io.github.randomusert.mods.tincore.config.values;

import java.util.function.Predicate;

import io.github.randomusert.mods.tincore.config.ConfigValue;

public class StringValue extends ConfigValue<String> {
    private final Predicate<String> validator;

    public StringValue(String key, String defaultValue, Predicate<String> validator, String comment) {
        super(key, defaultValue, comment);
        this.validator = validator == null ? s -> true : validator;
        if (!this.validator.test(defaultValue))
            throw new IllegalArgumentException("default fails validation");
    }

    @Override
    public void setFromObject(Object o) {
        if (o instanceof String) {
            String s = (String) o;
            if (validator.test(s))
                this.value = s;
        }
    }

    @Override
    public Object toObject() {
        return value;
    }

}
