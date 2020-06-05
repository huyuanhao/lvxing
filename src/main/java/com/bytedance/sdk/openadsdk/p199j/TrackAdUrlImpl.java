package com.bytedance.sdk.openadsdk.p199j;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.RequestFuture;
import com.bytedance.sdk.adnet.p159b.StringRequest;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ListUtils;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* renamed from: com.bytedance.sdk.openadsdk.j.b */
public class TrackAdUrlImpl implements TrackAdUrl {
    /* renamed from: a */
    private final Context f8986a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final TrackRetryRepertory f8987b;

    /* compiled from: TrackAdUrlImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.j.b$a */
    private class C2496a extends AsyncTask<Void, Void, Void> {
        /* renamed from: b */
        private final TrackInfo f8993b;
        /* renamed from: c */
        private final String f8994c;

        private C2496a(TrackInfo eVar, String str) {
            this.f8993b = eVar;
            this.f8994c = str;
        }

        /* renamed from: c */
        private String m11724c(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = "{TS}";
            String str3 = "__TS__";
            if (str.contains(str2) || str.contains(str3)) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace(str2, String.valueOf(currentTimeMillis)).replace(str3, String.valueOf(currentTimeMillis));
            }
            String str4 = "{UID}";
            String str5 = "__UID__";
            if ((str.contains(str4) || str.contains(str5)) && !TextUtils.isEmpty(this.f8994c)) {
                str = str.replace(str4, this.f8994c).replace(str5, this.f8994c);
            }
            String a = OAIDHelper.m12248a();
            String str6 = "{OAID}";
            String str7 = "__OAID__";
            return ((str.contains(str6) || str.contains(str7)) && !TextUtils.isEmpty(a)) ? str.replace(str6, a).replace(str7, a) : str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo16829a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo16830b(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                str = str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                return str;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        /* access modifiers changed from: protected|varargs */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            C1982p pVar;
            if (!SdkSwitch.m9757a() || !mo16829a(this.f8993b.mo16834b())) {
                return null;
            }
            if (this.f8993b.mo16836d() == 0) {
                TrackAdUrlImpl.this.f8987b.mo16840c(this.f8993b);
                return null;
            }
            while (true) {
                if (this.f8993b.mo16836d() <= 0 || isCancelled()) {
                    break;
                }
                try {
                    if (this.f8993b.mo16836d() == 5) {
                        TrackAdUrlImpl.this.f8987b.mo16838a(this.f8993b);
                    }
                    if (!C2566w.m12241a(TrackAdUrlImpl.this.mo16825b())) {
                        break;
                    }
                    String c = m11724c(this.f8993b.mo16834b());
                    if (this.f8993b.mo16835c()) {
                        c = mo16830b(c);
                    }
                    RequestFuture a = RequestFuture.m7746a();
                    new StringRequest(0, c, a).setRetryPolicy(TTNetClient.m11430b().mo14330a((int) C7516p.f25219Cf)).build(TTNetClient.m11428a(TrackAdUrlImpl.this.mo16825b()).mo16657d());
                    try {
                        pVar = a.get();
                    } catch (Throwable unused) {
                        pVar = null;
                    }
                    String str = "trackurl";
                    if (pVar != null) {
                        if (pVar.mo14373a()) {
                            TrackAdUrlImpl.this.f8987b.mo16840c(this.f8993b);
                            if (C2564t.m12224c()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("track success : ");
                                sb.append(this.f8993b.mo16834b());
                                C2564t.m12222c(str, sb.toString());
                            }
                        }
                    }
                    if (C2564t.m12224c()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("track fail : ");
                        sb2.append(this.f8993b.mo16834b());
                        C2564t.m12222c(str, sb2.toString());
                    }
                    this.f8993b.mo16833a(this.f8993b.mo16836d() - 1);
                    if (this.f8993b.mo16836d() == 0) {
                        TrackAdUrlImpl.this.f8987b.mo16840c(this.f8993b);
                        if (C2564t.m12224c()) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("track fail and delete : ");
                            sb3.append(this.f8993b.mo16834b());
                            C2564t.m12222c(str, sb3.toString());
                        }
                    } else {
                        TrackAdUrlImpl.this.f8987b.mo16839b(this.f8993b);
                    }
                } catch (Throwable unused2) {
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public void mo16822a() {
    }

    public TrackAdUrlImpl(Context context, TrackRetryRepertory fVar) {
        this.f8986a = context;
        this.f8987b = fVar;
    }

    /* renamed from: b */
    public Context mo16825b() {
        Context context = this.f8986a;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* renamed from: a */
    public void mo16824a(String str, List<String> list, boolean z) {
        if (SdkSwitch.m9757a() && ListUtils.m12209b(list)) {
            for (String str2 : list) {
                StringBuilder sb = new StringBuilder();
                sb.append(UUID.randomUUID().toString());
                sb.append("_");
                sb.append(System.currentTimeMillis());
                new C2496a(new TrackInfo(sb.toString(), str2, z, 5), str).executeOnExecutor(TTExecutor.m11692a().mo16805b(), new Void[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo16823a(final String str) {
        if (SdkSwitch.m9757a()) {
            TTExecutor.m11692a().mo16809d(new Runnable() {
                public void run() {
                    final List a = TrackAdUrlImpl.this.f8987b.mo16837a();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            TrackAdUrlImpl.this.m11718a(a, str);
                        }
                    });
                }
            }, 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11718a(List<TrackInfo> list, String str) {
        if (ListUtils.m12209b(list)) {
            for (TrackInfo aVar : list) {
                new C2496a(aVar, str).executeOnExecutor(TTExecutor.m11692a().mo16805b(), new Void[0]);
            }
        }
    }

    /* renamed from: c */
    public static TrackAdUrl m11719c() {
        return TrackAdUrlImplEmpty.m11731b();
    }
}
