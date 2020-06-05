package com.qiyukf.nim.uikit.session.module.p427a;

import android.content.Context;
import com.qiyukf.nim.uikit.common.p419a.C5437d;
import com.qiyukf.nim.uikit.common.p419a.C5438e;
import com.qiyukf.nim.uikit.session.helper.C5563d.C5564a;
import com.qiyukf.nim.uikit.session.viewholder.C5629c;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.customization.msg_list.UnicornMessageHandler;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.qiyukf.nim.uikit.session.module.a.c */
public final class C5588c extends C5437d<IMMessage> {
    /* renamed from: b */
    private C5590a f17991b;
    /* renamed from: c */
    private Map<String, Float> f17992c = new HashMap();
    /* renamed from: d */
    private Set<String> f17993d = new HashSet();
    /* renamed from: e */
    private IMMessage f17994e;

    /* renamed from: com.qiyukf.nim.uikit.session.module.a.c$1 */
    static /* synthetic */ class C55891 {
        /* renamed from: a */
        static final /* synthetic */ int[] f17995a = new int[MsgTypeEnum.values().length];

        static {
            try {
                f17995a[MsgTypeEnum.notification.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.session.module.a.c$a */
    public interface C5590a {
        /* renamed from: a */
        void mo27721a(C5564a aVar);

        /* renamed from: a */
        void mo27722a(IMMessage iMMessage);

        /* renamed from: a */
        boolean mo27723a();

        /* renamed from: b */
        void mo27724b();

        /* renamed from: b */
        boolean mo27725b(IMMessage iMMessage);

        /* renamed from: c */
        void mo27726c();

        /* renamed from: c */
        void mo27727c(IMMessage iMMessage);
    }

    public C5588c(Context context, List<IMMessage> list, C5438e eVar) {
        super(context, list, eVar);
    }

    /* renamed from: a */
    private void m22658a(IMMessage iMMessage, boolean z) {
        if (z) {
            this.f17993d.add(iMMessage.getUuid());
        } else {
            this.f17993d.remove(iMMessage.getUuid());
        }
    }

    /* renamed from: d */
    private static boolean m22659d(IMMessage iMMessage) {
        return C55891.f17995a[iMMessage.getMsgType().ordinal()] == 1;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27382a(int i) {
        super.mo27382a(i);
        IMMessage iMMessage = (IMMessage) getItem(i);
        UnicornMessageHandler b = C5629c.m22790b(iMMessage);
        if (b != null) {
            boolean z = iMMessage.getStatus() == MsgStatusEnum.read;
            boolean onMessage = b.onMessage(this.f17430a, iMMessage, z);
            if (!z && onMessage) {
                iMMessage.setStatus(MsgStatusEnum.read);
                C5922f.m23755b((C5912a) iMMessage);
            }
        }
    }

    /* renamed from: a */
    public final void mo27728a(C5590a aVar) {
        this.f17991b = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
            if (r1.isTheSame(r6) == false) goto L_0x008e;
     */
    /* renamed from: a */
    public final void mo27729a(com.qiyukf.nimlib.sdk.msg.model.IMMessage r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0003
        return
    L_0x0003:
        java.util.List r0 = r5.mo27381a()
        java.util.Iterator r0 = r0.iterator()
        r1 = 0
        r2 = 0
    L_0x000d:
        boolean r3 = r0.hasNext()
        if (r3 == 0) goto L_0x0022
        java.lang.Object r3 = r0.next()
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r3 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r3
        boolean r3 = r3.isTheSame(r6)
        if (r3 != 0) goto L_0x0022
        int r2 = r2 + 1
        goto L_0x000d
    L_0x0022:
        int r0 = r5.getCount()
        if (r2 >= r0) goto L_0x0091
        java.util.List r0 = r5.mo27381a()
        r0.remove(r2)
        boolean r0 = r5.mo27733c(r6)
        if (r0 == 0) goto L_0x008e
        r5.m22658a(r6, r1)
        int r0 = r5.getCount()
        r3 = 0
        if (r0 <= 0) goto L_0x008c
        int r0 = r5.getCount()
        r4 = 1
        if (r2 != r0) goto L_0x0047
        int r2 = r2 - r4
    L_0x0047:
        java.lang.Object r0 = r5.getItem(r2)
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0
        boolean r2 = m22659d(r0)
        if (r2 == 0) goto L_0x007a
        r5.m22658a(r0, r1)
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r0 = r5.f17994e
        if (r0 == 0) goto L_0x008e
        if (r0 == 0) goto L_0x008e
        boolean r6 = r0.isTheSame(r6)
        if (r6 == 0) goto L_0x008e
        r5.f17994e = r3
        int r6 = r5.getCount()
        int r6 = r6 - r4
    L_0x0069:
        if (r6 < 0) goto L_0x008e
        java.lang.Object r0 = r5.getItem(r6)
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0
        boolean r1 = r5.mo27733c(r0)
        if (r1 != 0) goto L_0x0089
        int r6 = r6 + -1
        goto L_0x0069
    L_0x007a:
        r5.m22658a(r0, r4)
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r1 = r5.f17994e
        if (r1 == 0) goto L_0x0089
        if (r1 == 0) goto L_0x008e
        boolean r6 = r1.isTheSame(r6)
        if (r6 == 0) goto L_0x008e
    L_0x0089:
        r5.f17994e = r0
        goto L_0x008e
    L_0x008c:
        r5.f17994e = r3
    L_0x008e:
        r5.notifyDataSetChanged()
    L_0x0091:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.p427a.C5588c.mo27729a(com.qiyukf.nimlib.sdk.msg.model.IMMessage):void");
    }

    /* renamed from: a */
    public final void mo27730a(IMMessage iMMessage, float f) {
        this.f17992c.put(iMMessage.getUuid(), Float.valueOf(f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
            if ((r0.getTime() - r10.getTime()) < 300000) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x000a A[SYNTHETIC] */
    /* renamed from: a */
    public final void mo27731a(java.util.List<com.qiyukf.nimlib.sdk.msg.model.IMMessage> r9, boolean r10, boolean r11) {
        /*
        r8 = this;
        if (r10 == 0) goto L_0x0004
        r10 = 0
        goto L_0x0006
    L_0x0004:
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r10 = r8.f17994e
    L_0x0006:
        java.util.Iterator r9 = r9.iterator()
    L_0x000a:
        boolean r0 = r9.hasNext()
        if (r0 == 0) goto L_0x003e
        java.lang.Object r0 = r9.next()
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0
        boolean r1 = m22659d(r0)
        r2 = 1
        r3 = 0
        if (r1 == 0) goto L_0x0022
    L_0x001e:
        r8.m22658a(r0, r3)
        goto L_0x0035
    L_0x0022:
        if (r10 == 0) goto L_0x0037
        long r4 = r10.getTime()
        long r6 = r0.getTime()
        long r6 = r6 - r4
        r4 = 300000(0x493e0, double:1.482197E-318)
        int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
        if (r1 >= 0) goto L_0x0037
        goto L_0x001e
    L_0x0035:
        r2 = 0
        goto L_0x003a
    L_0x0037:
        r8.m22658a(r0, r2)
    L_0x003a:
        if (r2 == 0) goto L_0x000a
        r10 = r0
        goto L_0x000a
    L_0x003e:
        if (r11 == 0) goto L_0x0042
        r8.f17994e = r10
    L_0x0042:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.p427a.C5588c.mo27731a(java.util.List, boolean, boolean):void");
    }

    /* renamed from: b */
    public final float mo27732b(IMMessage iMMessage) {
        Float f = (Float) this.f17992c.get(iMMessage.getUuid());
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    /* renamed from: c */
    public final boolean mo27733c(IMMessage iMMessage) {
        return this.f17993d.contains(iMMessage.getUuid());
    }

    /* renamed from: d */
    public final C5590a mo27734d() {
        return this.f17991b;
    }
}
