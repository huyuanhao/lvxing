package org.p703a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: org.a.a */
public class C8551a implements Iterable<Object> {
    /* renamed from: a */
    private final ArrayList<Object> f29060a;

    public C8551a() {
        this.f29060a = new ArrayList<>();
    }

    public C8551a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.f29060a.ensureCapacity(length);
            for (int i = 0; i < length; i++) {
                mo40837a(C8553c.m36953c(Array.get(obj, i)));
            }
            return;
        }
        throw new C8552b("JSONArray initial value should be a string or collection or array.");
    }

    public C8551a(Collection<?> collection) {
        if (collection == null) {
            this.f29060a = new ArrayList<>();
            return;
        }
        this.f29060a = new ArrayList<>(collection.size());
        for (Object c : collection) {
            this.f29060a.add(C8553c.m36953c(c));
        }
    }

    /* renamed from: a */
    public int mo40834a() {
        return this.f29060a.size();
    }

    /* renamed from: a */
    public Writer mo40835a(Writer writer, int i, int i2) {
        int i3;
        try {
            int a = mo40834a();
            writer.write(91);
            i3 = 0;
            if (a == 1) {
                C8553c.m36946a(writer, this.f29060a.get(0), i, i2);
            } else if (a != 0) {
                int i4 = i2 + i;
                boolean z = false;
                while (i3 < a) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    C8553c.m36950a(writer, i4);
                    C8553c.m36946a(writer, this.f29060a.get(i3), i, i4);
                    i3++;
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                C8553c.m36950a(writer, i2);
            }
            writer.write(93);
            return writer;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to write JSONArray value at index: ");
            sb.append(i3);
            throw new C8552b(sb.toString(), e);
        } catch (Exception e2) {
            throw new C8552b("Unable to write JSONArray value at index: 0", e2);
        } catch (IOException e3) {
            throw new C8552b((Throwable) e3);
        }
    }

    /* renamed from: a */
    public String mo40836a(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = mo40835a(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* renamed from: a */
    public C8551a mo40837a(Object obj) {
        this.f29060a.add(obj);
        return this;
    }

    public Iterator<Object> iterator() {
        return this.f29060a.iterator();
    }

    public String toString() {
        try {
            return mo40836a(0);
        } catch (Exception unused) {
            return null;
        }
    }
}
