package com.tencent.android.tpush.cloudctr.network;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.cloudctr.p582a.C6887a;
import com.tencent.android.tpush.cloudctr.p583b.C6891c;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.stat.XGPatchMonitor;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.cloudctr.network.a */
public class C6894a {
    /* renamed from: a */
    private C6891c f22963a = new C6891c("cloud control network thread");
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C6887a f22964b;

    public C6894a(C6887a aVar) {
        this.f22964b = aVar;
    }

    /* renamed from: a */
    public void mo33095a(Context context, String str, long j) {
        final Context applicationContext = context.getApplicationContext();
        C6891c cVar = this.f22963a;
        final String str2 = str;
        final long j2 = j;
        C68951 r0 = new Runnable() {
            public void run() {
                String str = "cloud control";
                try {
                    long accessId = XGPushConfig.getAccessId(applicationContext);
                    String accessKey = XGPushConfig.getAccessKey(applicationContext);
                    if (accessId > 0) {
                        if (!C6914l.m29521c(accessKey)) {
                            Date a = C6894a.this.f22964b.mo33069a(applicationContext, str2, accessId);
                            if (a == null || System.currentTimeMillis() - a.getTime() >= 259200000) {
                                Intent intent = new Intent("com.tencent.android.tpush.action.REGISTER.V4");
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                sb.append(accessId);
                                intent.putExtra("accId", Rijndael.encrypt(sb.toString()));
                                intent.putExtra("accChannel", XGPushConfig.getChannelId(applicationContext));
                                intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                                intent.putExtra("currentTimeMillis", System.currentTimeMillis());
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("ccver", 1);
                                    jSONObject.put("cccheck", 1);
                                    jSONObject.put("cccfgver", j2);
                                    jSONObject.put("ccbuscode", str2);
                                } catch (Exception unused) {
                                }
                                intent.putExtra("reserved", Rijndael.encrypt(jSONObject.toString()));
                                XGPatchMonitor.onConfigAction(applicationContext, accessId, str2, XGPatchMonitor.ActionRequestConfig, 0, null, null);
                                applicationContext.sendBroadcast(intent);
                                Log.d(str, "send broadcast");
                                C6894a.this.f22964b.mo33070a(applicationContext, str2, accessId, new Date());
                                return;
                            }
                            C6864a.m29298c(str, "未达到云控注册时间间隔，忽略这次注册");
                        }
                    }
                } catch (Exception e) {
                    C6864a.m29308i(str, e.toString());
                }
            }
        };
        cVar.mo33077a(r0);
    }
}
