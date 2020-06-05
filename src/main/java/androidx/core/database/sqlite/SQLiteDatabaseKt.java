package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\b¢\u0006\u0002\u0010\b¨\u0006\t"}, mo39189d2 = {"transaction", "T", "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: SQLiteDatabase.kt */
public final class SQLiteDatabaseKt {
    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        C8271i.m35386b(sQLiteDatabase, "$this$transaction");
        C8271i.m35386b(bVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = bVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            InlineMarker.m35375a(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.m35376b(1);
        }
    }

    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z, C8247b<? super SQLiteDatabase, ? extends T> bVar) {
        C8271i.m35386b(sQLiteDatabase, "$this$transaction");
        C8271i.m35386b(bVar, "body");
        if (z) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = bVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            InlineMarker.m35375a(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.m35376b(1);
        }
    }
}
