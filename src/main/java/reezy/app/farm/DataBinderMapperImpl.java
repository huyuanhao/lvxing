package reezy.app.farm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    /* renamed from: a */
    private static final SparseIntArray f29297a = new SparseIntArray(0);

    /* renamed from: reezy.app.farm.DataBinderMapperImpl$a */
    private static class C8601a {
        /* renamed from: a */
        static final SparseArray<String> f29298a = new SparseArray<>(2);

        static {
            f29298a.put(0, "_all");
        }
    }

    /* renamed from: reezy.app.farm.DataBinderMapperImpl$b */
    private static class C8602b {
        /* renamed from: a */
        static final HashMap<String, Integer> f29299a = new HashMap<>(0);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (f29297a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f29297a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        Integer num = (Integer) C8602b.f29299a.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    public String convertBrIdToString(int i) {
        return (String) C8601a.f29298a.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}
