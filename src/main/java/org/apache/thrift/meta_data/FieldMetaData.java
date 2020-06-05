package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;

public class FieldMetaData implements Serializable {
    private static Map<Class<? extends TBase>, Map<? extends TFieldIdEnum, FieldMetaData>> structMap = new HashMap();
    public final String fieldName;
    public final byte requirementType;
    public final FieldValueMetaData valueMetaData;

    public FieldMetaData(String str, byte b, FieldValueMetaData fieldValueMetaData) {
        this.fieldName = str;
        this.requirementType = b;
        this.valueMetaData = fieldValueMetaData;
    }

    public static synchronized void addStructMetaDataMap(Class<? extends TBase> cls, Map<? extends TFieldIdEnum, FieldMetaData> map) {
        synchronized (FieldMetaData.class) {
            structMap.put(cls, map);
        }
    }

    public static synchronized Map<? extends TFieldIdEnum, FieldMetaData> getStructMetaDataMap(Class<? extends TBase> cls) {
        Map<? extends TFieldIdEnum, FieldMetaData> map;
        synchronized (FieldMetaData.class) {
            if (!structMap.containsKey(cls)) {
                try {
                    cls.newInstance();
                } catch (InstantiationException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("InstantiationException for TBase class: ");
                    sb.append(cls.getName());
                    sb.append(", message: ");
                    sb.append(e.getMessage());
                    throw new RuntimeException(sb.toString());
                } catch (IllegalAccessException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("IllegalAccessException for TBase class: ");
                    sb2.append(cls.getName());
                    sb2.append(", message: ");
                    sb2.append(e2.getMessage());
                    throw new RuntimeException(sb2.toString());
                }
            }
            map = (Map) structMap.get(cls);
        }
        return map;
    }
}
