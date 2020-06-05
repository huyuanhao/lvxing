package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.core.p173g.TotalCountLruDiskDir;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p164b.TotalCountLruDiskFile;
import com.bytedance.sdk.openadsdk.p190h.p197g.FileHelper;
import com.bytedance.sdk.openadsdk.utils.ActivityLifecycleListener;
import com.bytedance.sdk.openadsdk.utils.BitmapUtils;
import com.bytedance.sdk.openadsdk.utils.Predicate;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.core.h */
public class GlobalInfo {
    /* renamed from: s */
    private static final GlobalInfo f7563s = new GlobalInfo();
    /* renamed from: v */
    private static TTCustomController f7564v = new TTCustomController() {
    };
    /* renamed from: a */
    private String f7565a;
    /* renamed from: b */
    private String f7566b;
    /* renamed from: c */
    private boolean f7567c;
    /* renamed from: d */
    private String f7568d;
    /* renamed from: e */
    private String f7569e;
    /* renamed from: f */
    private int f7570f = 0;
    /* renamed from: g */
    private boolean f7571g = true;
    /* renamed from: h */
    private boolean f7572h = false;
    /* renamed from: i */
    private TTGlobalAppDownloadListener f7573i;
    /* renamed from: j */
    private final Set<Integer> f7574j = Collections.synchronizedSet(new HashSet());
    /* renamed from: k */
    private boolean f7575k = false;
    /* renamed from: l */
    private Bitmap f7576l = null;
    /* renamed from: m */
    private ActivityLifecycleListener f7577m = new ActivityLifecycleListener();
    /* renamed from: n */
    private TTDownloadEventLogger f7578n;
    /* renamed from: o */
    private TTSecAbs f7579o;
    /* renamed from: p */
    private String[] f7580p;
    /* renamed from: q */
    private TTCustomController f7581q;
    /* renamed from: r */
    private boolean f7582r = false;
    /* renamed from: t */
    private TotalCountLruDiskFile f7583t;
    /* renamed from: u */
    private TotalCountLruDiskDir f7584u;

    /* renamed from: a */
    public boolean mo15664a() {
        return this.f7577m.mo16896a();
    }

    /* renamed from: b */
    public boolean mo15668b() {
        return this.f7582r;
    }

    /* renamed from: a */
    public boolean mo15665a(Activity activity) {
        return this.f7577m.mo16897a(activity);
    }

