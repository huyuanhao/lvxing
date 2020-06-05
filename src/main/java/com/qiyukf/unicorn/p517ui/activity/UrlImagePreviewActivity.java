package com.qiyukf.unicorn.p517ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.basesdk.p412c.C5399c.C5400a;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nim.uikit.common.p424ui.imageview.C5477a;
import com.qiyukf.nim.uikit.common.p424ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.p516j.C6211c;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import com.tencent.mid.core.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity */
public class UrlImagePreviewActivity extends BaseFragmentActivity {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ViewPager f19460b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<String> f19461c;
    /* renamed from: d */
    private Bitmap f19462d;
    /* renamed from: e */
    private Bitmap f19463e;

    /* renamed from: com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity$a */
    private class C6246a extends PagerAdapter {
        private C6246a() {
        }

        /* synthetic */ C6246a(UrlImagePreviewActivity urlImagePreviewActivity, byte b) {
            this();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            ViewGroup viewGroup2 = (ViewGroup) obj;
            viewGroup2.removeAllViews();
            viewGroup.removeView(viewGroup2);
        }

        public final int getCount() {
            return UrlImagePreviewActivity.this.f19461c.size();
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_url_image_preview_item, null);
            final MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) inflate.findViewById(C5961R.C5963id.ysf_image_preview_image);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(C5961R.C5963id.ysf_image_preview_progress);
            multiTouchZoomableImageView.mo27510a(UrlImagePreviewActivity.this.f19460b);
            multiTouchZoomableImageView.mo27511a((C5477a) new C5477a() {
                /* renamed from: a */
                public final void mo27561a() {
                    UrlImagePreviewActivity.this.finish();
                }

                /* renamed from: b */
                public final void mo27562b() {
                    UrlImagePreviewActivity.m24706a(UrlImagePreviewActivity.this, multiTouchZoomableImageView);
                }

                /* renamed from: c */
                public final void mo27563c() {
                    UrlImagePreviewActivity.this.finish();
                }
            });
            UrlImagePreviewActivity urlImagePreviewActivity = UrlImagePreviewActivity.this;
            UrlImagePreviewActivity.m24707a(urlImagePreviewActivity, multiTouchZoomableImageView, progressBar, (String) urlImagePreviewActivity.f19461c.get(i));
            viewGroup.addView(inflate);
            return inflate;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24705a(UrlImagePreviewActivity urlImagePreviewActivity, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            String b = C5946c.m23840b();
            StringBuilder sb = new StringBuilder("img_");
            sb.append(System.currentTimeMillis());
            sb.append(".jpg");
            File file = new File(b, sb.toString());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                urlImagePreviewActivity.sendBroadcast(intent);
                C5415g.m22165b(C5961R.string.ysf_picture_save_to);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        C5415g.m22161a(C5961R.string.ysf_picture_save_fail);
    }

    /* renamed from: a */
    static /* synthetic */ void m24706a(UrlImagePreviewActivity urlImagePreviewActivity, MultiTouchZoomableImageView multiTouchZoomableImageView) {
        if (multiTouchZoomableImageView != null) {
            final Bitmap a = multiTouchZoomableImageView.mo27505a();
            if (a != null && !a.isRecycled() && a != urlImagePreviewActivity.m24711g() && a != urlImagePreviewActivity.m24712h()) {
                C6364g.m25003a((Context) urlImagePreviewActivity, (CharSequence) null, new CharSequence[]{urlImagePreviewActivity.getString(C5961R.string.ysf_save_to_device)}, (C6365a) new C6365a() {
                    /* renamed from: a */
                    public final void mo27603a(int i) {
                        C5399c.m22099a((Activity) UrlImagePreviewActivity.this).mo27354a(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE).mo27353a((C5400a) new C5400a() {
                            public final void onDenied() {
                                C5415g.m22161a(C5961R.string.ysf_no_permission_save_image);
                            }

                            public final void onGranted() {
                                UrlImagePreviewActivity.m24705a(UrlImagePreviewActivity.this, a);
                            }
                        }).mo27355a();
                    }
                });
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24707a(UrlImagePreviewActivity urlImagePreviewActivity, final MultiTouchZoomableImageView multiTouchZoomableImageView, final ProgressBar progressBar, String str) {
        progressBar.setVisibility(0);
        Bitmap a = C6211c.m24640b(str) ? C5426a.m22174a(C6211c.m24641c(str), 0, 0) : null;
        if (a == null || a.isRecycled()) {
            a = urlImagePreviewActivity.m24711g();
        }
        multiTouchZoomableImageView.mo27508a(a);
        C5426a.m22180a(str, (ImageLoaderListener) new ImageLoaderListener() {
            public final void onLoadComplete(Bitmap bitmap) {
                if (multiTouchZoomableImageView.getParent() != null) {
                    progressBar.setVisibility(8);
                    multiTouchZoomableImageView.mo27508a(bitmap);
                }
            }

            public final void onLoadFailed(Throwable th) {
                if (multiTouchZoomableImageView.getParent() != null) {
                    progressBar.setVisibility(8);
                    if (multiTouchZoomableImageView.mo27505a() == UrlImagePreviewActivity.this.m24711g()) {
                        multiTouchZoomableImageView.mo27508a(UrlImagePreviewActivity.this.m24712h());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Bitmap m24711g() {
        if (this.f19462d == null) {
            this.f19462d = BitmapFactory.decodeResource(getResources(), C5961R.C5962drawable.ysf_image_placeholder_loading);
        }
        return this.f19462d;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Bitmap m24712h() {
        if (this.f19463e == null) {
            this.f19463e = BitmapFactory.decodeResource(getResources(), C5961R.C5962drawable.ysf_image_placeholder_fail);
        }
        return this.f19463e;
    }

    public static void start(Context context, ArrayList<String> arrayList, int i) {
        Intent intent = new Intent(context, UrlImagePreviewActivity.class);
        intent.putExtra("url_list", arrayList);
        intent.putExtra("position", i);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27411a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(C5961R.C5964layout.ysf_activity_url_image_preview_activity);
        this.f19460b = (ViewPager) findViewById(C5961R.C5963id.ysf_image_preview_view_pager);
        this.f19461c = getIntent().getStringArrayListExtra("url_list");
        int intExtra = getIntent().getIntExtra("position", 0);
        List<String> list = this.f19461c;
        if (list == null || list.isEmpty() || intExtra >= this.f19461c.size()) {
            finish();
            return;
        }
        if (VERSION.SDK_INT >= 9) {
            this.f19460b.setAdapter(new C6246a(this, 0));
            this.f19460b.setCurrentItem(intExtra);
            this.f19460b.setOffscreenPageLimit(2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Bitmap bitmap = this.f19462d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f19462d.recycle();
        }
        Bitmap bitmap2 = this.f19463e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f19463e.recycle();
        }
        super.onDestroy();
    }
}
