package com.kwad.sdk.contentalliance.p309b;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.p003os.ParcelableCompat;
import androidx.core.p003os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.kwad.sdk.core.p319c.C4065b;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.kwad.sdk.contentalliance.b.b */
public class C3835b extends ViewGroup {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final int[] f12968a = {16842931};
    /* renamed from: ak */
    private static final C3848i f12969ak = new C3848i();
    /* renamed from: c */
    private static final Comparator<C3840b> f12970c = new Comparator<C3840b>() {
        /* renamed from: a */
        public int compare(C3840b bVar, C3840b bVar2) {
            return bVar.f13032b - bVar2.f13032b;
        }
    };
    /* renamed from: d */
    private static final Interpolator f12971d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    /* renamed from: A */
    private boolean f12972A;
    /* renamed from: B */
    private boolean f12973B;
    /* renamed from: C */
    private int f12974C = 1;
    /* renamed from: D */
    private boolean f12975D;
    /* renamed from: E */
    private boolean f12976E;
    /* renamed from: F */
    private int f12977F;
    /* renamed from: G */
    private int f12978G;
    /* renamed from: H */
    private float f12979H;
    /* renamed from: I */
    private float f12980I;
    /* renamed from: J */
    private float f12981J;
    /* renamed from: K */
    private float f12982K;
    /* renamed from: L */
    private int f12983L = -1;
    /* renamed from: M */
    private VelocityTracker f12984M;
    /* renamed from: N */
    private int f12985N;
    /* renamed from: O */
    private int f12986O;
    /* renamed from: P */
    private int f12987P;
    /* renamed from: Q */
    private int f12988Q;
    /* renamed from: R */
    private boolean f12989R;
    /* renamed from: S */
    private EdgeEffectCompat f12990S;
    /* renamed from: T */
    private EdgeEffectCompat f12991T;
    /* renamed from: U */
    private boolean f12992U = true;
    /* renamed from: V */
    private boolean f12993V = false;
    /* renamed from: W */
    private boolean f12994W;
    /* renamed from: aa */
    private int f12995aa;
    /* renamed from: ab */
    private long f12996ab;
    /* renamed from: ac */
    private List<OnPageChangeListener> f12997ac;
    /* renamed from: ad */
    private OnPageChangeListener f12998ad;
    /* renamed from: ae */
    private C3843e f12999ae;
    /* renamed from: af */
    private C3844f f13000af;
    /* renamed from: ag */
    private PageTransformer f13001ag;
    /* renamed from: ah */
    private Method f13002ah;
    /* renamed from: ai */
    private int f13003ai;
    /* renamed from: aj */
    private ArrayList<View> f13004aj;
    /* renamed from: al */
    private final Runnable f13005al = new Runnable() {
        public void run() {
            C3835b.this.setScrollState(0);
            C3835b.this.mo23288h();
            C3835b.this.mo23251a();
        }
    };
    /* renamed from: am */
    private int f13006am = 0;
    /* renamed from: b */
    private int f13007b;
    /* renamed from: e */
    protected int f13008e;
    /* renamed from: f */
    private final ArrayList<C3840b> f13009f = new ArrayList<>();
    /* renamed from: g */
    private final C3840b f13010g = new C3840b();
    /* renamed from: h */
    private final Rect f13011h = new Rect();
    /* access modifiers changed from: private */
    /* renamed from: i */
    public PagerAdapter f13012i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public int f13013j;
    /* renamed from: k */
    private int f13014k = -1;
    /* renamed from: l */
    private int f13015l = -1;
    /* renamed from: m */
    private Parcelable f13016m = null;
    /* renamed from: n */
    private ClassLoader f13017n = null;
    /* renamed from: o */
    private Scroller f13018o;
    /* renamed from: p */
    private C3845g f13019p;
    /* renamed from: q */
    private List<DataSetObserver> f13020q;
    /* renamed from: r */
    private int f13021r;
    /* renamed from: s */
    private Drawable f13022s;
    /* renamed from: t */
    private int f13023t;
    /* renamed from: u */
    private int f13024u;
    /* renamed from: v */
    private float f13025v = -3.4028235E38f;
    /* renamed from: w */
    private float f13026w = Float.MAX_VALUE;
    /* renamed from: x */
    private int f13027x;
    /* renamed from: y */
    private int f13028y;
    /* renamed from: z */
    private boolean f13029z;

    /* renamed from: com.kwad.sdk.contentalliance.b.b$a */
    interface C3839a {
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$b */
    public static class C3840b {
        /* renamed from: a */
        public Object f13031a;
        /* renamed from: b */
        public int f13032b;
        /* renamed from: c */
        boolean f13033c;
        /* renamed from: d */
        float f13034d;
        /* renamed from: e */
        float f13035e;
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$c */
    public static class C3841c extends LayoutParams {
        /* renamed from: a */
        public boolean f13036a;
        /* renamed from: b */
        public int f13037b;
        /* renamed from: c */
        float f13038c = 0.0f;
        /* renamed from: d */
        boolean f13039d;
        /* renamed from: e */
        int f13040e;
        /* renamed from: f */
        int f13041f;

        public C3841c() {
            super(-1, -1);
        }

        public C3841c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3835b.f12968a);
            this.f13037b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$d */
    class C3842d extends AccessibilityDelegateCompat {
        C3842d() {
        }

