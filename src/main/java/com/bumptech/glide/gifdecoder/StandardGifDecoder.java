package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.gifdecoder.GifDecoder.C1617a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.bumptech.glide.gifdecoder.d */
public class StandardGifDecoder implements GifDecoder {
    /* renamed from: a */
    private static final String f4330a = StandardGifDecoder.class.getSimpleName();
    /* renamed from: b */
    private int[] f4331b;
    /* renamed from: c */
    private final int[] f4332c;
    /* renamed from: d */
    private final C1617a f4333d;
    /* renamed from: e */
    private ByteBuffer f4334e;
    /* renamed from: f */
    private byte[] f4335f;
    /* renamed from: g */
    private short[] f4336g;
    /* renamed from: h */
    private byte[] f4337h;
    /* renamed from: i */
    private byte[] f4338i;
    /* renamed from: j */
    private byte[] f4339j;
    /* renamed from: k */
    private int[] f4340k;
    /* renamed from: l */
    private int f4341l;
    /* renamed from: m */
    private GifHeader f4342m;
    /* renamed from: n */
    private Bitmap f4343n;
    /* renamed from: o */
    private boolean f4344o;
    /* renamed from: p */
    private int f4345p;
    /* renamed from: q */
    private int f4346q;
    /* renamed from: r */
    private int f4347r;
    /* renamed from: s */
    private int f4348s;
    /* renamed from: t */
    private Boolean f4349t;
    /* renamed from: u */
    private Config f4350u;

    public StandardGifDecoder(C1617a aVar, GifHeader bVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        mo12579a(bVar, byteBuffer, i);
    }

    public StandardGifDecoder(C1617a aVar) {
        this.f4332c = new int[256];
        this.f4350u = Config.ARGB_8888;
        this.f4333d = aVar;
        this.f4342m = new GifHeader();
    }

    /* renamed from: a */
    public ByteBuffer mo12554a() {
        return this.f4334e;
    }

    /* renamed from: b */
    public void mo12556b() {
        this.f4341l = (this.f4341l + 1) % this.f4342m.f4315c;
    }

    /* renamed from: a */
    public int mo12578a(int i) {
        if (i < 0 || i >= this.f4342m.f4315c) {
            return -1;
        }
        return ((GifFrame) this.f4342m.f4317e.get(i)).f4310i;
    }

    /* renamed from: c */
    public int mo12557c() {
        if (this.f4342m.f4315c > 0) {
            int i = this.f4341l;
            if (i >= 0) {
                return mo12578a(i);
            }
        }
        return 0;
    }

    /* renamed from: d */
    public int mo12558d() {
        return this.f4342m.f4315c;
    }

    /* renamed from: e */
    public int mo12559e() {
        return this.f4341l;
    }

    /* renamed from: f */
    public void mo12560f() {
        this.f4341l = -1;
    }

    /* renamed from: g */
    public int mo12561g() {
        if (this.f4342m.f4325m == -1) {
            return 1;
        }
        if (this.f4342m.f4325m == 0) {
            return 0;
        }
        return this.f4342m.f4325m + 1;
    }

