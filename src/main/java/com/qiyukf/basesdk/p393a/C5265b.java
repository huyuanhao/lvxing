package com.qiyukf.basesdk.p393a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.qiyukf.basesdk.a.b */
final class C5265b {
    /* renamed from: a */
    static final SimpleDateFormat f17055a = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    /* renamed from: b */
    private static final SimpleDateFormat f17056b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    /* renamed from: c */
    private static final Set<String> f17057c;

    static {
        HashSet hashSet = new HashSet();
        f17057c = hashSet;
        hashSet.add("tmp_u_");
        f17057c.add("tmp_c_");
    }

    /* renamed from: a */
    static long m21627a(File file) {
        long length = file.length();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            long j = length - 1;
            long j2 = 0;
            while (j2 <= j) {
                try {
                    long j3 = (j2 + j) / 2;
                    randomAccessFile2.seek(j3);
                    short readShort = randomAccessFile2.readShort();
                    if ((readShort >> 8) == 0) {
                        j = j3 - 1;
                    } else if ((readShort & 255) == 0) {
                        long j4 = j3 + 1;
                        m21632a((Closeable) randomAccessFile2);
                        return j4;
                    } else {
                        j2 = j3 + 1;
                    }
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    String str = "log";
                    try {
                        StringBuilder sb = new StringBuilder("init log file error: ");
                        sb.append(e);
                        Log.i(str, sb.toString());
                        m21632a((Closeable) randomAccessFile);
                        return length;
                    } catch (Throwable th) {
                        th = th;
                        m21632a((Closeable) randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    m21632a((Closeable) randomAccessFile);
                    throw th;
                }
            }
            if (j2 == 0) {
                length = 0;
            }
            m21632a((Closeable) randomAccessFile2);
            return length;
        } catch (IOException e2) {
            e = e2;
            String str2 = "log";
            StringBuilder sb2 = new StringBuilder("init log file error: ");
            sb2.append(e);
            Log.i(str2, sb2.toString());
            m21632a((Closeable) randomAccessFile);
            return length;
        }
    }

    /* renamed from: a */
    static String m21628a(String str, long j, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(f17056b.format(new Date(j)));
        String str3 = ": ";
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        String str4 = "\n";
        sb.append(str4);
        if (th != null) {
            sb.append(Log.getStackTraceString(th));
            sb.append(str4);
        }
        return sb.toString();
    }

    /* renamed from: a */
    static MappedByteBuffer m21629a(File file, long j, long j2) {
        RandomAccessFile randomAccessFile;
        boolean z = !file.exists() || file.length() < j + j2;
        MappedByteBuffer mappedByteBuffer = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            long j3 = j + j2;
            try {
                randomAccessFile.setLength(j3);
                if (randomAccessFile.length() < j3) {
                    m21632a((Closeable) randomAccessFile);
                    return null;
                }
                if (z) {
                    m21634a(randomAccessFile, j, j2);
                }
                mappedByteBuffer = randomAccessFile.getChannel().map(MapMode.READ_WRITE, j, j2);
                m21632a((Closeable) randomAccessFile);
                return mappedByteBuffer;
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    m21632a((Closeable) randomAccessFile);
                    return mappedByteBuffer;
                } catch (Throwable th) {
                    th = th;
                    m21632a((Closeable) randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            RandomAccessFile randomAccessFile2 = null;
            e.printStackTrace();
            m21632a((Closeable) randomAccessFile);
            return mappedByteBuffer;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            m21632a((Closeable) randomAccessFile);
            throw th;
        }
    }

    /* renamed from: a */
    static Calendar m21630a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance;
    }

    /* renamed from: a */
    private static void m21631a(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    /* renamed from: a */
    private static void m21632a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.io.BufferedWriter] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Unknown variable types count: 18 */
    /* renamed from: a */
    private static void m21633a(java.io.File r12, java.io.File r13, java.io.File r14) {
        /*
        r0 = -1
        r2 = 0
        if (r13 == 0) goto L_0x0028
        boolean r3 = r13.exists()     // Catch:{ IOException -> 0x0023, all -> 0x001e }
        if (r3 == 0) goto L_0x0028
        java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0023, all -> 0x001e }
        java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0023, all -> 0x001e }
        r4.<init>(r13)     // Catch:{ IOException -> 0x0023, all -> 0x001e }
        r3.<init>(r4)     // Catch:{ IOException -> 0x0023, all -> 0x001e }
        java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        long r5 = m21641d(r4)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        goto L_0x002b
    L_0x001e:
        r12 = move-exception
        r0 = r2
        r3 = r0
        goto L_0x00b9
    L_0x0023:
        r12 = move-exception
        r0 = r2
        r9 = r0
        goto L_0x00a3
    L_0x0028:
        r5 = r0
        r3 = r2
        r4 = r3
    L_0x002b:
        if (r14 == 0) goto L_0x004e
        boolean r7 = r14.exists()     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        if (r7 == 0) goto L_0x004e
        java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        r1.<init>(r14)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        r0.<init>(r1)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
        java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
        long r7 = m21641d(r1)     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
        goto L_0x0051
    L_0x0046:
        r12 = move-exception
        r0 = r2
        goto L_0x00b9
    L_0x004a:
        r12 = move-exception
        r0 = r2
        r9 = r0
        goto L_0x00a2
    L_0x004e:
        r7 = r0
        r0 = r2
        r1 = r0
    L_0x0051:
        java.io.BufferedWriter r9 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
        java.io.FileWriter r10 = new java.io.FileWriter     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
        r11 = 1
        r10.<init>(r12, r11)     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
        r9.<init>(r10)     // Catch:{ IOException -> 0x00a0, all -> 0x009e }
    L_0x005c:
        r10 = 0
        int r12 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
        if (r12 >= 0) goto L_0x006b
        int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
        if (r2 < 0) goto L_0x0067
        goto L_0x006b
    L_0x0067:
        m21632a(r3)
        goto L_0x00a9
    L_0x006b:
        if (r12 == 0) goto L_0x008e
        int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
        if (r2 < 0) goto L_0x008e
        if (r12 <= 0) goto L_0x0078
        int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r10 > 0) goto L_0x0078
        goto L_0x008e
    L_0x0078:
        if (r2 == 0) goto L_0x0082
        if (r12 < 0) goto L_0x0082
        if (r2 <= 0) goto L_0x005c
        int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
        if (r12 <= 0) goto L_0x005c
    L_0x0082:
        m21631a(r9, r1)     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        java.lang.String r1 = r0.readLine()     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        long r7 = m21641d(r1)     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        goto L_0x005c
    L_0x008e:
        m21631a(r9, r4)     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        long r5 = m21641d(r4)     // Catch:{ IOException -> 0x009c, all -> 0x009a }
        goto L_0x005c
    L_0x009a:
        r12 = move-exception
        goto L_0x00b8
    L_0x009c:
        r12 = move-exception
        goto L_0x00a2
    L_0x009e:
        r12 = move-exception
        goto L_0x00b9
    L_0x00a0:
        r12 = move-exception
        r9 = r2
    L_0x00a2:
        r2 = r3
    L_0x00a3:
        r12.printStackTrace()     // Catch:{ all -> 0x00b6 }
        m21632a(r2)
    L_0x00a9:
        m21632a(r0)
        m21632a(r9)
        m21642d(r13)
        m21642d(r14)
        return
    L_0x00b6:
        r12 = move-exception
        r3 = r2
    L_0x00b8:
        r2 = r9
    L_0x00b9:
        m21632a(r3)
        m21632a(r0)
        m21632a(r2)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p393a.C5265b.m21633a(java.io.File, java.io.File, java.io.File):void");
    }

    /* renamed from: a */
    private static void m21634a(RandomAccessFile randomAccessFile, long j, long j2) {
        randomAccessFile.seek(j);
        byte[] bArr = new byte[65536];
        int i = 0;
        while (true) {
            long j3 = (long) i;
            if (j3 < j2) {
                randomAccessFile.write(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, j2 - j3));
                i += 65536;
            } else {
                randomAccessFile.seek(0);
                return;
            }
        }
    }

    /* renamed from: a */
    static void m21635a(String str) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        FileOutputStream fileOutputStream2;
        File file = new File(str);
        if (file.length() >= 8388608) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".tmp");
            File file2 = new File(sb.toString());
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        channel.position(file.length() - 4194304);
                        fileOutputStream.getChannel().transferFrom(channel, 0, 4194304);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    fileOutputStream2 = null;
                    e = iOException;
                    try {
                        e.printStackTrace();
                        m21632a((Closeable) fileInputStream);
                        m21632a((Closeable) fileOutputStream);
                        file2.renameTo(file);
                    } catch (Throwable th) {
                        th = th;
                        m21632a((Closeable) fileInputStream);
                        m21632a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    th = th;
                    m21632a((Closeable) fileInputStream);
                    m21632a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                fileOutputStream2 = null;
                e = e4;
                FileInputStream fileInputStream2 = null;
                e.printStackTrace();
                m21632a((Closeable) fileInputStream);
                m21632a((Closeable) fileOutputStream);
                file2.renameTo(file);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                fileOutputStream = null;
                th = th;
                m21632a((Closeable) fileInputStream);
                m21632a((Closeable) fileOutputStream);
                throw th;
            }
            m21632a((Closeable) fileInputStream);
            m21632a((Closeable) fileOutputStream);
            if (file2.exists() && file.delete()) {
                file2.renameTo(file);
            }
        }
    }

    /* renamed from: a */
    private static void m21636a(String str, final boolean z) {
        final Calendar a = m21630a();
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.getParentFile().listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    long b = C5265b.m21639c(file);
                    return z ? b > 0 : b > 0 && b < a.getTimeInMillis();
                }
            });
            if (listFiles.length != 0) {
                List asList = Arrays.asList(listFiles);
                Collections.sort(asList, new Comparator<File>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        int i = ((C5265b.m21639c((File) obj) - C5265b.m21639c((File) obj2)) > 0 ? 1 : ((C5265b.m21639c((File) obj) - C5265b.m21639c((File) obj2)) == 0 ? 0 : -1));
                        if (i > 0) {
                            return 1;
                        }
                        return i < 0 ? -1 : 0;
                    }
                });
                int i = 0;
                while (i < asList.size()) {
                    if (i == asList.size() - 1) {
                        m21633a(file, (File) asList.get(i), (File) null);
                        return;
                    }
                    File file2 = (File) asList.get(i);
                    int i2 = i + 1;
                    File file3 = (File) asList.get(i2);
                    if (m21639c(file2) == m21639c(file3)) {
                        m21633a(file, file2, file3);
                        i += 2;
                    } else {
                        m21633a(file, file2, (File) null);
                        i = i2;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    static void m21638b(String str) {
        m21636a(str, false);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static long m21639c(File file) {
        long j = -1;
        if (file.isDirectory()) {
            return -1;
        }
        String name = file.getName();
        if (name.length() < 8) {
            return -1;
        }
        String substring = name.substring(0, name.length() - 8);
        if (!f17057c.contains(substring)) {
            return -1;
        }
        try {
            j = f17055a.parse(name.substring(substring.length())).getTime();
        } catch (ParseException unused) {
        }
        return j;
    }

    /* renamed from: c */
    static void m21640c(String str) {
        m21636a(str, true);
    }

    /* renamed from: d */
    private static long m21641d(String str) {
        if (str == null) {
            return -1;
        }
        if (!TextUtils.isEmpty(str) && str.charAt(0) == 0) {
            return -1;
        }
        long j = 0;
        int indexOf = str.indexOf(": ");
        if (indexOf == 18) {
            try {
                j = f17056b.parse(str.substring(0, indexOf)).getTime();
            } catch (ParseException unused) {
            }
        }
        return j;
    }

    /* renamed from: d */
    private static boolean m21642d(File file) {
        return file != null && file.exists() && file.delete();
    }
}
