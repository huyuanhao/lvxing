package com.tencent.mta.track;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ba */
class C7368ba implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ C7366az f24941a;
    /* renamed from: b */
    private final View f24942b;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C7368ba(C7366az azVar, View view) {
        this.f24941a = azVar;
        this.f24942b = view;
    }

    public void afterTextChanged(Editable editable) {
        this.f24941a.mo35907b(this.f24942b);
    }
}
