package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.alibaba.fastjson.util.c */
public class FieldInfo implements Comparable<FieldInfo> {
    /* renamed from: a */
    public final String f2992a;
    /* renamed from: b */
    public final Method f2993b;
    /* renamed from: c */
    public final Field f2994c;
    /* renamed from: d */
    public final Class<?> f2995d;
    /* renamed from: e */
    public final Type f2996e;
    /* renamed from: f */
    public final Class<?> f2997f;
    /* renamed from: g */
    public final boolean f2998g;
    /* renamed from: h */
    public final int f2999h;
    /* renamed from: i */
    public final int f3000i;
    /* renamed from: j */
    public final String f3001j;
    /* renamed from: k */
    public final boolean f3002k;
    /* renamed from: l */
    public final boolean f3003l;
    /* renamed from: m */
    public final char[] f3004m;
    /* renamed from: n */
    public final boolean f3005n;
    /* renamed from: o */
    public final boolean f3006o;
    /* renamed from: p */
    public final boolean f3007p;
    /* renamed from: q */
    public final String f3008q;
    /* renamed from: r */
    public final String[] f3009r;
    /* renamed from: s */
    private int f3010s = 0;
    /* renamed from: t */
    private final JSONField f3011t;
    /* renamed from: u */
    private final JSONField f3012u;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2, int i3) {
        this.f2992a = str;
        this.f2997f = cls;
        this.f2995d = cls2;
        this.f2996e = type;
        this.f2993b = null;
        this.f2994c = field;
        this.f3010s = i;
        this.f2999h = i2;
        this.f3000i = i3;
        this.f3005n = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            boolean z = (modifiers & 1) != 0 || this.f2993b == null;
            this.f3002k = z;
            this.f3003l = Modifier.isTransient(modifiers);
        } else {
            this.f3003l = false;
            this.f3002k = false;
        }
        this.f3004m = mo11502a();
        if (field != null) {
            TypeUtils.m3236a((AccessibleObject) field);
        }
        this.f3001j = "";
        this.f3011t = null;
        this.f3012u = null;
        this.f2998g = false;
        this.f3006o = false;
        this.f3007p = false;
        this.f3008q = null;
        this.f3009r = new String[0];
    }

    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, int i3, JSONField jSONField, JSONField jSONField2, String str2) {
        boolean z;
        Type type2;
        boolean z2;
        Class<?> cls2;
        Type type3;
        Class<Object> cls3;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        this.f2992a = str;
        this.f2993b = method;
        this.f2994c = field;
        this.f3010s = i;
        this.f2999h = i2;
        this.f3000i = i3;
        this.f3011t = jSONField;
        this.f3012u = jSONField2;
        boolean z3 = true;
        if (field != null) {
            int modifiers = field.getModifiers();
            boolean z4 = (modifiers & 1) != 0 || method == null;
            this.f3002k = z4;
            boolean z5 = Modifier.isTransient(modifiers) || TypeUtils.m3240a(method);
            this.f3003l = z5;
        } else {
            this.f3002k = false;
            this.f3003l = false;
        }
        if (str2 == null || str2.length() <= 0) {
            this.f3001j = "";
        } else {
            this.f3001j = str2;
        }
        JSONField d = mo11506d();
        String str3 = null;
        if (d != null) {
            String format = d.format();
            if (format.trim().length() != 0) {
                str3 = format;
            }
            z = d.jsonDirect();
            this.f3007p = d.unwrapped();
            this.f3009r = d.alternateNames();
        } else {
            this.f3007p = false;
            this.f3009r = new String[0];
            z = false;
        }
        this.f3008q = str3;
        this.f3004m = mo11502a();
        if (method != null) {
            TypeUtils.m3236a((AccessibleObject) method);
        }
        if (field != null) {
            TypeUtils.m3236a((AccessibleObject) field);
        }
        if (method != null) {
            Class<Object>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls3 = parameterTypes[0];
                type2 = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Object.class) {
                cls3 = parameterTypes[0];
                type2 = cls3;
            } else {
                cls3 = method.getReturnType();
                type2 = method.getGenericReturnType();
                z2 = true;
                this.f2997f = method.getDeclaringClass();
                cls2 = cls3;
            }
            z2 = false;
            this.f2997f = method.getDeclaringClass();
            cls2 = cls3;
        } else {
            cls2 = field.getType();
            type2 = field.getGenericType();
            this.f2997f = field.getDeclaringClass();
            z2 = Modifier.isFinal(field.getModifiers());
        }
        this.f2998g = z2;
        if (!z || cls2 != String.class) {
            z3 = false;
        }
        this.f3006o = z3;
        if (cls != 0 && cls2 == Object.class && (type2 instanceof TypeVariable)) {
            Type a = m3175a(cls, type, (TypeVariable) type2);
            if (a != null) {
                this.f2995d = TypeUtils.m3255d(a);
                this.f2996e = a;
                this.f3005n = cls2.isEnum();
                return;
            }
        }
        if (!(type2 instanceof Class)) {
            if (type == 0) {
                type = cls;
            }
            type3 = m3174a(cls, type, type2);
            if (type3 != type2) {
                if (type3 instanceof ParameterizedType) {
                    cls2 = TypeUtils.m3255d(type3);
                } else if (type3 instanceof Class) {
                    cls2 = TypeUtils.m3255d(type3);
                }
            }
        } else {
            type3 = type2;
        }
        this.f2996e = type3;
        this.f2995d = cls2;
        this.f3005n = cls2.isEnum();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public char[] mo11502a() {
        int length = this.f2992a.length();
        char[] cArr = new char[(length + 3)];
        String str = this.f2992a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    /* renamed from: a */
    public static Type m3174a(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type a = m3174a(cls, type, genericComponentType);
                return genericComponentType != a ? Array.newInstance(TypeUtils.m3255d(a), 0).getClass() : type2;
            } else if (!TypeUtils.m3241a(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.m3245b(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable[] typeParameters = TypeUtils.m3255d((Type) parameterizedType2).getTypeParameters();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    if (m3176a(actualTypeArguments, typeVariableArr, parameterizedType.getActualTypeArguments())) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    /* renamed from: a */
    private static boolean m3176a(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            ParameterizedType parameterizedType = typeArr[i];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (m3176a(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    z = true;
                }
            } else if (parameterizedType instanceof TypeVariable) {
                boolean z2 = z;
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (parameterizedType.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static Type m3175a(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] typeArr;
        Type type2 = null;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr2 = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    m3176a(actualTypeArguments, cls.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls = cls.getSuperclass();
            }
            typeArr = typeArr2;
        }
        if (typeArr == null) {
            return null;
        }
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        int i = 0;
        while (true) {
            if (i >= typeParameters.length) {
                break;
            } else if (typeVariable.equals(typeParameters[i])) {
                type2 = typeArr[i];
                break;
            } else {
                i++;
            }
        }
        return type2;
    }

    public String toString() {
        return this.f2992a;
    }

    /* renamed from: b */
    public Member mo11503b() {
        Method method = this.f2993b;
        if (method != null) {
            return method;
        }
        return this.f2994c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Class<?> mo11504c() {
        Method method = this.f2993b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f2994c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(FieldInfo cVar) {
        int i = this.f3010s;
        int i2 = cVar.f3010s;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int compareTo = this.f2992a.compareTo(cVar.f2992a);
        if (compareTo != 0) {
            return compareTo;
        }
        Class c = mo11504c();
        Class c2 = cVar.mo11504c();
        if (!(c == null || c2 == null || c == c2)) {
            if (c.isAssignableFrom(c2)) {
                return -1;
            }
            if (c2.isAssignableFrom(c)) {
                return 1;
            }
        }
        Field field = this.f2994c;
        boolean z = false;
        boolean z2 = field != null && field.getType() == this.f2995d;
        Field field2 = cVar.f2994c;
        if (field2 != null && field2.getType() == cVar.f2995d) {
            z = true;
        }
        if (z2 && !z) {
            return 1;
        }
        if (z && !z2) {
            return -1;
        }
        if (cVar.f2995d.isPrimitive() && !this.f2995d.isPrimitive()) {
            return 1;
        }
        if (this.f2995d.isPrimitive() && !cVar.f2995d.isPrimitive()) {
            return -1;
        }
        String str = "java.";
        if (cVar.f2995d.getName().startsWith(str) && !this.f2995d.getName().startsWith(str)) {
            return 1;
        }
        if (!this.f2995d.getName().startsWith(str) || cVar.f2995d.getName().startsWith(str)) {
            return this.f2995d.getName().compareTo(cVar.f2995d.getName());
        }
        return -1;
    }

    /* renamed from: d */
    public JSONField mo11506d() {
        JSONField jSONField = this.f3011t;
        if (jSONField != null) {
            return jSONField;
        }
        return this.f3012u;
    }

    /* renamed from: e */
    public String mo11507e() {
        return this.f3008q;
    }

    /* renamed from: a */
    public Object mo11500a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f2993b;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.f2994c.get(obj);
    }

    /* renamed from: a */
    public void mo11501a(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f2993b;
        if (method != null) {
            method.invoke(obj, new Object[]{obj2});
            return;
        }
        this.f2994c.set(obj, obj2);
    }

    /* renamed from: f */
    public void mo11508f() throws SecurityException {
        Method method = this.f2993b;
        if (method != null) {
            TypeUtils.m3236a((AccessibleObject) method);
        } else {
            TypeUtils.m3236a((AccessibleObject) this.f2994c);
        }
    }
}
