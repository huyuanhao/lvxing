package com.qiyukf.nim.uikit.session.module.input;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5399c;
import com.qiyukf.basesdk.p412c.C5399c.C5400a;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.session.emoji.C5542e;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import com.qiyukf.unicorn.p499b.C6014b;
import com.tencent.stat.common.DeviceInfo;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.d */
public final class C5605d {
    /* renamed from: a */
    private static int f18033a;
    /* renamed from: c */
    private static final int f18034c = C5412d.m22146a(380.0f);
    /* renamed from: d */
    private static final int f18035d = C5412d.m22146a(200.0f);
    /* renamed from: b */
    private C5607a f18036b;
    /* renamed from: e */
    private Fragment f18037e;
    /* renamed from: f */
    private C5542e f18038f;
    /* renamed from: g */
    private List<BaseAction> f18039g;
    /* renamed from: h */
    private int f18040h;
    /* renamed from: i */
    private LinearLayout f18041i;
    /* renamed from: j */
    private MessageBottomContainer f18042j;
    /* renamed from: k */
    private EmoticonPickerView f18043k;
    /* renamed from: l */
    private View f18044l;
    /* renamed from: m */
    private View f18045m;
    /* renamed from: n */
    private EditText f18046n;
    /* renamed from: o */
    private View f18047o;
    /* renamed from: p */
    private View f18048p;
    /* renamed from: q */
    private TextView f18049q;
    /* renamed from: r */
    private boolean f18050r = false;
    /* renamed from: s */
    private boolean f18051s = false;
    /* renamed from: t */
    private boolean f18052t = false;

    /* renamed from: com.qiyukf.nim.uikit.session.module.input.d$a */
    interface C5607a {
        /* renamed from: a */
        void mo27767a(boolean z);
    }

    public C5605d(Fragment fragment, LinearLayout linearLayout, C5542e eVar, List<BaseAction> list, int i) {
        this.f18037e = fragment;
        this.f18038f = eVar;
        this.f18039g = list;
        this.f18040h = i;
        this.f18041i = linearLayout;
        this.f18042j = (MessageBottomContainer) linearLayout.findViewById(C5961R.C5963id.nim_message_emoticon_container);
        this.f18043k = (EmoticonPickerView) linearLayout.findViewById(C5961R.C5963id.emoticon_picker_view);
        this.f18045m = linearLayout.findViewById(C5961R.C5963id.textMessageLayout);
        this.f18046n = (EditText) linearLayout.findViewById(C5961R.C5963id.editTextMessage);
        this.f18047o = linearLayout.findViewById(C5961R.C5963id.buttonAudioMessage);
        this.f18048p = linearLayout.findViewById(C5961R.C5963id.buttonTextMessage);
        this.f18049q = (TextView) linearLayout.findViewById(C5961R.C5963id.audioRecord);
    }

    /* renamed from: a */
    static int m22699a() {
        if (f18033a == 0) {
            f18033a = C6014b.m23933b(f18035d);
        }
        int min = Math.min(f18034c, Math.max(f18035d, f18033a));
        StringBuilder sb = new StringBuilder("getValidBottomHeight:");
        sb.append(min);
        C5264a.m21617a(DeviceInfo.TAG_IMEI, sb.toString());
        return min;
    }

    /* renamed from: a */
    static boolean m22701a(int i) {
        int max = Math.max(Math.min(i, f18034c), f18035d);
        int b = C6014b.m23933b(f18035d);
        if (b != max) {
            f18033a = max;
            C6014b.m23922a(max);
        }
        return b != max;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22703b(boolean z) {
        if (this.f18044l != null) {
            if (this.f18052t) {
                this.f18036b.mo27767a(false);
            }
            this.f18052t = false;
            this.f18044l.setVisibility(8);
            if (z) {
                m22707h();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22705c(boolean z) {
        EmoticonPickerView emoticonPickerView = this.f18043k;
        if (emoticonPickerView != null) {
            this.f18050r = false;
            emoticonPickerView.setVisibility(8);
            this.f18042j.setVisibility(8);
            if (z) {
                m22707h();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22706d(boolean z) {
        int i = 0;
        this.f18049q.setVisibility(z ? 0 : 8);
        this.f18046n.setVisibility(z ? 8 : 0);
        this.f18048p.setVisibility(z ? 0 : 8);
        View view = this.f18047o;
        if (z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* renamed from: h */
    private void m22707h() {
        this.f18051s = true;
        C5409b.m22131a((View) this.f18046n);
    }

    /* renamed from: i */
    private void m22708i() {
        this.f18051s = false;
        C5409b.m22133b(this.f18046n);
    }

    /* renamed from: j */
    private void m22709j() {
        this.f18052t = true;
        this.f18036b.mo27767a(true);
        if (this.f18044l == null) {
            View.inflate(this.f18037e.getContext(), C5961R.C5964layout.ysf_message_activity_actions_layout, this.f18041i);
            this.f18044l = this.f18041i.findViewById(C5961R.C5963id.actionsLayout);
            this.f18044l.setBackgroundColor(this.f18040h);
            C5603c.m22696a(this.f18044l, this.f18039g);
        }
        m22705c(false);
        m22708i();
        this.f18044l.setVisibility(0);
    }

    /* renamed from: k */
    private void m22710k() {
        this.f18050r = true;
        m22706d(false);
        m22708i();
        m22703b(false);
        this.f18046n.requestFocus();
        this.f18043k.setVisibility(0);
        this.f18042j.setVisibility(0);
        this.f18043k.mo27629a(this.f18038f);
    }

    /* renamed from: a */
    public final void mo27759a(C5607a aVar) {
        this.f18036b = aVar;
    }

    /* renamed from: a */
    public final void mo27760a(boolean z) {
        m22706d(false);
        m22705c(z);
        m22703b(z);
        this.f18045m.setVisibility(0);
        if (z) {
            m22707h();
        }
    }

    /* renamed from: b */
    public final void mo27761b() {
        EmoticonPickerView emoticonPickerView = this.f18043k;
        if (emoticonPickerView == null || emoticonPickerView.getVisibility() == 8) {
            m22710k();
        } else {
            m22705c(true);
        }
    }

    /* renamed from: c */
    public final void mo27762c() {
        if (this.f18050r) {
            m22710k();
        } else if (this.f18052t) {
            m22709j();
        } else {
            boolean z = this.f18051s;
            m22705c(z);
            m22703b(z);
        }
    }

    /* renamed from: d */
    public final void mo27763d() {
        m22708i();
        m22705c(false);
        m22703b(false);
    }

    /* renamed from: e */
    public final void mo27764e() {
        m22708i();
        C5399c.m22100a(this.f18037e).mo27354a("android.permission.RECORD_AUDIO").mo27353a((C5400a) new C5400a() {
            public final void onDenied() {
                C5415g.m22161a(C5961R.string.ysf_no_permission_send_audio);
            }

            public final void onGranted() {
                C5605d.this.m22705c(false);
                C5605d.this.m22703b(false);
                C5605d.this.m22706d(true);
            }
        }).mo27355a();
    }

    /* renamed from: f */
    public final void mo27765f() {
        View view = this.f18044l;
        if (view == null || view.getVisibility() == 8) {
            m22709j();
        } else {
            m22703b(true);
        }
    }

    /* renamed from: g */
    public final View mo27766g() {
        return this.f18044l;
    }
}
