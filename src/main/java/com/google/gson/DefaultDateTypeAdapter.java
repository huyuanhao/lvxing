package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(str));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, int i) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateInstance(i, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(i));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(Date.class, i, i2);
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Date type must be one of ");
        sb.append(Date.class);
        sb.append(", ");
        sb.append(Timestamp.class);
        sb.append(", or ");
        sb.append(java.sql.Date.class);
        sb.append(" but was ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(((DateFormat) this.dateFormats.get(0)).format(date));
        }
    }

    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Date deserializeToDate = deserializeToDate(jsonReader.nextString());
        Class<? extends Date> cls = this.dateType;
        if (cls == Date.class) {
            return deserializeToDate;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new AssertionError();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r4 = r4;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r4v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v6
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
    /* JADX WARNING: Unknown variable types count: 4 */
    private java.util.Date deserializeToDate(? r4) {
        /*
        r3 = this;
        java.util.List<java.text.DateFormat> r0 = r3.dateFormats
        monitor-enter(r0)
        java.util.List<java.text.DateFormat> r1 = r3.dateFormats     // Catch:{ all -> 0x002e }
        java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x002e }
    L_0x0009:
        boolean r2 = r1.hasNext()     // Catch:{ all -> 0x002e }
        if (r2 == 0) goto L_0x001b
        java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x002e }
        java.text.DateFormat r2 = (java.text.DateFormat) r2     // Catch:{ all -> 0x002e }
        java.util.Date r4 = r2.parse(r4)     // Catch:{ ParseException -> 0x0009 }
        monitor-exit(r0)     // Catch:{ all -> 0x002e }
        return r4
    L_0x001b:
        java.text.ParsePosition r1 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x0027 }
        r2 = 0
        r1.<init>(r2)     // Catch:{ ParseException -> 0x0027 }
        java.util.Date r4 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r4, r1)     // Catch:{ ParseException -> 0x0027 }
        monitor-exit(r0)     // Catch:{ all -> 0x002e }
        return r4
    L_0x0027:
        r1 = move-exception
        com.google.gson.JsonSyntaxException r2 = new com.google.gson.JsonSyntaxException     // Catch:{ all -> 0x002e }
        r2.m44862init(r4, r1)     // Catch:{ all -> 0x002e }
        throw r2     // Catch:{ all -> 0x002e }
    L_0x002e:
        r4 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x002e }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.DefaultDateTypeAdapter.deserializeToDate(java.lang.String):java.util.Date");
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.dateFormats.get(0);
        String str = "DefaultDateTypeAdapter(";
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(((SimpleDateFormat) dateFormat).toPattern());
            sb.append(')');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(dateFormat.getClass().getSimpleName());
        sb2.append(')');
        return sb2.toString();
    }
}
