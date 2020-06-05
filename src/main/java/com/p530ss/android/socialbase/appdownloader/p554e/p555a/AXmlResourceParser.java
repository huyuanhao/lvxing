package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.a */
class AXmlResourceParser implements C6621i {
    /* renamed from: b */
    private IntReader f21548b;
    /* renamed from: c */
    private boolean f21549c = false;
    /* renamed from: d */
    private StringBlock f21550d;
    /* renamed from: e */
    private int[] f21551e;
    /* renamed from: f */
    private C6620a f21552f = new C6620a();
    /* renamed from: g */
    private boolean f21553g;
    /* renamed from: h */
    private int f21554h;
    /* renamed from: i */
    private int f21555i;
    /* renamed from: j */
    private int f21556j;
    /* renamed from: k */
    private int f21557k;
    /* renamed from: l */
    private int[] f21558l;
    /* renamed from: m */
    private int f21559m;
    /* renamed from: n */
    private int f21560n;
    /* renamed from: o */
    private int f21561o;

    /* compiled from: AXmlResourceParser */
    /* renamed from: com.ss.android.socialbase.appdownloader.e.a.a$a */
    private static final class C6620a {
        /* renamed from: a */
        private int[] f21562a = new int[32];
        /* renamed from: b */
        private int f21563b;
        /* renamed from: c */
        private int f21564c;

        /* renamed from: a */
        public final void mo31520a() {
            this.f21563b = 0;
            this.f21564c = 0;
        }

        /* renamed from: b */
        public final int mo31522b() {
            int i = this.f21563b;
            if (i == 0) {
                return 0;
            }
            return this.f21562a[i - 1];
        }

        /* renamed from: a */
        public final void mo31521a(int i, int i2) {
            if (this.f21564c == 0) {
                mo31525e();
            }
            m26790a(2);
            int i3 = this.f21563b;
            int i4 = i3 - 1;
            int[] iArr = this.f21562a;
            int i5 = iArr[i4];
            int i6 = i5 + 1;
            iArr[(i4 - 1) - (i5 * 2)] = i6;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i6;
            this.f21563b = i3 + 2;
        }

        /* renamed from: c */
        public final boolean mo31523c() {
            int i = this.f21563b;
            if (i == 0) {
                return false;
            }
            int i2 = i - 1;
            int[] iArr = this.f21562a;
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            int i4 = i3 - 1;
            int i5 = i2 - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.f21563b = i - 2;
            return true;
        }

        /* renamed from: d */
        public final int mo31524d() {
            return this.f21564c;
        }

        /* renamed from: e */
        public final void mo31525e() {
            m26790a(2);
            int i = this.f21563b;
            int[] iArr = this.f21562a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.f21563b = i + 2;
            this.f21564c++;
        }

        /* renamed from: f */
        public final void mo31526f() {
            int i = this.f21563b;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.f21562a[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.f21563b = i - (i3 + 2);
                    this.f21564c--;
                }
            }
        }

