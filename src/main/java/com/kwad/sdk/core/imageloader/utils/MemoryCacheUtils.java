package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MemoryCacheUtils {
    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtils() {
    }

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() {
            public int compare(String str, String str2) {
                String str3 = MemoryCacheUtils.URI_AND_SIZE_SEPARATOR;
                return str.substring(0, str.lastIndexOf(str3)).compareTo(str2.substring(0, str2.lastIndexOf(str3)));
            }
        };
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<Bitmap> findCachedBitmapsForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCache.get(str2));
            }
        }
        return arrayList;
    }

    public static String generateKey(String str, ImageSize imageSize) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(URI_AND_SIZE_SEPARATOR);
        sb.append(imageSize.getWidth());
        sb.append(WIDTH_AND_HEIGHT_SEPARATOR);
        sb.append(imageSize.getHeight());
        return sb.toString();
    }

    public static void removeFromCache(String str, MemoryCache memoryCache) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String remove : arrayList) {
            memoryCache.remove(remove);
        }
    }
}
