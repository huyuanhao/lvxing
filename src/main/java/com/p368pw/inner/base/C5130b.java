package com.p368pw.inner.base;

import android.content.Context;
import com.p368pw.inner.C5229d;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.base.p384a.C5121c.C5122a;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.pw.inner.base.b */
public class C5130b {
    /* renamed from: a */
    private static volatile C5130b f16744a;
    /* renamed from: g */
    private static final Object f16745g = new Object();
    /* renamed from: b */
    private Context f16746b;
    /* renamed from: c */
    private Set<Long> f16747c;
    /* renamed from: d */
    private ConcurrentHashMap<Integer, SortedSet<Long>> f16748d = new ConcurrentHashMap<>();
    /* renamed from: e */
    private ConcurrentHashMap<String, SortedSet<Long>> f16749e;
    /* renamed from: f */
    private Set<String> f16750f;

    private C5130b(Context context) {
        this.f16746b = context.getApplicationContext();
        this.f16747c = Collections.synchronizedSet(new TreeSet(m21236a(C5237f.m21594g(context))));
        this.f16748d.put(Integer.valueOf(1), new TreeSet(m21236a(C5237f.m21569a(context, 1))));
        this.f16748d.put(Integer.valueOf(2), new TreeSet(m21236a(C5237f.m21569a(context, 2))));
        this.f16748d.put(Integer.valueOf(3), new TreeSet(m21236a(C5237f.m21569a(context, 3))));
        this.f16748d.put(Integer.valueOf(4), new TreeSet(m21236a(C5237f.m21569a(context, 4))));
        this.f16748d.put(Integer.valueOf(5), new TreeSet(m21236a(C5237f.m21569a(context, 5))));
        this.f16748d.put(Integer.valueOf(106), new TreeSet(m21236a(C5237f.m21569a(context, 106))));
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        m21240b(this.f16747c, currentTimeMillis);
        C5237f.m21595g(context, m21235a((Collection<T>) this.f16747c));
        for (Entry entry : this.f16748d.entrySet()) {
            m21240b((Collection) entry.getValue(), currentTimeMillis);
            C5237f.m21571a(context, ((Integer) entry.getKey()).intValue(), m21235a((Collection) entry.getValue()));
        }
        m21237a();
    }

    /* renamed from: a */
    private static int m21232a(Collection<Long> collection, long j) {
        int i = 0;
        if (C5188f.m21377a((Collection) collection)) {
            return 0;
        }
        for (Long longValue : collection) {
            if (longValue.longValue() > j) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static C5122a m21233a(List<C5122a> list, int i) {
        for (C5122a aVar : list) {
            if (aVar != null && aVar.mo26672c() == i) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C5130b m21234a(Context context) {
        if (f16744a == null) {
            synchronized (C5130b.class) {
                if (f16744a == null) {
                    f16744a = new C5130b(context);
                }
            }
        }
        return f16744a;
    }

    /* renamed from: a */
    private static <T> String m21235a(Collection<T> collection) {
        if (C5188f.m21377a((Collection) collection)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (T valueOf : collection) {
            sb.append(String.valueOf(valueOf));
            sb.append(StorageInterface.KEY_SPLITER);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: a */
    private static List<Long> m21236a(String str) {
        ArrayList arrayList = new ArrayList();
        if (C5207q.m21476a((CharSequence) str)) {
            return arrayList;
        }
        String[] split = str.split(StorageInterface.KEY_SPLITER);
        if (!(split == null || str.length() == 0)) {
            for (String valueOf : split) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m21237a() {
        Set<String> set = this.f16750f;
        if (set == null || set.size() == 0) {
            synchronized (f16745g) {
                if (this.f16750f == null || this.f16750f.size() == 0) {
                    Set<String> synchronizedSet = Collections.synchronizedSet(new TreeSet(C5207q.m21475a(C5237f.m21596h(this.f16746b))));
                    if (!C5188f.m21377a((Collection) synchronizedSet)) {
                        this.f16750f = synchronizedSet;
                        this.f16749e = new ConcurrentHashMap<>();
                        for (String str : this.f16750f) {
                            this.f16749e.put(str, new TreeSet(m21236a(C5237f.m21597h(this.f16746b, str))));
                        }
                        long currentTimeMillis = System.currentTimeMillis() - 259200000;
                        for (Entry entry : this.f16749e.entrySet()) {
                            m21240b((Collection) entry.getValue(), currentTimeMillis);
                            C5237f.m21582b(this.f16746b, (String) entry.getKey(), m21235a((Collection) entry.getValue()));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m21238a(int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f16747c.add(Long.valueOf(currentTimeMillis));
        if (this.f16748d.containsKey(Integer.valueOf(i))) {
            ((SortedSet) this.f16748d.get(Integer.valueOf(i))).add(Long.valueOf(currentTimeMillis));
        } else {
            TreeSet treeSet = new TreeSet();
            treeSet.add(Long.valueOf(currentTimeMillis));
            this.f16748d.put(Integer.valueOf(i), treeSet);
        }
        if (this.f16749e.containsKey(str)) {
            ((SortedSet) this.f16749e.get(str)).add(Long.valueOf(currentTimeMillis));
        } else {
            TreeSet treeSet2 = new TreeSet();
            treeSet2.add(Long.valueOf(currentTimeMillis));
            this.f16749e.put(str, treeSet2);
        }
        C5237f.m21595g(this.f16746b, m21235a((Collection<T>) this.f16747c));
        C5237f.m21571a(this.f16746b, i, m21235a((Collection) this.f16748d.get(Integer.valueOf(i))));
        C5237f.m21582b(this.f16746b, str, m21235a((Collection) this.f16749e.get(str)));
    }

    /* renamed from: a */
    private boolean m21239a(int i, List<C5122a> list, Collection<Long> collection) {
        C5122a a = m21233a(list, i);
        return a == null || a.mo26671b() == 0 || a.mo26670a() == 0 || m21232a(collection, System.currentTimeMillis() - ((long) (a.mo26670a() * 1000))) < a.mo26671b();
    }

    /* renamed from: b */
    private static void m21240b(Collection<Long> collection, long j) {
        if (C5188f.m21379b(collection)) {
            Iterator it = collection.iterator();
            while (it.hasNext() && ((Long) it.next()).longValue() < j) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public boolean mo26732a(List<C5122a> list, int i, String str) {
        String str2;
        String str3;
        Set<String> set = this.f16750f;
        if (set == null || set.size() == 0) {
            m21237a();
        }
        if (C5229d.m21541a().mo26919b() == 1) {
            str3 = "debug mode.";
        } else if (C5188f.m21377a((Collection) list)) {
            str3 = "Request not limit.";
        } else {
            if (!m21239a(1, list, (Collection<Long>) this.f16747c)) {
                str2 = "Request too frequent(Product level).";
            } else if (!m21239a(2, list, (Collection) this.f16748d.get(Integer.valueOf(i)))) {
                str2 = "Request too frequent(AdsType level).";
            } else if (!m21239a(3, list, (Collection) this.f16749e.get(str))) {
                str2 = "Request too frequent(Placement level).";
            } else {
                m21238a(i, str);
                return true;
            }
            C5205o.m21462a(str2);
            return false;
        }
        C5205o.m21462a(str3);
        return true;
    }
}
