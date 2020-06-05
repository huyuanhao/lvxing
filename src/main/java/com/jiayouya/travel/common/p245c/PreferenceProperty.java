package com.jiayouya.travel.common.p245c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.jiayouya.travel.C2835b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.C8182c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.C8272k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.p679a.C8246a;
import kotlin.reflect.C8280j;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0005J\u001b\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0001\u0010\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u001bJ$\u0010\u001c\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0002¢\u0006\u0002\u0010 J!\u0010\u001c\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0001¢\u0006\u0002\u0010!J#\u0010\"\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u0002H\u0001H\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010$\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00172\u0006\u0010%\u001a\u0002H\u0017H\u0002¢\u0006\u0002\u0010&J,\u0010'\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010(R\u0010\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, mo39189d2 = {"Lcom/jiayouya/travel/common/preference/PreferenceProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "", "name", "", "default", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "clearPreference", "", "key", "contains", "", "deSerialization", "A", "str", "(Ljava/lang/String;)Ljava/lang/Object;", "getAll", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putValue", "value", "serialize", "obj", "(Ljava/lang/Object;)Ljava/lang/String;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.c.a */
public final class PreferenceProperty<T> {
    /* renamed from: a */
    static final /* synthetic */ C8280j[] f9600a = {C8272k.m35400a((PropertyReference1) new PropertyReference1Impl(C8272k.m35394a(PreferenceProperty.class), "prefs", "getPrefs()Landroid/content/SharedPreferences;"))};
    /* renamed from: b */
    private final Lazy f9601b = C8182c.m35317a(C2879a.INSTANCE);
    /* renamed from: c */
    private final String f9602c;
    /* renamed from: d */
    private final T f9603d;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "T", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: PreferenceProperty.kt */
    /* renamed from: com.jiayouya.travel.common.c.a$a */
    static final class C2879a extends Lambda implements C8246a<SharedPreferences> {
        public static final C2879a INSTANCE = new C2879a();

        C2879a() {
            super(0);
        }

        public final SharedPreferences invoke() {
            return PreferenceManager.getDefaultSharedPreferences(C2835b.f9544a);
        }
    }

    /* renamed from: a */
    private final SharedPreferences m12913a() {
        Lazy bVar = this.f9601b;
        C8280j jVar = f9600a[0];
        return (SharedPreferences) bVar.getValue();
    }

    public PreferenceProperty(String str, T t) {
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        this.f9602c = str;
        this.f9603d = t;
    }

    /* renamed from: a */
    public T mo19917a(Object obj, C8280j<?> jVar) {
        C8271i.m35386b(jVar, "property");
        return mo19918a(this.f9602c, this.f9603d);
    }

    /* renamed from: a */
    public void mo19919a(Object obj, C8280j<?> jVar, T t) {
        C8271i.m35386b(jVar, "property");
        m12916b(this.f9602c, t);
    }

    /* renamed from: b */
    private final <T> void m12916b(String str, T t) {
        Editor editor;
        Editor edit = m12913a().edit();
        if (t instanceof Long) {
            editor = edit.putLong(str, ((Number) t).longValue());
        } else if (t instanceof String) {
            editor = edit.putString(str, (String) t);
        } else if (t instanceof Integer) {
            editor = edit.putInt(str, ((Number) t).intValue());
        } else if (t instanceof Boolean) {
            editor = edit.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor = edit.putFloat(str, ((Number) t).floatValue());
        } else {
            editor = edit.putString(str, m12915a((A) t));
        }
        editor.apply();
    }

    /* renamed from: a */
    public final <T> T mo19918a(String str, T t) {
        T t2;
        C8271i.m35386b(str, ArgKey.KEY_NAME);
        SharedPreferences a = m12913a();
        if (t instanceof Long) {
            t2 = Long.valueOf(a.getLong(str, ((Number) t).longValue()));
        } else if (t instanceof String) {
            t2 = a.getString(str, (String) t);
        } else if (t instanceof Integer) {
            t2 = Integer.valueOf(a.getInt(str, ((Number) t).intValue()));
        } else if (t instanceof Boolean) {
            t2 = Boolean.valueOf(a.getBoolean(str, ((Boolean) t).booleanValue()));
        } else if (t instanceof Float) {
            t2 = Float.valueOf(a.getFloat(str, ((Number) t).floatValue()));
        } else {
            try {
                String string = a.getString(str, m12915a((A) t));
                if (string == null) {
                    string = "";
                }
                t = m12914a(string);
            } catch (Exception e) {
                e.printStackTrace();
                if (t == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
                }
            }
            t2 = t;
        }
        C8271i.m35382a((Object) t2, "when (default) {\n       …y\n            }\n        }");
        return t2;
    }

    /* renamed from: a */
    private final <A> String m12915a(A a) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(a);
        String encode = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        C8271i.m35382a((Object) encode, "serStr");
        return encode;
    }

    /* renamed from: a */
    private final <A> A m12914a(String str) throws IOException, ClassNotFoundException {
        String decode = URLDecoder.decode(str, "UTF-8");
        C8271i.m35382a((Object) decode, "redStr");
        Charset forName = Charset.forName("ISO-8859-1");
        C8271i.m35382a((Object) forName, "Charset.forName(charsetName)");
        if (decode != null) {
            byte[] bytes = decode.getBytes(forName);
            C8271i.m35382a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            A readObject = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return readObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
