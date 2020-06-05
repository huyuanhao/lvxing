package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.C2222b;
import com.bytedance.sdk.openadsdk.core.p170d.DeepLink;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibEventExtra;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.p530ss.android.p531a.p532a.p533a.DownloadEventLogger;
import com.p530ss.android.p531a.p532a.p536c.DownloadEventModel;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.b */
public class LibEventLogger implements DownloadEventLogger {
    /* renamed from: a */
    private final WeakReference<Context> f8525a;

    /* compiled from: LibEventLogger */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.b$a */
    private static class C2397a implements Runnable {
        /* renamed from: a */
        private final DownloadEventModel f8526a;
        /* renamed from: b */
        private LibEventExtra f8527b;
        /* renamed from: c */
        private MaterialMeta f8528c;

        /* renamed from: a */
        public static C2397a m11087a(DownloadEventModel dVar) {
            return new C2397a(dVar);
        }

        private C2397a(DownloadEventModel dVar) {
            this.f8526a = dVar;
            DownloadEventModel dVar2 = this.f8526a;
            if (dVar2 != null && dVar2.mo31122d() != null) {
                String optString = this.f8526a.mo31122d().optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.f8527b = LibEventExtra.m11190a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                        this.f8527b.mo16548b(this.f8526a.mo31120b());
                        if (this.f8527b != null) {
                            this.f8528c = this.f8527b.f8609a;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }

        /* renamed from: a */
        private Context m11086a() {
            return InternalContainer.m10059a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x011c, code lost:
            if ("landing_h5_download_ad_button".equals(r1.f8526a.mo31119a()) != false) goto L_0x011e;
     */
        /* renamed from: a */
        private boolean m11088a(java.lang.String r2) {
            /*
            r1 = this;
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0120
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "embeded_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "draw_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "draw_ad_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "banner_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "banner_call"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "banner_ad_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "feed_call"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "embeded_ad_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "interaction"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "interaction_call"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "interaction_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "slide_banner_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "splash_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "fullscreen_interstitial_ad"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "splash_ad_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "rewarded_video"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "rewarded_video_landingpage"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "openad_sdk_download_complete_tag"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "download_notificaion"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x011e
            com.ss.android.a.a.c.d r2 = r1.f8526a
            java.lang.String r2 = r2.mo31119a()
            java.lang.String r0 = "landing_h5_download_ad_button"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0120
        L_0x011e:
            r2 = 1
            goto L_0x0121
        L_0x0120:
            r2 = 0
        L_0x0121:
            return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.C2397a.m11088a(java.lang.String):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:116:0x01c0, code lost:
            switch(r1) {
                case 0: goto L_0x0368;
                case 1: goto L_0x035c;
                case 2: goto L_0x0350;
                case 3: goto L_0x0346;
                case 4: goto L_0x0332;
                case 5: goto L_0x0322;
                case 6: goto L_0x0322;
                case 7: goto L_0x0312;
                case 8: goto L_0x0312;
                case 9: goto L_0x0302;
                case 10: goto L_0x02d5;
                case 11: goto L_0x02c4;
                case 12: goto L_0x02c4;
                case 13: goto L_0x027e;
                case 14: goto L_0x026d;
                case 15: goto L_0x026d;
                case 16: goto L_0x025c;
                case 17: goto L_0x024b;
                case 18: goto L_0x023a;
                case 19: goto L_0x023a;
                case 20: goto L_0x0229;
                case 21: goto L_0x0218;
                case 22: goto L_0x020b;
                case 23: goto L_0x01fe;
                case 24: goto L_0x01f1;
                case 25: goto L_0x01e6;
                case 26: goto L_0x01db;
                case 27: goto L_0x01d0;
                case 28: goto L_0x01c5;
                default: goto L_0x01c3;
            };
     */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x01c5, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, r6);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01d0, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, r4);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01db, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, r8);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e6, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, r5);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f1, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, "open_market_fail");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x01fe, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, "open_market_suc");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x020b, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(m11086a(), r11.f8528c, r0, "open_market_url");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0218, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8410i(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0229, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8408g(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x023a, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8407f(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x024b, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8406e(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x025c, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8417p(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x026d, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8418q(m11086a(), r11.f8528c, r0, com.bytedance.sdk.openadsdk.utils.ToolUtils.m12029f(r11.f8528c), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x027e, code lost:
            r1 = com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.m11080c(r11.f8526a);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x0284, code lost:
            r2 = "hijack";
     */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x0286, code lost:
            if (r1 == null) goto L_0x0298;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
            r4 = r1.optInt("scene", -1);
            r1 = r1.optInt(r2, 0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0292, code lost:
            if (r1 != 2) goto L_0x0295;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0295, code lost:
            r9 = r1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0296, code lost:
            r5 = r4;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0298, code lost:
            r5 = -1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0299, code lost:
            r7.put(r2, java.lang.Integer.valueOf(r9));
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8385a(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r5, (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x02b5, code lost:
            if (m11089b() == false) goto L_0x037d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x02b7, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8418q(m11086a(), r11.f8528c, r0, "auto_control", r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x02c4, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8405d(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x02d5, code lost:
            r1 = com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.m11080c(r11.f8526a);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x02db, code lost:
            r2 = androidx.core.p003os.EnvironmentCompat.MEDIA_UNKNOWN;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x02dd, code lost:
            if (r1 == null) goto L_0x02ee;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
            r3 = r1.optInt("fail_status", -1);
            r6 = r1.optString("fail_msg", r2);
            r5 = r3;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x02ee, code lost:
            r6 = r2;
            r5 = -1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x02f0, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8384a(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), r5, r6, (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0302, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8402c(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0312, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8398b(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0322, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8387a(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0332, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8388a(m11086a(), r11.f8528c, r0, r11.f8526a.mo31120b(), com.bytedance.sdk.openadsdk.utils.ToolUtils.m11999a((java.util.Map<java.lang.String, java.lang.Object>) r7));
     */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0346, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8380a(m11086a(), r11.f8528c);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0350, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(m11086a(), r11.f8528c, "back_install_1", (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x035c, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(m11086a(), r11.f8528c, "back_install_0", (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0368, code lost:
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(m11086a(), r11.f8528c, "back_install", (java.util.Map<java.lang.String, java.lang.Object>) r7);
     */
        public void run() {
            /*
            r11 = this;
            com.ss.android.a.a.c.d r0 = r11.f8526a     // Catch:{ all -> 0x0375 }
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.ss.android.a.a.c.d r0 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = r0.mo31119a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.downloadnew.a.b.a r1 = r11.f8527b     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x001d
            com.bytedance.sdk.openadsdk.downloadnew.a.b.a r1 = r11.f8527b     // Catch:{ all -> 0x0375 }
            java.lang.String r1 = r1.f8610b     // Catch:{ all -> 0x0375 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0375 }
            if (r1 != 0) goto L_0x001d
            com.bytedance.sdk.openadsdk.downloadnew.a.b.a r0 = r11.f8527b     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = r0.f8610b     // Catch:{ all -> 0x0375 }
        L_0x001d:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0375 }
            r7.<init>()     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r1 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r1 = r1.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            boolean r0 = com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder.m11229a(r0, r1, r2, r7)     // Catch:{ all -> 0x0375 }
            if (r0 == 0) goto L_0x0031
            return
        L_0x0031:
            com.bytedance.sdk.openadsdk.downloadnew.a.b.a r0 = r11.f8527b     // Catch:{ all -> 0x0375 }
            if (r0 == 0) goto L_0x0374
            com.bytedance.sdk.openadsdk.core.d.k r0 = r11.f8528c     // Catch:{ all -> 0x0375 }
            if (r0 == 0) goto L_0x0374
            com.ss.android.a.a.c.d r0 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = r0.mo31119a()     // Catch:{ all -> 0x0375 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0375 }
            if (r0 != 0) goto L_0x0374
            com.ss.android.a.a.c.d r0 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = r0.mo31120b()     // Catch:{ all -> 0x0375 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0375 }
            if (r0 == 0) goto L_0x0053
            goto L_0x0374
        L_0x0053:
            com.bytedance.sdk.openadsdk.downloadnew.a.b.a r0 = r11.f8527b     // Catch:{ all -> 0x0375 }
            java.lang.String r0 = r0.f8610b     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r1 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r1 = r1.mo31119a()     // Catch:{ all -> 0x0375 }
            boolean r1 = r11.m11088a(r1)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x037d
            com.ss.android.a.a.c.d r1 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r1 = r1.mo31120b()     // Catch:{ all -> 0x0375 }
            int r2 = r1.hashCode()     // Catch:{ all -> 0x0375 }
            r3 = 2
            java.lang.String r4 = "market_openapp_success"
            java.lang.String r5 = "market_openapp_window_show"
            java.lang.String r6 = "market_openapp_failed"
            java.lang.String r8 = "market_openapp_cancel"
            r9 = 0
            r10 = -1
            switch(r2) {
                case -1297985154: goto L_0x01b5;
                case -1196657775: goto L_0x01ab;
                case -1109399931: goto L_0x01a2;
                case -1023652792: goto L_0x0199;
                case -910764296: goto L_0x018e;
                case -777040223: goto L_0x0183;
                case -541464848: goto L_0x0178;
                case -484083594: goto L_0x016d;
                case -457223548: goto L_0x0162;
                case -169094873: goto L_0x0157;
                case -132258229: goto L_0x014c;
                case -5666332: goto L_0x0140;
                case 156934100: goto L_0x0134;
                case 164468778: goto L_0x0128;
                case 317063772: goto L_0x011c;
                case 387396845: goto L_0x0110;
                case 790060919: goto L_0x0105;
                case 863509447: goto L_0x00f9;
                case 889396303: goto L_0x00ed;
                case 1020901937: goto L_0x00e1;
                case 1050948908: goto L_0x00d5;
                case 1213416641: goto L_0x00cb;
                case 1373499319: goto L_0x00bf;
                case 1682049151: goto L_0x00b4;
                case 1685366507: goto L_0x00a9;
                case 1831646103: goto L_0x009d;
                case 1845922136: goto L_0x0093;
                case 1884763758: goto L_0x0088;
                case 1885165645: goto L_0x007d;
                default: goto L_0x007b;
            }
        L_0x007b:
            goto L_0x01bf
        L_0x007d:
            java.lang.String r2 = "backdialog_show"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 0
            goto L_0x01c0
        L_0x0088:
            java.lang.String r2 = "backdialog_exit"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 1
            goto L_0x01c0
        L_0x0093:
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 27
            goto L_0x01c0
        L_0x009d:
            java.lang.String r2 = "deeplink_url_true"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 17
            goto L_0x01c0
        L_0x00a9:
            java.lang.String r2 = "click_start"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 4
            goto L_0x01c0
        L_0x00b4:
            java.lang.String r2 = "click_pause"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 5
            goto L_0x01c0
        L_0x00bf:
            java.lang.String r2 = "install_finish"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 13
            goto L_0x01c0
        L_0x00cb:
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 25
            goto L_0x01c0
        L_0x00d5:
            java.lang.String r2 = "download_notificaion_continue"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 8
            goto L_0x01c0
        L_0x00e1:
            java.lang.String r2 = "market_open_success"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 23
            goto L_0x01c0
        L_0x00ed:
            java.lang.String r2 = "market_open_failed"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 24
            goto L_0x01c0
        L_0x00f9:
            java.lang.String r2 = "deeplink_open_success"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 21
            goto L_0x01c0
        L_0x0105:
            java.lang.String r2 = "delayinstall_install_start"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 3
            goto L_0x01c0
        L_0x0110:
            java.lang.String r2 = "package_name_error"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 19
            goto L_0x01c0
        L_0x011c:
            java.lang.String r2 = "open_url_app"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 16
            goto L_0x01c0
        L_0x0128:
            java.lang.String r2 = "download_finish"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 9
            goto L_0x01c0
        L_0x0134:
            java.lang.String r2 = "download_failed"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 10
            goto L_0x01c0
        L_0x0140:
            java.lang.String r2 = "click_install"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 11
            goto L_0x01c0
        L_0x014c:
            java.lang.String r2 = "backdialog_install"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 2
            goto L_0x01c0
        L_0x0157:
            java.lang.String r2 = "download_notification_open"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 15
            goto L_0x01c0
        L_0x0162:
            java.lang.String r2 = "market_click_open"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 22
            goto L_0x01c0
        L_0x016d:
            java.lang.String r2 = "download_notificaion_install"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 12
            goto L_0x01c0
        L_0x0178:
            java.lang.String r2 = "deeplink_open_fail_for_packagename_no_match"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 18
            goto L_0x01c0
        L_0x0183:
            java.lang.String r2 = "click_open"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 14
            goto L_0x01c0
        L_0x018e:
            java.lang.String r2 = "deeplink_url_app"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 20
            goto L_0x01c0
        L_0x0199:
            boolean r1 = r1.equals(r6)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 28
            goto L_0x01c0
        L_0x01a2:
            boolean r1 = r1.equals(r8)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 26
            goto L_0x01c0
        L_0x01ab:
            java.lang.String r2 = "download_notificaion_pause"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 6
            goto L_0x01c0
        L_0x01b5:
            java.lang.String r2 = "click_continue"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x01bf
            r1 = 7
            goto L_0x01c0
        L_0x01bf:
            r1 = -1
        L_0x01c0:
            switch(r1) {
                case 0: goto L_0x0368;
                case 1: goto L_0x035c;
                case 2: goto L_0x0350;
                case 3: goto L_0x0346;
                case 4: goto L_0x0332;
                case 5: goto L_0x0322;
                case 6: goto L_0x0322;
                case 7: goto L_0x0312;
                case 8: goto L_0x0312;
                case 9: goto L_0x0302;
                case 10: goto L_0x02d5;
                case 11: goto L_0x02c4;
                case 12: goto L_0x02c4;
                case 13: goto L_0x027e;
                case 14: goto L_0x026d;
                case 15: goto L_0x026d;
                case 16: goto L_0x025c;
                case 17: goto L_0x024b;
                case 18: goto L_0x023a;
                case 19: goto L_0x023a;
                case 20: goto L_0x0229;
                case 21: goto L_0x0218;
                case 22: goto L_0x020b;
                case 23: goto L_0x01fe;
                case 24: goto L_0x01f1;
                case 25: goto L_0x01e6;
                case 26: goto L_0x01db;
                case 27: goto L_0x01d0;
                case 28: goto L_0x01c5;
                default: goto L_0x01c3;
            }     // Catch:{ all -> 0x0375 }
        L_0x01c3:
            goto L_0x037d
        L_0x01c5:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r6)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x01d0:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r4)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x01db:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r8)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x01e6:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r5)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x01f1:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = "open_market_fail"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r3)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x01fe:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = "open_market_suc"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r3)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x020b:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = "open_market_url"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8397b(r1, r2, r0, r3)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0218:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8410i(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0229:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8408g(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x023a:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8407f(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x024b:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8406e(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x025c:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8417p(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x026d:
            com.bytedance.sdk.openadsdk.core.d.k r1 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r1 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12029f(r1)     // Catch:{ all -> 0x0375 }
            android.content.Context r2 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r3 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8418q(r2, r3, r0, r1, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x027e:
            com.ss.android.a.a.c.d r1 = r11.f8526a     // Catch:{ all -> 0x0375 }
            org.json.JSONObject r1 = com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.m11082e(r1)     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "hijack"
            if (r1 == 0) goto L_0x0298
            java.lang.String r4 = "scene"
            int r4 = r1.optInt(r4, r10)     // Catch:{ all -> 0x0375 }
            int r1 = r1.optInt(r2, r9)     // Catch:{ all -> 0x0375 }
            if (r1 != r3) goto L_0x0295
            goto L_0x0296
        L_0x0295:
            r9 = r1
        L_0x0296:
            r5 = r4
            goto L_0x0299
        L_0x0298:
            r5 = -1
        L_0x0299:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0375 }
            r7.put(r2, r1)     // Catch:{ all -> 0x0375 }
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r4 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            r3 = r0
            r6 = r7
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8385a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0375 }
            boolean r1 = r11.m11089b()     // Catch:{ all -> 0x0375 }
            if (r1 == 0) goto L_0x037d
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = "auto_control"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8418q(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x02c4:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8405d(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x02d5:
            com.ss.android.a.a.c.d r1 = r11.f8526a     // Catch:{ all -> 0x0375 }
            org.json.JSONObject r1 = com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.m11082e(r1)     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "unknown"
            if (r1 == 0) goto L_0x02ee
            java.lang.String r3 = "fail_status"
            int r3 = r1.optInt(r3, r10)     // Catch:{ all -> 0x0375 }
            java.lang.String r4 = "fail_msg"
            java.lang.String r1 = r1.optString(r4, r2)     // Catch:{ all -> 0x0375 }
            r6 = r1
            r5 = r3
            goto L_0x02f0
        L_0x02ee:
            r6 = r2
            r5 = -1
        L_0x02f0:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r4 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            r3 = r0
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8384a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0302:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8402c(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0312:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8398b(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0322:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8387a(r1, r2, r0, r3, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0332:
            android.content.Context r1 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r2 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.ss.android.a.a.c.d r3 = r11.f8526a     // Catch:{ all -> 0x0375 }
            java.lang.String r3 = r3.mo31120b()     // Catch:{ all -> 0x0375 }
            org.json.JSONObject r4 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m11999a(r7)     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8388a(r1, r2, r0, r3, r4)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0346:
            android.content.Context r0 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r1 = r11.f8528c     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8380a(r0, r1)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0350:
            android.content.Context r0 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r1 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "back_install_1"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(r0, r1, r2, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x035c:
            android.content.Context r0 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r1 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "back_install_0"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(r0, r1, r2, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0368:
            android.content.Context r0 = r11.m11086a()     // Catch:{ all -> 0x0375 }
            com.bytedance.sdk.openadsdk.core.d.k r1 = r11.f8528c     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "back_install"
            com.bytedance.sdk.openadsdk.p165c.AdEventManager.m8404c(r0, r1, r2, r7)     // Catch:{ all -> 0x0375 }
            goto L_0x037d
        L_0x0374:
            return
        L_0x0375:
            r0 = move-exception
            java.lang.String r1 = "LibEventLogger"
            java.lang.String r2 = "upload event log error"
            com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r1, r2, r0)
        L_0x037d:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibEventLogger.C2397a.run():void");
        }

        /* renamed from: b */
        private boolean m11089b() {
            boolean z = false;
            try {
                if (m11086a() == null) {
                    return false;
                }
                if (this.f8528c != null && this.f8528c.mo15496k()) {
                    if (this.f8528c.mo15414B() == 4) {
                        DeepLink O = this.f8528c.mo15427O();
                        if (O != null && !TextUtils.isEmpty(O.mo15376a())) {
                            return false;
                        }
                        C2222b N = this.f8528c.mo15426N();
                        if (N != null) {
                            if (!TextUtils.isEmpty(N.mo15348d())) {
                                ToolUtils.m12005a(m11086a(), N.mo15348d());
                                z = true;
                            }
                        }
                    }
                }
                return z;
            } catch (Throwable unused) {
            }
        }
    }

    public LibEventLogger(Context context) {
        this.f8525a = new WeakReference<>(context);
    }

    /* renamed from: a */
    public void mo16476a(DownloadEventModel dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onV3Event: ");
        sb.append(String.valueOf(dVar));
        C2564t.m12220b("LibEventLogger", sb.toString());
        m11079a(dVar, true);
    }

    /* renamed from: b */
    public void mo16477b(DownloadEventModel dVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEvent: ");
        sb.append(String.valueOf(dVar));
        C2564t.m12220b("LibEventLogger", sb.toString());
        m11079a(dVar, false);
        m11081d(dVar);
    }

    /* renamed from: d */
    private void m11081d(DownloadEventModel dVar) {
        if (dVar != null) {
            TTExecutor.m11692a().mo16809d(C2397a.m11087a(dVar), 5);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: e */
    public static JSONObject m11082e(DownloadEventModel dVar) {
        if (dVar != null) {
            JSONObject d = dVar.mo31122d();
            if (d != null) {
                String optString = d.optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        return new JSONObject(optString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m11079a(DownloadEventModel dVar, boolean z) {
        TTDownloadEventLogger m = GlobalInfo.m9616c().mo15683m();
        if (m != null && dVar != null && (!m.shouldFilterOpenSdkLog() || !m11083f(dVar))) {
            if (z) {
                m.onV3Event(dVar);
            } else {
                m.onEvent(dVar);
            }
        }
    }

    /* renamed from: f */
    private boolean m11083f(DownloadEventModel dVar) {
        dVar.mo31121c();
        boolean z = false;
        if (dVar == null) {
            return false;
        }
        String dVar2 = dVar.toString();
        if (!TextUtils.isEmpty(dVar2)) {
            z = dVar2.contains("open_ad_sdk_download_extra");
        }
        return z;
    }
}
