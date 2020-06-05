package com.bytedance.sdk.openadsdk.p165c;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.NetApi;
import com.bytedance.sdk.openadsdk.p165c.EventFace;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ListUtils;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.c.g */
public class AdEventThread<T extends EventFace> extends HandlerThread implements Callback {
    /* renamed from: a */
    public static String f6753a = "AdEventThread";
    /* renamed from: b */
    public static String f6754b = "ttad_bk";
    /* renamed from: c */
    public final AdEventRepertory<T> f6755c;
    /* renamed from: d */
    public NetApi<T> f6756d;
    /* renamed from: e */
    public final List<T> f6757e = Collections.synchronizedList(new LinkedList());
    /* renamed from: f */
    public long f6758f;
    /* renamed from: g */
    public boolean f6759g;
    /* renamed from: h */
    public int f6760h;
    /* renamed from: i */
    public Handler f6761i;
    /* renamed from: j */
    public final C2086a f6762j;
    /* renamed from: k */
    public final C2087b f6763k;
    /* renamed from: l */
    protected boolean f6764l = false;

    /* compiled from: AdEventThread */
    /* renamed from: com.bytedance.sdk.openadsdk.c.g$a */
    public interface C2086a {
        /* renamed from: a */
        boolean mo15017a();
    }

    /* compiled from: AdEventThread */
    /* renamed from: com.bytedance.sdk.openadsdk.c.g$b */
    public static class C2087b {
        /* renamed from: a */
        final int f6765a;
        /* renamed from: b */
        final long f6766b;
        /* renamed from: c */
        final long f6767c;
        /* renamed from: d */
        final int f6768d;
        /* renamed from: e */
        final long f6769e;
        /* renamed from: f */
        final long f6770f;

        C2087b(int i, long j, long j2, int i2, long j3, long j4) {
            this.f6765a = i;
            this.f6766b = j;
            this.f6767c = j2;
            this.f6768d = i2;
            this.f6769e = j3;
            this.f6770f = j4;
        }

        /* renamed from: a */
        public static C2087b m8469a() {
            C2087b bVar = new C2087b(1, 120000, 15000, 5, 172800000, 300000);
            return bVar;
        }

        /* renamed from: b */
        public static C2087b m8470b() {
            C2087b bVar = new C2087b(3, 120000, 15000, 5, 172800000, 300000);
            return bVar;
        }
    }

    public AdEventThread(AdEventRepertory<T> eVar, NetApi<T> pVar, C2087b bVar, C2086a aVar) {
        super(f6754b);
        this.f6763k = bVar;
        this.f6762j = aVar;
        this.f6755c = eVar;
        this.f6756d = pVar;
    }

