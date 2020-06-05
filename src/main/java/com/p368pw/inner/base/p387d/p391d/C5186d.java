package com.p368pw.inner.base.p387d.p391d;

import com.p368pw.view.WebActivity.IWebActivityListener;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.pw.inner.base.d.d.d */
public class C5186d implements Serializable {
    /* renamed from: a */
    private static final Map<String, IWebActivityListener> f16888a = new ConcurrentHashMap();

    /* renamed from: a */
    public static IWebActivityListener m21366a(String str) {
        return (IWebActivityListener) f16888a.get(str);
    }

    /* renamed from: a */
    public static void m21367a(String str, IWebActivityListener iWebActivityListener) {
        f16888a.put(str, iWebActivityListener);
    }

    /* renamed from: b */
    public static void m21368b(String str) {
        if (!f16888a.isEmpty()) {
            f16888a.remove(str);
        }
    }
}
