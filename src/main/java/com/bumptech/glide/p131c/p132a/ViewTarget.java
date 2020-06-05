package com.bumptech.glide.p131c.p132a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.p131c.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* renamed from: com.bumptech.glide.c.a.i */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    /* renamed from: b */
    private static boolean f4189b;
    /* renamed from: c */
    private static Integer f4190c;
    /* renamed from: a */
    protected final T f4191a;
    /* renamed from: d */
    private final C1606a f4192d;
    /* renamed from: e */
    private OnAttachStateChangeListener f4193e;
    /* renamed from: f */
    private boolean f4194f;
    /* renamed from: g */
    private boolean f4195g;

    /* compiled from: ViewTarget */
    /* renamed from: com.bumptech.glide.c.a.i$a */
    static final class C1606a {
        /* renamed from: a */
        static Integer f4196a;
        /* renamed from: b */
        boolean f4197b;
        /* renamed from: c */
        private final View f4198c;
        /* renamed from: d */
        private final List<SizeReadyCallback> f4199d = new ArrayList();
        /* renamed from: e */
        private C1607a f4200e;

        /* compiled from: ViewTarget */
        /* renamed from: com.bumptech.glide.c.a.i$a$a */
        private static final class C1607a implements OnPreDrawListener {
            /* renamed from: a */
            private final WeakReference<C1606a> f4201a;

            C1607a(C1606a aVar) {
                this.f4201a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                String str = "ViewTarget";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v(str, sb.toString());
                }
                C1606a aVar = (C1606a) this.f4201a.get();
                if (aVar != null) {
                    aVar.mo12485a();
                }
                return true;
            }
        }

        /* renamed from: a */
        private boolean m5031a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        C1606a(View view) {
            this.f4198c = view;
        }

        /* renamed from: a */
        private static int m5029a(Context context) {
            if (f4196a == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.m6138a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f4196a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f4196a.intValue();
        }

        /* renamed from: a */
        private void m5030a(int i, int i2) {
            Iterator it = new ArrayList(this.f4199d).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).mo12482a(i, i2);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12485a() {
            if (!this.f4199d.isEmpty()) {
                int d = m5034d();
                int c = m5033c();
                if (m5032b(d, c)) {
                    m5030a(d, c);
                    mo12487b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12486a(SizeReadyCallback gVar) {
            int d = m5034d();
            int c = m5033c();
            if (m5032b(d, c)) {
                gVar.mo12482a(d, c);
                return;
            }
            if (!this.f4199d.contains(gVar)) {
                this.f4199d.add(gVar);
            }
            if (this.f4200e == null) {
                ViewTreeObserver viewTreeObserver = this.f4198c.getViewTreeObserver();
                this.f4200e = new C1607a(this);
                viewTreeObserver.addOnPreDrawListener(this.f4200e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo12488b(SizeReadyCallback gVar) {
            this.f4199d.remove(gVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo12487b() {
            ViewTreeObserver viewTreeObserver = this.f4198c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f4200e);
            }
            this.f4200e = null;
            this.f4199d.clear();
        }

        /* renamed from: b */
        private boolean m5032b(int i, int i2) {
            return m5031a(i) && m5031a(i2);
        }

        /* renamed from: c */
        private int m5033c() {
            int paddingTop = this.f4198c.getPaddingTop() + this.f4198c.getPaddingBottom();
            LayoutParams layoutParams = this.f4198c.getLayoutParams();
            return m5028a(this.f4198c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: d */
        private int m5034d() {
            int paddingLeft = this.f4198c.getPaddingLeft() + this.f4198c.getPaddingRight();
            LayoutParams layoutParams = this.f4198c.getLayoutParams();
            return m5028a(this.f4198c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: a */
        private int m5028a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f4197b && this.f4198c.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f4198c.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            String str = "ViewTarget";
            if (Log.isLoggable(str, 4)) {
                Log.i(str, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m5029a(this.f4198c.getContext());
        }
    }

    public ViewTarget(T t) {
        this.f4191a = (View) Preconditions.m6138a(t);
        this.f4192d = new C1606a(t);
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        m5024c();
    }

    /* renamed from: c */
    private void m5024c() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f4193e;
        if (onAttachStateChangeListener != null && !this.f4195g) {
            this.f4191a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f4195g = true;
        }
    }

    /* renamed from: d */
    private void m5025d() {
        OnAttachStateChangeListener onAttachStateChangeListener = this.f4193e;
        if (onAttachStateChangeListener != null && this.f4195g) {
            this.f4191a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f4195g = false;
        }
    }

    /* renamed from: b */
    public T mo12483b() {
        return this.f4191a;
    }

    public void getSize(SizeReadyCallback gVar) {
        this.f4192d.mo12486a(gVar);
    }

    public void removeCallback(SizeReadyCallback gVar) {
        this.f4192d.mo12488b(gVar);
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f4192d.mo12487b();
        if (!this.f4194f) {
            m5025d();
        }
    }

    public void setRequest(Request cVar) {
        mo12474a(cVar);
    }

    public Request getRequest() {
        Object e = m5026e();
        if (e == null) {
            return null;
        }
        if (e instanceof Request) {
            return (Request) e;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Target for: ");
        sb.append(this.f4191a);
        return sb.toString();
    }

    /* renamed from: a */
    private void mo12474a(Object obj) {
        Integer num = f4190c;
        if (num == null) {
            f4189b = true;
            this.f4191a.setTag(obj);
            return;
        }
        this.f4191a.setTag(num.intValue(), obj);
    }

    /* renamed from: e */
    private Object m5026e() {
        Integer num = f4190c;
        if (num == null) {
            return this.f4191a.getTag();
        }
        return this.f4191a.getTag(num.intValue());
    }
}
