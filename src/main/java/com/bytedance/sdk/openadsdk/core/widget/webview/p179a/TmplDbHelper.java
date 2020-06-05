package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.TmplDiffModel;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.c */
class TmplDbHelper {
    /* renamed from: a */
    private static volatile TmplDbHelper f8391a;
    /* renamed from: b */
    private Set<String> f8392b = Collections.synchronizedSet(new HashSet());
    /* renamed from: c */
    private LruCache<String, TmplDiffModel> f8393c = new LruCache<String, TmplDiffModel>(524288) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, TmplDiffModel pVar) {
            int i = 0;
            if (pVar != null) {
                if (!TextUtils.isEmpty(pVar.mo15570b())) {
                    try {
                        i = 0 + pVar.mo15570b().getBytes().length;
                    } catch (Throwable unused) {
                    }
                }
                if (!TextUtils.isEmpty(pVar.mo15572c())) {
                    try {
                        i += pVar.mo15572c().getBytes().length;
                    } catch (Throwable unused2) {
                    }
                }
                if (!TextUtils.isEmpty(pVar.mo15568a())) {
                    try {
                        i += pVar.mo15568a().getBytes().length;
                    } catch (Throwable unused3) {
                    }
                }
                if (!TextUtils.isEmpty(pVar.mo15574d())) {
                    try {
                        i += pVar.mo15574d().getBytes().length;
                    } catch (Throwable unused4) {
                    }
                }
                if (!TextUtils.isEmpty(pVar.mo15578f())) {
                    try {
                        i += pVar.mo15578f().getBytes().length;
                    } catch (Throwable unused5) {
                    }
                }
                if (!TextUtils.isEmpty(pVar.mo15576e())) {
                    try {
                        i += pVar.mo15576e().getBytes().length;
                    } catch (Throwable unused6) {
                    }
                }
            }
            return i > 0 ? i : super.sizeOf(str, pVar);
        }
    };

    /* renamed from: a */
    public static TmplDbHelper m10887a() {
        if (f8391a == null) {
            synchronized (TmplDbHelper.class) {
                if (f8391a == null) {
                    f8391a = new TmplDbHelper();
                }
            }
        }
        return f8391a;
    }

    private TmplDbHelper() {
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public TmplDiffModel mo16370a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TmplDiffModel pVar = (TmplDiffModel) this.f8393c.get(String.valueOf(str));
        if (pVar != null) {
            return pVar;
        }
        Cursor a = DBMultiAdapter.m11760a(InternalContainer.m10059a(), "template_diff", null, "id=?", new String[]{str}, null, null, null);
        if (a != null) {
            try {
                if (a.moveToNext()) {
                    String string = a.getString(a.getColumnIndex("rit"));
                    String string2 = a.getString(a.getColumnIndex("id"));
                    String string3 = a.getString(a.getColumnIndex("md5"));
                    String string4 = a.getString(a.getColumnIndex("url"));
                    String string5 = a.getString(a.getColumnIndex("data"));
                    TmplDiffModel f = new TmplDiffModel().mo15567a(string).mo15569b(string2).mo15571c(string3).mo15573d(string4).mo15575e(string5).mo15577f(a.getString(a.getColumnIndex(AppEntity.KEY_VERSION_STR)));
                    this.f8393c.put(string2, f);
                    this.f8392b.add(string2);
                    if (a != null) {
                        a.close();
                    }
                    return f;
                } else if (a != null) {
                    a.close();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return null;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<TmplDiffModel> mo16373b() {
        ArrayList arrayList = new ArrayList();
        Cursor a = DBMultiAdapter.m11760a(InternalContainer.m10059a(), "template_diff", null, null, null, null, null, null);
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    String string = a.getString(a.getColumnIndex("rit"));
                    String string2 = a.getString(a.getColumnIndex("id"));
                    String string3 = a.getString(a.getColumnIndex("md5"));
                    String string4 = a.getString(a.getColumnIndex("url"));
                    String string5 = a.getString(a.getColumnIndex("data"));
                    arrayList.add(new TmplDiffModel().mo15567a(string).mo15569b(string2).mo15571c(string3).mo15573d(string4).mo15575e(string5).mo15577f(a.getString(a.getColumnIndex(AppEntity.KEY_VERSION_STR))));
                    this.f8393c.put(string2, arrayList.get(arrayList.size() - 1));
                    this.f8392b.add(string2);
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
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16371a(TmplDiffModel pVar) {
        if (!TextUtils.isEmpty(pVar.mo15570b())) {
            Cursor a = DBMultiAdapter.m11760a(InternalContainer.m10059a(), "template_diff", null, "id=?", new String[]{pVar.mo15570b()}, null, null, null);
            boolean z = a != null && a.getCount() > 0;
            if (a != null) {
                try {
                    a.close();
                } catch (Throwable unused) {
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("rit", pVar.mo15568a());
            contentValues.put("id", pVar.mo15570b());
            contentValues.put("md5", pVar.mo15572c());
            contentValues.put("url", pVar.mo15574d());
            contentValues.put("data", pVar.mo15576e());
            contentValues.put(AppEntity.KEY_VERSION_STR, pVar.mo15578f());
            String str = "template_diff";
            if (z) {
                DBMultiAdapter.m11757a(InternalContainer.m10059a(), str, contentValues, "id=?", new String[]{pVar.mo15570b()});
            } else {
                DBMultiAdapter.m11763a(InternalContainer.m10059a(), str, contentValues);
            }
            this.f8393c.put(pVar.mo15570b(), pVar);
            this.f8392b.add(pVar.mo15570b());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16372a(Set<String> set) {
        if (set != null && !set.isEmpty() && m10889d()) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f8392b) {
                if (!set.contains(str)) {
                    arrayList.add(str);
                }
            }
            String[] strArr = new String[0];
            if (arrayList.size() > 0) {
                DBMultiAdapter.m11758a(InternalContainer.m10059a(), "template_diff", "id=?", (String[]) arrayList.toArray(strArr));
            }
        }
    }

    /* renamed from: d */
    private boolean m10889d() {
        Long l;
        String str = "sp_template_delete";
        String str2 = "delete_time";
        if (MultiGlobalInfo.m11808b()) {
            l = Long.valueOf(SPMultiHelper.m11866a(str, str2, 0));
        } else {
            l = Long.valueOf(m10890e().getLong(str2, 0));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - l.longValue() < 604800000) {
            return false;
        }
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11873a(str, str2, Long.valueOf(currentTimeMillis));
        } else {
            m10890e().edit().putLong(str2, currentTimeMillis);
        }
        return true;
    }

    /* renamed from: e */
    private SharedPreferences m10890e() {
        return InternalContainer.m10059a().getSharedPreferences("sp_template_delete", 0);
    }

    /* renamed from: c */
    public static String m10888c() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("template_diff");
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("rit");
        String str = " TEXT ,";
        sb.append(str);
        sb.append("id");
        sb.append(" TEXT UNIQUE,");
        sb.append("md5");
        sb.append(str);
        sb.append("url");
        String str2 = " TEXT , ";
        sb.append(str2);
        sb.append("data");
        sb.append(str2);
        sb.append(AppEntity.KEY_VERSION_STR);
        sb.append(" TEXT");
        sb.append(")");
        return sb.toString();
    }
}