        /* renamed from: a */
        private boolean m15983a() {
            return C3835b.this.f13012i != null && C3835b.this.f13012i.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(m15983a());
            if (accessibilityEvent.getEventType() == 4096 && C3835b.this.f13012i != null) {
                obtain.setItemCount(C3835b.this.f13012i.getCount());
                obtain.setFromIndex(C3835b.this.f13013j);
                obtain.setToIndex(C3835b.this.f13013j);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m15983a());
            if (C3835b.this.mo23272d(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (C3835b.this.mo23272d(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            C3835b bVar;
            int b;
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !C3835b.this.mo23272d(-1)) {
                    return false;
                }
                bVar = C3835b.this;
                b = bVar.f13013j - 1;
            } else if (!C3835b.this.mo23272d(1)) {
                return false;
            } else {
                bVar = C3835b.this;
                b = bVar.f13013j + 1;
            }
            bVar.setCurrentItem(b);
            return true;
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$e */
    interface C3843e {
        /* renamed from: a */
        void mo23320a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$f */
    public interface C3844f {
        /* renamed from: a */
        void mo23321a();
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$g */
    private class C3845g extends DataSetObserver {
        private C3845g() {
        }

        public void onChanged() {
            C3835b.this.mo23279g();
            C3835b.this.mo23289i();
        }

        public void onInvalidated() {
            C3835b.this.mo23279g();
            C3835b.this.mo23290j();
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$h */
    public static class C3846h extends BaseSavedState {
        public static final Creator<C3846h> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<C3846h>() {
            /* renamed from: a */
            public C3846h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C3846h(parcel, classLoader);
            }

            /* renamed from: a */
            public C3846h[] newArray(int i) {
                return new C3846h[i];
            }
        });
        /* renamed from: a */
        int f13044a;
        /* renamed from: b */
        Parcelable f13045b;
        /* renamed from: c */
        ClassLoader f13046c;

        C3846h(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f13044a = parcel.readInt();
            this.f13045b = parcel.readParcelable(classLoader);
            this.f13046c = classLoader;
        }

        public C3846h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            sb.append(this.f13044a);
            sb.append("}");
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13044a);
            parcel.writeParcelable(this.f13045b, i);
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$i */
    static class C3848i implements Comparator<View> {
        C3848i() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            C3841c cVar = (C3841c) view.getLayoutParams();
            C3841c cVar2 = (C3841c) view2.getLayoutParams();
            if (cVar.f13036a == cVar2.f13036a) {
                return cVar.f13040e - cVar2.f13040e;
            }
            return cVar.f13036a ? 1 : -1;
        }
    }

    public C3835b(Context context) {
        super(context);
        mo23278f();
    }

    public C3835b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo23278f();
    }

    /* renamed from: a */
    private float m15930a(MotionEvent motionEvent, int i) {
        return (i == -1 || motionEvent.getPointerCount() <= i) ? motionEvent.getX() : MotionEventCompat.getX(motionEvent, i);
    }

    /* renamed from: a */
    private Rect m15931a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* renamed from: a */
    private void m15933a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f13009f.isEmpty()) {
            C3840b b = mo23265b(this.f13013j);
            int min = (int) ((b != null ? Math.min(b.f13035e, this.f13026w) : 0.0f) * ((float) ((i - getPaddingTop()) - getPaddingBottom())));
            if (min != getScrollY()) {
                mo23606a(false);
                scrollTo(getScrollX(), min);
                return;
            }
            return;
        }
        int scrollY = (int) ((((float) getScrollY()) / ((float) (((i2 - getPaddingTop()) - getPaddingBottom()) + i4))) * ((float) (((i - getPaddingTop()) - getPaddingBottom()) + i3)));
        scrollTo(getScrollX(), scrollY);
        if (!this.f13018o.isFinished()) {
            this.f13018o.startScroll(0, scrollY, 0, (int) (mo23265b(this.f13013j).f13035e * ((float) i)), this.f13018o.getDuration() - this.f13018o.timePassed());
        }
    }

    /* renamed from: a */
    private void m15934a(int i, boolean z, int i2, boolean z2, boolean z3) {
        C3840b b = mo23265b(i);
        int clientHeight = b != null ? (int) (((float) getClientHeight()) * Math.max(this.f13025v, Math.min(b.f13035e, this.f13026w))) : 0;
        if (z) {
            mo23254a(0, clientHeight, i2, z3);
            if (z2) {
                m15949f(i);
                return;
            }
            return;
        }
        if (z2) {
            m15949f(i);
        }
        mo23606a(false);
        scrollTo(0, clientHeight);
        m15951h(clientHeight);
        if (z2 && this.f13006am != 2) {
            mo23251a();
        }
    }

    /* renamed from: a */
    private void mo23615a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f12983L) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f12980I = m15940b(motionEvent, i);
            this.f12983L = MotionEventCompat.getPointerId(motionEvent, i);
            VelocityTracker velocityTracker = this.f12984M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: a */
    private void m15936a(C3840b bVar, int i, C3840b bVar2) {
        C3840b bVar3;
        C3840b bVar4;
        int count = this.f13012i.getCount();
        int clientHeight = getClientHeight();
        float f = clientHeight > 0 ? ((float) this.f13021r) / ((float) clientHeight) : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.f13032b;
            if (i2 < bVar.f13032b) {
                float f2 = bVar2.f13035e + bVar2.f13034d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.f13032b && i4 < this.f13009f.size()) {
                    while (true) {
                        bVar4 = (C3840b) this.f13009f.get(i4);
                        if (i3 > bVar4.f13032b && i4 < this.f13009f.size() - 1) {
                            i4++;
                        }
                    }
                    while (i3 < bVar4.f13032b) {
                        f2 += this.f13012i.getPageWidth(i3) + f;
                        i3++;
                    }
                    bVar4.f13035e = f2;
                    f2 += bVar4.f13034d + f;
                    i3++;
                }
            } else if (i2 > bVar.f13032b) {
                int size = this.f13009f.size() - 1;
                float f3 = bVar2.f13035e;
                while (true) {
                    i2--;
                    if (i2 < bVar.f13032b || size < 0) {
                        break;
                    }
                    while (true) {
                        bVar3 = (C3840b) this.f13009f.get(size);
                        if (i2 < bVar3.f13032b && size > 0) {
                            size--;
                        }
                    }
                    while (i2 > bVar3.f13032b) {
                        f3 -= this.f13012i.getPageWidth(i2) + f;
                        i2--;
                    }
                    f3 -= bVar3.f13034d + f;
                    bVar3.f13035e = f3;
                }
            }
        }
        int size2 = this.f13009f.size();
        float f4 = bVar.f13035e;
        int i5 = bVar.f13032b - 1;
        this.f13025v = bVar.f13032b == 0 ? bVar.f13035e : -3.4028235E38f;
        int i6 = count - 1;
        this.f13026w = bVar.f13032b == i6 ? (bVar.f13035e + bVar.f13034d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            C3840b bVar5 = (C3840b) this.f13009f.get(i7);
            while (i5 > bVar5.f13032b) {
                f4 -= this.f13012i.getPageWidth(i5) + f;
                i5--;
            }
            f4 -= bVar5.f13034d + f;
            bVar5.f13035e = f4;
            if (bVar5.f13032b == 0) {
                this.f13025v = f4;
            }
            i7--;
            i5--;
        }
        float f5 = bVar.f13035e + bVar.f13034d + f;
        int i8 = bVar.f13032b + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            C3840b bVar6 = (C3840b) this.f13009f.get(i9);
            while (i8 < bVar6.f13032b) {
                f5 += this.f13012i.getPageWidth(i8) + f;
                i8++;
            }
            if (bVar6.f13032b == i6) {
                this.f13026w = (bVar6.f13034d + f5) - 1.0f;
            }
            bVar6.f13035e = f5;
            f5 += bVar6.f13034d + f;
            i9++;
            i8++;
        }
        this.f12993V = false;
    }

