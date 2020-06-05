package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

public abstract class TTDislikeDialogAbstract extends Dialog {
    /* renamed from: a */
    private View f6420a;
    /* renamed from: b */
    private MaterialMeta f6421b;

    public abstract int getLayoutId();

    public abstract LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6420a = LayoutInflater.from(getContext()).inflate(getLayoutId(), null);
        if (this.f6420a != null) {
            LayoutParams layoutParams = getLayoutParams();
            View view = this.f6420a;
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            m7998a();
            return;
        }
        throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
    }

    /* renamed from: a */
    private void m7998a() {
        if (this.f6421b != null && this.f6420a != null) {
            int[] tTDislikeListViewIds = getTTDislikeListViewIds();
            if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
                throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
            }
            int length = tTDislikeListViewIds.length;
            int i = 0;
            while (i < length) {
                View findViewById = this.f6420a.findViewById(tTDislikeListViewIds[i]);
                if (findViewById == null) {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                } else if (findViewById instanceof TTDislikeListView) {
                    ((TTDislikeListView) findViewById).setMaterialMeta(this.f6421b);
                    i++;
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                }
            }
        }
    }

    public void setMaterialMeta(MaterialMeta kVar) {
        this.f6421b = kVar;
        m7998a();
    }
}
