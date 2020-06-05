package p005cn.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.view.WindowManager;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: cn.bingoogolapple.qrcode.core.b */
final class CameraConfigurationManager {
    /* renamed from: a */
    private static final Pattern f1191a = Pattern.compile(StorageInterface.KEY_SPLITER);
    /* renamed from: b */
    private final Context f1192b;
    /* renamed from: c */
    private Point f1193c;
    /* renamed from: d */
    private Point f1194d;

    CameraConfigurationManager(Context context) {
        this.f1192b = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9718a(Camera camera) {
        Parameters parameters = camera.getParameters();
        if (m1043c(camera)) {
            parameters.setFocusMode("auto");
        }
        Point b = BGAQRCodeUtil.m1033b(this.f1192b);
        Point point = new Point();
        point.x = b.x;
        point.y = b.y;
        if (BGAQRCodeUtil.m1030a(this.f1192b)) {
            point.x = b.y;
            point.y = b.x;
        }
        this.f1194d = m1038a(parameters, point);
        if (BGAQRCodeUtil.m1030a(this.f1192b)) {
            this.f1193c = new Point(this.f1194d.y, this.f1194d.x);
        } else {
            this.f1193c = this.f1194d;
        }
    }

    /* renamed from: c */
    private static boolean m1043c(Camera camera) {
        return m1040a((Collection<String>) camera.getParameters().getSupportedFocusModes(), "auto") != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Point mo9717a() {
        return this.f1193c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo9719b(Camera camera) {
        Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.f1194d.x, this.f1194d.y);
        m1041a(parameters);
        camera.setDisplayOrientation(m1042b());
        camera.setParameters(parameters);
    }

    /* renamed from: a */
    private static String m1040a(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private int m1042b() {
        int i;
        CameraInfo cameraInfo = new CameraInfo();
        int i2 = 0;
        Camera.getCameraInfo(0, cameraInfo);
        WindowManager windowManager = (WindowManager) this.f1192b.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        return i;
    }

    /* renamed from: a */
    private static Point m1038a(Parameters parameters, Point point) {
        Point a = m1039a(parameters.getSupportedPreviewSizes(), point);
        return a == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : a;
    }

    /* renamed from: a */
    private static Point m1039a(List<Size> list, Point point) {
        Iterator it = list.iterator();
        int i = 0;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Size size = (Size) it.next();
            int i4 = size.width;
            int i5 = size.height;
            int abs = Math.abs(i4 - point.x) + Math.abs(i5 - point.y);
            if (abs == 0) {
                i3 = i5;
                i = i4;
                break;
            } else if (abs < i2) {
                i3 = i5;
                i = i4;
                i2 = abs;
            }
        }
        if (i <= 0 || i3 <= 0) {
            return null;
        }
        return new Point(i, i3);
    }

    /* renamed from: a */
    private static int m1037a(CharSequence charSequence, int i) {
        String[] split = f1191a.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(((double) i) - parseDouble) < ((double) Math.abs(i - i3))) {
                    i3 = i4;
                }
                i2++;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private void m1041a(Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = m1037a((CharSequence) str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!(str2 == null && str4 == null)) {
                parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }
}
