package ezy.p653ui.widget.recyclerview.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ezy.p653ui.widget.recyclerview.holder.ItemHolder;
import ezy.p653ui.widget.recyclerview.item.Classifiable;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ezy.ui.widget.recyclerview.holder.ItemType */
public class ItemType<Item, Holder extends ItemHolder> implements ItemHolderProvider<Item, Holder> {
    public static final int TYPE_INVALID = -1;
    protected final Class<Holder> holderClass;
    protected final Class<Item> itemClass;
    protected final int layoutResId;
    protected final int subtypeId;

    public void bind(Holder holder, Item item) {
    }

    public static ItemType create(Class cls, int i, int i2) {
        return new ItemType(cls, i, i2);
    }

    public static ItemType create(Class cls, int i) {
        return new ItemType(cls, i, i);
    }

    protected ItemType(Class<Holder> cls, Class<Item> cls2, int i, int i2) {
        this.holderClass = cls;
        this.itemClass = cls2;
        this.layoutResId = i;
        if (i2 != -1 || i <= 0) {
            i = i2;
        }
        this.subtypeId = i;
    }

    protected ItemType(Class<Item> cls, int i, int i2) {
        this(ItemHolder.class, cls, i, i2);
    }

    protected ItemType(Class<Item> cls) {
        this.holderClass = null;
        this.itemClass = cls;
        this.layoutResId = 0;
        this.subtypeId = -1;
    }

    public Holder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            return (ItemHolder) this.holderClass.getConstructor(new Class[]{View.class}).newInstance(new Object[]{layoutInflater.inflate(this.layoutResId, viewGroup, false)});
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean classify(Object obj) {
        boolean z = false;
        if (!this.itemClass.isInstance(obj)) {
            return false;
        }
        if (!(obj instanceof Classifiable)) {
            return true;
        }
        if (((long) this.subtypeId) == ((Classifiable) obj).toSubtypeId()) {
            z = true;
        }
        return z;
    }
}
