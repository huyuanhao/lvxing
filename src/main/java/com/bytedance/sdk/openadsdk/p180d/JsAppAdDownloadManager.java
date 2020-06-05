package com.bytedance.sdk.openadsdk.p180d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.video.p176b.IBaseVideoBusiness;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.C2417a;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTJSDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTJSDownloadAdapter.C2418a;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.d.a */
public class JsAppAdDownloadManager implements JsDownloadManager {
    /* renamed from: a */
    private final MaterialMeta f8482a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final JsDownloadListener f8483b;
    /* renamed from: c */
    private final Map<String, ITTJSDownloadAdapter> f8484c = new HashMap();

    private JsAppAdDownloadManager(JsDownloadListener bVar, MaterialMeta kVar) {
        this.f8483b = bVar;
        this.f8482a = kVar;
    }

    /* renamed from: a */
    public static JsAppAdDownloadManager m11017a(JsDownloadListener bVar, MaterialMeta kVar) {
        return new JsAppAdDownloadManager(bVar, kVar);
    }

    /* renamed from: a */
    public void mo16442a() {
        for (ITTDownloadAdapter aVar : this.f8484c.values()) {
            if (aVar != null) {
                aVar.mo16513b();
            }
        }
    }

    /* renamed from: b */
    public void mo16446b() {
        for (ITTDownloadAdapter aVar : this.f8484c.values()) {
            if (aVar != null) {
                aVar.mo16516c();
            }
        }
    }

    /* renamed from: c */
    public void mo16448c() {
        mo16446b();
        for (ITTDownloadAdapter aVar : this.f8484c.values()) {
            if (aVar != null) {
                aVar.mo16518d();
            }
        }
        this.f8484c.clear();
    }

    /* renamed from: a */
    private MaterialMeta m11016a(JSONObject jSONObject, String str) {
        String str2 = null;
        if (jSONObject == null) {
            return null;
        }
        MaterialMeta kVar = new MaterialMeta();
        kVar.mo15463b(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            kVar.mo15491i(str);
        }
        if (this.f8482a == null) {
            return kVar;
        }
        if (kVar.mo15426N() != null) {
            str2 = kVar.mo15426N().mo15342b();
        }
        if (TextUtils.isEmpty(str2)) {
            return this.f8482a;
        }
        return (this.f8482a.mo15426N() == null || !str2.equals(this.f8482a.mo15426N().mo15342b())) ? kVar : this.f8482a;
    }

    /* renamed from: a */
    public void mo16444a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        if (context != null && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                m11021a(context, m11016a(optJSONObject, str), optJSONObject, i, z);
            }
        }
    }

    /* renamed from: a */
    private void m11021a(Context context, MaterialMeta kVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && kVar != null && kVar.mo15426N() != null && jSONObject != null && this.f8483b != null && ((ITTJSDownloadAdapter) this.f8484c.get(kVar.mo15426N().mo15342b())) == null) {
            String a = ToolUtils.m11993a(i);
            if (!TextUtils.isEmpty(a)) {
                this.f8484c.put(kVar.mo15426N().mo15342b(), m11019a(context, kVar, jSONObject, a, z));
            }
        }
    }

    /* renamed from: a */
    public void mo16443a(Context context, JSONObject jSONObject) {
        if (context != null && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                m11020a(context, m11016a(optJSONObject, (String) null));
            }
        }
    }

    /* renamed from: a */
    private void m11020a(Context context, MaterialMeta kVar) {
        if (context != null && kVar != null && kVar.mo15426N() != null) {
            ITTJSDownloadAdapter bVar = (ITTJSDownloadAdapter) this.f8484c.get(kVar.mo15426N().mo15342b());
            if (bVar != null) {
                bVar.mo16522h();
            }
            if (context instanceof IBaseVideoBusiness) {
                ((IBaseVideoBusiness) context).mo14922P();
            }
        }
    }

    /* renamed from: a */
    public void mo16445a(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                m11022a(m11016a(optJSONObject, (String) null), optJSONObject);
            }
        }
    }

    /* renamed from: a */
    private void m11022a(MaterialMeta kVar, JSONObject jSONObject) {
        if (this.f8483b != null && kVar != null && kVar.mo15426N() != null) {
            String b = kVar.mo15426N().mo15342b();
            if (this.f8484c.containsKey(b)) {
                this.f8484c.remove(b);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.f8483b.mo16412a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo16447b(JSONObject jSONObject) {
        if (jSONObject != null && this.f8483b != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ITTJSDownloadAdapter bVar = (ITTJSDownloadAdapter) this.f8484c.get(m11016a(optJSONObject, (String) null).mo15426N().mo15342b());
                if (bVar != null) {
                    bVar.mo16521g();
                }
            }
        }
    }

    /* renamed from: a */
    private ITTJSDownloadAdapter m11019a(final Context context, final MaterialMeta kVar, final JSONObject jSONObject, String str, final boolean z) {
        ITTJSDownloadAdapter b = TTDownloadFactory.m11075b(context, kVar, str);
        b.mo16510a((TTAppDownloadListener) new TTAppDownloadListener() {
            public void onIdle() {
                m11030a(NotificationCompat.CATEGORY_STATUS, "idle");
            }

            public void onDownloadActive(long j, long j2, String str, String str2) {
                m11030a(NotificationCompat.CATEGORY_STATUS, "download_active", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            public void onDownloadPaused(long j, long j2, String str, String str2) {
                m11030a(NotificationCompat.CATEGORY_STATUS, "download_paused", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            public void onDownloadFailed(long j, long j2, String str, String str2) {
                m11030a(NotificationCompat.CATEGORY_STATUS, "download_failed", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j2));
            }

            public void onDownloadFinished(long j, String str, String str2) {
                m11030a(NotificationCompat.CATEGORY_STATUS, "download_finished", "total_bytes", String.valueOf(j), "current_bytes", String.valueOf(j));
            }

            public void onInstalled(String str, String str2) {
                m11030a(NotificationCompat.CATEGORY_STATUS, "installed");
            }

            /* renamed from: a */
            private void m11030a(String... strArr) {
                if (strArr != null && strArr.length % 2 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", "success");
                        jSONObject.put("appad", jSONObject);
                        for (int i = 0; i < strArr.length; i += 2) {
                            jSONObject.put(strArr[i], strArr[i + 1]);
                        }
                        JsAppAdDownloadManager.this.f8483b.mo16412a("app_ad_event", jSONObject);
                    } catch (JSONException unused) {
                        C2564t.m12220b("JsAppAdDownloadManager", "JSONException");
                    }
                }
            }
        }, false);
        b.mo16474a(new C2418a() {
        });
        b.mo16505a(3, (C2417a) new C2417a() {
            /* renamed from: a */
            public boolean mo14872a(int i, MaterialMeta kVar, String str, String str2, Object obj) {
                if (i == 3 && kVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    String str3 = "click_start_detail";
                    String str4 = "click_start";
                    boolean z = false;
                    if (!z) {
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case -1297985154:
                                if (str2.equals("click_continue")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -777040223:
                                if (str2.equals("click_open")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 565370917:
                                if (str2.equals(str3)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 1682049151:
                                if (str2.equals("click_pause")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1685366507:
                                if (str2.equals(str4)) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        if (!(c == 0 || c == 1 || c == 2 || c == 3 || c == 4)) {
                            z = true;
                        }
                        return z;
                    } else if (str2.equals(str4)) {
                        AdEventManager.m8388a(context, kVar, str, str3, (JSONObject) null);
                        return false;
                    }
                }
                return true;
            }
        });
        return b;
    }
}
