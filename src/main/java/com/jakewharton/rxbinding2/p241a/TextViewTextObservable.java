package com.jakewharton.rxbinding2.p241a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import p655io.reactivex.Observer;
import p655io.reactivex.p659a.C8077a;

/* renamed from: com.jakewharton.rxbinding2.a.b */
final class TextViewTextObservable extends InitialValueObservable<CharSequence> {
    /* renamed from: a */
    private final TextView f9529a;

    /* compiled from: TextViewTextObservable */
    /* renamed from: com.jakewharton.rxbinding2.a.b$a */
    static final class C2821a extends C8077a implements TextWatcher {
        /* renamed from: a */
        private final TextView f9530a;
        /* renamed from: b */
        private final Observer<? super CharSequence> f9531b;

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C2821a(TextView textView, Observer<? super CharSequence> lVar) {
            this.f9530a = textView;
            this.f9531b = lVar;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!isDisposed()) {
                this.f9531b.onNext(charSequence);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo19784a() {
            this.f9530a.removeTextChangedListener(this);
        }
    }

    TextViewTextObservable(TextView textView) {
        this.f9529a = textView;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo19782b(Observer<? super CharSequence> lVar) {
        C2821a aVar = new C2821a(this.f9529a, lVar);
        lVar.onSubscribe(aVar);
        this.f9529a.addTextChangedListener(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public CharSequence mo19780a() {
        return this.f9529a.getText();
    }
}
