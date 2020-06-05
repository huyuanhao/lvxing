package com.qiyukf.nimlib.p473h.p481c.p484c;

import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import java.util.Collection;

/* renamed from: com.qiyukf.nimlib.h.c.c.d */
public final class C5896d {
    /* renamed from: a */
    public static C5892b m23615a(C5898f fVar) {
        C5892b bVar = new C5892b();
        fVar.mo28261a((C5891a) bVar);
        return bVar;
    }

    /* renamed from: a */
    public static void m23616a(C5894b bVar, Collection<?> collection) {
        if (collection == null) {
            bVar.mo28255b(0);
            return;
        }
        bVar.mo28255b(collection.size());
        for (Object next : collection) {
            if (next instanceof Integer) {
                bVar.mo28247a(((Integer) next).intValue());
            } else if (next instanceof Short) {
                bVar.mo28252a(((Short) next).shortValue());
            } else if (next instanceof Long) {
                bVar.mo28248a(((Long) next).longValue());
            } else if (next instanceof String) {
                bVar.mo28250a((String) next);
            } else if (next instanceof C5891a) {
                bVar.mo28249a((C5891a) next);
            } else if (next instanceof Collection) {
                m23616a(bVar, (Collection) next);
            } else if (next instanceof byte[]) {
                bVar.mo28257b((byte[]) next);
            } else if (next instanceof Byte) {
                bVar.mo28246a(((Byte) next).byteValue());
            } else {
                StringBuilder sb = new StringBuilder("unmarshallable type: ");
                sb.append(next.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    public static byte[] m23617a(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (true) {
            byte b = (byte) (i % 128);
            i /= 128;
            if (i > 0) {
                b = (byte) (b | Byte.MIN_VALUE);
            }
            int i3 = i2 + 1;
            bArr[i2] = b;
            if (i <= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                return bArr2;
            }
            i2 = i3;
        }
    }

    /* renamed from: b */
    public static int m23618b(int i) {
        int i2 = 0;
        do {
            i /= 128;
            i2++;
        } while (i > 0);
        return i2;
    }
}
