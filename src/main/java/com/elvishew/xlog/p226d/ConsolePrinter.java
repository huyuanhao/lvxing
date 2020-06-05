package com.elvishew.xlog.p226d;

import com.elvishew.xlog.p222a.Flattener;
import com.elvishew.xlog.p224c.DefaultsFactory;

/* renamed from: com.elvishew.xlog.d.b */
public class ConsolePrinter implements Printer {
    /* renamed from: a */
    private Flattener f9460a = DefaultsFactory.m12658g();

    /* renamed from: a */
    public void mo17097a(int i, String str, String str2) {
        System.out.println(this.f9460a.mo17088a(i, str, str2).toString());
    }
}
