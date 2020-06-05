package com.tencent.stat.app.p610a;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.event.C7640n;
import com.tencent.stat.event.EventType;

/* renamed from: com.tencent.stat.app.a.a */
public class C7584a extends C7640n {
    /* renamed from: a */
    private int f25597a;

    public C7584a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, 0, null, statSpecifyReportedInfo);
        this.f25597a = 1;
        this.f25772c = true;
    }

    /* renamed from: a */
    public void mo37085a(int i) {
        this.f25597a = i;
    }

    public EventType getType() {
        return EventType.INSTALL_SOURCE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(2:2|(2:6|7))|8|9|(1:11)|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004e A[Catch:{ Exception -> 0x005b }] */
    public boolean onEncode(org.json.JSONObject r4) throws org.json.JSONException {
        /*
        r3 = this;
        super.onEncode(r4)
        int r0 = r3.f25597a
        java.lang.String r1 = "tnty"
        r4.put(r1, r0)
        android.content.Context r0 = r3.getContext()
        com.tencent.stat.apkreader.ChannelInfo r0 = com.tencent.stat.app.channel.MtaChannelReader.getChannelInfo(r0)
        if (r0 == 0) goto L_0x0037
        java.lang.String r1 = r0.getChannel()
        java.lang.String r2 = "ich"
        com.tencent.stat.common.Util.jsonPut(r4, r2, r1)
        java.util.Map r0 = r0.getExtraInfo()
        if (r0 == 0) goto L_0x0037
        int r1 = r0.size()
        if (r1 <= 0) goto L_0x0037
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0037 }
        r1.<init>(r0)     // Catch:{ Exception -> 0x0037 }
        java.lang.String r0 = "ichext"
        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0037 }
        com.tencent.stat.common.Util.jsonPut(r4, r0, r1)     // Catch:{ Exception -> 0x0037 }
    L_0x0037:
        android.content.Context r0 = r3.getContext()     // Catch:{ Exception -> 0x005b }
        android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x005b }
        android.content.Context r1 = r3.getContext()     // Catch:{ Exception -> 0x005b }
        java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x005b }
        r2 = 0
        android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch:{ Exception -> 0x005b }
        if (r0 == 0) goto L_0x005b
        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x005b }
        r1.<init>()     // Catch:{ Exception -> 0x005b }
        com.tencent.stat.common.StatCommonHelper.encodeAppPackageInfo(r1, r0)     // Catch:{ Exception -> 0x005b }
        java.lang.String r0 = "tpi"
        r4.put(r0, r1)     // Catch:{ Exception -> 0x005b }
    L_0x005b:
        r4 = 1
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.app.p610a.C7584a.onEncode(org.json.JSONObject):boolean");
    }
}
