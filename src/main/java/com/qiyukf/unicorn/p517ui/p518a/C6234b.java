package com.qiyukf.unicorn.p517ui.p518a;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;

/* renamed from: com.qiyukf.unicorn.ui.a.b */
public final class C6234b {
    /* renamed from: a */
    private int f19424a;
    /* renamed from: b */
    private String f19425b;
    /* renamed from: c */
    private int f19426c;
    /* renamed from: d */
    private int f19427d;
    /* renamed from: e */
    private String f19428e;
    /* renamed from: f */
    private boolean f19429f;

    /* renamed from: com.qiyukf.unicorn.ui.a.b$1 */
    static /* synthetic */ class C62351 {
        /* renamed from: a */
        static final /* synthetic */ int[] f19430a = new int[C6236a.m24689a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        static {
            /*
            int[] r0 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.m24689a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f19430a = r0
            r0 = 1
            int[] r1 = f19430a     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19432b     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = r2 - r0
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            int[] r1 = f19430a     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19433c     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = r2 - r0
            r3 = 2
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            int[] r1 = f19430a     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19434d     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = r2 - r0
            r3 = 3
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            int[] r1 = f19430a     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19435e     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = r2 - r0
            r0 = 4
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p517ui.p518a.C6234b.C62351.m50507clinit():void");
        }
    }

    /* renamed from: com.qiyukf.unicorn.ui.a.b$a */
    public enum C6236a {
        ;
        
        /* renamed from: a */
        public static final int f19431a = 1;
        /* renamed from: b */
        public static final int f19432b = 2;
        /* renamed from: c */
        public static final int f19433c = 3;
        /* renamed from: d */
        public static final int f19434d = 4;
        /* renamed from: e */
        public static final int f19435e = 5;

        static {
            f19436f = new int[]{f19431a, f19432b, f19433c, f19434d, f19435e};
        }

        /* renamed from: a */
        public static int[] m24689a() {
            return (int[]) f19436f.clone();
        }
    }

    public C6234b(int i) {
        this(i, null, null, true);
    }

    public C6234b(int i, String str, String str2, boolean z) {
        this.f19424a = i;
        this.f19425b = str;
        this.f19428e = str2;
        this.f19429f = z;
    }

    public C6234b(int i, boolean z) {
        this(i, null, null, z);
    }

    /* renamed from: a */
    public final int mo29423a() {
        return this.f19424a;
    }

    /* renamed from: a */
    public final void mo29424a(Context context) {
        int i;
        int i2 = C62351.f19430a[this.f19424a - 1];
        if (i2 == 1) {
            this.f19426c = C5961R.C5962drawable.ysf_default_shop_logo_dark;
            this.f19427d = C5961R.C5962drawable.ysf_default_shop_logo_light;
            if (TextUtils.isEmpty(this.f19425b)) {
                i = C5961R.string.ysf_menu_shop_name;
            }
            return;
        } else if (i2 == 2) {
            this.f19426c = C5961R.C5962drawable.ysf_human_service_dark;
            this.f19427d = C5961R.C5962drawable.ysf_human_service_light;
            i = C6029d.m24047g().mo29308i() ? C5961R.string.ysf_menu_request_vip_staff : C5961R.string.ysf_menu_request_staff;
        } else if (i2 != 3) {
            if (i2 == 4) {
                this.f19426c = C5961R.C5962drawable.ysf_ic_menu_close_dark_selector;
                this.f19427d = C5961R.C5962drawable.ysf_ic_menu_close_light_selector;
                this.f19425b = context.getString(C5961R.string.ysf_menu_close_session);
            }
            return;
        } else {
            this.f19426c = C5961R.C5962drawable.ysf_evaluation_star_level_list_dark;
            this.f19427d = C5961R.C5962drawable.ysf_evaluation_star_level_list_light;
            i = C5961R.string.ysf_evaluation;
        }
        this.f19425b = context.getString(i);
    }

    /* renamed from: b */
    public final String mo29425b() {
        return this.f19425b;
    }

    /* renamed from: c */
    public final String mo29426c() {
        return this.f19428e;
    }

    /* renamed from: d */
    public final int mo29427d() {
        return this.f19426c;
    }

    /* renamed from: e */
    public final int mo29428e() {
        return this.f19427d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof C6234b)) {
            C6234b bVar = (C6234b) obj;
            if (this.f19424a == bVar.f19424a && this.f19429f == bVar.f19429f) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final boolean mo29430f() {
        return this.f19429f;
    }
}
