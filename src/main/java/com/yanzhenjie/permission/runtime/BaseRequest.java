package com.yanzhenjie.permission.runtime;

import android.content.Context;
import android.os.Build.VERSION;
import com.yanzhenjie.permission.C7822a;
import com.yanzhenjie.permission.C7837e;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.p633a.PermissionChecker;
import com.yanzhenjie.permission.source.C7847b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.a */
abstract class BaseRequest implements PermissionRequest {
    /* renamed from: a */
    private C7847b f26664a;
    /* renamed from: b */
    private Rationale<List<String>> f26665b = new Rationale<List<String>>() {
        /* renamed from: a */
        public void mo19846a(Context context, List<String> list, C7837e eVar) {
            eVar.mo38051a();
        }
    };
    /* renamed from: c */
    private C7822a<List<String>> f26666c;
    /* renamed from: d */
    private C7822a<List<String>> f26667d;

    BaseRequest(C7847b bVar) {
        this.f26664a = bVar;
    }

    /* renamed from: a */
    public PermissionRequest mo38054a(Rationale<List<String>> dVar) {
        this.f26665b = dVar;
        return this;
    }

    /* renamed from: a */
    public PermissionRequest mo38053a(C7822a<List<String>> aVar) {
        this.f26666c = aVar;
        return this;
    }

    /* renamed from: b */
    public PermissionRequest mo38057b(C7822a<List<String>> aVar) {
        this.f26667d = aVar;
        return this;
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo38056a(List<String> list, C7837e eVar) {
        this.f26665b.mo19846a(this.f26664a.mo38075a(), list, eVar);
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo38055a(List<String> list) {
        C7822a<List<String>> aVar = this.f26666c;
        if (aVar != null) {
            aVar.mo20720a(list);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final void mo38058b(List<String> list) {
        C7822a<List<String>> aVar = this.f26667d;
        if (aVar != null) {
            aVar.mo20720a(list);
        }
    }

    /* renamed from: c */
    public static List<String> m34072c(List<String> list) {
        ArrayList arrayList = new ArrayList(new HashSet(list));
        if (VERSION.SDK_INT < 26) {
            arrayList.remove("android.permission.READ_PHONE_NUMBERS");
            arrayList.remove("android.permission.ANSWER_PHONE_CALLS");
        }
        if (VERSION.SDK_INT < 29) {
            arrayList.remove("android.permission.ACTIVITY_RECOGNITION");
            arrayList.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m34070a(PermissionChecker kVar, C7847b bVar, List<String> list) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : list) {
            if (!kVar.mo38009a(bVar.mo38075a(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m34071a(C7847b bVar, List<String> list) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : list) {
            if (bVar.mo38078a(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
