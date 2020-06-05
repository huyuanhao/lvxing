package com.qiyukf.nim.uikit.session.module;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;

/* renamed from: com.qiyukf.nim.uikit.session.module.a */
public final class C5567a {
    /* renamed from: a */
    public final Activity f17920a;
    /* renamed from: b */
    public final Fragment f17921b;
    /* renamed from: c */
    public String f17922c;
    /* renamed from: d */
    public final SessionTypeEnum f17923d;
    /* renamed from: e */
    public final C5591b f17924e;

    public C5567a(Fragment fragment, String str, SessionTypeEnum sessionTypeEnum, C5591b bVar) {
        this.f17921b = fragment;
        this.f17920a = fragment.getActivity();
        this.f17922c = str;
        this.f17923d = sessionTypeEnum;
        this.f17924e = bVar;
    }
}
