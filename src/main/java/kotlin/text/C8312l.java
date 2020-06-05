package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.p677d.C8231j;
import kotlin.p677d.C8238n;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, mo39189d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Regex.kt */
/* renamed from: kotlin.text.l */
public final class C8312l {
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final C8308j m35457b(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new C8309k(matcher, charSequence);
    }

    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final C8308j m35458b(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new C8309k(matcher, charSequence);
    }

    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final C8231j m35455b(MatchResult matchResult) {
        return C8238n.m35354b(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final C8231j m35456b(MatchResult matchResult, int i) {
        return C8238n.m35354b(matchResult.start(i), matchResult.end(i));
    }

    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final int m35454b(Iterable<? extends C8305f> iterable) {
        int i = 0;
        for (C8305f value : iterable) {
            i |= value.getValue();
        }
        return i;
    }
}
