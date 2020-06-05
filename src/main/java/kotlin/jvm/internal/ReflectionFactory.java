package kotlin.jvm.internal;

import kotlin.reflect.C8274g;
import kotlin.reflect.C8276h;
import kotlin.reflect.C8278i;
import kotlin.reflect.C8282k;
import kotlin.reflect.C8284l;
import kotlin.reflect.C8286m;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;

/* renamed from: kotlin.jvm.internal.l */
public class ReflectionFactory {
    /* renamed from: a */
    public KFunction mo39530a(FunctionReference functionReference) {
        return functionReference;
    }

    /* renamed from: a */
    public C8274g mo39531a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    /* renamed from: a */
    public C8276h mo39532a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    /* renamed from: a */
    public C8278i mo39533a(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    /* renamed from: a */
    public C8282k mo39534a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    /* renamed from: a */
    public C8284l mo39535a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    /* renamed from: a */
    public C8286m mo39536a(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    /* renamed from: a */
    public KClass mo39529a(Class cls) {
        return new ClassReference(cls);
    }

    /* renamed from: a */
    public String mo39527a(Lambda lambda) {
        return mo39528a((FunctionBase) lambda);
    }

    /* renamed from: a */
    public String mo39528a(FunctionBase gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
