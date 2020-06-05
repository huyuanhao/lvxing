package mtopsdk.mtop.domain;

import com.p522qq.p523e.comm.constants.Constants.KEYS;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopStatistics;
import org.json.JSONArray;
import org.json.JSONObject;

public class MtopResponse implements Serializable {
    private static final String SHARP = "::";
    private static final String TAG = "mtopsdk.MtopResponse";
    private static final long serialVersionUID = 1566423746968673499L;
    private String api;
    private volatile boolean bParsed = false;
    private byte[] bytedata;
    @Deprecated
    private byte[] data;
    private JSONObject dataJsonObject;
    private Map<String, List<String>> headerFields;
    public String mappingCode;
    public String mappingCodeSuffix;
    private MtopStatistics mtopStat;
    private int responseCode;
    private ResponseSource responseSource = ResponseSource.NETWORK_REQUEST;
    @Deprecated
    private String[] ret;
    private String retCode;
    private String retMsg;
    /* renamed from: v */
    private String f27921v;

    /* renamed from: mtopsdk.mtop.domain.MtopResponse$ResponseSource */
    public enum ResponseSource {
        FRESH_CACHE,
        EXPIRED_CACHE,
        NETWORK_REQUEST
    }

    public MtopResponse() {
    }

    public MtopResponse(String str, String str2) {
        this.retCode = str;
        this.retMsg = str2;
    }

