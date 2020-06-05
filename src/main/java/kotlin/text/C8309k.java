package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import kotlin.p677d.C8231j;
import kotlin.sequences.C8289c;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, mo39189d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Regex.kt */
/* renamed from: kotlin.text.k */
final class C8309k implements C8308j {
    /* renamed from: a */
    private final MatchResult f27818a = new C8310a(this);
    /* renamed from: b */
    private final Matcher f27819b;
    /* renamed from: c */
    private final CharSequence f27820c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo39189d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.k$a */
    public static final class C8310a extends AbstractCollection<C8306g> implements C8307i {
        /* renamed from: a */
        final /* synthetic */ C8309k f27821a;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
        /* compiled from: Regex.kt */
        /* renamed from: kotlin.text.k$a$a */
        static final class C8311a extends Lambda implements C8247b<Integer, C8306g> {
            final /* synthetic */ C8310a this$0;

            C8311a(C8310a aVar) {
                this.this$0 = aVar;
                super(1);
            }

            public /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final C8306g invoke(int i) {
                return this.this$0.mo39577a(i);
            }
        }

        public boolean isEmpty() {
            return false;
        }

        C8310a(C8309k kVar) {
            this.f27821a = kVar;
        }

        /* renamed from: a */
        public boolean mo39578a(C8306g gVar) {
            return super.contains(gVar);
        }

        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof C8306g : true) {
                return mo39578a((C8306g) obj);
            }
            return false;
        }

        /* renamed from: a */
        public int mo39284a() {
            return this.f27821a.m35443c().groupCount() + 1;
        }

        public Iterator<C8306g> iterator() {
            return C8289c.m35427a(C8187k.m35290e(C8187k.m35270a((Collection<?>) this)), new C8311a(this)).iterator();
        }

        /* renamed from: a */
        public C8306g mo39577a(int i) {
            C8231j a = C8312l.m35456b(this.f27821a.m35443c(), i);
            if (a.getStart().intValue() < 0) {
                return null;
            }
            String group = this.f27821a.m35443c().group(i);
            C8271i.m35382a((Object) group, "matchResult.group(index)");
            return new C8306g(group, a);
        }
    }

    public C8309k(Matcher matcher, CharSequence charSequence) {
        C8271i.m35386b(matcher, "matcher");
        C8271i.m35386b(charSequence, "input");
        this.f27819b = matcher;
        this.f27820c = charSequence;
    }

    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final MatchResult m35443c() {
        return this.f27819b;
    }

    /* renamed from: a */
    public C8231j mo39575a() {
        return C8312l.m35455b(m35443c());
    }

    /* renamed from: b */
    public C8308j mo39576b() {
        int end = m35443c().end() + (m35443c().end() == m35443c().start() ? 1 : 0);
        if (end > this.f27820c.length()) {
            return null;
        }
        Matcher matcher = this.f27819b.pattern().matcher(this.f27820c);
        C8271i.m35382a((Object) matcher, "matcher.pattern().matcher(input)");
        return C8312l.m35457b(matcher, end, this.f27820c);
    }
}
