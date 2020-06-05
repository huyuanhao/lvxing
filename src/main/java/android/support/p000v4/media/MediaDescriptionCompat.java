package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private MediaDescription mDescriptionFwk;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder setMediaId(String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public MediaDescriptionCompat build() {
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
            return mediaDescriptionCompat;
        }
    }

    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, parcel, i);
            TextUtils.writeToParcel(this.mSubtitle, parcel, i);
            TextUtils.writeToParcel(this.mDescription, parcel, i);
            parcel.writeParcelable(this.mIcon, i);
            parcel.writeParcelable(this.mIconUri, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.mMediaUri, i);
            return;
        }
        ((MediaDescription) getMediaDescription()).writeToParcel(parcel, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mTitle);
        String str = ", ";
        sb.append(str);
        sb.append(this.mSubtitle);
        sb.append(str);
        sb.append(this.mDescription);
        return sb.toString();
    }

    public Object getMediaDescription() {
        if (this.mDescriptionFwk != null || VERSION.SDK_INT < 21) {
            return this.mDescriptionFwk;
        }
        android.media.MediaDescription.Builder builder = new android.media.MediaDescription.Builder();
        builder.setMediaId(this.mMediaId);
        builder.setTitle(this.mTitle);
        builder.setSubtitle(this.mSubtitle);
        builder.setDescription(this.mDescription);
        builder.setIconBitmap(this.mIcon);
        builder.setIconUri(this.mIconUri);
        Bundle bundle = this.mExtras;
        if (VERSION.SDK_INT < 23 && this.mMediaUri != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            }
            bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        }
        builder.setExtras(bundle);
        if (VERSION.SDK_INT >= 23) {
            builder.setMediaUri(this.mMediaUri);
        }
        this.mDescriptionFwk = builder.build();
        return this.mDescriptionFwk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    public static android.support.p000v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r8) {
        /*
        r0 = 0
        if (r8 == 0) goto L_0x0082
        int r1 = android.os.Build.VERSION.SDK_INT
        r2 = 21
        if (r1 < r2) goto L_0x0082
        android.support.v4.media.MediaDescriptionCompat$Builder r1 = new android.support.v4.media.MediaDescriptionCompat$Builder
        r1.m37789init()
        android.media.MediaDescription r8 = (android.media.MediaDescription) r8
        java.lang.String r2 = r8.getMediaId()
        r1.setMediaId(r2)
        java.lang.CharSequence r2 = r8.getTitle()
        r1.setTitle(r2)
        java.lang.CharSequence r2 = r8.getSubtitle()
        r1.setSubtitle(r2)
        java.lang.CharSequence r2 = r8.getDescription()
        r1.setDescription(r2)
        android.graphics.Bitmap r2 = r8.getIconBitmap()
        r1.setIconBitmap(r2)
        android.net.Uri r2 = r8.getIconUri()
        r1.setIconUri(r2)
        android.os.Bundle r2 = r8.getExtras()
        java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
        if (r2 == 0) goto L_0x004c
        android.support.p000v4.media.session.MediaSessionCompat.ensureClassLoader(r2)
        android.os.Parcelable r4 = r2.getParcelable(r3)
        android.net.Uri r4 = (android.net.Uri) r4
        goto L_0x004d
    L_0x004c:
        r4 = r0
    L_0x004d:
        if (r4 == 0) goto L_0x0065
        java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
        boolean r6 = r2.containsKey(r5)
        if (r6 == 0) goto L_0x005f
        int r6 = r2.size()
        r7 = 2
        if (r6 != r7) goto L_0x005f
        goto L_0x0066
    L_0x005f:
        r2.remove(r3)
        r2.remove(r5)
    L_0x0065:
        r0 = r2
    L_0x0066:
        r1.setExtras(r0)
        if (r4 == 0) goto L_0x006f
        r1.setMediaUri(r4)
        goto L_0x007c
    L_0x006f:
        int r0 = android.os.Build.VERSION.SDK_INT
        r2 = 23
        if (r0 < r2) goto L_0x007c
        android.net.Uri r0 = r8.getMediaUri()
        r1.setMediaUri(r0)
    L_0x007c:
        android.support.v4.media.MediaDescriptionCompat r0 = r1.build()
        r0.mDescriptionFwk = r8
    L_0x0082:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
