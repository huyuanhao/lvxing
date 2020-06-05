package com.tmsdk.module.coin;

public interface ErrorCode {
    public static final int EC_FAIL = -8001;
    public static final int EC_ORDER_RESUBMIT = 4004;
    public static final int EC_PARAM_INVALID = -8002;
    public static final int EC_PARAM_INVALID_GUID = -8003;
    public static final int EC_SUCCESS = 0;
    public static final int ERC_LOGIN_ACCOUNT_INVALID = 6002;
    public static final int ERC_LOGIN_FAIL = 6004;
    public static final int ERC_LOGIN_PARAM_INVALID = 6001;
    public static final int ERC_LOGIN_TOKEN_EXPIRE = 6003;
    public static final int ERC_TASK_ACCOUNT_INVALID = 3003;
    public static final int ERC_TASK_BANK_FAIL = 3010;
    public static final int ERC_TASK_CACHE_EXCEP = 3006;
    public static final int ERC_TASK_CHECK_FAIL = 3005;
    public static final int ERC_TASK_GET_FAIL = 3007;
    public static final int ERC_TASK_INVALID = 3004;
    public static final int ERC_TASK_ORDER_EXPIRE = 3013;
    public static final int ERC_TASK_ORDER_FAIL = 3015;
    public static final int ERC_TASK_ORDER_INVALID = 3011;
    public static final int ERC_TASK_ORDER_RESUBMIT = 3014;
    public static final int ERC_TASK_ORDER_UNEXIST = 3012;
    public static final int ERC_TASK_PARAM_INVALID = 3001;
    public static final int ERC_TASK_PRODUCT_INVALID = 3002;
    public static final int ERC_TASK_REPORT_FAIL = 3009;
    public static final int ERC_TASK_SET_FAIL = 3008;
}
