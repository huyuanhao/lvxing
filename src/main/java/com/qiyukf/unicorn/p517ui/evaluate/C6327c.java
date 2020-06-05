package com.qiyukf.unicorn.p517ui.evaluate;

import android.content.Context;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6010b;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p516j.C6228j;
import com.qiyukf.unicorn.p517ui.evaluate.C6317a.C6325a;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.evaluate.c */
public final class C6327c {
    /* renamed from: a */
    private Fragment f19730a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f19731b;
    /* renamed from: c */
    private View f19732c;
    /* renamed from: d */
    private ImageView f19733d;
    /* renamed from: e */
    private TextView f19734e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C6317a f19735f;
    /* renamed from: g */
    private String f19736g;
    /* renamed from: h */
    private int f19737h = 0;
    /* renamed from: i */
    private boolean f19738i = false;

    public C6327c(Fragment fragment, String str) {
        this.f19730a = fragment;
        this.f19736g = str;
    }

    /* renamed from: a */
    static /* synthetic */ void m24904a(C6327c cVar, int i, List list, String str) {
        cVar.f19735f.mo29518a(false);
        cVar.f19735f.mo29519b(true);
        C6029d.m24047g().mo29296c().mo29269a(cVar.f19736g, i, str, list, (RequestCallbackWrapper<Void>) new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i != 200 || C6327c.this.f19735f == null) {
                    if (!(i == 200 || C6327c.this.f19735f == null || !C6327c.this.f19735f.isShowing())) {
                        C6327c.this.f19735f.mo29518a(true);
                        C6327c.this.f19735f.mo29519b(false);
                        C5415g.m22163a(C6327c.this.f19731b.getString(C5961R.string.ysf_network_error));
                    }
                    return;
                }
                C6327c.this.f19735f.cancel();
                C6327c.this.f19735f = null;
            }
        });
    }

    /* renamed from: a */
    public final void mo29534a() {
        if (this.f19732c != null) {
            C5409b.m22132a(this.f19730a);
            if (this.f19737h == 1) {
                this.f19733d.clearAnimation();
                this.f19735f = new C6317a(this.f19731b, this.f19736g);
                this.f19735f.setCanceledOnTouchOutside(false);
                this.f19735f.mo29517a((C6325a) new C6325a() {
                    /* renamed from: a */
                    public final void mo29272a(int i, List<String> list, String str) {
                        C6327c.m24904a(C6327c.this, i, list, str);
                    }
                });
                this.f19735f.show();
            }
        }
    }

    /* renamed from: a */
    public final void mo29535a(View view) {
        if (view != null) {
            this.f19732c = view;
            this.f19731b = view.getContext();
            this.f19733d = (ImageView) view.findViewById(C5961R.C5963id.ysf_action_menu_icon);
            this.f19734e = (TextView) view.findViewById(C5961R.C5963id.ysf_action_menu_title);
        }
    }

    /* renamed from: a */
    public final void mo29536a(String str) {
        this.f19736g = str;
    }

    /* renamed from: a */
    public final void mo29537a(boolean z) {
        this.f19738i = z;
        mo29538b();
    }

    /* renamed from: b */
    public final void mo29538b() {
        boolean z = false;
        if (this.f19738i) {
            this.f19737h = C6014b.m23964j(this.f19736g);
        } else {
            this.f19737h = 0;
        }
        if (C6010b.m23913a().mo28845b() != null) {
            C6010b.m23913a();
        }
        View view = this.f19732c;
        if (view != null) {
            C6228j.m24666a(view, this.f19737h != 0);
            this.f19733d.setImageLevel(this.f19737h);
            this.f19734e.setText(this.f19737h == 2 ? C5961R.string.ysf_evaluation_complete : C5961R.string.ysf_evaluation);
            if (this.f19737h == 0) {
                this.f19733d.clearAnimation();
            }
        }
        if (C6014b.m23962i(this.f19736g) == 4) {
            z = true;
        }
        if (this.f19738i && z) {
            mo29539c();
        }
    }

    /* renamed from: c */
    public final void mo29539c() {
        if (this.f19732c != null && this.f19737h == 1) {
            C6317a aVar = this.f19735f;
            if (aVar == null || !aVar.isShowing()) {
                C6014b.m23927a(this.f19736g, -1);
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -8.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setInterpolator(new CycleInterpolator(3.0f));
                rotateAnimation.setDuration(400);
                rotateAnimation.setStartOffset(800);
                rotateAnimation.setRepeatCount(4);
                this.f19733d.startAnimation(rotateAnimation);
            }
        }
    }
}
