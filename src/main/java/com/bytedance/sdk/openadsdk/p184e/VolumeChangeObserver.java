package com.bytedance.sdk.openadsdk.p184e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.e.f */
public class VolumeChangeObserver {
    /* renamed from: a */
    private VolumeChangeListener f8626a;
    /* renamed from: b */
    private C2419a f8627b;
    /* renamed from: c */
    private Context f8628c;
    /* renamed from: d */
    private AudioManager f8629d;
    /* renamed from: e */
    private boolean f8630e = false;

    /* compiled from: VolumeChangeObserver */
    /* renamed from: com.bytedance.sdk.openadsdk.e.f$a */
    private static class C2419a extends BroadcastReceiver {
        /* renamed from: a */
        private WeakReference<VolumeChangeObserver> f8631a;

        public C2419a(VolumeChangeObserver fVar) {
            this.f8631a = new WeakReference<>(fVar);
        }

        public void onReceive(Context context, Intent intent) {
            String str = "VolumeChangeObserver";
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    C2564t.m12220b(str, "媒体音量改变通.......");
                    VolumeChangeObserver fVar = (VolumeChangeObserver) this.f8631a.get();
                    if (fVar != null) {
                        VolumeChangeListener d = fVar.mo16564d();
                        if (d != null) {
                            int c = fVar.mo16563c();
                            if (c >= 0) {
                                d.mo14826c(c);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C2564t.m12216a(str, "onVolumeChangedError: ", th);
            }
        }
    }

    public VolumeChangeObserver(Context context) {
        this.f8628c = context;
        this.f8629d = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    /* renamed from: a */
    public void mo16561a(VolumeChangeListener eVar) {
        this.f8626a = eVar;
    }

    /* renamed from: a */
    public void mo16560a() {
        try {
            this.f8627b = new C2419a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f8628c.registerReceiver(this.f8627b, intentFilter);
            this.f8630e = true;
        } catch (Throwable th) {
            C2564t.m12216a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    /* renamed from: b */
    public void mo16562b() {
        if (this.f8630e) {
            try {
                this.f8628c.unregisterReceiver(this.f8627b);
                this.f8626a = null;
                this.f8630e = false;
            } catch (Throwable th) {
                C2564t.m12216a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    /* renamed from: c */
    public int mo16563c() {
        int i = -1;
        try {
            if (this.f8629d != null) {
                i = this.f8629d.getStreamVolume(3);
            }
            return i;
        } catch (Throwable th) {
            C2564t.m12216a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    /* renamed from: d */
    public VolumeChangeListener mo16564d() {
        return this.f8626a;
    }
}
