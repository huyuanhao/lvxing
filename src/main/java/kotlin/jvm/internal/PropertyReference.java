package kotlin.jvm.internal;

import kotlin.reflect.C8280j;
import kotlin.reflect.KCallable;

public abstract class PropertyReference extends CallableReference implements C8280j {
    public PropertyReference() {
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public C8280j getReflected() {
        return (C8280j) super.getReflected();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (!getOwner().equals(propertyReference.getOwner()) || !getName().equals(propertyReference.getName()) || !getSignature().equals(propertyReference.getSignature()) || !C8271i.m35384a(getBoundReceiver(), propertyReference.getBoundReceiver())) {
                z = false;
            }
            return z;
        } else if (obj instanceof C8280j) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("property ");
        sb.append(getName());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
