package org.apache.thrift;

import org.apache.thrift.protocol.TProtocol;

/* renamed from: org.apache.thrift.f */
public interface TSerializable {
    void read(TProtocol fVar) throws TException;

    void write(TProtocol fVar) throws TException;
}
