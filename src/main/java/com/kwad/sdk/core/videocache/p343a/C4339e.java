package com.kwad.sdk.core.videocache.p343a;

import com.kwad.sdk.core.p319c.C4065b;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.kwad.sdk.core.videocache.a.e */
public abstract class C4339e implements C4333a {
    /* renamed from: a */
    private final ExecutorService f14247a = Executors.newSingleThreadExecutor();

    /* renamed from: com.kwad.sdk.core.videocache.a.e$a */
    private class C4340a implements Callable<Void> {
        /* renamed from: b */
        private final File f14249b;

        public C4340a(File file) {
            this.f14249b = file;
        }

        /* renamed from: a */
        public Void call() {
            C4339e.this.m17737b(this.f14249b);
            return null;
        }
    }

    /* renamed from: a */
    private void m17735a(List<File> list) {
        long b = m17736b(list);
        int size = list.size();
        for (File file : list) {
            if (!mo24492a(file, b, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error deleting file ");
                    sb.append(file);
                    sb.append(" for trimming cache");
                    C4065b.m16869d("LruDiskUsage", sb.toString());
                }
            }
        }
    }

    /* renamed from: b */
    private long m17736b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17737b(File file) {
        C4336d.m17729c(file);
        m17735a(C4336d.m17728b(file.getParentFile()));
    }

    /* renamed from: a */
    public void mo24488a(File file) {
        this.f14247a.submit(new C4340a(file));
    }

    /* renamed from: a */
    public abstract boolean mo24492a(File file, long j, int i);
}
