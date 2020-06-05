package kotlin.jvm.internal;

import kotlin.reflect.C8276h;
import kotlin.reflect.C8276h.C8277a;
import kotlin.reflect.C8284l.C8285a;
import kotlin.reflect.KCallable;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements C8276h {
    public MutablePropertyReference1() {
    }

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35397a(this);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public C8285a getGetter() {
        return ((C8276h) getReflected()).getGetter();
    }

    public C8277a getSetter() {
        return ((C8276h) getReflected()).getSetter();
    }

    public Object getDelegate(Object obj) {
        return ((C8276h) getReflected()).getDelegate(obj);
    }
}
