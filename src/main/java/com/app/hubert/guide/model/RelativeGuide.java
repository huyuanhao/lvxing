package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.app.hubert.guide.p128b.LogUtil;

/* renamed from: com.app.hubert.guide.model.d */
public class RelativeGuide {
    /* renamed from: a */
    public HighLight f4085a;
    /* renamed from: b */
    public int f4086b;
    /* renamed from: c */
    public int f4087c;
    /* renamed from: d */
    public int f4088d;

    /* compiled from: RelativeGuide */
    /* renamed from: com.app.hubert.guide.model.d$a */
    public static class C1592a {
        /* renamed from: a */
        public int f4089a;
        /* renamed from: b */
        public int f4090b;
        /* renamed from: c */
        public int f4091c;
        /* renamed from: d */
        public int f4092d;
        /* renamed from: e */
        public int f4093e;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MarginInfo{leftMargin=");
            sb.append(this.f4089a);
            sb.append(", topMargin=");
            sb.append(this.f4090b);
            sb.append(", rightMargin=");
            sb.append(this.f4091c);
            sb.append(", bottomMargin=");
            sb.append(this.f4092d);
            sb.append(", gravity=");
            sb.append(this.f4093e);
            sb.append('}');
            return sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12338a(View view) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12339a(C1592a aVar, ViewGroup viewGroup, View view) {
    }

    /* renamed from: a */
    public final View mo12337a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f4086b, viewGroup, false);
        mo12338a(inflate);
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        C1592a a = m4852a(this.f4088d, viewGroup, inflate);
        LogUtil.m4780c(a.toString());
        mo12339a(a, viewGroup, inflate);
        layoutParams.gravity = a.f4093e;
        layoutParams.leftMargin += a.f4089a;
        layoutParams.topMargin += a.f4090b;
        layoutParams.rightMargin += a.f4091c;
        layoutParams.bottomMargin += a.f4092d;
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    /* renamed from: a */
    private C1592a m4852a(int i, ViewGroup viewGroup, View view) {
        C1592a aVar = new C1592a();
        RectF a = this.f4085a.mo12316a(viewGroup);
        if (i == 3) {
            aVar.f4093e = 5;
            aVar.f4091c = (int) ((((float) viewGroup.getWidth()) - a.left) + ((float) this.f4087c));
            aVar.f4090b = (int) a.top;
        } else if (i == 5) {
            aVar.f4089a = (int) (a.right + ((float) this.f4087c));
            aVar.f4090b = (int) a.top;
        } else if (i == 48) {
            aVar.f4093e = 80;
            aVar.f4092d = (int) ((((float) viewGroup.getHeight()) - a.top) + ((float) this.f4087c));
            aVar.f4089a = (int) a.left;
        } else if (i == 80) {
            aVar.f4090b = (int) (a.bottom + ((float) this.f4087c));
            aVar.f4089a = (int) a.left;
        }
        return aVar;
    }
}
