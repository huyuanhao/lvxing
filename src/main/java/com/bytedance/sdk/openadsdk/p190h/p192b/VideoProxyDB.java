package com.bytedance.sdk.openadsdk.p190h.p192b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.android.tpush.SettingsContentProvider;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bytedance.sdk.openadsdk.h.b.c */
public class VideoProxyDB {
    /* renamed from: b */
    private static volatile VideoProxyDB f8793b;
    /* renamed from: a */
    private final SparseArray<Map<String, VideoHttpHeaderInfo>> f8794a = new SparseArray<>(2);
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final VideoProxyDBHelper f8795c;
    /* renamed from: d */
    private final Executor f8796d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: e */
    public volatile SQLiteStatement f8797e;

    private VideoProxyDB(Context context) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.f8796d = threadPoolExecutor;
        this.f8795c = new VideoProxyDBHelper(context.getApplicationContext());
        this.f8794a.put(0, new ConcurrentHashMap());
        this.f8794a.put(1, new ConcurrentHashMap());
    }

    /* renamed from: a */
    public static VideoProxyDB m11510a(Context context) {
        if (f8793b == null) {
            synchronized (VideoProxyDB.class) {
                if (f8793b == null) {
                    f8793b = new VideoProxyDB(context);
                }
            }
        }
        return f8793b;
    }

    /* renamed from: a */
    public VideoHttpHeaderInfo mo16710a(String str, int i) {
        VideoHttpHeaderInfo aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) this.f8794a.get(i);
        if (map == null) {
            aVar = null;
        } else {
            aVar = (VideoHttpHeaderInfo) map.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor query = this.f8795c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    aVar = new VideoHttpHeaderInfo(query.getString(query.getColumnIndex(SettingsContentProvider.KEY)), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex("contentLength")), i, query.getString(query.getColumnIndex("extra")));
                }
                query.close();
            }
            if (!(aVar == null || map == null)) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo16712a(final VideoHttpHeaderInfo aVar) {
        if (aVar != null) {
            Map map = (Map) this.f8794a.get(aVar.f8791d);
            if (map != null) {
                map.put(aVar.f8788a, aVar);
            }
            this.f8796d.execute(new Runnable() {
                public void run() {
                    try {
                        if (VideoProxyDB.this.f8797e == null) {
                            VideoProxyDB.this.f8797e = VideoProxyDB.this.f8795c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            VideoProxyDB.this.f8797e.clearBindings();
                        }
                        VideoProxyDB.this.f8797e.bindString(1, aVar.f8788a);
                        VideoProxyDB.this.f8797e.bindString(2, aVar.f8789b);
                        VideoProxyDB.this.f8797e.bindLong(3, (long) aVar.f8790c);
                        VideoProxyDB.this.f8797e.bindLong(4, (long) aVar.f8791d);
                        VideoProxyDB.this.f8797e.bindString(5, aVar.f8792e);
                        VideoProxyDB.this.f8797e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo16713a(Collection<String> collection, int i) {
        if (collection != null && !collection.isEmpty()) {
            String[] strArr = new String[(collection.size() + 1)];
            int i2 = -1;
            Map map = (Map) this.f8794a.get(i);
            for (String str : collection) {
                if (map != null) {
                    map.remove(str);
                }
                i2++;
                strArr[i2] = str;
            }
            strArr[i2 + 1] = String.valueOf(i);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("key IN(");
                sb.append(m11512b(strArr.length));
                sb.append(") AND ");
                sb.append("flag");
                sb.append("=?");
                this.f8795c.getWritableDatabase().delete("video_http_header_t", sb.toString(), strArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: b */
    private String m11512b(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo16711a(final int i) {
        Map map = (Map) this.f8794a.get(i);
        if (map != null) {
            map.clear();
        }
        this.f8796d.execute(new Runnable() {
            public void run() {
                try {
                    VideoProxyDB.this.f8795c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
