package org.apache.thrift.protocol;

import org.apache.thrift.TException;

/* renamed from: org.apache.thrift.protocol.g */
public class TProtocolUtil {
    /* renamed from: a */
    private static int f29158a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m37231a(TProtocol fVar, byte b) throws TException {
        m37232a(fVar, b, f29158a);
    }

    /* renamed from: a */
    public static void m37232a(TProtocol fVar, byte b, int i) throws TException {
        int i2;
        if (i > 0) {
            int i3 = 0;
            switch (b) {
                case 2:
                    fVar.mo40916r();
                    return;
                case 3:
                    fVar.mo40917s();
                    return;
                case 4:
                    fVar.mo40921w();
                    return;
                case 6:
                    fVar.mo40918t();
                    return;
                case 8:
                    fVar.mo40919u();
                    return;
                case 10:
                    fVar.mo40920v();
                    return;
                case 11:
                    fVar.mo40923y();
                    return;
                case 12:
                    fVar.mo40906h();
                    while (true) {
                        TField j = fVar.mo40908j();
                        if (j.f29147b == 0) {
                            fVar.mo40907i();
                            return;
                        } else {
                            m37232a(fVar, j.f29147b, i - 1);
                            fVar.mo40909k();
                        }
                    }
                case 13:
                    TMap l = fVar.mo40910l();
                    while (i2 < l.f29153c) {
                        int i4 = i - 1;
                        m37232a(fVar, l.f29151a, i4);
                        m37232a(fVar, l.f29152b, i4);
                        i2++;
                    }
                    fVar.mo40911m();
                    return;
                case 14:
                    TSet p = fVar.mo40914p();
                    while (i3 < p.f29160b) {
                        m37232a(fVar, p.f29159a, i - 1);
                        i3++;
                    }
                    fVar.mo40915q();
                    return;
                case 15:
                    TList n = fVar.mo40912n();
                    while (i3 < n.f29150b) {
                        m37232a(fVar, n.f29149a, i - 1);
                        i3++;
                    }
                    fVar.mo40913o();
                    return;
                default:
                    return;
            }
        } else {
            throw new TException("Maximum skip depth exceeded");
        }
    }
}
