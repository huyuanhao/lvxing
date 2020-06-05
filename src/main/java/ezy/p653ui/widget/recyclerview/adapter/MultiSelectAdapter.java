package ezy.p653ui.widget.recyclerview.adapter;

import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolderProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ezy.ui.widget.recyclerview.adapter.MultiSelectAdapter */
public class MultiSelectAdapter extends MultiTypeAdapter {
    /* access modifiers changed from: private */
    public int mCheckViewId;
    private LongSparseArray<Integer> mCheckedPositions = new LongSparseArray<>();
    private LongSparseArray<Boolean> mCheckedStates = new LongSparseArray<>();
    private RecyclerView mRecyclerView;
    OnClickListener onClick = new OnClickListener() {
        public void onClick(View view) {
            Object tag = view.getTag(MultiSelectAdapter.this.mCheckViewId);
            if (tag instanceof ItemHolder) {
                MultiSelectAdapter.this.toggle(((ItemHolder) tag).getItemId());
            }
        }
    };

    public MultiSelectAdapter(ItemHolderProvider... itemHolderProviderArr) {
        super(itemHolderProviderArr);
        setHasStableIds(true);
        registerAdapterDataObserver(new AdapterDataObserver() {
            public void onChanged() {
                MultiSelectAdapter.this.onAdapterDataChanged();
            }
        });
    }

    public MultiSelectAdapter setCheckViewId(int i) {
        this.mCheckViewId = i;
        return this;
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        View findViewById = onCreateViewHolder.itemView.findViewById(this.mCheckViewId);
        if (findViewById != null) {
            findViewById.setTag(this.mCheckViewId, onCreateViewHolder);
            findViewById.setOnClickListener(this.onClick);
        } else {
            onCreateViewHolder.itemView.setTag(this.mCheckViewId, onCreateViewHolder);
            onCreateViewHolder.itemView.setOnClickListener(this.onClick);
        }
        return onCreateViewHolder;
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        super.onBindViewHolder(itemHolder, i);
        setViewChecked(itemHolder.itemView.findViewById(this.mCheckViewId), isChecked(itemHolder.getItemId()));
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public int getCheckedCount() {
        return this.mCheckedStates.size();
    }

    public <T> List<T> getCheckedItems() {
        List asList = Arrays.asList(getCheckedIds());
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < itemCount; i++) {
            if (asList.remove(Long.valueOf(getItemId(i)))) {
                arrayList.add(getItem(i));
            }
        }
        return arrayList;
    }

    public Long[] getCheckedIds() {
        int size = this.mCheckedStates.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            lArr[i] = Long.valueOf(this.mCheckedStates.keyAt(i));
        }
        return lArr;
    }

    public void toggle(long j) {
        check(j, !isChecked(j));
    }

    public boolean isChecked(long j) {
        return ((Boolean) this.mCheckedStates.get(j, Boolean.valueOf(false))).booleanValue();
    }

    public void setChecked(long j, boolean z) {
        if (isChecked(j) != z) {
            check(j, z);
        }
    }

    private void check(long j, boolean z) {
        if (z) {
            this.mCheckedStates.put(j, Boolean.valueOf(true));
        } else {
            this.mCheckedStates.delete(j);
        }
        update(j, z);
    }

    public boolean isAllChecked() {
        return getCheckedCount() == getItemCount();
    }

    public void setAllChecked(boolean z) {
        this.mCheckedStates.clear();
        if (z) {
            int itemCount = getItemCount();
            for (int i = 0; i < itemCount; i++) {
                this.mCheckedStates.put(getItemId(i), Boolean.valueOf(z));
            }
        }
        update();
    }

    /* access modifiers changed from: private */
    public void onAdapterDataChanged() {
        LongSparseArray<Boolean> longSparseArray = new LongSparseArray<>();
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            long itemId = getItemId(i);
            if (((Boolean) this.mCheckedStates.get(itemId, Boolean.valueOf(false))).booleanValue()) {
                longSparseArray.put(itemId, Boolean.valueOf(true));
            }
        }
        this.mCheckedStates = longSparseArray;
        update();
    }

    private void update(long j, boolean z) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            ViewHolder findViewHolderForItemId = recyclerView.findViewHolderForItemId(j);
            if (findViewHolderForItemId != null) {
                setViewChecked(findViewHolderForItemId.itemView, z);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("itemId = ");
        sb.append(j);
        sb.append(", checked = ");
        sb.append(z);
        Log.e("ezy", sb.toString());
    }

    private void update() {
        Log.e("ezy", "update all");
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder findContainingViewHolder = this.mRecyclerView.findContainingViewHolder(this.mRecyclerView.getChildAt(i));
                if (findContainingViewHolder != null) {
                    setViewChecked(findContainingViewHolder.itemView, isChecked(findContainingViewHolder.getItemId()));
                }
            }
        }
    }

    private void setViewChecked(View view, boolean z) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z);
        } else if (view != null) {
            view.setActivated(z);
        }
    }
}
