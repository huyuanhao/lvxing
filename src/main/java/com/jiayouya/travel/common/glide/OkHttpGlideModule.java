package com.jiayouya.travel.common.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.elvishew.xlog.XLog;
import com.jiayouya.travel.common.glide.HttpsUtil.C2902a;
import com.jiayouya.travel.common.glide.HttpsUtil.C2903b;
import com.jiayouya.travel.common.glide.OkHttpUrlLoader.C2905a;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C8513x.C8515a;

public class OkHttpGlideModule extends AppGlideModule {
    /* renamed from: a */
    public void mo12390a(Context context, GlideBuilder fVar) {
    }

    /* renamed from: a */
    public void mo12389a(Context context, Glide eVar, Registry registry) {
        XLog.m12692b("glide registerComponents");
        try {
            registry.mo12355b(GlideUrl.class, InputStream.class, (ModelLoaderFactory<? extends Model, ? extends Data>) new C2905a<Object,Object>(new C8515a().mo40635b(true).mo40622a(15, TimeUnit.SECONDS).mo40633b(60000, TimeUnit.MILLISECONDS).mo40625a((SSLSocketFactory) Objects.requireNonNull(HttpsUtil.m13079a()), (X509TrustManager) new C2903b()).mo40624a((HostnameVerifier) new C2902a()).mo40632a()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
