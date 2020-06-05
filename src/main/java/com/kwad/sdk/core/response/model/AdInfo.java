package com.kwad.sdk.core.response.model;

import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3805h;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdInfo implements C4321b, Serializable {
    private static final long serialVersionUID = -8738827282880419389L;
    public AdBaseInfo adBaseInfo = new AdBaseInfo();
    public AdConversionInfo adConversionInfo = new AdConversionInfo();
    public AdMaterialInfo adMaterialInfo = new AdMaterialInfo();
    private String adStyleInfo;
    public List<AdTrackInfo> adTrackInfoList = new ArrayList();
    public String downloadFilePath;
    public String downloadId;
    public AdStyleInfo mAdStyleInfo = new AdStyleInfo();
    public int progress;
    public DOWNLOADSTAUS status = DOWNLOADSTAUS.UNKNOWN;

    /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo */
    public static class AdBaseInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 1615884096720946547L;
        public String adActionDescription;
        public String adDescription;
        public int adOperationType;
        public int adShowDuration;
        public String adSourceDescription;
        public int adSourceType;
        public String appDownloadCountDesc;
        public String appIconUrl;
        public String appName;
        public String appPackageName;
        public int appScore;
        public String clickUrl;
        public String convUrl;
        public long creativeId;
        public int ecpm;
        public int enableSkipAd;
        public String expParam;
        public String showUrl;
        public String videoPlayedNS;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.creativeId = jSONObject.optLong("creativeId");
                this.adSourceType = jSONObject.optInt("adSourceType");
                this.adDescription = jSONObject.optString("adDescription");
                this.adSourceDescription = jSONObject.optString("adSourceDescription");
                this.adOperationType = jSONObject.optInt("adOperationType");
                this.adShowDuration = jSONObject.optInt("adShowDuration");
                this.appIconUrl = jSONObject.optString("appIconUrl");
                this.appName = jSONObject.optString(AppEntity.KEY_APP_NAME_STR);
                this.appPackageName = jSONObject.optString("appPackageName");
                this.appScore = jSONObject.optInt("appScore");
                this.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
                this.adActionDescription = jSONObject.optString("adActionDescription");
                this.enableSkipAd = jSONObject.optInt("enableSkipAd");
                this.ecpm = jSONObject.optInt("ecpm");
                this.videoPlayedNS = jSONObject.optString("videoPlayedNS");
                this.expParam = jSONObject.optString("expParam");
                this.showUrl = jSONObject.optString("showUrl");
                this.clickUrl = jSONObject.optString(KEYS.EXPOSED_CLICK_URL_KEY);
                this.convUrl = jSONObject.optString("convUrl");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15750a(jSONObject, "creativeId", this.creativeId);
            C3800e.m15749a(jSONObject, "adSourceType", this.adSourceType);
            C3800e.m15752a(jSONObject, "adDescription", this.adDescription);
            C3800e.m15752a(jSONObject, "adSourceDescription", this.adSourceDescription);
            C3800e.m15749a(jSONObject, "adOperationType", this.adOperationType);
            C3800e.m15749a(jSONObject, "adShowDuration", this.adShowDuration);
            C3800e.m15752a(jSONObject, "appIconUrl", this.appIconUrl);
            C3800e.m15752a(jSONObject, AppEntity.KEY_APP_NAME_STR, this.appName);
            C3800e.m15752a(jSONObject, "appPackageName", this.appPackageName);
            C3800e.m15749a(jSONObject, "appScore", this.appScore);
            C3800e.m15752a(jSONObject, "appDownloadCountDesc", this.appDownloadCountDesc);
            C3800e.m15752a(jSONObject, "adActionDescription", this.adActionDescription);
            C3800e.m15749a(jSONObject, "enableSkipAd", this.enableSkipAd);
            C3800e.m15749a(jSONObject, "ecpm", this.ecpm);
            C3800e.m15752a(jSONObject, "videoPlayedNS", this.videoPlayedNS);
            C3800e.m15752a(jSONObject, "expParam", this.expParam);
            C3800e.m15752a(jSONObject, "showUrl", this.showUrl);
            C3800e.m15752a(jSONObject, KEYS.EXPOSED_CLICK_URL_KEY, this.clickUrl);
            C3800e.m15752a(jSONObject, "convUrl", this.convUrl);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdConversionInfo */
    public static class AdConversionInfo implements C4321b, Serializable {
        private static final long serialVersionUID = -1623240707193173136L;
        public String appDownloadUrl;
        public String deeplinkUrl;
        public String h5Url;
        public String marketUrl;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.h5Url = jSONObject.optString("h5Url");
                this.deeplinkUrl = jSONObject.optString("deeplinkUrl");
                this.appDownloadUrl = jSONObject.optString(C7887a.f26832Hh);
                this.marketUrl = jSONObject.optString("marketUrl");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15752a(jSONObject, "h5Url", this.h5Url);
            C3800e.m15752a(jSONObject, "deeplinkUrl", this.deeplinkUrl);
            C3800e.m15752a(jSONObject, C7887a.f26832Hh, this.appDownloadUrl);
            C3800e.m15752a(jSONObject, "marketUrl", this.marketUrl);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo */
    public static class AdMaterialInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 8841259738296866924L;
        public List<MaterialFeature> materialFeatureList = new ArrayList();
        public int materialType;

        /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature */
        public static class MaterialFeature implements C4321b, Serializable {
            private static final long serialVersionUID = -1118440558210936255L;
            public String coverUrl;
            public int featureType;
            public String firstFrame;
            public int height;
            public String materialUrl;
            public long photoId;
            public int videoDuration;
            public int videoHeight;
            public int videoWith;
            public int width;

            public void parseJson(JSONObject jSONObject) {
                if (jSONObject != null) {
                    this.featureType = jSONObject.optInt("featureType");
                    this.materialUrl = jSONObject.optString("materialUrl");
                    this.photoId = jSONObject.optLong("photoId");
                    JSONObject optJSONObject = jSONObject.optJSONObject("materialSize");
                    if (optJSONObject != null) {
                        this.width = optJSONObject.optInt("width");
                        this.height = optJSONObject.optInt("height");
                    }
                    this.coverUrl = jSONObject.optString("coverUrl");
                    this.videoDuration = jSONObject.optInt("videoDuration");
                    this.firstFrame = jSONObject.optString("firstFrame");
                    this.videoWith = jSONObject.optInt("videoWith");
                    this.videoHeight = jSONObject.optInt("videoHeight");
                }
            }

            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                C3800e.m15749a(jSONObject, "featureType", this.featureType);
                C3800e.m15752a(jSONObject, "materialUrl", this.materialUrl);
                C3800e.m15750a(jSONObject, "photoId", this.photoId);
                JSONObject jSONObject2 = new JSONObject();
                C3800e.m15749a(jSONObject2, "width", this.width);
                C3800e.m15749a(jSONObject2, "height", this.height);
                C3800e.m15755a(jSONObject, "materialSize", jSONObject2);
                C3800e.m15752a(jSONObject, "coverUrl", this.coverUrl);
                C3800e.m15749a(jSONObject, "videoDuration", this.videoDuration);
                C3800e.m15752a(jSONObject, "firstFrame", this.firstFrame);
                C3800e.m15749a(jSONObject, "videoWith", this.videoWith);
                C3800e.m15749a(jSONObject, "videoHeight", this.videoHeight);
                return jSONObject;
            }
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.materialType = jSONObject.optInt("materialType", 2);
                JSONArray optJSONArray = jSONObject.optJSONArray("materialFeature");
                this.materialFeatureList = new ArrayList();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        MaterialFeature materialFeature = new MaterialFeature();
                        materialFeature.parseJson(optJSONObject);
                        this.materialFeatureList.add(materialFeature);
                    }
                }
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "materialType", this.materialType);
            C3800e.m15753a(jSONObject, "materialFeature", this.materialFeatureList);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo */
    public static class AdTrackInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 1185757456598461137L;
        public int type;
        public String[] urls;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.type = jSONObject.optInt("type");
                JSONArray optJSONArray = jSONObject.optJSONArray("url");
                if (optJSONArray != null) {
                    this.urls = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.urls[i] = optJSONArray.optString(i);
                    }
                }
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15749a(jSONObject, "type", this.type);
            JSONArray jSONArray = new JSONArray();
            String[] strArr = this.urls;
            if (strArr != null) {
                for (String put : strArr) {
                    jSONArray.put(put);
                }
            }
            C3800e.m15754a(jSONObject, "url", jSONArray);
            return jSONObject;
        }
    }

    /* renamed from: com.kwad.sdk.core.response.model.AdInfo$AdvertiserInfo */
    public static class AdvertiserInfo implements C4321b, Serializable {
        private static final long serialVersionUID = 1779108296418044788L;
        public long accountId;
        public String portraitUrl;
        public String userGender;
        public long userId;
        public String userName;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.userId = jSONObject.optLong("userId");
                this.userName = jSONObject.optString("userName");
                this.accountId = jSONObject.optLong("accountId");
                this.userGender = jSONObject.optString("userGender");
                this.portraitUrl = jSONObject.optString("portraitUrl");
            }
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15750a(jSONObject, "userId", this.userId);
            C3800e.m15752a(jSONObject, "userName", this.userName);
            C3800e.m15750a(jSONObject, "accountId", this.accountId);
            C3800e.m15752a(jSONObject, "userGender", this.userGender);
            C3800e.m15752a(jSONObject, "portraitUrl", this.portraitUrl);
            return jSONObject;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
            this.adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
            this.adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
            this.adStyleInfo = jSONObject.optString("adStyleInfo");
            this.mAdStyleInfo.parseAdStyleInfo(this.adStyleInfo);
            JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    AdTrackInfo adTrackInfo = new AdTrackInfo();
                    adTrackInfo.parseJson(optJSONArray.optJSONObject(i));
                    this.adTrackInfoList.add(adTrackInfo);
                }
            }
            this.downloadId = C3805h.m15773a(this.adConversionInfo.appDownloadUrl);
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15751a(jSONObject, "adBaseInfo", (C4321b) this.adBaseInfo);
        C3800e.m15751a(jSONObject, "adConversionInfo", (C4321b) this.adConversionInfo);
        C3800e.m15751a(jSONObject, "adMaterialInfo", (C4321b) this.adMaterialInfo);
        C3800e.m15752a(jSONObject, "adStyleInfo", this.adStyleInfo);
        C3800e.m15753a(jSONObject, "adTrackInfo", this.adTrackInfoList);
        return jSONObject;
    }
}
