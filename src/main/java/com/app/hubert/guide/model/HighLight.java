package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;

public interface HighLight {

    /* renamed from: com.app.hubert.guide.model.HighLight$Shape */
    public enum Shape {
        CIRCLE,
        RECTANGLE,
        OVAL,
        ROUND_RECTANGLE
    }

    /* renamed from: a */
    RectF mo12316a(View view);

    /* renamed from: a */
    Shape mo12317a();

    /* renamed from: b */
    float mo12318b();

    /* renamed from: c */
    int mo12319c();

    /* renamed from: d */
    HighlightOptions mo12320d();
}
