package ezy.p653ui.widget.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Space;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolderProvider;

/* renamed from: ezy.ui.widget.recyclerview.adapter.MultiTypeAdapter */
public class MultiTypeAdapter extends ItemAdapter {
    private final ItemHolderProvider[] mItemTypes;

    public MultiTypeAdapter(ItemHolderProvider... itemHolderProviderArr) {
        this.mItemTypes = itemHolderProviderArr;
    }

    public int getItemViewType(int i) {
        Object item = getItem(i);
        int i2 = 0;
        while (true) {
            ItemHolderProvider[] itemHolderProviderArr = this.mItemTypes;
            if (i2 >= itemHolderProviderArr.length) {
                return -1;
            }
            if (itemHolderProviderArr[i2].classify(item)) {
                return i2;
            }
            i2++;
        }
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        if (i == -1) {
            return new ItemHolder(new Space(viewGroup.getContext()));
        }
        return this.mItemTypes[i].create(this.mInflater, viewGroup);
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        if (itemHolder.getItemViewType() != -1) {
            this.mItemTypes[itemHolder.getItemViewType()].bind(itemHolder, getItem(i));
        }
    }
}
