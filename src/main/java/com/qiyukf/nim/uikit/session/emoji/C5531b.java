package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Xml;
import android.util.Xml.Encoding;
import androidx.collection.LruCache;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nim.uikit.C5433b;
import com.tencent.p605ep.commonbase.api.ConfigManager.OEM;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.b */
public final class C5531b {
    /* renamed from: a */
    private static Pattern f17831a = Pattern.compile("\\[[^\\[\\]]{1,10}\\]");
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final List<C5533a> f17832b = new ArrayList();
    /* access modifiers changed from: private|static|final */
    /* renamed from: c */
    public static final Map<String, C5533a> f17833c = new HashMap();
    /* renamed from: d */
    private static LruCache<String, Bitmap> f17834d = new LruCache<String, Bitmap>() {
        /* access modifiers changed from: protected|final|synthetic */
        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != ((Bitmap) obj3)) {
                bitmap.recycle();
            }
        }
    };

    /* renamed from: com.qiyukf.nim.uikit.session.emoji.b$a */
    private static class C5533a {
        /* renamed from: a */
        String f17835a;
        /* renamed from: b */
        String f17836b;

        C5533a(String str, String str2) {
            this.f17835a = str;
            this.f17836b = str2;
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.session.emoji.b$b */
    private static class C5534b extends DefaultHandler {
        /* renamed from: a */
        private String f17837a;

        private C5534b() {
            this.f17837a = "";
        }

        /* synthetic */ C5534b(byte b) {
            this();
        }

        public final void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("Catalog")) {
                this.f17837a = attributes.getValue(str, "Title");
                return;
            }
            if (str2.equals("Emoticon")) {
                String value = attributes.getValue(str, "Tag");
                String value2 = attributes.getValue(str, "File");
                StringBuilder sb = new StringBuilder("unicorn_emoji/");
                sb.append(this.f17837a);
                sb.append("/");
                sb.append(value2);
                C5533a aVar = new C5533a(value, sb.toString());
                C5531b.f17833c.put(aVar.f17835a, aVar);
                if (this.f17837a.equals(OEM.DEFAULT)) {
                    C5531b.f17832b.add(aVar);
                }
            }
        }
    }

    static {
        String str = "load is error assetPath";
        String str2 = "EntryLoader";
        Context a = C5433b.m22189a();
        String str3 = "unicorn_emoji/emoji.xml";
        C5534b bVar = new C5534b(0);
        InputStream inputStream = null;
        try {
            inputStream = a.getAssets().open(str3);
            Xml.parse(inputStream, Encoding.UTF_8, bVar);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(str3);
            C5264a.m21621b(str2, sb.toString(), e2);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (SAXException e3) {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(str3);
            C5264a.m21621b(str2, sb2.toString(), e3);
            if (inputStream != null) {
                inputStream.close();
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static final int m22508a() {
        return f17832b.size();
    }

    /* renamed from: a */
    public static final Drawable m22509a(Context context, int i) {
        String str = (i < 0 || i >= f17832b.size()) ? null : ((C5533a) f17832b.get(i)).f17835a;
        if (str == null) {
            return null;
        }
        return m22510a(context, str);
    }

    /* renamed from: a */
    public static final Drawable m22510a(Context context, String str) {
        C5533a aVar = (C5533a) f17833c.get(str);
        if (aVar == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) f17834d.get(aVar.f17836b);
        if (bitmap == null) {
            bitmap = m22512b(context, aVar.f17836b);
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    /* renamed from: a */
    public static final String m22511a(int i) {
        if (i < 0 || i >= f17832b.size()) {
            return null;
        }
        return ((C5533a) f17832b.get(i)).f17835a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[SYNTHETIC, Splitter:B:22:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC, Splitter:B:29:0x006d] */
    /* renamed from: b */
    private static android.graphics.Bitmap m22512b(android.content.Context r7, java.lang.String r8) {
        /*
        java.lang.String r0 = "InputStream close is error"
        java.lang.String r1 = "EmojiManager"
        r2 = 0
        android.content.res.Resources r3 = r7.getResources()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r4.<init>()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r5 = 240(0xf0, float:3.36E-43)
        r4.inDensity = r5     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        android.util.DisplayMetrics r5 = r3.getDisplayMetrics()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        int r5 = r5.densityDpi     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r4.inScreenDensity = r5     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        int r3 = r3.densityDpi     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        r4.inTargetDensity = r3     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        java.io.InputStream r7 = r7.open(r8)     // Catch:{ Exception -> 0x004a, all -> 0x0047 }
        android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x0045 }
        r3.<init>()     // Catch:{ Exception -> 0x0045 }
        android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r7, r3, r4)     // Catch:{ Exception -> 0x0045 }
        if (r3 == 0) goto L_0x003a
        androidx.collection.LruCache<java.lang.String, android.graphics.Bitmap> r4 = f17834d     // Catch:{ Exception -> 0x0045 }
        r4.put(r8, r3)     // Catch:{ Exception -> 0x0045 }
    L_0x003a:
        if (r7 == 0) goto L_0x0044
        r7.close()     // Catch:{ IOException -> 0x0040 }
        goto L_0x0044
    L_0x0040:
        r7 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r7)
    L_0x0044:
        return r3
    L_0x0045:
        r3 = move-exception
        goto L_0x004c
    L_0x0047:
        r8 = move-exception
        r7 = r2
        goto L_0x006b
    L_0x004a:
        r3 = move-exception
        r7 = r2
    L_0x004c:
        java.lang.String r4 = "EmojiManager loadAssetBitmap is error"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
        java.lang.String r6 = "assetPath:"
        r5.<init>(r6)     // Catch:{ all -> 0x006a }
        r5.append(r8)     // Catch:{ all -> 0x006a }
        java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x006a }
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r4, r8, r3)     // Catch:{ all -> 0x006a }
        if (r7 == 0) goto L_0x0069
        r7.close()     // Catch:{ IOException -> 0x0065 }
        goto L_0x0069
    L_0x0065:
        r7 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r7)
    L_0x0069:
        return r2
    L_0x006a:
        r8 = move-exception
    L_0x006b:
        if (r7 == 0) goto L_0x0075
        r7.close()     // Catch:{ IOException -> 0x0071 }
        goto L_0x0075
    L_0x0071:
        r7 = move-exception
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r1, r0, r7)
    L_0x0075:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.emoji.C5531b.m22512b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: b */
    public static final Pattern m22513b() {
        return f17831a;
    }
}
