package com.jiayouya.travel.common.glide;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8379e;
import okhttp3.C8379e.C8380a;
import okhttp3.C8381f;
import okhttp3.C8518z.C8519a;

/* renamed from: com.jiayouya.travel.common.glide.e */
public class OkHttpStreamFetcher implements DataFetcher<InputStream> {
    /* renamed from: a */
    InputStream f9647a;
    /* renamed from: b */
    C8364ac f9648b;
    /* renamed from: c */
    private final C8380a f9649c;
    /* renamed from: d */
    private final GlideUrl f9650d;
    /* renamed from: e */
    private volatile C8379e f9651e;

    public OkHttpStreamFetcher(C8380a aVar, GlideUrl gVar) {
        this.f9649c = aVar;
        this.f9650d = gVar;
    }

    /* renamed from: a */
    public void mo12626a(Priority priority, final C1623a<? super InputStream> aVar) {
        C8519a a = new C8519a().mo40655a(this.f9650d.mo12958b());
        for (Entry entry : this.f9650d.mo12959c().entrySet()) {
            a.mo40662b((String) entry.getKey(), (String) entry.getValue());
        }
        this.f9651e = this.f9649c.mo40177a(a.mo40663b());
        this.f9651e.mo40174a(new C8381f() {
            /* renamed from: a */
            public void mo20008a(C8379e eVar, IOException iOException) {
                String str = "OkHttpFetcher";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "OkHttp failed to obtain result", iOException);
                }
                aVar.mo12640a((Exception) iOException);
            }

            /* renamed from: a */
            public void mo20009a(C8379e eVar, C8362ab abVar) throws IOException {
                OkHttpStreamFetcher.this.f9648b = abVar.mo40097h();
                if (abVar.mo40093d()) {
                    long b = OkHttpStreamFetcher.this.f9648b.mo40121b();
                    OkHttpStreamFetcher eVar2 = OkHttpStreamFetcher.this;
                    eVar2.f9647a = ContentLengthInputStream.m6117a(eVar2.f9648b.mo40124d(), b);
                    aVar.mo12641a(OkHttpStreamFetcher.this.f9647a);
                    return;
                }
                aVar.mo12640a((Exception) new HttpException(abVar.mo40094e(), abVar.mo40091c()));
            }
        });
    }

    /* renamed from: b */
    public void mo12627b() {
        try {
            if (this.f9647a != null) {
                this.f9647a.close();
            }
        } catch (IOException unused) {
        }
        C8364ac acVar = this.f9648b;
        if (acVar != null) {
            acVar.close();
        }
    }

    /* renamed from: c */
    public void mo12628c() {
        C8379e eVar = this.f9651e;
        if (eVar != null) {
            eVar.mo40175b();
        }
    }

    /* renamed from: a */
    public Class<InputStream> mo12619a() {
        return InputStream.class;
    }

    /* renamed from: d */
    public DataSource mo12629d() {
        return DataSource.REMOTE;
    }
}
