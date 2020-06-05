package com.jakewharton.rxbinding2.p241a;

import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.C2822a;

/* renamed from: com.jakewharton.rxbinding2.a.a */
public final class RxTextView {
    /* renamed from: a */
    public static InitialValueObservable<CharSequence> m12726a(TextView textView) {
        C2822a.m12731a(textView, "view == null");
        return new TextViewTextObservable(textView);
    }
}
