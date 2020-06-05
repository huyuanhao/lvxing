package com.tencent.mta.track;

import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.az */
public class C7366az extends C7369bb {
    /* renamed from: a */
    private final Map f24937a = new HashMap();

    public C7366az(List list, C7461u uVar, C7370bc bcVar) {
        super(list, uVar, bcVar, true);
    }

    /* renamed from: a */
    public void mo35896a() {
        for (Entry entry : this.f24937a.entrySet()) {
            ((TextView) entry.getKey()).removeTextChangedListener((TextWatcher) entry.getValue());
        }
        this.f24937a.clear();
    }

    public void accumulate(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            C7368ba baVar = new C7368ba(this, textView);
            TextWatcher textWatcher = (TextWatcher) this.f24937a.get(textView);
            if (textWatcher != null) {
                textView.removeTextChangedListener(textWatcher);
            }
            textView.addTextChangedListener(baVar);
            this.f24937a.put(textView, baVar);
        }
    }
}
