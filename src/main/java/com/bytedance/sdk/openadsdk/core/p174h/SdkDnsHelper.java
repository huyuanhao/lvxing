package com.bytedance.sdk.openadsdk.core.p174h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.p159b.JsonObjectRequest;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.h */
public class SdkDnsHelper implements Runnable {
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final AtomicBoolean f7635c = new AtomicBoolean(false);
    /* renamed from: d */
    private static volatile SdkDnsHelper f7636d;
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ISettings f7637a;
    /* renamed from: b */
    private final Context f7638b;

    /* compiled from: SdkDnsHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.h.h$a */
    private class C2253a extends BroadcastReceiver {
        private C2253a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("b_msg_id", -1) == 1) {
                String stringExtra = intent.getStringExtra("b_msg_data");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        if (SdkDnsHelper.this.f7637a != null) {
                            SdkDnsHelper.this.f7637a.mo15742a(jSONObject);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static SdkDnsHelper m9732a(ISettings eVar) {
        if (f7636d == null) {
            synchronized (SdkDnsHelper.class) {
                if (f7636d == null) {
                    f7636d = new SdkDnsHelper(eVar);
                }
            }
        }
        return f7636d;
    }

    /* renamed from: a */
    private String m9733a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer("https://");
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("dig.bdurl.net");
        }
        stringBuffer.append("/q?host=");
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("is.snssdk.com");
            stringBuffer.append(StorageInterface.KEY_SPLITER);
            stringBuffer.append("pangolin.snssdk.com");
        }
        stringBuffer.append("&aid=");
        stringBuffer.append("1371");
        return stringBuffer.toString();
    }

    private SdkDnsHelper(ISettings eVar) {
        if (eVar == null) {
            eVar = InternalContainer.m10069h();
        }
        this.f7637a = eVar;
        this.f7638b = InternalContainer.m10059a();
        if (MultiGlobalInfo.m11808b()) {
            try {
                this.f7638b.registerReceiver(new C2253a(), new IntentFilter("com.bytedance.openadsdk.dnsSettingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9734a(String str) {
        if (!TextUtils.isEmpty(str) && InternalContainer.m10059a() != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.bytedance.openadsdk.dnsSettingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_data", str);
                InternalContainer.m10059a().sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public void mo15746a() {
        try {
            if (!f7635c.getAndSet(true)) {
                TTExecutor.m11692a().mo16807b(this, 10);
            }
        } catch (Throwable th) {
            C2564t.m12216a("SdkDnsHelper", "load sdk dns settings error: ", th);
        }
    }

    public void run() {
        if (!C2566w.m12241a(this.f7638b)) {
            try {
                this.f7637a.mo15741a();
                f7635c.set(false);
            } catch (Throwable unused) {
            }
        } else {
            new JsonObjectRequest(0, m9733a(null, null), (String) null, (C1983a<JSONObject>) new C1983a<JSONObject>() {
                /* renamed from: a */
                public void mo14171a(C1982p<JSONObject> pVar) {
                    SdkDnsHelper.f7635c.set(false);
                    if (pVar == null || pVar.f6293a == null) {
                        try {
                            SdkDnsHelper.this.f7637a.mo15741a();
                        } catch (Throwable unused) {
                        }
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) pVar.f6293a;
                    try {
                        SdkDnsHelper.this.f7637a.mo15742a(jSONObject);
                    } catch (Throwable unused2) {
                    }
                    if (MultiGlobalInfo.m11808b()) {
                        SdkDnsHelper.m9734a(jSONObject.toString());
                    }
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    SdkDnsHelper.f7635c.set(false);
                    try {
                        SdkDnsHelper.this.f7637a.mo15741a();
                    } catch (Throwable unused) {
                    }
                }
            }).setResponseOnMain(false).setShouldCache(false).build(TTNetClient.m11428a(this.f7638b).mo16657d());
        }
    }
}
