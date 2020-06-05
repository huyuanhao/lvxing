package p706pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;

/* renamed from: pl.droidsonroids.gif.GifAnimationMetaData */
public class GifAnimationMetaData implements Parcelable, Serializable {
    public static final Creator<GifAnimationMetaData> CREATOR = new Creator<GifAnimationMetaData>() {
        /* renamed from: a */
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel);
        }

        /* renamed from: a */
        public GifAnimationMetaData[] newArray(int i) {
            return new GifAnimationMetaData[i];
        }
    };
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    public int describeContents() {
        return 0;
    }

    public GifAnimationMetaData(Resources resources, int i) throws NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
    }

    public GifAnimationMetaData(AssetManager assetManager, String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(String str) throws IOException {
        this(new GifInfoHandle(str));
    }

    public GifAnimationMetaData(File file) throws IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream));
    }

    public GifAnimationMetaData(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public GifAnimationMetaData(FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor));
    }

    public GifAnimationMetaData(byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr));
    }

    public GifAnimationMetaData(ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer));
    }

    public GifAnimationMetaData(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.m37370a(contentResolver, uri));
    }

    private GifAnimationMetaData(GifInfoHandle gifInfoHandle) {
        this.mLoopCount = gifInfoHandle.mo41162e();
        this.mDuration = gifInfoHandle.mo41165g();
        this.mWidth = gifInfoHandle.mo41174p();
        this.mHeight = gifInfoHandle.mo41175q();
        this.mImageCount = gifInfoHandle.mo41176r();
        this.mMetadataBytesCount = gifInfoHandle.mo41170l();
        this.mPixelsBytesCount = gifInfoHandle.mo41169k();
        gifInfoHandle.mo41154a();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getNumberOfFrames() {
        return this.mImageCount;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public boolean isAnimated() {
        return this.mImageCount > 1 && this.mDuration > 0;
    }

    public long getAllocationByteCount() {
        return this.mPixelsBytesCount;
    }

    public long getDrawableAllocationByteCount(GifDrawable cVar, int i) {
        int i2;
        if (i < 1 || i > 65535) {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size ");
            sb.append(i);
            sb.append(" out of range <1, ");
            sb.append(65535);
            sb.append(">");
            throw new IllegalStateException(sb.toString());
        }
        int i3 = i * i;
        if (cVar == null || cVar.f29264e.isRecycled()) {
            i2 = ((this.mWidth * this.mHeight) * 4) / i3;
        } else if (VERSION.SDK_INT >= 19) {
            i2 = cVar.f29264e.getAllocationByteCount();
        } else {
            i2 = cVar.mo41230d();
        }
        return (this.mPixelsBytesCount / ((long) i3)) + ((long) i2);
    }

    public long getMetadataAllocationByteCount() {
        return this.mMetadataBytesCount;
    }

    public String toString() {
        int i = this.mLoopCount;
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), i == 0 ? "Infinity" : Integer.toString(i), Integer.valueOf(this.mDuration)});
        if (!isAnimated()) {
            return format;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animated ");
        sb.append(format);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
        parcel.writeLong(this.mMetadataBytesCount);
        parcel.writeLong(this.mPixelsBytesCount);
    }

    private GifAnimationMetaData(Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
        this.mMetadataBytesCount = parcel.readLong();
        this.mPixelsBytesCount = parcel.readLong();
    }
}
