package com.kwad.sdk.core.imageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.core.imageloader.core.assist.ContentLengthInputStream;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context2) {
        this(context2, DEFAULT_HTTP_CONNECT_TIMEOUT, DEFAULT_HTTP_READ_TIMEOUT);
    }

    public BaseImageDownloader(Context context2, int i, int i2) {
        this.context = context2.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }

    private InputStream getVideoThumbnailStream(String str) {
        if (VERSION.SDK_INT >= 8) {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
            if (createVideoThumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createVideoThumbnail.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        }
        return null;
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection createConnection(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public InputStream getContactPhotoStream(Uri uri) {
        ContentResolver contentResolver = this.context.getContentResolver();
        return VERSION.SDK_INT >= 14 ? Contacts.openContactPhotoInputStream(contentResolver, uri, true) : Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    public InputStream getStream(String str, Object obj) {
        switch (Scheme.ofUri(str)) {
            case HTTP:
            case HTTPS:
                return getStreamFromNetwork(str, obj);
            case FILE:
                return getStreamFromFile(str, obj);
            case CONTENT:
                return getStreamFromContent(str, obj);
            case ASSETS:
                return getStreamFromAssets(str, obj);
            case DRAWABLE:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromAssets(String str, Object obj) {
        return this.context.getAssets().open(Scheme.ASSETS.crop(str));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromContent(String str, Object obj) {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(CONTENT_CONTACTS_URI_PREFIX)) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(Scheme.DRAWABLE.crop(str)));
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromFile(String str, Object obj) {
        String crop = Scheme.FILE.crop(str);
        return isVideoFileUri(str) ? getVideoThumbnailStream(crop) : new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromNetwork(String str, Object obj) {
        HttpURLConnection createConnection = createConnection(str, obj);
        int i = 0;
        while (createConnection.getResponseCode() / 100 == 3 && i < 5) {
            createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
            i++;
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
            }
            IoUtils.closeSilently(inputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("Image request failed with response code ");
            sb.append(createConnection.getResponseCode());
            throw new IOException(sb.toString());
        } catch (IOException e) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getStreamFromOtherSource(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, new Object[]{str}));
    }

    /* access modifiers changed from: protected */
    public boolean shouldBeProcessed(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getResponseCode() == 200;
    }
}
