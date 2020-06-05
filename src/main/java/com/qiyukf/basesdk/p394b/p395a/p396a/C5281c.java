package com.qiyukf.basesdk.p394b.p395a.p396a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import java.util.Date;

/* renamed from: com.qiyukf.basesdk.b.a.a.c */
public final class C5281c {
    /* renamed from: a */
    private boolean f17095a;

    /* renamed from: com.qiyukf.basesdk.b.a.a.c$a */
    public static class C5282a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public String f17096a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f17097b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public C5273a f17098c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public long f17099d;
        /* renamed from: e */
        private int f17100e;

        /* renamed from: com.qiyukf.basesdk.b.a.a.c$a$a */
        public static class C5283a {
            /* renamed from: a */
            private String f17101a;
            /* renamed from: b */
            private String f17102b;
            /* renamed from: c */
            private C5273a f17103c = null;
            /* renamed from: d */
            private long f17104d = -1;
            /* renamed from: e */
            private int f17105e = C5284b.f17106a;

            public C5283a(String str, String str2) {
                this.f17101a = str;
                this.f17102b = str2;
            }

            /* renamed from: a */
            public final C5283a mo27133a(long j) {
                this.f17104d = j;
                return this;
            }

            /* renamed from: a */
            public final C5283a mo27134a(C5273a aVar) {
                this.f17103c = aVar;
                return this;
            }

            /* renamed from: a */
            public final C5282a mo27135a() {
                C5282a aVar = new C5282a(this.f17101a, this.f17102b, this.f17103c, this.f17104d, this.f17105e, 0);
                return aVar;
            }
        }

        /* renamed from: com.qiyukf.basesdk.b.a.a.c$a$b */
        public enum C5284b {
            ;
            
            /* renamed from: a */
            public static final int f17106a = 1;
            /* renamed from: b */
            public static final int f17107b = 2;
            /* renamed from: c */
            public static final int f17108c = 3;
            /* renamed from: d */
            public static final int f17109d = 4;

            static {
                f17110e = new int[]{f17106a, f17107b, f17108c, f17109d};
            }
        }

        private C5282a(String str, String str2, C5273a aVar, long j, int i) {
            this.f17098c = null;
            this.f17099d = -1;
            this.f17100e = C5284b.f17106a;
            this.f17096a = str;
            this.f17097b = str2;
            this.f17098c = aVar;
            this.f17099d = j;
            this.f17100e = i;
        }

