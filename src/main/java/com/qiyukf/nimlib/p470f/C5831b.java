package com.qiyukf.nimlib.p470f;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p450b.C5723c;
import com.qiyukf.nimlib.p470f.p471a.C5826a;
import com.qiyukf.nimlib.p470f.p471a.C5830b;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.p513g.C6171b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.f.b */
public final class C5831b {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Messenger f18508a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public IBinder f18509b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5836c f18510c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5836c f18511d;
    /* renamed from: e */
    private final List<Message> f18512e = new ArrayList();
    /* renamed from: f */
    private Messenger f18513f;

    /* renamed from: com.qiyukf.nimlib.f.b$a */
    private class C5835a extends Handler {
        C5835a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 103) {
                    switch (i) {
                        case 14:
                            C5826a aVar = (C5826a) C5825a.m23355a(message);
                            if (aVar != null) {
                                C5668c.m22861a().mo27860a(aVar);
                                break;
                            }
                            break;
                        case 15:
                            C5668c.m22861a().mo27861a((C5830b) C5825a.m23356b(message));
                            return;
                        case 16:
                            ArrayList arrayList = (ArrayList) C5825a.m23356b(message);
                            C5668c.m22861a();
                            C5668c.m22862a(arrayList);
                            return;
                        case 17:
                            C5723c.m23046e().mo27975a((String) C5825a.m23356b(message));
                            return;
                        default:
                            super.handleMessage(message);
                            break;
                    }
                    return;
                }
                C6171b.m24487a(((Boolean) C5825a.m23356b(message)).booleanValue());
            } catch (Throwable th) {
                C5264a.m21621b("LocalAgent", "handle push message error.", th);
            }
        }
    }

    public C5831b(Context context) {
        String str = "LocalAgent";
        if (!C5743d.m23121f()) {
            C5264a.m21617a(str, "LocalAgent only lives in main process");
            return;
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.f18513f = new Messenger(new C5835a(handlerThread.getLooper()));
        m23375a(context);
    }

    /* renamed from: a */
    private void m23374a(int i, Parcelable parcelable) {
        m23376a(C5825a.m23354a(i, parcelable));
    }

    /* renamed from: a */
    private void m23375a(Context context) {
        this.f18510c = new C5836c(context, NimService.m23853b(context), "main_conn") {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final void mo28145a(IBinder iBinder) {
                C5831b.m23377a(C5831b.this, iBinder);
                C5831b.this.f18510c.mo28150c();
            }
        };
        this.f18511d = new C5836c(context, NimService.m23854c(context), "aux_conn") {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final void mo28146a() {
                C5264a.m21617a("LocalAgent", "AuxService onServiceDisconnected");
                C5831b.this.f18511d.mo28149b();
            }

            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final void mo28145a(IBinder iBinder) {
                if (C5831b.this.f18509b == null || C5831b.this.f18508a == null) {
                    C5264a.m21617a("LocalAgent", "AuxService onConnected, reconnect NimService...");
                    C5831b.this.f18510c.mo28149b();
                }
            }
        };
        this.f18510c.mo28149b();
        this.f18511d.mo28149b();
    }

    /* renamed from: a */
    private void m23376a(Message message) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            try {
                if (this.f18508a != null) {
                    this.f18508a.send(message);
                    z = true;
                }
            } catch (DeadObjectException unused) {
                m23381c();
            } catch (Exception e) {
                if (!C5841e.m23410a(e)) {
                    m23378a(false);
                    break;
                }
                i++;
            }
        }
        if (!z) {
            synchronized (this.f18512e) {
                this.f18512e.add(message);
            }
            this.f18510c.mo28149b();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23377a(C5831b bVar, IBinder iBinder) {
        bVar.f18509b = iBinder;
        try {
            iBinder.linkToDeath(new DeathRecipient() {
                public final void binderDied() {
                    C5831b.this.m23381c();
                }
            }, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        bVar.m23378a(true);
    }

    /* renamed from: a */
    private void m23378a(boolean z) {
        if (z) {
            IBinder iBinder = this.f18509b;
            if (iBinder != null) {
                this.f18508a = new Messenger(iBinder);
                Message obtain = Message.obtain(null, 1);
                obtain.replyTo = this.f18513f;
                try {
                    this.f18508a.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    m23378a(false);
                }
                m23383d();
                return;
            }
        }
        this.f18508a = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m23381c() {
        C5264a.m21617a("LocalAgent", "!!! Push binder dead !!!");
        this.f18509b = null;
        m23378a(false);
    }

    /* renamed from: d */
    private void m23383d() {
        ArrayList<Message> arrayList;
        synchronized (this.f18512e) {
            if (this.f18512e.size() > 0) {
                arrayList = new ArrayList<>(this.f18512e);
                this.f18512e.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            for (Message a : arrayList) {
                m23376a(a);
            }
        }
    }

    /* renamed from: a */
    public final void mo28139a() {
        m23374a(11, (Parcelable) null);
    }

    /* renamed from: a */
    public final void mo28140a(int i) {
        m23376a(C5825a.m23354a(101, Integer.valueOf(i)));
    }

    /* renamed from: a */
    public final void mo28141a(C5826a aVar) {
        for (C5826a a : aVar.mo28132a()) {
            m23374a(13, (Parcelable) a);
        }
    }

    /* renamed from: a */
    public final void mo28142a(LoginInfo loginInfo) {
        m23374a(10, (Parcelable) loginInfo);
    }

    /* renamed from: a */
    public final void mo28143a(SavePowerConfig savePowerConfig) {
        m23376a(C5825a.m23354a(102, savePowerConfig));
    }

    /* renamed from: b */
    public final void mo28144b() {
        if (C5718b.m23009a() == null) {
            C5264a.m21617a("SDKCache.getContext() is", "null");
        } else if (this.f18508a == null || this.f18509b == null) {
            C5836c cVar = this.f18510c;
            if (cVar == null || !cVar.mo28151d()) {
                C5836c cVar2 = this.f18511d;
                if (cVar2 == null || !cVar2.mo28151d()) {
                    C5264a.m21617a("LocalAgent", "IPC has not established while awaking UI, start rebinding...");
                    NimService.m23852a(C5718b.m23009a(), 1);
                    m23375a(C5718b.m23009a());
                    return;
                }
                C5264a.m21617a("aux:", this.f18511d.toString());
                return;
            }
            C5264a.m21617a("main:", this.f18510c.toString());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18508a.toString());
            sb.append(this.f18509b.toString());
            C5264a.m21617a("sender and binder:", sb.toString());
        }
    }
}
