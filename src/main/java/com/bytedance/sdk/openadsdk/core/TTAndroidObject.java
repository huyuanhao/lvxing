package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.NetApi.C2287b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressVideoListener;
import com.bytedance.sdk.openadsdk.core.nativeexpress.RenderListener;
import com.bytedance.sdk.openadsdk.core.p167a.PendingDownloadListener;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo.C2226a;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.NetExtParams;
import com.bytedance.sdk.openadsdk.core.p170d.RenderInfo;
import com.bytedance.sdk.openadsdk.core.video.p176b.IBaseVideoBusiness;
import com.bytedance.sdk.openadsdk.p163a.AppInfo;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p180d.JsAppAdDownloadManager;
import com.bytedance.sdk.openadsdk.p180d.JsDownloadListener;
import com.bytedance.sdk.openadsdk.p180d.JsDownloadManager;
import com.bytedance.sdk.openadsdk.p180d.TeMaiIdsListener;
import com.bytedance.sdk.openadsdk.p184e.ContainerSizeListener;
import com.bytedance.sdk.openadsdk.p184e.JsLoadAdListener;
import com.bytedance.sdk.openadsdk.p184e.PlayableLoadingListener;
import com.bytedance.sdk.openadsdk.p184e.SendRewardListener;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.JsBridgeUtils;
import com.bytedance.sdk.openadsdk.utils.LoadUrlUtils;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.stat.common.DeviceInfo;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.x */
public class TTAndroidObject implements JsDownloadListener, C2539a {
    /* renamed from: f */
    private static final Map<String, Boolean> f8431f = new ConcurrentHashMap();
    /* renamed from: A */
    private boolean f8432A = false;
    /* renamed from: B */
    private boolean f8433B = false;
    /* renamed from: a */
    protected Map<String, Object> f8434a;
    /* renamed from: b */
    boolean f8435b;
    /* renamed from: c */
    boolean f8436c = false;
    /* renamed from: d */
    private WeakReference<WebView> f8437d;
    /* renamed from: e */
    private C2538ak f8438e;
    /* renamed from: g */
    private WeakReference<Context> f8439g;
    /* renamed from: h */
    private JsDownloadManager f8440h;
    /* renamed from: i */
    private String f8441i;
    /* renamed from: j */
    private String f8442j;
    /* renamed from: k */
    private int f8443k;
    /* renamed from: l */
    private String f8444l;
    /* renamed from: m */
    private MaterialMeta f8445m;
    /* renamed from: n */
    private boolean f8446n = true;
    /* renamed from: o */
    private RenderListener f8447o;
    /* renamed from: p */
    private ExpressVideoListener f8448p;
    /* renamed from: q */
    private JSONObject f8449q;
    /* renamed from: r */
    private TeMaiIdsListener f8450r;
    /* renamed from: s */
    private ContainerSizeListener f8451s;
    /* renamed from: t */
    private SendRewardListener f8452t;
    /* renamed from: u */
    private PlayableLoadingListener f8453u;
    /* renamed from: v */
    private JSONObject f8454v;
    /* renamed from: w */
    private PendingDownloadListener f8455w;
    /* renamed from: x */
    private boolean f8456x = true;
    /* access modifiers changed from: private */
    /* renamed from: y */
    public List<MaterialMeta> f8457y;
    /* renamed from: z */
    private HashMap<String, H5AdInteractionManager> f8458z;

    /* compiled from: TTAndroidObject */
    /* renamed from: com.bytedance.sdk.openadsdk.core.x$a */
    public static class C2381a {
        /* renamed from: a */
        public String f8471a;
        /* renamed from: b */
        public String f8472b;
        /* renamed from: c */
        public String f8473c;
        /* renamed from: d */
        public JSONObject f8474d;
        /* renamed from: e */
        public int f8475e;
    }

    static {
        f8431f.put("log_event", Boolean.TRUE);
        f8431f.put("private", Boolean.TRUE);
        f8431f.put("dispatch_message", Boolean.TRUE);
        f8431f.put("custom_event", Boolean.TRUE);
        f8431f.put("log_event_v3", Boolean.TRUE);
    }

    public TTAndroidObject(Context context) {
        this.f8439g = new WeakReference<>(context);
        this.f8438e = new C2538ak(Looper.getMainLooper(), this);
    }

