package com.jiayouya.travel.module.p276me.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.common.p244b.PaintEx;
import com.jiayouya.travel.module.p276me.data.MapItem;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u00107\u001a\u00020\b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J\b\u0010<\u001a\u00020!H\u0003J\u0018\u0010=\u001a\u00020>2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002J\b\u0010?\u001a\u00020\u0010H\u0002J\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0014J\u0018\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0010H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b(\u0010\fR\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b0\u0010\fR\u000e\u00102\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b4\u0010\fR\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/widget/MapView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "curPath", "Landroid/graphics/Path;", "dashPaint", "Landroid/graphics/Paint;", "getDashPaint", "()Landroid/graphics/Paint;", "dashPaint$delegate", "Lkotlin/Lazy;", "inSampleSize", "", "isFirst", "", "linePaint", "getLinePaint", "linePaint$delegate", "list", "", "Lcom/jiayouya/travel/module/me/data/MapItem;", "getList", "()Ljava/util/List;", "locationBitmap", "Landroid/graphics/drawable/Drawable;", "getLocationBitmap", "()Landroid/graphics/drawable/Drawable;", "locationBitmap$delegate", "mapBitmap", "Landroid/graphics/Bitmap;", "getMapBitmap", "()Landroid/graphics/Bitmap;", "mapBitmap$delegate", "originRect", "Landroid/graphics/Rect;", "paint", "getPaint", "paint$delegate", "pointRadius", "", "pointTextSpace", "roundRectHeight", "scaleRect", "smallDashPaint", "getSmallDashPaint", "smallDashPaint$delegate", "textPadding", "textPaint", "getTextPaint", "textPaint$delegate", "walkedPathList", "createPath", "p1", "Landroid/graphics/PointF;", "p2", "curCityIndex", "getBgBitmap", "getDistanceBetween2Points", "", "nextCityIndex", "notifyDataChanged", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: MapView.kt */
/* renamed from: com.jiayouya.travel.module.me.widget.MapView */
public final class MapView extends View {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f11761a;
    /* renamed from: b */
    private final Lazy f11762b = C8182c.m35317a(new C3267d(this));
    /* renamed from: c */
    private final Lazy f11763c = C8182c.m35317a(C3266c.INSTANCE);
    /* renamed from: d */
    private final List<MapItem> f11764d = new ArrayList();
    /* renamed from: e */
    private final Lazy f11765e = C8182c.m35317a(C3268e.INSTANCE);
    /* renamed from: f */
    private final Lazy f11766f = C8182c.m35317a(C3270g.INSTANCE);
    /* renamed from: g */
    private final float f11767g = ((float) GloblaEx.m12810a(4.0f));
    /* renamed from: h */
    private final Lazy f11768h = C8182c.m35317a(C3264a.INSTANCE);
    /* renamed from: i */
    private final Lazy f11769i = C8182c.m35317a(C3269f.INSTANCE);
    /* renamed from: j */
    private final Lazy f11770j = C8182c.m35317a(C3265b.INSTANCE);
    /* renamed from: k */
    private final Path f11771k = new Path();
    /* renamed from: l */
    private final List<Path> f11772l = new ArrayList();
    /* renamed from: m */
    private final Rect f11773m = new Rect();
    /* renamed from: n */
    private final Rect f11774n = new Rect();
    /* renamed from: o */
    private boolean f11775o;
    /* renamed from: p */
    private final int f11776p;
    /* renamed from: q */
    private final int f11777q;
    /* renamed from: r */
    private final int f11778r;
    /* renamed from: s */
    private final int f11779s;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$a */
    static final class C3264a extends Lambda implements C8246a<Paint> {
        public static final C3264a INSTANCE = new C3264a();

        C3264a() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) GloblaEx.m12810a(4.0f));
            paint.setPathEffect(new DashPathEffect(new float[]{(float) GloblaEx.m12810a(0.5f), (float) GloblaEx.m12810a(6.0f)}, 0.0f));
            paint.setStrokeCap(Cap.ROUND);
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$b */
    static final class C3265b extends Lambda implements C8246a<Paint> {
        public static final C3265b INSTANCE = new C3265b();

        C3265b() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) GloblaEx.m12810a(2.0f));
            paint.setColor(GloblaEx.m12811a((int) R.color.blue_3377EE));
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$c */
    static final class C3266c extends Lambda implements C8246a<Drawable> {
        public static final C3266c INSTANCE = new C3266c();

        C3266c() {
            super(0);
        }

        public final Drawable invoke() {
            return GloblaEx.m12820c(R.mipmap.ic_location);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$d */
    static final class C3267d extends Lambda implements C8246a<Bitmap> {
        final /* synthetic */ MapView this$0;

        C3267d(MapView mapView) {
            this.this$0 = mapView;
            super(0);
        }

        public final Bitmap invoke() {
            return this.this$0.getBgBitmap();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$e */
    static final class C3268e extends Lambda implements C8246a<Paint> {
        public static final C3268e INSTANCE = new C3268e();

        C3268e() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Style.FILL);
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$f */
    static final class C3269f extends Lambda implements C8246a<Paint> {
        public static final C3269f INSTANCE = new C3269f();

        C3269f() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) GloblaEx.m12810a(1.0f));
            paint.setPathEffect(new DashPathEffect(new float[]{(float) GloblaEx.m12810a(0.5f), (float) GloblaEx.m12810a(6.0f)}, 0.0f));
            paint.setStrokeCap(Cap.ROUND);
            return paint;
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39189d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MapView.kt */
    /* renamed from: com.jiayouya.travel.module.me.widget.MapView$g */
    static final class C3270g extends Lambda implements C8246a<Paint> {
        public static final C3270g INSTANCE = new C3270g();

        C3270g() {
            super(0);
        }

        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) GloblaEx.m12817b(10.0f));
            paint.setStyle(Style.FILL);
            return paint;
        }
    }

    static {
        Class<MapView> cls = MapView.class;
        f11761a = new C8280j[]{C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "mapBitmap", "getMapBitmap()Landroid/graphics/Bitmap;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "locationBitmap", "getLocationBitmap()Landroid/graphics/drawable/Drawable;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "paint", "getPaint()Landroid/graphics/Paint;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "textPaint", "getTextPaint()Landroid/graphics/Paint;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "dashPaint", "getDashPaint()Landroid/graphics/Paint;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "smallDashPaint", "getSmallDashPaint()Landroid/graphics/Paint;")), C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a((Class) cls), "linePaint", "getLinePaint()Landroid/graphics/Paint;"))};
    }

    private final Paint getDashPaint() {
        Lazy bVar = this.f11768h;
        C8280j jVar = f11761a[4];
        return (Paint) bVar.getValue();
    }

    private final Paint getLinePaint() {
        Lazy bVar = this.f11770j;
        C8280j jVar = f11761a[6];
        return (Paint) bVar.getValue();
    }

    private final Drawable getLocationBitmap() {
        Lazy bVar = this.f11763c;
        C8280j jVar = f11761a[1];
        return (Drawable) bVar.getValue();
    }

    private final Bitmap getMapBitmap() {
        Lazy bVar = this.f11762b;
        C8280j jVar = f11761a[0];
        return (Bitmap) bVar.getValue();
    }

    private final Paint getPaint() {
        Lazy bVar = this.f11765e;
        C8280j jVar = f11761a[2];
        return (Paint) bVar.getValue();
    }

    private final Paint getSmallDashPaint() {
        Lazy bVar = this.f11769i;
        C8280j jVar = f11761a[5];
        return (Paint) bVar.getValue();
    }

    private final Paint getTextPaint() {
        Lazy bVar = this.f11766f;
        C8280j jVar = f11761a[3];
        return (Paint) bVar.getValue();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
        List<MapItem> list = this.f11764d;
        MapItem mapItem = new MapItem(1, "中国", new PointF((float) GloblaEx.m12810a(803.0f), (float) GloblaEx.m12810a(202.0f)), 0, 8, null);
        list.add(mapItem);
        list.add(new MapItem(2, "日本", new PointF((float) GloblaEx.m12810a(907.0f), (float) GloblaEx.m12810a(214.0f)), R.mipmap.ic_riben));
        list.add(new MapItem(3, "印度", new PointF((float) GloblaEx.m12810a(717.0f), (float) GloblaEx.m12810a(282.0f)), R.mipmap.ic_yingdu));
        list.add(new MapItem(4, "埃及", new PointF((float) GloblaEx.m12810a(551.0f), (float) GloblaEx.m12810a(236.0f)), R.mipmap.ic_aiji));
        list.add(new MapItem(5, "意大利", new PointF((float) GloblaEx.m12810a(489.0f), (float) GloblaEx.m12810a(196.0f)), R.mipmap.ic_italy));
        list.add(new MapItem(6, "法国", new PointF((float) GloblaEx.m12810a(449.0f), (float) GloblaEx.m12810a(167.0f)), R.mipmap.ic_france));
        list.add(new MapItem(7, "英国", new PointF((float) GloblaEx.m12810a(436.0f), (float) GloblaEx.m12810a(115.0f)), R.mipmap.ic_england));
        list.add(new MapItem(8, "冰岛", new PointF((float) GloblaEx.m12810a(398.0f), (float) GloblaEx.m12810a(82.0f)), R.mipmap.ic_grl));
        list.add(new MapItem(9, "加拿大", new PointF((float) GloblaEx.m12810a(113.0f), (float) GloblaEx.m12810a(114.0f)), R.mipmap.ic_canada));
        list.add(new MapItem(10, "美国", new PointF((float) GloblaEx.m12810a(105.0f), (float) GloblaEx.m12810a(190.0f)), R.mipmap.ic_usa));
        list.add(new MapItem(11, "纽约", new PointF((float) GloblaEx.m12810a(215.0f), (float) GloblaEx.m12810a(181.0f)), R.mipmap.ic_new_york));
        list.add(new MapItem(12, "智利", new PointF((float) GloblaEx.m12810a(205.0f), (float) GloblaEx.m12810a(478.0f)), R.mipmap.ic_zili));
        list.add(new MapItem(13, "巴西", new PointF((float) GloblaEx.m12810a(278.0f), (float) GloblaEx.m12810a(412.0f)), R.mipmap.ic_brazil));
        list.add(new MapItem(14, "突尼斯", new PointF((float) GloblaEx.m12810a(453.0f), (float) GloblaEx.m12810a(245.0f)), R.mipmap.ic_tns));
        list.add(new MapItem(15, "东非", new PointF((float) GloblaEx.m12810a(600.0f), (float) GloblaEx.m12810a(350.0f)), R.mipmap.ic_mylh));
        list.add(new MapItem(16, "马达加斯加", new PointF((float) GloblaEx.m12810a(617.0f), (float) GloblaEx.m12810a(455.0f)), R.mipmap.ic_mdjsj));
        list.add(new MapItem(17, "刚果", new PointF((float) GloblaEx.m12810a(513.0f), (float) GloblaEx.m12810a(405.0f)), R.mipmap.ic_congo));
        list.add(new MapItem(18, "南非", new PointF((float) GloblaEx.m12810a(533.0f), (float) GloblaEx.m12810a(500.0f)), R.mipmap.ic_safrica));
        list.add(new MapItem(19, "西澳", new PointF((float) GloblaEx.m12810a(868.0f), (float) GloblaEx.m12810a(476.0f)), R.mipmap.ic_west_australia));
        list.add(new MapItem(20, "袋鼠岛", new PointF((float) GloblaEx.m12810a(845.0f), (float) GloblaEx.m12810a(550.0f)), R.mipmap.ic_south_australia));
        list.add(new MapItem(21, "墨尔本", new PointF((float) GloblaEx.m12810a(919.0f), (float) GloblaEx.m12810a(576.0f)), R.mipmap.ic_melbourne));
        MapItem mapItem2 = new MapItem(22, "悉尼", new PointF((float) GloblaEx.m12810a(970.0f), (float) GloblaEx.m12810a(526.0f)), 0, 8, null);
        list.add(mapItem2);
        MapItem mapItem3 = new MapItem(-1, "俄罗斯", new PointF((float) GloblaEx.m12810a(692.0f), (float) GloblaEx.m12810a(95.0f)), 0, 8, null);
        list.add(mapItem3);
        MapItem mapItem4 = new MapItem(-1, "新加坡", new PointF((float) GloblaEx.m12810a(814.0f), (float) GloblaEx.m12810a(379.0f)), 0, 8, null);
        list.add(mapItem4);
        this.f11775o = true;
        this.f11776p = GloblaEx.m12810a(6.0f);
        this.f11777q = GloblaEx.m12810a(8.0f);
        this.f11778r = GloblaEx.m12810a(16.0f);
        this.f11779s = 2;
    }

    public final List<MapItem> getList() {
        return this.f11764d;
    }

    /* renamed from: a */
    private final Path m14284a(PointF pointF, PointF pointF2) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        float f = (float) 2;
        double atan2 = ((double) 90) - ((Math.atan2((double) Math.abs(pointF.x - pointF2.x), (double) Math.abs(pointF.y - pointF2.y)) * ((double) TinkerReport.KEY_APPLIED_VERSION_CHECK)) / 3.141592653589793d);
        double b = m14285b(pointF, pointF2) * ((double) 0.3f);
        double abs = ((double) ((Math.abs(pointF.x - pointF2.x) / f) + Math.min(pointF.x, pointF2.x))) + (Math.sin(atan2) * b);
        path.quadTo((float) abs, (float) (((double) ((Math.abs(pointF.y - pointF2.y) / f) + Math.min(pointF.y, pointF2.y))) - (Math.cos(atan2) * b)), pointF2.x, pointF2.y);
        StringBuilder sb = new StringBuilder();
        sb.append("angle==");
        sb.append(atan2);
        XLog.m12691a(sb.toString());
        return path;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int a = GloblaEx.m12813a(false, 1, (Object) null);
        int width = getMapBitmap().getWidth();
        int height = getMapBitmap().getHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("bitmapWidth==");
        sb.append(width);
        sb.append(" bitmapHeight==");
        sb.append(height);
        sb.append(' ');
        XLog.m12691a(sb.toString());
        float f = ((float) a) / ((float) height);
        int i3 = (int) (((float) width) * f);
        setMeasuredDimension(i3, a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("width==");
        sb2.append(i3);
        sb2.append("  height==");
        sb2.append(a);
        sb2.append("  scale=");
        sb2.append(f);
        XLog.m12691a(sb2.toString());
        this.f11773m.set(0, 0, width, height);
        this.f11774n.set(0, 0, i3, a);
        if (this.f11775o) {
            for (MapItem location : this.f11764d) {
                PointF location2 = location.getLocation();
                location2.x *= f / ((float) this.f11779s);
                location2.y *= f / ((float) this.f11779s);
            }
            this.f11775o = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        C8271i.m35386b(canvas2, "canvas");
        canvas2.drawBitmap(getMapBitmap(), this.f11773m, this.f11774n, null);
        canvas2.drawPath(this.f11771k, getDashPaint());
        for (Path drawPath : this.f11772l) {
            canvas2.drawPath(drawPath, getSmallDashPaint());
        }
        for (MapItem mapItem : this.f11764d) {
            PointF location = mapItem.getLocation();
            float a = PaintEx.m12831a(getTextPaint());
            float measureText = getTextPaint().measureText(mapItem.getName());
            if (mapItem.isDrawMark()) {
                canvas2.drawBitmap(mapItem.getMarkBitmap(), mapItem.getOriginRect(), mapItem.getMarkRect(), null);
            }
            if (mapItem.isCirclePoint()) {
                getTextPaint().setColor(-1);
                canvas2.drawCircle(location.x, location.y, this.f11767g, getPaint());
                canvas2.drawText(mapItem.getName(), location.x - (measureText / ((float) 2)), location.y - ((float) this.f11777q), getTextPaint());
            } else {
                float f = location.y - a;
                float f2 = measureText / ((float) 2);
                canvas.drawRoundRect((location.x - f2) - ((float) this.f11776p), f, location.x + f2 + ((float) this.f11776p), f + ((float) this.f11778r), (float) GloblaEx.m12810a(8.0f), (float) GloblaEx.m12810a(8.0f), getPaint());
                getTextPaint().setColor(GloblaEx.m12811a((int) R.color.blue_end));
                canvas2.drawText(mapItem.getName(), location.x - f2, location.y, getTextPaint());
            }
        }
        int b = m14286b();
        if (b != -1) {
            PointF location2 = ((MapItem) this.f11764d.get(b)).getLocation();
            int intrinsicWidth = (int) (location2.x - ((float) (getLocationBitmap().getIntrinsicWidth() / 2)));
            int a2 = (int) (location2.y - ((float) GloblaEx.m12810a(95.0f)));
            getLocationBitmap().setBounds(intrinsicWidth, a2, getLocationBitmap().getIntrinsicWidth() + intrinsicWidth, getLocationBitmap().getIntrinsicHeight() + a2);
            getLocationBitmap().draw(canvas2);
        }
    }

    /* renamed from: b */
    private final double m14285b(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow(((double) pointF.y) - ((double) pointF2.y), 2.0d) + Math.pow(((double) pointF.x) - ((double) pointF2.x), 2.0d));
    }

    /* renamed from: a */
    public final void mo21513a() {
        this.f11772l.clear();
        int b = m14286b();
        if (b != -1) {
            if (b > 0) {
                int i = 0;
                while (i < b) {
                    i++;
                    this.f11772l.add(m14284a(((MapItem) this.f11764d.get(i)).getLocation(), ((MapItem) this.f11764d.get(i)).getLocation()));
                }
            }
            PointF location = ((MapItem) this.f11764d.get(b)).getLocation();
            int c = m14287c();
            if (c != -1) {
                this.f11771k.set(m14284a(location, ((MapItem) this.f11764d.get(c)).getLocation()));
            }
            ViewParent parent = getParent();
            String str = "parent";
            C8271i.m35382a((Object) parent, str);
            if (parent.getParent() instanceof HorizontalScrollView) {
                ViewParent parent2 = getParent();
                C8271i.m35382a((Object) parent2, str);
                ViewParent parent3 = parent2.getParent();
                if (parent3 != null) {
                    ((HorizontalScrollView) parent3).scrollTo((int) (location.x - ((float) (GloblaEx.m12809a() / 2))), 0);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.HorizontalScrollView");
                }
            }
        }
        invalidate();
    }

    /* renamed from: b */
    private final int m14286b() {
        int i = 0;
        for (MapItem isCurCity : this.f11764d) {
            if (isCurCity.isCurCity()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: c */
    private final int m14287c() {
        int i = 0;
        for (MapItem isNextCity : this.f11764d) {
            if (isNextCity.isNextCity()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private|final */
    public final Bitmap getBgBitmap() {
        Options options = new Options();
        options.inSampleSize = this.f11779s;
        Context context = getContext();
        C8271i.m35382a((Object) context, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.bg_map, options);
        C8271i.m35382a((Object) decodeResource, "BitmapFactory.decodeReso…R.mipmap.bg_map, options)");
        return decodeResource;
    }
}
