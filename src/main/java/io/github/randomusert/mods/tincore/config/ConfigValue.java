package io.github.randomusert.mods.tincore.config;


public abstract class ConfigValue<T> {
    protected final String key;
    protected final String comment;
    protected final T defaultValue;
    protected volatile T value;


    protected ConfigValue(String key, T defaultValue, String comment) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.comment = comment;
    }


    public String getKey() { return key; }
    public T get() { return value; }
    public T getDefault() { return defaultValue; }
    public String getComment() { return comment; }


    public abstract void setFromObject(Object o);
    public abstract Object toObject();


    public void reset() { this.value = defaultValue; }
}
