package org.apache.thrift.meta_data;

public class SetMetaData extends FieldValueMetaData {
    public final FieldValueMetaData elemMetaData;

    public SetMetaData(byte b, FieldValueMetaData fieldValueMetaData) {
        super(b);
        this.elemMetaData = fieldValueMetaData;
    }
}
