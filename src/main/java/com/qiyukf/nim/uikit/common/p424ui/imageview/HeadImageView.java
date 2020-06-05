package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.HeadImageView */
public class HeadImageView extends ShapedImageView {
    /* renamed from: a */
    public static final int f17611a = ((int) C5433b.m22189a().getResources().getDimension(C5961R.dimen.ysf_avatar_size));

    public HeadImageView(Context context) {
        super(context);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void mo27537a(String str) {
        int i = f17611a;
        setImageResource(C5718b.m23017d().userInfoProvider.getDefaultIconResId());
        UserInfo userInfo = C5718b.m23017d().userInfoProvider.getUserInfo(str);
        if (userInfo == null || !C5426a.m22183b(userInfo.getAvatar())) {
            setTag(null);
            return;
        }
        setTag(userInfo.getAvatar());
        String avatar = userInfo.getAvatar();
        final Object tag = getTag();
        C54741 r2 = new ImageLoaderListener() {
            public final void onLoadComplete(Bitmap bitmap) {
                if (HeadImageView.this.getTag() != null && HeadImageView.this.getTag().equals(tag)) {
                    HeadImageView.this.setImageBitmap(bitmap);
                }
            }

            public final void onLoadFailed(Throwable th) {
            }
        };
        Bitmap a = C5426a.m22173a(avatar);
        if (a != null) {
            r2.onLoadComplete(a);
        } else {
            C5426a.m22177a(avatar, i, i, (ImageLoaderListener) r2);
        }
    }
}
