package com.tencent.android.tpush.common;

/* compiled from: ProGuard */
public class Constants {
    public static final String ACTION_BROADCAST_ACKNOWLEDGE_ACK = "com.tencent.android.tpush.action.BROADCAST_ACK";
    public static final String ACTION_FEEDBACK = "com.tencent.android.tpush.action.FEEDBACK";
    public static final String ACTION_INTERNAL_PUSH_MESSAGE = "com.tencent.android.tpush.action.INTERNAL_PUSH_MESSAGE";
    public static final String ACTION_KEEPALIVE = "com.tencent.android.tpush.action.keepalive";
    public static final String ACTION_PREFFIX = "com.tencent.android.tpush.action";
    public static final String ACTION_PUSH_MESSAGE = "com.tencent.android.tpush.action.PUSH_MESSAGE";
    public static final String ACTION_SDK_INSTALL = "com.tencent.android.tpush.action.SDK";
    public static final String ACTION_SDK_NOTIFICATION_CLEARED = "Notification.cleared";
    public static final String ACTION_SDK_TYPE = "type";
    public static final String ACTION_SLVAE_2_MAIN = "com.tencent.android.tpush.action.slave2main";
    public static final String ACTION_START_SLVAE = "com.tencent.android.tpush.action.start_slave";
    public static final String ACTION_STOP_CONNECT = "com.tencent.android.tpush.action.stop_connect";
    public static final String APP_PREF_NAME = "tpush.app.shareprefs";
    public static final String FEEDBACK_ERROR_CODE = "TPUSH.ERRORCODE";
    public static final int FEEDBACK_NOTIFACTION_CLICKED = 4;
    public static final int FEEDBACK_NOTIFACTION_SHOWED = 5;
    public static final int FEEDBACK_REGISTER = 1;
    public static final int FEEDBACK_SET_DELETE_TAG = 3;
    public static final String FEEDBACK_TAG = "TPUSH.FEEDBACK";
    public static final int FEEDBACK_UNREGISTER = 2;
    public static final String FLAG_ACCOUNT = "account";
    public static final String FLAG_ACC_ID = "accId";
    public static final String FLAG_ACTION_CONFIRM = "action_confirm";
    public static final String FLAG_ACTION_TYPE = "action_type";
    public static final String FLAG_ACTIVITY_NAME = "activity";
    public static final String FLAG_CLICK_DELETE_ACTION = "action";
    public static final String FLAG_CLICK_TIME = "clickTime";
    public static final String FLAG_DEVICE_ID = "deviceId";
    public static final String FLAG_NOTIFICATION_ACTION_TYPE = "notificationActionType";
    public static final String FLAG_PACKAGE_DOWNLOAD_URL = "packageDownloadUrl";
    public static final String FLAG_PACKAGE_NAME = "packageName";
    public static final String FLAG_PACK_NAME = "packName";
    public static final String FLAG_REGISTER_FROM_CLOUDCTRL = "registerFromCloudControl";
    public static final String FLAG_TAG_NAME = "tagName";
    public static final String FLAG_TAG_OPER_NAME = "tagOperageName";
    public static final String FLAG_TAG_TYPE = "tagFlag";
    public static final String FLAG_TICKET = "ticket";
    public static final String FLAG_TICKET_TYPE = "ticketType";
    public static final String FLAG_TOKEN = "token";
    public static final String HorseLogTag = "XGHorse";
    public static final String IS_CACHE_CLEAR = "isClearCache.com.tencent.tpush.cache.redirect";
    public static final String IS_CLEAR_CACHE = "memeda3";
    public static final String LOCAL_MESSAGE_FLAG = "tpush.local.msg.";
    public static final String LOC_REPORT_TIME = "M_LAST_REPORT_LOC_TIME";
    public static final String LogTag = "TPush";
    public static final String MAIN_VERSION_TAG = "";
    public static final String META_STR_FOREIGIN_XG_WEAK_ALARM = "XG_WEAK_ALARM";
    public static final String MSDK_TAG = "XG_MSDK";
    public static final String MSG_CUSTOM_CONTENT = "custom_content";
    public static final String MTA_MSG_ARRIVE = "MTA_PUSH_R";
    public static final String MTA_MSG_OPEN = "MTA_PUSH_O";
    public static final String MTA_MSG_OPEN_TIME = "MTA_PUSH_T";
    public static final String NETWORK_RESTAT_DELAY_TIME = "delay_time";
    public static final String OTHER_PUSH_TAG = "XGOtherPush";
    public static final String OTHER_PUSH_TOKEN = "other_push_token";
    public static final String PARAM_NEED_CACHE = "needhttpcache";
    public static final short PROTOCOL_HTTP = 1;
    public static final short PROTOCOL_NONE = -1;
    public static final short PROTOCOL_TCP = 0;
    public static final String PRO_LOG_TAG = "XGPro";
    public static final String PUSH_CHANNEL = "PUSH.CHANNEL";
    public static final float PUSH_SDK_VERSION = 4.03f;
    public static final String PushMessageLogTag = "XGPushMessage";
    public static final short REDIRECTED_NO = 0;
    public static final short REDIRECTED_YES = 1;
    public static final int REGISTER_FAIL = 3;
    public static final int REGISTER_INIT = 0;
    public static final int REGISTER_IN_PROGRESS = 1;
    public static final int REGISTER_OK = 2;
    public static final String REPORT_LOG_TAG = "ReportLogTag";
    public static final String RPC_SUFFIX = ".PUSH_ACTION";
    public static final String SETTINGS_ENABLE_APPLIST = "com.tencent.android.tpush.enable_applist";
    public static final String SETTINGS_ENABLE_DEBUG_NAME = "com.tencent.android.tpush.debug";
    public static final String SETTINGS_ENABLE_FCM = "com.tencent.android.tpush.fcm";
    public static final String SETTINGS_ENABLE_FOREIGINPUSH = "com.tencent.android.tpush.enable_FOREIGINPUSH";
    public static final String SETTINGS_ENABLE_FOREIGIN_XG_WEAK_ALARM = "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM";
    public static final String SETTINGS_ENABLE_LOCATION = "com.tencent.android.tpush.enable_location";
    public static final String SETTINGS_ENABLE_NOTIFICATION = "com.tencent.android.tpush.enable_NOTIICATION";
    public static final String SETTINGS_ENABLE_OTHER_PUSH = "com.tencent.android.tpush.other.push";
    public static final String SETTINGS_ENABLE_SHOW_NOTIFICATION = "com.tencent.android.tpush.enable_SHOW_NOTIFICATION";
    public static final String SETTINGS_SERVICE_PACKAGE_NAME = "tpush.running.service.name";
    public static final String SETTINGS_SOCKET_NAME = "com.tencent.android.tpush.socket.name";
    public static final String SETTINGS_UNREGISTER_INFO_NAME = "tpush.unrge.info";
    public static final String SHARED_PREFS_KEY_REGISTER = "reg";
    public static final String SHARED_PREFS_NAME = ".tpush.local.setting.private";
    public static final String ServiceLogTag = "XGService";
    public static final String TAG_TPUSH_MESSAGE = "tag.tpush.MSG";
    public static final String TAG_TPUSH_NOTIFICATION = "tag.tpush.NOTIFIC";
    public static final int TYPE_ADD_TAGS = 5;
    public static final int TYPE_CLEAN_TAGS = 8;
    public static final int TYPE_DELETE_KEY_VALUE_TAG = 4;
    public static final int TYPE_DELETE_TAG = 2;
    public static final int TYPE_DELETE_TAGS = 7;
    public static final int TYPE_SET_KEY_VALUE_TAG = 3;
    public static final int TYPE_SET_TAG = 1;
    public static final int TYPE_SET_TAGS = 6;
    public static final String TcpRecvPackLogTag = "XGTcpRecvPacks";
    public static final String TcpSendPackLogTag = "XGTcpSendPacks";
    public static final int UNREGISTER_FAIL = 7;
    public static final int UNREGISTER_INIT = 4;
    public static final int UNREGISTER_IN_PROGRESS = 5;
    public static final int UNREGISTER_OK = 6;
    public static final String UNSTALL_DOMAIN = "pingma.qq.com";
    public static final String UNSTALL_PORT = "80";
    public static final String UNSTALL_URL = "/mstat/report";
    public static final String VIVO_STR = "vivo X6";
    public static final int XG_SERVICE_CONN_COMPATIBLE_VERSION = 4;
}