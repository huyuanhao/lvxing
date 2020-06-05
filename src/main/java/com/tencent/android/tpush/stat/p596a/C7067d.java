package com.tencent.android.tpush.stat.p596a;

import android.util.Log;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a.d */
public final class C7067d {
    /* renamed from: a */
    private String f23496a = OEM.DEFAULT;
    /* renamed from: b */
    private boolean f23497b = true;
    /* renamed from: c */
    private int f23498c = 2;

    /* renamed from: a */
    public boolean mo34168a() {
        return this.f23497b;
    }

    /* renamed from: a */
    public void mo34167a(boolean z) {
        this.f23497b = z;
    }

    public C7067d() {
    }

    public C7067d(String str) {
        this.f23496a = str;
    }

    /* renamed from: b */
    private String m30269b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(Thread.currentThread().getName());
                sb.append("(");
                sb.append(Thread.currentThread().getId());
                sb.append("): ");
                sb.append(stackTraceElement.getFileName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append("]");
                return sb.toString();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo34165a(Object obj) {
        String str;
        if (this.f23498c <= 4) {
            String b = m30269b();
            if (b == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.i(this.f23496a, str);
        }
    }

    /* renamed from: b */
    public void mo34169b(Object obj) {
        if (mo34168a()) {
            mo34165a(obj);
        }
    }

    /* renamed from: c */
    public void mo34171c(Object obj) {
        String str;
        if (this.f23498c <= 5) {
            String b = m30269b();
            if (b == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.w(this.f23496a, str);
        }
    }

    /* renamed from: d */
    public void mo34172d(Object obj) {
        if (mo34168a()) {
            mo34171c(obj);
        }
    }

    /* renamed from: e */
    public void mo34173e(Object obj) {
        String str;
        if (this.f23498c <= 6) {
            String b = m30269b();
            if (b == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.e(this.f23496a, str);
        }
    }

    /* renamed from: a */
    public void mo34166a(Throwable th) {
        if (this.f23498c <= 6) {
            Log.e(this.f23496a, "", th);
        }
    }

    /* renamed from: f */
    public void mo34174f(Object obj) {
        if (mo34168a()) {
            mo34173e(obj);
        }
    }

    /* renamed from: b */
    public void mo34170b(Throwable th) {
        if (mo34168a()) {
            mo34166a(th);
        }
    }

    /* renamed from: g */
    public void mo34175g(Object obj) {
        String str;
        if (this.f23498c <= 3) {
            String b = m30269b();
            if (b == null) {
                str = obj.toString();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(" - ");
                sb.append(obj);
                str = sb.toString();
            }
            Log.d(this.f23496a, str);
        }
    }

    /* renamed from: h */
    public void mo34176h(Object obj) {
        if (mo34168a()) {
            mo34175g(obj);
        }
    }
}
