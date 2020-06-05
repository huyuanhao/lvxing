package com.alibaba.baichuan.trade.biz.auth;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.alibaba.baichuan.trade.biz.auth.C1140a.C1142a;
import com.alibaba.baichuan.trade.common.utils.C1230d;
import java.util.Set;

public class AlibcAuthActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    static int f2344a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f2345b = false;

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.AlibcAuthActivity$a */
    private class C1138a implements C1148c {
        /* renamed from: a */
        C1142a f2346a;

        private C1138a() {
            this.f2346a = (C1142a) C1140a.f2350a.get(Integer.valueOf(AlibcAuthActivity.f2344a));
        }

        /* renamed from: a */
        public void mo10650a() {
            this.f2346a.f2357c.mo10650a();
            C1140a.f2350a.remove(Integer.valueOf(AlibcAuthActivity.f2344a));
            AlibcAuthActivity.this.finish();
        }

        /* renamed from: a */
        public void mo10651a(String str, String str2) {
            if (TextUtils.equals("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", str)) {
                this.f2346a.f2357c.mo10651a(str, str2);
                C1140a.f2350a.remove(Integer.valueOf(AlibcAuthActivity.f2344a));
                return;
            }
            AlibcAuthActivity.this.f2345b = true;
            AlibcAuthActivity.this.m2207a();
            mo10653c();
        }

        /* renamed from: b */
        public void mo10652b() {
            this.f2346a.f2357c.mo10652b();
            C1140a.f2350a.remove(Integer.valueOf(AlibcAuthActivity.f2344a));
            AlibcAuthActivity.this.finish();
        }

        /* renamed from: c */
        public void mo10653c() {
            this.f2346a.f2357c.mo10653c();
        }
    }

    /* renamed from: com.alibaba.baichuan.trade.biz.auth.AlibcAuthActivity$b */
    private class C1139b implements C1148c {
        /* renamed from: a */
        C1142a f2348a;

        private C1139b() {
            this.f2348a = (C1142a) C1140a.f2350a.get(Integer.valueOf(AlibcAuthActivity.f2344a));
        }

        /* renamed from: a */
        public void mo10650a() {
            AlibcAuthActivity.this.f2345b = false;
            AlibcAuthActivity.this.m2207a();
        }

        /* renamed from: a */
        public void mo10651a(String str, String str2) {
            AlibcAuthActivity.this.f2345b = true;
            AlibcAuthActivity.this.m2207a();
            mo10653c();
        }

        /* renamed from: b */
        public void mo10652b() {
            this.f2348a.f2357c.mo10652b();
            C1140a.f2350a.remove(Integer.valueOf(AlibcAuthActivity.f2344a));
            AlibcAuthActivity.this.finish();
        }

        /* renamed from: c */
        public void mo10653c() {
            this.f2348a.f2357c.mo10653c();
        }
    }

    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public void m2207a() {
        /*
        r11 = this;
        boolean r0 = r11.isFinishing()
        if (r0 == 0) goto L_0x0007
        return
    L_0x0007:
        java.util.Map<java.lang.Integer, com.alibaba.baichuan.trade.biz.auth.a$a> r0 = com.alibaba.baichuan.trade.biz.auth.C1140a.f2350a
        int r1 = f2344a
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        java.lang.Object r0 = r0.get(r1)
        com.alibaba.baichuan.trade.biz.auth.a$a r0 = (com.alibaba.baichuan.trade.biz.auth.C1140a.C1142a) r0
        android.content.pm.PackageManager r1 = r11.getPackageManager()
        android.content.pm.ApplicationInfo r2 = r11.getApplicationInfo()
        java.lang.CharSequence r1 = r2.loadLabel(r1)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "id"
        java.lang.String r3 = "open_auth_title"
        int r3 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r3)
        android.view.View r3 = r11.findViewById(r3)
        android.widget.TextView r3 = (android.widget.TextView) r3
        java.lang.String r4 = "open_auth_desc"
        int r4 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r4)
        android.view.View r4 = r11.findViewById(r4)
        android.widget.TextView r4 = (android.widget.TextView) r4
        java.lang.String r5 = "open_auth_btn_grant"
        int r5 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r5)
        android.view.View r5 = r11.findViewById(r5)
        android.widget.TextView r5 = (android.widget.TextView) r5
        java.lang.String r6 = "open_auth_rl"
        int r6 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r6)
        android.view.View r6 = r11.findViewById(r6)
        r7 = 0
        r6.setVisibility(r7)
        r11.m2211c()
        boolean r6 = r11.f2345b
        if (r6 == 0) goto L_0x0071
        java.lang.String r0 = "淘宝授权失败"
        r3.setText(r0)
        java.lang.String r0 = "请确认网络环境后再试试？"
        r4.setText(r0)
        java.lang.String r0 = "重试"
    L_0x006c:
        r5.setText(r0)
        goto L_0x013c
    L_0x0071:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        r6.append(r1)
        java.lang.String r1 = "将获取"
        r6.append(r1)
        java.lang.String r1 = r6.toString()
        r3.setText(r1)
        java.lang.StringBuffer r1 = new java.lang.StringBuffer
        r1.<init>()
        java.lang.String r3 = r0.f2355a
        java.lang.String r6 = ")"
        java.lang.String r7 = "访问您淘宝账号信息的权限("
        java.lang.String r8 = "\n"
        if (r3 == 0) goto L_0x00da
        java.lang.String r0 = r0.f2355a
        java.util.Set r0 = com.alibaba.baichuan.trade.biz.auth.C1149d.m2242b(r0)
        java.util.Iterator r0 = r0.iterator()
    L_0x009e:
        boolean r3 = r0.hasNext()
        if (r3 == 0) goto L_0x0120
        java.lang.Object r3 = r0.next()
        java.lang.String r3 = (java.lang.String) r3
        java.lang.String r9 = com.alibaba.baichuan.trade.biz.auth.C1149d.m2239a(r3)
        boolean r10 = android.text.TextUtils.isEmpty(r9)
        if (r10 == 0) goto L_0x00c7
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        r9.append(r7)
        r9.append(r3)
        r9.append(r6)
        java.lang.String r3 = r9.toString()
        goto L_0x00d6
    L_0x00c7:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r9)
        r3.append(r8)
        java.lang.String r3 = r3.toString()
    L_0x00d6:
        r1.append(r3)
        goto L_0x009e
    L_0x00da:
        java.util.Set<java.lang.String> r3 = r0.f2356b
        if (r3 == 0) goto L_0x0120
        java.util.Set<java.lang.String> r0 = r0.f2356b
        java.util.Iterator r0 = r0.iterator()
    L_0x00e4:
        boolean r3 = r0.hasNext()
        if (r3 == 0) goto L_0x0120
        java.lang.Object r3 = r0.next()
        java.lang.String r3 = (java.lang.String) r3
        java.lang.String r9 = com.alibaba.baichuan.trade.biz.auth.C1149d.m2239a(r3)
        boolean r10 = android.text.TextUtils.isEmpty(r9)
        if (r10 == 0) goto L_0x010d
        java.lang.StringBuilder r9 = new java.lang.StringBuilder
        r9.<init>()
        r9.append(r7)
        r9.append(r3)
        r9.append(r6)
        java.lang.String r3 = r9.toString()
        goto L_0x011c
    L_0x010d:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r9)
        r3.append(r8)
        java.lang.String r3 = r3.toString()
    L_0x011c:
        r1.append(r3)
        goto L_0x00e4
    L_0x0120:
        int r0 = r1.lastIndexOf(r8)
        int r3 = r1.length()
        r1.delete(r0, r3)
        boolean r0 = android.text.TextUtils.isEmpty(r1)
        if (r0 == 0) goto L_0x0133
        java.lang.String r1 = "访问您淘宝账号信息的权限"
    L_0x0133:
        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        r4.setText(r1)
        java.lang.String r0 = "确认授权"
        goto L_0x006c
    L_0x013c:
        r5.setOnClickListener(r11)
        java.lang.String r0 = "open_auth_btn_cancel"
        int r0 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r0)
        android.view.View r0 = r11.findViewById(r0)
        r0.setOnClickListener(r11)
        java.lang.String r0 = "open_auth_btn_close"
        int r0 = com.alibaba.baichuan.trade.common.utils.C1230d.m2427a(r11, r2, r0)
        android.view.View r0 = r11.findViewById(r0)
        r0.setOnClickListener(r11)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.trade.biz.auth.AlibcAuthActivity.m2207a():void");
    }

    /* renamed from: b */
    private void m2210b() {
        findViewById(C1230d.m2427a(this, "id", "com_alibc_auth_progressbar")).setVisibility(0);
    }

    /* renamed from: c */
    private void m2211c() {
        findViewById(C1230d.m2427a(this, "id", "com_alibc_auth_progressbar")).setVisibility(8);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C1230d.m2427a(this, "id", "open_auth_btn_cancel") || id == C1230d.m2427a(this, "id", "open_auth_btn_close")) {
            synchronized (this) {
                C1142a aVar = (C1142a) C1140a.f2350a.get(Integer.valueOf(f2344a));
                if (aVar != null) {
                    aVar.f2357c.mo10652b();
                    C1140a.f2350a.remove(Integer.valueOf(f2344a));
                }
                finish();
            }
        } else if (id == C1230d.m2427a(this, "id", "open_auth_btn_grant")) {
            synchronized (this) {
                C1142a aVar2 = (C1142a) C1140a.f2350a.get(Integer.valueOf(f2344a));
                if (aVar2 == null) {
                    finish();
                    return;
                }
                m2210b();
                findViewById(C1230d.m2427a(this, "id", "open_auth_rl")).setVisibility(8);
                if (!TextUtils.isEmpty(aVar2.f2355a)) {
                    Set b = C1149d.m2242b(aVar2.f2355a);
                    if (b != null) {
                        if (b.size() > 0) {
                            C1140a.m2222a(b, new C1138a(), false);
                        }
                    }
                    C1140a.m2221a(aVar2.f2355a, new C1139b(), false, false);
                } else {
                    C1140a.m2222a(aVar2.f2356b, new C1138a(), false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C1230d.m2427a(this, "layout", "com_alibc_auth_actiivty"));
        try {
            f2344a = getIntent().getExtras().getInt("authId");
            C1142a aVar = (C1142a) C1140a.f2350a.get(Integer.valueOf(f2344a));
            if (aVar.f2356b == null) {
                C1140a.m2221a(aVar.f2355a, new C1139b(), false, false);
            } else {
                m2207a();
            }
        } catch (Exception unused) {
        }
    }
}
