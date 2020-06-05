package com.bytedance.sdk.openadsdk.core.p172f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.core.f.e */
public abstract class PermissionsResultAction {
    /* renamed from: a */
    private static final String f7529a = PermissionsResultAction.class.getSimpleName();
    /* renamed from: b */
    private final Set<String> f7530b = new HashSet(1);
    /* renamed from: c */
    private Looper f7531c = Looper.getMainLooper();

    /* compiled from: PermissionsResultAction */
    /* renamed from: com.bytedance.sdk.openadsdk.core.f.e$5 */
    static /* synthetic */ class C22395 {
        /* renamed from: a */
        static final /* synthetic */ int[] f7538a = new int[Permissions.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.bytedance.sdk.openadsdk.core.f.c[] r0 = com.bytedance.sdk.openadsdk.core.p172f.Permissions.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f7538a = r0
            int[] r0 = f7538a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bytedance.sdk.openadsdk.core.f.c r1 = com.bytedance.sdk.openadsdk.core.p172f.Permissions.GRANTED     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f7538a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bytedance.sdk.openadsdk.core.f.c r1 = com.bytedance.sdk.openadsdk.core.p172f.Permissions.DENIED     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f7538a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bytedance.sdk.openadsdk.core.f.c r1 = com.bytedance.sdk.openadsdk.core.p172f.Permissions.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p172f.PermissionsResultAction.C22395.m43709clinit():void");
        }
    }

    /* renamed from: a */
    public abstract void mo14895a();

    /* renamed from: a */
    public abstract void mo14896a(String str);

    /* renamed from: b */
    public synchronized boolean mo15636b(String str) {
        String str2 = f7529a;
        StringBuilder sb = new StringBuilder();
        sb.append("Permission not found: ");
        sb.append(str);
        Log.d(str2, sb.toString());
        return true;
    }

    /* access modifiers changed from: protected|final|declared_synchronized */
    /* renamed from: a */
    public final synchronized boolean mo15634a(String str, int i) {
        if (i == 0) {
            return mo15635a(str, Permissions.GRANTED);
        }
        return mo15635a(str, Permissions.DENIED);
    }

    /* access modifiers changed from: protected|final|declared_synchronized */
    /* renamed from: a */
    public final synchronized boolean mo15635a(final String str, Permissions cVar) {
        this.f7530b.remove(str);
        int i = C22395.f7538a[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.f7531c).post(new Runnable() {
                    public void run() {
                        PermissionsResultAction.this.mo14896a(str);
                    }
                });
                return true;
            } else if (i == 3) {
                if (!mo15636b(str)) {
                    new Handler(this.f7531c).post(new Runnable() {
                        public void run() {
                            PermissionsResultAction.this.mo14896a(str);
                        }
                    });
                    return true;
                } else if (this.f7530b.isEmpty()) {
                    new Handler(this.f7531c).post(new Runnable() {
                        public void run() {
                            PermissionsResultAction.this.mo14895a();
                        }
                    });
                    return true;
                }
            }
        } else if (this.f7530b.isEmpty()) {
            new Handler(this.f7531c).post(new Runnable() {
                public void run() {
                    PermissionsResultAction.this.mo14895a();
                }
            });
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected|final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo15633a(String[] strArr) {
        Collections.addAll(this.f7530b, strArr);
    }
}
