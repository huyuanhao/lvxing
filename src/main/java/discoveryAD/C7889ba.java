package discoveryAD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: discoveryAD.ba */
public class C7889ba extends SQLiteOpenHelper {
    /* renamed from: I */
    private static final String f26876I = "Discovery_DB";
    /* renamed from: J */
    private static final int f26877J = 9;
    /* renamed from: K */
    private C7886aa f26878K = new C7886aa();
    /* renamed from: Q */
    private C7880W f26879Q = new C7880W();

    public C7889ba(Context context) {
        super(context, f26876I, null, 9);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f26878K.onCreate(sQLiteDatabase);
        this.f26879Q.onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f26878K.onDowngrade(sQLiteDatabase, i, i2);
        this.f26879Q.onDowngrade(sQLiteDatabase, i, i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C7886aa aaVar = this.f26878K;
        if (i2 > i) {
            aaVar.onUpgrade(sQLiteDatabase, i, i2);
            this.f26879Q.onUpgrade(sQLiteDatabase, i, i2);
            return;
        }
        aaVar.onDowngrade(sQLiteDatabase, i, i2);
        this.f26879Q.onDowngrade(sQLiteDatabase, i, i2);
    }
}
