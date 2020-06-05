package org.apache.thrift;

import java.io.Serializable;
import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;

public interface TBase<T extends TBase<T, F>, F extends TFieldIdEnum> extends Serializable, Comparable<T>, TSerializable {
    void clear();

    T deepCopy();

    F fieldForId(int i);

    Object getFieldValue(F f);

    boolean isSet(F f);

    void setFieldValue(F f, Object obj);
}
