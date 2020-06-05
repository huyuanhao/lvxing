package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.common.p424ui.imageview.MsgThumbImageView;
import com.qiyukf.nimlib.p488k.p490b.C5940b;
import com.qiyukf.nimlib.p488k.p490b.C5940b.C5941a;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.i */
public abstract class C5637i extends C5622b {
    /* renamed from: d */
    protected MsgThumbImageView f18147d;
    /* renamed from: e */
    protected TextView f18148e;
    /* renamed from: f */
    protected ImageView f18149f;

    /* renamed from: b */
    public static int m22801b() {
        return (int) (((double) C5412d.m22145a()) * 0.515625d);
    }

    /* renamed from: b */
    private void m22802b(String str) {
        C5941a aVar;
        int[] a = mo27825a();
        if (a[0] <= 0 || a[1] <= 0) {
            int b = (m22801b() + m22803c()) / 2;
            aVar = new C5941a(b, b);
        } else {
            aVar = C5940b.m23813a((float) a[0], (float) a[1], (float) m22801b(), (float) m22803c());
        }
        setLayoutParams(aVar.f18757a, aVar.f18758b, this.f18147d);
        mo27824a(aVar);
        if (str == null) {
            this.f18147d.mo27538a(C5961R.C5962drawable.ysf_image_placeholder_loading, aVar.f18757a, aVar.f18758b, m22804d());
        } else if (this.message.getAttachment() instanceof VideoAttachment) {
            this.f18147d.mo27539a(BitmapFactory.decodeFile(str), aVar.f18757a, aVar.f18758b, m22804d());
        } else {
            this.f18147d.mo27540a(str, aVar.f18757a, aVar.f18758b, m22804d());
        }
    }

    /* renamed from: c */
    public static int m22803c() {
        return (int) (((double) C5412d.m22145a()) * 0.2375d);
    }

    /* renamed from: d */
    private int m22804d() {
        return isReceivedMessage() ? C5961R.C5962drawable.ysf_message_left_bg : C5961R.C5962drawable.ysf_message_right_bg;
    }

    /* renamed from: a */
    public abstract String mo27823a(String str);

    /* renamed from: a */
    public abstract void mo27824a(C5941a aVar);

    /* renamed from: a */
    public abstract int[] mo27825a();

    /* access modifiers changed from: protected */
    public void bindContentView() {
        this.f18149f.setImageResource(isReceivedMessage() ? C5961R.C5962drawable.ysf_message_image_cover_left_selector : C5961R.C5962drawable.ysf_message_image_cover_right_selector);
        FileAttachment fileAttachment = (FileAttachment) this.message.getAttachment();
        String path = fileAttachment.getPath();
        String thumbPath = fileAttachment.getThumbPath();
        if (TextUtils.isEmpty(thumbPath)) {
            if (!TextUtils.isEmpty(path)) {
                thumbPath = mo27823a(path);
            } else {
                m22802b(null);
                if (this.message.getAttachStatus() == AttachStatusEnum.transferred || this.message.getAttachStatus() == AttachStatusEnum.def) {
                    downloadAttachment();
                }
                FileAttachment fileAttachment2 = (FileAttachment) this.message.getAttachment();
                if (TextUtils.isEmpty(fileAttachment2.getPath()) && TextUtils.isEmpty(fileAttachment2.getThumbPath())) {
                    if (this.message.getAttachStatus() != AttachStatusEnum.fail || this.message.getStatus() == MsgStatusEnum.fail) {
                        this.alertButton.setVisibility(0);
                    } else {
                        this.alertButton.setVisibility(8);
                    }
                }
                if (this.message.getStatus() != MsgStatusEnum.sending || this.message.getAttachStatus() == AttachStatusEnum.transferring) {
                    this.progressBar.setVisibility(0);
                    this.f18148e.setVisibility(0);
                    this.f18148e.setText(C5406d.m22117a(getAdapter().mo27732b(this.message)));
                }
                this.f18148e.setVisibility(8);
                return;
            }
        }
        m22802b(thumbPath);
        FileAttachment fileAttachment22 = (FileAttachment) this.message.getAttachment();
        if (this.message.getAttachStatus() != AttachStatusEnum.fail) {
        }
        this.alertButton.setVisibility(0);
        if (this.message.getStatus() != MsgStatusEnum.sending) {
        }
        this.progressBar.setVisibility(0);
        this.f18148e.setVisibility(0);
        this.f18148e.setText(C5406d.m22117a(getAdapter().mo27732b(this.message)));
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f18147d = (MsgThumbImageView) findViewById(C5961R.C5963id.message_item_thumb_thumbnail);
        this.f18148e = (TextView) findViewById(C5961R.C5963id.message_item_thumb_progress_text);
        this.f18149f = (ImageView) findViewById(C5961R.C5963id.message_item_thumb_cover);
        ViewCompat.setLayerType(this.f18147d, 1, null);
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
