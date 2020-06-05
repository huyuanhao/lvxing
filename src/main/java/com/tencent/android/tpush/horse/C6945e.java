package com.tencent.android.tpush.horse;

import com.bytedance.embedapplog.GameReportHelper;
import com.tencent.android.tpush.XGPush4Msdk;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.exception.HorseIgnoreException;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p589b.C6979b;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.mid.sotrage.StorageInterface;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.e */
public class C6945e {
    /* renamed from: f */
    private static int f23067f;
    /* renamed from: a */
    public StrategyItem f23068a;
    /* renamed from: b */
    private SocketChannel f23069b;
    /* renamed from: c */
    private ArrayBlockingQueue<C6946a> f23070c = new ArrayBlockingQueue<>(1);
    /* renamed from: d */
    private long f23071d;
    /* renamed from: e */
    private long f23072e;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.e$a */
    public interface C6946a {
        /* renamed from: a */
        void mo33176a(StrategyItem strategyItem);

        /* renamed from: a */
        void mo33177a(StrategyItem strategyItem, StrategyItem strategyItem2);

        /* renamed from: b */
        void mo33178b(StrategyItem strategyItem);
    }

    /* renamed from: a */
    public void mo33234a(StrategyItem strategyItem) {
        String str;
        this.f23071d = System.currentTimeMillis();
        this.f23068a = strategyItem;
        String str2 = ":";
        String str3 = "SocketClient";
        if (XGPush4Msdk.isDebugServerInfoStrategyItem(C6973b.m29776f())) {
            try {
                String debugServerInfo = XGPush4Msdk.getDebugServerInfo(C6973b.m29776f());
                if (!C7056i.m30194b(debugServerInfo)) {
                    String[] split = debugServerInfo.split(StorageInterface.KEY_SPLITER);
                    if (split.length == 2 && split[0].length() > 4) {
                        StrategyItem strategyItem2 = new StrategyItem(split[0], Integer.valueOf(split[1]).intValue(), "", 80, 0, 0);
                        this.f23068a = strategyItem2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("use test StrategyItem:");
                        sb.append(this.f23068a.getServerIp());
                        sb.append(str2);
                        sb.append(this.f23068a.getServerPort());
                        C6864a.m29298c(str3, sb.toString());
                    }
                }
            } catch (Exception e) {
                C6864a.m29302d(str3, " XGPush4Msdk.getDebugServerInfo", e);
            }
        } else if (XGPushConfig.isForeiginPush(XGPushManager.getContext())) {
            String c = C6979b.m29797c();
            if (C6979b.m29796b(c)) {
                StrategyItem strategyItem3 = new StrategyItem(c, DefaultServer.m29600a(), null, DefaultServer.m29600a(), 0, 0);
                this.f23068a = strategyItem3;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("use foreigin StrategyItem:");
                sb2.append(this.f23068a.getServerIp());
                sb2.append(str2);
                sb2.append(this.f23068a.getServerPort());
                C6864a.m29298c(str3, sb2.toString());
            }
        } else if (C6971a.m29749a(XGPushManager.getContext()).f23133D == 1 && f23067f <= 3) {
            try {
                String a = C6979b.m29795a(XGPushManager.getContext()).mo33298a();
                if (C6979b.m29796b(a)) {
                    StrategyItem strategyItem4 = new StrategyItem(a, DefaultServer.m29600a(), "", 80, 0, 0);
                    this.f23068a = strategyItem4;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("use httpdns StrategyItem:");
                    sb3.append(this.f23068a.getServerIp());
                    sb3.append(str2);
                    sb3.append(this.f23068a.getServerPort());
                    C6864a.m29298c(str3, sb3.toString());
                }
            } catch (Throwable th) {
                C6864a.m29302d(str3, "HttpDNS error", th);
                f23067f++;
            }
        }
        try {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("connect to ");
            sb4.append(this.f23068a.getServerIp());
            sb4.append(str2);
            sb4.append(this.f23068a.getServerPort());
            C6864a.m29301d(str3, sb4.toString());
            this.f23069b = SocketChannel.open();
            this.f23069b.configureBlocking(true);
            this.f23069b.socket().connect(m29658b(this.f23068a), C6936b.m29629b());
            this.f23069b.socket().setSoTimeout(C6936b.m29630c());
        } catch (Exception e2) {
            if (C6971a.m29749a(XGPushManager.getContext()).f23133D == 1) {
                f23067f++;
            }
            C6864a.m29302d(str3, "socket connect error", e2);
            m29659d();
            if (strategyItem == null) {
                str = "null";
            } else {
                str = strategyItem.toString();
            }
            throw new HorseIgnoreException(str, e2);
        }
    }

