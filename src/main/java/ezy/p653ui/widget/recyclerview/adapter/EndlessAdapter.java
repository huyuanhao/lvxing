package ezy.p653ui.widget.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolderProvider;
import ezy.p653ui.widget.recyclerview.holder.ItemType;

/* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter */
public class EndlessAdapter extends MultiTypeAdapter {
    public static final int STATUS_ENDED = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_LOADING = 0;
    public static final int TYPE_FOOTER = -2;
    int mLoadMoreBackgroundColor = 0;
    LoadMoreState mLoadMoreState = new LoadMoreState();
    private final ItemType mLoadMoreType = new ItemType<LoadMoreState, ItemHolder>(LoadMoreState.class) {
        public ItemHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            if (EndlessAdapter.this.vLoadMore == null) {
                EndlessAdapter endlessAdapter = EndlessAdapter.this;
                endlessAdapter.vLoadMore = new LoadMoreView(viewGroup.getContext());
            }
            return new ItemHolder(EndlessAdapter.this.vLoadMore);
        }

        public void bind(ItemHolder itemHolder, LoadMoreState loadMoreState) {
            LoadMoreView loadMoreView = (LoadMoreView) itemHolder.itemView;
            loadMoreView.setStatus(loadMoreState.getStatus());
            loadMoreView.setVisible(loadMoreState.getVisible());
        }
    };
    /* access modifiers changed from: private */
    public String noMoreText = "没有更多数据了";
    OnLoadMoreInflater onLoadMoreInflater;
    OnLoadMoreListener onLoadMoreListener;
    OnLoadMoreScrollListener onLoadMoreScrollListener = new OnLoadMoreScrollListener();
    LoadMoreView vLoadMore;
    RecyclerView vRecyclerView;

    /* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter$LoadMoreState */
    static class LoadMoreState {
        int mStatus = 1;
        boolean mVisible = true;

        LoadMoreState() {
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public void setVisible(boolean z) {
            this.mVisible = z;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public boolean getVisible() {
            return this.mVisible;
        }
    }

    /* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter$LoadMoreView */
    class LoadMoreView extends FrameLayout implements OnLoadMoreInflater {
        int mStatus = -1;
        SparseArray<View> mViews = new SparseArray<>();

        public LoadMoreView(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, -2));
            setBackgroundColor(EndlessAdapter.this.mLoadMoreBackgroundColor);
        }

        public View onInflate(ViewGroup viewGroup, int i) {
            if (EndlessAdapter.this.onLoadMoreInflater != null) {
                View onInflate = EndlessAdapter.this.onLoadMoreInflater.onInflate(viewGroup, i);
                if (onInflate != null) {
                    return onInflate;
                }
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (getResources().getDisplayMetrics().density * 60.0f)));
            if (i == 1) {
                TextView textView = new TextView(viewGroup.getContext());
                textView.setGravity(17);
                textView.setTextColor(Color.parseColor("#ff999999"));
                textView.setTextSize(12.0f);
                textView.setText(EndlessAdapter.this.noMoreText);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -1, 17.0f));
            } else if (i != 2) {
                ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
                progressBar.setIndeterminate(true);
                linearLayout.addView(progressBar, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            } else {
                TextView textView2 = new TextView(viewGroup.getContext());
                textView2.setGravity(17);
                textView2.setText("似乎出了点问题，点击重新加载");
                textView2.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (EndlessAdapter.this.onLoadMoreListener != null) {
                            EndlessAdapter.this.onLoadMoreListener.onLoadMore();
                        }
                    }
                });
                linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -1, 17.0f));
            }
            return linearLayout;
        }

        public void setStatus(int i) {
            int i2 = this.mStatus;
            if (i2 != i) {
                View view = (View) this.mViews.get(i2);
                if (view != null) {
                    view.setVisibility(8);
                }
                View view2 = (View) this.mViews.get(i);
                if (view2 != null) {
                    view2.setVisibility(0);
                } else {
                    View onInflate = onInflate(this, i);
                    if (onInflate != null) {
                        onInflate.setVisibility(0);
                        addView(onInflate);
                        this.mViews.put(i, onInflate);
                    }
                }
                this.mStatus = i;
            }
        }

        public void setVisible(boolean z) {
            setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter$OnLoadMoreInflater */
    public interface OnLoadMoreInflater {
        View onInflate(ViewGroup viewGroup, int i);
    }

    /* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter$OnLoadMoreListener */
    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    /* renamed from: ezy.ui.widget.recyclerview.adapter.EndlessAdapter$OnLoadMoreScrollListener */
    class OnLoadMoreScrollListener extends OnScrollListener implements OnScrollChangeListener {
        boolean mHasMore = false;
        boolean mIsLoading = false;
        int mVisibleThreshold = 3;

        OnLoadMoreScrollListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("===> state = ");
                sb.append(i);
                Log.e("ezy", sb.toString());
                scroll(recyclerView);
            }
        }

        private void scroll(RecyclerView recyclerView) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                scroll(recyclerView.getChildCount(), linearLayoutManager.getItemCount(), linearLayoutManager.findLastVisibleItemPosition());
            } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                scroll(recyclerView.getChildCount(), gridLayoutManager.getItemCount(), gridLayoutManager.findLastVisibleItemPosition());
            }
        }

        private void scroll(int i, int i2, int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append("===> hasMore =");
            sb.append(this.mHasMore);
            sb.append("count = ");
            sb.append(i);
            sb.append(", total = ");
            sb.append(i2);
            sb.append(", last = ");
            sb.append(i3);
            Log.e("ezy", sb.toString());
            if (!this.mIsLoading && this.mHasMore && i > 0 && i3 > i2 - this.mVisibleThreshold && EndlessAdapter.this.onLoadMoreListener != null) {
                this.mIsLoading = true;
                EndlessAdapter.this.onLoadMoreListener.onLoadMore();
            }
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()) == 0 && i2 > i4 && EndlessAdapter.this.vRecyclerView != null) {
                scroll(EndlessAdapter.this.vRecyclerView);
            }
        }
    }

    public EndlessAdapter(ItemHolderProvider... itemHolderProviderArr) {
        super(itemHolderProviderArr);
    }

    public Object getItem(int i) {
        if (super.getItemCount() == i) {
            return this.mLoadMoreState;
        }
        return super.getItem(i);
    }

    public int getItemCount() {
        int itemCount = super.getItemCount();
        if (!this.mLoadMoreState.getVisible()) {
            return itemCount;
        }
        if (itemCount > 0) {
            return itemCount + 1;
        }
        return 0;
    }

    public int getItemViewType(int i) {
        if (super.getItemCount() == i) {
            return -2;
        }
        return super.getItemViewType(i);
    }

    public long getItemId(int i) {
        if (super.getItemCount() == i) {
            return -1;
        }
        return super.getItemId(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.vRecyclerView = recyclerView;
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new SpanSizeLookup() {
                public int getSpanSize(int i) {
                    int itemViewType = EndlessAdapter.this.getItemViewType(i);
                    if (itemViewType == -1 || itemViewType == -2) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
        if (recyclerView.isNestedScrollingEnabled()) {
            recyclerView.addOnScrollListener(this.onLoadMoreScrollListener);
            return;
        }
        for (ViewParent parent = recyclerView.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof NestedScrollView) {
                ((NestedScrollView) parent).setOnScrollChangeListener(this.onLoadMoreScrollListener);
                return;
            }
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        recyclerView.removeOnScrollListener(this.onLoadMoreScrollListener);
        this.vRecyclerView = null;
    }

    public void onViewAttachedToWindow(ItemHolder itemHolder) {
        super.onViewAttachedToWindow(itemHolder);
        LayoutParams layoutParams = itemHolder.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && itemHolder.getItemViewType() == -2) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == -2) {
            return this.mLoadMoreType.create((LayoutInflater) null, viewGroup);
        }
        return super.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        if (itemHolder.getItemViewType() == -2) {
            this.mLoadMoreType.bind(itemHolder, getItem(i));
        } else {
            super.onBindViewHolder(itemHolder, i);
        }
    }

    public void showLoading() {
        setLoadMoreStatus(0);
        OnLoadMoreListener onLoadMoreListener2 = this.onLoadMoreListener;
        if (onLoadMoreListener2 != null) {
            onLoadMoreListener2.onLoadMore();
        }
    }

    public void showEnded() {
        setLoadMoreStatus(1);
    }

    public void showError() {
        setLoadMoreStatus(2);
    }

    public void setLoadMoreInflater(OnLoadMoreInflater onLoadMoreInflater2) {
        this.onLoadMoreInflater = onLoadMoreInflater2;
    }

    public void setLoadMoreStatus(int i) {
        this.mLoadMoreState.setStatus(i);
        this.onLoadMoreScrollListener.mHasMore = i == 0;
        this.onLoadMoreScrollListener.mIsLoading = false;
    }

    public void setLoadMoreVisible(boolean z) {
        this.mLoadMoreState.setVisible(z);
    }

    public void setLoadMoreBackgroundColor(int i) {
        this.mLoadMoreBackgroundColor = i;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener2) {
        this.onLoadMoreListener = onLoadMoreListener2;
    }

    public void setNoMoreText(String str) {
        this.noMoreText = str;
    }
}
