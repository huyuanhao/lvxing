package com.qiyukf.nimlib.sdk.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import java.io.File;

public final class AudioPlayer {
    public static final String TAG = "AudioPlayer";
    private static final int WHAT_COUNT_PLAY = 0;
    private static final int WHAT_DECODE_FAILED = 2;
    private static final int WHAT_DECODE_SUCCEED = 1;
    private AudioManager audioManager;
    private int audioStreamType;
    /* access modifiers changed from: private */
    public String mAudioFile;
    private boolean mCanPlay;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public long mIntervalTime;
    /* access modifiers changed from: private */
    public OnPlayListener mListener;
    /* access modifiers changed from: private */
    public MediaPlayer mPlayer;
    OnAudioFocusChangeListener onAudioFocusChangeListener;

    public AudioPlayer(Context context) {
        this(context, null, null);
    }

    public AudioPlayer(Context context, String str, OnPlayListener onPlayListener) {
        this.mIntervalTime = 500;
        this.mCanPlay = false;
        this.audioStreamType = 0;
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        AudioPlayer.this.startInner();
                    } else if (i == 2) {
                        StringBuilder sb = new StringBuilder("convert() error: ");
                        sb.append(AudioPlayer.this.mAudioFile);
                        C5264a.m21622c(AudioPlayer.TAG, sb.toString());
                        return;
                    }
                    return;
                }
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onPlaying((long) AudioPlayer.this.mPlayer.getCurrentPosition());
                }
                sendEmptyMessageDelayed(0, AudioPlayer.this.mIntervalTime);
            }
        };
        this.onAudioFocusChangeListener = new OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int i) {
                StringBuilder sb = new StringBuilder("onAudioFocusChange:");
                sb.append(i);
                C5264a.m21620b("test", sb.toString());
                if (i != -3) {
                    if (i == -2) {
                        AudioPlayer.this.stop();
                    } else if (i == -1) {
                        AudioPlayer.this.stop();
                    } else if (i == 1 && AudioPlayer.this.isPlaying()) {
                        AudioPlayer.this.mPlayer.setVolume(1.0f, 1.0f);
                    }
                } else if (AudioPlayer.this.isPlaying()) {
                    AudioPlayer.this.mPlayer.setVolume(0.1f, 0.1f);
                }
            }
        };
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.mAudioFile = str;
        this.mListener = onPlayListener;
    }

    /* access modifiers changed from: private */
    public boolean convert() {
        return true;
    }

    private void deleteOnExit() {
        File file = new File(this.mAudioFile);
        if (file.exists()) {
            file.deleteOnExit();
        }
    }

    /* access modifiers changed from: private */
    public void endPlay() {
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
            this.mHandler.removeMessages(0);
        }
    }

    private boolean needConvert() {
        return false;
    }

    /* access modifiers changed from: private */
    public void startInner() {
        AudioManager audioManager2;
        String str = TAG;
        this.mPlayer = new MediaPlayer();
        boolean z = false;
        this.mPlayer.setLooping(false);
        this.mPlayer.setAudioStreamType(this.audioStreamType);
        if (this.audioStreamType == 3) {
            audioManager2 = this.audioManager;
            z = true;
        } else {
            audioManager2 = this.audioManager;
        }
        audioManager2.setSpeakerphoneOn(z);
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, this.audioStreamType, 2);
        this.mPlayer.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                C5264a.m21624d(AudioPlayer.TAG, "player:onPrepared");
                AudioPlayer.this.mHandler.sendEmptyMessage(0);
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onPrepared();
                }
            }
        });
        this.mPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                C5264a.m21624d(AudioPlayer.TAG, "player:onCompletion");
                AudioPlayer.this.endPlay();
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onCompletion();
                }
            }
        });
        this.mPlayer.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                C5264a.m21622c(AudioPlayer.TAG, "player:onOnError");
                AudioPlayer.this.endPlay();
                if (AudioPlayer.this.mListener != null) {
                    AudioPlayer.this.mListener.onError(String.format("OnErrorListener what:%d extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
                return true;
            }
        });
        try {
            if (this.mAudioFile != null) {
                this.mPlayer.setDataSource(this.mAudioFile);
                this.mPlayer.prepare();
                this.mPlayer.start();
                StringBuilder sb = new StringBuilder("player:start ok---->");
                sb.append(this.mAudioFile);
                C5264a.m21624d(str, sb.toString());
                return;
            }
            if (this.mListener != null) {
                this.mListener.onError("no datasource");
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb2 = new StringBuilder("player:onOnError Exception\n");
            sb2.append(e.toString());
            C5264a.m21622c(str, sb2.toString());
            endPlay();
            OnPlayListener onPlayListener = this.mListener;
            if (onPlayListener != null) {
                StringBuilder sb3 = new StringBuilder("Exception\n");
                sb3.append(e.toString());
                onPlayListener.onError(sb3.toString());
            }
        }
    }

    private void startPlay() {
        C5264a.m21624d(TAG, "start() called");
        endPlay();
        if (!this.mCanPlay) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    if (AudioPlayer.this.mHandler != null) {
                        AudioPlayer.this.mHandler.sendEmptyMessage(AudioPlayer.this.convert() ? 1 : 2);
                    }
                }
            });
            thread.setPriority(10);
            thread.start();
            return;
        }
        startInner();
    }

    public final long getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return (long) mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public final long getDuration() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return (long) mediaPlayer.getDuration();
        }
        return 0;
    }

    public final OnPlayListener getOnPlayListener() {
        return this.mListener;
    }

    public final boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public final void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    public final void setDataSource(String str) {
        if (!TextUtils.equals(str, this.mAudioFile)) {
            this.mAudioFile = str;
            this.mCanPlay = !needConvert();
        }
    }

    public final void setOnPlayListener(OnPlayListener onPlayListener) {
        this.mListener = onPlayListener;
    }

    public final void start(int i) {
        this.audioStreamType = i;
        startPlay();
    }

    public final void stop() {
        if (this.mPlayer != null) {
            endPlay();
            OnPlayListener onPlayListener = this.mListener;
            if (onPlayListener != null) {
                onPlayListener.onInterrupt();
            }
        }
    }
}
