package com.tencent.mta.track;

import android.R.id;
import android.content.Context;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ac */
public class C7343ac extends C7342ab {
    /* renamed from: a */
    private final String f24868a;

    public C7343ac(String str, Context context) {
        super(context);
        this.f24868a = str;
        mo35841b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class mo35839a() {
        return id.class;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo35840a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24868a);
        sb.append(".R$id");
        return sb.toString();
    }
}
