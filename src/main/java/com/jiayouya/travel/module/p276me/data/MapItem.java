package com.jiayouya.travel.module.p276me.data;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.jiayouya.travel.R;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J1\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010!\u001a\u00020\"8FX\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8FX\u0002¢\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b,\u0010-R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000b¨\u00069"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/data/MapItem;", "", "id", "", "name", "", "location", "Landroid/graphics/PointF;", "resId", "(ILjava/lang/String;Landroid/graphics/PointF;I)V", "getId", "()I", "isCirclePoint", "", "()Z", "setCirclePoint", "(Z)V", "isCurCity", "setCurCity", "isDrawMark", "setDrawMark", "isNextCity", "setNextCity", "isScaleMark", "setScaleMark", "getLocation", "()Landroid/graphics/PointF;", "markBitmap", "Landroid/graphics/Bitmap;", "getMarkBitmap", "()Landroid/graphics/Bitmap;", "markBitmap$delegate", "Lkotlin/Lazy;", "markRect", "Landroid/graphics/RectF;", "getMarkRect", "()Landroid/graphics/RectF;", "markRect$delegate", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "originRect", "Landroid/graphics/Rect;", "getOriginRect", "()Landroid/graphics/Rect;", "originRect$delegate", "getResId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MapItem.kt */
/* renamed from: com.jiayouya.travel.module.me.data.MapItem */
public final class MapItem {
    static final /* synthetic */ C8280j[] $$delegatedProperties;
    /* renamed from: id */
    private final int f11567id;
    private boolean isCirclePoint;
    private boolean isCurCity;
    private boolean isDrawMark;
    private boolean isNextCity;
    private boolean isScaleMark;
    private final PointF location;
    private final Lazy markBitmap$delegate;
    private final Lazy markRect$delegate;
    private String name;
    private final Lazy originRect$delegate;
    private final int resId;

    static {
        Class<MapItem> cls = MapItem.class;
        $$delegatedProperties = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "markBitmap", "getMarkBitmap()Landroid/graphics/Bitmap;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "originRect", "getOriginRect()Landroid/graphics/Rect;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "markRect", "getMarkRect()Landroid/graphics/RectF;"))};
    }

    public static /* synthetic */ MapItem copy$default(MapItem mapItem, int i, String str, PointF pointF, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mapItem.f11567id;
        }
        if ((i3 & 2) != 0) {
            str = mapItem.name;
        }
        if ((i3 & 4) != 0) {
            pointF = mapItem.location;
        }
        if ((i3 & 8) != 0) {
            i2 = mapItem.resId;
        }
        return mapItem.copy(i, str, pointF, i2);
    }

    public final int component1() {
        return this.f11567id;
    }

    public final String component2() {
        return this.name;
    }

    public final PointF component3() {
        return this.location;
    }

    public final int component4() {
        return this.resId;
    }

    public final MapItem copy(int i, String str, PointF pointF, int i2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(pointF, "location");
        return new MapItem(i, str, pointF, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MapItem) {
                MapItem mapItem = (MapItem) obj;
                if ((this.f11567id == mapItem.f11567id) && C8271i.m35384a((Object) this.name, (Object) mapItem.name) && C8271i.m35384a((Object) this.location, (Object) mapItem.location)) {
                    if (this.resId == mapItem.resId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final Bitmap getMarkBitmap() {
        Lazy bVar = this.markBitmap$delegate;
        C8280j jVar = $$delegatedProperties[0];
        return (Bitmap) bVar.getValue();
    }

    public final RectF getMarkRect() {
        Lazy bVar = this.markRect$delegate;
        C8280j jVar = $$delegatedProperties[2];
        return (RectF) bVar.getValue();
    }

    public final Rect getOriginRect() {
        Lazy bVar = this.originRect$delegate;
        C8280j jVar = $$delegatedProperties[1];
        return (Rect) bVar.getValue();
    }

    public int hashCode() {
        int i = this.f11567id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        PointF pointF = this.location;
        if (pointF != null) {
            i2 = pointF.hashCode();
        }
        return ((hashCode + i2) * 31) + this.resId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MapItem(id=");
        sb.append(this.f11567id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", resId=");
        sb.append(this.resId);
        sb.append(")");
        return sb.toString();
    }

    public MapItem(int i, String str, PointF pointF, int i2) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        C8271i.m35386b(pointF, "location");
        this.f11567id = i;
        this.name = str;
        this.location = pointF;
        this.resId = i2;
        this.isCirclePoint = true;
        this.markBitmap$delegate = C8182c.m35317a(new MapItem$markBitmap$2(this));
        this.originRect$delegate = C8182c.m35317a(new MapItem$originRect$2(this));
        this.markRect$delegate = C8182c.m35317a(new MapItem$markRect$2(this));
    }

    public final int getId() {
        return this.f11567id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.name = str;
    }

    public final PointF getLocation() {
        return this.location;
    }

    public /* synthetic */ MapItem(int i, String str, PointF pointF, int i2, int i3, DefaultConstructorMarker fVar) {
        if ((i3 & 8) != 0) {
            i2 = R.mipmap.ic_beijing;
        }
        this(i, str, pointF, i2);
    }

    public final int getResId() {
        return this.resId;
    }

    public final boolean isDrawMark() {
        return this.isDrawMark;
    }

    public final void setDrawMark(boolean z) {
        this.isDrawMark = z;
    }

    public final boolean isScaleMark() {
        return this.isScaleMark;
    }

    public final void setScaleMark(boolean z) {
        this.isScaleMark = z;
    }

    public final boolean isCirclePoint() {
        return this.isCirclePoint;
    }

    public final void setCirclePoint(boolean z) {
        this.isCirclePoint = z;
    }

    public final boolean isCurCity() {
        return this.isCurCity;
    }

    public final void setCurCity(boolean z) {
        this.isCurCity = z;
    }

    public final boolean isNextCity() {
        return this.isNextCity;
    }

    public final void setNextCity(boolean z) {
        this.isNextCity = z;
    }
}
