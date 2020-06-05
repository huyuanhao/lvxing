package com.p530ss.android.socialbase.downloader.impls;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;

/* renamed from: com.ss.android.socialbase.downloader.impls.RetryJobSchedulerService */
public class RetryJobSchedulerService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public void onCreate() {
        super.onCreate();
        C6694b.m27353a((Context) this);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            StringBuilder sb = new StringBuilder();
            sb.append("onStartJob, id = ");
            sb.append(jobId);
            C6704a.m27760c("RetrySchedulerService", sb.toString());
            RetryScheduler.m28554a().mo32527a(jobId);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[Catch:{ all -> 0x0024, all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057 A[Catch:{ all -> 0x0024, all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069 A[Catch:{ all -> 0x0024, all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A[Catch:{ all -> 0x0024, all -> 0x008d }] */
    /* renamed from: a */
    static void m28227a(com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r9, long r10, boolean r12, int r13) {
        /*
        if (r9 == 0) goto L_0x0091
        r0 = 0
        int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
        if (r2 > 0) goto L_0x000a
        goto L_0x0091
    L_0x000a:
        android.content.Context r2 = com.p530ss.android.socialbase.downloader.downloader.C6694b.m27342B()
        if (r2 != 0) goto L_0x0011
        return
    L_0x0011:
        java.lang.String r3 = "jobscheduler"
        java.lang.Object r3 = r2.getSystemService(r3)     // Catch:{ all -> 0x008d }
        android.app.job.JobScheduler r3 = (android.app.job.JobScheduler) r3     // Catch:{ all -> 0x008d }
        if (r3 != 0) goto L_0x001c
        return
    L_0x001c:
        int r4 = r9.mo32283g()     // Catch:{ all -> 0x0024 }
        r3.cancel(r4)     // Catch:{ all -> 0x0024 }
        goto L_0x0028
    L_0x0024:
        r4 = move-exception
        r4.printStackTrace()     // Catch:{ all -> 0x008d }
    L_0x0028:
        r4 = 2
        if (r13 == 0) goto L_0x0035
        if (r12 == 0) goto L_0x0030
        if (r13 == r4) goto L_0x0030
        goto L_0x0035
    L_0x0030:
        r5 = 60000(0xea60, double:2.9644E-319)
        long r5 = r5 + r10
        goto L_0x0038
    L_0x0035:
        r10 = 1000(0x3e8, double:4.94E-321)
        r5 = r0
    L_0x0038:
        android.app.job.JobInfo$Builder r13 = new android.app.job.JobInfo$Builder     // Catch:{ all -> 0x008d }
        int r9 = r9.mo32283g()     // Catch:{ all -> 0x008d }
        android.content.ComponentName r7 = new android.content.ComponentName     // Catch:{ all -> 0x008d }
        java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x008d }
        java.lang.Class<com.ss.android.socialbase.downloader.impls.RetryJobSchedulerService> r8 = com.p530ss.android.socialbase.downloader.impls.RetryJobSchedulerService.class
        java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x008d }
        r7.<init>(r2, r8)     // Catch:{ all -> 0x008d }
        r13.<init>(r9, r7)     // Catch:{ all -> 0x008d }
        android.app.job.JobInfo$Builder r9 = r13.setMinimumLatency(r10)     // Catch:{ all -> 0x008d }
        if (r12 == 0) goto L_0x0057
        goto L_0x0058
    L_0x0057:
        r4 = 1
    L_0x0058:
        android.app.job.JobInfo$Builder r9 = r9.setRequiredNetworkType(r4)     // Catch:{ all -> 0x008d }
        r10 = 0
        android.app.job.JobInfo$Builder r9 = r9.setRequiresCharging(r10)     // Catch:{ all -> 0x008d }
        android.app.job.JobInfo$Builder r9 = r9.setRequiresDeviceIdle(r10)     // Catch:{ all -> 0x008d }
        int r10 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
        if (r10 <= 0) goto L_0x006c
        r9.setOverrideDeadline(r5)     // Catch:{ all -> 0x008d }
    L_0x006c:
        android.app.job.JobInfo r9 = r9.build()     // Catch:{ all -> 0x008d }
        int r9 = r3.schedule(r9)     // Catch:{ all -> 0x008d }
        if (r9 > 0) goto L_0x0091
        java.lang.String r10 = "RetrySchedulerService"
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
        r11.<init>()     // Catch:{ all -> 0x008d }
        java.lang.String r12 = "schedule err errCode = "
        r11.append(r12)     // Catch:{ all -> 0x008d }
        r11.append(r9)     // Catch:{ all -> 0x008d }
        java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x008d }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27761d(r10, r9)     // Catch:{ all -> 0x008d }
        goto L_0x0091
    L_0x008d:
        r9 = move-exception
        r9.printStackTrace()
    L_0x0091:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.impls.RetryJobSchedulerService.m28227a(com.ss.android.socialbase.downloader.g.c, long, boolean, int):void");
    }
}
