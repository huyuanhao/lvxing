package com.qiyukf.unicorn.p517ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;

/* renamed from: com.qiyukf.unicorn.ui.fragment.TranslateFragment */
public class TranslateFragment extends TFragment {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Button f19783a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public TextView f19784b;
    /* renamed from: c */
    private ProgressBar f19785c;
    /* renamed from: d */
    private AudioAttachment f19786d;
    /* renamed from: e */
    private AbortableFuture<String> f19787e;
    /* renamed from: f */
    private RequestCallbackWrapper<String> f19788f = new RequestCallbackWrapper<String>() {
        public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
            String str = (String) obj;
            TranslateFragment.m24966b(TranslateFragment.this);
            if (i == 200) {
                TranslateFragment.this.f19784b.setTextSize(22.0f);
                TranslateFragment.this.f19784b.setText(str);
                return;
            }
            TranslateFragment.m24968d(TranslateFragment.this);
        }
    };

    /* renamed from: b */
    static /* synthetic */ void m24966b(TranslateFragment translateFragment) {
        translateFragment.f19785c.setVisibility(8);
        translateFragment.f19783a.setVisibility(8);
    }

    /* renamed from: d */
    static /* synthetic */ void m24968d(TranslateFragment translateFragment) {
        Drawable drawable = ContextCompat.getDrawable(translateFragment.getContext(), C5961R.C5962drawable.ysf_ic_failed);
        int a = C5412d.m22146a(24.0f);
        drawable.setBounds(0, 0, a, a);
        translateFragment.f19784b.setCompoundDrawables(drawable, null, null, null);
        translateFragment.f19784b.setCompoundDrawablePadding(C5412d.m22146a(6.0f));
        translateFragment.f19784b.setText(translateFragment.getString(C5961R.string.ysf_audio_translate_failed));
        translateFragment.f19784b.setTextSize(15.0f);
    }

    public static TranslateFragment newInstance(IMMessage iMMessage) {
        TranslateFragment translateFragment = new TranslateFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, iMMessage);
        translateFragment.setArguments(bundle);
        return translateFragment;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null) {
            this.f19783a.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TranslateFragment.this.getActivity().onBackPressed();
                }
            });
            if (getView() != null) {
                getView().setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (TranslateFragment.this.f19783a.getVisibility() == 8) {
                            TranslateFragment.this.getActivity().onBackPressed();
                        }
                    }
                });
            }
        }
        AudioAttachment audioAttachment = this.f19786d;
        this.f19787e = ((MsgService) NIMClient.getService(MsgService.class)).transVoiceToText(audioAttachment.getUrl(), audioAttachment.getPath(), audioAttachment.getDuration());
        this.f19787e.setCallback(this.f19788f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            IMMessage iMMessage = (IMMessage) getArguments().getSerializable(NotificationCompat.CATEGORY_MESSAGE);
            if (iMMessage != null) {
                this.f19786d = (AudioAttachment) iMMessage.getAttachment();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C5961R.C5964layout.ysf_fragment_translate, viewGroup, false);
        this.f19783a = (Button) inflate.findViewById(C5961R.C5963id.ysf_translate_cancel_button);
        this.f19784b = (TextView) inflate.findViewById(C5961R.C5963id.ysf_translated_text);
        this.f19785c = (ProgressBar) inflate.findViewById(C5961R.C5963id.ysf_message_item_progress);
        return inflate;
    }

    public void onDetach() {
        if (this.f19783a.getVisibility() == 0) {
            AbortableFuture<String> abortableFuture = this.f19787e;
            if (abortableFuture != null) {
                abortableFuture.abort();
            }
        }
        super.onDetach();
    }
}
