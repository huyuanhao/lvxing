package com.p522qq.p523e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.p522qq.p523e.comm.constants.CustomPkgConstants;
import com.p522qq.p523e.comm.constants.Sig;
import com.p522qq.p523e.comm.util.FileUtil;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: com.qq.e.comm.managers.plugin.a */
public class C6419a {
    /* renamed from: a */
    private final File f20203a;
    /* renamed from: b */
    private final File f20204b;
    /* renamed from: c */
    private String f20205c;
    /* renamed from: d */
    private int f20206d;

    public C6419a(File file, File file2) {
        this.f20203a = file;
        this.f20204b = file2;
    }

    /* renamed from: a */
    public static boolean m25195a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(CustomPkgConstants.getAssetPluginDir());
            sb.append(File.separator);
            sb.append(CustomPkgConstants.getAssetPluginName());
            String sb2 = sb.toString();
            String str = Sig.ASSET_PLUGIN_SIG;
            if (str == null) {
                str = "";
            }
            StringBuilder sb3 = new StringBuilder("1081#####");
            sb3.append(str);
            StringUtil.writeTo(sb3.toString(), file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(sb2), file);
            }
            InputStream open = assets.open(sb2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    int i3 = i2;
                    int i4 = i;
                    int i5 = 0;
                    while (i5 < read) {
                        int i6 = i4 + 1;
                        if (i4 >= 64) {
                            int i7 = i3 + 1;
                            bArr[i5] = (byte) (bArr[i5] ^ bytes[i3 % length]);
                            i3 = i7;
                        }
                        i5++;
                        i4 = i6;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    i = i4;
                    i2 = i3;
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ all -> 0x004b }] */
    /* renamed from: a */
    public boolean mo30128a() {
        /*
        r7 = this;
        r0 = 0
        java.io.File r1 = r7.f20204b     // Catch:{ all -> 0x004b }
        boolean r1 = r1.exists()     // Catch:{ all -> 0x004b }
        if (r1 == 0) goto L_0x004a
        java.io.File r1 = r7.f20203a     // Catch:{ all -> 0x004b }
        boolean r1 = r1.exists()     // Catch:{ all -> 0x004b }
        if (r1 == 0) goto L_0x004a
        java.io.File r1 = r7.f20204b     // Catch:{ all -> 0x004b }
        java.lang.String r1 = com.p522qq.p523e.comm.util.StringUtil.readAll(r1)     // Catch:{ all -> 0x004b }
        java.lang.String r2 = "#####"
        java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x004b }
        int r2 = r1.length     // Catch:{ all -> 0x004b }
        r3 = 2
        if (r2 != r3) goto L_0x004a
        r2 = 1
        r3 = r1[r2]     // Catch:{ all -> 0x004b }
        r1 = r1[r0]     // Catch:{ all -> 0x004b }
        int r1 = com.p522qq.p523e.comm.util.StringUtil.parseInteger(r1, r0)     // Catch:{ all -> 0x004b }
        com.qq.e.comm.util.a r4 = com.p522qq.p523e.comm.util.C6439a.m25265a()     // Catch:{ all -> 0x004b }
        java.io.File r5 = r7.f20203a     // Catch:{ all -> 0x004b }
        if (r5 == 0) goto L_0x0042
        boolean r6 = r5.exists()     // Catch:{ all -> 0x004b }
        if (r6 != 0) goto L_0x0039
        goto L_0x0042
    L_0x0039:
        java.lang.String r5 = com.p522qq.p523e.comm.util.Md5Util.encode(r5)     // Catch:{ all -> 0x004b }
        boolean r4 = r4.mo30393b(r3, r5)     // Catch:{ all -> 0x004b }
        goto L_0x0043
    L_0x0042:
        r4 = 0
    L_0x0043:
        if (r4 == 0) goto L_0x004a
        r7.f20205c = r3     // Catch:{ all -> 0x004b }
        r7.f20206d = r1     // Catch:{ all -> 0x004b }
        return r2
    L_0x004a:
        return r0
    L_0x004b:
        r1 = move-exception
        java.lang.String r2 = "Exception while checking plugin"
        com.p522qq.p523e.comm.util.GDTLogger.report(r2, r1)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.managers.plugin.C6419a.mo30128a():boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo30129a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return (file.equals(this.f20203a) || FileUtil.renameTo(this.f20203a, file)) && (file2.equals(this.f20204b) || FileUtil.renameTo(this.f20204b, file2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo30130b() {
        return this.f20206d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo30131c() {
        return this.f20205c;
    }
}
