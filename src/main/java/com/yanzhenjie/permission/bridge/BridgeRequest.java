package com.yanzhenjie.permission.bridge;

import com.yanzhenjie.permission.source.C7847b;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.bridge.a */
public final class BridgeRequest {
    /* renamed from: a */
    private final C7847b f26642a;
    /* renamed from: b */
    private int f26643b;
    /* renamed from: c */
    private C7828a f26644c;
    /* renamed from: d */
    private List<String> f26645d;

    /* compiled from: BridgeRequest */
    /* renamed from: com.yanzhenjie.permission.bridge.a$a */
    public interface C7828a {
        /* renamed from: c */
        void mo38036c();
    }

    public BridgeRequest(C7847b bVar) {
        this.f26642a = bVar;
    }

    /* renamed from: a */
    public C7847b mo38029a() {
        return this.f26642a;
    }

    /* renamed from: b */
    public int mo38033b() {
        return this.f26643b;
    }

    /* renamed from: a */
    public void mo38030a(int i) {
        this.f26643b = i;
    }

    /* renamed from: c */
    public C7828a mo38034c() {
        return this.f26644c;
    }

    /* renamed from: a */
    public void mo38031a(C7828a aVar) {
        this.f26644c = aVar;
    }

    /* renamed from: d */
    public List<String> mo38035d() {
        return this.f26645d;
    }

    /* renamed from: a */
    public void mo38032a(List<String> list) {
        this.f26645d = list;
    }
}
