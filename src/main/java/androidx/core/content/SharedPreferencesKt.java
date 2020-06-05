package androidx.core.content;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\b¨\u0006\t"}, mo39189d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: SharedPreferences.kt */
public final class SharedPreferencesKt {
    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        C8271i.m35386b(sharedPreferences, "$this$edit");
        C8271i.m35386b(bVar, "action");
        Editor edit = sharedPreferences.edit();
        C8271i.m35382a((Object) edit, "editor");
        bVar.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static final void edit(SharedPreferences sharedPreferences, boolean z, C8247b<? super Editor, Unit> bVar) {
        C8271i.m35386b(sharedPreferences, "$this$edit");
        C8271i.m35386b(bVar, "action");
        Editor edit = sharedPreferences.edit();
        C8271i.m35382a((Object) edit, "editor");
        bVar.invoke(edit);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
