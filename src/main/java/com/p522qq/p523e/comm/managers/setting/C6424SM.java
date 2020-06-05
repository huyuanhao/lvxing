package com.p522qq.p523e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.p522qq.p523e.comm.constants.Constants.SETTING;
import com.p522qq.p523e.comm.managers.setting.C6427c.C6428a;
import com.p522qq.p523e.comm.managers.setting.C6427c.C6429b;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import com.p522qq.p523e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;

/* renamed from: com.qq.e.comm.managers.setting.SM */
public class C6424SM {
    /* renamed from: a */
    private C6427c f20225a;
    /* renamed from: b */
    private String f20226b;
    /* renamed from: c */
    private C6427c f20227c;
    /* renamed from: d */
    private C6427c f20228d;
    /* renamed from: e */
    private String f20229e;
    /* renamed from: f */
    private C6426b f20230f;
    /* renamed from: g */
    private C6426b f20231g = null;
    /* renamed from: h */
    private C6426b f20232h;
    /* renamed from: i */
    private String f20233i;
    /* renamed from: j */
    private String f20234j = "";
    /* renamed from: k */
    private Context f20235k;
    /* renamed from: l */
    private String f20236l;

    public C6424SM(Context context) {
        this.f20235k = context;
        this.f20225a = new C6427c();
        this.f20228d = new C6427c();
        this.f20232h = new C6425a();
        this.f20236l = SystemUtil.buildNewPathByProcessName(SETTING.SETTINGDIR);
        try {
            this.f20233i = StringUtil.readAll(new File(this.f20235k.getDir(this.f20236l, 0), SETTING.SUID_FILE));
        } catch (Throwable unused) {
            this.f20233i = null;
            GDTLogger.m25260e("IO Exception while loading suid");
        }
        m25216a();
        m25217b();
    }

    /* renamed from: a */
    private void m25216a() {
        C6429b b = C6427c.m25224b(this.f20235k);
        if (b != null) {
            this.f20229e = b.mo30165a();
            this.f20230f = b.mo30166b();
            return;
        }
        GDTLogger.m25258d("Load Local SDK Cloud setting fail");
    }

    /* renamed from: b */
    private void m25217b() {
        C6428a a = C6427c.m25221a(this.f20235k);
        if (a != null) {
            this.f20227c = a.mo30164b();
            this.f20226b = a.mo30163a();
            return;
        }
        GDTLogger.m25258d("Load Local DEV Cloud setting fail");
    }

    public Object get(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            if (this.f20225a.mo30159a(str) != null) {
                Object a = this.f20225a.mo30159a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f20227c != null) {
                Object a2 = this.f20227c.mo30159a(str);
                if (a2 != null) {
                    return a2;
                }
            }
            if (this.f20228d != null) {
                Object a3 = this.f20228d.mo30159a(str);
                if (a3 != null) {
                    return a3;
                }
            }
            if (this.f20230f != null) {
                Object a4 = this.f20230f.mo30156a(str);
                if (a4 != null) {
                    return a4;
                }
            }
            if (this.f20232h != null) {
                return this.f20232h.mo30156a(str);
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception in settingManager.get Setting for key:");
            sb.append(str);
            GDTLogger.report(sb.toString(), th);
            return null;
        }
    }

    public Object getDebugSetting() {
        return null;
    }

    public String getDevCloudSettingSig() {
        return this.f20226b;
    }

    public Object getForPlacement(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            try {
                if (this.f20225a != null) {
                    Object a = this.f20225a.mo30160a(str, str2);
                    if (a != null) {
                        return a;
                    }
                }
                if (this.f20227c != null) {
                    Object a2 = this.f20227c.mo30160a(str, str2);
                    if (a2 != null) {
                        return a2;
                    }
                }
                if (this.f20228d != null) {
                    Object a3 = this.f20228d.mo30160a(str, str2);
                    if (a3 != null) {
                        return a3;
                    }
                }
                return get(str);
            } catch (Throwable th) {
                GDTLogger.report("Exception in settingManager.getForPlacement", th);
            }
        }
        return null;
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getSdkCloudSettingSig() {
        return this.f20229e;
    }

    public String getSettingDir() {
        return this.f20236l;
    }

    public String getSid() {
        return this.f20234j;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement == null) {
            return null;
        }
        return forPlacement.toString();
    }

    public String getSuid() {
        return this.f20233i;
    }

    public void modifyDebugSetting(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
        }
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f20228d.mo30161a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f20228d.mo30162a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            C6427c cVar = new C6427c();
            if (!StringUtil.isEmpty(str)) {
                cVar = new C6427c(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.f20225a = cVar;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (C6427c.m25225b(this.f20235k, str, str2)) {
            m25217b();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (C6427c.m25222a(this.f20235k, str, str2)) {
            m25216a();
        }
    }

    public void updateSID(String str) {
        this.f20234j = str;
    }

    public void updateSUID(String str) {
        if (!StringUtil.isEmpty(str) && !str.equals(this.f20233i)) {
            this.f20233i = str;
            try {
                StringUtil.writeTo(str, new File(this.f20235k.getDir(this.f20236l, 0), SETTING.SUID_FILE));
            } catch (IOException e) {
                GDTLogger.report("Exception while persit suid", e);
            }
        }
    }
}
