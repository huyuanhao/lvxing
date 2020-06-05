package com.bytedance.embedapplog.p141a;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.collector.C1837a;
import com.bytedance.embedapplog.collector.Collector;
import com.bytedance.embedapplog.p142b.C1815b;
import com.bytedance.embedapplog.p142b.C1821h;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.p144d.C1839b;
import com.bytedance.embedapplog.p144d.C1846h;
import com.bytedance.embedapplog.p144d.C1847i;
import com.bytedance.embedapplog.util.C1855g;
import com.bytedance.embedapplog.util.C1856h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.bytedance.embedapplog.a.e */
public class C1805e implements Callback, Comparator<C1838a> {
    /* renamed from: b */
    private static C1805e f5048b;
    /* renamed from: a */
    public Application f5049a;
    /* renamed from: c */
    private C1801a f5050c;
    /* renamed from: d */
    private boolean f5051d;
    /* renamed from: e */
    private C1821h f5052e;
    /* renamed from: f */
    private final ArrayList<C1838a> f5053f = new ArrayList<>(32);
    /* renamed from: g */
    private C1839b f5054g;
    /* renamed from: h */
    private C1822i f5055h;
    /* renamed from: i */
    private Handler f5056i;
    /* renamed from: j */
    private C1811k f5057j;
    /* renamed from: k */
    private Handler f5058k;

    /* renamed from: a */
    public static void m6272a() {
        C1805e eVar = f5048b;
        if (eVar != null) {
            eVar.m6276b(null);
        }
    }

    private C1805e() {
    }

    /* renamed from: b */
    public static C1805e m6275b() {
        if (f5048b == null) {
            synchronized (C1805e.class) {
                if (f5048b == null) {
                    f5048b = new C1805e();
                }
            }
        }
        return f5048b;
    }

    /* renamed from: c */
    public static String m6277c() {
        return m6278d().f5078a;
    }

    /* renamed from: d */
    public static C1811k m6278d() {
        C1805e eVar = f5048b;
        if (eVar != null) {
            return eVar.f5057j;
        }
        C1856h.m6582a(null);
        return null;
    }

