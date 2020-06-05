package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.p077d.Base64;
import com.alibaba.mtl.log.p077d.Logger;
import com.p620ut.mini.p622b.p623a.UTMCAppStatusRegHelper;
import com.p620ut.mini.p622b.p624b.IUTRequestAuthentication;
import java.io.UnsupportedEncodingException;

/* renamed from: com.alibaba.mtl.log.b */
public class UTMCStatConfig {
    /* renamed from: a */
    private static UTMCStatConfig f3309a = new UTMCStatConfig();
    /* renamed from: b */
    private Context f3310b = null;
    /* renamed from: c */
    private String f3311c = null;
    /* renamed from: d */
    private String f3312d = null;
    /* renamed from: e */
    private String f3313e = null;
    /* renamed from: f */
    private String f3314f = null;
    /* renamed from: g */
    private Application f3315g = null;
    /* renamed from: h */
    private String f3316h = null;
    /* renamed from: i */
    private IUTRequestAuthentication f3317i = null;
    /* renamed from: j */
    private boolean f3318j = false;
    /* renamed from: k */
    private boolean f3319k = false;

    private UTMCStatConfig() {
    }

    /* renamed from: a */
    public static UTMCStatConfig m3729a() {
        return f3309a;
    }

    /* renamed from: b */
    public String mo11770b() {
        return this.f3316h;
    }

    /* renamed from: c */
    public void mo11771c() {
        Logger.m3835a(true);
    }

    /* renamed from: a */
    public void mo11769a(Context context) {
        if (context != null) {
            this.f3310b = context;
            SharedPreferences sharedPreferences = this.f3310b.getSharedPreferences("UTCommon", 0);
            String str = "";
            String string = sharedPreferences.getString("_lun", str);
            String str2 = "UTF-8";
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f3312d = new String(Base64.m3800a(string.getBytes(), 2), str2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string2 = sharedPreferences.getString("_luid", str);
            if (!TextUtils.isEmpty(string2)) {
                try {
                    this.f3314f = new String(Base64.m3800a(string2.getBytes(), 2), str2);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        m3730f();
    }

    /* renamed from: d */
    public Context mo11772d() {
        return this.f3310b;
    }

    /* renamed from: a */
    public void mo11768a(Application application) {
        this.f3315g = application;
        m3730f();
    }

    /* renamed from: f */
    private void m3730f() {
        if (!this.f3318j && VERSION.SDK_INT >= 14) {
            try {
                if (m3729a().mo11773e() != null) {
                    UTMCAppStatusRegHelper.m33140a(m3729a().mo11773e());
                    this.f3318j = true;
                    return;
                }
                UTMCAppStatusRegHelper.m33140a((Application) m3729a().mo11772d().getApplicationContext());
                this.f3318j = true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("UTEngine", "You need set a application instance for UT.");
            }
        }
    }

    /* renamed from: e */
    public Application mo11773e() {
        return this.f3315g;
    }
}
