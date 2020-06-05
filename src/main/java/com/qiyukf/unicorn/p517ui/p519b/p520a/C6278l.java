package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.session.helper.C5554a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6092i;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6092i.C6093a;
import com.qiyukf.unicorn.p516j.C6211c;
import com.qiyukf.unicorn.p517ui.activity.UrlImagePreviewActivity;
import java.util.ArrayList;

/* renamed from: com.qiyukf.unicorn.ui.b.a.l */
public class C6278l extends C6257e {
    /* renamed from: a */
    private LinearLayout f19577a;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        View view;
        this.f19577a.removeAllViews();
        C6092i iVar = (C6092i) this.message.getAttachment();
        for (int i = 0; i < iVar.mo28988c().size(); i++) {
            final C6093a aVar = (C6093a) iVar.mo28988c().get(i);
            if (aVar.mo28989a()) {
                ImageView imageView = (ImageView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_image, this.f19577a, false);
                C5426a.m22178a(aVar.mo28994f(), imageView);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(aVar.mo28994f());
                        UrlImagePreviewActivity.start(C6278l.this.context, arrayList, 0);
                    }
                });
                view = imageView;
            } else if (aVar.mo28991c() || aVar.mo28990b()) {
                TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_button, this.f19577a, false);
                textView.setText(aVar.mo28993e());
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (aVar.mo28991c()) {
                            C6278l.this.mo29450a(aVar.mo28995g(), aVar.mo28996h(), aVar.mo28993e());
                        } else {
                            C6278l.this.mo29448a(aVar.mo28995g());
                        }
                    }
                });
                view = textView;
            } else if (aVar.mo28992d()) {
                TextView textView2 = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_text, this.f19577a, false);
                C6211c.m24639a(textView2, aVar.mo28993e(), (int) textView2.getResources().getDimension(C5961R.dimen.ysf_bubble_content_rich_image_max_width), this.message.getSessionId());
                textView2.setOnTouchListener(C5554a.m22582a());
                view = textView2;
            } else {
                TextView textView3 = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_text, this.f19577a, false);
                textView3.setText(aVar.mo28993e());
                view = textView3;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i > 0) {
                layoutParams.setMargins(0, C5412d.m22146a(10.0f), 0, 0);
            }
            this.f19577a.addView(view);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_mix;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19577a = (LinearLayout) findViewById(C5961R.C5963id.ysf_message_mix_container);
    }
}
