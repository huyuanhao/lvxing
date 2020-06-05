package com.qiyukf.unicorn.p517ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nim.uikit.provider.UnicornProvider;
import com.qiyukf.nimlib.p488k.p489a.C5934a;
import com.qiyukf.nimlib.p488k.p489a.C5934a.C5937a;
import com.qiyukf.nimlib.p488k.p489a.C5938b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.widget.FileNameTextView;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import java.io.File;

/* renamed from: com.qiyukf.unicorn.ui.activity.FileDownloadActivity */
public class FileDownloadActivity extends BaseFragmentActivity implements OnClickListener, C5937a {
    /* renamed from: b */
    private ImageView f19442b;
    /* renamed from: c */
    private FileNameTextView f19443c;
    /* renamed from: d */
    private TextView f19444d;
    /* renamed from: e */
    private Button f19445e;
    /* renamed from: f */
    private LinearLayout f19446f;
    /* renamed from: g */
    private ProgressBar f19447g;
    /* renamed from: h */
    private ImageView f19448h;
    /* renamed from: i */
    private TextView f19449i;
    /* renamed from: j */
    private IMMessage f19450j;

    /* renamed from: a */
    private void m24694a(AttachmentProgress attachmentProgress) {
        if (this.f19450j.getAttachStatus() != AttachStatusEnum.transferring || attachmentProgress == null) {
            String a = C5363b.m22022a(((FileAttachment) this.f19450j.getAttachment()).getSize());
            this.f19444d.setText(getString(C5961R.string.ysf_file_download_file_size, new Object[]{a}));
            return;
        }
        String a2 = C5363b.m22022a(attachmentProgress.getTransferred());
        String a3 = C5363b.m22022a(attachmentProgress.getTotal());
        this.f19444d.setText(getString(C5961R.string.ysf_file_download_progress, new Object[]{a2, a3}));
        this.f19447g.setMax((int) attachmentProgress.getTotal());
        this.f19447g.setProgress((int) attachmentProgress.getTransferred());
    }

    /* renamed from: a */
    private void m24696a(boolean z) {
        C5934a.m23792a().mo28369a((C5937a) z ? this : null);
    }

