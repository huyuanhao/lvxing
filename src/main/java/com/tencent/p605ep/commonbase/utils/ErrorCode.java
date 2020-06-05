package com.tencent.p605ep.commonbase.utils;

/* renamed from: com.tencent.ep.commonbase.utils.ErrorCode */
public class ErrorCode {
    public static final int ERR_ARGUMENT = -6;
    public static final int ERR_CANCEL = -3;
    public static final int ERR_FILE_OP = -7000;
    public static final int ERR_GENERAL = -2;
    public static final int ERR_GET = -3000;
    public static final int ERR_ILLEGAL_ACCESS = -60;
    public static final int ERR_ILLEGAL_ARG = -57;
    public static final int ERR_ILLEGAL_STATE = -61;
    public static final int ERR_IO_EXCEPTION = -56;
    public static final int ERR_LICENSE_EXPIRED = -99999;
    public static final int ERR_MERGE_DIFF_OP = -9000;
    public static final int ERR_NONE = 0;
    public static final int ERR_NOT_COMPLETED = -7;
    public static final int ERR_NOT_FOUND = -1;
    public static final int ERR_NOT_SUPPORTED = -5;
    public static final int ERR_NO_CONNECTION = -52;
    public static final int ERR_NO_MEMORY = -4;
    public static final int ERR_OPEN_CONNECTION = -1000;
    public static final int ERR_POST = -2000;
    public static final int ERR_PROTOCOL = -51;
    public static final int ERR_RECEIVE = -5000;
    public static final int ERR_RESPONSE = -4000;
    public static final int ERR_SECURITY = -58;
    public static final int ERR_SHARK = -8000;
    public static final int ERR_SHARK_DATA_RET = -80;
    public static final int ERR_SOCKET = -54;
    public static final int ERR_SOCKET_TIMEOUT = -55;
    public static final int ERR_UNSUPPORTED_OP = -59;
    public static final int ERR_URL_MALFORMED = -53;
    public static final int ERR_WUP = -6000;

    /* renamed from: com.tencent.ep.commonbase.utils.ErrorCode$ErrorType */
    public enum ErrorType {
        NETWORK,
        WUP,
        CANCEL,
        OTHER
    }

    public static ErrorType judgeErrorCode(int i) {
        ErrorType errorType = ErrorType.OTHER;
        int i2 = -i;
        if ((-(i2 % 100)) == -3) {
            return ErrorType.CANCEL;
        }
        int i3 = -((i2 / 1000) * 1000);
        return (i3 == -5000 || i3 == -4000 || i3 == -3000 || i3 == -2000 || i3 == -1000) ? ErrorType.NETWORK : errorType;
    }
}
