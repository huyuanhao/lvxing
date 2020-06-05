package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5414f;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.media.p420a.C5442a.C5445a;
import com.qiyukf.nim.uikit.common.media.p420a.C5447b;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5554a;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.nim.uikit.session.p426b.C5517a;
import com.qiyukf.nim.uikit.session.p426b.C5518b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.p499b.C6014b;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.a */
public class C5619a extends C5622b {
    /* renamed from: a */
    private TextView f18109a;
    /* renamed from: b */
    private View f18110b;
    /* renamed from: c */
    private View f18111c;
    /* renamed from: d */
    private ImageView f18112d;
    /* renamed from: e */
    private C5518b f18113e;
    /* renamed from: f */
    private TextView f18114f;
    /* renamed from: g */
    private boolean f18115g;
    /* renamed from: h */
    private C5445a f18116h = new C5445a() {
        /* renamed from: a */
        public final void mo27442a(C5447b bVar) {
            if (C5619a.m22775a(C5619a.this, bVar)) {
                C5619a.this.m22770a();
            }
        }

        /* renamed from: b */
        public final void mo27443b(C5447b bVar) {
            if (C5619a.m22775a(C5619a.this, bVar)) {
                C5619a.this.m22771a(bVar.mo27450a());
                C5619a.this.m22776b();
            }
        }
    };

