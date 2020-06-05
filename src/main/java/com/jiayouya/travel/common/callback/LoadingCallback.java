package com.jiayouya.travel.common.callback;

import android.content.Context;
import android.view.View;
import com.jiayouya.travel.R;
import com.kingja.loadsir.callback.Callback;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/common/callback/LoadingCallback;", "Lcom/kingja/loadsir/callback/Callback;", "()V", "onCreateView", "", "onReloadEvent", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: LoadingCallback.kt */
public final class LoadingCallback extends Callback {
    /* access modifiers changed from: protected */
    public int onCreateView() {
        return R.layout.layout_loading;
    }

    /* access modifiers changed from: protected */
    public boolean onReloadEvent(Context context, View view) {
        return true;
    }
}
