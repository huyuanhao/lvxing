package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "", "run"}, mo39190k = 3, mo39191mv = {1, 1, 15})
/* compiled from: View.kt */
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ C8247b $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(View view, C8247b bVar) {
        this.$this_doOnPreDraw = view;
        this.$action = bVar;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
