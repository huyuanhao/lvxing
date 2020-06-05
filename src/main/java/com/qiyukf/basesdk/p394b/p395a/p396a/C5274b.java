package com.qiyukf.basesdk.p394b.p395a.p396a;

import android.os.Handler;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5312a;
import com.qiyukf.basesdk.p412c.C5361a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.b.a.a.b */
final class C5274b implements C5273a {
    /* renamed from: a */
    private static final Handler f17075a = C5361a.m22014b();
    /* renamed from: b */
    private String f17076b;
    /* renamed from: c */
    private String f17077c;
    /* renamed from: d */
    private long f17078d = 0;

    C5274b(String str, String str2) {
        this.f17076b = str;
        this.f17077c = str2;
    }

    /* renamed from: a */
    private void m21678a(final Runnable runnable) {
        f17075a.post(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder("download listener exception: ");
                    sb.append(th.getMessage());
                    C5264a.m21617a("RES", sb.toString());
                }
            }
        });
    }

    /* renamed from: a */
    private synchronized void m21679a(List<C5285d> list) {
        HashSet<String> hashSet = new HashSet<>();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashSet.add(((C5285d) list.get(i2)).mo27137b());
        }
        for (String str : hashSet) {
            i++;
            if (i == hashSet.size()) {
                C5312a.m21839b(this.f17077c, str);
            } else {
                C5312a.m21836a(this.f17077c, str);
            }
        }
    }

    /* renamed from: c */
    private static List<C5285d> m21680c(String str) {
        List a = C5287f.m21710a().mo27148a(str);
        if (a == null) {
            return null;
        }
        return new ArrayList(a);
    }

    /* renamed from: a */
    public final void mo27120a(String str) {
        final List c = m21680c(str);
        if (c != null) {
            m21678a((Runnable) new Runnable() {
                public final void run() {
                    Iterator it = c.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo27121a(String str, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f17078d >= 200) {
            final List c = m21680c(str);
            if (c != null) {
                this.f17078d = currentTimeMillis;
                final long j2 = j;
                final String str2 = str;
                C52773 r0 = new Runnable() {
                    public final void run() {
                        for (C5285d dVar : c) {
                            if (!dVar.mo27141f() && dVar.mo27142g() != null) {
                                dVar.mo27142g().mo27144a(j2);
                            }
                        }
                        C5289g b = C5287f.m21710a().mo27150b(str2);
                        if (b != null) {
                            b.f17128b = j2;
                        }
                    }
                };
                m21678a((Runnable) r0);
            }
        }
    }

    /* renamed from: a */
    public final void mo27122a(String str, final String str2) {
        final List c = m21680c(str);
        if (c != null) {
            m21678a((Runnable) new Runnable() {
                public final void run() {
                    for (C5285d dVar : c) {
                        if (!dVar.mo27141f() && dVar.mo27142g() != null) {
                            dVar.mo27142g().mo27145b();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public final void mo27123b(String str) {
        final List c = m21680c(str);
        if (c != null) {
            m21679a(c);
            m21678a((Runnable) new Runnable() {
                public final void run() {
                    for (C5285d dVar : c) {
                        if (!dVar.mo27141f() && dVar.mo27142g() != null) {
                            dVar.mo27142g().mo27143a();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public final void mo27124b(String str, final long j) {
        final List c = m21680c(str);
        if (c != null) {
            m21678a((Runnable) new Runnable() {
                public final void run() {
                    for (C5285d dVar : c) {
                        if (!dVar.mo27141f() && dVar.mo27142g() != null) {
                            dVar.mo27142g().mo27146b(j);
                        }
                    }
                }
            });
        }
    }
}
