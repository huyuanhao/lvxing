package com.qiyukf.unicorn.p514h;

import android.util.Base64;
import android.util.SparseArray;
import androidx.collection.LruCache;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.p503f.p504a.C6118d;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.C6164f;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6136q;

/* renamed from: com.qiyukf.unicorn.h.e */
public final class C6197e {
    /* renamed from: a */
    private LruCache<String, SparseArray<C6136q>> f19366a;

    /* renamed from: com.qiyukf.unicorn.h.e$a */
    private static class C6198a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C6197e f19367a = new C6197e(0);
    }

    private C6197e() {
        this.f19366a = new LruCache<>(5);
    }

    /* synthetic */ C6197e(byte b) {
        this();
    }

    /* renamed from: a */
    public final void mo29324a(long j, String str, C6136q qVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(qVar.mo29150c());
        String sb2 = sb.toString();
        SparseArray sparseArray = (SparseArray) this.f19366a.get(sb2);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f19366a.put(sb2, sparseArray);
        }
        sparseArray.put(qVar.mo29152e(), qVar);
        if (sparseArray.size() == qVar.mo29151d()) {
            this.f19366a.remove(sb2);
            StringBuilder sb3 = new StringBuilder();
            for (int i = 0; i < sparseArray.size(); i++) {
                sb3.append(((C6136q) sparseArray.get(i)).mo29153f());
            }
            C6118d a = C6164f.m24457a().parse(new String(Base64.decode(sb3.toString(), 0)));
            if (a != null) {
                if (qVar.mo29148a() == 1) {
                    C5914c.m23708a(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, qVar.mo29149b(), a, j));
                    return;
                }
                C5808b.m23319a(MessageBuilder.createCustomReceivedNotification(str, (C6144e) a, j));
            }
        }
    }
}
