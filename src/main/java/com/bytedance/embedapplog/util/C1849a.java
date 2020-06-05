package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.IDataObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.util.a */
public class C1849a implements IDataObserver {
    /* renamed from: a */
    private static ArrayList<WeakReference<IDataObserver>> f5218a = new ArrayList<>(4);

    public synchronized void onIdLoaded(String str, String str2, String str3) {
        Iterator it = f5218a.iterator();
        while (it.hasNext()) {
            IDataObserver iDataObserver = (IDataObserver) ((WeakReference) it.next()).get();
            if (iDataObserver == null) {
                it.remove();
            } else {
                iDataObserver.onIdLoaded(str, str2, str3);
            }
        }
    }

    public synchronized void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator it = f5218a.iterator();
        while (it.hasNext()) {
            IDataObserver iDataObserver = (IDataObserver) ((WeakReference) it.next()).get();
            if (iDataObserver == null) {
                it.remove();
            } else {
                iDataObserver.onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
            }
        }
    }

    public synchronized void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator it = f5218a.iterator();
        while (it.hasNext()) {
            IDataObserver iDataObserver = (IDataObserver) ((WeakReference) it.next()).get();
            if (iDataObserver == null) {
                it.remove();
            } else {
                iDataObserver.onRemoteConfigGet(z, jSONObject);
            }
        }
    }

    public synchronized void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator it = f5218a.iterator();
        while (it.hasNext()) {
            IDataObserver iDataObserver = (IDataObserver) ((WeakReference) it.next()).get();
            if (iDataObserver == null) {
                it.remove();
            } else {
                iDataObserver.onRemoteAbConfigGet(z, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo13496a(IDataObserver iDataObserver) {
        if (iDataObserver != null) {
            f5218a.add(new WeakReference(iDataObserver));
        }
    }

    /* renamed from: b */
    public synchronized void mo13497b(IDataObserver iDataObserver) {
        Iterator it = f5218a.iterator();
        while (it.hasNext()) {
            IDataObserver iDataObserver2 = (IDataObserver) ((WeakReference) it.next()).get();
            if (iDataObserver2 == null) {
                it.remove();
            } else if (iDataObserver2.equals(iDataObserver)) {
                it.remove();
            }
        }
    }
}
