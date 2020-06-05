package com.app.hubert.guide.core;

import android.app.Activity;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.p127a.OnGuideChangedListener;
import com.app.hubert.guide.p127a.OnPageChangedListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.app.hubert.guide.core.a */
public class Builder {
    /* renamed from: a */
    Activity f4036a;
    /* renamed from: b */
    Fragment f4037b;
    /* renamed from: c */
    androidx.fragment.app.Fragment f4038c;
    /* renamed from: d */
    String f4039d;
    /* renamed from: e */
    boolean f4040e;
    /* renamed from: f */
    View f4041f;
    /* renamed from: g */
    int f4042g = 1;
    /* renamed from: h */
    OnGuideChangedListener f4043h;
    /* renamed from: i */
    OnPageChangedListener f4044i;
    /* renamed from: j */
    List<GuidePage> f4045j = new ArrayList();

    public Builder(Activity activity) {
        this.f4036a = activity;
    }

    /* renamed from: a */
    public Builder mo12301a(boolean z) {
        this.f4040e = z;
        return this;
    }

    /* renamed from: a */
    public Builder mo12299a(GuidePage aVar) {
        this.f4045j.add(aVar);
        return this;
    }

    /* renamed from: a */
    public Builder mo12298a(OnGuideChangedListener bVar) {
        this.f4043h = bVar;
        return this;
    }

    /* renamed from: a */
    public Builder mo12300a(String str) {
        this.f4039d = str;
        return this;
    }

    /* renamed from: a */
    public Controller mo12302a() {
        m4791b();
        Controller bVar = new Controller(this);
        bVar.mo12303a();
        return bVar;
    }

    /* renamed from: b */
    private void m4791b() {
        if (TextUtils.isEmpty(this.f4039d)) {
            throw new IllegalArgumentException("the param 'label' is missing, please call setLabel()");
        } else if (this.f4036a != null) {
        } else {
            if (this.f4037b != null || this.f4038c != null) {
                throw new IllegalStateException("activity is null, please make sure that fragment is showing when call NewbieGuide");
            }
        }
    }
}
