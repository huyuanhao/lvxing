package org.apache.thrift.protocol;

import org.apache.thrift.TException;

public class TProtocolException extends TException {
    public static final int BAD_VERSION = 4;
    public static final int DEPTH_LIMIT = 6;
    public static final int INVALID_DATA = 1;
    public static final int NEGATIVE_SIZE = 2;
    public static final int NOT_IMPLEMENTED = 5;
    public static final int SIZE_LIMIT = 3;
    public static final int UNKNOWN = 0;
    private static final long serialVersionUID = 1;
    protected int type_ = 0;

    public TProtocolException() {
    }

    public TProtocolException(int i) {
        this.type_ = i;
    }

    public TProtocolException(int i, String str) {
        super(str);
        this.type_ = i;
    }

    public TProtocolException(String str) {
        super(str);
    }

    public TProtocolException(int i, Throwable th) {
        super(th);
        this.type_ = i;
    }

    public TProtocolException(Throwable th) {
        super(th);
    }

    public TProtocolException(String str, Throwable th) {
        super(str, th);
    }

    public TProtocolException(int i, String str, Throwable th) {
        super(str, th);
        this.type_ = i;
    }

    public int getType() {
        return this.type_;
    }
}
