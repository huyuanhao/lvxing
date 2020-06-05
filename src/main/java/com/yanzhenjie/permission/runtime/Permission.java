package com.yanzhenjie.permission.runtime;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mid.core.Constants;
import com.yanzhenjie.permission.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.runtime.f */
public class Permission {

    /* compiled from: Permission */
    /* renamed from: com.yanzhenjie.permission.runtime.f$a */
    public static final class C7844a {
        /* renamed from: a */
        public static final String[] f26682a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        /* renamed from: b */
        public static final String[] f26683b = {"android.permission.CAMERA"};
        /* renamed from: c */
        public static final String[] f26684c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
        /* renamed from: d */
        public static final String[] f26685d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        /* renamed from: e */
        public static final String[] f26686e = {"android.permission.RECORD_AUDIO"};
        /* renamed from: f */
        public static final String[] f26687f = {Constants.PERMISSION_READ_PHONE_STATE, "android.permission.CALL_PHONE", "android.permission.USE_SIP", "android.permission.READ_PHONE_NUMBERS", "android.permission.ANSWER_PHONE_CALLS", "com.android.voicemail.permission.ADD_VOICEMAIL"};
        /* renamed from: g */
        public static final String[] f26688g = {"android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "android.permission.PROCESS_OUTGOING_CALLS"};
        /* renamed from: h */
        public static final String[] f26689h = {"android.permission.BODY_SENSORS"};
        /* renamed from: i */
        public static final String[] f26690i = {"android.permission.ACTIVITY_RECOGNITION"};
        /* renamed from: j */
        public static final String[] f26691j = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
        /* renamed from: k */
        public static final String[] f26692k = {"android.permission.READ_EXTERNAL_STORAGE", Constants.PERMISSION_WRITE_EXTERNAL_STORAGE};
    }

    /* renamed from: a */
    public static List<String> m34115a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            char c = 65535;
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals("android.permission.READ_SMS")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1928411001:
                    if (str.equals("android.permission.READ_CALENDAR")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (str.equals("android.permission.READ_CALL_LOG")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1674700861:
                    if (str.equals("android.permission.ANSWER_PHONE_CALLS")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1479758289:
                    if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals("android.permission.BODY_SENSORS")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1164582768:
                    if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
                        c = 13;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals("android.permission.RECEIVE_MMS")) {
                        c = 24;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals("android.permission.RECEIVE_SMS")) {
                        c = 21;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 25;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 7;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals(Constants.PERMISSION_READ_PHONE_STATE)) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (str.equals("android.permission.SEND_SMS")) {
                        c = 20;
                        break;
                    }
                    break;
                case 112197485:
                    if (str.equals("android.permission.CALL_PHONE")) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (str.equals("android.permission.WRITE_CONTACTS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (str.equals("android.permission.WRITE_CALENDAR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (str.equals("android.permission.WRITE_CALL_LOG")) {
                        c = 16;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals("android.permission.USE_SIP")) {
                        c = 12;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals("android.permission.GET_ACCOUNTS")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                        c = 26;
                        break;
                    }
                    break;
                case 1780337063:
                    if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals("android.permission.READ_CONTACTS")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    String string = context.getString(R.string.permission_name_calendar);
                    if (arrayList.contains(string)) {
                        break;
                    } else {
                        arrayList.add(string);
                        break;
                    }
                case 2:
                    String string2 = context.getString(R.string.permission_name_camera);
                    if (arrayList.contains(string2)) {
                        break;
                    } else {
                        arrayList.add(string2);
                        break;
                    }
                case 3:
                case 4:
                case 5:
                    String string3 = context.getString(R.string.permission_name_contacts);
                    if (arrayList.contains(string3)) {
                        break;
                    } else {
                        arrayList.add(string3);
                        break;
                    }
                case 6:
                case 7:
                    String string4 = context.getString(R.string.permission_name_location);
                    if (arrayList.contains(string4)) {
                        break;
                    } else {
                        arrayList.add(string4);
                        break;
                    }
                case 8:
                    String string5 = context.getString(R.string.permission_name_microphone);
                    if (arrayList.contains(string5)) {
                        break;
                    } else {
                        arrayList.add(string5);
                        break;
                    }
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    String string6 = context.getString(R.string.permission_name_phone);
                    if (arrayList.contains(string6)) {
                        break;
                    } else {
                        arrayList.add(string6);
                        break;
                    }
                case 15:
                case 16:
                case 17:
                    String string7 = context.getString(VERSION.SDK_INT >= 29 ? R.string.permission_name_call_log : R.string.permission_name_phone);
                    if (arrayList.contains(string7)) {
                        break;
                    } else {
                        arrayList.add(string7);
                        break;
                    }
                case 18:
                    String string8 = context.getString(R.string.permission_name_sensors);
                    if (arrayList.contains(string8)) {
                        break;
                    } else {
                        arrayList.add(string8);
                        break;
                    }
                case 19:
                    String string9 = context.getString(R.string.permission_name_activity_recognition);
                    if (arrayList.contains(string9)) {
                        break;
                    } else {
                        arrayList.add(string9);
                        break;
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    String string10 = context.getString(R.string.permission_name_sms);
                    if (arrayList.contains(string10)) {
                        break;
                    } else {
                        arrayList.add(string10);
                        break;
                    }
                case 25:
                case 26:
                    String string11 = context.getString(R.string.permission_name_storage);
                    if (arrayList.contains(string11)) {
                        break;
                    } else {
                        arrayList.add(string11);
                        break;
                    }
            }
        }
        return arrayList;
    }
}
