package io.github.randomusert.mods.tincore.config.values;

import io.github.randomusert.mods.tincore.config.ConfigValue;

public class EnumValue<E extends Enum<E>> extends ConfigValue<E> {
    private final Class<E> enumClass;

    public EnumValue(String key, E defaultValue, Class<E> enumClass, String comment) {
        super(key, defaultValue, comment);
        this.enumClass = enumClass;
    }

    @Override
    public void setFromObject(Object o) {
        if (o instanceof String) {
            try {
                E e = Enum.valueOf(enumClass, ((String) o).toUpperCase());
                this.value = e;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    @Override
    public Object toObject() {
        return value.name();
    }
}
