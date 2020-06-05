package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.core.p318b.C4062b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdConfigData implements C4321b, Serializable {
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    private static final long serialVersionUID = -7796837168148055391L;
    public AdConfigs abConfig = new AdConfigs();
    public String errorMsg;
    public long requestInterval = 3600;
    public int result;

    /* renamed from: com.kwad.sdk.core.response.model.AdConfigData$AdConfigs */
    public static class AdConfigs implements C4321b, Serializable {
        public static final int DEF_CONFIG_BATCH_REPORT_CACHE_LIMIT = 20;
        public static final int DEF_CONFIG_BATCH_REPORT_CACHE_TYPE = 0;
        public static final int DEF_CONFIG_COMMENT_BUTTON_SWITCH = 1;
        public static final int DEF_CONFIG_LIKEBUTTON_SWITCH = 1;
        public static final int DEF_CONFIG_MOREBUTTON_SWITCH = 1;
        public static final int DEF_CONFIG_SEEKBAR_SWITCH = 59;
        public static final int DEF_CONFIG_TOOLBAR_SWITCH = 1;
        public static final int DEF_CONFIG_VIDEOCACHE_SWITCH = 0;
        private static final long serialVersionUID = -7384650020600652751L;
        public int batchReportCacheType = 0;
        public int batchReportCatchLimit = 20;
        public int commentButtonSwitch = 1;
        public List<String> hostList = new ArrayList();
        public int likeButtonSwitch = 1;
        public int moreButtonSwitch = 1;
        public List<String> pkgNameList = new ArrayList();
        public int seekBarSwitch = 59;
        public int toolbarSwitch = 1;
        public int videoCacheSwitch = 0;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.toolbarSwitch = jSONObject.optInt("toolbarSwitch", 1);
                this.likeButtonSwitch = jSONObject.optInt("likeButtonSwitch", 1);
                this.moreButtonSwitch = jSONObject.optInt("moreButtonSwitch", 1);
                this.commentButtonSwitch = jSONObject.optInt("commentButtonSwitch", 1);
                this.seekBarSwitch = jSONObject.optInt("seekBarSwitch", 59);
                this.videoCacheSwitch = jSONObject.optInt("videoCacheSwitch", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pkgNameList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.pkgNameList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.pkgNameList.add(optJSONArray.optString(i));
                    }
                }
                this.batchReportCatchLimit = jSONObject.optInt("batchReportCatchLimit", 20);
                this.batchReportCacheType = jSONObject.optInt("batchReportCacheType", 0);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("hostList");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        String optString = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            this.hostList.add(optString);
                        }
                    }
                }
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "toolbarSwitch", this.toolbarSwitch);
            C3800e.m15749a(jSONObject, "likeButtonSwitch", this.likeButtonSwitch);
            C3800e.m15749a(jSONObject, "moreButtonSwitch", this.moreButtonSwitch);
            C3800e.m15749a(jSONObject, "commentButtonSwitch", this.commentButtonSwitch);
            C3800e.m15749a(jSONObject, "seekBarSwitch", this.seekBarSwitch);
            C3800e.m15749a(jSONObject, "videoCacheSwitch", this.videoCacheSwitch);
            List<String> list = this.pkgNameList;
            if (list != null) {
                C3800e.m15754a(jSONObject, "pkgNameList", C3800e.m15745a(list));
            }
            C3800e.m15749a(jSONObject, "batchReportCatchLimit", this.batchReportCatchLimit);
            C3800e.m15749a(jSONObject, "batchReportCacheType", this.batchReportCacheType);
            List<String> list2 = this.hostList;
            if (list2 != null) {
                C3800e.m15754a(jSONObject, "hostList", C3800e.m15745a(list2));
            }
            return jSONObject;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.result = jSONObject.optInt(ArgKey.KEY_RESULT);
            this.errorMsg = jSONObject.optString("errorMsg");
            try {
                JSONObject jSONObject2 = new JSONObject(C4062b.m16853b(jSONObject.optString("data")));
                this.requestInterval = jSONObject2.optLong("requestInterval");
                this.abConfig.parseJson(jSONObject2.optJSONObject("abConfig"));
            } catch (Exception e) {
                C4065b.m16865a(e);
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, ArgKey.KEY_RESULT, this.result);
        C3800e.m15752a(jSONObject, "errorMsg", this.errorMsg);
        C3800e.m15750a(jSONObject, "requestInterval", this.requestInterval);
        C3800e.m15751a(jSONObject, "abConfig", (C4321b) this.abConfig);
        return jSONObject;
    }
}
