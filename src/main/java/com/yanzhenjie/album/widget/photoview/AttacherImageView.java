package com.yanzhenjie.album.widget.photoview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class AttacherImageView extends AppCompatImageView {
    /* renamed from: a */
    private PhotoViewAttacher f26357a;

    public AttacherImageView(Context context) {
        super(context);
    }

    public AttacherImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AttacherImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAttacher(PhotoViewAttacher dVar) {
        this.f26357a = dVar;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher dVar = this.f26357a;
        if (dVar != null) {
            dVar.mo37747j();
        }
    }
}
