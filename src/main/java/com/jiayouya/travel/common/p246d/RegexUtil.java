package com.jiayouya.travel.common.p246d;

import com.tencent.android.tpush.common.MessageKey;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, mo39189d2 = {"StringStartTrim", "", "string", "trim", "format", "args", "isInviteCode", "", "content", "isMobile", "phone", "keywordReplaceColor", "Landroid/text/SpannableString;", "keyword", "color", "", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.l */
public final class RegexUtil {
    /* renamed from: a */
    public static final boolean m12968a(String str) {
        C8271i.m35386b(str, MessageKey.MSG_CONTENT);
        return Pattern.compile("^(([1-9])([0-9]{3,7}))$", 2).matcher(str).matches();
    }
}
