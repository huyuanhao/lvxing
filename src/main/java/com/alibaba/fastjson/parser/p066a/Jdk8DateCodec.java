package com.alibaba.fastjson.parser.p066a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/* renamed from: com.alibaba.fastjson.parser.a.p */
public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectDeserializer, ObjectSerializer, ContextObjectSerializer {
    /* renamed from: a */
    public static final Jdk8DateCodec f2736a = new Jdk8DateCodec();
    /* renamed from: b */
    private static final DateTimeFormatter f2737b;
    /* renamed from: c */
    private static final DateTimeFormatter f2738c = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /* renamed from: d */
    private static final DateTimeFormatter f2739d = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    /* renamed from: e */
    private static final DateTimeFormatter f2740e = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    /* renamed from: f */
    private static final DateTimeFormatter f2741f = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    /* renamed from: g */
    private static final DateTimeFormatter f2742g = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    /* renamed from: h */
    private static final DateTimeFormatter f2743h = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    /* renamed from: i */
    private static final DateTimeFormatter f2744i = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    /* renamed from: j */
    private static final DateTimeFormatter f2745j = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    /* renamed from: k */
    private static final DateTimeFormatter f2746k = DateTimeFormatter.ofPattern("yyyyMMdd");
    /* renamed from: l */
    private static final DateTimeFormatter f2747l = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    /* renamed from: m */
    private static final DateTimeFormatter f2748m = DateTimeFormatter.ofPattern("yyyy年M月d日");
    /* renamed from: n */
    private static final DateTimeFormatter f2749n = DateTimeFormatter.ofPattern("yyyy년M월d일");
    /* renamed from: o */
    private static final DateTimeFormatter f2750o = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    /* renamed from: p */
    private static final DateTimeFormatter f2751p = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /* renamed from: q */
    private static final DateTimeFormatter f2752q = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    /* renamed from: r */
    private static final DateTimeFormatter f2753r = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /* renamed from: s */
    private static final DateTimeFormatter f2754s;
    /* renamed from: t */
    private static final DateTimeFormatter f2755t = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /* renamed from: g_ */
    public int mo11162g_() {
        return 4;
    }

    static {
        String str = "yyyy-MM-dd HH:mm:ss";
        f2737b = DateTimeFormatter.ofPattern(str);
        f2754s = DateTimeFormatter.ofPattern(str).withZone(ZoneId.systemDefault());
    }

    /* renamed from: a */
    public <T> T mo11164a(DefaultJSONParser aVar, Type type, Object obj, String str, int i) {
        T t;
        T t2;
        T t3;
        JSONLexer bVar = aVar.f2689d;
        if (bVar.mo11205a() == 8) {
            bVar.mo11222d();
            return null;
        } else if (bVar.mo11205a() == 4) {
            String l = bVar.mo11233l();
            bVar.mo11222d();
            DateTimeFormatter dateTimeFormatter = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f2737b : DateTimeFormatter.ofPattern(str) : null;
            if ("".equals(l)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                if (l.length() == 10 || l.length() == 8) {
                    t3 = LocalDateTime.of(mo11195a(l, str, dateTimeFormatter), LocalTime.MIN);
                } else {
                    t3 = mo11196a(l, dateTimeFormatter);
                }
                return t3;
            } else if (type == LocalDate.class) {
                if (l.length() == 23) {
                    LocalDateTime parse = LocalDateTime.parse(l);
                    t2 = LocalDate.of(parse.getYear(), parse.getMonthValue(), parse.getDayOfMonth());
                } else {
                    t2 = mo11195a(l, str, dateTimeFormatter);
                }
                return t2;
            } else if (type == LocalTime.class) {
                if (l.length() == 23) {
                    LocalDateTime parse2 = LocalDateTime.parse(l);
                    t = LocalTime.of(parse2.getHour(), parse2.getMinute(), parse2.getSecond(), parse2.getNano());
                } else {
                    t = LocalTime.parse(l);
                }
                return t;
            } else if (type == ZonedDateTime.class) {
                if (dateTimeFormatter == f2737b) {
                    dateTimeFormatter = f2754s;
                }
                return mo11199b(l, dateTimeFormatter);
            } else if (type == OffsetDateTime.class) {
                return OffsetDateTime.parse(l);
            } else {
                if (type == OffsetTime.class) {
                    return OffsetTime.parse(l);
                }
                if (type == ZoneId.class) {
                    return ZoneId.of(l);
                }
                if (type == Period.class) {
                    return Period.parse(l);
                }
                if (type == Duration.class) {
                    return Duration.parse(l);
                }
                if (type == Instant.class) {
                    return Instant.parse(l);
                }
                return null;
            }
        } else if (bVar.mo11205a() == 2) {
            long q = bVar.mo11238q();
            bVar.mo11222d();
            if (type == LocalDateTime.class) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(q), ZoneId.systemDefault());
            }
            throw new UnsupportedOperationException();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LocalDateTime mo11196a(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = f2737b;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = f2737b;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = f2738c;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = f2743h;
                            } else if (i > 12) {
                                dateTimeFormatter = f2742g;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f2742g;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f2743h;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = f2744i;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = f2745j;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = f2740e;
                    } else {
                        dateTimeFormatter = f2739d;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = f2741f;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDateTime.parse(str);
        }
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LocalDate mo11195a(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f2746k;
            }
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = f2747l;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter = f2751p;
                    } else if (i > 12) {
                        dateTimeFormatter = f2750o;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter = f2750o;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter = f2751p;
                        }
                    }
                } else {
                    if (charAt5 == '.' && charAt7 == '.') {
                        dateTimeFormatter2 = f2752q;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        dateTimeFormatter2 = f2753r;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter = f2748m;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter = f2749n;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ZonedDateTime mo11199b(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = f2737b;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = f2737b;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = f2738c;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = f2743h;
                            } else if (i > 12) {
                                dateTimeFormatter = f2742g;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f2742g;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f2743h;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = f2744i;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = f2745j;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = f2740e;
                    } else {
                        dateTimeFormatter = f2739d;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = f2741f;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return ZonedDateTime.parse(str);
        }
        return ZonedDateTime.parse(str, dateTimeFormatter);
    }

    /* renamed from: a */
    public void mo11198a(JSONSerializer agVar, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter baVar = agVar.f2846b;
        if (obj == null) {
            baVar.mo11396b();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            int mask = SerializerFeature.UseISO8601DateFormat.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String a = agVar.mo11310a();
            if ((a == null && (mask & i) != 0) || agVar.mo11318a(SerializerFeature.UseISO8601DateFormat)) {
                a = "yyyy-MM-dd'T'HH:mm:ss";
            }
            if (localDateTime.getNano() == 0 || a != null) {
                if (a == null) {
                    a = JSON.DEFFAULT_DATE_FORMAT;
                }
                m2701a(baVar, (TemporalAccessor) localDateTime, a);
                return;
            }
            baVar.mo11384a(obj.toString());
            return;
        }
        baVar.mo11384a(obj.toString());
    }

    /* renamed from: a */
    public void mo11197a(JSONSerializer agVar, Object obj, BeanContext jVar) throws IOException {
        m2701a(agVar.f2846b, (TemporalAccessor) obj, jVar.mo11424c());
    }

    /* renamed from: a */
    private void m2701a(SerializeWriter baVar, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatter;
        if (str == "yyyy-MM-dd'T'HH:mm:ss") {
            dateTimeFormatter = f2755t;
        } else {
            dateTimeFormatter = DateTimeFormatter.ofPattern(str);
        }
        baVar.mo11384a(dateTimeFormatter.format(temporalAccessor));
    }
}
