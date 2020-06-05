package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioFocusRequestCompat {
    static final AudioAttributesCompat FOCUS_DEFAULT_ATTR = new androidx.media.AudioAttributesCompat.Builder().setUsage(1).build();
    private final AudioAttributesCompat mAudioAttributesCompat;
    private final Handler mFocusChangeHandler;
    private final int mFocusGain;
    private final Object mFrameworkAudioFocusRequest;
    private final OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private final boolean mPauseOnDuck;

    /* renamed from: androidx.media.AudioFocusRequestCompat$Builder */
    public static final class Builder {
        private boolean mAcceptsDelayedFocusGain;
        private AudioAttributesCompat mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        private Handler mFocusChangeHandler;
        private int mFocusGain;
        private OnAudioFocusChangeListener mOnAudioFocusChangeListener;
        private boolean mPauseOnDuck;

        static boolean isValidFocusGain(int i) {
            return i == 1 || i == 2 || i == 3 || i == 4;
        }

        public Builder(int i) {
            setFocusGain(i);
        }

        public Builder(AudioFocusRequestCompat audioFocusRequestCompat) {
            if (audioFocusRequestCompat != null) {
                this.mFocusGain = audioFocusRequestCompat.getFocusGain();
                this.mOnAudioFocusChangeListener = audioFocusRequestCompat.getOnAudioFocusChangeListener();
                this.mFocusChangeHandler = audioFocusRequestCompat.getFocusChangeHandler();
                this.mAudioAttributesCompat = audioFocusRequestCompat.getAudioAttributesCompat();
                this.mPauseOnDuck = audioFocusRequestCompat.willPauseWhenDucked();
                return;
            }
            throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
        }

        public Builder setFocusGain(int i) {
            if (isValidFocusGain(i)) {
                if (VERSION.SDK_INT < 19 && i == 4) {
                    i = 2;
                }
                this.mFocusGain = i;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal audio focus gain type ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setOnAudioFocusChangeListener(OnAudioFocusChangeListener onAudioFocusChangeListener) {
            return setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
        }

        public Builder setOnAudioFocusChangeListener(OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            if (onAudioFocusChangeListener == null) {
                throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
            } else if (handler != null) {
                this.mOnAudioFocusChangeListener = onAudioFocusChangeListener;
                this.mFocusChangeHandler = handler;
                return this;
            } else {
                throw new IllegalArgumentException("Handler must not be null");
            }
        }

        public Builder setAudioAttributes(AudioAttributesCompat audioAttributesCompat) {
            if (audioAttributesCompat != null) {
                this.mAudioAttributesCompat = audioAttributesCompat;
                return this;
            }
            throw new NullPointerException("Illegal null AudioAttributes");
        }

        public Builder setWillPauseWhenDucked(boolean z) {
            this.mPauseOnDuck = z;
            return this;
        }

        public AudioFocusRequestCompat build() {
            OnAudioFocusChangeListener onAudioFocusChangeListener = this.mOnAudioFocusChangeListener;
            if (onAudioFocusChangeListener != null) {
                AudioFocusRequestCompat audioFocusRequestCompat = new AudioFocusRequestCompat(this.mFocusGain, onAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, this.mPauseOnDuck);
                return audioFocusRequestCompat;
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.media.AudioFocusRequestCompat$FocusGainType */
    public @interface FocusGainType {
    }

    /* renamed from: androidx.media.AudioFocusRequestCompat$OnAudioFocusChangeListenerHandlerCompat */
    private static class OnAudioFocusChangeListenerHandlerCompat implements OnAudioFocusChangeListener, Callback {
        private static final int FOCUS_CHANGE = 2782386;
        private final Handler mHandler;
        private final OnAudioFocusChangeListener mListener;

        OnAudioFocusChangeListenerHandlerCompat(OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.mListener = onAudioFocusChangeListener;
            this.mHandler = new Handler(handler.getLooper(), this);
        }

        public void onAudioFocusChange(int i) {
            Handler handler = this.mHandler;
            handler.sendMessage(Message.obtain(handler, FOCUS_CHANGE, i, 0));
        }

        public boolean handleMessage(Message message) {
            if (message.what != FOCUS_CHANGE) {
                return false;
            }
            this.mListener.onAudioFocusChange(message.arg1);
            return true;
        }
    }

    AudioFocusRequestCompat(int i, OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z) {
        this.mFocusGain = i;
        this.mFocusChangeHandler = handler;
        this.mAudioAttributesCompat = audioAttributesCompat;
        this.mPauseOnDuck = z;
        if (VERSION.SDK_INT >= 26 || this.mFocusChangeHandler.getLooper() == Looper.getMainLooper()) {
            this.mOnAudioFocusChangeListener = onAudioFocusChangeListener;
        } else {
            this.mOnAudioFocusChangeListener = new OnAudioFocusChangeListenerHandlerCompat(onAudioFocusChangeListener, handler);
        }
        if (VERSION.SDK_INT >= 26) {
            this.mFrameworkAudioFocusRequest = new android.media.AudioFocusRequest.Builder(this.mFocusGain).setAudioAttributes(getAudioAttributes()).setWillPauseWhenDucked(this.mPauseOnDuck).setOnAudioFocusChangeListener(this.mOnAudioFocusChangeListener, this.mFocusChangeHandler).build();
        } else {
            this.mFrameworkAudioFocusRequest = null;
        }
    }

    public int getFocusGain() {
        return this.mFocusGain;
    }

    public AudioAttributesCompat getAudioAttributesCompat() {
        return this.mAudioAttributesCompat;
    }

    public boolean willPauseWhenDucked() {
        return this.mPauseOnDuck;
    }

    public OnAudioFocusChangeListener getOnAudioFocusChangeListener() {
        return this.mOnAudioFocusChangeListener;
    }

    public Handler getFocusChangeHandler() {
        return this.mFocusChangeHandler;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
        if (this.mFocusGain != audioFocusRequestCompat.mFocusGain || this.mPauseOnDuck != audioFocusRequestCompat.mPauseOnDuck || !ObjectsCompat.equals(this.mOnAudioFocusChangeListener, audioFocusRequestCompat.mOnAudioFocusChangeListener) || !ObjectsCompat.equals(this.mFocusChangeHandler, audioFocusRequestCompat.mFocusChangeHandler) || !ObjectsCompat.equals(this.mAudioAttributesCompat, audioFocusRequestCompat.mAudioAttributesCompat)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mFocusGain), this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, Boolean.valueOf(this.mPauseOnDuck));
    }

    /* access modifiers changed from: 0000 */
    public AudioAttributes getAudioAttributes() {
        AudioAttributesCompat audioAttributesCompat = this.mAudioAttributesCompat;
        if (audioAttributesCompat != null) {
            return (AudioAttributes) audioAttributesCompat.unwrap();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public AudioFocusRequest getAudioFocusRequest() {
        return (AudioFocusRequest) this.mFrameworkAudioFocusRequest;
    }
}
