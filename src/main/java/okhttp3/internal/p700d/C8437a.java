package okhttp3.internal.p700d;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.C8535k;
import okio.C8546q;
import okio.C8547r;

/* compiled from: FileSystem */
/* renamed from: okhttp3.internal.d.a */
public interface C8437a {
    /* renamed from: a */
    public static final C8437a f28620a = new C8437a() {
        /* renamed from: a */
        public C8547r mo40312a(File file) throws FileNotFoundException {
            return C8535k.m36854a(file);
        }

        /* JADX WARNING: type inference failed for: r2v1, types: [java.io.File] */
        /* JADX WARNING: type inference failed for: r2v4 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: b */
        public okio.C8546q mo40314b(java.io.File r2) throws java.io.FileNotFoundException {
            /*
            r1 = this;
            okio.q r2 = okio.C8535k.m36858b(r2)     // Catch:{ FileNotFoundException -> 0x0005 }
            return r2
        L_0x0005:
            java.io.File r0 = r2.getParentFile()
            r0.mkdirs()
            okio.q r2 = okio.C8535k.m36858b(r2)
            return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p700d.C8437a.C84381.mo40314b(java.io.File):okio.q");
        }

        /* JADX WARNING: type inference failed for: r2v1, types: [java.io.File] */
        /* JADX WARNING: type inference failed for: r2v4 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: c */
        public okio.C8546q mo40315c(java.io.File r2) throws java.io.FileNotFoundException {
            /*
            r1 = this;
            okio.q r2 = okio.C8535k.m36861c(r2)     // Catch:{ FileNotFoundException -> 0x0005 }
            return r2
        L_0x0005:
            java.io.File r0 = r2.getParentFile()
            r0.mkdirs()
            okio.q r2 = okio.C8535k.m36861c(r2)
            return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p700d.C8437a.C84381.mo40315c(java.io.File):okio.q");
        }

        /* renamed from: d */
        public void mo40316d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to delete ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
        }

        /* renamed from: e */
        public boolean mo40317e(File file) {
            return file.exists();
        }

        /* renamed from: f */
        public long mo40318f(File file) {
            return file.length();
        }

        /* renamed from: a */
        public void mo40313a(File file, File file2) throws IOException {
            mo40316d(file2);
            if (!file.renameTo(file2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to rename ");
                sb.append(file);
                sb.append(" to ");
                sb.append(file2);
                throw new IOException(sb.toString());
            }
        }

        /* renamed from: g */
        public void mo40319g(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        mo40319g(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(file2);
                        throw new IOException(sb.toString());
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not a readable directory: ");
            sb2.append(file);
            throw new IOException(sb2.toString());
        }
    };

    /* renamed from: a */
    C8547r mo40312a(File file) throws FileNotFoundException;

    /* renamed from: a */
    void mo40313a(File file, File file2) throws IOException;

    /* renamed from: b */
    C8546q mo40314b(File file) throws FileNotFoundException;

    /* renamed from: c */
    C8546q mo40315c(File file) throws FileNotFoundException;

    /* renamed from: d */
    void mo40316d(File file) throws IOException;

    /* renamed from: e */
    boolean mo40317e(File file);

    /* renamed from: f */
    long mo40318f(File file);

    /* renamed from: g */
    void mo40319g(File file) throws IOException;
}
