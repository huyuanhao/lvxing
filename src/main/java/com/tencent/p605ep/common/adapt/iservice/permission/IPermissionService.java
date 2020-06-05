package com.tencent.p605ep.common.adapt.iservice.permission;

/* renamed from: com.tencent.ep.common.adapt.iservice.permission.IPermissionService */
public interface IPermissionService {

    /* renamed from: com.tencent.ep.common.adapt.iservice.permission.IPermissionService$RequestPermissionsCallback */
    public interface RequestPermissionsCallback {
        void onCallback(int[] iArr, int[] iArr2);
    }

    int checkPermission(int i);

    int[] checkPermissions(int[] iArr);

    void requestPermissionsDefault(int[] iArr, RequestPermissionsCallback requestPermissionsCallback);
}
