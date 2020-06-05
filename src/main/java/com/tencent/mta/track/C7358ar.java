package com.tencent.mta.track;

import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.JsonWriter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ar */
public class C7358ar {
    /* renamed from: a */
    private final C7361au f24907a;
    /* renamed from: b */
    private final List f24908b;
    /* renamed from: c */
    private final C7360at f24909c;
    /* renamed from: d */
    private final Handler f24910d;
    /* renamed from: e */
    private final C7341aa f24911e;
    /* renamed from: f */
    private String[] f24912f = null;
    /* renamed from: g */
    private ArrayList f24913g = new ArrayList();
    /* renamed from: h */
    private ArrayList f24914h = new ArrayList();
    /* renamed from: i */
    private HashMap f24915i = new HashMap();
    /* renamed from: j */
    private View f24916j = null;
    /* renamed from: k */
    private ArrayList f24917k = new ArrayList();
    /* renamed from: l */
    private ArrayList f24918l = new ArrayList();

    public C7358ar(List list, C7341aa aaVar) {
        this.f24908b = list;
        this.f24911e = aaVar;
        this.f24910d = new Handler(Looper.getMainLooper());
        this.f24907a = new C7361au();
        this.f24909c = new C7360at(255);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* renamed from: a */
    public void mo35886a(com.tencent.mta.track.C7348ah r7, java.io.OutputStream r8) {
        /*
        r6 = this;
        java.lang.String r0 = "Snapshot"
        com.tencent.mta.track.au r1 = r6.f24907a
        r1.mo35894a(r7)
        java.util.concurrent.FutureTask r7 = new java.util.concurrent.FutureTask
        com.tencent.mta.track.au r1 = r6.f24907a
        r7.<init>(r1)
        android.os.Handler r1 = r6.f24910d
        r1.post(r7)
        java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
        r1.<init>(r8)
        java.util.List r2 = java.util.Collections.emptyList()
        r3 = 1
        java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0035, TimeoutException -> 0x002e, ExecutionException -> 0x0027 }
        java.lang.Object r7 = r7.get(r3, r5)     // Catch:{ InterruptedException -> 0x0035, TimeoutException -> 0x002e, ExecutionException -> 0x0027 }
        java.util.List r7 = (java.util.List) r7     // Catch:{ InterruptedException -> 0x0035, TimeoutException -> 0x002e, ExecutionException -> 0x0027 }
        goto L_0x003c
    L_0x0027:
        r7 = move-exception
        java.lang.String r3 = "Exception thrown during screenshot attempt"
        android.util.Log.e(r0, r3, r7)
        goto L_0x003b
    L_0x002e:
        r7 = move-exception
        java.lang.String r3 = "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent."
        android.util.Log.i(r0, r3, r7)
        goto L_0x003b
    L_0x0035:
        r7 = move-exception
        java.lang.String r3 = "Screenshot interrupted, no screenshot will be sent."
        android.util.Log.w(r0, r3, r7)
    L_0x003b:
        r7 = r2
    L_0x003c:
        int r0 = r7.size()
        if (r0 <= 0) goto L_0x00d1
        r0 = 0
        java.lang.Object r7 = r7.get(r0)
        com.tencent.mta.track.av r7 = (com.tencent.mta.track.C7362av) r7
        java.lang.String r2 = "\"activity\":"
        r1.write(r2)
        java.lang.String r2 = r7.f24927a
        java.lang.String r2 = org.json.JSONObject.quote(r2)
        r1.write(r2)
        java.lang.String r2 = ","
        r1.write(r2)
        java.lang.String r3 = "\"scale\":"
        r1.write(r3)
        r3 = 1
        java.lang.Object[] r3 = new java.lang.Object[r3]
        float r4 = r7.f24930d
        java.lang.Float r4 = java.lang.Float.valueOf(r4)
        r3[r0] = r4
        java.lang.String r0 = "%s"
        java.lang.String r0 = java.lang.String.format(r0, r3)
        r1.write(r0)
        r1.write(r2)
        java.lang.String r0 = "\"serialized_objects\":"
        r1.write(r0)
        android.util.JsonWriter r0 = new android.util.JsonWriter
        r0.<init>(r1)
        r0.beginObject()
        java.lang.String r3 = "rootObject"
        android.util.JsonWriter r3 = r0.name(r3)
        android.view.View r4 = r7.f24928b
        int r4 = r4.hashCode()
        long r4 = (long) r4
        r3.value(r4)
        java.lang.String r3 = "objects"
        r0.name(r3)
        android.view.View r3 = r7.f24928b
        r6.m31751a(r0, r3)
        r0.endObject()
        r0.flush()
        r1.write(r2)
        java.lang.String r0 = "\"image_hash\":"
        r1.write(r0)
        com.tencent.mta.track.as r0 = r7.f24929c
        java.lang.String r0 = r0.mo35888a()
        java.lang.String r0 = org.json.JSONObject.quote(r0)
        r1.write(r0)
        r1.write(r2)
        java.lang.String r0 = "\"screenshot\":"
        r1.write(r0)
        r1.flush()
        com.tencent.mta.track.as r7 = r7.f24929c
        android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG
        r3 = 100
        r7.mo35890a(r0, r3, r8)
        r1.write(r2)
    L_0x00d1:
        r1.flush()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mta.track.C7358ar.mo35886a(com.tencent.mta.track.ah, java.io.OutputStream):void");
    }

    /* renamed from: a */
    private void m31751a(JsonWriter jsonWriter, View view) {
        try {
            m31752a(view);
            jsonWriter.beginArray();
            m31755b(jsonWriter, view);
            jsonWriter.endArray();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m31752a(View view) {
        this.f24913g.clear();
        this.f24915i.clear();
        this.f24917k.clear();
        this.f24918l.clear();
        m31760d(view);
        m31759c(view);
        m31756b(view);
    }

    /* renamed from: b */
    private void m31756b(View view) {
        try {
            if (this.f24915i.size() > 0) {
                for (Point point : this.f24915i.keySet()) {
                    ArrayList arrayList = (ArrayList) this.f24915i.get(point);
                    this.f24918l.clear();
                    int i = 0;
                    while (true) {
                        if (i >= this.f24915i.size()) {
                            break;
                        }
                        m31754a(view, arrayList);
                        if (this.f24916j != null) {
                            if (((this.f24916j.getBackground() != null && this.f24916j.getBackground().getAlpha() == 255 && this.f24916j.getAlpha() == 1.0f) || this.f24916j.isClickable() || ((this.f24916j instanceof ImageView) && ((ImageView) this.f24916j).getDrawable() != null && ((ImageView) this.f24916j).getDrawable().getCurrent().getConstantState() != null && this.f24916j.getAlpha() == 1.0f && ((ImageView) this.f24916j).getImageAlpha() == 255)) && !(this.f24916j instanceof GridView) && !(this.f24916j instanceof ListView) && !(this.f24916j instanceof WebView)) {
                                this.f24917k.add(this.f24916j);
                                this.f24916j = null;
                                break;
                            }
                            this.f24918l.add(this.f24916j);
                        }
                        i++;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m31754a(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                int i = childCount - 1;
                while (i >= 0) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt == null || childAt.getVisibility() != 0 || !arrayList.contains(Integer.valueOf(childAt.hashCode())) || this.f24918l.contains(childAt)) {
                        i--;
                    } else {
                        this.f24916j = childAt;
                        m31754a(childAt, arrayList);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m31759c(View view) {
        int size = this.f24913g.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                Point point = (Point) this.f24913g.get(i);
                this.f24914h = new ArrayList();
                m31753a(view, point.x, point.y);
                this.f24915i.put(point, this.f24914h);
            }
        }
    }

    /* renamed from: a */
    private void m31753a(View view, int i, int i2) {
        if (m31757b(view, i, i2)) {
            this.f24914h.add(Integer.valueOf(view.hashCode()));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    m31753a(childAt, i, i2);
                }
            }
        }
    }

    /* renamed from: d */
    private void m31760d(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view.getMeasuredWidth();
        view.getMeasuredHeight();
        Point point = new Point();
        point.set(i, i2);
        this.f24913g.add(point);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    m31760d(childAt);
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m31757b(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i4;
        if (i2 < i4 || i2 > measuredHeight || i < i3 || i > measuredWidth) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m31755b(JsonWriter jsonWriter, View view) {
        float f;
        try {
            jsonWriter.beginObject();
            jsonWriter.name("hashCode").value((long) view.hashCode());
            jsonWriter.name("id").value((long) view.getId());
            jsonWriter.name("index").value((long) m31750a(view.getParent(), view));
            jsonWriter.name("sa_id_name").value(m31761e(view));
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            jsonWriter.name("left").value((long) i);
            jsonWriter.name("top").value((long) i2);
            jsonWriter.name("width").value((long) view.getWidth());
            jsonWriter.name("height").value((long) view.getHeight());
            jsonWriter.name("scrollX").value((long) view.getScrollX());
            jsonWriter.name("scrollY").value((long) view.getScrollY());
            String str = "visibility";
            if (this.f24917k.contains(view)) {
                jsonWriter.name(str).value(0);
            } else {
                jsonWriter.name(str).value(8);
            }
            float f2 = 0.0f;
            if (VERSION.SDK_INT >= 11) {
                f2 = view.getTranslationX();
                f = view.getTranslationY();
            } else {
                f = 0.0f;
            }
            jsonWriter.name("translationX").value((double) f2);
            jsonWriter.name("translationY").value((double) f);
            jsonWriter.name("classes");
            jsonWriter.beginArray();
            Class<Object> cls = view.getClass();
            do {
                jsonWriter.value((String) this.f24909c.get(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jsonWriter.endArray();
            m31758c(jsonWriter, view);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                jsonWriter.name("layoutRules");
                jsonWriter.beginArray();
                for (int i3 : rules) {
                    jsonWriter.value((long) i3);
                }
                jsonWriter.endArray();
            }
            jsonWriter.name("subviews");
            jsonWriter.beginArray();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    if (childAt != null) {
                        jsonWriter.value((long) childAt.hashCode());
                    }
                }
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount2 = viewGroup2.getChildCount();
                for (int i5 = 0; i5 < childCount2; i5++) {
                    View childAt2 = viewGroup2.getChildAt(i5);
                    if (childAt2 != null) {
                        m31755b(jsonWriter, childAt2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private void m31758c(JsonWriter jsonWriter, View view) {
        try {
            Class cls = view.getClass();
            for (C7477z zVar : this.f24908b) {
                if (zVar.f25040b.isAssignableFrom(cls) && zVar.f25041c != null) {
                    Object a = zVar.f25041c.mo35910a(view);
                    if (a != null) {
                        if (a instanceof Number) {
                            jsonWriter.name(zVar.f25039a).value((Number) a);
                        } else if (a instanceof Boolean) {
                            jsonWriter.name(zVar.f25039a).value(((Boolean) a).booleanValue());
                        } else if (a instanceof ColorStateList) {
                            jsonWriter.name(zVar.f25039a).value(Integer.valueOf(((ColorStateList) a).getDefaultColor()));
                        } else if (a instanceof Drawable) {
                            Drawable drawable = (Drawable) a;
                            Rect bounds = drawable.getBounds();
                            jsonWriter.name(zVar.f25039a);
                            jsonWriter.beginObject();
                            jsonWriter.name("classes");
                            jsonWriter.beginArray();
                            for (Class<Object> cls2 = drawable.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                                jsonWriter.value(cls2.getCanonicalName());
                            }
                            jsonWriter.endArray();
                            jsonWriter.name("dimensions");
                            jsonWriter.beginObject();
                            jsonWriter.name("left").value((long) bounds.left);
                            jsonWriter.name("right").value((long) bounds.right);
                            jsonWriter.name("top").value((long) bounds.top);
                            jsonWriter.name("bottom").value((long) bounds.bottom);
                            jsonWriter.endObject();
                            if (drawable instanceof ColorDrawable) {
                                jsonWriter.name("color").value((long) ((ColorDrawable) drawable).getColor());
                            }
                            jsonWriter.endObject();
                        } else {
                            jsonWriter.name(zVar.f25039a).value(a.toString());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo35887a(String str) {
        if (str == null || str.length() <= 0) {
            this.f24912f = null;
        } else {
            this.f24912f = str.split(StorageInterface.KEY_SPLITER);
        }
    }

    /* renamed from: e */
    private String m31761e(View view) {
        int id = view.getId();
        if (-1 == id) {
            return null;
        }
        return this.f24911e.mo35836a(id);
    }

    /* renamed from: a */
    private int m31750a(ViewParent viewParent, View view) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            String e = m31761e(view);
            String str = (String) this.f24909c.get(view.getClass());
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (C7473v.m32351a((Object) childAt, str)) {
                    String e2 = m31761e(childAt);
                    if (e == null || e.equals(e2)) {
                        if (childAt == view) {
                            return i;
                        }
                        i++;
                    }
                }
            }
        }
        return -1;
    }
}
