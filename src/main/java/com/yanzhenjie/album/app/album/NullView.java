package com.yanzhenjie.album.app.album;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.api.widget.Widget.ButtonStyle;
import com.yanzhenjie.album.app.Contract.C7733c;
import com.yanzhenjie.album.app.Contract.NullPresenter;
import com.yanzhenjie.album.p629b.AlbumUtils;
import com.yanzhenjie.album.p629b.SystemBar;

/* renamed from: com.yanzhenjie.album.app.album.c */
class NullView extends C7733c implements OnClickListener {
    /* renamed from: a */
    private Activity f26250a;
    /* renamed from: b */
    private Toolbar f26251b;
    /* renamed from: c */
    private TextView f26252c;
    /* renamed from: d */
    private AppCompatButton f26253d;
    /* renamed from: e */
    private AppCompatButton f26254e;

    public NullView(Activity activity, NullPresenter nullPresenter) {
        super(activity, nullPresenter);
        this.f26250a = activity;
        this.f26251b = (Toolbar) activity.findViewById(R.id.toolbar);
        this.f26252c = (TextView) activity.findViewById(R.id.tv_message);
        this.f26253d = (AppCompatButton) activity.findViewById(R.id.btn_camera_image);
        this.f26254e = (AppCompatButton) activity.findViewById(R.id.btn_camera_video);
        this.f26253d.setOnClickListener(this);
        this.f26254e.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo37607a(Widget widget) {
        this.f26251b.setBackgroundColor(widget.mo37547c());
        int b = widget.mo37546b();
        Drawable e = mo37702e(R.drawable.album_ic_back_white);
        if (widget.mo37545a() == 1) {
            if (SystemBar.m33559a(this.f26250a, true)) {
                SystemBar.m33556a(this.f26250a, b);
            } else {
                SystemBar.m33556a(this.f26250a, mo37704f(R.color.albumColorPrimaryBlack));
            }
            AlbumUtils.m33545a(e, mo37704f(R.color.albumIconDark));
            mo37694a(e);
        } else {
            SystemBar.m33556a(this.f26250a, b);
            mo37694a(e);
        }
        SystemBar.m33562b(this.f26250a, widget.mo37548d());
        ButtonStyle h = widget.mo37553h();
        ColorStateList b2 = h.mo37560b();
        this.f26253d.setSupportBackgroundTintList(b2);
        this.f26254e.setSupportBackgroundTintList(b2);
        if (h.mo37559a() == 1) {
            Drawable drawable = this.f26253d.getCompoundDrawables()[0];
            AlbumUtils.m33545a(drawable, mo37704f(R.color.albumIconDark));
            this.f26253d.setCompoundDrawables(drawable, null, null, null);
            Drawable drawable2 = this.f26254e.getCompoundDrawables()[0];
            AlbumUtils.m33545a(drawable2, mo37704f(R.color.albumIconDark));
            this.f26254e.setCompoundDrawables(drawable2, null, null, null);
            this.f26253d.setTextColor(mo37704f(R.color.albumFontDark));
            this.f26254e.setTextColor(mo37704f(R.color.albumFontDark));
        }
    }

    /* renamed from: a */
    public void mo37606a(int i) {
        this.f26252c.setText(i);
    }

    /* renamed from: a */
    public void mo37608a(boolean z) {
        this.f26253d.setVisibility(z ? 0 : 8);
    }

    /* renamed from: b */
    public void mo37609b(boolean z) {
        this.f26254e.setVisibility(z ? 0 : 8);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_camera_image) {
            ((NullPresenter) mo37693a()).mo37587a();
        } else if (id == R.id.btn_camera_video) {
            ((NullPresenter) mo37693a()).mo37588b();
        }
    }
}
