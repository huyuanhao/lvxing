package com.tencent.android.tpush.horse;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.horse.C6932a.C6933a;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.p588a.C6971a;
import com.tencent.android.tpush.service.p595e.C7056i;
import java.nio.channels.SocketChannel;
import java.util.Timer;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.d */
public class C6938d {
    /* renamed from: a */
    static long f23047a = 1;
    /* renamed from: b */
    static long f23048b = 0;
    /* renamed from: c */
    public static int f23049c = -1;
    /* renamed from: j */
    private static long f23050j;
    /* renamed from: k */
    private static long f23051k;
    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static int f23052m;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final Object f23053d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: e */
    public volatile int f23054e;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f23055f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public long f23056g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C6942a f23057h;
    /* renamed from: i */
    private C6943b f23058i;
    /* renamed from: l */
    private Timer f23059l;
    /* renamed from: n */
    private Handler f23060n;
    /* renamed from: o */
    private C6933a f23061o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public C6933a f23062p;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.d$a */
    public interface C6942a {
        /* renamed from: a */
        void mo33184a(int i, String str);

        /* renamed from: a */
        void mo33185a(SocketChannel socketChannel, StrategyItem strategyItem);
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.d$b */
    public interface C6943b {
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.d$c */
    public static class C6944c {
        /* renamed from: a */
        public static C6938d f23066a = new C6938d();
    }

    /* renamed from: a */
    public void mo33181a(C6943b bVar) {
        this.f23058i = bVar;
    }

    /* renamed from: a */
    public static C6938d m29638a() {
        return C6944c.f23066a;
    }

    private C6938d() {
        this.f23053d = new Object();
        this.f23054e = 0;
        this.f23055f = false;
        this.f23059l = new Timer();
        this.f23060n = null;
        this.f23061o = new C6933a() {
            /* renamed from: a */
            public void mo33173a(SocketChannel socketChannel, StrategyItem strategyItem) {
                C6938d.f23052m = 0;
                if (C6948g.m29673i().mo33166b()) {
                    C6938d.this.f23054e = 1;
                }
                synchronized (C6938d.this.f23053d) {
                    if (C6938d.this.f23054e == 1) {
                        try {
                            C6938d.this.f23053d.wait();
                        } catch (Exception e) {
                            C6864a.m29302d(Constants.HorseLogTag, "lock.wait", e);
                        }
                    }
                }
                if (!socketChannel.isConnected() || C6948g.m29673i().mo33167c()) {
                    if (!socketChannel.isConnected() && !C6948g.m29673i().mo33167c()) {
                        C6938d.this.m29639a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create channel fail httpChannelCallback !");
                    }
                } else if (C6938d.this.f23057h == null) {
                    C6864a.m29308i(Constants.HorseLogTag, ">> mcreateSocket channelCallback is null ");
                } else if (strategyItem.isRedirected()) {
                    try {
                        socketChannel.close();
                    } catch (Exception e2) {
                        C6864a.m29302d(Constants.HorseLogTag, "socketChannel.close()", e2);
                    }
                } else {
                    C6938d.this.f23057h.mo33185a(socketChannel, strategyItem);
                }
            }

            /* renamed from: a */
            public void mo33172a(StrategyItem strategyItem) {
                if (!C6948g.m29673i().mo33166b() && !C6937c.m29631i().mo33166b() && C6938d.this.f23054e == 0) {
                    C6938d.this.f23054e = 2;
                    if (C6938d.this.f23057h != null) {
                        C6938d.this.f23057h.mo33184a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create http channel fail!");
                    }
                }
            }
        };
        this.f23062p = new C6933a() {
            /* renamed from: a */
            public void mo33173a(SocketChannel socketChannel, StrategyItem strategyItem) {
                C6938d.f23052m = 0;
                if (socketChannel == null || strategyItem == null) {
                    C6938d.this.m29639a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create channel fail!");
                    return;
                }
                if (!socketChannel.isConnected()) {
                    C6938d.this.m29639a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create channel fail!");
                } else if (C6938d.this.f23057h != null) {
                    if (!strategyItem.isRedirected() || C6938d.this.f23055f) {
                        C6938d.this.f23057h.mo33185a(socketChannel, strategyItem);
                    } else {
                        try {
                            socketChannel.close();
                        } catch (Exception e) {
                            C6864a.m29302d(Constants.HorseLogTag, "socketChannel.close()", e);
                        }
                    }
                }
                if (C6938d.this.f23055f) {
                    C6938d.this.f23055f = false;
                }
                synchronized (C6938d.this.f23053d) {
                    C6938d.this.f23054e = 2;
                    C6938d.this.f23053d.notify();
                }
            }

            /* renamed from: a */
            public void mo33172a(StrategyItem strategyItem) {
                if (C6938d.this.f23055f) {
                    C6938d.this.f23055f = false;
                    C6938d.this.mo33182b();
                    return;
                }
                if (!C6948g.m29673i().mo33166b()) {
                    if (C6938d.this.f23054e == 0 && !C6937c.m29631i().mo33166b()) {
                        C6938d.this.f23054e = 2;
                        if (C6938d.this.f23057h != null) {
                            C6938d.this.m29639a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create channel fail!");
                        }
                    }
                    if (C6938d.this.f23054e == 1) {
                        synchronized (C6938d.this.f23053d) {
                            C6938d.this.f23054e = 2;
                            C6938d.this.f23053d.notify();
                        }
                    }
                } else {
                    C6864a.m29303e(Constants.HorseLogTag, ">> tcp has remain");
                }
            }
        };
        this.f23060n = C6901c.m29459a().mo33107b();
    }

