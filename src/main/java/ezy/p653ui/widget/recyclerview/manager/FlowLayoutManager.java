package ezy.p653ui.widget.recyclerview.manager;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;

/* renamed from: ezy.ui.widget.recyclerview.manager.FlowLayoutManager */
public final class FlowLayoutManager extends LayoutManager {
    private static final String TAG = FlowLayoutManager.class.getSimpleName();
    private final SparseArray<Rect> mItemRects = new SparseArray<>();
    private int mVerticalOffset = 0;

    public boolean canScrollVertically() {
        return true;
    }

    public FlowLayoutManager() {
        setAutoMeasureEnabled(true);
    }

    public FlowLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        setAutoMeasureEnabled(true);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
        } else if (getChildCount() != 0 || !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            layout(recycler, state, 0);
        }
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        if (i == 0 || getChildCount() == 0) {
            return 0;
        }
        int i2 = this.mVerticalOffset;
        if (i2 + i >= 0) {
            if (i > 0) {
                View childAt = getChildAt(getChildCount() - 1);
                if (getPosition(childAt) == getItemCount() - 1) {
                    int decoratedBottom = getDecoratedBottom(childAt);
                    int decoratedTop = getDecoratedTop(childAt);
                    int childCount = getChildCount() - 2;
                    while (childCount >= 0 && getDecoratedTop(getChildAt(childCount)) == decoratedTop) {
                        decoratedBottom = Math.max(decoratedBottom, getDecoratedBottom(getChildAt(childCount)));
                        childCount--;
                    }
                    i2 = (getHeight() - getPaddingBottom()) - decoratedBottom;
                    if (i2 <= 0) {
                        if (i2 == 0) {
                            i = 0;
                        } else {
                            i = Math.min(i, -i2);
                        }
                    }
                }
            }
            int layout = layout(recycler, state, i);
            this.mVerticalOffset += layout;
            offsetChildrenVertical(-layout);
            return layout;
        }
        i = -i2;
        int layout2 = layout(recycler, state, i);
        this.mVerticalOffset += layout2;
        offsetChildrenVertical(-layout2);
        return layout2;
    }

    private int layout(Recycler recycler, State state, int i) {
        int i2;
        int i3;
        Recycler recycler2 = recycler;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int childCount = getChildCount();
        if (childCount > 0) {
            if (i > 0) {
                while (childCount > 0) {
                    View childAt = getChildAt(0);
                    if (getDecoratedBottom(childAt) - i >= paddingTop) {
                        break;
                    }
                    removeAndRecycleView(childAt, recycler2);
                    childCount--;
                }
            } else if (i < 0) {
                for (int i4 = childCount - 1; i4 >= 0; i4--) {
                    View childAt2 = getChildAt(i4);
                    if (getDecoratedTop(childAt2) - i <= getHeight() - getPaddingBottom()) {
                        break;
                    }
                    removeAndRecycleView(childAt2, recycler2);
                }
            }
        }
        if (i >= 0) {
            if (getChildCount() > 0) {
                View childAt3 = getChildAt(getChildCount() - 1);
                int decoratedTop = getDecoratedTop(childAt3);
                int decoratedRight = getDecoratedRight(childAt3);
                i2 = getPosition(childAt3) + 1;
                int max = Math.max(0, getDecoratedMeasurementVertical(childAt3));
                for (int childCount2 = getChildCount() - 2; childCount2 >= 0; childCount2--) {
                    View childAt4 = getChildAt(childCount2);
                    if (getDecoratedTop(childAt4) != decoratedTop) {
                        break;
                    }
                    max = Math.max(max, getDecoratedMeasurementVertical(childAt4));
                }
                int i5 = decoratedRight;
                i3 = max;
                paddingTop = decoratedTop;
                paddingLeft = i5;
            } else {
                i3 = 0;
                i2 = 0;
            }
            int i6 = paddingTop;
            int i7 = paddingLeft;
            int i8 = i3;
            int i9 = i2;
            while (true) {
                if (i9 >= getItemCount()) {
                    break;
                }
                View viewForPosition = recycler2.getViewForPosition(i9);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasurementHorizontal = getDecoratedMeasurementHorizontal(viewForPosition);
                int decoratedMeasurementVertical = getDecoratedMeasurementVertical(viewForPosition);
                int i10 = i7 + decoratedMeasurementHorizontal;
                if (i10 <= getHorizontalSpace()) {
                    int i11 = i6 + decoratedMeasurementVertical;
                    layoutDecoratedWithMargins(viewForPosition, i7, i6, i10, i11);
                    int i12 = this.mVerticalOffset;
                    this.mItemRects.put(i9, new Rect(i7, i6 + i12, i10, i11 + i12));
                    i8 = Math.max(i8, decoratedMeasurementVertical);
                    i7 = i10;
                } else {
                    int i13 = i6 + i8;
                    int paddingLeft2 = getPaddingLeft();
                    if (i13 - i > getHeight() - getPaddingBottom()) {
                        removeAndRecycleView(viewForPosition, recycler2);
                        break;
                    }
                    int i14 = paddingLeft2 + decoratedMeasurementHorizontal;
                    int i15 = i13 + decoratedMeasurementVertical;
                    layoutDecoratedWithMargins(viewForPosition, paddingLeft2, i13, i14, i15);
                    int i16 = this.mVerticalOffset;
                    this.mItemRects.put(i9, new Rect(paddingLeft2, i13 + i16, i14, i15 + i16));
                    i6 = i13;
                    i7 = i14;
                    i8 = Math.max(0, decoratedMeasurementVertical);
                }
                i9++;
            }
        } else {
            int itemCount = getItemCount() - 1;
            if (getChildCount() > 0) {
                itemCount = getPosition(getChildAt(0)) - 1;
            }
            for (int i17 = itemCount; i17 >= 0; i17--) {
                Rect rect = (Rect) this.mItemRects.get(i17);
                if ((rect.bottom - this.mVerticalOffset) - i >= getPaddingTop()) {
                    View viewForPosition2 = recycler2.getViewForPosition(i17);
                    addView(viewForPosition2, 0);
                    measureChildWithMargins(viewForPosition2, 0, 0);
                    layoutDecoratedWithMargins(viewForPosition2, rect.left, rect.top - this.mVerticalOffset, rect.right, rect.bottom - this.mVerticalOffset);
                }
            }
        }
        return i;
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        this.mVerticalOffset = 0;
        this.mItemRects.clear();
    }

    private int getDecoratedMeasurementHorizontal(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    private int getDecoratedMeasurementVertical(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private int getHorizontalSpace() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }
}
