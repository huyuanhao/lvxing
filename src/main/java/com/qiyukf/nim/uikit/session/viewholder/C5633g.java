package com.qiyukf.nim.uikit.session.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nim.uikit.session.activity.WatchMessagePictureActivity;
import com.qiyukf.nim.uikit.session.helper.C5556b;
import com.qiyukf.nimlib.p488k.p490b.C5940b.C5941a;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.g */
public class C5633g extends C5637i {
    /* renamed from: a */
    protected TextView f18134a;
    /* renamed from: b */
    protected String f18135b;
    /* renamed from: c */
    protected OnClickListener f18136c = new OnClickListener() {
        public final void onClick(View view) {
            C5556b.m22584a(C5633g.this.context, C5633g.this.f18135b, "");
        }
    };

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final String mo27823a(String str) {
        return str;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27824a(C5941a aVar) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (TextUtils.isEmpty(this.f18135b)) {
            layoutParams.gravity = 16;
            this.f18147d.setLayoutParams(layoutParams);
            setLayoutParams(aVar.f18757a, aVar.f18758b, this.f18149f);
            return;
        }
        layoutParams.gravity = 48;
        this.f18147d.setLayoutParams(layoutParams);
        setLayoutParams(aVar.f18757a, aVar.f18758b + TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, this.f18149f);
        setLayoutParams(aVar.f18757a, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, this.f18134a);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final int[] mo27825a() {
        ImageAttachment imageAttachment = (ImageAttachment) this.message.getAttachment();
        return new int[]{imageAttachment.getWidth(), imageAttachment.getHeight()};
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        super.bindContentView();
        JSONObject f = C5366b.m22040f(this.message.getExtension(), "action");
        if (f != null) {
            this.f18134a.setVisibility(0);
            String str = "label";
            if (!TextUtils.isEmpty(C5366b.m22039e(f, str))) {
                this.f18134a.setText(C5366b.m22039e(f, str));
            } else {
                this.f18134a.setText("知道了");
            }
            this.f18135b = C5366b.m22039e(f, "url");
            if (!TextUtils.isEmpty(this.f18135b)) {
                this.f18134a.setOnClickListener(this.f18136c);
            } else {
                this.f18134a.setOnClickListener(null);
            }
        } else {
            this.f18134a.setOnClickListener(null);
            this.f18134a.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_picture;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.f18134a = (TextView) findViewById(C5961R.C5963id.tv_nim_message_item_thumb_button);
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (IMMessage iMMessage : getAdapter().mo27381a()) {
            if (iMMessage.getMsgType() == MsgTypeEnum.image) {
                if (iMMessage.isTheSame(this.message)) {
                    i = arrayList.size();
                }
                arrayList.add(iMMessage);
            }
        }
        WatchMessagePictureActivity.start(this.context, arrayList, i);
    }
}
