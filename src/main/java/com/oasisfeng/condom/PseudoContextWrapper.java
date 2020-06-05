package com.oasisfeng.condom;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PseudoContextWrapper extends Context {
    final Context mBase;

    public AssetManager getAssets() {
        return this.mBase.getAssets();
    }

    public Resources getResources() {
        return this.mBase.getResources();
    }

    public PackageManager getPackageManager() {
        return this.mBase.getPackageManager();
    }

    public ContentResolver getContentResolver() {
        return this.mBase.getContentResolver();
    }

    public Looper getMainLooper() {
        return this.mBase.getMainLooper();
    }

    public Context getApplicationContext() {
        return this.mBase.getApplicationContext();
    }

    public void setTheme(int i) {
        this.mBase.setTheme(i);
    }

    public Theme getTheme() {
        return this.mBase.getTheme();
    }

    public ClassLoader getClassLoader() {
        return this.mBase.getClassLoader();
    }

    public String getPackageName() {
        return this.mBase.getPackageName();
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mBase.getApplicationInfo();
    }

    public String getPackageResourcePath() {
        return this.mBase.getPackageResourcePath();
    }

    public String getPackageCodePath() {
        return this.mBase.getPackageCodePath();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.mBase.getSharedPreferences(str, i);
    }

    public boolean moveSharedPreferencesFrom(Context context, String str) {
        return this.mBase.moveSharedPreferencesFrom(context, str);
    }

    public boolean deleteSharedPreferences(String str) {
        return this.mBase.deleteSharedPreferences(str);
    }

    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return this.mBase.openFileInput(str);
    }

    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        return this.mBase.openFileOutput(str, i);
    }

    public boolean deleteFile(String str) {
        return this.mBase.deleteFile(str);
    }

    public File getFileStreamPath(String str) {
        return this.mBase.getFileStreamPath(str);
    }

    public String[] fileList() {
        return this.mBase.fileList();
    }

    public File getDataDir() {
        return this.mBase.getDataDir();
    }

    public File getFilesDir() {
        return this.mBase.getFilesDir();
    }

    public File getNoBackupFilesDir() {
        return this.mBase.getNoBackupFilesDir();
    }

    public File getExternalFilesDir(String str) {
        return this.mBase.getExternalFilesDir(str);
    }

    public File[] getExternalFilesDirs(String str) {
        return this.mBase.getExternalFilesDirs(str);
    }

    public File getObbDir() {
        return this.mBase.getObbDir();
    }

    public File[] getObbDirs() {
        return this.mBase.getObbDirs();
    }

    public File getCacheDir() {
        return this.mBase.getCacheDir();
    }

    public File getCodeCacheDir() {
        return this.mBase.getCodeCacheDir();
    }

    public File getExternalCacheDir() {
        return this.mBase.getExternalCacheDir();
    }

    public File[] getExternalCacheDirs() {
        return this.mBase.getExternalCacheDirs();
    }

    public File[] getExternalMediaDirs() {
        return this.mBase.getExternalMediaDirs();
    }

    public File getDir(String str, int i) {
        return this.mBase.getDir(str, i);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return this.mBase.openOrCreateDatabase(str, i, cursorFactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return this.mBase.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
    }

    public boolean moveDatabaseFrom(Context context, String str) {
        return this.mBase.moveDatabaseFrom(context, str);
    }

    public boolean deleteDatabase(String str) {
        return this.mBase.deleteDatabase(str);
    }

    public File getDatabasePath(String str) {
        return this.mBase.getDatabasePath(str);
    }

    public String[] databaseList() {
        return this.mBase.databaseList();
    }

    @Deprecated
    public Drawable getWallpaper() {
        return this.mBase.getWallpaper();
    }

    @Deprecated
    public Drawable peekWallpaper() {
        return this.mBase.peekWallpaper();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumWidth() {
        return this.mBase.getWallpaperDesiredMinimumWidth();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumHeight() {
        return this.mBase.getWallpaperDesiredMinimumHeight();
    }

    @Deprecated
    public void setWallpaper(Bitmap bitmap) throws IOException {
        this.mBase.setWallpaper(bitmap);
    }

    @Deprecated
    public void setWallpaper(InputStream inputStream) throws IOException {
        this.mBase.setWallpaper(inputStream);
    }

    @Deprecated
    public void clearWallpaper() throws IOException {
        this.mBase.clearWallpaper();
    }

    public void startActivity(Intent intent) {
        this.mBase.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        this.mBase.startActivity(intent, bundle);
    }

    public void startActivities(Intent[] intentArr) {
        this.mBase.startActivities(intentArr);
    }

    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mBase.startActivities(intentArr, bundle);
    }

    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i, i2, i3);
    }

    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    public void sendBroadcast(Intent intent) {
        this.mBase.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String str) {
        this.mBase.sendBroadcast(intent, str);
    }

    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mBase.sendOrderedBroadcast(intent, str);
    }

    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendBroadcastAsUser(intent, userHandle);
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        this.mBase.sendBroadcastAsUser(intent, userHandle, str);
    }

    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i, str2, bundle);
    }

    public void sendStickyBroadcast(Intent intent) {
        this.mBase.sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mBase.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i, str, bundle);
    }

    public void removeStickyBroadcast(Intent intent) {
        this.mBase.removeStickyBroadcast(intent);
    }

    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendStickyBroadcastAsUser(intent, userHandle);
    }

    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        this.mBase.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i, str, bundle);
    }

    @Deprecated
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.removeStickyBroadcastAsUser(intent, userHandle);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mBase.unregisterReceiver(broadcastReceiver);
    }

    public ComponentName startService(Intent intent) {
        return this.mBase.startService(intent);
    }

    public boolean stopService(Intent intent) {
        return this.mBase.stopService(intent);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.mBase.bindService(intent, serviceConnection, i);
    }

    public void unbindService(ServiceConnection serviceConnection) {
        this.mBase.unbindService(serviceConnection);
    }

    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return this.mBase.startInstrumentation(componentName, str, bundle);
    }

    public Object getSystemService(String str) {
        return this.mBase.getSystemService(str);
    }

    public String getSystemServiceName(Class<?> cls) {
        return this.mBase.getSystemServiceName(cls);
    }

    public int checkPermission(String str, int i, int i2) {
        return this.mBase.checkPermission(str, i, i2);
    }

    public int checkCallingPermission(String str) {
        return this.mBase.checkCallingPermission(str);
    }

    public int checkCallingOrSelfPermission(String str) {
        return this.mBase.checkCallingOrSelfPermission(str);
    }

    public int checkSelfPermission(String str) {
        return this.mBase.checkSelfPermission(str);
    }

    public void enforcePermission(String str, int i, int i2, String str2) {
        this.mBase.enforcePermission(str, i, i2, str2);
    }

    public void enforceCallingPermission(String str, String str2) {
        this.mBase.enforceCallingPermission(str, str2);
    }

    public void enforceCallingOrSelfPermission(String str, String str2) {
        this.mBase.enforceCallingOrSelfPermission(str, str2);
    }

    public void grantUriPermission(String str, Uri uri, int i) {
        this.mBase.grantUriPermission(str, uri, i);
    }

    public void revokeUriPermission(Uri uri, int i) {
        this.mBase.revokeUriPermission(uri, i);
    }

    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        return this.mBase.checkUriPermission(uri, i, i2, i3);
    }

    public int checkCallingUriPermission(Uri uri, int i) {
        return this.mBase.checkCallingUriPermission(uri, i);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return this.mBase.checkCallingOrSelfUriPermission(uri, i);
    }

    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        return this.mBase.checkUriPermission(uri, str, str2, i, i2, i3);
    }

    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        this.mBase.enforceUriPermission(uri, i, i2, i3, str);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        this.mBase.enforceCallingUriPermission(uri, i, str);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        this.mBase.enforceCallingOrSelfUriPermission(uri, i, str);
    }

    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        this.mBase.enforceUriPermission(uri, str, str2, i, i2, i3, str3);
    }

    public Context createPackageContext(String str, int i) throws NameNotFoundException {
        return this.mBase.createPackageContext(str, i);
    }

    public Context createConfigurationContext(Configuration configuration) {
        return this.mBase.createConfigurationContext(configuration);
    }

    public Context createDisplayContext(Display display) {
        return this.mBase.createDisplayContext(display);
    }

    public boolean isRestricted() {
        return this.mBase.isRestricted();
    }

    public Context createDeviceProtectedStorageContext() {
        return this.mBase.createDeviceProtectedStorageContext();
    }

    public boolean isDeviceProtectedStorage() {
        return this.mBase.isDeviceProtectedStorage();
    }

    public PseudoContextWrapper(Context context) {
        this.mBase = context;
    }
}
