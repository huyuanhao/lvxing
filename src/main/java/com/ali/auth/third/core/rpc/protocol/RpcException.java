package com.ali.auth.third.core.rpc.protocol;

public class RpcException extends RuntimeException {
    private static final long serialVersionUID = -2875437994101380406L;
    private int mCode;
    private String mMsg;

    public RpcException(Integer num, String str) {
        super(m1975a(num, str));
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    public RpcException(Integer num, Throwable th) {
        super(th);
        this.mCode = num.intValue();
    }

    public RpcException(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }

    /* renamed from: a */
    protected static String m1975a(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("RPCException: ");
        if (num != null) {
            sb.append("[");
            sb.append(num);
            sb.append("]");
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean isNetworkError(int i) {
        return i == 7;
    }

    public static boolean isSystemError(int i) {
        return i == 7 || (i >= 400 && i <= 408);
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
