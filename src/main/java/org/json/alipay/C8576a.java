package org.json.alipay;

import com.tencent.mid.sotrage.StorageInterface;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: org.json.alipay.a */
public class C8576a {
    /* renamed from: a */
    private ArrayList f29202a;

    public C8576a() {
        this.f29202a = new ArrayList();
    }

    public C8576a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.f29202a.add(Array.get(obj, i));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public C8576a(String str) {
        this(new C8579c(str));
    }

    public C8576a(Collection collection) {
        this.f29202a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public C8576a(C8579c cVar) {
        char c;
        Object obj;
        ArrayList arrayList;
        this();
        char c2 = cVar.mo41018c();
        if (c2 == '[') {
            c = ']';
        } else if (c2 == '(') {
            c = ')';
        } else {
            throw cVar.mo41015a("A JSONArray text must start with '['");
        }
        if (cVar.mo41018c() != ']') {
            do {
                cVar.mo41016a();
                char c3 = cVar.mo41018c();
                cVar.mo41016a();
                if (c3 == ',') {
                    arrayList = this.f29202a;
                    obj = null;
                } else {
                    arrayList = this.f29202a;
                    obj = cVar.mo41019d();
                }
                arrayList.add(obj);
                char c4 = cVar.mo41018c();
                if (c4 != ')') {
                    if (c4 != ',' && c4 != ';') {
                        if (c4 != ']') {
                            throw cVar.mo41015a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c != c4) {
                    StringBuilder sb = new StringBuilder("Expected a '");
                    sb.append(new Character(c));
                    sb.append("'");
                    throw cVar.mo41015a(sb.toString());
                }
                return;
            } while (cVar.mo41018c() != ']');
        }
    }

    /* renamed from: a */
    private String m37298a(String str) {
        int size = this.f29202a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(C8577b.m37301a(this.f29202a.get(i)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final int mo41005a() {
        return this.f29202a.size();
    }

    /* renamed from: a */
    public final Object mo41006a(int i) {
        Object obj = (i < 0 || i >= this.f29202a.size()) ? null : this.f29202a.get(i);
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder("JSONArray[");
        sb.append(i);
        sb.append("] not found.");
        throw new JSONException(sb.toString());
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder("[");
            sb.append(m37298a(StorageInterface.KEY_SPLITER));
            sb.append(']');
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
