package com.qiyukf.unicorn.p517ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.unicorn.ui.activity.LeaveMessageDetailActivity */
public class LeaveMessageDetailActivity extends BaseFragmentActivity {
    public static void start(Context context, String str) {
        Intent intent = new Intent(context, LeaveMessageDetailActivity.class);
        intent.putExtra("leave_message", str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final boolean mo27413b() {
        return false;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final boolean mo27414c() {
        return true;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, C5961R.anim.ysf_anim_popup_out);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_activity_leave_message_detail);
        String stringExtra = getIntent().getStringExtra("leave_message");
        if (stringExtra == null) {
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(C5961R.C5963id.ysf_leave_message_text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(stringExtra);
        mo27409a(C5961R.string.ysf_close).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LeaveMessageDetailActivity.this.finish();
            }
        });
    }
}
