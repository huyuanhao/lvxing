package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.p073f.ParseUtils;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashSet;
import java.util.Set;

public class UTDimensionValueSet extends DimensionValueSet {
    /* renamed from: b */
    private static final Set<LogField> f3258b = new HashSet<LogField>() {
        {
            add(LogField.PAGE);
            add(LogField.ARG1);
            add(LogField.ARG2);
            add(LogField.ARG3);
            add(LogField.ARGS);
        }
    };

    /* renamed from: c */
    public Integer mo11746c() {
        int i;
        if (this.f3248a != null) {
            String str = (String) this.f3248a.get(LogField.EVENTID.toString());
            if (str != null) {
                try {
                    i = ParseUtils.m3588a(str);
                } catch (NumberFormatException unused) {
                }
                return Integer.valueOf(i);
            }
        }
        i = 0;
        return Integer.valueOf(i);
    }

    /* renamed from: d */
    public void mo11546d() {
        super.mo11546d();
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        super.mo11548a(objArr);
    }
}
