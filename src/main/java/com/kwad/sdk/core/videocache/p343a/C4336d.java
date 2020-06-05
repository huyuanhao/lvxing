package com.kwad.sdk.core.videocache.p343a;

import com.kwad.sdk.core.p319c.C4065b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.videocache.a.d */
class C4336d {

    /* renamed from: com.kwad.sdk.core.videocache.a.d$a */
    private static final class C4338a implements Comparator<File> {
        private C4338a() {
        }

        /* renamed from: a */
        private int m17732a(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return m17732a(file.lastModified(), file2.lastModified());
        }
    }

    /* renamed from: a */
    static void m17727a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                StringBuilder sb = new StringBuilder();
                sb.append("File ");
                sb.append(file);
                sb.append(" is not directory!");
                throw new IOException(sb.toString());
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: b */
    static List<File> m17728b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C4338a());
        return asList;
    }

    /* renamed from: c */
    static void m17729c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                m17730d(file);
                if (file.lastModified() < currentTimeMillis) {
                    C4065b.m16868c("Files", String.format("Last modified date %s is not set for file %s", new Object[]{new Date(file.lastModified()), file.getAbsolutePath()}));
                }
            }
        }
    }

    /* renamed from: d */
    static void m17730d(File file) {
        long length = file.length();
        if (length == 0) {
            m17731e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    /* renamed from: e */
    private static void m17731e(File file) {
        if (!file.delete() || !file.createNewFile()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error recreate zero-size file ");
            sb.append(file);
            throw new IOException(sb.toString());
        }
    }
}
