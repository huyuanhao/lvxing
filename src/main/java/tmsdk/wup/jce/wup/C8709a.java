package tmsdk.wup.jce.wup;

import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: tmsdk.wup.jce.wup.a */
public class C8709a {
    /* renamed from: a */
    private static void m37732a(ArrayList<String> arrayList, String str) {
        int length = str.length();
        while (str.charAt(length - 1) == '>') {
            length--;
            if (length == 0) {
                break;
            }
        }
        arrayList.add(0, uni2JavaType(str.substring(0, length)));
    }

    public static Object createClassByName(String str) {
        if (str.equals("java.lang.Integer")) {
            return Integer.valueOf(0);
        }
        if (str.equals("java.lang.Boolean")) {
            return Boolean.valueOf(false);
        }
        if (str.equals("java.lang.Byte")) {
            return Byte.valueOf(0);
        }
        if (str.equals("java.lang.Double")) {
            return Double.valueOf(0.0d);
        }
        if (str.equals("java.lang.Float")) {
            return Float.valueOf(0.0f);
        }
        if (str.equals("java.lang.Long")) {
            return Long.valueOf(0);
        }
        if (str.equals("java.lang.Short")) {
            return Short.valueOf(0);
        }
        if (str.equals("java.lang.Character")) {
            throw new IllegalArgumentException("can not support java.lang.Character");
        } else if (str.equals("java.lang.String")) {
            return "";
        } else {
            if (str.equals("java.util.List")) {
                return new ArrayList();
            }
            if (str.equals("java.util.Map")) {
                return new HashMap();
            }
            String str2 = "Array";
            if (str.equals(str2)) {
                return str2;
            }
            if (str.equals("?")) {
                return str;
            }
            try {
                return Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                throw new C8710b(e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
            if (r2 == null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
            if (r2 == null) goto L_0x007d;
     */
    public static java.lang.Object createClassByUni(java.lang.String r7) {
        /*
        java.util.ArrayList r7 = getTypeList(r7)
        java.util.Iterator r7 = r7.iterator()
        r0 = 0
        r1 = r0
        r2 = r1
    L_0x000b:
        r3 = r2
    L_0x000c:
        boolean r4 = r7.hasNext()
        if (r4 == 0) goto L_0x007f
        java.lang.Object r1 = r7.next()
        java.lang.String r1 = (java.lang.String) r1
        java.lang.Object r1 = createClassByName(r1)
        boolean r4 = r1 instanceof java.lang.String
        r5 = 0
        if (r4 == 0) goto L_0x0043
        r4 = r1
        java.lang.String r4 = (java.lang.String) r4
        java.lang.String r4 = (java.lang.String) r4
        java.lang.String r6 = "Array"
        boolean r6 = r6.equals(r4)
        if (r6 == 0) goto L_0x0037
        if (r2 != 0) goto L_0x000c
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
        goto L_0x000c
    L_0x0037:
        java.lang.String r5 = "?"
        boolean r4 = r5.equals(r4)
        if (r4 == 0) goto L_0x0040
        goto L_0x000c
    L_0x0040:
        if (r2 != 0) goto L_0x007c
        goto L_0x007b
    L_0x0043:
        boolean r4 = r1 instanceof java.util.List
        r6 = 1
        if (r4 == 0) goto L_0x0062
        if (r2 == 0) goto L_0x0058
        boolean r4 = r2 instanceof java.lang.Byte
        if (r4 == 0) goto L_0x0058
        java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
        java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r6)
        java.lang.reflect.Array.set(r1, r5, r2)
        goto L_0x000c
    L_0x0058:
        if (r2 == 0) goto L_0x0060
        r4 = r1
        java.util.List r4 = (java.util.List) r4
        r4.add(r2)
    L_0x0060:
        r2 = r0
        goto L_0x000c
    L_0x0062:
        boolean r4 = r1 instanceof java.util.Map
        if (r4 == 0) goto L_0x0079
        if (r2 == 0) goto L_0x006a
        r4 = 1
        goto L_0x006b
    L_0x006a:
        r4 = 0
    L_0x006b:
        if (r3 == 0) goto L_0x006e
        r5 = 1
    L_0x006e:
        r4 = r4 & r5
        if (r4 == 0) goto L_0x0077
        r4 = r1
        java.util.Map r4 = (java.util.Map) r4
        r4.put(r2, r3)
    L_0x0077:
        r2 = r0
        goto L_0x000b
    L_0x0079:
        if (r2 != 0) goto L_0x007c
    L_0x007b:
        goto L_0x007d
    L_0x007c:
        r3 = r2
    L_0x007d:
        r2 = r1
        goto L_0x000c
    L_0x007f:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdk.wup.jce.wup.C8709a.createClassByUni(java.lang.String):java.lang.Object");
    }

    public static ArrayList<String> getTypeList(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str2 = "<";
        int indexOf = str.indexOf(str2);
        int i = 0;
        while (i < indexOf) {
            m37732a(arrayList, str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf(str2, i);
            int indexOf2 = str.indexOf(StorageInterface.KEY_SPLITER, i);
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 != -1 && indexOf2 < indexOf) {
                indexOf = indexOf2;
            }
        }
        m37732a(arrayList, str.substring(i, str.length()));
        return arrayList;
    }

    public static String java2UniType(String str) {
        if (str.equals("java.lang.Integer") || str.equals("int")) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals(SettingsContentProvider.BOOLEAN_TYPE)) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return "char";
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double") && !str.equals(str2)) {
            boolean equals = str.equals("java.lang.Float");
            str2 = SettingsContentProvider.FLOAT_TYPE;
            if (!equals && !str.equals(str2)) {
                if (str.equals("java.lang.Long") || str.equals(SettingsContentProvider.LONG_TYPE)) {
                    return "int64";
                }
                String str3 = "short";
                if (str.equals("java.lang.Short") || str.equals(str3)) {
                    return str3;
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else if (str.equals("java.lang.String")) {
                    return SettingsContentProvider.STRING_TYPE;
                } else {
                    if (str.equals("java.util.List")) {
                        return "list";
                    }
                    if (str.equals("java.util.Map")) {
                        str = "map";
                    }
                    return str;
                }
            }
        }
        return str2;
    }

    public static String transTypeList(ArrayList<String> arrayList) {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, java2UniType((String) arrayList.get(i)));
        }
        Collections.reverse(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = (String) arrayList.get(i2);
            String str2 = ">";
            String str3 = "<";
            if (str.equals("list")) {
                int i3 = i2 - 1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append((String) arrayList.get(i3));
                arrayList.set(i3, sb2.toString());
                sb = new StringBuilder();
            } else if (str.equals("map")) {
                int i4 = i2 - 1;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append((String) arrayList.get(i4));
                sb3.append(StorageInterface.KEY_SPLITER);
                arrayList.set(i4, sb3.toString());
                sb = new StringBuilder();
            } else if (str.equals("Array")) {
                int i5 = i2 - 1;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str3);
                sb4.append((String) arrayList.get(i5));
                arrayList.set(i5, sb4.toString());
                sb = new StringBuilder();
            }
            sb.append((String) arrayList.get(0));
            sb.append(str2);
            arrayList.set(0, sb.toString());
        }
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        return stringBuffer.toString();
    }

    public static String uni2JavaType(String str) {
        if (str.equals("int32")) {
            return "java.lang.Integer";
        }
        if (str.equals("bool")) {
            return "java.lang.Boolean";
        }
        if (str.equals("char")) {
            return "java.lang.Byte";
        }
        if (str.equals("double")) {
            return "java.lang.Double";
        }
        if (str.equals(SettingsContentProvider.FLOAT_TYPE)) {
            return "java.lang.Float";
        }
        if (str.equals("int64")) {
            return "java.lang.Long";
        }
        if (str.equals("short")) {
            return "java.lang.Short";
        }
        if (str.equals(SettingsContentProvider.STRING_TYPE)) {
            return "java.lang.String";
        }
        if (str.equals("list")) {
            return "java.util.List";
        }
        if (str.equals("map")) {
            str = "java.util.Map";
        }
        return str;
    }
}