    /* renamed from: a */
    public synchronized void mo33180a(C6942a aVar) {
        this.f23054e = 0;
        this.f23057h = aVar;
        this.f23060n.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ab, code lost:
            return;
     */
            public void run() {
                /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ all -> 0x01ac }
                if (r0 == 0) goto L_0x000c
                java.lang.String r0 = "XGHorse"
                java.lang.String r1 = "Action ->  createOptimalSocketChannel run"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r1)     // Catch:{ all -> 0x01ac }
            L_0x000c:
                android.content.Context r0 = com.tencent.android.tpush.XGPushManager.getContext()     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.service.a.a r0 = com.tencent.android.tpush.service.p588a.C6971a.m29749a(r0)     // Catch:{ all -> 0x01ac }
                int r0 = r0.f23133D     // Catch:{ all -> 0x01ac }
                r1 = 1
                if (r0 == r1) goto L_0x013d
                android.content.Context r0 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ all -> 0x01ac }
                boolean r0 = com.tencent.android.tpush.XGPushConfig.isForeiginPush(r0)     // Catch:{ all -> 0x01ac }
                if (r0 == 0) goto L_0x0025
                goto L_0x013d
            L_0x0025:
                com.tencent.android.tpush.horse.g r0 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ all -> 0x01ac }
                boolean r0 = r0.mo33166b()     // Catch:{ all -> 0x01ac }
                if (r0 != 0) goto L_0x0134
                com.tencent.android.tpush.horse.c r0 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ all -> 0x01ac }
                boolean r0 = r0.mo33166b()     // Catch:{ all -> 0x01ac }
                if (r0 != 0) goto L_0x0134
                java.lang.String r0 = ""
                android.content.Context r2 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r0 = com.tencent.android.tpush.service.p595e.C7056i.m30218l(r2)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                android.content.Context r2 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.data.OptStrategyList r2 = com.tencent.android.tpush.service.cache.CacheManager.getOptStrategyList(r2, r0)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.data.StrategyItem r3 = r2.getOptStrategyItem()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                int r4 = r3.getProtocolType()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r4 == r1) goto L_0x0105
                if (r3 == 0) goto L_0x0105
                long r4 = r2.getTimestamp()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                boolean r2 = com.tencent.android.tpush.horse.C6936b.m29628a(r4)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r2 == 0) goto L_0x0063
                goto L_0x0105
            L_0x0063:
                com.tencent.android.tpush.horse.d r2 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.f23056g = r4     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                int r2 = r3.getProtocolType()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r2 != 0) goto L_0x00be
                boolean r2 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r2 == 0) goto L_0x0090
                java.lang.String r2 = "XGHorse"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r4.<init>()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r5 = "Using the optStrategyItem"
                r4.append(r5)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r5 = r3.toString()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r4.append(r5)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r4 = r4.toString()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.p580b.C6864a.m29298c(r2, r4)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
            L_0x0090:
                com.tencent.android.tpush.horse.d r2 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.f23055f = r1     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.<init>()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2 = 0
                r3.setRedirect(r2)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.add(r3)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.g r2 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.d r3 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.a$a r3 = r3.f23062p     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.mo33164a(r3)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.g r2 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.mo33165a(r1)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.g r1 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.mo33171g()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                goto L_0x013b
            L_0x00be:
                boolean r1 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r1 == 0) goto L_0x00dc
                java.lang.String r1 = "XGHorse"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.<init>()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r4 = "Using Http chanel http:"
                r2.append(r4)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r4 = r3.toString()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.append(r4)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.lang.String r2 = r2.toString()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.p580b.C6864a.m29298c(r1, r2)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
            L_0x00dc:
                com.tencent.android.tpush.horse.e r1 = new com.tencent.android.tpush.horse.e     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.m51986init()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.mo33234a(r3)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.nio.channels.SocketChannel r2 = r1.mo33232a()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                boolean r2 = r2.isConnected()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r2 == 0) goto L_0x013b
                com.tencent.android.tpush.horse.d r2 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.d$a r2 = r2.f23057h     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                if (r2 == 0) goto L_0x013b
                com.tencent.android.tpush.horse.d r2 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                com.tencent.android.tpush.horse.d$a r2 = r2.f23057h     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                java.nio.channels.SocketChannel r1 = r1.mo33232a()     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r2.mo33185a(r1, r3)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                monitor-exit(r6)     // Catch:{ all -> 0x01ac }
                return
            L_0x0105:
                com.tencent.android.tpush.horse.d r1 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                r1.m29642a(r0)     // Catch:{ NullReturnException -> 0x0127, HorseIgnoreException -> 0x011a, Exception -> 0x010c }
                monitor-exit(r6)     // Catch:{ all -> 0x01ac }
                return
            L_0x010c:
                r0 = move-exception
                java.lang.String r1 = "XGHorse"
                java.lang.String r2 = "createOptimalSocketChannel error"
                com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r2, r0)     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x01ac }
                r0.mo33182b()     // Catch:{ all -> 0x01ac }
                goto L_0x013b
            L_0x011a:
                java.lang.String r0 = "XGHorse"
                java.lang.String r1 = "create OptimalSocket  Channel error"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r1)     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x01ac }
                r0.mo33182b()     // Catch:{ all -> 0x01ac }
                goto L_0x013b
            L_0x0127:
                java.lang.String r1 = "XGHorse"
                java.lang.String r2 = "no network Strategy, begin horse running"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r1, r2)     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d r1 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x01ac }
                r1.m29642a(r0)     // Catch:{ all -> 0x01ac }
                goto L_0x013b
            L_0x0134:
                java.lang.String r0 = "XGHorse"
                java.lang.String r1 = ">> horse task running"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r1)     // Catch:{ all -> 0x01ac }
            L_0x013b:
                monitor-exit(r6)     // Catch:{ all -> 0x01ac }
                return
            L_0x013d:
                java.lang.String r0 = "XGHorse"
                java.lang.String r1 = "Action ->  createOptimalSocketChannel run"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r0, r1)     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.e r0 = new com.tencent.android.tpush.horse.e     // Catch:{ all -> 0x0189 }
                r0.m51986init()     // Catch:{ all -> 0x0189 }
                r1 = 0
                r0.mo33234a(r1)     // Catch:{ all -> 0x0189 }
                java.nio.channels.SocketChannel r1 = r0.mo33232a()     // Catch:{ all -> 0x0189 }
                boolean r1 = r1.isConnected()     // Catch:{ all -> 0x0189 }
                if (r1 == 0) goto L_0x016f
                com.tencent.android.tpush.horse.d r1 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.d$a r1 = r1.f23057h     // Catch:{ all -> 0x0189 }
                if (r1 == 0) goto L_0x01aa
                com.tencent.android.tpush.horse.d r1 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.d$a r1 = r1.f23057h     // Catch:{ all -> 0x0189 }
                java.nio.channels.SocketChannel r2 = r0.mo33232a()     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.data.StrategyItem r0 = r0.f23068a     // Catch:{ all -> 0x0189 }
                r1.mo33185a(r2, r0)     // Catch:{ all -> 0x0189 }
                goto L_0x01aa
            L_0x016f:
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.d$a r0 = r0.f23057h     // Catch:{ all -> 0x0189 }
                if (r0 == 0) goto L_0x01aa
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.horse.d$a r0 = r0.f23057h     // Catch:{ all -> 0x0189 }
                com.tencent.android.tpush.common.ReturnCode r1 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED     // Catch:{ all -> 0x0189 }
                int r1 = r1.getType()     // Catch:{ all -> 0x0189 }
                java.lang.String r2 = "create tcp channel fail!"
                r0.mo33184a(r1, r2)     // Catch:{ all -> 0x0189 }
                goto L_0x01aa
            L_0x0189:
                r0 = move-exception
                java.lang.String r1 = "XGHorse"
                java.lang.String r2 = "createOptimalSocketChannel error"
                com.tencent.android.tpush.p580b.C6864a.m29302d(r1, r2, r0)     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d$a r0 = r0.f23057h     // Catch:{ all -> 0x01ac }
                if (r0 == 0) goto L_0x01aa
                com.tencent.android.tpush.horse.d r0 = com.tencent.android.tpush.horse.C6938d.this     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.horse.d$a r0 = r0.f23057h     // Catch:{ all -> 0x01ac }
                com.tencent.android.tpush.common.ReturnCode r1 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED     // Catch:{ all -> 0x01ac }
                int r1 = r1.getType()     // Catch:{ all -> 0x01ac }
                java.lang.String r2 = "create tcp channel fail!"
                r0.mo33184a(r1, r2)     // Catch:{ all -> 0x01ac }
            L_0x01aa:
                monitor-exit(r6)     // Catch:{ all -> 0x01ac }
                return
            L_0x01ac:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x01ac }
                throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6938d.C69391.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02c5  */
    /* renamed from: a */
    public void m29642a(java.lang.String r12) {
        /*
        r11 = this;
        java.lang.String r0 = "create default channel fail!"
        java.lang.String r1 = "create wap channel fail!"
        java.lang.String r2 = "create http channel fail!"
        java.lang.String r3 = "create tcp channel fail!"
        java.lang.String r4 = ""
        java.lang.String r5 = "XGHorse"
        if (r12 == 0) goto L_0x0026
        com.tencent.android.tpush.stat.a.d r6 = com.tencent.android.tpush.stat.p596a.C7066c.m30259b()
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r8 = "startHorseTask key:"
        r7.append(r8)
        r7.append(r12)
        java.lang.String r7 = r7.toString()
        r6.mo34172d(r7)
    L_0x0026:
        android.content.Context r6 = com.tencent.android.tpush.service.C6973b.m29776f()
        boolean r6 = com.tencent.android.tpush.service.p595e.C7048a.m30142d(r6)
        java.lang.String r7 = "OptimalLinkSelector"
        if (r6 != 0) goto L_0x0043
        java.lang.String r12 = "Network can't reachable"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r7, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_UNREACHABLE
        int r12 = r12.getType()
        java.lang.String r0 = "network can't reachable!"
        r11.m29639a(r12, r0)
        return
    L_0x0043:
        com.tencent.android.tpush.horse.g r6 = com.tencent.android.tpush.horse.C6948g.m29673i()
        boolean r6 = r6.mo33166b()
        if (r6 != 0) goto L_0x032e
        com.tencent.android.tpush.horse.c r6 = com.tencent.android.tpush.horse.C6937c.m29631i()
        boolean r6 = r6.mo33166b()
        if (r6 == 0) goto L_0x0059
        goto L_0x032e
    L_0x0059:
        boolean r6 = com.tencent.android.tpush.XGPushConfig.enableDebug
        if (r6 == 0) goto L_0x0071
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        java.lang.String r8 = "Action -> startHorseTask with key = "
        r6.append(r8)
        r6.append(r12)
        java.lang.String r6 = r6.toString()
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r6)
    L_0x0071:
        android.content.Context r6 = com.tencent.android.tpush.service.C6973b.m29776f()
        com.tencent.android.tpush.service.cache.CacheManager.removeOptStrategyList(r6, r12)
        r6 = 0
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
        r8.<init>()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r4)     // Catch:{ Exception -> 0x00d9 }
        com.tencent.android.tpush.common.MobileType r9 = com.tencent.android.tpush.common.MobileType.CHINAMOBILE     // Catch:{ Exception -> 0x00d9 }
        byte r9 = r9.getType()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r9)     // Catch:{ Exception -> 0x00d9 }
        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00d9 }
        boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x00d9 }
        if (r8 != 0) goto L_0x00d0
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
        r8.<init>()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r4)     // Catch:{ Exception -> 0x00d9 }
        com.tencent.android.tpush.common.MobileType r9 = com.tencent.android.tpush.common.MobileType.TELCOM     // Catch:{ Exception -> 0x00d9 }
        byte r9 = r9.getType()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r9)     // Catch:{ Exception -> 0x00d9 }
        java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00d9 }
        boolean r8 = r12.equals(r8)     // Catch:{ Exception -> 0x00d9 }
        if (r8 != 0) goto L_0x00d0
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
        r8.<init>()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r4)     // Catch:{ Exception -> 0x00d9 }
        com.tencent.android.tpush.common.MobileType r4 = com.tencent.android.tpush.common.MobileType.UNICOM     // Catch:{ Exception -> 0x00d9 }
        byte r4 = r4.getType()     // Catch:{ Exception -> 0x00d9 }
        r8.append(r4)     // Catch:{ Exception -> 0x00d9 }
        java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x00d9 }
        boolean r4 = r12.equals(r4)     // Catch:{ Exception -> 0x00d9 }
        if (r4 == 0) goto L_0x00cb
        goto L_0x00d0
    L_0x00cb:
        java.util.ArrayList r4 = com.tencent.android.tpush.horse.DefaultServer.m29601a(r12)     // Catch:{ Exception -> 0x00d9 }
        goto L_0x0111
    L_0x00d0:
        android.content.Context r4 = com.tencent.android.tpush.service.C6973b.m29776f()     // Catch:{ Exception -> 0x00d9 }
        java.util.ArrayList r4 = com.tencent.android.tpush.service.cache.CacheManager.getServerItems(r4, r12)     // Catch:{ Exception -> 0x00d9 }
        goto L_0x0111
    L_0x00d9:
        r4 = move-exception
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = ">> Can not get local serverItems : "
        r8.append(r9)
        java.lang.String r4 = r4.getMessage()
        r8.append(r4)
        java.lang.String r4 = r8.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r4)
        java.util.ArrayList r4 = com.tencent.android.tpush.horse.DefaultServer.m29601a(r12)     // Catch:{ Exception -> 0x00f7 }
        goto L_0x0111
    L_0x00f7:
        r4 = move-exception
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = ">> Can not get default serverItems : "
        r8.append(r9)
        java.lang.String r4 = r4.toString()
        r8.append(r4)
        java.lang.String r4 = r8.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r4)
        r4 = r6
    L_0x0111:
        if (r4 != 0) goto L_0x0118
        java.util.ArrayList r4 = new java.util.ArrayList
        r4.<init>()
    L_0x0118:
        java.util.ArrayList r8 = com.tencent.android.tpush.horse.DefaultServer.m29603b()
        r4.addAll(r8)
        android.content.Context r8 = com.tencent.android.tpush.service.C6973b.m29776f()
        int r8 = com.tencent.android.tpush.horse.Tools.getChannelType(r8)
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        java.lang.String r10 = "Tools.getChannelType = "
        r9.append(r10)
        r9.append(r8)
        java.lang.String r9 = r9.toString()
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r9)
        r9 = 2
        if (r8 == r9) goto L_0x02c5
        r2 = 3
        if (r8 == r2) goto L_0x023b
        r1 = 4
        if (r8 == r1) goto L_0x01b0
        java.lang.String r0 = "XINGE Use TcpTask"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r0)     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        java.util.List r12 = com.tencent.android.tpush.horse.C6947f.m29670a(r4, r12)     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        com.tencent.android.tpush.horse.g r0 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        com.tencent.android.tpush.horse.a$a r1 = r11.f23062p     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        r0.mo33164a(r1)     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        com.tencent.android.tpush.horse.g r0 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        r0.mo33165a(r12)     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        com.tencent.android.tpush.horse.g r12 = com.tencent.android.tpush.horse.C6948g.m29673i()     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        r12.mo33171g()     // Catch:{ NullReturnException -> 0x0168, Exception -> 0x0166 }
        goto L_0x032d
    L_0x0166:
        r12 = move-exception
        goto L_0x016a
    L_0x0168:
        r12 = move-exception
        goto L_0x018d
    L_0x016a:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = ">> (create tcp channel fail!) >> "
        r0.append(r1)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r3)
        goto L_0x032d
    L_0x018d:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = ">> Can not get strategyItems(create tcp channel fail!) >> "
        r0.append(r1)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r3)
        goto L_0x032d
    L_0x01b0:
        java.lang.String r1 = "XINGE Use TCP_OR_HTTP"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r1)     // Catch:{ NullReturnException -> 0x01c5, Exception -> 0x01c2 }
        java.util.List r1 = com.tencent.android.tpush.horse.C6947f.m29670a(r4, r12)     // Catch:{ NullReturnException -> 0x01c5, Exception -> 0x01c2 }
        java.util.List r6 = com.tencent.android.tpush.horse.C6947f.m29672b(r4, r12)     // Catch:{ NullReturnException -> 0x01c0, Exception -> 0x01be }
        goto L_0x020b
    L_0x01be:
        r12 = move-exception
        goto L_0x01c8
    L_0x01c0:
        r12 = move-exception
        goto L_0x01ea
    L_0x01c2:
        r12 = move-exception
        r1 = r6
        goto L_0x01c8
    L_0x01c5:
        r12 = move-exception
        r1 = r6
        goto L_0x01ea
    L_0x01c8:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = ">> (create default channel fail!) >> "
        r2.append(r3)
        java.lang.String r12 = r12.getMessage()
        r2.append(r12)
        java.lang.String r12 = r2.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r0)
        goto L_0x020b
    L_0x01ea:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = ">> Can not get strategyItems(create default channel fail!)>>"
        r2.append(r3)
        java.lang.String r12 = r12.getMessage()
        r2.append(r12)
        java.lang.String r12 = r2.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r0)
    L_0x020b:
        com.tencent.android.tpush.horse.g r12 = com.tencent.android.tpush.horse.C6948g.m29673i()
        com.tencent.android.tpush.horse.a$a r0 = r11.f23062p
        r12.mo33164a(r0)
        com.tencent.android.tpush.horse.g r12 = com.tencent.android.tpush.horse.C6948g.m29673i()
        r12.mo33165a(r1)
        com.tencent.android.tpush.horse.g r12 = com.tencent.android.tpush.horse.C6948g.m29673i()
        r12.mo33171g()
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()
        com.tencent.android.tpush.horse.a$a r0 = r11.f23061o
        r12.mo33164a(r0)
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()
        r12.mo33165a(r6)
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()
        r12.mo33171g()
        goto L_0x032d
    L_0x023b:
        java.lang.String r0 = "XINGE Use HTTP_WAP"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r0)     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        java.util.List r12 = com.tencent.android.tpush.horse.C6947f.m29672b(r4, r12)     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        r0.<init>()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        java.util.Iterator r12 = r12.iterator()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
    L_0x024d:
        boolean r2 = r12.hasNext()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        if (r2 == 0) goto L_0x0263
        java.lang.Object r2 = r12.next()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        com.tencent.android.tpush.horse.data.StrategyItem r2 = (com.tencent.android.tpush.horse.data.StrategyItem) r2     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        boolean r3 = r2.isWap()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        if (r3 == 0) goto L_0x024d
        r0.add(r2)     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        goto L_0x024d
    L_0x0263:
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        com.tencent.android.tpush.horse.a$a r2 = r11.f23061o     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        r12.mo33164a(r2)     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        r12.mo33165a(r0)     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        r12.mo33171g()     // Catch:{ NullReturnException -> 0x027e, Exception -> 0x027c }
        goto L_0x032d
    L_0x027c:
        r12 = move-exception
        goto L_0x0280
    L_0x027e:
        r12 = move-exception
        goto L_0x02a3
    L_0x0280:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r2 = ">> (create wap channel fail!) >> "
        r0.append(r2)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r1)
        goto L_0x032d
    L_0x02a3:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r2 = ">> Can not get strategyItems(create wap channel fail!)>>"
        r0.append(r2)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r1)
        goto L_0x032d
    L_0x02c5:
        java.lang.String r0 = "XINGE Use HTTP TASK"
        com.tencent.android.tpush.p580b.C6864a.m29298c(r7, r0)     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        java.util.List r12 = com.tencent.android.tpush.horse.C6947f.m29672b(r4, r12)     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        com.tencent.android.tpush.horse.c r0 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        com.tencent.android.tpush.horse.a$a r1 = r11.f23061o     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        r0.mo33164a(r1)     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        com.tencent.android.tpush.horse.c r0 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        r0.mo33165a(r12)     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        com.tencent.android.tpush.horse.c r12 = com.tencent.android.tpush.horse.C6937c.m29631i()     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        r12.mo33171g()     // Catch:{ NullReturnException -> 0x02e8, Exception -> 0x02e6 }
        goto L_0x032d
    L_0x02e6:
        r12 = move-exception
        goto L_0x02ea
    L_0x02e8:
        r12 = move-exception
        goto L_0x030c
    L_0x02ea:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = ">> (create http channel fail!) >> "
        r0.append(r1)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r2)
        goto L_0x032d
    L_0x030c:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = ">> Can not get strategyItems(create http channel fail!)>>"
        r0.append(r1)
        java.lang.String r12 = r12.getMessage()
        r0.append(r12)
        java.lang.String r12 = r0.toString()
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r12)
        com.tencent.android.tpush.common.ReturnCode r12 = com.tencent.android.tpush.common.ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED
        int r12 = r12.getType()
        r11.m29639a(r12, r2)
    L_0x032d:
        return
    L_0x032e:
        java.lang.String r12 = "Horse task running"
        com.tencent.android.tpush.p580b.C6864a.m29286a(r7, r12)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6938d.m29642a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29639a(int i, String str) {
        C6942a aVar = this.f23057h;
        if (aVar != null) {
            aVar.mo33184a(i, str);
        }
    }

    /* renamed from: a */
    public synchronized void mo33179a(Intent intent) {
        try {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                if (XGPushConfig.enableDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Connection state changed to - ");
                    sb.append(networkInfo.toString());
                    C6864a.m29298c("OptimalLinkSelector", sb.toString());
                }
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                int type = networkInfo.getType();
                if (booleanExtra) {
                    if (XGPushConfig.enableDebug) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DisConnected with network type ");
                        sb2.append(networkInfo.getTypeName());
                        C6864a.m29298c("OptimalLinkSelector", sb2.toString());
                    }
                    C6973b.m29773c(C6973b.m29776f());
                } else if (State.CONNECTED == networkInfo.getState()) {
                    if (XGPushConfig.enableDebug) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Connected with network type ");
                        sb3.append(networkInfo.getTypeName());
                        C6864a.m29298c("OptimalLinkSelector", sb3.toString());
                    }
                    f23049c = type;
                    C6973b.m29766a(C6973b.m29776f(), 2000);
                } else if (State.DISCONNECTED == networkInfo.getState()) {
                    if (XGPushConfig.enableDebug) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("NetworkInfo.State.DISCONNECTED with network type = ");
                        sb4.append(networkInfo.getTypeName());
                        C6864a.m29298c("OptimalLinkSelector", sb4.toString());
                    }
                    if (f23049c == -1 || f23049c == type) {
                        C6973b.m29773c(C6973b.m29776f());
                    }
                } else if (XGPushConfig.enableDebug) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("other network state - ");
                    sb5.append(networkInfo.getState());
                    sb5.append(". Do nothing.");
                    C6864a.m29298c("OptimalLinkSelector", sb5.toString());
                }
            } else {
                return;
            }
        } catch (Throwable th) {
            C6864a.m29288a("OptimalLinkSelector", "onNetworkChanged", th);
        }
        return;
    }

    /* renamed from: b */
    public void mo33182b() {
        f23052m++;
        if (f23052m < C6971a.m29749a(C6973b.m29776f()).f23161t) {
            m29638a().m29642a(C7056i.m30218l(C6973b.m29776f()));
        } else {
            m29639a(ReturnCode.CODE_NETWORK_CREATE_OPTIOMAL_SC_FAILED.getType(), "create socket err");
        }
    }
}
