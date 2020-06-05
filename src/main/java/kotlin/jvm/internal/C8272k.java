package kotlin.jvm.internal;

import kotlin.reflect.C8274g;
import kotlin.reflect.C8276h;
import kotlin.reflect.C8278i;
import kotlin.reflect.C8282k;
import kotlin.reflect.C8284l;
import kotlin.reflect.C8286m;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;

/* compiled from: Reflection */
/* renamed from: kotlin.jvm.internal.k */
public class C8272k {
    /* renamed from: a */
    private static final ReflectionFactory f27784a;
    /* renamed from: b */
    private static final KClass[] f27785b = new KClass[0];

    static {
        ReflectionFactory lVar = null;
        try {
            lVar = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new ReflectionFactory();
        }
        f27784a = lVar;
    }

    /* renamed from: a */
    public static KClass m35394a(Class cls) {
        return f27784a.mo39529a(cls);
    }

    /* renamed from: a */
    public static String m35392a(Lambda lambda) {
        return f27784a.mo39527a(lambda);
    }

    /* renamed from: a */
    public static String m35393a(FunctionBase gVar) {
        return f27784a.mo39528a(gVar);
    }

    /* renamed from: a */
    public static KFunction m35395a(FunctionReference functionReference) {
        return f27784a.mo39530a(functionReference);
    }

    /* renamed from: a */
    public static C8282k m35399a(PropertyReference0 propertyReference0) {
        return f27784a.mo39534a(propertyReference0);
    }

    /* renamed from: a */
    public static C8274g m35396a(MutablePropertyReference0 mutablePropertyReference0) {
        return f27784a.mo39531a(mutablePropertyReference0);
    }

    /* renamed from: a */
    public static C8284l m35400a(PropertyReference1 propertyReference1) {
        return f27784a.mo39535a(propertyReference1);
    }

    /* renamed from: a */
    public static C8276h m35397a(MutablePropertyReference1 mutablePropertyReference1) {
        return f27784a.mo39532a(mutablePropertyReference1);
    }

    /* renamed from: a */
    public static C8286m m35401a(PropertyReference2 propertyReference2) {
        return f27784a.mo39536a(propertyReference2);
    }

    /* renamed from: a */
    public static C8278i m35398a(MutablePropertyReference2 mutablePropertyReference2) {
        return f27784a.mo39533a(mutablePropertyReference2);
    }
}
