package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import epco.C7986n;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    /* renamed from: androidx.multidex.MultiDexExtractor$ExtractedDex */
    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        String sb2 = sb.toString();
        String str = TAG;
        Log.i(str, sb2);
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        this.lockRaf = new RandomAccessFile(file3, "rw");
        try {
            this.lockChannel = this.lockRaf.getChannel();
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Blocking on lock ");
                sb3.append(file3.getPath());
                Log.i(str, sb3.toString());
                this.cacheLock = this.lockChannel.lock();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(file3.getPath());
                sb4.append(" locked");
                Log.i(str, sb4.toString());
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            closeQuietly(this.lockRaf);
            throw e4;
        }
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [java.util.List, java.util.List<? extends java.io.File>] */
    /* JADX WARNING: type inference failed for: r12v2, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r12v6, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    public java.util.List<? extends java.io.File> load(android.content.Context r10, java.lang.String r11, boolean r12) throws java.io.IOException {
        /*
        r9 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "MultiDexExtractor.load("
        r0.append(r1)
        java.io.File r1 = r9.sourceApk
        java.lang.String r1 = r1.getPath()
        r0.append(r1)
        java.lang.String r1 = ", "
        r0.append(r1)
        r0.append(r12)
        r0.append(r1)
        r0.append(r11)
        java.lang.String r1 = ")"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "MultiDex"
        android.util.Log.i(r1, r0)
        java.nio.channels.FileLock r0 = r9.cacheLock
        boolean r0 = r0.isValid()
        if (r0 == 0) goto L_0x009f
        if (r12 != 0) goto L_0x0062
        java.io.File r0 = r9.sourceApk
        long r2 = r9.sourceCrc
        boolean r0 = isModified(r10, r0, r2, r11)
        if (r0 != 0) goto L_0x0062
        java.util.List r10 = r9.loadExistingExtractions(r10, r11)     // Catch:{ IOException -> 0x0049 }
        r12 = r10
        goto L_0x0081
    L_0x0049:
        r12 = move-exception
        java.lang.String r0 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
        android.util.Log.w(r1, r0, r12)
        java.util.List r12 = r9.performExtractions()
        java.io.File r0 = r9.sourceApk
        long r4 = getTimeStamp(r0)
        long r6 = r9.sourceCrc
        r2 = r10
        r3 = r11
        r8 = r12
        putStoredApkInfo(r2, r3, r4, r6, r8)
        goto L_0x0081
    L_0x0062:
        if (r12 == 0) goto L_0x006a
        java.lang.String r12 = "Forced extraction must be performed."
        android.util.Log.i(r1, r12)
        goto L_0x006f
    L_0x006a:
        java.lang.String r12 = "Detected that extraction must be performed."
        android.util.Log.i(r1, r12)
    L_0x006f:
        java.util.List r12 = r9.performExtractions()
        java.io.File r0 = r9.sourceApk
        long r4 = getTimeStamp(r0)
        long r6 = r9.sourceCrc
        r2 = r10
        r3 = r11
        r8 = r12
        putStoredApkInfo(r2, r3, r4, r6, r8)
    L_0x0081:
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r11 = "load found "
        r10.append(r11)
        int r11 = r12.size()
        r10.append(r11)
        java.lang.String r11 = " secondary dex files"
        r10.append(r11)
        java.lang.String r10 = r10.toString()
        android.util.Log.i(r1, r10)
        return r12
    L_0x009f:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
        java.lang.String r11 = "MultiDexExtractor was closed"
        r10.<init>(r11)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.load(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        Log.i(TAG, "loading existing secondary dex files");
        StringBuilder sb = new StringBuilder();
        sb.append(this.sourceApk.getName());
        sb.append(EXTRACTED_NAME_EXT);
        String sb2 = sb.toString();
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(KEY_DEX_NUMBER);
        int i = multiDexPreferences.getInt(sb3.toString(), 1);
        ArrayList arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(i2);
            sb4.append(EXTRACTED_SUFFIX);
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, sb4.toString());
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(KEY_DEX_CRC);
                sb5.append(i2);
                long j = multiDexPreferences.getLong(sb5.toString(), -1);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append(KEY_DEX_TIME);
                sb6.append(i2);
                long j2 = multiDexPreferences.getLong(sb6.toString(), -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str3 = sb2;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        multiDexPreferences = sharedPreferences;
                        sb2 = str3;
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid extracted dex: ");
                sb7.append(extractedDex);
                sb7.append(" (key \"");
                sb7.append(str2);
                sb7.append("\"), expected modification time: ");
                sb7.append(j2);
                sb7.append(", modification time: ");
                sb7.append(lastModified);
                sb7.append(", expected crc: ");
                sb7.append(j);
                sb7.append(", file crc: ");
                sb7.append(extractedDex.crc);
                throw new IOException(sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Missing extracted secondary dex file '");
            sb8.append(extractedDex.getPath());
            sb8.append("'");
            throw new IOException(sb8.toString());
        }
        return arrayList;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        if (multiDexPreferences.getLong(sb.toString(), -1) == getTimeStamp(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(KEY_CRC);
            if (multiDexPreferences.getLong(sb2.toString(), -1) == j) {
                return false;
            }
        }
        return true;
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        ExtractedDex extractedDex;
        boolean z;
        String str = DEX_SUFFIX;
        String str2 = "Failed to close resource";
        String str3 = DEX_PREFIX;
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(this.sourceApk.getName());
        sb.append(EXTRACTED_NAME_EXT);
        String sb2 = sb.toString();
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(2);
            sb3.append(str);
            ZipEntry entry = zipFile.getEntry(sb3.toString());
            int i = 2;
            while (entry != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append(i);
                sb4.append(EXTRACTED_SUFFIX);
                extractedDex = new ExtractedDex(this.dexDir, sb4.toString());
                arrayList.add(extractedDex);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Extraction is needed for file ");
                sb5.append(extractedDex);
                Log.i(str4, sb5.toString());
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    extract(zipFile, entry, extractedDex, sb2);
                    extractedDex.crc = getZipCrc(extractedDex);
                    z = true;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Extraction ");
                    sb6.append(z ? "succeeded" : "failed");
                    sb6.append(" '");
                    sb6.append(extractedDex.getAbsolutePath());
                    sb6.append("': length ");
                    int i4 = i3;
                    sb6.append(extractedDex.length());
                    sb6.append(" - crc: ");
                    sb6.append(extractedDex.crc);
                    Log.i(str4, sb6.toString());
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Failed to delete corrupted secondary dex '");
                            sb7.append(extractedDex.getPath());
                            sb7.append("'");
                            Log.w(str4, sb7.toString());
                        }
                    }
                    z2 = z;
                    i2 = i4;
                }
                if (z2) {
                    i++;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str3);
                    sb8.append(i);
                    sb8.append(str);
                    entry = zipFile.getEntry(sb8.toString());
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Could not create zip file ");
                    sb9.append(extractedDex.getAbsolutePath());
                    sb9.append(" for secondary dex (");
                    sb9.append(i);
                    sb9.append(")");
                    throw new IOException(sb9.toString());
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w(str4, str2, e);
            }
            return arrayList;
        } catch (IOException e2) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Failed to read crc from ");
            sb10.append(extractedDex.getAbsolutePath());
            Log.w(str4, sb10.toString(), e2);
            z = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w(str4, str2, e3);
            }
            throw th2;
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        Editor edit = getMultiDexPreferences(context).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("timestamp");
        edit.putLong(sb.toString(), j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(KEY_CRC);
        edit.putLong(sb2.toString(), j2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(KEY_DEX_NUMBER);
        edit.putInt(sb3.toString(), list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(KEY_DEX_CRC);
            sb4.append(i);
            edit.putLong(sb4.toString(), extractedDex.crc);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(KEY_DEX_TIME);
            sb5.append(i);
            edit.putLong(sb5.toString(), extractedDex.lastModified());
            i++;
        }
        edit.commit();
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        String str = TAG;
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.dexDir.getPath());
            sb.append(").");
            Log.w(str, sb.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            Log.i(str, sb2.toString());
            if (!file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
                Log.w(str, sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
                Log.i(str, sb4.toString());
            }
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(str);
        File createTempFile = File.createTempFile(sb.toString(), EXTRACTED_SUFFIX, file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(createTempFile.getPath());
        String sb3 = sb2.toString();
        String str2 = TAG;
        Log.i(str2, sb3);
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry(C7986n.f27119c);
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Renaming to ");
                sb4.append(file.getPath());
                Log.i(str2, sb4.toString());
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Failed to rename \"");
                sb5.append(createTempFile.getAbsolutePath());
                sb5.append("\" to \"");
                sb5.append(file.getAbsolutePath());
                sb5.append("\"");
                throw new IOException(sb5.toString());
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Failed to mark readonly \"");
            sb6.append(createTempFile.getAbsolutePath());
            sb6.append("\" (tmp of \"");
            sb6.append(file.getAbsolutePath());
            sb6.append("\")");
            throw new IOException(sb6.toString());
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }
}
