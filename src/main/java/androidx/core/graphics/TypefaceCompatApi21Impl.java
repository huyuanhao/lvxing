package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class sFontFamily = null;
    private static Constructor sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    TypefaceCompatApi21Impl() {
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    private static void init() {
        /*
        boolean r0 = sHasInitBeenCalled
        if (r0 == 0) goto L_0x0005
        return
    L_0x0005:
        r0 = 1
        sHasInitBeenCalled = r0
        r1 = 0
        java.lang.String r2 = "android.graphics.FontFamily"
        java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r3 = 0
        java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.reflect.Constructor r4 = r2.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.String r5 = "addFontWeightStyle"
        r6 = 3
        java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.Class<java.lang.String> r7 = java.lang.String.class
        r6[r3] = r7     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r6[r0] = r7     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r7 = 2
        java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r6[r7] = r8     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.reflect.Method r5 = r2.getMethod(r5, r6)     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.Object r6 = java.lang.reflect.Array.newInstance(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.Class<android.graphics.Typeface> r7 = android.graphics.Typeface.class
        java.lang.String r8 = "createFromFamiliesWithDefault"
        java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.Class r6 = r6.getClass()     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r0[r3] = r6     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        java.lang.reflect.Method r1 = r7.getMethod(r8, r0)     // Catch:{ ClassNotFoundException -> 0x0045, NoSuchMethodException -> 0x0043 }
        r0 = r1
        r1 = r4
        goto L_0x0056
    L_0x0043:
        r0 = move-exception
        goto L_0x0046
    L_0x0045:
        r0 = move-exception
    L_0x0046:
        java.lang.Class r2 = r0.getClass()
        java.lang.String r2 = r2.getName()
        java.lang.String r3 = "TypefaceCompatApi21Impl"
        android.util.Log.e(r3, r2, r0)
        r0 = r1
        r2 = r0
        r5 = r2
    L_0x0056:
        sFontFamilyCtor = r1
        sFontFamily = r2
        sAddFontWeightStyle = r5
        sCreateFromFamiliesWithDefault = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.init():void");
    }

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/self/fd/");
            sb.append(parcelFileDescriptor.getFd());
            String readlink = Os.readlink(sb.toString());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Object newFamily() {
        init();
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        init();
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontWeightStyle(Object obj, String str, int i, boolean z) {
        init();
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004f, code lost:
            r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
            r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0058, code lost:
            throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005b, code lost:
            r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x005c, code lost:
            if (r5 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0066, code lost:
            throw r6;
     */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r4, android.os.CancellationSignal r5, androidx.core.provider.FontsContractCompat.FontInfo[] r6, int r7) {
        /*
        r3 = this;
        int r0 = r6.length
        r1 = 0
        r2 = 1
        if (r0 >= r2) goto L_0x0006
        return r1
    L_0x0006:
        androidx.core.provider.FontsContractCompat$FontInfo r6 = r3.findBestInfo(r6, r7)
        android.content.ContentResolver r7 = r4.getContentResolver()
        android.net.Uri r6 = r6.getUri()     // Catch:{ IOException -> 0x0067 }
        java.lang.String r0 = "r"
        android.os.ParcelFileDescriptor r5 = r7.openFileDescriptor(r6, r0, r5)     // Catch:{ IOException -> 0x0067 }
        if (r5 != 0) goto L_0x0020
        if (r5 == 0) goto L_0x001f
        r5.close()     // Catch:{ IOException -> 0x0067 }
    L_0x001f:
        return r1
    L_0x0020:
        java.io.File r6 = r3.getFile(r5)     // Catch:{ all -> 0x0059 }
        if (r6 == 0) goto L_0x0037
        boolean r7 = r6.canRead()     // Catch:{ all -> 0x0059 }
        if (r7 != 0) goto L_0x002d
        goto L_0x0037
    L_0x002d:
        android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r6)     // Catch:{ all -> 0x0059 }
        if (r5 == 0) goto L_0x0036
        r5.close()     // Catch:{ IOException -> 0x0067 }
    L_0x0036:
        return r4
    L_0x0037:
        java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x0059 }
        java.io.FileDescriptor r7 = r5.getFileDescriptor()     // Catch:{ all -> 0x0059 }
        r6.<init>(r7)     // Catch:{ all -> 0x0059 }
        android.graphics.Typeface r4 = super.createFromInputStream(r4, r6)     // Catch:{ all -> 0x004d }
        r6.close()     // Catch:{ all -> 0x0059 }
        if (r5 == 0) goto L_0x004c
        r5.close()     // Catch:{ IOException -> 0x0067 }
    L_0x004c:
        return r4
    L_0x004d:
        r4 = move-exception
        throw r4     // Catch:{ all -> 0x004f }
    L_0x004f:
        r7 = move-exception
        r6.close()     // Catch:{ all -> 0x0054 }
        goto L_0x0058
    L_0x0054:
        r6 = move-exception
        r4.addSuppressed(r6)     // Catch:{ all -> 0x0059 }
    L_0x0058:
        throw r7     // Catch:{ all -> 0x0059 }
    L_0x0059:
        r4 = move-exception
        throw r4     // Catch:{ all -> 0x005b }
    L_0x005b:
        r6 = move-exception
        if (r5 == 0) goto L_0x0066
        r5.close()     // Catch:{ all -> 0x0062 }
        goto L_0x0066
    L_0x0062:
        r5 = move-exception
        r4.addSuppressed(r5)     // Catch:{ IOException -> 0x0067 }
    L_0x0066:
        throw r6     // Catch:{ IOException -> 0x0067 }
    L_0x0067:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object newFamily = newFamily();
        FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i2 = 0;
        while (i2 < length) {
            FontFileResourceEntry fontFileResourceEntry = entries[i2];
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                    tempFile.delete();
                    return null;
                } else if (!addFontWeightStyle(newFamily, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                    return null;
                } else {
                    tempFile.delete();
                    i2++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }
}
