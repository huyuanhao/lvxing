package com.p570ta.utdid2.p574c.p575a;

import com.p570ta.utdid2.p574c.p575a.MySharedPreferences.C6805a;
import com.p570ta.utdid2.p574c.p575a.MySharedPreferences.C6806b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.ta.utdid2.c.a.d */
public class TransactionXMLFile {
    /* renamed from: c */
    private static final Object f22525c = new Object();
    /* renamed from: a */
    private File f22526a;
    /* renamed from: a */
    private HashMap<File, C6807a> f22527a = new HashMap<>();
    /* renamed from: b */
    private final Object f22528b = new Object();

    /* compiled from: TransactionXMLFile */
    /* renamed from: com.ta.utdid2.c.a.d$a */
    private static final class C6807a implements MySharedPreferences {
        /* renamed from: d */
        private static final Object f22529d = new Object();
        /* renamed from: a */
        private WeakHashMap<C6806b, Object> f22530a;
        /* renamed from: b */
        private final File f22531b;
        /* renamed from: c */
        private final int f22532c;
        /* renamed from: c */
        private final File f22533c;
        /* renamed from: c */
        private Map f22534c;
        /* renamed from: k */
        private boolean f22535k = false;

        /* compiled from: TransactionXMLFile */
        /* renamed from: com.ta.utdid2.c.a.d$a$a */
        public final class C6808a implements C6805a {
            /* renamed from: d */
            private final Map<String, Object> f22537d = new HashMap();
            /* renamed from: l */
            private boolean f22538l = false;

            public C6808a() {
            }

            /* renamed from: a */
            public C6805a mo32690a(String str, String str2) {
                synchronized (this) {
                    this.f22537d.put(str, str2);
                }
                return this;
            }

            /* renamed from: a */
            public C6805a mo32688a(String str, int i) {
                synchronized (this) {
                    this.f22537d.put(str, Integer.valueOf(i));
                }
                return this;
            }

            /* renamed from: a */
            public C6805a mo32689a(String str, long j) {
                synchronized (this) {
                    this.f22537d.put(str, Long.valueOf(j));
                }
                return this;
            }

            /* renamed from: a */
            public C6805a mo32687a(String str, float f) {
                synchronized (this) {
                    this.f22537d.put(str, Float.valueOf(f));
                }
                return this;
            }

            /* renamed from: a */
            public C6805a mo32691a(String str, boolean z) {
                synchronized (this) {
                    this.f22537d.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            /* renamed from: a */
            public C6805a mo32686a(String str) {
                synchronized (this) {
                    this.f22537d.put(str, this);
                }
                return this;
            }

            /* renamed from: b */
            public C6805a mo32692b() {
                synchronized (this) {
                    this.f22538l = true;
                }
                return this;
            }

            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                Set<C6806b> set;
                boolean a;
                synchronized (TransactionXMLFile.m29056a()) {
                    z = C6807a.m29064a(C6807a.this).size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        set = new HashSet<>(C6807a.m29064a(C6807a.this).keySet());
                    } else {
                        set = null;
                    }
                    synchronized (this) {
                        if (this.f22538l) {
                            C6807a.m29064a(C6807a.this).clear();
                            this.f22538l = false;
                        }
                        for (Entry entry : this.f22537d.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                C6807a.m29064a(C6807a.this).remove(str);
                            } else {
                                C6807a.m29064a(C6807a.this).put(str, value);
                            }
                            if (z) {
                                arrayList.add(str);
                            }
                        }
                        this.f22537d.clear();
                    }
                    a = C6807a.m29064a(C6807a.this);
                    if (a) {
                        C6807a.this.mo32701a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str2 = (String) arrayList.get(size);
                        for (C6806b bVar : set) {
                            if (bVar != null) {
                                bVar.mo32694a(C6807a.this, str2);
                            }
                        }
                    }
                }
                return a;
            }
        }

        C6807a(File file, int i, Map map) {
            this.f22531b = file;
            this.f22533c = TransactionXMLFile.m29057a(file);
            this.f22532c = i;
            if (map == null) {
                map = new HashMap();
            }
            this.f22534c = map;
            this.f22530a = new WeakHashMap<>();
        }

