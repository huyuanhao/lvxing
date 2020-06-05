package com.tencent.android.tpush.p579a;

import android.content.pm.ProviderInfo;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.a.c */
public class C6863c {
    /* renamed from: a */
    private String f22831a;
    /* renamed from: b */
    private ProviderInfo f22832b;
    /* renamed from: c */
    private ProviderInfo f22833c;
    /* renamed from: d */
    private ArrayList<ProviderInfo> f22834d;

    /* renamed from: a */
    public void mo32991a(String str) {
        this.f22831a = str;
    }

    /* renamed from: a */
    public void mo32990a(ProviderInfo providerInfo) {
        this.f22832b = providerInfo;
    }

    /* renamed from: b */
    public void mo32992b(ProviderInfo providerInfo) {
        this.f22833c = providerInfo;
    }

    /* renamed from: a */
    public ArrayList<ProviderInfo> mo32989a() {
        return this.f22834d;
    }

    /* renamed from: c */
    public void mo32993c(ProviderInfo providerInfo) {
        if (this.f22834d == null) {
            this.f22834d = new ArrayList<>();
        }
        this.f22834d.add(providerInfo);
    }
}
