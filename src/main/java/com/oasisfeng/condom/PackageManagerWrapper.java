package com.oasisfeng.condom;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.InstrumentationInfo;
import android.content.pm.KeySet;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.MoveCallback;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager.OnPermissionsChangedListener;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.UserHandle;
import java.util.List;

class PackageManagerWrapper extends PackageManager {
    private PackageManager mBase;

    PackageManagerWrapper(PackageManager packageManager) {
        this.mBase = packageManager;
    }

    public PackageInfo getPackageInfo(String str, int i) throws NameNotFoundException {
        return this.mBase.getPackageInfo(str, i);
    }

    public PackageInfo getPackageInfoAsUser(String str, int i, int i2) throws NameNotFoundException {
        return this.mBase.getPackageInfoAsUser(str, i, i2);
    }

    public String[] currentToCanonicalPackageNames(String[] strArr) {
        return this.mBase.currentToCanonicalPackageNames(strArr);
    }

    public String[] canonicalToCurrentPackageNames(String[] strArr) {
        return this.mBase.canonicalToCurrentPackageNames(strArr);
    }

    public Intent getLaunchIntentForPackage(String str) {
        return this.mBase.getLaunchIntentForPackage(str);
    }

    public Intent getLeanbackLaunchIntentForPackage(String str) {
        return this.mBase.getLeanbackLaunchIntentForPackage(str);
    }

    public int[] getPackageGids(String str) throws NameNotFoundException {
        return this.mBase.getPackageGids(str);
    }

    public int[] getPackageGids(String str, int i) throws NameNotFoundException {
        return this.mBase.getPackageGids(str, i);
    }

    public int getPackageUid(String str, int i) throws NameNotFoundException {
        return this.mBase.getPackageUid(str, i);
    }

    public int getPackageUidAsUser(String str, int i) throws NameNotFoundException {
        return this.mBase.getPackageUidAsUser(str, i);
    }

    public int getPackageUidAsUser(String str, int i, int i2) throws NameNotFoundException {
        return this.mBase.getPackageUidAsUser(str, i, i2);
    }

    public PermissionInfo getPermissionInfo(String str, int i) throws NameNotFoundException {
        return this.mBase.getPermissionInfo(str, i);
    }

    public List<PermissionInfo> queryPermissionsByGroup(String str, int i) throws NameNotFoundException {
        return this.mBase.queryPermissionsByGroup(str, i);
    }

