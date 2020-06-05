package com.kwai.filedownloader.message;

import com.kwai.filedownloader.C4583a;
import com.kwai.filedownloader.message.C4683a.C4684a;
import com.kwai.filedownloader.message.C4687d.C4688a;
import com.kwai.filedownloader.message.C4687d.C4689b;
import com.kwai.filedownloader.message.C4687d.C4691d;
import com.kwai.filedownloader.message.C4687d.C4692e;
import com.kwai.filedownloader.message.C4687d.C4696i;
import com.kwai.filedownloader.message.C4687d.C4697j;
import com.kwai.filedownloader.message.C4705h.C4706a;
import com.kwai.filedownloader.message.C4705h.C4707b;
import com.kwai.filedownloader.message.C4705h.C4709d;
import com.kwai.filedownloader.message.C4705h.C4710e;
import com.kwai.filedownloader.message.C4705h.C4714i;
import com.kwai.filedownloader.message.C4705h.C4715j;
import com.kwai.filedownloader.p358f.C4664f;
import java.io.File;

/* renamed from: com.kwai.filedownloader.message.f */
public class C4701f {
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r10v5, types: [com.kwai.filedownloader.message.MessageSnapshot] */
    /* JADX WARNING: type inference failed for: r8v7, types: [com.kwai.filedownloader.message.h$d] */
    /* JADX WARNING: type inference failed for: r8v8, types: [com.kwai.filedownloader.message.d$d] */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.kwai.filedownloader.message.d$f] */
    /* JADX WARNING: type inference failed for: r8v20, types: [com.kwai.filedownloader.message.h$h] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.kwai.filedownloader.message.d$h] */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r0v7, types: [com.kwai.filedownloader.message.d$f] */
    /* JADX WARNING: type inference failed for: r8v29 */
    /* JADX WARNING: type inference failed for: r0v8, types: [com.kwai.filedownloader.message.d$h] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v27
  assigns: [com.kwai.filedownloader.message.d$f, com.kwai.filedownloader.message.d$h]
  uses: [?[OBJECT, ARRAY], com.kwai.filedownloader.message.d$f, com.kwai.filedownloader.message.d$h]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* renamed from: a */
    public static com.kwai.filedownloader.message.MessageSnapshot m19285a(byte r8, com.kwai.filedownloader.p356d.C4621c r9, com.kwai.filedownloader.download.C4634d.C4635a r10) {
        /*
        int r1 = r9.mo25071a()
        r0 = 1
        r2 = 0
        r3 = -4
        if (r8 == r3) goto L_0x0162
        r3 = -3
        if (r8 == r3) goto L_0x0147
        r3 = -1
        if (r8 == r3) goto L_0x0123
        if (r8 == r0) goto L_0x00fe
        r3 = 2
        if (r8 == r3) goto L_0x00c0
        r4 = 3
        if (r8 == r4) goto L_0x00a3
        r4 = 5
        if (r8 == r4) goto L_0x0075
        r4 = 6
        if (r8 == r4) goto L_0x006e
        java.lang.Object[] r4 = new java.lang.Object[r3]
        r4[r2] = r9
        java.lang.Byte r5 = java.lang.Byte.valueOf(r8)
        r4[r0] = r5
        java.lang.String r5 = "it can't takes a snapshot for the task(%s) when its status is %d,"
        java.lang.String r4 = com.kwai.filedownloader.p358f.C4664f.m19135a(r5, r4)
        java.lang.Class<com.kwai.filedownloader.message.f> r6 = com.kwai.filedownloader.message.C4701f.class
        java.lang.Object[] r3 = new java.lang.Object[r3]
        r3[r2] = r9
        java.lang.Byte r8 = java.lang.Byte.valueOf(r8)
        r3[r0] = r8
        com.kwai.filedownloader.p358f.C4660d.m19124d(r6, r5, r3)
        java.lang.Exception r8 = r10.mo25177b()
        if (r8 == 0) goto L_0x004c
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
        java.lang.Exception r10 = r10.mo25177b()
        r8.<init>(r4, r10)
        goto L_0x0051
    L_0x004c:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
        r8.<init>(r4)
    L_0x0051:
        boolean r10 = r9.mo25099q()
        if (r10 == 0) goto L_0x0062
        com.kwai.filedownloader.message.d$d r10 = new com.kwai.filedownloader.message.d$d
        long r2 = r9.mo25089g()
        r10.m48732init(r1, r2, r8)
        goto L_0x0161
    L_0x0062:
        com.kwai.filedownloader.message.h$d r10 = new com.kwai.filedownloader.message.h$d
        long r2 = r9.mo25089g()
        int r9 = (int) r2
        r10.m48758init(r1, r9, r8)
        goto L_0x0161
    L_0x006e:
        com.kwai.filedownloader.message.MessageSnapshot$b r10 = new com.kwai.filedownloader.message.MessageSnapshot$b
        r10.m48722init(r1)
        goto L_0x0161
    L_0x0075:
        boolean r8 = r9.mo25099q()
        if (r8 == 0) goto L_0x008f
        com.kwai.filedownloader.message.d$h r8 = new com.kwai.filedownloader.message.d$h
        long r2 = r9.mo25089g()
        java.lang.Exception r4 = r10.mo25177b()
        int r5 = r10.mo25178c()
        r0 = r8
        r0.m48740init(r1, r2, r4, r5)
        goto L_0x0145
    L_0x008f:
        com.kwai.filedownloader.message.h$h r8 = new com.kwai.filedownloader.message.h$h
        long r2 = r9.mo25089g()
        int r9 = (int) r2
        java.lang.Exception r0 = r10.mo25177b()
        int r10 = r10.mo25178c()
        r8.m48766init(r1, r9, r0, r10)
        goto L_0x0145
    L_0x00a3:
        boolean r8 = r9.mo25099q()
        if (r8 == 0) goto L_0x00b4
        com.kwai.filedownloader.message.d$g r10 = new com.kwai.filedownloader.message.d$g
        long r8 = r9.mo25089g()
        r10.m48738init(r1, r8)
        goto L_0x0161
    L_0x00b4:
        com.kwai.filedownloader.message.h$g r10 = new com.kwai.filedownloader.message.h$g
        long r8 = r9.mo25089g()
        int r9 = (int) r8
        r10.m48764init(r1, r9)
        goto L_0x0161
    L_0x00c0:
        boolean r8 = r9.mo25094l()
        if (r8 == 0) goto L_0x00cb
        java.lang.String r8 = r9.mo25095m()
        goto L_0x00cc
    L_0x00cb:
        r8 = 0
    L_0x00cc:
        boolean r0 = r9.mo25099q()
        if (r0 == 0) goto L_0x00e8
        com.kwai.filedownloader.message.d$c r7 = new com.kwai.filedownloader.message.d$c
        boolean r2 = r10.mo25176a()
        long r3 = r9.mo25090h()
        java.lang.String r5 = r9.mo25092j()
        r0 = r7
        r6 = r8
        r0.m48730init(r1, r2, r3, r5, r6)
        r10 = r7
        goto L_0x0161
    L_0x00e8:
        com.kwai.filedownloader.message.h$c r6 = new com.kwai.filedownloader.message.h$c
        boolean r2 = r10.mo25176a()
        long r3 = r9.mo25090h()
        int r3 = (int) r3
        java.lang.String r4 = r9.mo25092j()
        r0 = r6
        r5 = r8
        r0.m48756init(r1, r2, r3, r4, r5)
        r10 = r6
        goto L_0x0161
    L_0x00fe:
        boolean r8 = r9.mo25099q()
        if (r8 == 0) goto L_0x0113
        com.kwai.filedownloader.message.d$f r8 = new com.kwai.filedownloader.message.d$f
        long r2 = r9.mo25089g()
        long r4 = r9.mo25090h()
        r0 = r8
        r0.m48735init(r1, r2, r4)
        goto L_0x0145
    L_0x0113:
        com.kwai.filedownloader.message.h$f r10 = new com.kwai.filedownloader.message.h$f
        long r2 = r9.mo25089g()
        int r8 = (int) r2
        long r2 = r9.mo25090h()
        int r9 = (int) r2
        r10.m48761init(r1, r8, r9)
        goto L_0x0161
    L_0x0123:
        boolean r8 = r9.mo25099q()
        if (r8 == 0) goto L_0x0137
        com.kwai.filedownloader.message.d$d r8 = new com.kwai.filedownloader.message.d$d
        long r2 = r9.mo25089g()
        java.lang.Exception r9 = r10.mo25177b()
        r8.m48732init(r1, r2, r9)
        goto L_0x0145
    L_0x0137:
        com.kwai.filedownloader.message.h$d r8 = new com.kwai.filedownloader.message.h$d
        long r2 = r9.mo25089g()
        int r9 = (int) r2
        java.lang.Exception r10 = r10.mo25177b()
        r8.m48758init(r1, r9, r10)
    L_0x0145:
        r10 = r8
        goto L_0x0161
    L_0x0147:
        boolean r8 = r9.mo25099q()
        if (r8 == 0) goto L_0x0157
        com.kwai.filedownloader.message.d$b r10 = new com.kwai.filedownloader.message.d$b
        long r8 = r9.mo25090h()
        r10.m48728init(r1, r2, r8)
        goto L_0x0161
    L_0x0157:
        com.kwai.filedownloader.message.h$b r10 = new com.kwai.filedownloader.message.h$b
        long r8 = r9.mo25090h()
        int r9 = (int) r8
        r10.m48754init(r1, r2, r9)
    L_0x0161:
        return r10
    L_0x0162:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
        java.lang.Object[] r9 = new java.lang.Object[r0]
        java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
        r9[r2] = r10
        java.lang.String r10 = "please use #catchWarn instead %d"
        java.lang.String r9 = com.kwai.filedownloader.p358f.C4664f.m19135a(r10, r9)
        r8.<init>(r9)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.message.C4701f.m19285a(byte, com.kwai.filedownloader.d.c, com.kwai.filedownloader.download.d$a):com.kwai.filedownloader.message.MessageSnapshot");
    }

    /* renamed from: a */
    public static MessageSnapshot m19286a(int i, long j, long j2, boolean z) {
        if (j2 <= 2147483647L) {
            return z ? new C4714i(i, (int) j, (int) j2) : new C4715j(i, (int) j, (int) j2);
        }
        if (z) {
            C4696i iVar = new C4696i(i, j, j2);
            return iVar;
        }
        C4697j jVar = new C4697j(i, j, j2);
        return jVar;
    }

    /* renamed from: a */
    public static MessageSnapshot m19287a(int i, long j, Throwable th) {
        return j > 2147483647L ? new C4691d(i, j, th) : new C4709d(i, (int) j, th);
    }

    /* renamed from: a */
    public static MessageSnapshot m19288a(int i, File file, boolean z) {
        long length = file.length();
        return length > 2147483647L ? z ? new C4688a(i, true, length) : new C4689b(i, true, length) : z ? new C4706a(i, true, (int) length) : new C4707b(i, true, (int) length);
    }

    /* renamed from: a */
    public static MessageSnapshot m19289a(C4583a aVar) {
        if (!aVar.mo24897D()) {
            return new C4710e(aVar.mo24915h(), aVar.mo24924q(), aVar.mo24926s());
        }
        C4692e eVar = new C4692e(aVar.mo24915h(), aVar.mo24925r(), aVar.mo24927t());
        return eVar;
    }

    /* renamed from: a */
    public static MessageSnapshot m19290a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.mo25286b() == -3) {
            return new C4684a(messageSnapshot);
        }
        throw new IllegalStateException(C4664f.m19135a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.mo25278m()), Byte.valueOf(messageSnapshot.mo25286b())));
    }
}
