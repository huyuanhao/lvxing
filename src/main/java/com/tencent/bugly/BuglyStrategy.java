package com.tencent.bugly;

import com.tencent.bugly.crashreport.common.info.C7174a;
import java.util.Map;

/* compiled from: BUGLY */
public class BuglyStrategy {
    /* renamed from: a */
    private String f23642a;
    /* renamed from: b */
    private String f23643b;
    /* renamed from: c */
    private String f23644c;
    /* renamed from: d */
    private long f23645d;
    /* renamed from: e */
    private String f23646e;
    /* renamed from: f */
    private String f23647f;
    /* renamed from: g */
    private boolean f23648g = true;
    /* renamed from: h */
    private boolean f23649h = true;
    /* renamed from: i */
    private boolean f23650i = true;
    /* renamed from: j */
    private Class<?> f23651j = null;
    /* renamed from: k */
    private boolean f23652k = true;
    /* renamed from: l */
    private boolean f23653l = true;
    /* renamed from: m */
    private boolean f23654m = true;
    /* renamed from: n */
    private boolean f23655n = false;
    /* renamed from: o */
    private C7120a f23656o;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.BuglyStrategy$a */
    public static class C7120a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.f23652k = z;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.f23655n = z;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.f23654m = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.f23654m;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f23652k;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f23655n;
    }

    public boolean isReplaceOldChannel() {
        return this.f23653l;
    }

    public void setReplaceOldChannel(boolean z) {
        this.f23653l = z;
    }

    public synchronized String getAppVersion() {
        return this.f23642a == null ? C7174a.m30754b().f24035p : this.f23642a;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f23642a = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f23651j = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f23651j;
    }

    public synchronized String getAppChannel() {
        return this.f23643b == null ? C7174a.m30754b().f24037r : this.f23643b;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f23643b = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        return this.f23644c == null ? C7174a.m30754b().f24023d : this.f23644c;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f23644c = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f23645d;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f23645d = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f23646e;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f23646e = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.f23647f;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f23647f = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f23648g;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.f23648g = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.f23650i = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f23650i;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f23649h;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.f23649h = z;
        return this;
    }

    public synchronized C7120a getCrashHandleCallback() {
        return this.f23656o;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(C7120a aVar) {
        this.f23656o = aVar;
        return this;
    }
}
