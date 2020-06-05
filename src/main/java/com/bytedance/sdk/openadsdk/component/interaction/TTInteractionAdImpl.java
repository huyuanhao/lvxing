package com.bytedance.sdk.openadsdk.component.interaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1963c;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener;
import com.bytedance.sdk.openadsdk.core.ImageLoadListener;
import com.bytedance.sdk.openadsdk.core.InsertAdDialog;
import com.bytedance.sdk.openadsdk.core.InsertAdDialog.C2262a;
import com.bytedance.sdk.openadsdk.core.p167a.ClickCreativeListener;
import com.bytedance.sdk.openadsdk.core.p167a.ClickListener.C2203a;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.TTDownloadFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.component.interaction.b */
class TTInteractionAdImpl implements TTInteractionAd {
    /* renamed from: i */
    private static boolean f6891i;
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final Context f6892a;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final MaterialMeta f6893b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Dialog f6894c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AdInteractionListener f6895d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public ITTDownloadAdapter f6896e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ImageLoadListener f6897f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public ImageView f6898g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public ImageView f6899h;

    TTInteractionAdImpl(Context context, MaterialMeta kVar) {
        this.f6892a = context;
        this.f6893b = kVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15087a(ImageLoadListener kVar) {
        this.f6897f = kVar;
        AdEventManager.m8392a(this.f6893b);
        if (getInteractionType() == 4) {
            this.f6896e = TTDownloadFactory.m11071a(this.f6892a, this.f6893b, "interaction");
        }
        m8641a();
    }

    /* renamed from: a */
    private void m8641a() {
        if (this.f6894c == null) {
            this.f6894c = new InsertAdDialog(this.f6892a);
            this.f6894c.setOnShowListener(new OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    if (TTInteractionAdImpl.this.f6894c.isShowing()) {
                        AdEventManager.m8389a(TTInteractionAdImpl.this.f6892a, TTInteractionAdImpl.this.f6893b, "interaction", null);
                        if (TTInteractionAdImpl.this.f6895d != null) {
                            TTInteractionAdImpl.this.f6895d.onAdShow();
                        }
                        if (TTInteractionAdImpl.this.f6893b.mo15433U()) {
                            ToolUtils.m12001a(TTInteractionAdImpl.this.f6893b, (View) TTInteractionAdImpl.this.f6899h);
                        }
                    }
                }
            });
            this.f6894c.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (TTInteractionAdImpl.this.f6896e != null) {
                        TTInteractionAdImpl.this.f6896e.mo16518d();
                    }
                }
            });
            ((InsertAdDialog) this.f6894c).mo15835a(false, new C2262a() {
                /* renamed from: a */
                public void mo15091a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    TTInteractionAdImpl.this.f6899h = imageView;
                    TTInteractionAdImpl.this.f6898g = imageView2;
                    TTInteractionAdImpl.this.m8644b();
                    TTInteractionAdImpl.this.m8646c();
                }

                /* renamed from: a */
                public void mo15090a(View view) {
                    TTInteractionAdImpl.this.m8648d();
                    AdEventManager.m8381a(TTInteractionAdImpl.this.f6892a, TTInteractionAdImpl.this.f6893b, "interaction");
                    if (TTInteractionAdImpl.this.f6895d != null) {
                        TTInteractionAdImpl.this.f6895d.onAdDismiss();
                    }
                    C2564t.m12220b("TTInteractionAdImpl", "dislike事件发出");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8644b() {
        ClickCreativeListener aVar = new ClickCreativeListener(this.f6892a, this.f6893b, "interaction", 3);
        aVar.mo15277a((View) this.f6899h);
        aVar.mo15286b(this.f6898g);
        aVar.mo15283a(this.f6896e);
        aVar.mo15280a((C2203a) new C2203a() {
            /* renamed from: a */
            public void mo15083a(View view, int i) {
                if (TTInteractionAdImpl.this.f6895d != null) {
                    TTInteractionAdImpl.this.f6895d.onAdClicked();
                }
                if (i == 2 || i == 3 || i == 5) {
                    TTInteractionAdImpl.this.m8648d();
                    if (TTInteractionAdImpl.this.f6895d != null) {
                        TTInteractionAdImpl.this.f6895d.onAdDismiss();
                    }
                }
            }
        });
        this.f6899h.setOnClickListener(aVar);
        this.f6899h.setOnTouchListener(aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8646c() {
        int b = ((Image) this.f6893b.mo15418F().get(0)).mo15409b();
        TTNetClient.m11428a(this.f6892a).mo16660g().mo14199a(((Image) this.f6893b.mo15418F().get(0)).mo15406a(), (C1964d) new C1964d() {
            /* renamed from: a */
            public void mo14215a() {
            }

            /* renamed from: a */
            public void mo14171a(C1982p<Bitmap> pVar) {
            }

            /* renamed from: b */
            public void mo14217b() {
            }

            /* renamed from: a */
            public void mo14216a(C1963c cVar, boolean z) {
                if (cVar == null || cVar.mo14214a() == null) {
                    if (TTInteractionAdImpl.this.f6897f != null) {
                        TTInteractionAdImpl.this.f6897f.mo15086b();
                    }
                    return;
                }
                TTInteractionAdImpl.this.f6899h.setImageBitmap(cVar.mo14214a());
                if (TTInteractionAdImpl.this.f6897f != null) {
                    TTInteractionAdImpl.this.f6897f.mo15085a();
                }
            }

            /* renamed from: b */
            public void mo14172b(C1982p<Bitmap> pVar) {
                if (TTInteractionAdImpl.this.f6897f != null) {
                    TTInteractionAdImpl.this.f6897f.mo15086b();
                }
            }
        }, b, b);
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.f6895d = adInteractionListener;
    }

    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ITTDownloadAdapter aVar = this.f6896e;
        if (aVar != null) {
            aVar.mo16509a(tTAppDownloadListener);
        }
    }

    public int getInteractionType() {
        MaterialMeta kVar = this.f6893b;
        if (kVar == null) {
            return -1;
        }
        return kVar.mo15414B();
    }

    public Map<String, Object> getMediaExtraInfo() {
        MaterialMeta kVar = this.f6893b;
        if (kVar != null) {
            return kVar.mo15436X();
        }
        return null;
    }

    public void showInteractionAd(Activity activity) {
        if (!activity.isFinishing()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (!f6891i) {
                    f6891i = true;
                    this.f6894c.show();
                }
                return;
            }
            throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8648d() {
        f6891i = false;
        this.f6894c.dismiss();
    }
}
