package ezy.p653ui.widget.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.holder.ItemHolderProvider;
import java.util.List;

/* renamed from: ezy.ui.widget.recyclerview.adapter.SingleTypeAdapter */
public class SingleTypeAdapter<Item> extends ItemAdapter<Item, ItemHolder> {
    private final ItemHolderProvider<Item, ItemHolder> mItemType;

    public SingleTypeAdapter(ItemHolderProvider itemHolderProvider) {
        this.mItemType = itemHolderProvider;
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return this.mItemType.create(this.mInflater, viewGroup);
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        this.mItemType.bind(itemHolder, getItem(i));
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i, List<Object> list) {
        super.onBindViewHolder(itemHolder, i, list);
        this.mItemType.bind(itemHolder, getItem(i));
    }
}
