package com.yanzhenjie.album.widget;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;

public class LoadingDialog extends Dialog {
    /* renamed from: a */
    private ColorProgressBar f26342a = ((ColorProgressBar) findViewById(R.id.progress_bar));
    /* renamed from: b */
    private TextView f26343b = ((TextView) findViewById(R.id.tv_message));

    public LoadingDialog(Context context) {
        super(context, R.style.Album_Dialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.album_dialog_loading);
    }

    /* renamed from: a */
    public void mo37717a(Widget widget) {
        if (widget.mo37545a() == 1) {
            this.f26342a.setColorFilter(ContextCompat.getColor(getContext(), R.color.albumLoadingDark));
            return;
        }
        this.f26342a.setColorFilter(widget.mo37547c());
    }

    /* renamed from: a */
    public void mo37716a(int i) {
        this.f26343b.setText(i);
    }
}
