package tech.linjiang.android.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class Drawables {
    /* renamed from: a */
    private static final int[] f29576a = new int[4];

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: tech.linjiang.android.drawable.Drawables$GradientType */
    public @interface GradientType {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
        public static final int SWEEP = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: tech.linjiang.android.drawable.Drawables$Orientation */
    public @interface Orientation {
        public static final int BL_TR = 5;
        public static final int BOTTOM_TOP = 4;
        public static final int BR_TL = 3;
        public static final int LEFT_RIGHT = 6;
        public static final int RIGHT_LEFT = 2;
        public static final int TL_BR = 7;
        public static final int TOP_BOTTOM = 0;
        public static final int TR_BL = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: tech.linjiang.android.drawable.Drawables$ShapeMode */
    public @interface ShapeMode {
        public static final int LINE = 2;
        public static final int OVAL = 1;
        public static final int RECTANGLE = 0;
        public static final int RING = 3;
    }

    /* renamed from: a */
    private static int m37720a(int i) {
        if (i > 3 || i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: a */
    public static void m37723a(View view, int i, Integer num, int i2, Integer num2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Integer num3, Integer num4, Integer num5, int i3, int i4, Float f8, Float f9, float f10, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Float f11, Integer num13, Float f12, int i5, Integer num14, int i6, Integer num15, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Integer num16, Integer num17, Integer num18, int i7, int i8, Float f20, Float f21, float f22, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Float f23, Integer num26, Float f24, int i9, Integer num27, int i10, Integer num28, float f25, float f26, float f27, float f28, float f29, float f30, float f31, Integer num29, Integer num30, Integer num31, int i11, int i12, Float f32, Float f33, float f34, Integer num32, Integer num33, Integer num34, Integer num35, Integer num36, Integer num37, Integer num38, Float f35, Integer num39, Float f36, int i13, Integer num40, int i14, Integer num41, float f37, float f38, float f39, float f40, float f41, float f42, float f43, Integer num42, Integer num43, Integer num44, int i15, int i16, Float f44, Float f45, float f46, Integer num45, Integer num46, Integer num47, Integer num48, Integer num49, Integer num50, Integer num51, Float f47, Integer num52, Float f48, int i17, Integer num53, int i18, Integer num54, float f49, float f50, float f51, float f52, float f53, float f54, float f55, Integer num55, Integer num56, Integer num57, int i19, int i20, Float f56, Float f57, float f58, Integer num58, Integer num59, Integer num60, Integer num61, Integer num62, Integer num63, Integer num64, Float f59, Integer num65, Float f60, int i21, Integer num66, int i22, Integer num67, float f61, float f62, float f63, float f64, float f65, float f66, float f67, Integer num68, Integer num69, Integer num70, int i23, int i24, Float f68, Float f69, float f70, Integer num71, Integer num72, Integer num73, Integer num74, Integer num75, Integer num76, Integer num77, Float f71, Integer num78, Float f72, int i25, Integer num79, int i26, Integer num80, float f73, float f74, float f75, float f76, float f77, float f78, float f79, Integer num81, Integer num82, Integer num83, int i27, int i28, Float f80, Float f81, float f82, Integer num84, Integer num85, Integer num86, Integer num87, Integer num88, Integer num89, Integer num90, Float f83, Integer num91, Float f84, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6, Drawable drawable7) {
        boolean z;
        int i29;
        boolean z2;
        View view2 = view;
        Drawable a = drawable != null ? drawable : m37721a(i, num, i2, num2, f, f2, f3, f4, f5, f6, f7, num3, num4, num5, i3, i4, f8, f9, f10, num6, num7, num8, num9, num10, num11, num12, f11, num13, f12);
        if (a != null) {
            i29 = 1;
            z = false;
        } else {
            i29 = 0;
            z = true;
        }
        Drawable a2 = drawable2 != null ? drawable2 : m37721a(i5, num14, i6, num15, f13, f14, f15, f16, f17, f18, f19, num16, num17, num18, i7, i8, f20, f21, f22, num19, num20, num21, num22, num23, num24, num25, f23, num26, f24);
        if (a2 != null) {
            i29++;
        }
        Drawable a3 = drawable3 != null ? drawable3 : m37721a(i9, num27, i10, num28, f25, f26, f27, f28, f29, f30, f31, num29, num30, num31, i11, i12, f32, f33, f34, num32, num33, num34, num35, num36, num37, num38, f35, num39, f36);
        if (a3 != null) {
            i29++;
        }
        Drawable a4 = drawable4 != null ? drawable4 : m37721a(i13, num40, i14, num41, f37, f38, f39, f40, f41, f42, f43, num42, num43, num44, i15, i16, f44, f45, f46, num45, num46, num47, num48, num49, num50, num51, f47, num52, f48);
        if (a4 != null) {
            i29++;
        }
        Drawable a5 = drawable5 != null ? drawable5 : m37721a(i17, num53, i18, num54, f49, f50, f51, f52, f53, f54, f55, num55, num56, num57, i19, i20, f56, f57, f58, num58, num59, num60, num61, num62, num63, num64, f59, num65, f60);
        if (a5 != null) {
            i29++;
        }
        Drawable a6 = drawable6 != null ? drawable6 : m37721a(i21, num66, i22, num67, f61, f62, f63, f64, f65, f66, f67, num68, num69, num70, i23, i24, f68, f69, f70, num71, num72, num73, num74, num75, num76, num77, f71, num78, f72);
        if (a6 != null) {
            i29++;
        }
        Drawable a7 = drawable7 != null ? drawable7 : m37721a(i25, num79, i26, num80, f73, f74, f75, f76, f77, f78, f79, num81, num82, num83, i27, i28, f80, f81, f82, num84, num85, num86, num87, num88, num89, num90, f83, num91, f84);
        if (a7 != null) {
            i29++;
        }
        if (i29 >= 1) {
            if (z || i29 == 1) {
                f29576a[0] = view.getPaddingLeft();
                f29576a[1] = view.getPaddingTop();
                f29576a[2] = view.getPaddingRight();
                f29576a[3] = view.getPaddingBottom();
                z2 = true;
            } else {
                z2 = false;
            }
            if (i29 != 1 || z) {
                ProxyDrawable aVar = new ProxyDrawable();
                if (a2 != null) {
                    aVar.addState(new int[]{16842912}, a2);
                }
                if (a3 != null) {
                    aVar.addState(new int[]{16842911}, a3);
                }
                if (a4 != null) {
                    aVar.addState(new int[]{16842910}, a4);
                }
                if (a5 != null) {
                    aVar.addState(new int[]{16842908}, a5);
                }
                if (a6 != null) {
                    aVar.addState(new int[]{16842919}, a6);
                }
                if (a7 != null) {
                    aVar.addState(new int[]{16842913}, a7);
                }
                if (a != null) {
                    aVar.addState(new int[]{0}, a);
                } else {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        if (background instanceof ProxyDrawable) {
                            background = ((ProxyDrawable) background).mo41501a();
                        }
                        aVar.addState(new int[]{0}, background);
                    }
                }
                view2.setBackground(aVar);
            } else {
                view2.setBackground(a);
            }
            if (z2) {
                int[] iArr = f29576a;
                view2.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
        }
    }

    /* renamed from: a */
    public static Drawable m37721a(int i, Integer num, int i2, Integer num2, float f, float f2, float f3, float f4, float f5, float f6, float f7, Integer num3, Integer num4, Integer num5, int i3, int i4, Float f8, Float f9, float f10, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Float f11, Integer num13, Float f12) {
        int i5;
        int i6;
        int i7;
        int i8;
        float f13;
        int i9 = i;
        int i10 = i2;
        int i11 = i4;
        if (i9 == 0 && num == null && i10 == 0 && num2 == null && f == 0.0f && f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f5 == 0.0f && f6 == 0.0f && f7 == 0.0f && num3 == null && num4 == null && num5 == null && i3 == 0 && i11 == 0 && f8 == null && f9 == null && f10 == 0.0f && num6 == null && num7 == null && num8 == null && num9 == null && num10 == null && num11 == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (num3 != null && num5 != null) {
            gradientDrawable.setColors(num4 != null ? new int[]{num3.intValue(), num4.intValue(), num5.intValue()} : new int[]{num3.intValue(), num5.intValue()});
            gradientDrawable.setOrientation(m37724b(i3));
            gradientDrawable.setGradientType(i11);
            if (i11 == 1) {
                float f14 = 0.5f;
                if (f8 == null) {
                    f13 = 0.5f;
                } else {
                    f13 = f8.floatValue();
                }
                if (f9 != null) {
                    f14 = f9.floatValue();
                }
                gradientDrawable.setGradientCenter(f13, f14);
                gradientDrawable.setGradientRadius((float) m37719a(f10));
            }
        } else if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        gradientDrawable.setShape(m37720a(i));
        if (i9 == 3) {
            m37722a(gradientDrawable, num12, f11, num13, f12);
        }
        if (num2 != null && num2.intValue() >= 0) {
            gradientDrawable.setStroke(m37719a((float) num2.intValue()), i2, (float) m37719a(f), (float) m37719a(f2));
        }
        if (f3 <= 0.0f) {
            gradientDrawable.setCornerRadii(new float[]{(float) m37719a(f4), (float) m37719a(f4), (float) m37719a(f6), (float) m37719a(f6), (float) m37719a(f7), (float) m37719a(f7), (float) m37719a(f5), (float) m37719a(f5)});
        } else {
            gradientDrawable.setCornerRadius((float) m37719a(f3));
        }
        if (!(num6 == null || num7 == null)) {
            gradientDrawable.setSize(m37719a((float) num6.intValue()), m37719a((float) num7.intValue()));
        }
        if (num8 == null && num9 == null && num10 == null && num11 == null) {
            return gradientDrawable;
        }
        if (num8 == null) {
            i5 = 0;
        } else {
            i5 = m37719a((float) num8.intValue());
        }
        if (num9 == null) {
            i6 = 0;
        } else {
            i6 = m37719a((float) num9.intValue());
        }
        if (num10 == null) {
            i7 = 0;
        } else {
            i7 = m37719a((float) num10.intValue());
        }
        if (num11 == null) {
            i8 = 0;
        } else {
            i8 = m37719a((float) num11.intValue());
        }
        InsetDrawable insetDrawable = new InsetDrawable(gradientDrawable, i5, i6, i7, i8);
        return insetDrawable;
    }

    /* renamed from: b */
    private static android.graphics.drawable.GradientDrawable.Orientation m37724b(int i) {
        switch (i) {
            case 0:
                return android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM;
            case 1:
                return android.graphics.drawable.GradientDrawable.Orientation.TR_BL;
            case 2:
                return android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return android.graphics.drawable.GradientDrawable.Orientation.BR_TL;
            case 4:
                return android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return android.graphics.drawable.GradientDrawable.Orientation.BL_TR;
            case 6:
                return android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return android.graphics.drawable.GradientDrawable.Orientation.TL_BR;
            default:
                return android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    /* renamed from: a */
    private static void m37722a(GradientDrawable gradientDrawable, Integer num, Float f, Integer num2, Float f2) {
        try {
            Field declaredField = gradientDrawable.getClass().getDeclaredField("mGradientState");
            declaredField.setAccessible(true);
            Class cls = declaredField.get(gradientDrawable).getClass();
            Field declaredField2 = cls.getDeclaredField("mUseLevelForShape");
            declaredField2.setAccessible(true);
            declaredField2.setBoolean(declaredField.get(gradientDrawable), false);
            if (num != null) {
                Field declaredField3 = cls.getDeclaredField("mThickness");
                declaredField3.setAccessible(true);
                declaredField3.setInt(declaredField.get(gradientDrawable), m37719a((float) num.intValue()));
            }
            if (f != null) {
                Field declaredField4 = cls.getDeclaredField("mThicknessRatio");
                declaredField4.setAccessible(true);
                declaredField4.setFloat(declaredField.get(gradientDrawable), (float) m37719a(f.floatValue()));
            }
            if (num2 != null) {
                Field declaredField5 = cls.getDeclaredField("mInnerRadius");
                declaredField5.setAccessible(true);
                declaredField5.setInt(declaredField.get(gradientDrawable), m37719a((float) num2.intValue()));
            }
            if (f2 != null) {
                Field declaredField6 = cls.getDeclaredField("mInnerRadiusRatio");
                declaredField6.setAccessible(true);
                declaredField6.setFloat(declaredField.get(gradientDrawable), (float) m37719a(f2.floatValue()));
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static int m37719a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
