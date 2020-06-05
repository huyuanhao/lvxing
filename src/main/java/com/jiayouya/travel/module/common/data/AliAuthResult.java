package com.jiayouya.travel.module.common.data;

import android.text.TextUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Map;

public class AliAuthResult {
    private String alipayOpenId;
    private String authCode;
    private String credential;
    private String memo;
    private String result;
    private String resultCode;
    private String resultStatus;

    public AliAuthResult(Map<String, String> map, boolean z) {
        String[] split;
        if (map != null) {
            for (String str : map.keySet()) {
                if (TextUtils.equals(str, "resultStatus")) {
                    this.resultStatus = (String) map.get(str);
                } else if (TextUtils.equals(str, ArgKey.KEY_RESULT)) {
                    this.result = (String) map.get(str);
                } else if (TextUtils.equals(str, "memo")) {
                    this.memo = (String) map.get(str);
                }
            }
            for (String str2 : this.result.split("&")) {
                if (str2.startsWith("alipay_open_id")) {
                    this.alipayOpenId = removeBrackets(getValue("alipay_open_id=", str2), z);
                } else if (str2.startsWith("auth_code")) {
                    this.authCode = removeBrackets(getValue("auth_code=", str2), z);
                } else if (str2.startsWith("result_code")) {
                    this.resultCode = removeBrackets(getValue("result_code=", str2), z);
                }
            }
        }
    }

    private String removeBrackets(String str, boolean z) {
        if (!z || TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "\"";
        if (str.startsWith(str2)) {
            str = str.replaceFirst(str2, "");
        }
        return str.endsWith(str2) ? str.substring(0, str.length() - 1) : str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("resultStatus={");
        sb.append(this.resultStatus);
        sb.append("};memo={");
        sb.append(this.memo);
        sb.append("};result={");
        sb.append(this.result);
        sb.append("}");
        return sb.toString();
    }

    private String getValue(String str, String str2) {
        return str2.substring(str.length(), str2.length());
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getAlipayOpenId() {
        return this.alipayOpenId;
    }

    public void setCredential(String str) {
        this.credential = str;
    }

    public String getCredential() {
        return this.credential;
    }
}
