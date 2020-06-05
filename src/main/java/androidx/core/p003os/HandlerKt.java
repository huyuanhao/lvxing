package androidx.core.p003os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¨\u0006\f"}, mo39189d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Handler.kt */
/* renamed from: androidx.core.os.HandlerKt */
public final class HandlerKt {
    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, C8246a aVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C8271i.m35386b(handler, "$this$postDelayed");
        C8271i.m35386b(aVar, "action");
        Runnable handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static final Runnable postDelayed(Handler handler, long j, Object obj, C8246a<Unit> aVar) {
        C8271i.m35386b(handler, "$this$postDelayed");
        C8271i.m35386b(aVar, "action");
        Runnable handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, C8246a aVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C8271i.m35386b(handler, "$this$postAtTime");
        C8271i.m35386b(aVar, "action");
        Runnable handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static final Runnable postAtTime(Handler handler, long j, Object obj, C8246a<Unit> aVar) {
        C8271i.m35386b(handler, "$this$postAtTime");
        C8271i.m35386b(aVar, "action");
        Runnable handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }
}
