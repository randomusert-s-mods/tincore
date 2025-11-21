package io.github.randomusert.mods.tincore.config;

import java.util.*;

import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;
import net.neoforged.neoforge.common.ModConfigSpec.DoubleValue;
import net.neoforged.neoforge.common.ModConfigSpec.EnumValue;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;

import io.github.randomusert.mods.tincore.config.values.*;

public class TinConfigSpec {
    private final Map<String, ConfigValue<?>> values;   
    private final List<String> categoryOrder;

    private TinConfigSpec(Map<String, ConfigValue<?>> values, List<String> categoryOrder) {
        this.values = Collections.unmodifiableMap(new LinkedHashMap<>(values));
        this.categoryOrder = Collections.unmodifiableList(categoryOrder);
    }

    public Optional<ConfigValue<?>> get(String key) {
        return Optional.ofNullable(values.get(key));
    }
    public Collection<ConfigValue<?>> getAlll() {
        return values.values();
    }
    public List<String> getCategoryOrder() {
        return categoryOrder;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
    
        private final Map<String, ConfigValue<?>> values = new LinkedHashMap<>();
    }


    public Builder pop() {
        if (!categoryStack.isEmpty()) categoryStack.pop();
        return this;
    }


    private String composeKey(String name) {
        if (categoryStack.isEmpty()) return name;
        List<String> path = new ArrayList<>(categoryStack);
        Collections.reverse(path);
        path.add(name);
        return String.join(".", path);
    }


    public IntValue defineInRange(String name, int defaultValue, int min, int max, String comment) {
        String key = composeKey(name);
        IntValue v = new IntValue(key, defaultValue, min, max, comment);
        values.put(key, v);
        return v;
    }


    public DoubleValue defineInRange(String name, double defaultValue, double min, double max, String comment) {
        String key = composeKey(name);
        DoubleValue v = new DoubleValue(key, defaultValue, min, max, comment);
        values.put(key, v);
        return v;
    }


    public BooleanValue define(String name, boolean defaultValue, String comment) {
        String key = composeKey(name);
        BooleanValue v = new BooleanValue(key, defaultValue, comment);
        values.put(key, v);
        return v;
    }

    public StringValue define(String name, String defaultValue, Predicate<String> validator, String comment) {
        String key = composeKey(name);
        StringValue v = new StringValue(key, defaultValue, validator, comment);
        values.put(key, v);
        return v;
    }


    public <E extends Enum<E>> EnumValue<E> defineEnum(String name, E defaultValue, Class<E> clazz, String comment) {
        String key = composeKey(name);
        EnumValue<E> v = new EnumValue<>(key, defaultValue, clazz, comment);
        values.put(key, v);
        return v;
    }
    public TinConfigSpec build() {
        return new TinConfigSpec(values, categoryOrder);
    }

}
