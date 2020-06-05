package com.qiyukf.nimlib.p451c.p452a;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;

/* renamed from: com.qiyukf.nimlib.c.a.d */
public final class C5736d extends CursorWrapper {
    /* renamed from: a */
    private Cursor f18304a;

    private C5736d(Cursor cursor) {
        super(cursor);
        this.f18304a = cursor;
    }

    /* renamed from: a */
    public static C5736d m23091a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new C5736d(cursor);
    }

    /* renamed from: a */
    private static final boolean m23092a(Exception exc) {
        exc.printStackTrace();
        boolean z = false;
        if (exc instanceof SQLiteException) {
            String message = exc.getMessage();
            if (!TextUtils.isEmpty(message) && message.contains("lock")) {
                z = true;
            }
            if (z) {
                C5264a.m21626e("db", "query locked!");
            }
        }
        return z;
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                this.f18304a.copyStringToBuffer(i, charArrayBuffer);
            } catch (RuntimeException e) {
                if (!m23092a((Exception) e)) {
                    throw e;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int] */
    /* JADX WARNING: type inference failed for: r4v1, types: [int] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r4v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final byte[] getBlob(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        byte[] r4 = r1.getBlob(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = 0
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getBlob(int):byte[]");
    }

    public final int getColumnCount() {
        int i = 0;
        int i2 = 0;
        while (i2 < 3) {
            try {
                i = this.f18304a.getColumnCount();
                return i;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [int] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r4v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final int getColumnIndex(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        int r4 = r1.getColumnIndex(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = -1
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getColumnIndex(java.lang.String):int");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [int] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r4v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final int getColumnIndexOrThrow(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        int r4 = r1.getColumnIndexOrThrow(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = -1
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getColumnIndexOrThrow(java.lang.String):int");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int] */
    /* JADX WARNING: type inference failed for: r4v1, types: [int] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r4v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final java.lang.String getColumnName(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        java.lang.String r4 = r1.getColumnName(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = 0
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getColumnName(int):java.lang.String");
    }

    public final String[] getColumnNames() {
        int i;
        int i2 = 0;
        while (i2 < 3) {
            try {
                i = i2;
                String[] columnNames = this.f18304a.getColumnNames();
                i = columnNames;
                return columnNames;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i2 = i + 1;
                } else {
                    throw e;
                }
            }
        }
        return null;
    }

    public final int getCount() {
        int i = 0;
        int i2 = 0;
        while (i2 < 3) {
            try {
                i = this.f18304a.getCount();
                return i;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i2++;
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                C5264a.m21622c("LockSafeCursor getCount", e2.toString());
            }
        }
        return i;
    }

    public final double getDouble(int i) {
        int i2;
        int i3 = 0;
        while (i3 < 3) {
            try {
                i2 = i3;
                double d = this.f18304a.getDouble(i);
                i2 = d;
                return d;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i3 = i2 + 1;
                } else {
                    throw e;
                }
            }
        }
        return 0.0d;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int] */
    /* JADX WARNING: type inference failed for: r4v1, types: [int] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [float] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r4v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final float getFloat(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        float r4 = r1.getFloat(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = 0
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getFloat(int):float");
    }

    public final int getInt(int i) {
        int i2 = 0;
        while (i2 < 3) {
            try {
                i = this.f18304a.getInt(i);
                return i;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final long getLong(int i) {
        int i2;
        int i3 = 0;
        while (i3 < 3) {
            try {
                i2 = i3;
                long j = this.f18304a.getLong(i);
                i2 = j;
                return j;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i3 = i2 + 1;
                } else {
                    throw e;
                }
            }
        }
        return 0;
    }

    public final int getPosition() {
        int i = 0;
        int i2 = 0;
        while (i2 < 3) {
            try {
                i = this.f18304a.getPosition();
                return i;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i2++;
                } else {
                    throw e;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [int] */
    /* JADX WARNING: type inference failed for: r5v1, types: [int] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [short] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r5v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final short getShort(? r5) {
        /*
        r4 = this;
        r0 = 0
        r1 = 0
    L_0x0002:
        r2 = 3
        if (r1 >= r2) goto L_0x0017
        android.database.Cursor r2 = r4.f18304a     // Catch:{ RuntimeException -> 0x000c }
        short r5 = r2.getShort(r5)     // Catch:{ RuntimeException -> 0x000c }
        return r5
    L_0x000c:
        r2 = move-exception
        boolean r3 = m23092a(r2)
        if (r3 == 0) goto L_0x0016
        int r1 = r1 + 1
        goto L_0x0002
    L_0x0016:
        throw r2
    L_0x0017:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getShort(int):short");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int] */
    /* JADX WARNING: type inference failed for: r4v1, types: [int] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r4v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v3
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final java.lang.String getString(? r4) {
        /*
        r3 = this;
        r0 = 0
    L_0x0001:
        r1 = 3
        if (r0 >= r1) goto L_0x0016
        android.database.Cursor r1 = r3.f18304a     // Catch:{ RuntimeException -> 0x000b }
        java.lang.String r4 = r1.getString(r4)     // Catch:{ RuntimeException -> 0x000b }
        return r4
    L_0x000b:
        r1 = move-exception
        boolean r2 = m23092a(r1)
        if (r2 == 0) goto L_0x0015
        int r0 = r0 + 1
        goto L_0x0001
    L_0x0015:
        throw r1
    L_0x0016:
        r4 = 0
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.getString(int):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [int] */
    /* JADX WARNING: type inference failed for: r5v1, types: [int] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r5v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final boolean move(? r5) {
        /*
        r4 = this;
        r0 = 0
        r1 = 0
    L_0x0002:
        r2 = 3
        if (r1 >= r2) goto L_0x0017
        android.database.Cursor r2 = r4.f18304a     // Catch:{ RuntimeException -> 0x000c }
        boolean r5 = r2.move(r5)     // Catch:{ RuntimeException -> 0x000c }
        return r5
    L_0x000c:
        r2 = move-exception
        boolean r3 = m23092a(r2)
        if (r3 == 0) goto L_0x0016
        int r1 = r1 + 1
        goto L_0x0002
    L_0x0016:
        throw r2
    L_0x0017:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.move(int):boolean");
    }

    public final boolean moveToFirst() {
        boolean z = false;
        int i = 0;
        while (i < 3) {
            try {
                z = this.f18304a.moveToFirst();
                return z;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return z;
    }

    public final boolean moveToLast() {
        boolean z = false;
        int i = 0;
        while (i < 3) {
            try {
                z = this.f18304a.moveToLast();
                return z;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return z;
    }

    public final boolean moveToNext() {
        boolean z = false;
        int i = 0;
        while (i < 3) {
            try {
                z = this.f18304a.moveToNext();
                return z;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [int] */
    /* JADX WARNING: type inference failed for: r5v1, types: [int] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r5v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v2
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
    /* JADX WARNING: Unknown variable types count: 4 */
    public final boolean moveToPosition(? r5) {
        /*
        r4 = this;
        r0 = 0
        r1 = 0
    L_0x0002:
        r2 = 3
        if (r1 >= r2) goto L_0x0017
        android.database.Cursor r2 = r4.f18304a     // Catch:{ RuntimeException -> 0x000c }
        boolean r5 = r2.moveToPosition(r5)     // Catch:{ RuntimeException -> 0x000c }
        return r5
    L_0x000c:
        r2 = move-exception
        boolean r3 = m23092a(r2)
        if (r3 == 0) goto L_0x0016
        int r1 = r1 + 1
        goto L_0x0002
    L_0x0016:
        throw r2
    L_0x0017:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p451c.p452a.C5736d.moveToPosition(int):boolean");
    }

    public final boolean moveToPrevious() {
        boolean z = false;
        int i = 0;
        while (i < 3) {
            try {
                z = this.f18304a.moveToPrevious();
                return z;
            } catch (RuntimeException e) {
                if (m23092a((Exception) e)) {
                    i++;
                } else {
                    throw e;
                }
            }
        }
        return z;
    }
}
