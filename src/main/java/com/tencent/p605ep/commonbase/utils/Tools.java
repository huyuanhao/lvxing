package com.tencent.p605ep.commonbase.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.format.Formatter;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/* renamed from: com.tencent.ep.commonbase.utils.Tools */
public class Tools {
    static final String TAG = "Tools";
    public static final short version = 4352;

    public static String assertNotNullString(String str) {
        return str == null ? "" : str;
    }

    public static boolean checkCustomizeMod(int i, int i2) {
        return (i & i2) != 0;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String formatSensitiveNumber(String str, int i, int i2) {
        if (str == null || i + i2 >= str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, i));
        sb.append("***");
        sb.append(str.substring(str.length() - i2));
        return sb.toString();
    }

    public static AlphaAnimation getAlphaAnimation(float f, float f2, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        return alphaAnimation;
    }

    public static byte[] getMD5(String str) {
        MessageDigest messageDigest;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (messageDigest == null) {
            return null;
        }
        return messageDigest.digest();
    }

    public static ScaleAnimation getScaleAnimationToSelf(float f, float f2, float f3, float f4, float f5, float f6, long j) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, 1, f5, 1, f6);
        scaleAnimation.setDuration(j);
        return scaleAnimation;
    }

    public static String getSizeStr(Context context, long j) {
        return j == -1 ? "0" : Formatter.formatFileSize(context, j);
    }

    public static String getStandarTotal(int i) {
        String str;
        String str2 = "";
        if (i <= 0) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (i > 99) {
            str = "99+";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(str2);
            str = sb2.toString();
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static TranslateAnimation getTranslateAnimationToSelf(float f, float f2, float f3, float f4, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f, 1, f2, 1, f3, 1, f4);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    public static final boolean isContainHtml(String str) {
        return str != null && Pattern.compile("[a-zA-z]+://[^一-龥]*", 2).matcher(str).find();
    }

    public static void openBrower(String str, Context context) {
        if (str != null) {
            String str2 = "http://";
            if (!str.startsWith(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                str = sb.toString();
            }
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String parseDateToString(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String splitString(String str, int i) {
        String str2 = "Unicode";
        String str3 = "";
        if (str == null || str.equals(str3)) {
            return str3;
        }
        try {
            byte[] bytes = str.getBytes(str2);
            int i2 = 2;
            if (bytes.length >= i) {
                str3 = "...";
            }
            String str4 = str3;
            int i3 = 0;
            while (i2 < bytes.length && i3 < i) {
                if (i2 % 2 != 1) {
                    if (bytes[i2] == 0) {
                        i2++;
                    }
                }
                i3++;
                i2++;
            }
            if (i2 % 2 == 1) {
                int i4 = i2 - 1;
                i2 = bytes[i4] != 0 ? i4 : i2 + 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(new String(bytes, 0, i2, str2));
            sb.append(str4);
            str = sb.toString();
        } catch (Exception unused) {
        }
        return str;
    }

    public static String[] spliteString(String str, String str2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        String[] strArr = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int i2 = i + 1;
            strArr[i] = stringTokenizer.nextToken();
            i = i2;
        }
        return strArr;
    }

    public static String truncateString(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length && charArray[i] != 8203) {
            i++;
        }
        return str.substring(0, i);
    }

    public static String truncateString(String str, int i) {
        if (str == null) {
            return null;
        }
        String truncateString = truncateString(str);
        if (truncateString.length() > i) {
            StringBuilder sb = new StringBuilder();
            sb.append(truncateString.substring(0, i));
            sb.append("...");
            truncateString = sb.toString();
        }
        return truncateString;
    }
}
