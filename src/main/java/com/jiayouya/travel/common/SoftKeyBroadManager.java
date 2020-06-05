package com.jiayouya.travel.common;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.elvishew.xlog.XLog;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo39189d2 = {"Lcom/jiayouya/travel/common/SoftKeyBroadManager;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activityRootView", "Landroid/view/View;", "isSoftKeyboardOpened", "", "(Landroid/view/View;Z)V", "()Z", "setSoftKeyboardOpened", "(Z)V", "lastSoftKeyboardHeightInPx", "", "listeners", "Ljava/util/LinkedList;", "Lcom/jiayouya/travel/common/SoftKeyBroadManager$SoftKeyboardStateListener;", "addSoftKeyboardStateListener", "", "listener", "notifyOnSoftKeyboardClosed", "notifyOnSoftKeyboardOpened", "keyboardHeightInPx", "onGlobalLayout", "removeSoftKeyboardStateListener", "SoftKeyboardStateListener", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.c */
public final class SoftKeyBroadManager implements OnGlobalLayoutListener {
    /* renamed from: a */
    private final LinkedList<C2878a> f9596a;
    /* renamed from: b */
    private int f9597b;
    /* renamed from: c */
    private final View f9598c;
    /* renamed from: d */
    private boolean f9599d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/common/SoftKeyBroadManager$SoftKeyboardStateListener;", "", "onSoftKeyboardClosed", "", "onSoftKeyboardOpened", "keyboardHeightInPx", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: SoftKeyBroadManager.kt */
    /* renamed from: com.jiayouya.travel.common.c$a */
    public interface C2878a {
        /* renamed from: a */
        void mo19915a();

        /* renamed from: a */
        void mo19916a(int i);
    }

    public SoftKeyBroadManager(View view, boolean z) {
        C8271i.m35386b(view, "activityRootView");
        this.f9598c = view;
        this.f9599d = z;
        this.f9596a = new LinkedList<>();
        this.f9598c.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public /* synthetic */ SoftKeyBroadManager(View view, boolean z, int i, DefaultConstructorMarker fVar) {
        if ((i & 2) != 0) {
            z = false;
        }
        this(view, z);
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f9598c.getWindowVisibleDisplayFrame(rect);
        View rootView = this.f9598c.getRootView();
        C8271i.m35382a((Object) rootView, "activityRootView.rootView");
        int height = rootView.getHeight() - (rect.bottom - rect.top);
        if (!this.f9599d && height > 500) {
            this.f9599d = true;
            m12909a(height);
        } else if (this.f9599d && height < 500) {
            this.f9599d = false;
            m12908a();
        }
    }

    /* renamed from: a */
    public final void mo19913a(C2878a aVar) {
        C8271i.m35386b(aVar, "listener");
        this.f9596a.add(aVar);
    }

    /* renamed from: a */
    private final void m12909a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("notifyOnSoftKeyboardOpened keyboardHeightInPx==");
        sb.append(i);
        XLog.m12692b(sb.toString());
        this.f9597b = i;
        Iterator it = this.f9596a.iterator();
        while (it.hasNext()) {
            ((C2878a) it.next()).mo19916a(i);
        }
    }

    /* renamed from: a */
    private final void m12908a() {
        XLog.m12692b("notifyOnSoftKeyboardClosed");
        Iterator it = this.f9596a.iterator();
        while (it.hasNext()) {
            ((C2878a) it.next()).mo19915a();
        }
    }
}
