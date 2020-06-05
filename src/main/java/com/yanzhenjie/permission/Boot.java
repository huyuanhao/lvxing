package com.yanzhenjie.permission;

import android.os.Build.VERSION;
import com.yanzhenjie.permission.p634b.NRequestFactory;
import com.yanzhenjie.permission.p634b.ORequestFactory;
import com.yanzhenjie.permission.p635c.C7836a;
import com.yanzhenjie.permission.p636d.LRequestFactory;
import com.yanzhenjie.permission.p636d.MRequestFactory;
import com.yanzhenjie.permission.runtime.Runtime;
import com.yanzhenjie.permission.runtime.p639a.RuntimeOption;
import com.yanzhenjie.permission.source.C7847b;

/* renamed from: com.yanzhenjie.permission.c */
public class Boot implements C7836a {
    /* renamed from: a */
    private static final C7834a f26656a;
    /* renamed from: b */
    private static final C7835b f26657b;
    /* renamed from: c */
    private C7847b f26658c;

    /* compiled from: Boot */
    /* renamed from: com.yanzhenjie.permission.c$a */
    public interface C7834a {
    }

    /* compiled from: Boot */
    /* renamed from: com.yanzhenjie.permission.c$b */
    public interface C7835b {
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f26656a = new ORequestFactory();
        } else {
            f26656a = new NRequestFactory();
        }
        if (VERSION.SDK_INT >= 23) {
            f26657b = new MRequestFactory();
        } else {
            f26657b = new LRequestFactory();
        }
    }

    public Boot(C7847b bVar) {
        this.f26658c = bVar;
    }

    /* renamed from: a */
    public RuntimeOption mo38048a() {
        return new Runtime(this.f26658c);
    }
}
