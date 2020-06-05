package org.apache.thrift;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TUnion;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.p704a.TupleScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

public abstract class TUnion<T extends TUnion<T, F>, F extends TFieldIdEnum> implements TBase<T, F> {
    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap();
    protected F setField_;
    protected Object value_;

    /* renamed from: org.apache.thrift.TUnion$a */
    private static class C8558a extends StandardScheme<TUnion> {
        private C8558a() {
        }

        /* renamed from: a */
        public void read(TProtocol fVar, TUnion tUnion) throws TException {
            tUnion.setField_ = null;
            tUnion.value_ = null;
            fVar.mo40906h();
            TField j = fVar.mo40908j();
            tUnion.value_ = tUnion.standardSchemeReadValue(fVar, j);
            if (tUnion.value_ != null) {
                tUnion.setField_ = tUnion.enumForId(j.f29148c);
            }
            fVar.mo40909k();
            fVar.mo40908j();
            fVar.mo40907i();
        }

        /* renamed from: b */
        public void write(TProtocol fVar, TUnion tUnion) throws TException {
            if (tUnion.getSetField() == null || tUnion.getFieldValue() == null) {
                throw new TProtocolException("Cannot write a TUnion with no set value!");
            }
            fVar.mo40897a(tUnion.getStructDesc());
            fVar.mo40894a(tUnion.getFieldDesc(tUnion.setField_));
            tUnion.standardSchemeWriteValue(fVar);
            fVar.mo40901c();
            fVar.mo40902d();
            fVar.mo40900b();
        }
    }

    /* renamed from: org.apache.thrift.TUnion$b */
    private static class C8559b implements SchemeFactory {
        private C8559b() {
        }

        /* renamed from: a */
        public C8558a getScheme() {
            return new C8558a();
        }
    }

    /* renamed from: org.apache.thrift.TUnion$c */
    private static class C8560c extends TupleScheme<TUnion> {
        private C8560c() {
        }

        /* renamed from: a */
        public void read(TProtocol fVar, TUnion tUnion) throws TException {
            tUnion.setField_ = null;
            tUnion.value_ = null;
            short t = fVar.mo40918t();
            tUnion.value_ = tUnion.tupleSchemeReadValue(fVar, t);
            if (tUnion.value_ != null) {
                tUnion.setField_ = tUnion.enumForId(t);
            }
        }

        /* renamed from: b */
        public void write(TProtocol fVar, TUnion tUnion) throws TException {
            if (tUnion.getSetField() == null || tUnion.getFieldValue() == null) {
                throw new TProtocolException("Cannot write a TUnion with no set value!");
            }
            fVar.mo40898a(tUnion.setField_.getThriftFieldId());
            tUnion.tupleSchemeWriteValue(fVar);
        }
    }

    /* renamed from: org.apache.thrift.TUnion$d */
    private static class C8561d implements SchemeFactory {
        private C8561d() {
        }

        /* renamed from: a */
        public C8560c getScheme() {
            return new C8560c();
        }
    }

    public abstract void checkType(F f, Object obj) throws ClassCastException;

    public abstract F enumForId(short s);

    public abstract TField getFieldDesc(F f);

    public abstract TStruct getStructDesc();

    public abstract Object standardSchemeReadValue(TProtocol fVar, TField bVar) throws TException;

    public abstract void standardSchemeWriteValue(TProtocol fVar) throws TException;

    public abstract Object tupleSchemeReadValue(TProtocol fVar, short s) throws TException;

    public abstract void tupleSchemeWriteValue(TProtocol fVar) throws TException;

    protected TUnion() {
        this.setField_ = null;
        this.value_ = null;
    }

    static {
        schemes.put(StandardScheme.class, new C8559b());
        schemes.put(TupleScheme.class, new C8561d());
    }

    protected TUnion(F f, Object obj) {
        setFieldValue(f, obj);
    }

