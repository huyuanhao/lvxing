package com.bytedance.sdk.openadsdk.p199j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.j.g */
public class TrackRetryRepertoryImpl implements TrackRetryRepertory {
    /* renamed from: a */
    private Context f9000a;

    public TrackRetryRepertoryImpl(Context context) {
        this.f9000a = context;
    }

    /* renamed from: a */
    public synchronized List<TrackInfo> mo16837a() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor a = DBMultiAdapter.m11760a(this.f9000a, "trackurl", null, null, null, null, null, null);
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    linkedList.add(new TrackInfo(a.getString(a.getColumnIndex("id")), a.getString(a.getColumnIndex("url")), a.getInt(a.getColumnIndex("replaceholder")) > 0, a.getInt(a.getColumnIndex("retry"))));
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public synchronized void mo16838a(TrackInfo eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.mo16832a());
        contentValues.put("url", eVar.mo16834b());
        contentValues.put("replaceholder", Integer.valueOf(eVar.mo16835c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(eVar.mo16836d()));
        DBMultiAdapter.m11763a(this.f9000a, "trackurl", contentValues);
    }

    /* renamed from: b */
    public synchronized void mo16839b(TrackInfo eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.mo16832a());
        contentValues.put("url", eVar.mo16834b());
        contentValues.put("replaceholder", Integer.valueOf(eVar.mo16835c() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(eVar.mo16836d()));
        DBMultiAdapter.m11757a(this.f9000a, "trackurl", contentValues, "id=?", new String[]{eVar.mo16832a()});
    }

    /* renamed from: c */
    public synchronized void mo16840c(TrackInfo eVar) {
        DBMultiAdapter.m11758a(this.f9000a, "trackurl", "id=?", new String[]{eVar.mo16832a()});
    }

    /* renamed from: b */
    public static String m11744b() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("trackurl");
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("id");
        sb.append(" TEXT UNIQUE,");
        sb.append("url");
        sb.append(" TEXT ,");
        sb.append("replaceholder");
        sb.append(" INTEGER default 0, ");
        sb.append("retry");
        sb.append(" INTEGER default 0");
        sb.append(")");
        return sb.toString();
    }
}