    /* renamed from: a */
    public void mo13354a(Application application, C1821h hVar, C1822i iVar, C1837a aVar) {
        this.f5049a = application;
        this.f5054g = new C1839b(application, iVar, hVar);
        this.f5052e = hVar;
        this.f5055h = iVar;
        this.f5057j = new C1811k(this.f5055h, this.f5052e);
        this.f5049a.registerActivityLifecycleCallbacks(aVar);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        this.f5058k = new Handler(handlerThread.getLooper(), this);
        boolean z = true;
        this.f5058k.sendEmptyMessage(1);
        if (hVar.mo13409l() == 0) {
            z = false;
        }
        C1855g.m6576a(z);
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            C1856h.f5225a = this.f5052e.mo13423z();
            if (!this.f5055h.mo13435e()) {
                this.f5058k.removeMessages(1);
                this.f5058k.sendEmptyMessageDelayed(1, 1000);
            } else if (this.f5052e.mo13418u()) {
                HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                handlerThread.start();
                this.f5056i = new Handler(handlerThread.getLooper(), this);
                this.f5056i.sendEmptyMessage(2);
                if (this.f5053f.size() > 0) {
                    this.f5058k.removeMessages(4);
                    this.f5058k.sendEmptyMessageDelayed(4, 1000);
                }
                C1856h.m6585d("net|worker start", null);
            }
            C1815b.m6314a();
        } else if (i == 2) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(new C1809i(this.f5049a, this.f5055h, this.f5057j));
            arrayList.add(new C1804d(this.f5049a, this.f5055h, this.f5052e));
            arrayList.add(new C1808h(this.f5049a, this.f5055h, this.f5054g));
            arrayList.add(new C1810j(this.f5049a, this.f5054g, this.f5052e, this.f5055h));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1803c cVar = (C1803c) it.next();
                long h = cVar.mo13352h();
                if (h < 864000000) {
                    this.f5056i.sendMessageDelayed(this.f5058k.obtainMessage(6, cVar), h);
                }
            }
            m6279f();
        } else if (i == 4) {
            m6276b(null);
        } else if (i == 5) {
            m6276b((String[]) message.obj);
        } else if (i == 6) {
            C1803c cVar2 = (C1803c) message.obj;
            if (!cVar2.mo13351g()) {
                long h2 = cVar2.mo13352h();
                if (h2 < 864000000) {
                    this.f5056i.sendMessageDelayed(this.f5058k.obtainMessage(6, cVar2), h2);
                }
                m6279f();
            }
        } else if (i != 7) {
            C1856h.m6582a(null);
        } else {
            synchronized (this.f5053f) {
                this.f5053f.add(C1811k.m6306d());
            }
            m6276b(null);
        }
        return true;
    }

    /* renamed from: f */
    private void m6279f() {
        if (!this.f5052e.mo13422y()) {
            C1801a aVar = this.f5050c;
            if (aVar != null) {
                aVar.mo13350f();
                this.f5050c = null;
            }
        } else if (this.f5050c == null) {
            this.f5050c = new C1801a(this.f5049a, this.f5055h, this.f5052e);
            this.f5056i.obtainMessage(6, this.f5050c).sendToTarget();
        }
    }

    /* renamed from: e */
    public boolean mo13356e() {
        this.f5051d = true;
        C1802b bVar = new C1802b(this.f5049a, this.f5055h);
        Handler handler = this.f5056i;
        if (handler == null) {
            return false;
        }
        handler.obtainMessage(6, bVar).sendToTarget();
        return true;
    }

    /* renamed from: b */
    private void m6276b(String[] strArr) {
        ArrayList arrayList;
        synchronized (this.f5053f) {
            arrayList = (ArrayList) this.f5053f.clone();
            this.f5053f.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String a : strArr) {
                arrayList.add(C1838a.m6447a(a));
            }
        }
        boolean a2 = this.f5052e.mo13393a(arrayList);
        if (arrayList.size() <= 0) {
            return;
        }
        if (!this.f5052e.mo13418u()) {
            Intent intent = new Intent(this.f5049a, Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i2 = 0;
            while (i < size) {
                strArr2[i] = ((C1838a) arrayList.get(i)).mo13467e().toString();
                i2 += strArr2[i].length();
                i++;
            }
            if (i2 >= 307200) {
                C1856h.m6582a(null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f5049a.sendBroadcast(intent);
            } catch (Exception e) {
                C1856h.m6582a(e);
            }
        } else if (a2 || arrayList.size() > 100) {
            Collections.sort(arrayList, this);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            boolean z = false;
            while (it.hasNext()) {
                C1838a aVar = (C1838a) it.next();
                if (this.f5057j.mo13360a(aVar, arrayList2)) {
                    m6280g();
                }
                if (aVar instanceof C1846h) {
                    z = C1811k.m6305a(aVar);
                    i = 1;
                }
            }
            if (i != 0) {
                if (z) {
                    this.f5058k.removeMessages(7);
                } else {
                    this.f5058k.sendEmptyMessageDelayed(7, this.f5052e.mo13366A());
                }
            }
            this.f5054g.mo13475a(arrayList2);
            if (!this.f5051d && this.f5057j.mo13362b() && this.f5056i != null && AppLog.getAutoActiveState()) {
                mo13356e();
            }
        } else {
            synchronized (this.f5053f) {
                this.f5053f.addAll(arrayList);
            }
        }
    }

    /* renamed from: g */
    private void m6280g() {
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("packAndSend once, ");
            sb.append(this.f5057j.f5078a);
            sb.append(", hadUI:");
            sb.append(this.f5057j.mo13362b());
            C1856h.m6581a(sb.toString(), null);
        }
        Handler handler = this.f5056i;
        if (handler != null) {
            handler.sendMessage(this.f5058k.obtainMessage(6, new C1806f(this.f5049a, this.f5055h, this.f5054g)));
            this.f5056i.sendMessage(this.f5058k.obtainMessage(6, new C1807g(this.f5049a, this.f5054g, this.f5052e, this.f5055h)));
        }
    }

    /* renamed from: a */
    public static void m6273a(C1838a aVar) {
        int size;
        C1805e eVar = f5048b;
        if (eVar == null) {
            C1856h.m6583b("Init comes First!", null);
            C1815b.m6315a(aVar);
            return;
        }
        if (aVar.f5155a == 0) {
            C1856h.m6582a(null);
        }
        if (aVar instanceof C1847i) {
            ((C1847i) aVar).f5201i = eVar.f5052e.mo13409l();
        }
        synchronized (eVar.f5053f) {
            size = eVar.f5053f.size();
            eVar.f5053f.add(aVar);
        }
        if (size % 10 == 0) {
            Handler handler = eVar.f5058k;
            if (handler != null) {
                handler.removeMessages(4);
                eVar.f5058k.sendEmptyMessageDelayed(4, size == 0 ? 500 : 250);
            }
        }
    }

    /* renamed from: a */
    public static void m6274a(String[] strArr) {
        C1805e eVar = f5048b;
        if (eVar == null) {
            C1856h.m6582a(new RuntimeException("Init comes First!"));
            return;
        }
        eVar.f5058k.removeMessages(4);
        eVar.f5058k.obtainMessage(5, strArr).sendToTarget();
    }

    /* renamed from: a */
    public int compare(C1838a aVar, C1838a aVar2) {
        int i = ((aVar.f5155a - aVar2.f5155a) > 0 ? 1 : ((aVar.f5155a - aVar2.f5155a) == 0 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }
}
