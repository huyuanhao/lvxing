package com.tencent.android.tpush.horse;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.horse.C6945e.C6946a;
import com.tencent.android.tpush.horse.data.StrategyItem;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;
import com.tencent.android.tpush.service.channel.protocol.TpnsRedirectReq;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.lang.Thread.State;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.horse.a */
public abstract class C6932a {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final Object f23034a = new Object();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public LinkedBlockingQueue<StrategyItem> f23035b = new LinkedBlockingQueue<>();
    /* renamed from: c */
    private ConcurrentHashMap<Integer, C6934b> f23036c = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C6933a f23037d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public AtomicInteger f23038e = new AtomicInteger(0);
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f23039f = false;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.a$a */
    public interface C6933a {
        /* renamed from: a */
        void mo33172a(StrategyItem strategyItem);

        /* renamed from: a */
        void mo33173a(SocketChannel socketChannel, StrategyItem strategyItem);
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.horse.a$b */
    private class C6934b extends Thread {
        /* renamed from: a */
        protected C6946a f23040a = new C6946a() {
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
            if (r4.getProtocolType() != 0) goto L_0x0096;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
            r3.f23045a.f23041b.mo33169e();
            r3.f23045a.f23041b.mo33170f();
     */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0096, code lost:
            com.tencent.android.tpush.service.cache.CacheManager.addOptStrategy(r4);
            r3.f23045a.f23041b.mo33162a();
     */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
            if (com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b) == null) goto L_0x00bf;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00aa, code lost:
            com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b).mo33173a(r3.f23045a.mo33174a().mo33232a(), r4);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bf, code lost:
            return;
     */
            /* renamed from: a */
            public void mo33176a(com.tencent.android.tpush.horse.data.StrategyItem r4) {
                /*
                r3 = this;
                boolean r0 = com.tencent.android.tpush.XGPushConfig.enableDebug
                if (r0 == 0) goto L_0x003d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Horse run onSuccess("
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = ","
                r0.append(r1)
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                int r1 = r1.f23043d
                r0.append(r1)
                java.lang.String r1 = ","
                r0.append(r1)
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this
                boolean r1 = r1.f23039f
                r0.append(r1)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "BaseTask"
                com.tencent.android.tpush.p580b.C6864a.m29286a(r1, r0)
            L_0x003d:
                java.lang.Object r0 = com.tencent.android.tpush.horse.C6932a.f23034a
                monitor-enter(r0)
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00c0 }
                java.util.concurrent.LinkedBlockingQueue r1 = r1.f23035b     // Catch:{ all -> 0x00c0 }
                r1.clear()     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00c0 }
                boolean r1 = r1.f23039f     // Catch:{ all -> 0x00c0 }
                if (r1 == 0) goto L_0x005f
                boolean r1 = r4.isRedirected()     // Catch:{ all -> 0x00c0 }
                if (r1 != 0) goto L_0x005f
                monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
                return
            L_0x005f:
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00c0 }
                r2 = 1
                r1.f23039f = r2     // Catch:{ all -> 0x00c0 }
                int r1 = r4.getProtocolType()     // Catch:{ all -> 0x00c0 }
                if (r1 != 0) goto L_0x0074
                int r1 = r4.getRedirect()     // Catch:{ all -> 0x00c0 }
                if (r1 != r2) goto L_0x0074
                goto L_0x0081
            L_0x0074:
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00c0 }
                com.tencent.android.tpush.horse.a$b r2 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00c0 }
                int r2 = r2.f23043d     // Catch:{ all -> 0x00c0 }
                r1.mo33163a(r2)     // Catch:{ all -> 0x00c0 }
            L_0x0081:
                monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
                int r0 = r4.getProtocolType()
                if (r0 != 0) goto L_0x0096
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                r0.mo33169e()
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                r0.mo33170f()
            L_0x0096:
                com.tencent.android.tpush.service.cache.CacheManager.addOptStrategy(r4)
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                r0.mo33162a()
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r0 = r0.f23037d
                if (r0 == 0) goto L_0x00bf
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r0 = r0.f23037d
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.e r1 = r1.mo33174a()
                java.nio.channels.SocketChannel r1 = r1.mo33232a()
                r0.mo33173a(r1, r4)
            L_0x00bf:
                return
            L_0x00c0:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
                throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6932a.C6934b.C69351.mo33176a(com.tencent.android.tpush.horse.data.StrategyItem):void");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
            com.tencent.android.tpush.service.cache.CacheManager.addOptStrategy(r4);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
            if (r4.equals(r5) == false) goto L_0x00a6;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
            r3.f23045a.f23041b.mo33162a();
     */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
            if (com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b) == null) goto L_0x00f6;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
            com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b).mo33173a(r3.f23045a.mo33174a().mo33232a(), r4);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x00aa, code lost:
            if (r4.getRedirect() != 0) goto L_0x00da;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ac, code lost:
            r3.f23045a.f23041b.mo33162a();
     */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b7, code lost:
            if (r5.isFormatOk() == false) goto L_0x00c4;
     */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b9, code lost:
            com.tencent.android.tpush.horse.C6932a.m29604a(r3.f23045a.f23041b).add(r5);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c4, code lost:
            com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b).mo33173a(r3.f23045a.mo33174a().mo33232a(), r4);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
            r3.f23045a.f23041b.mo33162a();
            com.tencent.android.tpush.horse.C6932a.m29607c(r3.f23045a.f23041b).mo33173a(r3.f23045a.mo33174a().mo33232a(), r4);
     */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
            return;
     */
            /* renamed from: a */
            public void mo33177a(com.tencent.android.tpush.horse.data.StrategyItem r4, com.tencent.android.tpush.horse.data.StrategyItem r5) {
                /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Horse run onRedirect(org:"
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = ",redirect:"
                r0.append(r1)
                r0.append(r5)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "BaseTask"
                com.tencent.android.tpush.p580b.C6864a.m29286a(r1, r0)
                java.lang.Object r0 = com.tencent.android.tpush.horse.C6932a.f23034a
                monitor-enter(r0)
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                java.util.concurrent.LinkedBlockingQueue r1 = r1.f23035b     // Catch:{ all -> 0x00f7 }
                r1.clear()     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                boolean r1 = r1.f23039f     // Catch:{ all -> 0x00f7 }
                if (r1 == 0) goto L_0x004c
                boolean r1 = r4.isRedirected()     // Catch:{ all -> 0x00f7 }
                if (r1 != 0) goto L_0x004c
                java.lang.String r4 = "XGHorse"
                java.lang.String r5 = ">> hasSuccessCallback && !strategyItem.isRedirected()"
                com.tencent.android.tpush.p580b.C6864a.m29298c(r4, r5)     // Catch:{ all -> 0x00f7 }
                monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
                return
            L_0x004c:
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                r2 = 1
                r1.f23039f = r2     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a$b r2 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                int r2 = r2.f23043d     // Catch:{ all -> 0x00f7 }
                r1.mo33163a(r2)     // Catch:{ all -> 0x00f7 }
                int r1 = r4.getProtocolType()     // Catch:{ all -> 0x00f7 }
                if (r1 != 0) goto L_0x0075
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                r1.mo33169e()     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a$b r1 = com.tencent.android.tpush.horse.C6932a.C6934b.this     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.horse.a r1 = com.tencent.android.tpush.horse.C6932a.this     // Catch:{ all -> 0x00f7 }
                r1.mo33170f()     // Catch:{ all -> 0x00f7 }
            L_0x0075:
                monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
                com.tencent.android.tpush.service.cache.CacheManager.addOptStrategy(r4)
                boolean r0 = r4.equals(r5)
                if (r0 == 0) goto L_0x00a6
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                r5.mo33162a()
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r5 = r5.f23037d
                if (r5 == 0) goto L_0x00f6
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r5 = r5.f23037d
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.e r0 = r0.mo33174a()
                java.nio.channels.SocketChannel r0 = r0.mo33232a()
                r5.mo33173a(r0, r4)
                goto L_0x00f6
            L_0x00a6:
                int r0 = r4.getRedirect()
                if (r0 != 0) goto L_0x00da
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                r0.mo33162a()
                boolean r0 = r5.isFormatOk()
                if (r0 == 0) goto L_0x00c4
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r0 = com.tencent.android.tpush.horse.C6932a.this
                java.util.concurrent.LinkedBlockingQueue r0 = r0.f23035b
                r0.add(r5)
            L_0x00c4:
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r5 = r5.f23037d
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.e r0 = r0.mo33174a()
                java.nio.channels.SocketChannel r0 = r0.mo33232a()
                r5.mo33173a(r0, r4)
                goto L_0x00f6
            L_0x00da:
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                r5.mo33162a()
                com.tencent.android.tpush.horse.a$b r5 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.a r5 = com.tencent.android.tpush.horse.C6932a.this
                com.tencent.android.tpush.horse.a$a r5 = r5.f23037d
                com.tencent.android.tpush.horse.a$b r0 = com.tencent.android.tpush.horse.C6932a.C6934b.this
                com.tencent.android.tpush.horse.e r0 = r0.mo33174a()
                java.nio.channels.SocketChannel r0 = r0.mo33232a()
                r5.mo33173a(r0, r4)
            L_0x00f6:
                return
            L_0x00f7:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00f7 }
                throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6932a.C6934b.C69351.mo33177a(com.tencent.android.tpush.horse.data.StrategyItem, com.tencent.android.tpush.horse.data.StrategyItem):void");
            }

            /* renamed from: b */
            public void mo33178b(StrategyItem strategyItem) {
                StringBuilder sb = new StringBuilder();
                sb.append("Horse onFail(");
                sb.append(strategyItem);
                sb.append(")");
                C6864a.m29308i("BaseTask", sb.toString());
                if (strategyItem.getRedirect() != 1) {
                    C6932a.this.f23038e.decrementAndGet();
                    if (C6932a.this.f23037d != null && !C6932a.this.mo33166b()) {
                        C6932a.this.f23037d.mo33172a(strategyItem);
                    }
                } else if (!C6932a.this.f23039f) {
                    C6932a.this.f23038e.decrementAndGet();
                    if (C6932a.this.f23037d != null && !C6932a.this.mo33166b()) {
                        C6932a.this.f23037d.mo33172a(strategyItem);
                    }
                }
            }
        };
        /* renamed from: c */
        private C6945e f23042c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f23043d;
        /* renamed from: e */
        private StrategyItem f23044e;

        public C6934b(int i) {
            this.f23043d = i;
        }

        /* renamed from: a */
        public C6945e mo33174a() {
            return this.f23042c;
        }

        public void run() {
            String str = "HorseThread";
            while (C6932a.this.f23035b.size() > 0) {
                try {
                    this.f23044e = (StrategyItem) C6932a.this.f23035b.remove();
                    try {
                        TpnsRedirectReq tpnsRedirectReq = new TpnsRedirectReq();
                        tpnsRedirectReq.network = DeviceInfos.getNetworkType(C6973b.m29776f());
                        tpnsRedirectReq.f23401op = C7056i.m30217k(C6973b.m29776f());
                        this.f23042c = new C6945e();
                        this.f23042c.mo33235a(this.f23040a);
                        StringBuilder sb = new StringBuilder();
                        sb.append(" HorseThread:");
                        sb.append(getClass().getSimpleName());
                        sb.append(Thread.currentThread());
                        sb.append("current NetworkType:");
                        sb.append(tpnsRedirectReq.network);
                        sb.append(",strategyItem:");
                        sb.append(this.f23044e);
                        C6864a.m29298c(str, sb.toString());
                        this.f23042c.mo33234a(this.f23044e);
                        this.f23042c.mo33233a((JceStruct) tpnsRedirectReq);
                        this.f23042c.mo33236b();
                    } catch (Throwable th) {
                        C6864a.m29302d(str, "HorseThread error", th);
                    }
                } catch (Exception e) {
                    C6864a.m29302d(str, "Can not get strateItem from strategyItems>>", e);
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e2) {
                        C6864a.m29308i(Constants.HorseLogTag, e2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: e */
    public abstract void mo33169e();

    /* renamed from: f */
    public abstract void mo33170f();

    /* renamed from: a */
    public void mo33162a() {
        this.f23038e.set(0);
    }

    /* renamed from: b */
    public boolean mo33166b() {
        return this.f23038e.get() > 0;
    }

    /* renamed from: c */
    public boolean mo33167c() {
        return this.f23039f;
    }

    /* renamed from: d */
    public LinkedBlockingQueue<StrategyItem> mo33168d() {
        return this.f23035b;
    }

    /* renamed from: g */
    public void mo33171g() {
        String str = "BaseTask";
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("startTask() with strategyItems size = ");
            sb.append(this.f23035b.size());
            C6864a.m29298c(str, sb.toString());
        }
        for (int i = 0; i < 1; i++) {
            try {
                if (this.f23036c.get(Integer.valueOf(i)) != null) {
                    if (((C6934b) this.f23036c.get(Integer.valueOf(i))).getState() != State.TERMINATED) {
                        if (!((C6934b) this.f23036c.get(Integer.valueOf(i))).isAlive()) {
                            ((C6934b) this.f23036c.get(Integer.valueOf(i))).start();
                        }
                    }
                }
                C6934b bVar = new C6934b(i);
                this.f23036c.put(Integer.valueOf(i), bVar);
                bVar.start();
            } catch (Exception e) {
                try {
                    this.f23036c.remove(Integer.valueOf(i));
                    C6864a.m29302d(Constants.HorseLogTag, "startTask", e);
                } catch (OutOfMemoryError e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("startTask() Exception = ");
                    sb2.append(e2);
                    C6864a.m29308i(str, sb2.toString());
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo33165a(java.util.List<com.tencent.android.tpush.horse.data.StrategyItem> r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        if (r3 == 0) goto L_0x003b
        r0 = 1
        int r1 = r3.size()     // Catch:{ all -> 0x004d }
        if (r0 <= r1) goto L_0x000b
        goto L_0x003b
    L_0x000b:
        java.util.concurrent.LinkedBlockingQueue<com.tencent.android.tpush.horse.data.StrategyItem> r0 = r2.f23035b     // Catch:{ all -> 0x004d }
        r0.clear()     // Catch:{ all -> 0x004d }
        r0 = 0
        r2.f23039f = r0     // Catch:{ all -> 0x004d }
        r2.mo33162a()     // Catch:{ all -> 0x004d }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x004d }
    L_0x001a:
        boolean r0 = r3.hasNext()     // Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0039
        java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x004d }
        com.tencent.android.tpush.horse.data.StrategyItem r0 = (com.tencent.android.tpush.horse.data.StrategyItem) r0     // Catch:{ all -> 0x004d }
        java.util.concurrent.LinkedBlockingQueue<com.tencent.android.tpush.horse.data.StrategyItem> r1 = r2.f23035b     // Catch:{ all -> 0x004d }
        boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x004d }
        if (r1 != 0) goto L_0x001a
        java.util.concurrent.LinkedBlockingQueue<com.tencent.android.tpush.horse.data.StrategyItem> r1 = r2.f23035b     // Catch:{ all -> 0x004d }
        r1.add(r0)     // Catch:{ all -> 0x004d }
        java.util.concurrent.atomic.AtomicInteger r0 = r2.f23038e     // Catch:{ all -> 0x004d }
        r0.incrementAndGet()     // Catch:{ all -> 0x004d }
        goto L_0x001a
    L_0x0039:
        monitor-exit(r2)
        return
    L_0x003b:
        com.tencent.android.tpush.horse.a$a r3 = r2.f23037d     // Catch:{ all -> 0x004d }
        if (r3 == 0) goto L_0x004b
        boolean r3 = r2.mo33166b()     // Catch:{ all -> 0x004d }
        if (r3 != 0) goto L_0x004b
        com.tencent.android.tpush.horse.a$a r3 = r2.f23037d     // Catch:{ all -> 0x004d }
        r0 = 0
        r3.mo33172a(r0)     // Catch:{ all -> 0x004d }
    L_0x004b:
        monitor-exit(r2)
        return
    L_0x004d:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.horse.C6932a.mo33165a(java.util.List):void");
    }

    /* renamed from: a */
    public void mo33163a(int i) {
        try {
            if (!this.f23036c.isEmpty()) {
                for (Integer intValue : this.f23036c.keySet()) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i) {
                        C6934b bVar = (C6934b) this.f23036c.get(Integer.valueOf(intValue2));
                        if (!(bVar == null || bVar.mo33174a() == null)) {
                            bVar.mo33174a().mo33237c();
                        }
                    }
                }
                C6934b bVar2 = (C6934b) this.f23036c.remove(Integer.valueOf(i));
                if (bVar2 != null) {
                    bVar2.interrupt();
                }
            }
        } catch (Exception e) {
            C6864a.m29302d("BaseTask", "stopOtherHorse", e);
        }
    }

    /* renamed from: a */
    public void mo33164a(C6933a aVar) {
        this.f23037d = aVar;
    }
}
