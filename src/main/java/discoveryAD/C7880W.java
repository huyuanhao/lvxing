package discoveryAD;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: discoveryAD.W */
public class C7880W implements C7891ca {
    private static final String TAG = "ActionDBCreator";
    /* renamed from: Td */
    private static final int f26798Td = 3;
    /* renamed from: Ud */
    public static final String f26799Ud = "discovery_advertise_action_table";

    /* renamed from: discoveryAD.W$a */
    public interface C7881a {
        public static final String TIMESTAMP = "timestamp";
        /* renamed from: bh */
        public static final String f26800bh = "auto_increate_index";
        /* renamed from: ch */
        public static final String f26801ch = "activity_id";
        /* renamed from: dh */
        public static final String f26802dh = "position_id";
        /* renamed from: eh */
        public static final String f26803eh = "context";
        /* renamed from: fh */
        public static final String f26804fh = "phase";
        /* renamed from: gh */
        public static final String f26805gh = "specialtime";
    }

    /* renamed from: a */
    private void m34252a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(f26799Ud);
        sb.append(" (");
        sb.append(C7881a.f26800bh);
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("activity_id");
        sb.append(" TEXT,");
        sb.append(C7881a.f26802dh);
        String str = " INTEGER,";
        sb.append(str);
        sb.append("context");
        sb.append(" BLOB,");
        sb.append(C7881a.TIMESTAMP);
        sb.append(" LONG,");
        sb.append(C7881a.f26804fh);
        sb.append(str);
        sb.append(C7881a.f26805gh);
        sb.append(" LONG)");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createTable,sql=");
        sb3.append(sb2);
        C7852Aa.m34154d(TAG, sb3.toString());
        sQLiteDatabase.execSQL(sb2);
    }

    /* renamed from: b */
    private void m34253b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS discovery_advertise_action_table");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m34253b(sQLiteDatabase);
        m34252a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m34253b(sQLiteDatabase);
        m34252a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            m34253b(sQLiteDatabase);
            m34252a(sQLiteDatabase);
        }
    }

    /* renamed from: u */
    public int mo38161u() {
        return 3;
    }
}
