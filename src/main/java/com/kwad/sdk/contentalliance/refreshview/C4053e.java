package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.contentalliance.refreshview.e */
public class C4053e extends RefreshLayout {
    public C4053e(Context context) {
        this(context, null);
    }

    public C4053e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (C4054f.m16801a()) {
            setRefreshInitialOffset((float) ((-C3817t.m15861a(context)) - C3817t.m15862a(context, 30.0f)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4050b mo23624a() {
        return new C4049a(getContext());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23626a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(C3809l.m15792b(getContext(), "ksad_content_alliance_shoot_refresh_view"), this, true);
        this.f13558d = findViewById(C3809l.m15789a(getContext(), "ksad_slide_shoot_refresh_view"));
        this.f13558d.setVisibility(8);
        if (this.f13558d instanceof C4052d) {
            this.f13559e = (C4052d) this.f13558d;
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    /* renamed from: a */
    public void mo23708a(MotionEvent motionEvent) {
        if (!mo23650d()) {
            super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public View mo23645b(AttributeSet attributeSet) {
        return null;
    }

    /* renamed from: b */
    public void mo23709b(MotionEvent motionEvent) {
        if (!mo23650d()) {
            super.onTouchEvent(motionEvent);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