        /* renamed from: a */
        public boolean m29071a() {
            File file = this.f22531b;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        /* renamed from: a */
        public void mo32701a(boolean z) {
            synchronized (this) {
                this.f22535k = z;
            }
        }

        /* renamed from: c */
        public boolean mo32702c() {
            boolean z;
            synchronized (this) {
                z = this.f22535k;
            }
            return z;
        }

        /* renamed from: a */
        public void mo32700a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f22534c = map;
                }
            }
        }

        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f22534c);
            }
            return hashMap;
        }

        public String getString(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f22534c.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f22534c.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        /* renamed from: a */
        public C6805a mo32682a() {
            return new C6808a();
        }

        /* renamed from: a */
        private FileOutputStream m29063a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    fileOutputStream = null;
                }
            }
            return fileOutputStream;
        }

        /* renamed from: d */
        private boolean m29067d() {
            if (this.f22531b.exists()) {
                if (this.f22533c.exists()) {
                    this.f22531b.delete();
                } else if (!this.f22531b.renameTo(this.f22533c)) {
                    return false;
                }
            }
            try {
                FileOutputStream a = m29063a(this.f22531b);
                if (a == null) {
                    return false;
                }
                XmlUtils.m29086a(this.f22534c, (OutputStream) a);
                a.close();
                this.f22533c.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f22531b.exists()) {
                    this.f22531b.delete();
                }
                return false;
            }
        }
    }

    public TransactionXMLFile(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f22526a = new File(str);
    }

    /* renamed from: a */
    private File m29058a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        StringBuilder sb = new StringBuilder("File ");
        sb.append(str);
        sb.append(" contains a path separator");
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private File m29056a() {
        File file;
        synchronized (this.f22528b) {
            file = this.f22526a;
        }
        return file;
    }

    /* renamed from: b */
    private File m29061b(String str) {
        File a = m29056a();
        StringBuilder sb = new StringBuilder(String.valueOf(str));
        sb.append(".xml");
        return m29058a(a, sb.toString());
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r0v24, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:63|64|(2:81|82)|83|84) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x00e4, code lost:
            r1 = new com.p570ta.utdid2.p574c.p575a.TransactionXMLFile.C6807a(r10, r11, r0);
            r9.f22527a.put(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x00ef, code lost:
            return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            r0 = m29057a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
            if (r0.exists() == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            r10.delete();
            r0.renameTo(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
            if (r10.exists() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            r10.canRead();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
            r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            if (r10.exists() == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            if (r10.canRead() == false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r0 = new java.io.FileInputStream
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
            r2 = r2;
            r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r2 = com.p570ta.utdid2.p574c.p575a.XmlUtils.m29082a(r0);
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r0.close();
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
            r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
            r8 = r2;
            r2 = r0;
            r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
            r8 = r2;
            r2 = r0;
            r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
            r8 = r2;
            r2 = r0;
            r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
            r10 = th;
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006c, code lost:
            if (r2 != 0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0073, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0074, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0078, code lost:
            if (r2 != 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007a, code lost:
            r2 = r2;
            r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007b, code lost:
            r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007c, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007d, code lost:
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0080, code lost:
            if (r2 != 0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0083, code lost:
            r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r3 = new java.io.FileInputStream
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r0 = new byte[r3.available()];
            r3.read(r0);
            new java.lang.String(r0, 0, r0.length, "UTF-8");
            r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a1, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a3, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a5, code lost:
            r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a6, code lost:
            r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a8, code lost:
            r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a9, code lost:
            r8 = r3;
            r3 = r0;
            r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00af, code lost:
            if (r3 != 0) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b1, code lost:
            r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b2, code lost:
            r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b3, code lost:
            r8 = r3;
            r3 = r0;
            r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b6, code lost:
            r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00b9, code lost:
            if (r3 != 0) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00bc, code lost:
            if (r3 != 0) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c2, code lost:
            r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c3, code lost:
            r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00c4, code lost:
            if (r2 != 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00c9, code lost:
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00ca, code lost:
            if (r2 != 0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00cf, code lost:
            throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00d0, code lost:
            r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x00d3, code lost:
            monitor-enter(f22525c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00d4, code lost:
            if (r1 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
            r1.mo32700a((java.util.Map) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00da, code lost:
            r1 = (com.p570ta.utdid2.p574c.p575a.TransactionXMLFile.C6807a) r9.f22527a.get(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x00e2, code lost:
            if (r1 == null) goto L_0x00e4;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x00c9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v4
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007a A[Catch:{ XmlPullParserException -> 0x0083, FileNotFoundException -> 0x007b, IOException -> 0x0073, Exception -> 0x0067, all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00b1 A[Catch:{ FileNotFoundException -> 0x00b2, IOException -> 0x00a8, all -> 0x00a5, all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00be A[SYNTHETIC, Splitter:B:76:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00c6 A[SYNTHETIC, Splitter:B:81:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00d4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0075=Splitter:B:44:0x0075, B:37:0x0069=Splitter:B:37:0x0069, B:83:0x00c9=Splitter:B:83:0x00c9} */
    /* JADX WARNING: Unknown variable types count: 22 */
    /* renamed from: a */
    public com.p570ta.utdid2.p574c.p575a.MySharedPreferences mo32699a(java.lang.String r10, int r11) {
        /*
        r9 = this;
        java.io.File r10 = r9.m29061b(r10)
        java.lang.Object r0 = f22525c
        monitor-enter(r0)
        java.util.HashMap<java.io.File, com.ta.utdid2.c.a.d$a> r1 = r9.f22527a     // Catch:{ all -> 0x00f3 }
        java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x00f3 }
        com.ta.utdid2.c.a.d$a r1 = (com.p570ta.utdid2.p574c.p575a.TransactionXMLFile.C6807a) r1     // Catch:{ all -> 0x00f3 }
        if (r1 == 0) goto L_0x0019
        boolean r2 = r1.mo32702c()     // Catch:{ all -> 0x00f3 }
        if (r2 != 0) goto L_0x0019
        monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
        return r1
    L_0x0019:
        monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
        java.io.File r0 = m29057a(r10)
        boolean r2 = r0.exists()
        if (r2 == 0) goto L_0x002a
        r10.delete()
        r0.renameTo(r10)
    L_0x002a:
        boolean r0 = r10.exists()
        if (r0 == 0) goto L_0x0033
        r10.canRead()
    L_0x0033:
        boolean r0 = r10.exists()
        r2 = 0
        if (r0 == 0) goto L_0x00d0
        boolean r0 = r10.canRead()
        if (r0 == 0) goto L_0x00d0
        java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ XmlPullParserException -> 0x0083, FileNotFoundException -> 0x007b, IOException -> 0x0073, Exception -> 0x0067 }
        r0.<init>(r10)     // Catch:{ XmlPullParserException -> 0x0083, FileNotFoundException -> 0x007b, IOException -> 0x0073, Exception -> 0x0067 }
        java.util.HashMap r2 = com.p570ta.utdid2.p574c.p575a.XmlUtils.m29082a(r0)     // Catch:{ XmlPullParserException -> 0x0084, FileNotFoundException -> 0x005f, IOException -> 0x005a, Exception -> 0x0055, all -> 0x0051 }
        r0.close()     // Catch:{ XmlPullParserException -> 0x0084, FileNotFoundException -> 0x005f, IOException -> 0x005a, Exception -> 0x0055, all -> 0x0051 }
        r0.close()     // Catch:{ all -> 0x00d0 }
        goto L_0x00d0
    L_0x0051:
        r10 = move-exception
        r2 = r0
        goto L_0x00ca
    L_0x0055:
        r3 = move-exception
        r8 = r2
        r2 = r0
        r0 = r8
        goto L_0x0069
    L_0x005a:
        r3 = move-exception
        r8 = r2
        r2 = r0
        r0 = r8
        goto L_0x0075
    L_0x005f:
        r3 = move-exception
        r8 = r2
        r2 = r0
        r0 = r8
        goto L_0x007d
    L_0x0064:
        r10 = move-exception
        goto L_0x00ca
    L_0x0067:
        r3 = move-exception
        r0 = r2
    L_0x0069:
        r3.printStackTrace()     // Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x00d1
    L_0x006e:
        r2.close()     // Catch:{ all -> 0x00d1 }
        goto L_0x00d1
    L_0x0073:
        r3 = move-exception
        r0 = r2
    L_0x0075:
        r3.printStackTrace()     // Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x00d1
        goto L_0x006e
    L_0x007b:
        r3 = move-exception
        r0 = r2
    L_0x007d:
        r3.printStackTrace()     // Catch:{ all -> 0x0064 }
        if (r2 == 0) goto L_0x00d1
        goto L_0x006e
    L_0x0083:
        r0 = r2
    L_0x0084:
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00b2, IOException -> 0x00a8, all -> 0x00a5 }
        r3.<init>(r10)     // Catch:{ FileNotFoundException -> 0x00b2, IOException -> 0x00a8, all -> 0x00a5 }
        int r0 = r3.available()     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
        byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
        r3.read(r0)     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
        java.lang.String r4 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
        r5 = 0
        int r6 = r0.length     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
        java.lang.String r7 = "UTF-8"
        r4.<init>(r0, r5, r6, r7)     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x00a1 }
    L_0x009b:
        r3.close()     // Catch:{ all -> 0x009f }
        goto L_0x00bc
        goto L_0x00bc
    L_0x00a1:
        r0 = move-exception
        goto L_0x00ac
    L_0x00a3:
        r0 = move-exception
        goto L_0x00b6
    L_0x00a5:
        r10 = move-exception
        r2 = r0
        goto L_0x00c4
    L_0x00a8:
        r3 = move-exception
        r8 = r3
        r3 = r0
        r0 = r8
    L_0x00ac:
        r0.printStackTrace()     // Catch:{ all -> 0x00c2 }
        if (r3 == 0) goto L_0x00bc
        goto L_0x009b
    L_0x00b2:
        r3 = move-exception
        r8 = r3
        r3 = r0
        r0 = r8
    L_0x00b6:
        r0.printStackTrace()     // Catch:{ all -> 0x00c2 }
        if (r3 == 0) goto L_0x00bc
        goto L_0x009b
    L_0x00bc:
        if (r3 == 0) goto L_0x00d0
        r3.close()     // Catch:{ all -> 0x00d0 }
        goto L_0x00d0
    L_0x00c2:
        r10 = move-exception
        r2 = r3
    L_0x00c4:
        if (r2 == 0) goto L_0x00c9
        r2.close()     // Catch:{ all -> 0x00c9 }
    L_0x00c9:
        throw r10     // Catch:{ all -> 0x0064 }
    L_0x00ca:
        if (r2 == 0) goto L_0x00cf
        r2.close()     // Catch:{ all -> 0x00cf }
    L_0x00cf:
        throw r10
    L_0x00d0:
        r0 = r2
    L_0x00d1:
        java.lang.Object r2 = f22525c
        monitor-enter(r2)
        if (r1 == 0) goto L_0x00da
        r1.mo32700a(r0)     // Catch:{ all -> 0x00f0 }
        goto L_0x00ee
    L_0x00da:
        java.util.HashMap<java.io.File, com.ta.utdid2.c.a.d$a> r1 = r9.f22527a     // Catch:{ all -> 0x00f0 }
        java.lang.Object r1 = r1.get(r10)     // Catch:{ all -> 0x00f0 }
        com.ta.utdid2.c.a.d$a r1 = (com.p570ta.utdid2.p574c.p575a.TransactionXMLFile.C6807a) r1     // Catch:{ all -> 0x00f0 }
        if (r1 != 0) goto L_0x00ee
        com.ta.utdid2.c.a.d$a r1 = new com.ta.utdid2.c.a.d$a     // Catch:{ all -> 0x00f0 }
        r1.m51746init(r10, r11, r0)     // Catch:{ all -> 0x00f0 }
        java.util.HashMap<java.io.File, com.ta.utdid2.c.a.d$a> r11 = r9.f22527a     // Catch:{ all -> 0x00f0 }
        r11.put(r10, r1)     // Catch:{ all -> 0x00f0 }
    L_0x00ee:
        monitor-exit(r2)     // Catch:{ all -> 0x00f0 }
        return r1
    L_0x00f0:
        r10 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x00f0 }
        throw r10
    L_0x00f3:
        r10 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x00f3 }
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p574c.p575a.TransactionXMLFile.mo32699a(java.lang.String, int):com.ta.utdid2.c.a.b");
    }

    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static File m29057a(File file) {
        StringBuilder sb = new StringBuilder(String.valueOf(file.getPath()));
        sb.append(".bak");
        return new File(sb.toString());
    }
}
