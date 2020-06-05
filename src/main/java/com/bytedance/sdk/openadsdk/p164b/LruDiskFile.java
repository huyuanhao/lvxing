package com.bytedance.sdk.openadsdk.p164b;

import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.p198i.TTFutureTask;
import com.bytedance.sdk.openadsdk.p198i.TTRunnable;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.bytedance.sdk.openadsdk.b.b */
public abstract class LruDiskFile implements DiskUsage {

    /* compiled from: LruDiskFile */
    /* renamed from: com.bytedance.sdk.openadsdk.b.b$a */
    private class C2082a implements Callable<Void> {
        /* renamed from: b */
        private final File f6739b;

        private C2082a(File file) {
            this.f6739b = file;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            LruDiskFile.this.m8338b(this.f6739b);
            return null;
        }
    }

    /* renamed from: a */
    public abstract void mo14988a(List<File> list);

    /* renamed from: a */
    public abstract boolean mo14989a(long j, int i);

    /* renamed from: a */
    public abstract boolean mo14990a(File file, long j, int i);

    /* renamed from: a */
    public void mo14986a(File file) throws IOException {
        final TTFutureTask bVar = new TTFutureTask(new C2082a(file), 1, 2);
        TTExecutor.m11692a().mo16806b(new TTRunnable(bVar.mo16814a()) {
            public void run() {
                bVar.run();
            }
        });
    }

    /* renamed from: a */
    public File mo14987a(String str, File file) throws IOException {
        return m8337b(str, file);
    }

    /* renamed from: b */
    private File m8337b(String str, File file) {
        List<File> a = FileUtils.m12174a(file);
        if (a != null && a.size() > 0) {
            for (File file2 : a) {
                if (file2 != null && str.equals(file2.getName())) {
                    C2564t.m12226e("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                    return file2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8338b(File file) throws IOException {
        try {
            FileUtils.m12175b(file);
        } catch (Throwable th) {
            C2564t.m12216a("LruDiskFile", "setLastModifiedNowError", th);
        }
        mo14988a(FileUtils.m12174a(file.getParentFile()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo14991b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }
}