    protected TUnion(TUnion<T, F> tUnion) {
        if (tUnion.getClass().equals(getClass())) {
            this.setField_ = tUnion.setField_;
            this.value_ = deepCopyObject(tUnion.value_);
            return;
        }
        throw new ClassCastException();
    }

    private static Object deepCopyObject(Object obj) {
        if (obj instanceof TBase) {
            return ((TBase) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return TBaseHelper.m36987a((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return deepCopyList((List) obj);
        }
        if (obj instanceof Set) {
            return deepCopySet((Set) obj);
        }
        if (obj instanceof Map) {
            obj = deepCopyMap((Map) obj);
        }
        return obj;
    }

    private static Map deepCopyMap(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(deepCopyObject(entry.getKey()), deepCopyObject(entry.getValue()));
        }
        return hashMap;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Set, code=java.util.Set<java.lang.Object>, for r2v0, types: [java.util.Set<java.lang.Object>, java.util.Set] */
    private static java.util.Set deepCopySet(java.util.Set<java.lang.Object> r2) {
        /*
        java.util.HashSet r0 = new java.util.HashSet
        r0.<init>()
        java.util.Iterator r2 = r2.iterator()
    L_0x0009:
        boolean r1 = r2.hasNext()
        if (r1 == 0) goto L_0x001b
        java.lang.Object r1 = r2.next()
        java.lang.Object r1 = deepCopyObject(r1)
        r0.add(r1)
        goto L_0x0009
    L_0x001b:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.TUnion.deepCopySet(java.util.Set):java.util.Set");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r2v0, types: [java.util.List, java.util.List<java.lang.Object>] */
    private static java.util.List deepCopyList(java.util.List<java.lang.Object> r2) {
        /*
        java.util.ArrayList r0 = new java.util.ArrayList
        int r1 = r2.size()
        r0.<init>(r1)
        java.util.Iterator r2 = r2.iterator()
    L_0x000d:
        boolean r1 = r2.hasNext()
        if (r1 == 0) goto L_0x001f
        java.lang.Object r1 = r2.next()
        java.lang.Object r1 = deepCopyObject(r1)
        r0.add(r1)
        goto L_0x000d
    L_0x001f:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.TUnion.deepCopyList(java.util.List):java.util.List");
    }

    public F getSetField() {
        return this.setField_;
    }

    public Object getFieldValue() {
        return this.value_;
    }

    public Object getFieldValue(F f) {
        if (f == this.setField_) {
            return getFieldValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get the value of field ");
        sb.append(f);
        sb.append(" because union's set field is ");
        sb.append(this.setField_);
        throw new IllegalArgumentException(sb.toString());
    }

    public Object getFieldValue(int i) {
        return getFieldValue((F) enumForId((short) i));
    }

    public boolean isSet() {
        return this.setField_ != null;
    }

    public boolean isSet(F f) {
        return this.setField_ == f;
    }

    public boolean isSet(int i) {
        return isSet((F) enumForId((short) i));
    }

    public void read(TProtocol fVar) throws TException {
        ((SchemeFactory) schemes.get(fVar.mo40942C())).getScheme().read(fVar, this);
    }

    public void setFieldValue(F f, Object obj) {
        checkType(f, obj);
        this.setField_ = f;
        this.value_ = obj;
    }

    public void setFieldValue(int i, Object obj) {
        setFieldValue((F) enumForId((short) i), obj);
    }

    public void write(TProtocol fVar) throws TException {
        ((SchemeFactory) schemes.get(fVar.mo40942C())).getScheme().write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (getSetField() != null) {
            Object fieldValue = getFieldValue();
            sb.append(getFieldDesc(getSetField()).f29146a);
            sb.append(":");
            if (fieldValue instanceof ByteBuffer) {
                TBaseHelper.m36988a((ByteBuffer) fieldValue, sb);
            } else {
                sb.append(fieldValue.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    public final void clear() {
        this.setField_ = null;
        this.value_ = null;
    }
}
