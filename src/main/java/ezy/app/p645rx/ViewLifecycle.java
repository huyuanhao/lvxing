package ezy.app.p645rx;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.elvishew.xlog.XLog;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lezy/app/rx/ViewLifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onViewAttachedToWindow", "", "v", "onViewDetachedFromWindow", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: ViewLifecycle.kt */
/* renamed from: ezy.app.rx.ViewLifecycle */
public final class ViewLifecycle implements OnAttachStateChangeListener, LifecycleOwner {
    /* renamed from: a */
    private final LifecycleRegistry f27261a = new LifecycleRegistry(this);

    public ViewLifecycle(View view) {
        C8271i.m35386b(view, "view");
        if (view.isAttachedToWindow()) {
            try {
                this.f27261a.handleLifecycleEvent(Event.ON_START);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        view.addOnAttachStateChangeListener(this);
    }

    public Lifecycle getLifecycle() {
        return this.f27261a;
    }

    public void onViewDetachedFromWindow(View view) {
        XLog.m12691a("onViewDetachedFromWindow");
        try {
            if (this.f27261a.getCurrentState() != State.DESTROYED) {
                this.f27261a.handleLifecycleEvent(Event.ON_DESTROY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onViewAttachedToWindow(View view) {
        XLog.m12691a("onViewAttachedToWindow");
        try {
            this.f27261a.handleLifecycleEvent(Event.ON_START);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
