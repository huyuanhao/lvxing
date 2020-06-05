package com.pgl.sys.ces.p366b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;

/* renamed from: com.pgl.sys.ces.b.a */
public final class C4808a implements SensorEventListener {
    /* renamed from: f */
    private static C4808a f15469f;
    /* renamed from: a */
    private SensorManager f15470a = null;
    /* renamed from: b */
    private int f15471b;
    /* renamed from: c */
    private int f15472c = 0;
    /* renamed from: d */
    private float[] f15473d = new float[3];
    /* renamed from: e */
    private DecimalFormat f15474e = new DecimalFormat("0.0");

    private C4808a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f15470a = (SensorManager) applicationContext.getSystemService("sensor");
        }
    }

    /* renamed from: a */
    public static C4808a m19672a(Context context) {
        if (f15469f == null) {
            synchronized (C4808a.class) {
                if (f15469f == null) {
                    f15469f = new C4808a(context);
                }
            }
        }
        return f15469f;
    }

    /* renamed from: b */
    private synchronized void m19673b() {
        try {
            if (this.f15470a != null) {
                if (this.f15471b == 0) {
                    if (!this.f15470a.registerListener(this, this.f15470a.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f15471b++;
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private synchronized void m19674c() {
        try {
            if (this.f15470a != null) {
                this.f15471b--;
                if (this.f15471b == 0) {
                    this.f15470a.unregisterListener(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: a */
    public String mo25753a() {
        StringBuilder sb;
        DecimalFormat decimalFormat;
        float f;
        m19673b();
        try {
            synchronized (this) {
                int i = 0;
                while (this.f15472c == 0 && i < 10) {
                    i++;
                    wait(100);
                }
            }
            sb = new StringBuilder();
            sb.append(this.f15474e.format((double) this.f15473d[0]));
            sb.append(", ");
            sb.append(this.f15474e.format((double) this.f15473d[1]));
            sb.append(", ");
            decimalFormat = this.f15474e;
            f = this.f15473d[2];
        } catch (Exception e) {
            try {
                e.printStackTrace();
                sb = new StringBuilder();
                sb.append(this.f15474e.format((double) this.f15473d[0]));
                sb.append(", ");
                sb.append(this.f15474e.format((double) this.f15473d[1]));
                sb.append(", ");
                decimalFormat = this.f15474e;
                f = this.f15473d[2];
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f15474e.format((double) this.f15473d[0]));
                sb2.append(", ");
                sb2.append(this.f15474e.format((double) this.f15473d[1]));
                sb2.append(", ");
                sb2.append(this.f15474e.format((double) this.f15473d[2]));
                sb2.toString();
                m19674c();
                this.f15472c = 0;
                throw th;
            }
        }
        sb.append(decimalFormat.format((double) f));
        String sb3 = sb.toString();
        m19674c();
        this.f15472c = 0;
        return sb3;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f15473d = sensorEvent.values;
        this.f15472c = 1;
    }
}
