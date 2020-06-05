package kotlin.jvm.internal;

import kotlin.reflect.C8284l;
import kotlin.reflect.C8284l.C8285a;
import kotlin.reflect.KCallable;

public abstract class PropertyReference1 extends PropertyReference implements C8284l {
    public PropertyReference1() {
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35400a(this);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public C8285a getGetter() {
        return ((C8284l) getReflected()).getGetter();
    }

    public Object getDelegate(Object obj) {
        return ((C8284l) getReflected()).getDelegate(obj);
    }
}
