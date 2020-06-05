package com.qiyukf.nimlib.sdk.media.record;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5312a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.unicorn.C5961R;
import java.io.File;

public class AudioRecorder {
    public static final int DEFAULT_MAX_AUDIO_RECORD_TIME_SECOND = 60;
    private static final String TAG = "AudioRecordManager";
    /* access modifiers changed from: private */
    public File audioFile;
    private AudioManager audioManager;
    private boolean cancelRecord = false;
    /* access modifiers changed from: private */
    /* renamed from: cb */
    public IAudioRecordCallback f18782cb;
    private Context context;
    private OnErrorListener errorListener = new OnErrorListener() {
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            AudioRecorder.this.mUiHandler.removeCallbacks(AudioRecorder.this.recordingUpdateUI);
            AudioRecorder.this.handleEndRecord(false, 0);
        }
    };
    private OnInfoListener infoListener = new OnInfoListener() {
        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            if (i == 800) {
                AudioRecorder.this.recordTime = 0;
                AudioRecorder audioRecorder = AudioRecorder.this;
                audioRecorder.handleReachedMaxRecordTime(audioRecorder.maxDuration * 1000);
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler mUiHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public int maxDuration;
    /* access modifiers changed from: private */
    public MediaRecorder mediaRecorder;
    /* access modifiers changed from: private */
    public long recordTime = 0;
    /* access modifiers changed from: private */
    public RecordType recordType;
    /* access modifiers changed from: private */
    public Runnable recordingUpdateUI = new Runnable() {
        public void run() {
            if (AudioRecorder.this.mediaRecorder != null && AudioRecorder.this.f18782cb != null) {
                AudioRecorder.this.f18782cb.onUpdateAmplitude(AudioRecorder.this.mediaRecorder.getMaxAmplitude());
                AudioRecorder.this.mUiHandler.postDelayed(this, 100);
            }
        }
    };
    /* access modifiers changed from: private */
    public File tempFile;

    public AudioRecorder(Context context2, RecordType recordType2, int i, IAudioRecordCallback iAudioRecordCallback) {
        this.context = context2.getApplicationContext();
        setRecordType(recordType2);
        if (i <= 0) {
            this.maxDuration = 60;
        } else {
            this.maxDuration = i;
        }
        this.f18782cb = iAudioRecordCallback;
        this.audioManager = (AudioManager) context2.getSystemService("audio");
    }

    /* access modifiers changed from: private */
    public void handleReachedMaxRecordTime(int i) {
        this.f18782cb.onRecordReachedMaxTime(i);
        this.mUiHandler.removeCallbacks(this.recordingUpdateUI);
        stop();
        C5312a.m21838b(this.tempFile.getAbsolutePath());
    }

    private void setRecordType(RecordType recordType2) {
        if (VERSION.SDK_INT >= 10 || recordType2 == RecordType.AMR) {
            this.recordType = recordType2;
        } else {
            this.recordType = RecordType.AMR;
        }
    }

    private void stop() {
        final MediaRecorder mediaRecorder2 = this.mediaRecorder;
        this.mediaRecorder = null;
        C5361a.m22013a().mo27317c().post(new Runnable() {
            public void run() {
                try {
                    mediaRecorder2.setOnErrorListener(null);
                    mediaRecorder2.setOnInfoListener(null);
                    mediaRecorder2.setPreviewDisplay(null);
                    mediaRecorder2.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void completeRecord(boolean z) {
        if (isRecording()) {
            this.cancelRecord = z;
            this.audioManager.abandonAudioFocus(null);
            if (this.mediaRecorder != null) {
                this.mUiHandler.removeCallbacks(this.recordingUpdateUI);
                stop();
                handleEndRecord(true, (int) (System.currentTimeMillis() - this.recordTime));
            }
            this.recordTime = 0;
            C5312a.m21838b(this.tempFile.getAbsolutePath());
        }
    }

    public void handleEndRecord(boolean z, final int i) {
        if (this.cancelRecord) {
            this.f18782cb.onRecordCancel();
        } else if (!z) {
            this.f18782cb.onRecordFail();
        } else {
            this.mUiHandler.postDelayed(new Runnable() {
                public void run() {
                    C5312a.m21836a(AudioRecorder.this.tempFile.getAbsolutePath(), AudioRecorder.this.audioFile.getAbsolutePath());
                    if (AudioRecorder.this.audioFile == null || !AudioRecorder.this.audioFile.exists() || AudioRecorder.this.audioFile.length() <= 0 || i < 400) {
                        AudioRecorder.this.f18782cb.onRecordFail();
                    } else {
                        AudioRecorder.this.f18782cb.onRecordSuccess(AudioRecorder.this.audioFile, (long) i, AudioRecorder.this.recordType);
                    }
                }
            }, 500);
        }
    }

    public boolean isRecording() {
        return this.recordTime > 0;
    }

    public boolean startRecord() {
        this.audioManager.requestAudioFocus(null, 0, 2);
        String str = "AudioRecorder";
        if (isRecording()) {
            C5264a.m21617a(str, "AudioRecordManager startRecord false, as current state is isRecording");
            return false;
        } else if (!C5946c.m23839a(C5944b.TYPE_AUDIO)) {
            C5264a.m21617a(str, "AudioRecordManager startRecord false, as has no enough space to write");
            C5415g.m22165b(C5961R.string.ysf_picker_image_sdcard_not_enough_error);
            return false;
        } else {
            int outputFormat = this.recordType.getOutputFormat();
            StringBuilder sb = new StringBuilder();
            sb.append(C5406d.m22116a());
            sb.append(outputFormat);
            String a = C5946c.m23834a(sb.toString(), C5944b.TYPE_AUDIO);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C5406d.m22116a());
            sb2.append(outputFormat);
            String a2 = C5946c.m23834a(sb2.toString(), C5944b.TYPE_AUDIO);
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
                C5264a.m21617a(str, "AudioRecordManager startRecord false, as outputFilePath is empty");
                return false;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a2);
            sb3.append(this.recordType.getFileSuffix());
            this.audioFile = new File(sb3.toString());
            this.tempFile = new File(a);
            this.cancelRecord = false;
            try {
                this.mediaRecorder = new MediaRecorder();
                this.mediaRecorder.setOnInfoListener(this.infoListener);
                this.mediaRecorder.setOnErrorListener(this.errorListener);
                this.mediaRecorder.setAudioSource(1);
                this.mediaRecorder.setOutputFormat(this.recordType.getOutputFormat());
                this.mediaRecorder.setAudioEncoder(this.recordType.getAudioEncoder());
                this.mediaRecorder.setOutputFile(this.tempFile.getPath());
                this.mediaRecorder.setMaxDuration(this.maxDuration * 1000);
                if (!this.cancelRecord) {
                    this.f18782cb.onRecordReady();
                    this.mediaRecorder.prepare();
                    this.mediaRecorder.start();
                    this.recordTime = System.currentTimeMillis();
                    this.f18782cb.onRecordStart(this.tempFile, this.recordType);
                    this.mUiHandler.post(this.recordingUpdateUI);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isRecording();
        }
    }
}
