package de.urkallinger.config.data;

import java.util.ArrayList;
import java.util.HashMap;

public final class DataUtils {
    public static final SimpleData createSimpleData() {
        SimpleData data = new SimpleData();

        data.setByteValue((byte) 0xFFFFFFFF);
        data.setShortValue(Short.MAX_VALUE);
        data.setIntValue(Integer.MAX_VALUE);
        data.setLongValue(Long.MAX_VALUE);
        data.setFloatValue(Float.MAX_VALUE);
        data.setDoubleValue(Double.MAX_VALUE);
        data.setCharValue('a');
        data.setStringValue("string value");
        data.setBooleanValue(false);

        return data;
    }

    public static final ComplexData createComplexData() {
        ComplexData data = new ComplexData();

        data.setList(new ArrayList<SimpleData>());
        data.setMap(new HashMap<Integer, SimpleData>());

        data.getList().add(createSimpleData());
        data.getList().add(createSimpleData());

        data.getMap().put(1, createSimpleData());
        data.getMap().put(2, createSimpleData());

        return data;
    }
}
