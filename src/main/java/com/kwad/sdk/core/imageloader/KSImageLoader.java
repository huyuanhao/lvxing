package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions.Builder;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.display.CircleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

public class KSImageLoader {
    public static DisplayImageOptions IMGOPTION_ENTRY;
    public static DisplayImageOptions IMGOPTION_NORMAL = new Builder().bitmapConfig(Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();

    private static void checkInit() {
        if (!ImageLoader.getInstance().isInited()) {
            init(KsAdSDK.getContext());
        }
    }

    public static void init(Context context) {
        IMGOPTION_ENTRY = new Builder().bitmapConfig(Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(C3809l.m15795d(context, "ksad_loading_entry")).build();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        builder.threadPriority(3);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCacheSize(20971520);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        ImageLoader.getInstance().init(builder.build());
    }

    public static void loadAppIcon(ImageView imageView, String str, int i) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            checkInit();
            String str2 = "ksad_default_app_icon";
            ImageLoader.getInstance().displayImage(str, imageView, new Builder().showImageOnLoading(C3809l.m15797f(imageView.getContext(), str2)).showImageForEmptyUri(C3809l.m15797f(imageView.getContext(), str2)).showImageOnFail(C3809l.m15797f(imageView.getContext(), str2)).considerExifParams(true).bitmapConfig(Config.RGB_565).displayer(new RoundedBitmapDisplayer(C3817t.m15862a(imageView.getContext(), (float) i))).build());
        }
    }

    public static void loadAuthorCircleIcon(ImageView imageView, String str) {
        if (imageView != null) {
            checkInit();
            String str2 = "ksad_photo_default_author_icon";
            ImageLoader.getInstance().displayImage(str, imageView, new Builder().showImageOnLoading(C3809l.m15797f(imageView.getContext(), str2)).showImageForEmptyUri(C3809l.m15797f(imageView.getContext(), str2)).showImageOnFail(C3809l.m15797f(imageView.getContext(), str2)).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Config.ARGB_8888).displayer(new CircleBitmapDisplayer(Integer.valueOf(Color.argb(255, 255, 255, 255)), 1.0f)).build());
        }
    }

    public static void loadFeeImage(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            checkInit();
            ImageLoader.getInstance().displayImage(str, imageView, new Builder().bitmapConfig(Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(C3817t.m15862a(imageView.getContext(), 1.0f))).build());
        }
    }

    public static void loadImage(ImageView imageView, String str) {
        loadImage(imageView, str, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, String str, DisplayImageOptions displayImageOptions) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            checkInit();
            if (displayImageOptions == null) {
                displayImageOptions = IMGOPTION_NORMAL;
            }
            ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions);
        }
    }

    public static void loadImage(ImageView imageView, String str, ImageLoadingListener imageLoadingListener) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            checkInit();
            ImageLoader.getInstance().displayImage(str, imageView, IMGOPTION_NORMAL, imageLoadingListener);
        }
    }

    public static void preloadImage(String str) {
        if (!TextUtils.isEmpty(str) && KsAdSDK.getContext() != null) {
            checkInit();
            ImageLoader.getInstance().loadImage(str, IMGOPTION_NORMAL, (ImageLoadingListener) null);
        }
    }
}
