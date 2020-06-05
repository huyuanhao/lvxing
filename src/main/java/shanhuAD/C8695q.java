package shanhuAD;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.tencent.p605ep.commonbase.utils.Tools;

/* renamed from: shanhuAD.q */
public class C8695q extends C8694p {
    /* renamed from: Jj */
    public static final String f29556Jj = "loadingtype";
    /* renamed from: Kj */
    public static final int f29557Kj = 1;
    /* renamed from: Lj */
    public static final int f29558Lj = 2;
    /* renamed from: Mj */
    public static final int f29559Mj = 3;
    /* renamed from: Nj */
    public static final int f29560Nj = 4;
    /* renamed from: Oj */
    public static final int f29561Oj = 5;
    /* renamed from: Pj */
    private static final float f29562Pj = ((float) Math.sqrt(3.0d));
    private static final String TAG = "q";
    /* renamed from: Qj */
    private Paint f29563Qj;
    /* renamed from: Rj */
    private Path f29564Rj;
    /* renamed from: Sj */
    private SweepGradient f29565Sj;
    /* renamed from: Tj */
    private int f29566Tj;
    /* renamed from: Uj */
    private int f29567Uj;
    /* renamed from: Vj */
    int f29568Vj = 0;
    /* renamed from: Wj */
    private volatile boolean f29569Wj = false;
    private int height;
    private Context mContext;
    Matrix mMatrix = new Matrix();
    private int mType;
    private int width;

    public C8695q(Context context, int i) {
        super(context);
        this.mContext = context;
        init(i);
        setLoadingViewByType(i);
    }

    /* renamed from: R */
    private Path m37711R(int i) {
        Path path = new Path();
        float f = (float) i;
        float f2 = (f29562Pj * f) / 2.0f;
        path.moveTo(0.0f, f);
        float f3 = 0.0f - f2;
        int i2 = i / 2;
        float f4 = (float) i2;
        path.lineTo(f3, f4);
        float f5 = (float) (0 - i2);
        path.lineTo(f3, f5);
        path.lineTo(0.0f, (float) (0 - i));
        path.lineTo(f2, f5);
        path.lineTo(f2, f4);
        path.close();
        return path;
    }

    private void init(int i) {
        this.f29564Rj = new Path();
        this.f29563Qj = new Paint();
        this.f29563Qj.setStrokeWidth((float) Tools.dip2px(this.mContext, 2.0f));
        this.f29563Qj.setStyle(Style.STROKE);
        this.f29563Qj.setAntiAlias(true);
        if (i == 4 || i == 5) {
            this.f29565Sj = new SweepGradient(0.0f, 0.0f, 16777215, -2130706433);
        } else {
            this.f29565Sj = new SweepGradient(0.0f, 0.0f, 0, 855638016);
        }
        this.f29563Qj.setShader(this.f29565Sj);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        mo41484vb();
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((float) this.f29566Tj, (float) this.f29567Uj);
        this.mMatrix.setRotate((float) this.f29568Vj);
        this.f29565Sj.setLocalMatrix(this.mMatrix);
        canvas.drawPath(this.f29564Rj, this.f29563Qj);
        this.f29568Vj += 6;
        if (this.f29568Vj >= 360) {
            this.f29568Vj = 0;
        }
        if (this.f29569Wj) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.width, this.height);
    }

    public void setLoadingViewByType(int i) {
        this.mType = i;
        if (i == 1) {
            this.width = Tools.dip2px(this.mContext, 38.0f);
            this.height = this.width;
        } else if (i == 2) {
            this.width = Tools.dip2px(this.mContext, 26.0f);
            this.height = this.width;
        } else if (i == 3) {
            this.width = Tools.dip2px(this.mContext, 26.0f);
            this.height = this.width;
        } else if (i == 4) {
            this.f29565Sj = new SweepGradient(0.0f, 0.0f, 16777215, -2130706433);
            this.f29563Qj.setShader(this.f29565Sj);
            this.width = Tools.dip2px(this.mContext, 26.0f);
            this.height = this.width;
        } else if (i == 5) {
            this.f29565Sj = new SweepGradient(0.0f, 0.0f, 16777215, -2130706433);
            this.f29563Qj.setShader(this.f29565Sj);
            this.width = Tools.dip2px(this.mContext, 38.0f);
            this.height = this.width;
        }
        this.f29566Tj = this.width / 2;
        this.f29567Uj = this.height / 2;
        int i2 = this.f29566Tj;
        int i3 = this.f29567Uj;
        if (i2 > i3) {
            i2 = i3;
        }
        this.f29564Rj = m37711R(i2 - 5);
        mo41484vb();
    }

    /* renamed from: vb */
    public void mo41484vb() {
        this.f29569Wj = true;
        postInvalidate();
    }

    /* renamed from: wb */
    public void mo41485wb() {
        this.f29569Wj = false;
    }

    public C8695q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init(5);
        setLoadingViewByType(5);
    }
}