    /* renamed from: b */
    private void m24697b(boolean z) {
        int i = 0;
        m24698c(false);
        m24694a((AttachmentProgress) null);
        this.f19445e.setText(z ? C5961R.string.ysf_file_open : C5961R.string.ysf_file_download);
        TextView textView = this.f19449i;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    /* renamed from: c */
    private void m24698c(boolean z) {
        int i = 8;
        this.f19445e.setVisibility(z ? 8 : 0);
        LinearLayout linearLayout = this.f19446f;
        if (z) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m24699g() {
        m24698c(true);
        C5934a.m23792a().mo28370b(this.f19450j);
    }

    public static void start(Context context, IMMessage iMMessage) {
        Intent intent = new Intent();
        intent.putExtra("extra_message", iMMessage);
        intent.setClass(context, FileDownloadActivity.class);
        context.startActivity(intent);
    }

    public void onClick(View view) {
        String str;
        String str2 = "android.intent.action.VIEW";
        if (view != this.f19445e) {
            if (view == this.f19448h) {
                C5934a.m23792a().mo28371c(this.f19450j);
                m24697b(false);
            }
        } else if (C5934a.m23797d(this.f19450j)) {
            FileAttachment fileAttachment = (FileAttachment) this.f19450j.getAttachment();
            String path = fileAttachment.getPath();
            String displayName = fileAttachment.getDisplayName();
            File file = new File(path);
            if (TextUtils.isEmpty(displayName)) {
                str = "";
            } else {
                String a = C5363b.m22023a(displayName);
                String str3 = null;
                if (!TextUtils.isEmpty(a)) {
                    str3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a);
                }
                String str4 = (!TextUtils.isEmpty(str3) || !TextUtils.equals(a, "aac")) ? str3 : "audio/aac";
                StringBuilder sb = new StringBuilder("fileName:");
                sb.append(displayName);
                sb.append(" type:");
                sb.append(str4);
                Log.i("FileUtil", sb.toString());
                str = str4;
            }
            try {
                Intent intent = new Intent(str2);
                intent.setDataAndType(Uri.fromFile(file), str);
                startActivity(intent);
            } catch (Exception e) {
                if (TextUtils.equals(e.getClass().getName(), "android.os.FileUriExposedException") && UnicornProvider.m22379a(this)) {
                    try {
                        Intent intent2 = new Intent(str2);
                        intent2.setDataAndType(UnicornProvider.m22378a(this, file), str);
                        intent2.addFlags(1);
                        startActivity(intent2);
                        return;
                    } catch (Exception unused) {
                        C5415g.m22161a(C5961R.string.ysf_file_open_fail);
                    }
                }
                C5415g.m22161a(C5961R.string.ysf_file_open_fail);
            }
        } else if (C5934a.m23798e(this.f19450j)) {
            C5415g.m22161a(C5961R.string.ysf_file_out_of_date);
            this.f19445e.setEnabled(false);
        } else if (!C5411c.m22135b(this)) {
            C5415g.m22161a(C5961R.string.ysf_download_network_not_available);
        } else if (C5411c.m22137d(this) || C5411c.m22138e(this)) {
            C6364g.m25004a(this, getString(C5961R.string.ysf_download_tips_title), getString(C5961R.string.ysf_download_tips_message), getString(C5961R.string.ysf_download_tips_sure), getString(C5961R.string.ysf_cancel), true, new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    if (i == 0) {
                        FileDownloadActivity.this.m24699g();
                    }
                }
            });
        } else {
            m24699g();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AttachmentProgress attachmentProgress;
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_activity_file_download);
        this.f19450j = (IMMessage) getIntent().getSerializableExtra("extra_message");
        IMMessage iMMessage = this.f19450j;
        if (iMMessage == null || iMMessage.getAttachment() == null || !(this.f19450j.getAttachment() instanceof FileAttachment)) {
            C5415g.m22161a(C5961R.string.ysf_file_invalid);
            finish();
            return;
        }
        this.f19442b = (ImageView) findViewById(C5961R.C5963id.iv_file_icon);
        this.f19443c = (FileNameTextView) findViewById(C5961R.C5963id.tv_file_name);
        this.f19444d = (TextView) findViewById(C5961R.C5963id.tv_file_size);
        this.f19445e = (Button) findViewById(C5961R.C5963id.download_btn);
        this.f19446f = (LinearLayout) findViewById(C5961R.C5963id.ll_download_progress);
        this.f19447g = (ProgressBar) findViewById(C5961R.C5963id.pb_download);
        this.f19448h = (ImageView) findViewById(C5961R.C5963id.iv_stop_download);
        this.f19449i = (TextView) findViewById(C5961R.C5963id.tv_tips);
        FileAttachment fileAttachment = (FileAttachment) this.f19450j.getAttachment();
        this.f19442b.setImageResource(C5938b.m23803a(fileAttachment.getDisplayName(), true));
        this.f19443c.mo29556a(fileAttachment.getDisplayName());
        this.f19449i.setVisibility(C5934a.m23797d(this.f19450j) ? 0 : 8);
        if (this.f19450j.getAttachStatus() == AttachStatusEnum.transferring) {
            m24698c(true);
            attachmentProgress = C5934a.m23792a().mo28368a(this.f19450j);
            onProgress(attachmentProgress);
        } else {
            this.f19445e.setText(C5934a.m23797d(this.f19450j) ? C5961R.string.ysf_file_open : C5961R.string.ysf_file_download);
            attachmentProgress = null;
        }
        m24694a(attachmentProgress);
        this.f19445e.setOnClickListener(this);
        this.f19448h.setOnClickListener(this);
        m24696a(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m24696a(false);
    }

    public void onFail(IMMessage iMMessage) {
        if (this.f19450j.isTheSame(iMMessage)) {
            this.f19450j = iMMessage;
            C5415g.m22161a(C5961R.string.ysf_file_download_fail);
            m24697b(false);
        }
    }

    public void onProgress(AttachmentProgress attachmentProgress) {
        if (attachmentProgress != null && TextUtils.equals(this.f19450j.getUuid(), attachmentProgress.getUuid())) {
            m24694a(attachmentProgress);
        }
    }

    public void onSuccess(IMMessage iMMessage) {
        if (this.f19450j.isTheSame(iMMessage)) {
            this.f19450j = iMMessage;
            m24697b(true);
        }
    }
}
