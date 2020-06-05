package com.tencent.p605ep.common.adapt.iservice;

import android.content.Intent;

/* renamed from: com.tencent.ep.common.adapt.iservice.IMessageService */
public interface IMessageService {
    public static final String PKG_NAME = "pkgnm";

    /* renamed from: com.tencent.ep.common.adapt.iservice.IMessageService$IMessageReceiver */
    public interface IMessageReceiver {
        void onReceive(int i, Intent intent);
    }

    /* renamed from: com.tencent.ep.common.adapt.iservice.IMessageService$MsgID */
    public interface MsgID {
        public static final int MSG_AIRPLANEMODE_STATE_CHANGED = 29;
        public static final int MSG_BATTERY_CHANGED = 11;
        public static final int MSG_BLUETOOTH_ACTION_STATE_CHANGED = 28;
        public static final int MSG_CONNECT_SWITCH = 32;
        public static final int MSG_NETWORK_STATE_CHANGED = 31;
        public static final int MSG_PACKAGE_ADDED = 2;
        public static final int MSG_PACKAGE_CHANGED = 4;
        public static final int MSG_PACKAGE_REMOVED = 3;
        public static final int MSG_PACKAGE_REPLACED = 1;
        public static final int MSG_POWER_CONNECTED = 33;
        public static final int MSG_POWER_DISCONNECTED = 34;
        public static final int MSG_SCREEN_OFF = 8;
        public static final int MSG_SCREEN_ON = 7;
        public static final int MSG_SDCARD_EVENT = 9;
        public static final int MSG_SWITCH_IN_MY_APP = 23;
        public static final int MSG_SWITCH_OUT_MY_APP = 24;
        public static final int MSG_SYSTEM_INSTALL_RESULT = 35;
        public static final int MSG_SYSTEM_TIME_CHANGED = 6;
        public static final int MSG_USER_PRESENT = 20;
        public static final int MSG_WIFI_STATE_CHANGED_ACTION = 27;
    }

    void broadcastMsg(int i, Intent intent);

    void registerMsgReceiver(int i, IMessageReceiver iMessageReceiver);

    void unRegisterMsgReceiver(int i, IMessageReceiver iMessageReceiver);
}
