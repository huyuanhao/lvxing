package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BlackFragmentActivity;
import com.qiyukf.nimlib.p488k.p490b.C5939a;
import com.qiyukf.unicorn.C5961R;
import java.io.File;
import java.util.ArrayList;

public class PreviewImageFromCameraActivity extends BlackFragmentActivity {
    /* renamed from: b */
    private ImageView f17538b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public File f17539c;
    /* renamed from: d */
    private TextView f17540d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public String f17541e;
    /* renamed from: f */
    private String f17542f;

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m22272g() {
        File file = this.f17539c;
        if (file != null) {
            file.delete();
        }
        C5362a.m22021b(this.f17541e);
    }

    public static Bitmap getBitmap(Drawable drawable) {
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public static Intent initPreviewImageIntent(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z) {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("scaled_image_list", arrayList);
        intent.putStringArrayListExtra("orig_image_list", arrayList2);
        intent.putExtra("is_original", z);
        return intent;
    }

    public void onBackPressed() {
        m22272g();
        Intent intent = new Intent();
        intent.setClass(this, getIntent().getClass());
        setResult(0, intent);
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutParams layoutParams = this.f17538b.getLayoutParams();
        layoutParams.height = C5412d.m22148b();
        layoutParams.width = C5412d.m22145a();
        this.f17538b.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = this.f17540d.getLayoutParams();
        layoutParams2.height = -2;
        layoutParams2.width = C5412d.m22145a();
        this.f17540d.setLayoutParams(layoutParams2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_preview_image_from_camera_activity);
        TextView a = mo27409a(C5961R.string.ysf_image_retake);
        a.setTextColor(getResources().getColorStateList(C5961R.color.ysf_title_bar_text_color_light_selector));
        a.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PreviewImageFromCameraActivity.this.m22272g();
                Intent intent = new Intent();
                PreviewImageFromCameraActivity previewImageFromCameraActivity = PreviewImageFromCameraActivity.this;
                intent.setClass(previewImageFromCameraActivity, previewImageFromCameraActivity.getIntent().getClass());
                intent.putExtra("RESULT_RETAKE", true);
                PreviewImageFromCameraActivity.this.setResult(-1, intent);
                PreviewImageFromCameraActivity.this.finish();
            }
        });
        String string = getIntent().getExtras().getString("image_file_path");
        this.f17541e = getIntent().getExtras().getString("orig_image_file_path");
        this.f17542f = getIntent().getExtras().getString("preview_image_btn_text");
        this.f17539c = new File(string);
        this.f17540d = (TextView) findViewById(C5961R.C5963id.buttonSend);
        this.f17538b = (ImageView) findViewById(C5961R.C5963id.imageViewPreview);
        if (!TextUtils.isEmpty(this.f17542f)) {
            this.f17540d.setText(this.f17542f);
        }
        this.f17540d.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(PreviewImageFromCameraActivity.this.f17539c.getPath());
                arrayList2.add(PreviewImageFromCameraActivity.this.f17541e);
                C5362a.m22021b(PreviewImageFromCameraActivity.this.f17541e);
                Intent initPreviewImageIntent = PreviewImageFromCameraActivity.initPreviewImageIntent(arrayList, arrayList2, false);
                PreviewImageFromCameraActivity previewImageFromCameraActivity = PreviewImageFromCameraActivity.this;
                initPreviewImageIntent.setClass(previewImageFromCameraActivity, previewImageFromCameraActivity.getIntent().getClass());
                initPreviewImageIntent.putExtra("RESULT_SEND", true);
                PreviewImageFromCameraActivity.this.setResult(-1, initPreviewImageIntent);
                PreviewImageFromCameraActivity.this.finish();
            }
        });
        try {
            Bitmap b = C5939a.m23807b(this.f17539c.getAbsolutePath());
            if (b != null) {
                this.f17538b.setImageBitmap(b);
            } else {
                C5415g.m22165b(C5961R.string.ysf_image_show_error);
            }
        } catch (OutOfMemoryError unused) {
            C5415g.m22165b(C5961R.string.ysf_image_out_of_memory);
        }
    }

    public void onDestroy() {
        Drawable drawable = this.f17538b.getDrawable();
        this.f17538b.setImageBitmap(null);
        if (drawable != null) {
            Bitmap bitmap = getBitmap(drawable);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        super.onDestroy();
    }
}
