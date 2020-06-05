package org.apache.thrift.p704a;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

/* renamed from: org.apache.thrift.a.a */
public interface IScheme<T extends TBase> {
    void read(TProtocol fVar, T t) throws TException;

    void write(TProtocol fVar, T t) throws TException;
}
