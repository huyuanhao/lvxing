package com.tencent.mid.util;

import android.content.Context;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.Perference;
import org.json.JSONObject;

public class ConstantUtil {
    private static String HTTP_SERVICE = null;
    private static final String HTTP_SERVICE_KEY = "http_service";
    private static String INFO_URL = null;
    private static final String INFO_URL_KEY = "info_url";
    public static final String PREFIX = "teg_mid_";
    private static String PSW_URL = null;
    private static final String PSW_URL_KEY = "http_url";
    private static String RMID_URL = null;
    private static final String RMID_URL_KEY = "rmid_url";
    private static int RSA_KEY_VERSION = 0;
    private static final String RSA_KEY_VERSION_KEY = "key_version";
    private static String RSA_PK = null;
    private static final String RSA_PK_KEY = "rsa_pk";
    private static String VMID_URL = null;
    private static final String VMID_URL_KEY = "vmid_url";
    private static ConstantUtil instance = null;
    private static Logger logger = Util.getLogger();
    private Context context = null;
    private Perference perference = null;

    public String getRequestMidNewUrl() {
        return Constants.REQUEST_MID_NEW_URL;
    }

    public String getRequestMidUrl() {
        return Constants.REQUEST_MID_URL;
    }

    public String getVerifyMidUrl() {
        return Constants.VERIFY_MID_URL;
    }

    private ConstantUtil(Context context2) {
        this.context = context2;
        this.perference = new Perference(context2, 0);
    }

    public static synchronized ConstantUtil getInstance(Context context2) {
        ConstantUtil constantUtil;
        synchronized (ConstantUtil.class) {
            if (instance == null) {
                instance = new ConstantUtil(context2);
            }
            constantUtil = instance;
        }
        return constantUtil;
    }

    public void updateConstants(JSONObject jSONObject) throws Exception {
        String str = HTTP_SERVICE_KEY;
        if (jSONObject.isNull(str)) {
            putHttpService(jSONObject.getString(str));
        }
        String str2 = PSW_URL_KEY;
        if (jSONObject.isNull(str2)) {
            putPSWUrl(jSONObject.getString(str2));
        }
        String str3 = RMID_URL_KEY;
        if (jSONObject.isNull(str3)) {
            putRMidUrl(jSONObject.getString(str3));
        }
        String str4 = VMID_URL_KEY;
        if (jSONObject.isNull(str4)) {
            putVMidUrl(jSONObject.getString(str4));
        }
        String str5 = INFO_URL_KEY;
        if (jSONObject.isNull(str5)) {
            putInfoUrl(jSONObject.getString(str5));
        }
    }

    public int getRSAKeyVersion() {
        try {
            if (RSA_KEY_VERSION == 0) {
                RSA_KEY_VERSION = Integer.parseInt(this.perference.read("teg_mid_key_version"));
            }
            return RSA_KEY_VERSION;
        } catch (Exception unused) {
            return 2;
        }
    }

    public void putRSAKeyVersion(int i) throws Exception {
        Perference perference2 = this.perference;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        perference2.write("teg_mid_key_version", sb.toString());
        RSA_KEY_VERSION = i;
    }

    public String getRSAPK() {
        String str = Constants.RSA_PK;
        try {
            if (Util.isEmpty(RSA_PK)) {
                RSA_PK = this.perference.read("teg_mid_rsa_pk");
            }
            if (Util.isEmpty(RSA_PK)) {
                return str;
            }
            str = RSA_PK;
            return str;
        } catch (Exception unused) {
        }
    }

    public void putRSAPK(String str) throws Exception {
        this.perference.write("teg_mid_rsa_pk", str);
        RSA_PK = str;
    }

    public String getHttpService() {
        String str = Constants.HTTP_SERVICE;
        try {
            if (Util.isEmpty(HTTP_SERVICE)) {
                HTTP_SERVICE = this.perference.read("teg_mid_http_service");
            }
            if (Util.isEmpty(HTTP_SERVICE)) {
                return str;
            }
            str = HTTP_SERVICE;
            return str;
        } catch (Exception unused) {
        }
    }

    public void putHttpService(String str) throws Exception {
        this.perference.write("teg_mid_http_service", str);
        HTTP_SERVICE = str;
    }

    public String getPSWUrl() {
        String str = Constants.PSW_URL;
        try {
            if (Util.isEmpty(PSW_URL)) {
                PSW_URL = this.perference.read("teg_mid_http_url");
            }
            if (Util.isEmpty(PSW_URL)) {
                return str;
            }
            str = PSW_URL;
            return str;
        } catch (Exception unused) {
        }
    }

    public void putPSWUrl(String str) throws Exception {
        this.perference.write("teg_mid_http_url", str);
        PSW_URL = str;
    }

    public void putRMidUrl(String str) throws Exception {
        this.perference.write("teg_mid_rmid_url", str);
        RMID_URL = str;
    }

    public void putVMidUrl(String str) throws Exception {
        this.perference.write("teg_mid_vmid_url", str);
        VMID_URL = str;
    }

    public String getInfoUrl() {
        String str = Constants.INFO_URL;
        try {
            if (Util.isEmpty(INFO_URL)) {
                INFO_URL = this.perference.read("teg_mid_info_url");
            }
            if (Util.isEmpty(INFO_URL)) {
                return str;
            }
            str = INFO_URL;
            return str;
        } catch (Exception unused) {
        }
    }

    public void putInfoUrl(String str) throws Exception {
        this.perference.write("teg_mid_info_url", str);
        INFO_URL = str;
    }
}
