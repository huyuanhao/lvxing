package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ai */
public class UIUtils {
    /* renamed from: a */
    private static float f9127a = -1.0f;
    /* renamed from: b */
    private static int f9128b = -1;
    /* renamed from: c */
    private static float f9129c = -1.0f;
    /* renamed from: d */
    private static int f9130d = -1;
    /* renamed from: e */
    private static int f9131e = -1;
    /* renamed from: f */
    private static WindowManager f9132f;

    /* renamed from: a */
    private static boolean m12066a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    static {
        m12054a(InternalContainer.m10059a());
    }

    /* renamed from: a */
    private static boolean m12065a() {
        return f9127a < 0.0f || f9128b < 0 || f9129c < 0.0f || f9130d < 0 || f9131e < 0;
    }

    /* renamed from: a */
    public static void m12054a(Context context) {
        Context a = context == null ? InternalContainer.m10059a() : context;
        f9132f = (WindowManager) InternalContainer.m10059a().getSystemService("window");
        if (a != null) {
            if (m12065a()) {
                DisplayMetrics displayMetrics = a.getResources().getDisplayMetrics();
                f9127a = displayMetrics.density;
                f9128b = displayMetrics.densityDpi;
                f9129c = displayMetrics.scaledDensity;
                f9130d = displayMetrics.widthPixels;
                f9131e = displayMetrics.heightPixels;
            }
            if (!(context == null || context.getResources() == null || context.getResources().getConfiguration() == null)) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    int i = f9130d;
                    int i2 = f9131e;
                    if (i > i2) {
                        f9130d = i2;
                        f9131e = i;
                    }
                } else {
                    int i3 = f9130d;
                    int i4 = f9131e;
                    if (i3 < i4) {
                        f9130d = i4;
                        f9131e = i3;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static float m12048a(Context context, float f) {
        m12054a(context);
        return (f * m12087e(context)) + 0.5f;
    }

    /* renamed from: b */
    public static int m12068b(Context context, float f) {
        m12054a(context);
        float e = m12087e(context);
        if (e <= 0.0f) {
            e = 1.0f;
        }
        return (int) ((f / e) + 0.5f);
    }

    /* renamed from: b */
    public static int[] m12076b(Context context) {
        if (context == null) {
            return null;
        }
        if (f9132f == null) {
            f9132f = (WindowManager) InternalContainer.m10059a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f9132f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (VERSION.SDK_INT >= 14 && VERSION.SDK_INT < 17) {
                try {
                    i = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                    i = point.x;
                    i2 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    /* renamed from: c */
    public static int m12078c(Context context) {
        m12054a(context);
        return f9130d;
    }

    /* renamed from: d */
    public static int m12084d(Context context) {
        m12054a(context);
        return f9131e;
    }

    /* renamed from: e */
    public static float m12087e(Context context) {
        m12054a(context);
        return f9127a;
    }

    /* renamed from: f */
    public static int m12089f(Context context) {
        m12054a(context);
        return f9128b;
    }

    /* renamed from: a */
    public static void m12060a(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new HackTouchDelegate(rect, view));
    }

    /* renamed from: a */
    public static int[] m12067a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    /* renamed from: b */
    public static int[] m12077b(View view) {
        if (view == null) {
            return null;
        }
        return new int[]{view.getWidth(), view.getHeight()};
    }

    /* renamed from: a */
    public static void m12059a(View view, int i) {
        if (view != null && view.getVisibility() != i && m12066a(i)) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    public static void m12058a(View view, float f) {
        if (view != null) {
            view.setAlpha(f);
        }
    }

    /* renamed from: c */
    public static boolean m12083c(View view) {
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: a */
    public static void m12064a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: b */
    public static void m12074b(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof MarginLayoutParams)) {
                m12063a(view, (MarginLayoutParams) layoutParams, i, i2, i3, i4);
            }
        }
    }

    /* renamed from: a */
    private static void m12063a(View view, MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view != null && marginLayoutParams != null) {
            if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.rightMargin != i3 || marginLayoutParams.bottomMargin != i4) {
                if (i != -3) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -3) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -3) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -3) {
                    marginLayoutParams.bottomMargin = i4;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* renamed from: b */
    public static Bitmap m12069b(View view, int i) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        try {
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = view.getDrawingCache();
            if (i > 0 && bitmap != null) {
                if (bitmap.getRowBytes() * bitmap.getHeight() >= i) {
                    bitmap = BitmapUtils.m12135a(bitmap, 720, 0);
                }
                if (bitmap.getRowBytes() * bitmap.getHeight() >= i) {
                    bitmap = BitmapUtils.m12134a(bitmap, i);
                }
                if (bitmap != null && C2564t.m12224c()) {
                    int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                    StringBuilder sb = new StringBuilder();
                    sb.append("size: ");
                    sb.append(rowBytes);
                    C2564t.m12214a(sb.toString());
                }
            }
        } catch (Exception unused) {
        }
        return bitmap;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static Bitmap m12080c(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            if (capturePicture == null) {
                return null;
            }
            if (capturePicture.getWidth() > 0) {
                if (capturePicture.getHeight() > 0) {
                    bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Config.ARGB_8888);
                    capturePicture.draw(new Canvas(bitmap));
                }
            }
            return bitmap;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public static void m12086d(final View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    UIUtils.m12059a(view, 8);
                    ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(0).start();
                }
            });
            ofFloat.setDuration(800);
            ofFloat.start();
        }
    }

