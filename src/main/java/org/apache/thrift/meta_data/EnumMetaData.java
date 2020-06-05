package org.apache.thrift.meta_data;

public class EnumMetaData extends FieldValueMetaData {
    public final Class<? extends Object> enumClass;

    public EnumMetaData(byte b, Class<? extends Object> cls) {
        super(b);
        this.enumClass = cls;
    }
}
