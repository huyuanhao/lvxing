package p005cn.bingoogolapple.qrcode.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Map;
import p005cn.bingoogolapple.qrcode.core.BarcodeType;
import p005cn.bingoogolapple.qrcode.core.QRCodeView;
import p005cn.bingoogolapple.qrcode.core.ScanResult;

/* renamed from: cn.bingoogolapple.qrcode.zxing.ZXingView */
public class ZXingView extends QRCodeView {
    /* renamed from: j */
    private MultiFormatReader f1203j;
    /* renamed from: k */
    private Map<DecodeHintType, Object> f1204k;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9628a() {
        this.f1203j = new MultiFormatReader();
        if (this.f1128i == BarcodeType.ONE_DIMENSION) {
            this.f1203j.setHints(QRCodeDecoder.f1206b);
        } else if (this.f1128i == BarcodeType.TWO_DIMENSION) {
            this.f1203j.setHints(QRCodeDecoder.f1207c);
        } else if (this.f1128i == BarcodeType.ONLY_QR_CODE) {
            this.f1203j.setHints(QRCodeDecoder.f1208d);
        } else if (this.f1128i == BarcodeType.ONLY_CODE_128) {
            this.f1203j.setHints(QRCodeDecoder.f1209e);
        } else if (this.f1128i == BarcodeType.ONLY_EAN_13) {
            this.f1203j.setHints(QRCodeDecoder.f1210f);
        } else if (this.f1128i == BarcodeType.HIGH_FREQUENCY) {
            this.f1203j.setHints(QRCodeDecoder.f1211g);
        } else if (this.f1128i == BarcodeType.CUSTOM) {
            this.f1203j.setHints(this.f1204k);
        } else {
            this.f1203j.setHints(QRCodeDecoder.f1205a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ScanResult mo9626a(Bitmap bitmap) {
        return new ScanResult(QRCodeDecoder.m1054a(bitmap));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* renamed from: a */
    public p005cn.bingoogolapple.qrcode.core.ScanResult mo9627a(byte[] r15, int r16, int r17, boolean r18) {
        /*
        r14 = this;
        r1 = r14
        r2 = 0
        cn.bingoogolapple.qrcode.core.ScanBoxView r0 = r1.f1122c     // Catch:{ Exception -> 0x006a }
        r10 = r17
        android.graphics.Rect r12 = r0.mo9645a(r10)     // Catch:{ Exception -> 0x006a }
        if (r12 == 0) goto L_0x0027
        com.google.zxing.PlanarYUVLuminanceSource r0 = new com.google.zxing.PlanarYUVLuminanceSource     // Catch:{ Exception -> 0x0065 }
        int r7 = r12.left     // Catch:{ Exception -> 0x0065 }
        int r8 = r12.top     // Catch:{ Exception -> 0x0065 }
        int r9 = r12.width()     // Catch:{ Exception -> 0x0065 }
        int r11 = r12.height()     // Catch:{ Exception -> 0x0065 }
        r13 = 0
        r3 = r0
        r4 = r15
        r5 = r16
        r6 = r17
        r10 = r11
        r11 = r13
        r3.m45053init(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0065 }
        goto L_0x0039
    L_0x0027:
        com.google.zxing.PlanarYUVLuminanceSource r0 = new com.google.zxing.PlanarYUVLuminanceSource     // Catch:{ Exception -> 0x0065 }
        r7 = 0
        r8 = 0
        r11 = 0
        r3 = r0
        r4 = r15
        r5 = r16
        r6 = r17
        r9 = r16
        r10 = r17
        r3.m45053init(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0065 }
    L_0x0039:
        com.google.zxing.MultiFormatReader r3 = r1.f1203j     // Catch:{ Exception -> 0x0065 }
        com.google.zxing.BinaryBitmap r4 = new com.google.zxing.BinaryBitmap     // Catch:{ Exception -> 0x0065 }
        com.google.zxing.common.GlobalHistogramBinarizer r5 = new com.google.zxing.common.GlobalHistogramBinarizer     // Catch:{ Exception -> 0x0065 }
        r5.m45160init(r0)     // Catch:{ Exception -> 0x0065 }
        r4.m45034init(r5)     // Catch:{ Exception -> 0x0065 }
        com.google.zxing.Result r3 = r3.decodeWithState(r4)     // Catch:{ Exception -> 0x0065 }
        if (r3 != 0) goto L_0x0070
        com.google.zxing.MultiFormatReader r4 = r1.f1203j     // Catch:{ Exception -> 0x0063 }
        com.google.zxing.BinaryBitmap r5 = new com.google.zxing.BinaryBitmap     // Catch:{ Exception -> 0x0063 }
        com.google.zxing.common.HybridBinarizer r6 = new com.google.zxing.common.HybridBinarizer     // Catch:{ Exception -> 0x0063 }
        r6.m45163init(r0)     // Catch:{ Exception -> 0x0063 }
        r5.m45034init(r6)     // Catch:{ Exception -> 0x0063 }
        com.google.zxing.Result r3 = r4.decodeWithState(r5)     // Catch:{ Exception -> 0x0063 }
        if (r3 == 0) goto L_0x0070
        java.lang.String r0 = "GlobalHistogramBinarizer 没识别到，HybridBinarizer 能识别到"
        p005cn.bingoogolapple.qrcode.core.BGAQRCodeUtil.m1028a(r0)     // Catch:{ Exception -> 0x0063 }
        goto L_0x0070
    L_0x0063:
        r0 = move-exception
        goto L_0x006d
    L_0x0065:
        r0 = move-exception
        r3 = r2
        goto L_0x006d
    L_0x0068:
        r0 = move-exception
        goto L_0x00c8
    L_0x006a:
        r0 = move-exception
        r3 = r2
        r12 = r3
    L_0x006d:
        r0.printStackTrace()     // Catch:{ all -> 0x0068 }
    L_0x0070:
        com.google.zxing.MultiFormatReader r0 = r1.f1203j
        r0.reset()
        if (r3 == 0) goto L_0x00c2
        java.lang.String r2 = r3.getText()
        com.google.zxing.BarcodeFormat r0 = r3.getBarcodeFormat()
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "格式为："
        r4.append(r5)
        java.lang.String r0 = r0.name()
        r4.append(r0)
        java.lang.String r0 = r4.toString()
        p005cn.bingoogolapple.qrcode.core.BGAQRCodeUtil.m1028a(r0)
        boolean r0 = r14.mo9633b()
        if (r0 == 0) goto L_0x00c2
        com.google.zxing.ResultPoint[] r0 = r3.getResultPoints()
        int r3 = r0.length
        android.graphics.PointF[] r3 = new android.graphics.PointF[r3]
        int r4 = r0.length
        r5 = 0
        r6 = 0
    L_0x00a7:
        if (r5 >= r4) goto L_0x00bf
        r7 = r0[r5]
        android.graphics.PointF r8 = new android.graphics.PointF
        float r9 = r7.getX()
        float r7 = r7.getY()
        r8.<init>(r9, r7)
        r3[r6] = r8
        int r6 = r6 + 1
        int r5 = r5 + 1
        goto L_0x00a7
    L_0x00bf:
        r14.mo9631a(r3, r12)
    L_0x00c2:
        cn.bingoogolapple.qrcode.core.d r0 = new cn.bingoogolapple.qrcode.core.d
        r0.m40849init(r2)
        return r0
    L_0x00c8:
        com.google.zxing.MultiFormatReader r2 = r1.f1203j
        r2.reset()
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cn.bingoogolapple.qrcode.zxing.ZXingView.mo9627a(byte[], int, int, boolean):cn.bingoogolapple.qrcode.core.d");
    }
}
