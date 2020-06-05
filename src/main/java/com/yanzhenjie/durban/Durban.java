package com.yanzhenjie.durban;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Durban {
    /* renamed from: a */
    private static DurbanConfig f26425a;
    /* renamed from: b */
    private Object f26426b;
    /* renamed from: c */
    private Intent f26427c;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.durban.Durban$FormatTypes */
    public @interface FormatTypes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.durban.Durban$GestureTypes */
    public @interface GestureTypes {
    }

    /* renamed from: a */
    public static void m33765a(DurbanConfig aVar) {
        f26425a = aVar;
    }

    /* renamed from: a */
    public static DurbanConfig m33763a() {
        if (f26425a == null) {
            m33765a(DurbanConfig.m33796a(null).mo37808a(Locale.getDefault()).mo37809a());
        }
        return f26425a;
    }

    /* renamed from: a */
    public static Durban m33762a(Activity activity) {
        return new Durban(activity);
    }

    private Durban(Object obj) {
        this.f26426b = obj;
        this.f26427c = new Intent(m33761a(obj), DurbanActivity.class);
    }

    /* renamed from: a */
    public Durban mo37790a(int i) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_GESTURE", i);
        return this;
    }

    /* renamed from: a */
    public Durban mo37789a(float f, float f2) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_ASPECT_RATIO", new float[]{f, f2});
        return this;
    }

    /* renamed from: a */
    public Durban mo37791a(int i, int i2) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_MAX_WIDTH_HEIGHT", new int[]{i, i2});
        return this;
    }

    /* renamed from: b */
    public Durban mo37794b(int i) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_COMPRESS_FORMAT", i);
        return this;
    }

    /* renamed from: c */
    public Durban mo37796c(int i) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_COMPRESS_QUALITY", i);
        return this;
    }

    /* renamed from: a */
    public Durban mo37792a(String str) {
        this.f26427c.putExtra("AlbumCrop.KEY_INPUT_DIRECTORY", str);
        return this;
    }

    /* renamed from: a */
    public Durban mo37793a(String... strArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        this.f26427c.putStringArrayListExtra("AlbumCrop.KEY_INPUT_PATH_ARRAY", arrayList);
        return this;
    }

    /* renamed from: d */
    public Durban mo37797d(int i) {
        this.f26427c.putExtra("requestCode", i);
        return this;
    }

    /* renamed from: b */
    public void mo37795b() {
        try {
            Method method = this.f26426b.getClass().getMethod("startActivityForResult", new Class[]{Intent.class, Integer.TYPE});
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(this.f26426b, new Object[]{this.f26427c, Integer.valueOf(this.f26427c.getIntExtra("requestCode", 1))});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static ArrayList<String> m33764a(Intent intent) {
        return intent.getStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST");
    }

    /* renamed from: a */
    protected static Context m33761a(Object obj) {
        if (obj instanceof Activity) {
            return (Context) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getContext();
        }
        if (obj instanceof android.app.Fragment) {
            ((android.app.Fragment) obj).getActivity();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass());
        sb.append(" is not supported.");
        throw new IllegalArgumentException(sb.toString());
    }
}
