package com.tencent.bigdata.reflecttools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reflect {
    /* access modifiers changed from: private|final */
    public final Object object;
    /* access modifiers changed from: private|final */
    public final Class<?> type;

    /* renamed from: com.tencent.bigdata.reflecttools.Reflect$a */
    private static class C7119a {
        private C7119a() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|13|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
            throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0009, code lost:
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r2 = r0.getDeclaredMethod(r2, r3);
            r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
            r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=null, for r2v0, types: [java.lang.String] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v1
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 6 */
    private java.lang.reflect.Method exactMethod(? r2, java.lang.Class<?>[] r3) {
        /*
        r1 = this;
        java.lang.Class r0 = r1.type()
        java.lang.reflect.Method r2 = r0.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0009 }
        return r2
    L_0x0009:
        java.lang.reflect.Method r2 = r0.getDeclaredMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x000e }
        return r2
    L_0x000e:
        java.lang.Class r0 = r0.getSuperclass()
        if (r0 == 0) goto L_0x0015
        goto L_0x0009
    L_0x0015:
        java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException
        r2.<init>()
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.reflecttools.Reflect.exactMethod(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private Field field0(String str) {
        Class type2 = type();
        try {
            return (Field) accessible(type2.getField(str));
        } catch (NoSuchFieldException e) {
            while (true) {
                try {
                    return (Field) accessible(type2.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type2 = type2.getSuperclass();
                    if (type2 == null) {
                        throw new ReflectException((Throwable) e);
                    }
                }
            }
        }
    }

    public static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        while (i < clsArr2.length) {
            if (clsArr2[i] != C7119a.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: on */
    public static Reflect m30518on(Class<?> cls) {
        return new Reflect(cls);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: on */
    public static Reflect m30519on(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    /* renamed from: on */
    public static Reflect m30520on(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    /* renamed from: on */
    public static Reflect m30521on(String str) {
        return m30518on(forName(str));
    }

    /* renamed from: on */
    public static Reflect m30522on(String str, ClassLoader classLoader) {
        return m30518on(forName(str, classLoader));
    }

    /* renamed from: on */
    private static Reflect m30523on(Constructor<?> constructor, Object... objArr) {
        try {
            return m30519on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    /* renamed from: on */
    private static Reflect m30524on(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return m30520on(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return m30520on(obj);
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    /* access modifiers changed from: private|static */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, 1).toLowerCase());
        sb.append(str.substring(1));
        return sb.toString();
    }

    private Method similarMethod(String str, Class<?>[] clsArr) {
        Method[] methods;
        Method[] declaredMethods;
        Class type2 = type();
        for (Method method : type2.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        while (true) {
            for (Method method2 : type2.getDeclaredMethods()) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            type2 = type2.getSuperclass();
            if (type2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("No similar method ");
                sb.append(str);
                sb.append(" with params ");
                sb.append(Arrays.toString(clsArr));
                sb.append(" could be found on type ");
                sb.append(type());
                sb.append(".");
                throw new NoSuchMethodException(sb.toString());
            }
        }
    }

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? C7119a.class : obj.getClass();
        }
        return clsArr;
    }

    private static Object unwrap(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    public static java.lang.Class<?> wrapper(java.lang.Class r1) {
        /*
        if (r1 != 0) goto L_0x0004
        r1 = 0
        return r1
    L_0x0004:
        boolean r0 = r1.isPrimitive()
        if (r0 == 0) goto L_0x0048
        java.lang.Class r0 = java.lang.Boolean.TYPE
        if (r0 != r1) goto L_0x0011
        java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
        return r1
    L_0x0011:
        java.lang.Class r0 = java.lang.Integer.TYPE
        if (r0 != r1) goto L_0x0018
        java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
        return r1
    L_0x0018:
        java.lang.Class r0 = java.lang.Long.TYPE
        if (r0 != r1) goto L_0x001f
        java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
        return r1
    L_0x001f:
        java.lang.Class r0 = java.lang.Short.TYPE
        if (r0 != r1) goto L_0x0026
        java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
        return r1
    L_0x0026:
        java.lang.Class r0 = java.lang.Byte.TYPE
        if (r0 != r1) goto L_0x002d
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        return r1
    L_0x002d:
        java.lang.Class r0 = java.lang.Double.TYPE
        if (r0 != r1) goto L_0x0034
        java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
        return r1
    L_0x0034:
        java.lang.Class r0 = java.lang.Float.TYPE
        if (r0 != r1) goto L_0x003b
        java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
        return r1
    L_0x003b:
        java.lang.Class r0 = java.lang.Character.TYPE
        if (r0 != r1) goto L_0x0042
        java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
        return r1
    L_0x0042:
        java.lang.Class r0 = java.lang.Void.TYPE
        if (r0 != r1) goto L_0x0048
        java.lang.Class<java.lang.Void> r1 = java.lang.Void.class
    L_0x0048:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.reflecttools.Reflect.wrapper(java.lang.Class):java.lang.Class");
    }

    /* renamed from: as */
    public <P> P mo34249as(Class<P> cls) {
        final boolean z = this.object instanceof Map;
        C71181 r1 = new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) {
                String str;
                String name = method.getName();
                try {
                    str = name;
                    Object obj2 = Reflect.m30519on(Reflect.this.type, Reflect.this.object).call(name, objArr).get();
                    str = obj2;
                    return obj2;
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) Reflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && str.startsWith("get")) {
                            return map.get(Reflect.property(str.substring(3)));
                        }
                        if (length == 0 && str.startsWith("is")) {
                            return map.get(Reflect.property(str.substring(2)));
                        }
                        if (length == 1 && str.startsWith("set")) {
                            map.put(Reflect.property(str.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, r1);
    }

    public Reflect call(String str) {
        return call(str, new Object[0]);
    }

    /* JADX INFO: used method not loaded: com.tencent.bigdata.reflecttools.ReflectException.<init>(java.lang.Throwable):null, types can be incorrect */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            return m30524on(similarMethod(r4, r0), r3.object, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
            r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
            throw new com.tencent.bigdata.reflecttools.ReflectException((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    public com.tencent.bigdata.reflecttools.Reflect call(java.lang.String r4, java.lang.Object... r5) {
        /*
        r3 = this;
        java.lang.Class[] r0 = types(r5)
        java.lang.reflect.Method r1 = r3.exactMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x000f }
        java.lang.Object r2 = r3.object     // Catch:{ NoSuchMethodException -> 0x000f }
        com.tencent.bigdata.reflecttools.Reflect r4 = m30524on(r1, r2, r5)     // Catch:{ NoSuchMethodException -> 0x000f }
        return r4
    L_0x000f:
        java.lang.reflect.Method r4 = r3.similarMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x001a }
        java.lang.Object r0 = r3.object     // Catch:{ NoSuchMethodException -> 0x001a }
        com.tencent.bigdata.reflecttools.Reflect r4 = m30524on(r4, r0, r5)     // Catch:{ NoSuchMethodException -> 0x001a }
        return r4
    L_0x001a:
        r4 = move-exception
        com.tencent.bigdata.reflecttools.ReflectException r5 = new com.tencent.bigdata.reflecttools.ReflectException
        r5.m52366init(r4)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bigdata.reflecttools.Reflect.call(java.lang.String, java.lang.Object[]):com.tencent.bigdata.reflecttools.Reflect");
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public Reflect create(Object... objArr) {
        Constructor[] declaredConstructors;
        Class[] types = types(objArr);
        try {
            r8 = objArr;
            r8 = m30523on(type().getDeclaredConstructor(types), objArr);
            r8 = r8;
            return r8;
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), types)) {
                    return m30523on(constructor, r8);
                }
            }
            throw new ReflectException((Throwable) e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.object.equals(((Reflect) obj).get());
        }
        return false;
    }

    public Reflect field(String str) {
        try {
            Field field0 = field0(str);
            return m30519on(field0.getType(), field0.get(this.object));
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    public Map<String, Reflect> fields() {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class type2 = type();
        do {
            for (Field field : type2.getDeclaredFields()) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            type2 = type2.getSuperclass();
        } while (type2 != null);
        return linkedHashMap;
    }

    public <T> T get() {
        return this.object;
    }

    public <T> T get(String str) {
        return field(str).get();
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String str, Object obj) {
        try {
            Field field0 = field0(str);
            if ((field0.getModifiers() & 16) == 16) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(field0, field0.getModifiers() & -17);
            }
            field0.set(this.object, unwrap(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException((Throwable) e);
        }
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        return this.type;
    }
}