    /* renamed from: h */
    public int mo12562h() {
        return this.f4334e.limit() + this.f4339j.length + (this.f4340k.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e9, code lost:
            return null;
     */
    /* renamed from: i */
    public synchronized android.graphics.Bitmap mo12563i() {
        /*
        r7 = this;
        monitor-enter(r7)
        com.bumptech.glide.gifdecoder.b r0 = r7.f4342m     // Catch:{ all -> 0x00ea }
        int r0 = r0.f4315c     // Catch:{ all -> 0x00ea }
        r1 = 3
        r2 = 1
        if (r0 <= 0) goto L_0x000d
        int r0 = r7.f4341l     // Catch:{ all -> 0x00ea }
        if (r0 >= 0) goto L_0x003b
    L_0x000d:
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x0039
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
        r3.<init>()     // Catch:{ all -> 0x00ea }
        java.lang.String r4 = "Unable to decode frame, frameCount="
        r3.append(r4)     // Catch:{ all -> 0x00ea }
        com.bumptech.glide.gifdecoder.b r4 = r7.f4342m     // Catch:{ all -> 0x00ea }
        int r4 = r4.f4315c     // Catch:{ all -> 0x00ea }
        r3.append(r4)     // Catch:{ all -> 0x00ea }
        java.lang.String r4 = ", framePointer="
        r3.append(r4)     // Catch:{ all -> 0x00ea }
        int r4 = r7.f4341l     // Catch:{ all -> 0x00ea }
        r3.append(r4)     // Catch:{ all -> 0x00ea }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ea }
        android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ea }
    L_0x0039:
        r7.f4345p = r2     // Catch:{ all -> 0x00ea }
    L_0x003b:
        int r0 = r7.f4345p     // Catch:{ all -> 0x00ea }
        r3 = 0
        if (r0 == r2) goto L_0x00c8
        int r0 = r7.f4345p     // Catch:{ all -> 0x00ea }
        r4 = 2
        if (r0 != r4) goto L_0x0047
        goto L_0x00c8
    L_0x0047:
        r0 = 0
        r7.f4345p = r0     // Catch:{ all -> 0x00ea }
        byte[] r4 = r7.f4335f     // Catch:{ all -> 0x00ea }
        if (r4 != 0) goto L_0x0058
        com.bumptech.glide.gifdecoder.GifDecoder$a r4 = r7.f4333d     // Catch:{ all -> 0x00ea }
        r5 = 255(0xff, float:3.57E-43)
        byte[] r4 = r4.obtainByteArray(r5)     // Catch:{ all -> 0x00ea }
        r7.f4335f = r4     // Catch:{ all -> 0x00ea }
    L_0x0058:
        com.bumptech.glide.gifdecoder.b r4 = r7.f4342m     // Catch:{ all -> 0x00ea }
        java.util.List<com.bumptech.glide.gifdecoder.a> r4 = r4.f4317e     // Catch:{ all -> 0x00ea }
        int r5 = r7.f4341l     // Catch:{ all -> 0x00ea }
        java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00ea }
        com.bumptech.glide.gifdecoder.a r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4     // Catch:{ all -> 0x00ea }
        int r5 = r7.f4341l     // Catch:{ all -> 0x00ea }
        int r5 = r5 - r2
        if (r5 < 0) goto L_0x0074
        com.bumptech.glide.gifdecoder.b r6 = r7.f4342m     // Catch:{ all -> 0x00ea }
        java.util.List<com.bumptech.glide.gifdecoder.a> r6 = r6.f4317e     // Catch:{ all -> 0x00ea }
        java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00ea }
        com.bumptech.glide.gifdecoder.a r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00ea }
        goto L_0x0075
    L_0x0074:
        r5 = r3
    L_0x0075:
        int[] r6 = r4.f4312k     // Catch:{ all -> 0x00ea }
        if (r6 == 0) goto L_0x007c
        int[] r6 = r4.f4312k     // Catch:{ all -> 0x00ea }
        goto L_0x0080
    L_0x007c:
        com.bumptech.glide.gifdecoder.b r6 = r7.f4342m     // Catch:{ all -> 0x00ea }
        int[] r6 = r6.f4313a     // Catch:{ all -> 0x00ea }
    L_0x0080:
        r7.f4331b = r6     // Catch:{ all -> 0x00ea }
        int[] r6 = r7.f4331b     // Catch:{ all -> 0x00ea }
        if (r6 != 0) goto L_0x00aa
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00a6
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
        r1.<init>()     // Catch:{ all -> 0x00ea }
        java.lang.String r4 = "No valid color table found for frame #"
        r1.append(r4)     // Catch:{ all -> 0x00ea }
        int r4 = r7.f4341l     // Catch:{ all -> 0x00ea }
        r1.append(r4)     // Catch:{ all -> 0x00ea }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
        android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
    L_0x00a6:
        r7.f4345p = r2     // Catch:{ all -> 0x00ea }
        monitor-exit(r7)
        return r3
    L_0x00aa:
        boolean r1 = r4.f4307f     // Catch:{ all -> 0x00ea }
        if (r1 == 0) goto L_0x00c2
        int[] r1 = r7.f4331b     // Catch:{ all -> 0x00ea }
        int[] r2 = r7.f4332c     // Catch:{ all -> 0x00ea }
        int[] r3 = r7.f4331b     // Catch:{ all -> 0x00ea }
        int r3 = r3.length     // Catch:{ all -> 0x00ea }
        java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00ea }
        int[] r1 = r7.f4332c     // Catch:{ all -> 0x00ea }
        r7.f4331b = r1     // Catch:{ all -> 0x00ea }
        int[] r1 = r7.f4331b     // Catch:{ all -> 0x00ea }
        int r2 = r4.f4309h     // Catch:{ all -> 0x00ea }
        r1[r2] = r0     // Catch:{ all -> 0x00ea }
    L_0x00c2:
        android.graphics.Bitmap r0 = r7.m5236a(r4, r5)     // Catch:{ all -> 0x00ea }
        monitor-exit(r7)
        return r0
    L_0x00c8:
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00e8
        java.lang.String r0 = f4330a     // Catch:{ all -> 0x00ea }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
        r1.<init>()     // Catch:{ all -> 0x00ea }
        java.lang.String r2 = "Unable to decode frame, status="
        r1.append(r2)     // Catch:{ all -> 0x00ea }
        int r2 = r7.f4345p     // Catch:{ all -> 0x00ea }
        r1.append(r2)     // Catch:{ all -> 0x00ea }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
        android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ea }
    L_0x00e8:
        monitor-exit(r7)
        return r3
    L_0x00ea:
        r0 = move-exception
        monitor-exit(r7)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.mo12563i():android.graphics.Bitmap");
    }

    /* renamed from: j */
    public void mo12564j() {
        this.f4342m = null;
        byte[] bArr = this.f4339j;
        if (bArr != null) {
            this.f4333d.release(bArr);
        }
        int[] iArr = this.f4340k;
        if (iArr != null) {
            this.f4333d.release(iArr);
        }
        Bitmap bitmap = this.f4343n;
        if (bitmap != null) {
            this.f4333d.release(bitmap);
        }
        this.f4343n = null;
        this.f4334e = null;
        this.f4349t = null;
        byte[] bArr2 = this.f4335f;
        if (bArr2 != null) {
            this.f4333d.release(bArr2);
        }
    }

    /* renamed from: a */
    public synchronized void mo12579a(GifHeader bVar, ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.f4345p = 0;
            this.f4342m = bVar;
            this.f4341l = -1;
            this.f4334e = byteBuffer.asReadOnlyBuffer();
            this.f4334e.position(0);
            this.f4334e.order(ByteOrder.LITTLE_ENDIAN);
            this.f4344o = false;
            Iterator it = bVar.f4317e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((GifFrame) it.next()).f4308g == 3) {
                        this.f4344o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f4346q = highestOneBit;
            this.f4348s = bVar.f4318f / highestOneBit;
            this.f4347r = bVar.f4319g / highestOneBit;
            this.f4339j = this.f4333d.obtainByteArray(bVar.f4318f * bVar.f4319g);
            this.f4340k = this.f4333d.obtainIntArray(this.f4348s * this.f4347r);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size must be >=0, not: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public void mo12555a(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.f4350u = config;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported format: ");
        sb.append(config);
        sb.append(", must be one of ");
        sb.append(Config.ARGB_8888);
        sb.append(" or ");
        sb.append(Config.RGB_565);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private Bitmap m5236a(GifFrame aVar, GifFrame aVar2) {
        int[] iArr = this.f4340k;
        int i = 0;
        if (aVar2 == null) {
            Bitmap bitmap = this.f4343n;
            if (bitmap != null) {
                this.f4333d.release(bitmap);
            }
            this.f4343n = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f4308g == 3 && this.f4343n == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f4308g > 0) {
            if (aVar2.f4308g == 2) {
                if (!aVar.f4307f) {
                    int i2 = this.f4342m.f4324l;
                    if (aVar.f4312k == null || this.f4342m.f4322j != aVar.f4309h) {
                        i = i2;
                    }
                } else if (this.f4341l == 0) {
                    this.f4349t = Boolean.valueOf(true);
                }
                int i3 = aVar2.f4305d / this.f4346q;
                int i4 = aVar2.f4303b / this.f4346q;
                int i5 = aVar2.f4304c / this.f4346q;
                int i6 = aVar2.f4302a / this.f4346q;
                int i7 = this.f4348s;
                int i8 = (i4 * i7) + i6;
                int i9 = (i3 * i7) + i8;
                while (i8 < i9) {
                    int i10 = i8 + i5;
                    for (int i11 = i8; i11 < i10; i11++) {
                        iArr[i11] = i;
                    }
                    i8 += this.f4348s;
                }
            } else if (aVar2.f4308g == 3) {
                Bitmap bitmap2 = this.f4343n;
                if (bitmap2 != null) {
                    int i12 = this.f4348s;
                    bitmap2.getPixels(iArr, 0, i12, 0, 0, i12, this.f4347r);
                }
            }
        }
        m5239c(aVar);
        if (aVar.f4306e || this.f4346q != 1) {
            m5238b(aVar);
        } else {
            m5237a(aVar);
        }
        if (this.f4344o && (aVar.f4308g == 0 || aVar.f4308g == 1)) {
            if (this.f4343n == null) {
                this.f4343n = m5242m();
            }
            Bitmap bitmap3 = this.f4343n;
            int i13 = this.f4348s;
            bitmap3.setPixels(iArr, 0, i13, 0, 0, i13, this.f4347r);
        }
        Bitmap m = m5242m();
        int i14 = this.f4348s;
        m.setPixels(iArr, 0, i14, 0, 0, i14, this.f4347r);
        return m;
    }

    /* renamed from: a */
    private void m5237a(GifFrame aVar) {
        GifFrame aVar2 = aVar;
        int[] iArr = this.f4340k;
        int i = aVar2.f4305d;
        int i2 = aVar2.f4303b;
        int i3 = aVar2.f4304c;
        int i4 = aVar2.f4302a;
        boolean z = this.f4341l == 0;
        int i5 = this.f4348s;
        byte[] bArr = this.f4339j;
        int[] iArr2 = this.f4331b;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = aVar2.f4304c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                byte b3 = b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (b3 != b) {
                    int i13 = iArr2[b3];
                    if (i13 != 0) {
                        iArr[i12] = i13;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                GifFrame aVar3 = aVar;
            }
            i6++;
            aVar2 = aVar;
        }
        boolean z2 = this.f4349t == null && z && b != -1;
        this.f4349t = Boolean.valueOf(z2);
    }

    /* renamed from: b */
    private void m5238b(GifFrame aVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        GifFrame aVar2 = aVar;
        int[] iArr = this.f4340k;
        int i6 = aVar2.f4305d / this.f4346q;
        int i7 = aVar2.f4303b / this.f4346q;
        int i8 = aVar2.f4304c / this.f4346q;
        int i9 = aVar2.f4302a / this.f4346q;
        int i10 = this.f4341l;
        Boolean valueOf = Boolean.valueOf(true);
        boolean z2 = i10 == 0;
        int i11 = this.f4346q;
        int i12 = this.f4348s;
        int i13 = this.f4347r;
        byte[] bArr = this.f4339j;
        int[] iArr2 = this.f4331b;
        Boolean bool = this.f4349t;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        int i17 = 8;
        while (i14 < i6) {
            Boolean bool2 = valueOf;
            if (aVar2.f4306e) {
                if (i15 >= i6) {
                    i = i6;
                    i5 = i16 + 1;
                    if (i5 == 2) {
                        i15 = 4;
                    } else if (i5 == 3) {
                        i15 = 2;
                        i17 = 4;
                    } else if (i5 == 4) {
                        i15 = 1;
                        i17 = 2;
                    }
                } else {
                    i = i6;
                    i5 = i16;
                }
                i2 = i15 + i17;
                i16 = i5;
            } else {
                i = i6;
                i2 = i15;
                i15 = i14;
            }
            int i18 = i15 + i7;
            boolean z3 = i11 == 1;
            if (i18 < i13) {
                int i19 = i18 * i12;
                int i20 = i19 + i9;
                int i21 = i20 + i8;
                int i22 = i19 + i12;
                if (i22 < i21) {
                    i21 = i22;
                }
                i3 = i7;
                int i23 = i14 * i11 * aVar2.f4304c;
                if (z3) {
                    int i24 = i20;
                    while (i24 < i21) {
                        int i25 = i8;
                        int i26 = iArr2[bArr[i23] & DeviceInfos.NETWORK_TYPE_UNCONNECTED];
                        if (i26 != 0) {
                            iArr[i24] = i26;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i23 += i11;
                        i24++;
                        i8 = i25;
                    }
                } else {
                    i4 = i8;
                    int i27 = ((i21 - i20) * i11) + i23;
                    int i28 = i20;
                    while (i28 < i21) {
                        int i29 = i21;
                        int a = m5235a(i23, i27, aVar2.f4304c);
                        if (a != 0) {
                            iArr[i28] = a;
                        } else if (z2 && bool == null) {
                            bool = bool2;
                        }
                        i23 += i11;
                        i28++;
                        i21 = i29;
                    }
                    i14++;
                    i15 = i2;
                    i8 = i4;
                    valueOf = bool2;
                    i6 = i;
                    i7 = i3;
                }
            } else {
                i3 = i7;
            }
            i4 = i8;
            i14++;
            i15 = i2;
            i8 = i4;
            valueOf = bool2;
            i6 = i;
            i7 = i3;
        }
        if (this.f4349t == null) {
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            this.f4349t = Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    private int m5235a(int i, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i4 < this.f4346q + i) {
            byte[] bArr = this.f4339j;
            if (i4 >= bArr.length || i4 >= i2) {
                break;
            }
            int i10 = this.f4331b[bArr[i4] & DeviceInfos.NETWORK_TYPE_UNCONNECTED];
            if (i10 != 0) {
                i5 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i7 += (i10 >> 8) & 255;
                i8 += i10 & 255;
                i9++;
            }
            i4++;
        }
        int i11 = i + i3;
        int i12 = i11;
        while (i12 < this.f4346q + i11) {
            byte[] bArr2 = this.f4339j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f4331b[bArr2[i12] & DeviceInfos.NETWORK_TYPE_UNCONNECTED];
            if (i13 != 0) {
                i5 += (i13 >> 24) & 255;
                i6 += (i13 >> 16) & 255;
                i7 += (i13 >> 8) & 255;
                i8 += i13 & 255;
                i9++;
            }
            i12++;
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [short[]] */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r28v1 */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r28v2 */
    /* JADX WARNING: type inference failed for: r22v4 */
    /* JADX WARNING: type inference failed for: r4v16, types: [short] */
    /* JADX WARNING: type inference failed for: r4v18, types: [int] */
    /* JADX WARNING: type inference failed for: r28v5 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r28v6 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r28v7 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r28v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r4v16, types: [short] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short[], code=null, for r3v1, types: [short[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r22v3
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: c */
    private void m5239c(com.bumptech.glide.gifdecoder.GifFrame r30) {
        /*
        r29 = this;
        r0 = r29
        r1 = r30
        if (r1 == 0) goto L_0x000d
        java.nio.ByteBuffer r2 = r0.f4334e
        int r3 = r1.f4311j
        r2.position(r3)
    L_0x000d:
        if (r1 != 0) goto L_0x001a
        com.bumptech.glide.gifdecoder.b r1 = r0.f4342m
        int r1 = r1.f4318f
        com.bumptech.glide.gifdecoder.b r2 = r0.f4342m
        int r2 = r2.f4319g
        int r1 = r1 * r2
        goto L_0x0020
    L_0x001a:
        int r2 = r1.f4304c
        int r1 = r1.f4305d
        int r1 = r1 * r2
    L_0x0020:
        byte[] r2 = r0.f4339j
        if (r2 == 0) goto L_0x0027
        int r2 = r2.length
        if (r2 >= r1) goto L_0x002f
    L_0x0027:
        com.bumptech.glide.gifdecoder.GifDecoder$a r2 = r0.f4333d
        byte[] r2 = r2.obtainByteArray(r1)
        r0.f4339j = r2
    L_0x002f:
        byte[] r2 = r0.f4339j
        short[] r3 = r0.f4336g
        r4 = 4096(0x1000, float:5.74E-42)
        if (r3 != 0) goto L_0x003b
        short[] r3 = new short[r4]
        r0.f4336g = r3
    L_0x003b:
        short[] r3 = r0.f4336g
        byte[] r5 = r0.f4337h
        if (r5 != 0) goto L_0x0045
        byte[] r5 = new byte[r4]
        r0.f4337h = r5
    L_0x0045:
        byte[] r5 = r0.f4337h
        byte[] r6 = r0.f4338i
        if (r6 != 0) goto L_0x0051
        r6 = 4097(0x1001, float:5.741E-42)
        byte[] r6 = new byte[r6]
        r0.f4338i = r6
    L_0x0051:
        byte[] r6 = r0.f4338i
        int r7 = r29.m5240k()
        r8 = 1
        int r9 = r8 << r7
        int r10 = r9 + 1
        int r11 = r9 + 2
        int r7 = r7 + r8
        int r12 = r8 << r7
        int r12 = r12 - r8
        r13 = 0
        r14 = 0
    L_0x0064:
        if (r14 >= r9) goto L_0x006e
        r3[r14] = r13
        byte r15 = (byte) r14
        r5[r14] = r15
        int r14 = r14 + 1
        goto L_0x0064
    L_0x006e:
        byte[] r14 = r0.f4335f
        r15 = -1
        r26 = r7
        r24 = r11
        r25 = r12
        r16 = 0
        r17 = 0
        r18 = 0
        r19 = 0
        r20 = 0
        r21 = -1
        r22 = 0
        r23 = 0
    L_0x0087:
        if (r13 >= r1) goto L_0x015d
        if (r16 != 0) goto L_0x0098
        int r16 = r29.m5241l()
        if (r16 > 0) goto L_0x0096
        r3 = 3
        r0.f4345p = r3
        goto L_0x015d
    L_0x0096:
        r19 = 0
    L_0x0098:
        byte r4 = r14[r19]
        r4 = r4 & 255(0xff, float:3.57E-43)
        int r4 = r4 << r17
        int r18 = r18 + r4
        int r17 = r17 + 8
        int r19 = r19 + 1
        int r16 = r16 + -1
        r4 = r17
        r8 = r21
        r28 = r22
        r27 = r24
        r21 = r20
        r20 = r13
        r13 = r26
    L_0x00b4:
        if (r4 < r13) goto L_0x0141
        r15 = r18 & r25
        int r18 = r18 >> r13
        int r4 = r4 - r13
        if (r15 != r9) goto L_0x00c5
        r13 = r7
        r27 = r11
        r25 = r12
        r8 = -1
    L_0x00c3:
        r15 = -1
        goto L_0x00b4
    L_0x00c5:
        if (r15 != r10) goto L_0x00da
        r17 = r4
        r26 = r13
        r13 = r20
        r20 = r21
        r24 = r27
        r22 = r28
        r4 = 4096(0x1000, float:5.74E-42)
        r15 = -1
        r21 = r8
        r8 = 1
        goto L_0x0087
    L_0x00da:
        r0 = -1
        if (r8 != r0) goto L_0x00eb
        byte r8 = r5[r15]
        r2[r21] = r8
        int r21 = r21 + 1
        int r20 = r20 + 1
        r0 = r29
        r8 = r15
        r28 = r8
        goto L_0x00c3
    L_0x00eb:
        r0 = r27
        r24 = r4
        if (r15 < r0) goto L_0x00fa
        r4 = r28
        byte r4 = (byte) r4
        r6[r23] = r4
        int r23 = r23 + 1
        r4 = r8
        goto L_0x00fb
    L_0x00fa:
        r4 = r15
    L_0x00fb:
        if (r4 < r9) goto L_0x0106
        byte r26 = r5[r4]
        r6[r23] = r26
        int r23 = r23 + 1
        short r4 = r3[r4]
        goto L_0x00fb
    L_0x0106:
        byte r4 = r5[r4]
        r4 = r4 & 255(0xff, float:3.57E-43)
        r26 = r7
        byte r7 = (byte) r4
        r2[r21] = r7
    L_0x010f:
        int r21 = r21 + 1
        int r20 = r20 + 1
        if (r23 <= 0) goto L_0x011c
        int r23 = r23 + -1
        byte r27 = r6[r23]
        r2[r21] = r27
        goto L_0x010f
    L_0x011c:
        r27 = r4
        r4 = 4096(0x1000, float:5.74E-42)
        if (r0 >= r4) goto L_0x0133
        short r8 = (short) r8
        r3[r0] = r8
        r5[r0] = r7
        int r0 = r0 + 1
        r7 = r0 & r25
        if (r7 != 0) goto L_0x0133
        if (r0 >= r4) goto L_0x0133
        int r13 = r13 + 1
        int r25 = r25 + r0
    L_0x0133:
        r8 = r15
        r4 = r24
        r7 = r26
        r28 = r27
        r15 = -1
        r27 = r0
        r0 = r29
        goto L_0x00b4
    L_0x0141:
        r24 = r4
        r0 = r27
        r15 = r28
        r26 = r13
        r22 = r15
        r13 = r20
        r20 = r21
        r17 = r24
        r4 = 4096(0x1000, float:5.74E-42)
        r15 = -1
        r24 = r0
        r21 = r8
        r8 = 1
        r0 = r29
        goto L_0x0087
    L_0x015d:
        r13 = r20
        r0 = 0
        java.util.Arrays.fill(r2, r13, r1, r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.m5239c(com.bumptech.glide.gifdecoder.a):void");
    }

    /* renamed from: k */
    private int m5240k() {
        return this.f4334e.get() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    /* renamed from: l */
    private int m5241l() {
        int k = m5240k();
        if (k <= 0) {
            return k;
        }
        ByteBuffer byteBuffer = this.f4334e;
        byteBuffer.get(this.f4335f, 0, Math.min(k, byteBuffer.remaining()));
        return k;
    }

    /* renamed from: m */
    private Bitmap m5242m() {
        Boolean bool = this.f4349t;
        Config config = (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.f4350u;
        Bitmap obtain = this.f4333d.obtain(this.f4348s, this.f4347r, config);
        obtain.setHasAlpha(true);
        return obtain;
    }
}
