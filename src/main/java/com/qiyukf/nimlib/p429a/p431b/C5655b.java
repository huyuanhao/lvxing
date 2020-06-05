package com.qiyukf.nimlib.p429a.p431b;

import com.qiyukf.basesdk.p412c.C5420e;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;

/* renamed from: com.qiyukf.nimlib.a.b.b */
public final class C5655b {
    /* renamed from: a */
    private C5420e f18180a;
    /* renamed from: b */
    private C5666f f18181b;
    /* renamed from: c */
    private boolean f18182c;
    /* renamed from: d */
    private C5659c f18183d;

    /* renamed from: com.qiyukf.nimlib.a.b.b$a */
    public static class C5657a extends C5686a {
        /* renamed from: a */
        public final C5898f mo27845a(C5898f fVar) {
            return null;
        }
    }

    public C5655b(boolean z, C5420e eVar, C5666f fVar) {
        this.f18182c = z;
        this.f18180a = eVar;
        this.f18181b = fVar;
        this.f18183d = C5659c.m22837a(z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0070  */
    /* renamed from: a */
    public void m22832a(com.qiyukf.nimlib.p473h.p481c.C5888a r8, com.qiyukf.nimlib.p473h.p481c.p484c.C5898f r9) {
        /*
        r7 = this;
        com.qiyukf.nimlib.a.b.c r0 = r7.f18183d
        com.qiyukf.nimlib.a.d.a r0 = r0.mo27853d(r8)
        boolean r1 = r7.f18182c
        if (r1 == 0) goto L_0x0024
        boolean r1 = com.qiyukf.nimlib.C5743d.m23116b()
        if (r1 != 0) goto L_0x0018
        com.qiyukf.nimlib.a.b.c r1 = r7.f18183d
        boolean r1 = r1.mo27849a(r8)
        if (r1 == 0) goto L_0x0024
    L_0x0018:
        com.qiyukf.nimlib.a.d.a$a r1 = new com.qiyukf.nimlib.a.d.a$a
        r1.m49867init()
        r1.f18231a = r8
        r1.f18232b = r9
        com.qiyukf.nimlib.p470f.C5837d.m23403a(r1)
    L_0x0024:
        if (r0 != 0) goto L_0x002f
        boolean r1 = r7.f18182c
        if (r1 != 0) goto L_0x002f
        com.qiyukf.nimlib.a.b.b$a r0 = new com.qiyukf.nimlib.a.b.b$a
        r0.m49837init()
    L_0x002f:
        if (r0 != 0) goto L_0x0032
        return
    L_0x0032:
        r0.mo27892a(r8)
        boolean r1 = r0.mo27893b()
        r2 = 0
        r3 = 1
        if (r1 == 0) goto L_0x0042
        if (r9 != 0) goto L_0x0040
        goto L_0x0042
    L_0x0040:
        r1 = 0
        goto L_0x0043
    L_0x0042:
        r1 = 1
    L_0x0043:
        r4 = 0
        if (r1 != 0) goto L_0x006d
        com.qiyukf.nimlib.h.c.c.f r9 = r0.mo27845a(r9)     // Catch:{ all -> 0x0060 }
        if (r9 == 0) goto L_0x004d
        r2 = 1
    L_0x004d:
        if (r2 == 0) goto L_0x005e
        com.qiyukf.nimlib.h.c.a r5 = new com.qiyukf.nimlib.h.c.a     // Catch:{ all -> 0x005c }
        r5.m50063init()     // Catch:{ all -> 0x005c }
        r9.mo28261a(r5)     // Catch:{ all -> 0x0059 }
        r4 = r5
        goto L_0x005e
    L_0x0059:
        r3 = move-exception
        r4 = r5
        goto L_0x0062
    L_0x005c:
        r3 = move-exception
        goto L_0x0062
    L_0x005e:
        r1 = 1
        goto L_0x006e
    L_0x0060:
        r3 = move-exception
        r9 = r4
    L_0x0062:
        r3.printStackTrace()
        java.lang.String r5 = "ResponseDispatcher"
        java.lang.String r6 = "handlePacket is error"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r5, r6, r3)
        goto L_0x006e
    L_0x006d:
        r9 = r4
    L_0x006e:
        if (r1 == 0) goto L_0x00d8
        if (r2 == 0) goto L_0x0082
        boolean r1 = r7.f18182c
        if (r1 == 0) goto L_0x007f
        com.qiyukf.nimlib.a.b.c r1 = r7.f18183d
        com.qiyukf.nimlib.a.b.a r1 = r1.mo27852c(r4)
        if (r1 != 0) goto L_0x007f
        return
    L_0x007f:
        r7.m22832a(r4, r9)
    L_0x0082:
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        java.lang.String r1 = "handle packet: "
        r9.<init>(r1)
        r9.append(r8)
        java.lang.String r8 = r9.toString()
        java.lang.String r9 = "core"
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r9, r8)
        com.qiyukf.nimlib.a.b.f r8 = r7.f18181b     // Catch:{ all -> 0x00b7 }
        if (r8 == 0) goto L_0x009e
        com.qiyukf.nimlib.a.b.f r8 = r7.f18181b     // Catch:{ all -> 0x00b7 }
        r8.mo27854a(r0)     // Catch:{ all -> 0x00b7 }
    L_0x009e:
        com.qiyukf.nimlib.a.b.c r8 = r7.f18183d     // Catch:{ all -> 0x00b7 }
        com.qiyukf.nimlib.h.c.a r1 = r0.mo27891a()     // Catch:{ all -> 0x00b7 }
        com.qiyukf.nimlib.a.b.a r8 = r8.mo27852c(r1)     // Catch:{ all -> 0x00b7 }
        if (r8 == 0) goto L_0x00ad
        r8.mo27842a(r0)     // Catch:{ all -> 0x00b7 }
    L_0x00ad:
        com.qiyukf.nimlib.a.b.f r8 = r7.f18181b     // Catch:{ all -> 0x00b7 }
        if (r8 == 0) goto L_0x00b6
        com.qiyukf.nimlib.a.b.f r8 = r7.f18181b     // Catch:{ all -> 0x00b7 }
        r8.mo27855b(r0)     // Catch:{ all -> 0x00b7 }
    L_0x00b6:
        return
    L_0x00b7:
        r8 = move-exception
        r8.printStackTrace()
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r2 = "process response exception: "
        r1.<init>(r2)
        r1.append(r8)
        java.lang.String r8 = " on packet: "
        r1.append(r8)
        com.qiyukf.nimlib.h.c.a r8 = r0.mo27891a()
        r1.append(r8)
        java.lang.String r8 = r1.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21622c(r9, r8)
    L_0x00d8:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p429a.p431b.C5655b.m22832a(com.qiyukf.nimlib.h.c.a, com.qiyukf.nimlib.h.c.c.f):void");
    }

    /* renamed from: a */
    public final void mo27843a(C5687a aVar) {
        final C5888a aVar2 = aVar.f18231a;
        final C5898f fVar = aVar.f18232b;
        final Integer b = this.f18183d.mo27850b(aVar2);
        C56561 r2 = new Runnable() {
            public final void run() {
                C5655b.this.m22832a(aVar2, fVar);
            }
        };
        C5420e eVar = this.f18180a;
        if (b == null) {
            eVar.execute(r2);
        } else {
            eVar.mo27365a(r2, b.intValue());
        }
    }
}
