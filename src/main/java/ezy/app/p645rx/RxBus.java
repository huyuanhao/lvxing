package ezy.app.p645rx;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.Observable;
import p655io.reactivex.p668h.PublishSubject;
import p655io.reactivex.p668h.Subject;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lezy/app/rx/RxBus;", "", "()V", "publisher", "Lio/reactivex/subjects/Subject;", "kotlin.jvm.PlatformType", "of", "Lio/reactivex/Observable;", "T", "eventType", "Ljava/lang/Class;", "post", "", "event", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.rx.b */
public final class RxBus {
    /* renamed from: a */
    public static final RxBus f27263a = new RxBus();
    /* renamed from: b */
    private static final Subject<Object> f27264b;

    static {
        Subject<Object> j = PublishSubject.m34983a().mo38878j();
        C8271i.m35382a((Object) j, "PublishSubject.create<Any>().toSerialized()");
        f27264b = j;
    }

    private RxBus() {
    }

    /* renamed from: a */
    public final void mo38572a(Object obj) {
        C8271i.m35386b(obj, NotificationCompat.CATEGORY_EVENT);
        f27264b.onNext(obj);
    }

    /* renamed from: a */
    public final <T> Observable<T> mo38571a(Class<T> cls) {
        C8271i.m35386b(cls, "eventType");
        Observable<T> b = f27264b.mo38903b(cls);
        C8271i.m35382a((Object) b, "publisher.ofType(eventType)");
        return b;
    }
}
