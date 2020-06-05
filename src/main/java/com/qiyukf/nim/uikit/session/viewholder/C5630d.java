package com.qiyukf.nim.uikit.session.viewholder;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.nimlib.p488k.p489a.C5934a;
import com.qiyukf.nimlib.p488k.p489a.C5938b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.p517ui.activity.FileDownloadActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.d */
public class C5630d extends C5622b {
    /* renamed from: a */
    private LinearLayout f18129a;
    /* renamed from: b */
    private ImageView f18130b;
    /* renamed from: c */
    private FileNameTextView f18131c;
    /* renamed from: d */
    private TextView f18132d;

    /* access modifiers changed from: protected */
    public void bindContentView() {
        Context context;
        int i;
        this.f18129a.setBackgroundResource(isReceivedMessage() ? C5961R.C5962drawable.ysf_message_left_bg_product_selector : C5961R.C5962drawable.ysf_message_right_bg_product_selector);
        FileAttachment fileAttachment = (FileAttachment) this.message.getAttachment();
        this.f18130b.setImageResource(C5938b.m23803a(fileAttachment.getDisplayName(), false));
        this.f18131c.mo29556a(fileAttachment.getDisplayName());
        StringBuilder sb = new StringBuilder();
        sb.append(C5363b.m22022a(fileAttachment.getSize()));
        sb.append("  ");
        if (C5934a.m23797d(this.message)) {
            context = this.context;
            i = C5961R.string.ysf_msg_file_downloaded;
        } else if (C5934a.m23798e(this.message)) {
            context = this.context;
            i = C5961R.string.ysf_msg_file_expired;
        } else {
            context = this.context;
            i = C5961R.string.ysf_msg_file_not_downloaded;
        }
        sb.append(context.getString(i));
        this.f18132d.setText(sb.toString());
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_file;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f18129a = (LinearLayout) findViewById(C5961R.C5963id.ll_content);
        this.f18130b = (ImageView) findViewById(C5961R.C5963id.message_item_file_icon_image);
        this.f18131c = (FileNameTextView) findViewById(C5961R.C5963id.message_item_file_name_label);
        this.f18132d = (TextView) findViewById(C5961R.C5963id.message_item_file_status_label);
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        if (C5934a.m23797d(this.message) || !C5934a.m23798e(this.message)) {
            FileDownloadActivity.start(this.context, this.message);
        }
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
