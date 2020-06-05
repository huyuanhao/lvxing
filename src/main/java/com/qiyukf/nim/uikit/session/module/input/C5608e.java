package com.qiyukf.nim.uikit.session.module.input;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nim.uikit.session.C5490a;
import com.qiyukf.nim.uikit.session.emoji.C5542e;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;
import com.qiyukf.nim.uikit.session.module.C5567a;
import com.qiyukf.nim.uikit.session.module.input.p428a.C5594a;
import com.qiyukf.nim.uikit.session.module.input.p428a.C5594a.C5597a;
import com.qiyukf.nimlib.sdk.media.record.AudioRecorder;
import com.qiyukf.nimlib.sdk.media.record.IAudioRecordCallback;
import com.qiyukf.nimlib.sdk.media.record.RecordType;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6045d;
import com.qiyukf.unicorn.p502e.C6047e;
import com.qiyukf.unicorn.p502e.C6051i;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f.C6125a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6130k;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6162r;
import com.qiyukf.unicorn.p514h.C6185c;
import java.io.File;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.e */
public final class C5608e implements C5542e, IAudioRecordCallback {
    /* renamed from: A */
    private boolean f18054A = false;
    /* renamed from: B */
    private boolean f18055B = false;
    /* access modifiers changed from: private */
    /* renamed from: C */
    public boolean f18056C = false;
    /* renamed from: D */
    private boolean f18057D = false;
    /* access modifiers changed from: private */
    /* renamed from: E */
    public List<BaseAction> f18058E;
    /* renamed from: F */
    private int f18059F = 0;
    /* access modifiers changed from: private */
    /* renamed from: G */
    public C5605d f18060G;
    /* renamed from: H */
    private C5617f f18061H;
    /* access modifiers changed from: private */
    /* renamed from: I */
    public String f18062I = "";
    /* access modifiers changed from: private */
    /* renamed from: J */
    public C5490a f18063J;
    /* renamed from: K */
    private Runnable f18064K = new Runnable() {
        public final void run() {
            C6051i k = C6029d.m24047g().mo29309k(C5608e.this.f18079m.f17922c);
            long c = C6029d.m24047g().mo29295c(C5608e.this.f18079m.f17922c);
            long f = (long) C6029d.m24047g().mo29301f(C5608e.this.f18079m.f17922c);
            String obj = C5608e.this.f18068b.getText().toString();
            if (k.mo28905a() && c > 0 && f == 0 && !C5608e.this.f18079m.f17922c.equals(C5433b.m22192b()) && !TextUtils.equals(obj, C5608e.this.f18062I)) {
                C5608e.this.f18062I = obj;
                C6162r rVar = new C6162r();
                rVar.mo29230a(c);
                rVar.mo29231a(C5608e.this.f18062I);
                rVar.mo29232b(System.currentTimeMillis());
                rVar.mo29229a(k.mo28906b());
                C6185c.m24532a(rVar, C5608e.this.f18079m.f17922c, false);
            }
            C5608e.this.f18081o.postDelayed(this, (long) (k.mo28906b() * 1000.0f));
        }
    };
    /* renamed from: L */
    private OnClickListener f18065L = new OnClickListener() {
        public final void onClick(View view) {
            if (view == C5608e.this.f18071e) {
                C5608e.this.f18060G.mo27760a(true);
                C5608e.this.m22740i();
            } else if (view == C5608e.this.f18072f) {
                C5608e.this.f18060G.mo27764e();
                C5608e.this.m22740i();
            } else if (view == C5608e.this.f18074h) {
                C5608e.m22736g(C5608e.this);
            } else if (view == C5608e.this.f18073g) {
                if (C5608e.this.f18063J == null || !C5608e.this.f18063J.f17687h) {
                    ((BaseAction) C5608e.this.f18058E.get(0)).onClick();
                } else {
                    C5608e.this.f18060G.mo27765f();
                }
            } else if (view == C5608e.this.f18075i) {
                C5608e.this.f18060G.mo27761b();
            } else {
                if (view == C5608e.this.f18068b) {
                    C5608e.this.f18060G.mo27760a(true);
                }
            }
        }
    };
    /* renamed from: M */
    private C5597a f18066M = new C5597a() {
        /* renamed from: a */
        public final void mo27755a(C6125a aVar) {
            C5608e.this.f18068b.setText(aVar.mo29111a());
            C5608e.m22736g(C5608e.this);
        }
    };
    /* renamed from: a */
    protected LinearLayout f18067a;
    /* renamed from: b */
    protected EditText f18068b;
    /* renamed from: c */
    protected TextView f18069c;
    /* renamed from: d */
    protected View f18070d;
    /* renamed from: e */
    protected View f18071e;
    /* renamed from: f */
    protected View f18072f;
    /* renamed from: g */
    protected View f18073g;
    /* renamed from: h */
    protected View f18074h;
    /* renamed from: i */
    protected View f18075i;
    /* renamed from: j */
    protected View f18076j;
    /* renamed from: k */
    protected EmoticonPickerView f18077k;
    /* renamed from: l */
    protected AudioRecorder f18078l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public C5567a f18079m;
    /* renamed from: n */
    private View f18080n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public Handler f18081o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public C5594a f18082p;
    /* renamed from: q */
    private ViewGroup f18083q;
    /* renamed from: r */
    private LevelListDrawable f18084r;
    /* renamed from: s */
    private View f18085s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public TextView f18086t;
    /* renamed from: u */
    private TextView f18087u;
    /* renamed from: v */
    private View f18088v;
    /* renamed from: w */
    private View f18089w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public ImageView f18090x;
    /* access modifiers changed from: private */
    /* renamed from: y */
    public ImageView f18091y;
    /* renamed from: z */
    private long f18092z;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    public C5608e(com.qiyukf.nim.uikit.session.module.C5567a r3, android.view.View r4, com.qiyukf.nim.uikit.session.C5490a r5) {
        /*
        r2 = this;
        r2.<init>()
        r0 = 0
        r2.f18054A = r0
        r2.f18055B = r0
        r2.f18056C = r0
        r2.f18057D = r0
        r2.f18059F = r0
        java.lang.String r0 = ""
        r2.f18062I = r0
        com.qiyukf.nim.uikit.session.module.input.e$3 r0 = new com.qiyukf.nim.uikit.session.module.input.e$3
        r0.m49788init()
        r2.f18064K = r0
        com.qiyukf.nim.uikit.session.module.input.e$4 r0 = new com.qiyukf.nim.uikit.session.module.input.e$4
        r0.m49789init()
        r2.f18065L = r0
        com.qiyukf.nim.uikit.session.module.input.e$8 r0 = new com.qiyukf.nim.uikit.session.module.input.e$8
        r0.m49793init()
        r2.f18066M = r0
        r2.f18079m = r3
        r2.f18080n = r4
        java.util.ArrayList r3 = new java.util.ArrayList
        r3.<init>()
        com.qiyukf.unicorn.api.YSFOptions r4 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.customization.input.InputPanelOptions r4 = r4.inputPanelOptions
        if (r4 == 0) goto L_0x0073
        boolean r0 = r4.showActionPanel
        if (r0 == 0) goto L_0x0073
        com.qiyukf.unicorn.api.customization.input.ActionPanelOptions r0 = r4.actionPanelOptions
        com.qiyukf.unicorn.api.customization.input.ActionListProvider r0 = r0.actionListProvider
        if (r0 == 0) goto L_0x005d
        com.qiyukf.unicorn.api.customization.input.ActionPanelOptions r0 = r4.actionPanelOptions
        com.qiyukf.unicorn.api.customization.input.ActionListProvider r0 = r0.actionListProvider
        java.util.List r0 = r0.getActionList()
        int r0 = r0.size()
        if (r0 != 0) goto L_0x0051
        goto L_0x005d
    L_0x0051:
        com.qiyukf.unicorn.api.customization.input.ActionPanelOptions r4 = r4.actionPanelOptions
        com.qiyukf.unicorn.api.customization.input.ActionListProvider r4 = r4.actionListProvider
        java.util.List r4 = r4.getActionList()
        r3.addAll(r4)
        goto L_0x007b
    L_0x005d:
        com.qiyukf.unicorn.api.customization.action.AlbumAction r4 = new com.qiyukf.unicorn.api.customization.action.AlbumAction
        int r0 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_ic_action_album
        int r1 = com.qiyukf.unicorn.C5961R.string.ysf_picker_image_folder
        r4.m50244init(r0, r1)
        r3.add(r4)
        com.qiyukf.unicorn.api.customization.action.CameraAction r4 = new com.qiyukf.unicorn.api.customization.action.CameraAction
        int r0 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_ic_action_camera
        int r1 = com.qiyukf.unicorn.C5961R.string.ysf_input_panel_take
        r4.m50248init(r0, r1)
        goto L_0x0078
    L_0x0073:
        com.qiyukf.unicorn.api.customization.action.ImageAction r4 = new com.qiyukf.unicorn.api.customization.action.ImageAction
        r4.m50251init()
    L_0x0078:
        r3.add(r4)
    L_0x007b:
        r2.f18058E = r3
        android.os.Handler r3 = new android.os.Handler
        r3.<init>()
        r2.f18081o = r3
        r2.f18063J = r5
        if (r5 == 0) goto L_0x008c
        int r3 = r5.f17682c
        r2.f18059F = r3
    L_0x008c:
        r2.m22735g()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.input.C5608e.m49785init(com.qiyukf.nim.uikit.session.module.a, android.view.View, com.qiyukf.nim.uikit.session.a):void");
    }

    /* renamed from: a */
    private void m22722a(boolean z, boolean z2) {
        if (z) {
            this.f18086t.setText(C5961R.string.ysf_audio_record_cancel_tip);
            this.f18086t.setBackgroundResource(C5961R.C5962drawable.ysf_audio_cancel_record_red_bg);
            return;
        }
        this.f18086t.setBackgroundResource(0);
        TextView textView = this.f18086t;
        if (z2) {
            textView.setText(this.f18079m.f17920a.getString(C5961R.string.ysf_audio_record_time_is_up_tips, new Object[]{Integer.valueOf(60)}));
            return;
        }
        textView.setText(C5961R.string.ysf_audio_record_move_up_to_cancel);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m22723a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return motionEvent.getRawX() < ((float) iArr[0]) || motionEvent.getRawX() > ((float) (iArr[0] + view.getWidth())) || motionEvent.getRawY() < ((float) (iArr[1] - 40));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22730d(boolean z) {
        this.f18079m.f17920a.getWindow().setFlags(0, 128);
        this.f18078l.completeRecord(z);
        this.f18069c.setText(C5961R.string.ysf_audio_record_touch_to_record);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22732e(boolean z) {
        if (this.f18054A && this.f18055B != z) {
            this.f18055B = z;
            m22734f(z);
        }
    }

    /* renamed from: f */
    private void m22734f(boolean z) {
        boolean z2 = false;
        TextView textView = this.f18069c;
        if (z) {
            textView.setText(C5961R.string.ysf_audio_record_touch_to_record);
            this.f18089w.setVisibility(4);
            this.f18085s.setVisibility(0);
        } else {
            textView.setText(C5961R.string.ysf_audio_record_up_to_complete);
            this.f18085s.setVisibility(4);
            this.f18089w.setVisibility(0);
            int i = ((System.currentTimeMillis() - this.f18092z) > 50000 ? 1 : ((System.currentTimeMillis() - this.f18092z) == 50000 ? 0 : -1));
            ViewGroup viewGroup = this.f18083q;
            if (i > 0) {
                viewGroup.setVisibility(4);
                this.f18087u.setVisibility(0);
            } else {
                viewGroup.setVisibility(0);
                this.f18087u.setVisibility(4);
            }
        }
        if (System.currentTimeMillis() - this.f18092z >= 59000) {
            z2 = true;
        }
        m22722a(z, z2);
    }

    /* renamed from: g */
    private void m22735g() {
        int i;
        View view;
        this.f18067a = (LinearLayout) this.f18080n.findViewById(C5961R.C5963id.messageActivityBottomLayout);
        this.f18076j = this.f18080n.findViewById(C5961R.C5963id.textMessageLayout);
        this.f18071e = this.f18080n.findViewById(C5961R.C5963id.buttonTextMessage);
        this.f18072f = this.f18080n.findViewById(C5961R.C5963id.buttonAudioMessage);
        this.f18073g = this.f18080n.findViewById(C5961R.C5963id.action_list_trigger_button);
        this.f18075i = this.f18080n.findViewById(C5961R.C5963id.emoji_button);
        this.f18074h = this.f18080n.findViewById(C5961R.C5963id.send_message_button);
        this.f18068b = (EditText) this.f18080n.findViewById(C5961R.C5963id.editTextMessage);
        this.f18069c = (TextView) this.f18080n.findViewById(C5961R.C5963id.audioRecord);
        this.f18070d = this.f18080n.findViewById(C5961R.C5963id.ysf_audio_recording_panel);
        this.f18086t = (TextView) this.f18080n.findViewById(C5961R.C5963id.ysf_cancel_recording_text_view);
        this.f18083q = (ViewGroup) this.f18080n.findViewById(C5961R.C5963id.ysf_audio_amplitude_panel);
        this.f18090x = (ImageView) this.f18080n.findViewById(C5961R.C5963id.ysf_amplitude_indicator);
        this.f18091y = (ImageView) this.f18080n.findViewById(C5961R.C5963id.ysf_recording_view_mic);
        this.f18084r = (LevelListDrawable) ((ImageView) this.f18080n.findViewById(C5961R.C5963id.ysf_amplitude_indicator)).getDrawable();
        this.f18085s = this.f18080n.findViewById(C5961R.C5963id.ysf_recording_cancel_indicator);
        this.f18087u = (TextView) this.f18080n.findViewById(C5961R.C5963id.ysf_recording_count_down_label);
        this.f18089w = this.f18080n.findViewById(C5961R.C5963id.ysf_audio_recording_animation_view);
        this.f18088v = this.f18080n.findViewById(C5961R.C5963id.ysf_audio_record_end_tip);
        this.f18077k = (EmoticonPickerView) this.f18080n.findViewById(C5961R.C5963id.emoticon_picker_view);
        C5605d dVar = new C5605d(this.f18079m.f17921b, this.f18067a, this, this.f18058E, this.f18059F);
        this.f18060G = dVar;
        this.f18060G.mo27759a((C5607a) new C5607a() {
            /* renamed from: a */
            public final void mo27767a(boolean z) {
                C5608e.this.mo27777c(!z);
            }
        });
        this.f18061H = new C5617f(this.f18079m, this.f18067a);
        this.f18071e.setVisibility(8);
        this.f18072f.setVisibility(0);
        this.f18082p = new C5594a();
        this.f18082p.mo27750a(this.f18079m.f17921b.getContext(), this.f18080n, this.f18079m.f17922c, this.f18066M);
        m22738h();
        this.f18071e.setOnClickListener(this.f18065L);
        this.f18072f.setOnClickListener(this.f18065L);
        this.f18075i.setOnClickListener(this.f18065L);
        this.f18074h.setOnClickListener(this.f18065L);
        this.f18073g.setOnClickListener(this.f18065L);
        this.f18068b.setOnClickListener(this.f18065L);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.inputTextSize > 0.0f) {
                this.f18068b.setTextSize(uICustomization.inputTextSize);
            }
            if (uICustomization.inputTextColor != 0) {
                this.f18068b.setTextColor(uICustomization.inputTextColor);
            }
        }
        this.f18068b.setInputType(131073);
        this.f18068b.addTextChangedListener(new TextWatcher() {
            /* renamed from: b */
            private int f18095b;
            /* renamed from: c */
            private int f18096c;

            public final void afterTextChanged(Editable editable) {
                C5608e.this.m22740i();
                C5543f.m22545a((Context) C5608e.this.f18079m.f17920a, editable, this.f18095b, this.f18096c);
                C5608e.this.f18082p.mo27751a(editable.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f18095b = i;
                this.f18096c = i3;
            }
        });
        String d = C6014b.m23949d(this.f18079m.f17922c);
        if (!TextUtils.isEmpty(d)) {
            this.f18068b.setText(d);
            this.f18068b.setSelection(d.length());
            C6014b.m23938b(this.f18079m.f17922c, (String) null);
        }
        if (uICustomization == null || !uICustomization.hideKeyboardOnEnterConsult) {
            this.f18060G.mo27760a(true);
        } else {
            this.f18060G.mo27760a(false);
        }
        this.f18069c.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    C5608e.this.f18056C = true;
                    C5608e.m22742j(C5608e.this);
                    C5608e.m22743k(C5608e.this);
                } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    C5608e.this.f18056C = false;
                    C5608e.this.m22730d(C5608e.m22723a(view, motionEvent));
                } else if (motionEvent.getAction() == 2) {
                    C5608e.this.f18056C = false;
                    C5608e.this.m22732e(C5608e.m22723a(view, motionEvent));
                }
                return true;
            }
        });
        m22740i();
        this.f18068b.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    return C5608e.this.mo27778d();
                }
                return false;
            }
        });
        C5490a aVar = this.f18063J;
        if (aVar != null) {
            this.f18072f.setBackgroundResource(aVar.f17683d != 0 ? this.f18063J.f17683d : C5961R.C5962drawable.ysf_message_button_bottom_audio_selector);
            this.f18075i.setBackgroundResource(this.f18063J.f17684e != 0 ? this.f18063J.f17684e : C5961R.C5962drawable.ysf_message_button_bottom_emoji_selector);
            if (this.f18063J.f17687h) {
                view = this.f18073g;
                i = this.f18063J.f17686g != 0 ? this.f18063J.f17686g : C5961R.C5962drawable.ysf_ic_actionpanel_start;
            } else {
                view = this.f18073g;
                i = this.f18063J.f17685f != 0 ? this.f18063J.f17685f : C5961R.C5962drawable.ysf_message_button_bottom_add_selector;
            }
            view.setBackgroundResource(i);
        }
        for (int i2 = 0; i2 < this.f18058E.size(); i2++) {
            ((BaseAction) this.f18058E.get(i2)).setIndex(i2);
            ((BaseAction) this.f18058E.get(i2)).setContainer(this.f18079m);
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m22736g(C5608e eVar) {
        if (eVar.f18079m.f17924e.sendMessage(MessageBuilder.createTextMessage(eVar.f18079m.f17922c, eVar.f18079m.f17923d, eVar.f18068b.getText().toString().trim()), false)) {
            eVar.f18068b.setText("");
        }
    }

    /* renamed from: h */
    private void m22738h() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        View findViewById = this.f18080n.findViewById(C5961R.C5963id.switchLayout);
        int i = 8;
        int i2 = (uICustomization == null || !uICustomization.hideAudio) ? 0 : 8;
        findViewById.setVisibility(i2);
        View view = this.f18075i;
        int i3 = (uICustomization == null || !uICustomization.hideEmoji) ? 0 : 8;
        view.setVisibility(i3);
        boolean z = !C5406d.m22119a((CharSequence) this.f18068b.getText());
        this.f18073g.setVisibility(z ? 8 : 0);
        View view2 = this.f18074h;
        if (z) {
            i = 0;
        }
        view2.setVisibility(i);
        this.f18074h.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m22740i() {
        boolean z = true;
        int i = 0;
        boolean z2 = this.f18069c.getVisibility() == 0;
        boolean z3 = !C5406d.m22119a((CharSequence) this.f18068b.getText());
        boolean z4 = !z2 && (z3 || this.f18057D);
        if (this.f18057D || (!z2 && z3)) {
            z = false;
        }
        this.f18074h.setEnabled(z3);
        this.f18074h.setVisibility(z4 ? 0 : 8);
        View view = this.f18073g;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m22741j() {
        this.f18070d.setVisibility(8);
    }

    /* renamed from: j */
    static /* synthetic */ void m22742j(C5608e eVar) {
        if (eVar.f18078l == null) {
            eVar.f18078l = new AudioRecorder(eVar.f18079m.f17920a, RecordType.AMR, 60, eVar);
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m22743k(C5608e eVar) {
        eVar.f18079m.f17920a.getWindow().setFlags(128, 128);
        eVar.f18054A = eVar.f18078l.startRecord();
        eVar.f18055B = false;
        if (eVar.f18054A && eVar.f18056C) {
            eVar.f18069c.setText(C5961R.string.ysf_audio_record_up_to_complete);
            eVar.m22734f(false);
            eVar.f18070d.setVisibility(0);
        }
    }

    /* renamed from: a */
    public final void mo27768a(int i) {
        this.f18059F = i;
    }

    /* renamed from: a */
    public final void mo27769a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            int i3 = (i << 16) >> 24;
            if (i3 != 0) {
                int i4 = i3 - 1;
                if (i4 < 0 || i4 >= this.f18058E.size()) {
                    C5264a.m21624d("MsgSendLayout", "request code out of actions' range");
                } else {
                    BaseAction baseAction = (BaseAction) this.f18058E.get(i4);
                    if (baseAction != null) {
                        baseAction.onActivityResult(i & 255, i2, intent);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27770a(C5567a aVar) {
        this.f18079m = aVar;
    }

    /* renamed from: a */
    public final void mo27771a(C6124f fVar) {
        if (fVar.mo29109a() == C6029d.m24047g().mo29299e(this.f18079m.f17922c)) {
            this.f18082p.mo27752a(fVar.mo29110b());
        }
    }

    /* renamed from: a */
    public final void mo27654a(String str) {
        Editable text = this.f18068b.getText();
        int i = 0;
        if (str.equals("/DEL")) {
            this.f18068b.dispatchKeyEvent(new KeyEvent(0, 67));
        } else if (str.equals("/DEL_CUSTOM")) {
            try {
                String obj = text.toString();
                int selectionStart = this.f18068b.getSelectionStart();
                if (selectionStart != -1) {
                    int lastIndexOf = obj.substring(0, selectionStart).lastIndexOf("[:");
                    if (lastIndexOf < selectionStart && lastIndexOf != -1 && C5543f.m22547a(obj.substring(lastIndexOf, selectionStart)) && ']' == obj.charAt(selectionStart - 1)) {
                        this.f18068b.getText().delete(lastIndexOf, selectionStart);
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("is error");
                sb.append(e);
                C5264a.m21617a("deleteEmoji", sb.toString());
            }
        } else {
            int selectionStart2 = this.f18068b.getSelectionStart();
            int selectionEnd = this.f18068b.getSelectionEnd();
            if (selectionStart2 < 0) {
                selectionStart2 = 0;
            }
            if (selectionEnd >= 0) {
                i = selectionEnd;
            }
            if (selectionStart2 <= i) {
                text.replace(selectionStart2, i, str);
            } else {
                text.replace(i, selectionStart2, str);
            }
            this.f18068b.setSelection(Math.min(selectionStart2, i) + str.length());
        }
    }

    /* renamed from: a */
    public final void mo27655a(String str, String str2) {
        C6130k a = C6130k.m24343a(str2, str);
        IMMessage createCustomMessage = MessageBuilder.createCustomMessage(this.f18079m.f17922c, SessionTypeEnum.Ysf, a);
        createCustomMessage.setContent(a.mo29123a());
        this.f18079m.f17924e.sendMessage(createCustomMessage, false);
    }

    /* renamed from: a */
    public final void mo27656a(List<C6045d> list) {
        C6029d.m24047g().mo29284a(Long.valueOf(C6029d.m24047g().mo29295c(this.f18079m.f17922c)), list);
    }

    /* renamed from: a */
    public final void mo27772a(boolean z) {
        this.f18057D = z;
        m22732e(true);
        m22741j();
        this.f18060G.mo27760a(false);
        if (z) {
            UICustomization uICustomization = C6029d.m24045e().uiCustomization;
            View findViewById = this.f18080n.findViewById(C5961R.C5963id.switchLayout);
            int i = (uICustomization == null || !uICustomization.hideAudioWithRobot) ? 0 : 8;
            findViewById.setVisibility(i);
            this.f18075i.setVisibility(8);
            this.f18073g.setVisibility(8);
            this.f18074h.setVisibility(0);
            return;
        }
        m22738h();
    }

    /* renamed from: a */
    public final boolean mo27657a() {
        List a = C6029d.m24047g().mo29279a(Long.valueOf(C6029d.m24047g().mo29295c(this.f18079m.f17922c)));
        return (a == null || a.size() == 0) ? false : true;
    }

    /* renamed from: b */
    public final void mo27773b() {
        this.f18081o.post(this.f18064K);
    }

    /* renamed from: b */
    public final void mo27774b(List<? extends C6047e> list) {
        this.f18061H.mo27796a(list);
    }

    /* renamed from: b */
    public final void mo27775b(boolean z) {
        String str = null;
        if (z) {
            m22732e(true);
            m22741j();
            this.f18060G.mo27760a(false);
            this.f18068b.setText(null);
            this.f18060G.mo27763d();
        }
        EditText editText = this.f18068b;
        if (z) {
            str = editText.getContext().getString(C5961R.string.ysf_no_staff_disabled);
        }
        editText.setHint(str);
        this.f18068b.setEnabled(!z);
        this.f18072f.setEnabled(!z);
        this.f18075i.setEnabled(!z);
        this.f18073g.setEnabled(!z);
    }

    /* renamed from: c */
    public final void mo27776c() {
        if (this.f18078l != null) {
            m22730d(true);
        }
        C6014b.m23938b(this.f18079m.f17922c, this.f18068b.getText().toString());
        this.f18081o.removeCallbacks(this.f18064K);
    }

    /* renamed from: c */
    public final void mo27777c(boolean z) {
        View view = this.f18073g;
        float[] fArr = {0.0f, 45.0f};
        String str = C7887a.ROTATION;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, fArr);
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18073g, str, new float[]{45.0f, 0.0f});
        ofFloat.setDuration(300);
        C5490a aVar = this.f18063J;
        if (aVar != null && aVar.f17687h) {
            if (z) {
                ofFloat2.start();
                return;
            }
            ofFloat.start();
        }
    }

    /* renamed from: d */
    public final boolean mo27778d() {
        View g = this.f18060G.mo27766g();
        EmoticonPickerView emoticonPickerView = this.f18077k;
        boolean z = (emoticonPickerView != null && emoticonPickerView.getVisibility() == 0) || (g != null && g.getVisibility() == 0);
        this.f18060G.mo27763d();
        return z;
    }

    /* renamed from: e */
    public final boolean mo27779e() {
        AudioRecorder audioRecorder = this.f18078l;
        return audioRecorder != null && audioRecorder.isRecording();
    }

    /* renamed from: f */
    public final void mo27780f() {
        C5605d dVar = this.f18060G;
        if (dVar != null) {
            dVar.mo27762c();
        }
    }

    public final void onRecordCancel() {
        m22741j();
    }

    public final void onRecordFail() {
        this.f18090x.setVisibility(8);
        this.f18091y.setImageResource(C5961R.C5962drawable.ysf_recording_alert);
        this.f18086t.setText(C5961R.string.ysf_audio_record_alert);
        this.f18086t.setPadding(C5412d.m22146a(25.0f), C5412d.m22146a(5.0f), C5412d.m22146a(25.0f), C5412d.m22146a(5.0f));
        this.f18081o.postDelayed(new Runnable() {
            public final void run() {
                C5608e.this.f18090x.setVisibility(0);
                C5608e.this.f18091y.setImageResource(C5961R.C5962drawable.ysf_recording_mic);
                C5608e.this.f18086t.setText(C5961R.string.ysf_audio_record_cancel_tip);
                C5608e.this.f18086t.setPadding(C5412d.m22146a(5.0f), C5412d.m22146a(5.0f), C5412d.m22146a(5.0f), C5412d.m22146a(5.0f));
                C5608e.this.m22741j();
            }
        }, 1000);
    }

    public final void onRecordReachedMaxTime(int i) {
        m22741j();
        this.f18078l.handleEndRecord(true, i);
    }

    public final void onRecordReady() {
    }

    public final void onRecordStart(File file, RecordType recordType) {
        this.f18092z = System.currentTimeMillis();
    }

    public final void onRecordSuccess(File file, long j, RecordType recordType) {
        m22741j();
        this.f18079m.f17924e.sendMessage(MessageBuilder.createAudioMessage(this.f18079m.f17922c, this.f18079m.f17923d, file, j, this.f18057D), false);
    }

    public final void onUpdateAmplitude(int i) {
        boolean z = false;
        this.f18084r.setLevel(Math.max(0, Math.min(5, (int) (((float) ((int) (Math.log10((double) (i / 100)) * 20.0d))) / 7.3733335f))));
        long currentTimeMillis = 60 - ((System.currentTimeMillis() - this.f18092z) / 1000);
        if (currentTimeMillis >= 11) {
            this.f18083q.setVisibility(0);
            this.f18087u.setVisibility(4);
            this.f18088v.setVisibility(4);
        } else if (currentTimeMillis > 1) {
            this.f18083q.setVisibility(4);
            this.f18087u.setVisibility(0);
            this.f18088v.setVisibility(4);
            this.f18087u.setText(String.valueOf(currentTimeMillis - 1));
        } else {
            this.f18083q.setVisibility(4);
            this.f18087u.setVisibility(4);
            this.f18088v.setVisibility(0);
            if (this.f18085s.getVisibility() == 0) {
                z = true;
            }
            m22722a(z, true);
        }
    }
}
