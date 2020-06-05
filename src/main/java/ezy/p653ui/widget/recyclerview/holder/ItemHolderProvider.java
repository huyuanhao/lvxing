package ezy.p653ui.widget.recyclerview.holder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;

/* renamed from: ezy.ui.widget.recyclerview.holder.ItemHolderProvider */
public interface ItemHolderProvider<Item, Holder extends ItemHolder> {
    void bind(Holder holder, Item item);

    boolean classify(Object obj);

    Holder create(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
