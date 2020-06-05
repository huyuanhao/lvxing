package com.bytedance.sdk.openadsdk.p185f.p187b;

import com.bytedance.sdk.openadsdk.p185f.p186a.ILogStats;

/* renamed from: com.bytedance.sdk.openadsdk.f.b.e */
class LogUploaderImplEmpty implements ILogUploader {
    /* renamed from: a */
    private static volatile LogUploaderImplEmpty f8665a;

    /* renamed from: a */
    public void mo16615a() {
    }

    /* renamed from: a */
    public void mo16616a(ILogStats bVar) {
    }

    /* renamed from: a */
    public void mo16617a(ILogStats bVar, boolean z) {
    }

    /* renamed from: b */
    public void mo16618b() {
    }

    /* renamed from: c */
    public static LogUploaderImplEmpty m11359c() {
        if (f8665a == null) {
            synchronized (LogUploaderImplEmpty.class) {
                if (f8665a == null) {
                    f8665a = new LogUploaderImplEmpty();
                }
            }
        }
        return f8665a;
    }

    private LogUploaderImplEmpty() {
    }
}
