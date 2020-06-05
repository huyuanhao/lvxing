package ezy.p653ui.widget.recyclerview.adapter;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolderProvider;

/* renamed from: ezy.ui.widget.recyclerview.adapter.SingleSelectAdapter */
public class SingleSelectAdapter extends MultiTypeAdapter {
    /* access modifiers changed from: private */
    public int mRadioViewId;
    private RecyclerView mRecyclerView;
    private long mSelectedId = Long.MIN_VALUE;
    private int mSelectedPosition = -1;
    OnClickListener onClick = new OnClickListener() {
        public void onClick(View view) {
            Object tag = view.getTag(SingleSelectAdapter.this.mRadioViewId);
            if (tag instanceof ItemHolder) {
                SingleSelectAdapter.this.select(((ItemHolder) tag).getItemId());
            }
        }
    };
    OnSelectChangedListener onSelectChangedListener;

    /* renamed from: ezy.ui.widget.recyclerview.adapter.SingleSelectAdapter$OnSelectChangedListener */
    public interface OnSelectChangedListener {
        void onSelectChanged(long j, long j2);
    }

    public SingleSelectAdapter(ItemHolderProvider... itemHolderProviderArr) {
        super(itemHolderProviderArr);
        setHasStableIds(true);
    }

    public void setOnSelectChangedListener(OnSelectChangedListener onSelectChangedListener2) {
        this.onSelectChangedListener = onSelectChangedListener2;
    }

    public SingleSelectAdapter setRadioViewId(int i) {
        this.mRadioViewId = i;
        return this;
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        View findViewById = onCreateViewHolder.itemView.findViewById(this.mRadioViewId);
        if (findViewById != null) {
            findViewById.setTag(this.mRadioViewId, onCreateViewHolder);
            findViewById.setOnClickListener(this.onClick);
        } else {
            onCreateViewHolder.itemView.setTag(this.mRadioViewId, onCreateViewHolder);
            onCreateViewHolder.itemView.setOnClickListener(this.onClick);
        }
        return onCreateViewHolder;
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        super.onBindViewHolder(itemHolder, i);
        setViewChecked(itemHolder.itemView.findViewById(this.mRadioViewId), isSelected(itemHolder.getItemId()));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public <T> T getSelectedItem() {
        if (this.mSelectedId == -1) {
            return null;
        }
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (this.mSelectedId == getItemId(i)) {
                return getItem(i);
            }
        }
        return null;
    }

    public long getSelectedId() {
        return this.mSelectedId;
    }

    public boolean isSelected(long j) {
        return this.mSelectedId == j;
    }

    public void select(long j) {
        if (this.mSelectedId != j) {
            update(j);
        }
    }

    public void toggle(long j) {
        if (this.mSelectedId == j) {
            j = -1;
        }
        update(j);
    }

    public void unselect() {
        update(-1);
    }

    private void update(long j) {
        long j2 = this.mSelectedId;
        this.mSelectedId = j;
        this.mSelectedPosition = -1;
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder findContainingViewHolder = this.mRecyclerView.findContainingViewHolder(this.mRecyclerView.getChildAt(i));
            StringBuilder sb = new StringBuilder();
            sb.append("i = ");
            sb.append(i);
            sb.append(", selectId = ");
            sb.append(this.mSelectedId);
            sb.append(", itemId = ");
            sb.append(findContainingViewHolder.getItemId());
            Log.e("ezy", sb.toString());
            boolean hasStableIds = hasStableIds();
            boolean z = true;
            long j3 = this.mSelectedId;
            if (!hasStableIds ? j3 != ((long) findContainingViewHolder.getLayoutPosition()) : j3 != findContainingViewHolder.getItemId()) {
                z = false;
            }
            if (z) {
                this.mSelectedPosition = findContainingViewHolder.getLayoutPosition();
            }
            setViewChecked(findContainingViewHolder.itemView.findViewById(this.mRadioViewId), z);
        }
        OnSelectChangedListener onSelectChangedListener2 = this.onSelectChangedListener;
        if (onSelectChangedListener2 != null) {
            onSelectChangedListener2.onSelectChanged(j2, j);
        }
    }

    static void setViewChecked(View view, boolean z) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z);
        } else if (view != null) {
            view.setActivated(z);
        }
    }
}
