package com.qiyukf.nimlib.p453d.p454a.p458d;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.a.d.a */
public final class C5759a {
    /* renamed from: a */
    public static Object m23155a(JSONObject jSONObject, Class<?> cls) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5 = null;
        try {
            obj5 = cls.newInstance();
            m23156a(obj5, jSONObject, cls);
            return obj5;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return obj;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return obj2;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return obj3;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return obj4;
        } catch (Exception e5) {
            e5.printStackTrace();
            return obj5;
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v9, types: [java.lang.Short] */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.lang.Character] */
    /* JADX WARNING: type inference failed for: r4v12, types: [java.lang.Byte] */
    /* JADX WARNING: type inference failed for: r4v14, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r4v16, types: [java.lang.Double] */
    /* JADX WARNING: type inference failed for: r4v17, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r4v24, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v25, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r4v27, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v2, types: [java.lang.Object]
  assigns: [java.lang.Object, java.lang.String, java.util.ArrayList]
  uses: [java.lang.Object, java.lang.String, java.util.ArrayList]
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: a */
    private static void m23156a(java.lang.Object r9, org.json.JSONObject r10, java.lang.Class<?> r11) {
        /*
        java.lang.Class r0 = r11.getSuperclass()
        if (r0 == 0) goto L_0x000d
        java.lang.Class r0 = r11.getSuperclass()
        m23156a(r9, r10, r0)
    L_0x000d:
        java.lang.reflect.Field[] r11 = r11.getDeclaredFields()
        int r0 = r11.length
        r1 = 0
        r2 = 0
    L_0x0014:
        if (r2 >= r0) goto L_0x01eb
        r3 = r11[r2]
        r4 = 1
        r3.setAccessible(r4)
        java.lang.Class r5 = r3.getType()
        java.lang.String r6 = r3.getName()
        boolean r7 = r10.has(r6)
        if (r7 == 0) goto L_0x01e7
        boolean r7 = r5.isPrimitive()
        if (r7 != 0) goto L_0x0140
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Byte> r8 = java.lang.Byte.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Character> r8 = java.lang.Character.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Short> r8 = java.lang.Short.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Float> r8 = java.lang.Float.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 != 0) goto L_0x00b2
        java.lang.String r7 = r5.getName()
        java.lang.Class<java.lang.Double> r8 = java.lang.Double.class
        java.lang.String r8 = r8.getName()
        boolean r7 = r7.equals(r8)
        if (r7 == 0) goto L_0x00b1
        goto L_0x00b2
    L_0x00b1:
        r4 = 0
    L_0x00b2:
        if (r4 == 0) goto L_0x00b6
        goto L_0x0140
    L_0x00b6:
        java.lang.Class<java.lang.String> r4 = java.lang.String.class
        boolean r4 = r5.isAssignableFrom(r4)
        if (r4 == 0) goto L_0x00c8
        java.lang.Object r4 = r10.get(r6)
        java.lang.String r4 = java.lang.String.valueOf(r4)
        goto L_0x01e4
    L_0x00c8:
        java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
        boolean r4 = r5.isAssignableFrom(r4)
        if (r4 == 0) goto L_0x012e
        java.util.ArrayList r4 = new java.util.ArrayList
        r4.<init>()
        java.lang.reflect.Type r5 = r3.getGenericType()
        boolean r7 = r5 instanceof java.lang.reflect.ParameterizedType
        if (r7 == 0) goto L_0x01e7
        java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
        java.lang.reflect.Type[] r7 = r5.getActualTypeArguments()
        r7 = r7[r1]
        boolean r7 = r7 instanceof java.lang.Class
        if (r7 == 0) goto L_0x01e7
        java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
        r5 = r5[r1]
        java.lang.Class r5 = (java.lang.Class) r5
        java.lang.Object r7 = r10.get(r6)
        boolean r7 = r7 instanceof org.json.JSONArray
        if (r7 == 0) goto L_0x01e4
        org.json.JSONArray r6 = r10.getJSONArray(r6)
        r7 = 0
    L_0x00fe:
        int r8 = r6.length()
        if (r7 >= r8) goto L_0x01e4
        java.lang.Object r8 = r6.get(r7)
        boolean r8 = r8 instanceof org.json.JSONObject
        if (r8 == 0) goto L_0x0118
        org.json.JSONObject r8 = r6.getJSONObject(r7)
        java.lang.Object r8 = m23155a(r8, r5)
    L_0x0114:
        r4.add(r8)
        goto L_0x012b
    L_0x0118:
        java.lang.Object r8 = r6.get(r7)
        java.lang.Class r8 = r8.getClass()
        boolean r8 = r5.isAssignableFrom(r8)
        if (r8 == 0) goto L_0x012b
        java.lang.Object r8 = r6.get(r7)
        goto L_0x0114
    L_0x012b:
        int r7 = r7 + 1
        goto L_0x00fe
    L_0x012e:
        org.json.JSONObject r4 = r10.getJSONObject(r6)
        java.lang.Object r5 = r5.newInstance()
        java.lang.Class r5 = r5.getClass()
        java.lang.Object r4 = m23155a(r4, r5)
        goto L_0x01e4
    L_0x0140:
        java.lang.Object r4 = r10.get(r6)
        java.lang.Class r5 = r3.getType()
        java.lang.Class r6 = r4.getClass()
        boolean r5 = r5.isAssignableFrom(r6)
        if (r5 == 0) goto L_0x0154
        goto L_0x01e4
    L_0x0154:
        java.lang.Class r5 = r3.getType()
        java.lang.String r4 = r4.toString()
        java.lang.Class r6 = java.lang.Integer.TYPE
        if (r6 == r5) goto L_0x01dc
        java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
        if (r6 != r5) goto L_0x0166
        goto L_0x01dc
    L_0x0166:
        java.lang.Class r6 = java.lang.Long.TYPE
        if (r6 == r5) goto L_0x01d3
        java.lang.Class<java.lang.Long> r6 = java.lang.Long.class
        if (r6 != r5) goto L_0x0170
        goto L_0x01d3
    L_0x0170:
        java.lang.Class r6 = java.lang.Short.TYPE
        if (r6 == r5) goto L_0x01ca
        java.lang.Class<java.lang.Short> r6 = java.lang.Short.class
        if (r6 != r5) goto L_0x0179
        goto L_0x01ca
    L_0x0179:
        java.lang.Class r6 = java.lang.Character.TYPE
        if (r6 == r5) goto L_0x01c1
        java.lang.Class<java.lang.Character> r6 = java.lang.Character.class
        if (r6 != r5) goto L_0x0182
        goto L_0x01c1
    L_0x0182:
        java.lang.Class r6 = java.lang.Byte.TYPE
        if (r6 == r5) goto L_0x01bc
        java.lang.Class<java.lang.Byte> r6 = java.lang.Byte.class
        if (r6 != r5) goto L_0x018b
        goto L_0x01bc
    L_0x018b:
        java.lang.Class r6 = java.lang.Float.TYPE
        if (r6 == r5) goto L_0x01b3
        java.lang.Class<java.lang.Float> r6 = java.lang.Float.class
        if (r6 != r5) goto L_0x0194
        goto L_0x01b3
    L_0x0194:
        java.lang.Class r6 = java.lang.Double.TYPE
        if (r6 == r5) goto L_0x01aa
        java.lang.Class<java.lang.Double> r6 = java.lang.Double.class
        if (r6 != r5) goto L_0x019d
        goto L_0x01aa
    L_0x019d:
        java.lang.Class r6 = java.lang.Boolean.TYPE
        if (r6 == r5) goto L_0x01a5
        java.lang.Class<java.lang.Boolean> r6 = java.lang.Boolean.class
        if (r6 != r5) goto L_0x01e4
    L_0x01a5:
        java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
        goto L_0x01e4
    L_0x01aa:
        double r4 = java.lang.Double.parseDouble(r4)
        java.lang.Double r4 = java.lang.Double.valueOf(r4)
        goto L_0x01e4
    L_0x01b3:
        float r4 = java.lang.Float.parseFloat(r4)
        java.lang.Float r4 = java.lang.Float.valueOf(r4)
        goto L_0x01e4
    L_0x01bc:
        java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
        goto L_0x01e4
    L_0x01c1:
        char r4 = r4.charAt(r1)
        java.lang.Character r4 = java.lang.Character.valueOf(r4)
        goto L_0x01e4
    L_0x01ca:
        short r4 = java.lang.Short.parseShort(r4)
        java.lang.Short r4 = java.lang.Short.valueOf(r4)
        goto L_0x01e4
    L_0x01d3:
        long r4 = java.lang.Long.parseLong(r4)
        java.lang.Long r4 = java.lang.Long.valueOf(r4)
        goto L_0x01e4
    L_0x01dc:
        int r4 = java.lang.Integer.parseInt(r4)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
    L_0x01e4:
        r3.set(r9, r4)
    L_0x01e7:
        int r2 = r2 + 1
        goto L_0x0014
    L_0x01eb:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p453d.p454a.p458d.C5759a.m23156a(java.lang.Object, org.json.JSONObject, java.lang.Class):void");
    }
}
