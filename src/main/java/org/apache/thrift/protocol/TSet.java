package org.apache.thrift.protocol;

/* renamed from: org.apache.thrift.protocol.h */
public final class TSet {
    /* renamed from: a */
    public final byte f29159a;
    /* renamed from: b */
    public final int f29160b;

    public TSet() {
        this(0, 0);
    }

    public TSet(byte b, int i) {
        this.f29159a = b;
        this.f29160b = i;
    }

    public TSet(TList cVar) {
        this(cVar.f29149a, cVar.f29150b);
    }
}
