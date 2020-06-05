package com.p530ss.android.downloadlib.p541a.p542a;

import android.text.TextUtils;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.C6544a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.a.b */
class AdDownloadDialogSpHelper {
    AdDownloadDialogSpHelper() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public CopyOnWriteArrayList<C6544a> mo31253a(String str, String str2) {
        CopyOnWriteArrayList<C6544a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = C6565j.m26357a().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    C6544a a = C6544a.m26164a(jSONObject.optJSONObject((String) keys.next()));
                    if (a != null) {
                        copyOnWriteArrayList.add(a);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo31254a(String str, String str2, CopyOnWriteArrayList<C6544a> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    C6544a aVar = (C6544a) it.next();
                    if (aVar != null) {
                        jSONObject.put(String.valueOf(aVar.f21297b), aVar.mo31259b());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            C6565j.m26357a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo31255b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            C6565j.m26357a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
        }
    }
}
