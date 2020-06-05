package com.tencent.mid.core;

public class Constants {
    public static final String CONFIG_PATCH_PATH = "patch/mid_core.zip";
    public static final String CONFIG_PATCH_PATH_BAK = "mid_core.zip.bak";
    public static long DAY_TIMESTAMPS = 86400000;
    public static final String HTTP_SERVICE = "pingmid.qq.com:80";
    public static final String INFO_URL = "/update_info";
    public static final String LOG_TAG = "MID";
    public static final String PERMISSION_ACCESS_NETWORK_STATE = "android.permission.ACCESS_NETWORK_STATE";
    public static final String PERMISSION_ACCESS_WIFI_STATE = "android.permission.ACCESS_WIFI_STATE";
    public static final String PERMISSION_INTERNET = "android.permission.INTERNET";
    public static final String PERMISSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String PERMISSION_WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";
    public static final String PSW_URL = "/post_password";
    public static final String REQUEST_MID_NEW_URL = "/request_new";
    public static final String REQUEST_MID_URL = "/request";
    public static final int RSA_KEY_VERSION = 2;
    public static final String RSA_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5zQz+I9s/DqreFr8dkd6wSdYDngK9T36rtlDPM6VJHjWQHv6FK83xbDoX6hgcZMPYIIawcwRCVPZNetRlsAnztAt7b71z9NvPaF24+fhHe8Sy3Z/Z2JxvGXsjDnejZzdiuHTS+FGUSjcX+CzyqB30yX0AV+LgxXtQe9aRpT5yo5W6jc2UpEhBYCjpGlmW1mksAwWbyvWSEUTkUD7n9uP7C8eFEh5DHnaTwzxAQtzSxQVC1ZopnC3ly/LhMRl8GFXsFlRzg4VTkSdwS/amyWtkKjfHXp7qh4ySBqY9HEGaoZIHrXGv3VtpXoTgGraj+5HPArW0wqQroUOYVx48xRs6QIDAQAB";
    public static final String VERIFY_MID_URL = "/verify";

    /* renamed from: com.tencent.mid.core.Constants$CMD */
    public interface CMD {
        public static final int GET_MID = 1;
        public static final int SYN_MID = 2;
    }

    /* renamed from: com.tencent.mid.core.Constants$ERROR */
    public interface ERROR {
        public static final String CMD_FORMAT_ERROR = "-1";
        public static final String CMD_NO_CMD = "-2";
    }
}
