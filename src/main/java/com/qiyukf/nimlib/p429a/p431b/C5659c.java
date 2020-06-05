package com.qiyukf.nimlib.p429a.p431b;

import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5692b;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.unicorn.analytics.C5973a;

/* renamed from: com.qiyukf.nimlib.a.b.c */
public abstract class C5659c {
    /* renamed from: b */
    private static C5659c f18188b;
    /* renamed from: c */
    private static C5659c f18189c;
    /* renamed from: a */
    private boolean f18190a = false;
    /* renamed from: d */
    private SparseArray<Class<? extends C5686a>> f18191d = new SparseArray<>();
    /* renamed from: e */
    private SparseArray<Integer> f18192e = new SparseArray<>();
    /* renamed from: f */
    private SparseArray<C5649a> f18193f = new SparseArray<>();

    protected C5659c() {
        m22838c();
    }

    /* renamed from: a */
    public static C5659c m22837a(boolean z) {
        if ((z ? f18188b : f18189c) == null) {
            synchronized (C5659c.class) {
                if ((z ? f18188b : f18189c) == null) {
                    if (z) {
                        f18188b = new C5661d();
                    } else {
                        f18189c = new C5665e();
                    }
                }
            }
        }
        C5659c cVar = z ? f18188b : f18189c;
        cVar.m22838c();
        return cVar;
    }

    /* renamed from: c */
    private void m22838c() {
        if (!this.f18190a) {
            try {
                mo27846a();
                mo27851b();
                this.f18190a = true;
            } catch (Throwable th) {
                C5264a.m21617a("RF", "register handlers error");
                C5973a.m23884a(th);
                th.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    private static int m22839e(C5888a aVar) {
        return aVar.mo28233h() | (aVar.mo28232g() << 16);
    }

    /* renamed from: a */
    public abstract void mo27846a();

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27847a(Class<? extends C5686a> cls) {
        C5692b bVar = (C5692b) cls.getAnnotation(C5692b.class);
        if (bVar != null) {
            byte a = bVar.mo27899a();
            String[] b = bVar.mo27900b();
            if (!(b == null || b.length == 0)) {
                for (String split : b) {
                    String[] split2 = split.split("#");
                    if (!(split2 == null || split2.length == 0)) {
                        byte parseByte = Byte.parseByte(split2[0]);
                        if (split2.length >= 2) {
                            this.f18192e.put((a << 16) | parseByte, Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                        this.f18191d.put(parseByte | (a << 16), cls);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27848a(Class<? extends C5686a> cls, C5649a aVar) {
        C5692b bVar = (C5692b) cls.getAnnotation(C5692b.class);
        if (bVar != null) {
            byte a = bVar.mo27899a();
            String[] b = bVar.mo27900b();
            if (!(b == null || b.length == 0)) {
                for (String split : b) {
                    String[] split2 = split.split("#");
                    if (!(split2 == null || split2.length == 0)) {
                        byte parseByte = Byte.parseByte(split2[0]) | (a << 16);
                        if (split2.length >= 2) {
                            this.f18192e.append(parseByte, Integer.valueOf(Integer.parseInt(split2[1])));
                        }
                        this.f18191d.append(parseByte, cls);
                        this.f18193f.append(parseByte, aVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean mo27849a(C5888a aVar) {
        return aVar != null && this.f18191d.indexOfKey(m22839e(aVar)) >= 0;
    }

    /* renamed from: b */
    public final Integer mo27850b(C5888a aVar) {
        if (aVar != null) {
            SparseArray<Integer> sparseArray = this.f18192e;
            if (sparseArray != null) {
                return (Integer) sparseArray.get(m22839e(aVar));
            }
        }
        return null;
    }

    /* renamed from: b */
    public abstract void mo27851b();

    /* renamed from: c */
    public final C5649a mo27852c(C5888a aVar) {
        if (aVar != null) {
            SparseArray<C5649a> sparseArray = this.f18193f;
            if (sparseArray != null) {
                return (C5649a) sparseArray.get(m22839e(aVar));
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[SYNTHETIC, Splitter:B:8:0x001b] */
    /* renamed from: d */
    public final com.qiyukf.nimlib.p429a.p442d.C5686a mo27853d(com.qiyukf.nimlib.p473h.p481c.C5888a r5) {
        /*
        r4 = this;
        java.lang.String r0 = "newResponse is error"
        java.lang.String r1 = "ResponseFactory"
        r2 = 0
        if (r5 == 0) goto L_0x0017
        android.util.SparseArray<java.lang.Class<? extends com.qiyukf.nimlib.a.d.a>> r3 = r4.f18191d
        if (r3 != 0) goto L_0x000c
        goto L_0x0017
    L_0x000c:
        int r5 = m22839e(r5)
        java.lang.Object r5 = r3.get(r5)
        java.lang.Class r5 = (java.lang.Class) r5
        goto L_0x0018
    L_0x0017:
        r5 = r2
    L_0x0018:
        if (r5 != 0) goto L_0x001b
        return r2
    L_0x001b:
        java.lang.Object r5 = r5.newInstance()     // Catch:{ InstantiationException -> 0x0024, IllegalAccessException -> 0x0022 }
        com.qiyukf.nimlib.a.d.a r5 = (com.qiyukf.nimlib.p429a.p442d.C5686a) r5     // Catch:{ InstantiationException -> 0x0024, IllegalAccessException -> 0x0022 }
        return r5
    L_0x0022:
        r5 = move-exception
        goto L_0x0025
    L_0x0024:
        r5 = move-exception
    L_0x0025:
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r5)
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p429a.p431b.C5659c.mo27853d(com.qiyukf.nimlib.h.c.a):com.qiyukf.nimlib.a.d.a");
    }
}
