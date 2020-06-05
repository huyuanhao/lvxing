package ezy.p653ui.widget.round;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: ezy.ui.widget.round.RoundUtil */
public class RoundUtil {
    private RoundUtil() {
    }

    public static int darker(int i, float f) {
        if ((i >> 24) == 0) {
            i = 578846848;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = fArr[2] * f;
        return Color.HSVToColor(i >> 24, fArr);
    }

    public static ColorStateList csl(int i, float f) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[0]}, new int[]{darker(i, f), i});
    }

    public static int[] parseGradientColors(int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (i2 != -1) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 != -1) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    public static int[] parseGradientColors(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = StorageInterface.KEY_SPLITER;
            if (str.contains(str2)) {
                String[] split = str.split(str2);
                int[] iArr = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    iArr[i] = Color.parseColor(split[i]);
                }
                return iArr;
            }
        }
        return null;
    }

    public static Orientation parseGradientOrientation(int i) {
        switch (i) {
            case 0:
                return Orientation.TOP_BOTTOM;
            case 1:
                return Orientation.TR_BL;
            case 2:
                return Orientation.RIGHT_LEFT;
            case 3:
                return Orientation.BR_TL;
            case 4:
                return Orientation.BOTTOM_TOP;
            case 5:
                return Orientation.BL_TR;
            case 6:
                return Orientation.LEFT_RIGHT;
            case 7:
                return Orientation.TL_BR;
            default:
                return Orientation.TOP_BOTTOM;
        }
    }

    public static Paint initShadowPaint(int i, int i2, int i3, int i4) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setStyle(Style.FILL);
        paint.setShadowLayer((float) i2, (float) i3, (float) i4, i);
        return paint;
    }
}
