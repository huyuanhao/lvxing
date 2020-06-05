package com.p570ta.utdid2.p574c.p575a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.p570ta.utdid2.p572b.p573a.C6804i;
import com.p570ta.utdid2.p574c.p575a.MySharedPreferences.C6805a;
import java.io.File;
import java.util.Map.Entry;

/* renamed from: com.ta.utdid2.c.a.c */
public class PersistentConfiguration {
    /* renamed from: a */
    private Editor f22514a;
    /* renamed from: a */
    private SharedPreferences f22515a;
    /* renamed from: a */
    private C6805a f22516a;
    /* renamed from: a */
    private MySharedPreferences f22517a;
    /* renamed from: a */
    private TransactionXMLFile f22518a;
    /* renamed from: e */
    private String f22519e;
    /* renamed from: f */
    private String f22520f;
    /* renamed from: g */
    private boolean f22521g = false;
    /* renamed from: h */
    private boolean f22522h = false;
    /* renamed from: i */
    private boolean f22523i = false;
    /* renamed from: j */
    private boolean f22524j;
    private Context mContext;

    /* JADX WARNING: Removed duplicated region for block: B:81:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x017b A[Catch:{ Exception -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    public PersistentConfiguration(android.content.Context r10, java.lang.String r11, java.lang.String r12, boolean r13, boolean r14) {
        /*
        r9 = this;
        r9.<init>()
        java.lang.String r0 = ""
        r9.f22519e = r0
        r9.f22520f = r0
        r0 = 0
        r9.f22521g = r0
        r9.f22522h = r0
        r9.f22523i = r0
        r1 = 0
        r9.f22515a = r1
        r9.f22517a = r1
        r9.f22514a = r1
        r9.f22516a = r1
        r9.mContext = r1
        r9.f22518a = r1
        r9.f22524j = r0
        r9.f22521g = r13
        r9.f22524j = r14
        r9.f22519e = r12
        r9.f22520f = r11
        r9.mContext = r10
        java.lang.String r13 = "t"
        r2 = 0
        if (r10 == 0) goto L_0x003c
        android.content.SharedPreferences r4 = r10.getSharedPreferences(r12, r0)
        r9.f22515a = r4
        android.content.SharedPreferences r4 = r9.f22515a
        long r4 = r4.getLong(r13, r2)
        goto L_0x003d
    L_0x003c:
        r4 = r2
    L_0x003d:
        java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0042 }
        goto L_0x0046
    L_0x0042:
        r6 = move-exception
        r6.printStackTrace()
    L_0x0046:
        boolean r6 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r1)
        if (r6 == 0) goto L_0x0051
        r9.f22523i = r0
        r9.f22522h = r0
        goto L_0x0070
    L_0x0051:
        java.lang.String r6 = "mounted"
        boolean r6 = r1.equals(r6)
        r7 = 1
        if (r6 == 0) goto L_0x005f
        r9.f22523i = r7
        r9.f22522h = r7
        goto L_0x0070
    L_0x005f:
        java.lang.String r6 = "mounted_ro"
        boolean r1 = r1.equals(r6)
        if (r1 == 0) goto L_0x006c
        r9.f22522h = r7
        r9.f22523i = r0
        goto L_0x0070
    L_0x006c:
        r9.f22523i = r0
        r9.f22522h = r0
    L_0x0070:
        boolean r1 = r9.f22522h
        java.lang.String r6 = "t2"
        if (r1 != 0) goto L_0x007a
        boolean r1 = r9.f22523i
        if (r1 == 0) goto L_0x014a
    L_0x007a:
        if (r10 == 0) goto L_0x014a
        boolean r1 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r11)
        if (r1 != 0) goto L_0x014a
        com.ta.utdid2.c.a.d r11 = r9.m29050a(r11)
        r9.f22518a = r11
        com.ta.utdid2.c.a.d r11 = r9.f22518a
        if (r11 == 0) goto L_0x014a
        com.ta.utdid2.c.a.b r11 = r11.mo32699a(r12, r0)     // Catch:{ Exception -> 0x014a }
        r9.f22517a = r11     // Catch:{ Exception -> 0x014a }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x014a }
        long r7 = r11.getLong(r13, r2)     // Catch:{ Exception -> 0x014a }
        if (r14 != 0) goto L_0x00d2
        int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
        if (r11 <= 0) goto L_0x00ae
        android.content.SharedPreferences r10 = r9.f22515a     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00cf }
        r9.m29052a(r10, r11)     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.d r10 = r9.f22518a     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.b r10 = r10.mo32699a(r12, r0)     // Catch:{ Exception -> 0x00cf }
        r9.f22517a = r10     // Catch:{ Exception -> 0x00cf }
        goto L_0x00cf
    L_0x00ae:
        if (r11 >= 0) goto L_0x00be
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00cf }
        android.content.SharedPreferences r13 = r9.f22515a     // Catch:{ Exception -> 0x00cf }
        r9.m29053a(r11, r13)     // Catch:{ Exception -> 0x00cf }
        android.content.SharedPreferences r10 = r10.getSharedPreferences(r12, r0)     // Catch:{ Exception -> 0x00cf }
        r9.f22515a = r10     // Catch:{ Exception -> 0x00cf }
        goto L_0x00cf
    L_0x00be:
        if (r11 != 0) goto L_0x00cf
        android.content.SharedPreferences r10 = r9.f22515a     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00cf }
        r9.m29052a(r10, r11)     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.d r10 = r9.f22518a     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.b r10 = r10.mo32699a(r12, r0)     // Catch:{ Exception -> 0x00cf }
        r9.f22517a = r10     // Catch:{ Exception -> 0x00cf }
    L_0x00cf:
        r13 = r7
        goto L_0x014b
    L_0x00d2:
        android.content.SharedPreferences r11 = r9.f22515a     // Catch:{ Exception -> 0x00cf }
        long r4 = r11.getLong(r6, r2)     // Catch:{ Exception -> 0x00cf }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00cf }
        long r13 = r11.getLong(r6, r2)     // Catch:{ Exception -> 0x00cf }
        int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
        if (r11 >= 0) goto L_0x00f8
        int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r1 <= 0) goto L_0x00f8
        android.content.SharedPreferences r10 = r9.f22515a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00f6 }
        r9.m29052a(r10, r11)     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.d r10 = r9.f22518a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r10 = r10.mo32699a(r12, r0)     // Catch:{ Exception -> 0x00f6 }
        r9.f22517a = r10     // Catch:{ Exception -> 0x00f6 }
        goto L_0x014b
        goto L_0x014b
    L_0x00f8:
        if (r11 <= 0) goto L_0x010c
        int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
        if (r1 <= 0) goto L_0x010c
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00f6 }
        android.content.SharedPreferences r1 = r9.f22515a     // Catch:{ Exception -> 0x00f6 }
        r9.m29053a(r11, r1)     // Catch:{ Exception -> 0x00f6 }
        android.content.SharedPreferences r10 = r10.getSharedPreferences(r12, r0)     // Catch:{ Exception -> 0x00f6 }
        r9.f22515a = r10     // Catch:{ Exception -> 0x00f6 }
        goto L_0x014b
    L_0x010c:
        int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r1 != 0) goto L_0x0122
        int r7 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
        if (r7 <= 0) goto L_0x0122
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00f6 }
        android.content.SharedPreferences r1 = r9.f22515a     // Catch:{ Exception -> 0x00f6 }
        r9.m29053a(r11, r1)     // Catch:{ Exception -> 0x00f6 }
        android.content.SharedPreferences r10 = r10.getSharedPreferences(r12, r0)     // Catch:{ Exception -> 0x00f6 }
        r9.f22515a = r10     // Catch:{ Exception -> 0x00f6 }
        goto L_0x014b
    L_0x0122:
        int r10 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
        if (r10 != 0) goto L_0x0138
        if (r1 <= 0) goto L_0x0138
        android.content.SharedPreferences r10 = r9.f22515a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00f6 }
        r9.m29052a(r10, r11)     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.d r10 = r9.f22518a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r10 = r10.mo32699a(r12, r0)     // Catch:{ Exception -> 0x00f6 }
        r9.f22517a = r10     // Catch:{ Exception -> 0x00f6 }
        goto L_0x014b
    L_0x0138:
        if (r11 != 0) goto L_0x014b
        android.content.SharedPreferences r10 = r9.f22515a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r11 = r9.f22517a     // Catch:{ Exception -> 0x00f6 }
        r9.m29052a(r10, r11)     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.d r10 = r9.f22518a     // Catch:{ Exception -> 0x00f6 }
        com.ta.utdid2.c.a.b r10 = r10.mo32699a(r12, r0)     // Catch:{ Exception -> 0x00f6 }
        r9.f22517a = r10     // Catch:{ Exception -> 0x00f6 }
        goto L_0x014b
    L_0x014a:
        r13 = r2
    L_0x014b:
        int r10 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
        if (r10 != 0) goto L_0x0157
        int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r10 != 0) goto L_0x0187
        int r10 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
        if (r10 != 0) goto L_0x0187
    L_0x0157:
        long r10 = java.lang.System.currentTimeMillis()
        boolean r12 = r9.f22524j
        if (r12 == 0) goto L_0x0169
        if (r12 == 0) goto L_0x0187
        int r12 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
        if (r12 != 0) goto L_0x0187
        int r12 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
        if (r12 != 0) goto L_0x0187
    L_0x0169:
        android.content.SharedPreferences r12 = r9.f22515a
        if (r12 == 0) goto L_0x0177
        android.content.SharedPreferences$Editor r12 = r12.edit()
        r12.putLong(r6, r10)
        r12.commit()
    L_0x0177:
        com.ta.utdid2.c.a.b r12 = r9.f22517a     // Catch:{ Exception -> 0x0187 }
        if (r12 == 0) goto L_0x0187
        com.ta.utdid2.c.a.b r12 = r9.f22517a     // Catch:{ Exception -> 0x0187 }
        com.ta.utdid2.c.a.b$a r12 = r12.mo32682a()     // Catch:{ Exception -> 0x0187 }
        r12.mo32689a(r6, r10)     // Catch:{ Exception -> 0x0187 }
        r12.commit()     // Catch:{ Exception -> 0x0187 }
    L_0x0187:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p574c.p575a.PersistentConfiguration.m51742init(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    /* renamed from: a */
    private TransactionXMLFile m29050a(String str) {
        File a = m29050a(str);
        if (a == null) {
            return null;
        }
        this.f22518a = new TransactionXMLFile(a.getAbsolutePath());
        return this.f22518a;
    }