        /* renamed from: a */
        private void m26790a(int i) {
            int[] iArr = this.f21562a;
            int length = iArr.length;
            int i2 = this.f21563b;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[((iArr.length + i3) * 2)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.f21562a = iArr2;
            }
        }
    }

    /* renamed from: f */
    public int mo31519f() {
        return -1;
    }

    public AXmlResourceParser() {
        m26777g();
    }

    /* renamed from: a */
    public void mo31511a(InputStream inputStream) {
        mo31510a();
        if (inputStream != null) {
            this.f21548b = new IntReader(inputStream, false);
        }
    }

    /* renamed from: a */
    public void mo31510a() {
        if (this.f21549c) {
            this.f21549c = false;
            this.f21548b.mo31528a();
            this.f21548b = null;
            this.f21550d = null;
            this.f21551e = null;
            this.f21552f.mo31520a();
            m26777g();
        }
    }

    /* renamed from: b */
    public int mo31512b() throws XmlPullParserException, IOException {
        if (this.f21548b != null) {
            try {
                m26778h();
                return this.f21554h;
            } catch (IOException e) {
                mo31510a();
                throw e;
            }
        } else {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
    }

    /* renamed from: c */
    public int mo31514c() {
        return this.f21555i;
    }

    /* renamed from: d */
    public String mo31516d() {
        StringBuilder sb = new StringBuilder();
        sb.append("XML line #");
        sb.append(mo31514c());
        return sb.toString();
    }

    /* renamed from: e */
    public int mo31518e() {
        if (this.f21554h != 2) {
            return -1;
        }
        return this.f21558l.length / 5;
    }

    /* renamed from: a */
    public String mo31509a(int i) {
        int i2 = this.f21558l[m26776e(i) + 1];
        if (i2 == -1) {
            return "";
        }
        return this.f21550d.mo31535a(i2);
    }

    /* renamed from: b */
    public int mo31513b(int i) {
        return this.f21558l[m26776e(i) + 3];
    }

    /* renamed from: c */
    public int mo31515c(int i) {
        return this.f21558l[m26776e(i) + 4];
    }

    /* renamed from: d */
    public String mo31517d(int i) {
        int e = m26776e(i);
        int[] iArr = this.f21558l;
        if (iArr[e + 3] == 3) {
            return this.f21550d.mo31535a(iArr[e + 2]);
        }
        int i2 = iArr[e + 4];
        return "";
    }

    /* renamed from: e */
    private final int m26776e(int i) {
        if (this.f21554h == 2) {
            int i2 = i * 5;
            if (i2 < this.f21558l.length) {
                return i2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid attribute index (");
            sb.append(i);
            sb.append(").");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    /* renamed from: g */
    private final void m26777g() {
        this.f21554h = -1;
        this.f21555i = -1;
        this.f21556j = -1;
        this.f21557k = -1;
        this.f21558l = null;
        this.f21559m = -1;
        this.f21560n = -1;
        this.f21561o = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0095, code lost:
            throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0190, code lost:
            throw new java.io.IOException(r1.toString());
     */
    /* renamed from: h */
    private final void m26778h() throws java.io.IOException {
        /*
        r10 = this;
        com.ss.android.socialbase.appdownloader.e.a.f r0 = r10.f21550d
        r1 = 1
        if (r0 != 0) goto L_0x0021
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        r2 = 524291(0x80003, float:7.34688E-40)
        com.p530ss.android.socialbase.appdownloader.p554e.p555a.ChunkUtil.m26798a(r0, r2)
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        r0.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        com.ss.android.socialbase.appdownloader.e.a.f r0 = com.p530ss.android.socialbase.appdownloader.p554e.p555a.StringBlock.m26811a(r0)
        r10.f21550d = r0
        com.ss.android.socialbase.appdownloader.e.a.a$a r0 = r10.f21552f
        r0.mo31525e()
        r10.f21549c = r1
    L_0x0021:
        int r0 = r10.f21554h
        if (r0 == r1) goto L_0x0191
        r10.m26777g()
    L_0x0028:
        boolean r2 = r10.f21553g
        r3 = 0
        if (r2 == 0) goto L_0x0034
        r10.f21553g = r3
        com.ss.android.socialbase.appdownloader.e.a.a$a r2 = r10.f21552f
        r2.mo31526f()
    L_0x0034:
        r2 = 3
        if (r0 != r2) goto L_0x004b
        com.ss.android.socialbase.appdownloader.e.a.a$a r4 = r10.f21552f
        int r4 = r4.mo31524d()
        if (r4 != r1) goto L_0x004b
        com.ss.android.socialbase.appdownloader.e.a.a$a r4 = r10.f21552f
        int r4 = r4.mo31522b()
        if (r4 != 0) goto L_0x004b
        r10.f21554h = r1
        goto L_0x0150
    L_0x004b:
        r4 = 1048834(0x100102, float:1.46973E-39)
        if (r0 != 0) goto L_0x0054
        r5 = 1048834(0x100102, float:1.46973E-39)
        goto L_0x005a
    L_0x0054:
        com.ss.android.socialbase.appdownloader.e.a.d r5 = r10.f21548b
        int r5 = r5.mo31531b()
    L_0x005a:
        r6 = 524672(0x80180, float:7.35222E-40)
        r7 = 2
        java.lang.String r8 = ")."
        if (r5 != r6) goto L_0x0096
        com.ss.android.socialbase.appdownloader.e.a.d r2 = r10.f21548b
        int r2 = r2.mo31531b()
        r3 = 8
        if (r2 < r3) goto L_0x007c
        int r3 = r2 % 4
        if (r3 != 0) goto L_0x007c
        com.ss.android.socialbase.appdownloader.e.a.d r3 = r10.f21548b
        int r2 = r2 / 4
        int r2 = r2 - r7
        int[] r2 = r3.mo31532b(r2)
        r10.f21551e = r2
        goto L_0x0028
    L_0x007c:
        java.io.IOException r0 = new java.io.IOException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r3 = "Invalid resource ids size ("
        r1.append(r3)
        r1.append(r2)
        r1.append(r8)
        java.lang.String r1 = r1.toString()
        r0.<init>(r1)
        throw r0
    L_0x0096:
        r6 = 1048832(0x100100, float:1.469727E-39)
        if (r5 < r6) goto L_0x0177
        r9 = 1048836(0x100104, float:1.469732E-39)
        if (r5 > r9) goto L_0x0177
        if (r5 != r4) goto L_0x00a9
        r8 = -1
        if (r0 != r8) goto L_0x00a9
        r10.f21554h = r3
        goto L_0x0150
    L_0x00a9:
        com.ss.android.socialbase.appdownloader.e.a.d r3 = r10.f21548b
        r3.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.d r3 = r10.f21548b
        int r3 = r3.mo31531b()
        com.ss.android.socialbase.appdownloader.e.a.d r8 = r10.f21548b
        r8.mo31533c()
        if (r5 == r6) goto L_0x0151
        r8 = 1048833(0x100101, float:1.469728E-39)
        if (r5 != r8) goto L_0x00c2
        goto L_0x0151
    L_0x00c2:
        r10.f21555i = r3
        if (r5 != r4) goto L_0x011d
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        r10.f21557k = r0
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        r10.f21556j = r0
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        r0.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        int r3 = r0 >>> 16
        int r3 = r3 - r1
        r10.f21559m = r3
        r3 = 65535(0xffff, float:9.1834E-41)
        r0 = r0 & r3
        com.ss.android.socialbase.appdownloader.e.a.d r4 = r10.f21548b
        int r4 = r4.mo31531b()
        r10.f21560n = r4
        int r4 = r10.f21560n
        int r5 = r4 >>> 16
        int r5 = r5 - r1
        r10.f21561o = r5
        r3 = r3 & r4
        int r3 = r3 - r1
        r10.f21560n = r3
        com.ss.android.socialbase.appdownloader.e.a.d r1 = r10.f21548b
        int r0 = r0 * 5
        int[] r0 = r1.mo31532b(r0)
        r10.f21558l = r0
    L_0x0107:
        int[] r0 = r10.f21558l
        int r1 = r0.length
        if (r2 >= r1) goto L_0x0115
        r1 = r0[r2]
        int r1 = r1 >>> 24
        r0[r2] = r1
        int r2 = r2 + 5
        goto L_0x0107
    L_0x0115:
        com.ss.android.socialbase.appdownloader.e.a.a$a r0 = r10.f21552f
        r0.mo31525e()
        r10.f21554h = r7
        goto L_0x0150
    L_0x011d:
        r3 = 1048835(0x100103, float:1.469731E-39)
        if (r5 != r3) goto L_0x0137
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        r10.f21557k = r0
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        r10.f21556j = r0
        r10.f21554h = r2
        r10.f21553g = r1
        goto L_0x0150
    L_0x0137:
        if (r5 == r9) goto L_0x013b
        goto L_0x0028
    L_0x013b:
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        int r0 = r0.mo31531b()
        r10.f21556j = r0
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        r0.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.d r0 = r10.f21548b
        r0.mo31533c()
        r0 = 4
        r10.f21554h = r0
    L_0x0150:
        return
    L_0x0151:
        if (r5 != r6) goto L_0x0166
        com.ss.android.socialbase.appdownloader.e.a.d r2 = r10.f21548b
        int r2 = r2.mo31531b()
        com.ss.android.socialbase.appdownloader.e.a.d r3 = r10.f21548b
        int r3 = r3.mo31531b()
        com.ss.android.socialbase.appdownloader.e.a.a$a r4 = r10.f21552f
        r4.mo31521a(r2, r3)
        goto L_0x0028
    L_0x0166:
        com.ss.android.socialbase.appdownloader.e.a.d r2 = r10.f21548b
        r2.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.d r2 = r10.f21548b
        r2.mo31533c()
        com.ss.android.socialbase.appdownloader.e.a.a$a r2 = r10.f21552f
        r2.mo31523c()
        goto L_0x0028
    L_0x0177:
        java.io.IOException r0 = new java.io.IOException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Invalid chunk type ("
        r1.append(r2)
        r1.append(r5)
        r1.append(r8)
        java.lang.String r1 = r1.toString()
        r0.<init>(r1)
        throw r0
    L_0x0191:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.appdownloader.p554e.p555a.AXmlResourceParser.m26778h():void");
    }
}
