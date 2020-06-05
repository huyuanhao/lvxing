package ezy.app.p645rx;

import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.ObservableSubscribeProxy;
import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.Observable;
import p655io.reactivex.ObservableConverter;
import p655io.reactivex.ObservableSource;
import p655io.reactivex.p659a.p661b.AndroidSchedulers;
import p655io.reactivex.p664d.Function;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, mo39189d2 = {"lifecycle", "Lio/reactivex/Observable;", "T", "Lcom/uber/autodispose/ObservableSubscribeProxy;", "view", "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lib.framework_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Lifecycle.kt */
/* renamed from: ezy.app.rx.a */
public final class C8019a {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "kotlin.jvm.PlatformType", "it", "", "apply"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Lifecycle.kt */
    /* renamed from: ezy.app.rx.a$a */
    static final class C8020a<T, R> implements Function<Throwable, ObservableSource<? extends T>> {
        /* renamed from: a */
        public static final C8020a f27262a = new C8020a();

        C8020a() {
        }

        /* renamed from: a */
        public final Observable<T> apply(Throwable th) {
            C8271i.m35386b(th, "it");
            th.printStackTrace();
            return Observable.m35001d();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ ObservableSubscribeProxy m34778a(Observable iVar, LifecycleOwner lifecycleOwner, Event event, int i, Object obj) {
        if ((i & 2) != 0) {
            event = Event.ON_DESTROY;
        }
        return m34777a(iVar, lifecycleOwner, event);
    }

    /* renamed from: a */
    public static final <T> ObservableSubscribeProxy<T> m34777a(Observable<T> iVar, LifecycleOwner lifecycleOwner, Event event) {
        C8271i.m35386b(iVar, "$this$lifecycle");
        C8271i.m35386b(lifecycleOwner, "lifecycleOwner");
        C8271i.m35386b(event, NotificationCompat.CATEGORY_EVENT);
        Object a = iVar.mo38892a(AndroidSchedulers.m34919a()).mo38905c((Function<? super Throwable, ? extends ObservableSource<? extends T>>) C8020a.f27262a).mo38895a((ObservableConverter<T, ? extends R>) AutoDispose.m33075a((ScopeProvider) AndroidLifecycleScopeProvider.m33069a(lifecycleOwner, event)));
        C8271i.m35382a(a, "observeOn(AndroidSchedul…cycleOwner, event))\n    )");
        return (ObservableSubscribeProxy) a;
    }

    /* renamed from: a */
    public static final <T> ObservableSubscribeProxy<T> m34776a(Observable<T> iVar, View view) {
        C8271i.m35386b(iVar, "$this$lifecycle");
        C8271i.m35386b(view, "view");
        Object a = iVar.mo38892a(AndroidSchedulers.m34919a()).mo38891a((ObservableSource<? extends T>) Observable.m35001d()).mo38895a((ObservableConverter<T, ? extends R>) AutoDispose.m33075a((ScopeProvider) AndroidLifecycleScopeProvider.m33069a((LifecycleOwner) new ViewLifecycle(view), Event.ON_DESTROY)));
        C8271i.m35382a(a, "observeOn(AndroidSchedul….Event.ON_DESTROY))\n    )");
        return (ObservableSubscribeProxy) a;
    }
}
