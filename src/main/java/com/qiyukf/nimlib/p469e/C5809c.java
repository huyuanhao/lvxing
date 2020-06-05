package com.qiyukf.nimlib.p469e;

import android.os.Handler;
import com.qiyukf.nimlib.sdk.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.qiyukf.nimlib.e.c */
public final class C5809c {
    /* renamed from: a */
    private final Map<String, List<Observer>> f18470a = new ConcurrentHashMap();
    /* renamed from: b */
    private final C5810d f18471b;

    C5809c(Handler handler) {
        this.f18471b = new C5810d(handler);
    }

    /* renamed from: a */
    public final boolean mo28104a(C5817i iVar) {
        if (iVar.mo28115a().startsWith("observe")) {
            Object[] objArr = iVar.f18480a.f18487b;
            if (objArr != null && objArr.length == 2 && (objArr[0] instanceof Observer) && (objArr[1] instanceof Boolean)) {
                Observer observer = (Observer) objArr[0];
                if (((Boolean) objArr[1]).booleanValue()) {
                    String str = iVar.f18480a.f18486a;
                    List list = (List) this.f18470a.get(str);
                    if (list == null) {
                        list = new ArrayList();
                        this.f18470a.put(str, list);
                    }
                    synchronized (list) {
                        list.add(observer);
                    }
                    this.f18471b.mo28106a(iVar.f18480a.f18486a, observer);
                } else {
                    List list2 = (List) this.f18470a.get(iVar.f18480a.f18486a);
                    if (list2 != null) {
                        synchronized (list2) {
                            list2.remove(observer);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final boolean mo28105b(C5817i iVar) {
        ArrayList<Observer> arrayList;
        List list = (List) this.f18470a.get(iVar.f18480a.f18486a);
        if (list == null) {
            return false;
        }
        synchronized (list) {
            arrayList = new ArrayList<>(list);
        }
        for (Observer onEvent : arrayList) {
            onEvent.onEvent(iVar.f18480a.f18487b[0]);
        }
        return true;
    }
}