    /* renamed from: j */
    private WebView m10952j() {
        WeakReference<WebView> weakReference = this.f8437d;
        if (weakReference != null) {
            return (WebView) weakReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public TTAndroidObject mo16398a(WebView webView) {
        this.f8437d = new WeakReference<>(webView);
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16411a(boolean z) {
        this.f8435b = z;
        return this;
    }

    /* renamed from: b */
    public TTAndroidObject mo16418b(boolean z) {
        this.f8433B = z;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16407a(String str) {
        this.f8441i = str;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16400a(MaterialMeta kVar) {
        this.f8445m = kVar;
        return this;
    }

    /* renamed from: a */
    public MaterialMeta mo16396a() {
        return this.f8445m;
    }

    /* renamed from: b */
    public boolean mo16420b() {
        MaterialMeta kVar = this.f8445m;
        return kVar != null && kVar.mo15465b();
    }

    /* renamed from: b */
    public TTAndroidObject mo16416b(String str) {
        this.f8442j = str;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16397a(int i) {
        this.f8443k = i;
        return this;
    }

    /* renamed from: c */
    public TTAndroidObject mo16421c(String str) {
        this.f8444l = str;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16402a(RenderListener jVar) {
        this.f8447o = jVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16401a(ExpressVideoListener gVar) {
        this.f8448p = gVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16403a(TeMaiIdsListener dVar) {
        this.f8450r = dVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16399a(PendingDownloadListener dVar) {
        this.f8455w = dVar;
        return this;
    }

    /* renamed from: c */
    public TTAndroidObject mo16422c(boolean z) {
        this.f8456x = z;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16410a(JSONObject jSONObject) {
        this.f8449q = jSONObject;
        return this;
    }

    /* renamed from: b */
    public TTAndroidObject mo16417b(JSONObject jSONObject) {
        this.f8454v = jSONObject;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16409a(Map<String, Object> map) {
        this.f8434a = map;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16404a(ContainerSizeListener aVar) {
        this.f8451s = aVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16406a(SendRewardListener dVar) {
        this.f8452t = dVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16405a(PlayableLoadingListener cVar) {
        this.f8453u = cVar;
        return this;
    }

    /* renamed from: a */
    public TTAndroidObject mo16408a(List<MaterialMeta> list) {
        this.f8457y = list;
        return this;
    }

    /* renamed from: c */
    public boolean mo16423c() {
        return this.f8436c;
    }

    /* renamed from: k */
    private List<String> m10954k() {
        return Arrays.asList(new String[]{"appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds"});
    }

    /* renamed from: a */
    private void m10932a(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String put : m10954k()) {
            jSONArray.put(put);
        }
        jSONObject.put(AppEntity.KEY_APP_NAME_STR, AppInfo.m7999a());
        jSONObject.put("innerAppName", AppInfo.m8004e());
        jSONObject.put(DeviceInfo.TAG_ANDROID_ID, AppInfo.m8001b());
        jSONObject.put("sdkEdition", AppInfo.m8002c());
        jSONObject.put("appVersion", AppInfo.m8003d());
        jSONObject.put("netType", AppInfo.m8005f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put(Constants.FLAG_DEVICE_ID, AppInfo.m8000a(InternalContainer.m10059a()));
    }

    /* renamed from: c */
    private void m10942c(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.f8441i)) {
            jSONObject.put("cid", this.f8441i);
        }
        if (!TextUtils.isEmpty(this.f8442j)) {
            jSONObject.put("log_extra", this.f8442j);
        }
        if (!TextUtils.isEmpty(this.f8444l)) {
            jSONObject.put("download_url", this.f8444l);
        }
    }

    /* renamed from: d */
    private void m10944d(JSONObject jSONObject) throws Exception {
        MaterialMeta kVar = this.f8445m;
        if (kVar != null && !TextUtils.isEmpty(kVar.mo15471d())) {
            jSONObject.put("playable_style", this.f8445m.mo15471d());
        }
    }

    /* renamed from: a */
    private void m10927a(C2381a aVar) throws Exception {
        if (NotificationCompat.CATEGORY_CALL.equals(aVar.f8471a)) {
            JSONObject jSONObject = new JSONObject();
            if ("appInfo".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    m10932a(jSONObject, aVar.f8475e);
                    m10939b(aVar.f8472b, jSONObject);
                }
                return;
            }
            if ("adInfo".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    m10942c(jSONObject);
                    m10939b(aVar.f8472b, jSONObject);
                }
                return;
            }
            if ("playable_style".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    m10944d(jSONObject);
                    m10939b(aVar.f8472b, jSONObject);
                }
                return;
            }
            if ("getTemplateInfo".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    JSONObject jSONObject2 = this.f8449q;
                    if (jSONObject2 != null) {
                        jSONObject2.put("setting", m10958m());
                    }
                    m10939b(aVar.f8472b, this.f8449q);
                }
                return;
            }
            if ("getTeMaiAds".equals(aVar.f8473c) && !TextUtils.isEmpty(aVar.f8472b) && this.f8454v != null) {
                m10939b(aVar.f8472b, this.f8454v);
            }
            if ("isViewable".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    jSONObject.put("viewStatus", this.f8433B);
                    m10939b(aVar.f8472b, jSONObject);
                }
                return;
            }
            if ("getScreenSize".equals(aVar.f8473c)) {
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    ContainerSizeListener aVar2 = this.f8451s;
                    if (aVar2 != null) {
                        int b = aVar2.mo14882b();
                        int a = this.f8451s.mo14881a();
                        jSONObject.put("width", b);
                        jSONObject.put("height", a);
                        m10939b(aVar.f8472b, jSONObject);
                    }
                }
                return;
            }
            boolean z = true;
            if ("getVolume".equals(aVar.f8473c)) {
                AudioManager audioManager = (AudioManager) InternalContainer.m10059a().getSystemService("audio");
                int i = -1;
                if (audioManager != null) {
                    i = audioManager.getStreamVolume(3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("音乐音量 >>>> AudioManager-->currentVolume=");
                    sb.append(i);
                    C2564t.m12220b("TTAndroidObject", sb.toString());
                }
                if (!TextUtils.isEmpty(aVar.f8472b)) {
                    if (i > 0) {
                        z = false;
                    }
                    jSONObject.put("endcard_mute", z);
                    m10939b(aVar.f8472b, jSONObject);
                }
                return;
            }
            if ("removeLoading".equals(aVar.f8473c)) {
                PlayableLoadingListener cVar = this.f8453u;
                if (cVar != null) {
                    cVar.mo14884a();
                }
                return;
            }
            if ("sendReward".equals(aVar.f8473c)) {
                this.f8436c = true;
                SendRewardListener dVar = this.f8452t;
                if (dVar != null) {
                    dVar.mo14883a();
                }
            }
            boolean a2 = m10934a(aVar, jSONObject);
            if (!TextUtils.isEmpty(aVar.f8472b) && a2) {
                m10939b(aVar.f8472b, jSONObject);
            }
        }
    }

    /* renamed from: a */
    private boolean m10934a(C2381a aVar, JSONObject jSONObject) {
        String str = "download_app_ad";
        if (this.f8435b) {
            try {
                JSONObject optJSONObject = aVar.f8474d.optJSONObject("data");
                if (optJSONObject != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("替换 download_url 前 appAdJson:");
                    sb.append(optJSONObject.toString());
                    C2564t.m12220b(str, sb.toString());
                    optJSONObject.put("download_url", this.f8445m.mo15426N().mo15342b());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("替换 download_url 后 appAdJson::");
                    sb2.append(optJSONObject.toString());
                    C2564t.m12222c(str, sb2.toString());
                }
            } catch (Throwable unused) {
            }
        }
        String str2 = aVar.f8473c;
        char c = 65535;
        switch (str2.hashCode()) {
            case -2036781162:
                if (str2.equals("subscribe_app_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -1169135450:
                if (str2.equals("changeVideoState")) {
                    c = 10;
                    break;
                }
                break;
            case -800853518:
                if (str2.equals("clickEvent")) {
                    c = 5;
                    break;
                }
                break;
            case -489318846:
                if (str2.equals("getMaterialMeta")) {
                    c = 13;
                    break;
                }
                break;
            case -278382602:
                if (str2.equals("send_temai_product_ids")) {
                    c = 12;
                    break;
                }
                break;
            case 27837080:
                if (str2.equals(str)) {
                    c = 1;
                    break;
                }
                break;
            case 105049135:
                if (str2.equals("unsubscribe_app_ad")) {
                    c = 3;
                    break;
                }
                break;
            case 571273292:
                if (str2.equals("dynamicTrack")) {
                    c = 7;
                    break;
                }
                break;
            case 672928467:
                if (str2.equals("cancel_download_app_ad")) {
                    c = 2;
                    break;
                }
                break;
            case 711635577:
                if (str2.equals("getCurrentVideoState")) {
                    c = 11;
                    break;
                }
                break;
            case 1151744482:
                if (str2.equals("muteVideo")) {
                    c = 9;
                    break;
                }
                break;
            case 1237100796:
                if (str2.equals("renderDidFinish")) {
                    c = 6;
                    break;
                }
                break;
            case 1713585602:
                if (str2.equals("getNetworkData")) {
                    c = 14;
                    break;
                }
                break;
            case 2086000188:
                if (str2.equals("skipVideo")) {
                    c = 8;
                    break;
                }
                break;
            case 2105008900:
                if (str2.equals("landscape_click")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m10963p();
                WeakReference<Context> weakReference = this.f8439g;
                if (weakReference != null) {
                    Context context = (Context) weakReference.get();
                    if (context != null) {
                        this.f8440h.mo16444a(context, aVar.f8474d, this.f8442j, this.f8443k, this.f8446n);
                        break;
                    }
                }
                break;
            case 1:
                PendingDownloadListener dVar = this.f8455w;
                if (dVar == null) {
                    if (this.f8440h != null) {
                        WeakReference<Context> weakReference2 = this.f8439g;
                        if (weakReference2 != null) {
                            Context context2 = (Context) weakReference2.get();
                            if (context2 != null) {
                                this.f8440h.mo16443a(context2, aVar.f8474d);
                                break;
                            }
                        }
                    } else {
                        return false;
                    }
                } else {
                    dVar.mo14949a(this.f8456x);
                    return false;
                }
                break;
            case 2:
                JsDownloadManager cVar = this.f8440h;
                if (cVar != null) {
                    cVar.mo16447b(aVar.f8474d);
                    break;
                } else {
                    return false;
                }
            case 3:
                JsDownloadManager cVar2 = this.f8440h;
                if (cVar2 != null) {
                    cVar2.mo16445a(aVar.f8474d);
                    break;
                } else {
                    return false;
                }
            case 4:
                WeakReference<Context> weakReference3 = this.f8439g;
                if (weakReference3 != null) {
                    Context context3 = (Context) weakReference3.get();
                    if (context3 != null && (context3 instanceof IBaseVideoBusiness)) {
                        ((IBaseVideoBusiness) context3).mo14922P();
                        break;
                    }
                }
                break;
            case 5:
                m10950h(aVar.f8474d);
                break;
            case 6:
                m10951i(aVar.f8474d);
                break;
            case 7:
                m10953j(aVar.f8474d);
                break;
            case 8:
                m10956l();
                break;
            case 9:
                m10946e(aVar.f8474d);
                break;
            case 10:
                m10948f(aVar.f8474d);
                break;
            case 11:
                return m10949g(jSONObject);
            case 12:
                m10955k(aVar.f8474d);
                break;
            case 13:
                return m10957l(jSONObject);
            case 14:
                m10937b(aVar, jSONObject);
                break;
        }
        return false;
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            m10942c(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            m10932a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        try {
            if (this.f8449q != null) {
                this.f8449q.put("setting", m10958m());
            }
            return this.f8449q.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            m10951i(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m10946e(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        TTAndroidObject.this.m10946e(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
            C2564t.m12226e("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            m10953j(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m10948f(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        TTAndroidObject.this.m10948f(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m10950h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        TTAndroidObject.this.m10950h(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        m10956l();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        m10949g(jSONObject);
        return jSONObject.toString();
    }

    /* renamed from: l */
    private void m10956l() {
        ExpressVideoListener gVar = this.f8448p;
        if (gVar != null) {
            gVar.mo14902J();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10946e(JSONObject jSONObject) {
        if (this.f8448p != null && jSONObject != null) {
            try {
                this.f8448p.mo14910e(jSONObject.optBoolean("mute", false));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10948f(JSONObject jSONObject) {
        if (this.f8448p != null && jSONObject != null) {
            try {
                this.f8448p.mo14909d(jSONObject.optInt("stateType", -1));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: g */
    private boolean m10949g(JSONObject jSONObject) {
        ExpressVideoListener gVar = this.f8448p;
        if (!(gVar == null || jSONObject == null)) {
            double K = (double) gVar.mo14903K();
            int L = this.f8448p.mo14904L();
            try {
                jSONObject.put("currentTime", K / 1000.0d);
                jSONObject.put(ArgKey.KEY_STATE, L);
                StringBuilder sb = new StringBuilder();
                sb.append("currentTime,state:");
                sb.append(L);
                C2564t.m12220b("TTAndroidObject", sb.toString());
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: m */
    private JSONObject m10958m() {
        JSONObject jSONObject = new JSONObject();
        if (InternalContainer.m10069h() != null) {
            try {
                int d = ToolUtils.m12018d(this.f8442j);
                int g = InternalContainer.m10069h().mo15790g(String.valueOf(d));
                boolean b = InternalContainer.m10069h().mo15778b(String.valueOf(d));
                jSONObject.put("voice_control", InternalContainer.m10069h().mo15777b(d));
                jSONObject.put("rv_skip_time", g);
                jSONObject.put("fv_skip_show", b);
                String str = "show_dislike";
                int i = 0;
                boolean z = this.f8445m != null && this.f8445m.mo15457ac();
                jSONObject.put(str, z);
                String str2 = "video_adaptation";
                if (this.f8445m != null) {
                    i = this.f8445m.mo15479f();
                }
                jSONObject.put(str2, i);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10950h(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        int i;
        String str;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        int i2;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            try {
                String optString = jSONObject2.optString("adId");
                int optInt = jSONObject2.optInt("areaType", 1);
                JSONObject optJSONObject = jSONObject2.optJSONObject("clickInfo");
                double d10 = 0.0d;
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble("down_x", 0.0d);
                    d7 = optJSONObject.optDouble("down_y", 0.0d);
                    d6 = optJSONObject.optDouble("up_x", 0.0d);
                    d5 = optJSONObject.optDouble("up_y", 0.0d);
                    d4 = optJSONObject.optDouble("down_time", 0.0d);
                    double d11 = optDouble;
                    double optDouble2 = optJSONObject.optDouble("up_time", 0.0d);
                    double optDouble3 = optJSONObject.optDouble("button_x", 0.0d);
                    double optDouble4 = optJSONObject.optDouble("button_y", 0.0d);
                    double optDouble5 = optJSONObject.optDouble("button_width", 0.0d);
                    d = optJSONObject.optDouble("button_height", 0.0d);
                    d10 = d11;
                    d8 = optDouble2;
                    d3 = optDouble4;
                    d2 = optDouble5;
                    str = optString;
                    i = optInt;
                    d9 = optDouble3;
                } else {
                    str = optString;
                    i = optInt;
                    d9 = 0.0d;
                    d8 = 0.0d;
                    d7 = 0.0d;
                    d6 = 0.0d;
                    d5 = 0.0d;
                    d4 = 0.0d;
                    d3 = 0.0d;
                    d2 = 0.0d;
                    d = 0.0d;
                }
                DynamicClickInfo a = new C2226a().mo15401d((int) d10).mo15400c((int) d7).mo15398b((int) d6).mo15395a((int) d5).mo15399b((long) d4).mo15396a((long) d8).mo15402e((int) d9).mo15403f((int) d3).mo15404g((int) d2).mo15405h((int) d).mo15397a();
                if (this.f8447o != null) {
                    i2 = i;
                    this.f8447o.mo15184a(i2, a);
                } else {
                    i2 = i;
                }
                m10931a(str, i2, a);
            } catch (Exception unused) {
                RenderListener jVar = this.f8447o;
                if (jVar != null) {
                    jVar.mo15184a(-1, null);
                }
            }
        }
    }

    /* renamed from: i */
    private void m10951i(JSONObject jSONObject) {
        double d;
        boolean z;
        JSONObject jSONObject2 = jSONObject;
        if (this.f8447o != null && jSONObject2 != null) {
            RenderInfo mVar = new RenderInfo();
            try {
                boolean optBoolean = jSONObject2.optBoolean("isRenderSuc");
                JSONObject optJSONObject = jSONObject2.optJSONObject("AdSize");
                String str = "height";
                String str2 = "width";
                double d2 = 0.0d;
                if (optJSONObject != null) {
                    d2 = optJSONObject.optDouble(str2);
                    d = optJSONObject.optDouble(str);
                } else {
                    d = 0.0d;
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("videoInfo");
                if (optJSONObject2 != null) {
                    double optDouble = optJSONObject2.optDouble("x");
                    double optDouble2 = optJSONObject2.optDouble("y");
                    z = optBoolean;
                    double optDouble3 = optJSONObject2.optDouble(str2);
                    double optDouble4 = optJSONObject2.optDouble(str);
                    mVar.mo15536c(optDouble);
                    mVar.mo15538d(optDouble2);
                    mVar.mo15540e(optDouble3);
                    mVar.mo15542f(optDouble4);
                } else {
                    z = optBoolean;
                }
                String optString = jSONObject2.optString("message", C2240g.m9576a(101));
                int optInt = jSONObject2.optInt("code", 101);
                mVar.mo15531a(z);
                mVar.mo15528a(d2);
                mVar.mo15534b(d);
                mVar.mo15530a(optString);
                mVar.mo15529a(optInt);
                this.f8447o.mo15185a(mVar);
            } catch (Exception unused) {
                mVar.mo15529a(101);
                mVar.mo15530a(C2240g.m9576a(101));
                this.f8447o.mo15185a(mVar);
            }
        }
    }

    /* renamed from: j */
    private void m10953j(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Uri parse = Uri.parse(jSONObject.optString("trackData"));
                if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                    JsBridgeUtils.m12207a(parse, this);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: k */
    private void m10955k(JSONObject jSONObject) {
        if (jSONObject != null && this.f8450r != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("temaiProductIds");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    this.f8450r.mo14934a(false, null);
                } else {
                    this.f8450r.mo14934a(true, optJSONArray);
                }
            } catch (Exception unused) {
                this.f8450r.mo14934a(false, null);
            }
        }
    }

    /* renamed from: l */
    private boolean m10957l(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", m10936b(this.f8457y));
        } catch (Exception unused) {
        }
        return true;
    }

    /* renamed from: b */
    private void m10937b(final C2381a aVar, final JSONObject jSONObject) {
        if (aVar != null) {
            try {
                m10933a(aVar.f8474d, (JsLoadAdListener) new JsLoadAdListener() {
                    /* renamed from: a */
                    public void mo16441a(boolean z, List<MaterialMeta> list) {
                        if (z) {
                            try {
                                jSONObject.put("creatives", TTAndroidObject.this.m10936b(list));
                                TTAndroidObject.this.m10939b(aVar.f8472b, jSONObject);
                            } catch (Exception unused) {
                            }
                        } else {
                            TTAndroidObject.this.m10939b(aVar.f8472b, jSONObject);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public void mo16426d() {
        m10933a((JSONObject) null, (JsLoadAdListener) new JsLoadAdListener() {
            /* renamed from: a */
            public void mo16441a(boolean z, List<MaterialMeta> list) {
                TTAndroidObject.this.f8457y = list;
                TTAndroidObject.this.m10961n();
                TTAndroidObject.this.mo16428e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m10961n() {
        List<MaterialMeta> list = this.f8457y;
        if (list != null && list.size() > 0) {
            this.f8458z = new HashMap<>();
            View view = null;
            WeakReference<WebView> weakReference = this.f8437d;
            if (weakReference != null) {
                view = (View) weakReference.get();
            }
            WeakReference<Context> weakReference2 = this.f8439g;
            if (weakReference2 != null) {
                Context context = (Context) weakReference2.get();
                if (context != null) {
                    for (MaterialMeta kVar : this.f8457y) {
                        this.f8458z.put(kVar.mo15425M(), new H5AdInteractionManager(context, kVar, view));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m10931a(String str, int i, DynamicClickInfo iVar) {
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, H5AdInteractionManager> hashMap = this.f8458z;
            if (hashMap != null) {
                H5AdInteractionManager iVar2 = (H5AdInteractionManager) hashMap.get(str);
                if (iVar2 != null) {
                    iVar2.mo15825a(i, iVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m10933a(JSONObject jSONObject, final JsLoadAdListener bVar) {
        if (bVar != null) {
            try {
                if (this.f8445m != null) {
                    if (!TextUtils.isEmpty(this.f8442j)) {
                        int c = ToolUtils.m12014c(this.f8442j);
                        AdSlot j = this.f8445m.mo15492j();
                        NetExtParams lVar = new NetExtParams();
                        if (this.f8445m.mo15510x() != null) {
                            lVar.f7454e = 2;
                        }
                        JSONObject Y = this.f8445m.mo15437Y();
                        if (Y == null) {
                            Y = new JSONObject();
                        }
                        if (jSONObject != null) {
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                Y.put(str, jSONObject.opt(str));
                            }
                        }
                        lVar.f7456g = Y;
                        InternalContainer.m10067f().mo15917a(j, lVar, c, (C2287b) new C2287b() {
                            /* renamed from: a */
                            public void mo14946a(int i, String str) {
                                bVar.mo16441a(false, null);
                            }

                            /* renamed from: a */
                            public void mo14947a(AdInfo aVar) {
                                if (aVar.mo15336c() == null || aVar.mo15336c().isEmpty()) {
                                    bVar.mo16441a(false, null);
                                } else {
                                    bVar.mo16441a(true, aVar.mo15336c());
                                }
                            }
                        });
                    }
                }
                bVar.mo16441a(false, null);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    public void mo16428e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", m10936b(this.f8457y));
            mo16412a("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public JSONArray m10936b(List<MaterialMeta> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(((MaterialMeta) list.get(i)).mo15459ae());
        }
        return jSONArray;
    }

    /* renamed from: o */
    private boolean m10962o() {
        MaterialMeta kVar = this.f8445m;
        if (kVar == null || kVar.mo15437Y() == null || this.f8445m.mo15503q() || this.f8432A || this.f8445m.mo15437Y().optInt("parent_type") != 2) {
            return false;
        }
        int c = ToolUtils.m12014c(this.f8442j);
        if (c != 8 && c != 7) {
            return false;
        }
        this.f8432A = true;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10939b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            m10959m(jSONObject2);
        } catch (Exception unused) {
        }
    }

    /* renamed from: m */
    private void m10959m(JSONObject jSONObject) {
        if (jSONObject != null) {
            WebView j = m10952j();
            if (j != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("javascript:ToutiaoJSBridge._handleMessageFromToutiao(");
                sb.append(jSONObject.toString());
                sb.append(")");
                String sb2 = sb.toString();
                LoadUrlUtils.m12210a(j, sb2);
                if (C2564t.m12217a()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("js_msg ");
                    sb3.append(sb2);
                    C2564t.m12215a("TTAndroidObject", sb3.toString());
                }
            }
        }
    }

    /* renamed from: c */
    private void m10941c(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
                jSONObject2.put("__event_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                m10959m(jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|(1:8)|9|10|(1:24)(2:12|(2:14|25)(2:15|23))|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057 A[Catch:{ Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
    /* renamed from: d */
    private void m10943d(java.lang.String r9) {
        /*
        r8 = this;
        java.lang.String r0 = "TTAndroidObject"
        java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0072 }
        r2 = 2
        byte[] r2 = android.util.Base64.decode(r9, r2)     // Catch:{ Exception -> 0x0072 }
        r1.<init>(r2)     // Catch:{ Exception -> 0x0072 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r0, r1)     // Catch:{ Exception -> 0x0072 }
        org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x0072 }
        r2.<init>(r1)     // Catch:{ Exception -> 0x0072 }
        int r1 = r2.length()     // Catch:{ Exception -> 0x0072 }
        r3 = 0
    L_0x0019:
        if (r3 >= r1) goto L_0x0093
        com.bytedance.sdk.openadsdk.core.x$a r4 = new com.bytedance.sdk.openadsdk.core.x$a     // Catch:{ Exception -> 0x0072 }
        r4.m43944init()     // Catch:{ Exception -> 0x0072 }
        org.json.JSONObject r5 = r2.optJSONObject(r3)     // Catch:{ all -> 0x004f }
        if (r5 == 0) goto L_0x004f
        java.lang.String r6 = "__msg_type"
        r7 = 0
        java.lang.String r6 = r5.optString(r6, r7)     // Catch:{ all -> 0x004f }
        r4.f8471a = r6     // Catch:{ all -> 0x004f }
        java.lang.String r6 = "__callback_id"
        java.lang.String r6 = r5.optString(r6, r7)     // Catch:{ all -> 0x004f }
        r4.f8472b = r6     // Catch:{ all -> 0x004f }
        java.lang.String r6 = "func"
        java.lang.String r6 = r5.optString(r6)     // Catch:{ all -> 0x004f }
        r4.f8473c = r6     // Catch:{ all -> 0x004f }
        java.lang.String r6 = "params"
        org.json.JSONObject r6 = r5.optJSONObject(r6)     // Catch:{ all -> 0x004f }
        r4.f8474d = r6     // Catch:{ all -> 0x004f }
        java.lang.String r6 = "JSSDK"
        int r5 = r5.optInt(r6)     // Catch:{ all -> 0x004f }
        r4.f8475e = r5     // Catch:{ all -> 0x004f }
    L_0x004f:
        java.lang.String r5 = r4.f8471a     // Catch:{ Exception -> 0x0072 }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0072 }
        if (r5 != 0) goto L_0x006f
        java.lang.String r5 = r4.f8473c     // Catch:{ Exception -> 0x0072 }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0072 }
        if (r5 == 0) goto L_0x0060
        goto L_0x006f
    L_0x0060:
        com.bytedance.sdk.openadsdk.utils.ak r5 = r8.f8438e     // Catch:{ Exception -> 0x0072 }
        r6 = 11
        android.os.Message r5 = r5.obtainMessage(r6)     // Catch:{ Exception -> 0x0072 }
        r5.obj = r4     // Catch:{ Exception -> 0x0072 }
        com.bytedance.sdk.openadsdk.utils.ak r4 = r8.f8438e     // Catch:{ Exception -> 0x0072 }
        r4.sendMessage(r5)     // Catch:{ Exception -> 0x0072 }
    L_0x006f:
        int r3 = r3 + 1
        goto L_0x0019
        boolean r1 = com.bytedance.sdk.openadsdk.utils.C2564t.m12217a()
        if (r1 == 0) goto L_0x008e
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "failed to parse jsbridge msg queue "
        r1.append(r2)
        r1.append(r9)
        java.lang.String r9 = r1.toString()
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r0, r9)
        goto L_0x0093
    L_0x008e:
        java.lang.String r9 = "failed to parse jsbridge msg queue"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12225d(r0, r9)
    L_0x0093:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.TTAndroidObject.m10943d(java.lang.String):void");
    }

    /* renamed from: a */
    public boolean mo16413a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (f8431f.containsKey(uri.getHost())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void mo16419b(Uri uri) {
        long j;
        String str = "TTAndroidObject";
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host)) {
                if (!"log_event_v3".equals(host)) {
                    if (!"private".equals(host)) {
                        if (!"dispatch_message".equals(host)) {
                            C2564t.m12225d(str, "handlrUir: not match schema host");
                            return;
                        }
                    }
                    m10947f(uri.toString());
                    return;
                }
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            long j2 = 0;
            try {
                j = Long.parseLong(uri.getQueryParameter(ArgKey.KEY_VALUE));
            } catch (Exception unused) {
                j = 0;
            }
            try {
                j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
            } catch (Exception unused2) {
            }
            long j3 = j2;
            JSONObject jSONObject = null;
            String queryParameter4 = uri.getQueryParameter("extra");
            if (!TextUtils.isEmpty(queryParameter4)) {
                try {
                    jSONObject = new JSONObject(queryParameter4);
                } catch (Exception unused3) {
                }
            }
            AdEventManager.m8396a(queryParameter, m10945e(queryParameter2), queryParameter3, j, j3, "click".equals(queryParameter3) ? m10960n(jSONObject) : jSONObject);
        } catch (Exception e) {
            C2564t.m12221b(str, "handleUri exception: ", e);
        }
    }

    /* renamed from: n */
    private JSONObject m10960n(JSONObject jSONObject) {
        String str = "ad_extra_data";
        if (this.f8434a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString(str, null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Entry entry : this.f8434a.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject.put(str, jSONObject2.toString());
            } catch (Exception e) {
                C2564t.m12219b(e.toString());
            }
        }
        return jSONObject;
    }

    /* renamed from: f */
    public String mo16429f() {
        return ToolUtils.m11993a(this.f8443k);
    }

    /* renamed from: e */
    private String m10945e(String str) {
        return this.f8447o == null ? ToolUtils.m11993a(this.f8443k) : str;
    }

    /* renamed from: f */
    private void m10947f(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            String str2 = "bytedance://private/setresult/";
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView j = m10952j();
                    if (j != null) {
                        LoadUrlUtils.m12210a(j, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith(str2)) {
                    int indexOf = str.indexOf(38, 30);
                    if (indexOf > 0) {
                        String substring = str.substring(30, indexOf);
                        String substring2 = str.substring(indexOf + 1);
                        if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                            m10943d(substring2);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: g */
    public void mo16430g() {
        JsDownloadManager cVar = this.f8440h;
        if (cVar != null) {
            cVar.mo16442a();
        }
        if (m10962o()) {
            mo16426d();
        }
    }

    /* renamed from: h */
    public void mo16433h() {
        JsDownloadManager cVar = this.f8440h;
        if (cVar != null) {
            cVar.mo16446b();
        }
    }

    /* renamed from: i */
    public void mo16434i() {
        JsDownloadManager cVar = this.f8440h;
        if (cVar != null) {
            cVar.mo16448c();
        }
    }

    /* renamed from: a */
    public void mo14813a(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof C2381a)) {
            try {
                m10927a((C2381a) message.obj);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: p */
    private void m10963p() {
        if (this.f8440h == null) {
            this.f8440h = JsAppAdDownloadManager.m11017a((JsDownloadListener) this, this.f8445m);
        }
    }

    /* renamed from: a */
    public void mo16412a(String str, JSONObject jSONObject) {
        m10941c(str, jSONObject);
    }
}
