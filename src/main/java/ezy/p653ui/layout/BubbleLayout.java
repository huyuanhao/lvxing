package ezy.p653ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import reezy.lib.common.R;

/* renamed from: ezy.ui.layout.BubbleLayout */
public class BubbleLayout extends FrameLayout {
    public static final int BOTTOM = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int TOP = 2;
    private Paint mBorderPaint;
    private Point mDatumPoint;
    private int mDirection;
    private int mOffset;
    private Path mPath;
    private int mRadius;
    private RectF mRect;

    /* renamed from: ezy.ui.layout.BubbleLayout$Direction */
    private @interface Direction {
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        int color = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_blBackgroundColor, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_blShadowColor, Color.parseColor("#999999"));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BubbleLayout_blShadowSize, (int) TypedValue.applyDimension(0, 4.0f, getResources().getDisplayMetrics()));
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BubbleLayout_blCornerRadius, 0);
        this.mDirection = obtainStyledAttributes.getInt(R.styleable.BubbleLayout_blDirection, 4);
        this.mOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BubbleLayout_blOffset, 0);
        obtainStyledAttributes.recycle();
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(color);
        this.mBorderPaint.setShadowLayer((float) dimensionPixelSize, 0.0f, 0.0f, color2);
        this.mPath = new Path();
        this.mRect = new RectF();
        this.mDatumPoint = new Point();
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDatumPoint.x > 0 && this.mDatumPoint.y > 0) {
            int i = this.mDirection;
            if (i == 1) {
                drawLeftTriangle(canvas);
            } else if (i == 2) {
                drawTopTriangle(canvas);
            } else if (i == 3) {
                drawRightTriangle(canvas);
            } else if (i == 4) {
                drawBottomTriangle(canvas);
            }
        }
    }

    private void drawLeftTriangle(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        if (paddingLeft != 0) {
            Path path = this.mPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, (float) i, (float) i, android.graphics.Path.Direction.CCW);
            int i2 = paddingLeft / 2;
            this.mPath.moveTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y - i2));
            this.mPath.lineTo((float) (this.mDatumPoint.x - i2), (float) this.mDatumPoint.y);
            this.mPath.lineTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y + i2));
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
    }

    private void drawTopTriangle(Canvas canvas) {
        int paddingTop = getPaddingTop();
        if (paddingTop != 0) {
            Path path = this.mPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, (float) i, (float) i, android.graphics.Path.Direction.CCW);
            int i2 = paddingTop / 2;
            this.mPath.moveTo((float) (this.mDatumPoint.x + i2), (float) this.mDatumPoint.y);
            this.mPath.lineTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y - i2));
            this.mPath.lineTo((float) (this.mDatumPoint.x - i2), (float) this.mDatumPoint.y);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
    }

    private void drawRightTriangle(Canvas canvas) {
        int paddingRight = getPaddingRight();
        if (paddingRight != 0) {
            Path path = this.mPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, (float) i, (float) i, android.graphics.Path.Direction.CCW);
            int i2 = paddingRight / 2;
            this.mPath.moveTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y - i2));
            this.mPath.lineTo((float) (this.mDatumPoint.x + i2), (float) this.mDatumPoint.y);
            this.mPath.lineTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y + i2));
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
    }

    private void drawBottomTriangle(Canvas canvas) {
        int paddingBottom = getPaddingBottom();
        if (paddingBottom != 0) {
            Path path = this.mPath;
            RectF rectF = this.mRect;
            int i = this.mRadius;
            path.addRoundRect(rectF, (float) i, (float) i, android.graphics.Path.Direction.CCW);
            int i2 = paddingBottom / 2;
            this.mPath.moveTo((float) (this.mDatumPoint.x + i2), (float) this.mDatumPoint.y);
            this.mPath.lineTo((float) this.mDatumPoint.x, (float) (this.mDatumPoint.y + i2));
            this.mPath.lineTo((float) (this.mDatumPoint.x - i2), (float) this.mDatumPoint.y);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRect.left = (float) getPaddingLeft();
        this.mRect.top = (float) getPaddingTop();
        this.mRect.right = (float) (i - getPaddingRight());
        this.mRect.bottom = (float) (i2 - getPaddingBottom());
        int i5 = this.mDirection;
        if (i5 == 1) {
            this.mDatumPoint.x = getPaddingLeft();
            this.mDatumPoint.y = i2 / 2;
        } else if (i5 == 2) {
            Point point = this.mDatumPoint;
            point.x = i / 2;
            point.y = getPaddingTop();
        } else if (i5 == 3) {
            this.mDatumPoint.x = i - getPaddingRight();
            this.mDatumPoint.y = i2 / 2;
        } else if (i5 == 4) {
            Point point2 = this.mDatumPoint;
            point2.x = i / 2;
            point2.y = i2 - getPaddingBottom();
        }
        if (this.mOffset != 0) {
            applyOffset();
        }
    }

    public void setTriangleOffset(int i) {
        this.mOffset = i;
        applyOffset();
        invalidate();
    }

    private void applyOffset() {
        int i = this.mDirection;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            this.mDatumPoint.x += this.mOffset;
            return;
        }
        this.mDatumPoint.y += this.mOffset;
    }
}
