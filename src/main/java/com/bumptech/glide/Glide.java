package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.engine.p139c.BitmapPreFiller;
import com.bumptech.glide.load.model.AssetUriLoader.C1699b;
import com.bumptech.glide.load.model.AssetUriLoader.C1700c;
import com.bumptech.glide.load.model.ByteArrayLoader.C1701a;
import com.bumptech.glide.load.model.ByteArrayLoader.C1705d;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader.C1708b;
import com.bumptech.glide.load.model.DataUrlLoader.C1711c;
import com.bumptech.glide.load.model.FileLoader.C1714b;
import com.bumptech.glide.load.model.FileLoader.C1718e;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader.C1732a;
import com.bumptech.glide.load.model.ResourceLoader.C1733b;
import com.bumptech.glide.load.model.ResourceLoader.C1734c;
import com.bumptech.glide.load.model.ResourceLoader.C1735d;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader.C1739a;
import com.bumptech.glide.load.model.StringLoader.C1740b;
import com.bumptech.glide.load.model.StringLoader.C1741c;
import com.bumptech.glide.load.model.UnitModelLoader.C1742a;
import com.bumptech.glide.load.model.UriLoader.C1744a;
import com.bumptech.glide.load.model.UriLoader.C1745b;
import com.bumptech.glide.load.model.UriLoader.C1747d;
import com.bumptech.glide.load.model.UrlUriLoader.C1748a;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.C1736a;
import com.bumptech.glide.load.model.stream.HttpUriLoader.C1737a;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader.C1738a;
import com.bumptech.glide.load.p135a.DataRewinder.C1624a;
import com.bumptech.glide.load.p135a.InputStreamRewinder.C1629a;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.p131c.RequestListener;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.p132a.ImageViewTargetFactory;
import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bumptech.glide.e */
public class Glide implements ComponentCallbacks2 {
    /* renamed from: a */
    private static volatile Glide f4262a;
    /* renamed from: b */
    private static volatile boolean f4263b;
    /* renamed from: c */
    private final Engine f4264c;
    /* renamed from: d */
    private final BitmapPool f4265d;
    /* renamed from: e */
    private final MemoryCache f4266e;
    /* renamed from: f */
    private final BitmapPreFiller f4267f;
    /* renamed from: g */
    private final GlideContext f4268g;
    /* renamed from: h */
    private final Registry f4269h;
    /* renamed from: i */
    private final ArrayPool f4270i;
    /* renamed from: j */
    private final RequestManagerRetriever f4271j;
    /* renamed from: k */
    private final ConnectivityMonitorFactory f4272k;
    /* renamed from: l */
    private final List<RequestManager> f4273l = new ArrayList();
    /* renamed from: m */
    private MemoryCategory f4274m = MemoryCategory.NORMAL;

    public void onConfigurationChanged(Configuration configuration) {
    }

    /* renamed from: a */
    public static Glide m5169a(Context context) {
        if (f4262a == null) {
            synchronized (Glide.class) {
                if (f4262a == null) {
                    m5175c(context);
                }
            }
        }
        return f4262a;
    }

