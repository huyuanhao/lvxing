package com.qiyukf.nimlib.p469e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.e.e */
public final class C5812e implements InvocationHandler {

    /* renamed from: com.qiyukf.nimlib.e.e$a */
    private static class C5813a {
        /* renamed from: a */
        private static final Map<Class, Object> f18476a;

        static {
            HashMap hashMap = new HashMap(7);
            f18476a = hashMap;
            hashMap.put(Integer.TYPE, Integer.valueOf(0));
            f18476a.put(Long.TYPE, Long.valueOf(0));
            f18476a.put(Boolean.TYPE, Boolean.valueOf(false));
            f18476a.put(Byte.TYPE, Byte.valueOf(0));
            f18476a.put(Float.TYPE, Float.valueOf(0.0f));
            f18476a.put(Double.TYPE, Double.valueOf(0.0d));
            f18476a.put(Character.TYPE, Character.valueOf(0));
        }

        /* renamed from: a */
        static /* synthetic */ Object m23329a(Class cls, Object obj) {
            return (obj != null || !f18476a.containsKey(cls)) ? obj : f18476a.get(cls);
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean z = true;
        boolean z2 = !method.getReturnType().equals(Void.TYPE) && !method.getReturnType().equals(Void.class);
        if (!z2 || method.getReturnType().isAssignableFrom(C5824k.class)) {
            z = false;
        }
        C5817i iVar = new C5817i();
        C5817i a = iVar.mo28114a(objArr);
        String simpleName = method.getDeclaringClass().getSimpleName();
        C5819b bVar = a.f18480a;
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append("/");
        sb.append(method.getName());
        bVar.f18486a = sb.toString();
        a.mo28117b(z2).mo28113a(z);
        Object a2 = C5805a.m23310a(iVar);
        return z ? C5813a.m23329a(method.getReturnType(), a2) : a2;
    }
}
