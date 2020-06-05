package com.qiyukf.nim.uikit.session.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.media.p420a.C5442a.C5445a;
import com.qiyukf.nim.uikit.common.media.p420a.C5447b;
import com.qiyukf.nim.uikit.session.C5490a;
import com.qiyukf.nim.uikit.session.module.C5567a;
import com.qiyukf.nim.uikit.session.module.C5591b;
import com.qiyukf.nim.uikit.session.module.input.C5608e;
import com.qiyukf.nim.uikit.session.module.p427a.C5570b;
import com.qiyukf.nim.uikit.session.p426b.C5518b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.C6029d.C6036a;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6160p;
import com.qiyukf.unicorn.p514h.C6185c;
import java.util.List;

public class MessageFragment extends TFragment implements C5591b {
    /* renamed from: a */
    protected View f17880a;
    /* renamed from: b */
    protected TextView f17881b;
    /* renamed from: c */
    protected LinearLayout f17882c;
    /* renamed from: d */
    protected C5608e f17883d;
    /* renamed from: e */
    protected C5570b f17884e;
    /* renamed from: f */
    protected C5567a f17885f;
    /* renamed from: g */
    protected String f17886g;
    /* renamed from: h */
    protected SessionTypeEnum f17887h;
    /* renamed from: i */
    protected SensorEventListener f17888i;
    /* renamed from: j */
    private View f17889j;
    /* renamed from: k */
    private C5490a f17890k;
    /* renamed from: l */
    private SensorManager f17891l;
    /* renamed from: m */
    private Sensor f17892m;
    /* renamed from: n */
    private C6036a f17893n = new C6036a() {
        /* renamed from: a */
        public final void mo27687a() {
            MessageFragment.this.m22572a(true);
            MessageFragment.m22574b(MessageFragment.this);
            if (MessageFragment.this.isResumed()) {
                ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(MessageFragment.this.f17886g, MessageFragment.this.f17887h);
            }
        }
    };
    /* renamed from: o */
    private C5445a f17894o = new C5445a() {
        /* renamed from: a */
        public final void mo27442a(C5447b bVar) {
            MessageFragment.this.getActivity().getWindow().setFlags(128, 128);
            MessageFragment.this.getActivity();
            if (C5518b.m22478i().mo27431b() == 0) {
                MessageFragment.this.f17884e.mo27708b(C5961R.string.ysf_audio_is_playing_by_earphone);
            }
        }

        /* renamed from: b */
        public final void mo27443b(C5447b bVar) {
            MessageFragment.this.getActivity().getWindow().setFlags(0, 128);
            MessageFragment.m22576d(MessageFragment.this);
        }
    };
    /* renamed from: p */
    private Observer<List<IMMessage>> f17895p = new Observer<List<IMMessage>>() {
        public final /* synthetic */ void onEvent(Object obj) {
            List list = (List) obj;
            if (list != null && !list.isEmpty()) {
                MessageFragment.this.f17884e.mo27706a(list);
                MessageFragment.this.onReceiveMessage(list);
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22572a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeReceiveMessage(this.f17895p, z);
        C6185c.m24534a((C5591b) z ? this : null);
    }

    /* renamed from: b */
    private void m22573b() {
        if (this.f17892m != null) {
            SensorManager sensorManager = this.f17891l;
            if (sensorManager != null) {
                SensorEventListener sensorEventListener = this.f17888i;
                if (sensorEventListener != null) {
                    sensorManager.unregisterListener(sensorEventListener);
                }
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m22574b(MessageFragment messageFragment) {
        C5570b bVar = messageFragment.f17884e;
        if (bVar == null) {
            messageFragment.f17884e = new C5570b(messageFragment.f17885f, messageFragment.f17880a);
        } else {
            bVar.mo27702a(messageFragment.f17885f);
        }
        C5608e eVar = messageFragment.f17883d;
        if (eVar == null) {
            messageFragment.f17883d = new C5608e(messageFragment.f17885f, messageFragment.f17880a, messageFragment.f17890k);
        } else {
            eVar.mo27770a(messageFragment.f17885f);
        }
        C5490a aVar = messageFragment.f17890k;
        if (aVar != null) {
            messageFragment.f17883d.mo27768a(aVar.f17682c);
            messageFragment.f17884e.mo27705a(messageFragment.f17890k.f17680a, messageFragment.f17890k.f17681b);
            return;
        }
        messageFragment.f17884e.mo27705a((String) null, 0);
        messageFragment.f17883d.mo27768a(0);
    }

    /* renamed from: c */
    static /* synthetic */ void m22575c(MessageFragment messageFragment) {
        if (messageFragment.getActivity() != null) {
            messageFragment.getActivity().getWindow().setFlags(32768, 32768);
            messageFragment.getActivity().getWindow().setFlags(1024, 1024);
            if (messageFragment.f17889j == null) {
                View.inflate(messageFragment.getActivity(), C5961R.C5964layout.ysf_screen_lock_layout, (ViewGroup) messageFragment.getActivity().getWindow().getDecorView());
                messageFragment.f17889j = messageFragment.getActivity().findViewById(C5961R.C5963id.screen_lock_layout);
            }
            messageFragment.f17889j.setVisibility(0);
            if (!C6014b.m23965j()) {
                messageFragment.getActivity();
                if (C5518b.m22478i().mo27437f()) {
                    messageFragment.getActivity().setVolumeControlStream(0);
                }
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m22576d(MessageFragment messageFragment) {
        if (messageFragment.getActivity() != null) {
            View view = messageFragment.f17889j;
            if (view != null && view.getVisibility() != 8) {
                boolean g = messageFragment.f17884e.mo27714g();
                messageFragment.getActivity().getWindow().setFlags(0, 32768);
                messageFragment.getActivity().getWindow().clearFlags(1024);
                if (VERSION.SDK_INT >= 14) {
                    messageFragment.getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
                }
                View view2 = messageFragment.f17889j;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (g) {
                    messageFragment.f17884e.mo27715h();
                }
                if (!C6014b.m23965j()) {
                    messageFragment.getActivity();
                    if (C5518b.m22478i().mo27438g()) {
                        messageFragment.getActivity().setVolumeControlStream(3);
                        messageFragment.f17884e.mo27708b(C5961R.string.ysf_audio_switch_to_speaker);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27680a() {
        this.f17884e.mo27702a(this.f17885f);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27681a(String str) {
        this.f17886g = str;
        this.f17885f.f17922c = str;
        ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(str, this.f17887h);
    }

    public boolean isAllowSendMessage(boolean z) {
        return true;
    }

    public boolean isLongClickEnabled() {
        return !this.f17883d.mo27779e();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f17881b = (TextView) this.f17880a.findViewById(C5961R.C5963id.message_tips_label);
        this.f17881b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f17882c = (LinearLayout) this.f17880a.findViewById(C5961R.C5963id.ll_message_fragment_ad);
        this.f17886g = getArguments().getString("account");
        if (TextUtils.isEmpty(this.f17886g)) {
            this.f17886g = C6014b.m23942c();
        }
        if (TextUtils.isEmpty(this.f17886g) && C5718b.m23018e() != null) {
            this.f17886g = C6185c.m24533a();
        }
        this.f17887h = (SessionTypeEnum) getArguments().getSerializable("type");
        this.f17890k = (C5490a) getArguments().getSerializable("customization");
        this.f17885f = new C5567a(this, this.f17886g, this.f17887h, this);
        if (C6029d.m24038b()) {
            this.f17893n.mo27687a();
        } else {
            C6029d.m24031a(this.f17893n);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f17883d.mo27769a(i, i2, intent);
        this.f17884e.mo27701a(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C5608e eVar = this.f17883d;
        if (eVar != null) {
            eVar.mo27780f();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17880a = layoutInflater.inflate(C5961R.C5964layout.ysf_message_fragment, viewGroup, false);
        return this.f17880a;
    }

    public void onDestroy() {
        C5570b bVar = this.f17884e;
        if (bVar != null) {
            bVar.mo27710c();
        }
        m22573b();
        if (C6029d.m24038b()) {
            m22572a(false);
        }
        C6029d.m24037b(this.f17893n);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        C5608e eVar = this.f17883d;
        if (eVar != null) {
            eVar.mo27776c();
        }
        C5570b bVar = this.f17884e;
        if (bVar != null) {
            bVar.mo27712e();
        }
        getActivity();
        C5518b.m22478i().mo27436e();
        getActivity();
        C5518b.m22478i().mo27432b(this.f17894o);
        m22573b();
        if (C6029d.m24038b()) {
            ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(MsgService.MSG_CHATTING_ACCOUNT_NONE, SessionTypeEnum.None);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveMessage(List<IMMessage> list) {
    }

    public void onResume() {
        FragmentActivity fragmentActivity;
        super.onResume();
        C5570b bVar = this.f17884e;
        if (bVar != null) {
            bVar.mo27711d();
        }
        C5608e eVar = this.f17883d;
        if (eVar != null) {
            eVar.mo27773b();
        }
        C5570b bVar2 = this.f17884e;
        if (bVar2 != null) {
            bVar2.mo27713f();
        }
        getActivity();
        C5518b.m22478i().mo27428a(this.f17894o);
        if (this.f17891l == null) {
            this.f17891l = (SensorManager) getActivity().getSystemService("sensor");
            this.f17892m = this.f17891l.getDefaultSensor(8);
            this.f17888i = new SensorEventListener() {
                public final void onAccuracyChanged(Sensor sensor, int i) {
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() == 8) {
                        float f = sensorEvent.values[0];
                        if (f >= 5.0f || f >= sensorEvent.sensor.getMaximumRange()) {
                            MessageFragment.m22576d(MessageFragment.this);
                        } else {
                            MessageFragment.this.getActivity();
                            if (C5518b.m22478i().mo27435d()) {
                                MessageFragment.m22575c(MessageFragment.this);
                            }
                        }
                    }
                }
            };
        }
        Sensor sensor = this.f17892m;
        int i = 3;
        if (sensor != null) {
            SensorManager sensorManager = this.f17891l;
            if (sensorManager != null) {
                SensorEventListener sensorEventListener = this.f17888i;
                if (sensorEventListener != null) {
                    sensorManager.registerListener(sensorEventListener, sensor, 3);
                }
            }
        }
        if (C6014b.m23965j()) {
            fragmentActivity = getActivity();
            i = 0;
        } else {
            fragmentActivity = getActivity();
        }
        fragmentActivity.setVolumeControlStream(i);
        if (C6029d.m24038b()) {
            ((MsgService) NIMClient.getService(MsgService.class)).setChattingAccount(this.f17886g, this.f17887h);
            if (C6029d.m24047g().mo29311m(this.f17885f.f17922c) != null && C6029d.m24047g().mo29301f(this.f17886g) == 0) {
                C6160p pVar = new C6160p();
                pVar.mo29227a(String.valueOf(C6029d.m24047g().mo29295c(this.f17886g)));
                C6185c.m24532a(pVar, this.f17886g, true);
            }
        }
    }

    public boolean sendMessage(IMMessage iMMessage, boolean z) {
        if (!isAllowSendMessage(true)) {
            return false;
        }
        ((MsgService) NIMClient.getService(MsgService.class)).sendMessage(iMMessage, z, true);
        if (!z) {
            this.f17884e.mo27704a(iMMessage);
        }
        return true;
    }

    public void shouldCollapseInputPanel() {
        this.f17883d.mo27778d();
    }
}
