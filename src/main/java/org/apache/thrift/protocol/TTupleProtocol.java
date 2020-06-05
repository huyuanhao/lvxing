package org.apache.thrift.protocol;

import java.util.BitSet;
import org.apache.thrift.TException;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.transport.TTransport;

public final class TTupleProtocol extends TCompactProtocol {

    /* renamed from: org.apache.thrift.protocol.TTupleProtocol$Factory */
    public static class Factory implements TProtocolFactory {
        public TProtocol getProtocol(TTransport fVar) {
            return new TTupleProtocol(fVar);
        }
    }

    public TTupleProtocol(TTransport fVar) {
        super(fVar);
    }

    /* renamed from: C */
    public Class<? extends IScheme> mo40942C() {
        return TupleScheme.class;
    }

    /* renamed from: a */
    public void mo40943a(BitSet bitSet, int i) throws TException {
        for (byte a : m37192b(bitSet, i)) {
            mo40925a(a);
        }
    }

    /* renamed from: b */
    public BitSet mo40944b(int i) throws TException {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo40917s();
        }
        return m37191a(bArr);
    }

    /* renamed from: a */
    public static BitSet m37191a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m37192b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }
}
