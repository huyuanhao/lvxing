package com.qiyukf.unicorn;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.nimlib.p485i.C5925h;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.pop.OnSessionListChangedListener;
import com.qiyukf.unicorn.api.pop.Session;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6129j;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6154j;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p516j.C6218e;
import com.tencent.mid.core.Constants.ERROR;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.qiyukf.unicorn.c */
public final class C6015c {
    /* renamed from: a */
    private final List<RecentContact> f18822a = new ArrayList();
    /* renamed from: b */
    private final List<UnreadCountChangeListener> f18823b = new ArrayList();
    /* renamed from: c */
    private final List<OnSessionListChangedListener> f18824c = new ArrayList();
    /* renamed from: d */
    private Handler f18825d = C5361a.m22014b();
    /* renamed from: e */
    private boolean f18826e = false;

    public C6015c() {
        C60194 r0 = new Observer<List<RecentContact>>() {
            public final /* synthetic */ void onEvent(Object obj) {
                List list = (List) obj;
                if (list != null) {
                    C6015c.m23989a(C6015c.this, list);
                    C6015c.this.m23995b(list);
                }
                C6015c.this.m23998g();
            }
        };
        C60205 r1 = new Observer<RecentContact>() {
            public final /* synthetic */ void onEvent(Object obj) {
                RecentContact recentContact = (RecentContact) obj;
                if (recentContact == null) {
                    C6015c.this.m23997f();
                    return;
                }
                C6015c.this.m23986a(recentContact);
                C6015c.this.m23991b(recentContact);
                if (recentContact.getUnreadCount() > 0) {
                    C6015c.this.m23998g();
                }
            }
        };
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeRecentContact(r0, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeRecentContactDeleted(r1, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23986a(RecentContact recentContact) {
        synchronized (this.f18822a) {
            Iterator it = this.f18822a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RecentContact recentContact2 = (RecentContact) it.next();
                if (recentContact2.getContactId().equals(recentContact.getContactId()) && recentContact2.getSessionType() == recentContact.getSessionType()) {
                    this.f18822a.remove(recentContact2);
                    break;
                }
            }
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact>, for r7v0, types: [java.util.List, java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact>] */
    /* renamed from: a */
    static /* synthetic */ void m23989a(com.qiyukf.unicorn.C6015c r6, java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r7) {
        /*
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r0 = r6.f18822a
        monitor-enter(r0)
        java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x007e }
    L_0x0007:
        boolean r1 = r7.hasNext()     // Catch:{ all -> 0x007e }
        if (r1 == 0) goto L_0x007c
        java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x007e }
        com.qiyukf.nimlib.sdk.msg.model.RecentContact r1 = (com.qiyukf.nimlib.sdk.msg.model.RecentContact) r1     // Catch:{ all -> 0x007e }
        r2 = -1
        r3 = 0
    L_0x0015:
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r4 = r6.f18822a     // Catch:{ all -> 0x007e }
        int r4 = r4.size()     // Catch:{ all -> 0x007e }
        if (r3 >= r4) goto L_0x004a
        java.lang.String r4 = r1.getContactId()     // Catch:{ all -> 0x007e }
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r5 = r6.f18822a     // Catch:{ all -> 0x007e }
        java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x007e }
        com.qiyukf.nimlib.sdk.msg.model.RecentContact r5 = (com.qiyukf.nimlib.sdk.msg.model.RecentContact) r5     // Catch:{ all -> 0x007e }
        java.lang.String r5 = r5.getContactId()     // Catch:{ all -> 0x007e }
        boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x007e }
        if (r4 == 0) goto L_0x0047
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r4 = r1.getSessionType()     // Catch:{ all -> 0x007e }
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r5 = r6.f18822a     // Catch:{ all -> 0x007e }
        java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x007e }
        com.qiyukf.nimlib.sdk.msg.model.RecentContact r5 = (com.qiyukf.nimlib.sdk.msg.model.RecentContact) r5     // Catch:{ all -> 0x007e }
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r5 = r5.getSessionType()     // Catch:{ all -> 0x007e }
        if (r4 != r5) goto L_0x0047
        r2 = r3
        goto L_0x004a
    L_0x0047:
        int r3 = r3 + 1
        goto L_0x0015
    L_0x004a:
        if (r2 < 0) goto L_0x0064
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r3 = r6.f18822a     // Catch:{ all -> 0x007e }
        java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x007e }
        com.qiyukf.nimlib.sdk.msg.model.RecentContact r2 = (com.qiyukf.nimlib.sdk.msg.model.RecentContact) r2     // Catch:{ all -> 0x007e }
        r3 = r1
        com.qiyukf.nimlib.i.h r3 = (com.qiyukf.nimlib.p485i.C5925h) r3     // Catch:{ all -> 0x007e }
        com.qiyukf.unicorn.api.msg.SessionStatusEnum r4 = r2.getSessionStatus()     // Catch:{ all -> 0x007e }
        r3.mo28340a(r4)     // Catch:{ all -> 0x007e }
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r3 = r6.f18822a     // Catch:{ all -> 0x007e }
        r3.remove(r2)     // Catch:{ all -> 0x007e }
        goto L_0x0076
    L_0x0064:
        com.qiyukf.unicorn.h.d r2 = com.qiyukf.unicorn.C6029d.m24047g()     // Catch:{ all -> 0x007e }
        java.lang.String r3 = r1.getContactId()     // Catch:{ all -> 0x007e }
        com.qiyukf.unicorn.api.msg.SessionStatusEnum r2 = r2.mo29307i(r3)     // Catch:{ all -> 0x007e }
        r3 = r1
        com.qiyukf.nimlib.i.h r3 = (com.qiyukf.nimlib.p485i.C5925h) r3     // Catch:{ all -> 0x007e }
        r3.mo28340a(r2)     // Catch:{ all -> 0x007e }
    L_0x0076:
        java.util.List<com.qiyukf.nimlib.sdk.msg.model.RecentContact> r2 = r6.f18822a     // Catch:{ all -> 0x007e }
        r2.add(r1)     // Catch:{ all -> 0x007e }
        goto L_0x0007
    L_0x007c:
        monitor-exit(r0)     // Catch:{ all -> 0x007e }
        return
    L_0x007e:
        r6 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x007e }
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.C6015c.m23989a(com.qiyukf.unicorn.c, java.util.List):void");
    }

    /* renamed from: a */
    private static boolean m23990a(int i) {
        for (SessionStatusEnum value : SessionStatusEnum.values()) {
            if (value.value() == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23991b(final RecentContact recentContact) {
        synchronized (this.f18824c) {
            for (final OnSessionListChangedListener onSessionListChangedListener : this.f18824c) {
                C6218e.m24652b(new Runnable() {
                    public final void run() {
                        onSessionListChangedListener.onSessionDelete(recentContact.getContactId());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23995b(final List<RecentContact> list) {
        synchronized (this.f18824c) {
            for (final OnSessionListChangedListener onSessionListChangedListener : this.f18824c) {
                C6218e.m24652b(new Runnable() {
                    public final void run() {
                        onSessionListChangedListener.onSessionUpdate(C6015c.m23996c(list));
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static List<Session> m23996c(List<RecentContact> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23997f() {
        synchronized (this.f18822a) {
            int d = mo28858d();
            Iterator it = this.f18822a.iterator();
            while (it.hasNext()) {
                RecentContact recentContact = (RecentContact) it.next();
                it.remove();
                m23991b(recentContact);
            }
            if (d > 0) {
                m23998g();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m23998g() {
        final int d = mo28858d();
        synchronized (this.f18823b) {
            for (final UnreadCountChangeListener unreadCountChangeListener : this.f18823b) {
                C6218e.m24652b(new Runnable() {
                    public final void run() {
                        unreadCountChangeListener.onUnreadCountChange(d);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public final int mo28848a(String str) {
        synchronized (this.f18822a) {
            for (RecentContact recentContact : this.f18822a) {
                if (TextUtils.equals(str, recentContact.getContactId())) {
                    int unreadCount = recentContact.getUnreadCount();
                    return unreadCount;
                }
            }
            return 0;
        }
    }

    /* renamed from: a */
    public final void mo28849a() {
        synchronized (this.f18822a) {
            if (!this.f18822a.isEmpty()) {
                m23997f();
            }
            List queryRecentContactsBlock = ((MsgService) NIMClient.getService(MsgService.class)).queryRecentContactsBlock();
            if (queryRecentContactsBlock != null && !queryRecentContactsBlock.isEmpty()) {
                this.f18822a.addAll(queryRecentContactsBlock);
                m23995b(queryRecentContactsBlock);
                m23998g();
            }
        }
    }

    /* renamed from: a */
    public final void mo28850a(final UnreadCountChangeListener unreadCountChangeListener, boolean z) {
        if (unreadCountChangeListener != null) {
            synchronized (this.f18823b) {
                if (z) {
                    try {
                        if (!this.f18823b.contains(unreadCountChangeListener)) {
                            this.f18823b.add(unreadCountChangeListener);
                            C6218e.m24652b(new Runnable() {
                                public final void run() {
                                    unreadCountChangeListener.onUnreadCountChange(C6015c.this.mo28858d());
                                }
                            });
                        }
                    } finally {
                    }
                }
                if (!z) {
                    this.f18823b.remove(unreadCountChangeListener);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28851a(final OnSessionListChangedListener onSessionListChangedListener, boolean z) {
        if (onSessionListChangedListener != null) {
            synchronized (this.f18824c) {
                if (z) {
                    try {
                        if (!this.f18824c.contains(onSessionListChangedListener)) {
                            this.f18824c.add(onSessionListChangedListener);
                            C6218e.m24652b(new Runnable() {
                                public final void run() {
                                    onSessionListChangedListener.onSessionUpdate(C6015c.this.mo28859e());
                                }
                            });
                        }
                    } finally {
                    }
                }
                if (!z) {
                    this.f18824c.remove(onSessionListChangedListener);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28852a(C6129j jVar) {
        this.f18826e = true;
        Map a = jVar.mo29122a();
        if (a != null && !a.isEmpty()) {
            synchronized (this.f18822a) {
                ArrayList arrayList = new ArrayList(a.size());
                for (String str : a.keySet()) {
                    int intValue = ((Integer) a.get(str)).intValue();
                    if (m23990a(intValue)) {
                        C5925h hVar = null;
                        for (RecentContact recentContact : this.f18822a) {
                            if (recentContact.getContactId().equals(str)) {
                                hVar = (C5925h) recentContact;
                            }
                        }
                        if (hVar != null) {
                            hVar.mo28340a(SessionStatusEnum.valueOf(intValue));
                            arrayList.add(hVar);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    m23995b((List<RecentContact>) arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28853a(String str, SessionStatusEnum sessionStatusEnum) {
        C5925h hVar;
        synchronized (this.f18822a) {
            Iterator it = this.f18822a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                }
                RecentContact recentContact = (RecentContact) it.next();
                if (recentContact.getContactId().equals(str)) {
                    hVar = (C5925h) recentContact;
                    break;
                }
            }
        }
        if (!(hVar == null || hVar.getSessionStatus() == sessionStatusEnum)) {
            hVar.mo28340a(sessionStatusEnum);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(hVar);
            m23995b((List<RecentContact>) arrayList);
        }
    }

    /* renamed from: a */
    public final void mo28854a(String str, boolean z) {
        RecentContact recentContact;
        synchronized (this.f18822a) {
            Iterator it = this.f18822a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    recentContact = null;
                    break;
                }
                recentContact = (RecentContact) it.next();
                if (recentContact.getContactId().equals(str)) {
                    break;
                }
            }
        }
        if (recentContact != null) {
            ((MsgService) NIMClient.getService(MsgService.class)).deleteRecentContact(recentContact);
            m23986a(recentContact);
            m23991b(recentContact);
            if (recentContact.getUnreadCount() > 0) {
                m23998g();
            }
            if (z) {
                ((MsgService) NIMClient.getService(MsgService.class)).clearChattingHistory(str, SessionTypeEnum.Ysf);
            }
        }
    }

    /* renamed from: b */
    public final void mo28855b() {
        String c = C6014b.m23942c();
        boolean z = !TextUtils.isEmpty(c) && !TextUtils.equals(c, ERROR.CMD_FORMAT_ERROR);
        if (z) {
            if (!this.f18826e || C6029d.m24047g().mo29298d()) {
                this.f18825d.postDelayed(new Runnable() {
                    public final void run() {
                        C6185c.m24532a(new C6154j(), C6185c.m24533a(), false);
                    }
                }, 1000);
            }
        }
    }

    /* renamed from: b */
    public final boolean mo28856b(String str) {
        synchronized (this.f18822a) {
            for (RecentContact contactId : this.f18822a) {
                if (contactId.getContactId().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: c */
    public final void mo28857c() {
        m23997f();
    }

    /* renamed from: d */
    public final int mo28858d() {
        int i;
        synchronized (this.f18822a) {
            i = 0;
            for (RecentContact recentContact : this.f18822a) {
                if (recentContact != null) {
                    i += recentContact.getUnreadCount();
                }
            }
        }
        return i;
    }

    /* renamed from: e */
    public final List<Session> mo28859e() {
        List<Session> c;
        synchronized (this.f18822a) {
            c = m23996c(this.f18822a);
        }
        return c;
    }
}
