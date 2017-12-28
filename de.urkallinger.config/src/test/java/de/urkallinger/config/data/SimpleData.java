package de.urkallinger.config.data;

public class SimpleData {
    private byte byteValue;
    private short shortValue;
    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    private char charValue;
    private String stringValue;
    private boolean booleanValue;

    public byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public short getShortValue() {
        return shortValue;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public char getCharValue() {
        return charValue;
    }

    public void setCharValue(char charValue) {
        this.charValue = charValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SimpleData other = (SimpleData) obj;

        if (!this.stringValue.equals(other.getStringValue ())) return false;

        if (this.byteValue != other.getByteValue()) return false;
        if (this.shortValue != other.getShortValue()) return false;
        if (this.intValue != other.getIntValue()) return false;
        if (this.longValue != other.getLongValue()) return false;
        if (this.floatValue != other.getFloatValue()) return false;
        if (this.doubleValue != other.getDoubleValue()) return false;
        if (this.charValue != other.getCharValue()) return false;
        if (this.booleanValue != other.getBooleanValue()) return false;

        return true;
    }
}
