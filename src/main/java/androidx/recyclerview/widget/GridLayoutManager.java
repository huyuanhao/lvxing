package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$DefaultSpanSizeLookup */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanSize(int i) {
            return 1;
        }

        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$LayoutParams */
    public static class LayoutParams extends androidx.recyclerview.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup */
    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        /* access modifiers changed from: 0000 */
        public int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        /* access modifiers changed from: 0000 */
        public int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[RETURN] */
        public int getSpanIndex(int r6, int r7) {
            /*
            r5 = this;
            int r0 = r5.getSpanSize(r6)
            r1 = 0
            if (r0 != r7) goto L_0x0008
            return r1
        L_0x0008:
            boolean r2 = r5.mCacheSpanIndices
            if (r2 == 0) goto L_0x0020
            android.util.SparseIntArray r2 = r5.mSpanIndexCache
            int r2 = findFirstKeyLessThan(r2, r6)
            if (r2 < 0) goto L_0x0020
            android.util.SparseIntArray r3 = r5.mSpanIndexCache
            int r3 = r3.get(r2)
            int r4 = r5.getSpanSize(r2)
            int r3 = r3 + r4
            goto L_0x0030
        L_0x0020:
            r2 = 0
            r3 = 0
        L_0x0022:
            if (r2 >= r6) goto L_0x0033
            int r4 = r5.getSpanSize(r2)
            int r3 = r3 + r4
            if (r3 != r7) goto L_0x002d
            r3 = 0
            goto L_0x0030
        L_0x002d:
            if (r3 <= r7) goto L_0x0030
            r3 = r4
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0033:
            int r0 = r0 + r3
            if (r0 > r7) goto L_0x0037
            return r3
        L_0x0037:
            return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        public int getSpanGroupIndex(int r7, int r8) {
            /*
            r6 = this;
            boolean r0 = r6.mCacheSpanGroupIndices
            r1 = 0
            if (r0 == 0) goto L_0x0026
            android.util.SparseIntArray r0 = r6.mSpanGroupIndexCache
            int r0 = findFirstKeyLessThan(r0, r7)
            r2 = -1
            if (r0 == r2) goto L_0x0026
            android.util.SparseIntArray r2 = r6.mSpanGroupIndexCache
            int r2 = r2.get(r0)
            int r3 = r0 + 1
            int r4 = r6.getCachedSpanIndex(r0, r8)
            int r0 = r6.getSpanSize(r0)
            int r0 = r0 + r4
            if (r0 != r8) goto L_0x0029
            int r0 = r2 + 1
            r2 = r0
            r0 = 0
            goto L_0x0029
        L_0x0026:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0029:
            int r4 = r6.getSpanSize(r7)
        L_0x002d:
            if (r3 >= r7) goto L_0x0042
            int r5 = r6.getSpanSize(r3)
            int r0 = r0 + r5
            if (r0 != r8) goto L_0x003a
            int r2 = r2 + 1
            r0 = 0
            goto L_0x003f
        L_0x003a:
            if (r0 <= r8) goto L_0x003f
            int r2 = r2 + 1
            r0 = r5
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0042:
            int r0 = r0 + r4
            if (r0 <= r8) goto L_0x0047
            int r2 = r2 + 1
        L_0x0047:
            return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanGroupIndex(int, int):int");
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }

    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getColumnCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        calculateItemBorders(i2 - i);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i4 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i3 = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i3 = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i4 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: 0000 */
    public int getSpaceForSpanRange(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i3 = this.mSpanCount;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* access modifiers changed from: 0000 */
    public void onAnchorReady(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
        }
        ensureViewSet();
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    private void ensureAnchorIsInCorrectSpan(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
        boolean z = i == 1;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z) {
            while (spanIndex > 0 && anchorInfo.mPosition > 0) {
                anchorInfo.mPosition--;
                spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i2 = anchorInfo.mPosition;
        while (i2 < itemCount) {
            int i3 = i2 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i3);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i2 = i3;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i2;
    }

    /* access modifiers changed from: 0000 */
    public View findReferenceChild(Recycler recycler, State state, int i, int i2, int i3) {
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && getSpanIndex(recycler, state, position) == 0) {
                if (((androidx.recyclerview.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private int getSpanGroupIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(i);
        Log.w(TAG, sb.toString());
        return 0;
    }

    private int getSpanIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i);
        Log.w(TAG, sb.toString());
        return 0;
    }

    private int getSpanSize(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i);
        Log.w(TAG, sb.toString());
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public void collectPrefetchPositionsForLayoutState(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i2++) {
            int i3 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, layoutState.mScrollingOffset));
            i -= this.mSpanSizeLookup.getSpanSize(i3);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    /* access modifiers changed from: 0000 */
    public void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Recycler recycler2 = recycler;
        State state2 = state;
        LayoutState layoutState2 = layoutState;
        LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z = false;
        boolean z2 = modeInOther != 1073741824;
        int i12 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = layoutState2.mItemDirection == 1;
        int i13 = this.mSpanCount;
        if (!z3) {
            i13 = getSpanIndex(recycler2, state2, layoutState2.mCurrentPosition) + getSpanSize(recycler2, state2, layoutState2.mCurrentPosition);
        }
        int i14 = i13;
        int i15 = 0;
        while (i15 < this.mSpanCount && layoutState2.hasMore(state2) && i14 > 0) {
            int i16 = layoutState2.mCurrentPosition;
            int spanSize = getSpanSize(recycler2, state2, i16);
            if (spanSize <= this.mSpanCount) {
                i14 -= spanSize;
                if (i14 < 0) {
                    break;
                }
                View next = layoutState2.next(recycler2);
                if (next == null) {
                    break;
                }
                this.mSet[i15] = next;
                i15++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(i16);
                sb.append(" requires ");
                sb.append(spanSize);
                sb.append(" spans but GridLayoutManager has only ");
                sb.append(this.mSpanCount);
                sb.append(" spans.");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i15 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        float f = 0.0f;
        assignSpans(recycler2, state2, i15, z3);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i15) {
            View view = this.mSet[i17];
            if (layoutState2.mScrapList == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, z);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, z);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i18) {
                i18 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
            i17++;
            z = false;
        }
        if (z2) {
            guessMeasurement(f, i12);
            int i19 = 0;
            for (int i20 = 0; i20 < i15; i20++) {
                View view2 = this.mSet[i20];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i19) {
                    i19 = decoratedMeasurement2;
                }
            }
        }
        for (int i21 = 0; i21 < i15; i21++) {
            View view3 = this.mSet[i21];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i22 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i23 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i11 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i23, layoutParams.width, false);
                    i10 = MeasureSpec.makeMeasureSpec(i - i22, 1073741824);
                } else {
                    int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i - i23, 1073741824);
                    i10 = getChildMeasureSpec(spaceForSpanRange, 1073741824, i22, layoutParams.height, false);
                    i11 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i11, i10, true);
            }
        }
        int i24 = 0;
        layoutChunkResult2.mConsumed = i;
        if (this.mOrientation == 1) {
            if (layoutState2.mLayoutDirection == -1) {
                int i25 = layoutState2.mOffset;
                i4 = i25 - i;
                i3 = i25;
            } else {
                int i26 = layoutState2.mOffset;
                i3 = i26 + i;
                i4 = i26;
            }
            i5 = 0;
            i2 = 0;
        } else if (layoutState2.mLayoutDirection == -1) {
            i2 = layoutState2.mOffset;
            i5 = i2 - i;
            i4 = 0;
            i3 = 0;
        } else {
            int i27 = layoutState2.mOffset;
            int i28 = i27 + i;
            i4 = 0;
            i3 = 0;
            int i29 = i27;
            i2 = i28;
            i5 = i29;
        }
        while (i24 < i15) {
            View view4 = this.mSet[i24];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i9 = i5;
                i8 = paddingTop;
                i6 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
                i7 = i2;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i7 = paddingLeft;
                i8 = i4;
                i6 = i3;
                i9 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
            } else {
                int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i9 = paddingLeft2;
                i8 = i4;
                i6 = i3;
                i7 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft2;
            }
            layoutDecoratedWithMargins(view4, i9, i8, i7, i6);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable |= view4.hasFocusable();
            i24++;
            i5 = i9;
            i4 = i8;
            i2 = i7;
            i3 = i6;
        }
        Arrays.fill(this.mSet, null);
    }

    private void measureChild(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i2 = getChildMeasureSpec(spaceForSpanRange, i, i5, layoutParams.width, false);
            i3 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i4, layoutParams.height, true);
        } else {
            int childMeasureSpec = getChildMeasureSpec(spaceForSpanRange, i, i4, layoutParams.height, false);
            int childMeasureSpec2 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i5, layoutParams.width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i2, i3, z);
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * ((float) this.mSpanCount)), i));
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        boolean z2;
        androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            z2 = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void assignSpans(Recycler recycler, State state, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = i - 1;
            i2 = -1;
        }
        for (i3 = 
/*
Method generation error in method: androidx.recyclerview.widget.GridLayoutManager.assignSpans(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, boolean):void, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r7v1 'i3' int) = (r7v4 'i3' int), (r7v5 'i3' int) binds: {(r7v4 'i3' int)=B:3:0x0009, (r7v5 'i3' int)=B:2:0x0004} in method: androidx.recyclerview.widget.GridLayoutManager.assignSpans(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, boolean):void, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:193)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:36)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:536)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:508)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:232)
	... 14 more

*/

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i >= 1) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Span count should be at least 1. Provided ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d7, code lost:
            if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f7, code lost:
            if (r13 == r10) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0105  */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.Recycler r25, androidx.recyclerview.widget.RecyclerView.State r26) {
        /*
        r22 = this;
        r0 = r22
        r1 = r25
        r2 = r26
        android.view.View r3 = r22.findContainingItemView(r23)
        r4 = 0
        if (r3 != 0) goto L_0x000e
        return r4
    L_0x000e:
        android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
        androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
        int r6 = r5.mSpanIndex
        int r7 = r5.mSpanIndex
        int r5 = r5.mSpanSize
        int r7 = r7 + r5
        android.view.View r5 = super.onFocusSearchFailed(r23, r24, r25, r26)
        if (r5 != 0) goto L_0x0022
        return r4
    L_0x0022:
        r5 = r24
        int r5 = r0.convertFocusDirectionToLayoutDirection(r5)
        r9 = 1
        if (r5 != r9) goto L_0x002d
        r5 = 1
        goto L_0x002e
    L_0x002d:
        r5 = 0
    L_0x002e:
        boolean r10 = r0.mShouldReverseLayout
        if (r5 == r10) goto L_0x0034
        r5 = 1
        goto L_0x0035
    L_0x0034:
        r5 = 0
    L_0x0035:
        r10 = -1
        if (r5 == 0) goto L_0x0040
        int r5 = r22.getChildCount()
        int r5 = r5 - r9
        r11 = -1
        r12 = -1
        goto L_0x0047
    L_0x0040:
        int r5 = r22.getChildCount()
        r11 = r5
        r5 = 0
        r12 = 1
    L_0x0047:
        int r13 = r0.mOrientation
        if (r13 != r9) goto L_0x0053
        boolean r13 = r22.isLayoutRTL()
        if (r13 == 0) goto L_0x0053
        r13 = 1
        goto L_0x0054
    L_0x0053:
        r13 = 0
    L_0x0054:
        int r14 = r0.getSpanGroupIndex(r1, r2, r5)
        r10 = r4
        r8 = -1
        r15 = 0
        r16 = 0
        r17 = -1
    L_0x005f:
        if (r5 == r11) goto L_0x0145
        int r9 = r0.getSpanGroupIndex(r1, r2, r5)
        android.view.View r1 = r0.getChildAt(r5)
        if (r1 != r3) goto L_0x006d
        goto L_0x0145
    L_0x006d:
        boolean r18 = r1.hasFocusable()
        if (r18 == 0) goto L_0x0087
        if (r9 == r14) goto L_0x0087
        if (r4 == 0) goto L_0x0079
        goto L_0x0145
    L_0x0079:
        r18 = r3
        r20 = r8
        r23 = r10
        r19 = r11
        r8 = r16
        r11 = r17
        goto L_0x0131
    L_0x0087:
        android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
        androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
        int r2 = r9.mSpanIndex
        r18 = r3
        int r3 = r9.mSpanIndex
        r19 = r11
        int r11 = r9.mSpanSize
        int r3 = r3 + r11
        boolean r11 = r1.hasFocusable()
        if (r11 == 0) goto L_0x00a3
        if (r2 != r6) goto L_0x00a3
        if (r3 != r7) goto L_0x00a3
        return r1
    L_0x00a3:
        boolean r11 = r1.hasFocusable()
        if (r11 == 0) goto L_0x00ab
        if (r4 == 0) goto L_0x00b3
    L_0x00ab:
        boolean r11 = r1.hasFocusable()
        if (r11 != 0) goto L_0x00bd
        if (r10 != 0) goto L_0x00bd
    L_0x00b3:
        r20 = r8
        r23 = r10
        r8 = r16
        r11 = r17
    L_0x00bb:
        r10 = 1
        goto L_0x0103
    L_0x00bd:
        int r11 = java.lang.Math.max(r2, r6)
        int r20 = java.lang.Math.min(r3, r7)
        int r11 = r20 - r11
        boolean r20 = r1.hasFocusable()
        if (r20 == 0) goto L_0x00da
        if (r11 <= r15) goto L_0x00d0
        goto L_0x00b3
    L_0x00d0:
        if (r11 != r15) goto L_0x00fa
        if (r2 <= r8) goto L_0x00d6
        r11 = 1
        goto L_0x00d7
    L_0x00d6:
        r11 = 0
    L_0x00d7:
        if (r13 != r11) goto L_0x00fa
        goto L_0x00b3
    L_0x00da:
        if (r4 != 0) goto L_0x00fa
        r20 = r8
        r23 = r10
        r8 = 0
        r10 = 1
        boolean r21 = r0.isViewPartiallyVisible(r1, r8, r10)
        r8 = r16
        if (r21 == 0) goto L_0x0100
        if (r11 <= r8) goto L_0x00ef
        r11 = r17
        goto L_0x0103
    L_0x00ef:
        if (r11 != r8) goto L_0x0100
        r11 = r17
        if (r2 <= r11) goto L_0x00f6
        goto L_0x00f7
    L_0x00f6:
        r10 = 0
    L_0x00f7:
        if (r13 != r10) goto L_0x0102
        goto L_0x00bb
    L_0x00fa:
        r20 = r8
        r23 = r10
        r8 = r16
    L_0x0100:
        r11 = r17
    L_0x0102:
        r10 = 0
    L_0x0103:
        if (r10 == 0) goto L_0x0131
        boolean r10 = r1.hasFocusable()
        if (r10 == 0) goto L_0x0120
        int r4 = r9.mSpanIndex
        int r3 = java.lang.Math.min(r3, r7)
        int r2 = java.lang.Math.max(r2, r6)
        int r3 = r3 - r2
        r10 = r23
        r15 = r3
        r16 = r8
        r17 = r11
        r8 = r4
        r4 = r1
        goto L_0x0139
    L_0x0120:
        int r8 = r9.mSpanIndex
        int r3 = java.lang.Math.min(r3, r7)
        int r2 = java.lang.Math.max(r2, r6)
        int r3 = r3 - r2
        r10 = r1
        r16 = r3
        r17 = r8
        goto L_0x0137
    L_0x0131:
        r10 = r23
        r16 = r8
        r17 = r11
    L_0x0137:
        r8 = r20
    L_0x0139:
        int r5 = r5 + r12
        r1 = r25
        r2 = r26
        r3 = r18
        r11 = r19
        r9 = 1
        goto L_0x005f
    L_0x0145:
        r23 = r10
        if (r4 == 0) goto L_0x014a
        goto L_0x014c
    L_0x014a:
        r4 = r23
    L_0x014c:
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public int computeHorizontalScrollRange(State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollRange(State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    public int computeHorizontalScrollOffset(State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeVerticalScrollOffset(State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    private int computeScrollRangeWithSpanInfo(State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) decoratedEnd) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private int computeScrollOffsetWithSpanInfo(State state) {
        int i;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i;
                }
                return Math.round((((float) i) * (((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }
}
