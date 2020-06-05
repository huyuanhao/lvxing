package kotlin.jvm.internal;

import kotlin.reflect.C8278i;
import kotlin.reflect.C8278i.C8279a;
import kotlin.reflect.C8286m.C8287a;
import kotlin.reflect.KCallable;

public abstract class MutablePropertyReference2 extends MutablePropertyReference implements C8278i {
    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35398a(this);
    }

    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public C8287a getGetter() {
        return ((C8278i) getReflected()).getGetter();
    }

    public C8279a getSetter() {
        return ((C8278i) getReflected()).getSetter();
    }

    public Object getDelegate(Object obj, Object obj2) {
        return ((C8278i) getReflected()).getDelegate(obj, obj2);
    }
}
