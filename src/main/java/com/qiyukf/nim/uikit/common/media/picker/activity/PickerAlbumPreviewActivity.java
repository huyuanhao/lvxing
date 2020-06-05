package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BlackFragmentActivity;
import com.qiyukf.nim.uikit.common.media.picker.model.C5469b;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.media.picker.p422a.C5456c;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5463b;
import com.qiyukf.nim.uikit.common.p424ui.imageview.BaseZoomableImageView;
import com.qiyukf.unicorn.C5961R;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickerAlbumPreviewActivity extends BlackFragmentActivity implements OnClickListener, OnPageChangeListener {
    /* renamed from: b */
    private ViewPager f17523b;
    /* renamed from: c */
    private C5456c f17524c;
    /* renamed from: d */
    private List<PhotoInfo> f17525d = new ArrayList();
    /* renamed from: e */
    private List<PhotoInfo> f17526e = new ArrayList();
    /* renamed from: f */
    private int f17527f = 0;
    /* renamed from: g */
    private int f17528g = -1;
    /* renamed from: h */
    private int f17529h;
    /* renamed from: i */
    private boolean f17530i;
    /* renamed from: j */
    private boolean f17531j;
    /* renamed from: k */
    private TextView f17532k;
    /* renamed from: l */
    private TextView f17533l;
    /* renamed from: m */
    private CheckboxImageView f17534m;
    /* renamed from: n */
    private int f17535n;

    /* renamed from: a */
    private void m22265a(boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        if (this.f17525d != null) {
            if (z) {
                long j = 0;
                for (int i = 0; i < this.f17525d.size(); i++) {
                    j += ((PhotoInfo) this.f17525d.get(i)).getSize();
                }
                TextView textView = this.f17532k;
                String string = getResources().getString(C5961R.string.ysf_picker_image_preview_original_select);
                Object[] objArr = new Object[1];
                if (j <= 0) {
                    str = "0B";
                } else {
                    int i2 = (j > 1024 ? 1 : (j == 1024 ? 0 : -1));
                    if (i2 < 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(j);
                        sb2.append("B");
                        str = sb2.toString();
                    } else {
                        if (i2 >= 0 && j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                            BigDecimal scale = new BigDecimal(((double) j) / 1024.0d).setScale(0, 4);
                            sb = new StringBuilder();
                            sb.append((int) scale.doubleValue());
                            str2 = "K";
                        } else if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED || j >= 1073741824) {
                            BigDecimal scale2 = new BigDecimal(((double) j) / 1.073741824E9d).setScale(2, 4);
                            sb = new StringBuilder();
                            sb.append(scale2.doubleValue());
                            str2 = "GB";
                        } else {
                            BigDecimal scale3 = new BigDecimal(((double) j) / 1048576.0d).setScale(1, 4);
                            sb = new StringBuilder();
                            sb.append(scale3.doubleValue());
                            str2 = "M";
                        }
                        sb.append(str2);
                        str = sb.toString();
                    }
                }
                objArr[0] = str;
                textView.setText(String.format(string, objArr));
                return;
            }
            this.f17532k.setText(C5961R.string.ysf_picker_image_preview_original);
        }
    }

    /* renamed from: c */
    private void m22266c(int i) {
        List<PhotoInfo> list = this.f17526e;
        if (list != null && i < list.size()) {
            this.f17534m.mo27467a(((PhotoInfo) this.f17526e.get(i)).isChoose());
        }
    }

    /* renamed from: d */
    private void m22267d(int i) {
        String sb;
        if (this.f17529h <= 0) {
            sb = "";
        } else {
            int i2 = i + 1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            sb2.append("/");
            sb2.append(this.f17529h);
            sb = sb2.toString();
        }
        setTitle((CharSequence) sb);
    }

    /* renamed from: g */
    private void m22268g() {
        int size = this.f17525d.size();
        if (size > 0) {
            this.f17533l.setEnabled(true);
            this.f17533l.setText(String.format(getResources().getString(C5961R.string.ysf_picker_image_send_select), new Object[]{Integer.valueOf(size)}));
            return;
        }
        this.f17533l.setEnabled(true);
        this.f17533l.setText(C5961R.string.ysf_send);
    }

    public static void start(Activity activity, List<PhotoInfo> list, int i, boolean z, boolean z2, List<PhotoInfo> list2, int i2) {
        C5463b.m22275a(activity, new ArrayList(list));
        Intent intent = new Intent();
        intent.setClass(activity, PickerAlbumPreviewActivity.class);
        intent.putExtra("selected_photo_list", new ArrayList(list2));
        intent.putExtra("current_pos", i);
        intent.putExtra("support_original", z);
        intent.putExtra("is_original", z2);
        intent.putExtra("multi_select_size_limit", i2);
        activity.startActivityForResult(intent, 5);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("selected_photo_list", new ArrayList(this.f17525d));
        intent.putExtra("is_original", this.f17531j);
        setResult(2, intent);
        finish();
    }

    public void onClick(View view) {
        int i = 0;
        boolean z = true;
        if (view.getId() == C5961R.C5963id.picker_image_preview_photos_select) {
            List<PhotoInfo> list = this.f17526e;
            if (list != null && this.f17528g < list.size()) {
                PhotoInfo photoInfo = (PhotoInfo) this.f17526e.get(this.f17528g);
                boolean isChoose = photoInfo.isChoose();
                List<PhotoInfo> list2 = this.f17525d;
                if (list2 == null || list2.size() < this.f17535n || isChoose) {
                    photoInfo.setChoose(!isChoose);
                    this.f17534m.mo27467a(!isChoose);
                    if (!isChoose) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= this.f17525d.size()) {
                                z = false;
                                break;
                            } else if (((PhotoInfo) this.f17525d.get(i2)).getImageId() == photoInfo.getImageId()) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            this.f17525d.add(photoInfo);
                        }
                    } else {
                        Iterator it = this.f17525d.iterator();
                        while (it.hasNext()) {
                            if (((PhotoInfo) it.next()).getImageId() == photoInfo.getImageId()) {
                                it.remove();
                            }
                        }
                    }
                    m22268g();
                    if (this.f17525d.size() == 0 && this.f17531j) {
                        this.f17531j = false;
                    }
                    m22265a(this.f17531j);
                } else {
                    C5415g.m22166b(String.format(getResources().getString(C5961R.string.ysf_picker_image_exceed_max_image_select), new Object[]{Integer.valueOf(this.f17535n)}));
                }
            }
        } else if (view.getId() == C5961R.C5963id.picker_image_preview_send) {
            List<PhotoInfo> list3 = this.f17525d;
            if (list3 != null && list3.size() == 0) {
                PhotoInfo photoInfo2 = (PhotoInfo) this.f17526e.get(this.f17528g);
                photoInfo2.setChoose(true);
                this.f17525d.add(photoInfo2);
            }
            setResult(-1, C5469b.m22297a(this.f17525d, this.f17531j));
            finish();
        } else {
            if (view.getId() == C5961R.C5963id.picker_image_preview_orignal_image) {
                if (!this.f17531j) {
                    this.f17531j = true;
                    List<PhotoInfo> list4 = this.f17525d;
                    if (list4 != null) {
                        i = list4.size();
                    }
                    if (i < this.f17535n) {
                        PhotoInfo photoInfo3 = (PhotoInfo) this.f17526e.get(this.f17528g);
                        if (!photoInfo3.isChoose()) {
                            photoInfo3.setChoose(true);
                            this.f17525d.add(photoInfo3);
                            m22268g();
                            this.f17534m.mo27467a(true);
                        }
                    }
                } else {
                    this.f17531j = false;
                }
                m22265a(this.f17531j);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutParams layoutParams = this.f17523b.getLayoutParams();
        layoutParams.height = (C5412d.m22148b() - mo27415d()) - C5412d.m22146a(50.0f);
        layoutParams.width = C5412d.m22145a();
        this.f17527f = this.f17523b.getCurrentItem();
        this.f17523b.setLayoutParams(layoutParams);
        this.f17524c = new C5456c(this.f17527f, this.f17526e, getLayoutInflater());
        this.f17523b.setAdapter(this.f17524c);
        this.f17523b.setCurrentItem(this.f17527f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_picker_image_preview_activity);
        Intent intent = getIntent();
        this.f17530i = intent.getBooleanExtra("support_original", false);
        this.f17531j = intent.getBooleanExtra("is_original", false);
        this.f17527f = intent.getIntExtra("current_pos", 0);
        this.f17535n = intent.getIntExtra("multi_select_size_limit", 9);
        this.f17526e.addAll(C5463b.m22274a(this));
        this.f17529h = this.f17526e.size();
        this.f17525d.clear();
        this.f17525d.addAll(C5469b.m22300b(intent));
        this.f17534m = (CheckboxImageView) mo27412b(C5961R.C5964layout.ysf_action_bar_right_picker_preview).findViewById(C5961R.C5963id.picker_image_preview_photos_select);
        this.f17534m.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(C5961R.C5963id.picker_image_preview_orignal_image);
        imageButton.setOnClickListener(this);
        this.f17532k = (TextView) findViewById(C5961R.C5963id.picker_image_preview_orignal_image_tip);
        if (!this.f17530i) {
            imageButton.setVisibility(4);
            this.f17532k.setVisibility(4);
        }
        this.f17533l = (TextView) findViewById(C5961R.C5963id.picker_image_preview_send);
        this.f17533l.setOnClickListener(this);
        m22268g();
        m22265a(this.f17531j);
        this.f17523b = (ViewPager) findViewById(C5961R.C5963id.picker_image_preview_viewpager);
        this.f17523b.addOnPageChangeListener(this);
        this.f17523b.setOffscreenPageLimit(2);
        this.f17524c = new C5456c(this.f17527f, this.f17526e, getLayoutInflater());
        this.f17523b.setAdapter(this.f17524c);
        m22267d(this.f17527f);
        m22266c(this.f17527f);
        updateCurrentItem(this.f17527f);
        this.f17523b.setCurrentItem(this.f17527f);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f17523b.setAdapter(null);
        super.onDestroy();
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        m22267d(i);
        m22266c(i);
        updateCurrentItem(i);
    }

    public void updateCurrentItem(final int i) {
        List<PhotoInfo> list = this.f17526e;
        if (list != null && (i <= 0 || i < list.size())) {
            int i2 = this.f17528g;
            if (i2 != i || i2 == 0) {
                this.f17528g = i;
                LinearLayout linearLayout = (LinearLayout) this.f17523b.findViewWithTag(Integer.valueOf(i));
                if (linearLayout == null) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            PickerAlbumPreviewActivity.this.updateCurrentItem(i);
                        }
                    }, 300);
                    return;
                }
                ((BaseZoomableImageView) linearLayout.findViewById(C5961R.C5963id.imageView)).mo27510a(this.f17523b);
            }
        }
    }
}
