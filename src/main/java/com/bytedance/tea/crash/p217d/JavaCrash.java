package com.bytedance.tea.crash.p217d;

import android.content.Context;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.p216c.CrashBody;
import com.bytedance.tea.crash.p218e.p219a.CrashContextAssembly;
import com.bytedance.tea.crash.p221g.C2593d;
import com.bytedance.tea.crash.upload.CrashUploadManager;

/* renamed from: com.bytedance.tea.crash.d.c */
public class JavaCrash implements ICrashDisposer {
    /* renamed from: a */
    private Context f9287a;

    /* renamed from: a */
    public boolean mo17017a(Throwable th) {
        return true;
    }

    /* renamed from: a */
    public void mo17016a(long j, Thread thread, Throwable th) {
        CrashBody a = CrashBody.m12345a(j, this.f9287a, thread, th);
        C2593d.m12526a(this.f9287a, CrashType.JAVA.mo16988a(), Thread.currentThread().getName());
        CrashUploadManager.m12604a().mo17076a(CrashContextAssembly.m12442a().mo17041a(CrashType.JAVA, a).mo16997a());
    }

    public JavaCrash(Context context) {
        this.f9287a = context;
    }
}
