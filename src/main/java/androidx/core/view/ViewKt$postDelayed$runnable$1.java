package androidx.core.view;

import kotlin.Metadata;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: View.kt */
public final class ViewKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ C8246a $action;

    public ViewKt$postDelayed$runnable$1(C8246a aVar) {
        this.$action = aVar;
    }

    public final void run() {
        this.$action.invoke();
    }
}
