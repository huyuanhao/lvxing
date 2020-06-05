package kotlin.jvm.internal;

import kotlin.reflect.C8274g;
import kotlin.reflect.C8274g.C8275a;
import kotlin.reflect.C8282k.C8283a;
import kotlin.reflect.KCallable;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements C8274g {
    public MutablePropertyReference0() {
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35396a(this);
    }

    public Object invoke() {
        return get();
    }

    public C8283a getGetter() {
        return ((C8274g) getReflected()).getGetter();
    }

    public C8275a getSetter() {
        return ((C8274g) getReflected()).getSetter();
    }

    public Object getDelegate() {
        return ((C8274g) getReflected()).getDelegate();
    }
}
