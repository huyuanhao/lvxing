package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.bytedance.sdk.openadsdk.core.p167a.InteractionListener;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.ListUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements C2539a {
    /* renamed from: a */
    private boolean f7183a;
    /* renamed from: b */
    private boolean f7184b;
    /* renamed from: c */
    private C2202a f7185c;
    /* renamed from: d */
    private View f7186d;
    /* renamed from: e */
    private List<View> f7187e;
    /* renamed from: f */
    private List<View> f7188f;
    /* renamed from: g */
    private boolean f7189g;
    /* renamed from: h */
    private int f7190h;
    /* renamed from: i */
    private final Handler f7191i = new C2538ak(Looper.getMainLooper(), this);
    /* renamed from: j */
    private final AtomicBoolean f7192j = new AtomicBoolean(true);

    /* renamed from: com.bytedance.sdk.openadsdk.core.EmptyView$a */
    public interface C2202a {
        /* renamed from: a */
        void mo14916a();

        /* renamed from: a */
        void mo14917a(View view);

        /* renamed from: a */
        void mo14918a(boolean z);

        /* renamed from: b */
        void mo14919b();
    }

    public EmptyView(Context context, View view) {
        super(InternalContainer.m10059a());
        this.f7186d = view;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        C2202a aVar = this.f7185c;
        if (aVar != null) {
            aVar.mo14918a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m9039d();
        this.f7189g = false;
        m9037b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m9037b();
    }

    /* renamed from: b */
    private void m9037b() {
        if (this.f7192j.getAndSet(false)) {
            C2202a aVar = this.f7185c;
            if (aVar != null) {
                aVar.mo14916a();
            }
        }
    }

    /* renamed from: c */
    private void m9038c() {
        if (!this.f7192j.getAndSet(true)) {
            C2202a aVar = this.f7185c;
            if (aVar != null) {
                aVar.mo14919b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9040e();
        this.f7189g = true;
        m9038c();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m9038c();
    }

    public void setRefClickViews(List<View> list) {
        this.f7187e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f7188f = list;
    }

    /* renamed from: a */
    public void mo15258a() {
        mo15259a(this.f7187e, null);
        mo15259a(this.f7188f, null);
    }

    /* renamed from: a */
    public void mo15259a(List<View> list, InteractionListener cVar) {
        if (ListUtils.m12209b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    /* renamed from: d */
    private void m9039d() {
        if (this.f7184b && !this.f7183a) {
            this.f7183a = true;
            this.f7191i.sendEmptyMessage(1);
        }
    }

    /* renamed from: e */
    private void m9040e() {
        if (this.f7183a) {
            this.f7191i.removeCallbacksAndMessages(null);
            this.f7183a = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.f7184b = z;
        if (!z && this.f7183a) {
            m9040e();
        } else if (z && !this.f7183a) {
            m9039d();
        }
    }

    public void setCallback(C2202a aVar) {
        this.f7185c = aVar;
    }

    public void setAdType(int i) {
        this.f7190h = i;
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                boolean d = ToolUtils.m12020d(InternalContainer.m10059a(), InternalContainer.m10059a().getPackageName());
                if (VisibilityChecker.m11004a(this.f7186d, 20, this.f7190h) || !d) {
                    this.f7191i.sendEmptyMessageDelayed(2, 1000);
                } else if (!this.f7189g) {
                    setNeedCheckingShow(true);
                }
            }
        } else if (!this.f7183a) {
        } else {
            if (VisibilityChecker.m11004a(this.f7186d, 20, this.f7190h)) {
                m9040e();
                this.f7191i.sendEmptyMessageDelayed(2, 1000);
                C2202a aVar = this.f7185c;
                if (aVar != null) {
                    aVar.mo14917a(this.f7186d);
                    return;
                }
                return;
            }
            this.f7191i.sendEmptyMessageDelayed(1, 1000);
        }
    }
}
