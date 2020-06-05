package ezy.p653ui.widget.recyclerview.item;

import java.util.List;

/* renamed from: ezy.ui.widget.recyclerview.item.Flattenable */
public interface Flattenable {
    int getFlattenedCount();

    <T> T getFlattenedItem(int i);

    <T> List<T> toFlattened();
}
