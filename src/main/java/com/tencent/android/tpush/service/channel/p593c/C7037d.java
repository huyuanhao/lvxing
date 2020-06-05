package com.tencent.android.tpush.service.channel.p593c;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.android.tpush.stat.p596a.C7069f;
import com.tencent.mid.core.Constants;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.c.d */
public class C7037d {
    /* renamed from: c */
    private static volatile C7037d f23392c;
    /* renamed from: a */
    private int f23393a = 10;
    /* renamed from: b */
    private int f23394b = 0;
    /* renamed from: d */
    private Context f23395d = null;
    /* renamed from: e */
    private boolean f23396e = false;

    /* renamed from: a */
    public boolean mo33482a(String str, String str2) {
        if (this.f23396e) {
            try {
                return System.putString(this.f23395d.getContentResolver(), str, str2);
            } catch (Throwable th) {
                int i = this.f23394b;
                this.f23394b = i + 1;
                if (i < this.f23393a) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public String mo33478a(String str) {
        try {
            return System.getString(this.f23395d.getContentResolver(), str);
        } catch (Throwable th) {
            int i = this.f23394b;
            this.f23394b = i + 1;
            if (i < this.f23393a) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo33480a(String str, int i) {
        if (this.f23396e) {
            try {
                return System.putInt(this.f23395d.getContentResolver(), str, i);
            } catch (Throwable th) {
                int i2 = this.f23394b;
                this.f23394b = i2 + 1;
                if (i2 < this.f23393a) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33481a(String str, long j) {
        if (this.f23396e) {
            try {
                return System.putLong(this.f23395d.getContentResolver(), str, j);
            } catch (Throwable th) {
                int i = this.f23394b;
                this.f23394b = i + 1;
                if (i < this.f23393a) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33479a(String str, float f) {
        if (this.f23396e) {
            try {
                return System.putFloat(this.f23395d.getContentResolver(), str, f);
            } catch (Throwable th) {
                int i = this.f23394b;
                this.f23394b = i + 1;
                if (i < this.f23393a) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    private C7037d(Context context) {
        this.f23395d = context.getApplicationContext();
        try {
            this.f23396e = C7069f.m30292a(this.f23395d, Constants.PERMISSION_WRITE_SETTINGS);
            if (this.f23396e && VERSION.SDK_INT >= 23) {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.f23396e = ((Boolean) declaredMethod.invoke(null, new Object[]{this.f23395d})).booleanValue();
            }
        } catch (Throwable th) {
            int i = this.f23394b;
            this.f23394b = i + 1;
            if (i < this.f23393a) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static C7037d m30095a(Context context) {
        if (f23392c == null) {
            synchronized (C7037d.class) {
                if (f23392c == null) {
                    f23392c = new C7037d(context);
                }
            }
        }
        return f23392c;
    }
}
