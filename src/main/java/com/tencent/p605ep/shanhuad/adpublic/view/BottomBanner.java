package com.tencent.p605ep.shanhuad.adpublic.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.p605ep.shanhuad.C7299R;
import shanhuAD.C8682h;
import shanhuAD.C8682h.C8683a;

/* renamed from: com.tencent.ep.shanhuad.adpublic.view.BottomBanner */
public class BottomBanner extends RelativeLayout {
    /* renamed from: Aj */
    private boolean f24788Aj = true;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();

    public BottomBanner(Context context) {
        super(context, null);
    }

    public void setInfo(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            this.f24788Aj = false;
            return;
        }
        ((TextView) findViewById(C7299R.C7301id.title)).setText(str);
        ((TextView) findViewById(C7299R.C7301id.desc)).setText(str2);
        C8682h.m37695b(str3, new C8683a() {
            public void onLoaded(final Bitmap bitmap) {
                BottomBanner.this.mHandler.post(new Runnable() {
                    public void run() {
                        ((ImageView) BottomBanner.this.findViewById(C7299R.C7301id.icon)).setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    public void showUp() {
        if (this.f24788Aj) {
            setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getHeight(), 0.0f);
            translateAnimation.setDuration(300);
            setAnimation(translateAnimation);
            translateAnimation.start();
        }
    }

    public BottomBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
