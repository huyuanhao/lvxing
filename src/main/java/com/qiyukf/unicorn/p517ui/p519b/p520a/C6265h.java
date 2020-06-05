package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.session.helper.C5563d.C5564a;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5966a;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f.C6085a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6105a;
import com.qiyukf.unicorn.p517ui.activity.UrlImagePreviewActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.ui.b.a.h */
public class C6265h extends C6257e implements OnDismissListener, OnClickListener {
    /* renamed from: a */
    private static String f19526a;
    /* renamed from: b */
    private TextView f19527b;
    /* renamed from: c */
    private View f19528c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Dialog f19529d;
    /* renamed from: e */
    private View f19530e;
    /* renamed from: f */
    private View f19531f;
    /* renamed from: g */
    private Button f19532g;
    /* renamed from: h */
    private C6084f f19533h;
    /* renamed from: i */
    private List<C6085a> f19534i;
    /* renamed from: j */
    private final List<C6270c> f19535j = new ArrayList();

    /* renamed from: com.qiyukf.unicorn.ui.b.a.h$a */
    private class C6266a extends C6270c implements OnClickListener {
        /* renamed from: e */
        private Button f19537e = ((Button) this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_image_select));
        /* renamed from: f */
        private View f19538f = this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_image_layout);
        /* renamed from: g */
        private FileNameTextView f19539g = ((FileNameTextView) this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_image_name));
        /* renamed from: h */
        private TextView f19540h = ((TextView) this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_image_size));
        /* renamed from: i */
        private View f19541i = this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_image_delete);
        /* access modifiers changed from: private */
        /* renamed from: j */
        public String f19542j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public boolean f19543k;
        /* renamed from: l */
        private C5564a f19544l = new C5564a() {
            public final void sendImage(File file, String str, boolean z) {
                C6266a aVar = C6266a.this;
                StringBuilder sb = new StringBuilder("file://");
                sb.append(file.getPath());
                aVar.f19542j = sb.toString();
                C6266a.this.f19543k = true;
                C6266a.m24774a(C6266a.this);
                FileAttachment fileAttachment = new FileAttachment();
                fileAttachment.setPath(file.getPath());
                fileAttachment.setSize(file.length());
                fileAttachment.setDisplayName(str);
                ((MsgService) NIMClient.getService(MsgService.class)).sendFile(fileAttachment).setCallback(new RequestCallbackWrapper<FileAttachment>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        FileAttachment fileAttachment = (FileAttachment) obj;
                        if (C6266a.this.f19550b.getTag() == C6265h.this.f19529d) {
                            C6266a.this.f19543k = false;
                            C6266a.m24774a(C6266a.this);
                            if (i == 200) {
                                JSONObject jSONObject = new JSONObject();
                                C5366b.m22032a(jSONObject, ArgKey.KEY_NAME, fileAttachment.getDisplayName());
                                C5366b.m22030a(jSONObject, AppEntity.KEY_SIZE_LONG, fileAttachment.getSize());
                                C5366b.m22032a(jSONObject, "url", fileAttachment.getUrl());
                                C6266a.this.f19551c.mo28962a(jSONObject);
                                C6266a.this.m24777c();
                                return;
                            }
                            C5415g.m22161a(C5961R.string.ysf_bot_form_upload_image_failed);
                        }
                    }
                });
            }
        };

        public C6266a(ViewGroup viewGroup) {
            super(viewGroup);
        }

        /* renamed from: a */
        static /* synthetic */ void m24774a(C6266a aVar) {
            aVar.f19537e.setText(aVar.f19543k ? C5961R.string.ysf_bot_form_uploading_image : C5961R.string.ysf_bot_form_upload_image);
            aVar.f19537e.setEnabled(!aVar.f19543k);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m24777c() {
            JSONObject h = this.f19551c.mo28969h();
            if (h == null) {
                this.f19537e.setVisibility(0);
                this.f19538f.setVisibility(8);
                return;
            }
            this.f19537e.setVisibility(8);
            this.f19538f.setVisibility(0);
            String e = C5366b.m22039e(h, ArgKey.KEY_NAME);
            String a = C5363b.m22022a(C5366b.m22037c(h, AppEntity.KEY_SIZE_LONG));
            this.f19539g.mo29556a(e);
            this.f19540h.setText(a);
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final int mo29471a() {
            return C5961R.C5964layout.ysf_message_item_form_notify_item_image;
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final void mo29472a(C6085a aVar) {
            super.mo29472a(aVar);
            this.f19537e.setOnClickListener(this);
            this.f19538f.setOnClickListener(this);
            this.f19541i.setOnClickListener(this);
            this.f19550b.setTag(C6265h.this.f19529d);
            m24777c();
        }

        public final void onClick(View view) {
            if (view == this.f19537e) {
                C6265h.this.getAdapter().mo27734d().mo27721a(this.f19544l);
                return;
            }
            if (view == this.f19538f) {
                if (!TextUtils.isEmpty(this.f19542j)) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(this.f19542j);
                    UrlImagePreviewActivity.start(C6265h.this.context, arrayList, 0);
                }
            } else if (view == this.f19541i) {
                this.f19542j = null;
                this.f19551c.mo28962a(null);
                m24777c();
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.ui.b.a.h$b */
    private class C6269b extends C6270c implements TextWatcher {
        /* renamed from: e */
        private EditText f19548e = ((EditText) this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_input_edit));

        public C6269b(ViewGroup viewGroup) {
            super(viewGroup);
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final int mo29471a() {
            return C5961R.C5964layout.ysf_message_item_form_notify_item_input;
        }

        /* access modifiers changed from: protected|final */
        /* renamed from: a */
        public final void mo29472a(C6085a aVar) {
            super.mo29472a(aVar);
            this.f19548e.addTextChangedListener(this);
            if (!TextUtils.isEmpty(aVar.mo28968g())) {
                this.f19548e.setText(aVar.mo28968g());
                EditText editText = this.f19548e;
                editText.setSelection(editText.length());
            }
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            String trim = obj.replace("&", "").trim();
            if (!TextUtils.equals(obj, trim)) {
                this.f19548e.setText(trim);
                this.f19548e.setSelection(trim.length());
            }
            this.f19551c.mo28962a(trim);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.qiyukf.unicorn.ui.b.a.h$c */
    private abstract class C6270c {
        /* renamed from: a */
        private TextView f19549a = ((TextView) this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_label));
        /* renamed from: b */
        protected View f19550b;
        /* renamed from: c */
        protected C6085a f19551c;
        /* renamed from: e */
        private View f19553e = this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_required);
        /* renamed from: f */
        private View f19554f = this.f19550b.findViewById(C5961R.C5963id.ysf_message_form_item_error);

        public C6270c(ViewGroup viewGroup) {
            this.f19550b = LayoutInflater.from(viewGroup.getContext()).inflate(mo29471a(), viewGroup, false);
        }

        /* renamed from: a */
        static /* synthetic */ boolean m24782a(C6270c cVar) {
            if (!cVar.f19551c.mo28965d()) {
                return true;
            }
            boolean i = cVar.f19551c.mo28970i();
            cVar.f19554f.setVisibility(i ? 8 : 0);
            return i;
        }

        /* renamed from: a */
        public abstract int mo29471a();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo29472a(C6085a aVar) {
            this.f19551c = aVar;
            this.f19549a.setText(aVar.mo28964c());
            this.f19553e.setVisibility(aVar.mo28965d() ? 0 : 8);
        }

        /* renamed from: b */
        public final View mo29477b() {
            return this.f19550b;
        }
    }

    /* renamed from: a */
    private void m24764a(Dialog dialog) {
        TextView textView = (TextView) dialog.findViewById(C5961R.C5963id.ysf_message_form_window_title);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(C5961R.C5963id.ysf_message_form_window_item_container);
        this.f19530e = dialog.findViewById(C5961R.C5963id.ysf_message_form_window_placeholder);
        this.f19531f = dialog.findViewById(C5961R.C5963id.ysf_message_form_window_close);
        this.f19532g = (Button) dialog.findViewById(C5961R.C5963id.ysf_message_form_window_submit);
        textView.setText(this.f19533h.mo28956c());
        this.f19530e.setOnClickListener(this);
        this.f19531f.setOnClickListener(this);
        this.f19532g.setOnClickListener(this);
        this.f19535j.clear();
        for (C6085a aVar : this.f19534i) {
            C6270c aVar2 = aVar.mo28966e() ? new C6266a(linearLayout) : new C6269b(linearLayout);
            aVar2.mo29472a(aVar);
            linearLayout.addView(aVar2.mo29477b());
            this.f19535j.add(aVar2);
        }
    }

    /* renamed from: b */
    public static void m24766b(String str) {
        if (f19526a == null) {
            f19526a = str;
        }
    }

    /* renamed from: d */
    private long m24768d() {
        try {
            return Long.valueOf(this.message.getUuid().substring(0, this.message.getUuid().indexOf(35))).longValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: e */
    private void m24769e() {
        if (TextUtils.equals(f19526a, this.message.getUuid()) && this.f19529d == null) {
            getAdapter().mo27734d().mo27724b();
            this.f19529d = new Dialog(this.context, C5961R.style.ysf_form_dialog_style);
            this.f19529d.setContentView(C5961R.C5964layout.ysf_popup_window_form);
            this.f19529d.setOnDismissListener(this);
            LayoutParams attributes = this.f19529d.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            m24764a(this.f19529d);
            this.f19529d.show();
        }
    }

    /* renamed from: f */
    private void m24770f() {
        Dialog dialog = this.f19529d;
        if (dialog != null) {
            C5409b.m22133b(dialog.getWindow().getDecorView());
            this.f19529d.dismiss();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        this.f19533h = (C6084f) this.message.getAttachment();
        this.f19534i = this.f19533h.mo28958e();
        this.f19527b.setText(this.f19533h.mo28956c());
        this.f19528c.setVisibility(this.f19533h.mo28959f() ? 8 : 0);
        this.f19528c.setOnClickListener(this);
        if (!this.f19533h.mo28959f()) {
            m24769e();
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final boolean mo29451b() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_form_notify;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19527b = (TextView) findViewById(C5961R.C5963id.ysf_message_form_title);
        this.f19528c = findViewById(C5961R.C5963id.ysf_message_form_expand);
    }

    public void onClick(View view) {
        if (view == this.f19528c) {
            long d = m24768d();
            if (d <= 0 || d != C6029d.m24047g().mo29295c(this.message.getSessionId())) {
                C5415g.m22161a(C5961R.string.ysf_bot_form_disabled);
                return;
            }
            if (f19526a == null) {
                f19526a = this.message.getUuid();
                m24769e();
            }
        } else if (view == this.f19530e || view == this.f19531f) {
            m24770f();
        } else {
            if (view == this.f19532g) {
                long d2 = m24768d();
                if (d2 <= 0 || d2 != C6029d.m24047g().mo29295c(this.message.getSessionId())) {
                    C5415g.m22161a(C5961R.string.ysf_bot_form_disabled);
                    m24770f();
                } else {
                    boolean z = true;
                    for (C6270c a : this.f19535j) {
                        if (!C6270c.m24782a(a)) {
                            z = false;
                        }
                    }
                    if (z) {
                        m24770f();
                        String str = "";
                        String d3 = this.f19533h.mo28957d() == null ? str : this.f19533h.mo28957d();
                        StringBuilder sb = new StringBuilder();
                        sb.append(d3);
                        sb.append("&msgIdClient=");
                        sb.append(this.message.getUuid());
                        String sb2 = sb.toString();
                        for (C6085a aVar : this.f19534i) {
                            String obj = aVar.mo28967f() == null ? str : aVar.mo28967f().toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(sb2);
                            sb3.append("&");
                            sb3.append(aVar.mo28961a());
                            sb3.append("=");
                            sb3.append(obj);
                            sb2 = sb3.toString();
                        }
                        C6105a aVar2 = new C6105a();
                        aVar2.mo29039a(this.f19534i);
                        C5969b bVar = new C5969b();
                        bVar.mo28521b(sb2);
                        bVar.mo28520a(aVar2.mo29040c());
                        aVar2.mo28536a(bVar);
                        getAdapter().mo27734d().mo27727c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, aVar2));
                        this.f19533h.mo28960g();
                        ((C5966a) this.f19533h.mo28535a()).mo28515a("hasCommit", Boolean.valueOf(true));
                        ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(this.message, true);
                    }
                }
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        f19526a = null;
        this.f19529d = null;
    }
}
