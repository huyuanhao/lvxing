package com.tencent.bugly.beta.p602ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.C7124a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7128b;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.global.C7132f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.utils.C7159e;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7282y;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.h */
public class C7149h extends C7139a {
    /* renamed from: v */
    public static C7149h f23802v = new C7149h();
    /* renamed from: A */
    OnClickListener f23803A = new C7128b(6, this);
    /* renamed from: B */
    DownloadListener f23804B = new C7124a(2, this);
    /* renamed from: C */
    private C7145d f23805C = null;
    /* renamed from: n */
    protected TextView f23806n;
    /* renamed from: o */
    protected TextView f23807o;
    /* renamed from: p */
    public C7282y f23808p;
    /* renamed from: q */
    public DownloadTask f23809q;
    /* renamed from: r */
    public Runnable f23810r;
    /* renamed from: s */
    public Runnable f23811s;
    /* renamed from: t */
    protected Bitmap f23812t = null;
    /* renamed from: u */
    public BitmapDrawable f23813u;
    /* renamed from: w */
    public UILifecycleListener f23814w;
    /* renamed from: x */
    OnClickListener f23815x = new C7128b(9, this);
    /* renamed from: y */
    OnClickListener f23816y = new C7128b(4, this);
    /* renamed from: z */
    OnClickListener f23817z = new C7128b(5, this);

    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.f23814w;
        if (uILifecycleListener != null) {
            Context context = this.f23759a;
            View view = this.f23760b;
            C7282y yVar = this.f23808p;
            uILifecycleListener.onStart(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        int i = this.f23770l;
        String str = Beta.TAG_UPGRADE_FEATURE;
        String str2 = Beta.TAG_UPGRADE_INFO;
        if (i != 0) {
            this.f23806n = (TextView) onCreateView.findViewWithTag(str2);
            this.f23807o = (TextView) onCreateView.findViewWithTag(str);
        } else {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.f23759a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LayoutParams layoutParams2 = new LayoutParams(-1, -2);
            ResBean resBean = ResBean.f23687a;
            if (C7131e.f23698E.f23719U) {
                this.f23806n = new TextView(this.f23759a);
                this.f23806n.setLayoutParams(layoutParams2);
                TextView textView = this.f23806n;
                resBean.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                this.f23806n.setTextSize((float) 14);
                this.f23806n.setTag(str2);
                this.f23806n.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.f23806n);
            }
            TextView textView2 = new TextView(this.f23759a);
            textView2.setLayoutParams(layoutParams2);
            resBean.getClass();
            String str3 = "#273238";
            textView2.setTextColor(Color.parseColor(str3));
            float f = (float) 14;
            textView2.setTextSize(f);
            textView2.setSingleLine();
            textView2.setEllipsize(TruncateAt.END);
            StringBuilder sb = new StringBuilder();
            sb.append(Beta.strUpgradeDialogFeatureLabel);
            sb.append(": ");
            textView2.setText(String.valueOf(sb.toString()));
            textView2.setPadding(0, C7127a.m30540a(this.f23759a, 8.0f), 0, 0);
            linearLayout.addView(textView2);
            this.f23807o = new TextView(this.f23759a);
            this.f23807o.setLayoutParams(layoutParams2);
            TextView textView3 = this.f23807o;
            resBean.getClass();
            textView3.setTextColor(Color.parseColor(str3));
            this.f23807o.setTextSize(f);
            this.f23807o.setTag(str);
            this.f23807o.setMaxHeight(C7127a.m30540a(this.f23759a, 200.0f));
            this.f23807o.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.f23807o);
            this.f23767i.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.f23814w;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            C7282y yVar = this.f23808p;
            uILifecycleListener.onCreate(activity, onCreateView, yVar != null ? new UpgradeInfo(yVar) : null);
        }
        return onCreateView;
    }

    public void onDestroyView() {
        try {
            super.onDestroyView();
            UpgradeInfo upgradeInfo = null;
            this.f23806n = null;
            this.f23807o = null;
            synchronized (this) {
                this.f23805C = null;
            }
            if (this.f23813u != null) {
                this.f23813u.setCallback(null);
            }
            if (this.f23814w != null) {
                UILifecycleListener uILifecycleListener = this.f23814w;
                Context context = this.f23759a;
                View view = this.f23760b;
                if (this.f23808p != null) {
                    upgradeInfo = new UpgradeInfo(this.f23808p);
                }
                uILifecycleListener.onDestroy(context, view, upgradeInfo);
            }
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23770l = C7131e.f23698E.f23737i;
        this.f23814w = C7131e.f23698E.f23739k;
        try {
            this.f23769k = Integer.parseInt(ResBean.f23687a.mo34329a("VAL_style"));
        } catch (Exception e) {
            C7226an.m31141a(e.getMessage(), new Object[0]);
            this.f23769k = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* renamed from: a */
    public void mo34447a(com.tencent.bugly.beta.download.DownloadTask r9) {
        /*
        r8 = this;
        int r0 = r9.getStatus()
        r1 = 2
        r2 = 0
        if (r0 == 0) goto L_0x004e
        r3 = 1
        if (r0 == r3) goto L_0x0049
        if (r0 == r1) goto L_0x0024
        r9 = 3
        if (r0 == r9) goto L_0x001f
        r9 = 4
        if (r0 == r9) goto L_0x004e
        r9 = 5
        if (r0 == r9) goto L_0x001a
        java.lang.String r9 = ""
        r0 = r2
        goto L_0x0052
    L_0x001a:
        java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogRetryBtn
        android.view.View$OnClickListener r0 = r8.f23816y
        goto L_0x0052
    L_0x001f:
        java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogContinueBtn
        android.view.View$OnClickListener r0 = r8.f23816y
        goto L_0x0052
    L_0x0024:
        java.util.Locale r0 = java.util.Locale.getDefault()
        java.lang.Object[] r3 = new java.lang.Object[r3]
        r4 = 0
        long r5 = r9.getSavedLength()
        float r5 = (float) r5
        long r6 = r9.getTotalLength()
        float r9 = (float) r6
        float r5 = r5 / r9
        r9 = 1120403456(0x42c80000, float:100.0)
        float r5 = r5 * r9
        java.lang.Float r9 = java.lang.Float.valueOf(r5)
        r3[r4] = r9
        java.lang.String r9 = "%.1f%%"
        java.lang.String r9 = java.lang.String.format(r0, r9, r3)
        android.view.View$OnClickListener r0 = r8.f23817z
        goto L_0x0052
    L_0x0049:
        java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogInstallBtn
        android.view.View$OnClickListener r0 = r8.f23815x
        goto L_0x0052
    L_0x004e:
        java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpgradeBtn
        android.view.View$OnClickListener r0 = r8.f23816y
    L_0x0052:
        com.tencent.bugly.proguard.y r3 = r8.f23808p
        byte r3 = r3.f24659g
        if (r3 == r1) goto L_0x0060
        java.lang.String r1 = com.tencent.bugly.beta.Beta.strUpgradeDialogCancelBtn
        android.view.View$OnClickListener r2 = r8.f23803A
        r8.mo34435a(r1, r2, r9, r0)
        goto L_0x0063
    L_0x0060:
        r8.mo34435a(r2, r2, r9, r0)
    L_0x0063:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p602ui.C7149h.mo34447a(com.tencent.bugly.beta.download.DownloadTask):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01cd, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e6, code lost:
            return;
     */
    /* renamed from: c */
    public synchronized void mo34449c() {
        /*
        r7 = this;
        monitor-enter(r7)
        r0 = 0
        android.view.View r1 = r7.f23760b     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x01cc
        com.tencent.bugly.proguard.y r1 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x01cc
        com.tencent.bugly.beta.download.DownloadTask r1 = r7.f23809q     // Catch:{ Exception -> 0x01d0 }
        if (r1 != 0) goto L_0x0010
        goto L_0x01cc
    L_0x0010:
        int r1 = r7.f23770l     // Catch:{ Exception -> 0x01d0 }
        r2 = 0
        r3 = 1
        if (r1 != 0) goto L_0x0099
        int r1 = r7.f23769k     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x0082
        android.content.Context r1 = r7.f23759a     // Catch:{ Exception -> 0x01d0 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.global.ResBean r5 = r7.f23768j     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r6 = "IMG_title"
        java.lang.String r5 = r5.mo34329a(r6)     // Catch:{ Exception -> 0x01d0 }
        r4[r0] = r5     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r1 = com.tencent.bugly.beta.global.C7127a.m30541a(r1, r0, r4)     // Catch:{ Exception -> 0x01d0 }
        r7.f23812t = r1     // Catch:{ Exception -> 0x01d0 }
        r7.f23813u = r2     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r1 = r7.f23812t     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x0037
        android.graphics.Bitmap r2 = r7.f23812t     // Catch:{ Exception -> 0x01d0 }
        goto L_0x004f
    L_0x0037:
        com.tencent.bugly.beta.global.e r1 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x01d0 }
        int r1 = r1.f23736h     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x004f
        android.content.Context r1 = r7.f23759a     // Catch:{ Exception -> 0x01d0 }
        java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x01d0 }
        int r4 = r4.f23736h     // Catch:{ Exception -> 0x01d0 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x01d0 }
        r2[r0] = r4     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r2 = com.tencent.bugly.beta.global.C7127a.m30541a(r1, r3, r2)     // Catch:{ Exception -> 0x01d0 }
    L_0x004f:
        android.widget.TextView r1 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.ui.d r4 = r7.f23805C     // Catch:{ Exception -> 0x01d0 }
        r1.removeOnPreDrawListener(r4)     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.ui.d r1 = new com.tencent.bugly.beta.ui.d     // Catch:{ Exception -> 0x01d0 }
        r4 = 4
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01d0 }
        r4[r0] = r7     // Catch:{ Exception -> 0x01d0 }
        android.widget.TextView r5 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        r4[r3] = r5     // Catch:{ Exception -> 0x01d0 }
        r5 = 2
        r4[r5] = r2     // Catch:{ Exception -> 0x01d0 }
        r2 = 3
        int r5 = r7.f23769k     // Catch:{ Exception -> 0x01d0 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01d0 }
        r4[r2] = r5     // Catch:{ Exception -> 0x01d0 }
        r1.m52428init(r3, r4)     // Catch:{ Exception -> 0x01d0 }
        r7.f23805C = r1     // Catch:{ Exception -> 0x01d0 }
        android.widget.TextView r1 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.ui.d r2 = r7.f23805C     // Catch:{ Exception -> 0x01d0 }
        r1.addOnPreDrawListener(r2)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x00e9
    L_0x0082:
        android.widget.TextView r1 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        android.content.Context r2 = r7.f23759a     // Catch:{ Exception -> 0x01d0 }
        r4 = 1109917696(0x42280000, float:42.0)
        int r2 = com.tencent.bugly.beta.global.C7127a.m30540a(r2, r4)     // Catch:{ Exception -> 0x01d0 }
        r1.setHeight(r2)     // Catch:{ Exception -> 0x01d0 }
        android.widget.TextView r1 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.f24653a     // Catch:{ Exception -> 0x01d0 }
        r1.setText(r2)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x00e9
    L_0x0099:
        android.widget.TextView r1 = r7.f23764f     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r4 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r4 = r4.f24653a     // Catch:{ Exception -> 0x01d0 }
        r1.setText(r4)     // Catch:{ Exception -> 0x01d0 }
        android.widget.ImageView r1 = r7.f23763e     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x00e9
        android.widget.ImageView r1 = r7.f23763e     // Catch:{ Exception -> 0x01d0 }
        r1.setAdjustViewBounds(r3)     // Catch:{ Exception -> 0x01d0 }
        int r1 = r7.f23769k     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x00e9
        android.content.Context r1 = r7.f23759a     // Catch:{ Exception -> 0x01d0 }
        java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.global.ResBean r5 = r7.f23768j     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r6 = "IMG_title"
        java.lang.String r5 = r5.mo34329a(r6)     // Catch:{ Exception -> 0x01d0 }
        r4[r0] = r5     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r1 = com.tencent.bugly.beta.global.C7127a.m30541a(r1, r0, r4)     // Catch:{ Exception -> 0x01d0 }
        r7.f23812t = r1     // Catch:{ Exception -> 0x01d0 }
        r7.f23813u = r2     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r1 = r7.f23812t     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x00cc
        android.graphics.Bitmap r2 = r7.f23812t     // Catch:{ Exception -> 0x01d0 }
        goto L_0x00e4
    L_0x00cc:
        com.tencent.bugly.beta.global.e r1 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x01d0 }
        int r1 = r1.f23736h     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x00e4
        android.content.Context r1 = r7.f23759a     // Catch:{ Exception -> 0x01d0 }
        java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.global.e r4 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x01d0 }
        int r4 = r4.f23736h     // Catch:{ Exception -> 0x01d0 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x01d0 }
        r2[r0] = r4     // Catch:{ Exception -> 0x01d0 }
        android.graphics.Bitmap r2 = com.tencent.bugly.beta.global.C7127a.m30541a(r1, r3, r2)     // Catch:{ Exception -> 0x01d0 }
    L_0x00e4:
        android.widget.ImageView r1 = r7.f23763e     // Catch:{ Exception -> 0x01d0 }
        r1.setImageBitmap(r2)     // Catch:{ Exception -> 0x01d0 }
    L_0x00e9:
        android.widget.TextView r1 = r7.f23807o     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.f24654b     // Catch:{ Exception -> 0x01d0 }
        int r2 = r2.length()     // Catch:{ Exception -> 0x01d0 }
        r4 = 500(0x1f4, float:7.0E-43)
        if (r2 <= r4) goto L_0x0100
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.f24654b     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.substring(r0, r4)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x0104
    L_0x0100:
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.f24654b     // Catch:{ Exception -> 0x01d0 }
    L_0x0104:
        r1.setText(r2)     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.beta.global.e r1 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x01d0 }
        boolean r1 = r1.f23719U     // Catch:{ Exception -> 0x01d0 }
        if (r1 == 0) goto L_0x01c6
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d0 }
        r1.<init>()     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = com.tencent.bugly.beta.Beta.strUpgradeDialogVersionLabel     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = ": "
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.v r2 = r2.f24657e     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.f24626d     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = "\n"
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = com.tencent.bugly.beta.Beta.strUpgradeDialogFileSizeLabel     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = ": "
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r2 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.u r2 = r2.f24658f     // Catch:{ Exception -> 0x01d0 }
        long r4 = r2.f24620d     // Catch:{ Exception -> 0x01d0 }
        float r2 = (float) r4     // Catch:{ Exception -> 0x01d0 }
        r4 = 1233125376(0x49800000, float:1048576.0)
        int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r5 < 0) goto L_0x015d
        java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r6 = "%.1f"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        float r2 = r2 / r4
        java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x01d0 }
        r3[r0] = r2     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = java.lang.String.format(r5, r6, r3)     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = "M"
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x0199
    L_0x015d:
        r4 = 1149239296(0x44800000, float:1024.0)
        int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r5 < 0) goto L_0x017f
        java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r6 = "%.1f"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        float r2 = r2 / r4
        java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x01d0 }
        r3[r0] = r2     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = java.lang.String.format(r5, r6, r3)     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = "K"
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x0199
    L_0x017f:
        java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r5 = "%.1f"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
        java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x01d0 }
        r3[r0] = r2     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = java.lang.String.format(r4, r5, r3)     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = "B"
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
    L_0x0199:
        java.lang.String r2 = "\n"
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r3 = "yyyy-MM-dd HH:mm"
        java.util.Locale r4 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x01d0 }
        r2.<init>(r3, r4)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r3 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpdateTimeLabel     // Catch:{ Exception -> 0x01d0 }
        r1.append(r3)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r3 = ": "
        r1.append(r3)     // Catch:{ Exception -> 0x01d0 }
        java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x01d0 }
        com.tencent.bugly.proguard.y r4 = r7.f23808p     // Catch:{ Exception -> 0x01d0 }
        long r4 = r4.f24667o     // Catch:{ Exception -> 0x01d0 }
        r3.<init>(r4)     // Catch:{ Exception -> 0x01d0 }
        java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x01d0 }
        r1.append(r2)     // Catch:{ Exception -> 0x01d0 }
        android.widget.TextView r2 = r7.f23806n     // Catch:{ Exception -> 0x01d0 }
        r2.setText(r1)     // Catch:{ Exception -> 0x01d0 }
    L_0x01c6:
        com.tencent.bugly.beta.download.DownloadTask r1 = r7.f23809q     // Catch:{ Exception -> 0x01d0 }
        r7.mo34447a(r1)     // Catch:{ Exception -> 0x01d0 }
        goto L_0x01e5
    L_0x01cc:
        monitor-exit(r7)
        return
    L_0x01ce:
        r0 = move-exception
        goto L_0x01e7
    L_0x01d0:
        r1 = move-exception
        int r2 = r7.f23770l     // Catch:{ all -> 0x01ce }
        if (r2 == 0) goto L_0x01dc
        java.lang.String r2 = "please confirm your argument: [Beta.upgradeDialogLayoutId] is correct"
        java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x01ce }
        com.tencent.bugly.proguard.C7226an.m31149e(r2, r0)     // Catch:{ all -> 0x01ce }
    L_0x01dc:
        boolean r0 = com.tencent.bugly.proguard.C7226an.m31145b(r1)     // Catch:{ all -> 0x01ce }
        if (r0 != 0) goto L_0x01e5
        r1.printStackTrace()     // Catch:{ all -> 0x01ce }
    L_0x01e5:
        monitor-exit(r7)
        return
    L_0x01e7:
        monitor-exit(r7)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.p602ui.C7149h.mo34449c():void");
    }

    /* renamed from: a */
    public synchronized void mo34448a(C7282y yVar, DownloadTask downloadTask) {
        this.f23808p = yVar;
        this.f23809q = downloadTask;
        this.f23809q.addListener(this.f23804B);
        C7159e.m30681a(new C7130d(7, this));
    }

    /* renamed from: a */
    public boolean mo34441a(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f23808p.f24659g != 2) {
            Runnable runnable = this.f23811s;
            if (runnable != null) {
                runnable.run();
            }
            mo34434a();
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        DownloadListener downloadListener = this.f23804B;
        if (downloadListener != null) {
            DownloadTask downloadTask = this.f23809q;
            if (downloadTask != null) {
                downloadTask.removeListener(downloadListener);
            }
        }
        UILifecycleListener uILifecycleListener = this.f23814w;
        if (uILifecycleListener != null) {
            Context context = this.f23759a;
            View view = this.f23760b;
            C7282y yVar = this.f23808p;
            uILifecycleListener.onPause(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    public void onResume() {
        super.onResume();
        DownloadListener downloadListener = this.f23804B;
        if (downloadListener != null) {
            DownloadTask downloadTask = this.f23809q;
            if (downloadTask != null) {
                downloadTask.addListener(downloadListener);
            }
        }
        mo34449c();
        if (this.f23769k != 0 && this.f23812t == null) {
            C7132f.f23755a.mo34342a(new C7130d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.f23814w;
        if (uILifecycleListener != null) {
            Context context = this.f23759a;
            View view = this.f23760b;
            C7282y yVar = this.f23808p;
            uILifecycleListener.onResume(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.f23814w;
        if (uILifecycleListener != null) {
            Context context = this.f23759a;
            View view = this.f23760b;
            C7282y yVar = this.f23808p;
            uILifecycleListener.onStop(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }
}
