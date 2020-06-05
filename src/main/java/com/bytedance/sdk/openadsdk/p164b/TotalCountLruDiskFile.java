package com.bytedance.sdk.openadsdk.p164b;

import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.io.File;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.b.c */
public class TotalCountLruDiskFile extends LruDiskFile {
    /* renamed from: a */
    private int f6740a = 15;
    /* renamed from: b */
    private int f6741b = 3;

    public TotalCountLruDiskFile(int i, int i2) {
        if (i > 0) {
            this.f6740a = i;
            this.f6741b = i2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo14989a(long j, int i) {
        return i <= this.f6740a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo14990a(File file, long j, int i) {
        return i <= this.f6741b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14988a(List<File> list) {
        long b = mo14991b(list);
        int size = list.size();
        if (!mo14989a(b, size)) {
            for (File file : list) {
                long length = file.length();
                String str = "TotalCountLruDiskFile";
                if (file.delete()) {
                    size--;
                    b -= length;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cache file ");
                    sb.append(file);
                    sb.append(" is deleted because it exceeds cache limit");
                    C2564t.m12222c(str, sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error deleting file ");
                    sb2.append(file);
                    sb2.append(" for trimming cache");
                    C2564t.m12222c(str, sb2.toString());
                }
                if (mo14990a(file, b, size)) {
                    return;
                }
            }
        }
    }
}