    /* renamed from: c */
    private static void m5175c(Context context) {
        if (!f4263b) {
            f4263b = true;
            m5176d(context);
            f4263b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    /* renamed from: d */
    private static void m5176d(Context context) {
        m5172a(context, new GlideBuilder());
    }

    /* renamed from: a */
    private static void m5172a(Context context, GlideBuilder fVar) {
        Context applicationContext = context.getApplicationContext();
        GeneratedAppGlideModule i = m5178i();
        List<GlideModule> emptyList = Collections.emptyList();
        if (i == null || i.mo12391c()) {
            emptyList = new ManifestParser(applicationContext).mo13195a();
        }
        String str = "Glide";
        if (i != null && !i.mo12360a().isEmpty()) {
            Set a = i.mo12360a();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule cVar = (GlideModule) it.next();
                if (a.contains(cVar.getClass())) {
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AppGlideModule excludes manifest GlideModule: ");
                        sb.append(cVar);
                        Log.d(str, sb.toString());
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(str, 3)) {
            for (GlideModule cVar2 : emptyList) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(cVar2.getClass());
                Log.d(str, sb2.toString());
            }
        }
        fVar.mo12544a(i != null ? i.mo12361b() : null);
        for (GlideModule a2 : emptyList) {
            a2.mo12390a(applicationContext, fVar);
        }
        if (i != null) {
            i.mo12390a(applicationContext, fVar);
        }
        Glide a3 = fVar.mo12543a(applicationContext);
        for (GlideModule a4 : emptyList) {
            a4.mo12389a(applicationContext, a3, a3.f4269h);
        }
        if (i != null) {
            i.mo12389a(applicationContext, a3, a3.f4269h);
        }
        applicationContext.registerComponentCallbacks(a3);
        f4262a = a3;
    }

    /* renamed from: i */
    private static GeneratedAppGlideModule m5178i() {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.b").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            String str = "Glide";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e) {
            m5173a((Exception) e);
        } catch (IllegalAccessException e2) {
            m5173a((Exception) e2);
        } catch (NoSuchMethodException e3) {
            m5173a((Exception) e3);
        } catch (InvocationTargetException e4) {
            m5173a((Exception) e4);
        }
        return null;
    }

    /* renamed from: a */
    private static void m5173a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    Glide(Context context, Engine kVar, MemoryCache gVar, BitmapPool eVar, ArrayPool bVar, RequestManagerRetriever lVar, ConnectivityMonitorFactory dVar, int i, RequestOptions fVar, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, boolean z) {
        Context context2 = context;
        MemoryCache gVar2 = gVar;
        BitmapPool eVar2 = eVar;
        ArrayPool bVar2 = bVar;
        Class<byte[]> cls = byte[].class;
        this.f4264c = kVar;
        this.f4265d = eVar2;
        this.f4270i = bVar2;
        this.f4266e = gVar2;
        this.f4271j = lVar;
        this.f4272k = dVar;
        this.f4267f = new BitmapPreFiller(gVar2, eVar2, (DecodeFormat) fVar.mo12451m().mo12919a(Downsampler.DECODE_FORMAT));
        Resources resources = context.getResources();
        this.f4269h = new Registry();
        this.f4269h.mo12342a((ImageHeaderParser) new DefaultImageHeaderParser());
        if (VERSION.SDK_INT >= 27) {
            this.f4269h.mo12342a((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List a = this.f4269h.mo12353a();
        Downsampler downsampler = new Downsampler(a, resources.getDisplayMetrics(), eVar2, bVar2);
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, a, eVar2, bVar2);
        ResourceDecoder parcel = VideoDecoder.parcel(eVar);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, bVar2);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        C1734c cVar = new C1734c(resources);
        C1735d dVar2 = new C1735d(resources);
        C1733b bVar3 = new C1733b(resources);
        C1732a aVar = new C1732a(resources);
        Class<byte[]> cls2 = cls;
        BitmapEncoder bitmapEncoder = new BitmapEncoder(bVar2);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        C1732a aVar2 = aVar;
        C1735d dVar3 = dVar2;
        String str = "Bitmap";
        C1733b bVar4 = bVar3;
        BitmapDrawableDecoder bitmapDrawableDecoder = new BitmapDrawableDecoder(resources, (ResourceDecoder<DataType, Bitmap>) byteBufferBitmapDecoder);
        String str2 = "BitmapDrawable";
        StreamGifDecoder streamGifDecoder = new StreamGifDecoder(a, byteBufferGifDecoder, bVar2);
        String str3 = "Gif";
        C1733b bVar5 = bVar4;
        C1735d dVar4 = dVar3;
        C1732a aVar3 = aVar2;
        Context context3 = context;
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls3 = cls2;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        this.f4269h.mo12344a(ByteBuffer.class, (Encoder<Data>) new ByteBufferEncoder<Data>()).mo12344a(InputStream.class, (Encoder<Data>) new StreamEncoder<Data>(bVar2)).mo12349a(str, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).mo12349a(str, InputStream.class, Bitmap.class, streamBitmapDecoder).mo12349a(str, ParcelFileDescriptor.class, Bitmap.class, parcel).mo12349a(str, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(eVar)).mo12347a(Bitmap.class, Bitmap.class, (ModelLoaderFactory<Model, Data>) C1742a.m5983b()).mo12349a(str, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).mo12345a(Bitmap.class, (ResourceEncoder<TResource>) bitmapEncoder).mo12349a(str2, ByteBuffer.class, BitmapDrawable.class, bitmapDrawableDecoder).mo12349a(str2, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, (ResourceDecoder<DataType, Bitmap>) streamBitmapDecoder)).mo12349a(str2, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).mo12345a(BitmapDrawable.class, (ResourceEncoder<TResource>) new BitmapDrawableEncoder<TResource>(eVar2, bitmapEncoder)).mo12349a(str3, InputStream.class, GifDrawable.class, streamGifDecoder).mo12349a(str3, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).mo12345a(GifDrawable.class, (ResourceEncoder<TResource>) new GifDrawableEncoder<TResource>()).mo12347a(GifDecoder.class, GifDecoder.class, (ModelLoaderFactory<Model, Data>) C1742a.m5983b()).mo12349a(str, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(eVar2)).mo12346a(Uri.class, Drawable.class, (ResourceDecoder<Data, TResource>) resourceDrawableDecoder).mo12346a(Uri.class, Bitmap.class, (ResourceDecoder<Data, TResource>) new ResourceBitmapDecoder<Data,TResource>(resourceDrawableDecoder, eVar2)).mo12343a((C1624a<?>) new Factory<Object>()).mo12347a(File.class, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new C1708b<Model,Data>()).mo12347a(File.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1718e<Model,Data>()).mo12346a(File.class, File.class, (ResourceDecoder<Data, TResource>) new FileDecoder<Data,TResource>()).mo12347a(File.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1714b<Model,Data>()).mo12347a(File.class, File.class, (ModelLoaderFactory<Model, Data>) C1742a.m5983b()).mo12343a((C1624a<?>) new C1629a<Object>(bVar2)).mo12347a(Integer.TYPE, InputStream.class, (ModelLoaderFactory<Model, Data>) cVar).mo12347a(Integer.TYPE, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) bVar5).mo12347a(Integer.class, InputStream.class, (ModelLoaderFactory<Model, Data>) cVar).mo12347a(Integer.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) bVar5).mo12347a(Integer.class, Uri.class, (ModelLoaderFactory<Model, Data>) dVar4).mo12347a(Integer.TYPE, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) aVar3).mo12347a(Integer.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) aVar3).mo12347a(Integer.TYPE, Uri.class, (ModelLoaderFactory<Model, Data>) dVar4).mo12347a(String.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1711c<Model,Data>()).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1711c<Model,Data>()).mo12347a(String.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1741c<Model,Data>()).mo12347a(String.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1740b<Model,Data>()).mo12347a(String.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1739a<Model,Data>()).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1737a<Model,Data>()).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1700c<Model,Data>(context.getAssets())).mo12347a(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1699b<Model,Data>(context.getAssets())).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreImageThumbLoader.Factory<Model,Data>(context3)).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreVideoThumbLoader.Factory<Model,Data>(context3)).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1747d<Model,Data>(contentResolver2)).mo12347a(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1745b<Model,Data>(contentResolver2)).mo12347a(Uri.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new C1744a<Model,Data>(contentResolver2)).mo12347a(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1748a<Model,Data>()).mo12347a(URL.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1738a<Model,Data>()).mo12347a(Uri.class, File.class, (ModelLoaderFactory<Model, Data>) new MediaStoreFileLoader.Factory<Model,Data>(context3)).mo12347a(GlideUrl.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1736a<Model,Data>()).mo12347a(cls3, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new C1701a<Model,Data>()).mo12347a(cls3, InputStream.class, (ModelLoaderFactory<Model, Data>) new C1705d<Model,Data>()).mo12347a(Uri.class, Uri.class, (ModelLoaderFactory<Model, Data>) C1742a.m5983b()).mo12347a(Drawable.class, Drawable.class, (ModelLoaderFactory<Model, Data>) C1742a.m5983b()).mo12346a(Drawable.class, Drawable.class, (ResourceDecoder<Data, TResource>) new UnitDrawableDecoder<Data,TResource>()).mo12348a(Bitmap.class, BitmapDrawable.class, (ResourceTranscoder<TResource, Transcode>) new BitmapDrawableTranscoder<TResource,Transcode>(resources)).mo12348a(Bitmap.class, cls3, (ResourceTranscoder<TResource, Transcode>) bitmapBytesTranscoder2).mo12348a(Drawable.class, cls3, (ResourceTranscoder<TResource, Transcode>) new DrawableBytesTranscoder<TResource,Transcode>(eVar2, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).mo12348a(GifDrawable.class, cls3, (ResourceTranscoder<TResource, Transcode>) gifDrawableBytesTranscoder2);
        GlideContext gVar3 = new GlideContext(context, bVar, this.f4269h, new ImageViewTargetFactory(), fVar, map, list, kVar, z, i);
        this.f4268g = gVar3;
    }

    /* renamed from: a */
    public BitmapPool mo12528a() {
        return this.f4265d;
    }

    /* renamed from: b */
    public ArrayPool mo12532b() {
        return this.f4270i;
    }

    /* renamed from: c */
    public Context mo12534c() {
        return this.f4268g.getBaseContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public ConnectivityMonitorFactory mo12535d() {
        return this.f4272k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public GlideContext mo12536e() {
        return this.f4268g;
    }

    /* renamed from: f */
    public void mo12537f() {
        C1772j.m6154a();
        this.f4266e.mo12801a();
        this.f4265d.clearMemory();
        this.f4270i.mo12703a();
    }

    /* renamed from: a */
    public void mo12529a(int i) {
        C1772j.m6154a();
        this.f4266e.mo12796a(i);
        this.f4265d.trimMemory(i);
        this.f4270i.mo12704a(i);
    }

    /* renamed from: g */
    public RequestManagerRetriever mo12538g() {
        return this.f4271j;
    }

    /* renamed from: e */
    private static RequestManagerRetriever m5177e(Context context) {
        Preconditions.m6139a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m5169a(context).mo12538g();
    }

    /* renamed from: b */
    public static RequestManager m5174b(Context context) {
        return m5177e(context).mo13177a(context);
    }

    /* renamed from: a */
    public static RequestManager m5171a(FragmentActivity fragmentActivity) {
        return m5177e(fragmentActivity).mo13180a(fragmentActivity);
    }

    /* renamed from: a */
    public static RequestManager m5170a(View view) {
        return m5177e(view.getContext()).mo13178a(view);
    }

    /* renamed from: h */
    public Registry mo12539h() {
        return this.f4269h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo12531a(Target<?> hVar) {
        synchronized (this.f4273l) {
            for (RequestManager b : this.f4273l) {
                if (b.mo12598b(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12530a(RequestManager iVar) {
        synchronized (this.f4273l) {
            if (!this.f4273l.contains(iVar)) {
                this.f4273l.add(iVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo12533b(RequestManager iVar) {
        synchronized (this.f4273l) {
            if (this.f4273l.contains(iVar)) {
                this.f4273l.remove(iVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void onTrimMemory(int i) {
        mo12529a(i);
    }

    public void onLowMemory() {
        mo12537f();
    }
}
