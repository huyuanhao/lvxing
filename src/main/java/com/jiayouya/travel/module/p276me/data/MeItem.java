package com.jiayouya.travel.module.p276me.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import ezy.p653ui.widget.recyclerview.item.Classifiable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/MeItem;", "Lezy/ui/widget/recyclerview/item/Classifiable;", "Lcom/jiayouya/travel/module/me/data/MeMenu;", "value", "", "mark", "title", "route", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getMark", "getRoute", "getValue", "toSubtypeId", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MeItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MeItem */
public final class MeItem extends MeMenu implements Classifiable {
    private final String image;
    private final String mark;
    private final String route;
    private final String value;

    public final String getValue() {
        return this.value;
    }

    public final String getMark() {
        return this.mark;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getImage() {
        return this.image;
    }

    public MeItem(String str, String str2, String str3, String str4, String str5) {
        C8271i.m35386b(str, ArgKey.KEY_VALUE);
        C8271i.m35386b(str2, "mark");
        C8271i.m35386b(str3, "title");
        C8271i.m35386b(str4, "route");
        C8271i.m35386b(str5, "image");
        super(str3);
        this.value = str;
        this.mark = str2;
        this.route = str4;
        this.image = str5;
    }

    public long toSubtypeId() {
        String title = getTitle();
        int hashCode = title.hashCode();
        if (hashCode != 3552645) {
            if (hashCode == 1674318617 && title.equals("divider")) {
                return 3;
            }
        } else if (title.equals("task")) {
            return 2;
        }
        return 1;
    }
}
