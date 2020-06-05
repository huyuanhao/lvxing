package ezy.p642a;

import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;
import reezy.lib.common.R;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\t*\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, mo39189d2 = {"click", "", "Landroid/view/View;", "throttleTime", "", "block", "Lkotlin/Function1;", "findAncestor", "T", "Landroid/view/ViewGroup;", "ancestorClass", "Ljava/lang/Class;", "(Landroid/view/View;Ljava/lang/Class;)Landroid/view/ViewGroup;", "lib.common_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: ezy.a.d */
public final class View {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: View.kt */
    /* renamed from: ezy.a.d$a */
    static final class C8014a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C8247b f27248a;

        C8014a(C8247b bVar) {
            this.f27248a = bVar;
        }

        public final void onClick(android.view.View view) {
            C8247b bVar = this.f27248a;
            C8271i.m35382a((Object) view, "it");
            bVar.invoke(view);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: View.kt */
    /* renamed from: ezy.a.d$b */
    static final class C8015b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ long f27249a;
        /* renamed from: b */
        final /* synthetic */ C8247b f27250b;

        C8015b(long j, C8247b bVar) {
            this.f27249a = j;
            this.f27250b = bVar;
        }

        public final void onClick(android.view.View view) {
            Object tag = view.getTag(R.id.tag_last_click_time);
            long longValue = tag instanceof Long ? ((Number) tag).longValue() : 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > this.f27249a) {
                C8247b bVar = this.f27250b;
                C8271i.m35382a((Object) view, "it");
                bVar.invoke(view);
                view.setTag(R.id.tag_last_click_time, Long.valueOf(currentTimeMillis));
            }
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m34750a(android.view.View view, long j, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        m34749a(view, j, bVar);
    }

    /* renamed from: a */
    public static final void m34749a(android.view.View view, long j, C8247b<? super android.view.View, Unit> bVar) {
        C8271i.m35386b(view, "$this$click");
        C8271i.m35386b(bVar, "block");
        if (j < 1) {
            view.setOnClickListener(new C8014a(bVar));
        } else {
            view.setOnClickListener(new C8015b(j, bVar));
        }
    }
}
