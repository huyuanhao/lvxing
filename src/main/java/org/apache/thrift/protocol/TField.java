package org.apache.thrift.protocol;

/* renamed from: org.apache.thrift.protocol.b */
public class TField {
    /* renamed from: a */
    public final String f29146a;
    /* renamed from: b */
    public final byte f29147b;
    /* renamed from: c */
    public final short f29148c;

    public TField() {
        this("", 0, 0);
    }

    public TField(String str, byte b, short s) {
        this.f29146a = str;
        this.f29147b = b;
        this.f29148c = s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<TField name:'");
        sb.append(this.f29146a);
        sb.append("' type:");
        sb.append(this.f29147b);
        sb.append(" field-id:");
        sb.append(this.f29148c);
        sb.append(">");
        return sb.toString();
    }

    public int hashCode() {
        int i = (this.f29148c + 31) * 31;
        String str = this.f29146a;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.f29147b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TField bVar = (TField) obj;
        if (!(this.f29147b == bVar.f29147b && this.f29148c == bVar.f29148c)) {
            z = false;
        }
        return z;
    }
}
