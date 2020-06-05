package mtopsdk.mtop.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import mtopsdk.common.util.C8330d;

public class ErrorConstant {
    /* renamed from: a */
    private static HashMap<String, String> f27925a = new HashMap<>(128);
    /* renamed from: b */
    private static HashMap<String, String> f27926b = new HashMap<>(24);
    /* renamed from: c */
    private static HashMap<String, String> f27927c;

    /* renamed from: mtopsdk.mtop.util.ErrorConstant$ErrorMappingType */
    public interface ErrorMappingType {

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: mtopsdk.mtop.util.ErrorConstant$ErrorMappingType$Definition */
        public @interface Definition {
        }
    }

    /* renamed from: mtopsdk.mtop.util.ErrorConstant$MappingMsg */
    public interface MappingMsg {

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: mtopsdk.mtop.util.ErrorConstant$MappingMsg$Definition */
        public @interface Definition {
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>(64);
        f27927c = hashMap;
        hashMap.put("FAIL_SYS_API_STOP_SERVICE", "ES10000");
        f27927c.put("FAIL_SYS_SM_ODD_REQUEST", "ES10001");
        f27927c.put("FAIL_SYS_API_NOT_FOUNDED", "ES10002");
        f27927c.put("FAIL_SYS_SESSION_EXPIRED", "ES10003");
        f27927c.put("FAIL_SYS_SYSTEM_BUSY_ERROR", "ES10004");
        f27927c.put("FAIL_SYS_SERVLET_ASYNC_START_FAIL", "ES10005");
        f27927c.put("FAIL_SYS_FLOWLIMIT", "ES10006");
        f27927c.put("FAIL_SYS_API_UNAUTHORIZED", "ES10007");
        f27927c.put("FAIL_SYS_PROTOPARAM_MISSED", "ES10008");
        f27927c.put("FAIL_SYS_PROTOVER_MISSED", "ES10009");
        f27927c.put("FAIL_SYS_REQUEST_EXPIRED", "ES10010");
        f27927c.put("FAIL_SYS_ILEGEL_SIGN", "ES10011");
        f27927c.put("FAIL_SYS_INVALID_HTTP_METHOD", "ES10012");
        f27927c.put("FAIL_SYS_BADARGUMENT_T", "ES10013");
        f27927c.put("FAIL_SYS_UNKNOWN_APP", "ES10014");
        f27927c.put("FAIL_SYS_INTERNAL_FAULT", "ES10015");
        f27927c.put("FAIL_SYS_TRAFFIC_LIMIT", "ES10016");
        f27927c.put("FAIL_SYS_BIZPARAM_TYPE_ERROR", "ES10017");
        f27927c.put("FAIL_SYS_BIZPARAM_MISSED", "ES10018");
        f27927c.put("FAIL_SYS_TOPAUTHPARAM_MISSED", "ES10019");
        f27927c.put("FAIL_SYS_TOPAUTH_FAILED", "ES10020");
        f27927c.put("FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR", "ES10021");
        f27927c.put("FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR", "ES10022");
        f27927c.put("FAIL_SYS_TOPUNAUTHAPI_ERROR", "ES10023");
        f27927c.put("FAIL_SYS_TOPAUTH_FAULT", "ES10024");
        f27927c.put("FAIL_SYS_RETMISSED_ERROR", "ES10025");
        f27927c.put("FAIL_SYS_PARAMINVALID_ERROR", "ES10026");
        f27927c.put("SYSTEM_ERROR", "ES10027");
        f27927c.put("FAIL_SYS_UNAUTHORIZED_ENTRANCE", "ES10028");
        f27927c.put("FAIL_SYS_SESSION_ERROR", "ES10029");
        f27927c.put("FAIL_SYS_MT_ODD_REQUEST", "ES10030");
        f27927c.put("FAIL_SYS_EXPIRED_REQUEST", "ES10031");
        f27927c.put("FAIL_SYS_PORTOCOLPARAM_INVALID", "ES10032");
        f27927c.put("FAIL_SYS_INVALID_PROTOCOLVERSION", "ES10033");
        f27927c.put("FAIL_SYS_PARAM_MISSING", "ES10035");
        f27927c.put("FAIL_SYS_PARAM_FORMAT_ERROR", "ES10036");
        f27927c.put("FAIL_SYS_ILLEGAL_ARGUMENT_TTID", "ES10034");
        f27927c.put("FAIL_SYS_ILLEGAL_ACCESS_TOKEN", "ES10037");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", "ES10038");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT", "ES10039");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT", "ES10040");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_EXPIRED", "ES10041");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID", "ES10042");
        f27927c.put("FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR", "ES10043");
        f27927c.put("FAIL_SYS_REQUEST_QUEUED", "ES10044");
        f27927c.put("FAIL_SYS_SERVICE_NOT_EXIST", "ES20000");
        f27927c.put("FAIL_SYS_SERVICE_TIMEOUT", "ES20001");
        f27927c.put("FAIL_SYS_SERVICE_FAULT", "ES20002");
        f27927c.put("FAIL_SYS_HTTP_QUERYIP_ERROR", "ES30000");
        f27927c.put("FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED", "ES30001");
        f27927c.put("FAIL_SYS_HTTP_INVOKE_ERROR", "ES30002");
        f27927c.put("FAIL_SYS_HTTP_RESPONSE_TIMEOUT", "ES30003");
        f27927c.put("FAIL_SYS_HTTP_CONNECT_TIMEOUT", "ES30004");
        f27927c.put("UNKNOWN_FAIL_CODE", "ES40000");
        f27927c.put("FAIL_SYS_HSF_THROWN_EXCEPTION", "ES40001");
        f27927c.put("FAIL_SYS_HTTP_RESULT_FIELDMISSED", "ES40003");
        f27927c.put("FAIL_SYS_SERVICE_INNER_FAULT", "ES40002");
        f27926b.put("ANDROID_SYS_NO_NETWORK", "EC10000");
        f27926b.put("ANDROID_SYS_NETWORK_ERROR", "EC10001");
        f27926b.put("ANDROID_SYS_JSONDATA_BLANK", "EC30000");
        f27926b.put("ANDROID_SYS_JSONDATA_PARSE_ERROR", "EC30001");
        f27926b.put("ANDROID_SYS_MTOPSDK_INIT_ERROR", "EC40000");
        f27926b.put("ANDROID_SYS_MTOPCONTEXT_INIT_ERROR", "EC40001");
        f27926b.put("ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR", "EC40002");
        f27926b.put("ANDROID_SYS_NETWORK_REQUEST_CONVERT_ERROR", "EC40003");
        f27926b.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "EC20000");
        f27926b.put("ANDROID_SYS_API_41X_ANTI_ATTACK", "EC20001");
        f27926b.put("ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "EC40004");
        f27926b.put("ANDROID_SYS_INIT_MTOP_ISIGN_ERROR", "EC40005");
        f27926b.put("ANDROID_SYS_MTOP_MISS_CALL_FACTORY", "EC40006");
        f27926b.put("ANDROID_SYS_LOGIN_FAIL", "EC40007");
        f27926b.put("ANDROID_SYS_LOGIN_CANCEL", "EC40008");
        f27926b.put("ANDROID_SYS_ILLEGAL_JSPARAM_ERROR", "EC40009");
        f27926b.put("ANDROID_SYS_PARSE_JSPARAM_ERROR", "EC40010");
        f27926b.put("ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR", "EC40011");
        f27925a.putAll(f27927c);
        f27925a.putAll(f27926b);
        String str = "SUCCESS";
        f27925a.put(str, str);
    }

    /* renamed from: a */
    public static String m35558a(String str) {
        return (String) f27925a.get(str);
    }

    /* renamed from: b */
    public static boolean m35559b(String str) {
        return f27927c.containsKey(str);
    }

    /* renamed from: c */
    public static boolean m35560c(String str) {
        return C8330d.m35525b(str) || f27926b.containsKey(str);
    }

    /* renamed from: d */
    public static boolean m35561d(String str) {
        return "ANDROID_SYS_NETWORK_ERROR".equals(str) || "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    /* renamed from: e */
    public static boolean m35562e(String str) {
        return "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    /* renamed from: f */
    public static boolean m35563f(String str) {
        return "FAIL_SYS_SESSION_EXPIRED".equals(str) || "ANDROID_SYS_LOGIN_FAIL".equals(str);
    }

    /* renamed from: g */
    public static boolean m35564g(String str) {
        return "FAIL_SYS_ILEGEL_SIGN".equals(str);
    }

    /* renamed from: h */
    public static boolean m35565h(String str) {
        return "SUCCESS".equals(str);
    }

    /* renamed from: i */
    public static boolean m35566i(String str) {
        return "ANDROID_SYS_API_41X_ANTI_ATTACK".equals(str);
    }

    /* renamed from: j */
    public static boolean m35567j(String str) {
        return "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equals(str);
    }

    /* renamed from: k */
    public static boolean m35568k(String str) {
        return "FAIL_SYS_EXPIRED_REQUEST".equals(str) || "FAIL_SYS_REQUEST_EXPIRED".equals(str);
    }

    /* renamed from: l */
    public static boolean m35569l(String str) {
        return str != null && (f27927c.containsKey(str) || str.startsWith("FAIL_SYS_"));
    }

    /* renamed from: a */
    public static String m35557a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("A");
        sb.append(str);
        return sb.toString();
    }
}
