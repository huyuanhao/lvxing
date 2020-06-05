package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;

public final class MemorySizeCalculator {
    /* renamed from: a */
    private final int f4525a;
    /* renamed from: b */
    private final int f4526b;
    /* renamed from: c */
    private final Context f4527c;
    /* renamed from: d */
    private final int f4528d;

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$Builder */
    public static final class Builder {
        /* renamed from: a */
        static final int f4529a = (VERSION.SDK_INT < 26 ? 4 : 1);
        /* renamed from: b */
        final Context f4530b;
        /* renamed from: c */
        ActivityManager f4531c;
        /* renamed from: d */
        C1659b f4532d;
        /* renamed from: e */
        float f4533e = 2.0f;
        /* renamed from: f */
        float f4534f = ((float) f4529a);
        /* renamed from: g */
        float f4535g = 0.4f;
        /* renamed from: h */
        float f4536h = 0.33f;
        /* renamed from: i */
        int f4537i = 4194304;

        public Builder(Context context) {
            this.f4530b = context;
            this.f4531c = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            this.f4532d = new C1658a(context.getResources().getDisplayMetrics());
            if (VERSION.SDK_INT >= 26 && MemorySizeCalculator.m5531a(this.f4531c)) {
                this.f4534f = 0.0f;
            }
        }

        /* renamed from: a */
        public MemorySizeCalculator mo12782a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$a */
    private static final class C1658a implements C1659b {
        /* renamed from: a */
        private final DisplayMetrics f4538a;

        C1658a(DisplayMetrics displayMetrics) {
            this.f4538a = displayMetrics;
        }

        /* renamed from: a */
        public int mo12783a() {
            return this.f4538a.widthPixels;
        }

        /* renamed from: b */
        public int mo12784b() {
            return this.f4538a.heightPixels;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$b */
    interface C1659b {
        /* renamed from: a */
        int mo12783a();

        /* renamed from: b */
        int mo12784b();
    }

    MemorySizeCalculator(Builder builder) {
        int i;
        this.f4527c = builder.f4530b;
        if (m5531a(builder.f4531c)) {
            i = builder.f4537i / 2;
        } else {
            i = builder.f4537i;
        }
        this.f4528d = i;
        int a = m5529a(builder.f4531c, builder.f4535g, builder.f4536h);
        float a2 = (float) (builder.f4532d.mo12783a() * builder.f4532d.mo12784b() * 4);
        int round = Math.round(builder.f4534f * a2);
        int round2 = Math.round(a2 * builder.f4533e);
        int i2 = a - this.f4528d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f4526b = round2;
            this.f4525a = round;
        } else {
            float f = ((float) i2) / (builder.f4534f + builder.f4533e);
            this.f4526b = Math.round(builder.f4533e * f);
            this.f4525a = Math.round(f * builder.f4534f);
        }
        String str = "MemorySizeCalculator";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m5530a(this.f4526b));
            sb.append(", pool size: ");
            sb.append(m5530a(this.f4525a));
            sb.append(", byte array size: ");
            sb.append(m5530a(this.f4528d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a);
            sb.append(", max size: ");
            sb.append(m5530a(a));
            sb.append(", memoryClass: ");
            sb.append(builder.f4531c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m5531a(builder.f4531c));
            Log.d(str, sb.toString());
        }
    }

    /* renamed from: a */
    public int mo12779a() {
        return this.f4526b;
    }

    /* renamed from: b */
    public int mo12780b() {
        return this.f4525a;
    }

    /* renamed from: c */
    public int mo12781c() {
        return this.f4528d;
    }

    /* renamed from: a */
    private static int m5529a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (m5531a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    /* renamed from: a */
    private String m5530a(int i) {
        return Formatter.formatFileSize(this.f4527c, (long) i);
    }

    /* renamed from: a */
    static boolean m5531a(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
