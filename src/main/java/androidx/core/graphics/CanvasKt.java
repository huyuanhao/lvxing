package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\b¨\u0006\u001e"}, mo39189d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Canvas.kt */
public final class CanvasKt {
    public static final void withSave(Canvas canvas, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withSave");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C8271i.m35386b(canvas, "$this$withTranslation");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withTranslation");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        C8271i.m35386b(canvas, "$this$withRotation");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withRotation");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        C8271i.m35386b(canvas, "$this$withScale");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withScale");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        C8271i.m35386b(canvas, "$this$withSkew");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withSkew");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        C8271i.m35386b(canvas, "$this$withMatrix");
        C8271i.m35386b(matrix, "matrix");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withMatrix");
        C8271i.m35386b(matrix, "matrix");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withClip(Canvas canvas, Rect rect, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withClip");
        C8271i.m35386b(rect, "clipRect");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withClip");
        C8271i.m35386b(rectF, "clipRect");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withClip");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withClip");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, C8247b<? super Canvas, Unit> bVar) {
        C8271i.m35386b(canvas, "$this$withClip");
        C8271i.m35386b(path, "clipPath");
        C8271i.m35386b(bVar, "block");
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            bVar.invoke(canvas);
        } finally {
            InlineMarker.m35375a(1);
            canvas.restoreToCount(save);
            InlineMarker.m35376b(1);
        }
    }
}
