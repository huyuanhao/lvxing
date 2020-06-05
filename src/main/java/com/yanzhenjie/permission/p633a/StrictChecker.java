package com.yanzhenjie.permission.p633a;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mid.core.Constants;

/* renamed from: com.yanzhenjie.permission.a.v */
public final class StrictChecker implements PermissionChecker {
    /* renamed from: a */
    public boolean mo38009a(Context context, String... strArr) {
        if (VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : strArr) {
            if (!m33975a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m33975a(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals("android.permission.READ_SMS")) {
                        c = 20;
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
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1479758289:
                    if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals("android.permission.BODY_SENSORS")) {
                        c = 16;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals("android.permission.RECEIVE_MMS")) {
                        c = 19;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals("android.permission.RECEIVE_SMS")) {
                        c = 22;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 23;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 6;
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
                        c = 18;
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
                        c = 4;
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
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals("android.permission.USE_SIP")) {
                        c = 14;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals("android.permission.GET_ACCOUNTS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals(Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                        c = 24;
                        break;
                    }
                    break;
                case 1780337063:
                    if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
                        c = 17;
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
                        c = 3;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                        c = 13;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return m33974a(context);
                case 1:
                    return m33977b(context);
                case 2:
                    return m33978c(context);
                case 3:
                    return m33979d(context);
                case 4:
                    return m33980e(context);
                case 5:
                    return true;
                case 6:
                    return m33981f(context);
                case 7:
                    return m33982g(context);
                case 8:
                    return m33983h(context);
                case 9:
                    return m33984i(context);
                case 10:
                    return true;
                case 11:
                    return m33985j(context);
                case 12:
                    return m33986k(context);
                case 13:
                    return true;
                case 14:
                    return m33987l(context);
                case 15:
                    return true;
                case 16:
                    return m33988m(context);
                case 17:
                    return m33989n(context);
                case 18:
                case 19:
                    return true;
                case 20:
                    return m33990o(context);
                case 21:
                case 22:
                    return true;
                case 23:
                    return m33973a();
                case 24:
                    return m33976b();
                default:
                    return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m33974a(Context context) throws Throwable {
        return new CalendarReadTest(context).mo38007a();
    }

    /* renamed from: b */
    private static boolean m33977b(Context context) throws Throwable {
        return new CalendarWriteTest(context).mo38007a();
    }

    /* renamed from: c */
    private static boolean m33978c(Context context) throws Throwable {
        return new CameraTest(context).mo38007a();
    }

    /* renamed from: d */
    private static boolean m33979d(Context context) throws Throwable {
        return new ContactsReadTest(context).mo38007a();
    }

    /* renamed from: e */
    private static boolean m33980e(Context context) throws Throwable {
        return new ContactsWriteTest(context.getContentResolver()).mo38007a();
    }

    /* renamed from: f */
    private static boolean m33981f(Context context) throws Throwable {
        return new LocationCoarseTest(context).mo38007a();
    }

    /* renamed from: g */
    private static boolean m33982g(Context context) throws Throwable {
        return new LocationFineTest(context).mo38007a();
    }

    /* renamed from: h */
    private static boolean m33983h(Context context) throws Throwable {
        return new RecordAudioTest(context).mo38007a();
    }

    /* renamed from: i */
    private static boolean m33984i(Context context) throws Throwable {
        return new PhoneStateReadTest(context).mo38007a();
    }

    /* renamed from: j */
    private static boolean m33985j(Context context) throws Throwable {
        return new CallLogReadTest(context).mo38007a();
    }

    /* renamed from: k */
    private static boolean m33986k(Context context) throws Throwable {
        return new CallLogWriteTest(context).mo38007a();
    }

    /* renamed from: l */
    private static boolean m33987l(Context context) throws Throwable {
        return new SipTest(context).mo38007a();
    }

    /* renamed from: m */
    private static boolean m33988m(Context context) throws Throwable {
        return new SensorHeartTest(context).mo38007a();
    }

    /* renamed from: n */
    private static boolean m33989n(Context context) throws Throwable {
        return new SensorActivityTest(context).mo38007a();
    }

    /* renamed from: o */
    private static boolean m33990o(Context context) throws Throwable {
        return new SmsReadTest(context).mo38007a();
    }

    /* renamed from: a */
    private static boolean m33973a() throws Throwable {
        return new StorageReadTest().mo38007a();
    }

    /* renamed from: b */
    private static boolean m33976b() throws Throwable {
        return new StorageWriteTest().mo38007a();
    }
}
