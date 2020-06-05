package org.apache.thrift.transport;

import org.apache.thrift.TException;

public class TTransportException extends TException {
    public static final int ALREADY_OPEN = 2;
    public static final int CORRUPTED_DATA = 5;
    public static final int END_OF_FILE = 4;
    public static final int NOT_OPEN = 1;
    public static final int TIMED_OUT = 3;
    public static final int UNKNOWN = 0;
    private static final long serialVersionUID = 1;
    protected int type_ = 0;

    public TTransportException() {
    }

    public TTransportException(int i) {
        this.type_ = i;
    }

    public TTransportException(int i, String str) {
        super(str);
        this.type_ = i;
    }

    public TTransportException(String str) {
        super(str);
    }

    public TTransportException(int i, Throwable th) {
        super(th);
        this.type_ = i;
    }

    public TTransportException(Throwable th) {
        super(th);
    }

    public TTransportException(String str, Throwable th) {
        super(str, th);
    }

    public TTransportException(int i, String str, Throwable th) {
        super(str, th);
        this.type_ = i;
    }

    public int getType() {
        return this.type_;
    }
}
