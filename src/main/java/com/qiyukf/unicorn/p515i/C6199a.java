package com.qiyukf.unicorn.p515i;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Instrumentation.ActivityResult;
import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.TestLooperManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* renamed from: com.qiyukf.unicorn.i.a */
public final class C6199a extends Instrumentation {
    /* renamed from: a */
    private Instrumentation f19368a;

    public C6199a(Instrumentation instrumentation) {
        this.f19368a = instrumentation;
    }

    public final TestLooperManager acquireLooperManager(Looper looper) {
        return this.f19368a.acquireLooperManager(looper);
    }

    public final ActivityMonitor addMonitor(IntentFilter intentFilter, ActivityResult activityResult, boolean z) {
        return this.f19368a.addMonitor(intentFilter, activityResult, z);
    }

    public final ActivityMonitor addMonitor(String str, ActivityResult activityResult, boolean z) {
        return this.f19368a.addMonitor(str, activityResult, z);
    }

    public final void addMonitor(ActivityMonitor activityMonitor) {
        this.f19368a.addMonitor(activityMonitor);
    }

    public final void addResults(Bundle bundle) {
        this.f19368a.addResults(bundle);
    }

    public final void callActivityOnCreate(Activity activity, Bundle bundle) {
        this.f19368a.callActivityOnCreate(activity, bundle);
    }

    public final void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.f19368a.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    public final void callActivityOnDestroy(Activity activity) {
        this.f19368a.callActivityOnDestroy(activity);
    }

    public final void callActivityOnNewIntent(Activity activity, Intent intent) {
        this.f19368a.callActivityOnNewIntent(activity, intent);
    }

    public final void callActivityOnPause(Activity activity) {
        this.f19368a.callActivityOnPause(activity);
        C6200b.m24602a().mo29398b(activity);
    }

    public final void callActivityOnPostCreate(Activity activity, Bundle bundle) {
        this.f19368a.callActivityOnPostCreate(activity, bundle);
    }

    public final void callActivityOnPostCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.f19368a.callActivityOnPostCreate(activity, bundle, persistableBundle);
    }

    public final void callActivityOnRestart(Activity activity) {
        this.f19368a.callActivityOnRestart(activity);
    }

    public final void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        this.f19368a.callActivityOnRestoreInstanceState(activity, bundle);
    }

    public final void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.f19368a.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
    }

    public final void callActivityOnResume(Activity activity) {
        this.f19368a.callActivityOnResume(activity);
        C6200b.m24602a().mo29390a(activity);
    }

    public final void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        this.f19368a.callActivityOnSaveInstanceState(activity, bundle);
    }

    public final void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        this.f19368a.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
    }

    public final void callActivityOnStart(Activity activity) {
        this.f19368a.callActivityOnStart(activity);
    }

    public final void callActivityOnStop(Activity activity) {
        this.f19368a.callActivityOnStop(activity);
    }

    public final void callActivityOnUserLeaving(Activity activity) {
        this.f19368a.callActivityOnUserLeaving(activity);
    }

    public final void callApplicationOnCreate(Application application) {
        this.f19368a.callApplicationOnCreate(application);
    }

    public final boolean checkMonitorHit(ActivityMonitor activityMonitor, int i) {
        return this.f19368a.checkMonitorHit(activityMonitor, i);
    }

    public final void endPerformanceSnapshot() {
        this.f19368a.endPerformanceSnapshot();
    }

    public final void finish(int i, Bundle bundle) {
        this.f19368a.finish(i, bundle);
    }

    public final Bundle getAllocCounts() {
        return this.f19368a.getAllocCounts();
    }

    public final Bundle getBinderCounts() {
        return this.f19368a.getBinderCounts();
    }

    public final ComponentName getComponentName() {
        return this.f19368a.getComponentName();
    }

    public final Context getContext() {
        return this.f19368a.getContext();
    }

    public final String getProcessName() {
        return this.f19368a.getProcessName();
    }

    public final Context getTargetContext() {
        return this.f19368a.getTargetContext();
    }

    public final UiAutomation getUiAutomation() {
        return this.f19368a.getUiAutomation();
    }

    public final UiAutomation getUiAutomation(int i) {
        return this.f19368a.getUiAutomation(i);
    }

    public final boolean invokeContextMenuAction(Activity activity, int i, int i2) {
        return this.f19368a.invokeContextMenuAction(activity, i, i2);
    }

    public final boolean invokeMenuActionSync(Activity activity, int i, int i2) {
        return this.f19368a.invokeMenuActionSync(activity, i, i2);
    }

    public final boolean isProfiling() {
        return this.f19368a.isProfiling();
    }

    public final Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        return this.f19368a.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    public final Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        return this.f19368a.newActivity(classLoader, str, intent);
    }

    public final Application newApplication(ClassLoader classLoader, String str, Context context) {
        return this.f19368a.newApplication(classLoader, str, context);
    }

    public final void onCreate(Bundle bundle) {
        this.f19368a.onCreate(bundle);
    }

    public final void onDestroy() {
        this.f19368a.onDestroy();
    }

    public final boolean onException(Object obj, Throwable th) {
        return this.f19368a.onException(obj, th);
    }

    public final void onStart() {
        this.f19368a.onStart();
    }

    public final void removeMonitor(ActivityMonitor activityMonitor) {
        this.f19368a.removeMonitor(activityMonitor);
    }

    public final void runOnMainSync(Runnable runnable) {
        this.f19368a.runOnMainSync(runnable);
    }

    public final void sendCharacterSync(int i) {
        this.f19368a.sendCharacterSync(i);
    }

    public final void sendKeyDownUpSync(int i) {
        this.f19368a.sendKeyDownUpSync(i);
    }

    public final void sendKeySync(KeyEvent keyEvent) {
        this.f19368a.sendKeySync(keyEvent);
    }

    public final void sendPointerSync(MotionEvent motionEvent) {
        this.f19368a.sendPointerSync(motionEvent);
    }

    public final void sendStatus(int i, Bundle bundle) {
        this.f19368a.sendStatus(i, bundle);
    }

    public final void sendStringSync(String str) {
        this.f19368a.sendStringSync(str);
    }

    public final void sendTrackballEventSync(MotionEvent motionEvent) {
        this.f19368a.sendTrackballEventSync(motionEvent);
    }

    public final void setAutomaticPerformanceSnapshots() {
        this.f19368a.setAutomaticPerformanceSnapshots();
    }

    public final void setInTouchMode(boolean z) {
        this.f19368a.setInTouchMode(z);
    }

    public final void start() {
        this.f19368a.start();
    }

    public final Activity startActivitySync(Intent intent) {
        return this.f19368a.startActivitySync(intent);
    }

    public final void startAllocCounting() {
        this.f19368a.startAllocCounting();
    }

    public final void startPerformanceSnapshot() {
        this.f19368a.startPerformanceSnapshot();
    }

    public final void startProfiling() {
        this.f19368a.startProfiling();
    }

    public final void stopAllocCounting() {
        this.f19368a.stopAllocCounting();
    }

    public final void stopProfiling() {
        this.f19368a.stopProfiling();
    }

    public final void waitForIdle(Runnable runnable) {
        this.f19368a.waitForIdle(runnable);
    }

    public final void waitForIdleSync() {
        this.f19368a.waitForIdleSync();
    }

    public final Activity waitForMonitor(ActivityMonitor activityMonitor) {
        return this.f19368a.waitForMonitor(activityMonitor);
    }

    public final Activity waitForMonitorWithTimeout(ActivityMonitor activityMonitor, long j) {
        return this.f19368a.waitForMonitorWithTimeout(activityMonitor, j);
    }
}
