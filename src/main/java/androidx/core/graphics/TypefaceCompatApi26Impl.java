package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 9 */
    public TypefaceCompatApi26Impl() {
        /*
        r8 = this;
        r8.m38832init()
        r0 = 0
        java.lang.Class r1 = r8.obtainFontFamily()     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Constructor r2 = r8.obtainFontFamilyCtor(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Method r3 = r8.obtainAddFontFromAssetManagerMethod(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Method r4 = r8.obtainAddFontFromBufferMethod(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Method r5 = r8.obtainFreezeMethod(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Method r6 = r8.obtainAbortCreationMethod(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        java.lang.reflect.Method r0 = r8.obtainCreateFromFamiliesWithDefaultMethod(r1)     // Catch:{ ClassNotFoundException -> 0x0026, NoSuchMethodException -> 0x0024 }
        r7 = r1
        r1 = r0
        r0 = r7
        goto L_0x004b
    L_0x0024:
        r1 = move-exception
        goto L_0x0027
    L_0x0026:
        r1 = move-exception
    L_0x0027:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "Unable to collect necessary methods for class "
        r2.append(r3)
        java.lang.Class r3 = r1.getClass()
        java.lang.String r3 = r3.getName()
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        java.lang.String r3 = "TypefaceCompatApi26Impl"
        android.util.Log.e(r3, r2, r1)
        r1 = r0
        r2 = r1
        r3 = r2
        r4 = r3
        r5 = r4
        r6 = r5
    L_0x004b:
        r8.mFontFamily = r0
        r8.mFontFamilyCtor = r2
        r8.mAddFontFromAssetManager = r3
        r8.mAddFontFromBuffer = r4
        r8.mFreeze = r5
        r8.mAbortCreation = r6
        r8.mCreateFromFamiliesWithDefault = r1
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi26Impl.m38835init():void");
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.mAddFontFromAssetManager != null;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.mAddFontFromBuffer.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{newInstance, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void abortCreation(Object obj) {
        try {
            this.mAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontFileResourceEntry[] entries;
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        for (FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic(), FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
            r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            if (r11 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
            throw r13;
     */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r11, android.os.CancellationSignal r12, androidx.core.provider.FontsContractCompat.FontInfo[] r13, int r14) {
        /*
        r10 = this;
        int r0 = r13.length
        r1 = 1
        r2 = 0
        if (r0 >= r1) goto L_0x0006
        return r2
    L_0x0006:
        boolean r0 = r10.isFontFamilyPrivateAPIAvailable()
        if (r0 != 0) goto L_0x0058
        androidx.core.provider.FontsContractCompat$FontInfo r13 = r10.findBestInfo(r13, r14)
        android.content.ContentResolver r11 = r11.getContentResolver()
        android.net.Uri r14 = r13.getUri()     // Catch:{ IOException -> 0x0057 }
        java.lang.String r0 = "r"
        android.os.ParcelFileDescriptor r11 = r11.openFileDescriptor(r14, r0, r12)     // Catch:{ IOException -> 0x0057 }
        if (r11 != 0) goto L_0x0026
        if (r11 == 0) goto L_0x0025
        r11.close()     // Catch:{ IOException -> 0x0057 }
    L_0x0025:
        return r2
    L_0x0026:
        android.graphics.Typeface$Builder r12 = new android.graphics.Typeface$Builder     // Catch:{ all -> 0x0049 }
        java.io.FileDescriptor r14 = r11.getFileDescriptor()     // Catch:{ all -> 0x0049 }
        r12.<init>(r14)     // Catch:{ all -> 0x0049 }
        int r14 = r13.getWeight()     // Catch:{ all -> 0x0049 }
        android.graphics.Typeface$Builder r12 = r12.setWeight(r14)     // Catch:{ all -> 0x0049 }
        boolean r13 = r13.isItalic()     // Catch:{ all -> 0x0049 }
        android.graphics.Typeface$Builder r12 = r12.setItalic(r13)     // Catch:{ all -> 0x0049 }
        android.graphics.Typeface r12 = r12.build()     // Catch:{ all -> 0x0049 }
        if (r11 == 0) goto L_0x0048
        r11.close()     // Catch:{ IOException -> 0x0057 }
    L_0x0048:
        return r12
    L_0x0049:
        r12 = move-exception
        throw r12     // Catch:{ all -> 0x004b }
    L_0x004b:
        r13 = move-exception
        if (r11 == 0) goto L_0x0056
        r11.close()     // Catch:{ all -> 0x0052 }
        goto L_0x0056
    L_0x0052:
        r11 = move-exception
        r12.addSuppressed(r11)     // Catch:{ IOException -> 0x0057 }
    L_0x0056:
        throw r13     // Catch:{ IOException -> 0x0057 }
    L_0x0057:
        return r2
    L_0x0058:
        java.util.Map r11 = androidx.core.provider.FontsContractCompat.prepareFontData(r11, r13, r12)
        java.lang.Object r12 = r10.newFamily()
        if (r12 != 0) goto L_0x0063
        return r2
    L_0x0063:
        int r0 = r13.length
        r3 = 0
        r9 = 0
    L_0x0066:
        if (r9 >= r0) goto L_0x0093
        r4 = r13[r9]
        android.net.Uri r5 = r4.getUri()
        java.lang.Object r5 = r11.get(r5)
        java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
        if (r5 != 0) goto L_0x0077
        goto L_0x0090
    L_0x0077:
        int r6 = r4.getTtcIndex()
        int r7 = r4.getWeight()
        boolean r8 = r4.isItalic()
        r3 = r10
        r4 = r12
        boolean r3 = r3.addFontFromBuffer(r4, r5, r6, r7, r8)
        if (r3 != 0) goto L_0x008f
        r10.abortCreation(r12)
        return r2
    L_0x008f:
        r3 = 1
    L_0x0090:
        int r9 = r9 + 1
        goto L_0x0066
    L_0x0093:
        if (r3 != 0) goto L_0x0099
        r10.abortCreation(r12)
        return r2
    L_0x0099:
        boolean r11 = r10.freeze(r12)
        if (r11 != 0) goto L_0x00a0
        return r2
    L_0x00a0:
        android.graphics.Typeface r11 = r10.createFromFamiliesWithDefault(r12)
        if (r11 != 0) goto L_0x00a7
        return r2
    L_0x00a7:
        android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r14)
        return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, null)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }

    /* access modifiers changed from: protected */
    public Class obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    /* access modifiers changed from: protected */
    public Constructor obtainFontFamilyCtor(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method obtainAddFontFromAssetManagerMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method obtainAddFontFromBufferMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    /* access modifiers changed from: protected */
    public Method obtainFreezeMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(FREEZE_METHOD, new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method obtainAbortCreationMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
