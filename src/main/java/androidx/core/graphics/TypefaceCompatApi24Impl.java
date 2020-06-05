package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;

    TypefaceCompatApi24Impl() {
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    static {
        /*
        r0 = 0
        java.lang.String r1 = "android.graphics.FontFamily"
        java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r2 = 0
        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.reflect.Constructor r3 = r1.getConstructor(r3)     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.String r4 = "addFontWeightStyle"
        r5 = 5
        java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.Class<java.nio.ByteBuffer> r6 = java.nio.ByteBuffer.class
        r5[r2] = r6     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r7 = 1
        r5[r7] = r6     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r6 = 2
        java.lang.Class<java.util.List> r8 = java.util.List.class
        r5[r6] = r8     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r6 = 3
        java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r5[r6] = r8     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r6 = 4
        java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r5[r6] = r8     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.reflect.Method r4 = r1.getMethod(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.Object r5 = java.lang.reflect.Array.newInstance(r1, r7)     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.Class<android.graphics.Typeface> r6 = android.graphics.Typeface.class
        java.lang.String r8 = "createFromFamiliesWithDefault"
        java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.Class r5 = r5.getClass()     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r7[r2] = r5     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        java.lang.reflect.Method r0 = r6.getMethod(r8, r7)     // Catch:{ ClassNotFoundException -> 0x0048, NoSuchMethodException -> 0x0046 }
        r2 = r0
        r0 = r3
        goto L_0x0059
    L_0x0046:
        r1 = move-exception
        goto L_0x0049
    L_0x0048:
        r1 = move-exception
    L_0x0049:
        java.lang.Class r2 = r1.getClass()
        java.lang.String r2 = r2.getName()
        java.lang.String r3 = "TypefaceCompatApi24Impl"
        android.util.Log.e(r3, r2, r1)
        r1 = r0
        r2 = r1
        r4 = r2
    L_0x0059:
        sFontFamilyCtor = r0
        sFontFamily = r1
        sAddFontWeightStyle = r4
        sCreateFromFamiliesWithDefault = r2
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi24Impl.m38833clinit():void");
    }

    public static boolean isUsable() {
        if (sAddFontWeightStyle == null) {
            Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return sAddFontWeightStyle != null;
    }

    private static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr, int i) {
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        int length = fontInfoArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            FontInfo fontInfo = fontInfoArr[i2];
            Uri uri = fontInfo.getUri();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !addFontWeightStyle(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                return null;
            }
        }
        Typeface createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily);
        if (createFromFamiliesWithDefault == null) {
            return null;
        }
        return Typeface.create(createFromFamiliesWithDefault, i);
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        for (int i2 = 0; i2 < length; i2++) {
            FontFileResourceEntry fontFileResourceEntry = entries[i2];
            ByteBuffer copyToDirectBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, fontFileResourceEntry.getResourceId());
            if (copyToDirectBuffer == null || !addFontWeightStyle(newFamily, copyToDirectBuffer, fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                return null;
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }
}
