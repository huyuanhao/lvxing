package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType;

    /* renamed from: androidx.media.AudioAttributesImplApi21$Builder */
    static class Builder implements androidx.media.AudioAttributesImpl.Builder {
        final android.media.AudioAttributes.Builder mFwkBuilder;

        Builder() {
            this.mFwkBuilder = new android.media.AudioAttributes.Builder();
        }

        Builder(Object obj) {
            this.mFwkBuilder = new android.media.AudioAttributes.Builder((AudioAttributes) obj);
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.mFwkBuilder.build());
        }

        public Builder setUsage(int i) {
            if (i == 16) {
                i = 12;
            }
            this.mFwkBuilder.setUsage(i);
            return this;
        }

        public Builder setContentType(int i) {
            this.mFwkBuilder.setContentType(i);
            return this;
        }

        public Builder setFlags(int i) {
            this.mFwkBuilder.setFlags(i);
            return this;
        }

        public Builder setLegacyStreamType(int i) {
            this.mFwkBuilder.setLegacyStreamType(i);
            return this;
        }
    }

    AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i) {
        this.mLegacyStreamType = -1;
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = i;
    }

    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
    }

    public int getLegacyStreamType() {
        int i = this.mLegacyStreamType;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.toVolumeStreamType(false, getFlags(), getUsage());
    }

    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioAttributesCompat: audioattributes=");
        sb.append(this.mAudioAttributes);
        return sb.toString();
    }
}
