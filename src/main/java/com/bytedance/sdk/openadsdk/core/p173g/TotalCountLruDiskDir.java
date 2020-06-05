package com.bytedance.sdk.openadsdk.core.p173g;

import com.bytedance.sdk.openadsdk.p164b.TotalCountLruDiskFile;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import java.io.File;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.core.g.c */
public class TotalCountLruDiskDir extends TotalCountLruDiskFile {
    public TotalCountLruDiskDir(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14988a(List<File> list) {
        int size = list.size();
        if (!mo14989a(0, size)) {
            for (File file : list) {
                FileUtils.m12176c(file);
                size--;
                if (mo14990a(file, 0, size)) {
                    return;
                }
            }
        }
    }
}
