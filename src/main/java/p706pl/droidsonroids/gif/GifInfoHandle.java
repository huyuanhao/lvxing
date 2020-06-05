package p706pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: pl.droidsonroids.gif.GifInfoHandle */
final class GifInfoHandle {
    /* renamed from: a */
    private volatile long f29241a;

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFd(FileDescriptor fileDescriptor, long j) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    static {
        LibraryLoader.m37445a(null);
    }

    GifInfoHandle() {
    }

    GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f29241a = openFd(fileDescriptor, 0);
    }

    GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f29241a = openByteArray(bArr);
    }

    GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f29241a = openDirectByteBuffer(byteBuffer);
    }

    GifInfoHandle(String str) throws GifIOException {
        this.f29241a = openFile(str);
    }

    GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f29241a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f29241a = openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    static GifInfoHandle m37370a(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        return new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized long mo41153a(Bitmap bitmap) {
        return renderFrame(this.f29241a, bitmap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41158a(Surface surface, long[] jArr) {
        bindSurface(this.f29241a, surface, jArr);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo41154a() {
        free(this.f29241a);
        this.f29241a = 0;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized long mo41159b() {
        return restoreRemainder(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: c */
    public synchronized boolean mo41160c() {
        return reset(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: d */
    public synchronized void mo41161d() {
        saveRemainder(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: e */
    public synchronized int mo41162e() {
        return getLoopCount(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: f */
    public synchronized int mo41163f() {
        return getNativeErrorCode(this.f29241a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41156a(float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.f29241a, f);
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: g */
    public synchronized int mo41165g() {
        return getDuration(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: h */
    public synchronized int mo41166h() {
        return getCurrentPosition(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: i */
    public synchronized int mo41167i() {
        return getCurrentFrameIndex(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: j */
    public synchronized int mo41168j() {
        return getCurrentLoop(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo41157a(int i, Bitmap bitmap) {
        seekToTime(this.f29241a, i, bitmap);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: k */
    public synchronized long mo41169k() {
        return getAllocationByteCount(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: l */
    public synchronized long mo41170l() {
        return getMetadataByteCount(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: m */
    public synchronized boolean mo41171m() {
        return this.f29241a == 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            mo41154a();
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: n */
    public synchronized void mo41172n() {
        postUnbindSurface(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: o */
    public synchronized long[] mo41173o() {
        return getSavedState(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized int mo41152a(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f29241a, jArr, bitmap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41155a(char c, boolean z) {
        setOptions(this.f29241a, c, z);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: p */
    public synchronized int mo41174p() {
        return getWidth(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: q */
    public synchronized int mo41175q() {
        return getHeight(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: r */
    public synchronized int mo41176r() {
        return getNumberOfFrames(this.f29241a);
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: s */
    public synchronized boolean mo41177s() {
        return isOpaque(this.f29241a);
    }
}
