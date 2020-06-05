package com.kwad.sdk.reward;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.kwad.sdk.p306a.C3809l;

/* renamed from: com.kwad.sdk.reward.d */
public class C4537d extends DialogFragment {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4541a f14782a;

    /* renamed from: com.kwad.sdk.reward.d$a */
    public interface C4541a {
        /* renamed from: a */
        void mo24810a();

        /* renamed from: b */
        void mo24811b();

        /* renamed from: c */
        void mo24812c();
    }

    /* renamed from: a */
    public static C4537d m18429a(Activity activity, String str, C4541a aVar) {
        C4537d dVar = new C4537d();
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        dVar.setArguments(bundle);
        dVar.m18430a(aVar);
        dVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return dVar;
    }

    /* renamed from: a */
    private void m18430a(C4541a aVar) {
        this.f14782a = aVar;
    }

    /* renamed from: a */
    public boolean mo24819a() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window != null) {
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            C4541a aVar = this.f14782a;
            if (aVar != null) {
                aVar.mo24810a();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(C3809l.m15792b(getActivity(), "ksad_video_close_dialog"), viewGroup, false);
        ((TextView) inflate.findViewById(C3809l.m15789a(getActivity(), "ksad_title"))).setText(getArguments().getString("key_title"));
        inflate.findViewById(C3809l.m15789a(getActivity(), "ksad_close_btn")).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4537d.this.dismiss();
                if (C4537d.this.f14782a != null) {
                    C4537d.this.f14782a.mo24811b();
                }
            }
        });
        inflate.findViewById(C3809l.m15789a(getActivity(), "ksad_continue_btn")).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C4537d.this.dismiss();
                if (C4537d.this.f14782a != null) {
                    C4537d.this.f14782a.mo24812c();
                }
            }
        });
        getDialog().setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return inflate;
    }
}
