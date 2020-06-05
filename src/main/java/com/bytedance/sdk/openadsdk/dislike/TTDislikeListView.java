package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p165c.AdEventManager;
import java.util.ArrayList;
import java.util.List;

public class TTDislikeListView extends ListView {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public MaterialMeta f8493a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public OnItemClickListener f8494b;
    /* renamed from: c */
    private OnItemClickListener f8495c = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (TTDislikeListView.this.getAdapter() == null || TTDislikeListView.this.getAdapter().getItem(i) == null || !(TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
            FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
            if (!filterWord.hasSecondOptions()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(filterWord);
                if (TTDislikeListView.this.f8493a != null) {
                    AdEventManager.m8395a(TTDislikeListView.this.f8493a, (List<FilterWord>) arrayList);
                }
            }
            try {
                if (TTDislikeListView.this.f8494b != null) {
                    TTDislikeListView.this.f8494b.onItemClick(adapterView, view, i, j);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public TTDislikeListView(Context context) {
        super(context);
        m11042a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11042a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11042a();
    }

    public void setMaterialMeta(MaterialMeta kVar) {
        this.f8493a = kVar;
    }

    /* renamed from: a */
    private void m11042a() {
        super.setOnItemClickListener(this.f8495c);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f8494b = onItemClickListener;
    }
}
