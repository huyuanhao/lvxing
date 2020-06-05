package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* renamed from: com.yanzhenjie.permission.a.p */
class SensorHeartTest implements PermissionTest {
    /* renamed from: b */
    private static final SensorEventListener f26630b = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    };
    /* renamed from: a */
    private Context f26631a;

    SensorHeartTest(Context context) {
        this.f26631a = context;
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f26631a.getSystemService("sensor");
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(21);
            sensorManager.registerListener(f26630b, defaultSensor, 3);
            sensorManager.unregisterListener(f26630b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f26631a.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate");
        }
    }
}
