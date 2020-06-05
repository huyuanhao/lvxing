package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.p522qq.p523e.ads.nativ.NativeExpressAD.ADListenerAdapter;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.AdData;
import com.p522qq.p523e.comm.p525pi.NEADI;
import com.p522qq.p523e.comm.p525pi.NEADVI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.nativ.NativeExpressADView */
public class NativeExpressADView extends FrameLayout {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public NEADVI f20068a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f20069b = false;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile boolean f20070c = false;
    /* access modifiers changed from: private|volatile */
    /* renamed from: d */
    public volatile boolean f20071d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public NativeExpressMediaListener f20072e;
    public Map<String, String> ext = new HashMap();
    /* renamed from: f */
    private AdData f20073f;
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile boolean f20074g = false;
    /* renamed from: h */
    private ViewBindStatusListener f20075h;

    /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$ViewBindStatusListener */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(NEADI neadi, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        final Context context2 = context;
        super(context);
        this.f20073f = m25131a(hashMap);
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final String str3 = str;
        final NEADI neadi2 = neadi;
        final ADSize aDSize2 = aDSize;
        final String str4 = str2;
        final JSONObject jSONObject2 = jSONObject;
        final HashMap<String, JSONObject> hashMap2 = hashMap;
        C63991 r0 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(context2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        NativeExpressADView.this.f20068a = pOFactory.getNativeExpressADView(neadi2, context2, NativeExpressADView.this, aDSize2, str3, str4, jSONObject2, hashMap2);
                                        NativeExpressADView.this.f20069b = true;
                                        if (NativeExpressADView.this.f20072e != null) {
                                            NativeExpressADView.this.setMediaListener(NativeExpressADView.this.f20072e);
                                        }
                                        if (NativeExpressADView.this.f20070c) {
                                            NativeExpressADView.this.preloadVideo();
                                        }
                                        if (NativeExpressADView.this.f20071d) {
                                            NativeExpressADView.this.render();
                                        }
                                        if (NativeExpressADView.this.f20074g) {
                                            NativeExpressADView.this.negativeFeedback();
                                        }
                                    }
                                } catch (Throwable th) {
                                    NativeExpressADView.this.f20069b = true;
                                    throw th;
                                }
                                NativeExpressADView.this.f20069b = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init Native Express AD View plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                }
            }
        };
        executorService.execute(r0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c A[RETURN] */
    /* renamed from: a */
    private static com.p522qq.p523e.comm.p525pi.AdData m25131a(java.util.HashMap<java.lang.String, org.json.JSONObject> r2) {
        /*
        java.lang.String r0 = "adinfo"
        r1 = 0
        if (r2 == 0) goto L_0x000c
        java.lang.Object r2 = r2.get(r0)     // Catch:{ JSONException -> 0x0014 }
        org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ JSONException -> 0x0014 }
        goto L_0x000d
    L_0x000c:
        r2 = r1
    L_0x000d:
        if (r2 == 0) goto L_0x0014
        java.lang.Object r2 = r2.get(r0)     // Catch:{ JSONException -> 0x0014 }
        goto L_0x0015
    L_0x0014:
        r2 = r1
    L_0x0015:
        boolean r0 = r2 instanceof com.p522qq.p523e.comm.p525pi.AdData
        if (r0 == 0) goto L_0x001c
        com.qq.e.comm.pi.AdData r2 = (com.p522qq.p523e.comm.p525pi.AdData) r2
        return r2
    L_0x001c:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.ads.nativ.NativeExpressADView.m25131a(java.util.HashMap):com.qq.e.comm.pi.AdData");
    }

    public void destroy() {
        NEADVI neadvi = this.f20068a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    public AdData getBoundData() {
        return this.f20073f;
    }

    public void negativeFeedback() {
        if (!this.f20069b) {
            this.f20074g = true;
            return;
        }
        NEADVI neadvi = this.f20068a;
        if (neadvi != null) {
            neadvi.reportAdNegative();
            this.f20074g = false;
            return;
        }
        GDTLogger.m25260e("Native Express negativeFeedback  core is null");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewBindStatusListener viewBindStatusListener = this.f20075h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewBindStatusListener viewBindStatusListener = this.f20075h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f20075h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.f20075h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.f20069b) {
            this.f20070c = true;
            return;
        }
        NEADVI neadvi = this.f20068a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.m25260e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.f20069b) {
            this.f20071d = true;
            return;
        }
        NEADVI neadvi = this.f20068a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.m25260e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f20068a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.f20072e = nativeExpressMediaListener;
        NEADVI neadvi = this.f20068a;
        if (neadvi != null && nativeExpressMediaListener != null) {
            neadvi.setAdListener(new ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.f20075h = viewBindStatusListener;
    }
}
