package com.p368pw.inner.base.p387d.p390c;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.p368pw.inner.base.p387d.C5205o;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.pw.inner.base.d.c.a */
public class C5168a {
    /* renamed from: a */
    private static int m21325a(Vector<Rect> vector) {
        int size = vector.size();
        int i = size * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{i, i});
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Rect rect = (Rect) vector.elementAt(i4);
            int i5 = i2 + 1;
            iArr[i2] = rect.left;
            i2 = i5 + 1;
            iArr[i5] = rect.right;
            int i6 = i3 + 1;
            iArr2[i3] = rect.bottom;
            i3 = i6 + 1;
            iArr2[i6] = rect.top;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (int i7 = 0; i7 < size; i7++) {
            Rect rect2 = (Rect) vector.elementAt(i7);
            int a = m21326a(iArr, rect2.left);
            int a2 = m21326a(iArr, rect2.right);
            int a3 = m21326a(iArr2, rect2.top);
            int a4 = m21326a(iArr2, rect2.bottom);
            for (int i8 = a + 1; i8 <= a2; i8++) {
                for (int i9 = a3 + 1; i9 <= a4; i9++) {
                    zArr[i8][i9] = true;
                }
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            int i12 = i11;
            for (int i13 = 0; i13 < i; i13++) {
                i12 += zArr[i10][i13] ? (iArr[i10] - iArr[i10 - 1]) * (iArr2[i13] - iArr2[i13 - 1]) : 0;
            }
            i10++;
            i11 = i12;
        }
        return i11;
    }

