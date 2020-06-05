package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

public class AutowiredServiceImpl implements AutowiredService {
    /* renamed from: a */
    private LruCache<String, ISyringe> f2283a;
    /* renamed from: b */
    private List<String> f2284b;

    public void init(Context context) {
        this.f2283a = new LruCache<>(66);
        this.f2284b = new ArrayList();
    }

    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (!this.f2284b.contains(name)) {
                ISyringe iSyringe = (ISyringe) this.f2283a.get(name);
                if (iSyringe == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(obj.getClass().getName());
                    sb.append("$$ARouter$$Autowired");
                    iSyringe = (ISyringe) Class.forName(sb.toString()).getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                iSyringe.inject(obj);
                this.f2283a.put(name, iSyringe);
            }
        } catch (Exception unused) {
            this.f2284b.add(name);
        }
    }
}
