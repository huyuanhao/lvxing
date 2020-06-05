package com.ali.auth.third.p034ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.model.C1028i;
import com.ali.auth.third.core.model.C1030k;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.core.p023b.C0986d;
import com.ali.auth.third.core.p023b.C0986d.C0987a;
import com.ali.auth.third.core.p023b.C0988e;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.util.C1039d;
import com.ali.auth.third.p016a.p019c.C0965b;
import com.ali.auth.third.p016a.p019c.C0971d;
import com.ali.auth.third.p034ui.p035a.C1068b;
import com.ali.auth.third.p034ui.p037iv.C1078a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.ui.NQRView */
public class NQRView extends FrameLayout {
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static long f2096b;
    /* renamed from: a */
    Handler f2097a;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public LinearLayout f2098c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public LinearLayout f2099d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public LinearLayout f2100e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public LinearLayout f2101f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ImageView f2102g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public TextView f2103h;
    /* renamed from: i */
    private Button f2104i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public C0985c f2105j;
    /* renamed from: k */
    private RelativeLayout f2106k;
    /* renamed from: l */
    private LinearLayout f2107l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean f2108m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C0986d f2109n;

    public NQRView(Context context) {
        this(context, null);
    }

    public NQRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2097a = new Handler();
        this.f2108m = true;
        this.f2109n = new C0986d() {
            /* renamed from: a */
            public void mo10305a(int i, String str) {
                NQRView.this.m2026a(R.string.auth_sdk_message_10010_message);
                NQRView.this.f2105j.mo10305a(i, str);
            }

            /* renamed from: a */
            public void mo10306a(C1030k kVar) {
                NQRView.this.m2035b();
                NQRView.this.m2044f();
                NQRView.this.f2105j.mo10306a(kVar);
            }

            /* renamed from: a */
            public void mo10307a(String str, int i) {
                NQRView nQRView;
                int i2;
                if (i == 4) {
                    return;
                }
                if (i != 5) {
                    if (i != 6) {
                        NQRView.this.m2035b();
                        nQRView = NQRView.this;
                        i2 = R.string.auth_sdk_message_10010_message;
                    } else {
                        NQRView.this.m2035b();
                        nQRView = NQRView.this;
                        i2 = R.string.auth_sdk_message_qr_expired;
                    }
                    nQRView.m2026a(i2);
                    return;
                }
                NQRView.this.m2041e();
            }

            /* renamed from: a */
            public void mo10308a(String str, Bitmap bitmap, C0987a aVar) {
                NQRView.this.f2102g.setImageBitmap(bitmap);
                NQRView.this.m2039d();
            }
        };
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2026a(final int i) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                NQRView.this.m2037c();
                NQRView.this.f2098c.setVisibility(8);
                NQRView.this.f2101f.setVisibility(8);
                NQRView.this.f2103h.setText(i);
                NQRView.this.f2099d.setVisibility(0);
                NQRView.this.f2100e.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2027a(int i, int i2, final C0986d dVar) {
        QRView.f2130a = new C0985c() {
            /* renamed from: a */
            public void mo10305a(int i, String str) {
            }

            /* renamed from: a */
            public void mo10306a(C1030k kVar) {
                NQRView.this.m2035b();
                dVar.mo10306a(kVar);
            }
        };
        this.f2107l.setVisibility(0);
        this.f2106k.setVisibility(8);
        new C0965b(new C0988e() {
            /* renamed from: a */
            public void mo10305a(int i, String str) {
                dVar.mo10305a(i, str);
            }

            /* renamed from: a */
            public void mo10309a(Object obj) {
                Map map = (Map) obj;
                Bitmap bitmap = (Bitmap) map.remove("imageBitMap");
                final String str = (String) map.get("at");
                HashMap hashMap = new HashMap();
                hashMap.put("qrCodeInfo", map);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("params", hashMap);
                final String jSONObject = C1039d.m1996a((Map<String, ? extends Object>) hashMap2).toString();
                dVar.mo10308a(str, bitmap, null);
                NQRView.f2096b = System.currentTimeMillis();
                NQRView.this.f2097a.postDelayed(new Runnable() {
                    public void run() {
                        if (!NQRView.this.f2108m) {
                            NQRView.this.m2033a(str, jSONObject, dVar);
                            NQRView.this.f2097a.postDelayed(this, 2000);
                        }
                    }
                }, 3000);
                NQRView.this.f2108m = false;
            }
        }).execute(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), null});
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2032a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("scene");
            String optString2 = jSONObject.optString("iv_token");
            final String optString3 = jSONObject.optString("login_token");
            if (TextUtils.equals("true", jSONObject.optString("nativeIv")) && !TextUtils.isEmpty(optString2)) {
                C1078a.m2095a(optString2, "8", new C1028i() {
                });
            }
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2033a(final String str, String str2, final C0986d dVar) {
        new C0971d(new C1068b() {
            /* renamed from: a */
            public Activity mo10406a() {
                return null;
            }

            /* renamed from: a */
            public void mo10407a(int i, String str) {
                if (i == 13060) {
                    NQRView.this.m2035b();
                    NQRView.this.m2032a(str);
                    return;
                }
                dVar.mo10305a(i, str);
            }

            /* renamed from: a */
            public void mo10408a(String str) {
                String str2 = "code";
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (System.currentTimeMillis() - NQRView.f2096b > 900000) {
                        NQRView.this.m2035b();
                        dVar.mo10307a(str, 10022);
                        return;
                    }
                    dVar.mo10307a(str, jSONObject.getInt(str2));
                    if (jSONObject.getInt(str2) == 6) {
                        NQRView.this.m2035b();
                    }
                } catch (JSONException e) {
                    Log.e("NQRView", "check qrcode status error ", e);
                }
            }

            /* renamed from: b */
            public void mo10409b(String str) {
                dVar.mo10305a(1, str);
            }
        }, true).execute(new String[]{str2});
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2035b() {
        if (this.f2097a != null) {
            this.f2108m = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2037c() {
        this.f2107l.setVisibility(0);
        this.f2106k.setVisibility(8);
        this.f2106k.removeAllViews();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2039d() {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                NQRView.this.m2037c();
                NQRView.this.f2098c.setVisibility(0);
                NQRView.this.f2099d.setVisibility(8);
                NQRView.this.f2101f.setVisibility(8);
                NQRView.this.f2100e.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2041e() {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                NQRView.this.f2098c.setVisibility(8);
                NQRView.this.f2099d.setVisibility(8);
                NQRView.this.f2100e.setVisibility(8);
                NQRView.this.f2101f.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2044f() {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                NQRView.this.m2037c();
                NQRView.this.f2098c.setVisibility(8);
                NQRView.this.f2099d.setVisibility(8);
                NQRView.this.f2101f.setVisibility(8);
                NQRView.this.f2100e.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.ali_auth_nqrview;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2035b();
        if (this.f2102g != null) {
            this.f2102g = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2107l = (LinearLayout) findViewById(R.id.ali_auth_nqrview);
        this.f2102g = (ImageView) findViewById(R.id.ali_auth_nqrview_qr_image);
        this.f2104i = (Button) findViewById(R.id.ali_auth_nqrview_error_refresh);
        this.f2098c = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_qr);
        this.f2099d = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_errortips);
        this.f2101f = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_scanedtips);
        this.f2100e = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_successedtips);
        this.f2103h = (TextView) findViewById(R.id.ali_auth_nqrview_error_main);
        this.f2104i.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                NQRView.this.f2099d.setVisibility(8);
                NQRView nQRView = NQRView.this;
                nQRView.m2027a(nQRView.getWidth(), NQRView.this.getHeight(), NQRView.this.f2109n);
            }
        });
        this.f2106k = (RelativeLayout) findViewById(R.id.ali_auth_verify_rl);
    }

    public void setNQrCodeLoginCallback(C0986d dVar) {
        if (dVar != null) {
            this.f2109n = dVar;
        }
    }
}
