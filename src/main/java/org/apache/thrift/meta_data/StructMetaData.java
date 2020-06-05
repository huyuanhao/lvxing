package org.apache.thrift.meta_data;

import org.apache.thrift.TBase;

public class StructMetaData extends FieldValueMetaData {
    public final Class<? extends TBase> structClass;

    public StructMetaData(byte b, Class<? extends TBase> cls) {
        super(b);
        this.structClass = cls;
    }
}
