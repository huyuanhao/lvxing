package com.pgl.sys.ces;

import android.content.Context;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.pgl.p359a.p361b.C4788f;
import com.pgl.sys.ces.p367c.C4811b;

/* renamed from: com.pgl.sys.ces.d */
public class C4812d {
    /* renamed from: a */
    public static int f15477a = 0;
    /* renamed from: b */
    public static long f15478b = 3600;
    /* renamed from: c */
    public static long f15479c;

    /* renamed from: a */
    public static synchronized void m19682a(Context context) {
        synchronized (C4812d.class) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - f15479c >= f15478b) {
                int i = 0;
                C4804b.f15453h = false;
                f15477a = 0;
                f15479c = currentTimeMillis;
                while (i < 3) {
                    if (!C4804b.f15453h && f15477a < 3) {
                        m19683b(context);
                        f15477a++;
                    }
                    i++;
                    C4788f.m19625a((long) (i * BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT));
                    if (C4804b.f15453h) {
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static void m19683b(Context context) {
        new C4811b(context, C4804b.m19666d()).mo25725a(2, 2, null);
    }
}
