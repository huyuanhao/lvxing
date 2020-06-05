package p005cn.bingoogolapple.qrcode.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: cn.bingoogolapple.qrcode.zxing.a */
public class QRCodeDecoder {
    /* renamed from: a */
    static final Map<DecodeHintType, Object> f1205a = new EnumMap(DecodeHintType.class);
    /* renamed from: b */
    static final Map<DecodeHintType, Object> f1206b = new EnumMap(DecodeHintType.class);
    /* renamed from: c */
    static final Map<DecodeHintType, Object> f1207c = new EnumMap(DecodeHintType.class);
    /* renamed from: d */
    static final Map<DecodeHintType, Object> f1208d = new EnumMap(DecodeHintType.class);
    /* renamed from: e */
    static final Map<DecodeHintType, Object> f1209e = new EnumMap(DecodeHintType.class);
    /* renamed from: f */
    static final Map<DecodeHintType, Object> f1210f = new EnumMap(DecodeHintType.class);
    /* renamed from: g */
    static final Map<DecodeHintType, Object> f1211g = new EnumMap(DecodeHintType.class);

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f1205a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        f1205a.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        String str = "utf-8";
        f1205a.put(DecodeHintType.CHARACTER_SET, str);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BarcodeFormat.CODABAR);
        arrayList2.add(BarcodeFormat.CODE_39);
        arrayList2.add(BarcodeFormat.CODE_93);
        arrayList2.add(BarcodeFormat.CODE_128);
        arrayList2.add(BarcodeFormat.EAN_8);
        arrayList2.add(BarcodeFormat.EAN_13);
        arrayList2.add(BarcodeFormat.ITF);
        arrayList2.add(BarcodeFormat.PDF_417);
        arrayList2.add(BarcodeFormat.RSS_14);
        arrayList2.add(BarcodeFormat.RSS_EXPANDED);
        arrayList2.add(BarcodeFormat.UPC_A);
        arrayList2.add(BarcodeFormat.UPC_E);
        arrayList2.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f1206b.put(DecodeHintType.POSSIBLE_FORMATS, arrayList2);
        f1206b.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1206b.put(DecodeHintType.CHARACTER_SET, str);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(BarcodeFormat.AZTEC);
        arrayList3.add(BarcodeFormat.DATA_MATRIX);
        arrayList3.add(BarcodeFormat.MAXICODE);
        arrayList3.add(BarcodeFormat.QR_CODE);
        f1207c.put(DecodeHintType.POSSIBLE_FORMATS, arrayList3);
        f1207c.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1207c.put(DecodeHintType.CHARACTER_SET, str);
        f1208d.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.QR_CODE));
        f1208d.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1208d.put(DecodeHintType.CHARACTER_SET, str);
        f1209e.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.CODE_128));
        f1209e.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1209e.put(DecodeHintType.CHARACTER_SET, str);
        f1210f.put(DecodeHintType.POSSIBLE_FORMATS, Collections.singletonList(BarcodeFormat.EAN_13));
        f1210f.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1210f.put(DecodeHintType.CHARACTER_SET, str);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(BarcodeFormat.QR_CODE);
        arrayList4.add(BarcodeFormat.EAN_13);
        arrayList4.add(BarcodeFormat.CODE_128);
        f1211g.put(DecodeHintType.POSSIBLE_FORMATS, arrayList4);
        f1211g.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f1211g.put(DecodeHintType.CHARACTER_SET, str);
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [com.google.zxing.LuminanceSource] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v7, types: [com.google.zxing.LuminanceSource, com.google.zxing.RGBLuminanceSource] */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v8
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
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[SYNTHETIC, Splitter:B:11:0x0040] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: a */
    public static java.lang.String m1054a(android.graphics.Bitmap r12) {
        /*
        r0 = 0
        int r9 = r12.getWidth()     // Catch:{ Exception -> 0x0039 }
        int r10 = r12.getHeight()     // Catch:{ Exception -> 0x0039 }
        int r1 = r9 * r10
        int[] r11 = new int[r1]     // Catch:{ Exception -> 0x0039 }
        r3 = 0
        r5 = 0
        r6 = 0
        r1 = r12
        r2 = r11
        r4 = r9
        r7 = r9
        r8 = r10
        r1.getPixels(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0039 }
        com.google.zxing.RGBLuminanceSource r12 = new com.google.zxing.RGBLuminanceSource     // Catch:{ Exception -> 0x0039 }
        r12.m45054init(r9, r10, r11)     // Catch:{ Exception -> 0x0039 }
        com.google.zxing.MultiFormatReader r1 = new com.google.zxing.MultiFormatReader     // Catch:{ Exception -> 0x0037 }
        r1.m45048init()     // Catch:{ Exception -> 0x0037 }
        com.google.zxing.BinaryBitmap r2 = new com.google.zxing.BinaryBitmap     // Catch:{ Exception -> 0x0037 }
        com.google.zxing.common.HybridBinarizer r3 = new com.google.zxing.common.HybridBinarizer     // Catch:{ Exception -> 0x0037 }
        r3.m45163init(r12)     // Catch:{ Exception -> 0x0037 }
        r2.m45034init(r3)     // Catch:{ Exception -> 0x0037 }
        java.util.Map<com.google.zxing.DecodeHintType, java.lang.Object> r3 = f1205a     // Catch:{ Exception -> 0x0037 }
        com.google.zxing.Result r1 = r1.decode(r2, r3)     // Catch:{ Exception -> 0x0037 }
        java.lang.String r12 = r1.getText()     // Catch:{ Exception -> 0x0037 }
        return r12
    L_0x0037:
        r1 = move-exception
        goto L_0x003b
    L_0x0039:
        r1 = move-exception
        r12 = r0
    L_0x003b:
        r1.printStackTrace()
        if (r12 == 0) goto L_0x005e
        com.google.zxing.MultiFormatReader r1 = new com.google.zxing.MultiFormatReader     // Catch:{ all -> 0x005a }
        r1.m45048init()     // Catch:{ all -> 0x005a }
        com.google.zxing.BinaryBitmap r2 = new com.google.zxing.BinaryBitmap     // Catch:{ all -> 0x005a }
        com.google.zxing.common.GlobalHistogramBinarizer r3 = new com.google.zxing.common.GlobalHistogramBinarizer     // Catch:{ all -> 0x005a }
        r3.m45160init(r12)     // Catch:{ all -> 0x005a }
        r2.m45034init(r3)     // Catch:{ all -> 0x005a }
        java.util.Map<com.google.zxing.DecodeHintType, java.lang.Object> r12 = f1205a     // Catch:{ all -> 0x005a }
        com.google.zxing.Result r12 = r1.decode(r2, r12)     // Catch:{ all -> 0x005a }
        java.lang.String r12 = r12.getText()     // Catch:{ all -> 0x005a }
        return r12
    L_0x005a:
        r12 = move-exception
        r12.printStackTrace()
    L_0x005e:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cn.bingoogolapple.qrcode.zxing.QRCodeDecoder.m1054a(android.graphics.Bitmap):java.lang.String");
    }
}
