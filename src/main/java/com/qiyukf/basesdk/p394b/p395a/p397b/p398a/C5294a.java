package com.qiyukf.basesdk.p394b.p395a.p397b.p398a;

import android.content.Context;
import android.text.TextUtils;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p399b.C5296a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5299a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5300b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5301c;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5303e;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5304f;
import com.qiyukf.basesdk.p394b.p395a.p397b.p401d.C5305a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p401d.C5306b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5308b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5309c;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5314b;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qiyukf.basesdk.b.a.b.a.a */
public class C5294a {
    /* renamed from: o */
    private static final String f17146o = C5309c.m21831a(C5294a.class);
    /* renamed from: a */
    protected volatile HttpURLConnection f17147a;
    /* renamed from: b */
    protected volatile HttpURLConnection f17148b;
    /* renamed from: c */
    protected volatile boolean f17149c = false;
    /* renamed from: d */
    protected Context f17150d;
    /* renamed from: e */
    protected String f17151e;
    /* renamed from: f */
    protected String f17152f;
    /* renamed from: g */
    protected String f17153g;
    /* renamed from: h */
    protected File f17154h;
    /* renamed from: i */
    protected Object f17155i;
    /* renamed from: j */
    protected String f17156j;
    /* renamed from: k */
    protected boolean f17157k;
    /* renamed from: l */
    protected C5304f f17158l;
    /* renamed from: m */
    protected long f17159m;
    /* renamed from: n */
    protected C5303e f17160n;
    /* renamed from: p */
    private C5300b f17161p;

    public C5294a(Context context, String str, String str2, String str3, File file, Object obj, String str4, C5304f fVar) {
        this.f17150d = context;
        this.f17151e = str;
        this.f17152f = str2;
        this.f17153g = str3;
        this.f17154h = file;
        this.f17155i = obj;
        this.f17156j = str4;
        this.f17157k = true;
        this.f17160n = new C5303e();
        this.f17158l = fVar;
    }

    /* renamed from: a */
    private C5299a m21740a(C5299a aVar) {
        if (this.f17149c) {
            this.f17160n.mo27185a(2);
            this.f17160n.mo27189b((int) OtherError.CONTAINER_INVISIBLE_ERROR);
            C5299a aVar2 = new C5299a(this.f17155i, this.f17156j, OtherError.CONTAINER_INVISIBLE_ERROR, "", "", "uploading is cancelled", null);
            this.f17161p.mo27163b();
            return aVar2;
        } else if (aVar.mo27173a() == 200 && aVar.mo27174b() == null) {
            this.f17160n.mo27185a(0);
            this.f17161p.mo27159a();
            return aVar;
        } else {
            this.f17160n.mo27185a(1);
            this.f17161p.mo27161a(aVar);
            String str = f17146o;
            StringBuilder sb = new StringBuilder("upload error with code: ");
            sb.append(aVar.mo27173a());
            C5264a.m21626e(str, sb.toString());
            return aVar;
        }
    }

