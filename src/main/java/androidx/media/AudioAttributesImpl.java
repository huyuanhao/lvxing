package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

interface AudioAttributesImpl extends VersionedParcelable {

    /* renamed from: androidx.media.AudioAttributesImpl$Builder */
    public interface Builder {
        AudioAttributesImpl build();

        Builder setContentType(int i);

        Builder setFlags(int i);

        Builder setLegacyStreamType(int i);

        Builder setUsage(int i);
    }

    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();
}
