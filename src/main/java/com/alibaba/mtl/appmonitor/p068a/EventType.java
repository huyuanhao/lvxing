package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.log.p077d.Logger;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* renamed from: com.alibaba.mtl.appmonitor.a.f */
public enum EventType {
    ALARM(65501, 30, "alarmData", BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT),
    COUNTER(65502, 30, "counterData", BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT),
    OFFLINE_COUNTER(65133, 30, "counterData", BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT),
    STAT(65503, 30, "statData", BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
    
    static String TAG;
    /* renamed from: e */
    private int f3168e;
    /* renamed from: h */
    private int f3169h;
    /* renamed from: i */
    private int f3170i;
    /* renamed from: j */
    private int f3171j;
    /* renamed from: k */
    private int f3172k;
    /* renamed from: m */
    private boolean f3173m;
    /* renamed from: t */
    private String f3174t;

    static {
        TAG = "EventType";
    }

    private EventType(int i, int i2, String str, int i3) {
        this.f3170i = 25;
        this.f3171j = TinkerReport.KEY_APPLIED_VERSION_CHECK;
        this.f3168e = i;
        this.f3169h = i2;
        this.f3173m = true;
        this.f3174t = str;
        this.f3172k = i3;
    }

    /* renamed from: a */
    public int mo11568a() {
        return this.f3168e;
    }

    public boolean isOpen() {
        return this.f3173m;
    }

    /* renamed from: b */
    public void mo11571b(boolean z) {
        this.f3173m = z;
    }

    /* renamed from: b */
    public int mo11569b() {
        return this.f3169h;
    }

    /* renamed from: b */
    public void mo11570b(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        Logger.m3833a(str, "[setTriggerCount]", this.f3174t, sb.toString());
        this.f3169h = i;
    }

    /* renamed from: a */
    public static EventType m3341a(int i) {
        EventType[] values = values();
        for (int i2 = 0; i2 < values.length; i2++) {
            EventType fVar = values[i2];
            if (fVar != null && fVar.mo11568a() == i) {
                return fVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m3343a() {
        return this.f3174t;
    }

    /* renamed from: c */
    public int mo11572c() {
        return this.f3170i;
    }

    /* renamed from: d */
    public int mo11574d() {
        return this.f3171j;
    }

    public void setStatisticsInterval(int i) {
        this.f3170i = i;
        this.f3171j = i;
    }

    /* renamed from: e */
    public int mo11575e() {
        return this.f3172k;
    }

    /* renamed from: c */
    public void mo11573c(int i) {
        this.f3172k = i;
    }
}
