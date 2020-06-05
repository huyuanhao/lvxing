package com.qiyukf.nimlib.p470f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.util.Pair;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p450b.C5721b;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p470f.p471a.C5830b;
import com.qiyukf.nimlib.p473h.C5906f;
import com.qiyukf.nimlib.p473h.C5911g;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.WakeupService;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.p513g.C6174c;
import com.qiyukf.unicorn.p513g.C6177d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.f.d */
public final class C5837d {
    /* renamed from: a */
    private final Messenger f18522a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Messenger f18523b;
    /* renamed from: c */
    private final List<Pair<Integer, Object>> f18524c;

    /* renamed from: com.qiyukf.nimlib.f.d$a */
    private static class C5839a {
        /* renamed from: a */
        static C5837d f18526a = new C5837d(0);
    }

    /* renamed from: com.qiyukf.nimlib.f.d$b */
    private class C5840b extends Handler {
        C5840b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 1) {
                    if (i == 13) {
                        C5826a aVar = (C5826a) C5825a.m23355a(message);
                        if (aVar != null) {
                            C5906f.m23656a().mo28281a(aVar);
                        }
                    } else if (i == 10) {
                        C5906f.m23656a().mo28282a((LoginInfo) C5825a.m23355a(message));
                        return;
                    } else if (i == 11) {
                        C5906f.m23656a().mo28283b();
                        return;
                    } else if (i == 101) {
                        C6174c.m24489a(C5718b.m23009a()).mo29240a(((Integer) C5825a.m23356b(message)).intValue());
                        return;
                    } else if (i != 102) {
                        super.handleMessage(message);
                    } else {
                        C6177d.m24495a().mo29246a((SavePowerConfig) C5825a.m23356b(message));
                        return;
                    }
                    return;
                }
                C5837d.m23404a(C5837d.this, message);
            } catch (Throwable th) {
                C5264a.m21625d("RemoteAgent", "handle message error.", th);
            }
        }
    }

    private C5837d() {
        this.f18524c = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("RemoteAgent");
        handlerThread.start();
        this.f18522a = new Messenger(new C5840b(handlerThread.getLooper()));
    }

    /* synthetic */ C5837d(byte b) {
        this();
    }

    /* renamed from: a */
    public static void m23401a() {
        if (C5743d.m23116b()) {
            m23402a(16, (Object) C5911g.m23678b());
        }
    }

    /* renamed from: a */
    private static void m23402a(int i, Object obj) {
        String str;
        boolean z = false;
        try {
            if (C5743d.m23116b() && C5839a.f18526a.f18523b != null) {
                C5839a.f18526a.f18523b.send(C5825a.m23354a(i, obj));
                z = true;
            }
        } catch (Exception unused) {
            if (C5839a.f18526a == null) {
                str = "remoteagent is null";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(C5839a.f18526a.toString());
                sb.append(i);
                str = sb.toString();
            }
            C5264a.m21617a("RemoteAgent send message exception", str);
        }
        if (!z) {
            synchronized (C5839a.f18526a.f18524c) {
                C5839a.f18526a.f18524c.add(new Pair(Integer.valueOf(i), obj));
            }
            C5264a.m21617a("RemoteAgent", "awake UI process and bind core");
            WakeupService.m23855a(C5718b.m23009a());
        }
    }

    /* renamed from: a */
    public static void m23403a(C5687a aVar) {
        for (C5826a a : new C5826a(aVar).mo28132a()) {
            m23402a(14, (Object) a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23404a(C5837d dVar, Message message) {
        try {
            dVar.f18523b = message.replyTo;
            dVar.f18523b.getBinder().linkToDeath(new DeathRecipient() {
                public final void binderDied() {
                    C5264a.m21617a("RemoteAgent", "UI binder dead!");
                    C5743d.m23115b(false);
                    C5837d.this.f18523b = null;
                }
            }, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ArrayList<Pair> arrayList = null;
        synchronized (C5839a.f18526a.f18524c) {
            if (C5839a.f18526a.f18524c.size() > 0) {
                arrayList = new ArrayList<>(C5839a.f18526a.f18524c);
                C5839a.f18526a.f18524c.clear();
            }
        }
        if (arrayList != null) {
            C5264a.m21617a("RemoteAgent", "onPend, send pending data");
            for (Pair pair : arrayList) {
                m23402a(((Integer) pair.first).intValue(), (Object) pair.second);
            }
        }
    }

    /* renamed from: a */
    public static void m23405a(StatusCode statusCode) {
        if (C5743d.m23116b() || statusCode.wontAutoLogin()) {
            m23402a(15, (Object) new C5830b(statusCode, C5743d.m23123h(), C5718b.m23018e()));
        }
    }

    /* renamed from: a */
    public static void m23406a(boolean z) {
        m23402a(103, (Object) Boolean.valueOf(z));
    }

    /* renamed from: b */
    public static void m23407b() {
        m23402a(17, (Object) C5721b.m23039e().mo27971c());
    }

    /* renamed from: c */
    public static IBinder m23408c() {
        return C5839a.f18526a.f18522a.getBinder();
    }

    /* renamed from: d */
    public static void m23409d() {
        if (!C5743d.m23116b()) {
            C5264a.m21617a("RemoteAgent", "UI process bound!");
            C5743d.m23115b(true);
            m23405a(C5743d.m23120e());
            m23401a();
        }
    }
}
