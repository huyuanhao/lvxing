package com.bytedance.sdk.p145a.p147b.p148a.p154f;

import java.io.File;
import java.io.IOException;

/* renamed from: com.bytedance.sdk.a.b.a.f.a */
public interface FileSystem {
    /* renamed from: a */
    public static final FileSystem f5653a = new FileSystem() {
        /* renamed from: a */
        public void mo13865a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to delete ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
        }

        /* renamed from: b */
        public boolean mo13867b(File file) {
            return file.exists();
        }

        /* renamed from: c */
        public long mo13868c(File file) {
            return file.length();
        }

        /* renamed from: a */
        public void mo13866a(File file, File file2) throws IOException {
            mo13865a(file2);
            if (!file.renameTo(file2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to rename ");
                sb.append(file);
                sb.append(" to ");
                sb.append(file2);
                throw new IOException(sb.toString());
            }
        }
    };

    /* renamed from: a */
    void mo13865a(File file) throws IOException;

    /* renamed from: a */
    void mo13866a(File file, File file2) throws IOException;

    /* renamed from: b */
    boolean mo13867b(File file);

    /* renamed from: c */
    long mo13868c(File file);
}