        /* synthetic */ C5282a(String str, String str2, C5273a aVar, long j, int i, byte b) {
            this(str, str2, aVar, j, i);
        }
    }

    private C5281c() {
    }

    /* renamed from: a */
    public static final C5281c m21686a() {
        return new C5281c();
    }

    /* JADX INFO: unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:55:0x011d in {} preds:[B:54:0x011b, B:39:0x00db, B:48:0x010c, B:49:0x0110]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.calcImmediateDominators(BlockProcessor.java:303)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:255)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:55)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        */
    /* renamed from: a */
    private boolean m21687a(java.lang.String r25, java.lang.String r26, java.lang.String r27, com.qiyukf.basesdk.p394b.p395a.p396a.C5273a r28, long r29) {
        /*
        r24 = this;
        r0 = r25
        r1 = r26
        r2 = r27
        r3 = r28
        r4 = r29
        java.lang.String r6 = "HTTPDownload FAILED CLOSE EX "
        java.lang.String r7 = "http://"
        java.lang.String r8 = "HTTPDownload STAT COST "
        java.lang.String r9 = "HTTPDownload STAT END "
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        java.lang.String r11 = "HTTPDownload GET URL "
        r10.<init>(r11)
        r10.append(r1)
        java.lang.String r10 = r10.toString()
        java.lang.String r11 = "RES"
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r11, r10)
        long r12 = m21688c()
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        java.lang.String r14 = "HTTPDownload STAT START "
        r10.<init>(r14)
        r10.append(r12)
        java.lang.String r10 = r10.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r11, r10)
        if (r3 == 0) goto L_0x003f
        r3.mo27120a(r0)
    L_0x003f:
        boolean r15 = r1.startsWith(r7)     // Catch:{ Exception -> 0x0363, all -> 0x035a }
        if (r15 != 0) goto L_0x0061
        java.lang.String r15 = "https://"
        boolean r15 = r1.startsWith(r15)     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        if (r15 == 0) goto L_0x004e     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        goto L_0x0061     // Catch:{ Exception -> 0x0363, all -> 0x005b }
    L_0x004e:
        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        r15.<init>(r7)     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        r15.append(r1)     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        java.lang.String r1 = r15.toString()     // Catch:{ Exception -> 0x0363, all -> 0x005b }
        goto L_0x0061
    L_0x005b:
        r0 = move-exception
        r1 = r0
        r2 = r6
        r4 = r11
        goto L_0x035e
    L_0x0061:
        boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        if (r7 == 0) goto L_0x0069     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        r7 = r1     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        goto L_0x0071     // Catch:{ Exception -> 0x0356, all -> 0x035a }
    L_0x0069:
        java.lang.String r7 = "(http://|https://)nos.netease.com/nim/"     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        java.lang.String r15 = "https://nim.nosdn.127.net/"     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        java.lang.String r7 = r1.replaceAll(r7, r15)     // Catch:{ Exception -> 0x0356, all -> 0x035a }
    L_0x0071:
        java.lang.String r15 = "RES-DOWN"     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        java.net.HttpURLConnection r7 = com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21853c(r7, r15)     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        r15.<init>(r2)     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        boolean r16 = r15.exists()     // Catch:{ Exception -> 0x0356, all -> 0x035a }
        r14 = 1
        r18 = 0
        if (r16 == 0) goto L_0x0121
        r16 = r11
        long r10 = r15.length()     // Catch:{ Exception -> 0x0118, all -> 0x0113 }
        int r21 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
        if (r21 <= 0) goto L_0x00de
        int r21 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
        if (r21 < 0) goto L_0x00de
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        java.lang.String r2 = "HTTPDownload FAILED MISMATCH OFFSET "     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        r0.<init>(r2)     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        r0.append(r10)     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        java.lang.String r2 = " SIZE "     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        r0.append(r2)     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        r0.append(r4)     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00dc, all -> 0x0113 }
        r4 = r16
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)     // Catch:{ Exception -> 0x00da, all -> 0x034e }
        r15.delete()     // Catch:{ Exception -> 0x00da, all -> 0x034e }
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        r1 = 0
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r1)
    L_0x00d8:
        r1 = 0
        return r1
    L_0x00da:
        r0 = move-exception
        goto L_0x011d
    L_0x00dc:
        r0 = move-exception
        goto L_0x011b
    L_0x00de:
        r4 = r16
        java.lang.String r5 = "Range"
        java.lang.String r15 = "bytes=%d-"
        r26 = r1
        java.lang.Object[] r1 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        java.lang.Long r16 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r17 = 0     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r1[r17] = r16     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        java.lang.String r1 = java.lang.String.format(r15, r1)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r7.setRequestProperty(r5, r1)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        java.lang.String r5 = "HTTPDownload RANGE OFFSET "     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r1.<init>(r5)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r1.append(r10)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r1)     // Catch:{ Exception -> 0x010b, all -> 0x034e }
        r5 = 0
        goto L_0x017b
    L_0x010b:
        r0 = move-exception
        r1 = r26
        goto L_0x011d
    L_0x010f:
        r0 = move-exception
        r26 = r1
        goto L_0x011d
    L_0x0113:
        r0 = move-exception
        r4 = r16
        goto L_0x035c
    L_0x0118:
        r0 = move-exception
        r26 = r1
    L_0x011b:
        r4 = r16
    L_0x011d:
        r29 = r6
        goto L_0x0367
    L_0x0121:
        r26 = r1
        r4 = r11
        java.io.File r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5312a.m21837a(r27)     // Catch:{ Exception -> 0x0350, all -> 0x034e }
        if (r1 != 0) goto L_0x0178
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        java.lang.String r1 = "HTTPDownload FAILED CREATE PATH "     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        r0.append(r2)     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)     // Catch:{ Exception -> 0x016d, all -> 0x0164 }
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        r5 = 0
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r5)
        goto L_0x00d8
    L_0x0164:
        r0 = move-exception
        r5 = 0
        r1 = r0
        r15 = r5
        r20 = r15
        r2 = r6
        goto L_0x03d7
    L_0x016d:
        r0 = move-exception
        r5 = 0
        r1 = r26
        r10 = r5
        r20 = r10
        r29 = r6
        goto L_0x036a
    L_0x0178:
        r5 = 0
        r10 = r18
    L_0x017b:
        int r1 = r7.getResponseCode()     // Catch:{ Exception -> 0x0350, all -> 0x034e }
        java.io.InputStream r15 = r7.getInputStream()     // Catch:{ Exception -> 0x0350, all -> 0x034e }
        r5 = 200(0xc8, float:2.8E-43)
        if (r1 == r5) goto L_0x0246
        r14 = 206(0xce, float:2.89E-43)
        if (r1 != r14) goto L_0x018d
        goto L_0x0246
    L_0x018d:
        r0 = 416(0x1a0, float:5.83E-43)
        if (r1 != r0) goto L_0x0213
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r1 = "HTTPDownload FAILED REASON REQUESTED_RANGE_NOT_SATISFIABLE:"     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.io.InputStream r1 = r7.getErrorStream()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21842a(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0.append(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        boolean r0 = android.text.TextUtils.isEmpty(r27)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        if (r0 != 0) goto L_0x01eb     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0.<init>(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        boolean r1 = r0.exists()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        if (r1 == 0) goto L_0x01eb     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r1.<init>()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r2 = r0.getParent()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r1.append(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r2 = "/"     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r1.append(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r1.append(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r2 = "_tmp"     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r1.append(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r2.<init>(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        boolean r1 = r0.renameTo(r2)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        if (r1 == 0) goto L_0x01e8     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0 = r2     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
    L_0x01e8:
        r0.delete()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
    L_0x01eb:
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
    L_0x0204:
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r15)
        goto L_0x00d8
    L_0x0213:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r1 = "HTTPDownload FAILED REASON: "     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0.<init>(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.io.InputStream r1 = r7.getErrorStream()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r1 = com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21842a(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        r0.append(r1)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
        goto L_0x0204
    L_0x0246:
        if (r1 != r5) goto L_0x024a
        r10 = r18
    L_0x024a:
        if (r3 == 0) goto L_0x0258
        r3.mo27121a(r0, r10)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
        goto L_0x0258
    L_0x0250:
        r0 = move-exception
        r1 = r26
        r29 = r6
        r10 = r15
        goto L_0x0368
    L_0x0258:
        java.lang.String r1 = "Content-Length"
        java.lang.String r1 = r7.getHeaderField(r1)     // Catch:{ Exception -> 0x026a, all -> 0x0265 }
        long r18 = java.lang.Long.parseLong(r1)     // Catch:{ Exception -> 0x026a, all -> 0x0265 }
        long r18 = r10 + r18
        goto L_0x026a
    L_0x0265:
        r0 = move-exception
        r1 = r0
        r2 = r6
        goto L_0x035f
    L_0x026a:
        r29 = r10
        r10 = r18
        if (r3 == 0) goto L_0x0273
        r3.mo27124b(r0, r10)     // Catch:{ Exception -> 0x0250, all -> 0x0265 }
    L_0x0273:
        r1 = 4096(0x1000, float:5.74E-42)
        byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0344, all -> 0x033c }
        java.io.RandomAccessFile r10 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0344, all -> 0x033c }
        java.lang.String r7 = "rws"     // Catch:{ Exception -> 0x0344, all -> 0x033c }
        r10.<init>(r2, r7)     // Catch:{ Exception -> 0x0344, all -> 0x033c }
        r14 = 0
        r22 = r29
        r29 = r6
        r6 = r22
    L_0x0285:
        int r11 = r15.read(r5, r14, r1)     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        if (r11 <= 0) goto L_0x02df     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        r10.seek(r6)     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        r10.write(r5, r14, r11)     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        r14 = r24     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        boolean r1 = r14.f17095a     // Catch:{ Exception -> 0x0336, all -> 0x032f }
        if (r1 == 0) goto L_0x02d2
        r10.close()     // Catch:{ Exception -> 0x02ca, all -> 0x02c2 }
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r15)
    L_0x02c0:
        r0 = 1
        return r0
    L_0x02c2:
        r0 = move-exception
        r2 = r29
        r1 = r0
        r20 = r10
        goto L_0x03d7
    L_0x02ca:
        r0 = move-exception
        r1 = r26
        r20 = r10
        r10 = r15
        goto L_0x036a
    L_0x02d2:
        r1 = r15
        long r14 = (long) r11
        long r6 = r6 + r14
        if (r3 == 0) goto L_0x02da
        r3.mo27121a(r0, r6)     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
    L_0x02da:
        r15 = r1     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
        r1 = 4096(0x1000, float:5.74E-42)     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
        r14 = 0     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
        goto L_0x0285     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
    L_0x02df:
        r1 = r15     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
        r10.close()     // Catch:{ Exception -> 0x032d, all -> 0x0328 }
        if (r3 == 0) goto L_0x0301
        java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        r5.<init>(r2)     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        boolean r2 = r5.exists()     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        if (r2 == 0) goto L_0x02f4     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        r3.mo27123b(r0)     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        goto L_0x0301     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
    L_0x02f4:
        java.lang.String r2 = "file not exist"     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        r3.mo27122a(r0, r2)     // Catch:{ Exception -> 0x02ff, all -> 0x02fa }
        goto L_0x0301
    L_0x02fa:
        r0 = move-exception
        r2 = r29
        r15 = r1
        goto L_0x033f
    L_0x02ff:
        r0 = move-exception
        goto L_0x0348
    L_0x0301:
        long r2 = m21688c()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>(r9)
        r0.append(r2)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        long r2 = r2 - r12
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>(r8)
        r0.append(r2)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r1)
        goto L_0x02c0
    L_0x0328:
        r0 = move-exception
        r2 = r29
        r15 = r1
        goto L_0x0333
    L_0x032d:
        r0 = move-exception
        goto L_0x0338
    L_0x032f:
        r0 = move-exception
        r1 = r15
        r2 = r29
    L_0x0333:
        r20 = r10
        goto L_0x0341
    L_0x0336:
        r0 = move-exception
        r1 = r15
    L_0x0338:
        r20 = r10
        r10 = r1
        goto L_0x034b
    L_0x033c:
        r0 = move-exception
        r1 = r15
        r2 = r6
    L_0x033f:
        r20 = 0
    L_0x0341:
        r1 = r0
        goto L_0x03d7
    L_0x0344:
        r0 = move-exception
        r29 = r6
        r1 = r15
    L_0x0348:
        r10 = r1
        r20 = 0
    L_0x034b:
        r1 = r26
        goto L_0x036a
    L_0x034e:
        r0 = move-exception
        goto L_0x035c
    L_0x0350:
        r0 = move-exception
        r29 = r6
        r1 = r26
        goto L_0x0367
    L_0x0356:
        r0 = move-exception
        r26 = r1
        goto L_0x0364
    L_0x035a:
        r0 = move-exception
        r4 = r11
    L_0x035c:
        r1 = r0
        r2 = r6
    L_0x035e:
        r15 = 0
    L_0x035f:
        r20 = 0
        goto L_0x03d7
    L_0x0363:
        r0 = move-exception
    L_0x0364:
        r29 = r6
        r4 = r11
    L_0x0367:
        r10 = 0
    L_0x0368:
        r20 = 0
    L_0x036a:
        r0.printStackTrace()     // Catch:{ all -> 0x03d2 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d2 }
        java.lang.String r3 = "HTTPDownload FAILED URL "     // Catch:{ all -> 0x03d2 }
        r2.<init>(r3)     // Catch:{ all -> 0x03d2 }
        r2.append(r1)     // Catch:{ all -> 0x03d2 }
        java.lang.String r1 = " EX "     // Catch:{ all -> 0x03d2 }
        r2.append(r1)     // Catch:{ all -> 0x03d2 }
        java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03d2 }
        r2.append(r0)     // Catch:{ all -> 0x03d2 }
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x03d2 }
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)     // Catch:{ all -> 0x03d2 }
        long r0 = m21688c()
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r9)
        r2.append(r0)
        java.lang.String r2 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r2)
        long r0 = r0 - r12
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>(r8)
        r2.append(r0)
        java.lang.String r0 = r2.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r10)
        if (r20 == 0) goto L_0x03d0
        r20.close()     // Catch:{ IOException -> 0x03b6 }
        goto L_0x03d0
    L_0x03b6:
        r0 = move-exception
        r1 = r0
        r1.printStackTrace()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r2 = r29
        r0.<init>(r2)
        java.lang.String r1 = r1.toString()
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)
    L_0x03d0:
        r1 = 0
        return r1
    L_0x03d2:
        r0 = move-exception
        r2 = r29
        r1 = r0
        r15 = r10
    L_0x03d7:
        long r5 = m21688c()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>(r9)
        r0.append(r5)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        long r5 = r5 - r12
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>(r8)
        r0.append(r5)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21624d(r4, r0)
        com.qiyukf.basesdk.p394b.p395a.p404c.C5314b.m21846a(r15)
        if (r20 == 0) goto L_0x041b
        r20.close()     // Catch:{ IOException -> 0x0403 }
        goto L_0x041b
    L_0x0403:
        r0 = move-exception
        r3 = r0
        r3.printStackTrace()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>(r2)
        java.lang.String r2 = r3.toString()
        r0.append(r2)
        java.lang.String r0 = r0.toString()
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r4, r0)
    L_0x041b:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p394b.p395a.p396a.C5281c.m21687a(java.lang.String, java.lang.String, java.lang.String, com.qiyukf.basesdk.b.a.a.a, long):boolean");
    }

    /* renamed from: c */
    private static final long m21688c() {
        return new Date().getTime();
    }

    /* renamed from: a */
    public final boolean mo27131a(C5282a aVar) {
        boolean z;
        String a = aVar.f17096a;
        String b = aVar.f17097b;
        C5273a c = aVar.f17098c;
        long d = aVar.f17099d;
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            if (c != null) {
                c.mo27122a(a, "url or file path is empty");
            }
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= 3) {
                z = false;
                break;
            } else if (m21687a(a, a, b, c, d)) {
                z = true;
                break;
            } else {
                SystemClock.sleep(5000);
                StringBuilder sb = new StringBuilder("HTTPDownload USUAL RETRY ");
                sb.append(i);
                C5264a.m21617a("RES", sb.toString());
                i++;
            }
        }
        if (z) {
            return true;
        }
        if (c != null) {
            c.mo27122a(a, "");
        }
        return false;
    }

    /* renamed from: b */
    public final void mo27132b() {
        this.f17095a = true;
    }
}
