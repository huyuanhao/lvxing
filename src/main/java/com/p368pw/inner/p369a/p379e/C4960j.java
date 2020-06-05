package com.p368pw.inner.p369a.p379e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.p368pw.inner.C4817a;
import com.p368pw.inner.C5069b;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5167c;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p388a.C5153c.C5157a;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.base.p387d.p391d.C5186d;
import com.p368pw.inner.p369a.p370a.p371a.C4827e;
import com.p368pw.inner.p369a.p379e.C4933e.C4940a;
import com.p368pw.view.WebActivity.IWebActivityListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;

/* renamed from: com.pw.inner.a.e.j */
public class C4960j {
    /* renamed from: a */
    public static int m20728a(final Context context, final C4958h hVar, C5183b bVar, final C4827e eVar, final C4940a aVar) {
        if (hVar == null) {
            return 0;
        }
        try {
            if (!TextUtils.isEmpty(hVar.mo26241m())) {
                C5205o.m21462a("vd dp ph");
                Intent parseUri = Intent.parseUri(hVar.mo26241m(), 0);
                if (parseUri.resolveActivity(context.getPackageManager()) != null) {
                    parseUri.setFlags(268435456);
                    context.startActivity(parseUri);
                    eVar.mo25789a(1, bVar);
                    return 0;
                }
            }
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        if (!TextUtils.isEmpty(hVar.mo26239l())) {
            C5205o.m21462a("vd jm ph");
            if (C5125f.m21216a().mo26727d().mo26714r() == 1) {
                C5167c.m21323a(context, hVar.mo26235j(), hVar.mo26239l());
            } else {
                String uuid = TextUtils.isEmpty(hVar.mo26244p()) ? UUID.randomUUID().toString() : hVar.mo26244p();
                C5186d.m21367a(uuid, new IWebActivityListener() {
                    public void onClose(int i) {
                        C4827e eVar = eVar;
                        if (eVar == null) {
                            return;
                        }
                        if (i == 1) {
                            eVar.mo25799d(1);
                        } else if (i == 2) {
                            eVar.mo25807l();
                        }
                    }
                });
                C5167c.m21324a(context, hVar.mo26235j(), hVar.mo26239l(), uuid);
            }
            if (eVar != null) {
                eVar.mo25789a(2, bVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("vd wb url: ");
            sb.append(hVar.mo26239l());
            C5205o.m21462a(sb.toString());
            return 0;
        }
        String g = hVar.mo26229g();
        String f = hVar.mo26227f();
        if (TextUtils.isEmpty(g)) {
            g = f;
        }
        if (eVar != null) {
            eVar.mo25789a(1, bVar);
        }
        if (!C5191i.m21390a(context, g) || !C5069b.m21115a().mo26583b(g)) {
            int a = C5153c.m21275a().mo26760a(context, f, g, (C5157a) new C5157a() {
                public void onComplete(String str, String str2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("vd apk path = ");
                    sb.append(str2);
                    C5205o.m21462a(sb.toString());
                    C4827e eVar = eVar;
                    if (eVar != null) {
                        eVar.mo25791a(str, str2);
                    }
                    C4940a aVar = aVar;
                    if (aVar != null) {
                        aVar.mo26164b(str, str2);
                    }
                    C4817a.m19685a(context, str, hVar, eVar, aVar);
                    C4960j.m20732a(context, hVar, 21);
                }

                public void onProgress(final int i) {
                    C5208r.m21479a(new Runnable() {
                        public void run() {
                            if (aVar != null) {
                                aVar.mo26162a(i);
                            }
                        }
                    });
                }
            }, eVar);
            if (a == 2) {
                return 2;
            }
            if (a == 4) {
                if (eVar != null) {
                    eVar.mo25790a(g);
                }
                m20732a(context, hVar, 20);
                return 1;
            }
            if (a == 1) {
                C4817a.m19685a(context, g, hVar, eVar, aVar);
                C5153c.m21275a().mo26762a(context, g, eVar);
                return 3;
            }
            return 0;
        }
        C5205o.m21462a("open app");
        C5187e.m21376c(context, g);
        if (eVar != null) {
            eVar.mo25805j();
        }
        return 4;
    }

    /* renamed from: a */
    private static String m20729a(String str, C5183b bVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (bVar != null) {
            str = str.replace("__clk_down_x__", String.valueOf(z ? bVar.f16880e : bVar.f16876a)).replace("__clk_down_y__", String.valueOf(z ? bVar.f16881f : bVar.f16877b)).replace("__clk_up_x__", String.valueOf(z ? bVar.f16882g : bVar.f16878c)).replace("__clk_up_y__", String.valueOf(z ? bVar.f16883h : bVar.f16879d));
        }
        return str.replace("__clk_time__", String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: a */
    private static List<String> m20730a(JSONArray jSONArray, C5183b bVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String a = m20729a(jSONArray.optString(i), bVar, z);
                if (!TextUtils.isEmpty(a)) {
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m20731a(Context context, int i, C4958h hVar) {
        if (i == 25) {
            try {
                m20732a(context, hVar, 3);
            } catch (Throwable th) {
                C5205o.m21464a(th);
                return;
            }
        }
        if (i == 50) {
            m20732a(context, hVar, 4);
        }
        if (i == 75) {
            m20732a(context, hVar, 5);
        }
        if (i == 100) {
            m20732a(context, hVar, 6);
        }
    }

    /* renamed from: a */
    public static void m20732a(Context context, C4958h hVar, int i) {
        JSONArray a;
        try {
            C4959i k = hVar.mo26237k();
            if (k != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("hd stat type = ");
                sb.append(i);
                C5205o.m21462a(sb.toString());
                switch (i) {
                    case 0:
                        a = k.mo26250a();
                        break;
                    case 1:
                        a = k.mo26251b();
                        break;
                    case 2:
                        a = k.mo26252c();
                        break;
                    case 3:
                        a = k.mo26253d();
                        break;
                    case 4:
                        a = k.mo26254e();
                        break;
                    case 5:
                        a = k.mo26255f();
                        break;
                    case 6:
                        a = k.mo26256g();
                        break;
                    case 7:
                        a = k.mo26257h();
                        break;
                    case 8:
                        a = k.mo26258i();
                        break;
                    case 9:
                        a = k.mo26259j();
                        break;
                    case 10:
                        a = k.mo26260k();
                        break;
                    case 11:
                        a = k.mo26261l();
                        break;
                    case 12:
                        a = k.mo26262m();
                        break;
                    case 13:
                        a = k.mo26265p();
                        break;
                    case 14:
                        a = k.mo26266q();
                        break;
                    case 15:
                        a = k.mo26267r();
                        break;
                    case 16:
                        a = k.mo26268s();
                        break;
                    case 17:
                        a = k.mo26269t();
                        break;
                    case 18:
                        a = k.mo26270u();
                        break;
                    case 19:
                        a = k.mo26271v();
                        break;
                    case 20:
                        a = k.mo26263n();
                        break;
                    case 21:
                        a = k.mo26264o();
                        break;
                }
                m20738b(context, a);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public static void m20733a(Context context, C4958h hVar, int i, C5183b bVar, C4827e eVar, C4940a aVar, boolean z) {
        String str;
        if (i != 1 || z) {
            int a = m20728a(context, hVar, bVar, eVar, aVar);
            if (a == 1) {
                str = "开始下载";
            } else if (a == 2) {
                str = "正在下载，请稍后";
            } else if (a == 3) {
                str = "已经下载，开始安装";
            } else {
                if (a == 4) {
                    str = "已经安装，打开该应用";
                }
                return;
            }
            Toast.makeText(context, str, 0).show();
            return;
        }
        C5205o.m21462a("vd nt jump");
    }

    /* renamed from: a */
    private static void m20734a(Context context, List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        C5194l.m21437f((String) list.get(i));
                    }
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* renamed from: a */
    public static void m20735a(Context context, JSONArray jSONArray) {
        m20738b(context, jSONArray);
    }

    /* renamed from: a */
    public static void m20736a(Context context, JSONArray jSONArray, C5183b bVar, boolean z) {
        m20734a(context, m20730a(jSONArray, bVar, z));
    }

    /* renamed from: a */
    public static void m20737a(C4958h hVar, C5183b bVar, boolean z) {
        if (hVar != null) {
            hVar.mo26234j(m20729a(hVar.mo26241m(), bVar, z));
            hVar.mo26232i(m20729a(hVar.mo26239l(), bVar, z));
            hVar.mo26219c(m20729a(hVar.mo26227f(), bVar, z));
        }
    }

    /* renamed from: b */
    private static void m20738b(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        C5194l.m21437f(jSONArray.get(i).toString());
                    }
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }
}