    /* renamed from: e */
    public static void m12088e(View view) {
        if (view != null) {
            m12059a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300);
            ofFloat.start();
        }
    }

    /* renamed from: c */
    public static int m12079c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: g */
    public static int m12090g(Context context) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* renamed from: h */
    public static int m12091h(Context context) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: i */
    public static float m12092i(Context context) {
        if (context == null) {
            context = InternalContainer.m10059a();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return (float) context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    /* renamed from: a */
    public static void m12053a(Activity activity) {
        if (activity != null) {
            try {
                if (VERSION.SDK_INT <= 11 || VERSION.SDK_INT >= 19) {
                    if (VERSION.SDK_INT >= 19) {
                        activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                        activity.getWindow().addFlags(134217728);
                    }
                }
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static boolean m12075b(Activity activity) {
        if (m12050a("ro.miui.notch", activity) == 1 || m12093j(activity) || m12095l(activity) || m12094k(activity) || m12082c(activity)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m12082c(Activity activity) {
        if (VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            Class cls = Class.forName("android.view.WindowInsets");
            if (cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static int m12050a(String str, Activity activity) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (!RomUtils.m11951e()) {
            return 0;
        }
        try {
            Class loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            i5 = ((Integer) loadClass.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(loadClass, new Object[]{new String(str), new Integer(0)})).intValue();
            return i5;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return i;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return i2;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return i3;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return i4;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return i5;
        }
    }

    /* renamed from: j */
    public static boolean m12093j(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: k */
    public static boolean m12094k(Context context) {
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m12095l(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /* renamed from: a */
    public static void m12056a(final Context context, final MaterialMeta kVar, final String str, final WebView webView) {
        if (webView != null && kVar != null && kVar.mo15512z() == null) {
            webView.postDelayed(new Runnable() {
                public void run() {
                    final Bitmap b = UIUtils.m12069b((View) webView, 0);
                    if (b == null) {
                        b = UIUtils.m12080c(webView);
                    }
                    TTExecutor.m11692a().mo16808c(new Runnable() {
                        public void run() {
                            UIUtils.m12072b(context, kVar, str, b);
                        }
                    }, 5);
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m12072b(Context context, MaterialMeta kVar, String str, Bitmap bitmap) {
        MaterialMeta kVar2 = kVar;
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        StringBuilder sb = new StringBuilder();
        sb.append("checkWebViewIsTransparent start .....bitmap=");
        sb.append(bitmap2);
        sb.append(",materialMeta=");
        sb.append(kVar2);
        String str3 = "checkWebViewIsTransparent";
        C2564t.m12220b(str3, sb.toString());
        if (bitmap2 != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    if (!bitmap.isRecycled()) {
                        Bitmap a = BitmapUtils.m12135a(bitmap2, bitmap.getWidth() / 6, bitmap.getHeight() / 6);
                        if (a != null) {
                            if (!a.isRecycled()) {
                                int width = a.getWidth();
                                int height = a.getHeight();
                                double d = (double) (width * height);
                                long j = (long) (0.05d * d);
                                long j2 = (long) (d * 0.5d);
                                int i = 0;
                                int i2 = 0;
                                int i3 = 0;
                                while (i < height) {
                                    int i4 = i3;
                                    int i5 = i2;
                                    int i6 = 0;
                                    while (i6 < width) {
                                        int pixel = a.getPixel(i6, i);
                                        int red = Color.red(pixel);
                                        int green = Color.green(pixel);
                                        int blue = Color.blue(pixel);
                                        int alpha = Color.alpha(pixel);
                                        if (!(red == 0 && green == 0 && blue == 0)) {
                                            i5++;
                                        }
                                        if (red == 0 && green == 0 && blue == 0 && alpha == 0) {
                                            i4++;
                                        }
                                        int i7 = i;
                                        if (((long) i5) > j && i4 != i5) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("wwww-TAG=");
                                            sb2.append(str2);
                                            sb2.append(",checkWebViewIsTransparent....不满足透明不上报");
                                            C2564t.m12220b(str3, sb2.toString());
                                            return;
                                        } else if (((long) i4) >= j2) {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("TAG=");
                                            sb3.append(str2);
                                            sb3.append(",checkWebViewIsTransparent....满足透明上报..");
                                            C2564t.m12220b(str3, sb3.toString());
                                            AdEventManager.m8400b(context, kVar2, str2, null);
                                            return;
                                        } else {
                                            Context context2 = context;
                                            i6++;
                                            i = i7;
                                        }
                                    }
                                    Context context3 = context;
                                    i++;
                                    i2 = i5;
                                    i3 = i4;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>");
                sb4.append(th.toString());
                C2564t.m12226e("UIUtils", sb4.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m12061a(View view, OnClickListener onClickListener, String str) {
        if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is null , can not set OnClickListener !!!");
            C2564t.m12226e("OnclickListener ", sb.toString());
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public static void m12062a(View view, OnTouchListener onTouchListener, String str) {
        if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is null , can not set OnTouchListener !!!");
            C2564t.m12226e("OnTouchListener ", sb.toString());
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    /* renamed from: a */
    public static Bitmap m12052a(WebView webView) {
        webView.setLayerType(1, null);
        Bitmap d = m12085d(webView);
        if (d == null) {
            d = m12080c(webView);
        }
        webView.setLayerType(2, null);
        if (d == null) {
            return null;
        }
        return m12051a(d, d.getWidth() / 6, d.getHeight() / 6);
    }

    /* renamed from: a */
    public static void m12057a(Context context, MaterialMeta kVar, String str, String str2, Bitmap bitmap) {
        TTExecutor a = TTExecutor.m11692a();
        final Context context2 = context;
        final MaterialMeta kVar2 = kVar;
        final String str3 = str;
        final String str4 = str2;
        final Bitmap bitmap2 = bitmap;
        C25374 r1 = new Runnable() {
            public void run() {
                UIUtils.m12081c(context2, kVar2, str3, str4, bitmap2);
            }
        };
        a.mo16808c(r1, 5);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static void m12081c(Context context, MaterialMeta kVar, String str, String str2, Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    if (!bitmap.isRecycled()) {
                        int a = m12049a(bitmap);
                        if (a >= 50) {
                            AdEventManager.m8383a(context, kVar, str, str2, a);
                        }
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>");
                sb.append(th.toString());
                C2564t.m12226e("UIUtils", sb.toString());
            }
        }
    }

    /* renamed from: b */
    private static ArrayList<Integer> m12071b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i) >> 16, (65280 & i) >> 8, i & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static int m12049a(Bitmap bitmap) {
        try {
            ArrayList b = m12071b(bitmap);
            if (b == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator it = b.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (hashMap.containsKey(num)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(num)).intValue() + 1);
                    hashMap.remove(num);
                    hashMap.put(num, valueOf);
                } else {
                    hashMap.put(num, Integer.valueOf(1));
                }
            }
            int i = 0;
            int i2 = 0;
            for (Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i2 < intValue) {
                    i = ((Integer) entry.getKey()).intValue();
                    i2 = intValue;
                }
            }
            if (i == 0) {
                return -1;
            }
            return (int) ((((float) i2) / (((float) (bitmap.getWidth() * bitmap.getHeight())) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: d */
    private static Bitmap m12085d(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            webView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();
            if (webView.getMeasuredWidth() > 0) {
                if (webView.getMeasuredHeight() > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(createBitmap, 0.0f, (float) createBitmap.getHeight(), new Paint());
                    webView.draw(canvas);
                    return createBitmap;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static Bitmap m12051a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0) {
                if (height > 0) {
                    if (i < width) {
                        if (i2 < height) {
                            float f = ((float) i) / ((float) width);
                            float f2 = ((float) i2) / ((float) height);
                            Matrix matrix = new Matrix();
                            matrix.postScale(f, f2);
                            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                        }
                    }
                }
            }
            return bitmap;
        } catch (Exception unused) {
            return null;
        }
    }
}