    /* renamed from: com.qiyukf.nim.uikit.session.viewholder.a$2 */
    static /* synthetic */ class C56212 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18118a = new int[MsgStatusEnum.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
            com.qiyukf.unicorn.api.msg.MsgStatusEnum[] r0 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f18118a = r0
            int[] r0 = f18118a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.fail     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f18118a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.sending     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.viewholder.C5619a.C56212.m49802clinit():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22770a() {
        if (this.f18112d.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.f18112d.getBackground()).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22771a(long j) {
        long a = C5414f.m22157a(j);
        if (a >= 0) {
            TextView textView = this.f18109a;
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append("\"");
            textView.setText(sb.toString());
            return;
        }
        this.f18109a.setText("");
    }

    /* renamed from: a */
    private void m22774a(boolean z) {
        int i = 0;
        this.f18114f.setVisibility(z ? 0 : 8);
        this.f18110b.setVisibility(z ? 8 : 0);
        View view = this.f18111c;
        if (z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m22775a(C5619a aVar, C5447b bVar) {
        return (bVar instanceof C5517a) && ((C5517a) bVar).mo27623c() == aVar.message;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22776b() {
        if (this.f18112d.getBackground() instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f18112d.getBackground();
            animationDrawable.stop();
            animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
        }
    }

    /* renamed from: c */
    private static int m22778c() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundLeft <= 0) ? C5961R.C5962drawable.ysf_message_left_bg_selector : uICustomization.msgItemBackgroundLeft;
    }

    /* renamed from: d */
    private static int m22779d() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundRight <= 0) ? C5961R.C5962drawable.ysf_message_right_bg_selector : uICustomization.msgItemBackgroundRight;
    }

    /* renamed from: e */
    private static int m22780e() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.textMsgColorLeft == 0) ? ViewCompat.MEASURED_STATE_MASK : uICustomization.textMsgColorLeft;
    }

    /* renamed from: f */
    private static int m22781f() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization == null || uICustomization.textMsgColorRight == 0) {
            return -1;
        }
        return uICustomization.textMsgColorRight;
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        int i;
        TextView textView;
        int i2;
        TextView textView2;
        int i3;
        AudioAttachment audioAttachment = (AudioAttachment) this.message.getAttachment();
        if (!audioAttachment.getAutoTransform() || audioAttachment.getText() == null) {
            boolean z = false;
            m22774a(false);
            if (isReceivedMessage()) {
                setGravity(this.f18112d, 19);
                setGravity(this.f18109a, 21);
                this.f18110b.setBackgroundResource(m22778c());
                ImageView imageView = this.f18112d;
                UICustomization uICustomization = C6029d.m24045e().uiCustomization;
                int i4 = (uICustomization == null || uICustomization.audioMsgAnimationLeft <= 0) ? C5961R.C5962drawable.ysf_audio_animation_list_left : uICustomization.audioMsgAnimationLeft;
                imageView.setBackgroundResource(i4);
                textView = this.f18109a;
                i = m22780e();
            } else {
                setGravity(this.f18112d, 21);
                setGravity(this.f18109a, 19);
                this.f18111c.setVisibility(8);
                this.f18110b.setBackgroundResource(m22779d());
                ImageView imageView2 = this.f18112d;
                UICustomization uICustomization2 = C6029d.m24045e().uiCustomization;
                int i5 = (uICustomization2 == null || uICustomization2.audioMsgAnimationRight <= 0) ? C5961R.C5962drawable.ysf_audio_animation_list_right : uICustomization2.audioMsgAnimationRight;
                imageView2.setBackgroundResource(i5);
                textView = this.f18109a;
                i = m22781f();
            }
            textView.setTextColor(i);
            AudioAttachment audioAttachment2 = (AudioAttachment) this.message.getAttachment();
            MsgStatusEnum status = this.message.getStatus();
            AttachStatusEnum attachStatus = this.message.getAttachStatus();
            if (TextUtils.isEmpty(audioAttachment2.getPath())) {
                if (attachStatus == AttachStatusEnum.fail || status == MsgStatusEnum.fail) {
                    this.alertButton.setVisibility(0);
                } else {
                    this.alertButton.setVisibility(8);
                }
            }
            if (status == MsgStatusEnum.sending || attachStatus == AttachStatusEnum.transferring) {
                this.progressBar.setVisibility(0);
            } else {
                this.progressBar.setVisibility(8);
            }
            if (!isReceivedMessage() || attachStatus != AttachStatusEnum.transferred || status == MsgStatusEnum.read) {
                this.f18111c.setVisibility(8);
            } else {
                this.f18111c.setVisibility(0);
            }
            long duration = ((AudioAttachment) this.message.getAttachment()).getDuration();
            long a = C5414f.m22157a(duration);
            int c = (int) (((double) C5412d.m22149c()) * 0.6d);
            int c2 = (int) (((double) C5412d.m22149c()) * 0.1875d);
            int i6 = (a > 0 ? 1 : (a == 0 ? 0 : -1));
            int i7 = i6 <= 0 ? c2 : (i6 <= 0 || a > 120) ? c : (int) ((((double) (c - c2)) * 0.6366197723675814d * Math.atan(((double) a) / 10.0d)) + ((double) c2));
            if (i7 < c2) {
                c = c2;
            } else if (i7 <= c) {
                c = i7;
            }
            LayoutParams layoutParams = this.f18110b.getLayoutParams();
            layoutParams.width = c;
            this.f18110b.setLayoutParams(layoutParams);
            C5518b bVar = this.f18113e;
            IMMessage iMMessage = this.message;
            if (bVar.mo27626j() != null && bVar.mo27626j().isTheSame(iMMessage)) {
                z = true;
            }
            if (!z) {
                m22771a(duration);
                m22776b();
            } else {
                m22770a();
            }
            this.f18113e.mo27428a(this.f18116h);
            return;
        }
        m22774a(true);
        if (isReceivedMessage()) {
            this.f18114f.setBackgroundResource(m22778c());
            textView2 = this.f18114f;
            i2 = m22780e();
        } else {
            this.f18114f.setBackgroundResource(m22779d());
            textView2 = this.f18114f;
            i2 = m22781f();
        }
        textView2.setTextColor(i2);
        UICustomization uICustomization3 = C6029d.m24045e().uiCustomization;
        if (uICustomization3 != null && uICustomization3.textMsgSize > 0.0f) {
            this.f18114f.setTextSize(uICustomization3.textMsgSize);
        }
        this.f18114f.setText(C5566e.m22593a(this.context, (CharSequence) C5543f.m22542a(this.context, ((AudioAttachment) this.message.getAttachment()).getText())));
        TextView textView3 = this.f18114f;
        UICustomization uICustomization4 = C6029d.m24045e().uiCustomization;
        if (uICustomization4 != null) {
            if (isReceivedMessage() && uICustomization4.hyperLinkColorLeft != 0) {
                i3 = uICustomization4.hyperLinkColorLeft;
                textView3.setLinkTextColor(i3);
                this.f18114f.setOnTouchListener(C5554a.m22582a());
            } else if (!isReceivedMessage() && uICustomization4.hyperLinkColorRight != 0) {
                i3 = uICustomization4.hyperLinkColorRight;
                textView3.setLinkTextColor(i3);
                this.f18114f.setOnTouchListener(C5554a.m22582a());
            }
        }
        i3 = textView3.getCurrentTextColor();
        if ((16777215 & i3) == 0) {
            i3 = textView3.getContext().getResources().getColor(C5961R.color.ysf_text_link_color_blue);
        }
        textView3.setLinkTextColor(i3);
        this.f18114f.setOnTouchListener(C5554a.m22582a());
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_audio;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f18109a = (TextView) findViewById(C5961R.C5963id.message_item_audio_duration);
        this.f18110b = findViewById(C5961R.C5963id.message_item_audio_container);
        this.f18111c = findViewById(C5961R.C5963id.message_item_audio_unread_indicator);
        this.f18112d = (ImageView) findViewById(C5961R.C5963id.message_item_audio_playing_animation);
        this.f18114f = (TextView) findViewById(C5961R.C5963id.nim_message_item_text_body);
        this.f18113e = C5518b.m22478i();
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    public void onDetached() {
        this.f18113e.mo27432b(this.f18116h);
        m22776b();
        super.onDetached();
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        if (this.f18110b.getVisibility() == 0 && this.f18113e != null) {
            if (!isReceivedMessage() || this.message.getAttachStatus() == AttachStatusEnum.transferred) {
                if (this.message.getStatus() != MsgStatusEnum.read) {
                    this.f18111c.setVisibility(8);
                }
                this.f18113e.mo27624a(this.message, C6014b.m23965j() ? 0 : 3);
                this.f18113e.mo27625a(true, this.adapter, this.message);
            } else {
                C5415g.m22161a(C5961R.string.ysf_no_permission_audio_error);
            }
        }
    }

    public void reclaim() {
        this.f18113e.mo27432b(this.f18116h);
        m22776b();
        super.reclaim();
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void setStatus() {
        int i = C56212.f18118a[this.message.getStatus().ordinal()];
        if (i == 1) {
            this.progressBar.setVisibility(8);
            this.alertButton.setVisibility(0);
            if (((AudioAttachment) this.message.getAttachment()).getAutoTransform() && this.f18115g) {
                C5415g.m22161a(C5961R.string.ysf_audio_translate_to_text_failed);
                this.f18115g = false;
            }
        } else if (i != 2) {
            this.progressBar.setVisibility(8);
            this.alertButton.setVisibility(8);
        } else {
            this.progressBar.setVisibility(0);
            this.alertButton.setVisibility(8);
            this.f18115g = true;
        }
    }
}
