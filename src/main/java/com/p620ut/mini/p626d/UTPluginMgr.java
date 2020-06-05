package com.p620ut.mini.p626d;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.log.UTMCStatConfig;
import com.alibaba.mtl.log.p077d.Logger;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusCallbacks;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.ut.mini.d.c */
public class UTPluginMgr implements UTMCAppStatusCallbacks {
    /* renamed from: a */
    private static UTPluginMgr f26041a = new UTPluginMgr();
    /* renamed from: b */
    private HandlerThread f26042b = null;
    /* renamed from: c */
    private Handler f26043c = null;
    /* renamed from: d */
    private List<UTPlugin> f26044d = new LinkedList();
    /* renamed from: e */
    private List<String> f26045e = new ArrayList();
    /* renamed from: f */
    private List<String> f26046f = new ArrayList<String>() {
        {
            add("com.ut.mini.perf.UTPerfPlugin");
        }
    };
    /* renamed from: g */
    private List<UTPlugin> f26047g = new LinkedList();

    /* compiled from: UTPluginMgr */
    /* renamed from: com.ut.mini.d.c$a */
    private static class C7717a {
        /* renamed from: a */
        private int f26050a;
        /* renamed from: b */
        private Object f26051b;
        /* renamed from: c */
        private UTPlugin f26052c;

        private C7717a() {
            this.f26050a = 0;
            this.f26051b = null;
            this.f26052c = null;
        }

        /* renamed from: a */
        public int mo37441a() {
            return this.f26050a;
        }

        /* renamed from: a */
        public void mo37442a(int i) {
            this.f26050a = i;
        }

        /* renamed from: b */
        public Object mo37445b() {
            return this.f26051b;
        }

        /* renamed from: a */
        public void mo37444a(Object obj) {
            this.f26051b = obj;
        }

        /* renamed from: c */
        public UTPlugin mo37446c() {
            return this.f26052c;
        }

        /* renamed from: a */
        public void mo37443a(UTPlugin aVar) {
            this.f26052c = aVar;
        }
    }

    /* renamed from: a */
    public void mo37405a(Activity activity) {
    }

    /* renamed from: a */
    public void mo37406a(Activity activity, Bundle bundle) {
    }

    /* renamed from: b */
    public void mo37408b(Activity activity) {
    }

    /* renamed from: b */
    public void mo37409b(Activity activity, Bundle bundle) {
    }

    /* renamed from: c */
    public void mo37410c(Activity activity) {
    }

    private UTPluginMgr() {
        if (VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.m33141a((UTMCAppStatusCallbacks) this);
        }
    }

    /* renamed from: c */
    public static UTPluginMgr m33170c() {
        return f26041a;
    }

    /* renamed from: d */
    private void m33171d() {
        this.f26042b = new HandlerThread("UT-PLUGIN-ASYNC");
        this.f26042b.start();
        this.f26043c = new Handler(this.f26042b.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1 && (message.obj instanceof C7717a)) {
                    C7717a aVar = (C7717a) message.obj;
                    UTPlugin c = aVar.mo37446c();
                    int a = aVar.mo37441a();
                    Object b = aVar.mo37445b();
                    if (c != null) {
                        try {
                            if (b instanceof UTPluginMsgDispatchDelegate) {
                                UTPluginMsgDispatchDelegate dVar = (UTPluginMsgDispatchDelegate) b;
                                if (dVar.mo37447a(c)) {
                                    c.mo37432a(a, dVar.mo37448b(c));
                                    return;
                                }
                                return;
                            }
                            c.mo37432a(a, b);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    /* renamed from: e */
    private UTPluginContext m33172e() {
        UTPluginContext bVar = new UTPluginContext();
        bVar.mo37436a(UTMCStatConfig.m3729a().mo11772d());
        if (Logger.m3837b()) {
            bVar.mo37437a(Logger.m3837b());
        }
        return bVar;
    }

    /* renamed from: a */
    public synchronized void mo37438a(UTPlugin aVar, boolean z) {
        if (aVar != null) {
            if (!this.f26047g.contains(aVar)) {
                aVar.mo37433a(m33172e());
                this.f26047g.add(aVar);
                if (!z) {
                    this.f26044d.add(aVar);
                }
                aVar.mo37434c();
            }
        }
    }

    /* renamed from: a */
    private boolean m33169a(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : iArr) {
            if (i2 == i) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo37439a(int i, Object obj) {
        boolean z;
        if (this.f26043c == null) {
            m33171d();
        }
        boolean z2 = false;
        if (this.f26047g.size() > 0) {
            for (UTPlugin aVar : this.f26047g) {
                int[] d = aVar.mo37435d();
                if (d != null && m33169a(i, d)) {
                    if (i != 1) {
                        if (this.f26044d == null || !this.f26044d.contains(aVar)) {
                            C7717a aVar2 = new C7717a();
                            aVar2.mo37442a(i);
                            aVar2.mo37444a(obj);
                            aVar2.mo37443a(aVar);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = aVar2;
                            this.f26043c.sendMessage(obtain);
                            z2 = true;
                        }
                    }
                    try {
                        if (obj instanceof UTPluginMsgDispatchDelegate) {
                            UTPluginMsgDispatchDelegate dVar = (UTPluginMsgDispatchDelegate) obj;
                            if (dVar.mo37447a(aVar)) {
                                aVar.mo37432a(i, dVar.mo37448b(aVar));
                            }
                        } else {
                            aVar.mo37432a(i, obj);
                        }
                        z2 = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo37404a() {
        mo37439a(2, (Object) null);
    }

    /* renamed from: b */
    public void mo37407b() {
        mo37439a(8, (Object) null);
    }
}
