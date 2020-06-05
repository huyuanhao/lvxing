package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment;
import com.qiyukf.nim.uikit.common.media.picker.fragment.PickerAlbumFragment.C5466b;
import com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment;
import com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment.C5467a;
import com.qiyukf.nim.uikit.common.media.picker.model.C5468a;
import com.qiyukf.nim.uikit.common.media.picker.model.C5469b;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5463b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickerAlbumActivity extends BaseFragmentActivity implements OnClickListener, C5466b, C5467a {
    /* renamed from: b */
    private FrameLayout f17510b;
    /* renamed from: c */
    private FrameLayout f17511c;
    /* renamed from: d */
    private PickerAlbumFragment f17512d;
    /* renamed from: e */
    private PickerImageFragment f17513e;
    /* renamed from: f */
    private TextView f17514f;
    /* renamed from: g */
    private TextView f17515g;
    /* renamed from: h */
    private List<PhotoInfo> f17516h = new ArrayList();
    /* renamed from: i */
    private boolean f17517i;
    /* renamed from: j */
    private boolean f17518j;
    /* renamed from: k */
    private boolean f17519k;
    /* renamed from: l */
    private int f17520l;
    /* renamed from: m */
    private boolean f17521m;
    /* renamed from: n */
    private int f17522n = 1;

    /* renamed from: a */
    private boolean m22263a(PhotoInfo photoInfo) {
        for (int i = 0; i < this.f17516h.size(); i++) {
            if (((PhotoInfo) this.f17516h.get(i)).getImageId() == photoInfo.getImageId()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private void m22264g() {
        int size = this.f17516h.size();
        if (size > 0) {
            this.f17514f.setEnabled(true);
            this.f17515g.setEnabled(true);
            this.f17515g.setText(String.format(getResources().getString(C5961R.string.ysf_picker_image_send_select), new Object[]{Integer.valueOf(size)}));
            return;
        }
        this.f17514f.setEnabled(false);
        this.f17515g.setEnabled(false);
        this.f17515g.setText(C5961R.string.ysf_send);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5 && intent != null) {
            if (i2 == -1) {
                setResult(-1, new Intent(intent));
                finish();
            } else if (i2 == 2) {
                this.f17519k = intent.getBooleanExtra("is_original", false);
                List b = C5469b.m22300b(intent);
                PickerImageFragment pickerImageFragment = this.f17513e;
                if (!(pickerImageFragment == null || b == null)) {
                    pickerImageFragment.updateSelectPhotos(b);
                }
                List b2 = C5469b.m22300b(intent);
                List<PhotoInfo> list = this.f17516h;
                if (list != null) {
                    list.clear();
                } else {
                    this.f17516h = new ArrayList();
                }
                this.f17516h.addAll(b2);
                m22264g();
                PickerImageFragment pickerImageFragment2 = this.f17513e;
                if (pickerImageFragment2 != null) {
                    List<PhotoInfo> list2 = this.f17516h;
                    if (list2 != null) {
                        pickerImageFragment2.updateSelectedForAdapter(list2.size());
                    }
                }
            }
        }
    }

    public void onAlbumItemClick(C5468a aVar) {
        List e = aVar.mo27504e();
        if (e != null) {
            Iterator it = e.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                PhotoInfo photoInfo = (PhotoInfo) it.next();
                if (m22263a(photoInfo)) {
                    z = true;
                }
                photoInfo.setChoose(z);
            }
            this.f17510b.setVisibility(8);
            this.f17511c.setVisibility(0);
            if (this.f17513e == null) {
                this.f17513e = new PickerImageFragment();
                C5463b.m22275a(this, new ArrayList(e));
                PickerImageFragment pickerImageFragment = this.f17513e;
                boolean z2 = this.f17517i;
                int i = this.f17520l;
                Bundle bundle = new Bundle();
                bundle.putBoolean("multi_select_mode", z2);
                bundle.putInt("multi_select_size_limit", i);
                bundle.putInt("extra_screen_orientation", this.f17522n);
                pickerImageFragment.setArguments(bundle);
                mo27410a(C5961R.C5963id.picker_photos_fragment, this.f17513e);
            } else {
                this.f17513e.resetFragment(e, this.f17516h.size());
            }
            setTitle((CharSequence) aVar.mo27503d());
            this.f17521m = false;
        }
    }

    public void onBackPressed() {
        if (this.f17521m) {
            finish();
            return;
        }
        setTitle(C5961R.string.ysf_picker_image_folder);
        this.f17521m = true;
        this.f17510b.setVisibility(0);
        this.f17511c.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == C5961R.C5963id.picker_bottombar_preview) {
            List<PhotoInfo> list = this.f17516h;
            PickerAlbumPreviewActivity.start(this, list, 0, this.f17518j, this.f17519k, list, this.f17520l);
            return;
        }
        if (view.getId() == C5961R.C5963id.picker_bottombar_select) {
            setResult(-1, C5469b.m22297a(this.f17516h, this.f17519k));
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f17522n = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_picker_album_activity);
        Intent intent = getIntent();
        int i = 0;
        if (intent != null) {
            this.f17517i = intent.getBooleanExtra("multi_select_mode", false);
            this.f17520l = intent.getIntExtra("multi_select_size_limit", 9);
            this.f17518j = intent.getBooleanExtra("support_original", false);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C5961R.C5963id.picker_bottombar);
        if (!this.f17517i) {
            i = 8;
        }
        relativeLayout.setVisibility(i);
        this.f17514f = (TextView) findViewById(C5961R.C5963id.picker_bottombar_preview);
        this.f17514f.setOnClickListener(this);
        this.f17515g = (TextView) findViewById(C5961R.C5963id.picker_bottombar_select);
        this.f17515g.setOnClickListener(this);
        this.f17510b = (FrameLayout) findViewById(C5961R.C5963id.picker_album_fragment);
        this.f17511c = (FrameLayout) findViewById(C5961R.C5963id.picker_photos_fragment);
        this.f17512d = new PickerAlbumFragment();
        mo27410a(C5961R.C5963id.picker_album_fragment, this.f17512d);
        this.f17521m = true;
        try {
            UICustomization uICustomization = C6029d.m24045e().uiCustomization;
            if (uICustomization != null && uICustomization.buttonBackgroundColorList > 0) {
                this.f17514f.setTextColor(getResources().getColorStateList(uICustomization.buttonBackgroundColorList));
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("ui customization error: ");
            sb.append(e.toString());
            C5264a.m21622c("PickerAlbumActivity", sb.toString());
        }
        setTitle(C5961R.string.ysf_picker_image_folder);
    }

    public void onPhotoSelectClick(PhotoInfo photoInfo) {
        if (photoInfo != null) {
            if (!photoInfo.isChoose()) {
                Iterator it = this.f17516h.iterator();
                while (it.hasNext()) {
                    if (((PhotoInfo) it.next()).getImageId() == photoInfo.getImageId()) {
                        it.remove();
                    }
                }
            } else if (!m22263a(photoInfo)) {
                this.f17516h.add(photoInfo);
            }
            m22264g();
        }
    }

    public void onPhotoSingleClick(List<PhotoInfo> list, int i) {
        if (this.f17517i) {
            PickerAlbumPreviewActivity.start(this, list, i, this.f17518j, this.f17519k, this.f17516h, this.f17520l);
            return;
        }
        if (list != null) {
            PhotoInfo photoInfo = (PhotoInfo) list.get(i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(photoInfo);
            setResult(-1, C5469b.m22297a(arrayList, false));
            finish();
        }
    }
}
