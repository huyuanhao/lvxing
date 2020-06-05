package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public boolean handles(Uri uri, Options fVar) {
        return uri.getScheme().equals("android.resource");
    }

    public Resource<Drawable> decode(Uri uri, int i, int i2, Options fVar) {
        Context findContextForPackage = findContextForPackage(uri, uri.getAuthority());
        return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, findContextForPackage, findResourceIdFromUri(findContextForPackage, uri)));
    }

    private Context findContextForPackage(Uri uri, String str) {
        if (str.equals(this.context.getPackageName())) {
            return this.context;
        }
        try {
            r4 = uri;
            r4 = this.context.createPackageContext(str, 0);
            r4 = r4;
            return r4;
        } catch (NameNotFoundException e) {
            if (str.contains(this.context.getPackageName())) {
                return this.context;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(r4);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    private int findResourceIdFromUri(Context context2, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return findResourceIdFromTypeAndNameResourceUri(context2, uri);
        }
        if (pathSegments.size() == 1) {
            return findResourceIdFromResourceIdUri(uri);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized Uri format: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context context2, Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        String str2 = (String) pathSegments.get(1);
        int identifier = context2.getResources().getIdentifier(str2, str, uri.getAuthority());
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, ANDROID_PACKAGE_NAME);
        }
        if (identifier != 0) {
            return identifier;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to find resource id for: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString());
    }

    private int findResourceIdFromResourceIdUri(Uri uri) {
        List pathSegments = uri.getPathSegments();
        try {
            r5 = uri;
            r5 = Integer.parseInt((String) pathSegments.get(0));
            r5 = r5;
            return r5;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(r5);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }
}
