package com.bytedance.sdk.openadsdk.p198i;

import java.util.UUID;

/* renamed from: com.bytedance.sdk.openadsdk.i.c */
public abstract class TTRunnable implements Comparable<TTRunnable>, Runnable {
    /* renamed from: a */
    private int f8971a;
    /* renamed from: b */
    private String f8972b;

    public TTRunnable(int i) {
        this.f8971a = -1;
        if (i == -1) {
            i = 5;
        }
        this.f8971a = i;
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID().toString());
        sb.append("-");
        sb.append(String.valueOf(System.nanoTime()));
        this.f8972b = sb.toString();
    }

    public TTRunnable() {
        this.f8971a = -1;
        this.f8971a = 5;
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID().toString());
        sb.append("-");
        sb.append(String.valueOf(System.nanoTime()));
        this.f8972b = sb.toString();
    }

    /* renamed from: a */
    public int mo16817a() {
        return this.f8971a;
    }

    /* renamed from: a */
    public int compareTo(TTRunnable cVar) {
        if (mo16817a() < cVar.mo16817a()) {
            return 1;
        }
        return mo16817a() > cVar.mo16817a() ? -1 : 0;
    }
}