    /* renamed from: b */
    private InetSocketAddress m29658b(StrategyItem strategyItem) {
        if (strategyItem.getProtocolType() != 1 || !strategyItem.isWap()) {
            return new InetSocketAddress(strategyItem.getServerIp(), strategyItem.getServerPort());
        }
        return new InetSocketAddress(strategyItem.getProxyIp(), strategyItem.getProxyPort());
    }

    /* renamed from: a */
    public SocketChannel mo33232a() {
        return this.f23069b;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00e0=Splitter:B:34:0x00e0, B:30:0x00d5=Splitter:B:30:0x00d5} */
    /* renamed from: a */
    public void mo33233a(com.p522qq.taf.jce.JceStruct r9) {
        /*
        r8 = this;
        java.lang.String r0 = ":"
        java.lang.String r1 = "SocketClient -> send "
        java.lang.String r2 = "SocketClient"
        com.qq.taf.jce.JceOutputStream r3 = new com.qq.taf.jce.JceOutputStream
        r3.m50952init()
        java.lang.String r4 = "UTF-8"
        r3.setServerEncoding(r4)
        r9.writeTo(r3)
        com.tencent.android.tpush.service.channel.b.h r9 = new com.tencent.android.tpush.service.channel.b.h
        r4 = 1
        r9.m52085init(r4)
        r4 = 10
        r9.mo33443b(r4)
        r9.mo33441a(r4)
        java.nio.ByteBuffer r3 = r3.getByteBuffer()
        byte[] r3 = r3.array()
        r9.mo33442a(r3)
        r3 = 0
        java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ InnerException -> 0x00f9, IOException -> 0x00ec, UnexpectedDataException -> 0x00df, Exception -> 0x00d4 }
        r4.<init>()     // Catch:{ InnerException -> 0x00f9, IOException -> 0x00ec, UnexpectedDataException -> 0x00df, Exception -> 0x00d4 }
        com.tencent.android.tpush.horse.data.StrategyItem r3 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        int r3 = r3.getProtocolType()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        if (r3 != 0) goto L_0x0044
    L_0x003a:
        boolean r0 = r9.mo33424b()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        if (r0 != 0) goto L_0x00af
        r9.mo33416a(r4)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        goto L_0x003a
    L_0x0044:
        com.tencent.android.tpush.service.channel.b.b r3 = new com.tencent.android.tpush.service.channel.b.b     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r5 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r5 = r5.getServerIp()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.<init>()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r7 = "http://"
        r6.append(r7)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r7 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r7 = r7.getServerIp()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r7)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r0)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r7 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        int r7 = r7.getServerPort()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r7)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r7 = "/"
        r6.append(r7)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r6 = r6.toString()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r3.m52076init(r5, r6)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r5 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        boolean r5 = r5.isWap()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        if (r5 == 0) goto L_0x00a2
        java.lang.String r5 = "X-Online-Host"
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.<init>()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r7 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r7 = r7.getServerIp()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r7)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r0)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.horse.data.StrategyItem r0 = r8.f23068a     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        int r0 = r0.getServerPort()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r6.append(r0)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.lang.String r0 = r6.toString()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r3.mo33419a(r5, r0)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
    L_0x00a2:
        r3.mo33418a(r9)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
    L_0x00a5:
        boolean r9 = r3.mo33424b()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        if (r9 != 0) goto L_0x00af
        r3.mo33416a(r4)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        goto L_0x00a5
    L_0x00af:
        java.nio.channels.SocketChannel r9 = r8.f23069b     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.net.Socket r9 = r9.socket()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        java.io.OutputStream r9 = r9.getOutputStream()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r4.writeTo(r9)     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        r4.flush()     // Catch:{ InnerException -> 0x00ce, IOException -> 0x00cb, UnexpectedDataException -> 0x00c8, Exception -> 0x00c5, all -> 0x00c3 }
        com.tencent.android.tpush.common.C6900b.m29456a(r4)
        goto L_0x00de
    L_0x00c3:
        r9 = move-exception
        goto L_0x0106
    L_0x00c5:
        r9 = move-exception
        r3 = r4
        goto L_0x00d5
    L_0x00c8:
        r9 = move-exception
        r3 = r4
        goto L_0x00e0
    L_0x00cb:
        r9 = move-exception
        r3 = r4
        goto L_0x00ed
    L_0x00ce:
        r9 = move-exception
        r3 = r4
        goto L_0x00fa
    L_0x00d1:
        r9 = move-exception
        r4 = r3
        goto L_0x0106
    L_0x00d4:
        r9 = move-exception
    L_0x00d5:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r9)     // Catch:{ all -> 0x00d1 }
        r8.m29659d()     // Catch:{ all -> 0x00d1 }
        com.tencent.android.tpush.common.C6900b.m29456a(r3)
    L_0x00de:
        return
    L_0x00df:
        r9 = move-exception
    L_0x00e0:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r9)     // Catch:{ all -> 0x00d1 }
        r8.m29659d()     // Catch:{ all -> 0x00d1 }
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException     // Catch:{ all -> 0x00d1 }
        r0.m52105init(r9)     // Catch:{ all -> 0x00d1 }
        throw r0     // Catch:{ all -> 0x00d1 }
    L_0x00ec:
        r9 = move-exception
    L_0x00ed:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r9)     // Catch:{ all -> 0x00d1 }
        r8.m29659d()     // Catch:{ all -> 0x00d1 }
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException     // Catch:{ all -> 0x00d1 }
        r0.m52105init(r9)     // Catch:{ all -> 0x00d1 }
        throw r0     // Catch:{ all -> 0x00d1 }
    L_0x00f9:
        r9 = move-exception
    L_0x00fa:
        com.tencent.android.tpush.p580b.C6864a.m29302d(r2, r1, r9)     // Catch:{ all -> 0x00d1 }
        r8.m29659d()     // Catch:{ all -> 0x00d1 }
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException     // Catch:{ all -> 0x00d1 }
        r0.m52105init(r9)     // Catch:{ all -> 0x00d1 }
        throw r0     // Catch:{ all -> 0x00d1 }
    L_0x0106:
        com.tencent.android.tpush.common.C6900b.m29456a(r4)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6945e.mo33233a(com.qq.taf.jce.JceStruct):void");
    }

    /* renamed from: d */
    private void m29659d() {
        try {
            C6946a aVar = (C6946a) this.f23070c.remove();
            if (aVar != null) {
                aVar.mo33178b(this.f23068a);
            }
        } catch (Exception e) {
            C6864a.m29302d("SocketClient", "notifyFail", e);
        }
        this.f23072e = System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00de  */
    /* renamed from: b */
    public void mo33236b() {
        /*
        r11 = this;
        java.lang.String r0 = "SocketClient -> recv "
        java.lang.String r1 = "SocketClient"
        java.lang.String r2 = ""
        com.tencent.android.tpush.horse.data.StrategyItem r3 = r11.f23068a
        if (r3 == 0) goto L_0x0181
        r4 = 1024(0x400, float:1.435E-42)
        r5 = 0
        r6 = 0
        java.lang.String r7 = "XGService"
        if (r3 == 0) goto L_0x0081
        int r3 = r3.getProtocolType()
        if (r3 != 0) goto L_0x0081
        com.tencent.android.tpush.service.channel.b.g r2 = new com.tencent.android.tpush.service.channel.b.g
        r2.m52084init()
        java.nio.channels.SocketChannel r3 = r11.f23069b     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        java.net.Socket r3 = r3.socket()     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        java.io.InputStream r3 = r3.getInputStream()     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        byte[] r4 = new byte[r4]     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        r8.<init>(r4)     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
    L_0x002e:
        boolean r9 = r2.mo33424b()     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        if (r9 != 0) goto L_0x003e
        int r9 = r4.length     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        int r9 = r9 - r6
        int r6 = r3.read(r4, r6, r9)     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        r2.mo33411a(r8)     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        goto L_0x002e
    L_0x003e:
        byte[] r0 = r2.mo33450k()     // Catch:{ UnexpectedDataException -> 0x0074, IOException -> 0x0067, InnerException -> 0x005a, IndexOutOfBoundsException -> 0x004d, Exception -> 0x0044 }
        goto L_0x00d3
    L_0x0044:
        r2 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r0, r2)
        r11.m29659d()
        goto L_0x00d2
    L_0x004d:
        r2 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r0, r2)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r0.m52105init(r2)
        throw r0
    L_0x005a:
        r2 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r0, r2)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r0.m52105init(r2)
        throw r0
    L_0x0067:
        r2 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r0, r2)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r0.m52105init(r2)
        throw r0
    L_0x0074:
        r2 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r0, r2)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r0.m52105init(r2)
        throw r0
    L_0x0081:
        com.tencent.android.tpush.service.channel.b.a r0 = new com.tencent.android.tpush.service.channel.b.a
        r0.m52073init()
        java.nio.channels.SocketChannel r1 = r11.f23069b     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        java.net.Socket r1 = r1.socket()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        java.io.InputStream r1 = r1.getInputStream()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        byte[] r3 = new byte[r4]     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        r4.<init>(r3)     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        r8 = 0
    L_0x0098:
        boolean r9 = r0.mo33424b()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        if (r9 != 0) goto L_0x00a9
        int r9 = r3.length     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        int r9 = r9 - r8
        int r9 = r1.read(r3, r8, r9)     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        int r8 = r8 + r9
        r0.mo33411a(r4)     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        goto L_0x0098
    L_0x00a9:
        java.util.ArrayList<com.tencent.android.tpush.service.channel.b.g> r1 = r0.f23336i     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        if (r1 == 0) goto L_0x00c2
        java.util.ArrayList<com.tencent.android.tpush.service.channel.b.g> r1 = r0.f23336i     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        int r1 = r1.size()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        if (r1 <= 0) goto L_0x00c2
        java.util.ArrayList<com.tencent.android.tpush.service.channel.b.g> r0 = r0.f23336i     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        com.tencent.android.tpush.service.channel.b.g r0 = (com.tencent.android.tpush.service.channel.p592b.C7027g) r0     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        byte[] r0 = r0.mo33450k()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        goto L_0x00d3
    L_0x00c2:
        java.lang.String r0 = ">> packet is null or packet.recvPackets is null"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r7, r0)     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        r11.m29659d()     // Catch:{ UnexpectedDataException -> 0x0174, IOException -> 0x0167, InnerException -> 0x015a, IndexOutOfBoundsException -> 0x014d, Exception -> 0x00cb }
        return
    L_0x00cb:
        r0 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r0)
        r11.m29659d()
    L_0x00d2:
        r0 = r5
    L_0x00d3:
        if (r0 != 0) goto L_0x00de
        java.lang.String r0 = ">> dataBuffer is null"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r7, r0)
        r11.m29659d()
        return
    L_0x00de:
        com.qq.taf.jce.JceInputStream r1 = new com.qq.taf.jce.JceInputStream
        r1.m50949init(r0)
        java.lang.String r0 = "UTF-8"
        r1.setServerEncoding(r0)
        com.tencent.android.tpush.service.channel.protocol.TpnsRedirectRsp r0 = new com.tencent.android.tpush.service.channel.protocol.TpnsRedirectRsp
        r0.m52213init()
        r0.readFrom(r1)
        java.util.concurrent.ArrayBlockingQueue<com.tencent.android.tpush.horse.e$a> r1 = r11.f23070c     // Catch:{ Exception -> 0x00f9 }
        java.lang.Object r1 = r1.remove()     // Catch:{ Exception -> 0x00f9 }
        com.tencent.android.tpush.horse.e$a r1 = (com.tencent.android.tpush.horse.C6945e.C6946a) r1     // Catch:{ Exception -> 0x00f9 }
        goto L_0x0100
    L_0x00f9:
        r1 = move-exception
        java.lang.String r2 = "callBacks.remove()"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r1)
        r1 = r5
    L_0x0100:
        if (r1 == 0) goto L_0x0146
        long r2 = r0.f23402ip
        java.lang.String r2 = com.tencent.android.tpush.service.p595e.C7056i.m30176a(r2)
        int r0 = r0.port
        com.tencent.android.tpush.horse.data.StrategyItem r3 = new com.tencent.android.tpush.horse.data.StrategyItem
        com.tencent.android.tpush.horse.data.StrategyItem r4 = r11.f23068a
        java.lang.String r7 = r4.getProxyIp()
        com.tencent.android.tpush.horse.data.StrategyItem r4 = r11.f23068a
        int r8 = r4.getProxyPort()
        com.tencent.android.tpush.horse.data.StrategyItem r4 = r11.f23068a
        int r9 = r4.getProtocolType()
        com.tencent.android.tpush.horse.data.StrategyItem r4 = r11.f23068a
        int r10 = r4.getRedirect()
        r4 = r3
        r5 = r2
        r6 = r0
        r4.m51984init(r5, r6, r7, r8, r9, r10)
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x013f
        if (r0 != 0) goto L_0x0133
        goto L_0x013f
    L_0x0133:
        r0 = 1
        r3.setRedirect(r0)
        if (r1 == 0) goto L_0x0146
        com.tencent.android.tpush.horse.data.StrategyItem r0 = r11.f23068a
        r1.mo33177a(r0, r3)
        goto L_0x0146
    L_0x013f:
        if (r1 == 0) goto L_0x0146
        com.tencent.android.tpush.horse.data.StrategyItem r0 = r11.f23068a
        r1.mo33176a(r0)
    L_0x0146:
        long r0 = java.lang.System.currentTimeMillis()
        r11.f23072e = r0
        return
    L_0x014d:
        r0 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r0)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r1 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r1.m52105init(r0)
        throw r1
    L_0x015a:
        r0 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r0)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r1 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r1.m52105init(r0)
        throw r1
    L_0x0167:
        r0 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r0)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r1 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r1.m52105init(r0)
        throw r1
    L_0x0174:
        r0 = move-exception
        com.tencent.android.tpush.p580b.C6864a.m29302d(r7, r2, r0)
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r1 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        r1.m52105init(r0)
        throw r1
    L_0x0181:
        r11.m29659d()
        com.tencent.android.tpush.service.channel.exception.HorseIgnoreException r0 = new com.tencent.android.tpush.service.channel.exception.HorseIgnoreException
        java.lang.String r1 = "Recv() fail,because mStrategyItem is null"
        r0.m52106init(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6945e.mo33236b():void");
    }

    /* renamed from: c */
    public void mo33237c() {
        try {
            this.f23069b.close();
            this.f23070c.clear();
        } catch (Exception e) {
            C6864a.m29302d("SocketClient", "mSocketChannel.close()", e);
        }
    }

    /* renamed from: a */
    public void mo33235a(C6946a aVar) {
        try {
            this.f23070c.add(aVar);
        } catch (Exception e) {
            C6864a.m29302d("SocketClient", GameReportHelper.REGISTER, e);
        }
    }
}
