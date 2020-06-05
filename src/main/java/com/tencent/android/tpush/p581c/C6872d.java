package com.tencent.android.tpush.p581c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.C6931a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6873e.C6874a;
import com.tencent.android.tpush.service.channel.security.C7038a;
import com.tencent.android.tpush.service.channel.security.C7043d;
import com.tencent.mid.sotrage.StorageInterface;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.d */
public class C6872d {
    /* renamed from: f */
    private static String f22867f;
    /* renamed from: a */
    private long f22868a = 0;
    /* renamed from: b */
    private long f22869b = 0;
    /* renamed from: c */
    private String f22870c = "";
    /* renamed from: d */
    private String f22871d = null;
    /* renamed from: e */
    private Context f22872e = null;
    /* renamed from: g */
    private Intent f22873g = null;

    public C6872d(Context context, Intent intent) {
        this.f22872e = context.getApplicationContext();
        this.f22873g = intent;
    }

    /* renamed from: a */
    private boolean m29354a() {
        String str = ".xg.push.cm.vrf";
        if (f22867f == null) {
            f22867f = C6908h.m29483a(this.f22872e, str, "");
        }
        if (f22867f.contains(this.f22870c)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22870c);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(f22867f);
        f22867f = sb.toString();
        if (f22867f.length() > 10240) {
            f22867f = f22867f.substring(0, 2048);
        }
        C6908h.m29487b(this.f22872e, str, f22867f);
        return false;
    }

    /* renamed from: a */
    public boolean mo33028a(C6881g gVar, long j, long j2, long j3) {
        C6867a g = gVar.mo33057g();
        String stringExtra = this.f22873g.getStringExtra("title");
        String str = Constants.LogTag;
        boolean z = true;
        if (j3 <= 0 || stringExtra == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(gVar.mo33053c());
            sb.append(j3);
            sb.append(this.f22872e.getPackageName());
            String str2 = "";
            sb.append(TextUtils.isEmpty(g.mo33000e()) ? str2 : g.mo33000e());
            sb.append(TextUtils.isEmpty(g.mo33001f()) ? str2 : g.mo33001f());
            String g2 = g.mo33002g();
            String jSONObject = (TextUtils.isEmpty(g2) || new JSONObject(g2).length() == 0) ? str2 : new JSONObject(g2).toString();
            sb.append(jSONObject);
            if (g instanceof C6873e) {
                C6874a m = ((C6873e) g).mo33034m();
                sb.append(TextUtils.isEmpty(m.f22894f) ? str2 : m.f22894f);
                sb.append(TextUtils.isEmpty(m.f22892d) ? str2 : m.f22892d);
                if (!TextUtils.isEmpty(m.f22890b)) {
                    str2 = m.f22890b;
                }
                sb.append(str2);
            }
            String sb2 = sb.toString();
            String a = C6931a.m29598a(sb2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Constants.LOCAL_MESSAGE_FLAG);
            sb3.append(a);
            String sb4 = sb3.toString();
            long a2 = C6908h.m29481a(this.f22872e, sb4, 0);
            C6908h.m29484a(this.f22872e, sb4);
            long currentTimeMillis = a2 - System.currentTimeMillis();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(",localMsgTag:");
            sb5.append(sb4);
            sb5.append(",diff:");
            sb5.append(currentTimeMillis);
            C6864a.m29298c(str, sb5.toString());
            if (currentTimeMillis < 0) {
                z = false;
            }
            return z;
        }
        JSONObject jSONObject2 = new JSONObject(Rijndael.decrypt(stringExtra));
        StringBuilder sb6 = new StringBuilder();
        sb6.append("title encry obj:");
        sb6.append(jSONObject2);
        C6864a.m29303e(str, sb6.toString());
        this.f22870c = C7043d.m30107a(C7038a.m30101a(jSONObject2.getString("cipher"), 0));
        String[] split = this.f22870c.split("_");
        this.f22869b = Long.valueOf(split[0]).longValue();
        this.f22871d = split[1].toUpperCase();
        this.f22868a = Long.valueOf(split[2]).longValue();
        boolean z2 = this.f22869b == j2 && (j2 != 0 || j == this.f22868a);
        if (!z2 || m29354a() || j2 != this.f22869b || !g.mo32996a().equalsIgnoreCase(this.f22871d)) {
            z = false;
        }
        return z;
    }
}