    private GlobalInfo() {
        FileHelper.m11640a(InternalContainer.m10059a());
        this.f7574j.add(Integer.valueOf(4));
        Context a = InternalContainer.m10059a();
        if (a instanceof Application) {
            ((Application) a).registerActivityLifecycleCallbacks(this.f7577m);
        } else if (!(a == null || a.getApplicationContext() == null)) {
            ((Application) a.getApplicationContext()).registerActivityLifecycleCallbacks(this.f7577m);
        }
        if (VERSION.SDK_INT >= 26) {
            try {
                this.f7582r = ((ShortcutManager) InternalContainer.m10059a().getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: c */
    public static GlobalInfo m9616c() {
        return f7563s;
    }

    /* renamed from: a */
    public void mo15656a(TTCustomController tTCustomController) {
        this.f7581q = tTCustomController;
    }

    /* renamed from: d */
    public TTCustomController mo15672d() {
        if (InitHelper.f7725b != null) {
            return InitHelper.f7725b;
        }
        TTCustomController tTCustomController = this.f7581q;
        if (tTCustomController == null) {
            tTCustomController = f7564v;
        }
        return tTCustomController;
    }

    /* renamed from: e */
    public String mo15675e() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11880b("sp_global_info", ArgKey.KEY_APP_ID, (String) null);
        }
        return this.f7565a;
    }

    /* renamed from: a */
    public void mo15660a(String str) {
        m9617e(str);
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11874a("sp_global_info", ArgKey.KEY_APP_ID, str);
        }
        this.f7565a = str;
        m9621t();
    }

    /* renamed from: t */
    private void m9621t() {
        HashMap hashMap = new HashMap();
        String e = m9616c().mo15675e();
        if (TextUtils.isEmpty(e)) {
            e = String.valueOf(164362);
        }
        hashMap.put("host_appid", e);
        hashMap.put("sdk_version", "2.9.5.5");
        AppLog.setHeaderInfo(hashMap);
    }

    /* renamed from: f */
    public String mo15676f() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11880b("sp_global_info", ArgKey.KEY_NAME, (String) null);
        }
        return this.f7566b;
    }

    /* renamed from: b */
    public void mo15666b(String str) {
        m9618f(str);
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11874a("sp_global_info", ArgKey.KEY_NAME, str);
        }
        this.f7566b = str;
    }

    /* renamed from: g */
    public boolean mo15677g() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11877a("sp_global_info", "is_paid", false);
        }
        return this.f7567c;
    }

    /* renamed from: a */
    public void mo15661a(boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11870a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.f7567c = z;
    }

    /* renamed from: h */
    public String mo15678h() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11880b("sp_global_info", "keywords", (String) null);
        }
        return this.f7568d;
    }

    /* renamed from: c */
    public void mo15670c(String str) {
        m9619g(str);
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11874a("sp_global_info", "keywords", str);
        }
        this.f7568d = str;
    }

    /* renamed from: i */
    public String mo15679i() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11880b("sp_global_info", "extra_data", (String) null);
        }
        return this.f7569e;
    }

    /* renamed from: d */
    public void mo15673d(String str) {
        m9620h(str);
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11874a("sp_global_info", "extra_data", str);
        }
        this.f7569e = str;
    }

    /* renamed from: a */
    public void mo15654a(int i) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11872a("sp_global_info", "title_bar_theme", Integer.valueOf(i));
        }
        this.f7570f = i;
    }

    /* renamed from: j */
    public int mo15680j() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11865a("sp_global_info", "title_bar_theme", 0);
        }
        return this.f7570f;
    }

    /* renamed from: b */
    public void mo15667b(boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11870a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.f7571g = z;
    }

    /* renamed from: k */
    public boolean mo15681k() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11877a("sp_global_info", "allow_show_notify", true);
        }
        return this.f7571g;
    }

    /* renamed from: c */
    public void mo15671c(boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11870a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.f7572h = z;
    }

    /* renamed from: l */
    public boolean mo15682l() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11877a("sp_global_info", "allow_lp_when_screen_lock", false);
        }
        return this.f7572h;
    }

    /* renamed from: a */
    public void mo15658a(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        this.f7573i = tTGlobalAppDownloadListener;
    }

    /* renamed from: m */
    public TTDownloadEventLogger mo15683m() {
        return this.f7578n;
    }

    /* renamed from: a */
    public void mo15657a(TTDownloadEventLogger tTDownloadEventLogger) {
        this.f7578n = tTDownloadEventLogger;
    }

    /* renamed from: n */
    public TTSecAbs mo15684n() {
        return this.f7579o;
    }

    /* renamed from: a */
    public void mo15659a(TTSecAbs tTSecAbs) {
        this.f7579o = tTSecAbs;
    }

    /* renamed from: b */
    public boolean mo15669b(int i) {
        if (!MultiGlobalInfo.m11808b()) {
            return this.f7574j.contains(Integer.valueOf(i));
        }
        String b = SPMultiHelper.m11880b("sp_global_info", "network_state", (String) null);
        boolean z = false;
        if (!TextUtils.isEmpty(b)) {
            String[] split = b.split(StorageInterface.KEY_SPLITER);
            if (split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str = split[i2];
                    if (!TextUtils.isEmpty(str) && String.valueOf(i).equals(str)) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo15662a(int... iArr) {
        if (iArr != null) {
            try {
                this.f7574j.clear();
                for (int valueOf : iArr) {
                    this.f7574j.add(Integer.valueOf(valueOf));
                }
                if (MultiGlobalInfo.m11808b()) {
                    String str = "network_state";
                    String str2 = "sp_global_info";
                    if (!this.f7574j.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        for (Object append : this.f7574j) {
                            sb.append(append);
                            sb.append(StorageInterface.KEY_SPLITER);
                        }
                        SPMultiHelper.m11874a(str2, str, sb.toString());
                    } else {
                        SPMultiHelper.m11869a(str2, str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: o */
    public void mo15685o() {
        m9617e(this.f7565a);
        m9618f(this.f7566b);
    }

    /* renamed from: e */
    private static void m9617e(String str) {
        Predicate.m12257a(str, "appid不能为空");
    }

    /* renamed from: f */
    private static void m9618f(String str) {
        Predicate.m12257a(str, "name不能为空");
    }

    /* renamed from: g */
    private static void m9619g(String str) {
        if (!TextUtils.isEmpty(str)) {
            Predicate.m12258a(str.length() <= 1000, "keyword超长, 最长为1000");
        }
    }

    /* renamed from: h */
    private static void m9620h(String str) {
        if (!TextUtils.isEmpty(str)) {
            Predicate.m12258a(str.length() <= 1000, "data超长, 最长为1000");
        }
    }

    /* renamed from: p */
    public TotalCountLruDiskFile mo15686p() {
        if (this.f7583t == null) {
            this.f7583t = new TotalCountLruDiskFile(10, 8);
        }
        return this.f7583t;
    }

    /* renamed from: q */
    public TotalCountLruDiskDir mo15687q() {
        if (this.f7584u == null) {
            this.f7584u = new TotalCountLruDiskDir(10, 8);
        }
        return this.f7584u;
    }

    /* renamed from: r */
    public boolean mo15688r() {
        if (MultiGlobalInfo.m11808b()) {
            return SPMultiHelper.m11877a("sp_global_info", "is_use_texture", false);
        }
        return this.f7575k;
    }

    /* renamed from: d */
    public void mo15674d(boolean z) {
        if (MultiGlobalInfo.m11808b()) {
            SPMultiHelper.m11870a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.f7575k = z;
    }

    /* renamed from: s */
    public Bitmap mo15689s() {
        if (MultiGlobalInfo.m11808b()) {
            return BitmapUtils.m12136a(SPMultiHelper.m11880b("sp_global_info", "pause_icon", (String) null));
        }
        return this.f7576l;
    }

    /* renamed from: a */
    public void mo15655a(Bitmap bitmap) {
        if (MultiGlobalInfo.m11808b()) {
            String a = BitmapUtils.m12137a(bitmap);
            if (!TextUtils.isEmpty(a)) {
                SPMultiHelper.m11874a("sp_global_info", "pause_icon", a);
            }
        }
        this.f7576l = bitmap;
    }

    /* renamed from: a */
    public void mo15663a(String[] strArr) {
        if (MultiGlobalInfo.m11808b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i2 = i + 1;
                    if (i > 0) {
                        sb.append(StorageInterface.KEY_SPLITER);
                    }
                    sb.append(str);
                    i = i2;
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                SPMultiHelper.m11874a("sp_global_info", "need_clear_task_reset", sb2);
            }
        }
        this.f7580p = strArr;
    }
}