    /* renamed from: a */
    private static int m21326a(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = ((length - i2) / 2) + i2;
            if (iArr[i3] == i) {
                return i3;
            }
            if (iArr[i3] > i) {
                length = i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static View m21327a(Context context, View view) {
        View d = m21337d(context);
        return d != null ? d : m21328a(view);
    }

    /* renamed from: a */
    public static View m21328a(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        if (findViewById != null) {
            rootView = findViewById;
        }
        return rootView;
    }

    /* renamed from: a */
    public static Map<String, String> m21329a(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("kgr", String.valueOf(m21333b(context)));
            if (context == null || !(context instanceof Activity)) {
                str = "Invalid Activity context in window interactive check, assuming interactive.";
            } else {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    int i = window.getAttributes().flags;
                    hashMap.put("wt", Integer.toString(window.getAttributes().type));
                    String str2 = "1";
                    String str3 = "0";
                    hashMap.put("wfdkg", (4194304 & i) > 0 ? str2 : str3);
                    if ((524288 & i) <= 0) {
                        str2 = str3;
                    }
                    hashMap.put("wfswl", str2);
                    return hashMap;
                }
                str = "Invalid window in window interactive check, assuming interactive.";
            }
            C5205o.m21462a(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception in window info check");
            sb.append(e.getMessage());
            C5205o.m21462a(sb.toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    public static boolean m21330a(View view, int i) {
        String sb;
        if (view == null) {
            sb = "adView is null.";
        } else if (view.getParent() == null) {
            sb = "adView has no parent.";
        } else if (!view.isShown()) {
            sb = "adView parent is not set to VISIBLE.";
        } else if (view.getWindowVisibility() != 0) {
            sb = "adView window is not set to VISIBLE.";
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adView has invisible dimensions (w=");
            sb2.append(view.getMeasuredWidth());
            sb2.append(", h=");
            sb2.append(view.getMeasuredHeight());
            sb = sb2.toString();
        } else if (view.getAlpha() < 0.9f) {
            sb = "adView is too transparent.";
        } else {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                sb = "getGlobalVisibleRect false.";
            } else {
                Context context = view.getContext();
                if (!(context instanceof Activity)) {
                    try {
                        context = ((ViewGroup) view.getParent()).getContext();
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
                Vector b = m21332b(view);
                int a = m21325a(b);
                b.add(rect);
                float a2 = ((float) (m21325a(b) - a)) / ((float) (view.getMeasuredHeight() * view.getMeasuredWidth()));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("visibleAreaPercent:");
                sb3.append(a2);
                C5205o.m21462a(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("judgeAreaPercent:");
                sb4.append(i);
                C5205o.m21462a(sb4.toString());
                float f = a2 * 100.0f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("可见区域：");
                sb5.append(f);
                sb5.append("%");
                C5205o.m21462a(sb5.toString());
                if (f < ((float) i)) {
                    sb = String.format(Locale.US, "adView visible area is too small [%.2f%% visible, current threshold %d%%]", new Object[]{Float.valueOf(f), Integer.valueOf(i)});
                } else if (!m21336c(context)) {
                    sb = "Screen is not interactive.";
                } else {
                    Map a3 = m21329a(context);
                    if (m21331a(a3)) {
                        sb = "Keyguard is obstructing view.";
                    } else if (m21334b(a3)) {
                        sb = "Ad is on top of the Lockscreen.";
                    } else {
                        C5205o.m21462a("adView is visible.");
                        return true;
                    }
                }
            }
        }
        C5205o.m21462a(sb);
        return false;
    }

    /* renamed from: a */
    public static boolean m21331a(Map<String, String> map) {
        boolean z = false;
        if (map == null || map.isEmpty()) {
            C5205o.m21462a("Invalid Window info in window interactive check, assuming not obstructed by Keyguard.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        String str3 = "1";
        if (str != null && str.equals(str3)) {
            return false;
        }
        if (str2 != null && str2.equals(str3)) {
            return false;
        }
        String str4 = (String) map.get("kgr");
        if (str4 != null && str4.equals("true")) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static Vector<Rect> m21332b(View view) {
        Vector<Rect> vector = new Vector<>();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int indexOfChild = viewGroup.indexOfChild(view);
        while (true) {
            indexOfChild++;
            if (indexOfChild < viewGroup.getChildCount()) {
                vector.addAll(m21335c(viewGroup.getChildAt(indexOfChild)));
            } else {
                vector.addAll(m21332b((View) viewGroup));
                return vector;
            }
        }
    }

    /* renamed from: b */
    public static boolean m21333b(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        boolean z = true;
        if (VERSION.SDK_INT < 16) {
            if (keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode()) {
                z = false;
            }
            return z;
        }
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m21334b(Map<String, String> map) {
        boolean z = false;
        if (map == null || map.isEmpty()) {
            C5205o.m21462a("Invalid Window info in window interactive check, assuming is not a Lockscreen.");
            return false;
        }
        String str = (String) map.get("wfdkg");
        String str2 = (String) map.get("wfswl");
        String str3 = (String) map.get("kgr");
        if (str != null) {
            String str4 = "1";
            if (str.equals(str4) && str2 != null && str2.equals(str4) && str3 != null && str3.equals("true")) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: c */
    private static Vector<Rect> m21335c(View view) {
        Vector<Rect> vector = new Vector<>();
        if (view.isShown() && (VERSION.SDK_INT < 11 || view.getAlpha() > 0.0f)) {
            if (!(view instanceof ViewGroup) || !m21338d(view)) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    vector.add(rect);
                }
            } else {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    vector.addAll(m21335c(viewGroup.getChildAt(i)));
                }
                return vector;
            }
        }
        return vector;
    }

    /* renamed from: c */
    public static boolean m21336c(Context context) {
        String sb;
        if (context == null) {
            sb = "Invalid context in screen interactive check, assuming interactive.";
        } else {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception in screen interactive check, assuming interactive.");
                sb2.append(th.getMessage());
                sb = sb2.toString();
            }
        }
        C5205o.m21462a(sb);
        return true;
    }

    /* renamed from: d */
    public static View m21337d(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
    }

    /* renamed from: d */
    private static boolean m21338d(View view) {
        return view.getBackground() == null || (VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0);
    }
}
