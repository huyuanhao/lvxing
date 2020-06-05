package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f.C6085a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6105a;
import com.qiyukf.unicorn.p517ui.activity.UrlImagePreviewActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.ui.b.a.i */
public class C6271i extends C6257e {
    /* renamed from: a */
    private LinearLayout f19555a;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        View view;
        this.f19555a.removeAllViews();
        List d = ((C6105a) this.message.getAttachment()).mo29041d();
        if (d != null) {
            for (int i = 0; i < d.size(); i++) {
                C6085a aVar = (C6085a) d.get(i);
                if (aVar.mo28966e()) {
                    view = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_form_request_item_image, this.f19555a, false);
                    TextView textView = (TextView) view.findViewById(C5961R.C5963id.ysf_message_form_item_label);
                    View findViewById = view.findViewById(C5961R.C5963id.ysf_message_form_item_image_layout);
                    FileNameTextView fileNameTextView = (FileNameTextView) view.findViewById(C5961R.C5963id.ysf_message_form_item_image_name);
                    TextView textView2 = (TextView) view.findViewById(C5961R.C5963id.ysf_message_form_item_image_size);
                    textView.setText(aVar.mo28964c());
                    JSONObject h = aVar.mo28969h();
                    if (h == null) {
                        findViewById.setVisibility(8);
                    } else {
                        findViewById.setVisibility(0);
                        fileNameTextView.mo29556a(C5366b.m22039e(h, ArgKey.KEY_NAME));
                        textView2.setText(C5363b.m22022a(C5366b.m22037c(h, AppEntity.KEY_SIZE_LONG)));
                        final String e = C5366b.m22039e(h, "url");
                        findViewById.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                ArrayList arrayList = new ArrayList(1);
                                arrayList.add(e);
                                UrlImagePreviewActivity.start(C6271i.this.context, arrayList, 0);
                            }
                        });
                    }
                } else {
                    view = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_form_request_item_text, this.f19555a, false);
                    TextView textView3 = (TextView) view.findViewById(C5961R.C5963id.ysf_message_form_item_text_value);
                    ((TextView) view.findViewById(C5961R.C5963id.ysf_message_form_item_label)).setText(aVar.mo28964c());
                    String g = aVar.mo28968g();
                    if (TextUtils.isEmpty(g)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        textView3.setText(g);
                    }
                }
                this.f19555a.addView(view);
                if (i < d.size() - 1) {
                    this.f19555a.addView(LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_include_divider, this.f19555a, false));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_form_request;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19555a = (LinearLayout) findViewById(C5961R.C5963id.ysf_message_form_request_container);
    }
}
