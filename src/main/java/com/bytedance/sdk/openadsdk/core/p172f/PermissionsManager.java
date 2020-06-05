package com.bytedance.sdk.openadsdk.core.p172f;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.RomUtils;
import com.tencent.mid.core.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.core.f.d */
public class PermissionsManager {
    /* renamed from: a */
    private static final String f7523a = PermissionsManager.class.getSimpleName();
    /* renamed from: e */
    private static PermissionsManager f7524e = null;
    /* renamed from: f */
    private static final Map<String, Integer> f7525f = new HashMap();
    /* renamed from: b */
    private final Set<String> f7526b = new HashSet(1);
    /* renamed from: c */
    private final List<WeakReference<PermissionsResultAction>> f7527c = new ArrayList(1);
    /* renamed from: d */
    private final List<PermissionsResultAction> f7528d = new ArrayList(1);

    static {
        String str = "tt_request_permission_descript_location";
        f7525f.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ResourceHelp.m11932b(InternalContainer.m10059a(), str)));
        f7525f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ResourceHelp.m11932b(InternalContainer.m10059a(), str)));
        f7525f.put(Constants.PERMISSION_READ_PHONE_STATE, Integer.valueOf(ResourceHelp.m11932b(InternalContainer.m10059a(), "tt_request_permission_descript_read_phone_state")));
        String str2 = "tt_request_permission_descript_external_storage";
        f7525f.put(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE, Integer.valueOf(ResourceHelp.m11932b(InternalContainer.m10059a(), str2)));
        if (VERSION.SDK_INT >= 16) {
            f7525f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(ResourceHelp.m11932b(InternalContainer.m10059a(), str2)));
        }
    }

    /* renamed from: a */
    public static PermissionsManager m9560a() {
        if (f7524e == null) {
            f7524e = new PermissionsManager();
        }
        return f7524e;
    }

    private PermissionsManager() {
        m9564b();
    }

    /* renamed from: b */
    private synchronized void m9564b() {
        Object obj;
        for (Field field : permission.class.getFields()) {
            try {
                obj = (String) field.get("");
            } catch (IllegalAccessException e) {
                Log.e(f7523a, "Could not access field", e);
                obj = null;
            }
            this.f7526b.add(obj);
        }
    }

    /* renamed from: a */
    private synchronized void m9562a(String[] strArr, PermissionsResultAction eVar) {
        if (eVar != null) {
            eVar.mo15633a(strArr);
            this.f7528d.add(eVar);
            this.f7527c.add(new WeakReference(eVar));
        }
    }

    /* renamed from: a */
    private synchronized void m9561a(PermissionsResultAction eVar) {
        Iterator it = this.f7527c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == eVar || weakReference.get() == null) {
                it.remove();
            }
        }
        Iterator it2 = this.f7528d.iterator();
        while (it2.hasNext()) {
            if (((PermissionsResultAction) it2.next()) == eVar) {
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
            return r0;
     */
    /* renamed from: a */
    public synchronized boolean mo15632a(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        monitor-enter(r3)
        r0 = 0
        if (r4 != 0) goto L_0x0006
        monitor-exit(r3)
        return r0
    L_0x0006:
        boolean r1 = com.bytedance.sdk.openadsdk.utils.RomUtils.m11951e()     // Catch:{ all -> 0x0035 }
        r2 = 1
        if (r1 == 0) goto L_0x0024
        boolean r1 = com.bytedance.sdk.openadsdk.core.p172f.MIUIPermissionUtils.m9555a(r4, r5)     // Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0022
        int r4 = com.bytedance.sdk.openadsdk.core.p172f.PermissionActivityCompat.m9558a(r4, r5)     // Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x0021
        java.util.Set<java.lang.String> r4 = r3.f7526b     // Catch:{ all -> 0x0035 }
        boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0035 }
        if (r4 != 0) goto L_0x0022
    L_0x0021:
        r0 = 1
    L_0x0022:
        monitor-exit(r3)
        return r0
    L_0x0024:
        int r4 = com.bytedance.sdk.openadsdk.core.p172f.PermissionActivityCompat.m9558a(r4, r5)     // Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x0032
        java.util.Set<java.lang.String> r4 = r3.f7526b     // Catch:{ all -> 0x0035 }
        boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0035 }
        if (r4 != 0) goto L_0x0033
    L_0x0032:
        r0 = 1
    L_0x0033:
        monitor-exit(r3)
        return r0
    L_0x0035:
        r4 = move-exception
        monitor-exit(r3)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.mo15632a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: a */
    public synchronized void mo15630a(Activity activity, String[] strArr, PermissionsResultAction eVar) {
        if (activity != null) {
            try {
                m9562a(strArr, eVar);
                if (VERSION.SDK_INT < 23) {
                    m9565b(activity, strArr, eVar);
                } else {
                    List c = m9566c(activity, strArr, eVar);
                    if (c.isEmpty()) {
                        m9561a(eVar);
                    } else {
                        PermissionActivityCompat.m9559a(activity, (String[]) c.toArray(new String[c.size()]), 1);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: b */
    private void m9565b(Activity activity, String[] strArr, PermissionsResultAction eVar) {
        boolean z;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.f7526b.contains(str)) {
                        z = eVar.mo15635a(str, Permissions.NOT_FOUND);
                    } else if (PermissionActivityCompat.m9558a(activity, str) != 0) {
                        z = eVar.mo15635a(str, Permissions.DENIED);
                    } else {
                        z = eVar.mo15635a(str, Permissions.GRANTED);
                    }
                    if (z) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        m9561a(eVar);
    }

    /* renamed from: c */
    private List<String> m9566c(Activity activity, String[] strArr, PermissionsResultAction eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!this.f7526b.contains(str)) {
                if (eVar != null) {
                    eVar.mo15635a(str, Permissions.NOT_FOUND);
                }
            } else if (!mo15632a((Context) activity, str)) {
                arrayList.add(str);
            } else if (eVar != null) {
                eVar.mo15635a(str, Permissions.GRANTED);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void mo15631a(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int i = 0;
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (RomUtils.m11951e() && !MIUIPermissionUtils.m9555a(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
                i++;
            }
            m9563a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
            r0.remove();
     */
    /* renamed from: a */
    private void m9563a(java.lang.String[] r6, int[] r7, java.lang.String[] r8) {
        /*
        r5 = this;
        int r8 = r6.length     // Catch:{ all -> 0x0047 }
        int r0 = r7.length     // Catch:{ all -> 0x0047 }
        if (r0 >= r8) goto L_0x0005
        int r8 = r7.length     // Catch:{ all -> 0x0047 }
    L_0x0005:
        java.util.List<java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.f.e>> r0 = r5.f7527c     // Catch:{ all -> 0x0047 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0047 }
    L_0x000b:
        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x0034
        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0047 }
        java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x0047 }
        java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0047 }
        com.bytedance.sdk.openadsdk.core.f.e r1 = (com.bytedance.sdk.openadsdk.core.p172f.PermissionsResultAction) r1     // Catch:{ all -> 0x0047 }
        r2 = 0
    L_0x001e:
        if (r2 >= r8) goto L_0x000b
        if (r1 == 0) goto L_0x0030
        r3 = r6[r2]     // Catch:{ all -> 0x0047 }
        r4 = r7[r2]     // Catch:{ all -> 0x0047 }
        boolean r3 = r1.mo15634a(r3, r4)     // Catch:{ all -> 0x0047 }
        if (r3 == 0) goto L_0x002d
        goto L_0x0030
    L_0x002d:
        int r2 = r2 + 1
        goto L_0x001e
    L_0x0030:
        r0.remove()     // Catch:{ all -> 0x0047 }
        goto L_0x000b
    L_0x0034:
        java.util.List<com.bytedance.sdk.openadsdk.core.f.e> r6 = r5.f7528d     // Catch:{ all -> 0x0047 }
        java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0047 }
    L_0x003a:
        boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0047 }
        if (r7 == 0) goto L_0x004b
        r6.next()     // Catch:{ all -> 0x0047 }
        r6.remove()     // Catch:{ all -> 0x0047 }
        goto L_0x003a
    L_0x0047:
        r6 = move-exception
        r6.printStackTrace()
    L_0x004b:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.m9563a(java.lang.String[], int[], java.lang.String[]):void");
    }
}
