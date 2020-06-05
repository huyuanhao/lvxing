package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> dateFormats = new ArrayList();

    public DateTypeAdapter() {
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return deserializeToDate(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.util.Date] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r3 = r3;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r3v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v6
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
    private synchronized java.util.Date deserializeToDate(? r3) {
        /*
        r2 = this;
        monitor-enter(r2)
        java.util.List<java.text.DateFormat> r0 = r2.dateFormats     // Catch:{ all -> 0x002c }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002c }
    L_0x0007:
        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x0019
        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002c }
        java.text.DateFormat r1 = (java.text.DateFormat) r1     // Catch:{ all -> 0x002c }
        java.util.Date r3 = r1.parse(r3)     // Catch:{ ParseException -> 0x0007 }
        monitor-exit(r2)
        return r3
    L_0x0019:
        java.text.ParsePosition r0 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x0025 }
        r1 = 0
        r0.<init>(r1)     // Catch:{ ParseException -> 0x0025 }
        java.util.Date r3 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r3, r0)     // Catch:{ ParseException -> 0x0025 }
        monitor-exit(r2)
        return r3
    L_0x0025:
        r0 = move-exception
        com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException     // Catch:{ all -> 0x002c }
        r1.m44862init(r3, r0)     // Catch:{ all -> 0x002c }
        throw r1     // Catch:{ all -> 0x002c }
    L_0x002c:
        r3 = move-exception
        monitor-exit(r2)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.DateTypeAdapter.deserializeToDate(java.lang.String):java.util.Date");
    }

    public synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(((DateFormat) this.dateFormats.get(0)).format(date));
        }
    }
}