    public AdEventThread(String str, String str2, AdEventRepertory<T> eVar, NetApi<T> pVar, C2087b bVar, C2086a aVar) {
        super(str);
        f6753a = str2;
        this.f6763k = bVar;
        this.f6762j = aVar;
        this.f6755c = eVar;
        this.f6756d = pVar;
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        this.f6758f = System.currentTimeMillis();
        this.f6761i = new Handler(getLooper(), this);
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            m8447a((T) (EventFace) message.obj);
        } else if (i == 2) {
            m8455d();
        } else if (i == 3) {
            m8453c();
        } else if (i == 4) {
            m8450b();
        } else if (i == 5) {
            m8445a();
        }
        return true;
    }

    /* renamed from: a */
    private void m8445a() {
        this.f6755c.mo15005a(this.f6763k.f6768d, this.f6763k.f6769e);
        this.f6759g = this.f6755c.mo15010b();
        this.f6760h = this.f6755c.mo15011c();
        if (this.f6759g) {
            StringBuilder sb = new StringBuilder();
            sb.append("onHandleInitEvent serverBusy, retryCount = ");
            sb.append(this.f6760h);
            m8448a(sb.toString());
            m8459h();
            return;
        }
        m8451b(this.f6755c.mo15003a());
        m8448a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onHandleInitEvent cacheData count = ");
        sb2.append(this.f6757e.size());
        m8448a(sb2.toString());
        m8456e();
    }

    /* renamed from: b */
    private void m8451b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    for (T b : this.f6757e) {
                        hashSet.add(b.mo14996b());
                    }
                    for (T t : list) {
                        if (!hashSet.contains(t.mo14996b())) {
                            this.f6757e.add(t);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        m8448a("reloadCacheList adEventList is empty======");
    }

    /* renamed from: b */
    private void m8450b() {
        if (!this.f6762j.mo15017a()) {
            m8446a(4, this.f6763k.f6767c);
            m8448a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List a = this.f6755c.mo15003a();
        m8454c(a);
        if (ListUtils.m12208a(a)) {
            m8448a("onHandleServerBusyRetryEvent, empty list start routine");
            m8466o();
            m8461j();
            return;
        }
        AdEventUploadResult a2 = mo15014a(a);
        if (a2 != null) {
            if (a2.f6771a) {
                m8448a("onHandleServerBusyRetryEvent, success");
                m8458g();
                m8457f();
            } else if (m8449a(a2)) {
                this.f6760h++;
                this.f6755c.mo15004a(this.f6760h);
                this.f6755c.mo15008a(a, this.f6763k.f6768d, this.f6763k.f6769e);
                m8459h();
                StringBuilder sb = new StringBuilder();
                sb.append("onHandleServerBusyRetryEvent, serverbusy, count = ");
                sb.append(this.f6760h);
                m8448a(sb.toString());
            } else if (m8452b(a2)) {
                m8458g();
                m8457f();
            } else if (!this.f6764l) {
                m8460i();
                m8448a("onHandleServerBusyRetryEvent, net fail");
            } else {
                this.f6760h++;
                this.f6755c.mo15004a(this.f6760h);
                this.f6755c.mo15008a(a, this.f6763k.f6768d, this.f6763k.f6769e);
                m8463l();
            }
        }
    }

    /* renamed from: a */
    public AdEventUploadResult mo15014a(List<T> list) {
        if (this.f6756d == null) {
            InternalContainer.m10067f();
        }
        NetApi<T> pVar = this.f6756d;
        if (pVar == null) {
            return null;
        }
        return pVar.mo15913a(list);
    }

    /* renamed from: c */
    private void m8453c() {
        if (!this.f6759g) {
            m8448a("onHandleRoutineRetryEvent");
            m8456e();
        }
    }

    /* renamed from: d */
    private void m8455d() {
        if (!this.f6759g) {
            m8448a("onHandleRoutineUploadEvent");
            m8456e();
        }
    }

    /* renamed from: a */
    private void m8447a(T t) {
        m8454c(this.f6757e);
        this.f6755c.mo15006a(t);
        m8448a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
        if (!this.f6759g) {
            m8448a("onHandleReceivedAdEvent");
            this.f6757e.add(t);
            if (m8465n()) {
                m8448a("onHandleReceivedAdEvent upload");
                m8456e();
            }
        }
    }

    /* renamed from: c */
    private void m8454c(List<T> list) {
        if (this.f6764l && list != null) {
            if (list.size() <= 100) {
                StringBuilder sb = new StringBuilder();
                sb.append("start and return, checkAndDeleteEvent local size:");
                sb.append(list.size());
                sb.append("小于:");
                sb.append(100);
                m8448a(sb.toString());
                return;
            }
            int size = (int) (((float) list.size()) - 75.0f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("start checkAndDeleteEvent local size,deleteCnt:");
            sb2.append(list.size());
            sb2.append(StorageInterface.KEY_SPLITER);
            sb2.append(size);
            m8448a(sb2.toString());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add((EventFace) list.get(i));
            }
            list.removeAll(arrayList);
            this.f6755c.mo15007a((List<T>) arrayList);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("end checkAndDeleteEvent local size:");
            sb3.append(list.size());
            m8448a(sb3.toString());
        }
    }

    /* renamed from: e */
    private void m8456e() {
        this.f6761i.removeMessages(3);
        this.f6761i.removeMessages(2);
        if (ListUtils.m12208a(this.f6757e)) {
            this.f6758f = System.currentTimeMillis();
            m8461j();
        } else if (!this.f6762j.mo15017a()) {
            m8448a("doRoutineUpload no net, wait retry");
            m8460i();
        } else {
            AdEventUploadResult a = mo15014a(this.f6757e);
            if (a != null) {
                if (a.f6771a) {
                    m8448a("doRoutineUpload success");
                    m8458g();
                    m8457f();
                } else if (m8449a(a)) {
                    m8448a("doRoutineUpload serverbusy");
                    m8462k();
                } else if (m8452b(a)) {
                    m8458g();
                    m8457f();
                } else if (!this.f6759g) {
                    if (!this.f6764l) {
                        m8460i();
                        m8448a("doRoutineUpload net fail retry");
                    } else {
                        m8463l();
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private void m8457f() {
        this.f6758f = System.currentTimeMillis();
        m8466o();
        m8461j();
    }

    /* renamed from: g */
    private void m8458g() {
        m8448a("clearCacheList, delete event from cache and db");
        this.f6755c.mo15007a(this.f6757e);
        this.f6757e.clear();
    }

    /* renamed from: h */
    private void m8459h() {
        m8446a(4, m8464m());
    }

    /* renamed from: i */
    private void m8460i() {
        m8446a(3, this.f6763k.f6767c);
    }

    /* renamed from: j */
    private void m8461j() {
        m8446a(2, this.f6763k.f6766b);
    }

    /* renamed from: a */
    private void m8446a(int i, long j) {
        Message obtainMessage = this.f6761i.obtainMessage();
        obtainMessage.what = i;
        this.f6761i.sendMessageDelayed(obtainMessage, j);
    }

    /* renamed from: k */
    private void m8462k() {
        this.f6759g = true;
        this.f6755c.mo15009a(true);
        this.f6757e.clear();
        this.f6761i.removeMessages(3);
        this.f6761i.removeMessages(2);
        m8459h();
    }

    /* renamed from: l */
    private void m8463l() {
        this.f6759g = true;
        this.f6755c.mo15009a(true);
        this.f6757e.clear();
        this.f6761i.removeMessages(3);
        this.f6761i.removeMessages(2);
        m8459h();
    }

    /* renamed from: m */
    private long m8464m() {
        return ((long) ((this.f6760h % 3) + 1)) * this.f6763k.f6770f;
    }

    /* renamed from: a */
    private static boolean m8449a(AdEventUploadResult hVar) {
        return hVar.f6772b == 509;
    }

    /* renamed from: b */
    private static boolean m8452b(AdEventUploadResult hVar) {
        return hVar.f6774d;
    }

    /* renamed from: n */
    private boolean m8465n() {
        return !this.f6759g && (this.f6757e.size() >= this.f6763k.f6765a || System.currentTimeMillis() - this.f6758f >= this.f6763k.f6766b);
    }

    /* renamed from: o */
    private void m8466o() {
        this.f6759g = false;
        this.f6755c.mo15009a(false);
        this.f6760h = 0;
        this.f6755c.mo15004a(0);
        this.f6761i.removeMessages(4);
    }

    /* renamed from: a */
    private void m8448a(String str) {
        C2564t.m12220b(f6753a, str);
    }
}