    /* renamed from: a */
    private void mo23606a(boolean z) {
        boolean z2 = this.f13006am == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f13018o.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f13018o.getCurrX();
            int currY = this.f13018o.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.f12973B = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f13009f.size(); i++) {
            C3840b bVar = (C3840b) this.f13009f.get(i);
            if (bVar.f13033c) {
                bVar.f13033c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f13005al);
        } else {
            this.f13005al.run();
        }
    }

    /* renamed from: a */
    private boolean m15939a(float f, float f2) {
        return (f < ((float) this.f12978G) && f2 > 0.0f) || (f > ((float) (getHeight() - this.f12978G)) && f2 < 0.0f);
    }

    /* renamed from: b */
    private float m15940b(MotionEvent motionEvent, int i) {
        return (i == -1 || motionEvent.getPointerCount() <= i) ? motionEvent.getY() : MotionEventCompat.getY(motionEvent, i);
    }

    /* renamed from: b */
    private void mo23617b() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C3841c) getChildAt(i).getLayoutParams()).f13036a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m15943b(int i, float f, int i2) {
        List<OnPageChangeListener> list = this.f12997ac;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f12997ac.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener2 = this.f12998ad;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: b */
    private void m15944b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    /* renamed from: c */
    private void mo23619c() {
        if (this.f13003ai != 0) {
            ArrayList<View> arrayList = this.f13004aj;
            if (arrayList == null) {
                this.f13004aj = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f13004aj.add(getChildAt(i));
            }
            Collections.sort(this.f13004aj, f12969ak);
        }
    }

    /* renamed from: c */
    private void m15946c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: d */
    private C3840b mo23620d() {
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? ((float) getScrollY()) / ((float) clientHeight) : 0.0f;
        float f = clientHeight > 0 ? ((float) this.f13021r) / ((float) clientHeight) : 0.0f;
        C3840b bVar = null;
        int i = 0;
        boolean z = true;
        int i2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i < this.f13009f.size()) {
            C3840b bVar2 = (C3840b) this.f13009f.get(i);
            if (!z) {
                int i3 = i2 + 1;
                if (bVar2.f13032b != i3) {
                    bVar2 = this.f13010g;
                    bVar2.f13035e = f2 + f3 + f;
                    bVar2.f13032b = i3;
                    bVar2.f13034d = this.f13012i.getPageWidth(bVar2.f13032b);
                    i--;
                }
            }
            f2 = bVar2.f13035e;
            float f4 = bVar2.f13034d + f2 + f;
            if (!z && scrollY < f2) {
                return bVar;
            }
            if (scrollY < f4 || i == this.f13009f.size() - 1) {
                return bVar2;
            }
            i2 = bVar2.f13032b;
            f3 = bVar2.f13034d;
            i++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    /* renamed from: e */
    private void mo23608e() {
        this.f12975D = false;
        this.f12976E = false;
        VelocityTracker velocityTracker = this.f12984M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f12984M = null;
        }
    }

    /* renamed from: f */
    private void m15949f(int i) {
        List<OnPageChangeListener> list = this.f12997ac;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f12997ac.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener2 = this.f12998ad;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageSelected(i);
        }
    }

    /* renamed from: g */
    private void m15950g(int i) {
        List<OnPageChangeListener> list = this.f12997ac;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f12997ac.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener2 = this.f12998ad;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* renamed from: h */
    private boolean m15951h(int i) {
        String str = "onPageScrolled did not call superclass implementation";
        if (this.f13009f.size() == 0) {
            this.f12994W = false;
            mo23253a(0, 0.0f, 0);
            if (this.f12994W) {
                return false;
            }
            throw new IllegalStateException(str);
        }
        C3840b d = mo23620d();
        int clientHeight = getClientHeight();
        int i2 = this.f13021r;
        int i3 = clientHeight + i2;
        float f = (float) clientHeight;
        float f2 = ((float) i2) / f;
        int i4 = d.f13032b;
        float f3 = ((((float) i) / f) - d.f13035e) / (d.f13034d + f2);
        int i5 = (int) (((float) i3) * f3);
        this.f12994W = false;
        mo23253a(i4, f3, i5);
        if (this.f12994W) {
            return true;
        }
        throw new IllegalStateException(str);
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f13006am != i) {
            this.f13006am = i;
            if (this.f13001ag != null) {
                m15944b(i != 0);
            }
            m15950g(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f12972A != z) {
            this.f12972A = z;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public float mo23247a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo23248a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f12987P || Math.abs(i2) <= this.f12985N) {
            i = (int) (((float) i) + f + (i >= this.f13013j ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f13009f.size() <= 0) {
            return i;
        }
        C3840b bVar = (C3840b) this.f13009f.get(0);
        ArrayList<C3840b> arrayList = this.f13009f;
        return Math.max(bVar.f13032b, Math.min(i, ((C3840b) arrayList.get(arrayList.size() - 1)).f13032b));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3840b mo23249a(int i, int i2) {
        C3840b bVar = new C3840b();
        bVar.f13032b = i;
        bVar.f13031a = this.f13012i.instantiateItem((ViewGroup) this, i);
        bVar.f13034d = this.f13012i.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f13009f.size()) {
            this.f13009f.add(bVar);
        } else {
            this.f13009f.add(i2, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3840b mo23250a(View view) {
        for (int i = 0; i < this.f13009f.size(); i++) {
            C3840b bVar = (C3840b) this.f13009f.get(i);
            if (this.f13012i.isViewFromObject(view, bVar.f13031a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23251a() {
        C3844f fVar = this.f13000af;
        if (fVar != null) {
            fVar.mo23321a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
            if (r10.f13032b == r0.f13013j) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d0, code lost:
            if (r15 >= 0) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00de, code lost:
            if (r15 >= 0) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ec, code lost:
            if (r15 >= 0) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f7, code lost:
            r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014c, code lost:
            if (r3 < r0.f13009f.size()) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0157, code lost:
            r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x016a, code lost:
            if (r3 < r0.f13009f.size()) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x017c, code lost:
            if (r3 < r0.f13009f.size()) goto L_0x014e;
     */
    /* renamed from: a */
    public void mo23252a(int r18) {
        /*
        r17 = this;
        r0 = r17
        r1 = r18
        int r2 = r0.f13013j
        if (r2 == r1) goto L_0x0018
        if (r2 >= r1) goto L_0x000d
        r2 = 130(0x82, float:1.82E-43)
        goto L_0x000f
    L_0x000d:
        r2 = 33
    L_0x000f:
        int r4 = r0.f13013j
        com.kwad.sdk.contentalliance.b.b$b r4 = r0.mo23265b(r4)
        r0.f13013j = r1
        goto L_0x001a
    L_0x0018:
        r2 = 2
        r4 = 0
    L_0x001a:
        androidx.viewpager.widget.PagerAdapter r1 = r0.f13012i
        if (r1 != 0) goto L_0x0022
        r17.mo23619c()
        return
    L_0x0022:
        boolean r1 = r0.f12973B
        if (r1 == 0) goto L_0x002a
        r17.mo23619c()
        return
    L_0x002a:
        android.os.IBinder r1 = r17.getWindowToken()
        if (r1 != 0) goto L_0x0031
        return
    L_0x0031:
        androidx.viewpager.widget.PagerAdapter r1 = r0.f13012i
        r1.startUpdate(r0)
        int r1 = r0.f12974C
        int r5 = r0.f13013j
        int r5 = r5 - r1
        r6 = 0
        int r5 = java.lang.Math.max(r6, r5)
        androidx.viewpager.widget.PagerAdapter r7 = r0.f13012i
        int r7 = r7.getCount()
        int r8 = r7 + -1
        int r9 = r0.f13013j
        int r9 = r9 + r1
        int r8 = java.lang.Math.min(r8, r9)
        int r9 = r0.f13007b
        if (r7 != r9) goto L_0x0205
        r9 = 0
    L_0x0054:
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r10 = r0.f13009f
        int r10 = r10.size()
        if (r9 >= r10) goto L_0x0074
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r10 = r0.f13009f
        java.lang.Object r10 = r10.get(r9)
        com.kwad.sdk.contentalliance.b.b$b r10 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3840b) r10
        int r11 = r10.f13032b
        int r12 = r0.f13013j
        if (r11 < r12) goto L_0x0071
        int r11 = r10.f13032b
        int r12 = r0.f13013j
        if (r11 != r12) goto L_0x0074
        goto L_0x0075
    L_0x0071:
        int r9 = r9 + 1
        goto L_0x0054
    L_0x0074:
        r10 = 0
    L_0x0075:
        if (r10 != 0) goto L_0x007f
        if (r7 <= 0) goto L_0x007f
        int r10 = r0.f13013j
        com.kwad.sdk.contentalliance.b.b$b r10 = r0.mo23249a(r10, r9)
    L_0x007f:
        if (r10 == 0) goto L_0x0183
        if (r1 <= 0) goto L_0x0183
        int r1 = r9 + -1
        if (r1 < 0) goto L_0x0090
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r12 = r0.f13009f
        java.lang.Object r12 = r12.get(r1)
        com.kwad.sdk.contentalliance.b.b$b r12 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3840b) r12
        goto L_0x0091
    L_0x0090:
        r12 = 0
    L_0x0091:
        int r13 = r17.getClientHeight()
        r14 = 1073741824(0x40000000, float:2.0)
        if (r13 > 0) goto L_0x009b
        r3 = 0
        goto L_0x00a7
    L_0x009b:
        float r15 = r10.f13034d
        float r15 = r14 - r15
        int r3 = r17.getPaddingLeft()
        float r3 = (float) r3
        float r6 = (float) r13
        float r3 = r3 / r6
        float r3 = r3 + r15
    L_0x00a7:
        int r6 = r0.f13013j
        int r6 = r6 + -1
        r15 = r1
        r1 = 0
    L_0x00ad:
        if (r6 < 0) goto L_0x00fc
        int r16 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
        if (r16 < 0) goto L_0x00d3
        if (r6 >= r5) goto L_0x00d3
        if (r12 != 0) goto L_0x00b8
        goto L_0x00fc
    L_0x00b8:
        int r11 = r12.f13032b
        if (r6 != r11) goto L_0x00f9
        boolean r11 = r12.f13033c
        if (r11 != 0) goto L_0x00f9
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r11 = r0.f13009f
        r11.remove(r15)
        androidx.viewpager.widget.PagerAdapter r11 = r0.f13012i
        java.lang.Object r12 = r12.f13031a
        r11.destroyItem(r0, r6, r12)
        int r15 = r15 + -1
        int r9 = r9 + -1
        if (r15 < 0) goto L_0x00f7
        goto L_0x00ee
    L_0x00d3:
        if (r12 == 0) goto L_0x00e1
        int r11 = r12.f13032b
        if (r6 != r11) goto L_0x00e1
        float r11 = r12.f13034d
        float r1 = r1 + r11
        int r15 = r15 + -1
        if (r15 < 0) goto L_0x00f7
        goto L_0x00ee
    L_0x00e1:
        int r11 = r15 + 1
        com.kwad.sdk.contentalliance.b.b$b r11 = r0.mo23249a(r6, r11)
        float r11 = r11.f13034d
        float r1 = r1 + r11
        int r9 = r9 + 1
        if (r15 < 0) goto L_0x00f7
    L_0x00ee:
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r11 = r0.f13009f
        java.lang.Object r11 = r11.get(r15)
        com.kwad.sdk.contentalliance.b.b$b r11 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3840b) r11
        goto L_0x00f8
    L_0x00f7:
        r11 = 0
    L_0x00f8:
        r12 = r11
    L_0x00f9:
        int r6 = r6 + -1
        goto L_0x00ad
    L_0x00fc:
        float r1 = r10.f13034d
        int r3 = r9 + 1
        int r5 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
        if (r5 >= 0) goto L_0x0180
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        int r5 = r5.size()
        if (r3 >= r5) goto L_0x0115
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        java.lang.Object r5 = r5.get(r3)
        com.kwad.sdk.contentalliance.b.b$b r5 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3840b) r5
        goto L_0x0116
    L_0x0115:
        r5 = 0
    L_0x0116:
        if (r13 > 0) goto L_0x011a
        r11 = 0
        goto L_0x0123
    L_0x011a:
        int r6 = r17.getPaddingRight()
        float r6 = (float) r6
        float r11 = (float) r13
        float r6 = r6 / r11
        float r11 = r6 + r14
    L_0x0123:
        int r6 = r0.f13013j
    L_0x0125:
        int r6 = r6 + 1
        if (r6 >= r7) goto L_0x0180
        int r12 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
        if (r12 < 0) goto L_0x0159
        if (r6 <= r8) goto L_0x0159
        if (r5 != 0) goto L_0x0132
        goto L_0x0180
    L_0x0132:
        int r12 = r5.f13032b
        if (r6 != r12) goto L_0x017f
        boolean r12 = r5.f13033c
        if (r12 != 0) goto L_0x017f
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r12 = r0.f13009f
        r12.remove(r3)
        androidx.viewpager.widget.PagerAdapter r12 = r0.f13012i
        java.lang.Object r5 = r5.f13031a
        r12.destroyItem(r0, r6, r5)
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        int r5 = r5.size()
        if (r3 >= r5) goto L_0x0157
    L_0x014e:
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        java.lang.Object r5 = r5.get(r3)
        com.kwad.sdk.contentalliance.b.b$b r5 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3840b) r5
        goto L_0x017f
    L_0x0157:
        r5 = 0
        goto L_0x017f
    L_0x0159:
        if (r5 == 0) goto L_0x016d
        int r12 = r5.f13032b
        if (r6 != r12) goto L_0x016d
        float r5 = r5.f13034d
        float r1 = r1 + r5
        int r3 = r3 + 1
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        int r5 = r5.size()
        if (r3 >= r5) goto L_0x0157
        goto L_0x014e
    L_0x016d:
        com.kwad.sdk.contentalliance.b.b$b r5 = r0.mo23249a(r6, r3)
        int r3 = r3 + 1
        float r5 = r5.f13034d
        float r1 = r1 + r5
        java.util.ArrayList<com.kwad.sdk.contentalliance.b.b$b> r5 = r0.f13009f
        int r5 = r5.size()
        if (r3 >= r5) goto L_0x0157
        goto L_0x014e
    L_0x017f:
        goto L_0x0125
    L_0x0180:
        r0.m15936a(r10, r9, r4)
    L_0x0183:
        androidx.viewpager.widget.PagerAdapter r1 = r0.f13012i
        int r3 = r0.f13013j
        if (r10 == 0) goto L_0x018c
        java.lang.Object r4 = r10.f13031a
        goto L_0x018d
    L_0x018c:
        r4 = 0
    L_0x018d:
        r1.setPrimaryItem(r0, r3, r4)
        androidx.viewpager.widget.PagerAdapter r1 = r0.f13012i
        r1.finishUpdate(r0)
        int r1 = r17.getChildCount()
        r3 = 0
    L_0x019a:
        if (r3 >= r1) goto L_0x01c6
        android.view.View r4 = r0.getChildAt(r3)
        android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
        com.kwad.sdk.contentalliance.b.b$c r5 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3841c) r5
        r5.f13041f = r3
        boolean r6 = r5.f13036a
        if (r6 != 0) goto L_0x01c2
        float r6 = r5.f13038c
        r7 = 0
        int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
        if (r6 != 0) goto L_0x01c3
        com.kwad.sdk.contentalliance.b.b$b r4 = r0.mo23250a(r4)
        if (r4 == 0) goto L_0x01c3
        float r6 = r4.f13034d
        r5.f13038c = r6
        int r4 = r4.f13032b
        r5.f13040e = r4
        goto L_0x01c3
    L_0x01c2:
        r7 = 0
    L_0x01c3:
        int r3 = r3 + 1
        goto L_0x019a
    L_0x01c6:
        r17.mo23619c()
        boolean r1 = r17.hasFocus()
        if (r1 == 0) goto L_0x0204
        android.view.View r1 = r17.findFocus()
        if (r1 == 0) goto L_0x01da
        com.kwad.sdk.contentalliance.b.b$b r3 = r0.mo23266b(r1)
        goto L_0x01db
    L_0x01da:
        r3 = 0
    L_0x01db:
        if (r3 == 0) goto L_0x01e3
        int r1 = r3.f13032b
        int r3 = r0.f13013j
        if (r1 == r3) goto L_0x0204
    L_0x01e3:
        r1 = 0
    L_0x01e4:
        int r3 = r17.getChildCount()
        if (r1 >= r3) goto L_0x0204
        android.view.View r3 = r0.getChildAt(r1)
        com.kwad.sdk.contentalliance.b.b$b r4 = r0.mo23250a(r3)
        if (r4 == 0) goto L_0x0201
        int r4 = r4.f13032b
        int r5 = r0.f13013j
        if (r4 != r5) goto L_0x0201
        boolean r3 = r3.requestFocus(r2)
        if (r3 == 0) goto L_0x0201
        goto L_0x0204
    L_0x0201:
        int r1 = r1 + 1
        goto L_0x01e4
    L_0x0204:
        return
    L_0x0205:
        android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x0212 }
        int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x0212 }
        java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0212 }
        goto L_0x021a
    L_0x0212:
        int r1 = r17.getId()
        java.lang.String r1 = java.lang.Integer.toHexString(r1)
    L_0x021a:
        java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
        r3.append(r4)
        int r4 = r0.f13007b
        r3.append(r4)
        java.lang.String r4 = ", found: "
        r3.append(r4)
        r3.append(r7)
        java.lang.String r4 = " Pager id: "
        r3.append(r4)
        r3.append(r1)
        java.lang.String r1 = " Pager class: "
        r3.append(r1)
        java.lang.Class r1 = r17.getClass()
        r3.append(r1)
        java.lang.String r1 = " Problematic adapter: "
        r3.append(r1)
        androidx.viewpager.widget.PagerAdapter r1 = r0.f13012i
        java.lang.Class r1 = r1.getClass()
        r3.append(r1)
        java.lang.String r1 = r3.toString()
        r2.<init>(r1)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.p309b.C3835b.mo23252a(int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* renamed from: a */
    public void mo23253a(int r12, float r13, int r14) {
        /*
        r11 = this;
        int r0 = r11.f12995aa
        r1 = 0
        if (r0 <= 0) goto L_0x0070
        int r0 = r11.getScrollY()
        int r2 = r11.getPaddingTop()
        int r3 = r11.getPaddingBottom()
        int r4 = r11.getHeight()
        int r5 = r11.getChildCount()
        r6 = r3
        r3 = r2
        r2 = 0
    L_0x001c:
        if (r2 >= r5) goto L_0x0070
        android.view.View r7 = r11.getChildAt(r2)
        android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
        com.kwad.sdk.contentalliance.b.b$c r8 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3841c) r8
        boolean r9 = r8.f13036a
        if (r9 != 0) goto L_0x002d
        goto L_0x006d
    L_0x002d:
        int r8 = r8.f13037b
        r8 = r8 & 112(0x70, float:1.57E-43)
        r9 = 16
        if (r8 == r9) goto L_0x0052
        r9 = 48
        if (r8 == r9) goto L_0x004c
        r9 = 80
        if (r8 == r9) goto L_0x003f
        r8 = r3
        goto L_0x0061
    L_0x003f:
        int r8 = r4 - r6
        int r9 = r7.getMeasuredHeight()
        int r8 = r8 - r9
        int r9 = r7.getMeasuredHeight()
        int r6 = r6 + r9
        goto L_0x005e
    L_0x004c:
        int r8 = r7.getHeight()
        int r8 = r8 + r3
        goto L_0x0061
    L_0x0052:
        int r8 = r7.getMeasuredHeight()
        int r8 = r4 - r8
        int r8 = r8 / 2
        int r8 = java.lang.Math.max(r8, r3)
    L_0x005e:
        r10 = r8
        r8 = r3
        r3 = r10
    L_0x0061:
        int r3 = r3 + r0
        int r9 = r7.getTop()
        int r3 = r3 - r9
        if (r3 == 0) goto L_0x006c
        r7.offsetTopAndBottom(r3)
    L_0x006c:
        r3 = r8
    L_0x006d:
        int r2 = r2 + 1
        goto L_0x001c
    L_0x0070:
        r11.m15943b(r12, r13, r14)
        androidx.viewpager.widget.ViewPager$PageTransformer r12 = r11.f13001ag
        if (r12 == 0) goto L_0x00a4
        int r12 = r11.getScrollY()
        int r13 = r11.getChildCount()
    L_0x007f:
        if (r1 >= r13) goto L_0x00a4
        android.view.View r14 = r11.getChildAt(r1)
        android.view.ViewGroup$LayoutParams r0 = r14.getLayoutParams()
        com.kwad.sdk.contentalliance.b.b$c r0 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3841c) r0
        boolean r0 = r0.f13036a
        if (r0 == 0) goto L_0x0090
        goto L_0x00a1
    L_0x0090:
        int r0 = r14.getTop()
        int r0 = r0 - r12
        float r0 = (float) r0
        int r2 = r11.getClientHeight()
        float r2 = (float) r2
        float r0 = r0 / r2
        androidx.viewpager.widget.ViewPager$PageTransformer r2 = r11.f13001ag
        r2.transformPage(r14, r0)
    L_0x00a1:
        int r1 = r1 + 1
        goto L_0x007f
    L_0x00a4:
        r12 = 1
        r11.f12994W = r12
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.p309b.C3835b.mo23253a(int, float, int):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23254a(int i, int i2, int i3, boolean z) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            mo23606a(false);
            mo23288h();
            if (z) {
                mo23251a();
            }
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i7 = clientHeight / 2;
        float f = (float) clientHeight;
        float f2 = (float) i7;
        float a = f2 + (mo23247a(Math.min(1.0f, (((float) Math.abs(i6)) * 1.0f) / f)) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = ((int) (((((float) Math.abs(i6)) / ((f * this.f13012i.getPageWidth(this.f13013j)) + ((float) this.f13021r))) + 1.0f) * 100.0f)) * 2;
        }
        this.f13018o.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, OtherError.CONTAINER_INVISIBLE_ERROR));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: a */
    public void mo23255a(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setCurrentItem item=");
        sb.append(i);
        sb.append(" smoothScroll=");
        sb.append(z);
        C4065b.m16867b("VerticalViewPager", sb.toString());
        this.f12973B = false;
        mo23256a(i, z, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23256a(int i, boolean z, boolean z2) {
        mo23257a(i, z, z2, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23257a(int i, boolean z, boolean z2, int i2) {
        mo23258a(i, z, z2, i2, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23258a(int i, boolean z, boolean z2, int i2, boolean z3) {
        int i3;
        PagerAdapter pagerAdapter = this.f13012i;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f13013j != i || this.f13009f.size() == 0) {
            if (i < 0) {
                i3 = 0;
            } else {
                if (i >= this.f13012i.getCount()) {
                    i = this.f13012i.getCount() - 1;
                }
                i3 = i;
            }
            int i4 = this.f12974C;
            int i5 = this.f13013j;
            if (i3 > i5 + i4 || i3 < i5 - i4) {
                for (int i6 = 0; i6 < this.f13009f.size(); i6++) {
                    ((C3840b) this.f13009f.get(i6)).f13033c = true;
                }
            }
            boolean z4 = this.f13013j != i3;
            if (this.f12992U) {
                this.f13013j = i3;
                if (z4) {
                    m15949f(i3);
                }
                requestLayout();
            } else {
                mo23252a(i3);
                m15934a(i3, z, i2, z4, z3);
            }
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* renamed from: a */
    public void mo23259a(OnPageChangeListener onPageChangeListener) {
        if (this.f12997ac == null) {
            this.f12997ac = new ArrayList();
        }
        this.f12997ac.add(onPageChangeListener);
    }

    /* renamed from: a */
    public boolean mo23260a(KeyEvent keyEvent) {
        int i;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                i = 17;
            } else if (keyCode == 22) {
                i = 66;
            } else if (keyCode == 61 && VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    i = 2;
                } else if (keyEvent.hasModifiers(1)) {
                    return mo23277e(1);
                }
            }
            return mo23277e(i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo23261a(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        boolean z2 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.isEnabled() && childAt.getVisibility() == 0) {
                    int i4 = i3 + scrollY;
                    if (i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                        int i5 = i2 + scrollX;
                        if (i5 >= childAt.getLeft() && i5 < childAt.getRight()) {
                            if (mo23261a(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollVertically(view, -i)) {
            z2 = false;
        }
        return z2;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C3840b a = mo23250a(childAt);
                    if (a != null && a.f13032b == this.f13013j) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C3840b a = mo23250a(childAt);
                if (a != null && a.f13032b == this.f13013j) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C3841c cVar = (C3841c) layoutParams;
        cVar.f13036a |= view instanceof C3839a;
        if (!this.f13029z) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            super.addView(view, i, layoutParams);
        } else if (cVar == null || !cVar.f13036a) {
            cVar.f13039d = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3840b mo23265b(int i) {
        for (int i2 = 0; i2 < this.f13009f.size(); i2++) {
            C3840b bVar = (C3840b) this.f13009f.get(i2);
            if (bVar.f13032b == i) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3840b mo23266b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo23250a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = (View) parent;
            }
        }
        return null;
    }

    /* renamed from: b */
    public void mo23267b(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.f12997ac;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo23268b(float f) {
        boolean z;
        float f2 = this.f12980I - f;
        this.f12980I = f;
        float scrollY = ((float) getScrollY()) + f2;
        float clientHeight = (float) getClientHeight();
        float f3 = this.f13025v * clientHeight;
        float f4 = this.f13026w * clientHeight;
        boolean z2 = true;
        boolean z3 = false;
        if (this.f13009f.size() > 0) {
            C3840b bVar = (C3840b) this.f13009f.get(0);
            ArrayList<C3840b> arrayList = this.f13009f;
            C3840b bVar2 = (C3840b) arrayList.get(arrayList.size() - 1);
            if (bVar.f13032b != 0) {
                f3 = bVar.f13035e * clientHeight;
                z = false;
            } else {
                z = true;
            }
            if (bVar2.f13032b != this.f13012i.getCount() - 1) {
                f4 = bVar2.f13035e * clientHeight;
                z2 = false;
            }
        } else {
            z = true;
        }
        if (scrollY < f3) {
            if (z) {
                z3 = this.f12990S.onPull(Math.abs(f3 - scrollY) / clientHeight);
            }
            scrollY = f3;
        } else if (scrollY > f4) {
            if (z2) {
                z3 = this.f12991T.onPull(Math.abs(scrollY - f4) / clientHeight);
            }
            scrollY = f4;
        }
        int i = (int) scrollY;
        this.f12979H += scrollY - ((float) i);
        int c = mo23269c(i);
        scrollTo(getScrollX(), c);
        m15951h(mo23269c(c));
        return z3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo23269c(int i) {
        return i;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C3841c) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (this.f13018o.isFinished() || !this.f13018o.computeScrollOffset()) {
            mo23606a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f13018o.getCurrX();
        int currY = this.f13018o.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m15951h(currY)) {
                this.f13018o.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* renamed from: d */
    public boolean mo23272d(int i) {
        boolean z = false;
        if (this.f13012i == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            if (scrollY > ((int) (((float) clientHeight) * this.f13025v))) {
                z = true;
            }
            return z;
        }
        if (i > 0 && scrollY < ((int) (((float) clientHeight) * this.f13026w))) {
            z = true;
        }
        return z;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo23260a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C3840b a = mo23250a(childAt);
                if (a != null && a.f13032b == this.f13013j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
            if (r0.getCount() > 1) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public void draw(android.graphics.Canvas r8) {
        /*
        r7 = this;
        super.draw(r8)
        int r0 = androidx.core.view.ViewCompat.getOverScrollMode(r7)
        r1 = 0
        if (r0 == 0) goto L_0x0024
        r2 = 1
        if (r0 != r2) goto L_0x0018
        androidx.viewpager.widget.PagerAdapter r0 = r7.f13012i
        if (r0 == 0) goto L_0x0018
        int r0 = r0.getCount()
        if (r0 <= r2) goto L_0x0018
        goto L_0x0024
    L_0x0018:
        androidx.core.widget.EdgeEffectCompat r8 = r7.f12990S
        r8.finish()
        androidx.core.widget.EdgeEffectCompat r8 = r7.f12991T
        r8.finish()
        goto L_0x00a3
    L_0x0024:
        androidx.core.widget.EdgeEffectCompat r0 = r7.f12990S
        boolean r0 = r0.isFinished()
        if (r0 != 0) goto L_0x005e
        int r0 = r8.save()
        int r2 = r7.getHeight()
        int r3 = r7.getWidth()
        int r4 = r7.getPaddingLeft()
        int r3 = r3 - r4
        int r4 = r7.getPaddingRight()
        int r3 = r3 - r4
        int r4 = r7.getPaddingLeft()
        float r4 = (float) r4
        float r5 = r7.f13025v
        float r6 = (float) r2
        float r5 = r5 * r6
        r8.translate(r4, r5)
        androidx.core.widget.EdgeEffectCompat r4 = r7.f12990S
        r4.setSize(r3, r2)
        androidx.core.widget.EdgeEffectCompat r2 = r7.f12990S
        boolean r2 = r2.draw(r8)
        r1 = r1 | r2
        r8.restoreToCount(r0)
    L_0x005e:
        androidx.core.widget.EdgeEffectCompat r0 = r7.f12991T
        boolean r0 = r0.isFinished()
        if (r0 != 0) goto L_0x00a3
        int r0 = r8.save()
        int r2 = r7.getHeight()
        int r3 = r7.getWidth()
        int r4 = r7.getPaddingLeft()
        int r3 = r3 - r4
        int r4 = r7.getPaddingRight()
        int r3 = r3 - r4
        r4 = 1127481344(0x43340000, float:180.0)
        r8.rotate(r4)
        int r4 = -r3
        int r5 = r7.getPaddingLeft()
        int r4 = r4 - r5
        float r4 = (float) r4
        float r5 = r7.f13026w
        r6 = 1065353216(0x3f800000, float:1.0)
        float r5 = r5 + r6
        float r5 = -r5
        float r6 = (float) r2
        float r5 = r5 * r6
        r8.translate(r4, r5)
        androidx.core.widget.EdgeEffectCompat r4 = r7.f12991T
        r4.setSize(r3, r2)
        androidx.core.widget.EdgeEffectCompat r2 = r7.f12991T
        boolean r2 = r2.draw(r8)
        r1 = r1 | r2
        r8.restoreToCount(r0)
    L_0x00a3:
        if (r1 == 0) goto L_0x00a8
        androidx.core.view.ViewCompat.postInvalidateOnAnimation(r7)
    L_0x00a8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.p309b.C3835b.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f13022s;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: e */
    public boolean mo23277e(int i) {
        boolean l;
        boolean z;
        View findFocus = findFocus();
        boolean z2 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    sb2.append(sb.toString());
                    C4065b.m16863a("VerticalViewPager", sb2.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 33) {
                int i2 = m15931a(this.f13011h, findNextFocus).top;
                int i3 = m15931a(this.f13011h, view).top;
                if (view != null && i2 >= i3) {
                    l = mo23291k();
                    z2 = l;
                }
            } else if (i == 130) {
                int i4 = m15931a(this.f13011h, findNextFocus).bottom;
                int i5 = m15931a(this.f13011h, view).bottom;
                if (view != null && i4 <= i5) {
                    l = mo23292l();
                    z2 = l;
                }
            }
            l = findNextFocus.requestFocus();
            z2 = l;
        } else if (i == 33 || i == 1) {
            z2 = mo23291k();
        } else if (i == 130 || i == 2) {
            z2 = mo23292l();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo23278f() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f13018o = new Scroller(context, f12971d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f13008e = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f12985N = (int) (400.0f * f);
        this.f12986O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f12990S = new EdgeEffectCompat(context);
        this.f12991T = new EdgeEffectCompat(context);
        this.f12987P = (int) (25.0f * f);
        this.f12988Q = (int) (2.0f * f);
        this.f12977F = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new C3842d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo23279g() {
        int count = this.f13012i.getCount();
        this.f13007b = count;
        boolean z = this.f13009f.size() < (this.f12974C * 2) + 1 && this.f13009f.size() < count;
        boolean z2 = z;
        int i = this.f13013j;
        int i2 = 0;
        boolean z3 = false;
        while (i2 < this.f13009f.size()) {
            C3840b bVar = (C3840b) this.f13009f.get(i2);
            int itemPosition = this.f13012i.getItemPosition(bVar);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f13009f.remove(i2);
                    i2--;
                    if (!z3) {
                        this.f13012i.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.f13012i.destroyItem((ViewGroup) this, bVar.f13032b, bVar.f13031a);
                    if (this.f13013j == bVar.f13032b) {
                        i = Math.max(0, Math.min(this.f13013j, count - 1));
                    }
                } else if (bVar.f13032b != itemPosition) {
                    if (bVar.f13032b == this.f13013j) {
                        i = itemPosition;
                    }
                    bVar.f13032b = itemPosition;
                }
                z2 = true;
            }
            i2++;
        }
        if (z3) {
            this.f13012i.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f13009f, f12970c);
        if (z2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                C3841c cVar = (C3841c) getChildAt(i3).getLayoutParams();
                if (!cVar.f13036a) {
                    cVar.f13038c = 0.0f;
                }
            }
            mo23256a(i, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new C3841c();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C3841c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f13012i;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f13003ai == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C3841c) ((View) this.f13004aj.get(i2)).getLayoutParams()).f13041f;
    }

    public int getCurrentItem() {
        return this.f13013j;
    }

    public int getOffscreenPageLimit() {
        return this.f12974C;
    }

    public int getPageMargin() {
        return this.f13021r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo23288h() {
        mo23252a(this.f13013j);
    }

    /* renamed from: i */
    public void mo23289i() {
        List<DataSetObserver> list = this.f13020q;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                DataSetObserver dataSetObserver = (DataSetObserver) this.f13020q.get(i);
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            }
        }
    }

    /* renamed from: j */
    public void mo23290j() {
        List<DataSetObserver> list = this.f13020q;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                DataSetObserver dataSetObserver = (DataSetObserver) this.f13020q.get(i);
                if (dataSetObserver != null) {
                    dataSetObserver.onInvalidated();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo23291k() {
        int i = this.f13013j;
        if (i <= 0) {
            return false;
        }
        mo23255a(i - 1, true);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo23292l() {
        PagerAdapter pagerAdapter = this.f13012i;
        if (pagerAdapter == null || this.f13013j >= pagerAdapter.getCount() - 1) {
            return false;
        }
        mo23255a(this.f13013j + 1, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12992U = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        C4065b.m16867b("VerticalViewPager", "onDetachedFromWindow");
        removeCallbacks(this.f13005al);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f13021r > 0 && this.f13022s != null && this.f13009f.size() > 0 && this.f13012i != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f4 = (float) height;
            float f5 = ((float) this.f13021r) / f4;
            int i = 0;
            C3840b bVar = (C3840b) this.f13009f.get(0);
            float f6 = bVar.f13035e;
            int size = this.f13009f.size();
            int i2 = bVar.f13032b;
            int i3 = ((C3840b) this.f13009f.get(size - 1)).f13032b;
            while (i2 < i3) {
                while (i2 > bVar.f13032b && i < size) {
                    i++;
                    bVar = (C3840b) this.f13009f.get(i);
                }
                if (i2 == bVar.f13032b) {
                    f2 = (bVar.f13035e + bVar.f13034d) * f4;
                    f = bVar.f13035e + bVar.f13034d + f5;
                } else {
                    float pageWidth = this.f13012i.getPageWidth(i2);
                    f = f6 + pageWidth + f5;
                    f2 = (f6 + pageWidth) * f4;
                }
                int i4 = this.f13021r;
                if (((float) i4) + f2 > ((float) scrollY)) {
                    f3 = f5;
                    this.f13022s.setBounds(this.f13023t, (int) f2, this.f13024u, (int) (((float) i4) + f2 + 0.5f));
                    this.f13022s.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollY + height))) {
                    i2++;
                    f6 = f;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f12975D = false;
            this.f12976E = false;
            this.f12983L = -1;
            VelocityTracker velocityTracker = this.f12984M;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12984M = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f12975D) {
                return true;
            }
            if (this.f12976E) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f12981J = x;
            this.f12979H = x;
            float y = motionEvent.getY();
            this.f12982K = y;
            this.f12980I = y;
            this.f12983L = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f12976E = false;
            this.f13018o.computeScrollOffset();
            if (this.f13006am != 2 || Math.abs(this.f13018o.getFinalY() - this.f13018o.getCurrY()) <= this.f12988Q) {
                mo23606a(false);
                this.f12975D = false;
            } else {
                this.f13018o.abortAnimation();
                this.f12973B = false;
                mo23288h();
                this.f12975D = true;
                m15946c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f12983L;
            if (i != -1) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                float b = m15940b(motionEvent, findPointerIndex);
                float f = b - this.f12980I;
                float abs = Math.abs(f);
                float a = m15930a(motionEvent, findPointerIndex);
                float abs2 = Math.abs(a - this.f12981J);
                boolean z = !m15939a(this.f12980I, f);
                boolean a2 = mo23261a((View) this, false, (int) f, (int) a, (int) b);
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 == 0 || !z || !a2) {
                    if (abs > ((float) this.f13008e) && abs > abs2) {
                        this.f12975D = true;
                        m15946c(true);
                        setScrollState(1);
                        float f2 = this.f12982K;
                        this.f12980I = i2 > 0 ? f2 + ((float) this.f13008e) : f2 - ((float) this.f13008e);
                        this.f12979H = a;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.f13008e)) {
                        this.f12976E = true;
                    }
                    if (this.f12975D && mo23268b(b)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                } else {
                    this.f12979H = a;
                    this.f12980I = b;
                    this.f12976E = true;
                    return false;
                }
            }
        } else if (action == 6) {
            mo23615a(motionEvent);
        }
        if (this.f12984M == null) {
            this.f12984M = VelocityTracker.obtain();
        }
        this.f12984M.addMovement(motionEvent);
        return this.f12975D;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i9 = paddingRight;
        int i10 = 0;
        int i11 = paddingLeft;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                C3841c cVar = (C3841c) childAt.getLayoutParams();
                if (cVar.f13036a) {
                    int i13 = cVar.f13037b & 7;
                    int i14 = cVar.f13037b & 112;
                    if (i13 == 1) {
                        i5 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, i11);
                    } else if (i13 == 3) {
                        i5 = i11;
                        i11 = childAt.getMeasuredWidth() + i11;
                    } else if (i13 != 5) {
                        i5 = i11;
                    } else {
                        i5 = (i7 - i9) - childAt.getMeasuredWidth();
                        i9 += childAt.getMeasuredWidth();
                    }
                    if (i14 == 16) {
                        i6 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else if (i14 == 48) {
                        i6 = paddingTop;
                        paddingTop = childAt.getMeasuredHeight() + paddingTop;
                    } else if (i14 != 80) {
                        i6 = paddingTop;
                    } else {
                        i6 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                        paddingBottom += childAt.getMeasuredHeight();
                    }
                    int i15 = i6 + scrollY;
                    childAt.layout(i5, i15, childAt.getMeasuredWidth() + i5, i15 + childAt.getMeasuredHeight());
                    i10++;
                }
            }
        }
        int i16 = (i8 - paddingTop) - paddingBottom;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                C3841c cVar2 = (C3841c) childAt2.getLayoutParams();
                if (!cVar2.f13036a) {
                    C3840b a = mo23250a(childAt2);
                    if (a != null) {
                        float f = (float) i16;
                        int i18 = ((int) (a.f13035e * f)) + paddingTop;
                        if (cVar2.f13039d) {
                            cVar2.f13039d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((i7 - i11) - i9, 1073741824), MeasureSpec.makeMeasureSpec((int) (f * cVar2.f13038c), 1073741824));
                        }
                        childAt2.layout(i11, i18, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + i18);
                    }
                }
            }
        }
        this.f13023t = i11;
        this.f13024u = i7 - i9;
        this.f12995aa = i10;
        if (this.f12992U) {
            m15934a(this.f13013j, false, 0, false, false);
        }
        this.f12992U = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    public void onMeasure(int r17, int r18) {
        /*
        r16 = this;
        r0 = r16
        r1 = 0
        r2 = r17
        int r2 = getDefaultSize(r1, r2)
        r3 = r18
        int r3 = getDefaultSize(r1, r3)
        r0.setMeasuredDimension(r2, r3)
        int r2 = r16.getMeasuredHeight()
        int r3 = r2 / 10
        int r4 = r0.f12977F
        int r3 = java.lang.Math.min(r3, r4)
        r0.f12978G = r3
        int r3 = r16.getMeasuredWidth()
        int r4 = r16.getPaddingLeft()
        int r3 = r3 - r4
        int r4 = r16.getPaddingRight()
        int r3 = r3 - r4
        int r4 = r16.getPaddingTop()
        int r2 = r2 - r4
        int r4 = r16.getPaddingBottom()
        int r2 = r2 - r4
        int r4 = r16.getChildCount()
        r5 = r2
        r2 = 0
    L_0x003e:
        r6 = 8
        r7 = 1
        r8 = 1073741824(0x40000000, float:2.0)
        if (r2 >= r4) goto L_0x00c6
        android.view.View r9 = r0.getChildAt(r2)
        int r10 = r9.getVisibility()
        if (r10 == r6) goto L_0x00c1
        android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
        com.kwad.sdk.contentalliance.b.b$c r6 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3841c) r6
        if (r6 == 0) goto L_0x00c1
        boolean r10 = r6.f13036a
        if (r10 == 0) goto L_0x00c1
        int r10 = r6.f13037b
        r10 = r10 & 7
        int r11 = r6.f13037b
        r11 = r11 & 112(0x70, float:1.57E-43)
        r12 = 48
        if (r11 == r12) goto L_0x006e
        r12 = 80
        if (r11 != r12) goto L_0x006c
        goto L_0x006e
    L_0x006c:
        r11 = 0
        goto L_0x006f
    L_0x006e:
        r11 = 1
    L_0x006f:
        r12 = 3
        if (r10 == r12) goto L_0x0077
        r12 = 5
        if (r10 != r12) goto L_0x0076
        goto L_0x0077
    L_0x0076:
        r7 = 0
    L_0x0077:
        r10 = -2147483648(0xffffffff80000000, float:-0.0)
        if (r11 == 0) goto L_0x007e
        r10 = 1073741824(0x40000000, float:2.0)
        goto L_0x0083
    L_0x007e:
        if (r7 == 0) goto L_0x0083
        r12 = 1073741824(0x40000000, float:2.0)
        goto L_0x0085
    L_0x0083:
        r12 = -2147483648(0xffffffff80000000, float:-0.0)
    L_0x0085:
        int r13 = r6.width
        r14 = -1
        r15 = -2
        if (r13 == r15) goto L_0x0097
        int r10 = r6.width
        if (r10 == r14) goto L_0x0093
        int r10 = r6.width
        r13 = r10
        goto L_0x0094
    L_0x0093:
        r13 = r3
    L_0x0094:
        r10 = 1073741824(0x40000000, float:2.0)
        goto L_0x0098
    L_0x0097:
        r13 = r3
    L_0x0098:
        int r1 = r6.height
        if (r1 == r15) goto L_0x00a5
        int r1 = r6.height
        if (r1 == r14) goto L_0x00a3
        int r1 = r6.height
        goto L_0x00a7
    L_0x00a3:
        r1 = r5
        goto L_0x00a7
    L_0x00a5:
        r1 = r5
        r8 = r12
    L_0x00a7:
        int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r10)
        int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
        r9.measure(r6, r1)
        if (r11 == 0) goto L_0x00ba
        int r1 = r9.getMeasuredHeight()
        int r5 = r5 - r1
        goto L_0x00c1
    L_0x00ba:
        if (r7 == 0) goto L_0x00c1
        int r1 = r9.getMeasuredWidth()
        int r3 = r3 - r1
    L_0x00c1:
        int r2 = r2 + 1
        r1 = 0
        goto L_0x003e
    L_0x00c6:
        int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r8)
        r0.f13027x = r1
        int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
        r0.f13028y = r1
        r0.f13029z = r7
        r16.mo23288h()
        r1 = 0
        r0.f13029z = r1
        int r2 = r16.getChildCount()
    L_0x00de:
        if (r1 >= r2) goto L_0x0108
        android.view.View r3 = r0.getChildAt(r1)
        int r4 = r3.getVisibility()
        if (r4 == r6) goto L_0x0105
        android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
        com.kwad.sdk.contentalliance.b.b$c r4 = (com.kwad.sdk.contentalliance.p309b.C3835b.C3841c) r4
        if (r4 == 0) goto L_0x00f6
        boolean r7 = r4.f13036a
        if (r7 != 0) goto L_0x0105
    L_0x00f6:
        float r7 = (float) r5
        float r4 = r4.f13038c
        float r7 = r7 * r4
        int r4 = (int) r7
        int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r8)
        int r7 = r0.f13027x
        r3.measure(r7, r4)
    L_0x0105:
        int r1 = r1 + 1
        goto L_0x00de
    L_0x0108:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.p309b.C3835b.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = childCount - 1;
            i2 = -1;
        }
        for (i3 = 
/*
Method generation error in method: com.kwad.sdk.contentalliance.b.b.onRequestFocusInDescendants(int, android.graphics.Rect):boolean, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0v1 'i3' int) = (r0v4 'i3' int), (r0v5 'i3' int) binds: {(r0v4 'i3' int)=B:3:0x000f, (r0v5 'i3' int)=B:2:0x000b} in method: com.kwad.sdk.contentalliance.b.b.onRequestFocusInDescendants(int, android.graphics.Rect):boolean, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:193)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:36)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:536)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:508)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:232)
	... 14 more

*/

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C3846h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3846h hVar = (C3846h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        PagerAdapter pagerAdapter = this.f13012i;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(hVar.f13045b, hVar.f13046c);
            mo23256a(hVar.f13044a, false, true);
        } else {
            this.f13014k = hVar.f13044a;
            this.f13016m = hVar.f13045b;
            this.f13017n = hVar.f13046c;
        }
    }

    public Parcelable onSaveInstanceState() {
        C3846h hVar = new C3846h(super.onSaveInstanceState());
        hVar.f13044a = this.f13013j;
        PagerAdapter pagerAdapter = this.f13012i;
        if (pagerAdapter != null) {
            hVar.f13045b = pagerAdapter.saveState();
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            int i5 = this.f13021r;
            m15933a(i2, i4, i5, i5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x017a  */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        boolean r0 = r10.f12989R
        r1 = 1
        if (r0 == 0) goto L_0x0006
        return r1
    L_0x0006:
        int r0 = r11.getAction()
        r2 = 0
        if (r0 != 0) goto L_0x0014
        int r0 = r11.getEdgeFlags()
        if (r0 == 0) goto L_0x0014
        return r2
    L_0x0014:
        androidx.viewpager.widget.PagerAdapter r0 = r10.f13012i
        if (r0 == 0) goto L_0x017e
        int r0 = r0.getCount()
        if (r0 != 0) goto L_0x0020
        goto L_0x017e
    L_0x0020:
        android.view.VelocityTracker r0 = r10.f12984M
        if (r0 != 0) goto L_0x002a
        android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
        r10.f12984M = r0
    L_0x002a:
        android.view.VelocityTracker r0 = r10.f12984M
        r0.addMovement(r11)
        int r0 = r11.getAction()
        r0 = r0 & 255(0xff, float:3.57E-43)
        if (r0 == 0) goto L_0x0158
        r3 = -1
        if (r0 == r1) goto L_0x00f7
        r4 = 2
        if (r0 == r4) goto L_0x008c
        r4 = 3
        if (r0 == r4) goto L_0x0069
        r3 = 5
        if (r0 == r3) goto L_0x0059
        r3 = 6
        if (r0 == r3) goto L_0x0048
        goto L_0x0178
    L_0x0048:
        r10.mo23615a(r11)
        int r0 = r10.f12983L
        int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r11, r0)
        float r11 = r10.m15940b(r11, r0)
        r10.f12980I = r11
        goto L_0x0178
    L_0x0059:
        int r0 = androidx.core.view.MotionEventCompat.getActionIndex(r11)
        float r3 = r10.m15940b(r11, r0)
        r10.f12980I = r3
        int r11 = androidx.core.view.MotionEventCompat.getPointerId(r11, r0)
        goto L_0x0176
    L_0x0069:
        boolean r11 = r10.f12975D
        if (r11 == 0) goto L_0x0178
        int r5 = r10.f13013j
        r6 = 1
        r7 = 0
        r8 = 0
        r9 = 0
        r4 = r10
        r4.m15934a(r5, r6, r7, r8, r9)
        r10.f12983L = r3
        r10.mo23608e()
        androidx.core.widget.EdgeEffectCompat r11 = r10.f12990S
        boolean r11 = r11.onRelease()
        androidx.core.widget.EdgeEffectCompat r0 = r10.f12991T
        boolean r0 = r0.onRelease()
        r2 = r11 | r0
        goto L_0x0178
    L_0x008c:
        boolean r0 = r10.f12975D
        if (r0 != 0) goto L_0x00e2
        int r0 = r10.f12983L
        int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r11, r0)
        float r3 = r10.m15940b(r11, r0)
        float r4 = r10.f12980I
        float r4 = r3 - r4
        float r4 = java.lang.Math.abs(r4)
        float r0 = r10.m15930a(r11, r0)
        float r5 = r10.f12979H
        float r5 = r0 - r5
        float r5 = java.lang.Math.abs(r5)
        int r6 = r10.f13008e
        float r6 = (float) r6
        int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r6 <= 0) goto L_0x00e2
        int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
        if (r4 <= 0) goto L_0x00e2
        r10.f12975D = r1
        r10.m15946c(r1)
        float r4 = r10.f12982K
        float r3 = r3 - r4
        r5 = 0
        int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r3 <= 0) goto L_0x00cb
        int r3 = r10.f13008e
        float r3 = (float) r3
        float r4 = r4 + r3
        goto L_0x00cf
    L_0x00cb:
        int r3 = r10.f13008e
        float r3 = (float) r3
        float r4 = r4 - r3
    L_0x00cf:
        r10.f12980I = r4
        r10.f12979H = r0
        r10.setScrollState(r1)
        r10.setScrollingCacheEnabled(r1)
        android.view.ViewParent r0 = r10.getParent()
        if (r0 == 0) goto L_0x00e2
        r0.requestDisallowInterceptTouchEvent(r1)
    L_0x00e2:
        boolean r0 = r10.f12975D
        if (r0 == 0) goto L_0x0178
        int r0 = r10.f12983L
        int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r11, r0)
        float r11 = r10.m15940b(r11, r0)
        boolean r11 = r10.mo23268b(r11)
        r2 = r2 | r11
        goto L_0x0178
    L_0x00f7:
        boolean r0 = r10.f12975D
        if (r0 == 0) goto L_0x0151
        android.view.VelocityTracker r0 = r10.f12984M
        r2 = 1000(0x3e8, float:1.401E-42)
        int r4 = r10.f12986O
        float r4 = (float) r4
        r0.computeCurrentVelocity(r2, r4)
        int r2 = r10.f12983L
        float r0 = androidx.core.view.VelocityTrackerCompat.getYVelocity(r0, r2)
        int r8 = (int) r0
        r10.f12973B = r1
        int r0 = r10.getClientHeight()
        int r2 = r10.getScrollY()
        com.kwad.sdk.contentalliance.b.b$b r4 = r10.mo23620d()
        int r5 = r4.f13032b
        float r2 = (float) r2
        float r0 = (float) r0
        float r2 = r2 / r0
        float r0 = r4.f13035e
        float r2 = r2 - r0
        float r0 = r4.f13034d
        float r2 = r2 / r0
        int r0 = r10.f12983L
        int r0 = androidx.core.view.MotionEventCompat.findPointerIndex(r11, r0)
        float r11 = r10.m15940b(r11, r0)
        float r0 = r10.f12982K
        float r11 = r11 - r0
        int r11 = (int) r11
        int r5 = r10.mo23248a(r5, r2, r8, r11)
        r6 = 1
        r7 = 1
        r9 = 1
        r4 = r10
        r4.mo23258a(r5, r6, r7, r8, r9)
        r10.f12983L = r3
        r10.mo23608e()
        androidx.core.widget.EdgeEffectCompat r11 = r10.f12990S
        boolean r11 = r11.onRelease()
        androidx.core.widget.EdgeEffectCompat r0 = r10.f12991T
        boolean r0 = r0.onRelease()
        r2 = r11 | r0
    L_0x0151:
        long r3 = java.lang.System.currentTimeMillis()
        r10.f12996ab = r3
        goto L_0x0178
    L_0x0158:
        android.widget.Scroller r0 = r10.f13018o
        r0.abortAnimation()
        r10.f12973B = r2
        r10.mo23288h()
        float r0 = r11.getX()
        r10.f12981J = r0
        r10.f12979H = r0
        float r0 = r11.getY()
        r10.f12982K = r0
        r10.f12980I = r0
        int r11 = androidx.core.view.MotionEventCompat.getPointerId(r11, r2)
    L_0x0176:
        r10.f12983L = r11
    L_0x0178:
        if (r2 == 0) goto L_0x017d
        androidx.core.view.ViewCompat.postInvalidateOnAnimation(r10)
    L_0x017d:
        return r1
    L_0x017e:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.contentalliance.p309b.C3835b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void removeView(View view) {
        if (this.f13029z) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f13012i;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.f13019p);
            this.f13012i.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f13009f.size(); i++) {
                C3840b bVar = (C3840b) this.f13009f.get(i);
                this.f13012i.destroyItem((ViewGroup) this, bVar.f13032b, bVar.f13031a);
            }
            this.f13012i.finishUpdate((ViewGroup) this);
            this.f13009f.clear();
            mo23617b();
            this.f13013j = 0;
            scrollTo(0, 0);
        }
        int i2 = this.f13015l;
        if (i2 > 0) {
            this.f13013j = i2;
            this.f13015l = -1;
        }
        PagerAdapter pagerAdapter3 = this.f13012i;
        this.f13012i = pagerAdapter;
        this.f13007b = 0;
        if (this.f13012i != null) {
            if (this.f13019p == null) {
                this.f13019p = new C3845g();
            }
            this.f13012i.registerDataSetObserver(this.f13019p);
            this.f12973B = false;
            boolean z = this.f12992U;
            this.f12992U = true;
            this.f13007b = this.f13012i.getCount();
            if (this.f13014k >= 0) {
                this.f13012i.restoreState(this.f13016m, this.f13017n);
                mo23256a(this.f13014k, false, true);
                this.f13014k = -1;
                this.f13016m = null;
                this.f13017n = null;
            } else if (!z) {
                mo23288h();
            } else {
                requestLayout();
            }
        }
        C3843e eVar = this.f12999ae;
        if (eVar != null && pagerAdapter3 != pagerAdapter) {
            eVar.mo23320a(pagerAdapter3, pagerAdapter);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            String str = "VerticalViewPager";
            if (this.f13002ah == null) {
                try {
                    this.f13002ah = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    C4065b.m16864a(str, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f13002ah.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                C4065b.m16864a(str, "Error changing children drawing order", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setCurrentItem(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("setCurrentItem item=");
        sb.append(i);
        C4065b.m16867b("VerticalViewPager", sb.toString());
        this.f12973B = false;
        mo23256a(i, !this.f12992U, false);
    }

    public void setInitStartPosition(int i) {
        this.f13015l = i;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            C4065b.m16863a("VerticalViewPager", sb.toString());
            i = 1;
        }
        if (i != this.f12974C) {
            this.f12974C = i;
            mo23288h();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnAdapterChangeListener(C3843e eVar) {
        this.f12999ae = eVar;
    }

    public void setOnPageScrollEndListener(C3844f fVar) {
        this.f13000af = fVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.f13021r;
        this.f13021r = i;
        int height = getHeight();
        m15933a(height, height, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f13022s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13022s;
    }
}
