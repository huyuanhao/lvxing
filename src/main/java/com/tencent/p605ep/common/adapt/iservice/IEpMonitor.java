package com.tencent.p605ep.common.adapt.iservice;

/* renamed from: com.tencent.ep.common.adapt.iservice.IEpMonitor */
public interface IEpMonitor {

    /* renamed from: com.tencent.ep.common.adapt.iservice.IEpMonitor$ReportType */
    public interface ReportType {
        public static final int TYPE_INSTANT = 2;
        public static final int Type_AddUp = 1;
    }

    void monitorComponent(String str, String str2, String str3);

    void onCall(String str, String str2);

    @Deprecated
    void onCall(String str, String str2, int i);

    void onError(String str, int i);

    @Deprecated
    void onError(String str, int i, int i2);

    void onEvent(String str, String str2, String str3);

    @Deprecated
    void onEvent(String str, String str2, String str3, int i);

    void onTotal(String str, String str2, String str3, long j);
}
