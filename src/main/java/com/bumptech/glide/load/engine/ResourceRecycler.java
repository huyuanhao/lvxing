package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.bumptech.glide.load.engine.x */
class ResourceRecycler {
    /* renamed from: a */
    private boolean f4736a;
    /* renamed from: b */
    private final Handler f4737b = new Handler(Looper.getMainLooper(), new C1696a());

    /* compiled from: ResourceRecycler */
    /* renamed from: com.bumptech.glide.load.engine.x$a */
    private static final class C1696a implements Callback {
        C1696a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    ResourceRecycler() {
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12916a(Resource<?> uVar) {
        if (this.f4736a) {
            this.f4737b.obtainMessage(1, uVar).sendToTarget();
        } else {
            this.f4736a = true;
            uVar.recycle();
            this.f4736a = false;
        }
    }
}
