package com.qiyukf.unicorn.p517ui.p519b;

import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.widget.TextView;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.viewholder.C5635h;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6130k;
import com.qiyukf.unicorn.p516j.C6211c;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xml.sax.XMLReader;

/* renamed from: com.qiyukf.unicorn.ui.b.d */
public class C6303d extends C5635h {
    /* renamed from: e */
    private C6130k f19672e;

    /* renamed from: com.qiyukf.unicorn.ui.b.d$a */
    class C6304a implements TagHandler {
        C6304a() {
        }

        public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if ("html".equals(str)) {
                HashMap a = C6303d.m24832b(xMLReader);
                String str2 = "src";
                if (a.get(str2) != null) {
                    String str3 = "title";
                    if (a.get(str3) == null) {
                        C5426a.m22178a((String) a.get(str2), C6303d.this.f18140c);
                        C6303d.this.f18140c.setVisibility(0);
                        C6303d.this.f18139b.setVisibility(8);
                    } else if (!((String) a.get(str3)).endsWith(".gif") && !((String) a.get(str3)).endsWith(".GIF")) {
                        C5426a.m22178a((String) a.get(str2), C6303d.this.f18140c);
                        C6303d.this.f18140c.setVisibility(0);
                        C6303d.this.f18139b.setVisibility(8);
                    } else if (C6029d.m24045e() == null || C6029d.m24045e().gifImageLoader == null) {
                        C5426a.m22178a((String) a.get(str2), C6303d.this.f18140c);
                        C6303d.this.f18140c.setVisibility(0);
                        C6303d.this.f18139b.setVisibility(8);
                    } else {
                        C6029d.m24045e().gifImageLoader.loadGifImage((String) a.get(str2), C6303d.this.f18139b, (String) a.get(str3));
                        C6303d.this.f18140c.setVisibility(8);
                        C6303d.this.f18139b.setVisibility(0);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m24830a(C6130k kVar) {
        return (kVar == null || kVar.mo29123a() == null || (!kVar.mo29123a().startsWith("<img") && !kVar.mo29123a().startsWith("<IMG"))) ? false : true;
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static HashMap<String, String> m24832b(XMLReader xMLReader) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("data");
            declaredField3.setAccessible(true);
            String[] strArr = (String[]) declaredField3.get(obj2);
            Field declaredField4 = obj2.getClass().getDeclaredField("length");
            declaredField4.setAccessible(true);
            int intValue = ((Integer) declaredField4.get(obj2)).intValue();
            for (int i = 0; i < intValue; i++) {
                int i2 = i * 5;
                hashMap.put(strArr[i2 + 1], strArr[i2 + 4]);
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final int mo27827a() {
        if (m24830a(this.f19672e)) {
            return 0;
        }
        return super.mo27827a();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27828a(TextView textView) {
        int dimension = (int) textView.getResources().getDimension(C5961R.dimen.ysf_bubble_content_rich_image_max_width);
        if (m24830a(this.f19672e)) {
            this.f18138a.setVisibility(8);
            Html.fromHtml(this.f19672e.mo29123a(), null, new C6304a());
        } else if (C5543f.m22547a(this.f19672e.mo29123a())) {
            this.f18138a.setText(C5543f.m22543a(this.context, (CharSequence) this.f19672e.mo29123a(), this.f18138a));
            this.f18138a.setVisibility(0);
            this.f18139b.setVisibility(8);
            this.f18140c.setVisibility(8);
        } else {
            C6211c.m24639a(textView, this.f19672e.mo29123a(), dimension, this.message.getSessionId());
            this.f18138a.setVisibility(0);
            this.f18139b.setVisibility(8);
            this.f18140c.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final int mo27829b() {
        if (m24830a(this.f19672e)) {
            return 0;
        }
        return super.mo27829b();
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        this.f19672e = (C6130k) this.message.getAttachment();
        super.bindContentView();
    }
}
