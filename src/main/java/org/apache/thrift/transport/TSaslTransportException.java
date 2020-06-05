package org.apache.thrift.transport;

public class TSaslTransportException extends TTransportException {
    public TSaslTransportException() {
    }

    public TSaslTransportException(String str) {
        super(str);
    }

    public TSaslTransportException(Throwable th) {
        super(th);
    }

    public TSaslTransportException(String str, Throwable th) {
        super(str, th);
    }
}
