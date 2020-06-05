package kotlin.jvm.internal;

import kotlin.reflect.C8286m;
import kotlin.reflect.C8286m.C8287a;
import kotlin.reflect.KCallable;

public abstract class PropertyReference2 extends PropertyReference implements C8286m {
    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return C8272k.m35401a(this);
    }

    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public C8287a getGetter() {
        return ((C8286m) getReflected()).getGetter();
    }

    public Object getDelegate(Object obj, Object obj2) {
        return ((C8286m) getReflected()).getDelegate(obj, obj2);
    }
}
