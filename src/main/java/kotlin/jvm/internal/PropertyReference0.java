package kotlin.jvm.internal;

import kotlin.reflect.C8282k;
import kotlin.reflect.C8282k.C8283a;
import kotlin.reflect.KCallable;

public abstract class PropertyReference0 extends PropertyReference implements C8282k {
    public PropertyReference0() {
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35399a(this);
    }

    public Object invoke() {
        return get();
    }

    public C8283a getGetter() {
        return ((C8282k) getReflected()).getGetter();
    }

    public Object getDelegate() {
        return ((C8282k) getReflected()).getDelegate();
    }
}
