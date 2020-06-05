package com.qiyukf.unicorn.p517ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6104b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6108c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6079d;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6263g.C6264a;

/* renamed from: com.qiyukf.unicorn.ui.activity.CardPopupActivity */
public class CardPopupActivity extends BaseFragmentActivity {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public LinearLayout f19437b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public View f19438c;
    /* renamed from: d */
    private Observer<CustomNotification> f19439d = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof C6104b)) {
                C6104b bVar = (C6104b) customNotification.getAttachment();
                if (bVar.mo29038a() instanceof C6079d) {
                    CardPopupActivity.this.m24691a(false);
                    CardPopupActivity.this.f19438c.setVisibility(8);
                    C6079d dVar = (C6079d) bVar.mo29038a();
                    CardPopupActivity.this.setTitle((CharSequence) dVar.mo28939c());
                    new C6264a(CardPopupActivity.this.f19437b).mo29468a(dVar.mo28940d());
                }
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24691a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f19439d, z);
    }

    public static void start(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, CardPopupActivity.class);
        intent.putExtra("extra_exchange", str);
        intent.putExtra("extra_target", str2);
        intent.putExtra("extra_params", str3);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_activity_card_popup);
        setTitle(C5961R.string.ysf_loading);
        this.f19437b = (LinearLayout) findViewById(C5961R.C5963id.ysf_card_detail_container);
        this.f19438c = findViewById(C5961R.C5963id.ysf_card_popup_progress);
        this.f19438c.setVisibility(0);
        String stringExtra = getIntent().getStringExtra("extra_exchange");
        String stringExtra2 = getIntent().getStringExtra("extra_target");
        String stringExtra3 = getIntent().getStringExtra("extra_params");
        m24691a(true);
        C6108c cVar = new C6108c();
        cVar.mo29049a(stringExtra2);
        cVar.mo29050b(stringExtra3);
        C6185c.m24532a(cVar, stringExtra, false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i != 200) {
                    C5415g.m22161a(C5961R.string.ysf_network_broken);
                    CardPopupActivity.this.finish();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m24691a(false);
        super.onDestroy();
    }
}
