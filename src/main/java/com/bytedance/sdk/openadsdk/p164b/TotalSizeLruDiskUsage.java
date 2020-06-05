package com.bytedance.sdk.openadsdk.p164b;

import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.b.d */
public class TotalSizeLruDiskUsage extends LruDiskFile {
    /* renamed from: a */
    protected long f6742a = 83886080;

    /* renamed from: a */
    public File mo14987a(String str, File file) throws IOException {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo14989a(long j, int i) {
        return j < this.f6742a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo14990a(File file, long j, int i) {
        return j < this.f6742a / 2;
    }

    /* renamed from: a */
    public void mo14988a(List<File> list) {
        long b = mo14991b(list);
        StringBuilder sb = new StringBuilder();
        sb.append("当前缓存文件的总size：");
        sb.append((b / 1024) / 1024);
        String str = "MB";
        sb.append(str);
        String str2 = "TotalSizeLruDiskUsage";
        C2564t.m12222c(str2, sb.toString());
        int size = list.size();
        boolean a = mo14989a(b, size);
        if (a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("不满足删除条件，不执行删除操作(true)");
            sb2.append(a);
            C2564t.m12222c(str2, sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("满足删除条件，开始执行删除操作(false)");
            sb3.append(a);
            C2564t.m12222c(str2, sb3.toString());
        }
        for (File file : list) {
            if (!a) {
                C2564t.m12222c(str2, "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("删除 一个 Cache file 当前总大小totalSize：");
                    sb4.append((b / 1024) / 1024);
                    sb4.append(str);
                    C2564t.m12222c(str2, sb4.toString());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Error deleting file ");
                    sb5.append(file);
                    sb5.append(" for trimming cache");
                    C2564t.m12226e(str2, sb5.toString());
                }
                boolean a2 = mo14990a(file, b, size);
                if (a2) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("当前总大小totalSize：");
                    sb6.append((b / 1024) / 1024);
                    sb6.append("MB，最大值存储上限maxSize=");
                    sb6.append((this.f6742a / 1024) / 1024);
                    sb6.append("MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=");
                    sb6.append(a2);
                    C2564t.m12222c(str2, sb6.toString());
                    return;
                }
            }
        }
    }
}
