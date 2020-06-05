package com.jiayouya.travel.module.p276me.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/MeMenu;", "", "title", "", "(Ljava/lang/String;)V", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "hasPre", "getHasPre", "setHasPre", "getTitle", "()Ljava/lang/String;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MeMenu.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MeMenu */
public class MeMenu {
    private boolean hasNext;
    private boolean hasPre;
    private final String title;

    public MeMenu(String str) {
        C8271i.m35386b(str, "title");
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getHasPre() {
        return this.hasPre;
    }

    public final void setHasPre(boolean z) {
        this.hasPre = z;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }
}
