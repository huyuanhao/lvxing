package com.kwad.sdk.contentalliance.detail.photo.p312a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.sdk.contentalliance.detail.photo.p312a.C3887b.C3892a;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.a.e */
public class C3895e extends Dialog {
    /* renamed from: b */
    private static C3895e f13185b;
    /* renamed from: a */
    C3892a f13186a = new C3892a() {
        /* renamed from: a */
        public void mo23395a() {
            C3895e.this.dismiss();
        }

        /* renamed from: b */
        public void mo23396b() {
            C3895e.this.dismiss();
        }
    };
    /* renamed from: c */
    private C3887b f13187c;
    /* renamed from: d */
    private C3894d f13188d;

    public C3895e(Context context, C3894d dVar) {
        super(context);
        setOwnerActivity((Activity) context);
        this.f13188d = dVar;
    }

    /* renamed from: a */
    public static void m16184a(Context context, C3894d dVar) {
        C3895e eVar = f13185b;
        if (eVar == null || !eVar.isShowing()) {
            f13185b = new C3895e(context, dVar);
            f13185b.show();
        }
    }

    /* renamed from: a */
    public static boolean m16185a() {
        C3895e eVar = f13185b;
        if (eVar != null) {
            return eVar.isShowing();
        }
        return false;
    }

    public void dismiss() {
        super.dismiss();
        f13185b = null;
    }

    public boolean isShowing() {
        return super.isShowing();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f13187c = new C3887b(getContext());
        this.f13187c.mo23389a(this.f13188d);
        setContentView(this.f13187c);
        this.f13187c.mo23388a(this.f13186a);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13187c.mo23390b(this.f13186a);
        this.f13187c.mo23387a();
    }

    public void show() {
        super.show();
    }
}
