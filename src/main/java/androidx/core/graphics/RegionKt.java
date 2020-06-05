package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import com.p522qq.p523e.comm.constants.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0017"}, mo39189d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Region.kt */
public final class RegionKt {
    public static final boolean contains(Region region, Point point) {
        C8271i.m35386b(region, "$this$contains");
        C8271i.m35386b(point, Constants.PORTRAIT);
        return region.contains(point.x, point.y);
    }

    public static final Region plus(Region region, Rect rect) {
        C8271i.m35386b(region, "$this$plus");
        C8271i.m35386b(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Region region2) {
        C8271i.m35386b(region, "$this$plus");
        C8271i.m35386b(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Op.UNION);
        return region3;
    }

    public static final Region minus(Region region, Rect rect) {
        C8271i.m35386b(region, "$this$minus");
        C8271i.m35386b(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Op.DIFFERENCE);
        return region2;
    }

    public static final Region minus(Region region, Region region2) {
        C8271i.m35386b(region, "$this$minus");
        C8271i.m35386b(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Op.DIFFERENCE);
        return region3;
    }

    public static final Region unaryMinus(Region region) {
        C8271i.m35386b(region, "$this$unaryMinus");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Op.DIFFERENCE);
        return region2;
    }

    public static final Region and(Region region, Rect rect) {
        C8271i.m35386b(region, "$this$and");
        C8271i.m35386b(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Op.INTERSECT);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        C8271i.m35386b(region, "$this$and");
        C8271i.m35386b(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Op.INTERSECT);
        return region3;
    }

    public static final Region xor(Region region, Rect rect) {
        C8271i.m35386b(region, "$this$xor");
        C8271i.m35386b(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Op.XOR);
        return region2;
    }

    public static final Region xor(Region region, Region region2) {
        C8271i.m35386b(region, "$this$xor");
        C8271i.m35386b(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Op.XOR);
        return region3;
    }

    public static final void forEach(Region region, C8247b<? super Rect, Unit> bVar) {
        C8271i.m35386b(region, "$this$forEach");
        C8271i.m35386b(bVar, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (regionIterator.next(rect)) {
                bVar.invoke(rect);
            } else {
                return;
            }
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        C8271i.m35386b(region, "$this$iterator");
        return new RegionKt$iterator$1<>(region);
    }

    public static final Region not(Region region) {
        C8271i.m35386b(region, "$this$not");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Op.DIFFERENCE);
        return region2;
    }

    /* renamed from: or */
    public static final Region m7or(Region region, Rect rect) {
        C8271i.m35386b(region, "$this$or");
        C8271i.m35386b(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    /* renamed from: or */
    public static final Region m8or(Region region, Region region2) {
        C8271i.m35386b(region, "$this$or");
        C8271i.m35386b(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Op.UNION);
        return region3;
    }
}
