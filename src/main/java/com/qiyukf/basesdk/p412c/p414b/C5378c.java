package com.qiyukf.basesdk.p412c.p414b;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qiyukf.basesdk.p412c.p414b.p415a.C5375c;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

/* renamed from: com.qiyukf.basesdk.c.b.c */
final class C5378c implements TagHandler {
    /* renamed from: a */
    private static Pattern f17340a;
    /* renamed from: b */
    private static Pattern f17341b;
    /* renamed from: c */
    private static Pattern f17342c;
    /* renamed from: d */
    private static Pattern f17343d;
    /* renamed from: e */
    private static Pattern f17344e;
    /* renamed from: f */
    private static Pattern f17345f;
    /* renamed from: g */
    private static final Map<String, Integer> f17346g;
    /* renamed from: l */
    private static final BulletSpan f17347l = new BulletSpan(10);
    /* renamed from: h */
    private Context f17348h;
    /* renamed from: i */
    private TextPaint f17349i;
    /* renamed from: j */
    private Stack<String> f17350j = new Stack<>();
    /* renamed from: k */
    private Stack<Integer> f17351k = new Stack<>();

    /* renamed from: com.qiyukf.basesdk.c.b.c$a */
    private static class C5379a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Alignment f17352a;

        public C5379a(Alignment alignment) {
            this.f17352a = alignment;
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$b */
    private static class C5380b {
        private C5380b() {
        }

        /* synthetic */ C5380b(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$c */
    private static class C5381c {
        private C5381c() {
        }

        /* synthetic */ C5381c(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$d */
    private static class C5382d {
        private C5382d() {
        }

        /* synthetic */ C5382d(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$e */
    private static class C5383e {
        /* renamed from: a */
        public String f17353a;
        /* renamed from: b */
        public String f17354b;

        public C5383e(String str, String str2) {
            this.f17353a = str;
            this.f17354b = str2;
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$f */
    private static class C5384f {
        /* renamed from: a */
        private int f17355a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public int f17356b;

        private C5384f() {
            this.f17355a = 0;
            this.f17356b = 0;
        }

        /* synthetic */ C5384f(byte b) {
            this();
        }

        /* renamed from: a */
        public final int mo27342a() {
            return this.f17355a;
        }

        /* renamed from: a */
        public final void mo27343a(int i) {
            this.f17355a = i;
        }

        /* renamed from: b */
        public final void mo27344b(int i) {
            this.f17356b = i;
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$g */
    private static class C5385g {
        /* renamed from: a */
        public String f17357a;

        public C5385g(String str) {
            this.f17357a = str;
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$h */
    private static class C5386h {
        private C5386h() {
        }

        /* synthetic */ C5386h(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$i */
    private static class C5387i {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f17358a = 1;
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$j */
    private static class C5388j {
        private C5388j() {
        }

        /* synthetic */ C5388j(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$k */
    private static class C5389k {
        private C5389k() {
        }

        /* synthetic */ C5389k(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$l */
    private static class C5390l {
        private C5390l() {
        }

        /* synthetic */ C5390l(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$m */
    private static class C5391m {
        private C5391m() {
        }

        /* synthetic */ C5391m(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$n */
    private static class C5392n {
        private C5392n() {
        }

        /* synthetic */ C5392n(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$o */
    private static class C5393o {
        private C5393o() {
        }

        /* synthetic */ C5393o(byte b) {
            this();
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.c$p */
    private static class C5394p {
        private C5394p() {
        }

        /* synthetic */ C5394p(byte b) {
            this();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f17346g = hashMap;
        Integer valueOf = Integer.valueOf(-5658199);
        hashMap.put("darkgray", valueOf);
        Map<String, Integer> map = f17346g;
        Integer valueOf2 = Integer.valueOf(-8355712);
        map.put("gray", valueOf2);
        Map<String, Integer> map2 = f17346g;
        Integer valueOf3 = Integer.valueOf(-2894893);
        map2.put("lightgray", valueOf3);
        f17346g.put("darkgrey", valueOf);
        f17346g.put("grey", valueOf2);
        f17346g.put("lightgrey", valueOf3);
        f17346g.put("green", Integer.valueOf(-16744448));
    }

    C5378c() {
    }

    /* renamed from: a */
    private static Object m22066a(Editable editable, Class cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        for (int length = spans.length; length > 0; length--) {
            int i = length - 1;
            if (editable.getSpanFlags(spans[i]) == 17) {
                return spans[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    private static <T> T m22067a(Spanned spanned, Class<T> cls) {
        T[] spans = spanned.getSpans(0, spanned.length(), cls);
        if (spans.length == 0) {
            return null;
        }
        return spans[spans.length - 1];
    }

    /* renamed from: a */
    static String m22068a(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll("<div>(<img\\s+[^>]*>)</div>", "$1");
        StringBuilder sb = new StringBuilder("<html>");
        sb.append(replaceAll);
        sb.append("</html>");
        String replace = sb.toString().replace("<ul", "<HTML_TEXT_TAG_UL").replace("</ul>", "</HTML_TEXT_TAG_UL>").replace("<ol", "<HTML_TEXT_TAG_OL").replace("</ol>", "</HTML_TEXT_TAG_OL>").replace("<li", "<HTML_TEXT_TAG_LI").replace("</li>", "</HTML_TEXT_TAG_LI>").replace("<font", "<HTML_TEXT_TAG_FONT").replace("</font>", "</HTML_TEXT_TAG_FONT>").replace("<div", "<HTML_TEXT_TAG_DIV").replace("</div>", "</HTML_TEXT_TAG_DIV>").replace("<span", "<HTML_SPAN_STYLE").replace("</span>", "</HTML_SPAN_STYLE>");
        String str2 = "<HTML_BR_LABEL";
        String str3 = "<br";
        String replace2 = replace.replace(str3, str2).replace("<b", "<HTML_B_STYLE").replace(str2, str3).replace("</b>", "</HTML_B_STYLE>").replace("<p", "<HTML_P_STYLE").replace("</p>", "</HTML_P_STYLE>").replace("<a", "<HTML_A_STYLE").replace("</a>", "</HTML_A_STYLE>").replace("<u", "<HTML_U_STYLE").replace("</u>", "</HTML_U_STYLE>");
        String str4 = "<HTML_IMG_LABEL";
        String str5 = "<img";
        return replace2.replace(str5, str4).replace("<i", "<HTML_I_STYLE").replace(str4, str5).replace("</i>", "</HTML_I_STYLE>").replace("\n", "<br>");
    }

    /* renamed from: a */
    private static HashMap<String, String> m22069a(XMLReader xMLReader) {
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

    /* renamed from: a */
    private static void m22070a(Editable editable) {
        int length = editable.length();
        Object[] spans = editable.getSpans(0, editable.length(), C5384f.class);
        Object obj = spans.length == 0 ? null : spans[spans.length - 1];
        int spanStart = editable.getSpanStart(obj);
        editable.removeSpan(obj);
        if (spanStart != length) {
            C5384f fVar = (C5384f) obj;
            if (fVar != null) {
                int a = fVar.mo27342a();
                int a2 = fVar.f17356b;
                if (a != -1) {
                    editable.setSpan(new ForegroundColorSpan(a | ViewCompat.MEASURED_STATE_MASK), spanStart, length, 33);
                }
                if (a2 > 0) {
                    editable.setSpan(new AbsoluteSizeSpan(a2, true), spanStart, length, 33);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m22071a(Editable editable, int i) {
        int length = editable.length();
        if (length != 0) {
            int i2 = 0;
            while (true) {
                length--;
                if (length >= 0 && editable.charAt(length) == 10) {
                    i2++;
                }
            }
            while (i2 < i) {
                editable.append("\n");
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static void m22072a(Editable editable, Class cls, Object obj) {
        editable.length();
        Object a = m22066a(editable, cls);
        if (a != null) {
            m22076a((Spannable) editable, a, obj);
        }
    }

    /* renamed from: a */
    private static void m22073a(Editable editable, Class cls, boolean z, Object... objArr) {
        Object a = m22066a(editable, cls);
        int spanStart = editable.getSpanStart(a);
        int length = editable.length();
        editable.removeSpan(a);
        if (spanStart != length) {
            if (z) {
                editable.append("\n");
                length++;
            }
            for (Object span : objArr) {
                editable.setSpan(span, spanStart, length, 33);
            }
        }
    }

    /* renamed from: a */
    private static void m22074a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    /* renamed from: a */
    private static void m22075a(Editable editable, XMLReader xMLReader) {
        String str = (String) m22069a(xMLReader).get("style");
        if (str != null) {
            C5384f fVar = new C5384f(0);
            if (f17340a == null) {
                f17340a = Pattern.compile("(?:\\s+|\\A|;\\s*)color\\s*:\\s*(.*)\\b");
            }
            Matcher matcher = f17340a.matcher(str);
            if (matcher.find()) {
                int d = m22081d(matcher.group(1));
                if (d != -1) {
                    fVar.mo27343a(d);
                }
            }
            if (f17341b == null) {
                f17341b = Pattern.compile("font-size: (\\d+)px");
            }
            Matcher matcher2 = f17341b.matcher(str);
            if (matcher2.find()) {
                try {
                    fVar.mo27344b(Integer.parseInt(matcher2.group(1)));
                } catch (NumberFormatException unused) {
                }
            }
            int length = editable.length();
            editable.setSpan(fVar, length, length, 17);
        }
    }

    /* renamed from: a */
    private static void m22076a(Spannable spannable, Object obj, Object... objArr) {
        int spanStart = spannable.getSpanStart(obj);
        spannable.removeSpan(obj);
        int length = spannable.length();
        if (spanStart != length) {
            for (int i = 0; i <= 0; i++) {
                spannable.setSpan(objArr[0], spanStart, length, 33);
            }
        }
    }

    /* renamed from: b */
    private static int m22077b(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: b */
    private static void m22078b(Editable editable) {
        int length = editable.length();
        if ((length <= 0 || editable.charAt(length - 1) != 10) && length != 0) {
            editable.append("\n");
        }
    }

    /* renamed from: b */
    private static void m22079b(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    /* renamed from: c */
    private int m22080c(String str) {
        try {
            return (Math.min(Math.max(Integer.parseInt(str), 1), 7) - 3) + ((int) ((this.f17349i.getTextSize() / this.f17348h.getResources().getDisplayMetrics().density) + 0.5f));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(5:1|2|(1:4)|5|(2:7|8))|9|11|12|(1:14)|15|(2:17|18)|19|20|(1:22)|23|(2:25|26)|28|(1:30)(2:31|32)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0065 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1  */
    /* renamed from: d */
    private static int m22081d(java.lang.String r6) {
        /*
        r0 = 1
        java.util.regex.Pattern r1 = f17344e     // Catch:{ Exception -> 0x0022 }
        if (r1 != 0) goto L_0x000d
        java.lang.String r1 = "^\\s*(#[A-Za-z0-9]{6,8})"
        java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x0022 }
        f17344e = r1     // Catch:{ Exception -> 0x0022 }
    L_0x000d:
        java.util.regex.Pattern r1 = f17344e     // Catch:{ Exception -> 0x0022 }
        java.util.regex.Matcher r1 = r1.matcher(r6)     // Catch:{ Exception -> 0x0022 }
        boolean r2 = r1.find()     // Catch:{ Exception -> 0x0022 }
        if (r2 == 0) goto L_0x0022
        java.lang.String r1 = r1.group(r0)     // Catch:{ Exception -> 0x0022 }
        int r6 = android.graphics.Color.parseColor(r1)     // Catch:{ Exception -> 0x0022 }
        return r6
    L_0x0022:
        r1 = 3
        r2 = 2
        java.util.regex.Pattern r3 = f17342c     // Catch:{ Exception -> 0x0065 }
        if (r3 != 0) goto L_0x0030
        java.lang.String r3 = "^\\s*rgb\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\b"
        java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x0065 }
        f17342c = r3     // Catch:{ Exception -> 0x0065 }
    L_0x0030:
        java.util.regex.Pattern r3 = f17342c     // Catch:{ Exception -> 0x0065 }
        java.util.regex.Matcher r3 = r3.matcher(r6)     // Catch:{ Exception -> 0x0065 }
        boolean r4 = r3.find()     // Catch:{ Exception -> 0x0065 }
        if (r4 == 0) goto L_0x0065
        java.lang.String r4 = r3.group(r0)     // Catch:{ Exception -> 0x0065 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0065 }
        int r4 = r4.intValue()     // Catch:{ Exception -> 0x0065 }
        java.lang.String r5 = r3.group(r2)     // Catch:{ Exception -> 0x0065 }
        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0065 }
        int r5 = r5.intValue()     // Catch:{ Exception -> 0x0065 }
        java.lang.String r3 = r3.group(r1)     // Catch:{ Exception -> 0x0065 }
        java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0065 }
        int r3 = r3.intValue()     // Catch:{ Exception -> 0x0065 }
        int r6 = android.graphics.Color.rgb(r4, r5, r3)     // Catch:{ Exception -> 0x0065 }
        return r6
    L_0x0065:
        java.util.regex.Pattern r3 = f17343d     // Catch:{ Exception -> 0x00b8 }
        if (r3 != 0) goto L_0x0071
        java.lang.String r3 = "^\\s*rgba\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*,\\s*([\\d.]+)\\b"
        java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x00b8 }
        f17343d = r3     // Catch:{ Exception -> 0x00b8 }
    L_0x0071:
        java.util.regex.Pattern r3 = f17343d     // Catch:{ Exception -> 0x00b8 }
        java.util.regex.Matcher r3 = r3.matcher(r6)     // Catch:{ Exception -> 0x00b8 }
        boolean r4 = r3.find()     // Catch:{ Exception -> 0x00b8 }
        if (r4 == 0) goto L_0x00b9
        java.lang.String r0 = r3.group(r0)     // Catch:{ Exception -> 0x00b8 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00b8 }
        int r0 = r0.intValue()     // Catch:{ Exception -> 0x00b8 }
        java.lang.String r2 = r3.group(r2)     // Catch:{ Exception -> 0x00b8 }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00b8 }
        int r2 = r2.intValue()     // Catch:{ Exception -> 0x00b8 }
        java.lang.String r1 = r3.group(r1)     // Catch:{ Exception -> 0x00b8 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00b8 }
        int r1 = r1.intValue()     // Catch:{ Exception -> 0x00b8 }
        r4 = 4
        java.lang.String r3 = r3.group(r4)     // Catch:{ Exception -> 0x00b8 }
        java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ Exception -> 0x00b8 }
        float r3 = r3.floatValue()     // Catch:{ Exception -> 0x00b8 }
        r4 = 1132396544(0x437f0000, float:255.0)
        float r3 = r3 * r4
        int r3 = (int) r3     // Catch:{ Exception -> 0x00b8 }
        int r6 = android.graphics.Color.argb(r3, r0, r2, r1)     // Catch:{ Exception -> 0x00b8 }
        return r6
    L_0x00b9:
        int r6 = com.qiyukf.basesdk.p412c.p414b.C5397e.m22096a(r6)
        r0 = -1
        if (r6 == r0) goto L_0x00c1
        return r6
    L_0x00c1:
        r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p414b.C5378c.m22081d(java.lang.String):int");
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo27340a(TextView textView) {
        this.f17348h = textView.getContext().getApplicationContext();
        this.f17349i = textView.getPaint();
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        C5379a aVar;
        String str2 = str;
        Editable editable2 = editable;
        String str3 = "s";
        String str4 = "code";
        String str5 = "HTML_TEXT_TAG_DIV";
        String str6 = "HTML_TEXT_TAG_FONT";
        String str7 = "HTML_TEXT_TAG_LI";
        String str8 = "center";
        String str9 = "\n";
        String str10 = "HTML_TEXT_TAG_OL";
        String str11 = "HTML_TEXT_TAG_UL";
        int i = 10;
        boolean equalsIgnoreCase = str2.equalsIgnoreCase(str11);
        if (z) {
            if (equalsIgnoreCase) {
                this.f17350j.push(str2);
            } else if (str2.equalsIgnoreCase(str10)) {
                this.f17350j.push(str2);
                this.f17351k.push(Integer.valueOf(1));
            } else if (str2.equalsIgnoreCase(str7)) {
                if (editable.length() > 0 && editable2.charAt(editable.length() - 1) != 10) {
                    editable2.append(str9);
                }
                if (!this.f17350j.isEmpty()) {
                    String str12 = (String) this.f17350j.peek();
                    if (str12.equalsIgnoreCase(str10)) {
                        m22079b(editable2, new C5388j(0));
                        Stack<Integer> stack = this.f17351k;
                        stack.push(Integer.valueOf(((Integer) stack.pop()).intValue() + 1));
                        return;
                    }
                    if (str12.equalsIgnoreCase(str11)) {
                        m22079b(editable2, new C5393o(0));
                    }
                }
            } else if (str2.equalsIgnoreCase(str6)) {
                int length = editable.length();
                HashMap a = m22069a(xMLReader);
                editable2.setSpan(new C5383e((String) a.get("color"), (String) a.get(AppEntity.KEY_SIZE_LONG)), length, length, 17);
            } else if (str2.equalsIgnoreCase(str5)) {
                m22078b(editable);
            } else if (str2.equalsIgnoreCase(str4)) {
                m22079b(editable2, new C5382d(0));
            } else if (str2.equalsIgnoreCase(str8)) {
                m22079b(editable2, new C5381c(0));
            } else if (str2.equalsIgnoreCase(str3) || str2.equalsIgnoreCase("strike")) {
                m22079b(editable2, new C5389k(0));
            } else if (str2.equalsIgnoreCase("tr")) {
                m22079b(editable2, new C5392n(0));
            } else if (str2.equalsIgnoreCase("th")) {
                m22079b(editable2, new C5391m(0));
            } else if (str2.equalsIgnoreCase("td")) {
                m22079b(editable2, new C5390l(0));
            } else if (str2.equalsIgnoreCase("HTML_SPAN_STYLE")) {
                m22075a(editable, xMLReader);
            } else if (str2.equalsIgnoreCase("HTML_B_STYLE")) {
                m22074a(editable2, (Object) new C5380b(0));
                m22075a(editable, xMLReader);
            } else if (str2.equalsIgnoreCase("HTML_P_STYLE")) {
                String str13 = (String) m22069a(xMLReader).get("style");
                editable.length();
                m22071a(editable2, 1);
                m22074a(editable2, (Object) new C5387i());
                if (str13 != null) {
                    if (f17345f == null) {
                        f17345f = Pattern.compile("(?:\\s+|\\A)text-align\\s*:\\s*(\\S*)\\b");
                    }
                    Matcher matcher = f17345f.matcher(str13);
                    if (matcher.find()) {
                        String group = matcher.group(1);
                        if (group.equalsIgnoreCase(MessageKey.MSG_ACCEPT_TIME_START)) {
                            aVar = new C5379a(Alignment.ALIGN_NORMAL);
                        } else if (group.equalsIgnoreCase(str8)) {
                            aVar = new C5379a(Alignment.ALIGN_CENTER);
                        } else if (group.equalsIgnoreCase(MessageKey.MSG_ACCEPT_TIME_END)) {
                            aVar = new C5379a(Alignment.ALIGN_OPPOSITE);
                        }
                        m22074a(editable2, (Object) aVar);
                    }
                }
                m22075a(editable, xMLReader);
            } else if (str2.equalsIgnoreCase("HTML_A_STYLE")) {
                String str14 = (String) m22069a(xMLReader).get("href");
                Log.e("htmlTagHandler:", str14);
                m22074a(editable2, (Object) new C5385g(str14));
                m22075a(editable, xMLReader);
            } else if (str2.equalsIgnoreCase("HTML_U_STYLE")) {
                m22074a(editable2, (Object) new C5394p(0));
                m22075a(editable, xMLReader);
            } else if (str2.equalsIgnoreCase("HTML_I_STYLE")) {
                m22074a(editable2, (Object) new C5386h(0));
                m22075a(editable, xMLReader);
            }
        } else if (equalsIgnoreCase) {
            this.f17350j.pop();
        } else if (str2.equalsIgnoreCase(str10)) {
            this.f17350j.pop();
            this.f17351k.pop();
        } else if (str2.equalsIgnoreCase(str7)) {
            if (!this.f17350j.isEmpty()) {
                if (((String) this.f17350j.peek()).equalsIgnoreCase(str11)) {
                    if (editable.length() > 0 && editable2.charAt(editable.length() - 1) != 10) {
                        editable2.append(str9);
                    }
                    if (this.f17350j.size() > 1) {
                        i = 10 - f17347l.getLeadingMargin(true);
                        if (this.f17350j.size() > 2) {
                            i -= (this.f17350j.size() - 2) * 20;
                        }
                    }
                    m22073a(editable2, C5393o.class, false, new Standard((this.f17350j.size() - 1) * 20), new BulletSpan(i));
                } else if (((String) this.f17350j.peek()).equalsIgnoreCase(str10)) {
                    if (editable.length() > 0 && editable2.charAt(editable.length() - 1) != 10) {
                        editable2.append(str9);
                    }
                    int size = (this.f17350j.size() - 1) * 20;
                    if (this.f17350j.size() > 2) {
                        size -= (this.f17350j.size() - 2) * 20;
                    }
                    m22073a(editable2, C5388j.class, false, new Standard(size), new C5375c(this.f17349i, ((Integer) this.f17351k.lastElement()).intValue() - 1));
                }
            }
        } else if (str2.equalsIgnoreCase(str6)) {
            int length2 = editable.length();
            Object a2 = m22066a(editable2, C5383e.class);
            int spanStart = editable2.getSpanStart(a2);
            editable2.removeSpan(a2);
            if (spanStart != length2) {
                C5383e eVar = (C5383e) a2;
                int b = m22077b(eVar.f17353a);
                int c = m22080c(eVar.f17354b);
                if (b != -1) {
                    editable2.setSpan(new ForegroundColorSpan(b | ViewCompat.MEASURED_STATE_MASK), spanStart, length2, 33);
                }
                if (c > 0) {
                    editable2.setSpan(new AbsoluteSizeSpan(c, true), spanStart, length2, 33);
                }
            }
        } else if (str2.equalsIgnoreCase(str5)) {
            m22078b(editable);
        } else if (str2.equalsIgnoreCase(str4)) {
            m22073a(editable2, C5382d.class, false, new TypefaceSpan("monospace"));
        } else if (str2.equalsIgnoreCase(str8)) {
            m22073a(editable2, C5381c.class, true, new AlignmentSpan.Standard(Alignment.ALIGN_CENTER));
        } else if (str2.equalsIgnoreCase(str3) || str2.equalsIgnoreCase("strike")) {
            m22073a(editable2, C5389k.class, false, new StrikethroughSpan());
        } else if (str2.equalsIgnoreCase("tr")) {
            m22073a(editable2, C5392n.class, false, new Object[0]);
        } else if (str2.equalsIgnoreCase("th")) {
            m22073a(editable2, C5391m.class, false, new Object[0]);
        } else if (str2.equalsIgnoreCase("td")) {
            m22073a(editable2, C5390l.class, false, new Object[0]);
        } else if (str2.equalsIgnoreCase("HTML_SPAN_STYLE")) {
            m22070a(editable);
        } else if (str2.equalsIgnoreCase("HTML_B_STYLE")) {
            m22070a(editable);
            m22072a(editable2, C5380b.class, (Object) new StyleSpan(1));
        } else if (str2.equalsIgnoreCase("HTML_P_STYLE")) {
            m22070a(editable);
            C5387i iVar = (C5387i) m22067a((Spanned) editable2, C5387i.class);
            if (iVar != null) {
                m22071a(editable2, iVar.f17358a);
                editable2.removeSpan(iVar);
            }
            C5379a aVar2 = (C5379a) m22067a((Spanned) editable2, C5379a.class);
            if (aVar2 != null) {
                m22076a((Spannable) editable2, (Object) aVar2, new AlignmentSpan.Standard(aVar2.f17352a));
            }
        } else if (str2.equalsIgnoreCase("HTML_A_STYLE")) {
            m22070a(editable);
            C5385g gVar = (C5385g) m22067a((Spanned) editable2, C5385g.class);
            if (!(gVar == null || gVar.f17357a == null)) {
                m22076a((Spannable) editable2, (Object) gVar, new URLSpan(gVar.f17357a));
            }
        } else if (str2.equalsIgnoreCase("HTML_U_STYLE")) {
            m22070a(editable);
            m22072a(editable2, C5394p.class, (Object) new UnderlineSpan());
        } else if (str2.equalsIgnoreCase("HTML_I_STYLE")) {
            m22070a(editable);
            m22072a(editable2, C5386h.class, (Object) new StyleSpan(2));
        }
    }
}
