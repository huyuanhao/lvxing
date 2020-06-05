package org.apache.thrift.protocol;

/* renamed from: org.apache.thrift.protocol.e */
public final class TMessage {
    /* renamed from: a */
    public final String f29154a;
    /* renamed from: b */
    public final byte f29155b;
    /* renamed from: c */
    public final int f29156c;

    public TMessage() {
        this("", 0, 0);
    }

    public TMessage(String str, byte b, int i) {
        this.f29154a = str;
        this.f29155b = b;
        this.f29156c = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<TMessage name:'");
        sb.append(this.f29154a);
        sb.append("' type: ");
        sb.append(this.f29155b);
        sb.append(" seqid:");
        sb.append(this.f29156c);
        sb.append(">");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.f29154a;
        return (((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f29156c) * 31) + this.f29155b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TMessage eVar = (TMessage) obj;
        String str = this.f29154a;
        if (str == null) {
            if (eVar.f29154a != null) {
                return false;
            }
        } else if (!str.equals(eVar.f29154a)) {
            return false;
        }
        return this.f29156c == eVar.f29156c && this.f29155b == eVar.f29155b;
    }
}
