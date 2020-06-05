package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.C1261a;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.p066a.ObjectDeserializer;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.serializer.i */
public class AwtCodec implements ObjectDeserializer, ObjectSerializer {
    /* renamed from: a */
    public static final AwtCodec f2936a = new AwtCodec();

    /* renamed from: g_ */
    public int mo11162g_() {
        return 12;
    }

    /* renamed from: a */
    public static boolean m3106a(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11396b();
            return;
        }
        String str = "y";
        String str2 = "x";
        if (obj instanceof Point) {
            Point point = (Point) obj;
            baVar.mo11375a(mo11417a(baVar, Point.class, '{'), str2, point.x);
            baVar.mo11375a(',', str, point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            baVar.mo11377a(mo11417a(baVar, Font.class, '{'), ArgKey.KEY_NAME, font.getName());
            baVar.mo11375a(',', "style", font.getStyle());
            baVar.mo11375a(',', AppEntity.KEY_SIZE_LONG, font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            baVar.mo11375a(mo11417a(baVar, Rectangle.class, '{'), str2, rectangle.x);
            baVar.mo11375a(',', str, rectangle.y);
            baVar.mo11375a(',', "width", rectangle.width);
            baVar.mo11375a(',', "height", rectangle.height);
        } else if (obj instanceof Color) {
            Color color = (Color) obj;
            baVar.mo11375a(mo11417a(baVar, Color.class, '{'), "r", color.getRed());
            baVar.mo11375a(',', "g", color.getGreen());
            baVar.mo11375a(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                baVar.mo11375a(',', "alpha", color.getAlpha());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("not support awt class : ");
            sb.append(obj.getClass().getName());
            throw new JSONException(sb.toString());
        }
        baVar.write(125);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public char mo11417a(SerializeWriter baVar, Class<?> cls, char c) {
        if (!baVar.mo11391a(SerializerFeature.WriteClassName)) {
            return c;
        }
        baVar.write(123);
        baVar.mo11404c(JSON.DEFAULT_TYPE_KEY);
        baVar.mo11384a(cls.getName());
        return ',';
    }

    /* renamed from: a */
    public <T> T mo11161a(DefaultJSONParser aVar, Type type, Object obj) {
        T t;
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 8) {
            bVar.mo11211a(16);
            return null;
        } else if (bVar.mo11205a() == 12 || bVar.mo11205a() == 16) {
            bVar.mo11222d();
            if (type == Point.class) {
                t = mo11419a(aVar, obj);
            } else if (type == Rectangle.class) {
                t = mo11421c(aVar);
            } else if (type == Color.class) {
                t = mo11420b(aVar);
            } else if (type == Font.class) {
                t = mo11418a(aVar);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not support awt class : ");
                sb.append(type);
                throw new JSONException(sb.toString());
            }
            ParseContext g = aVar.mo11149g();
            aVar.mo11114a((Object) t, obj);
            aVar.mo11125a(g);
            return t;
        } else {
            throw new JSONException("syntax error");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Font mo11418a(DefaultJSONParser aVar) {
        JSONLexer bVar = aVar.f2689d;
        int i = 0;
        String str = null;
        int i2 = 0;
        while (bVar.mo11205a() != 13) {
            String str2 = "syntax error";
            if (bVar.mo11205a() == 4) {
                String l = bVar.mo11233l();
                bVar.mo11219c(2);
                if (l.equalsIgnoreCase(ArgKey.KEY_NAME)) {
                    if (bVar.mo11205a() == 4) {
                        str = bVar.mo11233l();
                        bVar.mo11222d();
                    } else {
                        throw new JSONException(str2);
                    }
                } else if (l.equalsIgnoreCase("style")) {
                    if (bVar.mo11205a() == 2) {
                        i = bVar.mo11235n();
                        bVar.mo11222d();
                    } else {
                        throw new JSONException(str2);
                    }
                } else if (!l.equalsIgnoreCase(AppEntity.KEY_SIZE_LONG)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("syntax error, ");
                    sb.append(l);
                    throw new JSONException(sb.toString());
                } else if (bVar.mo11205a() == 2) {
                    i2 = bVar.mo11235n();
                    bVar.mo11222d();
                } else {
                    throw new JSONException(str2);
                }
                if (bVar.mo11205a() == 16) {
                    bVar.mo11211a(4);
                }
            } else {
                throw new JSONException(str2);
            }
        }
        bVar.mo11222d();
        return new Font(str, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Color mo11420b(DefaultJSONParser aVar) {
        JSONLexer bVar = aVar.f2689d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (bVar.mo11205a() != 13) {
            String str = "syntax error";
            if (bVar.mo11205a() == 4) {
                String l = bVar.mo11233l();
                bVar.mo11219c(2);
                if (bVar.mo11205a() == 2) {
                    int n = bVar.mo11235n();
                    bVar.mo11222d();
                    if (l.equalsIgnoreCase("r")) {
                        i = n;
                    } else if (l.equalsIgnoreCase("g")) {
                        i2 = n;
                    } else if (l.equalsIgnoreCase("b")) {
                        i3 = n;
                    } else if (l.equalsIgnoreCase("alpha")) {
                        i4 = n;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("syntax error, ");
                        sb.append(l);
                        throw new JSONException(sb.toString());
                    }
                    if (bVar.mo11205a() == 16) {
                        bVar.mo11211a(4);
                    }
                } else {
                    throw new JSONException(str);
                }
            } else {
                throw new JSONException(str);
            }
        }
        bVar.mo11222d();
        return new Color(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Rectangle mo11421c(DefaultJSONParser aVar) {
        int i;
        JSONLexer bVar = aVar.f2689d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (bVar.mo11205a() != 13) {
            String str = "syntax error";
            if (bVar.mo11205a() == 4) {
                String l = bVar.mo11233l();
                bVar.mo11219c(2);
                int a = bVar.mo11205a();
                if (a == 2) {
                    i = bVar.mo11235n();
                    bVar.mo11222d();
                } else if (a == 3) {
                    i = (int) bVar.mo11242u();
                    bVar.mo11222d();
                } else {
                    throw new JSONException(str);
                }
                if (l.equalsIgnoreCase("x")) {
                    i2 = i;
                } else if (l.equalsIgnoreCase("y")) {
                    i3 = i;
                } else if (l.equalsIgnoreCase("width")) {
                    i4 = i;
                } else if (l.equalsIgnoreCase("height")) {
                    i5 = i;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("syntax error, ");
                    sb.append(l);
                    throw new JSONException(sb.toString());
                }
                if (bVar.mo11205a() == 16) {
                    bVar.mo11211a(4);
                }
            } else {
                throw new JSONException(str);
            }
        }
        bVar.mo11222d();
        return new Rectangle(i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Point mo11419a(DefaultJSONParser aVar, Object obj) {
        int i;
        JSONLexer bVar = aVar.f2689d;
        int i2 = 0;
        int i3 = 0;
        while (bVar.mo11205a() != 13) {
            if (bVar.mo11205a() == 4) {
                String l = bVar.mo11233l();
                if (JSON.DEFAULT_TYPE_KEY.equals(l)) {
                    aVar.mo11129a("java.awt.Point");
                } else if ("$ref".equals(l)) {
                    return (Point) m3107b(aVar, obj);
                } else {
                    bVar.mo11219c(2);
                    int a = bVar.mo11205a();
                    if (a == 2) {
                        i = bVar.mo11235n();
                        bVar.mo11222d();
                    } else if (a == 3) {
                        i = (int) bVar.mo11242u();
                        bVar.mo11222d();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("syntax error : ");
                        sb.append(bVar.mo11214b());
                        throw new JSONException(sb.toString());
                    }
                    if (l.equalsIgnoreCase("x")) {
                        i2 = i;
                    } else if (l.equalsIgnoreCase("y")) {
                        i3 = i;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("syntax error, ");
                        sb2.append(l);
                        throw new JSONException(sb2.toString());
                    }
                    if (bVar.mo11205a() == 16) {
                        bVar.mo11211a(4);
                    }
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        bVar.mo11222d();
        return new Point(i2, i3);
    }

    /* renamed from: b */
    private Object m3107b(DefaultJSONParser aVar, Object obj) {
        JSONLexer n = aVar.mo11156n();
        n.mo11219c(4);
        String l = n.mo11233l();
        aVar.mo11114a((Object) aVar.mo11149g(), obj);
        aVar.mo11123a(new C1261a(aVar.mo11149g(), l));
        aVar.mo11154l();
        aVar.mo11122a(1);
        n.mo11211a(13);
        aVar.mo11139b(13);
        return null;
    }
}
