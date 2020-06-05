package com.kwad.sdk.export.p347i;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* renamed from: com.kwad.sdk.export.i.KsEntryElement */
public interface KsEntryElement {

    /* renamed from: com.kwad.sdk.export.i.KsEntryElement$EntranceType */
    public @interface EntranceType {
        public static final int ENTRYTYPE_SCROOLTYPE = 2;
        public static final int ENTRYTYPE_TWOSINGLE = 1;
    }

    /* renamed from: com.kwad.sdk.export.i.KsEntryElement$OnFeedClickListener */
    public interface OnFeedClickListener {
        void handleFeedClick(int i, List<AdTemplate> list, int i2, View view);
    }

    View getEntryView(Context context, OnFeedClickListener onFeedClickListener);

    void setTouchIntercept(boolean z);
}
