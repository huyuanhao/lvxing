package com.p530ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpService;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHttpService;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.downloader.g */
public class DownloaderBuilder {
    /* renamed from: a */
    private final Context f21920a;
    /* renamed from: b */
    private IDownloadCache f21921b;
    /* renamed from: c */
    private IDownloadIdGenerator f21922c;
    /* renamed from: d */
    private int f21923d;
    /* renamed from: e */
    private IChunkCntCalculator f21924e;
    /* renamed from: f */
    private INotificationClickCallback f21925f;
    /* renamed from: g */
    private IDownloadHttpService f21926g;
    /* renamed from: h */
    private IDownloadHeadHttpService f21927h;
    /* renamed from: i */
    private IDownloadLaunchHandler f21928i;
    /* renamed from: j */
    private ExecutorService f21929j;
    /* renamed from: k */
    private ExecutorService f21930k;
    /* renamed from: l */
    private ExecutorService f21931l;
    /* renamed from: m */
    private ExecutorService f21932m;
    /* renamed from: n */
    private int f21933n;
    /* renamed from: o */
    private IChunkAdjustCalculator f21934o;
    /* renamed from: p */
    private boolean f21935p;
    /* renamed from: q */
    private IMonitorConfig f21936q;
    /* renamed from: r */
    private int f21937r = 1023409663;
    /* renamed from: s */
    private JSONObject f21938s;

    public DownloaderBuilder(Context context) {
        this.f21920a = context;
    }

    /* renamed from: a */
    public DownloaderBuilder mo31936a(IDownloadHttpService fVar) {
        this.f21926g = fVar;
        return this;
    }

    /* renamed from: a */
    public DownloaderBuilder mo31935a(int i) {
        this.f21937r = i;
        return this;
    }

    /* renamed from: a */
    public DownloaderBuilder mo31937a(JSONObject jSONObject) {
        this.f21938s = jSONObject;
        return this;
    }

    /* renamed from: a */
    public Context mo31934a() {
        return this.f21920a;
    }

    /* renamed from: b */
    public IDownloadCache mo31938b() {
        return this.f21921b;
    }

    /* renamed from: c */
    public IDownloadIdGenerator mo31939c() {
        return this.f21922c;
    }

    /* renamed from: d */
    public IDownloadHttpService mo31940d() {
        return this.f21926g;
    }

    /* renamed from: e */
    public IDownloadHeadHttpService mo31941e() {
        return this.f21927h;
    }

    /* renamed from: f */
    public IDownloadLaunchHandler mo31942f() {
        return this.f21928i;
    }

    /* renamed from: g */
    public ExecutorService mo31943g() {
        return this.f21929j;
    }

    /* renamed from: h */
    public ExecutorService mo31944h() {
        return this.f21930k;
    }

    /* renamed from: i */
    public ExecutorService mo31945i() {
        return this.f21931l;
    }

    /* renamed from: j */
    public ExecutorService mo31946j() {
        return this.f21932m;
    }

    /* renamed from: k */
    public int mo31947k() {
        return this.f21923d;
    }

    /* renamed from: l */
    public IChunkCntCalculator mo31948l() {
        return this.f21924e;
    }

    /* renamed from: m */
    public IChunkAdjustCalculator mo31949m() {
        return this.f21934o;
    }

    /* renamed from: n */
    public int mo31950n() {
        return this.f21933n;
    }

    /* renamed from: o */
    public boolean mo31951o() {
        return this.f21935p;
    }

    /* renamed from: p */
    public IMonitorConfig mo31952p() {
        return this.f21936q;
    }

    /* renamed from: q */
    public int mo31953q() {
        return this.f21937r;
    }

    /* renamed from: r */
    public INotificationClickCallback mo31954r() {
        return this.f21925f;
    }

    /* renamed from: s */
    public JSONObject mo31955s() {
        return this.f21938s;
    }

    /* renamed from: t */
    public Downloader mo31956t() {
        return new Downloader(this);
    }
}
