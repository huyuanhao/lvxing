package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8246a;
import kotlin.jvm.p679a.C8247b;
import kotlin.p677d.C8238n;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.C8289c;
import kotlin.sequences.Sequence;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, mo39189d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Regex.kt */
public final class Regex implements Serializable {
    public static final C8298a Companion = new C8298a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, mo39189d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$a */
    public static final class C8298a {
        /* access modifiers changed from: private|final */
        /* renamed from: a */
        public final int m35430a(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private C8298a() {
        }

        public /* synthetic */ C8298a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo39189d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$b */
    private static final class C8299b implements Serializable {
        public static final C8300a Companion = new C8300a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
        /* compiled from: Regex.kt */
        /* renamed from: kotlin.text.Regex$b$a */
        public static final class C8300a {
            private C8300a() {
            }

            public /* synthetic */ C8300a(DefaultConstructorMarker fVar) {
                this();
            }
        }

        public C8299b(String str, int i) {
            C8271i.m35386b(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            C8271i.m35382a((Object) compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$c */
    static final class C8301c extends Lambda implements C8246a<C8308j> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;
        final /* synthetic */ Regex this$0;

        C8301c(Regex regex, CharSequence charSequence, int i) {
            this.this$0 = regex;
            this.$input = charSequence;
            this.$startIndex = i;
            super(0);
        }

        public final C8308j invoke() {
            return this.this$0.find(this.$input, this.$startIndex);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, mo39189d2 = {"<anonymous>", "Lkotlin/text/MatchResult;", "p1", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$d */
    static final /* synthetic */ class C8302d extends FunctionReference implements C8247b<C8308j, C8308j> {
        public static final C8302d INSTANCE = new C8302d();

        C8302d() {
            super(1);
        }

        public final String getName() {
            return "next";
        }

        public final KDeclarationContainer getOwner() {
            return C8272k.m35394a(C8308j.class);
        }

        public final String getSignature() {
            return "next()Lkotlin/text/MatchResult;";
        }

        public final C8308j invoke(C8308j jVar) {
            C8271i.m35386b(jVar, "p1");
            return jVar.mo39576b();
        }
    }

    public Regex(Pattern pattern) {
        C8271i.m35386b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public Regex(String str) {
        C8271i.m35386b(str, "pattern");
        Pattern compile = Pattern.compile(str);
        C8271i.m35382a((Object) compile, "Pattern.compile(pattern)");
        this(compile);
    }

    public Regex(String str, RegexOption regexOption) {
        C8271i.m35386b(str, "pattern");
        C8271i.m35386b(regexOption, "option");
        Pattern compile = Pattern.compile(str, Companion.m35430a(regexOption.getValue()));
        C8271i.m35382a((Object) compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(compile);
    }

    public Regex(String str, Set<? extends RegexOption> set) {
        C8271i.m35386b(str, "pattern");
        C8271i.m35386b(set, "options");
        Pattern compile = Pattern.compile(str, Companion.m35430a(C8312l.m35454b((Iterable<? extends C8305f>) set)));
        C8271i.m35382a((Object) compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
        this(compile);
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        C8271i.m35382a((Object) pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final Set<RegexOption> getOptions() {
        Set<? extends RegexOption> set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        C8187k.m35276a((Iterable<? extends T>) allOf, (C8247b<? super T, Boolean>) new Regex$fromInt$$inlined$apply$lambda$1<Object,Boolean>(flags));
        Set<? extends RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        C8271i.m35382a((Object) unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final boolean matches(CharSequence charSequence) {
        C8271i.m35386b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        C8271i.m35386b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public static /* synthetic */ C8308j find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final C8308j find(CharSequence charSequence, int i) {
        C8271i.m35386b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        C8271i.m35382a((Object) matcher, "nativePattern.matcher(input)");
        return C8312l.m35457b(matcher, i, charSequence);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final Sequence<C8308j> findAll(CharSequence charSequence, int i) {
        C8271i.m35386b(charSequence, "input");
        return C8289c.m35422a(new C8301c(this, charSequence, i), C8302d.INSTANCE);
    }

    public final C8308j matchEntire(CharSequence charSequence) {
        C8271i.m35386b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        C8271i.m35382a((Object) matcher, "nativePattern.matcher(input)");
        return C8312l.m35458b(matcher, charSequence);
    }

    public final String replace(CharSequence charSequence, String str) {
        C8271i.m35386b(charSequence, "input");
        C8271i.m35386b(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        C8271i.m35382a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replace(CharSequence charSequence, C8247b<? super C8308j, ? extends CharSequence> bVar) {
        C8271i.m35386b(charSequence, "input");
        C8271i.m35386b(bVar, "transform");
        int i = 0;
        C8308j find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (find$default == null) {
                C8271i.m35380a();
            }
            sb.append(charSequence, i, find$default.mo39575a().getStart().intValue());
            sb.append((CharSequence) bVar.invoke(find$default));
            i = find$default.mo39575a().getEndInclusive().intValue() + 1;
            find$default = find$default.mo39576b();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        C8271i.m35382a((Object) sb2, "sb.toString()");
        return sb2;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        C8271i.m35386b(charSequence, "input");
        C8271i.m35386b(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        C8271i.m35382a((Object) replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence charSequence, int i) {
        C8271i.m35386b(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (!matcher.find() || i == 1) {
                return C8187k.m35265a(charSequence.toString());
            }
            int i3 = 10;
            if (i > 0) {
                i3 = C8238n.m35356d(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i4 >= 0 && arrayList.size() == i4) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        C8271i.m35382a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        C8271i.m35382a((Object) pattern, "nativePattern.pattern()");
        return new C8299b(pattern, this.nativePattern.flags());
    }
}
