package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;

/* renamed from: com.bytedance.sdk.openadsdk.component.banner.c */
class BannerCellView extends FrameLayout {
    /* renamed from: a */
    private ImageView f6852a;
    /* renamed from: b */
    private final Context f6853b;
    /* renamed from: c */
    private MaterialMeta f6854c;

    public BannerCellView(Context context) {
        super(context);
        this.f6853b = context;
        m8583c();
    }

    /* renamed from: c */
    private void m8583c() {
        this.f6852a = new ImageView(this.f6853b);
        this.f6852a.setLayoutParams(new LayoutParams(-1, -1));
        this.f6852a.setScaleType(ScaleType.FIT_XY);
        addView(this.f6852a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public MaterialMeta mo15060a() {
        return this.f6854c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15062a(MaterialMeta kVar) {
        this.f6854c = kVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15061a(Bitmap bitmap) {
        this.f6852a.setImageBitmap(bitmap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo15063b() {
        this.f6852a.setImageBitmap(null);
        setOnClickListener(null);
        this.f6854c = null;
    }
}
