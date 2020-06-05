package com.qiyukf.nim.uikit.session.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5312a;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5414f;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.p424ui.imageview.MsgThumbImageView;
import com.qiyukf.nim.uikit.session.activity.WatchVideoActivity;
import com.qiyukf.nimlib.p488k.p490b.C5939a;
import com.qiyukf.nimlib.p488k.p490b.C5940b.C5941a;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.unicorn.C5961R;
import java.io.File;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.l */
public class C5640l extends C5637i {
    /* renamed from: a */
    C5941a f18150a;
    /* renamed from: b */
    VideoAttachment f18151b;
    /* renamed from: c */
    private TextView f18152c;
    /* renamed from: g */
    private TextView f18153g;

    /* renamed from: b */
    static /* synthetic */ void m22810b(C5640l lVar) {
        if (lVar.f18151b.getPath() == null) {
            C5415g.m22163a("请先下载视频");
        }
        String b = C5946c.m23840b();
        if (TextUtils.isEmpty(lVar.f18151b.getExtension())) {
            C5415g.m22161a(C5961R.string.ysf_video_save_fail);
            return;
        }
        StringBuilder sb = new StringBuilder("video_");
        sb.append(System.currentTimeMillis());
        sb.append(".mp4");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b);
        sb3.append(sb2);
        String sb4 = sb3.toString();
        if (C5312a.m21836a(lVar.f18151b.getPath(), sb4) != -1) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(new File(sb4)));
                lVar.context.sendBroadcast(intent);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(lVar.context.getString(C5961R.string.ysf_video_save_to));
                sb5.append(b);
                sb5.append("查看");
                C5415g.m22166b(sb5.toString());
            } catch (Exception unused) {
                C5415g.m22165b(C5961R.string.ysf_picture_save_fail);
            }
        } else {
            C5415g.m22161a(C5961R.string.ysf_video_save_fail);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final String mo27823a(String str) {
        VideoAttachment videoAttachment = (VideoAttachment) this.message.getAttachment();
        String thumbPathForSave = videoAttachment.getThumbPathForSave();
        if (C5939a.m23805a(str, thumbPathForSave, videoAttachment.getWidth(), videoAttachment.getHeight())) {
            return thumbPathForSave;
        }
        return null;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27824a(C5941a aVar) {
        this.f18150a = aVar;
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        this.f18147d.setLayoutParams(layoutParams);
        setLayoutParams(aVar.f18757a, aVar.f18758b, this.f18149f);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final int[] mo27825a() {
        VideoAttachment videoAttachment = (VideoAttachment) this.message.getAttachment();
        return new int[]{videoAttachment.getWidth(), videoAttachment.getHeight()};
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        StringBuilder sb;
        super.bindContentView();
        this.f18151b = (VideoAttachment) this.message.getAttachment();
        long a = C5414f.m22157a(this.f18151b.getDuration());
        if (a == 0) {
            a = 1;
        }
        TextView textView = this.f18152c;
        if (a < 10) {
            sb = new StringBuilder("00:0");
        } else {
            sb = new StringBuilder("00:");
        }
        sb.append(a);
        textView.setText(sb.toString());
        this.f18153g.setText(C5363b.m22022a(this.f18151b.getSize()));
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_video;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.f18153g = (TextView) findViewById(C5961R.C5963id.tv_ysf_item_message_size);
        this.f18152c = (TextView) findViewById(C5961R.C5963id.tv_ysf_item_message_duration);
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        WatchVideoActivity.start(this.context, this.message, false);
    }

    /* access modifiers changed from: protected */
    public boolean onItemLongClick() {
        MsgThumbImageView msgThumbImageView = this.f18147d;
        View inflate = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_popup_video_msg_item, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, C5412d.m22146a(100.0f), C5412d.m22146a(30.0f), true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_popup_video_voice);
        TextView textView2 = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_popup_video_save);
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                popupWindow.dismiss();
                WatchVideoActivity.start(C5640l.this.context, C5640l.this.message, true);
            }
        });
        textView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                popupWindow.dismiss();
                C5640l.m22810b(C5640l.this);
            }
        });
        LayoutParams layoutParams = (LayoutParams) msgThumbImageView.getLayoutParams();
        popupWindow.showAsDropDown(msgThumbImageView, (layoutParams.width / 2) - C5412d.m22146a(50.0f), -(layoutParams.height + C5412d.m22146a(30.0f)));
        return true;
    }
}
