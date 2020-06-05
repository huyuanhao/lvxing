package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.p132a.SimpleTarget;
import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.p131c.p133b.Transition;
import com.bumptech.glide.p134d.ObjectKey;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;

    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$DelayTarget */
    static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        DelayTarget(Handler handler2, int i, long j) {
            this.handler = handler2;
            this.index = i;
            this.targetTime = j;
        }

        /* access modifiers changed from: 0000 */
        public Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> fVar) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameCallback */
    public interface FrameCallback {
        void onFrameReady();
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameLoaderCallback */
    private class FrameLoaderCallback implements Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;

        FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            }
            if (message.what == 2) {
                GifFrameLoader.this.requestManager.mo12593a((Target<?>) (DelayTarget) message.obj);
            }
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$OnEveryFrameListener */
    interface OnEveryFrameListener {
        void onFrameReady();
    }

    GifFrameLoader(Glide eVar, GifDecoder gifDecoder2, int i, int i2, Transformation<Bitmap> iVar, Bitmap bitmap) {
        this(eVar.mo12528a(), Glide.m5174b(eVar.mo12534c()), gifDecoder2, null, getRequestBuilder(Glide.m5174b(eVar.mo12534c()), i, i2), iVar, bitmap);
    }

    GifFrameLoader(BitmapPool eVar, RequestManager iVar, GifDecoder gifDecoder2, Handler handler2, RequestBuilder<Bitmap> hVar, Transformation<Bitmap> iVar2, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.requestManager = iVar;
        if (handler2 == null) {
            handler2 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        }
        this.bitmapPool = eVar;
        this.handler = handler2;
        this.requestBuilder = hVar;
        this.gifDecoder = gifDecoder2;
        setFrameTransformation(iVar2, bitmap);
    }

    /* access modifiers changed from: 0000 */
    public void setFrameTransformation(Transformation<Bitmap> iVar, Bitmap bitmap) {
        this.transformation = (Transformation) Preconditions.m6138a(iVar);
        this.firstFrame = (Bitmap) Preconditions.m6138a(bitmap);
        this.requestBuilder = this.requestBuilder.mo12435b(new RequestOptions().mo12426a(iVar));
    }

    /* access modifiers changed from: 0000 */
    public Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    /* access modifiers changed from: 0000 */
    public void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.callbacks.contains(frameCallback)) {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(frameCallback);
            if (isEmpty) {
                start();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: 0000 */
    public void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    /* access modifiers changed from: 0000 */
    public int getWidth() {
        return getCurrentFrame().getWidth();
    }

    /* access modifiers changed from: 0000 */
    public int getHeight() {
        return getCurrentFrame().getHeight();
    }

    /* access modifiers changed from: 0000 */
    public int getSize() {
        return this.gifDecoder.mo12562h() + getFrameSize();
    }

    /* access modifiers changed from: 0000 */
    public int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.index;
        }
        return -1;
    }

    private int getFrameSize() {
        return C1772j.m6145a(getCurrentFrame().getWidth(), getCurrentFrame().getHeight(), getCurrentFrame().getConfig());
    }

    /* access modifiers changed from: 0000 */
    public ByteBuffer getBuffer() {
        return this.gifDecoder.mo12554a().asReadOnlyBuffer();
    }

    /* access modifiers changed from: 0000 */
    public int getFrameCount() {
        return this.gifDecoder.mo12558d();
    }

    /* access modifiers changed from: 0000 */
    public int getLoopCount() {
        return this.gifDecoder.mo12561g();
    }

    private void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    private void stop() {
        this.isRunning = false;
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.mo12593a((Target<?>) delayTarget);
            this.current = null;
        }
        DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.requestManager.mo12593a((Target<?>) delayTarget2);
            this.next = null;
        }
        DelayTarget delayTarget3 = this.pendingTarget;
        if (delayTarget3 != null) {
            this.requestManager.mo12593a((Target<?>) delayTarget3);
            this.pendingTarget = null;
        }
        this.gifDecoder.mo12564j();
        this.isCleared = true;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.getResource() : this.firstFrame;
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                Preconditions.m6142a(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.gifDecoder.mo12560f();
                this.startFromFirstFrame = false;
            }
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.mo12557c());
            this.gifDecoder.mo12556b();
            this.next = new DelayTarget(this.handler, this.gifDecoder.mo12559e(), uptimeMillis);
            this.requestBuilder.mo12435b((BaseRequestOptions<?>) RequestOptions.m5103b(getFrameSignature())).mo12587a((Object) this.gifDecoder).mo12580a(this.next);
        }
    }

    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.put(bitmap);
            this.firstFrame = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setNextStartFromFirstFrame() {
        Preconditions.m6142a(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.requestManager.mo12593a((Target<?>) delayTarget);
            this.pendingTarget = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setOnEveryFrameReadyListener(OnEveryFrameListener onEveryFrameListener2) {
        this.onEveryFrameListener = onEveryFrameListener2;
    }

    /* access modifiers changed from: 0000 */
    public void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener2 = this.onEveryFrameListener;
        if (onEveryFrameListener2 != null) {
            onEveryFrameListener2.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (!this.isRunning) {
            this.pendingTarget = delayTarget;
        } else {
            if (delayTarget.getResource() != null) {
                recycleFirstFrame();
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    ((FrameCallback) this.callbacks.get(size)).onFrameReady();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            loadNextFrame();
        }
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager iVar, int i, int i2) {
        return iVar.mo12599c().mo12435b(((RequestOptions) ((RequestOptions) RequestOptions.m5104b(DiskCacheStrategy.f4630b).mo12432a(true)).mo12437b(true)).mo12421a(i, i2));
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }
}