    public PermissionGroupInfo getPermissionGroupInfo(String str, int i) throws NameNotFoundException {
        return this.mBase.getPermissionGroupInfo(str, i);
    }

    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        return this.mBase.getAllPermissionGroups(i);
    }

    public ApplicationInfo getApplicationInfo(String str, int i) throws NameNotFoundException {
        return this.mBase.getApplicationInfo(str, i);
    }

    public ApplicationInfo getApplicationInfoAsUser(String str, int i, int i2) throws NameNotFoundException {
        return this.mBase.getApplicationInfoAsUser(str, i, i2);
    }

    public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws NameNotFoundException {
        return this.mBase.getActivityInfo(componentName, i);
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws NameNotFoundException {
        return this.mBase.getReceiverInfo(componentName, i);
    }

    public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws NameNotFoundException {
        return this.mBase.getServiceInfo(componentName, i);
    }

    public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws NameNotFoundException {
        return this.mBase.getProviderInfo(componentName, i);
    }

    public List<PackageInfo> getInstalledPackages(int i) {
        return this.mBase.getInstalledPackages(i);
    }

    public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i) {
        return this.mBase.getPackagesHoldingPermissions(strArr, i);
    }

    public List<PackageInfo> getInstalledPackagesAsUser(int i, int i2) {
        return this.mBase.getInstalledPackagesAsUser(i, i2);
    }

    public int checkPermission(String str, String str2) {
        return this.mBase.checkPermission(str, str2);
    }

    public boolean isPermissionRevokedByPolicy(String str, String str2) {
        return this.mBase.isPermissionRevokedByPolicy(str, str2);
    }

    public String getPermissionControllerPackageName() {
        return this.mBase.getPermissionControllerPackageName();
    }

    public boolean addPermission(PermissionInfo permissionInfo) {
        return this.mBase.addPermission(permissionInfo);
    }

    public boolean addPermissionAsync(PermissionInfo permissionInfo) {
        return this.mBase.addPermissionAsync(permissionInfo);
    }

    public void removePermission(String str) {
        this.mBase.removePermission(str);
    }

    public void grantRuntimePermission(String str, String str2, UserHandle userHandle) {
        this.mBase.grantRuntimePermission(str, str2, userHandle);
    }

    public void revokeRuntimePermission(String str, String str2, UserHandle userHandle) {
        this.mBase.revokeRuntimePermission(str, str2, userHandle);
    }

    public int getPermissionFlags(String str, String str2, UserHandle userHandle) {
        return this.mBase.getPermissionFlags(str, str2, userHandle);
    }

    public void updatePermissionFlags(String str, String str2, int i, int i2, UserHandle userHandle) {
        this.mBase.updatePermissionFlags(str, str2, i, i2, userHandle);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mBase.shouldShowRequestPermissionRationale(str);
    }

    public Intent buildRequestPermissionsIntent(String[] strArr) {
        return this.mBase.buildRequestPermissionsIntent(strArr);
    }

    public int checkSignatures(String str, String str2) {
        return this.mBase.checkSignatures(str, str2);
    }

    public int checkSignatures(int i, int i2) {
        return this.mBase.checkSignatures(i, i2);
    }

    public String[] getPackagesForUid(int i) {
        return this.mBase.getPackagesForUid(i);
    }

    public String getNameForUid(int i) {
        return this.mBase.getNameForUid(i);
    }

    public int getUidForSharedUser(String str) throws NameNotFoundException {
        return this.mBase.getUidForSharedUser(str);
    }

    public List<ApplicationInfo> getInstalledApplications(int i) {
        return this.mBase.getInstalledApplications(i);
    }

    public Drawable getEphemeralApplicationIcon(String str) {
        return this.mBase.getEphemeralApplicationIcon(str);
    }

    public boolean isEphemeralApplication() {
        return this.mBase.isEphemeralApplication();
    }

    public int getEphemeralCookieMaxSizeBytes() {
        return this.mBase.getEphemeralCookieMaxSizeBytes();
    }

    public byte[] getEphemeralCookie() {
        return this.mBase.getEphemeralCookie();
    }

    public boolean setEphemeralCookie(byte[] bArr) {
        return this.mBase.setEphemeralCookie(bArr);
    }

    public String[] getSystemSharedLibraryNames() {
        return this.mBase.getSystemSharedLibraryNames();
    }

    public String getServicesSystemSharedLibraryPackageName() {
        return this.mBase.getServicesSystemSharedLibraryPackageName();
    }

    public String getSharedSystemSharedLibraryPackageName() {
        return this.mBase.getSharedSystemSharedLibraryPackageName();
    }

    public FeatureInfo[] getSystemAvailableFeatures() {
        return this.mBase.getSystemAvailableFeatures();
    }

    public boolean hasSystemFeature(String str) {
        return this.mBase.hasSystemFeature(str);
    }

    public boolean hasSystemFeature(String str, int i) {
        return this.mBase.hasSystemFeature(str, i);
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        return this.mBase.resolveActivity(intent, i);
    }

    public ResolveInfo resolveActivityAsUser(Intent intent, int i, int i2) {
        return this.mBase.resolveActivityAsUser(intent, i, i2);
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        return this.mBase.queryIntentActivities(intent, i);
    }

    public List<ResolveInfo> queryIntentActivitiesAsUser(Intent intent, int i, int i2) {
        return this.mBase.queryIntentActivitiesAsUser(intent, i, i2);
    }

    public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
        return this.mBase.queryIntentActivityOptions(componentName, intentArr, intent, i);
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        return this.mBase.queryBroadcastReceivers(intent, i);
    }

    public List<ResolveInfo> queryBroadcastReceiversAsUser(Intent intent, int i, UserHandle userHandle) {
        return this.mBase.queryBroadcastReceiversAsUser(intent, i, userHandle);
    }

    public List<ResolveInfo> queryBroadcastReceiversAsUser(Intent intent, int i, int i2) {
        return this.mBase.queryBroadcastReceiversAsUser(intent, i, i2);
    }

    @Deprecated
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i, int i2) {
        return this.mBase.queryBroadcastReceivers(intent, i, i2);
    }

    public ResolveInfo resolveService(Intent intent, int i) {
        return this.mBase.resolveService(intent, i);
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        return this.mBase.queryIntentServices(intent, i);
    }

    public List<ResolveInfo> queryIntentServicesAsUser(Intent intent, int i, int i2) {
        return this.mBase.queryIntentServicesAsUser(intent, i, i2);
    }

    public List<ResolveInfo> queryIntentContentProvidersAsUser(Intent intent, int i, int i2) {
        return this.mBase.queryIntentContentProvidersAsUser(intent, i, i2);
    }

    public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i) {
        return this.mBase.queryIntentContentProviders(intent, i);
    }

    public ProviderInfo resolveContentProvider(String str, int i) {
        return this.mBase.resolveContentProvider(str, i);
    }

    public ProviderInfo resolveContentProviderAsUser(String str, int i, int i2) {
        return this.mBase.resolveContentProviderAsUser(str, i, i2);
    }

    public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
        return this.mBase.queryContentProviders(str, i, i2);
    }

    public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) throws NameNotFoundException {
        return this.mBase.getInstrumentationInfo(componentName, i);
    }

    public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
        return this.mBase.queryInstrumentation(str, i);
    }

    public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getDrawable(str, i, applicationInfo);
    }

    public Drawable getActivityIcon(ComponentName componentName) throws NameNotFoundException {
        return this.mBase.getActivityIcon(componentName);
    }

    public Drawable getActivityIcon(Intent intent) throws NameNotFoundException {
        return this.mBase.getActivityIcon(intent);
    }

    public Drawable getActivityBanner(ComponentName componentName) throws NameNotFoundException {
        return this.mBase.getActivityBanner(componentName);
    }

    public Drawable getActivityBanner(Intent intent) throws NameNotFoundException {
        return this.mBase.getActivityBanner(intent);
    }

    public Drawable getDefaultActivityIcon() {
        return this.mBase.getDefaultActivityIcon();
    }

    public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationIcon(applicationInfo);
    }

    public Drawable getApplicationIcon(String str) throws NameNotFoundException {
        return this.mBase.getApplicationIcon(str);
    }

    public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationBanner(applicationInfo);
    }

    public Drawable getApplicationBanner(String str) throws NameNotFoundException {
        return this.mBase.getApplicationBanner(str);
    }

    public Drawable getActivityLogo(ComponentName componentName) throws NameNotFoundException {
        return this.mBase.getActivityLogo(componentName);
    }

    public Drawable getActivityLogo(Intent intent) throws NameNotFoundException {
        return this.mBase.getActivityLogo(intent);
    }

    public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationLogo(applicationInfo);
    }

    public Drawable getApplicationLogo(String str) throws NameNotFoundException {
        return this.mBase.getApplicationLogo(str);
    }

    public Drawable getManagedUserBadgedDrawable(Drawable drawable, Rect rect, int i) {
        return this.mBase.getManagedUserBadgedDrawable(drawable, rect, i);
    }

    public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
        return this.mBase.getUserBadgedIcon(drawable, userHandle);
    }

    public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
        return this.mBase.getUserBadgedDrawableForDensity(drawable, userHandle, rect, i);
    }

    public Drawable getUserBadgeForDensity(UserHandle userHandle, int i) {
        return this.mBase.getUserBadgeForDensity(userHandle, i);
    }

    public Drawable getUserBadgeForDensityNoBackground(UserHandle userHandle, int i) {
        return this.mBase.getUserBadgeForDensityNoBackground(userHandle, i);
    }

    public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
        return this.mBase.getUserBadgedLabel(charSequence, userHandle);
    }

    public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getText(str, i, applicationInfo);
    }

    public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
        return this.mBase.getXml(str, i, applicationInfo);
    }

    public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
        return this.mBase.getApplicationLabel(applicationInfo);
    }

    public Resources getResourcesForActivity(ComponentName componentName) throws NameNotFoundException {
        return this.mBase.getResourcesForActivity(componentName);
    }

    public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws NameNotFoundException {
        return this.mBase.getResourcesForApplication(applicationInfo);
    }

    public Resources getResourcesForApplication(String str) throws NameNotFoundException {
        return this.mBase.getResourcesForApplication(str);
    }

    public Resources getResourcesForApplicationAsUser(String str, int i) throws NameNotFoundException {
        return this.mBase.getResourcesForApplicationAsUser(str, i);
    }

    public PackageInfo getPackageArchiveInfo(String str, int i) {
        return this.mBase.getPackageArchiveInfo(str, i);
    }

    public int installExistingPackage(String str) throws NameNotFoundException {
        return this.mBase.installExistingPackage(str);
    }

    public int installExistingPackageAsUser(String str, int i) throws NameNotFoundException {
        return this.mBase.installExistingPackageAsUser(str, i);
    }

    public void verifyPendingInstall(int i, int i2) {
        this.mBase.verifyPendingInstall(i, i2);
    }

    public void extendVerificationTimeout(int i, int i2, long j) {
        this.mBase.extendVerificationTimeout(i, i2, j);
    }

    public void verifyIntentFilter(int i, int i2, List<String> list) {
        this.mBase.verifyIntentFilter(i, i2, list);
    }

    public int getIntentVerificationStatusAsUser(String str, int i) {
        return this.mBase.getIntentVerificationStatusAsUser(str, i);
    }

    public boolean updateIntentVerificationStatusAsUser(String str, int i, int i2) {
        return this.mBase.updateIntentVerificationStatusAsUser(str, i, i2);
    }

    public List<IntentFilter> getAllIntentFilters(String str) {
        return this.mBase.getAllIntentFilters(str);
    }

    public String getDefaultBrowserPackageNameAsUser(int i) {
        return this.mBase.getDefaultBrowserPackageNameAsUser(i);
    }

    public boolean setDefaultBrowserPackageNameAsUser(String str, int i) {
        return this.mBase.setDefaultBrowserPackageNameAsUser(str, i);
    }

    public void setInstallerPackageName(String str, String str2) {
        this.mBase.setInstallerPackageName(str, str2);
    }

    public String getInstallerPackageName(String str) {
        return this.mBase.getInstallerPackageName(str);
    }

    public void deletePackage(String str, IPackageDeleteObserver iPackageDeleteObserver, int i) {
        this.mBase.deletePackage(str, iPackageDeleteObserver, i);
    }

    public void deletePackageAsUser(String str, IPackageDeleteObserver iPackageDeleteObserver, int i, int i2) {
        this.mBase.deletePackageAsUser(str, iPackageDeleteObserver, i, i2);
    }

    public void clearApplicationUserData(String str, IPackageDataObserver iPackageDataObserver) {
        this.mBase.clearApplicationUserData(str, iPackageDataObserver);
    }

    public void deleteApplicationCacheFiles(String str, IPackageDataObserver iPackageDataObserver) {
        this.mBase.deleteApplicationCacheFiles(str, iPackageDataObserver);
    }

    public void deleteApplicationCacheFilesAsUser(String str, int i, IPackageDataObserver iPackageDataObserver) {
        this.mBase.deleteApplicationCacheFilesAsUser(str, i, iPackageDataObserver);
    }

    public void freeStorageAndNotify(long j, IPackageDataObserver iPackageDataObserver) {
        this.mBase.freeStorageAndNotify(j, iPackageDataObserver);
    }

    public void freeStorageAndNotify(String str, long j, IPackageDataObserver iPackageDataObserver) {
        this.mBase.freeStorageAndNotify(str, j, iPackageDataObserver);
    }

    public void freeStorage(long j, IntentSender intentSender) {
        this.mBase.freeStorage(j, intentSender);
    }

    public void freeStorage(String str, long j, IntentSender intentSender) {
        this.mBase.freeStorage(str, j, intentSender);
    }

    public void getPackageSizeInfoAsUser(String str, int i, IPackageStatsObserver iPackageStatsObserver) {
        this.mBase.getPackageSizeInfoAsUser(str, i, iPackageStatsObserver);
    }

    public void getPackageSizeInfo(String str, IPackageStatsObserver iPackageStatsObserver) {
        this.mBase.getPackageSizeInfo(str, iPackageStatsObserver);
    }

    public void addPackageToPreferred(String str) {
        this.mBase.addPackageToPreferred(str);
    }

    public void removePackageFromPreferred(String str) {
        this.mBase.removePackageFromPreferred(str);
    }

    public List<PackageInfo> getPreferredPackages(int i) {
        return this.mBase.getPreferredPackages(i);
    }

    public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        this.mBase.addPreferredActivity(intentFilter, i, componentNameArr, componentName);
    }

    public void addPreferredActivityAsUser(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName, int i2) {
        this.mBase.addPreferredActivityAsUser(intentFilter, i, componentNameArr, componentName, i2);
    }

    @Deprecated
    public void replacePreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
        this.mBase.replacePreferredActivity(intentFilter, i, componentNameArr, componentName);
    }

    @Deprecated
    public void replacePreferredActivityAsUser(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName, int i2) {
        this.mBase.replacePreferredActivityAsUser(intentFilter, i, componentNameArr, componentName, i2);
    }

    public void clearPackagePreferredActivities(String str) {
        this.mBase.clearPackagePreferredActivities(str);
    }

    public int getPreferredActivities(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return this.mBase.getPreferredActivities(list, list2, str);
    }

    public ComponentName getHomeActivities(List<ResolveInfo> list) {
        return this.mBase.getHomeActivities(list);
    }

    public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
        this.mBase.setComponentEnabledSetting(componentName, i, i2);
    }

    public int getComponentEnabledSetting(ComponentName componentName) {
        return this.mBase.getComponentEnabledSetting(componentName);
    }

    public void setApplicationEnabledSetting(String str, int i, int i2) {
        this.mBase.setApplicationEnabledSetting(str, i, i2);
    }

    public int getApplicationEnabledSetting(String str) {
        return this.mBase.getApplicationEnabledSetting(str);
    }

    public void flushPackageRestrictionsAsUser(int i) {
        this.mBase.flushPackageRestrictionsAsUser(i);
    }

    public boolean setApplicationHiddenSettingAsUser(String str, boolean z, UserHandle userHandle) {
        return this.mBase.setApplicationHiddenSettingAsUser(str, z, userHandle);
    }

    public boolean getApplicationHiddenSettingAsUser(String str, UserHandle userHandle) {
        return this.mBase.getApplicationHiddenSettingAsUser(str, userHandle);
    }

    public boolean isSafeMode() {
        return this.mBase.isSafeMode();
    }

    public PackageInstaller getPackageInstaller() {
        return this.mBase.getPackageInstaller();
    }

    public void addOnPermissionsChangeListener(OnPermissionsChangedListener onPermissionsChangedListener) {
        this.mBase.addOnPermissionsChangeListener(onPermissionsChangedListener);
    }

    public void removeOnPermissionsChangeListener(OnPermissionsChangedListener onPermissionsChangedListener) {
        this.mBase.removeOnPermissionsChangeListener(onPermissionsChangedListener);
    }

    public KeySet getKeySetByAlias(String str, String str2) {
        return this.mBase.getKeySetByAlias(str, str2);
    }

    public KeySet getSigningKeySet(String str) {
        return this.mBase.getSigningKeySet(str);
    }

    public boolean isSignedBy(String str, KeySet keySet) {
        return this.mBase.isSignedBy(str, keySet);
    }

    public boolean isSignedByExactly(String str, KeySet keySet) {
        return this.mBase.isSignedByExactly(str, keySet);
    }

    public String[] setPackagesSuspendedAsUser(String[] strArr, boolean z, int i) {
        return this.mBase.setPackagesSuspendedAsUser(strArr, z, i);
    }

    public boolean isPackageSuspendedForUser(String str, int i) {
        return this.mBase.isPackageSuspendedForUser(str, i);
    }

    public int getMoveStatus(int i) {
        return this.mBase.getMoveStatus(i);
    }

    public void registerMoveCallback(MoveCallback moveCallback, Handler handler) {
        this.mBase.registerMoveCallback(moveCallback, handler);
    }

    public void unregisterMoveCallback(MoveCallback moveCallback) {
        this.mBase.unregisterMoveCallback(moveCallback);
    }

    public boolean isUpgrade() {
        return this.mBase.isUpgrade();
    }

    public void addCrossProfileIntentFilter(IntentFilter intentFilter, int i, int i2, int i3) {
        this.mBase.addCrossProfileIntentFilter(intentFilter, i, i2, i3);
    }

    public void clearCrossProfileIntentFilters(int i) {
        this.mBase.clearCrossProfileIntentFilters(i);
    }

    public Drawable loadItemIcon(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        return this.mBase.loadItemIcon(packageItemInfo, applicationInfo);
    }

    public Drawable loadUnbadgedItemIcon(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        return this.mBase.loadUnbadgedItemIcon(packageItemInfo, applicationInfo);
    }

    public boolean isPackageAvailable(String str) {
        return this.mBase.isPackageAvailable(str);
    }
}
