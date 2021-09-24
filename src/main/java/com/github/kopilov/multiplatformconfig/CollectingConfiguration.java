package com.github.kopilov.multiplatformconfig;

import org.apache.commons.configuration2.AbstractConfiguration;
import org.apache.commons.configuration2.Configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public class CollectingConfiguration extends AbstractConfiguration {
    public CollectingConfiguration(Configuration baseConfiguration) {
        this.baseConfiguration = baseConfiguration;
    }

    private Configuration baseConfiguration;

    @Override
    protected void addPropertyDirect(String key, Object value) {
        baseConfiguration.addProperty(key, value);
    }

    @Override
    protected void clearPropertyDirect(String key) {
        baseConfiguration.clearProperty(key);
    }

    @Override
    protected Iterator<String> getKeysInternal() {
        return baseConfiguration.getKeys();
    }

    @Override
    protected Object getPropertyInternal(String key) {
        return baseConfiguration.getProperty(key);
    }

    @Override
    protected boolean isEmptyInternal() {
        return baseConfiguration.isEmpty();
    }

    @Override
    protected boolean containsKeyInternal(String key) {
        return baseConfiguration.containsKey(key);
    }

    @Override
    public boolean getBoolean(final String key, final boolean defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getBoolean(key, defaultValue);
    }

    @Override
    public Boolean getBoolean(final String key, final Boolean defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getBoolean(key, defaultValue);
    }

    @Override
    public byte getByte(final String key, final byte defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getByte(key, defaultValue);
    }

    @Override
    public Byte getByte(final String key, final Byte defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getByte(key, defaultValue);
    }

    @Override
    public double getDouble(final String key, final double defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getDouble(key, defaultValue);
    }

    @Override
    public Double getDouble(final String key, final Double defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getDouble(key, defaultValue);
    }

    @Override
    public float getFloat(final String key, final float defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getFloat(key, defaultValue);
    }

    @Override
    public Float getFloat(final String key, final Float defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getFloat(key, defaultValue);
    }

    @Override
    public int getInt(final String key, final int defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getInt(key, defaultValue);
    }

    @Override
    public Integer getInteger(final String key, final Integer defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getInteger(key, defaultValue);
    }

    @Override
    public long getLong(final String key, final long defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getLong(key, defaultValue);
    }

    @Override
    public Long getLong(final String key, final Long defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getLong(key, defaultValue);
    }

    @Override
    public short getShort(final String key, final short defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getShort(key, defaultValue);
    }

    @Override
    public Short getShort(final String key, final Short defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getShort(key, defaultValue);
    }

    @Override
    public BigDecimal getBigDecimal(final String key, final BigDecimal defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getBigDecimal(key, defaultValue);
    }

    @Override
    public BigInteger getBigInteger(final String key, final BigInteger defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getBigInteger(key, defaultValue);
    }

    @Override
    public String getString(final String key, final String defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getString(key, defaultValue);
    }

    @Override
    public List<Object> getList(final String key, final List<?> defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getList(key, defaultValue);
    }

    @Override
    public <T> T get(final Class<T> cls, final String key, final T defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.get(cls, key, defaultValue);
    }

    @Override
    public Object getArray(final Class<?> cls, final String key, final Object defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getArray(cls, key, defaultValue);
    }

    @Override
    public <T> List<T> getList(final Class<T> cls, final String key, final List<T> defaultValue) {
        if (!baseConfiguration.containsKey(key)) {
            baseConfiguration.addProperty(key, defaultValue);
        }
        return baseConfiguration.getList(cls, key, defaultValue);
    }
}
