package com.p522qq.p523e.ads.cfg;

import com.p522qq.p523e.comm.util.GDTLogger;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.cfg.VideoOption */
public class VideoOption {
    /* renamed from: a */
    private final boolean f19970a;
    /* renamed from: b */
    private final int f19971b;
    /* renamed from: c */
    private final boolean f19972c;
    /* renamed from: d */
    private final boolean f19973d;
    /* renamed from: e */
    private final boolean f19974e;
    /* renamed from: f */
    private final boolean f19975f;
    /* renamed from: g */
    private final boolean f19976g;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$AutoPlayPolicy */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* renamed from: com.qq.e.ads.cfg.VideoOption$Builder */
    public static final class Builder {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean f19977a = true;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f19978b = 1;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean f19979c = true;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f19980d = true;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public boolean f19981e = true;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public boolean f19982f = false;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public boolean f19983g = false;

        public final VideoOption build() {
            return new VideoOption(this, 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f19977a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                StringBuilder sb = new StringBuilder("invalid value of autoPlayPolicy, can only be [0, 2], reset to : ");
                sb.append(1);
                GDTLogger.m25260e(sb.toString());
                i = 1;
            }
            this.f19978b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f19983g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f19981e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f19982f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f19980d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f19979c = z;
            return this;
        }
    }

    /* renamed from: com.qq.e.ads.cfg.VideoOption$VideoADContainerRender */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    /* renamed from: com.qq.e.ads.cfg.VideoOption$VideoPlayPolicy */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private VideoOption(Builder builder) {
        this.f19970a = builder.f19977a;
        this.f19971b = builder.f19978b;
        this.f19972c = builder.f19979c;
        this.f19973d = builder.f19980d;
        this.f19974e = builder.f19981e;
        this.f19975f = builder.f19982f;
        this.f19976g = builder.f19983g;
    }

    /* synthetic */ VideoOption(Builder builder, byte b) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f19970a;
    }

    public int getAutoPlayPolicy() {
        return this.f19971b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f19970a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f19971b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f19976g));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Get video options error: ");
            sb.append(e.getMessage());
            GDTLogger.m25260e(sb.toString());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f19976g;
    }

    public boolean isEnableDetailPage() {
        return this.f19974e;
    }

    public boolean isEnableUserControl() {
        return this.f19975f;
    }

    public boolean isNeedCoverImage() {
        return this.f19973d;
    }

    public boolean isNeedProgressBar() {
        return this.f19972c;
    }
}
