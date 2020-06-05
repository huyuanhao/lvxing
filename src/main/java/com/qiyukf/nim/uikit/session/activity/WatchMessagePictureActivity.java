package com.qiyukf.nim.uikit.session.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.basesdk.p412c.C5399c.C5400a;
import com.qiyukf.basesdk.p412c.p413a.C5362a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nim.uikit.common.p424ui.imageview.BaseZoomableImageView;
import com.qiyukf.nim.uikit.common.p424ui.imageview.C5477a;
import com.qiyukf.nim.uikit.common.p424ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nimlib.p488k.p490b.C5939a;
import com.qiyukf.nimlib.p488k.p490b.C5940b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WatchMessagePictureActivity extends BaseFragmentActivity {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<IMMessage> f17719b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public View f17720c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public ViewPager f17721d;
    /* renamed from: e */
    private C5501a f17722e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean f17723f = true;
    /* renamed from: g */
    private Handler f17724g;
    /* renamed from: h */
    private Observer<IMMessage> f17725h = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.isTheSame(WatchMessagePictureActivity.m22417d(WatchMessagePictureActivity.this)) && !WatchMessagePictureActivity.this.mo27417f()) {
                if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && WatchMessagePictureActivity.m22412b(iMMessage)) {
                    WatchMessagePictureActivity.this.m22415c(iMMessage);
                } else if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                    WatchMessagePictureActivity.m22411b(WatchMessagePictureActivity.this, iMMessage);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.nim.uikit.session.activity.WatchMessagePictureActivity$a */
    private class C5501a extends PagerAdapter {
        /* renamed from: b */
        private List<IMMessage> f17737b;
        /* renamed from: c */
        private Handler f17738c = C5361a.m22013a().mo27317c();
        /* renamed from: d */
        private int f17739d;

        public C5501a(int i, List<IMMessage> list) {
            this.f17737b = list;
            this.f17739d = i;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) obj;
            multiTouchZoomableImageView.mo27513b();
            viewGroup.removeView(multiTouchZoomableImageView);
        }

        public final int getCount() {
            List<IMMessage> list = this.f17737b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final Object instantiateItem(ViewGroup viewGroup, final int i) {
            MultiTouchZoomableImageView multiTouchZoomableImageView = new MultiTouchZoomableImageView(viewGroup.getContext());
            viewGroup.addView(multiTouchZoomableImageView, new LayoutParams(-1, -1));
            multiTouchZoomableImageView.setTag(Integer.valueOf(i));
            if (i == this.f17739d) {
                WatchMessagePictureActivity watchMessagePictureActivity = WatchMessagePictureActivity.this;
                watchMessagePictureActivity.m22404a((IMMessage) watchMessagePictureActivity.f17719b.get(i), true);
            } else {
                this.f17738c.post(new Runnable() {
                    public final void run() {
                        WatchMessagePictureActivity.this.m22404a((IMMessage) WatchMessagePictureActivity.this.f17719b.get(i), false);
                    }
                });
            }
            return multiTouchZoomableImageView;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22401a(WatchMessagePictureActivity watchMessagePictureActivity, final int i) {
        if (i == watchMessagePictureActivity.f17721d.getCurrentItem()) {
            BaseZoomableImageView c = watchMessagePictureActivity.m22414c(i);
            if (c == null) {
                watchMessagePictureActivity.f17724g.postDelayed(new Runnable() {
                    public final void run() {
                        WatchMessagePictureActivity.m22401a(WatchMessagePictureActivity.this, i);
                    }
                }, 300);
            } else {
                c.mo27511a((C5477a) new C5477a() {
                    /* renamed from: a */
                    public final void mo27561a() {
                        WatchMessagePictureActivity.this.finish();
                    }

                    /* renamed from: b */
                    public final void mo27562b() {
                        WatchMessagePictureActivity.this.mo27600g();
                    }

                    /* renamed from: c */
                    public final void mo27563c() {
                        WatchMessagePictureActivity.this.finish();
                    }
                });
                c.mo27510a(watchMessagePictureActivity.f17721d);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22404a(IMMessage iMMessage, boolean z) {
        final BaseZoomableImageView d = m22416d(iMMessage);
        if (d != null) {
            ImageAttachment imageAttachment = (ImageAttachment) iMMessage.getAttachment();
            if (imageAttachment != null) {
                String path = imageAttachment.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = imageAttachment.getThumbPath();
                }
                final Bitmap bitmap = null;
                if (!TextUtils.isEmpty(path)) {
                    bitmap = C5940b.m23812a(path, C5939a.m23807b(path));
                }
                if (bitmap == null) {
                    bitmap = C5940b.m23810a(C5961R.C5962drawable.ysf_image_placeholder_loading);
                }
                if (z) {
                    d.mo27508a(bitmap);
                } else {
                    this.f17724g.post(new Runnable() {
                        public final void run() {
                            d.mo27508a(bitmap);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    private void m22405a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.f17725h, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m22410b(WatchMessagePictureActivity watchMessagePictureActivity, int i) {
        IMMessage iMMessage = (IMMessage) watchMessagePictureActivity.f17719b.get(i);
        if (m22412b(iMMessage)) {
            watchMessagePictureActivity.m22415c(iMMessage);
            return;
        }
        watchMessagePictureActivity.m22404a(iMMessage, false);
        boolean isEmpty = TextUtils.isEmpty(((ImageAttachment) iMMessage.getAttachment()).getPath());
        View view = watchMessagePictureActivity.f17720c;
        if (isEmpty) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(iMMessage, false);
    }

    /* renamed from: b */
    static /* synthetic */ void m22411b(WatchMessagePictureActivity watchMessagePictureActivity, IMMessage iMMessage) {
        watchMessagePictureActivity.f17720c.setVisibility(8);
        BaseZoomableImageView d = watchMessagePictureActivity.m22416d(iMMessage);
        if (d != null) {
            d.mo27508a(C5940b.m23810a(C5961R.C5962drawable.ysf_image_placeholder_fail));
            C5415g.m22165b(C5961R.string.ysf_image_download_failed);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean m22412b(IMMessage iMMessage) {
        return iMMessage.getAttachStatus() == AttachStatusEnum.transferred && !TextUtils.isEmpty(((ImageAttachment) iMMessage.getAttachment()).getPath());
    }

    /* renamed from: c */
    private BaseZoomableImageView m22414c(int i) {
        try {
            return (BaseZoomableImageView) this.f17721d.findViewWithTag(Integer.valueOf(i));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("position：");
            sb.append(i);
            C5264a.m21621b("imageViewOf is error", sb.toString(), e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22415c(IMMessage iMMessage) {
        this.f17720c.setVisibility(8);
        m22404a(iMMessage, false);
    }

    /* renamed from: d */
    private BaseZoomableImageView m22416d(IMMessage iMMessage) {
        Iterator it = this.f17719b.iterator();
        int i = 0;
        while (it.hasNext() && !((IMMessage) it.next()).isTheSame(iMMessage)) {
            i++;
        }
        return m22414c(i);
    }

    /* renamed from: d */
    static /* synthetic */ IMMessage m22417d(WatchMessagePictureActivity watchMessagePictureActivity) {
        return (IMMessage) watchMessagePictureActivity.f17719b.get(watchMessagePictureActivity.f17721d.getCurrentItem());
    }

    public static void start(Context context, ArrayList<IMMessage> arrayList, int i) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_IMAGES", arrayList);
        intent.putExtra("EXTRA_INDEX", i);
        intent.setClass(context, WatchMessagePictureActivity.class);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27411a() {
        return false;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: g */
    public final void mo27600g() {
        if (!TextUtils.isEmpty(((ImageAttachment) ((IMMessage) this.f17719b.get(this.f17721d.getCurrentItem())).getAttachment()).getPath())) {
            C6364g.m25003a((Context) this, (CharSequence) null, new CharSequence[]{getString(C5961R.string.ysf_save_to_device)}, (C6365a) new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    C5399c.m22099a((Activity) WatchMessagePictureActivity.this).mo27354a(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE).mo27353a((C5400a) new C5400a() {
                        public final void onDenied() {
                            C5415g.m22161a(C5961R.string.ysf_no_permission_save_image);
                        }

                        public final void onGranted() {
                            WatchMessagePictureActivity.this.savePicture();
                        }
                    }).mo27355a();
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutParams layoutParams = this.f17721d.getLayoutParams();
        layoutParams.height = C5412d.m22148b();
        layoutParams.width = C5412d.m22145a();
        this.f17721d.setLayoutParams(layoutParams);
        this.f17722e.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(C5961R.C5964layout.ysf_watch_picture_activity);
        this.f17719b = (ArrayList) getIntent().getSerializableExtra("EXTRA_IMAGES");
        this.f17724g = new Handler();
        this.f17720c = findViewById(C5961R.C5963id.loading_layout);
        int intExtra = getIntent().getIntExtra("EXTRA_INDEX", 0);
        this.f17721d = (ViewPager) findViewById(C5961R.C5963id.ysf_watch_picture_view_pager);
        this.f17722e = new C5501a(intExtra, this.f17719b);
        this.f17721d.setOffscreenPageLimit(2);
        this.f17721d.setAdapter(this.f17722e);
        this.f17721d.setCurrentItem(intExtra);
        this.f17721d.addOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
                if (f == 0.0f && WatchMessagePictureActivity.this.f17723f) {
                    WatchMessagePictureActivity.this.f17723f = false;
                    WatchMessagePictureActivity.this.f17720c.setVisibility(8);
                    WatchMessagePictureActivity.m22401a(WatchMessagePictureActivity.this, i);
                    WatchMessagePictureActivity watchMessagePictureActivity = WatchMessagePictureActivity.this;
                    WatchMessagePictureActivity.m22410b(watchMessagePictureActivity, watchMessagePictureActivity.f17721d.getCurrentItem());
                }
            }

            public final void onPageSelected(int i) {
                WatchMessagePictureActivity.this.f17723f = true;
            }
        });
        m22405a(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m22405a(false);
        super.onDestroy();
    }

    public void savePicture() {
        ImageAttachment imageAttachment = (ImageAttachment) ((IMMessage) this.f17719b.get(this.f17721d.getCurrentItem())).getAttachment();
        String path = imageAttachment.getPath();
        if (!TextUtils.isEmpty(path)) {
            String fileName = imageAttachment.getFileName();
            String extension = TextUtils.isEmpty(imageAttachment.getExtension()) ? "jpg" : imageAttachment.getExtension();
            StringBuilder sb = new StringBuilder();
            sb.append(fileName);
            sb.append(".");
            sb.append(extension);
            String sb2 = sb.toString();
            String b = C5946c.m23840b();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b);
            sb3.append(sb2);
            String sb4 = sb3.toString();
            if (C5362a.m22018a(path, sb4) != -1) {
                try {
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put("mime_type", "image/jpeg");
                    contentValues.put("_data", sb4);
                    getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                    C5415g.m22165b(C5961R.string.ysf_picture_save_to);
                } catch (Exception e) {
                    C5415g.m22165b(C5961R.string.ysf_picture_save_fail);
                    C5264a.m21621b("savePicture is error", "", e);
                }
            } else {
                C5415g.m22165b(C5961R.string.ysf_picture_save_fail);
            }
        }
    }
}