    /* renamed from: a */
    private C5299a m21741a(String str, boolean z) {
        C5264a.m21624d(f17146o, "get lbs address");
        long currentTimeMillis = System.currentTimeMillis();
        C5301c a = m21744a(C5306b.m21815a(str), null);
        this.f17160n.mo27190b(System.currentTimeMillis() - currentTimeMillis);
        if (a.mo27175a() == 200) {
            JSONObject b = a.mo27176b();
            this.f17160n.mo27191b(b.getString("lbs"));
            String str2 = f17146o;
            StringBuilder sb = new StringBuilder("LBS address result: ");
            sb.append(b.toString());
            C5264a.m21624d(str2, sb.toString());
            C5308b.m21822a(this.f17150d, b);
            return null;
        }
        this.f17160n.mo27184a();
        this.f17160n.mo27188b();
        C5299a aVar = new C5299a(this.f17155i, this.f17156j, a.mo27175a(), C5309c.m21830a(a, "requestID"), C5309c.m21830a(a, "callbackRetMsg"), a.mo27176b().toString(), null);
        if (!z) {
            m21740a(aVar);
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ea, code lost:
            r12 = r37;
            r7 = r19;
            r6 = r20;
            r4 = r22;
     */
    /* renamed from: a */
    private com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5301c m21742a(android.content.Context r31, java.io.File r32, long r33, int r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, boolean r40) {
        /*
        r30 = this;
        r1 = r30
        long r2 = r32.length()
        com.qiyukf.basesdk.b.a.b.c.e r0 = r1.f17160n
        r0.mo27186a(r2)
        java.lang.String r0 = f17146o
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        java.lang.String r5 = "file length is: "
        r4.<init>(r5)
        r4.append(r2)
        java.lang.String r4 = r4.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r4)
        r0 = r39
        r1.f17156j = r0
        r4 = 0
        r0 = r32
        r12 = r37
        com.qiyukf.basesdk.b.a.b.e.a r0 = com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5309c.m21827a(r0, r12)     // Catch:{ Exception -> 0x01f9 }
        r9 = r33
        r6 = r35
        r5 = r4
        r4 = 1
        r7 = 0
        r15 = 0
    L_0x0033:
        if (r4 == 0) goto L_0x01f8
        r16 = 0
        int r8 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
        if (r8 < 0) goto L_0x0043
        int r8 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
        if (r8 != 0) goto L_0x01f8
        int r8 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
        if (r8 != 0) goto L_0x01f8
    L_0x0043:
        boolean r8 = r1.f17149c     // Catch:{ Exception -> 0x01f4 }
        if (r8 != 0) goto L_0x01f8
        long r13 = (long) r6     // Catch:{ Exception -> 0x01f4 }
        long r11 = r2 - r9
        long r13 = java.lang.Math.min(r13, r11)     // Catch:{ Exception -> 0x01f4 }
        int r8 = (int) r13     // Catch:{ Exception -> 0x01f4 }
        byte[] r13 = r0.mo27212a(r9, r8)     // Catch:{ Exception -> 0x01f4 }
        java.lang.String r14 = f17146o     // Catch:{ Exception -> 0x01f4 }
        r33 = r4
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f4 }
        r34 = r6
        java.lang.String r6 = "upload block size is: "
        r4.<init>(r6)     // Catch:{ Exception -> 0x01f4 }
        r4.append(r8)     // Catch:{ Exception -> 0x01f4 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01f4 }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r14, r4)     // Catch:{ Exception -> 0x01f4 }
        r4 = r31
        r14 = r40
        java.lang.String[] r6 = com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5308b.m21824a(r4, r14)     // Catch:{ Exception -> 0x01f4 }
        int r4 = r6.length     // Catch:{ Exception -> 0x01f4 }
        r22 = r33
        r20 = r34
        r21 = r5
        r19 = r7
        r7 = r13
        r5 = 0
        r13 = 0
        r18 = 0
    L_0x0080:
        if (r13 >= r4) goto L_0x01e3
        r33 = r4
        r4 = r6[r13]     // Catch:{ Exception -> 0x01e1 }
        r23 = r5
        r34 = r6
        long r5 = (long) r8     // Catch:{ Exception -> 0x01e1 }
        long r5 = r5 + r9
        int r24 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
        if (r24 < 0) goto L_0x0099
        java.lang.String r5 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = "upload block is the last block"
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r5, r6)     // Catch:{ Exception -> 0x01e1 }
        r23 = 1
    L_0x0099:
        com.qiyukf.basesdk.b.a.b.c.e r5 = r1.f17160n     // Catch:{ Exception -> 0x01e1 }
        r5.mo27195c(r4)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = r1.f17156j     // Catch:{ Exception -> 0x01e1 }
        r5 = r4
        r4 = r34
        r24 = r6
        r6 = r36
        r25 = r11
        r12 = r7
        r7 = r37
        r27 = r8
        r8 = r24
        r28 = r9
        r24 = r13
        r13 = r25
        r11 = r23
        java.lang.String r5 = com.qiyukf.basesdk.p394b.p395a.p397b.p401d.C5306b.m21817a(r5, r6, r7, r8, r9, r11)     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.b.a.b.c.c r21 = r1.m21745a(r5, r12)     // Catch:{ Exception -> 0x01e1 }
        boolean r5 = r1.f17149c     // Catch:{ Exception -> 0x01e1 }
        if (r5 == 0) goto L_0x00c5
        return r21
    L_0x00c5:
        int r5 = r21.mo27175a()     // Catch:{ Exception -> 0x01e1 }
        r6 = 200(0xc8, float:2.8E-43)
        if (r5 != r6) goto L_0x0149
        org.json.JSONObject r4 = r21.mo27176b()     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r5 = "offset"
        int r4 = r4.getInt(r5)     // Catch:{ Exception -> 0x01e1 }
        long r9 = (long) r4     // Catch:{ Exception -> 0x01e1 }
        org.json.JSONObject r4 = r21.mo27176b()     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r5 = "context"
        java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r5 = r1.f17156j     // Catch:{ Exception -> 0x01e1 }
        boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x01e1 }
        if (r5 != 0) goto L_0x00ef
        com.qiyukf.basesdk.b.a.b.c.b r5 = r1.f17161p     // Catch:{ Exception -> 0x01e1 }
        r5.mo27162a(r4)     // Catch:{ Exception -> 0x01e1 }
    L_0x00ef:
        r1.f17156j = r4     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.b.a.b.c.b r4 = r1.f17161p     // Catch:{ Exception -> 0x01e1 }
        r4.mo27160a(r9, r2)     // Catch:{ Exception -> 0x01e1 }
        int r15 = r15 + 1
        java.lang.String r4 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = "http post success, offset: "
        r5.<init>(r6)     // Catch:{ Exception -> 0x01e1 }
        r5.append(r9)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = ", len: "
        r5.append(r6)     // Catch:{ Exception -> 0x01e1 }
        r5.append(r2)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = ", this is "
        r5.append(r6)     // Catch:{ Exception -> 0x01e1 }
        r5.append(r15)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r6 = " block uploaded"
        r5.append(r6)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r5)     // Catch:{ Exception -> 0x01e1 }
        int r4 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
        if (r4 != 0) goto L_0x012a
        int r4 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
        if (r4 != 0) goto L_0x012a
        r4 = 0
        goto L_0x012c
    L_0x012a:
        r4 = r22
    L_0x012c:
        if (r19 != 0) goto L_0x013e
        int r5 = r20 << 1
        r6 = 1048576(0x100000, float:1.469368E-39)
        int r6 = java.lang.Math.min(r5, r6)     // Catch:{ Exception -> 0x01e1 }
        r12 = r37
        r7 = r19
        r5 = r21
        goto L_0x0033
    L_0x013e:
        r8 = r35
        r22 = r4
        r5 = r21
        r6 = 1
        r4 = r38
        goto L_0x01ea
    L_0x0149:
        r6 = 403(0x193, float:5.65E-43)
        if (r5 == r6) goto L_0x01c1
        r6 = 520(0x208, float:7.29E-43)
        if (r5 == r6) goto L_0x01b9
        com.qiyukf.basesdk.b.a.b.c.e r5 = r1.f17160n     // Catch:{ Exception -> 0x01e1 }
        r6 = 1
        int r7 = r18 + 1
        r5.mo27199e(r7)     // Catch:{ Exception -> 0x01e1 }
        int r5 = r4.length     // Catch:{ Exception -> 0x01e1 }
        if (r7 < r5) goto L_0x0174
        java.lang.String r5 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r9 = "upload block failed with all tries, offset: "
        r8.<init>(r9)     // Catch:{ Exception -> 0x01e1 }
        r9 = r28
        r8.append(r9)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r5, r8)     // Catch:{ Exception -> 0x01e1 }
        r22 = 0
        goto L_0x0176
    L_0x0174:
        r9 = r28
    L_0x0176:
        java.lang.String r5 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r11 = "http post failed: "
        r8.<init>(r11)     // Catch:{ Exception -> 0x01e1 }
        r8.append(r7)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r5, r8)     // Catch:{ Exception -> 0x01e1 }
        if (r19 != 0) goto L_0x01a4
        int r5 = r20 / 2
        r8 = r35
        int r5 = java.lang.Math.max(r5, r8)     // Catch:{ Exception -> 0x01e1 }
        long r11 = (long) r5     // Catch:{ Exception -> 0x01e1 }
        long r11 = java.lang.Math.min(r11, r13)     // Catch:{ Exception -> 0x01e1 }
        int r12 = (int) r11     // Catch:{ Exception -> 0x01e1 }
        byte[] r11 = r0.mo27212a(r9, r12)     // Catch:{ Exception -> 0x01e1 }
        r20 = r5
        r27 = r12
        r19 = 1
        goto L_0x01a7
    L_0x01a4:
        r8 = r35
        r11 = r12
    L_0x01a7:
        int r5 = r24 + 1
        r6 = r4
        r18 = r7
        r7 = r11
        r11 = r13
        r8 = r27
        r4 = r33
        r14 = r40
        r13 = r5
        r5 = r23
        goto L_0x0080
    L_0x01b9:
        java.lang.String r0 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r2 = "callback error."
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r0, r2)     // Catch:{ Exception -> 0x01e1 }
        return r21
    L_0x01c1:
        r9 = r28
        java.lang.String r0 = f17146o     // Catch:{ Exception -> 0x01e1 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r3 = "token is expired, token: "
        r2.<init>(r3)     // Catch:{ Exception -> 0x01e1 }
        r4 = r38
        r2.append(r4)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r3 = ", offset: "
        r2.append(r3)     // Catch:{ Exception -> 0x01e1 }
        r2.append(r9)     // Catch:{ Exception -> 0x01e1 }
        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01e1 }
        com.qiyukf.basesdk.p393a.C5264a.m21626e(r0, r2)     // Catch:{ Exception -> 0x01e1 }
        return r21
    L_0x01e1:
        r0 = move-exception
        goto L_0x01fc
    L_0x01e3:
        r8 = r35
        r4 = r38
        r6 = 1
        r5 = r21
    L_0x01ea:
        r12 = r37
        r7 = r19
        r6 = r20
        r4 = r22
        goto L_0x0033
    L_0x01f4:
        r0 = move-exception
        r21 = r5
        goto L_0x01fc
    L_0x01f8:
        return r5
    L_0x01f9:
        r0 = move-exception
        r21 = r4
    L_0x01fc:
        java.lang.String r2 = f17146o
        java.lang.String r3 = "upload block exception"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r2, r3, r0)
        return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p397b.p398a.C5294a.m21742a(android.content.Context, java.io.File, long, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):com.qiyukf.basesdk.b.a.b.c.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* renamed from: a */
    private com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5301c m21743a(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
        r7 = this;
        java.lang.String[] r8 = com.qiyukf.basesdk.p394b.p395a.p397b.p402e.C5308b.m21824a(r8, r13)
        java.lang.String r13 = f17146o
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        java.lang.String r1 = "upload servers: "
        r0.<init>(r1)
        java.lang.String r1 = java.util.Arrays.toString(r8)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r13, r0)
        java.util.HashMap r13 = new java.util.HashMap
        r13.<init>()
        java.lang.String r0 = "x-nos-token"
        r13.put(r0, r12)
        r12 = 0
        int r0 = r8.length     // Catch:{ Exception -> 0x0064 }
        r1 = 0
        r2 = r12
    L_0x0029:
        if (r1 >= r0) goto L_0x007b
        r3 = r8[r1]     // Catch:{ Exception -> 0x0062 }
        java.lang.String r3 = com.qiyukf.basesdk.p394b.p395a.p397b.p401d.C5306b.m21816a(r3, r9, r10, r11)     // Catch:{ Exception -> 0x0062 }
        java.lang.String r4 = f17146o     // Catch:{ Exception -> 0x0062 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0062 }
        java.lang.String r6 = "break query upload server url: "
        r5.<init>(r6)     // Catch:{ Exception -> 0x0062 }
        r5.append(r3)     // Catch:{ Exception -> 0x0062 }
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0062 }
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r5)     // Catch:{ Exception -> 0x0062 }
        com.qiyukf.basesdk.b.a.b.c.c r2 = r7.m21746b(r3, r13)     // Catch:{ Exception -> 0x0062 }
        boolean r3 = r7.f17149c     // Catch:{ Exception -> 0x0062 }
        if (r3 == 0) goto L_0x004d
        return r2
    L_0x004d:
        int r3 = r2.mo27175a()     // Catch:{ Exception -> 0x0062 }
        r4 = 200(0xc8, float:2.8E-43)
        if (r3 == r4) goto L_0x0061
        int r3 = r2.mo27175a()     // Catch:{ Exception -> 0x0062 }
        r4 = 404(0x194, float:5.66E-43)
        if (r3 != r4) goto L_0x005e
        goto L_0x0061
    L_0x005e:
        int r1 = r1 + 1
        goto L_0x0029
    L_0x0061:
        return r2
    L_0x0062:
        r8 = move-exception
        goto L_0x0066
    L_0x0064:
        r8 = move-exception
        r2 = r12
    L_0x0066:
        java.lang.String r9 = f17146o
        java.lang.String r10 = "get break offset exception"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r9, r10, r8)
        if (r2 != 0) goto L_0x007b
        com.qiyukf.basesdk.b.a.b.c.c r2 = new com.qiyukf.basesdk.b.a.b.c.c
        r8 = 500(0x1f4, float:7.0E-43)
        org.json.JSONObject r9 = new org.json.JSONObject
        r9.<init>()
        r2.m49419init(r8, r9, r12)
    L_0x007b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p397b.p398a.C5294a.m21743a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):com.qiyukf.basesdk.b.a.b.c.c");
    }

    /* renamed from: a */
    private C5301c m21744a(String str, Map<String, String> map) {
        InputStream inputStream;
        C5301c cVar;
        int i = 799;
        try {
            this.f17148b = C5314b.m21852b(str, "NOS-QUERY");
            C5314b.m21849a(this.f17148b, map);
            i = this.f17148b.getResponseCode();
            inputStream = this.f17148b.getInputStream();
            if (inputStream != null) {
                try {
                    String a = C5314b.m21842a(inputStream);
                    String str2 = f17146o;
                    StringBuilder sb = new StringBuilder("code: ");
                    sb.append(i);
                    sb.append(", result: ");
                    sb.append(a);
                    C5264a.m21624d(str2, sb.toString());
                    cVar = new C5301c(i, new JSONObject(a), null);
                } catch (Exception e) {
                    e = e;
                }
            } else {
                cVar = new C5301c(899, new JSONObject(), null);
            }
            C5314b.m21846a((Closeable) inputStream);
            this.f17148b.disconnect();
            this.f17148b = null;
            return cVar;
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            try {
                String str3 = f17146o;
                StringBuilder sb2 = new StringBuilder("http get task exception, error code=");
                sb2.append(i);
                C5264a.m21621b(str3, sb2.toString(), e);
                C5301c cVar2 = new C5301c(i, new JSONObject(), e);
                C5314b.m21846a((Closeable) inputStream);
                this.f17148b.disconnect();
                this.f17148b = null;
                return cVar2;
            } catch (Throwable th) {
                th = th;
                C5314b.m21846a((Closeable) inputStream);
                this.f17148b.disconnect();
                this.f17148b = null;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            C5314b.m21846a((Closeable) inputStream);
            this.f17148b.disconnect();
            this.f17148b = null;
            throw th;
        }
    }

    /* renamed from: a */
    private C5301c m21745a(String str, byte[] bArr) {
        String str2 = "offset";
        String str3 = ", retryTime: ";
        int d = C5290a.m21720c().mo27210d();
        String str4 = f17146o;
        StringBuilder sb = new StringBuilder("user set the retry times is : ");
        sb.append(d);
        C5264a.m21624d(str4, sb.toString());
        int i = 0;
        int i2 = -1;
        C5301c cVar = null;
        while (true) {
            int i3 = i + 1;
            if (i >= d) {
                break;
            }
            try {
                if (this.f17149c) {
                    break;
                }
                String str5 = f17146o;
                StringBuilder sb2 = new StringBuilder("put block to server side with url: ");
                sb2.append(str);
                sb2.append(", length: ");
                sb2.append(bArr.length);
                sb2.append(str3);
                sb2.append(i3);
                C5264a.m21624d(str5, sb2.toString());
                cVar = m21747b(str, bArr);
                if (this.f17149c) {
                    return cVar;
                }
                int a = cVar.mo27175a();
                if (a == 200) {
                    String str6 = f17146o;
                    StringBuilder sb3 = new StringBuilder("http post result is back, result:");
                    sb3.append(cVar.toString());
                    sb3.append(str3);
                    sb3.append(i3);
                    C5264a.m21624d(str6, sb3.toString());
                    JSONObject b = cVar.mo27176b();
                    if (b != null && b.has("context") && b.has(str2)) {
                        int i4 = cVar.mo27176b().getInt(str2);
                        String str7 = f17146o;
                        StringBuilder sb4 = new StringBuilder("http post result success with context: ");
                        sb4.append(this.f17150d);
                        sb4.append(", offset: ");
                        sb4.append(i4);
                        C5264a.m21624d(str7, sb4.toString());
                        i2 = i4;
                    }
                } else if (a == 403 || a == 500 || a == 520) {
                    return cVar;
                } else {
                    if (a == 799) {
                        i2 = -4;
                    } else if (a == 899) {
                        i2 = -5;
                    }
                }
                if (i2 > 0) {
                    String str8 = f17146o;
                    StringBuilder sb5 = new StringBuilder("retryPutFile with success result: ");
                    sb5.append(i2);
                    C5264a.m21624d(str8, sb5.toString());
                    return cVar;
                }
                this.f17160n.mo27193c(this.f17160n.mo27192c() + 1);
                i = i3;
            } catch (Exception e) {
                C5264a.m21621b(f17146o, "put file exception", e);
            }
        }
        return cVar;
    }

    /* renamed from: b */
    private C5301c m21746b(String str, Map<String, String> map) {
        int e = C5290a.m21720c().mo27211e();
        int i = 0;
        C5301c cVar = null;
        while (true) {
            int i2 = i + 1;
            if (i >= e || this.f17149c) {
                return cVar;
            }
            String str2 = f17146o;
            StringBuilder sb = new StringBuilder("query offset with url: ");
            sb.append(str);
            sb.append(", retry times: ");
            sb.append(i2);
            C5264a.m21624d(str2, sb.toString());
            cVar = m21744a(str, map);
            if (cVar.mo27175a() == 200) {
                JSONObject b = cVar.mo27176b();
                String str3 = f17146o;
                StringBuilder sb2 = new StringBuilder("get break offset result:");
                sb2.append(b.toString());
                C5264a.m21624d(str3, sb2.toString());
                return cVar;
            }
            C5303e eVar = this.f17160n;
            eVar.mo27197d(eVar.mo27196d() + 1);
            if (cVar.mo27175a() == 404) {
                C5264a.m21624d(f17146o, "upload file is expired in server side.");
                return cVar;
            }
            i = i2;
        }
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fd, code lost:
            r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fe, code lost:
            r2 = null;
            r7 = r10;
            r10 = r9;
            r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0103, code lost:
            r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0104, code lost:
            r10 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0103 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000c] */
    /* renamed from: b */
    private com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5301c m21747b(java.lang.String r9, byte[] r10) {
        /*
        r8 = this;
        java.lang.String r0 = f17146o
        java.lang.String r1 = "http post task is executing"
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r0, r1)
        r0 = 799(0x31f, float:1.12E-42)
        r1 = 0
        java.lang.String r2 = "NOS-Upload"
        java.net.HttpURLConnection r9 = com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21843a(r9, r2)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r8.f17147a = r9     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        int r2 = r10.length     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21847a(r9, r2)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r2 = "x-nos-token"
        java.lang.String r3 = r8.f17151e     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21848a(r9, r2, r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 == 0) goto L_0x009f
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r9 = r9.mo27202b()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 != 0) goto L_0x003e
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r2 = "Content-Type"
        com.qiyukf.basesdk.b.a.b.c.f r3 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r3 = r3.mo27202b()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21848a(r9, r2, r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x003e:
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r9 = r9.mo27200a()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 != 0) goto L_0x0057
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r2 = "Content-MD5"
        com.qiyukf.basesdk.b.a.b.c.f r3 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r3 = r3.mo27200a()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21848a(r9, r2, r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x0057:
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.util.Map r9 = r9.mo27204c()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 == 0) goto L_0x009f
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.util.Map r9 = r9.mo27204c()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        int r9 = r9.size()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 <= 0) goto L_0x009f
        com.qiyukf.basesdk.b.a.b.c.f r9 = r8.f17158l     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.util.Map r9 = r9.mo27204c()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.util.Set r2 = r9.keySet()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x0079:
        boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r3 == 0) goto L_0x009f
        java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.net.HttpURLConnection r4 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r6 = "x-nos-meta-"
        r5.<init>(r6)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r5.append(r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.Object r3 = r9.get(r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21848a(r4, r5, r3)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        goto L_0x0079
    L_0x009f:
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21850a(r9, r10)     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.net.HttpURLConnection r9 = r8.f17147a     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        int r9 = r9.getResponseCode()     // Catch:{ Exception -> 0x0106, all -> 0x0103 }
        java.net.HttpURLConnection r10 = r8.f17147a     // Catch:{ Exception -> 0x00fd, all -> 0x0103 }
        java.io.InputStream r10 = r10.getInputStream()     // Catch:{ Exception -> 0x00fd, all -> 0x0103 }
        if (r10 == 0) goto L_0x00ea
        java.lang.String r2 = com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21842a(r10)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r3 = 200(0xc8, float:2.8E-43)
        if (r9 != r3) goto L_0x00ce
        java.lang.String r3 = f17146o     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.String r5 = "http post response is correct, response: "
        r4.<init>(r5)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r4.append(r2)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
    L_0x00ca:
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r3, r4)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        goto L_0x00df
    L_0x00ce:
        java.lang.String r3 = f17146o     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.String r5 = "http post response is failed, status code: "
        r4.<init>(r5)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r4.append(r9)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        goto L_0x00ca
    L_0x00df:
        com.qiyukf.basesdk.b.a.b.c.c r3 = new com.qiyukf.basesdk.b.a.b.c.c     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r4.<init>(r2)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r3.m49419init(r9, r4, r1)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        goto L_0x00f1
    L_0x00ea:
        com.qiyukf.basesdk.b.a.b.c.c r3 = new com.qiyukf.basesdk.b.a.b.c.c     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
        r2 = 899(0x383, float:1.26E-42)
        r3.m49419init(r2, r1, r1)     // Catch:{ Exception -> 0x00f7, all -> 0x00f5 }
    L_0x00f1:
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r10)
        goto L_0x012a
    L_0x00f5:
        r9 = move-exception
        goto L_0x0134
    L_0x00f7:
        r2 = move-exception
        r7 = r10
        r10 = r9
        r9 = r2
        r2 = r7
        goto L_0x010a
    L_0x00fd:
        r10 = move-exception
        r2 = r1
        r7 = r10
        r10 = r9
        r9 = r7
        goto L_0x010a
    L_0x0103:
        r9 = move-exception
        r10 = r1
        goto L_0x0134
    L_0x0106:
        r9 = move-exception
        r2 = r1
        r10 = 799(0x31f, float:1.12E-42)
    L_0x010a:
        java.lang.String r3 = f17146o     // Catch:{ all -> 0x0132 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0132 }
        java.lang.String r5 = "http post exception, status code="
        r4.<init>(r5)     // Catch:{ all -> 0x0132 }
        r4.append(r10)     // Catch:{ all -> 0x0132 }
        java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0132 }
        com.qiyukf.basesdk.p393a.C5264a.m21623c(r3, r10, r9)     // Catch:{ all -> 0x0132 }
        com.qiyukf.basesdk.b.a.b.c.c r3 = new com.qiyukf.basesdk.b.a.b.c.c     // Catch:{ all -> 0x0132 }
        org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x0132 }
        r10.<init>()     // Catch:{ all -> 0x0132 }
        r3.m49419init(r0, r10, r9)     // Catch:{ all -> 0x0132 }
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r2)
    L_0x012a:
        java.net.HttpURLConnection r9 = r8.f17147a
        r9.disconnect()
        r8.f17147a = r1
        return r3
    L_0x0132:
        r9 = move-exception
        r10 = r2
    L_0x0134:
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r10)
        java.net.HttpURLConnection r10 = r8.f17147a
        r10.disconnect()
        r8.f17147a = r1
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p397b.p398a.C5294a.m21747b(java.lang.String, byte[]):com.qiyukf.basesdk.b.a.b.c.c");
    }

    /* renamed from: a */
    public final void mo27166a() {
        C5264a.m21624d(f17146o, "uploading is canceling");
        this.f17149c = true;
        if (this.f17148b != null) {
            this.f17148b.disconnect();
        }
        if (this.f17147a != null) {
            this.f17147a.disconnect();
        }
    }

    /* renamed from: a */
    public final void mo27167a(C5300b bVar) {
        this.f17161p = bVar;
    }

    /* renamed from: b */
    public final C5299a mo27168b() {
        if (this.f17149c) {
            return null;
        }
        try {
            this.f17160n.mo27198d(C5309c.m21829a(this.f17150d));
            this.f17160n.mo27187a(C5309c.m21828a());
            boolean a = C5308b.m21823a(this.f17150d);
            String str = f17146o;
            StringBuilder sb = new StringBuilder("lbs storage ");
            sb.append(a ? "valid" : "invalid");
            C5264a.m21624d(str, sb.toString());
            String b = C5308b.m21825b(this.f17150d);
            C5299a a2 = !TextUtils.isEmpty(b) ? m21741a(b, true) : null;
            if (TextUtils.isEmpty(b) || a2 != null) {
                a2 = m21741a(C5263a.m21612e(), false);
            }
            if (a2 != null) {
                return a2;
            }
            if (TextUtils.isEmpty(this.f17158l.mo27200a())) {
                this.f17158l.mo27201a(C5405c.m22115b(this.f17154h.getPath()));
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "callbackRetMsg";
            String str3 = "requestID";
            if (this.f17156j != null) {
                if (!this.f17156j.equals("")) {
                    C5301c a3 = m21743a(this.f17150d, this.f17152f, this.f17153g, this.f17156j, this.f17151e, this.f17157k);
                    if (a3.mo27175a() != 404) {
                        if (a3.mo27175a() != 400) {
                            if (a3.mo27175a() == 200) {
                                this.f17159m = (long) a3.mo27176b().getInt("offset");
                            } else {
                                C5299a aVar = new C5299a(this.f17155i, this.f17156j, a3.mo27175a(), C5309c.m21830a(a3, str3), C5309c.m21830a(a3, str2), a3.mo27176b().toString(), null);
                                return m21740a(aVar);
                            }
                        }
                    }
                    this.f17156j = null;
                }
            }
            if ((this.f17159m < this.f17154h.length() || this.f17154h.length() == 0) && this.f17159m >= 0) {
                Context context = this.f17150d;
                File file = this.f17154h;
                long j = this.f17159m;
                C5290a.m21720c();
                String str4 = str3;
                String str5 = str2;
                C5301c a4 = m21742a(context, file, j, C5305a.m21810c(), this.f17152f, this.f17153g, this.f17151e, this.f17156j, this.f17157k);
                if (a4 == null) {
                    a4 = new C5301c(500, new JSONObject(), null);
                }
                this.f17160n.mo27194c(System.currentTimeMillis() - currentTimeMillis);
                this.f17160n.mo27189b(a4.mo27175a());
                C5299a aVar2 = new C5299a(this.f17155i, this.f17156j, a4.mo27175a(), C5309c.m21830a(a4, str4), C5309c.m21830a(a4, str5), a4.mo27176b().toString(), null);
                return m21740a(aVar2);
            }
            Object obj = this.f17155i;
            String str6 = this.f17156j;
            StringBuilder sb2 = new StringBuilder("offset is invalid in server side, with offset: ");
            sb2.append(this.f17159m);
            sb2.append(", file length: ");
            sb2.append(this.f17154h.length());
            C5299a aVar3 = new C5299a(obj, str6, 699, "", "", null, new C5296a(sb2.toString()));
            m21740a(aVar3);
            return aVar3;
        } catch (Exception e) {
            Exception exc = e;
            C5264a.m21621b(f17146o, "offset result exception", exc);
            C5299a aVar4 = new C5299a(this.f17155i, this.f17156j, 799, "", "", null, exc);
            m21740a(aVar4);
            return aVar4;
        }
    }
}
