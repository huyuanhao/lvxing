package com.p530ss.android.socialbase.downloader.p569m;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;

/* renamed from: com.ss.android.socialbase.downloader.m.a */
public final class AppUtils {

    /* compiled from: AppUtils */
    /* renamed from: com.ss.android.socialbase.downloader.m.a$a */
    public static class C6750a {
        /* renamed from: a */
        private String f22359a;
        /* renamed from: b */
        private String f22360b;
        /* renamed from: c */
        private Drawable f22361c;
        /* renamed from: d */
        private String f22362d;
        /* renamed from: e */
        private String f22363e;
        /* renamed from: f */
        private int f22364f;
        /* renamed from: g */
        private boolean f22365g;

        /* renamed from: a */
        public Drawable mo32589a() {
            return this.f22361c;
        }

        /* renamed from: a */
        public void mo32591a(Drawable drawable) {
            this.f22361c = drawable;
        }

        /* renamed from: b */
        public boolean mo32595b() {
            return this.f22365g;
        }

        /* renamed from: a */
        public void mo32593a(boolean z) {
            this.f22365g = z;
        }

        /* renamed from: c */
        public String mo32596c() {
            return this.f22359a;
        }

        /* renamed from: a */
        public void mo32592a(String str) {
            this.f22359a = str;
        }

        /* renamed from: d */
        public String mo32598d() {
            return this.f22360b;
        }

        /* renamed from: b */
        public void mo32594b(String str) {
            this.f22360b = str;
        }

        /* renamed from: e */
        public String mo32600e() {
            return this.f22362d;
        }

        /* renamed from: c */
        public void mo32597c(String str) {
            this.f22362d = str;
        }

        /* renamed from: f */
        public int mo32601f() {
            return this.f22364f;
        }

        /* renamed from: a */
        public void mo32590a(int i) {
            this.f22364f = i;
        }

        /* renamed from: g */
        public String mo32602g() {
            return this.f22363e;
        }

        /* renamed from: d */
        public void mo32599d(String str) {
            this.f22363e = str;
        }

        public C6750a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            mo32594b(str2);
            mo32591a(drawable);
            mo32592a(str);
            mo32597c(str3);
            mo32599d(str4);
            mo32590a(i);
            mo32593a(z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{\n  pkg name: ");
            sb.append(mo32596c());
            sb.append("\n  app icon: ");
            sb.append(mo32589a());
            sb.append("\n  app name: ");
            sb.append(mo32598d());
            sb.append("\n  app path: ");
            sb.append(mo32600e());
            sb.append("\n  app v name: ");
            sb.append(mo32602g());
            sb.append("\n  app v code: ");
            sb.append(mo32601f());
            sb.append("\n  is system: ");
            sb.append(mo32595b());
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static C6750a m28726a(String str) {
        try {
            PackageManager packageManager = C6694b.m27342B().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return m28725a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static C6750a m28725a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        C6750a aVar = new C6750a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
        return aVar;
    }
}
