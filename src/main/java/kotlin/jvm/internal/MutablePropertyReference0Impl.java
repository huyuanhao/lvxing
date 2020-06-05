package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public MutablePropertyReference0Impl(KDeclarationContainer dVar, String str, String str2) {
        this.owner = dVar;
        this.name = str;
        this.signature = str2;
    }

    public KDeclarationContainer getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }
}