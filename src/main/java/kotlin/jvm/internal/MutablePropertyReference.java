package kotlin.jvm.internal;

import kotlin.reflect.KProperty;

public abstract class MutablePropertyReference extends PropertyReference implements KProperty {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object obj) {
        super(obj);
    }
}
