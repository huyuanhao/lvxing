package com.oasisfeng.condom;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.content.OperationApplicationException;
import android.content.UriPermission;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

class ContentResolverWrapper extends ContentResolver {
    private final ContentResolver mBase;

    public IContentProvider acquireProvider(Context context, String str) {
        return this.mBase.acquireProvider(context, str);
    }

    public IContentProvider acquireExistingProvider(Context context, String str) {
        return this.mBase.acquireExistingProvider(context, str);
    }

    public boolean releaseProvider(IContentProvider iContentProvider) {
        return this.mBase.releaseProvider(iContentProvider);
    }

    public IContentProvider acquireUnstableProvider(Context context, String str) {
        return this.mBase.acquireUnstableProvider(context, str);
    }

    public boolean releaseUnstableProvider(IContentProvider iContentProvider) {
        return this.mBase.releaseUnstableProvider(iContentProvider);
    }

    public void unstableProviderDied(IContentProvider iContentProvider) {
        this.mBase.unstableProviderDied(iContentProvider);
    }

    public String[] getStreamTypes(Uri uri, String str) {
        return this.mBase.getStreamTypes(uri, str);
    }

    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        return this.mBase.applyBatch(str, arrayList);
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver) {
        this.mBase.notifyChange(uri, contentObserver);
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver, boolean z) {
        this.mBase.notifyChange(uri, contentObserver, z);
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver, int i) {
        this.mBase.notifyChange(uri, contentObserver, i);
    }

    public void takePersistableUriPermission(Uri uri, int i) {
        this.mBase.takePersistableUriPermission(uri, i);
    }

    public void releasePersistableUriPermission(Uri uri, int i) {
        this.mBase.releasePersistableUriPermission(uri, i);
    }

    public List<UriPermission> getPersistedUriPermissions() {
        return this.mBase.getPersistedUriPermissions();
    }

    public List<UriPermission> getOutgoingPersistedUriPermissions() {
        return this.mBase.getOutgoingPersistedUriPermissions();
    }

    public void startSync(Uri uri, Bundle bundle) {
        this.mBase.startSync(uri, bundle);
    }

    public void cancelSync(Uri uri) {
        this.mBase.cancelSync(uri);
    }

    ContentResolverWrapper(Context context, ContentResolver contentResolver) {
        super(context);
        this.mBase = contentResolver;
    }
}
