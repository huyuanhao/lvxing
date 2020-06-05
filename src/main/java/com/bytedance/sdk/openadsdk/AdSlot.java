package com.bytedance.sdk.openadsdk;

import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import org.json.JSONObject;

public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    /* access modifiers changed from: private */
    /* renamed from: a */
    public String f6335a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f6336b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f6337c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public float f6338d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public float f6339e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f6340f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f6341g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public String f6342h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public int f6343i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public String f6344j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public String f6345k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f6346l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public int f6347m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean f6348n;

    /* renamed from: com.bytedance.sdk.openadsdk.AdSlot$Builder */
    public static class Builder {
        /* renamed from: a */
        private String f6349a;
        /* renamed from: b */
        private int f6350b = ScreenUtil.M9_WIDTH;
        /* renamed from: c */
        private int f6351c = 320;
        /* renamed from: d */
        private boolean f6352d;
        /* renamed from: e */
        private int f6353e = 1;
        /* renamed from: f */
        private String f6354f;
        /* renamed from: g */
        private int f6355g;
        /* renamed from: h */
        private String f6356h;
        /* renamed from: i */
        private String f6357i;
        /* renamed from: j */
        private int f6358j;
        /* renamed from: k */
        private int f6359k;
        /* renamed from: l */
        private float f6360l;
        /* renamed from: m */
        private float f6361m;
        /* renamed from: n */
        private boolean f6362n = true;

        public Builder setIsAutoPlay(boolean z) {
            this.f6362n = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f6349a = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.f6350b = i;
            this.f6351c = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.f6360l = f;
            this.f6361m = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.f6352d = z;
            return this;
        }

        public Builder setAdCount(int i) {
            this.f6353e = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f6354f = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.f6355g = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f6356h = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f6357i = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.f6358j = i;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.f6359k = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f6335a = this.f6349a;
            adSlot.f6340f = this.f6353e;
            adSlot.f6341g = this.f6352d;
            adSlot.f6336b = this.f6350b;
            adSlot.f6337c = this.f6351c;
            adSlot.f6338d = this.f6360l;
            adSlot.f6339e = this.f6361m;
            adSlot.f6342h = this.f6354f;
            adSlot.f6343i = this.f6355g;
            adSlot.f6344j = this.f6356h;
            adSlot.f6345k = this.f6357i;
            adSlot.f6346l = this.f6358j;
            adSlot.f6347m = this.f6359k;
            adSlot.f6348n = this.f6362n;
            return adSlot;
        }
    }

    public static int getPosition(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
            case 4:
            case 7:
            case 8:
                return 5;
            default:
                return 3;
        }
    }

    private AdSlot() {
        this.f6348n = true;
    }

    public String getCodeId() {
        return this.f6335a;
    }

    public boolean isAutoPlay() {
        return this.f6348n;
    }

    public int getImgAcceptedWidth() {
        return this.f6336b;
    }

    public int getImgAcceptedHeight() {
        return this.f6337c;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f6338d;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f6339e;
    }

    public boolean isSupportDeepLink() {
        return this.f6341g;
    }

    public int getAdCount() {
        return this.f6340f;
    }

    public void setAdCount(int i) {
        this.f6340f = i;
    }

    public String getRewardName() {
        return this.f6342h;
    }

    public int getRewardAmount() {
        return this.f6343i;
    }

    public String getMediaExtra() {
        return this.f6344j;
    }

    public String getUserID() {
        return this.f6345k;
    }

    public int getOrientation() {
        return this.f6346l;
    }

    public int getNativeAdType() {
        return this.f6347m;
    }

    public void setNativeAdType(int i) {
        this.f6347m = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdSlot{mCodeId='");
        sb.append(this.f6335a);
        sb.append('\'');
        sb.append(", mImgAcceptedWidth=");
        sb.append(this.f6336b);
        sb.append(", mImgAcceptedHeight=");
        sb.append(this.f6337c);
        sb.append(", mExpressViewAcceptedWidth=");
        sb.append(this.f6338d);
        sb.append(", mExpressViewAcceptedHeight=");
        sb.append(this.f6339e);
        sb.append(", mAdCount=");
        sb.append(this.f6340f);
        sb.append(", mSupportDeepLink=");
        sb.append(this.f6341g);
        sb.append(", mRewardName='");
        sb.append(this.f6342h);
        sb.append('\'');
        sb.append(", mRewardAmount=");
        sb.append(this.f6343i);
        sb.append(", mMediaExtra='");
        sb.append(this.f6344j);
        sb.append('\'');
        sb.append(", mUserID='");
        sb.append(this.f6345k);
        sb.append('\'');
        sb.append(", mOrientation=");
        sb.append(this.f6346l);
        sb.append(", mNativeAdType=");
        sb.append(this.f6347m);
        sb.append(", mIsAutoPlay=");
        sb.append(this.f6348n);
        sb.append('}');
        return sb.toString();
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f6335a);
            jSONObject.put("mIsAutoPlay", this.f6348n);
            jSONObject.put("mImgAcceptedWidth", this.f6336b);
            jSONObject.put("mImgAcceptedHeight", this.f6337c);
            jSONObject.put("mExpressViewAcceptedWidth", (double) this.f6338d);
            jSONObject.put("mExpressViewAcceptedHeight", (double) this.f6339e);
            jSONObject.put("mAdCount", this.f6340f);
            jSONObject.put("mSupportDeepLink", this.f6341g);
            jSONObject.put("mRewardName", this.f6342h);
            jSONObject.put("mRewardAmount", this.f6343i);
            jSONObject.put("mMediaExtra", this.f6344j);
            jSONObject.put("mUserID", this.f6345k);
            jSONObject.put("mOrientation", this.f6346l);
            jSONObject.put("mNativeAdType", this.f6347m);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
