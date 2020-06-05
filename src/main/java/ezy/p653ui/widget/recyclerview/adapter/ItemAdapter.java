package ezy.p653ui.widget.recyclerview.adapter;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.item.Identifiable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ezy.ui.widget.recyclerview.adapter.ItemAdapter */
public abstract class ItemAdapter<Item, Holder extends ItemHolder> extends Adapter<Holder> {
    protected LayoutInflater mInflater;
    private List<Item> nItems = new ArrayList();

    public void onBindViewHolder(Holder holder, int i) {
    }

    public void setItems(List<Item> list) {
        this.nItems = list;
    }

    public List<Item> getItems() {
        return this.nItems;
    }

    public Item getItem(int i) {
        return this.nItems.get(i);
    }

    public int getItemCount() {
        return this.nItems.size();
    }

    public long getItemId(int i) {
        if (hasStableIds()) {
            return ((Identifiable) getItem(i)).toStableId();
        }
        return -1;
    }

    public void onViewAttachedToWindow(Holder holder) {
        super.onViewAttachedToWindow(holder);
    }
}
