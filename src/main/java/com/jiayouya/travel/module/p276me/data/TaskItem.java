package com.jiayouya.travel.module.p276me.data;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import ezy.p653ui.widget.recyclerview.item.Classifiable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/TaskItem;", "Lezy/ui/widget/recyclerview/item/Classifiable;", "Lcom/jiayouya/travel/module/me/data/MeMenu;", "desc", "", "hbId", "", "image", "title", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHbId", "()I", "getImage", "toSubtypeId", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TaskItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.TaskItem */
public final class TaskItem extends MeMenu implements Classifiable {
    private final String desc;
    private final int hbId;
    private final String image;

    public long toSubtypeId() {
        return 2;
    }

    public TaskItem(String str, int i, String str2, String str3) {
        C8271i.m35386b(str, ArgKey.KEY_DESC);
        C8271i.m35386b(str2, "image");
        C8271i.m35386b(str3, "title");
        super(str3);
        this.desc = str;
        this.hbId = i;
        this.image = str2;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getHbId() {
        return this.hbId;
    }

    public final String getImage() {
        return this.image;
    }
}
