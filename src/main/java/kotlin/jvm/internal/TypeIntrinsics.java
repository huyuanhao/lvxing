package kotlin.jvm.internal;

import kotlin.C8179a;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8248c;
import kotlin.jvm.p679a.C8249d;
import kotlin.jvm.p679a.C8250e;
import kotlin.jvm.p679a.C8251f;
import kotlin.jvm.p679a.C8252g;
import kotlin.jvm.p679a.C8253h;
import kotlin.jvm.p679a.C8254i;
import kotlin.jvm.p679a.C8255j;
import kotlin.jvm.p679a.C8256k;
import kotlin.jvm.p679a.C8257l;
import kotlin.jvm.p679a.C8258m;
import kotlin.jvm.p679a.C8259n;
import kotlin.jvm.p679a.C8260o;
import kotlin.jvm.p679a.C8261p;
import kotlin.jvm.p679a.C8262q;
import kotlin.jvm.p679a.C8263r;
import kotlin.jvm.p679a.C8264s;
import kotlin.jvm.p679a.C8265t;
import kotlin.jvm.p679a.C8266u;
import kotlin.jvm.p679a.C8267v;
import kotlin.jvm.p679a.C8268w;

/* renamed from: kotlin.jvm.internal.m */
public class TypeIntrinsics {
    /* renamed from: a */
    private static <T extends Throwable> T m35414a(T t) {
        return C8271i.m35379a(t, TypeIntrinsics.class.getName());
    }

    /* renamed from: a */
    public static void m35415a(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" cannot be cast to ");
        sb.append(str);
        m35416a(sb.toString());
    }

    /* renamed from: a */
    public static void m35416a(String str) {
        throw m35413a(new ClassCastException(str));
    }

    /* renamed from: a */
    public static ClassCastException m35413a(ClassCastException classCastException) {
        throw ((ClassCastException) m35414a((T) classCastException));
    }

    /* renamed from: a */
    public static int m35412a(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof C8246a) {
            return 0;
        }
        if (obj instanceof C8247b) {
            return 1;
        }
        if (obj instanceof C8258m) {
            return 2;
        }
        if (obj instanceof C8262q) {
            return 3;
        }
        if (obj instanceof C8263r) {
            return 4;
        }
        if (obj instanceof C8264s) {
            return 5;
        }
        if (obj instanceof C8265t) {
            return 6;
        }
        if (obj instanceof C8266u) {
            return 7;
        }
        if (obj instanceof C8267v) {
            return 8;
        }
        if (obj instanceof C8268w) {
            return 9;
        }
        if (obj instanceof C8248c) {
            return 10;
        }
        if (obj instanceof C8249d) {
            return 11;
        }
        if (obj instanceof C8250e) {
            return 12;
        }
        if (obj instanceof C8251f) {
            return 13;
        }
        if (obj instanceof C8252g) {
            return 14;
        }
        if (obj instanceof C8253h) {
            return 15;
        }
        if (obj instanceof C8254i) {
            return 16;
        }
        if (obj instanceof C8255j) {
            return 17;
        }
        if (obj instanceof C8256k) {
            return 18;
        }
        if (obj instanceof C8257l) {
            return 19;
        }
        if (obj instanceof C8259n) {
            return 20;
        }
        if (obj instanceof C8260o) {
            return 21;
        }
        return obj instanceof C8261p ? 22 : -1;
    }

    /* renamed from: a */
    public static boolean m35417a(Object obj, int i) {
        return (obj instanceof C8179a) && m35412a(obj) == i;
    }

    /* renamed from: b */
    public static Object m35418b(Object obj, int i) {
        if (obj != null && !m35417a(obj, i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.functions.Function");
            sb.append(i);
            m35415a(obj, sb.toString());
        }
        return obj;
    }
}
