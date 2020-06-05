package com.yanzhenjie.permission.runtime;

import com.yanzhenjie.permission.C7837e;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.BridgeRequest.C7828a;
import com.yanzhenjie.permission.bridge.C7833e;
import com.yanzhenjie.permission.p633a.DoubleChecker;
import com.yanzhenjie.permission.p633a.PermissionChecker;
import com.yanzhenjie.permission.p633a.StandardChecker;
import com.yanzhenjie.permission.source.C7847b;
import com.yanzhenjie.permission.task.TaskExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.d */
class MRequest extends BaseRequest implements C7828a, C7837e {
    /* renamed from: a */
    private static final PermissionChecker f26676a = new StandardChecker();
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final PermissionChecker f26677b = new DoubleChecker();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C7847b f26678c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<String> f26679d;
    /* renamed from: e */
    private List<String> f26680e;

    MRequest(C7847b bVar) {
        super(bVar);
        this.f26678c = bVar;
    }

    /* renamed from: a */
    public PermissionRequest mo38063a(String... strArr) {
        this.f26679d = new ArrayList();
        this.f26679d.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: l_ */
    public void mo38064l_() {
        this.f26679d = m34072c(this.f26679d);
        this.f26680e = m34070a(f26676a, this.f26678c, this.f26679d);
        if (this.f26680e.size() > 0) {
            List a = m34071a(this.f26678c, this.f26680e);
            if (a.size() > 0) {
                mo38056a(a, (C7837e) this);
            } else {
                mo38051a();
            }
        } else {
            mo38036c();
        }
    }

    /* renamed from: a */
    public void mo38051a() {
        BridgeRequest aVar = new BridgeRequest(this.f26678c);
        aVar.mo38030a(2);
        aVar.mo38032a(this.f26680e);
        aVar.mo38031a((C7828a) this);
        C7833e.m34048a().mo38047a(aVar);
    }

    /* renamed from: b */
    public void mo38052b() {
        mo38036c();
    }

    /* renamed from: c */
    public void mo38036c() {
        new TaskExecutor<List<String>>(this.f26678c.mo38075a()) {
            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public List<String> doInBackground(Void... voidArr) {
                return BaseRequest.m34070a(MRequest.f26677b, MRequest.this.f26678c, MRequest.this.f26679d);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo38066a(List<String> list) {
                if (list.isEmpty()) {
                    MRequest dVar = MRequest.this;
                    dVar.mo38055a(dVar.f26679d);
                    return;
                }
                MRequest.this.mo38058b(list);
            }
        }.mo38079a();
    }
}
