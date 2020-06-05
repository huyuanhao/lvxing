package com.jiayouya.travel.common.p246d;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, mo39189d2 = {"getTempDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.f */
public final class FileUtil {
    /* renamed from: a */
    public static final File m12957a(Context context) {
        C8271i.m35386b(context, "context");
        if (!C8271i.m35384a((Object) Environment.getExternalStorageState(), (Object) "mounted") || !Environment.getExternalStorageDirectory().canWrite()) {
            File filesDir = context.getFilesDir();
            C8271i.m35382a((Object) filesDir, "context.filesDir");
            return filesDir;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        C8271i.m35382a((Object) externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        return externalStorageDirectory;
    }
}