    /* renamed from: a */
    private File m29051a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{externalStorageDirectory.getAbsolutePath(), File.separator, str}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    private void m29052a(SharedPreferences sharedPreferences, MySharedPreferences bVar) {
        if (sharedPreferences != null && bVar != null) {
            C6805a a = bVar.mo32682a();
            if (a != null) {
                a.mo32692b();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        a.mo32690a(str, (String) value);
                    } else if (value instanceof Integer) {
                        a.mo32688a(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        a.mo32689a(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        a.mo32687a(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        a.mo32691a(str, ((Boolean) value).booleanValue());
                    }
                }
                a.commit();
            }
        }
    }

    /* renamed from: a */
    private void m29053a(MySharedPreferences bVar, SharedPreferences sharedPreferences) {
        if (bVar != null && sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.clear();
                for (Entry entry : bVar.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        edit.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                edit.commit();
            }
        }
    }

    /* renamed from: b */
    private boolean m29054b() {
        MySharedPreferences bVar = this.f22517a;
        if (bVar == null) {
            return false;
        }
        boolean a = bVar.mo32682a();
        if (!a) {
            commit();
        }
        return a;
    }

    /* renamed from: c */
    private void m29055c() {
        if (this.f22514a == null) {
            SharedPreferences sharedPreferences = this.f22515a;
            if (sharedPreferences != null) {
                this.f22514a = sharedPreferences.edit();
            }
        }
        if (this.f22523i && this.f22516a == null) {
            MySharedPreferences bVar = this.f22517a;
            if (bVar != null) {
                this.f22516a = bVar.mo32682a();
            }
        }
        m29054b();
    }

    public void putString(String str, String str2) {
        if (!C6804i.m29033a(str) && !str.equals("t")) {
            m29055c();
            Editor editor = this.f22514a;
            if (editor != null) {
                editor.putString(str, str2);
            }
            C6805a aVar = this.f22516a;
            if (aVar != null) {
                aVar.mo32690a(str, str2);
            }
        }
    }

    public void remove(String str) {
        if (!C6804i.m29033a(str) && !str.equals("t")) {
            m29055c();
            Editor editor = this.f22514a;
            if (editor != null) {
                editor.remove(str);
            }
            C6805a aVar = this.f22516a;
            if (aVar != null) {
                aVar.mo32686a(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    public boolean commit() {
        /*
        r6 = this;
        long r0 = java.lang.System.currentTimeMillis()
        android.content.SharedPreferences$Editor r2 = r6.f22514a
        r3 = 0
        if (r2 == 0) goto L_0x0020
        boolean r4 = r6.f22524j
        if (r4 != 0) goto L_0x0016
        android.content.SharedPreferences r4 = r6.f22515a
        if (r4 == 0) goto L_0x0016
        java.lang.String r4 = "t"
        r2.putLong(r4, r0)
    L_0x0016:
        android.content.SharedPreferences$Editor r0 = r6.f22514a
        boolean r0 = r0.commit()
        if (r0 != 0) goto L_0x0020
        r0 = 0
        goto L_0x0021
    L_0x0020:
        r0 = 1
    L_0x0021:
        android.content.SharedPreferences r1 = r6.f22515a
        if (r1 == 0) goto L_0x0031
        android.content.Context r1 = r6.mContext
        if (r1 == 0) goto L_0x0031
        java.lang.String r2 = r6.f22519e
        android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
        r6.f22515a = r1
    L_0x0031:
        r1 = 0
        java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0037 }
        goto L_0x003b
    L_0x0037:
        r2 = move-exception
        r2.printStackTrace()
    L_0x003b:
        boolean r2 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r1)
        if (r2 != 0) goto L_0x00a4
        java.lang.String r2 = "mounted"
        boolean r4 = r1.equals(r2)
        if (r4 == 0) goto L_0x0084
        com.ta.utdid2.c.a.b r4 = r6.f22517a
        if (r4 != 0) goto L_0x0079
        java.lang.String r4 = r6.f22520f
        com.ta.utdid2.c.a.d r4 = r6.m29050a(r4)
        if (r4 == 0) goto L_0x0084
        java.lang.String r5 = r6.f22519e
        com.ta.utdid2.c.a.b r4 = r4.mo32699a(r5, r3)
        r6.f22517a = r4
        boolean r4 = r6.f22524j
        if (r4 != 0) goto L_0x0069
        android.content.SharedPreferences r4 = r6.f22515a
        com.ta.utdid2.c.a.b r5 = r6.f22517a
        r6.m29052a(r4, r5)
        goto L_0x0070
    L_0x0069:
        com.ta.utdid2.c.a.b r4 = r6.f22517a
        android.content.SharedPreferences r5 = r6.f22515a
        r6.m29053a(r4, r5)
    L_0x0070:
        com.ta.utdid2.c.a.b r4 = r6.f22517a
        com.ta.utdid2.c.a.b$a r4 = r4.mo32682a()
        r6.f22516a = r4
        goto L_0x0084
    L_0x0079:
        com.ta.utdid2.c.a.b$a r4 = r6.f22516a
        if (r4 == 0) goto L_0x0084
        boolean r4 = r4.commit()
        if (r4 != 0) goto L_0x0084
        r0 = 0
    L_0x0084:
        boolean r2 = r1.equals(r2)
        if (r2 != 0) goto L_0x0096
        java.lang.String r2 = "mounted_ro"
        boolean r1 = r1.equals(r2)
        if (r1 == 0) goto L_0x00a4
        com.ta.utdid2.c.a.b r1 = r6.f22517a
        if (r1 == 0) goto L_0x00a4
    L_0x0096:
        com.ta.utdid2.c.a.d r1 = r6.f22518a     // Catch:{ Exception -> 0x00a4 }
        if (r1 == 0) goto L_0x00a4
        com.ta.utdid2.c.a.d r1 = r6.f22518a     // Catch:{ Exception -> 0x00a4 }
        java.lang.String r2 = r6.f22519e     // Catch:{ Exception -> 0x00a4 }
        com.ta.utdid2.c.a.b r1 = r1.mo32699a(r2, r3)     // Catch:{ Exception -> 0x00a4 }
        r6.f22517a = r1     // Catch:{ Exception -> 0x00a4 }
    L_0x00a4:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p574c.p575a.PersistentConfiguration.commit():boolean");
    }

    public String getString(String str) {
        m29054b();
        SharedPreferences sharedPreferences = this.f22515a;
        String str2 = "";
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, str2);
            if (!C6804i.m29033a(string)) {
                return string;
            }
        }
        MySharedPreferences bVar = this.f22517a;
        return bVar != null ? bVar.getString(str, str2) : str2;
    }
}
