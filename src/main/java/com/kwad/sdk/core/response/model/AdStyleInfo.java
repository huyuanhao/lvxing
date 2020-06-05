package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AdStyleInfo implements C4321b, Serializable {
    private static final long serialVersionUID = 8719785586052076737L;
    public PlayDetailInfo playDetailInfo = new PlayDetailInfo();
    public PlayEndInfo playEndInfo = new PlayEndInfo();

    /* renamed from: com.kwad.sdk.core.response.model.AdStyleInfo$PlayDetailInfo */
    public static class PlayDetailInfo implements C4321b, Serializable {
        private static final long serialVersionUID = -1341583579732471663L;
        public DetailTopToolBarInfo detailTopToolBarInfo = new DetailTopToolBarInfo();

        /* renamed from: com.kwad.sdk.core.response.model.AdStyleInfo$PlayDetailInfo$DetailTopToolBarInfo */
        public static class DetailTopToolBarInfo implements C4321b, Serializable {
            private static final long serialVersionUID = 7018855616083214769L;
            public String callButtonDescription;
            public long callButtonShowTime;

            public void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
                    this.callButtonDescription = jSONObject.optString("callButtonDescription");
                }
            }

            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                C3800e.m15750a(jSONObject, "callButtonShowTime", this.callButtonShowTime);
                C3800e.m15752a(jSONObject, "callButtonDescription", this.callButtonDescription);
                return jSONObject;
            }
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15751a(jSONObject, "detailTopToolBarInfo", (C4321b) this.detailTopToolBarInfo);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.AdStyleInfo$PlayEndInfo */
    public static class PlayEndInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 4733855071604625289L;
        public AdWebCardInfo adWebCardInfo = new AdWebCardInfo();
        public EndTopToolBarInfo endTopToolBarInfo = new EndTopToolBarInfo();
        public int type;

        /* renamed from: com.kwad.sdk.core.response.model.AdStyleInfo$PlayEndInfo$AdWebCardInfo */
        public static class AdWebCardInfo implements C4321b, Serializable {
            private static final long serialVersionUID = 5629721137592788675L;
            public String cardData;
            public long cardDelayTime;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;

            public void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.typeLandscape = jSONObject.optLong("typeLandscape");
                    this.typePortrait = jSONObject.optLong("typePortrait");
                    this.cardUrl = jSONObject.optString("cardUrl");
                    this.cardShowTime = jSONObject.optLong("cardShowTime");
                    this.cardDelayTime = jSONObject.optLong("cardDelayTime");
                    this.cardData = jSONObject.optString("cardData");
                }
            }

            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                C3800e.m15750a(jSONObject, "typeLandscape", this.typeLandscape);
                C3800e.m15750a(jSONObject, "typePortrait", this.typePortrait);
                C3800e.m15752a(jSONObject, "cardUrl", this.cardUrl);
                C3800e.m15750a(jSONObject, "cardShowTime", this.cardShowTime);
                C3800e.m15750a(jSONObject, "cardDelayTime", this.cardDelayTime);
                C3800e.m15752a(jSONObject, "cardData", this.cardData);
                return jSONObject;
            }
        }

        /* renamed from: com.kwad.sdk.core.response.model.AdStyleInfo$PlayEndInfo$EndTopToolBarInfo */
        public static class EndTopToolBarInfo implements C4321b, Serializable {
            private static final long serialVersionUID = -3850938239125130621L;
            public String callButtonDescription;

            public void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.callButtonDescription = jSONObject.optString("callButtonDescription");
                }
            }

            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                C3800e.m15752a(jSONObject, "callButtonDescription", this.callButtonDescription);
                return jSONObject;
            }
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type = jSONObject.optInt("type");
                this.adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
                this.endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "type", this.type);
            C3800e.m15751a(jSONObject, "adWebCardInfo", (C4321b) this.adWebCardInfo);
            return jSONObject;
        }
    }

    public void parseAdStyleInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                parseJson(new JSONObject(str));
            } catch (JSONException e) {
                C4065b.m16865a(e);
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
            this.playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15751a(jSONObject, "playDetailInfo", (C4321b) this.playDetailInfo);
        C3800e.m15751a(jSONObject, "playEndInfo", (C4321b) this.playEndInfo);
        return jSONObject;
    }
}
