package com.tencent.android.tpush.service.channel.security;

import com.tencent.bigdata.dataacquisition.DeviceInfos;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.security.e */
public class C7044e {
    /* renamed from: a */
    static final /* synthetic */ boolean f23421a = (!C7044e.class.desiredAssertionStatus());
    /* renamed from: b */
    private int[] f23422b = new int[4];

    public C7044e(byte[] bArr) {
        if (bArr == null) {
            throw new RuntimeException("Invalid key: Key was null");
        } else if (bArr.length >= 16) {
            int i = 0;
            int i2 = 0;
            while (i < 4) {
                int i3 = i2 + 1;
                int i4 = i3 + 1;
                byte b = (bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
                int i5 = i4 + 1;
                byte b2 = b | ((bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16);
                int i6 = i5 + 1;
                this.f23422b[i] = b2 | ((bArr[i5] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24);
                i++;
                i2 = i6;
            }
        } else {
            throw new RuntimeException("Invalid key: Length was less than 16 bytes");
        }
    }

    /* renamed from: a */
    public byte[] mo34145a(byte[] bArr) {
        int[] iArr = new int[((((bArr.length / 8) + (bArr.length % 8 == 0 ? 0 : 1)) * 2) + 1)];
        iArr[0] = bArr.length;
        mo34143a(bArr, iArr, 1);
        mo34144a(iArr);
        return mo34146a(iArr, 0, iArr.length * 4);
    }

    /* renamed from: b */
    public byte[] mo34148b(byte[] bArr) {
        if (!f23421a && bArr.length % 4 != 0) {
            throw new AssertionError();
        } else if (f23421a || (bArr.length / 4) % 2 == 1) {
            int[] iArr = new int[(bArr.length / 4)];
            mo34143a(bArr, iArr, 0);
            mo34147b(iArr);
            return mo34146a(iArr, 1, iArr[0]);
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo34144a(int[] iArr) {
        if (f23421a || iArr.length % 2 == 1) {
            for (int i = 1; i < iArr.length; i += 2) {
                int i2 = 32;
                int i3 = iArr[i];
                int i4 = i + 1;
                int i5 = iArr[i4];
                int i6 = 0;
                while (true) {
                    int i7 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    i6 -= 1640531527;
                    int i8 = i5 << 4;
                    int[] iArr2 = this.f23422b;
                    i3 += ((i8 + iArr2[0]) ^ i5) + ((i5 >>> 5) ^ i6) + iArr2[1];
                    i5 += (((i3 << 4) + iArr2[2]) ^ i3) + ((i3 >>> 5) ^ i6) + iArr2[3];
                    i2 = i7;
                }
                iArr[i] = i3;
                iArr[i4] = i5;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo34147b(int[] iArr) {
        if (f23421a || iArr.length % 2 == 1) {
            for (int i = 1; i < iArr.length; i += 2) {
                int i2 = 32;
                int i3 = iArr[i];
                int i4 = i + 1;
                int i5 = iArr[i4];
                int i6 = -957401312;
                while (true) {
                    int i7 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    int i8 = i3 << 4;
                    int[] iArr2 = this.f23422b;
                    i5 -= (((i8 + iArr2[2]) ^ i3) + ((i3 >>> 5) ^ i6)) + iArr2[3];
                    i3 -= ((((i5 << 4) + iArr2[0]) ^ i5) + ((i5 >>> 5) ^ i6)) + iArr2[1];
                    i6 += 1640531527;
                    i2 = i7;
                }
                iArr[i] = i3;
                iArr[i4] = i5;
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v2
  assigns: []
  uses: []
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
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    public void mo34143a(byte[] r7, int[] r8, int r9) {
        /*
        r6 = this;
        boolean r0 = f23421a
        if (r0 != 0) goto L_0x0012
        int r0 = r7.length
        int r0 = r0 / 4
        int r0 = r0 + r9
        int r1 = r8.length
        if (r0 > r1) goto L_0x000c
        goto L_0x0012
    L_0x000c:
        java.lang.AssertionError r7 = new java.lang.AssertionError
        r7.<init>()
        throw r7
    L_0x0012:
        r0 = 0
        r8[r9] = r0
        r1 = 24
        r2 = r9
        r9 = 0
        r3 = 24
    L_0x001b:
        int r4 = r7.length
        if (r9 >= r4) goto L_0x0039
        r4 = r8[r2]
        byte r5 = r7[r9]
        r5 = r5 & 255(0xff, float:3.57E-43)
        int r5 = r5 << r3
        r4 = r4 | r5
        r8[r2] = r4
        if (r3 != 0) goto L_0x0034
        int r2 = r2 + 1
        int r3 = r8.length
        if (r2 >= r3) goto L_0x0031
        r8[r2] = r0
    L_0x0031:
        r3 = 24
        goto L_0x0036
    L_0x0034:
        int r3 = r3 + -8
    L_0x0036:
        int r9 = r9 + 1
        goto L_0x001b
    L_0x0039:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.security.C7044e.mo34143a(byte[], int[], int):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public byte[] mo34146a(int[] iArr, int i, int i2) {
        if (f23421a || i2 <= (iArr.length - i) * 4) {
            byte[] bArr = new byte[i2];
            int i3 = i;
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                bArr[i5] = (byte) ((iArr[i3] >> (24 - (i4 * 8))) & 255);
                i4++;
                if (i4 == 4) {
                    i3++;
                    i4 = 0;
                }
            }
            return bArr;
        }
        throw new AssertionError();
    }
}
