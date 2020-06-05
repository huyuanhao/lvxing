package com.tencent.android.tpush.p579a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.mid.api.MidProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.a.a */
public class C6861a {
    /* renamed from: a */
    private static volatile C6861a f22825a;
    /* renamed from: b */
    private Context f22826b = null;
    /* renamed from: c */
    private PackageManager f22827c = null;
    /* renamed from: d */
    private HashMap<String, C6863c> f22828d = new HashMap<>();
    /* renamed from: e */
    private Map<String, Long> f22829e = new HashMap();

    private C6861a(Context context) {
        this.f22826b = context;
        this.f22827c = context.getPackageManager();
    }

    /* renamed from: a */
    public static C6861a m29264a(Context context) {
        if (f22825a == null) {
            synchronized (C6861a.class) {
                if (f22825a == null) {
                    f22825a = new C6861a(context);
                }
            }
        }
        return f22825a;
    }

    /* renamed from: a */
    public void mo32984a() {
        try {
            mo32987b();
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "init", th);
        }
    }

    /* renamed from: b */
    public void mo32987b() {
        List<ProviderInfo> queryContentProviders = this.f22827c.queryContentProviders(null, 0, 0);
        List c = mo32988c();
        if (queryContentProviders != null && c != null) {
            for (ProviderInfo providerInfo : queryContentProviders) {
                if (c.contains(providerInfo.packageName) && providerInfo.exported) {
                    C6863c cVar = (C6863c) this.f22828d.get(providerInfo.packageName);
                    if (cVar == null) {
                        cVar = new C6863c();
                    }
                    cVar.mo32991a(providerInfo.packageName);
                    String str = providerInfo.name;
                    if (str.equals(XGPushProvider.class.getName())) {
                        cVar.mo32990a(providerInfo);
                    } else if (str.equals(MidProvider.class.getName())) {
                        cVar.mo32992b(providerInfo);
                    } else {
                        cVar.mo32993c(providerInfo);
                    }
                    this.f22828d.put(providerInfo.packageName, cVar);
                }
            }
        }
    }

    /* renamed from: c */
    public List<String> mo32988c() {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryBroadcastReceivers = this.f22827c.queryBroadcastReceivers(new Intent(Constants.ACTION_SDK_INSTALL), 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                arrayList.add(resolveInfo.resolvePackageName);
            }
        }
        Map a = C6860a.m29253a(this.f22826b);
        if (a != null) {
            for (Entry entry : a.entrySet()) {
                if (!arrayList.contains(entry.getKey())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo32985a(String str) {
        String str2 = Constants.LogTag;
        try {
            if (m29266d() && !this.f22826b.getPackageName().equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryWakeUpApp packageName:");
                sb.append(str);
                C6864a.m29298c(str2, sb.toString());
                m29265c(str);
            }
        } catch (Throwable th) {
            C6864a.m29302d(str2, "tryWakeUpApp", th);
        }
    }

    /* renamed from: d */
    private boolean m29266d() {
        String str = C6971a.m29749a(this.f22826b).f23138I;
        String str2 = Build.MANUFACTURER;
        StringBuilder sb = new StringBuilder();
        sb.append("wakeCtr:");
        sb.append(str);
        sb.append(",mf:");
        sb.append(str2);
        C6864a.m29298c(Constants.LogTag, sb.toString());
        if (!C6914l.m29521c(str) || !C6914l.m29521c(str2)) {
            for (String lowerCase : str.split(StorageInterface.KEY_SPLITER)) {
                if (lowerCase.toLowerCase().equals(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m29265c(String str) {
        Long l = (Long) this.f22829e.get(str);
        if (l == null || System.currentTimeMillis() <= l.longValue()) {
            C6863c b = mo32986b(str);
            StringBuilder sb = new StringBuilder();
            sb.append("tryWakeUpApp ipcAppInfo:");
            sb.append(b);
            String sb2 = sb.toString();
            String str2 = Constants.LogTag;
            C6864a.m29298c(str2, sb2);
            if (b != null) {
                ArrayList<ProviderInfo> a = b.mo32989a();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tryWakeUpApp providerInfoList:");
                sb3.append(a);
                C6864a.m29298c(str2, sb3.toString());
                if (a != null) {
                    for (ProviderInfo providerInfo : a) {
                        if (providerInfo.exported) {
                            String str3 = providerInfo.authority;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("content://");
                            sb4.append(str3);
                            Uri parse = Uri.parse(sb4.toString());
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("tryWakeUpApp uri:");
                            sb5.append(parse);
                            C6864a.m29298c(str2, sb5.toString());
                            this.f22826b.getContentResolver().getType(parse);
                        }
                    }
                }
            }
            this.f22829e.put(str, Long.valueOf(System.currentTimeMillis() + 3600000));
        }
    }

    /* renamed from: b */
    public C6863c mo32986b(String str) {
        if (!this.f22828d.containsKey(str)) {
            mo32984a();
        }
        return (C6863c) this.f22828d.get(str);
    }
}
