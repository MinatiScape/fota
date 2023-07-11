package com.gigaset.update.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.gigaset.update.MyApplication;
/* compiled from: ShakeUtil.java */
/* loaded from: classes.dex */
public class q implements SensorEventListener2 {

    /* renamed from: a  reason: collision with root package name */
    private static q f1180a;

    /* renamed from: b  reason: collision with root package name */
    private com.gigaset.update.a.f f1181b;
    private float c;
    private float d;
    private float e;
    private long f;

    public static q a() {
        if (f1180a == null) {
            f1180a = new q();
        }
        return f1180a;
    }

    private void c() {
        Vibrator vibrator = (Vibrator) MyApplication.c().getSystemService("vibrator");
        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }
        if (Build.VERSION.SDK_INT > 25) {
            vibrator.vibrate(VibrationEffect.createOneShot(500L, 100));
        } else {
            vibrator.vibrate(500L);
        }
    }

    public void b() {
        SensorManager sensorManager = (SensorManager) MyApplication.c().getSystemService("sensor");
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f1181b = null;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener2
    public void onFlushCompleted(Sensor sensor) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        com.gigaset.update.a.f fVar;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f;
        if (j < 100) {
            return;
        }
        this.f = currentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = f - this.c;
        float f5 = f2 - this.d;
        float f6 = f3 - this.e;
        this.c = f;
        this.d = f2;
        this.e = f3;
        double sqrt = Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
        double d = j;
        Double.isNaN(d);
        if ((sqrt / d) * 10000.0d < 4500.0d || (fVar = this.f1181b) == null) {
            return;
        }
        fVar.onShaking();
        c();
    }

    public boolean a(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(1) == null) ? false : true;
    }

    public void a(com.gigaset.update.a.f fVar) {
        Sensor defaultSensor;
        SensorManager sensorManager = (SensorManager) MyApplication.c().getSystemService("sensor");
        if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(1)) != null) {
            sensorManager.registerListener(this, defaultSensor, 2);
        }
        this.f1181b = fVar;
    }
}
