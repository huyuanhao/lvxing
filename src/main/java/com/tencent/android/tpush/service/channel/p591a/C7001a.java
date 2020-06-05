package com.tencent.android.tpush.service.channel.p591a;

import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.C7000a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.p592b.C7024d;
import com.tencent.android.tpush.service.channel.p592b.C7025e;
import com.tencent.android.tpush.service.channel.p592b.C7027g;
import com.tencent.android.tpush.service.channel.p592b.C7028h;
import com.tencent.android.tpush.service.channel.p592b.C7029i;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.a.a */
public class C7001a extends Thread {
    /* renamed from: a */
    protected C7002a f23247a;
    /* renamed from: b */
    public SocketChannel f23248b = null;
    /* renamed from: c */
    protected Selector f23249c = null;
    /* renamed from: d */
    protected TpnsSecurity f23250d = new TpnsSecurity();
    /* renamed from: e */
    protected C7024d f23251e = null;
    /* renamed from: f */
    protected C7025e f23252f = null;
    /* renamed from: g */
    protected String f23253g;
    /* renamed from: h */
    protected int f23254h;
    /* renamed from: i */
    protected int f23255i;
    /* renamed from: j */
    protected long f23256j;
    /* renamed from: k */
    protected C7000a f23257k;
    /* renamed from: l */
    private volatile boolean f23258l;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.channel.a.a$a */
    public interface C7002a {
        /* renamed from: a */
        ArrayList<C7028h> mo33382a(C7001a aVar, int i);

        /* renamed from: a */
        void mo33383a(C7001a aVar);

        /* renamed from: a */
        void mo33384a(C7001a aVar, C7029i iVar);

        /* renamed from: a */
        void mo33385a(C7001a aVar, ChannelException channelException);

        /* renamed from: b */
        void mo33386b(C7001a aVar);

        /* renamed from: b */
        void mo33387b(C7001a aVar, C7029i iVar);
    }

