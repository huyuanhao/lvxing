package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* renamed from: com.yanzhenjie.permission.a.o */
class SensorActivityTest implements PermissionTest {
    /* renamed from: b */
    private static final SensorEventListener f26628b = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    };
    /* renamed from: a */
    private Context f26629a;

    SensorActivityTest(Context context) {
        this.f26629a = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f26629a.getSystemService("sensor");
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(18);
            sensorManager.registerListener(f26628b, defaultSensor, 3);
            sensorManager.unregisterListener(f26628b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f26629a.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
        }
    }
}
