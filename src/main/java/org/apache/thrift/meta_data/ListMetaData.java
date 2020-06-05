package org.apache.thrift.meta_data;

public class ListMetaData extends FieldValueMetaData {
    public final FieldValueMetaData elemMetaData;

    public ListMetaData(byte b, FieldValueMetaData fieldValueMetaData) {
        super(b);
        this.elemMetaData = fieldValueMetaData;
    }
}
