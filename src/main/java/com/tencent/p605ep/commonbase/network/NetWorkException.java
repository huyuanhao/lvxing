package com.tencent.p605ep.commonbase.network;

/* renamed from: com.tencent.ep.commonbase.network.NetWorkException */
public class NetWorkException extends Exception {
    private static final long serialVersionUID = 1;
    private int errCode;

    public NetWorkException(int i, String str) {
        super(str);
        this.errCode = i;
    }

    public NetWorkException(int i, String str, Throwable th) {
        super(str, th);
        this.errCode = i;
    }

    public NetWorkException(int i, Throwable th) {
        super(th.getMessage(), th);
        this.errCode = i;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        String message = getMessage();
        if (message == null) {
            Throwable cause = getCause();
            if (cause != null) {
                message = cause.getMessage();
            }
        }
        return message != null ? message : "";
    }
}
