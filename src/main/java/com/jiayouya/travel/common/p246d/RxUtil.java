package com.jiayouya.travel.common.p246d;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.Observable;
import p655io.reactivex.p659a.p661b.AndroidSchedulers;
import p655io.reactivex.p664d.Function;
import p655io.reactivex.p667g.Schedulers;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo39189d2 = {"MAX_COUNT_TIME", "", "countdown", "Lio/reactivex/Observable;", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.n */
public final class RxUtil {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo39189d2 = {"<anonymous>", "", "increaseTime", "apply", "(Ljava/lang/Long;)J"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: RxUtil.kt */
    /* renamed from: com.jiayouya.travel.common.d.n$a */
    static final class C2900a<T, R> implements Function<T, R> {
        /* renamed from: a */
        final /* synthetic */ long f9645a;

        C2900a(long j) {
            this.f9645a = j;
        }

        public /* synthetic */ Object apply(Object obj) {
            return Long.valueOf(mo19954a((Long) obj));
        }

        /* renamed from: a */
        public final long mo19954a(Long l) {
            C8271i.m35386b(l, "increaseTime");
            return this.f9645a - ((long) ((int) l.longValue()));
        }
    }

    /* renamed from: a */
    public static /* synthetic */ Observable m12972a(long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 60;
        }
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.SECONDS;
        }
        return m12971a(j, timeUnit);
    }

    /* renamed from: a */
    public static final Observable<Long> m12971a(long j, TimeUnit timeUnit) {
        C8271i.m35386b(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        Observable<Long> b = Observable.m34990a(0, 1, timeUnit).mo38902b(Schedulers.m34968b()).mo38892a(AndroidSchedulers.m34919a()).mo38900b((Function<? super T, ? extends R>) new C2900a<Object,Object>(j)).mo38896b(j + 1);
        C8271i.m35382a((Object) b, "Observable.interval(0, 1…     .take(countTime + 1)");
        return b;
    }
}
