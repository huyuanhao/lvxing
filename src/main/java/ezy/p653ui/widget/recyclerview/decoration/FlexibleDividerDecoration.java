package ezy.p653ui.widget.recyclerview.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;

/* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration */
public abstract class FlexibleDividerDecoration extends ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private static final int DEFAULT_SIZE = 2;
    protected ColorProvider mColorProvider;
    protected DividerType mDividerType = DividerType.DRAWABLE;
    protected DrawableProvider mDrawableProvider;
    private Paint mPaint;
    protected PaintProvider mPaintProvider;
    protected boolean mPositionInsideItem;
    protected boolean mShowLastDivider;
    protected SizeProvider mSizeProvider;
    protected VisibilityProvider mVisibilityProvider;

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$3 */
    static /* synthetic */ class C80483 {
        /* renamed from: $SwitchMap$ezy$ui$widget$recyclerview$decoration$FlexibleDividerDecoration$DividerType */
        static final /* synthetic */ int[] f27324x548eb709 = new int[DividerType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DividerType[] r0 = ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.DividerType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f27324x548eb709 = r0
            int[] r0 = f27324x548eb709     // Catch:{ NoSuchFieldError -> 0x0014 }
            ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DividerType r1 = ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.DividerType.DRAWABLE     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f27324x548eb709     // Catch:{ NoSuchFieldError -> 0x001f }
            ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DividerType r1 = ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.DividerType.PAINT     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f27324x548eb709     // Catch:{ NoSuchFieldError -> 0x002a }
            ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DividerType r1 = ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.DividerType.COLOR     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: ezy.p653ui.widget.recyclerview.decoration.FlexibleDividerDecoration.C80483.m54594clinit():void");
        }
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$Builder */
    public static class Builder<T extends Builder> {
        /* access modifiers changed from: private */
        public ColorProvider mColorProvider;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public DrawableProvider mDrawableProvider;
        /* access modifiers changed from: private */
        public PaintProvider mPaintProvider;
        /* access modifiers changed from: private */
        public boolean mPositionInsideItem = false;
        protected Resources mResources;
        /* access modifiers changed from: private */
        public boolean mShowLastDivider = false;
        /* access modifiers changed from: private */
        public SizeProvider mSizeProvider;
        /* access modifiers changed from: private */
        public VisibilityProvider mVisibilityProvider = new VisibilityProvider() {
            public boolean shouldHideDivider(int i, RecyclerView recyclerView) {
                return false;
            }
        };

        public Builder(Context context) {
            this.mContext = context;
            this.mResources = context.getResources();
        }

        public T paint(final Paint paint) {
            return paintProvider(new PaintProvider() {
                public Paint dividerPaint(int i, RecyclerView recyclerView) {
                    return paint;
                }
            });
        }

        public T paintProvider(PaintProvider paintProvider) {
            this.mPaintProvider = paintProvider;
            return this;
        }

        public T color(final int i) {
            return colorProvider(new ColorProvider() {
                public int dividerColor(int i, RecyclerView recyclerView) {
                    return i;
                }
            });
        }

        public T colorResId(int i) {
            return color(ContextCompat.getColor(this.mContext, i));
        }

        public T colorProvider(ColorProvider colorProvider) {
            this.mColorProvider = colorProvider;
            return this;
        }

        public T drawable(int i) {
            return drawable(ContextCompat.getDrawable(this.mContext, i));
        }

        public T drawable(final Drawable drawable) {
            return drawableProvider(new DrawableProvider() {
                public Drawable drawableProvider(int i, RecyclerView recyclerView) {
                    return drawable;
                }
            });
        }

        public T drawableProvider(DrawableProvider drawableProvider) {
            this.mDrawableProvider = drawableProvider;
            return this;
        }

        public T size(final int i) {
            return sizeProvider(new SizeProvider() {
                public int dividerSize(int i, RecyclerView recyclerView) {
                    return i;
                }
            });
        }

        public T sizeResId(int i) {
            return size(this.mResources.getDimensionPixelSize(i));
        }

        public T sizeProvider(SizeProvider sizeProvider) {
            this.mSizeProvider = sizeProvider;
            return this;
        }

        public T visibilityProvider(VisibilityProvider visibilityProvider) {
            this.mVisibilityProvider = visibilityProvider;
            return this;
        }

        public T showLastDivider() {
            this.mShowLastDivider = true;
            return this;
        }

        public T positionInsideItem(boolean z) {
            this.mPositionInsideItem = z;
            return this;
        }

        /* access modifiers changed from: protected */
        public void checkBuilderParams() {
            if (this.mPaintProvider == null) {
                return;
            }
            if (this.mColorProvider != null) {
                throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
            } else if (this.mSizeProvider != null) {
                throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
            }
        }
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$ColorProvider */
    public interface ColorProvider {
        int dividerColor(int i, RecyclerView recyclerView);
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DividerType */
    protected enum DividerType {
        DRAWABLE,
        PAINT,
        COLOR
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$DrawableProvider */
    public interface DrawableProvider {
        Drawable drawableProvider(int i, RecyclerView recyclerView);
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$PaintProvider */
    public interface PaintProvider {
        Paint dividerPaint(int i, RecyclerView recyclerView);
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$SizeProvider */
    public interface SizeProvider {
        int dividerSize(int i, RecyclerView recyclerView);
    }

    /* renamed from: ezy.ui.widget.recyclerview.decoration.FlexibleDividerDecoration$VisibilityProvider */
    public interface VisibilityProvider {
        boolean shouldHideDivider(int i, RecyclerView recyclerView);
    }

    public abstract Rect getDividerBound(int i, RecyclerView recyclerView, View view);

    public abstract void setItemOffsets(Rect rect, int i, RecyclerView recyclerView);

    protected FlexibleDividerDecoration(Builder builder) {
        if (builder.mPaintProvider != null) {
            this.mDividerType = DividerType.PAINT;
            this.mPaintProvider = builder.mPaintProvider;
        } else if (builder.mColorProvider != null) {
            this.mDividerType = DividerType.COLOR;
            this.mColorProvider = builder.mColorProvider;
            this.mPaint = new Paint();
            setSizeProvider(builder);
        } else {
            this.mDividerType = DividerType.DRAWABLE;
            if (builder.mDrawableProvider == null) {
                TypedArray obtainStyledAttributes = builder.mContext.obtainStyledAttributes(ATTRS);
                final Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                this.mDrawableProvider = new DrawableProvider() {
                    public Drawable drawableProvider(int i, RecyclerView recyclerView) {
                        return drawable;
                    }
                };
            } else {
                this.mDrawableProvider = builder.mDrawableProvider;
            }
            this.mSizeProvider = builder.mSizeProvider;
        }
        this.mVisibilityProvider = builder.mVisibilityProvider;
        this.mShowLastDivider = builder.mShowLastDivider;
        this.mPositionInsideItem = builder.mPositionInsideItem;
    }

    private void setSizeProvider(Builder builder) {
        this.mSizeProvider = builder.mSizeProvider;
        if (this.mSizeProvider == null) {
            this.mSizeProvider = new SizeProvider() {
                public int dividerSize(int i, RecyclerView recyclerView) {
                    return 2;
                }
            };
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int lastDividerOffset = getLastDividerOffset(recyclerView);
            int childCount = recyclerView.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition >= i) {
                    if ((this.mShowLastDivider || childAdapterPosition < itemCount - lastDividerOffset) && !wasDividerAlreadyDrawn(childAdapterPosition, recyclerView)) {
                        int groupIndex = getGroupIndex(childAdapterPosition, recyclerView);
                        if (!this.mVisibilityProvider.shouldHideDivider(groupIndex, recyclerView)) {
                            Rect dividerBound = getDividerBound(groupIndex, recyclerView, childAt);
                            int i3 = C80483.f27324x548eb709[this.mDividerType.ordinal()];
                            if (i3 == 1) {
                                Drawable drawableProvider = this.mDrawableProvider.drawableProvider(groupIndex, recyclerView);
                                drawableProvider.setBounds(dividerBound);
                                drawableProvider.draw(canvas);
                            } else if (i3 == 2) {
                                this.mPaint = this.mPaintProvider.dividerPaint(groupIndex, recyclerView);
                                canvas.drawLine((float) dividerBound.left, (float) dividerBound.top, (float) dividerBound.right, (float) dividerBound.bottom, this.mPaint);
                            } else if (i3 == 3) {
                                this.mPaint.setColor(this.mColorProvider.dividerColor(groupIndex, recyclerView));
                                this.mPaint.setStrokeWidth((float) this.mSizeProvider.dividerSize(groupIndex, recyclerView));
                                canvas.drawLine((float) dividerBound.left, (float) dividerBound.top, (float) dividerBound.right, (float) dividerBound.bottom, this.mPaint);
                            }
                        }
                    }
                    i = childAdapterPosition;
                }
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int lastDividerOffset = getLastDividerOffset(recyclerView);
        if (this.mShowLastDivider || childAdapterPosition < itemCount - lastDividerOffset) {
            int groupIndex = getGroupIndex(childAdapterPosition, recyclerView);
            if (!this.mVisibilityProvider.shouldHideDivider(groupIndex, recyclerView)) {
                setItemOffsets(rect, groupIndex, recyclerView);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isReverseLayout(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getReverseLayout();
        }
        return false;
    }

    private int getLastDividerOffset(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanCount = gridLayoutManager.getSpanCount();
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i = itemCount - 1; i >= 0; i--) {
                if (spanSizeLookup.getSpanIndex(i, spanCount) == 0) {
                    return itemCount - i;
                }
            }
        }
        return 1;
    }

    private boolean wasDividerAlreadyDrawn(int i, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager.getSpanSizeLookup().getSpanIndex(i, gridLayoutManager.getSpanCount()) > 0) {
            return true;
        }
        return false;
    }

    private int getGroupIndex(int i, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return i;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.getSpanSizeLookup().getSpanGroupIndex(i, gridLayoutManager.getSpanCount());
    }
}
