package com.yanzhenjie.permission.runtime;

import com.yanzhenjie.permission.p633a.PermissionChecker;
import com.yanzhenjie.permission.p633a.StrictChecker;
import com.yanzhenjie.permission.source.C7847b;
import com.yanzhenjie.permission.task.TaskExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.b */
class LRequest extends BaseRequest {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final PermissionChecker f26669a = new StrictChecker();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C7847b f26670b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<String> f26671c;

    LRequest(C7847b bVar) {
        super(bVar);
        this.f26670b = bVar;
    }

    /* renamed from: a */
    public PermissionRequest mo38063a(String... strArr) {
        this.f26671c = new ArrayList();
        this.f26671c.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: l_ */
    public void mo38064l_() {
        this.f26671c = m34072c(this.f26671c);
        new TaskExecutor<List<String>>(this.f26670b.mo38075a()) {
            /* access modifiers changed from: protected|varargs */
            /* renamed from: a */
            public List<String> doInBackground(Void... voidArr) {
                return BaseRequest.m34070a(LRequest.f26669a, LRequest.this.f26670b, LRequest.this.f26671c);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo38066a(List<String> list) {
                if (list.isEmpty()) {
                    LRequest bVar = LRequest.this;
                    bVar.mo38055a(bVar.f26671c);
                    return;
                }
                LRequest.this.mo38058b(list);
            }
        }.mo38079a();
    }
}