    public C7001a(SocketChannel socketChannel, C7002a aVar) {
        String str = "TpnsClient";
        super(str);
        String str2 = "";
        this.f23253g = str2;
        this.f23254h = 0;
        this.f23255i = 0;
        this.f23258l = false;
        this.f23256j = Long.MAX_VALUE;
        this.f23257k = null;
        if (socketChannel.socket().isConnected()) {
            if (socketChannel.socket().getInetAddress() != null) {
                str2 = socketChannel.socket().getInetAddress().getHostAddress();
            }
            this.f23253g = str2;
            this.f23254h = socketChannel.socket().getPort();
            this.f23255i = 0;
            C6864a.m29305f(str, "Connect to Xinge Server succeed!");
        } else {
            C6864a.m29308i(str, "TpnsClient -> the socketChannel is not connected");
        }
        this.f23248b = socketChannel;
        this.f23247a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33371a() {
        if (this.f23251e == null) {
            this.f23251e = new C7027g();
            ((C7027g) this.f23251e).mo33423a(this.f23250d);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33372b() {
        if (this.f23252f == null) {
            ArrayList a = this.f23247a.mo33382a(this, 1);
            if (!a.isEmpty()) {
                this.f23252f = (C7025e) a.get(0);
            }
            C7025e eVar = this.f23252f;
            if (eVar != null) {
                ((C7028h) eVar).mo33423a(this.f23250d);
            }
        }
        if (this.f23252f != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo33369a(C7001a aVar, C7024d dVar) {
        this.f23247a.mo33387b(aVar, (C7029i) dVar);
    }

    /* renamed from: a */
    public void mo33370a(C7001a aVar, C7025e eVar) {
        if ((((C7028h) eVar).mo33447h() & 127) != 7) {
            this.f23247a.mo33384a(aVar, (C7029i) eVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af, all -> 0x01ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2 A[Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af, all -> 0x01ab }] */
    public void run() {
        /*
        r16 = this;
        r1 = r16
        boolean r2 = com.tencent.android.tpush.XGPushConfig.enableDebug
        if (r2 == 0) goto L_0x000d
        java.lang.String r2 = "TpnsClient"
        java.lang.String r3 = "TpnsClient is running and ready for send and recevie msg."
        com.tencent.android.tpush.p580b.C6864a.m29303e(r2, r3)
    L_0x000d:
        java.nio.channels.Selector r2 = java.nio.channels.Selector.open()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r1.f23249c = r2     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r3 = 0
        r2.configureBlocking(r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r2 = 24576(0x6000, float:3.4438E-41)
        java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocateDirect(r2)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        com.tencent.android.tpush.service.channel.c.a r5 = new com.tencent.android.tpush.service.channel.c.a     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r5.m52092init(r2, r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r6 = 4096(0x1000, float:5.74E-42)
        java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocateDirect(r6)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        com.tencent.android.tpush.service.channel.c.a r8 = new com.tencent.android.tpush.service.channel.c.a     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r9 = -1
        r8.m52092init(r9, r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r7.flip()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r10 = 0
        r12 = r10
    L_0x003a:
        boolean r14 = r1.f23258l     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r14 != 0) goto L_0x0148
        java.nio.channels.SocketChannel r14 = r1.f23248b     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.Selector r15 = r1.f23249c     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r3 = 1
        r14.register(r15, r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        boolean r3 = r16.mo33372b()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 != 0) goto L_0x0058
        int r3 = r7.remaining()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 > 0) goto L_0x0058
        int r3 = r8.mo33462c()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 <= 0) goto L_0x0060
    L_0x0058:
        java.nio.channels.SocketChannel r3 = r1.f23248b     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.Selector r14 = r1.f23249c     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r15 = 4
        r3.register(r14, r15)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x0060:
        boolean r3 = r16.mo33377g()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 == 0) goto L_0x0077
        com.tencent.android.tpush.service.channel.b.d r3 = r1.f23251e     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 != 0) goto L_0x0077
        com.tencent.android.tpush.service.channel.b.e r3 = r1.f23252f     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 != 0) goto L_0x0077
        java.lang.String r2 = "TpnsClient"
        java.lang.String r3 = ">> retired!!!"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        goto L_0x0148
    L_0x0077:
        java.nio.channels.Selector r3 = r1.f23249c     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r3.select(r12)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        com.tencent.android.tpush.service.channel.b.e r3 = r1.f23252f     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 == 0) goto L_0x0095
        com.tencent.android.tpush.service.channel.b.e r3 = r1.f23252f     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        long r12 = r3.mo33422a()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
        if (r3 <= 0) goto L_0x008d
        if (r3 >= 0) goto L_0x0095
        goto L_0x0096
    L_0x008d:
        java.util.concurrent.TimeoutException r2 = new java.util.concurrent.TimeoutException     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.lang.String r3 = "发送超时"
        r2.<init>(r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        throw r2     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x0095:
        r12 = r10
    L_0x0096:
        com.tencent.android.tpush.service.channel.b.d r3 = r1.f23251e     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r3 == 0) goto L_0x00b2
        com.tencent.android.tpush.service.channel.b.d r3 = r1.f23251e     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        long r14 = r3.mo33422a()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r3 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
        if (r3 <= 0) goto L_0x00aa
        int r3 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
        if (r3 >= 0) goto L_0x00b2
        r12 = r14
        goto L_0x00b2
    L_0x00aa:
        java.util.concurrent.TimeoutException r2 = new java.util.concurrent.TimeoutException     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.lang.String r3 = "接收超时"
        r2.<init>(r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        throw r2     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x00b2:
        java.nio.channels.Selector r3 = r1.f23249c     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.util.Set r3 = r3.selectedKeys()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x00bc:
        boolean r14 = r3.hasNext()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r14 == 0) goto L_0x0145
        java.lang.Object r14 = r3.next()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.SelectionKey r14 = (java.nio.channels.SelectionKey) r14     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        boolean r15 = r14.isReadable()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r15 == 0) goto L_0x00ff
        r4.clear()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r15 = r5.mo33463d()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r4.limit(r15)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.SocketChannel r15 = r1.f23248b     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.ByteBuffer r10 = r4.slice()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r10 = r15.read(r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r10 == r9) goto L_0x00f7
        r11 = 0
        r4.get(r2, r11, r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.io.OutputStream r15 = r5.mo33460a()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r15.write(r2, r11, r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.io.InputStream r10 = r5.mo33461b()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r1.mo33367a(r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        goto L_0x00ff
    L_0x00f7:
        java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.lang.String r3 = "socket channel read return -1"
        r2.<init>(r3)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        throw r2     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x00ff:
        boolean r10 = r14.isWritable()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r10 == 0) goto L_0x013d
        java.io.OutputStream r10 = r8.mo33460a()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r1.mo33368a(r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r10 = r8.mo33462c()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r10 <= 0) goto L_0x013d
        r7.compact()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r10 = r7.remaining()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        int r11 = r8.mo33462c()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        if (r10 >= r11) goto L_0x0124
        int r10 = r7.remaining()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        goto L_0x0128
    L_0x0124:
        int r10 = r8.mo33462c()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
    L_0x0128:
        java.io.InputStream r11 = r8.mo33461b()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r14 = 0
        int r10 = r11.read(r6, r14, r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r7.put(r6, r14, r10)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r7.flip()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        java.nio.channels.SocketChannel r10 = r1.f23248b     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r10.write(r7)     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        goto L_0x013e
    L_0x013d:
        r14 = 0
    L_0x013e:
        r3.remove()     // Catch:{ IOException -> 0x034b, InnerException -> 0x02ec, UnexpectedDataException -> 0x028c, TimeoutException -> 0x022c, Exception -> 0x01af }
        r10 = 0
        goto L_0x00bc
    L_0x0145:
        r3 = 0
        goto L_0x003a
    L_0x0148:
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x0152 }
        r2.close()     // Catch:{ Exception -> 0x0152 }
        goto L_0x016a
    L_0x014f:
        r0 = move-exception
        r2 = r0
        goto L_0x01a9
    L_0x0152:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
        r4.<init>()     // Catch:{ all -> 0x014f }
        java.lang.String r5 = ">>> Run >>> selector.close() "
        r4.append(r5)     // Catch:{ all -> 0x014f }
        r4.append(r2)     // Catch:{ all -> 0x014f }
        java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x014f }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r2)     // Catch:{ all -> 0x014f }
    L_0x016a:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x0170 }
        r2.close()     // Catch:{ Exception -> 0x0170 }
        goto L_0x0188
    L_0x0170:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
        r4.<init>()     // Catch:{ all -> 0x014f }
        java.lang.String r5 = ">>> Run >>> socketChannel.close(): "
        r4.append(r5)     // Catch:{ all -> 0x014f }
        r4.append(r2)     // Catch:{ all -> 0x014f }
        java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x014f }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r2)     // Catch:{ all -> 0x014f }
    L_0x0188:
        monitor-exit(r16)     // Catch:{ all -> 0x014f }
        boolean r2 = r1.f23258l
        if (r2 == 0) goto L_0x019b
        java.lang.String r2 = "TpnsClient"
        java.lang.String r3 = "<<< Run <<< exit!!! cancelled! "
        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r3)
        com.tencent.android.tpush.service.channel.a.a$a r2 = r1.f23247a
        r2.mo33383a(r1)
        goto L_0x03bd
    L_0x019b:
        java.lang.String r2 = "TpnsClient"
        java.lang.String r3 = "<<< Run <<< exit!!! Retired! "
        com.tencent.android.tpush.p580b.C6864a.m29308i(r2, r3)
        com.tencent.android.tpush.service.channel.a.a$a r2 = r1.f23247a
        r2.mo33386b(r1)
        goto L_0x03bd
    L_0x01a9:
        monitor-exit(r16)     // Catch:{ all -> 0x014f }
        throw r2
    L_0x01ab:
        r0 = move-exception
        r2 = r0
        goto L_0x03c0
    L_0x01af:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< socketChannel Exception"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.service.channel.exception.ChannelException r3 = new com.tencent.android.tpush.service.channel.exception.ChannelException     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_UNKNOWN_EXCEPTION     // Catch:{ all -> 0x01ab }
        int r4 = r4.getType()     // Catch:{ all -> 0x01ab }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ab }
        r5.<init>()     // Catch:{ all -> 0x01ab }
        java.lang.String r6 = "TpnsClient发生未知异常"
        r5.append(r6)     // Catch:{ all -> 0x01ab }
        r5.append(r2)     // Catch:{ all -> 0x01ab }
        java.lang.String r6 = " errorcode "
        r5.append(r6)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r6 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_UNKNOWN_EXCEPTION     // Catch:{ all -> 0x01ab }
        int r6 = r6.getType()     // Catch:{ all -> 0x01ab }
        r5.append(r6)     // Catch:{ all -> 0x01ab }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01ab }
        r3.m52101init(r4, r5, r2)     // Catch:{ all -> 0x01ab }
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x01ec }
        r2.close()     // Catch:{ Exception -> 0x01ec }
        goto L_0x0204
    L_0x01e9:
        r0 = move-exception
        r2 = r0
        goto L_0x022a
    L_0x01ec:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
        r5.<init>()     // Catch:{ all -> 0x01e9 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x01e9 }
        r5.append(r2)     // Catch:{ all -> 0x01e9 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x01e9 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x01e9 }
    L_0x0204:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x020a }
        r2.close()     // Catch:{ Exception -> 0x020a }
        goto L_0x0222
    L_0x020a:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
        r5.<init>()     // Catch:{ all -> 0x01e9 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x01e9 }
        r5.append(r2)     // Catch:{ all -> 0x01e9 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x01e9 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x01e9 }
    L_0x0222:
        monitor-exit(r16)     // Catch:{ all -> 0x01e9 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        goto L_0x03a7
    L_0x022a:
        monitor-exit(r16)     // Catch:{ all -> 0x01e9 }
        throw r2
    L_0x022c:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< socketChannel TimeoutException"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.service.channel.exception.ChannelException r3 = new com.tencent.android.tpush.service.channel.exception.ChannelException     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_TIMEOUT_EXCEPTION_OCCUR     // Catch:{ all -> 0x01ab }
        int r4 = r4.getType()     // Catch:{ all -> 0x01ab }
        java.lang.String r5 = "TpnsClient发生超时异常"
        r3.m52101init(r4, r5, r2)     // Catch:{ all -> 0x01ab }
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x024c }
        r2.close()     // Catch:{ Exception -> 0x024c }
        goto L_0x0264
    L_0x0249:
        r0 = move-exception
        r2 = r0
        goto L_0x028a
    L_0x024c:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
        r5.<init>()     // Catch:{ all -> 0x0249 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x0249 }
        r5.append(r2)     // Catch:{ all -> 0x0249 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0249 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0249 }
    L_0x0264:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x026a }
        r2.close()     // Catch:{ Exception -> 0x026a }
        goto L_0x0282
    L_0x026a:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
        r5.<init>()     // Catch:{ all -> 0x0249 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x0249 }
        r5.append(r2)     // Catch:{ all -> 0x0249 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0249 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0249 }
    L_0x0282:
        monitor-exit(r16)     // Catch:{ all -> 0x0249 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        goto L_0x03a7
    L_0x028a:
        monitor-exit(r16)     // Catch:{ all -> 0x0249 }
        throw r2
    L_0x028c:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< socketChannel UnexpectedDataException"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.service.channel.exception.ChannelException r3 = new com.tencent.android.tpush.service.channel.exception.ChannelException     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_UNEXPECTED_DATA_EXCEPTION_OCCUR     // Catch:{ all -> 0x01ab }
        int r4 = r4.getType()     // Catch:{ all -> 0x01ab }
        java.lang.String r5 = "TpnsClient发生非预期数据异常"
        r3.m52101init(r4, r5, r2)     // Catch:{ all -> 0x01ab }
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x02ac }
        r2.close()     // Catch:{ Exception -> 0x02ac }
        goto L_0x02c4
    L_0x02a9:
        r0 = move-exception
        r2 = r0
        goto L_0x02ea
    L_0x02ac:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a9 }
        r5.<init>()     // Catch:{ all -> 0x02a9 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x02a9 }
        r5.append(r2)     // Catch:{ all -> 0x02a9 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x02a9 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x02a9 }
    L_0x02c4:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x02ca }
        r2.close()     // Catch:{ Exception -> 0x02ca }
        goto L_0x02e2
    L_0x02ca:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a9 }
        r5.<init>()     // Catch:{ all -> 0x02a9 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x02a9 }
        r5.append(r2)     // Catch:{ all -> 0x02a9 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x02a9 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x02a9 }
    L_0x02e2:
        monitor-exit(r16)     // Catch:{ all -> 0x02a9 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        goto L_0x03a7
    L_0x02ea:
        monitor-exit(r16)     // Catch:{ all -> 0x02a9 }
        throw r2
    L_0x02ec:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< socketChannel InnerException"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.service.channel.exception.ChannelException r3 = new com.tencent.android.tpush.service.channel.exception.ChannelException     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_INNER_EXCEPTION_OCCUR     // Catch:{ all -> 0x01ab }
        int r4 = r4.getType()     // Catch:{ all -> 0x01ab }
        java.lang.String r5 = "TpnsClient发生内部异常"
        r3.m52101init(r4, r5, r2)     // Catch:{ all -> 0x01ab }
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x030c }
        r2.close()     // Catch:{ Exception -> 0x030c }
        goto L_0x0324
    L_0x0309:
        r0 = move-exception
        r2 = r0
        goto L_0x0349
    L_0x030c:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0309 }
        r5.<init>()     // Catch:{ all -> 0x0309 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x0309 }
        r5.append(r2)     // Catch:{ all -> 0x0309 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0309 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0309 }
    L_0x0324:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x032a }
        r2.close()     // Catch:{ Exception -> 0x032a }
        goto L_0x0342
    L_0x032a:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0309 }
        r5.<init>()     // Catch:{ all -> 0x0309 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x0309 }
        r5.append(r2)     // Catch:{ all -> 0x0309 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0309 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0309 }
    L_0x0342:
        monitor-exit(r16)     // Catch:{ all -> 0x0309 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        goto L_0x03a7
    L_0x0349:
        monitor-exit(r16)     // Catch:{ all -> 0x0309 }
        throw r2
    L_0x034b:
        r0 = move-exception
        r2 = r0
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< socketChannel IOException"
        com.tencent.android.tpush.p580b.C6864a.m29302d(r3, r4, r2)     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.service.channel.exception.ChannelException r3 = new com.tencent.android.tpush.service.channel.exception.ChannelException     // Catch:{ all -> 0x01ab }
        com.tencent.android.tpush.common.ReturnCode r4 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_IOEXCEPTION_OCCUR     // Catch:{ all -> 0x01ab }
        int r4 = r4.getType()     // Catch:{ all -> 0x01ab }
        java.lang.String r5 = "TpnsClient发生IO异常，链路可能被关闭"
        r3.m52101init(r4, r5, r2)     // Catch:{ all -> 0x01ab }
        monitor-enter(r16)
        java.nio.channels.Selector r2 = r1.f23249c     // Catch:{ Exception -> 0x036b }
        r2.close()     // Catch:{ Exception -> 0x036b }
        goto L_0x0383
    L_0x0368:
        r0 = move-exception
        r2 = r0
        goto L_0x03be
    L_0x036b:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0368 }
        r5.<init>()     // Catch:{ all -> 0x0368 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x0368 }
        r5.append(r2)     // Catch:{ all -> 0x0368 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0368 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0368 }
    L_0x0383:
        java.nio.channels.SocketChannel r2 = r1.f23248b     // Catch:{ Exception -> 0x0389 }
        r2.close()     // Catch:{ Exception -> 0x0389 }
        goto L_0x03a1
    L_0x0389:
        r0 = move-exception
        r2 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0368 }
        r5.<init>()     // Catch:{ all -> 0x0368 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x0368 }
        r5.append(r2)     // Catch:{ all -> 0x0368 }
        java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0368 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)     // Catch:{ all -> 0x0368 }
    L_0x03a1:
        monitor-exit(r16)     // Catch:{ all -> 0x0368 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
    L_0x03a7:
        java.lang.String r4 = "delegate.clientExceptionOccurs <<< Run <<< exit!!! cause: "
        r2.append(r4)
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        java.lang.String r4 = "TpnsClient"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r2)
        com.tencent.android.tpush.service.channel.a.a$a r2 = r1.f23247a
        r2.mo33385a(r1, r3)
    L_0x03bd:
        return
    L_0x03be:
        monitor-exit(r16)     // Catch:{ all -> 0x0368 }
        throw r2
    L_0x03c0:
        monitor-enter(r16)
        java.nio.channels.Selector r3 = r1.f23249c     // Catch:{ Exception -> 0x03ca }
        r3.close()     // Catch:{ Exception -> 0x03ca }
        goto L_0x03e2
    L_0x03c7:
        r0 = move-exception
        r2 = r0
        goto L_0x041f
    L_0x03ca:
        r0 = move-exception
        r3 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c7 }
        r5.<init>()     // Catch:{ all -> 0x03c7 }
        java.lang.String r6 = ">>> Run >>> selector.close() "
        r5.append(r6)     // Catch:{ all -> 0x03c7 }
        r5.append(r3)     // Catch:{ all -> 0x03c7 }
        java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x03c7 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r3)     // Catch:{ all -> 0x03c7 }
    L_0x03e2:
        java.nio.channels.SocketChannel r3 = r1.f23248b     // Catch:{ Exception -> 0x03e8 }
        r3.close()     // Catch:{ Exception -> 0x03e8 }
        goto L_0x0400
    L_0x03e8:
        r0 = move-exception
        r3 = r0
        java.lang.String r4 = "TpnsClient"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c7 }
        r5.<init>()     // Catch:{ all -> 0x03c7 }
        java.lang.String r6 = ">>> Run >>> socketChannel.close(): "
        r5.append(r6)     // Catch:{ all -> 0x03c7 }
        r5.append(r3)     // Catch:{ all -> 0x03c7 }
        java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x03c7 }
        com.tencent.android.tpush.p580b.C6864a.m29308i(r4, r3)     // Catch:{ all -> 0x03c7 }
    L_0x0400:
        monitor-exit(r16)     // Catch:{ all -> 0x03c7 }
        boolean r3 = r1.f23258l
        if (r3 == 0) goto L_0x0412
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< exit!!! cancelled! "
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r4)
        com.tencent.android.tpush.service.channel.a.a$a r3 = r1.f23247a
        r3.mo33383a(r1)
        goto L_0x041e
    L_0x0412:
        java.lang.String r3 = "TpnsClient"
        java.lang.String r4 = "<<< Run <<< exit!!! Retired! "
        com.tencent.android.tpush.p580b.C6864a.m29308i(r3, r4)
        com.tencent.android.tpush.service.channel.a.a$a r3 = r1.f23247a
        r3.mo33386b(r1)
    L_0x041e:
        throw r2
    L_0x041f:
        monitor-exit(r16)     // Catch:{ all -> 0x03c7 }
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.channel.p591a.C7001a.run():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33367a(InputStream inputStream) {
        int i;
        int i2 = 0;
        while (true) {
            if (inputStream.available() <= 0) {
                break;
            }
            mo33371a();
            C7024d dVar = this.f23251e;
            if (dVar != null) {
                i2 += dVar.mo33411a(inputStream);
                if (!this.f23251e.mo33424b()) {
                    C6864a.m29308i(Constants.TcpRecvPackLogTag, ">> recvHandle not success");
                    break;
                }
                mo33369a(this, this.f23251e);
                this.f23251e = null;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33368a(OutputStream outputStream) {
        if (!mo33377g()) {
            mo33372b();
        }
        C7025e eVar = this.f23252f;
        if (eVar == null) {
            return 0;
        }
        int a = eVar.mo33416a(outputStream);
        if (this.f23252f.mo33424b()) {
            mo33370a(this, this.f23252f);
            this.f23252f = null;
        }
        if (!mo33372b()) {
            return a;
        }
        mo33378h();
        return a;
    }

    public synchronized void start() {
        super.start();
    }

    /* renamed from: c */
    public synchronized void mo33373c() {
        this.f23258l = true;
        mo33378h();
    }

    /* renamed from: d */
    public synchronized boolean mo33374d() {
        if (this.f23248b == null) {
            return false;
        }
        return this.f23248b.isConnected();
    }

    /* renamed from: e */
    public boolean mo33375e() {
        return this.f23255i == 1;
    }

    /* renamed from: f */
    public C7000a mo33376f() {
        if (this.f23257k == null) {
            Object[] objArr = new Object[6];
            boolean z = false;
            objArr[0] = Integer.valueOf(0);
            objArr[1] = this.f23253g;
            objArr[2] = Integer.valueOf(1);
            objArr[3] = Integer.valueOf(this.f23254h);
            objArr[4] = Integer.valueOf(2);
            if (this.f23255i == 1) {
                z = true;
            }
            objArr[5] = Boolean.valueOf(z);
            this.f23257k = new C7000a(objArr);
        }
        return this.f23257k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo33377g() {
        return System.currentTimeMillis() > this.f23256j;
    }

    /* renamed from: h */
    public void mo33378h() {
        try {
            if (this.f23249c != null && this.f23249c.isOpen()) {
                this.f23249c.wakeup();
            }
        } catch (Throwable th) {
            C6864a.m29302d("TpnsClient", ">>selector wakeup err", th);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append("(ip:");
        stringBuffer.append(this.f23253g);
        stringBuffer.append(",port:");
        stringBuffer.append(this.f23254h);
        stringBuffer.append(",protocol:");
        stringBuffer.append(this.f23255i == 1 ? "http" : "tcp");
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
