package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    /* access modifiers changed from: private|static|final */
    public static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public void write(int i) {
        }
    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    /* access modifiers changed from: private|final */
    public final File directory;
    final ThreadPoolExecutor executorService;
    private int fileCount = 0;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private int maxFileCount;
    private long maxSize;
    private long nextSequenceNumber = 0;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size = 0;
    /* access modifiers changed from: private|final */
    public final int valueCount;

    /* renamed from: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor */
    public final class Editor {
        private boolean committed;
        /* access modifiers changed from: private|final */
        public final Entry entry;
        /* access modifiers changed from: private */
        public boolean hasErrors;
        /* access modifiers changed from: private|final */
        public final boolean[] written;

        /* renamed from: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor$FaultHidingOutputStream */
        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }
        }

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public void abort() {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        public void commit() {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public String getString(int i) {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public InputStream newInputStream(int i) {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        public java.io.OutputStream newOutputStream(int r4) {
            /*
            r3 = this;
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r0 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this
            monitor-enter(r0)
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0046 }
            if (r1 != r3) goto L_0x0040
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.readable     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0018
            boolean[] r1 = r3.written     // Catch:{ all -> 0x0046 }
            r2 = 1
            r1[r4] = r2     // Catch:{ all -> 0x0046 }
        L_0x0018:
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
            java.io.File r4 = r1.getDirtyFile(r4)     // Catch:{ all -> 0x0046 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0024 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0024 }
            goto L_0x0032
        L_0x0024:
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x0046 }
            java.io.File r1 = r1.directory     // Catch:{ all -> 0x0046 }
            r1.mkdirs()     // Catch:{ all -> 0x0046 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003a }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003a }
        L_0x0032:
            com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor$FaultHidingOutputStream r4 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0046 }
            r2 = 0
            r4.m48042init(r1)     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return r4
        L_0x003a:
            java.io.OutputStream r4 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.NULL_OUTPUT_STREAM     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return r4
        L_0x0040:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0046 }
            r4.<init>()     // Catch:{ all -> 0x0046 }
            throw r4     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Editor.newOutputStream(int):java.io.OutputStream");
        }

        public void set(int i, String str) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), Util.UTF_8);
                try {
                    outputStreamWriter2.write(str);
                    Util.closeQuietly(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.closeQuietly(outputStreamWriter);
                throw th;
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry */
    private final class Entry {
        /* access modifiers changed from: private */
        public Editor currentEditor;
        /* access modifiers changed from: private|final */
        public final String key;
        /* access modifiers changed from: private|final */
        public final long[] lengths;
        /* access modifiers changed from: private */
        public boolean readable;
        /* access modifiers changed from: private */
        public long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        private IOException invalidLengths(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: private */
        public void setLengths(String[] strArr) {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.lengths[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        public File getCleanFile(int i) {
            File access$2000 = DiskLruCache.this.directory;
            StringBuilder sb = new StringBuilder();
            sb.append(this.key);
            sb.append(".");
            sb.append(i);
            return new File(access$2000, sb.toString());
        }

        public File getDirtyFile(int i) {
            File access$2000 = DiskLruCache.this.directory;
            StringBuilder sb = new StringBuilder();
            sb.append(this.key);
            sb.append(".");
            sb.append(i);
            sb.append(".tmp");
            return new File(access$2000, sb.toString());
        }

        public String getLengths() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.lengths) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot */
    public final class Snapshot implements Closeable {
        private File[] files;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        public void close() {
            for (InputStream closeQuietly : this.ins) {
                Util.closeQuietly(closeQuietly);
            }
        }

        public Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int i) {
            return this.files[i];
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public String getString(int i) {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }
    }

    private DiskLruCache(File file, int i, int i2, long j, int i3) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.executorService = threadPoolExecutor;
        this.cleanupCallable = new Callable<Void>() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            return null;
     */
            public java.lang.Void call() {
                /*
                r4 = this;
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r0 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this
                monitor-enter(r0)
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                java.io.Writer r1 = r1.journalWriter     // Catch:{ all -> 0x002d }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x000e:
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.trimToSize()     // Catch:{ all -> 0x002d }
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.trimToFileCount()     // Catch:{ all -> 0x002d }
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ all -> 0x002d }
                if (r1 == 0) goto L_0x002b
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r1.rebuildJournal()     // Catch:{ all -> 0x002d }
                com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache r1 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.this     // Catch:{ all -> 0x002d }
                r3 = 0
                r1.redundantOpCount = r3     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x002d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.C42321.call():java.lang.Void");
            }
        };
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, JOURNAL_FILE);
        this.journalFileTmp = new File(file2, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file2, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.maxFileCount = i3;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0114, code lost:
            return;
     */
    public synchronized void completeEdit(com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Editor r11, boolean r12) {
        /*
        r10 = this;
        monitor-enter(r10)
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = r11.entry     // Catch:{ all -> 0x011b }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x011b }
        if (r1 != r11) goto L_0x0115
        r1 = 0
        if (r12 == 0) goto L_0x004d
        boolean r2 = r0.readable     // Catch:{ all -> 0x011b }
        if (r2 != 0) goto L_0x004d
        r2 = 0
    L_0x0015:
        int r3 = r10.valueCount     // Catch:{ all -> 0x011b }
        if (r2 >= r3) goto L_0x004d
        boolean[] r3 = r11.written     // Catch:{ all -> 0x011b }
        boolean r3 = r3[r2]     // Catch:{ all -> 0x011b }
        if (r3 == 0) goto L_0x0033
        java.io.File r3 = r0.getDirtyFile(r2)     // Catch:{ all -> 0x011b }
        boolean r3 = r3.exists()     // Catch:{ all -> 0x011b }
        if (r3 != 0) goto L_0x0030
        r11.abort()     // Catch:{ all -> 0x011b }
        monitor-exit(r10)
        return
    L_0x0030:
        int r2 = r2 + 1
        goto L_0x0015
    L_0x0033:
        r11.abort()     // Catch:{ all -> 0x011b }
        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011b }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
        r12.<init>()     // Catch:{ all -> 0x011b }
        java.lang.String r0 = "Newly created entry didn't create value for index "
        r12.append(r0)     // Catch:{ all -> 0x011b }
        r12.append(r2)     // Catch:{ all -> 0x011b }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x011b }
        r11.<init>(r12)     // Catch:{ all -> 0x011b }
        throw r11     // Catch:{ all -> 0x011b }
    L_0x004d:
        int r11 = r10.valueCount     // Catch:{ all -> 0x011b }
        r2 = 1
        if (r1 >= r11) goto L_0x0087
        java.io.File r11 = r0.getDirtyFile(r1)     // Catch:{ all -> 0x011b }
        if (r12 == 0) goto L_0x0081
        boolean r3 = r11.exists()     // Catch:{ all -> 0x011b }
        if (r3 == 0) goto L_0x0084
        java.io.File r3 = r0.getCleanFile(r1)     // Catch:{ all -> 0x011b }
        r11.renameTo(r3)     // Catch:{ all -> 0x011b }
        long[] r11 = r0.lengths     // Catch:{ all -> 0x011b }
        r4 = r11[r1]     // Catch:{ all -> 0x011b }
        long r6 = r3.length()     // Catch:{ all -> 0x011b }
        long[] r11 = r0.lengths     // Catch:{ all -> 0x011b }
        r11[r1] = r6     // Catch:{ all -> 0x011b }
        long r8 = r10.size     // Catch:{ all -> 0x011b }
        long r8 = r8 - r4
        long r8 = r8 + r6
        r10.size = r8     // Catch:{ all -> 0x011b }
        int r11 = r10.fileCount     // Catch:{ all -> 0x011b }
        int r11 = r11 + r2
        r10.fileCount = r11     // Catch:{ all -> 0x011b }
        goto L_0x0084
    L_0x0081:
        deleteIfExists(r11)     // Catch:{ all -> 0x011b }
    L_0x0084:
        int r1 = r1 + 1
        goto L_0x004d
    L_0x0087:
        int r11 = r10.redundantOpCount     // Catch:{ all -> 0x011b }
        int r11 = r11 + r2
        r10.redundantOpCount = r11     // Catch:{ all -> 0x011b }
        r11 = 0
        r0.currentEditor = r11     // Catch:{ all -> 0x011b }
        boolean r11 = r0.readable     // Catch:{ all -> 0x011b }
        r11 = r11 | r12
        r1 = 10
        if (r11 == 0) goto L_0x00cd
        r0.readable = r2     // Catch:{ all -> 0x011b }
        java.io.Writer r11 = r10.journalWriter     // Catch:{ all -> 0x011b }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
        r2.<init>()     // Catch:{ all -> 0x011b }
        java.lang.String r3 = "CLEAN "
        r2.append(r3)     // Catch:{ all -> 0x011b }
        java.lang.String r3 = r0.key     // Catch:{ all -> 0x011b }
        r2.append(r3)     // Catch:{ all -> 0x011b }
        java.lang.String r3 = r0.getLengths()     // Catch:{ all -> 0x011b }
        r2.append(r3)     // Catch:{ all -> 0x011b }
        r2.append(r1)     // Catch:{ all -> 0x011b }
        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011b }
        r11.write(r1)     // Catch:{ all -> 0x011b }
        if (r12 == 0) goto L_0x00f3
        long r11 = r10.nextSequenceNumber     // Catch:{ all -> 0x011b }
        r1 = 1
        long r1 = r1 + r11
        r10.nextSequenceNumber = r1     // Catch:{ all -> 0x011b }
        r0.sequenceNumber = r11     // Catch:{ all -> 0x011b }
        goto L_0x00f3
    L_0x00cd:
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r11 = r10.lruEntries     // Catch:{ all -> 0x011b }
        java.lang.String r12 = r0.key     // Catch:{ all -> 0x011b }
        r11.remove(r12)     // Catch:{ all -> 0x011b }
        java.io.Writer r11 = r10.journalWriter     // Catch:{ all -> 0x011b }
        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
        r12.<init>()     // Catch:{ all -> 0x011b }
        java.lang.String r2 = "REMOVE "
        r12.append(r2)     // Catch:{ all -> 0x011b }
        java.lang.String r0 = r0.key     // Catch:{ all -> 0x011b }
        r12.append(r0)     // Catch:{ all -> 0x011b }
        r12.append(r1)     // Catch:{ all -> 0x011b }
        java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x011b }
        r11.write(r12)     // Catch:{ all -> 0x011b }
    L_0x00f3:
        java.io.Writer r11 = r10.journalWriter     // Catch:{ all -> 0x011b }
        r11.flush()     // Catch:{ all -> 0x011b }
        long r11 = r10.size     // Catch:{ all -> 0x011b }
        long r0 = r10.maxSize     // Catch:{ all -> 0x011b }
        int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x010c
        int r11 = r10.fileCount     // Catch:{ all -> 0x011b }
        int r12 = r10.maxFileCount     // Catch:{ all -> 0x011b }
        if (r11 > r12) goto L_0x010c
        boolean r11 = r10.journalRebuildRequired()     // Catch:{ all -> 0x011b }
        if (r11 == 0) goto L_0x0113
    L_0x010c:
        java.util.concurrent.ThreadPoolExecutor r11 = r10.executorService     // Catch:{ all -> 0x011b }
        java.util.concurrent.Callable<java.lang.Void> r12 = r10.cleanupCallable     // Catch:{ all -> 0x011b }
        r11.submit(r12)     // Catch:{ all -> 0x011b }
    L_0x0113:
        monitor-exit(r10)
        return
    L_0x0115:
        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011b }
        r11.<init>()     // Catch:{ all -> 0x011b }
        throw r11     // Catch:{ all -> 0x011b }
    L_0x011b:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.completeEdit(com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor, boolean):void");
    }

    private static void deleteIfExists(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            return null;
     */
    public synchronized com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Editor edit(java.lang.String r6, long r7) {
        /*
        r5 = this;
        monitor-enter(r5)
        r5.checkNotClosed()     // Catch:{ all -> 0x0061 }
        r5.validateKey(r6)     // Catch:{ all -> 0x0061 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0061 }
        java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = (com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0061 }
        r1 = -1
        r3 = 0
        int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
        if (r4 == 0) goto L_0x0022
        if (r0 == 0) goto L_0x0020
        long r1 = r0.sequenceNumber     // Catch:{ all -> 0x0061 }
        int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
        if (r4 == 0) goto L_0x0022
    L_0x0020:
        monitor-exit(r5)
        return r3
    L_0x0022:
        if (r0 != 0) goto L_0x002f
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry     // Catch:{ all -> 0x0061 }
        r0.m48044init(r6)     // Catch:{ all -> 0x0061 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r7 = r5.lruEntries     // Catch:{ all -> 0x0061 }
        r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
        goto L_0x0037
    L_0x002f:
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0061 }
        if (r7 == 0) goto L_0x0037
        monitor-exit(r5)
        return r3
    L_0x0037:
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor r7 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor     // Catch:{ all -> 0x0061 }
        r7.m48040init(r0)     // Catch:{ all -> 0x0061 }
        r0.currentEditor = r7     // Catch:{ all -> 0x0061 }
        java.io.Writer r8 = r5.journalWriter     // Catch:{ all -> 0x0061 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
        r0.<init>()     // Catch:{ all -> 0x0061 }
        java.lang.String r1 = "DIRTY "
        r0.append(r1)     // Catch:{ all -> 0x0061 }
        r0.append(r6)     // Catch:{ all -> 0x0061 }
        r6 = 10
        r0.append(r6)     // Catch:{ all -> 0x0061 }
        java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
        r8.write(r6)     // Catch:{ all -> 0x0061 }
        java.io.Writer r6 = r5.journalWriter     // Catch:{ all -> 0x0061 }
        r6.flush()     // Catch:{ all -> 0x0061 }
        monitor-exit(r5)
        return r7
    L_0x0061:
        r6 = move-exception
        monitor-exit(r5)
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.edit(java.lang.String, long):com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor");
    }

    /* access modifiers changed from: private|static */
    public static String inputStreamToString(InputStream inputStream) {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    /* access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j, i3);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(e.getMessage());
                    sb.append(", removing");
                    printStream.println(sb.toString());
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j, i3);
            diskLruCache2.rebuildJournal();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void processJournal() {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += entry.lengths[i];
                    this.fileCount++;
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(entry.getCleanFile(i));
                    deleteIfExists(entry.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
            return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x006c=Splitter:B:20:0x006c, B:16:0x005f=Splitter:B:16:0x005f} */
    private void readJournal() {
        /*
        r9 = this;
        java.lang.String r0 = ", "
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.StrictLineReader r1 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.StrictLineReader
        java.io.FileInputStream r2 = new java.io.FileInputStream
        java.io.File r3 = r9.journalFile
        r2.<init>(r3)
        java.nio.charset.Charset r3 = com.kwad.sdk.core.imageloader.cache.disc.impl.ext.Util.US_ASCII
        r1.m48051init(r2, r3)
        java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x009a }
        java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x009a }
        java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x009a }
        java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x009a }
        java.lang.String r6 = r1.readLine()     // Catch:{ all -> 0x009a }
        java.lang.String r7 = "libcore.io.DiskLruCache"
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x009a }
        if (r7 == 0) goto L_0x006c
        java.lang.String r7 = "1"
        boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x009a }
        if (r7 == 0) goto L_0x006c
        int r7 = r9.appVersion     // Catch:{ all -> 0x009a }
        java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x009a }
        boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x009a }
        if (r4 == 0) goto L_0x006c
        int r4 = r9.valueCount     // Catch:{ all -> 0x009a }
        java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x009a }
        boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009a }
        if (r4 == 0) goto L_0x006c
        java.lang.String r4 = ""
        boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x009a }
        if (r4 == 0) goto L_0x006c
        r0 = 0
    L_0x0055:
        java.lang.String r2 = r1.readLine()     // Catch:{ EOFException -> 0x005f }
        r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005f }
        int r0 = r0 + 1
        goto L_0x0055
    L_0x005f:
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r2 = r9.lruEntries     // Catch:{ all -> 0x009a }
        int r2 = r2.size()     // Catch:{ all -> 0x009a }
        int r0 = r0 - r2
        r9.redundantOpCount = r0     // Catch:{ all -> 0x009a }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.Util.closeQuietly(r1)
        return
    L_0x006c:
        java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x009a }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
        r7.<init>()     // Catch:{ all -> 0x009a }
        java.lang.String r8 = "unexpected journal header: ["
        r7.append(r8)     // Catch:{ all -> 0x009a }
        r7.append(r2)     // Catch:{ all -> 0x009a }
        r7.append(r0)     // Catch:{ all -> 0x009a }
        r7.append(r3)     // Catch:{ all -> 0x009a }
        r7.append(r0)     // Catch:{ all -> 0x009a }
        r7.append(r5)     // Catch:{ all -> 0x009a }
        r7.append(r0)     // Catch:{ all -> 0x009a }
        r7.append(r6)     // Catch:{ all -> 0x009a }
        java.lang.String r0 = "]"
        r7.append(r0)     // Catch:{ all -> 0x009a }
        java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x009a }
        r4.<init>(r0)     // Catch:{ all -> 0x009a }
        throw r4     // Catch:{ all -> 0x009a }
    L_0x009a:
        r0 = move-exception
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.Util.closeQuietly(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        String str3 = "unexpected journal line: ";
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = (Entry) this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                entry.currentEditor = new Editor(entry);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith(READ))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                throw new IOException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(str);
        throw new IOException(sb2.toString());
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private|declared_synchronized */
    public synchronized void rebuildJournal() {
        String sb;
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write(VERSION_1);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DIRTY ");
                    sb2.append(entry.key);
                    sb2.append(10);
                    sb = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("CLEAN ");
                    sb3.append(entry.key);
                    sb3.append(entry.getLengths());
                    sb3.append(10);
                    sb = sb3.toString();
                }
                bufferedWriter.write(sb);
            }
            bufferedWriter.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void renameTo(File file, File file2, boolean z) {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void trimToFileCount() {
        while (this.fileCount > this.maxFileCount) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    /* access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder();
            sb.append("keys must match regex [a-z0-9_-]{1,64}: \"");
            sb.append(str);
            sb.append("\"");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public synchronized void close() {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            trimToFileCount();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    public void delete() {
        close();
        Util.deleteContents(this.directory);
    }

    public Editor edit(String str) {
        return edit(str, -1);
    }

    public synchronized long fileCount() {
        return (long) this.fileCount;
    }

    public synchronized void flush() {
        checkNotClosed();
        trimToSize();
        trimToFileCount();
        this.journalWriter.flush();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r12.redundantOpCount++;
            r1 = r12.journalWriter;
            r2 = new java.lang.StringBuilder();
            r2.append("READ ");
            r2.append(r13);
            r2.append(10);
            r1.append(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
            if (journalRebuildRequired() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
            r12.executorService.submit(r12.cleanupCallable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
            r3 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Snapshot(r12, r13, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Entry.access$1300(r0), r8, r9, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Entry.access$1100(r0), null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
            return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
            return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007b */
    public synchronized com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Snapshot get(java.lang.String r13) {
        /*
        r12 = this;
        monitor-enter(r12)
        r12.checkNotClosed()     // Catch:{ all -> 0x008d }
        r12.validateKey(r13)     // Catch:{ all -> 0x008d }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r12.lruEntries     // Catch:{ all -> 0x008d }
        java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x008d }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = (com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0     // Catch:{ all -> 0x008d }
        r1 = 0
        if (r0 != 0) goto L_0x0014
        monitor-exit(r12)
        return r1
    L_0x0014:
        boolean r2 = r0.readable     // Catch:{ all -> 0x008d }
        if (r2 != 0) goto L_0x001c
        monitor-exit(r12)
        return r1
    L_0x001c:
        int r2 = r12.valueCount     // Catch:{ all -> 0x008d }
        java.io.File[] r8 = new java.io.File[r2]     // Catch:{ all -> 0x008d }
        int r2 = r12.valueCount     // Catch:{ all -> 0x008d }
        java.io.InputStream[] r9 = new java.io.InputStream[r2]     // Catch:{ all -> 0x008d }
        r2 = 0
        r3 = 0
    L_0x0026:
        int r4 = r12.valueCount     // Catch:{ FileNotFoundException -> 0x007b }
        if (r3 >= r4) goto L_0x003a
        java.io.File r4 = r0.getCleanFile(r3)     // Catch:{ FileNotFoundException -> 0x007b }
        r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x007b }
        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007b }
        r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x007b }
        r9[r3] = r5     // Catch:{ FileNotFoundException -> 0x007b }
        int r3 = r3 + 1
        goto L_0x0026
    L_0x003a:
        int r1 = r12.redundantOpCount     // Catch:{ all -> 0x008d }
        int r1 = r1 + 1
        r12.redundantOpCount = r1     // Catch:{ all -> 0x008d }
        java.io.Writer r1 = r12.journalWriter     // Catch:{ all -> 0x008d }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
        r2.<init>()     // Catch:{ all -> 0x008d }
        java.lang.String r3 = "READ "
        r2.append(r3)     // Catch:{ all -> 0x008d }
        r2.append(r13)     // Catch:{ all -> 0x008d }
        r3 = 10
        r2.append(r3)     // Catch:{ all -> 0x008d }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008d }
        r1.append(r2)     // Catch:{ all -> 0x008d }
        boolean r1 = r12.journalRebuildRequired()     // Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0068
        java.util.concurrent.ThreadPoolExecutor r1 = r12.executorService     // Catch:{ all -> 0x008d }
        java.util.concurrent.Callable<java.lang.Void> r2 = r12.cleanupCallable     // Catch:{ all -> 0x008d }
        r1.submit(r2)     // Catch:{ all -> 0x008d }
    L_0x0068:
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot r1 = new com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot     // Catch:{ all -> 0x008d }
        long r6 = r0.sequenceNumber     // Catch:{ all -> 0x008d }
        long[] r10 = r0.lengths     // Catch:{ all -> 0x008d }
        r11 = 0
        r3 = r1
        r4 = r12
        r5 = r13
        r3.m48046init(r5, r6, r8, r9, r10)     // Catch:{ all -> 0x008d }
        monitor-exit(r12)
        return r1
    L_0x007b:
        int r13 = r12.valueCount     // Catch:{ all -> 0x008d }
        if (r2 >= r13) goto L_0x008b
        r13 = r9[r2]     // Catch:{ all -> 0x008d }
        if (r13 == 0) goto L_0x008b
        r13 = r9[r2]     // Catch:{ all -> 0x008d }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.Util.closeQuietly(r13)     // Catch:{ all -> 0x008d }
        int r2 = r2 + 1
        goto L_0x007b
    L_0x008b:
        monitor-exit(r12)
        return r1
    L_0x008d:
        r13 = move-exception
        monitor-exit(r12)
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.get(java.lang.String):com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized int getMaxFileCount() {
        return this.maxFileCount;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0097, code lost:
            return false;
     */
    public synchronized boolean remove(java.lang.String r9) {
        /*
        r8 = this;
        monitor-enter(r8)
        r8.checkNotClosed()     // Catch:{ all -> 0x0098 }
        r8.validateKey(r9)     // Catch:{ all -> 0x0098 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r8.lruEntries     // Catch:{ all -> 0x0098 }
        java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0098 }
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry r0 = (com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0098 }
        r1 = 0
        if (r0 == 0) goto L_0x0096
        com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Editor r2 = r0.currentEditor     // Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x001a
        goto L_0x0096
    L_0x001a:
        int r2 = r8.valueCount     // Catch:{ all -> 0x0098 }
        r3 = 1
        if (r1 >= r2) goto L_0x0062
        java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0098 }
        boolean r4 = r2.exists()     // Catch:{ all -> 0x0098 }
        if (r4 == 0) goto L_0x0047
        boolean r4 = r2.delete()     // Catch:{ all -> 0x0098 }
        if (r4 == 0) goto L_0x0030
        goto L_0x0047
    L_0x0030:
        java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        r0.<init>()     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = "failed to delete "
        r0.append(r1)     // Catch:{ all -> 0x0098 }
        r0.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0098 }
        r9.<init>(r0)     // Catch:{ all -> 0x0098 }
        throw r9     // Catch:{ all -> 0x0098 }
    L_0x0047:
        long r4 = r8.size     // Catch:{ all -> 0x0098 }
        long[] r2 = r0.lengths     // Catch:{ all -> 0x0098 }
        r6 = r2[r1]     // Catch:{ all -> 0x0098 }
        long r4 = r4 - r6
        r8.size = r4     // Catch:{ all -> 0x0098 }
        int r2 = r8.fileCount     // Catch:{ all -> 0x0098 }
        int r2 = r2 - r3
        r8.fileCount = r2     // Catch:{ all -> 0x0098 }
        long[] r2 = r0.lengths     // Catch:{ all -> 0x0098 }
        r3 = 0
        r2[r1] = r3     // Catch:{ all -> 0x0098 }
        int r1 = r1 + 1
        goto L_0x001a
    L_0x0062:
        int r0 = r8.redundantOpCount     // Catch:{ all -> 0x0098 }
        int r0 = r0 + r3
        r8.redundantOpCount = r0     // Catch:{ all -> 0x0098 }
        java.io.Writer r0 = r8.journalWriter     // Catch:{ all -> 0x0098 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
        r1.<init>()     // Catch:{ all -> 0x0098 }
        java.lang.String r2 = "REMOVE "
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        r1.append(r9)     // Catch:{ all -> 0x0098 }
        r2 = 10
        r1.append(r2)     // Catch:{ all -> 0x0098 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0098 }
        r0.append(r1)     // Catch:{ all -> 0x0098 }
        java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache$Entry> r0 = r8.lruEntries     // Catch:{ all -> 0x0098 }
        r0.remove(r9)     // Catch:{ all -> 0x0098 }
        boolean r9 = r8.journalRebuildRequired()     // Catch:{ all -> 0x0098 }
        if (r9 == 0) goto L_0x0094
        java.util.concurrent.ThreadPoolExecutor r9 = r8.executorService     // Catch:{ all -> 0x0098 }
        java.util.concurrent.Callable<java.lang.Void> r0 = r8.cleanupCallable     // Catch:{ all -> 0x0098 }
        r9.submit(r0)     // Catch:{ all -> 0x0098 }
    L_0x0094:
        monitor-exit(r8)
        return r3
    L_0x0096:
        monitor-exit(r8)
        return r1
    L_0x0098:
        r9 = move-exception
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }
}
