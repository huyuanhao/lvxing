package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.p318b.C4062b;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.Serializable;
import org.json.JSONObject;

public class PhotoShareInfo implements C4321b, Serializable {
    private static final long serialVersionUID = 1941263519515554943L;
    public ShareUrlInfo data = new ShareUrlInfo();
    public String errorMsg;
    public int result;

    /* renamed from: com.kwad.sdk.core.response.model.PhotoShareInfo$ShareUrlInfo */
    public static class ShareUrlInfo implements C4321b, Serializable {
        private static final long serialVersionUID = -7887599282226106153L;
        public String shareUrl;

        public void parseJson(JSONObject jSONObject) {
            this.shareUrl = jSONObject.optString("shareUrl");
        }

        public JSONObject toJson() {
            return null;
        }
    }

    public String getShareUrl() {
        ShareUrlInfo shareUrlInfo = this.data;
        return shareUrlInfo != null ? shareUrlInfo.shareUrl : "";
    }

    public boolean isResultDataEmpty() {
        return this.data == null;
    }

    public void parseJson(JSONObject jSONObject) {
        this.result = jSONObject.optInt(ArgKey.KEY_RESULT);
        this.errorMsg = jSONObject.optString("errorMsg");
        try {
            this.data.parseJson(new JSONObject(C4062b.m16853b(jSONObject.optString("data"))));
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    public JSONObject toJson() {
        return null;
    }
}
