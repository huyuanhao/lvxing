package com.tencent.p605ep.common.adapt.iservice.account;

/* renamed from: com.tencent.ep.common.adapt.iservice.account.AccountConst */
public class AccountConst {
    public static final String ACTION_CALL_CALLBACK = "qqpimsecure.piaccount.action.call_callback";
    public static final String ACTION_CALL_REQUEST = "qqpimsecure.piaccount.action.call_request";
    public static final String ACTION_CALL_RESULT = "qqpimsecure.piaccount.action.call_result";
    private static final int BASE_FUNCTION_ID = 17498112;
    public static final String KEY_IN_BUNDLE = "in_bundle";
    public static final String KEY_OUT_BUNDLE = "out_bundle";
    public static final String KEY_RESULT_CODE = "result_code";
    public static final String KEY_SESSION_ID = "session_id";

    /* renamed from: com.tencent.ep.common.adapt.iservice.account.AccountConst$AccountAuth */
    public interface AccountAuth {
        public static final int ACCOUNT_STATUS_EXPIRED = 2;
        public static final int ACCOUNT_STATUS_LOGGED = 0;
        public static final int ACCOUNT_STATUS_LOGOUT = 1;
        public static final int ACCOUNT_TYPE_MOBILE = 3;
        public static final int ACCOUNT_TYPE_QQ = 1;
        public static final int ACCOUNT_TYPE_QQPIM = 4;
        public static final int ACCOUNT_TYPE_WX = 2;
        public static final int AUTH_MODE_AUTH = 0;
        public static final int AUTH_MODE_BIND = 4;
        public static final int AUTH_MODE_CHANGE_BIND = 5;
        public static final int AUTH_MODE_LOGIN = 1;
        public static final int AUTH_MODE_LOGOUT = 3;
        public static final int AUTH_MODE_RELOGIN = 7;
        public static final int AUTH_MODE_UNBIND = 6;
        public static final int AUTH_POLICY_JUST_QQ = 1;
        public static final int AUTH_POLICY_JUST_WX = 2;
        public static final int AUTH_POLICY_MOBILE_DOWN = 10;
        public static final int AUTH_POLICY_MOBILE_ISP = 16;
        public static final int AUTH_POLICY_MOBILE_MIXED = 13;
        public static final int AUTH_POLICY_MOBILE_NONE = 9;
        public static final int AUTH_POLICY_MOBILE_UP = 11;
        public static final int AUTH_POLICY_MOBILE_UP_4_FD = 12;
        public static final int AUTH_POLICY_QQ_FIRST = 3;
        public static final int AUTH_POLICY_QQ_QQPIM = 15;
        public static final int AUTH_POLICY_QQ_WX = 14;
        public static final int AUTH_POLICY_USER_DECIDE = 0;
        public static final int AUTH_POLICY_WX_FIRST = 4;
        public static final int OAUTH_POLICY_AUTO_CONFIRM = 1;
        public static final int OAUTH_POLICY_FREE_CONFIRM = 2;
        public static final int OAUTH_POLICY_USER_CONFIRM = 0;
        public static final int RESULT_BAD_CLIENT = 14;
        public static final int RESULT_BAD_SCOPE = 15;
        public static final int RESULT_FAILED_ARG = 4;
        public static final int RESULT_FAILED_AUTH = 3;
        public static final int RESULT_FAILED_BIND = 8;
        public static final int RESULT_FAILED_ISP1 = 16;
        public static final int RESULT_FAILED_ISP2 = 17;
        public static final int RESULT_FAILED_ISP3 = 18;
        public static final int RESULT_FAILED_ISP4 = 19;
        public static final int RESULT_FAILED_ISP5 = 20;
        public static final int RESULT_FAILED_NETWORK = 2;
        public static final int RESULT_FAILED_SMS = 12;
        public static final int RESULT_FAILED_TIMEOUT = 5;
        public static final int RESULT_FAILED_TOKEN = 6;
        public static final int RESULT_FAILED_UNBIND = 7;
        public static final int RESULT_FAILED_UNKNOWN = 255;
        public static final int RESULT_GUID_MISSED = 10;
        public static final int RESULT_IMSI_MISSED = 9;
        public static final int RESULT_NOT_MOBILE_NET = 21;
        public static final int RESULT_NO_SIM = 11;
        public static final int RESULT_SUCCEED = 0;
        public static final int RESULT_USER_CANCELLED = 1;
        public static final int RESULT_USER_DENIED = 13;
        public static final String TOKEN_TYPE = "token_type";
        public static final int TOKEN_TYPE_ACCESS = 0;
        public static final int TOKEN_TYPE_REFRESH = 1;
        public static final String TOKEN_VALUE = "token_value";
    }

    /* renamed from: com.tencent.ep.common.adapt.iservice.account.AccountConst$ArgKey */
    public interface ArgKey {
        public static final String KEY_ACCOUNT = "account";
        public static final String KEY_ACCOUNT_INFO = "account_info";
        public static final String KEY_ACCOUNT_TYPE = "account_type";
        public static final String KEY_APP_ID = "app_id";
        public static final String KEY_APP_PKG = "app_pkg";
        public static final String KEY_AUTHORIZED = "authorized";
        public static final String KEY_AUTH_MODE = "auth_mode";
        public static final String KEY_AUTH_POLICY = "auth_policy";
        public static final String KEY_CODE = "authorization_code";
        public static final String KEY_DESC = "desc";
        public static final String KEY_ENABLE_INNER_GUIDE = "inner_guide";
        public static final String KEY_FACE = "face";
        public static final String KEY_FACE_URL = "face_url";
        public static final String KEY_FORCE = "force";
        public static final String KEY_IMSI = "imsi";
        public static final String KEY_MAIN_ACCOUNT_INFO = "main_account_info";
        public static final String KEY_MOBILE = "mobile";
        public static final String KEY_NAME = "name";
        public static final String KEY_OPERATOR = "operator";
        public static final String KEY_OUTSIDE = "outside";
        public static final String KEY_POLICY = "policy";
        public static final String KEY_PORT = "sms_port";
        public static final String KEY_PORT_LIST = "port_list";
        public static final String KEY_REMIND_PAY = "remind_pay";
        public static final String KEY_RESULT = "result";
        public static final String KEY_SCOPES = "scopes";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_STATE = "state";
        public static final String KEY_TITLE = "title";
        public static final String KEY_TOKEN = "token";
        public static final String KEY_TOKENS = "tokens";
        public static final String KEY_TOKEN_TYPE = "token_type";
        public static final String KEY_TOKEN_TYPES = "token_types";
        public static final String KEY_VALUE = "value";
    }
}
