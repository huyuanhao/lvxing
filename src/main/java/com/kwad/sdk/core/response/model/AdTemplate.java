package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.protocol.model.AdScene;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdTemplate implements C4321b, Serializable {
    private static final long serialVersionUID = -5413539480595883024L;
    public List<AdInfo> adInfoList = new ArrayList();
    public int contentType;
    public long llsid;
    public AdScene mAdScene;
    public int mBidEcpm;
    public transient boolean mDownloadFinishReported;
    public transient boolean mPvReported;
    public String mUniqueId = "";
    public boolean needHide;
    public PhotoInfo photoInfo = new PhotoInfo();
    public long posId;
    public int type;

    public boolean equals(Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.posId = jSONObject.optLong("posId");
            this.type = jSONObject.optInt("type");
            this.contentType = jSONObject.optInt("contentType", 0);
            this.needHide = jSONObject.optBoolean("needHide");
            JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    AdInfo adInfo = new AdInfo();
                    adInfo.parseJson(optJSONArray.optJSONObject(i));
                    this.adInfoList.add(adInfo);
                }
            }
            this.photoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            this.mUniqueId = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(this.mUniqueId)) {
                this.mUniqueId = String.valueOf(UUID.randomUUID());
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15750a(jSONObject, "posId", this.posId);
        C3800e.m15749a(jSONObject, "type", this.type);
        C3800e.m15749a(jSONObject, "contentType", this.contentType);
        C3800e.m15753a(jSONObject, "adInfo", this.adInfoList);
        C3800e.m15751a(jSONObject, "photoInfo", (C4321b) this.photoInfo);
        C3800e.m15752a(jSONObject, "uniqueId", this.mUniqueId);
        C3800e.m15756a(jSONObject, "needHide", this.needHide);
        return jSONObject;
    }
}