    public MtopResponse(String str, String str2, String str3, String str4) {
        this.api = str;
        this.f27921v = str2;
        this.retCode = str3;
        this.retMsg = str4;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public String getMappingCode() {
        return this.mappingCode;
    }

    public String getRetMsg() {
        if (this.retMsg == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.retMsg;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }

    public String getApi() {
        if (this.api == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.api;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public String getV() {
        if (this.f27921v == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.f27921v;
    }

    public void setV(String str) {
        this.f27921v = str;
    }

    @Deprecated
    public String[] getRet() {
        if (this.ret == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.ret;
    }

    @Deprecated
    public void setRet(String[] strArr) {
        this.ret = strArr;
    }

    @Deprecated
    public byte[] getData() {
        return this.data;
    }

    @Deprecated
    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public JSONObject getDataJsonObject() {
        if (this.dataJsonObject == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.dataJsonObject;
    }

    public void setDataJsonObject(JSONObject jSONObject) {
        this.dataJsonObject = jSONObject;
    }

    public byte[] getBytedata() {
        return this.bytedata;
    }

    public void setBytedata(byte[] bArr) {
        this.bytedata = bArr;
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.headerFields;
    }

    public void setHeaderFields(Map<String, List<String>> map) {
        this.headerFields = map;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public MtopStatistics getMtopStat() {
        return this.mtopStat;
    }

    public void setMtopStat(MtopStatistics mtopStatistics) {
        this.mtopStat = mtopStatistics;
    }

    public void parseJsonByte() {
        if (!this.bParsed) {
            synchronized (this) {
                if (!this.bParsed) {
                    if (this.bytedata == null || this.bytedata.length == 0) {
                        if (TBSdkLog.m35509b(LogEnable.ErrorEnable)) {
                            String str = TAG;
                            StringBuilder sb = new StringBuilder("[parseJsonByte]MtopResponse bytedata is blank,api=");
                            sb.append(this.api);
                            sb.append(",v=");
                            sb.append(this.f27921v);
                            TBSdkLog.m35510c(str, sb.toString());
                        }
                        if (C8330d.m35525b(this.retCode)) {
                            this.retCode = "ANDROID_SYS_JSONDATA_BLANK";
                        }
                        if (C8330d.m35525b(this.retMsg)) {
                            this.retMsg = "返回JSONDATA为空";
                        }
                        this.bParsed = true;
                        return;
                    }
                    try {
                        String str2 = new String(this.bytedata);
                        if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
                            String str3 = TAG;
                            StringBuilder sb2 = new StringBuilder("[parseJsonByte]MtopResponse bytedata : ");
                            sb2.append(str2);
                            TBSdkLog.m35501a(str3, sb2.toString());
                        }
                        JSONObject jSONObject = new JSONObject(str2);
                        if (this.api == null) {
                            this.api = jSONObject.getString("api");
                        }
                        if (this.f27921v == null) {
                            this.f27921v = jSONObject.getString("v");
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray(KEYS.RET);
                        int length = jSONArray.length();
                        this.ret = new String[length];
                        for (int i = 0; i < length; i++) {
                            this.ret[i] = jSONArray.getString(i);
                        }
                        if (length > 0) {
                            String str4 = this.ret[0];
                            if (C8330d.m35523a(str4)) {
                                String[] split = str4.split(SHARP);
                                if (split != null && split.length > 1) {
                                    if (C8330d.m35525b(this.retCode)) {
                                        this.retCode = split[0];
                                    }
                                    if (C8330d.m35525b(this.retMsg)) {
                                        this.retMsg = split[1];
                                    }
                                }
                            }
                        }
                        this.dataJsonObject = jSONObject.optJSONObject("data");
                    } catch (Throwable th) {
                        this.bParsed = true;
                        throw th;
                    }
                    this.bParsed = true;
                }
            }
        }
    }

    public void setSource(ResponseSource responseSource2) {
        this.responseSource = responseSource2;
    }

    public ResponseSource getSource() {
        return this.responseSource;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(",v=");
            sb.append(this.f27921v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",data=");
            sb.append(this.dataJsonObject);
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append(",bytedata=");
            sb.append(this.bytedata == null ? null : new String(this.bytedata));
            sb.append("]");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return super.toString();
        }
    }

    public String getResponseLog() {
        String str = ",v=";
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(str);
            sb.append(this.f27921v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append("]");
            str = sb.toString();
            return str;
        } catch (Throwable unused) {
            if (TBSdkLog.m35509b(LogEnable.ErrorEnable)) {
                StringBuilder sb2 = new StringBuilder("[getResponseLog]MtopResponse get log error, api=");
                sb2.append(this.api);
                sb2.append(str);
                sb2.append(this.f27921v);
                TBSdkLog.m35510c(TAG, sb2.toString());
            }
            return super.toString();
        }
    }

    public String getFullKey() {
        if (C8330d.m35525b(this.api) || C8330d.m35525b(this.f27921v)) {
            return null;
        }
        return C8330d.m35524b(this.api, this.f27921v);
    }

    public boolean isApiSuccess() {
        return ErrorConstant.m35565h(getRetCode()) && getBytedata() != null;
    }

    public boolean isExpiredRequest() {
        return ErrorConstant.m35568k(getRetCode());
    }

    @Deprecated
    public boolean isSystemError() {
        return ErrorConstant.m35559b(getRetCode());
    }

    public boolean isNetworkError() {
        return ErrorConstant.m35561d(getRetCode());
    }

    public boolean isNoNetwork() {
        return ErrorConstant.m35562e(getRetCode());
    }

    public boolean isSessionInvalid() {
        return ErrorConstant.m35563f(getRetCode());
    }

    @Deprecated
    public boolean isIllegelSign() {
        return ErrorConstant.m35564g(getRetCode());
    }

    public boolean is41XResult() {
        return ErrorConstant.m35566i(getRetCode());
    }

    public boolean isApiLockedResult() {
        return 420 == this.responseCode || ErrorConstant.m35567j(getRetCode());
    }

    public boolean isApiLockedAndRequestQueued() {
        if (420 == this.responseCode) {
            if ("FAIL_SYS_REQUEST_QUEUED".equalsIgnoreCase(getRetCode())) {
                return true;
            }
        }
        return false;
    }

    public boolean isMtopSdkError() {
        return ErrorConstant.m35560c(getRetCode());
    }

    public boolean isMtopServerError() {
        return ErrorConstant.m35569l(getRetCode());
    }
}
