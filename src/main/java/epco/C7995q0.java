package epco;

import androidx.core.app.NotificationCompat;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.util.ArrayList;

/* renamed from: epco.q0 */
public class C7995q0 {
    /* renamed from: a */
    public static String m34588a(int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        if ((i & 4096) != 0) {
            str = "density";
        } else if ((1073741824 & i) != 0) {
            str = "fontScale";
        } else if ((i & 16) != 0) {
            str = "keyboard";
        } else if ((i & 32) != 0) {
            str = "keyboardHidden";
        } else if ((i & 8192) != 0) {
            str = "direction";
        } else if ((i & 4) != 0) {
            str = "locale";
        } else if ((i & 1) != 0) {
            str = "mcc";
        } else if ((i & 2) != 0) {
            str = "mnc";
        } else if ((i & 64) != 0) {
            str = NotificationCompat.CATEGORY_NAVIGATION;
        } else if ((i & 128) != 0) {
            str = "orientation";
        } else if ((i & 256) != 0) {
            str = "screenLayout";
        } else if ((i & 1024) != 0) {
            str = "screenSize";
        } else if ((i & 2048) != 0) {
            str = "smallestScreenSize";
        } else if ((i & 8) != 0) {
            str = "touchscreen";
        } else {
            if ((i & 512) != 0) {
                str = "uiMode";
            }
            return C8007w0.m34695a((Iterable<?>) arrayList, "|");
        }
        arrayList.add(str);
        return C8007w0.m34695a((Iterable<?>) arrayList, "|");
    }

    /* renamed from: b */
    public static String m34589b(int i) {
        if (i == 0) {
            return "auto";
        }
        if (i == 1) {
            return "internalOnly";
        }
        if (i == 2) {
            return "preferExternal";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("installLocation:");
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    /* renamed from: c */
    public static String m34590c(int i) {
        if (i == 0) {
            return "standard";
        }
        if (i == 1) {
            return "singleTop";
        }
        if (i == 2) {
            return "singleTask";
        }
        if (i == 3) {
            return "singleInstance";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("LaunchMode:");
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    /* renamed from: d */
    public static String m34591d(int i) {
        String str;
        ArrayList arrayList = new ArrayList(3);
        if ((i & 16) != 0) {
            i ^= 16;
            arrayList.add("system");
        }
        if ((i & 32) != 0) {
            i ^= 32;
            arrayList.add("development");
        }
        if (i == 0) {
            str = "normal";
        } else if (i == 1) {
            str = "dangerous";
        } else if (i == 2) {
            str = "signature";
        } else if (i != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("ProtectionLevel:");
            sb.append(Integer.toHexString(i));
            str = sb.toString();
        } else {
            str = "signatureOrSystem";
        }
        arrayList.add(str);
        return C8007w0.m34695a((Iterable<?>) arrayList, "|");
    }

    /* renamed from: e */
    public static String m34592e(int i) {
        switch (i) {
            case -1:
                return "unspecified";
            case 0:
                return "landscape";
            case 1:
                return "portrait";
            case 2:
                return "user";
            case 3:
                return "behind";
            case 4:
                return "sensor";
            case 5:
                return "nosensor";
            case 6:
                return "sensorLandscape";
            case 7:
                return "sensorPortrait";
            case 8:
                return "reverseLandscape";
            case 9:
                return "reversePortrait";
            case 10:
                return "fullSensor";
            case 11:
                return "userLandscape";
            case 12:
                return "userPortrait";
            case 13:
                return "fullUser";
            case 14:
                return "locked";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("ScreenOrientation:");
                sb.append(Integer.toHexString(i));
                return sb.toString();
        }
    }

    /* renamed from: f */
    public static String m34593f(int i) {
        String str;
        String str2;
        int i2 = i & ScreenUtil.G8_WIDTH;
        int i3 = i & 15;
        ArrayList arrayList = new ArrayList(2);
        if (i2 != 0) {
            if (i2 == 16) {
                str2 = "adjustResize";
            } else if (i2 == 32) {
                str2 = "adjustPan";
            } else if (i2 != 48) {
                StringBuilder sb = new StringBuilder();
                sb.append("WindowInputModeAdjust:");
                sb.append(Integer.toHexString(i2));
                str2 = sb.toString();
            } else {
                str2 = "adjustNothing";
            }
            arrayList.add(str2);
        }
        if (i3 != 0) {
            if (i3 == 1) {
                str = "stateUnchanged";
            } else if (i3 == 2) {
                str = "stateHidden";
            } else if (i3 == 3) {
                str = "stateAlwaysHidden";
            } else if (i3 == 4) {
                str = "stateVisible";
            } else if (i3 != 5) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WindowInputModeState:");
                sb2.append(Integer.toHexString(i3));
                str = sb2.toString();
            } else {
                str = "stateAlwaysVisible";
            }
            arrayList.add(str);
        }
        return C8007w0.m34695a((Iterable<?>) arrayList, "|");
    }
}
