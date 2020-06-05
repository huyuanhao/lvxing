package com.jiayouya.travel.common.p246d;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.android.tpush.common.MessageKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\n"}, mo39189d2 = {"copyToClipboard", "", "context", "Landroid/content/Context;", "content", "", "isShowToast", "", "toast", "getClipboardContent", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.c */
public final class ClipboardUtil {
    /* renamed from: a */
    public static /* synthetic */ void m12953a(Context context, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        m12952a(context, str, z, str2);
    }

    /* renamed from: a */
    public static final void m12952a(Context context, String str, boolean z, String str2) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, MessageKey.MSG_CONTENT);
        Object systemService = context.getSystemService("clipboard");
        if (systemService instanceof ClipboardManager) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, str));
            if (z) {
                ezy.p642a.Context.m34744a(context, str2 != null ? str2 : "复制成功", 0, 0, 6, null);
            }
        }
    }

    /* renamed from: a */
    public static final String m12951a(Context context) {
        C8271i.m35386b(context, "context");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            String str = "";
            if (primaryClip == null) {
                return str;
            }
            Item itemAt = primaryClip.getItemAt(0);
            C8271i.m35382a((Object) itemAt, "item");
            return itemAt.getText() == null ? str : itemAt.getText().toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
}
