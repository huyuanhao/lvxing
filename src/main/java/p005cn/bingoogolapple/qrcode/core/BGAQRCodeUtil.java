package p005cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: cn.bingoogolapple.qrcode.core.a */
public class BGAQRCodeUtil {
    /* renamed from: a */
    private static boolean f1190a;

    /* renamed from: a */
    public static boolean m1029a() {
        return f1190a;
    }

    /* renamed from: a */
    public static void m1028a(String str) {
        if (f1190a) {
            Log.d("BGAQRCode", str);
        }
    }

    /* renamed from: b */
    public static void m1034b(String str) {
        if (f1190a) {
            Log.e("BGAQRCode", str);
        }
    }

    /* renamed from: a */
    public static boolean m1030a(Context context) {
        Point b = m1033b(context);
        return b.y > b.x;
    }

    /* renamed from: b */
    static Point m1033b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    /* renamed from: c */
    public static int m1035c(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843277});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (z) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = context.getResources().getDimensionPixelSize(identifier);
        }
        return i;
    }

    /* renamed from: a */
    public static int m1026a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    public static int m1031b(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    static Bitmap m1027a(Bitmap bitmap, int i) {
        float f;
        float f2;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        if (i == 90) {
            f = (float) bitmap.getHeight();
            f2 = 0.0f;
        } else {
            f = (float) bitmap.getHeight();
            f2 = (float) bitmap.getWidth();
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        matrix.postTranslate(f - fArr[2], f2 - fArr[5]);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    /* renamed from: b */
    static Bitmap m1032b(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: c */
    public static Bitmap m1036c(String str) {
        try {
            Options options = new Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outHeight / 400;
            if (i2 > 0) {
                i = i2;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
