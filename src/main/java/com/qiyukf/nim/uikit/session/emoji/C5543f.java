package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.helper.C5556b;
import com.qiyukf.unicorn.p516j.C6226i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.f */
public final class C5543f {
    /* renamed from: a */
    private static Pattern f17858a = Pattern.compile("<a\\s+([^>]*)>([^<]*)</a>");
    /* renamed from: b */
    private static Pattern f17859b = Pattern.compile("href\\s*=\\s*(\\S*)");

    /* renamed from: com.qiyukf.nim.uikit.session.emoji.f$a */
    private static class C5544a extends C5556b {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f17860a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f17861b;
        /* renamed from: c */
        private String f17862c;

        public C5544a(Context context, String str, String str2, String str3) {
            super(context, str2);
            this.f17862c = str;
            mo27694a(str3);
        }

        /* renamed from: a */
        public final String mo27658a() {
            return this.f17862c;
        }

        /* renamed from: a */
        public final void mo27659a(int i, int i2) {
            this.f17860a = i;
            this.f17861b = i2;
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: a */
    private static Drawable m22541a(Context context, CharSequence charSequence, float f) {
        Drawable a = C5531b.m22510a(context, charSequence.toString());
        if (a != null) {
            a.setBounds(0, 0, (int) (((float) a.getIntrinsicWidth()) * f), (int) (((float) a.getIntrinsicHeight()) * f));
        }
        return a;
    }

    /* renamed from: a */
    public static SpannableString m22542a(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        Matcher matcher = C5531b.m22513b().matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Drawable a = m22541a(context, charSequence.subSequence(start, end), 0.6f);
            if (a != null) {
                spannableString.setSpan(new ImageSpan(a, 0), start, end, 33);
            }
        }
        return spannableString;
    }

    /* renamed from: a */
    public static SpannableString m22543a(Context context, CharSequence charSequence, TextView textView) {
        Object imageSpan;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        if (textView == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        Matcher matcher = C5531b.m22513b().matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            CharSequence subSequence = charSequence.subSequence(start, end);
            if (!TextUtils.isEmpty(m22549b(subSequence))) {
                imageSpan = new C6226i(context, m22549b(subSequence), textView);
            } else {
                Drawable a = m22541a(context, subSequence, 0.6f);
                if (a != null) {
                    imageSpan = new ImageSpan(a, 0);
                }
            }
            spannableString.setSpan(imageSpan, start, end, 33);
        }
        return spannableString;
    }

    /* renamed from: a */
    public static SpannableString m22544a(Context context, String str, String str2) {
        return m22542a(context, m22548b(context, str, str2));
    }

    /* renamed from: a */
    public static void m22545a(Context context, Editable editable, int i, int i2) {
        if (i2 > 0) {
            int i3 = i2 + i;
            if (editable.length() >= i3) {
                Matcher matcher = C5531b.m22513b().matcher(editable.subSequence(i, i3));
                while (matcher.find()) {
                    int start = matcher.start() + i;
                    int end = matcher.end() + i;
                    Drawable a = m22541a(context, (CharSequence) editable.subSequence(start, end).toString(), 0.45f);
                    if (a != null) {
                        editable.setSpan(new ImageSpan(a, 0), start, end, 33);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m22546a(Context context, TextView textView, String str, String str2) {
        SpannableString a = m22544a(context, str, str2);
        if (textView != null) {
            textView.setText(a);
        }
    }

    /* renamed from: a */
    public static boolean m22547a(CharSequence charSequence) {
        Matcher matcher = Pattern.compile("\\[:[^\\[\\]]{1,10}\\]").matcher(charSequence);
        while (matcher.find()) {
            if (charSequence.subSequence(matcher.start(), matcher.end()) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static SpannableString m22548b(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            str = str3;
        }
        Matcher matcher = f17858a.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String str4 = null;
            Matcher matcher2 = f17859b.matcher(group);
            if (matcher2.find()) {
                str4 = matcher2.group(1).replace("\"", str3).replace("'", str3);
            }
            C5544a aVar = new C5544a(context, group2, str4, str2);
            aVar.mo27659a(start, end);
            arrayList.add(aVar);
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C5544a aVar2 = (C5544a) it.next();
                sb.append(str.subSequence(i, aVar2.f17860a));
                sb.append(aVar2.mo27658a());
                i = aVar2.f17861b;
                aVar2.f17861b = sb.length();
                aVar2.f17860a = aVar2.f17861b - aVar2.mo27658a().length();
            }
            sb.append(str.subSequence(i, str.length()));
            str = sb.toString();
        }
        SpannableString spannableString = new SpannableString(str);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C5544a aVar3 = (C5544a) it2.next();
            spannableString.setSpan(aVar3, aVar3.f17860a, aVar3.f17861b, 33);
        }
        return spannableString;
    }

    /* renamed from: b */
    private static String m22549b(CharSequence charSequence) {
        return C5548i.m22560a().mo27671a(charSequence.toString());
    }
}
