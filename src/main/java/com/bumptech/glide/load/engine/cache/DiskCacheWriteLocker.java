package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.engine.cache.c */
final class DiskCacheWriteLocker {
    /* renamed from: a */
    private final Map<String, C1662a> f4539a = new HashMap();
    /* renamed from: b */
    private final C1663b f4540b = new C1663b();

    /* compiled from: DiskCacheWriteLocker */
    /* renamed from: com.bumptech.glide.load.engine.cache.c$a */
    private static class C1662a {
        /* renamed from: a */
        final Lock f4541a = new ReentrantLock();
        /* renamed from: b */
        int f4542b;

        C1662a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker */
    /* renamed from: com.bumptech.glide.load.engine.cache.c$b */
    private static class C1663b {
        /* renamed from: a */
        private final Queue<C1662a> f4543a = new ArrayDeque();

        C1663b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1662a mo12791a() {
            C1662a aVar;
            synchronized (this.f4543a) {
                aVar = (C1662a) this.f4543a.poll();
            }
            return aVar == null ? new C1662a() : aVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo12792a(C1662a aVar) {
            synchronized (this.f4543a) {
                if (this.f4543a.size() < 10) {
                    this.f4543a.offer(aVar);
                }
            }
        }
    }

    DiskCacheWriteLocker() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12789a(String str) {
        C1662a aVar;
        synchronized (this) {
            aVar = (C1662a) this.f4539a.get(str);
            if (aVar == null) {
                aVar = this.f4540b.mo12791a();
                this.f4539a.put(str, aVar);
            }
            aVar.f4542b++;
        }
        aVar.f4541a.lock();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo12790b(String str) {
        C1662a aVar;
        synchronized (this) {
            aVar = (C1662a) Preconditions.m6138a(this.f4539a.get(str));
            if (aVar.f4542b >= 1) {
                aVar.f4542b--;
                if (aVar.f4542b == 0) {
                    C1662a aVar2 = (C1662a) this.f4539a.remove(str);
                    if (aVar2.equals(aVar)) {
                        this.f4540b.mo12792a(aVar2);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(aVar);
                        sb.append(", but actually removed: ");
                        sb.append(aVar2);
                        sb.append(", safeKey: ");
                        sb.append(str);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, safeKey: ");
                sb2.append(str);
                sb2.append(", interestedThreads: ");
                sb2.append(aVar.f4542b);
                throw new IllegalStateException(sb2.toString());
            }
        }
        aVar.f4541a.unlock();
    }
}
