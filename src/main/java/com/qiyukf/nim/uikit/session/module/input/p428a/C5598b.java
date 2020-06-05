package com.qiyukf.nim.uikit.session.module.input.p428a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.nim.uikit.common.p419a.C5439f;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f.C6125a;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.a.b */
public class C5598b extends C5439f<C6125a> {
    /* renamed from: a */
    private TextView f18022a;

    /* access modifiers changed from: protected */
    public int getResId() {
        return C5961R.C5964layout.ysf_view_holder_faq_list;
    }

    public void inflate() {
        this.f18022a = (TextView) findView(C5961R.C5963id.ysf_tv_faq_list_item);
    }

    public /* synthetic */ void refresh(Object obj) {
        String str = (String) getAdapter().mo27385c();
        String a = ((C6125a) obj).mo29111a();
        int color = ContextCompat.getColor(this.context, C5961R.color.ysf_red_f25058);
        SpannableString spannableString = new SpannableString(a);
        int indexOf = TextUtils.isEmpty(str) ? -1 : a.toLowerCase().indexOf(str.toLowerCase());
        if (indexOf >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(color), indexOf, str.length() + indexOf, 33);
        }
        this.f18022a.setText(spannableString);
    }
}
