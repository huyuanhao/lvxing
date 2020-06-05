package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.utils.Predicate;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

public class TsView extends FrameLayout {
    /* renamed from: a */
    private final Context f7051a;
    /* renamed from: b */
    private GifView f7052b;
    /* renamed from: c */
    private TTCountdownView f7053c;
    /* renamed from: d */
    private ImageView f7054d;
    /* renamed from: e */
    private FrameLayout f7055e;
    /* renamed from: f */
    private FrameLayout f7056f;
    /* renamed from: g */
    private TextView f7057g;
    /* renamed from: h */
    private NativeExpressView f7058h;

    public TsView(Context context) {
        super(context);
        this.f7051a = context;
        m8867a();
    }

    /* renamed from: a */
    private void m8867a() {
        setLayoutParams(new LayoutParams(-1, -1));
        Context context = this.f7051a;
        View inflate = inflate(context, ResourceHelp.m11936f(context, "tt_splash_view"), this);
        this.f7052b = (GifView) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_splash_ad_gif"));
        this.f7053c = (TTCountdownView) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_splash_skip_btn"));
        this.f7054d = (ImageView) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_splash_video_ad_mute"));
        this.f7055e = (FrameLayout) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_splash_video_container"));
        this.f7056f = (FrameLayout) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_splash_express_container"));
        this.f7057g = (TextView) inflate.findViewById(ResourceHelp.m11935e(this.f7051a, "tt_ad_logo"));
    }

    /* access modifiers changed from: 0000 */
    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            this.f7058h = nativeExpressView;
            this.f7056f.addView(this.f7058h);
            setExpressViewVisibility(0);
            setVideoViewVisibility(8);
            setImageViewVisibility(8);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setCountDownTime(int i) {
        TTCountdownView tTCountdownView = this.f7053c;
        if (tTCountdownView != null) {
            tTCountdownView.setCountDownTime(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setSkipIconVisibility(int i) {
        UIUtils.m12059a((View) this.f7053c, i);
    }

    /* access modifiers changed from: 0000 */
    public FrameLayout getVideoContainer() {
        return this.f7055e;
    }

    /* access modifiers changed from: 0000 */
    public void setVideoViewVisibility(int i) {
        UIUtils.m12059a((View) this.f7055e, i);
        UIUtils.m12059a((View) this.f7054d, i);
    }

    /* access modifiers changed from: 0000 */
    public void setAdlogoViewVisibility(int i) {
        UIUtils.m12059a((View) this.f7057g, i);
    }

    /* access modifiers changed from: 0000 */
    public void setImageViewVisibility(int i) {
        UIUtils.m12059a((View) this.f7052b, i);
    }

    /* access modifiers changed from: 0000 */
    public void setExpressViewVisibility(int i) {
        UIUtils.m12059a((View) this.f7056f, i);
    }

    /* access modifiers changed from: 0000 */
    public void setDrawable(Drawable drawable) {
        this.f7052b.setScaleType(ScaleType.FIT_XY);
        this.f7052b.setImageDrawable(drawable);
    }

    /* access modifiers changed from: 0000 */
    public void setGifView(byte[] bArr) {
        this.f7052b.setScaleType(ScaleType.CENTER_CROP);
        this.f7052b.mo16326a(bArr, false);
    }

    /* access modifiers changed from: 0000 */
    public TTCountdownView getCountDownView() {
        return this.f7053c;
    }

    /* access modifiers changed from: 0000 */
    public View getDislikeView() {
        return this.f7053c;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        Predicate.m12256a("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        Predicate.m12256a("不允许在Splash广告中注册OnTouchListener");
    }

    /* access modifiers changed from: final */
    public final void setOnTouchListenerInternal(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    /* access modifiers changed from: final */
    public final void setOnClickListenerInternal(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: final */
    public final void setSkipListener(OnClickListener onClickListener) {
        TTCountdownView tTCountdownView = this.f7053c;
        if (tTCountdownView != null) {
            tTCountdownView.setOnClickListener(onClickListener);
        }
    }

    /* access modifiers changed from: final */
    public final void setVoiceViewListener(OnClickListener onClickListener) {
        ImageView imageView = this.f7054d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    /* access modifiers changed from: final */
    public final void setVoiceViewImageResource(int i) {
        ImageView imageView = this.f7054d;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }
}
