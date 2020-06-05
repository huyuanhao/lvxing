package com.bumptech.glide.load.engine.p137a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.bumptech.glide.util.C1772j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.a.n */
public class SizeConfigStrategy implements LruPoolStrategy {
    /* renamed from: a */
    private static final Config[] f4481a;
    /* renamed from: b */
    private static final Config[] f4482b = f4481a;
    /* renamed from: c */
    private static final Config[] f4483c = {Config.RGB_565};
    /* renamed from: d */
    private static final Config[] f4484d = {Config.ARGB_4444};
    /* renamed from: e */
    private static final Config[] f4485e = {Config.ALPHA_8};
    /* renamed from: f */
    private final C1647b f4486f = new C1647b();
    /* renamed from: g */
    private final GroupedLinkedMap<C1646a, Bitmap> f4487g = new GroupedLinkedMap<>();
    /* renamed from: h */
    private final Map<Config, NavigableMap<Integer, Integer>> f4488h = new HashMap();

    /* compiled from: SizeConfigStrategy */
    /* renamed from: com.bumptech.glide.load.engine.a.n$1 */
    static /* synthetic */ class C16451 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4489a = new int[Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f4489a = r0
            int[] r0 = f4489a     // Catch:{ NoSuchFieldError -> 0x0014 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f4489a     // Catch:{ NoSuchFieldError -> 0x001f }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f4489a     // Catch:{ NoSuchFieldError -> 0x002a }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f4489a     // Catch:{ NoSuchFieldError -> 0x0035 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.p137a.SizeConfigStrategy.C16451.m42426clinit():void");
        }
    }

    /* compiled from: SizeConfigStrategy */
    /* renamed from: com.bumptech.glide.load.engine.a.n$a */
    static final class C1646a implements Poolable {
        /* renamed from: a */
        int f4490a;
        /* renamed from: b */
        private final C1647b f4491b;
        /* renamed from: c */
        private Config f4492c;

        public C1646a(C1647b bVar) {
            this.f4491b = bVar;
        }

        /* renamed from: a */
        public void mo12752a(int i, Config config) {
            this.f4490a = i;
            this.f4492c = config;
        }

        /* renamed from: a */
        public void mo12714a() {
            this.f4491b.mo12722a(this);
        }

        public String toString() {
            return SizeConfigStrategy.m5490a(this.f4490a, this.f4492c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1646a)) {
                return false;
            }
            C1646a aVar = (C1646a) obj;
            if (this.f4490a != aVar.f4490a || !C1772j.m6156a((Object) this.f4492c, (Object) aVar.f4492c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f4490a * 31;
            Config config = this.f4492c;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    /* compiled from: SizeConfigStrategy */
    /* renamed from: com.bumptech.glide.load.engine.a.n$b */
    static class C1647b extends BaseKeyPool<C1646a> {
        C1647b() {
        }

        /* renamed from: a */
        public C1646a mo12757a(int i, Config config) {
            C1646a aVar = (C1646a) mo12723c();
            aVar.mo12752a(i, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1646a mo12721b() {
            return new C1646a(this);
        }
    }

    static {
        Config[] configArr = {Config.ARGB_8888, null};
        if (VERSION.SDK_INT >= 26) {
            configArr = (Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Config.RGBA_F16;
        }
        f4481a = configArr;
    }

    /* renamed from: a */
    public void mo12709a(Bitmap bitmap) {
        C1646a a = this.f4486f.mo12757a(C1772j.m6147a(bitmap), bitmap.getConfig());
        this.f4487g.mo12735a(a, bitmap);
        NavigableMap a2 = m5491a(bitmap.getConfig());
        Integer num = (Integer) a2.get(Integer.valueOf(a.f4490a));
        Integer valueOf = Integer.valueOf(a.f4490a);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        a2.put(valueOf, Integer.valueOf(i));
    }

    /* renamed from: a */
    public Bitmap mo12708a(int i, int i2, Config config) {
        C1646a b = m5493b(C1772j.m6145a(i, i2, config), config);
        Bitmap bitmap = (Bitmap) this.f4487g.mo12734a(b);
        if (bitmap != null) {
            m5492a(Integer.valueOf(b.f4490a), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    /* renamed from: b */
    private C1646a m5493b(int i, Config config) {
        C1646a a = this.f4486f.mo12757a(i, config);
        Config[] b = m5494b(config);
        int length = b.length;
        int i2 = 0;
        while (i2 < length) {
            Config config2 = b[i2];
            Integer num = (Integer) m5491a(config2).ceilingKey(Integer.valueOf(i));
            if (num == null || num.intValue() > i * 8) {
                i2++;
            } else {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a;
                        }
                    } else if (config2.equals(config)) {
                        return a;
                    }
                }
                this.f4486f.mo12722a(a);
                return this.f4486f.mo12757a(num.intValue(), config2);
            }
        }
        return a;
    }

    /* renamed from: a */
    public Bitmap mo12707a() {
        Bitmap bitmap = (Bitmap) this.f4487g.mo12733a();
        if (bitmap != null) {
            m5492a(Integer.valueOf(C1772j.m6147a(bitmap)), bitmap);
        }
        return bitmap;
    }

    /* renamed from: a */
    private void m5492a(Integer num, Bitmap bitmap) {
        NavigableMap a = m5491a(bitmap.getConfig());
        Integer num2 = (Integer) a.get(num);
        if (num2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(num);
            sb.append(", removed: ");
            sb.append(mo12711b(bitmap));
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* renamed from: a */
    private NavigableMap<Integer, Integer> m5491a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f4488h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f4488h.put(config, treeMap);
        return treeMap;
    }

    /* renamed from: b */
    public String mo12711b(Bitmap bitmap) {
        return m5490a(C1772j.m6147a(bitmap), bitmap.getConfig());
    }

    /* renamed from: b */
    public String mo12710b(int i, int i2, Config config) {
        return m5490a(C1772j.m6145a(i, i2, config), config);
    }

    /* renamed from: c */
    public int mo12712c(Bitmap bitmap) {
        return C1772j.m6147a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f4487g);
        sb.append(", sortedSizes=(");
        for (Entry entry : this.f4488h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f4488h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* renamed from: a */
    static String m5490a(int i, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("](");
        sb.append(config);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: b */
    private static Config[] m5494b(Config config) {
        if (VERSION.SDK_INT >= 26 && Config.RGBA_F16.equals(config)) {
            return f4482b;
        }
        int i = C16451.f4489a[config.ordinal()];
        if (i == 1) {
            return f4481a;
        }
        if (i == 2) {
            return f4483c;
        }
        if (i == 3) {
            return f4484d;
        }
        if (i == 4) {
            return f4485e;
        }
        return new Config[]{config};
    }
}
